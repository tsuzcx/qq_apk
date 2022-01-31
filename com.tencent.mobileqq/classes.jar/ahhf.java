import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

class ahhf
  implements ValueAnimator.AnimatorUpdateListener
{
  ahhf(ahhb paramahhb) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = (Float)paramValueAnimator.getAnimatedValue();
    ahhb.a(this.a, (int)(paramValueAnimator.floatValue() * -ahhb.a(this.a)));
    this.a.a(this.a.jdField_a_of_type_Int + ahhb.b(this.a));
    this.a.jdField_a_of_type_AndroidViewView.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahhf
 * JD-Core Version:    0.7.0.1
 */