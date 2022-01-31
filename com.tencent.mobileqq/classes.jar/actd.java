import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.OnlineFileSessionCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import java.util.ArrayList;
import java.util.List;

class actd
  implements FMDialogUtil.FMDialogInterface
{
  actd(actb paramactb, FileManagerEntity paramFileManagerEntity) {}
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getCloudType() == 0) {
      QfileBaseRecentFileTabView.y(this.jdField_a_of_type_Actb.a).a().b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
    }
    DataLineHandler localDataLineHandler;
    ArrayList localArrayList;
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getCloudType() != 6) {
        break;
      }
      localDataLineHandler = (DataLineHandler)QfileBaseRecentFileTabView.z(this.jdField_a_of_type_Actb.a).a(8);
      localArrayList = new ArrayList();
      localArrayList.add(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq));
    } while (localDataLineHandler.a(localArrayList));
    FMToastUtil.a(2131428328);
    return;
    QfileBaseRecentFileTabView.A(this.jdField_a_of_type_Actb.a).a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     actd
 * JD-Core Version:    0.7.0.1
 */