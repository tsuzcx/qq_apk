import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.open.downloadnew.MyAppApi;

public class akqz
  implements Runnable
{
  public akqz(DownloadManager paramDownloadManager) {}
  
  public void run()
  {
    if (!this.a.a)
    {
      if (!MyAppApi.a().b()) {
        this.a.a(true);
      }
      this.a.a = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     akqz
 * JD-Core Version:    0.7.0.1
 */