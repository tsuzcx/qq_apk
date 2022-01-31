import com.tencent.mobileqq.filemanager.core.ThumbDownloadManager;
import com.tencent.mobileqq.filemanager.core.ThumbDownloadManager.ThumbTask;
import java.util.LinkedHashMap;
import java.util.List;

public class adhh
  implements Runnable
{
  public adhh(ThumbDownloadManager paramThumbDownloadManager) {}
  
  public void run()
  {
    if (ThumbDownloadManager.a(this.a).size() >= 8) {}
    while (ThumbDownloadManager.a(this.a).size() == 0) {
      return;
    }
    ThumbDownloadManager.ThumbTask localThumbTask = (ThumbDownloadManager.ThumbTask)ThumbDownloadManager.a(this.a).get(0);
    if (localThumbTask == null)
    {
      ThumbDownloadManager.a(this.a).remove(0);
      ThumbDownloadManager.a(this.a);
      return;
    }
    ThumbDownloadManager.a(this.a).remove(localThumbTask);
    ThumbDownloadManager.a(this.a, localThumbTask);
    ThumbDownloadManager.b(this.a, localThumbTask);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     adhh
 * JD-Core Version:    0.7.0.1
 */