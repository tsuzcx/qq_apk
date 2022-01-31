import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;

final class aloc
  extends adie
{
  private aloc(QQAppInterface paramQQAppInterface)
  {
    super(null, paramQQAppInterface, null, null, null);
  }
  
  private boolean a(ChatMessage paramChatMessage)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramChatMessage != null)
    {
      int i = a(paramChatMessage);
      if ((i != 81) && (i != 66) && (i != 42) && (i != 47))
      {
        bool1 = bool2;
        if (i != 89) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private boolean b(ChatMessage paramChatMessage)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    int i;
    MessageForArkApp localMessageForArkApp;
    if (paramChatMessage != null)
    {
      i = a(paramChatMessage);
      if (i != 81) {
        break label149;
      }
      if (!(paramChatMessage instanceof MessageForArkApp)) {
        break label147;
      }
      localMessageForArkApp = (MessageForArkApp)paramChatMessage;
      if ((localMessageForArkApp.isMultiMsg) || (localMessageForArkApp.istroop != 0)) {
        break label147;
      }
      if ((paramChatMessage.senderuin.equals(this.a.c())) || (!paramChatMessage.isSupportReply())) {
        break label92;
      }
      if (localMessageForArkApp.msg == null) {
        break label87;
      }
      bool1 = true;
    }
    label87:
    label92:
    do
    {
      do
      {
        for (;;)
        {
          return bool1;
          bool1 = false;
        }
        if ((!paramChatMessage.isSend()) || (!paramChatMessage.isSupportReply()) || (paramChatMessage.extraflag == 32772) || (paramChatMessage.extraflag == 32768) || (paramChatMessage.istroop == 3000)) {
          break;
        }
        bool1 = bool2;
      } while (localMessageForArkApp.msg != null);
      return false;
      return false;
      if ((i == 66) || (i == 42) || (i == 47)) {
        break;
      }
      bool1 = bool2;
    } while (i != 89);
    label147:
    label149:
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aloc
 * JD-Core Version:    0.7.0.1
 */