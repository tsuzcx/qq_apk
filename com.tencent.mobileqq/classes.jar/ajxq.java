import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.SystemClock;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.home.Conversation.35.1;
import com.tencent.mobileqq.activity.home.Conversation.35.2;
import com.tencent.mobileqq.activity.home.Conversation.35.3;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class ajxq
  extends anyz
{
  public ajxq(Conversation paramConversation) {}
  
  public void onBoxMsgUnreadNumRefresh()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, "refresh recent, onBoxMsgUnreadNumRefresh");
    }
    this.a.a(0L);
  }
  
  protected void onGetOfflineMsgFinished(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "onGetOfflineMsgFinished|isSuc = " + paramBoolean);
    }
    if (this.a.c > 0L) {
      bhhy.a("Conversation_PullToRefresh_msgCB", SystemClock.uptimeMillis() - this.a.c);
    }
    if (this.a.jdField_a_of_type_Long != 1000L) {
      this.a.jdField_a_of_type_Long = 1000L;
    }
    this.a.b(new Conversation.35.1(this, paramBoolean));
    Object localObject = (PublicAccountHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.HANDLER_PUBLIC_ACCOUNT);
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
  
  public void onGetSubAccountMsg(boolean paramBoolean, String paramString, bdxt parambdxt)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("SUB_ACCOUNT", 2, "onGetSubAccountMsgNotify.isSuccess=" + paramBoolean + "  subAccount=" + paramString);
      if (parambdxt != null) {
        QLog.d("SUB_ACCOUNT", 2, "onGetSubAccountMsgNotify.data.errorType=" + parambdxt.jdField_a_of_type_Int + " errorMsg=" + parambdxt.jdField_a_of_type_JavaLangString + " mainAccount=" + parambdxt.jdField_b_of_type_JavaLangString + "  subAccount=" + parambdxt.jdField_c_of_type_JavaLangString + " isNeedStartGetMsg=" + parambdxt.jdField_b_of_type_Boolean);
      }
    }
    if (parambdxt != null) {
      switch (parambdxt.jdField_a_of_type_Int)
      {
      default: 
        if ((parambdxt.jdField_c_of_type_Boolean) && (!parambdxt.d) && (parambdxt.jdField_c_of_type_JavaLangString != null) && (parambdxt.jdField_c_of_type_JavaLangString.length() > 4))
        {
          bdxj.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, 6);
          parambdxt.d = true;
        }
        break;
      }
    }
    for (;;)
    {
      this.a.a(0L);
      return;
      bdxj.c(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
      continue;
      bdxj.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
    }
  }
  
  public void onMsgRevokeNotice(boolean paramBoolean1, List<MessageRecord> paramList, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.troop.revoked_troop_msg", 2, "onMsgRevokeNotice, isSuccess:" + paramBoolean1);
    }
    if (!paramBoolean1) {
      return;
    }
    MessageRecord localMessageRecord;
    bfzk localbfzk;
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      localMessageRecord = (MessageRecord)paramList.get(0);
      localbfzk = (bfzk)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_AIO_NAVIGATE_BAR);
      switch (localMessageRecord.istroop)
      {
      }
    }
    for (;;)
    {
      super.onMsgRevokeNotice(paramBoolean1, paramList, paramBoolean2);
      return;
      if (localbfzk.a(localMessageRecord.frienduin) != -1)
      {
        ((bfjz)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getBaseMessageManager(localMessageRecord.istroop)).a(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.shmsgseq);
        this.a.a(8, localMessageRecord.frienduin, localMessageRecord.istroop);
        continue;
        if (localbfzk.a(localMessageRecord.frienduin + "&" + 3000) != -1)
        {
          ((aonv)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getBaseMessageManager(localMessageRecord.istroop)).a(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.shmsgseq);
          this.a.a(8, localMessageRecord.frienduin, localMessageRecord.istroop);
        }
      }
    }
  }
  
  public void onPushSubAccountMsg(boolean paramBoolean, String paramString, bdxt parambdxt)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("SUB_ACCOUNT", 2, "Conversation.onPushSubAccountMsgNotify() isSuccess=" + paramBoolean + " subAccount=" + paramString);
      if (parambdxt != null) {
        QLog.d("SUB_ACCOUNT", 2, "Conversation.onPushSubAccountMsgNotify() mainAccount=" + parambdxt.jdField_b_of_type_JavaLangString + " subAccount=" + parambdxt.jdField_c_of_type_JavaLangString + " data.errorType=" + parambdxt.jdField_a_of_type_Int + " errorMsg=" + parambdxt.jdField_a_of_type_JavaLangString + " isNeedStartGetMsg=" + parambdxt.jdField_b_of_type_Boolean);
      }
    }
    if ((!paramBoolean) || (parambdxt == null)) {
      return;
    }
    if (parambdxt.jdField_a_of_type_Int == 0)
    {
      bdxj.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, 1);
      parambdxt = (bdxj)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.SUB_ACCOUNT_CONTROLL);
      if (parambdxt != null) {
        parambdxt.a(paramString, 1, true);
      }
    }
    for (;;)
    {
      this.a.a(0L);
      return;
      if (parambdxt.jdField_a_of_type_Int == 1)
      {
        bdxj.c(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
        Conversation.n(this.a);
      }
    }
  }
  
  protected void onPushUpdateLoginDevStatusNotify(int paramInt)
  {
    this.a.b(new Conversation.35.3(this, paramInt));
  }
  
  protected void onRefleshRecentListFinished(boolean paramBoolean)
  {
    this.a.b(new Conversation.35.2(this, paramBoolean));
  }
  
  protected void onSendResult(boolean paramBoolean, String paramString, long paramLong)
  {
    paramString = algs.a(paramString, -2147483648);
    this.a.a(2, 9, paramString);
  }
  
  protected void onSendResult(boolean paramBoolean, String paramString, long paramLong, anyt paramanyt)
  {
    onSendResult(paramBoolean, paramString, paramLong);
  }
  
  public void onSubAccountThirdQQUnreadMsgNum(boolean paramBoolean, String paramString, bdxu parambdxu)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("SUB_ACCOUNT", 2, "onSubAccountThirdQQUnreadMsgNum.isSuccess=" + paramBoolean + "  subAccount=" + paramString);
      if (parambdxu != null) {
        QLog.d("SUB_ACCOUNT", 2, "onSubAccountThirdQQUnreadMsgNum.data=" + parambdxu);
      }
    }
    if ((this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (!this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isRunning())) {}
    int i;
    do
    {
      do
      {
        return;
      } while ((!paramBoolean) || (parambdxu == null) || (parambdxu.d == 0));
      i = bdxj.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    } while ((parambdxu.d <= i) || (bdxj.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade()) > 0));
    bdxj.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, parambdxu.d);
    if ((RecentUser)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a().findRecentUser(AppConstants.SUBACCOUNT_ASSISTANT_UIN, 7000) == null) {
      bdxj.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, AppConstants.SUBACCOUNT_ASSISTANT_UIN, 7);
    }
    for (;;)
    {
      this.a.a(0L);
      return;
      bdxj.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, AppConstants.SUBACCOUNT_ASSISTANT_UIN, 6);
    }
  }
  
  public void onUpdateMsgContent(boolean paramBoolean, String paramString)
  {
    this.a.a(8, paramString, -2147483648);
  }
  
  protected void onUpdateRecentList()
  {
    awtz.a().c(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, "refresh recent, from_onupdaterecentlist");
    }
    this.a.a(0L);
  }
  
  protected void onUpdateSecretfileStatus()
  {
    this.a.a(0L);
  }
  
  protected void onUpdateSendMsgError(String paramString1, int paramInt1, int paramInt2, SendMessageHandler paramSendMessageHandler, long paramLong1, long paramLong2, String paramString2)
  {
    paramString1 = algs.a(paramString1, -2147483648);
    this.a.a(2, 9, paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajxq
 * JD-Core Version:    0.7.0.1
 */