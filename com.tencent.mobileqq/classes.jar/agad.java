import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.FriendChatPie.11.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class agad
  extends anyz
{
  agad(agab paramagab) {}
  
  protected void onInsertIntoBlackList(boolean paramBoolean, String paramString)
  {
    if ((paramString != null) && (this.a.sessionInfo.curFriendUin != null) && (this.a.sessionInfo.curFriendUin.equals(paramString)))
    {
      ChatActivityUtils.b();
      if (paramBoolean) {
        this.a.updateAddFriendAndShieldView();
      }
    }
  }
  
  public void onMsgStartSendingUI(String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("MsgSend", 4, "delay 100ms, starting upadte ui");
    }
    this.a.refresh(131072);
  }
  
  protected void onRemoveFromBlackList(boolean paramBoolean, String paramString)
  {
    if ((paramString != null) && (this.a.sessionInfo.curFriendUin != null) && (this.a.sessionInfo.curFriendUin.equals(paramString)))
    {
      ChatActivityUtils.b();
      if (paramBoolean) {
        this.a.uiHandler.post(new FriendChatPie.11.1(this));
      }
    }
  }
  
  protected void onSendResult(boolean paramBoolean, String paramString, long paramLong)
  {
    onSendResult(paramBoolean, paramString, paramLong, null);
  }
  
  protected void onSendResult(boolean paramBoolean, String paramString, long paramLong, anyt paramanyt)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    while (!paramString.equals(this.a.sessionInfo.curFriendUin)) {
      return;
    }
    this.a.hasSentRecvMsg = true;
    this.a.refresh(262144, paramanyt, paramLong);
    ((awtn)this.a.app.getManager(QQManagerFactory.PUSH_NOTIFICATION_MANAGER)).a(this.a.sessionInfo, awtn.a);
  }
  
  protected void onUpdateMsgContent(boolean paramBoolean, String paramString)
  {
    this.a.refresh(65536);
  }
  
  protected void onUpdateSendMsgError(String paramString1, int paramInt1, int paramInt2, SendMessageHandler paramSendMessageHandler, long paramLong1, long paramLong2, String paramString2)
  {
    if ((paramString1 == null) || (!paramString1.equals(this.a.sessionInfo.curFriendUin)) || (paramInt1 != this.a.sessionInfo.curType))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.a.tag, 2, "onUpdateSendMsgError exception uin " + paramString1 + " type " + paramInt1 + " uniseq " + paramLong2);
      }
      paramString1 = this.a.app.getMessageFacade().getMsgItemByUniseq(paramString1, paramInt1, paramLong2);
      if ((paramString1 != null) && (paramString1.msgtype == -2058) && ((paramString1.extraflag == 32768) || (paramString1.sendFailCode == 41)))
      {
        if (QLog.isColorLevel()) {
          QLog.i(this.a.tag, 2, "onUpdateSendMsgError, sticker msg is failed!, now remove!");
        }
        this.a.app.getMessageFacade().removeMsgByMessageRecord(paramString1, false);
      }
      return;
    }
    agab.a(this.a, paramString1, paramInt1, paramLong2);
    this.a.refresh(196608);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agad
 * JD-Core Version:    0.7.0.1
 */