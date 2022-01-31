import android.os.Bundle;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;

public class absl
  extends DownloadListener
{
  public absl(BubbleManager paramBubbleManager, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onCancel(DownloadTask paramDownloadTask)
  {
    String str = paramDownloadTask.a().getString("name");
    if (QLog.isColorLevel()) {
      QLog.i("BubbleManager", 2, "bubbleDownloadListener onCancel pkgName = " + str);
    }
    this.a.a("Bubble_download_cancel", paramDownloadTask.b(), str, 0L);
  }
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    long l = paramDownloadTask.h - paramDownloadTask.g;
    if (QLog.isColorLevel()) {
      QLog.i("BubbleManager", 2, "bubbleDownloadListener onDone downloadTime = " + l);
    }
    this.a.a("Bubble_download_succ", paramDownloadTask.b(), "pkgName", l);
  }
  
  public boolean onStart(DownloadTask paramDownloadTask)
  {
    String str = paramDownloadTask.a().getString("name");
    if (QLog.isColorLevel()) {
      QLog.i("BubbleManager", 2, "bubbleDownloadListener onStart pkgName = " + str);
    }
    this.a.a("Bubble_download", paramDownloadTask.b(), str, 0L);
    super.onStart(paramDownloadTask);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     absl
 * JD-Core Version:    0.7.0.1
 */