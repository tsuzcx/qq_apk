import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.SystemClock;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.Conversation.34.1;
import com.tencent.mobileqq.activity.Conversation.34.2;
import com.tencent.mobileqq.activity.Conversation.34.3;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class aeig
  extends aocj
{
  public aeig(Conversation paramConversation) {}
  
  protected void a(int paramInt)
  {
    this.a.a(new Conversation.34.3(this, paramInt));
  }
  
  protected void a(String paramString1, int paramInt1, int paramInt2, SendMessageHandler paramSendMessageHandler, long paramLong1, long paramLong2, String paramString2)
  {
    paramString1 = alni.a(paramString1, -2147483648);
    this.a.a(2, 9, paramString1);
  }
  
  protected void a(boolean paramBoolean, String paramString, long paramLong)
  {
    paramString = alni.a(paramString, -2147483648);
    this.a.a(2, 9, paramString);
  }
  
  protected void a(boolean paramBoolean, String paramString, long paramLong, aocg paramaocg)
  {
    a(paramBoolean, paramString, paramLong);
  }
  
  public void a(boolean paramBoolean, String paramString, bdxd parambdxd)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("SUB_ACCOUNT", 2, "Conversation.onPushSubAccountMsgNotify() isSuccess=" + paramBoolean + " subAccount=" + paramString);
      if (parambdxd != null) {
        QLog.d("SUB_ACCOUNT", 2, "Conversation.onPushSubAccountMsgNotify() mainAccount=" + parambdxd.jdField_b_of_type_JavaLangString + " subAccount=" + parambdxd.jdField_c_of_type_JavaLangString + " data.errorType=" + parambdxd.jdField_a_of_type_Int + " errorMsg=" + parambdxd.jdField_a_of_type_JavaLangString + " isNeedStartGetMsg=" + parambdxd.jdField_b_of_type_Boolean);
      }
    }
    if ((!paramBoolean) || (parambdxd == null)) {
      return;
    }
    if (parambdxd.jdField_a_of_type_Int == 0)
    {
      bdwt.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, 1);
      parambdxd = (bdwt)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(62);
      if (parambdxd != null) {
        parambdxd.a(paramString, 1, true);
      }
    }
    for (;;)
    {
      this.a.a(0L);
      return;
      if (parambdxd.jdField_a_of_type_Int == 1)
      {
        bdwt.c(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
        Conversation.o(this.a);
      }
    }
  }
  
  public void a(boolean paramBoolean, String paramString, bdxe parambdxe)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("SUB_ACCOUNT", 2, "onSubAccountThirdQQUnreadMsgNum.isSuccess=" + paramBoolean + "  subAccount=" + paramString);
      if (parambdxe != null) {
        QLog.d("SUB_ACCOUNT", 2, "onSubAccountThirdQQUnreadMsgNum.data=" + parambdxe);
      }
    }
    if ((this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (!this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isRunning())) {}
    int i;
    do
    {
      do
      {
        return;
      } while ((!paramBoolean) || (parambdxe == null) || (parambdxe.d == 0));
      i = bdwt.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    } while ((parambdxe.d <= i) || (bdwt.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()) > 0));
    bdwt.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, parambdxe.d);
    if ((RecentUser)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().findRecentUser(antf.x, 7000) == null) {
      bdwt.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, antf.x, 7);
    }
    for (;;)
    {
      this.a.a(0L);
      return;
      bdwt.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, antf.x, 6);
    }
  }
  
  public void a(boolean paramBoolean1, List<MessageRecord> paramList, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.troop.revoked_troop_msg", 2, "onMsgRevokeNotice, isSuccess:" + paramBoolean1);
    }
    if (!paramBoolean1) {
      return;
    }
    MessageRecord localMessageRecord;
    bgiw localbgiw;
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      localMessageRecord = (MessageRecord)paramList.get(0);
      localbgiw = (bgiw)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(363);
      switch (localMessageRecord.istroop)
      {
      }
    }
    for (;;)
    {
      super.a(paramBoolean1, paramList, paramBoolean2);
      return;
      if (localbgiw.a(localMessageRecord.frienduin) != -1)
      {
        ((bftl)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageRecord.istroop)).a(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.shmsgseq);
        this.a.a(8, localMessageRecord.frienduin, localMessageRecord.istroop);
        continue;
        if (localbgiw.a(localMessageRecord.frienduin + "&" + 3000) != -1)
        {
          ((aosh)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageRecord.istroop)).a(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.shmsgseq);
          this.a.a(8, localMessageRecord.frienduin, localMessageRecord.istroop);
        }
      }
    }
  }
  
  protected void b()
  {
    axan.a().c(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, "refresh recent, from_onupdaterecentlist");
    }
    this.a.a(0L);
  }
  
  public void b(boolean paramBoolean, String paramString, bdxd parambdxd)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("SUB_ACCOUNT", 2, "onGetSubAccountMsgNotify.isSuccess=" + paramBoolean + "  subAccount=" + paramString);
      if (parambdxd != null) {
        QLog.d("SUB_ACCOUNT", 2, "onGetSubAccountMsgNotify.data.errorType=" + parambdxd.jdField_a_of_type_Int + " errorMsg=" + parambdxd.jdField_a_of_type_JavaLangString + " mainAccount=" + parambdxd.jdField_b_of_type_JavaLangString + "  subAccount=" + parambdxd.jdField_c_of_type_JavaLangString + " isNeedStartGetMsg=" + parambdxd.jdField_b_of_type_Boolean);
      }
    }
    if (parambdxd != null) {
      switch (parambdxd.jdField_a_of_type_Int)
      {
      default: 
        if ((parambdxd.jdField_c_of_type_Boolean) && (!parambdxd.d) && (parambdxd.jdField_c_of_type_JavaLangString != null) && (parambdxd.jdField_c_of_type_JavaLangString.length() > 4))
        {
          bdwt.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, 6);
          parambdxd.d = true;
        }
        break;
      }
    }
    for (;;)
    {
      this.a.a(0L);
      return;
      bdwt.c(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
      continue;
      bdwt.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
    }
  }
  
  protected void c()
  {
    this.a.a(0L);
  }
  
  public void c(boolean paramBoolean, String paramString)
  {
    this.a.a(8, paramString, -2147483648);
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, "refresh recent, onBoxMsgUnreadNumRefresh");
    }
    this.a.a(0L);
  }
  
  protected void d(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "onGetOfflineMsgFinished|isSuc = " + paramBoolean);
    }
    if (this.a.c > 0L) {
      bhsq.a("Conversation_PullToRefresh_msgCB", SystemClock.uptimeMillis() - this.a.c);
    }
    if (this.a.jdField_a_of_type_Long != 1000L) {
      this.a.jdField_a_of_type_Long = 1000L;
    }
    this.a.a(new Conversation.34.1(this, paramBoolean));
    Object localObject = (PublicAccountHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(11);
    if (localObject != null)
    {
      SharedPreferences localSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences("public_account_weather", 0);
      long l = localSharedPreferences.getLong("fresh_weather_time", 0L);
      l = System.currentTimeMillis() - l;
      if ((l > 86400000L) || (l < 0L))
      {
        ((PublicAccountHandler)localObject).a(-1, 0, 0, 0);
        localObject = localSharedPreferences.edit();
        ((SharedPreferences.Editor)localObject).putLong("fresh_weather_time", System.currentTimeMillis());
        ((SharedPreferences.Editor)localObject).commit();
      }
    }
  }
  
  protected void e(boolean paramBoolean)
  {
    this.a.a(new Conversation.34.2(this, paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeig
 * JD-Core Version:    0.7.0.1
 */