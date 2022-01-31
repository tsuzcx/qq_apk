import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class alml
  implements ValueAnimator.AnimatorUpdateListener
{
  alml(almk paramalmk) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.a(((Integer)paramValueAnimator.getAnimatedValue()).intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     alml
 * JD-Core Version:    0.7.0.1
 */