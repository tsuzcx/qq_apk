import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class admj
  implements View.OnTouchListener
{
  final acmv jdField_a_of_type_Acmv;
  GestureDetector jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(new admk(this));
  View jdField_a_of_type_AndroidViewView = null;
  
  public admj(admh paramadmh, acmv paramacmv)
  {
    this.jdField_a_of_type_Acmv = paramacmv;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_Acmv != null) {
      this.jdField_a_of_type_Acmv.onTouch(paramView, paramMotionEvent);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     admj
 * JD-Core Version:    0.7.0.1
 */