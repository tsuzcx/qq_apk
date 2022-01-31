import android.os.Bundle;
import com.tencent.mobileqq.theme.ThemeDownloader;
import com.tencent.mobileqq.theme.ThemeDownloader.ThemeUnzipListener;
import com.tencent.mobileqq.theme.ThemeSwitchManager;
import com.tencent.qphone.base.util.QLog;

public class aitk
  implements ThemeDownloader.ThemeUnzipListener
{
  public aitk(ThemeSwitchManager paramThemeSwitchManager) {}
  
  public void onUnzipCallback(Bundle paramBundle, int paramInt, ThemeDownloader paramThemeDownloader)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ThemeSwitchManager", 2, "mThemeDownloadListener onUnzipCallback stateCode:" + paramInt);
    }
    if ((paramInt == 1) || (paramInt == 3)) {
      if (1 == paramBundle.getInt("themeType", 0))
      {
        paramBundle.putBoolean("server_after_download", true);
        String str1 = paramBundle.getString("themeId");
        String str2 = paramBundle.getString("version");
        this.a.a(this.a.a, str1, str2, paramBundle);
      }
    }
    for (;;)
    {
      if (paramThemeDownloader != null) {
        paramThemeDownloader.a();
      }
      return;
      QLog.d("ThemeSwitchManager", 1, "mThemeDownloadListener onUnzipCallback Error stateCode:" + paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aitk
 * JD-Core Version:    0.7.0.1
 */