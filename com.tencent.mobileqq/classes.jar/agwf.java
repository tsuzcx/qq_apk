import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.profile.view.ProfileTagView;

public class agwf
  implements Animation.AnimationListener
{
  public agwf(ProfileTagView paramProfileTagView, View paramView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView;
    paramAnimation.l -= 1;
    this.jdField_a_of_type_AndroidViewView.setVisibility(4);
    this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView.d = false;
    if (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView.l == 0) {
      this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView.b();
    }
    ((FriendProfileCardActivity)this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView.a).k();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     agwf
 * JD-Core Version:    0.7.0.1
 */