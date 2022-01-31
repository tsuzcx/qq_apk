import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import java.util.List;

class alsh
  implements ValueAnimator.AnimatorUpdateListener
{
  alsh(alsg paramalsg) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    int i = 0;
    while (i < alsg.a(this.a).size())
    {
      paramValueAnimator = (alsj)alsg.a(this.a).get(i);
      paramValueAnimator.a((int)(alsj.c(paramValueAnimator) + (alsj.d(paramValueAnimator) - alsj.c(paramValueAnimator)) * f));
      i += 1;
    }
    this.a.invalidateSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     alsh
 * JD-Core Version:    0.7.0.1
 */