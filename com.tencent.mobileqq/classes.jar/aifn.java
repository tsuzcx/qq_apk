import android.text.TextUtils;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import msf.msgsvc.msg_svc.TransSvrInfo;
import qqcircle.QQCirclePrivateMsgAIO.PrivateMsgTransSvrInfo;

class aifn
  extends anyz
{
  aifn(aifl paramaifl) {}
  
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
  
  public void onMessageRecordAdded(List<MessageRecord> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = (MessageRecord)paramList.get(0);
      if ((!paramList.isSendFromLocal()) && (!(paramList instanceof MessageForUniteGrayTip)) && (paramList.frienduin != null) && (paramList.frienduin.equals(this.a.sessionInfo.curFriendUin)))
      {
        aifl.a(this.a);
        aifl.a(this.a, paramList);
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
    if (QLog.isColorLevel()) {
      QLog.d(this.a.tag, 2, "onSendResult, isSucc:" + paramBoolean + " uin:" + paramString + " uniseq:" + paramLong);
    }
    if ((paramString == null) || (paramString.length() == 0)) {}
    do
    {
      do
      {
        return;
      } while (!paramString.equals(this.a.sessionInfo.curFriendUin));
      this.a.hasSentRecvMsg = true;
      this.a.refresh(262144, null, paramLong);
    } while ((!paramBoolean) || (((anvk)this.a.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(this.a.sessionInfo.curFriendUin)));
    aifl.a(this.a);
  }
  
  protected void onSendResultWithTransInfo(boolean paramBoolean, msg_svc.TransSvrInfo paramTransSvrInfo)
  {
    if ((paramBoolean) && (paramTransSvrInfo != null) && (paramTransSvrInfo.bytes_trans_info.has()))
    {
      byte[] arrayOfByte = paramTransSvrInfo.bytes_trans_info.get().toByteArray();
      if (arrayOfByte.length > 0) {
        paramTransSvrInfo = new QQCirclePrivateMsgAIO.PrivateMsgTransSvrInfo();
      }
      try
      {
        paramTransSvrInfo.mergeFrom(arrayOfByte);
        int i = paramTransSvrInfo.int32_ret_code.get();
        paramTransSvrInfo = paramTransSvrInfo.str_err_msg.get();
        QLog.d(this.a.tag, 2, new Object[] { "onSendResultWithTransInfo isSuc:", Boolean.valueOf(paramBoolean), ",retCode:", Integer.valueOf(i), ",tips:", paramTransSvrInfo });
        if ((i == 0) && (!TextUtils.isEmpty(paramTransSvrInfo)))
        {
          QQToast.a(this.a.mContext, 0, paramTransSvrInfo, 0).a();
          QLog.d(this.a.tag, 2, new Object[] { "onSendResultWithTransInfo Show Toast,tips:", paramTransSvrInfo });
        }
        return;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        for (;;)
        {
          QLog.e(this.a.tag, 1, new Object[] { "onSendResultWithTransInfo isSuc:", Boolean.valueOf(paramBoolean), ",exception:" + localInvalidProtocolBufferMicroException.toString() });
        }
      }
    }
    QLog.d(this.a.tag, 1, new Object[] { "onSendResultWithTransInfo isSuc:", Boolean.valueOf(paramBoolean), ",transSvrInfo is empty!" });
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
    this.a.refresh(196608);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aifn
 * JD-Core Version:    0.7.0.1
 */