import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.util.ReportBadCase;
import com.tencent.mobileqq.shortvideo.dancemachine.BadcaseReportUtils;
import com.tencent.mobileqq.shortvideo.dancemachine.BadcaseReportUtils.BadDataFrame;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class ahpl
  implements Runnable
{
  public ahpl(ReportBadCase paramReportBadCase, BadcaseReportUtils.BadDataFrame paramBadDataFrame) {}
  
  public void run()
  {
    ??? = Bitmap.createBitmap(this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineBadcaseReportUtils$BadDataFrame.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineBadcaseReportUtils$BadDataFrame.jdField_c_of_type_Int, Bitmap.Config.ARGB_8888);
    ((Bitmap)???).copyPixelsFromBuffer(this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineBadcaseReportUtils$BadDataFrame.a);
    String str1 = ReportBadCase.a();
    boolean bool = ReportBadCase.a((Bitmap)???, str1);
    if (QLog.isColorLevel()) {
      QLog.d("BadcaseReportUtils", 2, "BadcaseReportUtils|writeBitmapToFile success=" + bool);
    }
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineBadcaseReportUtils$BadDataFrame.a = null;
    if (bool)
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineBadcaseReportUtils$BadDataFrame.jdField_b_of_type_JavaLangString = str1;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineBadcaseReportUtils$BadDataFrame.jdField_c_of_type_JavaLangString = (str1 + "_ct_2");
      BadcaseReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineBadcaseReportUtils$BadDataFrame);
      synchronized (ReportBadCase.a())
      {
        ReportBadCase.a().add(this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineBadcaseReportUtils$BadDataFrame);
      }
    }
    synchronized (ReportBadCase.a())
    {
      int i = ReportBadCase.a().size();
      if (i == 3) {
        ThreadManager.postDownLoadTask(new ahpm(this), 5, null, true);
      }
      return;
      str2 = finally;
      throw str2;
      FileUtils.d(str2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahpl
 * JD-Core Version:    0.7.0.1
 */