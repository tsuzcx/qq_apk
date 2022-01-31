import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpic.PresenceInterfaceImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr.InstallListener;
import mqq.os.MqqHandler;

public class aeal
  implements TVK_SDKMgr.InstallListener
{
  public aeal(PresenceInterfaceImpl paramPresenceInterfaceImpl) {}
  
  public void onInstallProgress(float paramFloat) {}
  
  public void onInstalledFailed(int paramInt)
  {
    PresenceInterfaceImpl.a = false;
    this.a.a("腾讯视频插件加载失败");
    if (QLog.isColorLevel()) {
      QLog.d("PresenceInterfaceImpl", 2, "tencent sdk onInstalledFail");
    }
  }
  
  public void onInstalledSuccessed()
  {
    PresenceInterfaceImpl.a = false;
    if (!this.a.c)
    {
      ThreadManager.getSubThreadHandler().post(new aeam(this));
      QLog.d("PresenceInterfaceImpl", 2, "run installSDK here");
    }
    QLog.d("PresenceInterfaceImpl", 2, "tencent sdk onInstall sucess");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeal
 * JD-Core Version:    0.7.0.1
 */