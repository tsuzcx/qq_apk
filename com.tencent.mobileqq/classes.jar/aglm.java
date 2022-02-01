import android.support.v4.app.FragmentActivity;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.mobileqq.activity.ChatActivityUtils;

class aglm
  extends GestureDetector.SimpleOnGestureListener
{
  aglm(agll paramagll) {}
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    if (this.a.jdField_a_of_type_Aglj.a()) {
      return false;
    }
    com.tencent.mobileqq.activity.aio.AIOUtils.isUserOperatedInAIO = true;
    ChatActivityUtils.a(this.a.jdField_a_of_type_Aglj.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidViewView, (FragmentActivity)this.a.jdField_a_of_type_Aglj.jdField_a_of_type_AndroidContentContext);
    return true;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    if (this.a.jdField_a_of_type_Afce != null) {
      this.a.jdField_a_of_type_Afce.onLongClick(this.a.jdField_a_of_type_AndroidViewView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aglm
 * JD-Core Version:    0.7.0.1
 */