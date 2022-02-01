import com.tencent.mobileqq.activity.NewAuthDevUgFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import tencent.im.login.GatewayVerify.ReqBody;
import tencent.im.login.GatewayVerify.ReqBodySelfPhone;
import tencent.im.login.GatewayVerify.ReqBodySelfPhoneCheck;

public class adrx
  implements aviq
{
  private WeakReference<NewAuthDevUgFragment> a;
  
  public adrx(NewAuthDevUgFragment paramNewAuthDevUgFragment)
  {
    this.a = new WeakReference(paramNewAuthDevUgFragment);
  }
  
  public void a(int paramInt, Exception paramException)
  {
    NewAuthDevUgFragment localNewAuthDevUgFragment = (NewAuthDevUgFragment)this.a.get();
    if (localNewAuthDevUgFragment == null)
    {
      QLog.e("NewAuthDevUgFragment", 1, "GatewayVerifyWrapper onGetTokenError mFragmentRef.get() is null");
      return;
    }
    if (localNewAuthDevUgFragment.a())
    {
      QLog.e("NewAuthDevUgFragment", 1, "GatewayCallback onGetTokenError getActivity is null or activity is finish");
      return;
    }
    QLog.e("NewAuthDevUgFragment", 1, new Object[] { "GatewayCallback onGetTokenError : ", paramException.getMessage() });
    NewAuthDevUgFragment.a(localNewAuthDevUgFragment, "V_GET_TOKEN_ERROR", paramInt, paramException.getMessage());
    NewAuthDevUgFragment.a(localNewAuthDevUgFragment);
    if ((NewAuthDevUgFragment.a(localNewAuthDevUgFragment) instanceof QQAppInterface)) {}
    for (paramException = (QQAppInterface)NewAuthDevUgFragment.a(localNewAuthDevUgFragment);; paramException = null)
    {
      avit.a(NewAuthDevUgFragment.a(localNewAuthDevUgFragment), paramException, 3, NewAuthDevUgFragment.b(localNewAuthDevUgFragment));
      return;
    }
  }
  
  public void a(Exception paramException)
  {
    NewAuthDevUgFragment localNewAuthDevUgFragment = (NewAuthDevUgFragment)this.a.get();
    if (localNewAuthDevUgFragment == null)
    {
      QLog.e("NewAuthDevUgFragment", 1, "GatewayVerifyWrapper onChangeNetworkError mFragmentRef.get() is null");
      return;
    }
    if (localNewAuthDevUgFragment.a())
    {
      QLog.e("NewAuthDevUgFragment", 1, "GatewayCallback onChangeNetworkError getActivity is null or activity is finish");
      return;
    }
    QLog.e("NewAuthDevUgFragment", 1, new Object[] { "GatewayCallback onChangeNetworkError : ", paramException.getMessage() });
    NewAuthDevUgFragment.a(localNewAuthDevUgFragment, "V_CHANGE_NETWORK_TYPE_ERROR", -1, paramException.getMessage());
    NewAuthDevUgFragment.a(localNewAuthDevUgFragment);
    if ((NewAuthDevUgFragment.a(localNewAuthDevUgFragment) instanceof QQAppInterface)) {}
    for (paramException = (QQAppInterface)NewAuthDevUgFragment.a(localNewAuthDevUgFragment);; paramException = null)
    {
      avit.a(NewAuthDevUgFragment.a(localNewAuthDevUgFragment), paramException, 3, NewAuthDevUgFragment.b(localNewAuthDevUgFragment));
      return;
    }
  }
  
  public void a(String paramString)
  {
    NewAuthDevUgFragment localNewAuthDevUgFragment = (NewAuthDevUgFragment)this.a.get();
    if (localNewAuthDevUgFragment == null)
    {
      QLog.e("NewAuthDevUgFragment", 1, "GatewayVerifyWrapper onRedirect mFragmentRef.get() is null");
      return;
    }
    if (localNewAuthDevUgFragment.a())
    {
      QLog.e("NewAuthDevUgFragment", 1, "GatewayCallback onRedirect getActivity is null or activity is finish");
      return;
    }
    NewAuthDevUgFragment.b(localNewAuthDevUgFragment);
    if (NewAuthDevUgFragment.c(localNewAuthDevUgFragment) > 5)
    {
      a(-1, new Exception("onRedirect timeout"));
      return;
    }
    NewAuthDevUgFragment.a(localNewAuthDevUgFragment).a(paramString, this);
  }
  
  public void a(String paramString1, String paramString2)
  {
    NewAuthDevUgFragment localNewAuthDevUgFragment = (NewAuthDevUgFragment)this.a.get();
    if (localNewAuthDevUgFragment == null) {
      QLog.e("NewAuthDevUgFragment", 1, "GatewayVerifyWrapper onResponse mFragmentRef.get() is null");
    }
    for (;;)
    {
      return;
      if (localNewAuthDevUgFragment.a())
      {
        QLog.e("NewAuthDevUgFragment", 1, "GatewayCallback onResponse getActivity is null or activity is finish");
        return;
      }
      if (NewAuthDevUgFragment.a(localNewAuthDevUgFragment) == null)
      {
        a(-1, new Exception("GatewayCallback onResponse, msgId is null"));
        return;
      }
      try
      {
        GatewayVerify.ReqBody localReqBody = new GatewayVerify.ReqBody();
        localReqBody.msg_req_self_phone.msg_req_check_phone.int32_channel_id.set(NewAuthDevUgFragment.a(localNewAuthDevUgFragment));
        localReqBody.msg_req_self_phone.msg_req_check_phone.str_msg_id.set(NewAuthDevUgFragment.a(localNewAuthDevUgFragment));
        localReqBody.msg_req_self_phone.msg_req_check_phone.str_token.set(paramString2);
        localReqBody.msg_req_self_phone.msg_req_check_phone.str_upurl.set(paramString1);
        paramString1 = pri.a();
        if ((!NetworkUtil.isWifiConnected(localNewAuthDevUgFragment.getActivity())) && (paramString1 != null)) {
          localReqBody.msg_req_self_phone.msg_req_check_phone.str_cell_ip.set(paramString1);
        }
        localReqBody.msg_req_self_phone.msg_req_check_phone.setHasFlag(true);
        localReqBody.msg_req_self_phone.setHasFlag(true);
        localReqBody.setHasFlag(true);
        paramString1 = localReqBody.toByteArray();
        int i = arhf.a().a(NewAuthDevUgFragment.a(localNewAuthDevUgFragment).getAppInterface(), NewAuthDevUgFragment.a(localNewAuthDevUgFragment), paramString1);
        if (i != 0)
        {
          QLog.e("NewAuthDevUgFragment", 1, new Object[] { "EquipmentLockImpl.getInstance().submitSms error, ret : ", Integer.valueOf(i) });
          return;
        }
      }
      catch (Exception paramString1)
      {
        QLog.e("NewAuthDevUgFragment", 1, new Object[] { "GatewayCallback onResponse submitSms error : ", paramString1.getMessage() });
        a(-1, new Exception(paramString1.getMessage() + "  content : " + paramString2));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adrx
 * JD-Core Version:    0.7.0.1
 */