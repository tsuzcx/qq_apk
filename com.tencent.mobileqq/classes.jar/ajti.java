import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class ajti
  implements View.OnTouchListener
{
  ajti(ajth paramajth) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      ajth.a(this.a).x = ((int)paramMotionEvent.getRawX());
      ajth.a(this.a).y = ((int)paramMotionEvent.getRawY());
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajti
 * JD-Core Version:    0.7.0.1
 */