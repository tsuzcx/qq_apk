import QQService.SvcDevLoginInfo;
import QQService.SvcRspGetDevLoginInfo;
import android.text.TextUtils;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.activity.AuthDevActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;
import mqq.manager.WtloginManager;

public class adnx
  extends anmu
{
  public adnx(AuthDevActivity paramAuthDevActivity) {}
  
  protected void onDelAuthDevResult(boolean paramBoolean, String paramString, int paramInt)
  {
    boolean bool = false;
    QLog.d("Q.devlock.AuthDevActivity", 1, new Object[] { "onDelAuthDevResult.isSuccess=", Boolean.valueOf(paramBoolean), " errorMsg=", paramString, " index=", Integer.valueOf(paramInt) });
    AuthDevActivity.c(this.a);
    List localList;
    if (AuthDevActivity.a(this.a)) {
      localList = AuthDevActivity.b(this.a);
    }
    while (paramBoolean)
    {
      if ((paramInt > -1) && (paramInt < localList.size()))
      {
        paramString = (SvcDevLoginInfo)localList.get(paramInt);
        if (Arrays.equals(NetConnInfoCenter.GUID, paramString.vecGuid))
        {
          this.a.app.updateSubAccountLogin(this.a.app.getAccount(), false);
          this.a.app.getApplication().refreAccountList();
          bgig.a(this.a, this.a.app, true);
          paramString = this.a.app.getManager(1);
          paramBoolean = bool;
          if (paramString == null) {
            paramBoolean = true;
          }
          QLog.d("Q.devlock.AuthDevActivity", 1, new Object[] { "clear login sig, manage is null : [", Boolean.valueOf(paramBoolean), "]" });
          if (paramString != null)
          {
            paramString = (WtloginManager)paramString;
            paramString.ClearUserFastLoginData(this.a.app.getAccount(), 16L);
            paramString.RefreshMemorySig();
          }
          return;
          localList = AuthDevActivity.a(this.a);
          continue;
        }
        if (paramInt < localList.size())
        {
          localList.remove(paramInt);
          AuthDevActivity.a(this.a, localList);
        }
      }
      QQToast.a(this.a.getApplicationContext(), 2, this.a.getString(2131691819), 0).b(this.a.getTitleBarHeight());
      return;
    }
    if (TextUtils.isEmpty(paramString))
    {
      QQToast.a(this.a.getApplicationContext(), 1, this.a.getString(2131691818), 0).b(this.a.getTitleBarHeight());
      return;
    }
    QQToast.a(this.a.getApplicationContext(), 1, paramString, 0).b(this.a.getTitleBarHeight());
  }
  
  protected void onDelHistoryDevResult(boolean paramBoolean, String paramString, int paramInt)
  {
    QLog.d("Q.devlock.AuthDevActivity", 1, "onDelHistoryDevResult isSuccess=" + paramBoolean + " errorMsg=" + paramString + " index=" + paramInt);
    AuthDevActivity.c(this.a);
    if (paramBoolean)
    {
      bcst.b(this.a.app, "CliOper", "", "", "My_eq", "Delete_eq", 0, 0, "", "", "", "");
      if ((paramInt > -1) && (AuthDevActivity.a(this.a) != null) && (paramInt < AuthDevActivity.a(this.a).size()))
      {
        AuthDevActivity.a(this.a).remove(paramInt);
        AuthDevActivity.a(this.a, AuthDevActivity.a(this.a));
      }
      QQToast.a(this.a.getApplicationContext(), 2, this.a.getString(2131691819), 0).b(this.a.getTitleBarHeight());
      return;
    }
    if (TextUtils.isEmpty(paramString))
    {
      QQToast.a(this.a.getApplicationContext(), 1, this.a.getString(2131693897), 0).b(this.a.getTitleBarHeight());
      return;
    }
    QQToast.a(this.a.getApplicationContext(), 1, paramString, 0).b(this.a.getTitleBarHeight());
  }
  
  protected void onGetAuthDevResult(boolean paramBoolean, SvcRspGetDevLoginInfo paramSvcRspGetDevLoginInfo)
  {
    AuthDevActivity.a(this.a).setVisibility(8);
    if (!AuthDevActivity.a(this.a)) {
      return;
    }
    if ((paramBoolean) && (paramSvcRspGetDevLoginInfo != null) && (paramSvcRspGetDevLoginInfo.iResult == 0))
    {
      QLog.d("Q.devlock.AuthDevActivity", 1, "onGetAuthDevResult.success");
      AuthDevActivity.b(this.a, paramSvcRspGetDevLoginInfo.vecAuthLoginDevInfo);
      if (QLog.isColorLevel())
      {
        QLog.d("Q.devlock.AuthDevActivity", 2, "------------------------------------------------------------------------------");
        paramSvcRspGetDevLoginInfo = AuthDevActivity.b(this.a).iterator();
        while (paramSvcRspGetDevLoginInfo.hasNext())
        {
          SvcDevLoginInfo localSvcDevLoginInfo = (SvcDevLoginInfo)paramSvcRspGetDevLoginInfo.next();
          if (localSvcDevLoginInfo != null) {
            QLog.d("Q.devlock.AuthDevActivity", 2, "SvcDevLoginInfo.iAppId=" + localSvcDevLoginInfo.iAppId + " iLoginTime=" + localSvcDevLoginInfo.iLoginTime + " strLoginLocation=" + localSvcDevLoginInfo.strLoginLocation + " iLoginPlatform=" + localSvcDevLoginInfo.iLoginPlatform + " strDeviceName=" + localSvcDevLoginInfo.strDeviceName + " strDeviceTypeInfo" + localSvcDevLoginInfo.strDeviceTypeInfo);
          }
        }
        QLog.d("Q.devlock.AuthDevActivity", 2, "------------------------------------------------------------------------------");
      }
      AuthDevActivity.a(this.a, AuthDevActivity.b(this.a));
      return;
    }
    QLog.d("Q.devlock.AuthDevActivity", 1, "onGetAuthDevResult.isSuccess=" + paramBoolean);
    if (paramSvcRspGetDevLoginInfo == null) {
      QLog.d("Q.devlock.AuthDevActivity", 1, "onGetAuthDevResult.data is null");
    }
    for (;;)
    {
      AuthDevActivity.a(this.a).setVisibility(4);
      QQToast.a(this.a, 1, this.a.getString(2131691830), 0).b(this.a.getTitleBarHeight());
      return;
      QLog.d("Q.devlock.AuthDevActivity", 1, "onGetAuthDevResult.data.iResult=" + paramSvcRspGetDevLoginInfo.iResult);
    }
  }
  
  protected void onGetHistoryDevResult(boolean paramBoolean, SvcRspGetDevLoginInfo paramSvcRspGetDevLoginInfo)
  {
    AuthDevActivity.a(this.a).setVisibility(8);
    if ((paramBoolean) && (paramSvcRspGetDevLoginInfo != null) && (paramSvcRspGetDevLoginInfo.iResult == 0))
    {
      QLog.d("Q.devlock.AuthDevActivity", 1, "onGetHistoryDevResult success");
      AuthDevActivity.a(this.a).addAll(paramSvcRspGetDevLoginInfo.vecHistoryLoginDevInfo);
      AuthDevActivity.a(this.a, AuthDevActivity.a(this.a));
      return;
    }
    String str;
    if (paramSvcRspGetDevLoginInfo == null)
    {
      str = "";
      if (paramSvcRspGetDevLoginInfo != null) {
        break label176;
      }
    }
    label176:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("Q.devlock.AuthDevActivity", 1, new Object[] { "onGetHistoryDevResult fail isSuccess=", Boolean.valueOf(paramBoolean), " data==null ? ", Boolean.valueOf(bool), "errorResult : ", str });
      QQToast.a(this.a.getActivity(), 1, this.a.getString(2131691830), 0).b(this.a.getTitleBarHeight());
      return;
      str = String.valueOf(paramSvcRspGetDevLoginInfo.iResult);
      break;
    }
  }
  
  protected void onGetLoginDevResult(boolean paramBoolean, SvcRspGetDevLoginInfo paramSvcRspGetDevLoginInfo)
  {
    AuthDevActivity.a(this.a).setVisibility(8);
    if ((paramBoolean) && (paramSvcRspGetDevLoginInfo != null) && (paramSvcRspGetDevLoginInfo.iResult == 0))
    {
      QLog.d("Q.devlock.AuthDevActivity", 1, "onGetLoginDevResult success");
      AuthDevActivity.a(this.a, paramSvcRspGetDevLoginInfo.vecCurrentLoginDevInfo);
      AuthDevActivity.a(this.a).addAll(0, AuthDevActivity.c(this.a));
      AuthDevActivity.a(this.a, AuthDevActivity.a(this.a));
      return;
    }
    String str;
    if (paramSvcRspGetDevLoginInfo == null)
    {
      str = "";
      if (paramSvcRspGetDevLoginInfo != null) {
        break label192;
      }
    }
    label192:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("Q.devlock.AuthDevActivity", 1, new Object[] { "onGetLoginDevResult fail isSuccess=", Boolean.valueOf(paramBoolean), " data==null ? ", Boolean.valueOf(bool), "errorResult : ", str });
      QQToast.a(this.a.getActivity(), 1, this.a.getString(2131691830), 0).b(this.a.getTitleBarHeight());
      return;
      str = String.valueOf(paramSvcRspGetDevLoginInfo.iResult);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adnx
 * JD-Core Version:    0.7.0.1
 */