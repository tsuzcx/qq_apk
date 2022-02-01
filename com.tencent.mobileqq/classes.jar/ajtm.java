import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.activity.contacts.base.tabs.SimpleCheckableSlidingIndicator;

public class ajtm
  implements ValueAnimator.AnimatorUpdateListener
{
  public ajtm(SimpleCheckableSlidingIndicator paramSimpleCheckableSlidingIndicator) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.h = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajtm
 * JD-Core Version:    0.7.0.1
 */