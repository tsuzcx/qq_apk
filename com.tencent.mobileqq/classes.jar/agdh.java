import android.os.Message;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.view.ProfileHeaderView;
import com.tencent.mobileqq.utils.AvatarPendantUtil;
import com.tencent.util.MqqWeakReferenceHandler;

public class agdh
  implements Runnable
{
  public agdh(ProfileHeaderView paramProfileHeaderView, ProfileCardInfo paramProfileCardInfo, boolean paramBoolean) {}
  
  public void run()
  {
    ExtensionInfo localExtensionInfo = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.a);
    Message localMessage = this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.obtainMessage(ProfileHeaderView.g, localExtensionInfo);
    this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendMessage(localMessage);
    if ((this.jdField_a_of_type_Boolean) && (localExtensionInfo != null) && (AvatarPendantUtil.b(localExtensionInfo.pendantId))) {
      AvatarPendantUtil.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     agdh
 * JD-Core Version:    0.7.0.1
 */