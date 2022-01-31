import android.os.Bundle;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import tencent.mobileim.structmsg.structmsg.RspHead;
import tencent.mobileim.structmsg.structmsg.RspSystemMsgAction;

class akqz
  implements aytj
{
  akqz(akqw paramakqw) {}
  
  public void a(aytl paramaytl, aytk paramaytk)
  {
    ToServiceMsg localToServiceMsg = (ToServiceMsg)paramaytk.a;
    if (paramaytl.a.getResultCode() != 1000) {
      this.a.a(4012, false, localToServiceMsg);
    }
    for (;;)
    {
      try
      {
        paramaytl = paramaytl.a.getWupBuffer();
        localRspSystemMsgAction = new structmsg.RspSystemMsgAction();
        localRspSystemMsgAction.mergeFrom(paramaytl);
        j = localRspSystemMsgAction.head.result.get();
        if (j != 0) {
          continue;
        }
        bool1 = true;
        paramaytl = localRspSystemMsgAction.msg_detail.get();
        if (paramaytl != null) {
          continue;
        }
        paramaytl = "";
      }
      catch (Exception paramaytl)
      {
        structmsg.RspSystemMsgAction localRspSystemMsgAction;
        int j;
        boolean bool1;
        int i;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.systemmsg.", 2, "sendFriendSystemMsgReadedReportResp exception", paramaytl);
        boolean bool2 = false;
        continue;
        continue;
      }
      i = -1;
      if (localRspSystemMsgAction.remark_result.has()) {
        i = localRspSystemMsgAction.remark_result.get();
      }
      localToServiceMsg.extraData.putString("system_msg_action_resp_key", paramaytl);
      localToServiceMsg.extraData.putInt("system_msg_action_resp_result_code_key", localRspSystemMsgAction.head.result.get());
      localToServiceMsg.extraData.putInt("system_msg_action_resp_type_key", localRspSystemMsgAction.type.get());
      localToServiceMsg.extraData.putString("system_msg_action_resp_invalid_decided_key", localRspSystemMsgAction.msg_invalid_decided.get());
      localToServiceMsg.extraData.putInt("system_msg_action_resp_remark_result_key", i);
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        QLog.d("Q.systemmsg.", 2, "sendFriendSystemMsgActionResp result:" + j + " msg:" + paramaytl);
        bool2 = bool1;
      }
      this.a.a(4011, bool2, localToServiceMsg);
      return;
      paramaytk = localRspSystemMsgAction.head.msg_fail.get();
      paramaytl = paramaytk;
      if (paramaytk == null) {
        paramaytl = "";
      }
      localToServiceMsg.extraData.putString("system_msg_action_resp_error_key", paramaytl);
      bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akqz
 * JD-Core Version:    0.7.0.1
 */