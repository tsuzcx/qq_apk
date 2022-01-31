import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.mobileqq.leba.view.LebaFeedsDislikeMaskView;

public class aejs
  implements ValueAnimator.AnimatorUpdateListener
{
  public aejs(LebaFeedsDislikeMaskView paramLebaFeedsDislikeMaskView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    LebaFeedsDislikeMaskView.a(this.a, LebaFeedsDislikeMaskView.a(this.a) - (int)(LebaFeedsDislikeMaskView.a(this.a) * f));
    LebaFeedsDislikeMaskView.a(this.a).setAlpha(1.0F - f);
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aejs
 * JD-Core Version:    0.7.0.1
 */