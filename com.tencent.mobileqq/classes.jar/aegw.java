import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.leba.LebaFeedsAdapter;
import com.tencent.mobileqq.leba.view.LebaFPSXListView;
import com.tencent.mobileqq.leba.view.LebaFeedsViewBase;

public class aegw
  implements ValueAnimator.AnimatorUpdateListener
{
  public aegw(LebaFeedsAdapter paramLebaFeedsAdapter, LebaFeedsViewBase paramLebaFeedsViewBase, int paramInt) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    if (i <= 240)
    {
      float f = i / 240.0F;
      this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaFeedsViewBase.setAlpha(1.0F - f);
    }
    do
    {
      return;
      paramValueAnimator = this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaFeedsViewBase.getLayoutParams();
    } while (paramValueAnimator == null);
    paramValueAnimator.height = (this.jdField_a_of_type_Int - (int)((i - 240) / 120.0F * this.jdField_a_of_type_Int));
    this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaFeedsViewBase.setLayoutParams(paramValueAnimator);
    LebaFeedsAdapter.a(this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsAdapter).requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aegw
 * JD-Core Version:    0.7.0.1
 */