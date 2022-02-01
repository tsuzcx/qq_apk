import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.qphone.base.util.QLog;

class ahfd
  extends amwl
{
  ahfd(ahey paramahey) {}
  
  protected void onSendResult_confess(boolean paramBoolean, String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    if ((paramString == null) || (!paramString.equals(this.a.sessionInfo.curFriendUin)) || (paramInt1 != this.a.sessionInfo.curType) || (paramInt2 != this.a.sessionInfo.topicId))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.a.tag, 2, "onSendResult_confess err uin " + paramString + " type " + paramInt1 + " uniseq " + paramLong + " topicId " + paramInt2);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.a.tag, 2, "onSendResult_confess uin " + paramString + " type " + paramInt1 + " uniseq " + paramLong + " topicId " + paramInt2);
    }
    this.a.hasSentRecvMsg = true;
    this.a.refresh(262144, null, paramLong);
  }
  
  protected void onUpdateMsgContent(boolean paramBoolean, String paramString)
  {
    this.a.refresh(65536);
  }
  
  protected void onUpdateSendMsgError_confess(String paramString1, int paramInt1, int paramInt2, SendMessageHandler paramSendMessageHandler, long paramLong1, long paramLong2, String paramString2, int paramInt3)
  {
    if ((paramString1 == null) || (!paramString1.equals(this.a.sessionInfo.curFriendUin)) || (paramInt1 != this.a.sessionInfo.curType) || (paramInt3 != this.a.sessionInfo.topicId))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.a.tag, 2, "onUpdateSendMsgError_confess err uin " + paramString1 + " type " + paramInt1 + " uniseq " + paramLong2 + " topicId " + paramInt3);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.a.tag, 2, "onUpdateSendMsgError_confess uin " + paramString1 + " type " + paramInt1 + " uniseq " + paramLong2 + " errorCode " + paramInt2 + " topicId " + paramInt3);
    }
    this.a.refresh(196608);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahfd
 * JD-Core Version:    0.7.0.1
 */