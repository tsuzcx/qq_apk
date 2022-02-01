import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.DiscussChatPie.8.2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class afit
  extends amwl
{
  afit(afim paramafim) {}
  
  private void a(String paramString)
  {
    try
    {
      if (!this.a.mActivity.isFinishing()) {
        bfur.a(this.a.mActivity, 230, amtj.a(2131702466), this.a.mActivity.getString(2131718113), new afiv(this, paramString), null).show();
      }
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e(this.a.tag, 1, "ERR!! send_discussion_msg_failed_not_member:" + paramString.getMessage());
    }
  }
  
  public void onMsgRevokeNotice(boolean paramBoolean1, List<MessageRecord> paramList, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.tag, 2, "onMsgRevokeNotice:" + paramBoolean1);
    }
    if (!paramBoolean1) {
      return;
    }
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      Object localObject = (MessageRecord)paramList.get(0);
      if (this.a.mTroopTips != null)
      {
        int i = this.a.mTroopTips.b();
        if (i != -1)
        {
          bese localbese = (bese)this.a.app.getManager(363);
          long l = localbese.a(this.a.sessionInfo.curFriendUin + "&" + 3000);
          if (((MessageRecord)localObject).uniseq == l)
          {
            localbese.a(this.a.sessionInfo.curFriendUin + "&" + 3000, i);
            this.a.mTroopTips.a(i);
            this.a.mTroopTips.e();
          }
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder("onMsgRevokeNotice==>");
            ((StringBuilder)localObject).append("navigateType:").append(i).append("|navigaeSeq:").append(l);
            QLog.d(this.a.tag + ".troop.special_msg", 2, ((StringBuilder)localObject).toString());
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
    this.a.refresh(131072);
  }
  
  protected void onSendResult(boolean paramBoolean, String paramString, long paramLong)
  {
    onSendResult(paramBoolean, paramString, paramLong, null);
  }
  
  protected void onSendResult(boolean paramBoolean, String paramString, long paramLong, amwf paramamwf)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    while (!paramString.equals(this.a.sessionInfo.curFriendUin)) {
      return;
    }
    this.a.hasSentRecvMsg = true;
    this.a.refresh(262144, paramamwf, paramLong);
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
      QLog.d(this.a.tag, 2, "onUpdateSendMsgError uin " + paramString1 + " type " + paramInt1 + " uniseq " + paramLong2);
    }
    if ((paramInt1 == 1) || (paramInt1 == 3000) || (paramInt1 == 0))
    {
      paramSendMessageHandler = this.a.app.getMessageFacade().getMsgItemByUniseq(paramString1, paramInt1, paramLong2);
      if ((paramSendMessageHandler != null) && ((paramSendMessageHandler instanceof MessageForStructing)) && ("viewMultiMsg".equals(((MessageForStructing)paramSendMessageHandler).structingMsg.mMsgAction))) {
        awcm.a().a(this.a.app, paramString1, paramInt1, paramLong2, false);
      }
    }
    if (paramInt1 == 3000) {
      switch (paramInt2)
      {
      default: 
        if (paramInt2 > 100) {
          QQToast.a(this.a.mActivity, paramString2, 0).b(this.a.mActivity.getTitleBarHeight());
        }
        break;
      }
    }
    for (;;)
    {
      this.a.refresh(196608);
      return;
      QQToast.a(this.a.mActivity, 2131718112, 1).b(this.a.mActivity.getTitleBarHeight());
      continue;
      QQToast.a(this.a.mActivity, 2131718114, 1).b(this.a.mActivity.getTitleBarHeight());
      continue;
      bfur.a(this.a.mActivity, 230, amtj.a(2131702465), this.a.mActivity.getString(2131691671), new afiu(this, paramString1), null).show();
      continue;
      if (Looper.myLooper() != Looper.getMainLooper()) {
        this.a.mActivity.runOnUiThread(new DiscussChatPie.8.2(this, paramString1));
      } else {
        a(paramString1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afit
 * JD-Core Version:    0.7.0.1
 */