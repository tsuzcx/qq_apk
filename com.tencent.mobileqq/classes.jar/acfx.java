import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.QLog;
import msf.msgsvc.msg_svc.AccostTmp;
import msf.msgsvc.msg_svc.RoutingHead;

public class acfx
  implements abyl
{
  public int a()
  {
    return 1001;
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(msg_svc.RoutingHead paramRoutingHead, MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    msg_svc.AccostTmp localAccostTmp = new msg_svc.AccostTmp();
    localAccostTmp.to_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
    QQMessageFacade.Message localMessage = paramQQAppInterface.getMessageFacade().getLastMessage(paramMessageRecord.frienduin, 1001);
    localAccostTmp.reply.set(localMessage.hasReply);
    if (QLog.isColorLevel()) {
      QLog.d("LBSFriendRoutingType", 2, "LBS_FRIEND------>reply=" + localMessage.hasReply);
    }
    paramMessageRecord = paramQQAppInterface.getMsgCache().n(paramMessageRecord.frienduin);
    if (paramMessageRecord != null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("fight_accost", 4, "发送附近人临时会消息 有keyLBSFriend------>" + HexUtil.bytes2HexStr(paramMessageRecord) + ",length:" + paramMessageRecord.length);
      }
      localAccostTmp.sig.set(ByteStringMicro.copyFrom(paramMessageRecord));
    }
    paramRoutingHead.accost_tmp.set(localAccostTmp);
    return true;
  }
  
  public int b()
  {
    return 6010;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acfx
 * JD-Core Version:    0.7.0.1
 */