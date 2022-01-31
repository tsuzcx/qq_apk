import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.vashealth.HealthBusinessPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;

public class ajuv
  implements Runnable
{
  public ajuv(HealthBusinessPlugin paramHealthBusinessPlugin) {}
  
  public void run()
  {
    TVK_SDKMgr.installPlugin(this.a.mRuntime.a().getApplication(), new ajuw(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ajuv
 * JD-Core Version:    0.7.0.1
 */