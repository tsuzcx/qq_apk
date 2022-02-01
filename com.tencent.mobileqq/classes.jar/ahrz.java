import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.activity.aio.item.SixCombolEffectView;

public class ahrz
  implements ValueAnimator.AnimatorUpdateListener
{
  public ahrz(SixCombolEffectView paramSixCombolEffectView, ahso paramahso) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.jdField_a_of_type_Ahso.a = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    if ((!this.jdField_a_of_type_Ahso.b) && (this.jdField_a_of_type_Ahso.a < 0.52F)) {
      this.jdField_a_of_type_Ahso.b = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahrz
 * JD-Core Version:    0.7.0.1
 */