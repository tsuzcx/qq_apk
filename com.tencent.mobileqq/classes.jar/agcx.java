import android.widget.ImageView;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.view.ProfileBaseView;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.AvatarPendantUtil;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.mobileqq.vas.PendantInfo;

class agcx
  implements Runnable
{
  agcx(agcw paramagcw, ExtensionInfo paramExtensionInfo) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.isPendantValid()))
    {
      this.jdField_a_of_type_Agcw.jdField_a_of_type_ComTencentMobileqqProfileViewProfileBaseView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_Agcw.jdField_a_of_type_ComTencentMobileqqProfileViewProfileBaseView.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.pendantId;
      AvatarPendantManager localAvatarPendantManager = (AvatarPendantManager)this.jdField_a_of_type_Agcw.jdField_a_of_type_ComTencentMobileqqProfileViewProfileBaseView.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(45);
      if (AvatarPendantUtil.a(this.jdField_a_of_type_Agcw.jdField_a_of_type_ComTencentMobileqqProfileViewProfileBaseView.jdField_a_of_type_Long)) {
        localAvatarPendantManager.a(this.jdField_a_of_type_Agcw.jdField_a_of_type_ComTencentMobileqqProfileViewProfileBaseView.jdField_a_of_type_Long).a(this.jdField_a_of_type_Agcw.jdField_a_of_type_ComTencentMobileqqProfileViewProfileBaseView.jdField_a_of_type_AndroidWidgetImageView, 2, PendantInfo.c, this.jdField_a_of_type_Agcw.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.a, this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.pendantDiyId);
      }
      for (;;)
      {
        if (this.jdField_a_of_type_Agcw.jdField_a_of_type_Boolean) {
          ReportController.b(this.jdField_a_of_type_Agcw.jdField_a_of_type_ComTencentMobileqqProfileViewProfileBaseView.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "AvatarClick", "ppshow", 0, 0, "", "", "", "");
        }
        return;
        localAvatarPendantManager.a(this.jdField_a_of_type_Agcw.jdField_a_of_type_ComTencentMobileqqProfileViewProfileBaseView.jdField_a_of_type_Long).a(this.jdField_a_of_type_Agcw.jdField_a_of_type_ComTencentMobileqqProfileViewProfileBaseView.jdField_a_of_type_AndroidWidgetImageView, 1, PendantInfo.c, this.jdField_a_of_type_Agcw.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.a, this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.pendantDiyId);
      }
    }
    this.jdField_a_of_type_Agcw.jdField_a_of_type_ComTencentMobileqqProfileViewProfileBaseView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_Agcw.jdField_a_of_type_ComTencentMobileqqProfileViewProfileBaseView.jdField_a_of_type_Long = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     agcx
 * JD-Core Version:    0.7.0.1
 */