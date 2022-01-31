import com.tencent.mobileqq.filemanager.activity.UniformDownloadActivity;
import com.tencent.open.downloadnew.DownloadManager;

public class acxe
  implements Runnable
{
  public acxe(UniformDownloadActivity paramUniformDownloadActivity) {}
  
  public void run()
  {
    DownloadManager.a().b(UniformDownloadActivity.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acxe
 * JD-Core Version:    0.7.0.1
 */