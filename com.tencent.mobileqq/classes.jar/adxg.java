import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class adxg
  implements View.OnTouchListener
{
  final acxj jdField_a_of_type_Acxj;
  GestureDetector jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(new adxh(this));
  View jdField_a_of_type_AndroidViewView = null;
  
  public adxg(adxe paramadxe, acxj paramacxj)
  {
    this.jdField_a_of_type_Acxj = paramacxj;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_Acxj != null) {
      this.jdField_a_of_type_Acxj.onTouch(paramView, paramMotionEvent);
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
 * Qualified Name:     adxg
 * JD-Core Version:    0.7.0.1
 */