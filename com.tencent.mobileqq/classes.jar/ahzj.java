import com.tencent.mobileqq.shortvideo.ShortVideoPreDownloader;
import java.util.concurrent.atomic.AtomicBoolean;

public class ahzj
  implements Runnable
{
  public ahzj(ShortVideoPreDownloader paramShortVideoPreDownloader) {}
  
  public void run()
  {
    if (!this.a.a.get())
    {
      this.a.a.set(true);
      ShortVideoPreDownloader.a("openRunnable", "Timer count off, mIsPreDownloaderOpen=" + this.a.a.get());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahzj
 * JD-Core Version:    0.7.0.1
 */