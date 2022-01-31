import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.qphone.base.util.QLog;

public class aaoa
  extends GestureDetector.SimpleOnGestureListener
{
  public aaoa(BaseChatPie paramBaseChatPie) {}
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    this.a.a(paramMotionEvent);
    return super.onDoubleTap(paramMotionEvent);
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    return super.onDown(paramMotionEvent);
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    super.onLongPress(paramMotionEvent);
    ((adis)this.a.a(26)).a();
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if ((BaseChatPie.i() == 1) && (!BaseChatPie.a(this.a).booleanValue())) {
      if (this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getCount() != 0) {}
    }
    do
    {
      return false;
      if ((this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null) && (this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getLastVisiblePosition() >= this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getCount() - 1))
      {
        paramMotionEvent1 = new int[2];
        this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildCount() - 1).getLocationOnScreen(paramMotionEvent1);
        int i = paramMotionEvent1[1];
        if (BaseChatPie.g(this.a) == i)
        {
          this.a.w(1);
          BaseChatPie.a(this.a, Boolean.valueOf(true));
          BaseChatPie.e(this.a, -1);
        }
        BaseChatPie.e(this.a, i);
      }
      if (BaseChatPie.a(this.a)) {
        this.a.i(true);
      }
    } while (paramFloat2 >= 0.0F);
    this.a.H = false;
    return false;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "onShowPress");
    }
    this.a.j(false);
    this.a.i(true);
    super.onShowPress(paramMotionEvent);
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    paramMotionEvent = (amcp)this.a.a(50);
    if (paramMotionEvent != null) {
      paramMotionEvent.a(true);
    }
    this.a.j(false);
    this.a.i(true);
    if (paramMotionEvent != null) {
      paramMotionEvent.a(false);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aaoa
 * JD-Core Version:    0.7.0.1
 */