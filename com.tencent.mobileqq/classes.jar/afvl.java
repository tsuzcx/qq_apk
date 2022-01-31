import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.ProgressBar;

final class afvl
  implements ValueAnimator.AnimatorUpdateListener
{
  afvl(ProgressBar paramProgressBar) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (this.a != null) {
      this.a.setProgress(((Integer)paramValueAnimator.getAnimatedValue()).intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afvl
 * JD-Core Version:    0.7.0.1
 */