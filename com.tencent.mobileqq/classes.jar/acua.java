import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

public class acua
  implements Runnable
{
  public acua(FileTransferHandler paramFileTransferHandler, FileManagerEntity paramFileManagerEntity) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType == 0)
    {
      QLog.i("FileTransferHandler<FileAssistant>", 1, "Id[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]Send CCMsg, but not size and thumb, try download Pic Thumb");
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferHandler.a.a().b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, 7);
    }
    while (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType != 2) {
      return;
    }
    QLog.i("FileTransferHandler<FileAssistant>", 1, "Id[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]Send CCMsg, but not size and thumb, try download Video Thumb");
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferHandler.a.a().b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     acua
 * JD-Core Version:    0.7.0.1
 */