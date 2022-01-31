import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class aica
  implements View.OnTouchListener
{
  aica(aibz paramaibz) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      aibz.a(this.a).x = ((int)paramMotionEvent.getRawX());
      aibz.a(this.a).y = ((int)paramMotionEvent.getRawY());
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aica
 * JD-Core Version:    0.7.0.1
 */