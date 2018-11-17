package com.company;
import java.awt.*;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.event.MouseInputAdapter;

public class MainFrame {


    public static class testFrame extends JFrame{
        testFrame(){
            JFrame guiGrab = new JFrame("HW3");
            guiGrab.setSize(1500, 600);
            guiGrab.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            guiGrab.add(new testImg());
            guiGrab.setVisible(true);



        }
}

    public static class testImg extends JPanel{
        public testImg()
        {
            ImageIcon imageIcon = new ImageIcon("pic.jpg");
            imageIcon.setImage(imageIcon.getImage().getScaledInstance(537, 400,100));
            JLabel label = new JLabel(imageIcon);
            add(label);

//            JPanel panel = new JPanel();
//            panel.setBounds(100,100,1000,1000);
//            panel.add(label);

            DragPicListener listener = new DragPicListener();
            this.addMouseListener(listener);
            this.addMouseMotionListener(listener);
        }
    }

    public static class DragPicListener extends MouseInputAdapter {
        //座標
        Point point = new Point(0, 0);

        //拖拉事件時 記錄位置
        public void mouseDragged(MouseEvent e) {
            Component aa = (Component) e.getSource();
            // 轉換坐標系統
            Point newPoint = SwingUtilities.convertPoint(aa, e
                    .getPoint(), aa.getParent());
            // 設定新位置
            aa.setLocation(aa.getX()
                    + (newPoint.x - point.x), aa.getY()
                    + (newPoint.y - point.y));
            // 更改座標
            point = newPoint;
        }

        //滑鼠按下事件發生時 當下的位置
        public void mousePressed(MouseEvent e) {
            // 得到當前座標
            Component aa = (Component) e.getSource();
            point = SwingUtilities.convertPoint(aa, e.getPoint(),
                    aa.getParent());
        }


    }


    public static void main(String[] args) {
        testFrame a = new testFrame();
        testImg b = new testImg();
        a.add(b);


    }



}


