import android.os.Bundle;
import com.tencent.mobileqq.emosm.web.MessengerService;
import com.tencent.mobileqq.theme.ThemeDownloader;
import com.tencent.mobileqq.theme.ThemeDownloader.ThemeDownloadListener;
import com.tencent.mobileqq.vip.IPCDownloadListener;
import com.tencent.qphone.base.util.QLog;

public class acjc
  implements ThemeDownloader.ThemeDownloadListener
{
  public acjc(MessengerService paramMessengerService) {}
  
  public void onDownloadCallback(Bundle paramBundle, int paramInt1, int paramInt2, int paramInt3, ThemeDownloader paramThemeDownloader)
  {
    if (paramInt1 == 4) {}
    do
    {
      return;
      if ((QLog.isColorLevel()) || (paramInt1 < 0)) {
        QLog.d("Q.emoji.web.MessengerService", 2, "mThemeDownloadListener onDownloadCallback stateCode:" + paramInt1 + ", errCode=" + paramInt2 + ", httpCode=" + paramInt3);
      }
      Bundle localBundle = paramBundle;
      if (paramBundle == null) {
        localBundle = new Bundle();
      }
      localBundle.putString("status", "onDone");
      localBundle.putInt("result", paramInt1);
      localBundle.putInt("errCode", paramInt2);
      this.a.a.a(localBundle);
    } while (paramThemeDownloader == null);
    paramThemeDownloader.a();
  }
  
  public void onDownloadProgress(Bundle paramBundle, int paramInt, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.emoji.web.MessengerService", 2, "mThemeDownloadListener onDownloadProgress readSize:" + paramLong1 + ", dwProgressMax" + paramLong2);
    }
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putString("status", "onProgress");
    localBundle.putLong("readSize", paramLong1);
    localBundle.putLong("size", paramLong2);
    this.a.a.a(localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acjc
 * JD-Core Version:    0.7.0.1
 */