import com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileOtherTabView;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class acsa
  implements Runnable
{
  public acsa(QfileLocalFileOtherTabView paramQfileLocalFileOtherTabView, FileInfo paramFileInfo) {}
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalfileQfileLocalFileOtherTabView.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo.d());
    if (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalfileQfileLocalFileOtherTabView.a.containsKey(localObject)) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalfileQfileLocalFileOtherTabView.a.put(localObject, new ArrayList());
    }
    localObject = (List)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalfileQfileLocalFileOtherTabView.a.get(localObject);
    if (((List)localObject).contains(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo) == true) {
      return;
    }
    ((List)localObject).add(0, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalfileQfileLocalFileOtherTabView.i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acsa
 * JD-Core Version:    0.7.0.1
 */