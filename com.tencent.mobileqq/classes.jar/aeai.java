import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.activity.aio.item.SixCombolEffectView;

public class aeai
  implements ValueAnimator.AnimatorUpdateListener
{
  public aeai(SixCombolEffectView paramSixCombolEffectView, aeaw paramaeaw) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.jdField_a_of_type_Aeaw.a = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeai
 * JD-Core Version:    0.7.0.1
 */