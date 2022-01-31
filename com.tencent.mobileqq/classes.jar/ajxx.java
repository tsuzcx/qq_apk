import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class ajxx
  implements View.OnTouchListener
{
  ajxx(ajxw paramajxw) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      ajxw.a(this.a).x = ((int)paramMotionEvent.getRawX());
      ajxw.a(this.a).y = ((int)paramMotionEvent.getRawY());
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajxx
 * JD-Core Version:    0.7.0.1
 */