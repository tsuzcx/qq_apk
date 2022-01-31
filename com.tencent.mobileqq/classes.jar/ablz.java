import QQService.SvcDevLoginInfo;
import QQService.SvcRspGetDevLoginInfo;
import com.tencent.mobileqq.activity.LoginInfoActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class ablz
  extends ajxj
{
  public ablz(LoginInfoActivity paramLoginInfoActivity) {}
  
  protected void onGetLoginDevResult(boolean paramBoolean, SvcRspGetDevLoginInfo paramSvcRspGetDevLoginInfo)
  {
    LoginInfoActivity.c(this.a);
    if ((paramBoolean) && (paramSvcRspGetDevLoginInfo != null) && (paramSvcRspGetDevLoginInfo.iResult == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("LoginInfoActivity.AccDevSec", 2, "onGetLoginDevResult success");
      }
      LoginInfoActivity.a(this.a, paramSvcRspGetDevLoginInfo.vecCurrentLoginDevInfo);
      if (QLog.isColorLevel())
      {
        QLog.d("LoginInfoActivity.AccDevSec", 2, "------------------------------------------------------------------------------");
        paramSvcRspGetDevLoginInfo = LoginInfoActivity.a(this.a).iterator();
        while (paramSvcRspGetDevLoginInfo.hasNext())
        {
          SvcDevLoginInfo localSvcDevLoginInfo = (SvcDevLoginInfo)paramSvcRspGetDevLoginInfo.next();
          if (localSvcDevLoginInfo != null) {
            QLog.d("LoginInfoActivity.AccDevSec", 2, "SvcDevLoginInfo.iAppId=" + localSvcDevLoginInfo.iAppId + " iLoginTime=" + localSvcDevLoginInfo.iLoginTime + " strLoginLocation=" + localSvcDevLoginInfo.strLoginLocation + " iLoginPlatform=" + localSvcDevLoginInfo.iLoginPlatform + " strDeviceName=" + localSvcDevLoginInfo.strDeviceName + " strDeviceTypeInfo" + localSvcDevLoginInfo.strDeviceTypeInfo);
          }
        }
        QLog.d("LoginInfoActivity.AccDevSec", 2, "------------------------------------------------------------------------------");
      }
      LoginInfoActivity.a(this.a, LoginInfoActivity.a(this.a));
      return;
    }
    if (QLog.isColorLevel())
    {
      QLog.d("LoginInfoActivity.AccDevSec", 2, "onGetLoginDevResult fail isSuccess=" + paramBoolean);
      if (paramSvcRspGetDevLoginInfo != null) {
        break label288;
      }
      QLog.d("LoginInfoActivity.AccDevSec", 2, "onGetLoginDevResult data is null");
    }
    for (;;)
    {
      bcql.a(this.a.getActivity(), 1, this.a.getString(2131692140), 0).b(this.a.getTitleBarHeight());
      return;
      label288:
      QLog.d("LoginInfoActivity.AccDevSec", 2, "onGetLoginDevResult data.iResult=" + paramSvcRspGetDevLoginInfo.iResult);
    }
  }
  
  protected void onKickOutDevFResult(boolean paramBoolean, long paramLong, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginInfoActivity.AccDevSec", 2, "onKickOutDevFResult isSuccess=" + paramBoolean + " appid=" + paramLong + " result=" + paramInt1 + " index=" + paramInt2);
    }
    LoginInfoActivity.c(this.a);
    if (paramBoolean)
    {
      if ((paramInt1 == 0) && (paramInt2 >= 1) && (paramInt2 < LoginInfoActivity.a(this.a).size()))
      {
        LoginInfoActivity.a(this.a).remove(paramInt2);
        LoginInfoActivity.a(this.a, LoginInfoActivity.a(this.a));
      }
      return;
    }
    bcql.a(this.a.getApplicationContext(), this.a.getString(2131694490), 0).b(this.a.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ablz
 * JD-Core Version:    0.7.0.1
 */