import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.UniformDownloadMgr;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.UniformDownloader;
import com.tencent.mobileqq.filemanager.util.UniformDownloader.IUniformDownloaderListener;
import com.tencent.mobileqq.filemanager.util.UniformDownloaderAppBaby;
import com.tencent.mobileqq.filemanager.util.UniformDownloaderAppBaby.IUniformDownloaderAppBabyListener;
import com.tencent.mobileqq.filemanager.util.UniformDownloaderAppBabySdk.RParam;
import com.tencent.mobileqq.statistics.StatisticAssist;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.MobileQQ;

public class acyk
  implements UniformDownloaderAppBaby.IUniformDownloaderAppBabyListener
{
  public acyk(UniformDownloaderAppBaby paramUniformDownloaderAppBaby) {}
  
  public void a(int paramInt, Bundle paramBundle)
  {
    this.a.b(paramInt);
    if (UniformDownloaderAppBaby.a(this.a) != null)
    {
      if (paramInt <= 100) {
        break label45;
      }
      UniformDownloaderAppBaby.a(this.a).b(this.a.h(), paramBundle);
    }
    label45:
    while (paramInt - this.a.g() <= 0) {
      return;
    }
    this.a.a(paramInt);
    UniformDownloaderAppBaby.a(this.a).b(paramInt, paramBundle);
  }
  
  public void a(int paramInt, String paramString, Bundle paramBundle)
  {
    this.a.c(5);
    QQAppInterface localQQAppInterface = UniformDownloadMgr.a().a();
    if (localQQAppInterface != null)
    {
      long l1 = -1L;
      long l2 = -1L;
      UniformDownloaderAppBabySdk.RParam localRParam = UniformDownloaderAppBabySdk.RParam.a(paramBundle);
      if (localRParam != null)
      {
        l1 = localRParam.jdField_a_of_type_Long;
        l2 = localRParam.b;
      }
      FileManagerUtil.a(localQQAppInterface, this.a.jdField_c_of_type_Long, "actFileUfAppBabySdkDownload", this.a.jdField_a_of_type_Long, "", "", "", "", paramInt, paramString, l1, l2, this.a.b, this.a.jdField_c_of_type_JavaLangString, "", 0, paramString, null);
      FileManagerUtil.a(localQQAppInterface, this.a.jdField_c_of_type_Long, "actFileUfAppBabySdkDownloadDetail", this.a.jdField_a_of_type_Long, "", "", "", "", paramInt, paramString, l1, l2, this.a.b, this.a.jdField_c_of_type_JavaLangString, "", 0, paramString, null);
      StatisticAssist.a(localQQAppInterface.getApplication().getApplicationContext(), localQQAppInterface.getCurrentAccountUin(), "Stop_download_2-0_3-0");
    }
    for (;;)
    {
      if (UniformDownloaderAppBaby.a(this.a) != null) {
        UniformDownloaderAppBaby.a(this.a).a(paramInt, paramString, paramBundle);
      }
      return;
      QLog.w(UniformDownloaderAppBaby.jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.a.jdField_c_of_type_Long + "].report failed - 6");
    }
  }
  
  public void a(Bundle paramBundle)
  {
    if (UniformDownloaderAppBaby.a(this.a) != null) {
      UniformDownloaderAppBaby.a(this.a).a(this.a.h(), null);
    }
  }
  
  public void a(String paramString, Bundle paramBundle)
  {
    QLog.i(UniformDownloaderAppBaby.jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.a.jdField_c_of_type_Long + "] >>>>>>Download SUCCESS. sdk download path=" + paramString);
    this.a.c(4);
    if (paramString == null)
    {
      QLog.e(UniformDownloaderAppBaby.jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.a.jdField_c_of_type_Long + "]. download success, but filepath = null");
      a(40, UniformDownloader.a(40), paramBundle);
    }
    label783:
    label821:
    for (;;)
    {
      return;
      if (FileUtils.a(this.a.e)) {
        this.a.e = FileManagerUtil.b(this.a.e);
      }
      QLog.i(UniformDownloaderAppBaby.jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.a.jdField_c_of_type_Long + "]. try to rename file to path:" + this.a.e);
      Object localObject;
      if (!FileUtils.b(new File(paramString), new File(this.a.e)))
      {
        QLog.e(UniformDownloaderAppBaby.jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.a.jdField_c_of_type_Long + "].rename failed. temppath=" + paramString + " save path=" + this.a.e);
        localObject = FileUtil.b(paramString);
        if (!FileManagerUtil.b().equalsIgnoreCase((String)localObject))
        {
          String str = (String)localObject + this.a.d;
          localObject = str;
          if (FileUtils.a(str)) {
            localObject = FileManagerUtil.b(str);
          }
          QLog.i(UniformDownloaderAppBaby.jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.a.jdField_c_of_type_Long + "]. rename failed, try to save file to path: " + (String)localObject);
          if (!FileUtils.b(new File(paramString), new File((String)localObject)))
          {
            QLog.e(UniformDownloaderAppBaby.jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.a.jdField_c_of_type_Long + "]. rename failed, try failed save path: " + (String)localObject);
            a(7, UniformDownloader.a(7), paramBundle);
            return;
          }
          this.a.e = ((String)localObject);
        }
      }
      else
      {
        QLog.i(UniformDownloaderAppBaby.jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.a.jdField_c_of_type_Long + "]. rename file success. path:" + this.a.e);
        paramString = UniformDownloadMgr.a().a();
        if (paramString == null) {
          break label783;
        }
        long l1 = -1L;
        long l2 = -1L;
        localObject = UniformDownloaderAppBabySdk.RParam.a(paramBundle);
        if (localObject == null) {
          break label743;
        }
        l1 = ((UniformDownloaderAppBabySdk.RParam)localObject).jdField_a_of_type_Long;
        l2 = ((UniformDownloaderAppBabySdk.RParam)localObject).b;
        FileManagerUtil.a(paramString, this.a.jdField_c_of_type_Long, "actFileUfAppBabySdkDownload", System.currentTimeMillis() - this.a.jdField_a_of_type_Long, "", "", "", "", l1, l2, this.a.b, 0, null);
        FileManagerUtil.a(paramString, this.a.jdField_c_of_type_Long, "actFileUfAppBabySdkDownloadDetail", System.currentTimeMillis() - this.a.jdField_a_of_type_Long, "", "", "", "", l1, l2, this.a.b, 0, null);
        StatisticAssist.a(paramString.getApplication().getApplicationContext(), paramString.getCurrentAccountUin(), "Complete_download_2_0");
      }
      for (;;)
      {
        if (UniformDownloaderAppBaby.a(this.a) == null) {
          break label821;
        }
        UniformDownloaderAppBaby.a(this.a).a(this.a.e, this.a.b, paramBundle);
        return;
        QLog.e(UniformDownloaderAppBaby.jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.a.jdField_c_of_type_Long + "]. rename failed 2, try failed save path: " + paramString);
        a(7, UniformDownloader.a(7), paramBundle);
        return;
        label743:
        QLog.w(UniformDownloaderAppBaby.jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.a.jdField_c_of_type_Long + "].report may failed - 0");
        break;
        QLog.i(UniformDownloaderAppBaby.jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.a.jdField_c_of_type_Long + "].report failed - 7");
      }
    }
  }
  
  public void b(Bundle paramBundle)
  {
    this.a.c(3);
    if (UniformDownloaderAppBaby.a(this.a) != null) {
      UniformDownloaderAppBaby.a(this.a).c(this.a.h(), null);
    }
  }
  
  public void c(Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acyk
 * JD-Core Version:    0.7.0.1
 */