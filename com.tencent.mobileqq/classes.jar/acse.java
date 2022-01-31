import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.extendfriend.utils.ExtendFriendVoicePlayer;
import com.tencent.mobileqq.extendfriend.utils.ExtendFriendVoicePlayer.ExtendFriendVoicePlayerListener;
import com.tencent.mobileqq.transfile.BuddyTransfileProcessor;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.MD5;
import java.io.File;

public class acse
  implements Runnable
{
  public acse(ExtendFriendVoicePlayer paramExtendFriendVoicePlayer, String paramString) {}
  
  public void run()
  {
    String str = BuddyTransfileProcessor.a(ExtendFriendVoicePlayer.a(this.jdField_a_of_type_ComTencentMobileqqExtendfriendUtilsExtendFriendVoicePlayer).app.getCurrentAccountUin(), MD5.toMD5(this.jdField_a_of_type_JavaLangString), 23, null);
    File localFile = new File(str);
    int i = HttpDownloadUtil.a(ExtendFriendVoicePlayer.a(this.jdField_a_of_type_ComTencentMobileqqExtendfriendUtilsExtendFriendVoicePlayer).app, this.jdField_a_of_type_JavaLangString, localFile);
    if (i == 0)
    {
      ExtendFriendVoicePlayer.a(this.jdField_a_of_type_ComTencentMobileqqExtendfriendUtilsExtendFriendVoicePlayer).a(localFile);
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendUtilsExtendFriendVoicePlayer.a(str);
      return;
    }
    ExtendFriendVoicePlayer.a(this.jdField_a_of_type_ComTencentMobileqqExtendfriendUtilsExtendFriendVoicePlayer).f(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acse
 * JD-Core Version:    0.7.0.1
 */