import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;

final class agyc
  implements ahbm
{
  public int a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    paramQQAppInterface = ((MessageForUniteGrayTip)paramChatMessage).tipParam;
    if ((paramQQAppInterface != null) && (paramQQAppInterface.b == 655384)) {
      return 110;
    }
    return 64;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agyc
 * JD-Core Version:    0.7.0.1
 */