import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.theme.ThemeDownloader;
import com.tencent.mobileqq.theme.ThemeReporter;
import com.tencent.mobileqq.theme.ThemeSwitchManager;
import com.tencent.mobileqq.theme.ThemeSwitchUtil;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.theme.ThemeUtil.ThemeInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;
import java.io.File;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;

public class aiah
  extends AsyncTask
{
  aiah(ThemeSwitchManager paramThemeSwitchManager) {}
  
  protected Bundle a(Object... paramVarArgs)
  {
    Bundle localBundle = new Bundle();
    if ((this.a.jdField_b_of_type_JavaLangRefWeakReference == null) || (this.a.jdField_b_of_type_JavaLangRefWeakReference.get() == null)) {}
    for (paramVarArgs = null; paramVarArgs == null; paramVarArgs = (AppRuntime)this.a.jdField_b_of_type_JavaLangRefWeakReference.get())
    {
      QLog.e("ThemeSwitchManager", 1, "doInBackground mRuntime==null");
      localBundle.putBoolean("result", false);
      localBundle.putString("message", "mRuntime=null");
      localBundle.putInt("errCode", -8);
      return localBundle;
    }
    QLog.d("ThemeSwitchManager", 1, "doInBackground intend to set themeID:" + this.a.jdField_a_of_type_JavaLangString + ", version:" + this.a.jdField_b_of_type_JavaLangString + ", from:" + this.a.c);
    if (this.a.jdField_a_of_type_JavaLangString.equals("1000")) {
      try
      {
        Thread.sleep(800L);
        localBundle.putString("message", "doInBackground DEFAULT_THEME_ID");
        localBundle.putBoolean("result", true);
        return localBundle;
      }
      catch (Exception paramVarArgs)
      {
        for (;;)
        {
          QLog.e("ThemeSwitchManager", 1, "doInBackground sleep Exception0:" + paramVarArgs.getMessage());
        }
      }
    }
    if (TextUtils.isEmpty(this.a.jdField_b_of_type_JavaLangString))
    {
      QLog.e("ThemeSwitchManager", 2, "doInBackground version=null, themeId=" + this.a.jdField_a_of_type_JavaLangString);
      localBundle.putBoolean("result", false);
      localBundle.putString("message", "version=null");
      localBundle.putInt("errCode", -54);
      return localBundle;
    }
    Object localObject1;
    Object localObject3;
    String str;
    File localFile;
    int i;
    try
    {
      localObject1 = ThemeUtil.getThemeInfo(paramVarArgs.getApplication(), this.a.jdField_a_of_type_JavaLangString);
      if ((localObject1 != null) || (this.a.jdField_a_of_type_ComTencentMobileqqThemeThemeUtil$ThemeInfo == null) || (!this.a.jdField_a_of_type_JavaLangString.equals(this.a.jdField_a_of_type_ComTencentMobileqqThemeThemeUtil$ThemeInfo.themeId))) {
        break label1384;
      }
      localObject1 = this.a.jdField_a_of_type_ComTencentMobileqqThemeThemeUtil$ThemeInfo;
      if (localObject1 == null)
      {
        QLog.e("ThemeSwitchManager", 2, "doInBackground themeInfo=null, themeId=" + this.a.jdField_a_of_type_JavaLangString);
        localBundle.putBoolean("result", false);
        localBundle.putString("message", "themeInfo = null");
        localBundle.putInt("errCode", -53);
        return localBundle;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ThemeSwitchManager", 1, "doInBackground set theme,themeId=" + this.a.jdField_a_of_type_JavaLangString + ",version=" + this.a.jdField_b_of_type_JavaLangString + ", from:" + this.a.c);
      }
      localObject3 = ThemeUtil.getThemeResourcePath(paramVarArgs.getApplication(), this.a.jdField_a_of_type_JavaLangString, this.a.jdField_b_of_type_JavaLangString);
      str = ThemeUtil.getThemeDownloadFilePath(paramVarArgs.getApplication(), this.a.jdField_a_of_type_JavaLangString, "20000000");
      localFile = new File(str);
      localObject2 = new File((String)localObject3);
      if (!((File)localObject2).exists()) {
        break label1226;
      }
      i = ThemeUtil.getFileNumInFile((File)localObject2);
      if ((i > 0) && (i >= ((ThemeUtil.ThemeInfo)localObject1).fileNum))
      {
        localBundle.putString("themePath", ThemeUtil.getThemeResourcePath(paramVarArgs.getApplication(), this.a.jdField_a_of_type_JavaLangString, this.a.jdField_b_of_type_JavaLangString));
        try
        {
          Thread.sleep(500L);
          localBundle.putString("message", "doInBackground already THEME_STATUS_COMPLETE,  fileNum:" + i);
          localBundle.putBoolean("result", true);
          if ((!QLog.isColorLevel()) && (i == ((ThemeUtil.ThemeInfo)localObject1).fileNum)) {
            break label1387;
          }
          QLog.d("ThemeSwitchManager", 1, "doInBackground THEME_STATUS_COMPLETE ok fileNum:" + i + ", themeInfo.fileNum=" + ((ThemeUtil.ThemeInfo)localObject1).fileNum + ", themeResDir:" + localObject2);
        }
        catch (Exception paramVarArgs)
        {
          for (;;)
          {
            QLog.d("ThemeSwitchManager", 2, "doInBackground THEME_STATUS_COMPLETE sleep Exception1:" + paramVarArgs.getMessage());
          }
        }
      }
      ThemeReporter.a(paramVarArgs, "theme_detail", this.a.c, 155, -1, -3, this.a.jdField_a_of_type_JavaLangString, this.a.jdField_b_of_type_JavaLangString, this.a.d, "");
    }
    catch (Exception paramVarArgs)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ThemeSwitchManager", 2, "doInBackground Exception:" + paramVarArgs.getMessage());
      }
      localBundle.putString("message", "doInBackground Exception error");
      localBundle.putBoolean("result", false);
      localBundle.putInt("errCode", -35);
      if (QLog.isColorLevel()) {
        QLog.i("ThemeSwitchManager", 2, "doInBackground fail");
      }
      return localBundle;
    }
    QLog.e("ThemeSwitchManager", 1, "doInBackground THEME_STATUS_COMPLETE fileNum Error, themeInfo.fileNum:" + ((ThemeUtil.ThemeInfo)localObject1).fileNum + ", fileNum:" + i + ",themeId:" + ((ThemeUtil.ThemeInfo)localObject1).themeId + ",version:" + ((ThemeUtil.ThemeInfo)localObject1).version + ", from:" + this.a.c);
    label949:
    if ((localFile.exists()) && (localFile.length() > 0L)) {
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder().append("doInBackground themePkgFile is exists,themeZipPath=").append(str);
        if (localObject1 == null) {
          break label1393;
        }
      }
    }
    label1226:
    label1384:
    label1387:
    label1390:
    label1393:
    for (Object localObject2 = ",status=" + ((ThemeUtil.ThemeInfo)localObject1).status + ", themeInfo.size=" + ((ThemeUtil.ThemeInfo)localObject1).size;; localObject2 = "themeInfo=null")
    {
      QLog.d("ThemeSwitchManager", 2, (String)localObject2);
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("themeId", ((ThemeUtil.ThemeInfo)localObject1).themeId);
      ((Bundle)localObject2).putString("version", ((ThemeUtil.ThemeInfo)localObject1).version);
      ((Bundle)localObject2).putBoolean("isVoiceTheme", ((ThemeUtil.ThemeInfo)localObject1).isVoiceTheme);
      ((Bundle)localObject2).putLong("size", ((ThemeUtil.ThemeInfo)localObject1).size);
      localObject1 = new ThemeDownloader(paramVarArgs, this.a.c);
      boolean bool = ((ThemeDownloader)localObject1).a(paramVarArgs.getApplication(), (Bundle)localObject2, null);
      ((ThemeDownloader)localObject1).a();
      if (bool)
      {
        this.a.jdField_b_of_type_JavaLangString = ((Bundle)localObject2).getString("version");
        localBundle.putString("themePath", ThemeUtil.getThemeResourcePath(paramVarArgs.getApplication(), this.a.jdField_a_of_type_JavaLangString, this.a.jdField_b_of_type_JavaLangString));
        localBundle.putString("message", "doInBackground unzip ok");
        localBundle.putBoolean("result", true);
        if (!QLog.isColorLevel()) {
          break label1390;
        }
        QLog.d("ThemeSwitchManager", 1, "doInBackground unzip ThemeZip ok");
        break label1390;
        QLog.e("ThemeSwitchManager", 1, "doInBackground THEME_STATUS_COMPLETE themeResPath not exists,themeResPath=" + (String)localObject3);
        break label949;
      }
      QLog.e("ThemeSwitchManager", 1, "doInBackground unzip error, themeZipPath:" + str);
      localBundle.putString("message", "doInBackground unzip fail");
      localBundle.putBoolean("result", false);
      localBundle.putInt("errCode", -30);
      break label1390;
      QLog.e("ThemeSwitchManager", 1, "doInBackground theme RES error, themeZipPath:" + str + ", exists:" + localFile.exists());
      localBundle.putString("message", "doInBackground RES error");
      localBundle.putBoolean("result", false);
      localBundle.putInt("errCode", -29);
      break label1390;
      break;
      return localBundle;
      return localBundle;
    }
  }
  
  protected void onPostExecute(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof Bundle)))
    {
      QLog.e("ThemeSwitchManager", 1, "onPostExecute result Error, result:" + paramObject);
      return;
    }
    Bundle localBundle = (Bundle)paramObject;
    if ((this.a.jdField_b_of_type_JavaLangRefWeakReference == null) || (this.a.jdField_b_of_type_JavaLangRefWeakReference.get() == null)) {}
    for (paramObject = null; paramObject == null; paramObject = (AppRuntime)this.a.jdField_b_of_type_JavaLangRefWeakReference.get())
    {
      QLog.e("ThemeSwitchManager", 1, "onPostExecute mRuntime==null");
      return;
    }
    boolean bool2 = localBundle.getBoolean("result", false);
    int i;
    boolean bool1;
    if (localBundle.getInt("errCode") == 0)
    {
      i = 23;
      if (QLog.isColorLevel()) {
        QLog.d("ThemeSwitchManager", 2, "onPostExecute result: " + bool2 + ", errCode:" + localBundle.getInt("errCode") + ", msg:" + localBundle.getString("message") + ", theme:" + this.a.jdField_a_of_type_JavaLangString + ", version:" + this.a.jdField_b_of_type_JavaLangString + ", mFrom:" + this.a.c);
      }
      if (!bool2) {
        break label858;
      }
      this.a.a();
      Object localObject = ThemeUtil.getCurrentThemeInfo();
      String str = localBundle.getString("themePath");
      bool1 = SkinEngine.getInstances().setSkinRootPath(paramObject.getApplication(), str);
      QLog.d("ThemeSwitchManager", 2, "onPostExecute setSkinRootPath: " + str + ", themeid:" + this.a.jdField_a_of_type_JavaLangString + ", version:" + this.a.jdField_b_of_type_JavaLangString + ", mFrom:" + this.a.c + ", setSkinSuccess=" + bool1);
      if (!bool1) {
        break label778;
      }
      if (BaseApplicationImpl.sImageCache != null) {
        BaseApplicationImpl.sImageCache.evictAll();
      }
      str = ((Bundle)localObject).getString("themeId");
      localObject = ((Bundle)localObject).getString("version");
      QLog.d("ThemeSwitchManager", 1, "onPostExecute currentTheme currThemeId=" + str + ", currVersion=" + (String)localObject + ", change to themeId=" + this.a.jdField_a_of_type_JavaLangString + ", mVersion=" + this.a.jdField_b_of_type_JavaLangString);
      if (!str.equals("1103")) {
        ThemeSwitchUtil.a(paramObject, str, (String)localObject);
      }
      ThemeUtil.setCurrentThemeIdVersion(paramObject, this.a.jdField_a_of_type_JavaLangString, this.a.jdField_b_of_type_JavaLangString);
      ThemeReporter.a(paramObject, "theme_detail", this.a.c, 155, NetworkUtil.a(null), 23, this.a.jdField_a_of_type_JavaLangString, this.a.jdField_b_of_type_JavaLangString, this.a.d, "");
    }
    for (;;)
    {
      if ((bool2) && (bool1)) {
        break label970;
      }
      int j = i;
      if (i > -1) {
        j = -1;
      }
      this.a.a(j, this.a.jdField_a_of_type_JavaLangString, this.a.jdField_b_of_type_JavaLangString, 65);
      QLog.e("ThemeSwitchManager", 1, "onPostExecute result Error: " + bool2 + ", errCode:" + localBundle.getInt("errCode") + ", msg:" + localBundle.getString("message") + ", theme:" + this.a.jdField_a_of_type_JavaLangString + ", version:" + this.a.jdField_b_of_type_JavaLangString + ", mFrom:" + this.a.c + ", errCode:" + j);
      ThemeReporter.a(paramObject, "theme_detail", this.a.c, 155, NetworkUtil.a(null), j, this.a.jdField_a_of_type_JavaLangString, this.a.jdField_b_of_type_JavaLangString, this.a.d, "");
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(201);
      return;
      i = localBundle.getInt("errCode");
      break;
      label778:
      i = -24;
      QLog.e("ThemeSwitchManager", 1, "onPostExecute setSkinSuccess: " + bool1 + ", theme:" + this.a.jdField_a_of_type_JavaLangString + ", version:" + this.a.jdField_b_of_type_JavaLangString + ", mFrom:" + this.a.c);
      continue;
      label858:
      QLog.e("ThemeSwitchManager", 1, "onPostExecute result: " + bool2 + ", errCode:" + localBundle.getInt("errCode") + ", msg:" + localBundle.getString("message") + ", theme:" + this.a.jdField_a_of_type_JavaLangString + ", version:" + this.a.jdField_b_of_type_JavaLangString + ", mFrom:" + this.a.c);
      bool1 = false;
    }
    label970:
    if ((paramObject instanceof QQAppInterface)) {
      ThreadManager.post(new aiai(this, paramObject), 8, null, true);
    }
    this.a.a(1, this.a.jdField_a_of_type_JavaLangString, this.a.jdField_b_of_type_JavaLangString, 66);
    ThemeReporter.a(paramObject, "theme_detail", this.a.c, 155, NetworkUtil.a(null), 23, this.a.jdField_a_of_type_JavaLangString, this.a.jdField_b_of_type_JavaLangString, this.a.d, "");
  }
  
  protected void onPreExecute()
  {
    if (this.a.jdField_b_of_type_Boolean) {
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(200);
    }
    super.onPreExecute();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aiah
 * JD-Core Version:    0.7.0.1
 */