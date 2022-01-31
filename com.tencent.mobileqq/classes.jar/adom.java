import android.app.Activity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.FileVideoManager.FileVideoManagerInitCallback;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.recreate.FileModel;
import com.tencent.qphone.base.util.QLog;

public class adom
  implements FileVideoManager.FileVideoManagerInitCallback
{
  public adom(FileModel paramFileModel, Activity paramActivity) {}
  
  public void a() {}
  
  public void b()
  {
    try
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (localQQAppInterface == null)
      {
        QLog.e("FileModel<FileAssistant>", 1, "Start VideoActivity is not in QQ!");
        return;
      }
    }
    catch (Exception localException)
    {
      Object localObject;
      for (;;)
      {
        localObject = null;
      }
      if (((FileModel.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerRecreateFileModel).status == 0) || (FileModel.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerRecreateFileModel).status == 3)) && (((this.jdField_a_of_type_AndroidAppActivity instanceof ChatActivity)) || ((this.jdField_a_of_type_AndroidAppActivity instanceof SplashActivity))) && (!FileModel.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerRecreateFileModel).bSend))
      {
        localObject.a().a(FileModel.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerRecreateFileModel).nSessionId);
        return;
      }
      FileModel.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerRecreateFileModel, this.jdField_a_of_type_AndroidAppActivity);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adom
 * JD-Core Version:    0.7.0.1
 */