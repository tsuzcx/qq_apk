import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import tencent.mobileim.structmsg.structmsg.RspHead;
import tencent.mobileim.structmsg.structmsg.RspSystemMsgRead;

class akre
  implements ayth
{
  akre(akqx paramakqx, long paramLong1, long paramLong2, long paramLong3) {}
  
  public void a(aytj paramaytj, ayti paramayti)
  {
    try
    {
      paramaytj = paramaytj.a.getWupBuffer();
      paramayti = new structmsg.RspSystemMsgRead();
      paramayti.mergeFrom(paramaytj);
      int i = paramayti.head.result.get();
      if (QLog.isColorLevel()) {
        QLog.d("Q.systemmsg.", 2, "sendGroupSystemMsgReadedReportResp reqSeq=" + this.jdField_a_of_type_Long + ";resultCode=" + i + ";latestFriendSeq=" + this.b + ";latestGroupSeq=" + this.c);
      }
      return;
    }
    catch (Exception paramaytj)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Q.systemmsg.", 2, "sendFriendSystemMsgReadedReportResp exception", paramaytj);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akre
 * JD-Core Version:    0.7.0.1
 */