import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class alwc
  implements View.OnTouchListener
{
  alwc(alwb paramalwb) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      alwb.a(this.a).x = ((int)paramMotionEvent.getRawX());
      alwb.a(this.a).y = ((int)paramMotionEvent.getRawY());
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alwc
 * JD-Core Version:    0.7.0.1
 */