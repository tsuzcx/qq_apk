import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class ahfm
  implements View.OnTouchListener
{
  final afzq jdField_a_of_type_Afzq;
  GestureDetector jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(new ahfn(this));
  View jdField_a_of_type_AndroidViewView = null;
  
  public ahfm(ahfk paramahfk, afzq paramafzq)
  {
    this.jdField_a_of_type_Afzq = paramafzq;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_Afzq != null) {
      this.jdField_a_of_type_Afzq.onTouch(paramView, paramMotionEvent);
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
 * Qualified Name:     ahfm
 * JD-Core Version:    0.7.0.1
 */