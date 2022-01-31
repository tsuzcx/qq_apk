import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.app.FrameHelperActivity;

public class abnj
  implements View.OnTouchListener
{
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getActionMasked())
    {
    case 2: 
    default: 
      return false;
    case 0: 
      FrameHelperActivity.c(false);
      return false;
    }
    FrameHelperActivity.c(true);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abnj
 * JD-Core Version:    0.7.0.1
 */