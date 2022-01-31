import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.olympic.view.ScanIconAnimateView;

public class agjy
  implements ValueAnimator.AnimatorUpdateListener
{
  public agjy(ScanIconAnimateView paramScanIconAnimateView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.d = (((Float)paramValueAnimator.getAnimatedValue()).floatValue() * -1.0F * AIOUtils.a(1.5F, this.a.getResources()));
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agjy
 * JD-Core Version:    0.7.0.1
 */