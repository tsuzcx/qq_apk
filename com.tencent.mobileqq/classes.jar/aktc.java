import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.open.downloadnew.MyAppApi.QQDownloadListener;

public class aktc
  implements Runnable
{
  public aktc(MyAppApi.QQDownloadListener paramQQDownloadListener) {}
  
  public void run()
  {
    DownloadManager.a().c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aktc
 * JD-Core Version:    0.7.0.1
 */