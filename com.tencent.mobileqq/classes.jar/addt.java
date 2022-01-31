import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.filemanager.fileviewer.controller.IUploadController;
import com.tencent.mobileqq.filemanager.fileviewer.model.TroopFileModel;
import com.tencent.mobileqq.troop.data.TroopFileItemOperation;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import java.util.UUID;

public class addt
  implements IUploadController
{
  public addt(TroopFileModel paramTroopFileModel) {}
  
  public void a()
  {
    FileManagerEntity localFileManagerEntity = this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
    TroopFileStatusInfo localTroopFileStatusInfo = TroopFileUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity);
    if ((TextUtils.isEmpty(TroopFileModel.a(this.a))) && (localTroopFileStatusInfo.a != null)) {
      TroopFileModel.a(this.a, localTroopFileStatusInfo.a.toString());
    }
    TroopFileItemOperation localTroopFileItemOperation = new TroopFileItemOperation(localFileManagerEntity.TroopUin, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidAppActivity);
    if (((localTroopFileStatusInfo.b == 3) || (localTroopFileStatusInfo.b == 2)) && (localTroopFileStatusInfo.a != null)) {
      localTroopFileItemOperation.a(localTroopFileStatusInfo.a);
    }
    localFileManagerEntity.status = 2;
  }
  
  public void b()
  {
    Object localObject = this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((FileManagerEntity)localObject).TroopUin);
    localObject = TroopFileUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (FileManagerEntity)localObject);
    if (!TextUtils.isEmpty(TroopFileModel.a(this.a)))
    {
      localTroopFileTransferManager.c(UUID.fromString(TroopFileModel.a(this.a)));
      TroopFileModel.a(this.a, (TroopFileStatusInfo)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     addt
 * JD-Core Version:    0.7.0.1
 */