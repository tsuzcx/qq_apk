import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class aheb
  implements View.OnTouchListener
{
  final aftk jdField_a_of_type_Aftk;
  GestureDetector jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(new ahec(this));
  View jdField_a_of_type_AndroidViewView = null;
  
  public aheb(ahdz paramahdz, aftk paramaftk)
  {
    this.jdField_a_of_type_Aftk = paramaftk;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_Aftk != null) {
      this.jdField_a_of_type_Aftk.onTouch(paramView, paramMotionEvent);
    }
    if (this.jdField_a_of_type_AndroidViewGestureDetector != null)
    {
      this.jdField_a_of_type_AndroidViewView = paramView;
      this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
      return true;
    }
    this.jdField_a_of_type_AndroidViewView = null;
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aheb
 * JD-Core Version:    0.7.0.1
 */