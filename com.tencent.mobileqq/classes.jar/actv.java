import android.text.TextUtils;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.filemanager.fileviewer.model.TroopFileModel;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;

public class actv
  extends BizTroopObserver
{
  public actv(TroopFileModel paramTroopFileModel) {}
  
  protected void a(Object paramObject)
  {
    Object localObject = this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
    paramObject = (TroopFileStatusInfo)paramObject;
    if (((FileManagerEntity)localObject).TroopUin != paramObject.jdField_a_of_type_Long) {
      if (QLog.isDevelopLevel()) {
        QLog.d("TroopFileModel<FileAssistant>", 4, "difference troop uin file");
      }
    }
    do
    {
      return;
      if (TextUtils.isEmpty(TroopFileModel.a(this.a)))
      {
        localObject = TroopFileUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (FileManagerEntity)localObject);
        if (((TroopFileStatusInfo)localObject).jdField_a_of_type_JavaUtilUUID != null) {
          TroopFileModel.a(this.a, ((TroopFileStatusInfo)localObject).jdField_a_of_type_JavaUtilUUID.toString());
        }
      }
    } while ((paramObject.jdField_a_of_type_JavaUtilUUID == null) || (TroopFileModel.a(this.a) == null) || (!TroopFileModel.a(this.a).equals(paramObject.jdField_a_of_type_JavaUtilUUID.toString())));
    TroopFileModel.a(this.a, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     actv
 * JD-Core Version:    0.7.0.1
 */