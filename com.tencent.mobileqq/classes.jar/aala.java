import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.arcard.ARBlessWordFragment;

public class aala
  implements View.OnTouchListener
{
  public aala(ARBlessWordFragment paramARBlessWordFragment) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (!this.a.a) {
      if (paramMotionEvent.getAction() == 0) {
        ARBlessWordFragment.a(this.a).setAlpha(0.5F);
      }
    }
    for (;;)
    {
      return false;
      if (paramMotionEvent.getAction() == 1)
      {
        ARBlessWordFragment.a(this.a).setAlpha(1.0F);
        continue;
        ARBlessWordFragment.a(this.a).setAlpha(1.0F);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aala
 * JD-Core Version:    0.7.0.1
 */