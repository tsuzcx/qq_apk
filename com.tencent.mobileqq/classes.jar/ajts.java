import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.activity.contacts.base.tabs.SimpleSlidingIndicator;

public class ajts
  implements ValueAnimator.AnimatorUpdateListener
{
  public ajts(SimpleSlidingIndicator paramSimpleSlidingIndicator) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.h = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajts
 * JD-Core Version:    0.7.0.1
 */