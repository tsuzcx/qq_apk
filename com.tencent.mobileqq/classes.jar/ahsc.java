import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.activity.aio.item.SixCombolEffectView;

public class ahsc
  implements ValueAnimator.AnimatorUpdateListener
{
  public ahsc(SixCombolEffectView paramSixCombolEffectView, ahso paramahso) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.jdField_a_of_type_Ahso.b = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemSixCombolEffectView.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahsc
 * JD-Core Version:    0.7.0.1
 */