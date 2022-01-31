import android.os.Handler;
import com.tencent.mobileqq.intervideo.huayang.HuayangCrashReport;
import com.tencent.mobileqq.intervideo.huayang.HuayangPluginNewDownloader;
import com.tencent.mobileqq.intervideo.huayang.Monitor;

public class aect
  implements Runnable
{
  public aect(HuayangPluginNewDownloader paramHuayangPluginNewDownloader) {}
  
  public void run()
  {
    try
    {
      HuayangPluginNewDownloader.a(this.a);
      return;
    }
    catch (Throwable localThrowable)
    {
      Monitor.a("3228166");
      HuayangCrashReport.a(new RuntimeException("huayangPluginManager downloadException", localThrowable));
      return;
    }
    finally
    {
      HuayangPluginNewDownloader.a(this.a).removeCallbacks(HuayangPluginNewDownloader.a(this.a));
      HuayangPluginNewDownloader.a(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aect
 * JD-Core Version:    0.7.0.1
 */