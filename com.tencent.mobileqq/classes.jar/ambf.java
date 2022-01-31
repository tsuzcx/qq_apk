import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.audiopanel.ListenChangeVoicePanel;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.pb.voiceChange.VipVoiceChange.subCmd0x1ReqAuth;
import com.tencent.pb.voiceChange.VipVoiceChange.subCmd0x1RspAuth;
import com.tencent.pb.voiceChange.VipVoiceChange.voiceChangeReq;
import com.tencent.pb.voiceChange.VipVoiceChange.voiceChangeRsp;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class ambf
  extends alko
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  final String jdField_a_of_type_JavaLangString = "VoiceChangeHandler";
  WeakReference<ListenChangeVoicePanel> jdField_a_of_type_JavaLangRefWeakReference;
  
  public ambf(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public void a(int paramInt1, int paramInt2, ListenChangeVoicePanel paramListenChangeVoicePanel)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramListenChangeVoicePanel);
    paramListenChangeVoicePanel = super.createToServiceMsg("voiceChange.Auth");
    paramListenChangeVoicePanel.extraData.putInt("callId", paramInt2);
    VipVoiceChange.voiceChangeReq localvoiceChangeReq = new VipVoiceChange.voiceChangeReq();
    localvoiceChangeReq.int32_platform.set(109);
    localvoiceChangeReq.int32_sub_cmd.set(1);
    localvoiceChangeReq.str_qq_version.set("8.3.3");
    VipVoiceChange.subCmd0x1ReqAuth localsubCmd0x1ReqAuth = new VipVoiceChange.subCmd0x1ReqAuth();
    localsubCmd0x1ReqAuth.int32_item_id.set(paramInt2);
    localvoiceChangeReq.msg_subcmd0x1_req_auth.set(localsubCmd0x1ReqAuth);
    localvoiceChangeReq.setHasFlag(true);
    paramListenChangeVoicePanel.putWupBuffer(localvoiceChangeReq.toByteArray());
    if (QLog.isColorLevel()) {
      QLog.d("VoiceChangeHandler", 2, "sendReqToSVR funcType=" + paramInt1 + ", voiceID:" + paramInt2);
    }
    super.sendPbReq(paramListenChangeVoicePanel);
  }
  
  protected Class<? extends alkr> observerClass()
  {
    return bdzh.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (!"voiceChange.Auth".equals(paramFromServiceMsg.getServiceCmd())) {
      return;
    }
    Bundle localBundle;
    for (;;)
    {
      try
      {
        localBundle = new Bundle();
        localBundle.putInt("callId", paramToServiceMsg.extraData.getInt("callId"));
        if ((!paramFromServiceMsg.isSuccess()) || (paramObject == null)) {
          break label171;
        }
        i = 1;
        if (i != 0) {
          break;
        }
        QLog.e("VoiceChangeHandler", 1, "onReceive~ isSuccess=false ,data=" + bdlr.a((byte[])paramObject));
        bfdq.a().a("voiceChange.Auth", 100, paramFromServiceMsg.getBusinessFailCode(), this.app.getCurrentAccountUin(), 0, alpo.a(2131717224), true);
        localBundle.putInt("result", -1);
        super.notifyUI(1, false, localBundle);
        return;
      }
      catch (Exception paramToServiceMsg)
      {
        QLog.e("VoiceChangeHandler", 1, "onReceive prb.mergeFrom error: " + paramToServiceMsg.getMessage());
      }
      this.jdField_a_of_type_JavaLangRefWeakReference = null;
      return;
      label171:
      i = 0;
    }
    paramToServiceMsg = new VipVoiceChange.voiceChangeRsp();
    paramToServiceMsg.mergeFrom((byte[])paramObject);
    int i = paramToServiceMsg.int32_sub_cmd.get();
    paramToServiceMsg = (VipVoiceChange.subCmd0x1RspAuth)paramToServiceMsg.msg_subcmd0x1_rsp_auth.get();
    int j = paramToServiceMsg.int32_ret.get();
    paramFromServiceMsg = paramToServiceMsg.str_error_msg.get();
    paramObject = paramToServiceMsg.str_active_url.get();
    localBundle.putInt("result", j);
    if (QLog.isColorLevel()) {
      QLog.d("VoiceChangeHandler", 2, "VoiceChangeHandler onReceive~ ret=" + j + ",msg=" + paramFromServiceMsg + ", url=" + paramObject + ", funcType=" + i + ", actStr=" + null);
    }
    localBundle.putString("message", paramFromServiceMsg);
    localBundle.putString("svr_url", paramObject);
    localBundle.putString("svr_actStr", null);
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {}
    for (paramToServiceMsg = (ListenChangeVoicePanel)this.jdField_a_of_type_JavaLangRefWeakReference.get();; paramToServiceMsg = null)
    {
      if (paramToServiceMsg != null)
      {
        paramToServiceMsg.a(i, j, localBundle, false);
        break;
      }
      QLog.e("VoiceChangeHandler", 1, "VoiceChangeHandler onReceive~ null == listenChangeVoicePanel ret=" + j + ",msg=" + paramFromServiceMsg + ", url=" + paramObject + ", funcType=" + i + ", actStr=" + null);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ambf
 * JD-Core Version:    0.7.0.1
 */