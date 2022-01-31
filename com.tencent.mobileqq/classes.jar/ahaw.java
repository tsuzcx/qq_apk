import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class ahaw
  implements View.OnTouchListener
{
  ahaw(ahav paramahav) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0) {
      paramView.setAlpha(0.5F);
    }
    for (;;)
    {
      return false;
      if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3)) {
        paramView.setAlpha(1.0F);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ahaw
 * JD-Core Version:    0.7.0.1
 */