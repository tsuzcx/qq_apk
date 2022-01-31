import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.activity.aio.item.SixCombolEffectView;

public class aeaj
  implements ValueAnimator.AnimatorUpdateListener
{
  public aeaj(SixCombolEffectView paramSixCombolEffectView, aeay paramaeay) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.jdField_a_of_type_Aeay.a = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    if ((!this.jdField_a_of_type_Aeay.b) && (this.jdField_a_of_type_Aeay.a < 0.52F)) {
      this.jdField_a_of_type_Aeay.b = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeaj
 * JD-Core Version:    0.7.0.1
 */