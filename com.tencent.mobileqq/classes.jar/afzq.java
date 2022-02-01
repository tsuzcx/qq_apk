import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class afzq
  extends anyz
{
  protected SessionInfo a;
  protected BaseChatPie a;
  public QQAppInterface a;
  
  public afzq(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseChatPie.app;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramBaseChatPie.sessionInfo;
  }
  
  public void onMsgRevokeNotice(boolean paramBoolean1, List<MessageRecord> paramList, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseTroopMsgObserver.troop.revoked_troop_msg", 2, "isSuccess:" + paramBoolean1);
    }
    if (!paramBoolean1) {
      return;
    }
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      Object localObject = (MessageRecord)paramList.get(0);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mTroopTips != null)
      {
        int i = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mTroopTips.b();
        if (i != -1)
        {
          bfzk localbfzk = (bfzk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_AIO_NAVIGATE_BAR);
          long l = localbfzk.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin);
          if (((MessageRecord)localObject).uniseq == l) {
            localbfzk.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, i);
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mTroopTips.a(((MessageRecord)localObject).uniseq);
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder("onMsgRevokeNotice==>");
            ((StringBuilder)localObject).append("navigateType:").append(i).append("|navigaeSeq:").append(l);
            QLog.d("BaseTroopMsgObserver.troop.special_msg", 2, ((StringBuilder)localObject).toString());
          }
        }
      }
    }
    super.onMsgRevokeNotice(paramBoolean1, paramList, paramBoolean2);
  }
  
  public void onMsgStartSendingUI(String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("MsgSend", 4, "delay 100ms, starting upadte ui");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.refresh(131072);
  }
  
  protected void onSendResult(boolean paramBoolean, String paramString, long paramLong)
  {
    onSendResult(paramBoolean, paramString, paramLong, null);
  }
  
  protected void onSendResult(boolean paramBoolean, String paramString, long paramLong, anyt paramanyt)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    while (!paramString.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.hasSentRecvMsg = true;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.refresh(262144, paramanyt, paramLong);
  }
  
  protected void onUpdateMsgContent(boolean paramBoolean, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.refresh(65536);
  }
  
  protected void onUpdateSendMsgError(String paramString1, int paramInt1, int paramInt2, SendMessageHandler paramSendMessageHandler, long paramLong1, long paramLong2, String paramString2)
  {
    if ((paramString1 == null) || (!paramString1.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin)) || (paramInt1 != this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType))
    {
      if (QLog.isColorLevel()) {
        QLog.d("BaseTroopMsgObserver", 2, "onUpdateSendMsgError exception uin " + paramString1 + " type " + paramInt1 + " uniseq " + paramLong2);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("BaseTroopMsgObserver", 2, "onUpdateSendMsgError uin " + paramString1 + " type " + paramInt1 + " uniseq " + paramLong2);
    }
    paramSendMessageHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHotChatMng(true);
    if ((paramSendMessageHandler.b(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      anwf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramSendMessageHandler.a(paramString1), paramString2, true);
      if ((paramInt2 == 112) || (paramInt2 == 113))
      {
        anwq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, 6);
        anwq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.refresh(196608);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afzq
 * JD-Core Version:    0.7.0.1
 */