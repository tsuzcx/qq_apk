import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForLongTextMsg;
import com.tencent.mobileqq.data.MessageForWantGiftMsg;

final class ahgl
  implements ahky
{
  public int a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    if ((paramChatMessage instanceof MessageForLongTextMsg)) {
      return 63;
    }
    if ((paramChatMessage instanceof MessageForWantGiftMsg)) {
      return 72;
    }
    if ((paramChatMessage.vipBubbleID == 100000L) && (!paramChatMessage.isSend())) {
      return 9;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahgl
 * JD-Core Version:    0.7.0.1
 */