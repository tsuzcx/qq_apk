import com.tencent.biz.troop.file.TroopFileProtocol;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.OnPreviewVideoOnlineListener;
import com.tencent.mobileqq.filemanager.fileviewer.model.TroopFileModel;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class actr
  implements Runnable
{
  public actr(TroopFileModel paramTroopFileModel, FileManagerEntity paramFileManagerEntity, FileBrowserModelBase.OnPreviewVideoOnlineListener paramOnPreviewVideoOnlineListener) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isZipInnerFile)
    {
      TroopFileProtocol.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelTroopFileModel.a, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.TroopUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.zipFilePath, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.busId, new acts(this));
      return;
    }
    try
    {
      TroopFileTransferManager localTroopFileTransferManager = (TroopFileTransferManager)TroopFileTransferManager.a.get(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.TroopUin));
      if (localTroopFileTransferManager == null)
      {
        if (QLog.isDevelopLevel()) {
          QLog.e("TroopFileModel<FileAssistant>", 4, "bad troopUin" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.TroopUin);
        }
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnPreviewVideoOnlineListener.c();
        return;
      }
    }
    finally {}
    localObject.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strTroopFilePath, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.busId, TroopFileModel.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelTroopFileModel));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     actr
 * JD-Core Version:    0.7.0.1
 */