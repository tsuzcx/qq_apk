import com.tencent.gamecenter.common.util.GameCenterAPIJavaScript;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr.InstallListener;

public class aahn
  implements TVK_SDKMgr.InstallListener
{
  public aahn(GameCenterAPIJavaScript paramGameCenterAPIJavaScript) {}
  
  public void onInstallProgress(float paramFloat)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GCApi", 1, String.format("plugin install %f", new Object[] { Float.valueOf(paramFloat) }));
    }
  }
  
  public void onInstalledFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GCApi", 1, "plugin fail errorCode = " + paramInt);
    }
  }
  
  public void onInstalledSuccessed()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GCApi", 1, "plugin success");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aahn
 * JD-Core Version:    0.7.0.1
 */