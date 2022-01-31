import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.activity.richmedia.view.RotationSeekBar;

public class ajss
  implements ValueAnimator.AnimatorUpdateListener
{
  public ajss(RotationSeekBar paramRotationSeekBar) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    RotationSeekBar.b(this.a, ((Integer)paramValueAnimator.getAnimatedValue()).intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajss
 * JD-Core Version:    0.7.0.1
 */