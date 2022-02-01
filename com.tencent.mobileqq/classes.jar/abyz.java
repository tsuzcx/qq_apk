import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.GetAioListCallback;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Collections;
import java.util.List;

public class abyz
  implements QQMessageFacade.GetAioListCallback
{
  private void a(List<ChatMessage> paramList)
  {
    try
    {
      Collections.sort(paramList, new abza(this));
      return;
    }
    catch (Exception paramList)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("PaiYiPaiGetAioList", 2, "Collections sort exception ! ", paramList);
    }
  }
  
  private void a(List<ChatMessage> paramList, ChatMessage paramChatMessage)
  {
    if (agjp.a(paramChatMessage.senderuin))
    {
      if (!(paramChatMessage instanceof MessageForText)) {
        break label111;
      }
      if (!((MessageForText)paramChatMessage).msg.startsWith(" ")) {
        paramList.remove(paramChatMessage);
      }
    }
    for (;;)
    {
      if ((paramChatMessage.msgtype == -5008) && (ArkAppCenter.b())) {
        paramList.remove(paramChatMessage);
      }
      if ((paramChatMessage.msgtype == -2011) && ((paramChatMessage instanceof MessageForStructing)))
      {
        AbsStructMsg localAbsStructMsg = ((MessageForStructing)paramChatMessage).structingMsg;
        if ((localAbsStructMsg != null) && (localAbsStructMsg.mMsgServiceID == 85)) {
          paramList.remove(paramChatMessage);
        }
      }
      return;
      label111:
      if ((!(paramChatMessage instanceof MessageForArkApp)) && (!(paramChatMessage instanceof MessageForStructing))) {
        paramList.remove(paramChatMessage);
      }
    }
  }
  
  public void onGetAioList(String paramString, int paramInt1, long paramLong, int paramInt2, boolean paramBoolean, List<ChatMessage> paramList, QQMessageFacade paramQQMessageFacade)
  {
    if (paramInt1 != 1008) {
      return;
    }
    if (paramList == null)
    {
      paramInt1 = 0;
      paramInt1 -= 1;
      label19:
      if (paramInt1 < 0) {
        break label67;
      }
      paramString = (ChatMessage)paramList.get(paramInt1);
      if (paramString != null) {
        break label57;
      }
    }
    for (;;)
    {
      paramInt1 -= 1;
      break label19;
      paramInt1 = paramList.size();
      break;
      label57:
      a(paramList, paramString);
    }
    label67:
    a(paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abyz
 * JD-Core Version:    0.7.0.1
 */