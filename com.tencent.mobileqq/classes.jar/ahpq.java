import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class ahpq
{
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      return;
      c(paramQQAppInterface, paramString);
      MessageRecord localMessageRecord = bbli.a(-1026);
      long l = bbko.a();
      localMessageRecord.init(paramQQAppInterface.getCurrentAccountUin(), paramString, paramString, "", l, -1026, 0, l);
      localMessageRecord.isread = true;
      paramQQAppInterface.getMessageFacade().addMessage(localMessageRecord, localMessageRecord.selfuin);
      bcef.b(paramQQAppInterface, "CliOper", "", "", "0X8004C56", "0X8004C56", 0, 0, "", "", "", "");
    } while (!QLog.isColorLevel());
    QLog.d("GatherContactsTipsHelper", 2, "insertUncommonlyUsedContactsTips success, currentUin: " + paramQQAppInterface.getCurrentAccountUin() + " friendUin:" + paramString);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, List<String> paramList)
  {
    if ((paramQQAppInterface == null) || (paramList == null) || (paramList.isEmpty())) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        a(paramQQAppInterface, (String)paramList.next());
      }
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      return;
      c(paramQQAppInterface, paramString);
      MessageRecord localMessageRecord = bbli.a(-1027);
      long l = bbko.a();
      localMessageRecord.init(paramQQAppInterface.getCurrentAccountUin(), paramString, paramString, "", l, -1027, 0, l);
      localMessageRecord.isread = true;
      paramQQAppInterface.getMessageFacade().addMessage(localMessageRecord, localMessageRecord.selfuin);
      bcef.b(paramQQAppInterface, "CliOper", "", "", "0X8004C57", "0X8004C57", 0, 0, "", "", "", "");
    } while (!QLog.isColorLevel());
    QLog.d("GatherContactsTipsHelper", 2, "insertUncommonlyUsedContactsCancelSetTips success, currentUin: " + paramQQAppInterface.getCurrentAccountUin() + " friendUin:" + paramString);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, List<String> paramList)
  {
    if ((paramQQAppInterface == null) || (paramList == null) || (paramList.isEmpty())) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        b(paramQQAppInterface, (String)paramList.next());
      }
    }
  }
  
  public static void c(QQAppInterface paramQQAppInterface, String paramString)
  {
    Iterator localIterator = paramQQAppInterface.getMessageFacade().getMsgList(paramString, 0).iterator();
    while (localIterator.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
      if ((localMessageRecord.msgtype == -1026) || (localMessageRecord.msgtype == -1027))
      {
        paramQQAppInterface.getMessageFacade().removeMsgByUniseq(paramString, 0, localMessageRecord.uniseq);
        if (QLog.isColorLevel()) {
          QLog.d("GatherContactsTipsHelper", 2, "deleteUncommonlyUsedContactsAndCancelTips, currentUin: " + paramQQAppInterface.getCurrentAccountUin() + " friendUin:" + paramString + " msgtype:" + localMessageRecord.msgtype);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahpq
 * JD-Core Version:    0.7.0.1
 */