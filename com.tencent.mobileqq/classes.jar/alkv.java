import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.agent.report.BaseData;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.open.base.APNUtil;
import com.tencent.open.business.base.OpenConfig;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class alkv
  implements Runnable
{
  public alkv(ReportCenter paramReportCenter, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, String paramString3, boolean paramBoolean) {}
  
  public void run()
  {
    int j = 1;
    for (;;)
    {
      try
      {
        localObject1 = new Bundle();
        Object localObject3 = APNUtil.a(CommonDataAdapter.a().a());
        ((Bundle)localObject1).putString("apn", (String)localObject3);
        ((Bundle)localObject1).putString("appid", "" + this.jdField_a_of_type_Int);
        ((Bundle)localObject1).putString("commandid", this.jdField_a_of_type_JavaLangString);
        ((Bundle)localObject1).putString("detail", this.jdField_b_of_type_JavaLangString);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("network=").append((String)localObject3).append('&');
        localObject3 = localStringBuilder.append("sdcard=");
        if (Environment.getExternalStorageState().equals("mounted"))
        {
          i = 1;
          ((StringBuilder)localObject3).append(i).append('&');
          localStringBuilder.append("wifi=").append(APNUtil.e(CommonDataAdapter.a().a()));
          ((Bundle)localObject1).putString("deviceInfo", localStringBuilder.toString());
          i = 100 / this.jdField_b_of_type_Int;
          if (i > 0) {
            continue;
          }
          i = j;
          ((Bundle)localObject1).putString("frequency", "" + i);
          ((Bundle)localObject1).putString("reqSize", "0");
          ((Bundle)localObject1).putString("resultCode", this.jdField_c_of_type_Int + "");
          ((Bundle)localObject1).putString("rspSize", "0");
          ((Bundle)localObject1).putString("timeCost", "0");
          ((Bundle)localObject1).putString("uin", this.jdField_c_of_type_JavaLangString + "");
          localObject1 = new BaseData((Bundle)localObject1);
        }
      }
      catch (Exception localException)
      {
        Object localObject1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ReportCenter", 2, "-->reportCgi, exception in sub thread.", localException);
        return;
      }
      try
      {
        this.jdField_a_of_type_ComTencentOpenAgentReportReportCenter.jdField_a_of_type_JavaUtilArrayList.add(localObject1);
        j = OpenConfig.a(CommonDataAdapter.a().a(), null).a("Agent_ReportTimeInterval");
        i = j;
        if (j == 0) {
          i = 10000;
        }
        if (!this.jdField_a_of_type_Boolean) {
          break label407;
        }
        this.jdField_a_of_type_ComTencentOpenAgentReportReportCenter.a(null);
        this.jdField_a_of_type_ComTencentOpenAgentReportReportCenter.jdField_a_of_type_AndroidOsHandler.removeMessages(1000);
        return;
      }
      finally {}
      int i = 0;
      continue;
      if (i > 100)
      {
        i = 100;
        continue;
        label407:
        if (!this.jdField_a_of_type_ComTencentOpenAgentReportReportCenter.jdField_a_of_type_AndroidOsHandler.hasMessages(1000))
        {
          Message localMessage = Message.obtain();
          localMessage.what = 1000;
          this.jdField_a_of_type_ComTencentOpenAgentReportReportCenter.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, i);
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     alkv
 * JD-Core Version:    0.7.0.1
 */