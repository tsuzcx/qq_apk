import com.tencent.mobileqq.richmedia.capture.util.ReportBadCase;
import com.tencent.mobileqq.shortvideo.dancemachine.BadcaseReportUtils.BadDataFrame;
import com.tencent.mobileqq.utils.FileUtils;
import java.util.ArrayList;

public final class ahpn
  implements Runnable
{
  public void run()
  {
    for (;;)
    {
      int i;
      synchronized ()
      {
        int j = ReportBadCase.a().size();
        if (j > 0)
        {
          i = 0;
          if (i < j)
          {
            BadcaseReportUtils.BadDataFrame localBadDataFrame = (BadcaseReportUtils.BadDataFrame)ReportBadCase.a().get(i);
            if ((!localBadDataFrame.b) || (localBadDataFrame.d == null) || ("".equals(localBadDataFrame.d))) {
              break label96;
            }
            FileUtils.d(localBadDataFrame.d);
            break label96;
          }
        }
        ReportBadCase.a().clear();
        ReportBadCase.b();
        return;
      }
      label96:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahpn
 * JD-Core Version:    0.7.0.1
 */