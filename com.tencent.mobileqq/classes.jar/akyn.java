import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebAccelerator;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public final class akyn
  implements Runnable
{
  public akyn(long paramLong) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    QLog.i("WebLog_SwiftWebAccelerator", 1, "doThreadedStep_InitEngine.run cost " + (l - this.a) + "ms.");
    l = System.currentTimeMillis();
    synchronized (SwiftWebAccelerator.a)
    {
      if (WebViewPluginEngine.a == null)
      {
        AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.waitAppRuntime(null);
        if (localAppRuntime != null)
        {
          localAppRuntime = localAppRuntime.getAppRuntime("modular_web");
          if ((localAppRuntime instanceof AppInterface)) {
            WebViewPluginEngine.a = WebAccelerateHelper.getInstance().createWebViewPluginEngine((AppInterface)localAppRuntime, null, null, null);
          }
        }
      }
      QLog.i("WebLog_SwiftWebAccelerator", 1, "doThreadedStep_InitEngine:init plugin engine, cost " + (System.currentTimeMillis() - l) + "ms.");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akyn
 * JD-Core Version:    0.7.0.1
 */