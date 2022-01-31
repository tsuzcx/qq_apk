import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;

final class afme
  implements afpr
{
  public int a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    if (paramChatMessage.senderuin.equals(paramQQAppInterface.getCurrentAccountUin())) {
      return 59;
    }
    return 60;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afme
 * JD-Core Version:    0.7.0.1
 */