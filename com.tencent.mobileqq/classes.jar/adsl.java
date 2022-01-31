import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.medalwall.MedalGuideView;
import com.tencent.mobileqq.medalwall.ParticleSystem;

public class adsl
  implements ValueAnimator.AnimatorUpdateListener
{
  public adsl(MedalGuideView paramMedalGuideView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    MedalGuideView.a(this.a, f);
    if (this.a.a != null)
    {
      this.a.a.a(f);
      if (f <= 0.05F) {
        this.a.a.b();
      }
    }
    if (paramValueAnimator.getAnimatedFraction() >= 1.0F) {
      paramValueAnimator.removeAllUpdateListeners();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     adsl
 * JD-Core Version:    0.7.0.1
 */