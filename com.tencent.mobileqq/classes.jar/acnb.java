import android.graphics.PointF;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.widget.BubblePopupWindow;

public class acnb
  implements aetk, View.OnClickListener, bhvm
{
  protected PointF a;
  MessageRecord jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  BubblePopupWindow jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
  
  public acnb(ChatHistory paramChatHistory)
  {
    this.jdField_a_of_type_AndroidGraphicsPointF = new PointF();
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = null;
  }
  
  void a(View paramView)
  {
    MotionEvent localMotionEvent = MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 3, 0.0F, 0.0F, 0);
    paramView.dispatchTouchEvent(localMotionEvent);
    localMotionEvent.recycle();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131365071) {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
    }
    this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = null;
  }
  
  public boolean onLongClick(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow != null) && (this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b()))
    {
      a(paramView);
      return false;
    }
    bdpi localbdpi = new bdpi();
    localbdpi.a(2131365071, this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.getString(2131690760), 2130838673);
    if (localbdpi.a() > 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((acnc)ChatHistory.a(paramView)).jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      int i = (int)this.jdField_a_of_type_AndroidGraphicsPointF.y;
      int j = aepi.a(10.0F, paramView.getResources());
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = bdft.a(paramView, (int)this.jdField_a_of_type_AndroidGraphicsPointF.x, i - j, localbdpi, this);
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a(this);
      a(paramView);
      return true;
    }
    a(paramView);
    return false;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      this.jdField_a_of_type_AndroidGraphicsPointF.x = paramMotionEvent.getRawX();
      this.jdField_a_of_type_AndroidGraphicsPointF.y = paramMotionEvent.getRawY();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acnb
 * JD-Core Version:    0.7.0.1
 */