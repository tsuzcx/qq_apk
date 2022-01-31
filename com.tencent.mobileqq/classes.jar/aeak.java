import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.activity.aio.item.SixCombolEffectView;

public class aeak
  implements ValueAnimator.AnimatorUpdateListener
{
  public aeak(SixCombolEffectView paramSixCombolEffectView, aeaw paramaeaw) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.jdField_a_of_type_Aeaw.b = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemSixCombolEffectView.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeak
 * JD-Core Version:    0.7.0.1
 */