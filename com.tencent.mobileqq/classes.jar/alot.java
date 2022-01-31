import android.os.Bundle;
import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.ApkGetCodeListener;
import com.tencent.open.downloadnew.DownloadManager;

public class alot
  implements ApkGetCodeListener
{
  public alot(DownloadManager paramDownloadManager) {}
  
  public void a(String paramString1, int paramInt, String paramString2, boolean paramBoolean, Bundle paramBundle)
  {
    LogUtility.c(DownloadManager.a, "receive get code finished pkgName|" + paramString1 + " versionCode|" + paramInt + " code|" + paramString2 + " extraData|" + paramBundle);
    paramBundle = new Bundle();
    paramBundle.putString("PackageName", paramString1);
    paramBundle.putString("Code", paramString2);
    paramBundle.putInt("VersionCode", paramInt);
    paramBundle.putBoolean("IsSuccess", paramBoolean);
    DownloadManager.a(this.a, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     alot
 * JD-Core Version:    0.7.0.1
 */