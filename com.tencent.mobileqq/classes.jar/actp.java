import com.tencent.mobileqq.filemanager.activity.recentfile.QfileRecentPicFileTabView;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.QfileTimeUtils;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class actp
  implements Runnable
{
  public actp(QfileRecentPicFileTabView paramQfileRecentPicFileTabView, FileManagerEntity paramFileManagerEntity) {}
  
  public void run()
  {
    Object localObject = QfileTimeUtils.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.srvTime);
    if (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityRecentfileQfileRecentPicFileTabView.a.containsKey(localObject)) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityRecentfileQfileRecentPicFileTabView.a.put(localObject, new ArrayList());
    }
    localObject = (List)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityRecentfileQfileRecentPicFileTabView.a.get(localObject);
    if (((List)localObject).contains(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity) == true) {
      return;
    }
    ((List)localObject).add(0, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityRecentfileQfileRecentPicFileTabView.i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     actp
 * JD-Core Version:    0.7.0.1
 */