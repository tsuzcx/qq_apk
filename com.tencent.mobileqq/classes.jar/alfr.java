import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.open.base.APNUtil;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.http.HttpCgiAsyncTask;
import com.tencent.open.business.base.AppUtil;
import com.tencent.open.business.base.appreport.AppReport;
import com.tencent.open.business.base.appreport.AppReport.IncrementalReportCallback;
import com.tencent.open.business.base.appreport.AppUpdate;
import com.tencent.smtt.sdk.WebView;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;

public final class alfr
  implements Runnable
{
  public alfr(String paramString1, int paramInt, Context paramContext, String paramString2, WebView paramWebView, String paramString3) {}
  
  public void run()
  {
    int m = 0;
    for (;;)
    {
      try
      {
        LogUtility.b("AppReport", "<AppReport> begin incrementalReport,packageName : " + this.jdField_a_of_type_JavaLangString + ", packageType :" + this.jdField_a_of_type_Int);
        if (this.jdField_a_of_type_AndroidContentContext == null)
        {
          LogUtility.e("AppReport", "<AppReport> incrementalReport context is null !");
          return;
        }
        HashMap localHashMap = new HashMap();
        Object localObject2;
        Object localObject3;
        int k;
        if ((this.jdField_a_of_type_JavaLangString == null) || (!this.jdField_a_of_type_JavaLangString.equals("com.tencent.android.qqdownloader")) || (this.jdField_a_of_type_Int != 8))
        {
          Object localObject1 = this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("appcenter_app_report", 0);
          boolean bool1 = ((SharedPreferences)localObject1).getBoolean("is_app_last_fullReport_success", false);
          if (!AppUtil.a(this.jdField_a_of_type_AndroidContentContext))
          {
            LogUtility.c("AppReport", "<AppReport> Package scan is closed !!!!");
            if (bool1) {
              j = this.jdField_a_of_type_Int;
            }
            try
            {
              localObject1 = this.jdField_a_of_type_AndroidContentContext.getPackageManager().getPackageInfo(this.jdField_a_of_type_JavaLangString, 0);
              if ((((PackageInfo)localObject1).applicationInfo.flags & 0x1) != 0) {
                continue;
              }
              i = j;
              if ((((PackageInfo)localObject1).applicationInfo.flags & 0x80) != 0) {
                continue;
              }
              AppReport.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, i);
            }
            catch (PackageManager.NameNotFoundException localNameNotFoundException1)
            {
              LogUtility.c("AppReport", "<AppReport> Package scan is closed, get packageinfo error : " + localNameNotFoundException1.toString());
              continue;
            }
            if ((this.b != null) && (this.jdField_a_of_type_ComTencentSmttSdkWebView != null)) {
              AppUpdate.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentSmttSdkWebView, this.b, true, this.c);
            }
          }
          else
          {
            long l = localNameNotFoundException1.getLong("app_last_fullReport_success_time", 0L);
            boolean bool2 = localNameNotFoundException1.getBoolean("is_incremental_report_overflow", false);
            if (l != 0L)
            {
              if (!bool1)
              {
                LogUtility.c("AppReport", "last full report failed , do incremental report !!!");
                AppReport.a(this.jdField_a_of_type_AndroidContentContext, this.b, this.jdField_a_of_type_ComTencentSmttSdkWebView, this.c, true);
                return;
              }
              if (bool2)
              {
                LogUtility.c("AppReport", "last incremental report overflow , do full report !!!");
                AppReport.a(this.jdField_a_of_type_AndroidContentContext, this.b, this.jdField_a_of_type_ComTencentSmttSdkWebView, this.c, true);
                return;
              }
              localObject2 = AppReport.a(this.jdField_a_of_type_AndroidContentContext);
              if ((localObject2 != null) && (((Map)localObject2).size() >= 70))
              {
                AppReport.a.lock();
                this.jdField_a_of_type_AndroidContentContext.deleteFile("appcenter_app_report_storage_file.txt");
                AppReport.a.unlock();
                localObject2 = this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("appcenter_app_report", 0).edit();
                ((SharedPreferences.Editor)localObject2).putBoolean("is_incremental_report_overflow", true);
                ((SharedPreferences.Editor)localObject2).commit();
                AppReport.a(this.jdField_a_of_type_AndroidContentContext, this.b, this.jdField_a_of_type_ComTencentSmttSdkWebView, this.c, true);
                return;
              }
              if ((localObject2 != null) && (((Map)localObject2).size() > 0)) {
                localHashMap.putAll((Map)localObject2);
              }
              localObject3 = new StringBuilder().append("<AppReport> increamental report package local size :");
              if (localObject2 == null) {
                break label1153;
              }
              i = ((Map)localObject2).size();
              LogUtility.b("AppReport", i);
            }
          }
        }
        else
        {
          k = this.jdField_a_of_type_Int;
          j = k;
          String str1;
          String str2;
          if (this.b == null)
          {
            j = k;
            if (this.jdField_a_of_type_JavaLangString != null)
            {
              str1 = "0";
              str2 = " ";
              localObject2 = str2;
              localObject3 = str1;
              i = m;
            }
          }
          try
          {
            localObject4 = this.jdField_a_of_type_AndroidContentContext.getPackageManager().getPackageInfo(this.jdField_a_of_type_JavaLangString, 0);
            localObject2 = str2;
            localObject3 = str1;
            i = m;
            m = ((PackageInfo)localObject4).versionCode;
            localObject2 = str2;
            localObject3 = str1;
            i = m;
            str1 = ((PackageInfo)localObject4).versionName;
            localObject2 = str2;
            localObject3 = str1;
            i = m;
            str2 = AppUtil.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString);
            localObject2 = str2;
            localObject3 = str1;
            i = m;
            if ((((PackageInfo)localObject4).applicationInfo.flags & 0x1) == 0)
            {
              localObject2 = str2;
              localObject3 = str1;
              i = m;
              int i1 = ((PackageInfo)localObject4).applicationInfo.flags;
              j = k;
              localObject4 = str2;
              localObject5 = str1;
              n = m;
              if ((i1 & 0x80) == 0) {}
            }
            else
            {
              j = k | 0x1;
              n = m;
              localObject5 = str1;
              localObject4 = str2;
            }
          }
          catch (PackageManager.NameNotFoundException localNameNotFoundException2)
          {
            j = k;
            Object localObject4 = localObject2;
            Object localObject5 = localObject3;
            int n = i;
            if (this.jdField_a_of_type_Int == 8) {
              continue;
            }
            LogUtility.e("AppReport", "<AppReport> get Package info form package <" + this.jdField_a_of_type_JavaLangString + "> error : " + localNameNotFoundException2.toString());
            j = k;
            localObject4 = localObject2;
            localObject5 = localObject3;
            n = i;
            continue;
            LogUtility.b("AppReport", "<AppReport> increamental report package size : " + localHashMap.size());
            localObject2 = AppReport.a(this.jdField_a_of_type_AndroidContentContext, localHashMap, "INC", this.c);
            LogUtility.b("AppReport", "<AppReport> incremental report params : " + ((Bundle)localObject2).toString());
            if (APNUtil.b(this.jdField_a_of_type_AndroidContentContext)) {
              continue;
            }
            AppReport.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, j);
            return;
            if (!TextUtils.isEmpty(((Bundle)localObject2).getString("sid"))) {
              continue;
            }
            if ((this.jdField_a_of_type_JavaLangString == null) || (!this.jdField_a_of_type_JavaLangString.equals("com.tencent.android.qqdownloader")) || (this.jdField_a_of_type_Int != 8)) {
              continue;
            }
            LogUtility.b("AppReport", "<AppReport> incremental report sid is null but still report myapp uninstall event");
            ((Bundle)localObject2).putString("sid", "fakesid");
            new HttpCgiAsyncTask("http://fusionbase.qq.com/cgi-bin/appstage/sdk_update", "POST", new AppReport.IncrementalReportCallback(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, j, this.b, this.jdField_a_of_type_ComTencentSmttSdkWebView)).execute(new Bundle[] { localObject2 });
            return;
            AppReport.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, j);
            return;
            new HttpCgiAsyncTask("http://fusionbase.qq.com/cgi-bin/appstage/sdk_update", "POST", new AppReport.IncrementalReportCallback(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, j, this.b, this.jdField_a_of_type_ComTencentSmttSdkWebView)).execute(new Bundle[] { localObject2 });
          }
          localHashMap.put(this.jdField_a_of_type_JavaLangString, AppReport.a(this.jdField_a_of_type_JavaLangString, n, (String)localObject5, j, (String)localObject4));
          if (localHashMap.size() <= 0)
          {
            LogUtility.b("AppReport", "<AppReport> Nothing to report, Incremental report finished !");
            return;
          }
        }
        return;
      }
      catch (Throwable localThrowable)
      {
        int j;
        return;
      }
      int i = j | 0x1;
      continue;
      label1153:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     alfr
 * JD-Core Version:    0.7.0.1
 */