import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.activity.richmedia.view.RotationSeekBar;

public class ambo
  implements ValueAnimator.AnimatorUpdateListener
{
  public ambo(RotationSeekBar paramRotationSeekBar) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    RotationSeekBar.a(this.a, ((Integer)paramValueAnimator.getAnimatedValue()).intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ambo
 * JD-Core Version:    0.7.0.1
 */