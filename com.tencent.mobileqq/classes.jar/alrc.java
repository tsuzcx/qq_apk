import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.widget.CircleProgress;

public class alrc
  implements ValueAnimator.AnimatorUpdateListener
{
  public alrc(NewFlowCameraActivity paramNewFlowCameraActivity, int paramInt1, int paramInt2) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    paramValueAnimator = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    paramValueAnimator.width = ((int)(this.jdField_a_of_type_Int * f));
    paramValueAnimator.height = ((int)(this.jdField_a_of_type_Int * f));
    paramValueAnimator.addRule(13);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(paramValueAnimator);
    paramValueAnimator = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.getLayoutParams();
    paramValueAnimator.width = ((int)(this.b * f));
    paramValueAnimator.height = ((int)(f * this.b));
    paramValueAnimator.addRule(13);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setLayoutParams(paramValueAnimator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alrc
 * JD-Core Version:    0.7.0.1
 */