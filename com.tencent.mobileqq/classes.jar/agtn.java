import android.app.Activity;
import android.text.TextUtils;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profile.PersonalityLabel.ShareHelper;
import com.tencent.mobileqq.profile.PersonalityLabel.ShareHelper.OnUseResListener;
import com.tencent.mobileqq.utils.ContactUtils;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;

class agtn
  implements Runnable
{
  agtn(agtm paramagtm, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Agtm.a.a.jdField_a_of_type_AndroidAppActivity.isFinishing()) {
      return;
    }
    this.jdField_a_of_type_Agtm.a.a.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelShareHelper$OnUseResListener.a(false);
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      QRUtils.a(1, 2131430006);
      return;
    }
    QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.a();
    localUserInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Agtm.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    localUserInfo.b = ContactUtils.j(this.jdField_a_of_type_Agtm.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Agtm.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
    QZoneHelper.a(this.jdField_a_of_type_Agtm.a.a.jdField_a_of_type_AndroidAppActivity, localUserInfo, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Agtm.a.a.jdField_a_of_type_AndroidAppActivity.getString(2131429970), "快来看看我的QQ个性标签吧", 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     agtn
 * JD-Core Version:    0.7.0.1
 */