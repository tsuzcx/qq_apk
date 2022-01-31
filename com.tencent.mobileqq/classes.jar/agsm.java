import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.view.VipProfileSimpleView;

public class agsm
  implements Animation.AnimationListener
{
  public agsm(VipProfileSimpleView paramVipProfileSimpleView, ProfileCardInfo paramProfileCardInfo) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.jdField_a_of_type_ComTencentMobileqqProfileViewVipProfileSimpleView.c = true;
    this.jdField_a_of_type_ComTencentMobileqqProfileViewVipProfileSimpleView.h(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     agsm
 * JD-Core Version:    0.7.0.1
 */