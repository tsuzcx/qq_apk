import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

class acug
  implements Runnable
{
  acug(acuf paramacuf) {}
  
  public void run()
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType == 0)
    {
      QLog.i("FileTransferHandler<FileAssistant>", 1, "Id[" + this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]Send CCMsg, but not size and thumb, try download Pic Thumb");
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferHandler.a.a().b(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, 7);
    }
    while (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType != 2) {
      return;
    }
    QLog.i("FileTransferHandler<FileAssistant>", 1, "Id[" + this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]Send CCMsg, but not size and thumb, try download Video Thumb");
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferHandler.a.a().a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     acug
 * JD-Core Version:    0.7.0.1
 */