import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.activity.contacts.view.SimpleCheckableSlidingIndicator;

public class afsy
  implements ValueAnimator.AnimatorUpdateListener
{
  public afsy(SimpleCheckableSlidingIndicator paramSimpleCheckableSlidingIndicator) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.h = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afsy
 * JD-Core Version:    0.7.0.1
 */