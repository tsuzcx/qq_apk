import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class akpn
  extends akon
{
  public akpn(QQAppInterface paramQQAppInterface, QQMessageFacade paramQQMessageFacade)
  {
    super(paramQQAppInterface, paramQQMessageFacade);
  }
  
  public int a(int paramInt, ConversationInfo paramConversationInfo)
  {
    if (akpc.a(paramConversationInfo) > 0) {
      return 0;
    }
    return super.a(paramInt, paramConversationInfo);
  }
  
  protected String a(String paramString1, String paramString2)
  {
    if (this.a.getCurrentAccountUin().equals(paramString1)) {}
    String str;
    for (paramString2 = ajyc.a(2131705435);; paramString2 = bbcl.h(this.a, paramString2, paramString1))
    {
      if ((paramString2 != null) && (paramString2.length() != 0))
      {
        str = paramString2;
        if (!paramString2.equals(paramString1)) {}
      }
      else
      {
        str = this.a.a(true).a(true).a(paramString1);
      }
      if (str != null) {
        break;
      }
      return paramString1;
    }
    return str;
  }
  
  public void a(MessageRecord paramMessageRecord, aukn paramaukn, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, akol paramakol)
  {
    if (paramMessageRecord == null) {
      return;
    }
    Map localMap2 = paramakol.jdField_a_of_type_JavaUtilMap;
    Map localMap1 = paramakol.d;
    Object localObject = paramakol.jdField_a_of_type_Aktg;
    String str1 = paramMessageRecord.frienduin;
    long l = paramMessageRecord.time;
    if (paramMessageRecord.time == 0L) {
      paramMessageRecord.time = awzw.a();
    }
    if (paramMessageRecord.msgseq == 0L) {
      paramMessageRecord.msgseq = ((int)paramMessageRecord.time);
    }
    localObject = ((aktg)localObject).a(str1, 1);
    if (localMap2.containsKey(akpy.a(((RecentUser)localObject).uin, ((RecentUser)localObject).getType()))) {
      localObject = (RecentUser)localMap2.get(akpy.a(((RecentUser)localObject).uin, ((RecentUser)localObject).getType()));
    }
    for (;;)
    {
      int i;
      String str2;
      if (!akpy.g(paramMessageRecord.msgtype))
      {
        i = 1;
        int j = i;
        if (paramMessageRecord.isLongMsg())
        {
          j = i;
          if (this.a.a().a(paramMessageRecord))
          {
            i = 0;
            j = i;
            if (QLog.isColorLevel())
            {
              QLog.i("Q.msg.BaseMessageManager", 2, "addMessageRecord, long msg uncompleted");
              j = i;
            }
          }
        }
        if (j != 0)
        {
          str2 = akpy.a(str1, 1);
          ((RecentUser)localObject).uin = str1;
          ((RecentUser)localObject).setType(1);
          boolean bool = true;
          if ((paramMessageRecord instanceof MessageForUniteGrayTip)) {
            bool = ((MessageForUniteGrayTip)paramMessageRecord).tipParam.d;
          }
          if ((l > ((RecentUser)localObject).lastmsgtime) && (bool)) {
            ((RecentUser)localObject).lastmsgtime = l;
          }
          localMap2.put(str2, localObject);
          localObject = (MessageRecord)localMap1.get(str2);
          if ((localObject != null) && (!paramMessageRecord.isSendFromLocal())) {
            break label358;
          }
          localMap1.put(str2, paramMessageRecord);
        }
      }
      for (;;)
      {
        if (paramMessageRecord.isSendFromLocal())
        {
          paramMessageRecord.extraflag = 32772;
          paramMessageRecord.sendFailCode = 0;
        }
        super.a(paramMessageRecord, paramaukn, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramakol);
        return;
        i = 0;
        break;
        label358:
        if (a(paramMessageRecord) >= a((MessageRecord)localObject)) {
          localMap1.put(str2, paramMessageRecord);
        }
      }
    }
  }
  
  protected String b(String paramString1, String paramString2)
  {
    return a(paramString1, paramString2);
  }
  
  protected void b(QQMessageFacade.Message paramMessage)
  {
    paramMessage.nickName = a(paramMessage.senderuin, paramMessage.frienduin);
    Object localObject;
    if ((paramMessage.nickName == null) || (paramMessage.nickName.equals(paramMessage.senderuin))) {
      localObject = paramMessage.nickName;
    }
    try
    {
      String str = paramMessage.getExtInfoFromExtStr("hotchat_nick");
      localObject = str;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    if ((localObject != null) && (((String)localObject).length() > 0)) {
      paramMessage.nickName = ((String)localObject);
    }
    if (QLog.isDevelopLevel()) {
      atbp.a("PttShow", "processNickName", new Object[] { paramMessage.senderuin, paramMessage.nickName });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akpn
 * JD-Core Version:    0.7.0.1
 */