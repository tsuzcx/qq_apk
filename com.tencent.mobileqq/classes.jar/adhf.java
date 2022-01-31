import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.util.FileCategoryUtil.GetApkPackageInfoCallback;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.qphone.base.util.BaseApplication;

public final class adhf
  implements Runnable
{
  public adhf(String paramString, FileCategoryUtil.GetApkPackageInfoCallback paramGetApkPackageInfoCallback) {}
  
  public void run()
  {
    Object localObject = BaseApplicationImpl.getContext().getPackageManager();
    PackageInfo localPackageInfo = ((PackageManager)localObject).getPackageArchiveInfo(this.jdField_a_of_type_JavaLangString, 1);
    if (localPackageInfo != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilFileCategoryUtil$GetApkPackageInfoCallback.b(localPackageInfo.applicationInfo.packageName);
      localObject = localPackageInfo.applicationInfo.loadLabel((PackageManager)localObject).toString();
      localObject = (String)localObject + ".apk";
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilFileCategoryUtil$GetApkPackageInfoCallback.a((String)localObject);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilFileCategoryUtil$GetApkPackageInfoCallback.b(FileManagerUtil.a(this.jdField_a_of_type_JavaLangString));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilFileCategoryUtil$GetApkPackageInfoCallback.a(FileManagerUtil.a(this.jdField_a_of_type_JavaLangString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adhf
 * JD-Core Version:    0.7.0.1
 */