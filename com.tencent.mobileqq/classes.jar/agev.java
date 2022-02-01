import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPic;

final class agev
  implements aghk
{
  public int a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    if (((MessageForPic)paramChatMessage).isMixed) {
      return 24;
    }
    if (amtr.a(paramChatMessage)) {
      return 42;
    }
    if (amrp.a(paramChatMessage)) {
      return 66;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agev
 * JD-Core Version:    0.7.0.1
 */