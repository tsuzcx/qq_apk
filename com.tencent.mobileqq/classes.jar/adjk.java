import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBUInt64Field;
import msf.msgsvc.msg_svc.PubGroupTmp;
import msf.msgsvc.msg_svc.RoutingHead;

public class adjk
  implements adbw
{
  public int a()
  {
    return 1020;
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(msg_svc.RoutingHead paramRoutingHead, MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = new msg_svc.PubGroupTmp();
    paramQQAppInterface.group_uin.set(Long.valueOf(paramMessageRecord.senderuin).longValue());
    paramQQAppInterface.to_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
    paramRoutingHead.pub_group_tmp.set(paramQQAppInterface);
    return true;
  }
  
  public int b()
  {
    return 6009;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adjk
 * JD-Core Version:    0.7.0.1
 */