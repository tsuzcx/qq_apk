import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import tencent.mobileim.structmsg.structmsg.RspHead;
import tencent.mobileim.structmsg.structmsg.RspSystemMsgRead;

class akrd
  implements aytj
{
  akrd(akqw paramakqw, long paramLong1, long paramLong2, long paramLong3) {}
  
  public void a(aytl paramaytl, aytk paramaytk)
  {
    try
    {
      paramaytl = paramaytl.a.getWupBuffer();
      paramaytk = new structmsg.RspSystemMsgRead();
      paramaytk.mergeFrom(paramaytl);
      int i = paramaytk.head.result.get();
      if (QLog.isColorLevel()) {
        QLog.d("Q.systemmsg.", 2, "sendGroupSystemMsgReadedReportResp reqSeq=" + this.jdField_a_of_type_Long + ";resultCode=" + i + ";latestFriendSeq=" + this.b + ";latestGroupSeq=" + this.c);
      }
      return;
    }
    catch (Exception paramaytl)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Q.systemmsg.", 2, "sendFriendSystemMsgReadedReportResp exception", paramaytl);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akrd
 * JD-Core Version:    0.7.0.1
 */