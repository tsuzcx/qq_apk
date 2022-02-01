import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.QLog;
import msf.msgsvc.msg_svc.RichStatusTmp;
import msf.msgsvc.msg_svc.RoutingHead;

public class acwr
  implements acos
{
  public int a()
  {
    return 1009;
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(msg_svc.RoutingHead paramRoutingHead, MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    msg_svc.RichStatusTmp localRichStatusTmp = new msg_svc.RichStatusTmp();
    localRichStatusTmp.to_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
    paramMessageRecord = paramQQAppInterface.getMsgCache().j(paramMessageRecord.frienduin);
    if (paramMessageRecord != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SameStateRoutingType", 2, "sameState------>" + HexUtil.bytes2HexStr(paramMessageRecord) + ",length:" + paramMessageRecord.length);
      }
      localRichStatusTmp.sig.set(ByteStringMicro.copyFrom(paramMessageRecord));
    }
    paramRoutingHead.rich_status_tmp.set(localRichStatusTmp);
    return true;
  }
  
  public int b()
  {
    return 8006;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acwr
 * JD-Core Version:    0.7.0.1
 */