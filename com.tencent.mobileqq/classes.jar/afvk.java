import com.tencent.mobileqq.olympic.activity.ARTipsManager;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;
import com.tencent.qphone.base.util.QLog;

public class afvk
  implements Runnable
{
  public afvk(ScanTorchActivity paramScanTorchActivity) {}
  
  public void run()
  {
    ScanTorchActivity.x(this.a, true);
    QLog.d("ScanTorchActivity", 2, "startDownloadTimeoutCheck timeout happened.");
    if (ScanTorchActivity.a(this.a) != null)
    {
      QLog.i("ScanTorchActivity", 1, "ARLoadFailed. mIsDownloadTimeout = " + ScanTorchActivity.p(this.a));
      ScanTorchActivity.a(this.a).a("AR组件加载失败，请退出后重试。");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afvk
 * JD-Core Version:    0.7.0.1
 */