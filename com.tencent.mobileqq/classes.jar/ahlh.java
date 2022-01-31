import com.tencent.mobileqq.shortvideo.ShortVideoPreDownloader;
import java.util.concurrent.atomic.AtomicBoolean;

public class ahlh
  implements Runnable
{
  public ahlh(ShortVideoPreDownloader paramShortVideoPreDownloader) {}
  
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
 * Qualified Name:     ahlh
 * JD-Core Version:    0.7.0.1
 */