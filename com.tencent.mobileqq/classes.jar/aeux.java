import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.nearby.now.send.SmallVideoSendFragment;

public class aeux
  implements View.OnTouchListener
{
  public aeux(SmallVideoSendFragment paramSmallVideoSendFragment) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((SmallVideoSendFragment.a(this.a)) && (paramMotionEvent.getY() > UITools.a(this.a.a(), 131.0F))) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aeux
 * JD-Core Version:    0.7.0.1
 */