import com.tencent.hlyyb.downloader.Downloader;
import com.tencent.hlyyb.downloader.DownloaderTask;
import com.tencent.mobileqq.intervideo.now.DownloadEngine.IDownloadListener;
import com.tencent.mobileqq.intervideo.now.DownloadEngine.IHellyEventListener;
import com.tencent.mobileqq.intervideo.now.DownloadEngine.NowDownloadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class adkq
  implements IHellyEventListener
{
  public adkq(NowDownloadManager paramNowDownloadManager) {}
  
  public void a(DownloaderTask paramDownloaderTask)
  {
    QLog.e("DownloadManager_Now_for_qq", 4, "onTaskCompleted----DOWNLOAD_SUCCESS, filePath = " + paramDownloaderTask.getSavePath());
    if (NowDownloadManager.a(this.a) != null) {
      NowDownloadManager.a(this.a).deleteTask(paramDownloaderTask, false);
    }
    if ((NowDownloadManager.a(this.a) != null) && (NowDownloadManager.a(this.a).containsKey(paramDownloaderTask.getUrl())) && (NowDownloadManager.a(this.a).get(paramDownloaderTask.getUrl()) != null)) {
      ((IDownloadListener)NowDownloadManager.a(this.a).get(paramDownloaderTask.getUrl())).a();
    }
  }
  
  public void b(DownloaderTask paramDownloaderTask) {}
  
  public void c(DownloaderTask paramDownloaderTask)
  {
    QLog.e("DownloadManager_Now_for_qq", 4, "onTaskFailed----DOWNLOAD_FAILED");
    if (NowDownloadManager.a(this.a) != null) {
      NowDownloadManager.a(this.a).deleteTask(paramDownloaderTask, false);
    }
    if ((NowDownloadManager.a(this.a) != null) && (NowDownloadManager.a(this.a).containsKey(paramDownloaderTask.getUrl())) && (NowDownloadManager.a(this.a).get(paramDownloaderTask.getUrl()) != null)) {
      ((IDownloadListener)NowDownloadManager.a(this.a).get(paramDownloaderTask.getUrl())).a(paramDownloaderTask.getFailCode(), paramDownloaderTask.getFailCode(), "failed");
    }
  }
  
  public void d(DownloaderTask paramDownloaderTask) {}
  
  public void e(DownloaderTask paramDownloaderTask) {}
  
  public void f(DownloaderTask paramDownloaderTask)
  {
    QLog.e("DownloadManager_Now_for_qq", 4, "onTaskReceived----percent: " + paramDownloaderTask.getPercentage());
    if ((NowDownloadManager.a(this.a) != null) && (NowDownloadManager.a(this.a).containsKey(paramDownloaderTask.getUrl())) && (NowDownloadManager.a(this.a).get(paramDownloaderTask.getUrl()) != null)) {
      ((IDownloadListener)NowDownloadManager.a(this.a).get(paramDownloaderTask.getUrl())).a(paramDownloaderTask.getReceivedLength(), paramDownloaderTask.getTotalLength(), paramDownloaderTask.getPercentage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     adkq
 * JD-Core Version:    0.7.0.1
 */