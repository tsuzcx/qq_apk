import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.ark.ArkAppDataReport;
import com.tencent.mobileqq.ark.ArkRecommendController;
import com.tencent.mobileqq.ark.ArkRecommendLogic;
import com.tencent.mobileqq.data.ChatMessage;

public class abef
  implements Runnable
{
  public abef(ArkRecommendController paramArkRecommendController, ChatMessage paramChatMessage, SessionInfo paramSessionInfo) {}
  
  public void run()
  {
    if (ArkRecommendController.a(this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController) == null) {
      return;
    }
    int i = "@babyQ".length();
    String str;
    if (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.msg.length() > i) {
      if (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.msg.charAt(i) != ' ') {
        str = this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.msg.substring(i);
      }
    }
    for (;;)
    {
      ArkRecommendController.a(this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController).a(str, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController);
      ArkAppDataReport.e(ArkRecommendController.a(this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController).a);
      return;
      str = this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.msg.substring(i + 1);
      continue;
      str = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abef
 * JD-Core Version:    0.7.0.1
 */