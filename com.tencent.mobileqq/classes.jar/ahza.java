import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class ahza
  extends anyz
{
  ahza(ahyl paramahyl) {}
  
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
  
  protected void onRemoveFromBlackList(boolean paramBoolean, String paramString)
  {
    if ((paramString != null) && (this.a.sessionInfo.curFriendUin != null) && (this.a.sessionInfo.curFriendUin.equals(paramString)))
    {
      ChatActivityUtils.b();
      if (paramBoolean) {
        this.a.updateAddFriendAndShieldView();
      }
    }
  }
  
  protected void onSendResult(boolean paramBoolean, String paramString, long paramLong)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    while (!paramString.equals(this.a.sessionInfo.curFriendUin)) {
      return;
    }
    this.a.hasSentRecvMsg = true;
    this.a.refresh(262144, null, paramLong);
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
        QLog.d("BusinessChatPie", 2, "onUpdateSendMsgError exception uin " + paramString1 + " type " + paramInt1 + " uniseq " + paramLong2);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("BusinessChatPie", 2, "onUpdateSendMsgError uin " + paramString1 + " type " + paramInt1 + " uniseq " + paramLong2);
    }
    if ((QLog.isColorLevel()) && (paramInt1 == 1024)) {
      QQToast.a(this.a.mActivity, "errorCode" + paramInt2, 0).b(this.a.mActivity.getTitleBarHeight());
    }
    this.a.refresh(196608);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahza
 * JD-Core Version:    0.7.0.1
 */