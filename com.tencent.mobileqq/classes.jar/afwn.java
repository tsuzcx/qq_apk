import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class afwn
  implements ValueAnimator.AnimatorUpdateListener
{
  afwn(afwm paramafwm) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    afwm.a(this.a, f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afwn
 * JD-Core Version:    0.7.0.1
 */