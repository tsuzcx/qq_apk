import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import msf.msgsvc.msg_svc.CommTmp;
import msf.msgsvc.msg_svc.RoutingHead;

public class acwb
  implements acos
{
  public int a()
  {
    return 10009;
  }
  
  public boolean a()
  {
    return true;
  }
  
  public boolean a(msg_svc.RoutingHead paramRoutingHead, MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    msg_svc.CommTmp localCommTmp = new msg_svc.CommTmp();
    localCommTmp.c2c_type.set(1);
    localCommTmp.svr_type.set(168);
    paramQQAppInterface = paramQQAppInterface.getMsgCache().e(paramMessageRecord.frienduin, paramMessageRecord.selfuin);
    if (paramQQAppInterface != null) {
      localCommTmp.sig.set(ByteStringMicro.copyFrom(paramQQAppInterface));
    }
    localCommTmp.to_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
    paramRoutingHead.comm_tmp.set(localCommTmp);
    return true;
  }
  
  public int b()
  {
    return 8044;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acwb
 * JD-Core Version:    0.7.0.1
 */