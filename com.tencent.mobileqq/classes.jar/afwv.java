import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.activity.aio.item.SixCombolEffectView;

public class afwv
  implements ValueAnimator.AnimatorUpdateListener
{
  public afwv(SixCombolEffectView paramSixCombolEffectView, afxk paramafxk) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.jdField_a_of_type_Afxk.a = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    if ((!this.jdField_a_of_type_Afxk.b) && (this.jdField_a_of_type_Afxk.a < 0.52F)) {
      this.jdField_a_of_type_Afxk.b = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afwv
 * JD-Core Version:    0.7.0.1
 */