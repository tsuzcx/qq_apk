import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.troop.widget.RedDotAnimateView;

public class ajsx
  implements ValueAnimator.AnimatorUpdateListener
{
  public ajsx(RedDotAnimateView paramRedDotAnimateView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.jdField_a_of_type_Float = (((Float)paramValueAnimator.getAnimatedValue()).floatValue() * this.a.jdField_a_of_type_Int / 2.0F);
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajsx
 * JD-Core Version:    0.7.0.1
 */