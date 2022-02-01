import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPoke;

final class agwp
  implements ahab
{
  public int a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    paramQQAppInterface = (MessageForPoke)paramChatMessage;
    if ((paramQQAppInterface.interactType == 126) && (!ahcw.a(paramQQAppInterface.minVersion))) {
      return 0;
    }
    return 62;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agwp
 * JD-Core Version:    0.7.0.1
 */