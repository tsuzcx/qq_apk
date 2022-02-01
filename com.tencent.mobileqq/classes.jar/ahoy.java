import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class ahoy
  implements View.OnTouchListener
{
  final agjk jdField_a_of_type_Agjk;
  GestureDetector jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(new ahoz(this));
  View jdField_a_of_type_AndroidViewView = null;
  
  public ahoy(ahow paramahow, agjk paramagjk)
  {
    this.jdField_a_of_type_Agjk = paramagjk;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_Agjk != null) {
      this.jdField_a_of_type_Agjk.onTouch(paramView, paramMotionEvent);
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
 * Qualified Name:     ahoy
 * JD-Core Version:    0.7.0.1
 */