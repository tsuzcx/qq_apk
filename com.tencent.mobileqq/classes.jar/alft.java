import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.APNUtil;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.http.HttpCgiAsyncTask;
import com.tencent.open.business.base.AppUtil;
import com.tencent.open.business.base.appreport.AppReport;
import com.tencent.open.business.base.appreport.AppReport.FullReportCallback;
import com.tencent.open.business.base.appreport.AppUpdate;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

class alft
  implements Runnable
{
  alft(alfs paramalfs) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        LogUtility.b("AppReport", "<AppReport> begin doFullReport ...");
        if (this.a.jdField_a_of_type_AndroidContentContext == null)
        {
          LogUtility.e("AppReport", "<AppReport> fullReport context is null !");
          return;
        }
        if (AppReport.jdField_a_of_type_Boolean)
        {
          if ((this.a.jdField_a_of_type_JavaLangString != null) && (this.a.jdField_a_of_type_ComTencentSmttSdkWebView != null))
          {
            boolean bool = AppReport.jdField_a_of_type_Boolean;
            if (bool)
            {
              try
              {
                LogUtility.c("AppReport", "<AppReport>Wait 100 milliseconds for another full report finished,before getUpdateAppRequest");
                Thread.sleep(new Random().nextInt(50) + 50L);
              }
              catch (InterruptedException localInterruptedException)
              {
                LogUtility.e("AppReport", "<AppReport> fullReport context is null !");
              }
              continue;
            }
            if (this.a.jdField_a_of_type_AndroidContentContext.getSharedPreferences("appcenter_app_report", 0).getBoolean("is_app_last_fullReport_success", false))
            {
              AppUpdate.a(this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_ComTencentSmttSdkWebView, this.a.jdField_a_of_type_JavaLangString, true, this.a.b);
              return;
            }
            AppUpdate.a(this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_ComTencentSmttSdkWebView, this.a.jdField_a_of_type_JavaLangString, false, this.a.b);
            return;
          }
          LogUtility.c("AppReport", "<AppReport>Another full report running, fullReport will not continue !!!");
          return;
        }
        AppReport.jdField_a_of_type_Boolean = true;
        if ((this.a.jdField_a_of_type_JavaLangString != null) && (this.a.jdField_a_of_type_ComTencentSmttSdkWebView != null))
        {
          LogUtility.c("AppReport", "<AppReport> onResult get app update list without full report");
          if ((!AppReport.a()) || (!AppReport.a(this.a.jdField_a_of_type_AndroidContentContext)))
          {
            LogUtility.c("AppReport", "doFullReport get app update list without full report, because : full report switch off, or Over max full report times a day");
            AppReport.jdField_a_of_type_Boolean = false;
            AppUpdate.a(this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_ComTencentSmttSdkWebView, this.a.jdField_a_of_type_JavaLangString, false, this.a.b);
            return;
          }
          if (!AppUtil.a(this.a.jdField_a_of_type_AndroidContentContext))
          {
            LogUtility.c("AppReport", "<AppReport> doFullReport get app update list without full report, because : packageScan is not allowed");
            AppReport.jdField_a_of_type_Boolean = false;
            AppUpdate.a(this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_ComTencentSmttSdkWebView, this.a.jdField_a_of_type_JavaLangString, true, this.a.b);
          }
        }
        else if (!AppUtil.a(this.a.jdField_a_of_type_AndroidContentContext))
        {
          LogUtility.c("AppReport", "<AppReport> doFullReport will not continue , because : packageScan is not allowed");
          AppReport.jdField_a_of_type_Boolean = false;
          return;
        }
        Object localObject2 = AppUtil.a(this.a.jdField_a_of_type_AndroidContentContext);
        if ((localObject2 != null) && (((List)localObject2).size() > 0))
        {
          Object localObject1 = new HashMap();
          localObject2 = ((List)localObject2).iterator();
          if (((Iterator)localObject2).hasNext())
          {
            PackageInfo localPackageInfo = (PackageInfo)((Iterator)localObject2).next();
            if ((localPackageInfo.applicationInfo.flags & 0x1) != 0) {
              break label813;
            }
            if ((localPackageInfo.applicationInfo.flags & 0x80) != 0)
            {
              break label813;
              ((Map)localObject1).put(localPackageInfo.packageName, AppReport.a(localPackageInfo.packageName, localPackageInfo.versionCode, localPackageInfo.versionName, i, AppUtil.a(this.a.jdField_a_of_type_AndroidContentContext, localPackageInfo.packageName)));
            }
          }
          else
          {
            localObject1 = AppReport.a(this.a.jdField_a_of_type_AndroidContentContext, (Map)localObject1, "ALL", this.a.b);
            LogUtility.b("AppReport", "<AppReport> incremental report params : " + ((Bundle)localObject1).toString());
            if ((!APNUtil.b(this.a.jdField_a_of_type_AndroidContentContext)) || (((Bundle)localObject1).getString("sid").equals("")))
            {
              localObject1 = this.a.jdField_a_of_type_AndroidContentContext.getSharedPreferences("appcenter_app_report", 0).edit();
              ((SharedPreferences.Editor)localObject1).putBoolean("is_app_last_fullReport_success", false);
              ((SharedPreferences.Editor)localObject1).commit();
              LogUtility.b("AppReport", "<AppReport> full report stoped !!! because network is unavaliable or get sid error");
              AppReport.jdField_a_of_type_Boolean = false;
              if ((!this.a.jdField_a_of_type_Boolean) || (this.a.jdField_a_of_type_ComTencentSmttSdkWebView == null)) {
                continue;
              }
              CommonDataAdapter.a().a("{\"guid\":1,\"method\":\"POST\"}", this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_ComTencentSmttSdkWebView);
              return;
            }
            LogUtility.b("AppReport", "<AppReport> do full report to server !!!");
            new HttpCgiAsyncTask("http://fusionbase.qq.com/cgi-bin/appstage/sdk_update", "POST", new AppReport.FullReportCallback(this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentSmttSdkWebView)).execute(new Bundle[] { localObject1 });
            continue;
          }
        }
        else
        {
          if ((this.a.jdField_a_of_type_JavaLangString == null) || (this.a.jdField_a_of_type_ComTencentSmttSdkWebView == null)) {
            continue;
          }
          AppUpdate.a(this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_ComTencentSmttSdkWebView, this.a.jdField_a_of_type_JavaLangString, true, this.a.b);
          AppReport.jdField_a_of_type_Boolean = false;
          continue;
        }
        i = 0;
        continue;
        return;
      }
      catch (Throwable localThrowable)
      {
        return;
      }
      label813:
      int i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     alft
 * JD-Core Version:    0.7.0.1
 */