import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.vashealth.HealthBusinessPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;

public class akjc
  implements Runnable
{
  public akjc(HealthBusinessPlugin paramHealthBusinessPlugin) {}
  
  public void run()
  {
    TVK_SDKMgr.installPlugin(this.a.mRuntime.a().getApplication(), new akjd(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akjc
 * JD-Core Version:    0.7.0.1
 */