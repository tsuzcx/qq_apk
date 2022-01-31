import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.arcard.ARGreetingCardListManager;

class aafq
  implements View.OnTouchListener
{
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(new aafr(this));
  
  aafq(aafp paramaafp) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (ARGreetingCardListManager.a(this.jdField_a_of_type_Aafp.a)) {
      this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aafq
 * JD-Core Version:    0.7.0.1
 */