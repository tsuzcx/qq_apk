import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.mobileqq.leba.view.LebaTopBarView;

public class aejz
  implements ValueAnimator.AnimatorUpdateListener
{
  public aejz(LebaTopBarView paramLebaTopBarView, float paramFloat, boolean paramBoolean, View paramView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if ((((Float)paramValueAnimator.getAnimatedValue()).floatValue() == this.jdField_a_of_type_Float) && (this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      LebaTopBarView.a(this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaTopBarView, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aejz
 * JD-Core Version:    0.7.0.1
 */