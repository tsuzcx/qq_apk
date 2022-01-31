import android.os.Handler;
import com.tencent.mobileqq.ar.view.ARScanEntryView;
import com.tencent.mobileqq.ar.view.ARScanEntryView.4.1;
import com.tencent.qphone.base.util.QLog;

public class akxu
  implements atjd
{
  public akxu(ARScanEntryView paramARScanEntryView) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARScanEntryView", 2, "PopUp onStart ");
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARScanEntryView", 2, "PopUp onEnd  needReportRedDot = " + ARScanEntryView.a(this.a));
    }
    if (ARScanEntryView.a(this.a) != null) {
      ARScanEntryView.a(this.a).post(new ARScanEntryView.4.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     akxu
 * JD-Core Version:    0.7.0.1
 */