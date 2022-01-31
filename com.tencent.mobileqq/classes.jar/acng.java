import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.SystemClock;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.Conversation.31.1;
import com.tencent.mobileqq.activity.Conversation.31.2;
import com.tencent.mobileqq.activity.Conversation.31.3;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class acng
  extends alsi
{
  public acng(Conversation paramConversation) {}
  
  protected void a(int paramInt)
  {
    this.a.a(new Conversation.31.3(this, paramInt));
  }
  
  protected void a(String paramString1, int paramInt1, int paramInt2, SendMessageHandler paramSendMessageHandler, long paramLong1, long paramLong2, String paramString2)
  {
    paramString1 = ajeu.a(paramString1, -2147483648);
    this.a.a(2, 9, paramString1);
  }
  
  protected void a(boolean paramBoolean, String paramString, long paramLong)
  {
    paramString = ajeu.a(paramString, -2147483648);
    this.a.a(2, 9, paramString);
  }
  
  protected void a(boolean paramBoolean, String paramString, long paramLong, alsf paramalsf)
  {
    a(paramBoolean, paramString, paramLong);
  }
  
  public void a(boolean paramBoolean, String paramString, azyv paramazyv)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("SUB_ACCOUNT", 2, "Conversation.onPushSubAccountMsgNotify() isSuccess=" + paramBoolean + " subAccount=" + paramString);
      if (paramazyv != null) {
        QLog.d("SUB_ACCOUNT", 2, "Conversation.onPushSubAccountMsgNotify() mainAccount=" + paramazyv.jdField_b_of_type_JavaLangString + " subAccount=" + paramazyv.jdField_c_of_type_JavaLangString + " data.errorType=" + paramazyv.jdField_a_of_type_Int + " errorMsg=" + paramazyv.jdField_a_of_type_JavaLangString + " isNeedStartGetMsg=" + paramazyv.jdField_b_of_type_Boolean);
      }
    }
    if ((!paramBoolean) || (paramazyv == null)) {
      return;
    }
    if (paramazyv.jdField_a_of_type_Int == 0)
    {
      azyl.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, 1);
      paramazyv = (azyl)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(62);
      if (paramazyv != null) {
        paramazyv.a(paramString, 1, true);
      }
    }
    for (;;)
    {
      this.a.a(0L);
      return;
      if (paramazyv.jdField_a_of_type_Int == 1)
      {
        azyl.c(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
        Conversation.j(this.a);
      }
    }
  }
  
  public void a(boolean paramBoolean, String paramString, azyw paramazyw)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("SUB_ACCOUNT", 2, "onSubAccountThirdQQUnreadMsgNum.isSuccess=" + paramBoolean + "  subAccount=" + paramString);
      if (paramazyw != null) {
        QLog.d("SUB_ACCOUNT", 2, "onSubAccountThirdQQUnreadMsgNum.data=" + paramazyw);
      }
    }
    if ((this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (!this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isRunning())) {}
    int i;
    do
    {
      do
      {
        return;
      } while ((!paramBoolean) || (paramazyw == null) || (paramazyw.d == 0));
      i = azyl.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    } while ((paramazyw.d <= i) || (azyl.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()) > 0));
    azyl.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramazyw.d);
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().b(aljq.x, 7000) == null) {
      azyl.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, aljq.x, 7);
    }
    for (;;)
    {
      this.a.a(0L);
      return;
      azyl.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, aljq.x, 6);
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
    aubr localaubr;
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      localMessageRecord = (MessageRecord)paramList.get(0);
      localaubr = (aubr)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(37);
      switch (localMessageRecord.istroop)
      {
      }
    }
    for (;;)
    {
      super.a(paramBoolean1, paramList, paramBoolean2);
      return;
      if (localaubr.a(localMessageRecord.frienduin) != -1)
      {
        ((bbpk)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageRecord.istroop)).a(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.shmsgseq);
        this.a.a(8, localMessageRecord.frienduin, localMessageRecord.istroop);
        continue;
        if (localaubr.a(localMessageRecord.frienduin + "&" + 3000) != -1)
        {
          ((amga)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageRecord.istroop)).a(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.shmsgseq);
          this.a.a(8, localMessageRecord.frienduin, localMessageRecord.istroop);
        }
      }
    }
  }
  
  protected void b()
  {
    atwd.a().c(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, "refresh recent, from_onupdaterecentlist");
    }
    this.a.a(0L);
  }
  
  public void b(boolean paramBoolean, String paramString, azyv paramazyv)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("SUB_ACCOUNT", 2, "onGetSubAccountMsgNotify.isSuccess=" + paramBoolean + "  subAccount=" + paramString);
      if (paramazyv != null) {
        QLog.d("SUB_ACCOUNT", 2, "onGetSubAccountMsgNotify.data.errorType=" + paramazyv.jdField_a_of_type_Int + " errorMsg=" + paramazyv.jdField_a_of_type_JavaLangString + " mainAccount=" + paramazyv.jdField_b_of_type_JavaLangString + "  subAccount=" + paramazyv.jdField_c_of_type_JavaLangString + " isNeedStartGetMsg=" + paramazyv.jdField_b_of_type_Boolean);
      }
    }
    if (paramazyv != null) {
      switch (paramazyv.jdField_a_of_type_Int)
      {
      default: 
        if ((paramazyv.jdField_c_of_type_Boolean) && (!paramazyv.d) && (paramazyv.jdField_c_of_type_JavaLangString != null) && (paramazyv.jdField_c_of_type_JavaLangString.length() > 4))
        {
          azyl.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, 6);
          paramazyv.d = true;
        }
        break;
      }
    }
    for (;;)
    {
      this.a.a(0L);
      return;
      azyl.c(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
      continue;
      azyl.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
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
      bdjd.a("Conversation_PullToRefresh_msgCB", SystemClock.uptimeMillis() - this.a.c);
    }
    if (this.a.jdField_a_of_type_Long != 1000L) {
      this.a.jdField_a_of_type_Long = 1000L;
    }
    this.a.a(new Conversation.31.1(this, paramBoolean));
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
    this.a.a(new Conversation.31.2(this, paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acng
 * JD-Core Version:    0.7.0.1
 */