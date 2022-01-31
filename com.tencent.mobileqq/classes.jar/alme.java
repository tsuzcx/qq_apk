import android.support.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.bigbrother.RockDownloader.RockDownloadListener;
import com.tencent.mobileqq.bigbrother.RockDownloader.RockDownloaderTask;
import com.tencent.mobileqq.data.RockDownloadInfo;
import java.util.ArrayList;
import javax.annotation.Nonnull;

public class alme
{
  @android.support.annotation.Nullable
  public static ArrayList<RockDownloadInfo> a(@NonNull RockDownloadInfo paramRockDownloadInfo)
  {
    RockDownloaderTask localRockDownloaderTask = new RockDownloaderTask();
    localRockDownloaderTask.setDownloadInfo(paramRockDownloadInfo);
    localRockDownloaderTask.setTaskCheckLevel(1);
    localRockDownloaderTask.setRuntime(BaseApplicationImpl.getApplication().getRuntime());
    return allz.a(localRockDownloaderTask);
  }
  
  public static void a(@Nonnull RockDownloadInfo paramRockDownloadInfo, @javax.annotation.Nullable ally paramally)
  {
    RockDownloaderTask localRockDownloaderTask = new RockDownloaderTask();
    localRockDownloaderTask.setDownloadInfo(paramRockDownloadInfo);
    localRockDownloaderTask.setTaskCheckLevel(1);
    localRockDownloaderTask.setRuntime(BaseApplicationImpl.getApplication().getRuntime());
    localRockDownloaderTask.setQueryAPKListener(paramally);
    allz.b(localRockDownloaderTask);
  }
  
  public static void a(@Nonnull RockDownloadInfo paramRockDownloadInfo, @javax.annotation.Nullable RockDownloadListener paramRockDownloadListener)
  {
    if (!badq.a(BaseApplicationImpl.context))
    {
      if (paramRockDownloadListener != null)
      {
        paramRockDownloadListener.onDownloadFail(paramRockDownloadInfo, ajjy.a(2131647702), 10009);
        paramRockDownloadListener.onDownloadFinish(paramRockDownloadInfo);
      }
      return;
    }
    RockDownloaderTask localRockDownloaderTask = new RockDownloaderTask();
    localRockDownloaderTask.setDownloadInfo(paramRockDownloadInfo);
    localRockDownloaderTask.setTaskCheckLevel(1);
    localRockDownloaderTask.setRuntime(BaseApplicationImpl.getApplication().getRuntime());
    localRockDownloaderTask.setRockDownloadListener(paramRockDownloadListener);
    allz.a(localRockDownloaderTask);
  }
  
  public static boolean a(@Nonnull RockDownloadInfo paramRockDownloadInfo)
  {
    RockDownloaderTask localRockDownloaderTask = new RockDownloaderTask();
    localRockDownloaderTask.setDownloadInfo(paramRockDownloadInfo);
    localRockDownloaderTask.setTaskCheckLevel(1);
    localRockDownloaderTask.setRuntime(BaseApplicationImpl.getApplication().getRuntime());
    return allz.b(localRockDownloaderTask);
  }
  
  public static boolean b(@Nonnull RockDownloadInfo paramRockDownloadInfo)
  {
    RockDownloaderTask localRockDownloaderTask = new RockDownloaderTask();
    localRockDownloaderTask.setDownloadInfo(paramRockDownloadInfo);
    localRockDownloaderTask.setTaskCheckLevel(1);
    localRockDownloaderTask.setRuntime(BaseApplicationImpl.getApplication().getRuntime());
    return allz.a(localRockDownloaderTask);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     alme
 * JD-Core Version:    0.7.0.1
 */