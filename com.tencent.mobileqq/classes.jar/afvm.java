import android.animation.ValueAnimator;
import android.widget.ProgressBar;

public class afvm
{
  public static ValueAnimator a(ProgressBar paramProgressBar, int paramInt)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, paramInt }).setDuration(500L);
    localValueAnimator.addUpdateListener(new afvn(paramProgressBar));
    return localValueAnimator;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afvm
 * JD-Core Version:    0.7.0.1
 */