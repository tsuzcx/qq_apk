import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import msf.msgsvc.msg_svc.CommTmp;
import msf.msgsvc.msg_svc.RoutingHead;

public class adjo
  implements adbw
{
  public int a()
  {
    return 10007;
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(msg_svc.RoutingHead paramRoutingHead, MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    msg_svc.CommTmp localCommTmp = new msg_svc.CommTmp();
    localCommTmp.c2c_type.set(1);
    localCommTmp.svr_type.set(164);
    byte[] arrayOfByte = paramQQAppInterface.a().d(paramMessageRecord.frienduin, paramMessageRecord.selfuin);
    if (arrayOfByte != null) {
      localCommTmp.sig.set(ByteStringMicro.copyFrom(arrayOfByte));
    }
    paramMessageRecord = paramQQAppInterface.a().a(paramMessageRecord.frienduin);
    long l1 = 0L;
    try
    {
      long l2 = Long.parseLong(paramMessageRecord);
      l1 = l2;
    }
    catch (NumberFormatException paramMessageRecord)
    {
      for (;;)
      {
        QLog.d("QQGameMsgTmpRoutingType", 1, paramMessageRecord, new Object[0]);
      }
    }
    localCommTmp.to_uin.set(l1);
    paramRoutingHead.comm_tmp.set(localCommTmp);
    return true;
  }
  
  public int b()
  {
    return 8042;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adjo
 * JD-Core Version:    0.7.0.1
 */