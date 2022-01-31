import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.activity.richmedia.view.RotationSeekBar;

public class aibi
  implements ValueAnimator.AnimatorUpdateListener
{
  public aibi(RotationSeekBar paramRotationSeekBar) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    RotationSeekBar.b(this.a, ((Integer)paramValueAnimator.getAnimatedValue()).intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aibi
 * JD-Core Version:    0.7.0.1
 */