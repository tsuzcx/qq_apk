import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.activity.aio.item.SixCombolEffectView;

public class ahip
  implements ValueAnimator.AnimatorUpdateListener
{
  public ahip(SixCombolEffectView paramSixCombolEffectView, ahje paramahje) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.jdField_a_of_type_Ahje.a = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    if ((!this.jdField_a_of_type_Ahje.b) && (this.jdField_a_of_type_Ahje.a < 0.52F)) {
      this.jdField_a_of_type_Ahje.b = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahip
 * JD-Core Version:    0.7.0.1
 */