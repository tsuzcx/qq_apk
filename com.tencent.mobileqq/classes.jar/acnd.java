import android.view.GestureDetector;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.StickerGestureDetector;

public class acnd
  implements Runnable
{
  public acnd(EmoticonMainPanel paramEmoticonMainPanel, TopGestureLayout paramTopGestureLayout, GestureDetector paramGestureDetector) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.removeView(((StickerGestureDetector)this.jdField_a_of_type_AndroidViewGestureDetector).a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acnd
 * JD-Core Version:    0.7.0.1
 */