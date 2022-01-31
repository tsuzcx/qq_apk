import android.os.SystemClock;
import com.tencent.mobileqq.webview.AbsWebView;
import com.tencent.qphone.base.util.QLog;

public class ajxs
  implements Runnable
{
  public ajxs(AbsWebView paramAbsWebView) {}
  
  public void run()
  {
    long l1 = SystemClock.uptimeMillis();
    if (this.a.a == null)
    {
      this.a.z();
      if (QLog.isColorLevel())
      {
        long l2 = SystemClock.uptimeMillis();
        QLog.d("AbsWebView", 2, "initPluginEngine cost= " + (l2 - l1));
      }
    }
    Thread.yield();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ajxs
 * JD-Core Version:    0.7.0.1
 */