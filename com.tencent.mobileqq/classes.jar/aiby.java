import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class aiby
  implements View.OnTouchListener
{
  aiby(aibx paramaibx) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      aibx.a(this.a).x = ((int)paramMotionEvent.getRawX());
      aibx.a(this.a).y = ((int)paramMotionEvent.getRawY());
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aiby
 * JD-Core Version:    0.7.0.1
 */