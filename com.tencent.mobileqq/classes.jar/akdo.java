import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class akdo
  implements View.OnTouchListener
{
  akdo(akdn paramakdn) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    akdn.a(this.a, paramView);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akdo
 * JD-Core Version:    0.7.0.1
 */