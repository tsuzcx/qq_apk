import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.hotpic.HotPicMainPanel;

public class adpu
  implements View.OnTouchListener
{
  public adpu(HotPicMainPanel paramHotPicMainPanel) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    HotPicMainPanel.a(this.a);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adpu
 * JD-Core Version:    0.7.0.1
 */