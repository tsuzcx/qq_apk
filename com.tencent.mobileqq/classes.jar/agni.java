import android.widget.ImageView;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;
import com.tencent.mobileqq.olympic.view.ScanIconAnimateView;
import com.tencent.mobileqq.olympic.view.ScanIconAnimateView.PopUpListener;
import com.tencent.qphone.base.util.QLog;

public class agni
  implements ScanIconAnimateView.PopUpListener
{
  public agni(ScanTorchActivity paramScanTorchActivity) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScanTorchActivity", 2, "PopUp onStart ");
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScanTorchActivity", 2, "PopUp onEnd  needReportRedDot = " + this.a.n);
    }
    if (this.a.n)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqOlympicViewScanIconAnimateView.a();
      this.a.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agni
 * JD-Core Version:    0.7.0.1
 */