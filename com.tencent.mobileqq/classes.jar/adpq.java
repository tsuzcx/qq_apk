import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.hotpic.HotPicMainPanel;
import com.tencent.widget.XPanelContainer;

public class adpq
  implements ValueAnimator.AnimatorUpdateListener
{
  public adpq(HotPicMainPanel paramHotPicMainPanel) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    XPanelContainer.a = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    this.a.a.requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adpq
 * JD-Core Version:    0.7.0.1
 */