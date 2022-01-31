import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.richmedia.capture.util.ReportBadCase;
import com.tencent.mobileqq.shortvideo.dancemachine.BadcaseReportUtils.BadDataFrame;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.manager.TicketManager;

public final class ahkx
  implements Runnable
{
  public ahkx(AppInterface paramAppInterface) {}
  
  public void run()
  {
    int k = 0;
    if (QLog.isColorLevel()) {
      QLog.d("BadcaseReportUtils", 2, "BadcaseReportUtils uploadBadCaseData begin...");
    }
    BadcaseReportUtils.BadDataFrame[] arrayOfBadDataFrame;
    int i;
    int m;
    String str;
    for (;;)
    {
      synchronized (ReportBadCase.a())
      {
        j = ReportBadCase.a().size();
        arrayOfBadDataFrame = new BadcaseReportUtils.BadDataFrame[j];
        i = 0;
        if (i < j)
        {
          arrayOfBadDataFrame[i] = ((BadcaseReportUtils.BadDataFrame)ReportBadCase.a().get(i));
          i += 1;
          break;
        }
        ReportBadCase.a().clear();
        if ((arrayOfBadDataFrame == null) || (arrayOfBadDataFrame.length <= 0))
        {
          if (QLog.isColorLevel()) {
            QLog.d("BadcaseReportUtils", 2, "BadcaseReportUtils uploadBadCaseData have no data...");
          }
          return;
        }
      }
      ??? = "" + this.a.getCurrentAccountUin();
      m = AppSetting.a;
      if (QLog.isColorLevel()) {
        QLog.d("BadcaseReportUtils", 2, "BadcaseReportUtils uploadBadCaseData size=" + localObject1.length);
      }
      str = ((TicketManager)this.a.getManager(2)).getSkey((String)???);
      if (!TextUtils.isEmpty(str)) {
        break label261;
      }
      QLog.d("BadcaseReportUtils", 2, "BadcaseReportUtils uploadBadCaseData skey error");
      i = k;
      while (i < localObject1.length)
      {
        ??? = localObject1[i];
        if ((((BadcaseReportUtils.BadDataFrame)???).d != null) && (!"".equals(((BadcaseReportUtils.BadDataFrame)???).d))) {
          FileUtils.d(((BadcaseReportUtils.BadDataFrame)???).d);
        }
        i += 1;
      }
    }
    label261:
    int j = 0;
    for (;;)
    {
      i = k;
      if (j >= localObject1.length) {
        break;
      }
      BadcaseReportUtils.BadDataFrame localBadDataFrame = localObject1[j];
      if ((localBadDataFrame.b) && (localBadDataFrame.d != null) && (!"".equals(localBadDataFrame.d))) {}
      try
      {
        ReportBadCase.a(localBadDataFrame, ReportBadCase.b(), m, (String)???, str);
        j += 1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("BadcaseReportUtils", 2, "BadcaseReportUtils uploadBadCaseData ", localException);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahkx
 * JD-Core Version:    0.7.0.1
 */