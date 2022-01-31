import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.arcard.ARGreetingCardListManager;

class aamr
  implements View.OnTouchListener
{
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(new aams(this));
  
  aamr(aamq paramaamq) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (ARGreetingCardListManager.a(this.jdField_a_of_type_Aamq.a)) {
      this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aamr
 * JD-Core Version:    0.7.0.1
 */