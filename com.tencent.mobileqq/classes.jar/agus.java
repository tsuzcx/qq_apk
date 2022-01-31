import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

class agus
  implements ValueAnimator.AnimatorUpdateListener
{
  agus(aguo paramaguo) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = (Float)paramValueAnimator.getAnimatedValue();
    aguo.a(this.a, (int)(paramValueAnimator.floatValue() * -aguo.a(this.a)));
    this.a.a(this.a.jdField_a_of_type_Int + aguo.b(this.a));
    this.a.jdField_a_of_type_AndroidViewView.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     agus
 * JD-Core Version:    0.7.0.1
 */