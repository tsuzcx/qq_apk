import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.view.ProfileBaseView;
import com.tencent.mobileqq.utils.AvatarPendantUtil;
import mqq.os.MqqHandler;

public class agqy
  implements Runnable
{
  public agqy(ProfileBaseView paramProfileBaseView, ProfileCardInfo paramProfileCardInfo, boolean paramBoolean) {}
  
  public void run()
  {
    ExtensionInfo localExtensionInfo = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileBaseView.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.a);
    agqz localagqz = new agqz(this, localExtensionInfo);
    ThreadManager.getUIHandler().post(localagqz);
    if ((this.jdField_a_of_type_Boolean) && (localExtensionInfo != null) && (AvatarPendantUtil.b(localExtensionInfo.pendantId)))
    {
      this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileBaseView.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileBaseView.jdField_a_of_type_ComTencentMobileqqAppBusinessObserver);
      AvatarPendantUtil.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileBaseView.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     agqy
 * JD-Core Version:    0.7.0.1
 */