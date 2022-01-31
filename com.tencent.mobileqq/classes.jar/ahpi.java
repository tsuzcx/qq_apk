import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class ahpi
  implements View.OnTouchListener
{
  ahpi(ahph paramahph) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      ahph.a(this.a).x = ((int)paramMotionEvent.getRawX());
      ahph.a(this.a).y = ((int)paramMotionEvent.getRawY());
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ahpi
 * JD-Core Version:    0.7.0.1
 */