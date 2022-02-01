import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.biz.richframework.part.block.base.RefreshHeaderView;

public class aacb
  implements ValueAnimator.AnimatorUpdateListener
{
  public aacb(RefreshHeaderView paramRefreshHeaderView, int paramInt) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBaseRefreshHeaderView.setVisibleHeight(((Integer)paramValueAnimator.getAnimatedValue()).intValue());
    if ((this.jdField_a_of_type_Int == 0) && (((Integer)paramValueAnimator.getAnimatedValue()).intValue() == 0)) {
      this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBaseRefreshHeaderView.setState(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aacb
 * JD-Core Version:    0.7.0.1
 */