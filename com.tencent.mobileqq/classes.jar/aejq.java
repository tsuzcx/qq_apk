import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.mobileqq.leba.view.LebaFeedsDislikeMaskView;

public class aejq
  implements ValueAnimator.AnimatorUpdateListener
{
  public aejq(LebaFeedsDislikeMaskView paramLebaFeedsDislikeMaskView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    LebaFeedsDislikeMaskView.a(this.a, (int)(LebaFeedsDislikeMaskView.a(this.a) * f));
    if (f <= 0.58F)
    {
      f /= 0.58F;
      LebaFeedsDislikeMaskView.a(this.a).setAlpha(1.0F * f);
      f *= 1.2F;
      LebaFeedsDislikeMaskView.a(this.a).setScaleX(f);
      LebaFeedsDislikeMaskView.a(this.a).setScaleY(f);
    }
    for (;;)
    {
      this.a.invalidate();
      return;
      f = 1.2F - (f - 0.58F) / 0.42F * 0.2F;
      LebaFeedsDislikeMaskView.a(this.a).setScaleX(f);
      LebaFeedsDislikeMaskView.a(this.a).setScaleY(f);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aejq
 * JD-Core Version:    0.7.0.1
 */