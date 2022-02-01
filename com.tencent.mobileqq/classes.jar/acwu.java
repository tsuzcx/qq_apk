import android.content.Context;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForWriteTogether;

public class acwu
  implements acod
{
  public boolean a(Context paramContext, QQAppInterface paramQQAppInterface, QQMessageFacade.Message paramMessage, int paramInt, MsgSummary paramMsgSummary, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramQQAppInterface == null) || (paramMessage == null) || (paramMsgSummary == null)) {
      return false;
    }
    paramContext = paramQQAppInterface.getMessageFacade();
    if (paramContext == null) {
      return false;
    }
    paramContext = paramContext.queryMsgItemByUniseq(paramMessage.frienduin, paramMessage.istroop, paramMessage.uniseq);
    if ((paramContext instanceof MessageForWriteTogether))
    {
      paramContext = (MessageForWriteTogether)paramContext;
      paramContext.parse();
      paramMsgSummary.strPrefix = paramString;
      paramMsgSummary.strContent = ("[一起写] " + paramContext.msg);
      return true;
    }
    return false;
  }
  
  public boolean a(QQMessageFacade.Message paramMessage)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acwu
 * JD-Core Version:    0.7.0.1
 */