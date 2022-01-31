import com.tencent.mobileqq.ar.ScanningSurfaceView;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.CopyOnWriteArrayList;

public class aakw
  implements Runnable
{
  public aakw(ScanningSurfaceView paramScanningSurfaceView, String paramString1, String paramString2) {}
  
  public void run()
  {
    if (ScanningSurfaceView.a(this.jdField_a_of_type_ComTencentMobileqqArScanningSurfaceView).size() > 0)
    {
      ScanningSurfaceView.b(this.jdField_a_of_type_ComTencentMobileqqArScanningSurfaceView).add(this.jdField_a_of_type_JavaLangString);
      ScanningSurfaceView.a(this.jdField_a_of_type_ComTencentMobileqqArScanningSurfaceView, this.b);
      ReportController.b(null, "dc00898", "", "", "0X8008350", "0X8008350", 0, 0, "", "", "", "");
      return;
    }
    QLog.d("ScanningSurfaceView", 1, "the dataList is null, cancel the jump action.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aakw
 * JD-Core Version:    0.7.0.1
 */