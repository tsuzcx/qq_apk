import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.leba.LebaWithFeeds;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import cooperation.comic.PluginPreloader;
import cooperation.comic.QQComicPreloadManager;
import cooperation.qqreader.QRProcessManager;

public class adzs
  implements Runnable
{
  public adzs(LebaWithFeeds paramLebaWithFeeds) {}
  
  public void run()
  {
    Object localObject = this.a.a.getCurrentAccountUin();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      long l = WebProcessManager.a((String)localObject);
      if (System.currentTimeMillis() - l < 604800000L) {
        WebProcessManager.a(LebaWithFeeds.a(), "key_health_dns_parse");
      }
      l = WebProcessManager.c((String)localObject);
      if (System.currentTimeMillis() - l < 259200000L) {
        WebProcessManager.a(LebaWithFeeds.b(), "key_gamecenter_dns_parse");
      }
      l = WebProcessManager.a((String)localObject, "key_reader_click_time");
      if (System.currentTimeMillis() - l < 259200000L) {
        WebProcessManager.a(LebaWithFeeds.c(), "key_reader_dns_parse");
      }
    }
    localObject = (QRProcessManager)this.a.a.getManager(128);
    if (localObject != null) {
      ((QRProcessManager)localObject).a(6);
    }
    localObject = (QQComicPreloadManager)this.a.a.getManager(141);
    if (localObject != null) {
      PluginPreloader.a(((QQComicPreloadManager)localObject).a(6), 500L);
    }
    ThreadManager.post(new adzt(this), 5, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adzs
 * JD-Core Version:    0.7.0.1
 */