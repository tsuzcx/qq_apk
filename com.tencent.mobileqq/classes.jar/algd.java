import com.tencent.open.downloadnew.DownloadListener;
import com.tencent.open.downloadnew.DownloadManager;

public final class algd
  implements Runnable
{
  public algd(DownloadListener paramDownloadListener) {}
  
  public void run()
  {
    DownloadManager.a().b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     algd
 * JD-Core Version:    0.7.0.1
 */