import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.theme.ThemeDownloader;
import com.tencent.mobileqq.theme.ThemeDownloader.ThemeDownloadListener;
import com.tencent.mobileqq.theme.ThemeDownloader.ThemeUnzipListener;
import com.tencent.mobileqq.theme.ThemeSwitchManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class aitj
  implements ThemeDownloader.ThemeDownloadListener
{
  public aitj(ThemeSwitchManager paramThemeSwitchManager) {}
  
  public void onDownloadCallback(Bundle paramBundle, int paramInt1, int paramInt2, int paramInt3, ThemeDownloader paramThemeDownloader)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ThemeSwitchManager", 2, "mThemeDownloadListener onDownloadCallback stateCode:" + paramInt1);
    }
    if (paramInt1 == 3) {
      this.a.jdField_a_of_type_ComTencentMobileqqThemeThemeDownloader$ThemeUnzipListener.onUnzipCallback(paramBundle, paramInt1, paramThemeDownloader);
    }
    for (;;)
    {
      this.a.a(null);
      return;
      BaseApplication localBaseApplication;
      if (paramInt1 == 1)
      {
        if (this.a.jdField_a_of_type_ComTencentCommonAppAppInterface != null) {}
        for (localBaseApplication = this.a.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp();; localBaseApplication = null)
        {
          paramThemeDownloader.a(localBaseApplication, paramBundle, this.a.jdField_a_of_type_ComTencentMobileqqThemeThemeDownloader$ThemeUnzipListener);
          break;
        }
      }
      if (paramInt1 == 2)
      {
        if (this.a.jdField_a_of_type_ComTencentCommonAppAppInterface != null) {}
        for (localBaseApplication = this.a.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp();; localBaseApplication = null)
        {
          paramThemeDownloader.a(localBaseApplication, paramBundle, this.a.jdField_a_of_type_ComTencentMobileqqThemeThemeDownloader$ThemeUnzipListener);
          break;
        }
      }
      if (paramInt1 < 0)
      {
        QLog.e("ThemeSwitchManager", 1, "mThemeDownloadListener onDownloadCallback Error stateCode:" + paramInt1);
        paramThemeDownloader.a();
      }
    }
  }
  
  public void onDownloadProgress(Bundle paramBundle, int paramInt, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aitj
 * JD-Core Version:    0.7.0.1
 */