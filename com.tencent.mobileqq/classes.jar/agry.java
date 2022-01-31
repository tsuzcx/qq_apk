import android.content.res.Resources;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.view.ProfileTagView;
import com.tencent.mobileqq.profile.view.VipTagView;

public class agry
  implements Animation.AnimationListener
{
  public agry(ProfileTagView paramProfileTagView, VipTagView paramVipTagView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewVipTagView, true);
  }
  
  public void onAnimationRepeat(Animation paramAnimation)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView.a.a.a != 0) {
      this.jdField_a_of_type_ComTencentMobileqqProfileViewVipTagView.setTagColor(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView.getResources().getColor(2131493147), this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView.getResources().getColor(2131493146));
    }
  }
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     agry
 * JD-Core Version:    0.7.0.1
 */