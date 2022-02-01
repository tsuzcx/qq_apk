import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class alqn
  implements View.OnTouchListener
{
  alqn(alqm paramalqm) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      alqm.a(this.a).x = ((int)paramMotionEvent.getRawX());
      alqm.a(this.a).y = ((int)paramMotionEvent.getRawY());
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alqn
 * JD-Core Version:    0.7.0.1
 */