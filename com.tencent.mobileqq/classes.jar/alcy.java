import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings.Secure;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.agent.report.BaseData;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.open.agent.report.ReportDatabaseHelper;
import com.tencent.open.base.APNUtil;
import com.tencent.open.business.base.MobileInfoUtil;
import com.tencent.open.business.base.OpenConfig;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.TimeZone;

public class alcy
  implements Runnable
{
  public alcy(ReportCenter paramReportCenter, String paramString, Bundle paramBundle, boolean paramBoolean) {}
  
  public void run()
  {
    int i;
    do
    {
      try
      {
        ??? = new Bundle();
        ((Bundle)???).putString("uin", this.jdField_a_of_type_JavaLangString);
        ((Bundle)???).putString("imei", MobileInfoUtil.c());
        ((Bundle)???).putString("imsi", MobileInfoUtil.d());
        ((Bundle)???).putString("android_id", Settings.Secure.getString(CommonDataAdapter.a().a().getContentResolver(), "android_id"));
        ((Bundle)???).putString("mac", MobileInfoUtil.a());
        ((Bundle)???).putString("platform", "4");
        ((Bundle)???).putString("os_ver", Build.VERSION.RELEASE);
        ((Bundle)???).putString("position", MobileInfoUtil.f());
        ((Bundle)???).putString("network", APNUtil.a(CommonDataAdapter.a().a()));
        ((Bundle)???).putString("language", MobileInfoUtil.b());
        ((Bundle)???).putString("resolution", MobileInfoUtil.e());
        ((Bundle)???).putString("apn", APNUtil.b(CommonDataAdapter.a().a()));
        ((Bundle)???).putString("model_name", Build.MODEL);
        ((Bundle)???).putString("timezone", TimeZone.getDefault().getID());
        ((Bundle)???).putString("qq_ver", CommonDataAdapter.a().c());
        ((Bundle)???).putString("qua", CommonDataAdapter.a().f());
        ((Bundle)???).putString("via", "2");
        ((Bundle)???).putString("result", "0");
        if (this.jdField_a_of_type_AndroidOsBundle != null) {
          ((Bundle)???).putAll(this.jdField_a_of_type_AndroidOsBundle);
        }
        localBaseData = new BaseData((Bundle)???);
      }
      catch (Exception localException)
      {
        BaseData localBaseData;
        int k;
        int m;
        int j;
        while (!QLog.isColorLevel()) {}
        QLog.d("ReportCenter", 2, "-->reportVia, exception in sub thread.", localException);
        return;
      }
      synchronized (this.jdField_a_of_type_ComTencentOpenAgentReportReportCenter)
      {
        this.jdField_a_of_type_ComTencentOpenAgentReportReportCenter.b.add(localBaseData);
        k = this.jdField_a_of_type_ComTencentOpenAgentReportReportCenter.b.size();
        m = ReportDatabaseHelper.a().a("report_via");
        j = OpenConfig.a(CommonDataAdapter.a().a(), null).a("Agent_ReportTimeInterval");
        i = j;
        if (j == 0) {
          i = 10000;
        }
        if ((this.jdField_a_of_type_ComTencentOpenAgentReportReportCenter.a("report_via", m + k)) || (this.jdField_a_of_type_Boolean))
        {
          this.jdField_a_of_type_ComTencentOpenAgentReportReportCenter.a();
          this.jdField_a_of_type_ComTencentOpenAgentReportReportCenter.a.removeMessages(1001);
          return;
        }
      }
    } while (this.jdField_a_of_type_ComTencentOpenAgentReportReportCenter.a.hasMessages(1001));
    Message localMessage = Message.obtain();
    localMessage.what = 1001;
    this.jdField_a_of_type_ComTencentOpenAgentReportReportCenter.a.sendMessageDelayed(localMessage, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     alcy
 * JD-Core Version:    0.7.0.1
 */