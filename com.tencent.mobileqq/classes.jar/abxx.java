import QQService.SvcDevLoginInfo;
import QQService.SvcRspGetDevLoginInfo;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.RecentLoginDevActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class abxx
  extends ajxl
{
  public abxx(RecentLoginDevActivity paramRecentLoginDevActivity) {}
  
  protected void onDelHistoryDevResult(boolean paramBoolean, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.devlock.RecentLoginDevActivity", 2, "onDelHistoryDevResult isSuccess=" + paramBoolean + " errorMsg=" + paramString + " index=" + paramInt);
    }
    RecentLoginDevActivity.b(this.a);
    if (paramBoolean)
    {
      axqw.b(this.a.app, "CliOper", "", "", "My_eq", "Delete_eq", 0, 0, "", "", "", "");
      if ((paramInt > -1) && (RecentLoginDevActivity.a(this.a) != null) && (paramInt < RecentLoginDevActivity.a(this.a).size()))
      {
        RecentLoginDevActivity.a(this.a).remove(paramInt);
        RecentLoginDevActivity.a(this.a, RecentLoginDevActivity.a(this.a));
      }
      bcpw.a(this.a.getApplicationContext(), 2, this.a.getString(2131692124), 0).b(this.a.getTitleBarHeight());
      return;
    }
    if (TextUtils.isEmpty(paramString))
    {
      bcpw.a(this.a.getApplicationContext(), 1, this.a.getString(2131694486), 0).b(this.a.getTitleBarHeight());
      return;
    }
    bcpw.a(this.a.getApplicationContext(), 1, paramString, 0).b(this.a.getTitleBarHeight());
  }
  
  protected void onGetHistoryDevResult(boolean paramBoolean, SvcRspGetDevLoginInfo paramSvcRspGetDevLoginInfo)
  {
    RecentLoginDevActivity.b(this.a);
    if ((paramBoolean) && (paramSvcRspGetDevLoginInfo != null) && (paramSvcRspGetDevLoginInfo.iResult == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.devlock.RecentLoginDevActivity", 2, "onGetHistoryDevResult success");
      }
      RecentLoginDevActivity.a(this.a, paramSvcRspGetDevLoginInfo.vecHistoryLoginDevInfo);
      if (QLog.isColorLevel())
      {
        QLog.d("Q.devlock.RecentLoginDevActivity", 2, "------------------------------------------------------------------------------");
        paramSvcRspGetDevLoginInfo = RecentLoginDevActivity.a(this.a).iterator();
        while (paramSvcRspGetDevLoginInfo.hasNext())
        {
          SvcDevLoginInfo localSvcDevLoginInfo = (SvcDevLoginInfo)paramSvcRspGetDevLoginInfo.next();
          if (localSvcDevLoginInfo != null) {
            QLog.d("Q.devlock.RecentLoginDevActivity", 2, "SvcDevLoginInfo.iAppId=" + localSvcDevLoginInfo.iAppId + " iLoginTime=" + localSvcDevLoginInfo.iLoginTime + " strLoginLocation=" + localSvcDevLoginInfo.strLoginLocation + " iLoginPlatform=" + localSvcDevLoginInfo.iLoginPlatform + " strDeviceName=" + localSvcDevLoginInfo.strDeviceName + " strDeviceTypeInfo" + localSvcDevLoginInfo.strDeviceTypeInfo);
          }
        }
        QLog.d("Q.devlock.RecentLoginDevActivity", 2, "------------------------------------------------------------------------------");
      }
      RecentLoginDevActivity.a(this.a, RecentLoginDevActivity.a(this.a));
      return;
    }
    if (QLog.isColorLevel())
    {
      QLog.d("Q.devlock.RecentLoginDevActivity", 2, "onGetHistoryDevResult failed isSuccess=" + paramBoolean);
      if (paramSvcRspGetDevLoginInfo != null) {
        break label288;
      }
      QLog.d("Q.devlock.RecentLoginDevActivity", 2, "onGetHistoryDevResult failed data is null");
    }
    for (;;)
    {
      bcpw.a(this.a.getActivity(), 1, this.a.getString(2131692140), 0).b(this.a.getTitleBarHeight());
      return;
      label288:
      QLog.d("Q.devlock.RecentLoginDevActivity", 2, "onGetHistoryDevResult failed data.iResult=" + paramSvcRspGetDevLoginInfo.iResult);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abxx
 * JD-Core Version:    0.7.0.1
 */