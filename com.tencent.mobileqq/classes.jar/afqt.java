import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;

final class afqt
  implements afug
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
 * Qualified Name:     afqt
 * JD-Core Version:    0.7.0.1
 */