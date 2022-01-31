import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.qphone.base.remote.ToServiceMsg;
import msf.msgsvc.msg_svc.PbMsgReadedReportReq;

class abny
  implements abnz
{
  abny(abnx paramabnx, msg_svc.PbMsgReadedReportReq paramPbMsgReadedReportReq) {}
  
  public ToServiceMsg a()
  {
    ToServiceMsg localToServiceMsg = this.jdField_a_of_type_Abnx.a.createToServiceMsg("PbMessageSvc.PbMsgReadedReport");
    byte[] arrayOfByte = this.jdField_a_of_type_MsfMsgsvcMsg_svc$PbMsgReadedReportReq.toByteArray();
    if (arrayOfByte != null)
    {
      localToServiceMsg.putWupBuffer(arrayOfByte);
      localToServiceMsg.setEnableFastResend(true);
      return localToServiceMsg;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abny
 * JD-Core Version:    0.7.0.1
 */