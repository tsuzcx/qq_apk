import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class aftt
  implements View.OnTouchListener
{
  final aeov jdField_a_of_type_Aeov;
  GestureDetector jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(new aftu(this));
  View jdField_a_of_type_AndroidViewView = null;
  
  public aftt(aftr paramaftr, aeov paramaeov)
  {
    this.jdField_a_of_type_Aeov = paramaeov;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_Aeov != null) {
      this.jdField_a_of_type_Aeov.onTouch(paramView, paramMotionEvent);
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
 * Qualified Name:     aftt
 * JD-Core Version:    0.7.0.1
 */