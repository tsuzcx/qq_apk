import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.activity.aio.item.HeartCombolEffectView;

public class afpq
  implements ValueAnimator.AnimatorUpdateListener
{
  public afpq(HeartCombolEffectView paramHeartCombolEffectView, afpr paramafpr) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.jdField_a_of_type_Afpr.jdField_b_of_type_Float = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    if ((!this.jdField_a_of_type_Afpr.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Afpr.jdField_b_of_type_Float > 0.0F)) {
      this.jdField_a_of_type_Afpr.jdField_b_of_type_Boolean = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afpq
 * JD-Core Version:    0.7.0.1
 */