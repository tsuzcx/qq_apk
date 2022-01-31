import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.aio.IntimateTitleSwitchView;

public class acxg
  implements ValueAnimator.AnimatorUpdateListener
{
  public acxg(IntimateTitleSwitchView paramIntimateTitleSwitchView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    if (f < 0.5F)
    {
      this.a.c.setAlpha(1.0F - f * 2.0F);
      return;
    }
    this.a.c.setAlpha(f * 2.0F - 1.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     acxg
 * JD-Core Version:    0.7.0.1
 */