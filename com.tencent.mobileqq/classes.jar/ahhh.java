import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

class ahhh
  implements ValueAnimator.AnimatorUpdateListener
{
  ahhh(ahhd paramahhd) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = (Float)paramValueAnimator.getAnimatedValue();
    ahhd.a(this.a, (int)(paramValueAnimator.floatValue() * -ahhd.a(this.a)));
    this.a.a(this.a.jdField_a_of_type_Int + ahhd.b(this.a));
    this.a.jdField_a_of_type_AndroidViewView.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahhh
 * JD-Core Version:    0.7.0.1
 */