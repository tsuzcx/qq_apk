import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarManager;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicUtils;
import com.tencent.mobileqq.avatar.dynamicavatar.SelectCoverActivity;
import com.tencent.mobileqq.util.ProfileCardUtil;
import java.io.File;

class abkk
  implements Runnable
{
  abkk(abki paramabki, SelectCoverActivity paramSelectCoverActivity, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarSelectCoverActivity.a.b;
    File localFile = new File(str);
    if ((localFile != null) && (localFile.exists()))
    {
      DynamicUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, 38, this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarSelectCoverActivity.e, 100);
      ProfileCardUtil.a(str);
      return;
    }
    SelectCoverActivity.a(this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarSelectCoverActivity, 2, "上传失败，请重试", 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abkk
 * JD-Core Version:    0.7.0.1
 */