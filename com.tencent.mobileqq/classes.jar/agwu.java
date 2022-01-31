import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.profile.view.ShimmerLinearLayout;

public class agwu
  implements ValueAnimator.AnimatorUpdateListener
{
  public agwu(ShimmerLinearLayout paramShimmerLinearLayout, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f1 = Math.max(0.0F, Math.min(1.0F, ((Float)paramValueAnimator.getAnimatedValue()).floatValue()));
    paramValueAnimator = this.jdField_a_of_type_ComTencentMobileqqProfileViewShimmerLinearLayout;
    int i = (int)(this.jdField_a_of_type_Int * (1.0F - f1) + this.b * f1);
    float f2 = this.c;
    paramValueAnimator.a(i, (int)(f1 * this.d + f2 * (1.0F - f1)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     agwu
 * JD-Core Version:    0.7.0.1
 */