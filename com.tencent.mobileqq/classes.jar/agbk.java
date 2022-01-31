import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.activity.aio.item.SixCombolEffectView;

public class agbk
  implements ValueAnimator.AnimatorUpdateListener
{
  public agbk(SixCombolEffectView paramSixCombolEffectView, agbz paramagbz) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.jdField_a_of_type_Agbz.a = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    if ((!this.jdField_a_of_type_Agbz.b) && (this.jdField_a_of_type_Agbz.a < 0.52F)) {
      this.jdField_a_of_type_Agbz.b = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agbk
 * JD-Core Version:    0.7.0.1
 */