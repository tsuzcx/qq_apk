import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class akyg
  implements View.OnTouchListener
{
  akyg(akyf paramakyf) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      akyf.a(this.a).x = ((int)paramMotionEvent.getRawX());
      akyf.a(this.a).y = ((int)paramMotionEvent.getRawY());
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akyg
 * JD-Core Version:    0.7.0.1
 */