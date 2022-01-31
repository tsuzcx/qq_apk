import com.tencent.mobileqq.hotchat.ui.PayLikeFloatViewBuilder;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public final class adpo
  extends DownloadListener
{
  public adpo(String paramString) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    PayLikeFloatViewBuilder.a(false);
    if (paramDownloadTask.a == 0)
    {
      paramDownloadTask = new File(this.a + ".tmp");
      if (paramDownloadTask.exists()) {
        paramDownloadTask.renameTo(new File(this.a));
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("PayLikeFloatViewBuilder", 2, "getPayZanAnimBitmap download failed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adpo
 * JD-Core Version:    0.7.0.1
 */