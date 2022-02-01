import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForDeviceFile;

final class agdt
  implements aghk
{
  public int a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    paramQQAppInterface = (MessageForDeviceFile)paramChatMessage;
    if (paramQQAppInterface.nFileMsgType == 2) {
      return 36;
    }
    if (paramQQAppInterface.nFileMsgType == 1) {
      return 37;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agdt
 * JD-Core Version:    0.7.0.1
 */