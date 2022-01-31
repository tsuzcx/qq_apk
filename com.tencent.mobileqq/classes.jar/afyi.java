import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class afyi
  implements View.OnTouchListener
{
  final aetk jdField_a_of_type_Aetk;
  GestureDetector jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(new afyj(this));
  View jdField_a_of_type_AndroidViewView = null;
  
  public afyi(afyg paramafyg, aetk paramaetk)
  {
    this.jdField_a_of_type_Aetk = paramaetk;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_Aetk != null) {
      this.jdField_a_of_type_Aetk.onTouch(paramView, paramMotionEvent);
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
 * Qualified Name:     afyi
 * JD-Core Version:    0.7.0.1
 */