import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class ahgm
  implements View.OnTouchListener
{
  ahgm(ahgl paramahgl) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1) {
      this.a.a();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahgm
 * JD-Core Version:    0.7.0.1
 */