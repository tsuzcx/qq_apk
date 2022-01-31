import com.tencent.mobileqq.ar.arengine.ARWorldCupBaseResDownload;
import com.tencent.mobileqq.olympic.activity.ARTipsManager;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;
import com.tencent.qphone.base.util.QLog;

public class agnl
  implements Runnable
{
  public agnl(ScanTorchActivity paramScanTorchActivity) {}
  
  public void run()
  {
    ScanTorchActivity.x(this.a, true);
    QLog.d("ScanTorchActivity", 2, "startDownloadTimeoutCheck timeout happened.");
    if (ScanTorchActivity.a(this.a) != null)
    {
      QLog.i("ScanTorchActivity", 1, "ARLoadFailed. mIsDownloadTimeout = " + ScanTorchActivity.q(this.a));
      ScanTorchActivity.a(this.a).a("AR组件加载失败，请退出后重试。");
    }
    if ((!this.a.f()) || (ScanTorchActivity.a(this.a).b())) {
      return;
    }
    this.a.e(10);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agnl
 * JD-Core Version:    0.7.0.1
 */