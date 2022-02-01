import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class affi
  implements ValueAnimator.AnimatorUpdateListener
{
  affi(affh paramaffh) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    affh.a(this.a, f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     affi
 * JD-Core Version:    0.7.0.1
 */