import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.activity.aio.item.SixCombolEffectView;

public class ahsa
  implements ValueAnimator.AnimatorUpdateListener
{
  public ahsa(SixCombolEffectView paramSixCombolEffectView, ahso paramahso) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.jdField_a_of_type_Ahso.a = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahsa
 * JD-Core Version:    0.7.0.1
 */