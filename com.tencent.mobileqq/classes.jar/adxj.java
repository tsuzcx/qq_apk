import android.support.v4.app.FragmentActivity;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.mobileqq.activity.ChatActivityUtils;

class adxj
  extends GestureDetector.SimpleOnGestureListener
{
  adxj(adxi paramadxi) {}
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    if (this.a.jdField_a_of_type_Adxg.a()) {
      return false;
    }
    actn.n = true;
    ChatActivityUtils.a(this.a.jdField_a_of_type_Adxg.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidViewView, (FragmentActivity)this.a.jdField_a_of_type_Adxg.jdField_a_of_type_AndroidContentContext);
    return true;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    if (this.a.jdField_a_of_type_Acxn != null) {
      this.a.jdField_a_of_type_Acxn.onLongClick(this.a.jdField_a_of_type_AndroidViewView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adxj
 * JD-Core Version:    0.7.0.1
 */