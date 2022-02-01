import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.activity.aio.item.SixCombolEffectView;

public class ahhc
  implements ValueAnimator.AnimatorUpdateListener
{
  public ahhc(SixCombolEffectView paramSixCombolEffectView, ahhr paramahhr) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.jdField_a_of_type_Ahhr.a = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    if ((!this.jdField_a_of_type_Ahhr.b) && (this.jdField_a_of_type_Ahhr.a < 0.52F)) {
      this.jdField_a_of_type_Ahhr.b = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahhc
 * JD-Core Version:    0.7.0.1
 */