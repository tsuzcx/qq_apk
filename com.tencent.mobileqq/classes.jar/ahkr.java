import com.tencent.mobileqq.richmedia.capture.util.CaptureReportUtil;
import com.tencent.mobileqq.richmedia.capture.util.DanceGameReporter;
import com.tencent.mobileqq.shortvideo.dancemachine.BoyDataReport;
import com.tencent.mobileqq.shortvideo.dancemachine.BoyDataReport.BoyItem;
import java.util.ArrayList;
import java.util.Iterator;

public final class ahkr
  implements Runnable
{
  public ahkr(BoyDataReport paramBoyDataReport) {}
  
  public void run()
  {
    CaptureReportUtil.a(this.a.b, this.a.jdField_a_of_type_Long);
    Iterator localIterator = this.a.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      BoyDataReport.BoyItem localBoyItem = (BoyDataReport.BoyItem)localIterator.next();
      if (localBoyItem.jdField_a_of_type_Boolean) {
        CaptureReportUtil.a(localBoyItem.jdField_a_of_type_JavaLangString, "" + localBoyItem.jdField_a_of_type_Int, CaptureReportUtil.a(localBoyItem.b));
      }
    }
    DanceGameReporter.a().a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahkr
 * JD-Core Version:    0.7.0.1
 */