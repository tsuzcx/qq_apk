import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.PAMessage.Item;
import java.util.ArrayList;

final class agfr
  implements aghk
{
  public int a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    int j = 0;
    paramQQAppInterface = ((MessageForPubAccount)paramChatMessage).mPAMessage;
    int i = j;
    if (paramQQAppInterface != null)
    {
      i = j;
      if (paramQQAppInterface.items != null)
      {
        i = j;
        if (paramQQAppInterface.items.size() != 0)
        {
          if (((PAMessage.Item)paramQQAppInterface.items.get(0)).cover == null) {
            break label85;
          }
          if (paramQQAppInterface.items.size() != 1) {
            break label74;
          }
          i = 6;
        }
      }
    }
    return i;
    label74:
    paramQQAppInterface.items.size();
    return 7;
    label85:
    return 8;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agfr
 * JD-Core Version:    0.7.0.1
 */