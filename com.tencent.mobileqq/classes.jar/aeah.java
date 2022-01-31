import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.activity.aio.item.SixCombolEffectView;

public class aeah
  implements ValueAnimator.AnimatorUpdateListener
{
  public aeah(SixCombolEffectView paramSixCombolEffectView, aeaw paramaeaw) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.jdField_a_of_type_Aeaw.a = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    if ((!this.jdField_a_of_type_Aeaw.b) && (this.jdField_a_of_type_Aeaw.a < 0.52F)) {
      this.jdField_a_of_type_Aeaw.b = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeah
 * JD-Core Version:    0.7.0.1
 */