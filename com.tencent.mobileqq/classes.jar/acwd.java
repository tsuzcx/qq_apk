import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class acwd
{
  static void a(QQAppInterface paramQQAppInterface, acvh paramacvh, QQMessageFacade paramQQMessageFacade, String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    paramInt2 = acwh.a(paramInt2, paramInt3);
    paramQQAppInterface.a(paramInt1).a(paramString1, paramInt1, paramString2, paramString3, paramInt2);
    paramString3 = paramQQMessageFacade.a(paramString1, paramInt1);
    if ((paramString3.senderuin != null) && (paramString3.senderuin.equals(paramString2)) && ((paramInt2 == 0) || ((paramInt2 != 0) && (paramInt2 == paramString3.getExtraKey()))))
    {
      paramString2 = paramQQAppInterface.a(paramInt1).b(paramString1, paramInt1);
      if ((paramString2 == null) || (paramString2.isEmpty())) {
        break label166;
      }
      MessageRecord.copyMessageRecordBaseField(paramString3, (MessageRecord)paramString2.get(paramString2.size() - 1));
      paramString3.frienduin = paramString1;
      paramString3.emoRecentMsg = null;
    }
    label166:
    do
    {
      do
      {
        try
        {
          paramacvh.a(paramString3);
          return;
        }
        catch (Throwable paramQQAppInterface)
        {
          while (!QLog.isColorLevel()) {}
          QLog.d("Q.msg.BaseMessageManager", 2, "removeMsgFromMsgBox ERROR", paramQQAppInterface);
          return;
        }
        paramString3.emoRecentMsg = null;
        paramString3.msg = null;
        aqjq.a(paramString3);
      } while (!paramBoolean);
      paramQQAppInterface = (RecentUser)paramQQAppInterface.a().a().findRecentUserByUin(paramString1, paramInt1);
    } while (paramQQAppInterface == null);
    paramQQMessageFacade.a(paramQQAppInterface);
  }
  
  static void a(QQAppInterface paramQQAppInterface, acvh paramacvh, QQMessageFacade paramQQMessageFacade, String paramString1, int paramInt, String paramString2, String paramString3, boolean paramBoolean)
  {
    paramQQAppInterface.a(paramInt).a(paramString1, paramInt, paramString2, paramString3, 0);
    String str = "";
    if (paramInt == 1010) {
      str = anhk.ab;
    }
    label34:
    label42:
    do
    {
      do
      {
        break label42;
        break label42;
        break label42;
        if (TextUtils.isEmpty(str)) {}
        for (;;)
        {
          return;
          if ((paramInt != 1001) && (paramInt != 10002)) {
            break label34;
          }
          str = anhk.H;
          break label34;
          QQMessageFacade.Message localMessage = paramQQMessageFacade.a(paramString1, paramInt);
          if ((localMessage.senderuin == null) || (!localMessage.senderuin.equals(paramString2))) {
            break;
          }
          paramQQAppInterface.a(paramInt).a(str, paramInt, paramString1, paramString3, 0);
          paramString2 = paramQQAppInterface.a(paramInt).b(paramString1, paramInt);
          if ((paramString2 != null) && (!paramString2.isEmpty()))
          {
            paramString2 = (MessageRecord)paramString2.get(paramString2.size() - 1);
            paramString3 = bbzh.a(paramString2.msgtype);
            MessageRecord.copyMessageRecordBaseField(paramString3, paramString2);
            paramString3.frienduin = str;
            paramString3.senderuin = paramString1;
            if (!acwh.h(paramString2.msgtype)) {
              paramacvh.a(paramString3, null, false, true, 1);
            }
            MessageRecord.copyMessageRecordBaseField(localMessage, paramString2);
            localMessage.frienduin = paramString1;
            localMessage.emoRecentMsg = null;
          }
          try
          {
            paramacvh.a(localMessage);
            paramString2 = paramQQMessageFacade.a(str, paramInt);
            if ((paramString2.senderuin != null) && (paramString2.senderuin.equals(paramString1)))
            {
              paramString1 = paramQQAppInterface.a(paramInt).b(str, paramInt);
              if ((paramString1 != null) && (!paramString1.isEmpty()))
              {
                MessageRecord.copyMessageRecordBaseField(paramString2, (MessageRecord)paramString1.get(paramString1.size() - 1));
                paramString2.frienduin = str;
                paramString2.emoRecentMsg = null;
                try
                {
                  paramacvh.a(paramString2);
                  return;
                }
                catch (Throwable paramQQAppInterface) {}
                if (!QLog.isColorLevel()) {
                  continue;
                }
                QLog.d("Q.msg.BaseMessageManager", 2, "removeMsgFromMsgBox ERROR", paramQQAppInterface);
              }
            }
          }
          catch (Throwable paramString2)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageManager", 2, "removeMsgFromMsgBox decode msgInLBSBox ERROR", paramString2);
              }
            }
            paramString2.emoRecentMsg = null;
            paramString2.msg = null;
          }
        }
      } while (!paramBoolean);
      paramQQAppInterface = (RecentUser)paramQQAppInterface.a().a().findRecentUserByUin(str, paramInt);
    } while (paramQQAppInterface == null);
    paramQQMessageFacade.a(paramQQAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acwd
 * JD-Core Version:    0.7.0.1
 */