import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.filemanager.fileviewer.controller.IDownloadController;
import com.tencent.mobileqq.filemanager.fileviewer.model.TroopFileModel;
import com.tencent.mobileqq.troop.data.TroopFileItemOperation;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;

public class admb
  implements IDownloadController
{
  public admb(TroopFileModel paramTroopFileModel) {}
  
  public void a()
  {
    FileManagerEntity localFileManagerEntity = this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
    TroopFileStatusInfo localTroopFileStatusInfo = TroopFileUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity);
    if ((TextUtils.isEmpty(TroopFileModel.a(this.a))) && (localTroopFileStatusInfo.a != null)) {
      TroopFileModel.a(this.a, localTroopFileStatusInfo.a.toString());
    }
    TroopFileItemOperation localTroopFileItemOperation = new TroopFileItemOperation(localFileManagerEntity.TroopUin, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidAppActivity);
    if ((localTroopFileStatusInfo.jdField_b_of_type_Int == 10) || (localTroopFileStatusInfo.jdField_b_of_type_Int == 9)) {
      if (localTroopFileStatusInfo.a != null)
      {
        localTroopFileItemOperation.b(localTroopFileStatusInfo.a);
        localFileManagerEntity.status = 2;
      }
    }
    do
    {
      do
      {
        return;
      } while (!QLog.isColorLevel());
      QLog.i("TroopFileModel<FileAssistant>", 2, "TroopFileModel doStartDownload : resumeDownload error, infoId is null");
      return;
      if (localTroopFileStatusInfo.jdField_b_of_type_Int == 7)
      {
        if (localFileManagerEntity.isZipInnerFile) {
          localTroopFileItemOperation.a(localFileManagerEntity);
        }
        for (;;)
        {
          localFileManagerEntity.status = 2;
          return;
          localTroopFileItemOperation.a(localFileManagerEntity.strTroopFilePath, localTroopFileStatusInfo.g, localTroopFileStatusInfo.jdField_b_of_type_Long, localTroopFileStatusInfo.e);
        }
      }
    } while (!QLog.isColorLevel());
    QLog.i("TroopFileModel<FileAssistant>", 2, "TroopFileModel doStartDownload : can not handle file info status,download error");
  }
  
  public void b()
  {
    Object localObject = this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((FileManagerEntity)localObject).TroopUin);
    localObject = TroopFileUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (FileManagerEntity)localObject);
    if ((TextUtils.isEmpty(TroopFileModel.a(this.a))) && (((TroopFileStatusInfo)localObject).a != null)) {
      TroopFileModel.a(this.a, ((TroopFileStatusInfo)localObject).a.toString());
    }
    if (!TextUtils.isEmpty(TroopFileModel.a(this.a)))
    {
      localTroopFileTransferManager.d(UUID.fromString(TroopFileModel.a(this.a)));
      TroopFileModel.a(this.a, (TroopFileStatusInfo)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     admb
 * JD-Core Version:    0.7.0.1
 */