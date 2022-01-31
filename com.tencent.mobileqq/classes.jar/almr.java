import android.text.TextUtils;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.qidian.QidianProfileCardActivity;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;

public class almr
  implements Runnable
{
  public almr(QidianProfileCardActivity paramQidianProfileCardActivity, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    Object localObject2 = this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity.app.getCurrentNickname();
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity.app.getCurrentNickname();
    }
    localObject2 = QZoneHelper.UserInfo.a();
    ((QZoneHelper.UserInfo)localObject2).a = this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity.app.getCurrentAccountUin();
    ((QZoneHelper.UserInfo)localObject2).b = ((String)localObject1);
    QZoneHelper.a(this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity, (QZoneHelper.UserInfo)localObject2, this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.a, this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.g, -1, 5, this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitPluginSession, this.jdField_a_of_type_ArrayOfByte);
    QidianProfileCardActivity.b(this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     almr
 * JD-Core Version:    0.7.0.1
 */