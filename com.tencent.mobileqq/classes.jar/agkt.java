import android.os.Handler;
import com.tencent.mobileqq.ar.IArSoListener;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;
import com.tencent.qphone.base.util.QLog;

public class agkt
  implements IArSoListener
{
  public agkt(ScanTorchActivity paramScanTorchActivity) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScanTorchActivity", 2, "onArSoDownloadSuccess");
    }
    ScanTorchActivity.g(this.a, true);
    ScanTorchActivity.h(this.a, false);
    ScanTorchActivity.c(this.a, 100);
    this.a.a.removeMessages(324);
    this.a.a.sendEmptyMessage(324);
    ScanTorchActivity.f(this.a);
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScanTorchActivity", 2, "onArSoDownloadProcess process=" + paramInt);
    }
    ScanTorchActivity.c(this.a, paramInt);
    ScanTorchActivity.e(this.a);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScanTorchActivity", 2, "onArSoDownloadFail");
    }
    ScanTorchActivity.g(this.a, false);
    ScanTorchActivity.h(this.a, false);
    ScanTorchActivity.f(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agkt
 * JD-Core Version:    0.7.0.1
 */