import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.ProgressBar;

final class ajqg
  implements ValueAnimator.AnimatorUpdateListener
{
  ajqg(ProgressBar paramProgressBar) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (this.a != null) {
      this.a.setProgress(((Integer)paramValueAnimator.getAnimatedValue()).intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajqg
 * JD-Core Version:    0.7.0.1
 */