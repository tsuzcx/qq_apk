import NS_MOBILE_EXTRA.mobile_get_qzone_public_msg_rsp;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.observer.QZoneObserver;
import com.tencent.mobileqq.statistics.QZoneReport;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;

public class ahrt
  extends QZoneObserver
{
  protected void d(boolean paramBoolean, Bundle paramBundle)
  {
    paramBundle = paramBundle.getSerializable("data");
    if ((paramBoolean) && (paramBundle != null) && ((paramBundle instanceof mobile_get_qzone_public_msg_rsp)))
    {
      int i = QZoneReport.a().decrementAndGet();
      QZoneReport.a(0);
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      localAppRuntime.getPreferences().edit().putInt(localAppRuntime.getAccount() + "_" + "qzone_xp_req_left", i).apply();
      QZoneReport.b(((mobile_get_qzone_public_msg_rsp)paramBundle).next_req_tmstamp);
      if (QLog.isColorLevel()) {
        QLog.i("QZoneReport", 2, "next req time: " + QZoneReport.b() + ", left: " + i);
      }
      ReportController.b(null, "CliOper", "", "", "0X800915D", "0X800915D", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      QZoneReport.a().set(false);
      BaseApplicationImpl.getApplication().getRuntime().unRegistObserver(QZoneReport.a());
      return;
      QZoneReport.c();
      if (QLog.isColorLevel()) {
        QLog.w("QZoneReport", 2, "qzone report failed");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ahrt
 * JD-Core Version:    0.7.0.1
 */