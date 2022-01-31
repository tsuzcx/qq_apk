import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import tencent.mobileim.structmsg.structmsg.RspHead;
import tencent.mobileim.structmsg.structmsg.RspSystemMsgRead;

class akcs
  implements axta
{
  akcs(akcl paramakcl, long paramLong1, long paramLong2, long paramLong3) {}
  
  public void a(axtc paramaxtc, axtb paramaxtb)
  {
    try
    {
      paramaxtc = paramaxtc.a.getWupBuffer();
      paramaxtb = new structmsg.RspSystemMsgRead();
      paramaxtb.mergeFrom(paramaxtc);
      int i = paramaxtb.head.result.get();
      if (QLog.isColorLevel()) {
        QLog.d("Q.systemmsg.", 2, "sendGroupSystemMsgReadedReportResp reqSeq=" + this.jdField_a_of_type_Long + ";resultCode=" + i + ";latestFriendSeq=" + this.b + ";latestGroupSeq=" + this.c);
      }
      return;
    }
    catch (Exception paramaxtc)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Q.systemmsg.", 2, "sendFriendSystemMsgReadedReportResp exception", paramaxtc);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akcs
 * JD-Core Version:    0.7.0.1
 */