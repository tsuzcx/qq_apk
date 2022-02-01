import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.qphone.base.remote.ToServiceMsg;
import msf.msgsvc.msg_svc.PbMsgReadedReportReq;

class acmf
  implements acmg
{
  acmf(acme paramacme, msg_svc.PbMsgReadedReportReq paramPbMsgReadedReportReq) {}
  
  public ToServiceMsg a()
  {
    ToServiceMsg localToServiceMsg = this.jdField_a_of_type_Acme.a.createToServiceMsg("PbMessageSvc.PbMsgReadedReport");
    localToServiceMsg.putWupBuffer(this.jdField_a_of_type_MsfMsgsvcMsg_svc$PbMsgReadedReportReq.toByteArray());
    localToServiceMsg.setEnableFastResend(true);
    return localToServiceMsg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acmf
 * JD-Core Version:    0.7.0.1
 */