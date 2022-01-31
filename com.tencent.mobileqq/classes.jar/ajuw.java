import android.os.Handler;
import com.tencent.mobileqq.vashealth.HealthBusinessPlugin;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr.InstallListener;

class ajuw
  implements TVK_SDKMgr.InstallListener
{
  ajuw(ajuv paramajuv) {}
  
  public void onInstallProgress(float paramFloat)
  {
    this.a.a.c = ((int)(100.0F * paramFloat));
    this.a.a.b.sendEmptyMessage(2);
  }
  
  public void onInstalledFailed(int paramInt)
  {
    this.a.a.d = paramInt;
    this.a.a.b.sendEmptyMessage(1);
  }
  
  public void onInstalledSuccessed()
  {
    this.a.a.b.sendEmptyMessage(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ajuw
 * JD-Core Version:    0.7.0.1
 */