import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.AddAccountActivity;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.activity.NewAuthDevUgFragment;
import com.tencent.mobileqq.activity.NewAuthDevUgFragment.1.1;
import com.tencent.mobileqq.activity.SubLoginActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.VerifyDevLockManager.NotifyType;
import mqq.manager.VerifyDevLockManager.VerifyDevLockObserver;
import mqq.os.MqqHandler;
import oicq.wlogin_sdk.tools.ErrMsg;
import tencent.im.login.GatewayVerify.RspBody;
import tencent.im.login.GatewayVerify.RspBodySelfPhone;
import tencent.im.login.GatewayVerify.RspBodySelfPhoneCheck;
import tencent.im.login.GatewayVerify.RspBodySelfPhoneGetUrl;

public class aeqc
  extends VerifyDevLockManager.VerifyDevLockObserver
{
  public aeqc(NewAuthDevUgFragment paramNewAuthDevUgFragment) {}
  
  public void onReceive(VerifyDevLockManager.NotifyType paramNotifyType, int paramInt, Object paramObject)
  {
    int i = 1;
    if (this.a.a())
    {
      QLog.e("NewAuthDevUgFragment", 1, "onReceive getActivity is null or activity is finish");
      return;
    }
    boolean bool;
    if (paramObject == null)
    {
      bool = true;
      QLog.d("NewAuthDevUgFragment", 1, new Object[] { "VerifyDevLockObserver onReceive, type is ", paramNotifyType, ", ret is ", Integer.valueOf(paramInt), "data == null ? ", Boolean.valueOf(bool) });
      if ((paramNotifyType != VerifyDevLockManager.NotifyType.NOTIFY_GET_GATEWAY_URL) || (paramInt != 239)) {
        break label365;
      }
      if (paramObject != null) {
        break label202;
      }
      try
      {
        QLog.e("NewAuthDevUgFragment", 1, "data is null");
        NewAuthDevUgFragment.a(this.a);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramNotifyType)
      {
        QLog.e("NewAuthDevUgFragment", 1, new Object[] { "onReceive, GatewayVerify.RspBody mergeFrom error : ", paramNotifyType.getMessage() });
        NewAuthDevUgFragment.a(this.a, "V_GET_GATEWAY_URL_ERROR", paramInt, paramNotifyType.getMessage());
        NewAuthDevUgFragment.a(this.a);
        if (!(NewAuthDevUgFragment.a(this.a) instanceof QQAppInterface)) {}
      }
    }
    for (paramNotifyType = (QQAppInterface)NewAuthDevUgFragment.a(this.a);; paramNotifyType = null)
    {
      awcu.a(NewAuthDevUgFragment.a(this.a), paramNotifyType, 3, NewAuthDevUgFragment.b(this.a));
      return;
      bool = false;
      break;
      label202:
      paramObject = (byte[])paramObject;
      paramNotifyType = new GatewayVerify.RspBody();
      paramNotifyType.mergeFrom(paramObject);
      paramObject = paramNotifyType.msg_rsp_self_phone.msg_rsp_get_url.str_upload_url.get();
      NewAuthDevUgFragment.a(this.a, paramNotifyType.msg_rsp_self_phone.msg_rsp_get_url.int32_channel_id.get());
      NewAuthDevUgFragment.a(this.a, paramNotifyType.msg_rsp_self_phone.msg_rsp_get_url.str_msg_id.get());
      NewAuthDevUgFragment.b(this.a, 0);
      NewAuthDevUgFragment.a(this.a, true);
      QLog.d("NewAuthDevUgFragment", 1, new Object[] { "msgid: ", NewAuthDevUgFragment.a(this.a), " channelId : ", Integer.valueOf(NewAuthDevUgFragment.a(this.a)) });
      NewAuthDevUgFragment.a(this.a).a(paramObject, NewAuthDevUgFragment.a(this.a));
      return;
    }
    label365:
    if (paramNotifyType == VerifyDevLockManager.NotifyType.NOTIFY_CHECK_SELF_PHONE)
    {
      if (paramInt == 160)
      {
        NewAuthDevUgFragment.a(this.a, "V_VERIFY_TOKEN_ERROR", paramInt, "");
        NewAuthDevUgFragment.a(this.a);
        return;
      }
      if (paramInt == 241)
      {
        NewAuthDevUgFragment.a(this.a, "V_VERIFY_TOKEN_ERROR", paramInt, "");
        NewAuthDevUgFragment.b(this.a);
        if ((NewAuthDevUgFragment.a(this.a) instanceof QQAppInterface)) {}
        for (paramNotifyType = (QQAppInterface)NewAuthDevUgFragment.a(this.a);; paramNotifyType = null)
        {
          awcu.a(NewAuthDevUgFragment.a(this.a), paramNotifyType, 5, NewAuthDevUgFragment.b(this.a));
          return;
        }
      }
      if (paramInt == 242)
      {
        if (paramObject == null) {
          try
          {
            QLog.e("NewAuthDevUgFragment", 1, "data is null");
            NewAuthDevUgFragment.a(this.a);
            return;
          }
          catch (InvalidProtocolBufferMicroException paramNotifyType)
          {
            QLog.e("NewAuthDevUgFragment", 1, new Object[] { "onReceive, GatewayVerify.RspBody mergeFrom error : ", paramNotifyType.getMessage() });
            NewAuthDevUgFragment.a(this.a);
            return;
          }
        }
        paramNotifyType = (byte[])paramObject;
        paramObject = new GatewayVerify.RspBody();
        paramObject.mergeFrom(paramNotifyType);
        paramNotifyType = paramObject.msg_rsp_self_phone.msg_rsp_check_phone.str_upload_redirect_url.get();
        NewAuthDevUgFragment.a(this.a).a(paramNotifyType);
        return;
      }
      NewAuthDevUgFragment.a(this.a, "V_VERIFY_TOKEN_ERROR", paramInt, "");
      NewAuthDevUgFragment.a(this.a);
      if ((NewAuthDevUgFragment.a(this.a) instanceof QQAppInterface)) {}
      for (paramNotifyType = (QQAppInterface)NewAuthDevUgFragment.a(this.a);; paramNotifyType = null)
      {
        awcu.a(NewAuthDevUgFragment.a(this.a), paramNotifyType, 3, NewAuthDevUgFragment.b(this.a));
        return;
      }
    }
    if (paramNotifyType == VerifyDevLockManager.NotifyType.NOTIFY_GET_GATEWAY_URL)
    {
      if (i == 0) {
        break label731;
      }
      paramNotifyType = "V_GET_GATEWAY_URL_ERROR";
      label663:
      NewAuthDevUgFragment.a(this.a, paramNotifyType, paramInt, "");
      NewAuthDevUgFragment.a(this.a);
      if (!(NewAuthDevUgFragment.a(this.a) instanceof QQAppInterface)) {
        break label737;
      }
    }
    label731:
    label737:
    for (paramNotifyType = (QQAppInterface)NewAuthDevUgFragment.a(this.a);; paramNotifyType = null)
    {
      awcu.a(NewAuthDevUgFragment.a(this.a), paramNotifyType, 3, NewAuthDevUgFragment.b(this.a));
      return;
      i = 0;
      break;
      paramNotifyType = "V_VERIFY_TOKEN_ERROR";
      break label663;
    }
  }
  
  public void onVerifyClose(int paramInt1, String paramString, int paramInt2, ErrMsg paramErrMsg)
  {
    if (this.a.a())
    {
      QLog.e("NewAuthDevUgFragment", 1, "onVerifyClose getActivity is null or activity is finish");
      return;
    }
    QLog.d("NewAuthDevUgFragment", 1, new Object[] { "onVerifyClose ret : ", Integer.valueOf(paramInt2) });
    if (paramInt2 == 0)
    {
      NewAuthDevUgFragment.a(this.a, false);
      NewAuthDevUgFragment.a(this.a, "V_RET_SUCCESS", paramInt2, "");
      NewAuthDevUgFragment.a(this.a).a();
      NewAuthDevUgFragment.a(this.a).setText(2131691851);
      NewAuthDevUgFragment.a(this.a).postDelayed(new NewAuthDevUgFragment.1.1(this), 800L);
      if (NewAuthDevUgFragment.a(this.a))
      {
        paramString = NewAuthDevUgFragment.a(this.a).getHandler(LoginActivity.class);
        if (paramString != null) {
          paramString.sendEmptyMessage(20200515);
        }
        paramString = NewAuthDevUgFragment.a(this.a).getHandler(SubLoginActivity.class);
        if (paramString != null) {
          paramString.sendEmptyMessage(20200515);
        }
        paramString = NewAuthDevUgFragment.a(this.a).getHandler(AddAccountActivity.class);
        if (paramString != null) {
          paramString.sendEmptyMessage(20200515);
        }
      }
      if ((NewAuthDevUgFragment.a(this.a) instanceof QQAppInterface))
      {
        paramString = (QQAppInterface)NewAuthDevUgFragment.a(this.a);
        awcu.a(NewAuthDevUgFragment.a(this.a), paramString, 4, NewAuthDevUgFragment.b(this.a));
        if (!(NewAuthDevUgFragment.a(this.a) instanceof QQAppInterface)) {
          break label297;
        }
      }
      label297:
      for (paramString = (QQAppInterface)NewAuthDevUgFragment.a(this.a);; paramString = null)
      {
        bcst.a(paramString, "dc00898", "", NewAuthDevUgFragment.b(this.a), "0X800AEFB", "0X800AEFB", 0, 0, "", "", "", "");
        return;
        paramString = null;
        break;
      }
    }
    QLog.e("NewAuthDevUgFragment", 1, new Object[] { "VerifyDevLockObserver onVerifyClose error, ret : ", Integer.valueOf(paramInt2) });
    NewAuthDevUgFragment.a(this.a, "V_VERIFY_TOKEN_ERROR", paramInt2, paramErrMsg.getMessage());
    NewAuthDevUgFragment.a(this.a);
    if ((NewAuthDevUgFragment.a(this.a) instanceof QQAppInterface)) {}
    for (paramString = (QQAppInterface)NewAuthDevUgFragment.a(this.a);; paramString = null)
    {
      awcu.a(NewAuthDevUgFragment.a(this.a), paramString, 3, NewAuthDevUgFragment.b(this.a));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeqc
 * JD-Core Version:    0.7.0.1
 */