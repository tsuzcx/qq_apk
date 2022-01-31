import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeDownloader;
import com.tencent.mobileqq.theme.ThemeDownloader.ThemeDownloadListener;
import com.tencent.mobileqq.theme.ThemeReporter;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.theme.ThemeUtil.ThemeInfo;
import com.tencent.mobileqq.vas.VasMonitorHandler;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.CallBacker;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class ahzz
  extends VasQuickUpdateManager.CallBacker
{
  public ahzz(ThemeDownloader paramThemeDownloader) {}
  
  public void callback(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, VasQuickUpdateManager paramVasQuickUpdateManager)
  {
    if (3L != paramLong) {}
    label514:
    label526:
    label691:
    for (;;)
    {
      return;
      if ((QLog.isColorLevel()) || (paramInt1 != 0)) {
        QLog.d("ThemeDownloader", 2, "callBacker themeDownloader, from" + paramString3 + ",httpCode=" + paramInt2 + ",errorCode:" + paramInt1 + ", mSVThemeSCID=" + this.a.jdField_b_of_type_JavaLangString + ", scid:" + paramString1 + ", cfgScid:" + paramString2);
      }
      if ((!TextUtils.isEmpty(paramString2)) && (paramString2.equals(this.a.jdField_b_of_type_JavaLangString)) && (paramString1.indexOf("theme.android.") >= 0))
      {
        String str = ThemeUtil.getIDFromSCID(paramString1);
        boolean bool = ThemeUtil.isNeedUpdataById(str);
        if ((!bool) || (QLog.isColorLevel())) {
          QLog.d("ThemeDownloader", 2, "onCompleted theme update theme ok. bid = " + paramLong + ", themeid=" + str + ", cfgScid=" + paramString2 + ",scid = " + paramString1 + ", isUpdate=" + bool);
        }
        if (bool)
        {
          paramLong = System.currentTimeMillis();
          long l = this.a.jdField_a_of_type_Long;
          int i;
          if (paramInt1 == 0)
          {
            i = 1;
            ThemeReporter.a(null, "theme_speed", paramString3, 153, -1, i, String.valueOf(paramLong - l), "665", String.valueOf(this.a.jdField_b_of_type_Long), str);
            if (paramInt1 != 0) {
              break label526;
            }
            paramString2 = BaseApplicationImpl.getApplication().getRuntime();
            paramString1 = null;
            if ((paramString2 instanceof QQAppInterface)) {
              paramString1 = (QQAppInterface)paramString2;
            }
            if ((paramString1 != null) && (ThemeUtil.getThemeInfo(paramString1.getApplication(), str) == null))
            {
              paramString2 = new ThemeUtil.ThemeInfo();
              paramString2.themeId = str;
              paramString2.isVoiceTheme = this.a.jdField_a_of_type_AndroidOsBundle.getBoolean("isVoiceTheme", false);
              if (paramString2.zipVer >= 20000000) {
                break label514;
              }
              i = 20000000;
              label374:
              paramString2.zipVer = i;
              paramString2.status = "3";
              if (this.a.jdField_a_of_type_AndroidOsBundle != null)
              {
                paramLong = this.a.jdField_a_of_type_AndroidOsBundle.getLong("size");
                paramString2.downsize = paramLong;
                paramString2.size = paramLong;
              }
              ThemeUtil.setThemeInfo(paramString1.getApplication(), paramString2);
            }
            if ((!TextUtils.isEmpty(str)) && (this.a.jdField_a_of_type_AndroidOsBundle != null) && (str.equals(this.a.jdField_a_of_type_AndroidOsBundle.getString("themeId")))) {
              this.a.a(this.a.jdField_a_of_type_AndroidOsBundle, 1, paramInt1, paramInt2);
            }
          }
          for (;;)
          {
            if (paramVasQuickUpdateManager == null) {
              break label691;
            }
            paramVasQuickUpdateManager.b(this.a.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker);
            return;
            i = -1;
            break;
            i = paramString2.zipVer + 1;
            break label374;
            AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
            QQAppInterface localQQAppInterface = null;
            if ((localAppRuntime instanceof QQAppInterface)) {
              localQQAppInterface = (QQAppInterface)localAppRuntime;
            }
            if ((!TextUtils.isEmpty(str)) && (this.a.jdField_a_of_type_AndroidOsBundle != null) && (str.equals(this.a.jdField_a_of_type_AndroidOsBundle.getString("themeId"))))
            {
              this.a.a(this.a.jdField_a_of_type_AndroidOsBundle, -1, paramInt1, paramInt2);
              VasMonitorHandler.a(localQQAppInterface, "individual_v2_theme_download_fail", String.valueOf(paramInt1), "from" + paramString3 + ",httpCode=" + paramInt2 + ",errorCode:" + paramInt1 + ", scid:" + paramString1 + ", cfgScid:" + paramString2, str, String.valueOf(paramInt2), null, 0.0F, 0.0F);
            }
          }
        }
      }
    }
  }
  
  public void onProgress(long paramLong1, String paramString1, String paramString2, long paramLong2, long paramLong3)
  {
    if (3L != paramLong1) {}
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("ThemeDownloader", 2, "ThemeDownloader onDownloadProgress scid:" + paramString1 + ", readSize:" + paramLong2 + ", dwProgressMax:" + paramLong3);
        }
      } while ((TextUtils.isEmpty(paramString2)) || (!paramString2.equals(this.a.jdField_b_of_type_JavaLangString)) || (paramString1.indexOf("theme.android.") < 0));
      if (this.a.jdField_a_of_type_AndroidOsBundle != null) {
        this.a.jdField_a_of_type_AndroidOsBundle.putLong("size", paramLong3);
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqThemeThemeDownloader$ThemeDownloadListener != null)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqThemeThemeDownloader$ThemeDownloadListener.onDownloadProgress(this.a.jdField_a_of_type_AndroidOsBundle, 1, paramLong2, paramLong3);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ThemeDownloader", 2, "ThemeDownloader onDownloadProgress outSideListener == null;");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ahzz
 * JD-Core Version:    0.7.0.1
 */