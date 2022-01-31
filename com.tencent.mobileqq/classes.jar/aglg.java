import com.tencent.mobileqq.ar.ARDeviceController;
import com.tencent.mobileqq.olympic.activity.ARTipsManager;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class aglg
  implements Runnable
{
  public aglg(ScanTorchActivity paramScanTorchActivity) {}
  
  public void run()
  {
    boolean bool1 = ARDeviceController.a().a();
    boolean bool2 = ARDeviceController.a().b();
    if ((bool1) && (bool2))
    {
      if ((!ScanTorchActivity.b(this.a)) || (!ScanTorchActivity.c(this.a)) || (!ScanTorchActivity.d(this.a)) || (!ScanTorchActivity.e(this.a))) {
        break label244;
      }
      if (!ScanTorchActivity.f(this.a)) {
        break label195;
      }
      QLog.i("ScanTorchActivity", 1, "ARLoadFailed. mIsArSoReady = " + ScanTorchActivity.b(this.a) + ", mIsVideoPluginReady = " + ScanTorchActivity.c(this.a) + ", mIsFaceModelReady = " + ScanTorchActivity.d(this.a) + ", mIsFaceSoReady = " + ScanTorchActivity.e(this.a) + ", mARStartFail = " + ScanTorchActivity.f(this.a));
      if (ScanTorchActivity.a(this.a) != null) {
        ScanTorchActivity.a(this.a).a("AR组件加载失败，请退出后重试。");
      }
    }
    for (;;)
    {
      ScanTorchActivity.a(this.a, null);
      return;
      label195:
      if (ScanTorchActivity.a(this.a) != null) {
        ScanTorchActivity.a(this.a).a("未识别到有效内容，请换个角度重试。");
      }
      ReportController.b(null, "dc00898", "", "", "0X80085B3", "0X80085B3", 0, 0, "", "", "", "");
      continue;
      label244:
      ScanTorchActivity.i(this.a, true);
      ScanTorchActivity.f(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aglg
 * JD-Core Version:    0.7.0.1
 */