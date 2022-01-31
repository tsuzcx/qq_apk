import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.mobileqq.leba.view.LebaTopBarView;

public class aebo
  implements ValueAnimator.AnimatorUpdateListener
{
  public aebo(LebaTopBarView paramLebaTopBarView, View paramView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    paramValueAnimator = this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    paramValueAnimator.height = i;
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(paramValueAnimator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aebo
 * JD-Core Version:    0.7.0.1
 */