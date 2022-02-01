import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ArkAppMessage.Config;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;

final class ahhi
  implements ahky
{
  public int a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    paramQQAppInterface = (MessageForArkApp)paramChatMessage;
    paramChatMessage = new ArkAppMessage.Config();
    paramChatMessage.fromString(paramQQAppInterface.ark_app_message.config);
    if ((paramChatMessage.type != null) && (paramChatMessage.type.equals("multiple"))) {
      return 112;
    }
    if ((paramChatMessage.type != null) && (paramChatMessage.type.equals("card"))) {
      return 81;
    }
    return 47;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahhi
 * JD-Core Version:    0.7.0.1
 */