import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.activity.aio.item.HeartCombolEffectView;

public class agvf
  implements ValueAnimator.AnimatorUpdateListener
{
  public agvf(HeartCombolEffectView paramHeartCombolEffectView, agvg paramagvg) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.jdField_a_of_type_Agvg.jdField_b_of_type_Float = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    if ((!this.jdField_a_of_type_Agvg.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Agvg.jdField_b_of_type_Float > 0.0F)) {
      this.jdField_a_of_type_Agvg.jdField_b_of_type_Boolean = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agvf
 * JD-Core Version:    0.7.0.1
 */