import com.tencent.mobileqq.filemanager.core.FileManagerRSCenter;
import com.tencent.mobileqq.filemanager.core.FileVideoManager;
import com.tencent.mobileqq.filemanager.core.FileVideoManager.FileVideoManagerInitCallback;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

public class addk
  implements FileVideoManager.FileVideoManagerInitCallback
{
  public addk(FileManagerRSCenter paramFileManagerRSCenter, FileManagerEntity paramFileManagerEntity) {}
  
  public void a()
  {
    QLog.e("FileManagerRSCenter<FileAssistant>", 1, "=_= v! entity[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "] init cancel!");
  }
  
  public void b()
  {
    QLog.e("FileManagerRSCenter<FileAssistant>", 1, "=_= v> entity[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "] init success, start video download");
    FileVideoManager.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     addk
 * JD-Core Version:    0.7.0.1
 */