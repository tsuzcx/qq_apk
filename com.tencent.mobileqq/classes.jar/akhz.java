import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.activity.phone.CountryActivity;

public class akhz
  implements Animation.AnimationListener
{
  public akhz(CountryActivity paramCountryActivity, int paramInt) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPhoneCountryActivity.b.setAnimation(null);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhoneCountryActivity.b.offsetTopAndBottom(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhoneCountryActivity.b.requestLayout();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akhz
 * JD-Core Version:    0.7.0.1
 */