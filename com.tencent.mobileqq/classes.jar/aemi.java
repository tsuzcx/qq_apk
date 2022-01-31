import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class aemi
  extends akav
{
  public aemi(aemf paramaemf) {}
  
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
    paramSendMessageHandler = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(true);
    if ((paramSendMessageHandler.b(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      ajyk.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramSendMessageHandler.a(paramString1), paramString2, true);
      if ((paramInt2 == 112) || (paramInt2 == 113))
      {
        ajyu.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, 6);
        ajyu.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
    }
    this.a.e(196608);
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
      QLog.d(this.a.jdField_a_of_type_JavaLangString + ".troop.revoked_troop_msg", 2, "isSuccess:" + paramBoolean1);
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
          long l = localaskq.b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          if (((MessageRecord)localObject).uniseq == l) {
            localaskq.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, i);
          }
          this.a.jdField_a_of_type_Aznm.a(((MessageRecord)localObject).uniseq);
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
 * Qualified Name:     aemi
 * JD-Core Version:    0.7.0.1
 */