import android.app.Activity;
import android.os.Message;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import mqq.os.MqqHandler;

class ahcl
  implements awzc<EmoticonPackage>
{
  ahcl(ahcj paramahcj, String paramString) {}
  
  public void a(EmoticonPackage paramEmoticonPackage)
  {
    if ((paramEmoticonPackage != null) && (this.jdField_a_of_type_Ahcj.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType != 1008) && (this.jdField_a_of_type_Ahcj.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType != 1000) && (this.jdField_a_of_type_Ahcj.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType != 10004) && (this.jdField_a_of_type_Ahcj.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType != 1001) && (this.jdField_a_of_type_Ahcj.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType != 1002) && (this.jdField_a_of_type_Ahcj.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType != 1003) && (this.jdField_a_of_type_Ahcj.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType != 1004) && (this.jdField_a_of_type_Ahcj.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType != 1005) && (this.jdField_a_of_type_Ahcj.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType != 1006))
    {
      paramEmoticonPackage = this.jdField_a_of_type_Ahcj.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class);
      if (paramEmoticonPackage != null) {
        paramEmoticonPackage.obtainMessage(22, this.jdField_a_of_type_JavaLangString).sendToTarget();
      }
      return;
    }
    EmojiHomeUiPlugin.openEmojiDetailPage((Activity)this.jdField_a_of_type_Ahcj.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Ahcj.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 8, this.jdField_a_of_type_JavaLangString, false, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahcl
 * JD-Core Version:    0.7.0.1
 */