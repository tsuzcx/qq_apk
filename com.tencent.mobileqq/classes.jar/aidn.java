import android.content.Intent;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPieObserver.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class aidn
  extends anyz
{
  private aidd a;
  
  aidn(aidd paramaidd)
  {
    this.a = paramaidd;
  }
  
  private void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    QQToast.a(this.a.mActivity, this.a.mActivity.getString(2131718142), 0).b(this.a.mActivity.getTitleBarHeight());
  }
  
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
    if (this.a.c)
    {
      paramString = new Message();
      paramString.what = 39;
      paramString.obj = this.a.d;
      this.a.getUIHandler().removeMessages(39);
      this.a.getUIHandler().sendMessage(paramString);
    }
    ThreadManagerV2.excute(new NearbyChatPieObserver.1(this, paramBoolean, this.a.mActivity.getIntent().getStringExtra("NEARBY_MSG_REPORT_SOURCE"), (axny)this.a.app.getManager(QQManagerFactory.NEARBY_CARD_MANAGER)), 16, null, false);
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
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.a.tag, 2, "onUpdateSendMsgError uin " + paramString1 + " type " + paramInt1 + " uniseq " + paramLong2 + " errorCode " + paramInt2);
    }
    if (paramInt1 == 1009) {
      a(paramInt2);
    }
    this.a.refresh(196608);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aidn
 * JD-Core Version:    0.7.0.1
 */