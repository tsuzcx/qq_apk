import android.content.res.Resources;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class akph
  extends akom
{
  public akph(QQAppInterface paramQQAppInterface, QQMessageFacade paramQQMessageFacade)
  {
    super(paramQQAppInterface, paramQQMessageFacade);
  }
  
  public String a(String paramString1, String paramString2)
  {
    if (this.a.getCurrentAccountUin().equals(paramString1)) {
      return this.a.getApp().getResources().getString(2131694099);
    }
    return bbcz.c(this.a, paramString2, paramString1);
  }
  
  public void a(MessageRecord paramMessageRecord, aukp paramaukp, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, akok paramakok)
  {
    if (paramMessageRecord == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageManager_At_Me_DISC", 2, "addMessageRecord:" + paramMessageRecord);
    }
    Map localMap = paramakok.jdField_a_of_type_JavaUtilMap;
    Object localObject = paramakok.jdField_a_of_type_Aktf;
    if (paramMessageRecord.time == 0L) {
      paramMessageRecord.time = awzy.a();
    }
    if (paramMessageRecord.msgseq == 0L) {
      paramMessageRecord.msgseq = ((int)paramMessageRecord.time);
    }
    String str1 = paramMessageRecord.frienduin;
    int k = paramMessageRecord.istroop;
    long l = paramMessageRecord.time;
    RecentUser localRecentUser = ((aktf)localObject).a(str1, paramMessageRecord.istroop);
    localObject = null;
    asks localasks = paramakok.jdField_a_of_type_Asks;
    String str2;
    azml localazml;
    if (localasks != null)
    {
      str2 = str1 + "&" + 3000;
      localazml = localasks.a(str2);
      if (localazml == null) {
        break label640;
      }
      if (localazml.a() == paramMessageRecord.shmsgseq) {
        break label583;
      }
      localazml = null;
      localObject = localazml;
      if (QLog.isColorLevel())
      {
        QLog.d("Q.msg.BaseMessageManager_At_Me_DISC", 2, "addMessageRecord:not the same msg:" + str2);
        localObject = localazml;
      }
    }
    int i;
    if ((localObject != null) && (((azml)localObject).a()))
    {
      i = ((azml)localObject).a();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager_At_Me_DISC", 2, "addMessageRecord, bizType" + i + "|ru.msgType:" + localRecentUser.msgType);
      }
      if (azml.a(i, localRecentUser.msgType))
      {
        localRecentUser.msgType = i;
        localRecentUser.msg = azml.a(this.a, str1, (azml)localObject, localRecentUser.msg, paramMessageRecord, false);
        localMap.put(akpx.a(str1, k), localRecentUser);
      }
    }
    if (localMap.containsKey(akpx.a(localRecentUser.uin, localRecentUser.getType()))) {}
    for (localObject = (RecentUser)localMap.get(akpx.a(localRecentUser.uin, localRecentUser.getType()));; localObject = localRecentUser)
    {
      if (!akpx.g(paramMessageRecord.msgtype)) {}
      for (i = 1;; i = 0)
      {
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
          ((RecentUser)localObject).uin = str1;
          ((RecentUser)localObject).setType(k);
          boolean bool = true;
          if ((paramMessageRecord instanceof MessageForUniteGrayTip)) {
            bool = ((MessageForUniteGrayTip)paramMessageRecord).tipParam.d;
          }
          if ((l > ((RecentUser)localObject).lastmsgtime) && (bool))
          {
            ((RecentUser)localObject).lastmsgtime = l;
            localMap.put(akpx.a(str1, k), localObject);
          }
        }
        super.a(paramMessageRecord, paramaukp, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramakok);
        paramaukp = ayfy.a(this.a);
        paramaukp.a(paramMessageRecord);
        paramaukp.a();
        return;
        label583:
        localObject = localazml;
        if (!paramMessageRecord.isread) {
          break;
        }
        localasks.b(str2);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager_At_Me_DISC", 2, "addMessageRecord:readed msg been removed:" + str2);
        }
        localObject = null;
        break;
        label640:
        localObject = localazml;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.msg.BaseMessageManager_At_Me_DISC", 2, "addMessageRecord:msgInfo == null " + str2);
        localObject = localazml;
        break;
      }
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageManager_At_Me_DISC", 2, "afterCleanUnRead:" + paramString + "-" + paramInt);
    }
    super.a(paramString, paramInt);
    ProxyManager localProxyManager = this.a.a();
    paramString = localProxyManager.a().a(paramString, paramInt);
    if (paramString.shouldShowInRecentList())
    {
      paramString.cleanMsgAndMsgData(paramString.msgType);
      localProxyManager.a().a(paramString);
    }
  }
  
  protected void a(String paramString, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageManager_At_Me_DISC", 2, "afterCleanUnRead:" + paramString + "-" + paramInt + "-" + paramLong);
    }
    super.a(paramString, paramInt, paramLong);
    c(paramString, paramInt, paramLong);
  }
  
  protected String b(String paramString1, String paramString2)
  {
    return a(paramString1, paramString2);
  }
  
  public void b(String paramString, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageManager_At_Me_DISC", 2, "afterCleanUnRead:" + paramString + "-" + paramInt + "-" + paramLong);
    }
    if (this.a.a().a(paramString, paramInt) > 0) {
      c(paramString, paramInt, paramLong);
    }
    super.b(paramString, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akph
 * JD-Core Version:    0.7.0.1
 */