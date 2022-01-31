import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class ahgo
  implements View.OnTouchListener
{
  ahgo(ahgn paramahgn) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1) {
      this.a.a();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahgo
 * JD-Core Version:    0.7.0.1
 */