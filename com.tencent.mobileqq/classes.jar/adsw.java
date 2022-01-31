import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.activity.aio.item.HeartCombolEffectView;

public class adsw
  implements ValueAnimator.AnimatorUpdateListener
{
  public adsw(HeartCombolEffectView paramHeartCombolEffectView, adsx paramadsx) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.jdField_a_of_type_Adsx.jdField_b_of_type_Float = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    if ((!this.jdField_a_of_type_Adsx.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Adsx.jdField_b_of_type_Float > 0.0F)) {
      this.jdField_a_of_type_Adsx.jdField_b_of_type_Boolean = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adsw
 * JD-Core Version:    0.7.0.1
 */