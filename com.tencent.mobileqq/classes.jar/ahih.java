import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.report.SpringHbReportManager;
import com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.report.SpringHbReportManager.ReportInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class ahih
{
  public static void a(String paramString, int paramInt1, int paramInt2, Map<String, String> paramMap)
  {
    a(paramString, paramInt1, paramInt2, paramMap, false);
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2, Map<String, String> paramMap, boolean paramBoolean)
  {
    paramString = SpringHbReportManager.ReportInfo.create(paramString, paramInt1, paramInt2, paramMap, paramBoolean);
    if ((paramString == null) || (!paramString.isValid()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("springHb_report_SpringHbReporter", 2, "[report] reportInfo is invalid" + paramString);
      }
      return;
    }
    paramMap = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramMap instanceof QQAppInterface))
    {
      ((SpringHbReportManager)((QQAppInterface)paramMap).getManager(344)).a(paramString);
      return;
    }
    paramMap = new Bundle();
    paramMap.putSerializable("key1", paramString);
    QIPCClientHelper.getInstance().callServer("SpringHbIPCModule", "ReportData", paramMap, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahih
 * JD-Core Version:    0.7.0.1
 */