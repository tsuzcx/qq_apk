import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.leba.view.LebaFeedsViewBase;

public class aebk
  implements View.OnTouchListener
{
  public aebk(LebaFeedsViewBase paramLebaFeedsViewBase) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (!this.a.b) {}
    switch (paramMotionEvent.getAction())
    {
    case 2: 
    default: 
      return false;
    case 0: 
      this.a.a(true);
      return false;
    }
    this.a.a(false);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aebk
 * JD-Core Version:    0.7.0.1
 */