import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.DiscussChatPie.8.2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class aeol
  extends akav
{
  aeol(aeoe paramaeoe) {}
  
  private void d(String paramString)
  {
    try
    {
      if (!this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing()) {
        bbcv.a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 230, ajyc.a(2131703332), this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131719249), new aeon(this, paramString), null).show();
      }
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e(this.a.jdField_a_of_type_JavaLangString, 1, "ERR!! send_discussion_msg_failed_not_member:" + paramString.getMessage());
    }
  }
  
  protected void a(String paramString1, int paramInt1, int paramInt2, SendMessageHandler paramSendMessageHandler, long paramLong1, long paramLong2, String paramString2)
  {
    if ((paramString1 == null) || (!paramString1.equals(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) || (paramInt1 != this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "onUpdateSendMsgError exception uin " + paramString1 + " type " + paramInt1 + " uniseq " + paramLong2);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "onUpdateSendMsgError uin " + paramString1 + " type " + paramInt1 + " uniseq " + paramLong2);
    }
    if ((paramInt1 == 1) || (paramInt1 == 3000) || (paramInt1 == 0))
    {
      paramSendMessageHandler = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1, paramInt1, paramLong2);
      if ((paramSendMessageHandler != null) && ((paramSendMessageHandler instanceof MessageForStructing)) && ("viewMultiMsg".equals(((MessageForStructing)paramSendMessageHandler).structingMsg.mMsgAction))) {
        asty.a().a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, paramInt1, paramLong2, false);
      }
    }
    if (paramInt1 == 3000) {
      switch (paramInt2)
      {
      default: 
        if (paramInt2 > 100) {
          bcpw.a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramString2, 0).b(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
        }
        break;
      }
    }
    for (;;)
    {
      this.a.e(196608);
      return;
      bcpw.a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2131719247, 1).b(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
      continue;
      bcpw.a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2131719250, 1).b(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
      continue;
      bbcv.a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 230, ajyc.a(2131703331), this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131691882), new aeom(this, paramString1), null).show();
      continue;
      if (Looper.myLooper() != Looper.getMainLooper()) {
        this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.runOnUiThread(new DiscussChatPie.8.2(this, paramString1));
      } else {
        d(paramString1);
      }
    }
  }
  
  protected void a(boolean paramBoolean, String paramString, long paramLong)
  {
    a(paramBoolean, paramString, paramLong, null);
  }
  
  protected void a(boolean paramBoolean, String paramString, long paramLong, akas paramakas)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    while (!paramString.equals(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      return;
    }
    this.a.u = true;
    this.a.a(262144, paramakas, paramLong);
  }
  
  public void a(boolean paramBoolean1, List<MessageRecord> paramList, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "onMsgRevokeNotice:" + paramBoolean1);
    }
    if (!paramBoolean1) {
      return;
    }
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      Object localObject = (MessageRecord)paramList.get(0);
      if (this.a.jdField_a_of_type_Aznm != null)
      {
        int i = this.a.jdField_a_of_type_Aznm.b();
        if (i != -1)
        {
          askq localaskq = (askq)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(37);
          long l = localaskq.b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + "&" + 3000);
          if (((MessageRecord)localObject).uniseq == l)
          {
            localaskq.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + "&" + 3000, i);
            this.a.jdField_a_of_type_Aznm.a(i);
            this.a.jdField_a_of_type_Aznm.e();
          }
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder("onMsgRevokeNotice==>");
            ((StringBuilder)localObject).append("navigateType:").append(i).append("|navigaeSeq:").append(l);
            QLog.d(this.a.jdField_a_of_type_JavaLangString + ".troop.special_msg", 2, ((StringBuilder)localObject).toString());
          }
        }
      }
    }
    super.a(paramBoolean1, paramList, paramBoolean2);
  }
  
  public void b(String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("MsgSend", 4, "delay 100ms, starting upadte ui");
    }
    this.a.e(131072);
  }
  
  protected void c(boolean paramBoolean, String paramString)
  {
    this.a.e(65536);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeol
 * JD-Core Version:    0.7.0.1
 */