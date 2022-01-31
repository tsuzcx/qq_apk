import android.support.v4.app.FragmentActivity;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.mobileqq.activity.ChatActivityUtils;

class aftu
  extends GestureDetector.SimpleOnGestureListener
{
  aftu(aftt paramaftt) {}
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    if (this.a.jdField_a_of_type_Aftr.a()) {
      return false;
    }
    aekt.n = true;
    ChatActivityUtils.a(this.a.jdField_a_of_type_Aftr.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidViewView, (FragmentActivity)this.a.jdField_a_of_type_Aftr.jdField_a_of_type_AndroidContentContext);
    return true;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    if (this.a.jdField_a_of_type_Aeov != null) {
      this.a.jdField_a_of_type_Aeov.onLongClick(this.a.jdField_a_of_type_AndroidViewView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aftu
 * JD-Core Version:    0.7.0.1
 */