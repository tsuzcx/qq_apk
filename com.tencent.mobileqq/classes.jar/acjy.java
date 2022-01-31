import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileCategoryUtil.GetApkPackageInfoCallback;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil.FileExecutor;
import java.util.concurrent.Executor;

public class acjy
  implements FileCategoryUtil.GetApkPackageInfoCallback
{
  public acjy(FileManagerEngine paramFileManagerEngine, FileManagerEntity paramFileManagerEntity, Runnable paramRunnable) {}
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = paramString;
    FileManagerUtil.FileExecutor.a().execute(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strApkPackageName = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     acjy
 * JD-Core Version:    0.7.0.1
 */