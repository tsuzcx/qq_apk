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
import msf.msgsvc.msg_svc.NearByDatingTmp;
import msf.msgsvc.msg_svc.RoutingHead;

public class acgd
  implements abyl
{
  public int a()
  {
    return 1010;
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(msg_svc.RoutingHead paramRoutingHead, MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    msg_svc.NearByDatingTmp localNearByDatingTmp = new msg_svc.NearByDatingTmp();
    localNearByDatingTmp.to_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
    QQMessageFacade.Message localMessage = paramQQAppInterface.getMessageFacade().getLastMessage(paramMessageRecord.frienduin, 1010);
    localNearByDatingTmp.reply.set(localMessage.hasReply);
    paramMessageRecord = paramQQAppInterface.getMsgCache().q(paramMessageRecord.frienduin);
    if (paramMessageRecord != null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("nearby_dating", 4, "发送附近人约会临时会话消息 有keyNearbyDating------>" + HexUtil.bytes2HexStr(paramMessageRecord) + ",length:" + paramMessageRecord.length);
      }
      localNearByDatingTmp.sig.set(ByteStringMicro.copyFrom(paramMessageRecord));
    }
    paramRoutingHead.nearby_dating_tmp.set(localNearByDatingTmp);
    return true;
  }
  
  public int b()
  {
    return 8012;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acgd
 * JD-Core Version:    0.7.0.1
 */