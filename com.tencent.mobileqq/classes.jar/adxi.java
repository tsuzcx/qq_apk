import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class adxi
  implements View.OnTouchListener
{
  final acxn jdField_a_of_type_Acxn;
  GestureDetector jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(new adxj(this));
  View jdField_a_of_type_AndroidViewView = null;
  
  public adxi(adxg paramadxg, acxn paramacxn)
  {
    this.jdField_a_of_type_Acxn = paramacxn;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_Acxn != null) {
      this.jdField_a_of_type_Acxn.onTouch(paramView, paramMotionEvent);
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
 * Qualified Name:     adxi
 * JD-Core Version:    0.7.0.1
 */