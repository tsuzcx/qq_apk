import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBUInt64Field;
import msf.msgsvc.msg_svc.Grp;
import msf.msgsvc.msg_svc.RoutingHead;

public class acfu
  implements abyl
{
  public int a()
  {
    return 1;
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(msg_svc.RoutingHead paramRoutingHead, MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = new msg_svc.Grp();
    paramQQAppInterface.group_code.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
    paramRoutingHead.grp.set(paramQQAppInterface);
    return true;
  }
  
  public int b()
  {
    return 3002;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acfu
 * JD-Core Version:    0.7.0.1
 */