import android.animation.ValueAnimator;
import android.widget.ProgressBar;

public class ahxt
{
  public static ValueAnimator a(ProgressBar paramProgressBar, int paramInt)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, paramInt }).setDuration(500L);
    localValueAnimator.addUpdateListener(new ahxu(paramProgressBar));
    return localValueAnimator;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahxt
 * JD-Core Version:    0.7.0.1
 */