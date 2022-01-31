import android.graphics.Bitmap;
import android.support.v4.util.MQLruCache;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.DownloadIconsListener;
import com.tencent.mobileqq.leba.header.LebaGridShowManager;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.Set;

public class aejj
  implements Runnable
{
  public aejj(LebaGridShowManager paramLebaGridShowManager, QQAppInterface paramQQAppInterface, URL paramURL, File paramFile, String paramString) {}
  
  public void run()
  {
    int i = 0;
    for (;;)
    {
      try
      {
        if (HttpDownloadUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaNetURL, this.jdField_a_of_type_JavaIoFile))
        {
          if (QLog.isColorLevel()) {
            QLog.d("LebaGridShowManager", 2, "Download icon key = " + this.jdField_a_of_type_JavaLangString + "suc--------");
          }
          Object localObject1 = null;
          if (BaseApplicationImpl.sImageCache != null)
          {
            localObject1 = "LebaIcon://" + this.jdField_a_of_type_JavaIoFile.getAbsolutePath();
            localObject1 = (Bitmap)BaseApplicationImpl.sImageCache.get(localObject1);
          }
          if (QLog.isColorLevel())
          {
            ??? = new StringBuilder().append("get Bitmap from cache, result=");
            if (localObject1 == null) {
              break label346;
            }
            bool = true;
            QLog.d("LebaGridShowManager", 2, bool);
          }
          if (localObject1 != null) {
            break label343;
          }
          localObject1 = LebaGridShowManager.a(this.jdField_a_of_type_ComTencentMobileqqLebaHeaderLebaGridShowManager, this.jdField_a_of_type_JavaIoFile);
          if (localObject1 != null) {
            if (QLog.isColorLevel()) {
              QLog.d("LebaGridShowManager", 2, "Download icon key = " + this.jdField_a_of_type_JavaLangString + "notify UI++++++++");
            }
          }
          synchronized (this.jdField_a_of_type_ComTencentMobileqqLebaHeaderLebaGridShowManager.jdField_a_of_type_JavaUtilList)
          {
            if (i < this.jdField_a_of_type_ComTencentMobileqqLebaHeaderLebaGridShowManager.jdField_a_of_type_JavaUtilList.size())
            {
              ((DownloadIconsListener)this.jdField_a_of_type_ComTencentMobileqqLebaHeaderLebaGridShowManager.jdField_a_of_type_JavaUtilList.get(i)).a(this.jdField_a_of_type_JavaLangString, (Bitmap)localObject1);
              i += 1;
              continue;
            }
            LebaGridShowManager.a(this.jdField_a_of_type_ComTencentMobileqqLebaHeaderLebaGridShowManager, this.jdField_a_of_type_JavaLangString);
            return;
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqLebaHeaderLebaGridShowManager.jdField_a_of_type_JavaUtilSet.remove(this.jdField_a_of_type_JavaLangString);
      }
      catch (Exception localException)
      {
        this.jdField_a_of_type_ComTencentMobileqqLebaHeaderLebaGridShowManager.jdField_a_of_type_JavaUtilSet.remove(this.jdField_a_of_type_JavaLangString);
        LebaGridShowManager.b(this.jdField_a_of_type_ComTencentMobileqqLebaHeaderLebaGridShowManager, this.jdField_a_of_type_JavaLangString);
        return;
      }
      LebaGridShowManager.b(this.jdField_a_of_type_ComTencentMobileqqLebaHeaderLebaGridShowManager, this.jdField_a_of_type_JavaLangString);
      return;
      label343:
      continue;
      label346:
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aejj
 * JD-Core Version:    0.7.0.1
 */