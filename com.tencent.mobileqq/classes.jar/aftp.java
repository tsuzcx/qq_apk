import com.tencent.mobileqq.ar.ARDeviceController;
import com.tencent.mobileqq.olympic.activity.ARTipsManager;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class aftp
  implements Runnable
{
  public aftp(ScanTorchActivity paramScanTorchActivity) {}
  
  public void run()
  {
    boolean bool1 = ARDeviceController.a().a();
    boolean bool2 = ARDeviceController.a().b();
    if ((bool1) && (bool2))
    {
      if ((!ScanTorchActivity.c(this.a)) || (!ScanTorchActivity.d(this.a)) || (!ScanTorchActivity.e(this.a)) || (!ScanTorchActivity.f(this.a))) {
        break label224;
      }
      if (!ScanTorchActivity.g(this.a)) {
        break label185;
      }
      QLog.i("ScanTorchActivity", 1, "ARLoadFailed. mIsArSoReady = " + ScanTorchActivity.c(this.a) + ", mIsVideoPluginReady = " + ScanTorchActivity.d(this.a) + ", mIsFaceModelReady = " + ScanTorchActivity.e(this.a) + ", mIsFaceSoReady = " + ScanTorchActivity.f(this.a) + ", mARStartFail = " + ScanTorchActivity.g(this.a));
      ScanTorchActivity.a(this.a).a("AR组件加载失败，请退出后重试。");
    }
    for (;;)
    {
      ScanTorchActivity.a(this.a, null);
      return;
      label185:
      ScanTorchActivity.a(this.a).a("未识别到有效内容，请换个角度重试。");
      ReportController.b(null, "dc00898", "", "", "0X80085B3", "0X80085B3", 0, 0, "", "", "", "");
      continue;
      label224:
      ScanTorchActivity.i(this.a, true);
      ScanTorchActivity.f(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aftp
 * JD-Core Version:    0.7.0.1
 */