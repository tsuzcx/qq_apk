import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import com.tencent.mobileqq.profile.view.ProfileHeaderView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.AnimateUtils.AnimationAdapter;
import com.tencent.util.MqqWeakReferenceHandler;

public class agri
  extends AnimateUtils.AnimationAdapter
{
  public agri(ProfileHeaderView paramProfileHeaderView, LinearLayout paramLinearLayout, View paramView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.d(ProfileHeaderView.jdField_a_of_type_JavaLangString, 2, "ProfileHeaderView updateTips sideOutAnim onAnimationEnd");
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_AndroidViewView);
    paramAnimation = AnimationUtils.loadAnimation(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131034358);
    paramAnimation.setFillAfter(true);
    this.jdField_a_of_type_AndroidViewView.startAnimation(paramAnimation);
    if (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.c < 4)
    {
      paramAnimation = this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView;
      paramAnimation.c += 1;
      paramAnimation = this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.obtainMessage(ProfileHeaderView.d);
      this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendMessageDelayed(paramAnimation, 4000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     agri
 * JD-Core Version:    0.7.0.1
 */