import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.activity.contacts.view.SimpleSlidingIndicator;

public class afhj
  implements ValueAnimator.AnimatorUpdateListener
{
  public afhj(SimpleSlidingIndicator paramSimpleSlidingIndicator) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.h = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afhj
 * JD-Core Version:    0.7.0.1
 */