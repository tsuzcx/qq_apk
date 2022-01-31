import android.os.Handler;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr.InstallListener;

public class aghe
  implements TVK_SDKMgr.InstallListener
{
  public aghe(ScanTorchActivity paramScanTorchActivity) {}
  
  public void onInstallProgress(float paramFloat)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScanTorchActivity", 2, "TVK_SDKMgr.onInstallProgress progress=" + paramFloat);
    }
    ScanTorchActivity.d(this.a, (int)(100.0F * paramFloat));
    ScanTorchActivity.e(this.a);
  }
  
  public void onInstalledFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScanTorchActivity", 2, "TVK_SDKMgr.onInstalledFailed error=" + paramInt);
    }
    ScanTorchActivity.p(this.a, false);
    ScanTorchActivity.q(this.a, false);
    ScanTorchActivity.f(this.a);
  }
  
  public void onInstalledSuccessed()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScanTorchActivity", 2, "TVK_SDKMgr.onInstalledSuccessed");
    }
    ScanTorchActivity.p(this.a, true);
    ScanTorchActivity.q(this.a, false);
    ScanTorchActivity.d(this.a, 100);
    this.a.a.removeMessages(324);
    this.a.a.sendEmptyMessage(324);
    ScanTorchActivity.f(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aghe
 * JD-Core Version:    0.7.0.1
 */