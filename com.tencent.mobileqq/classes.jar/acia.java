import com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileMediaTabView;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class acia
  implements Runnable
{
  public acia(QfileLocalFileMediaTabView paramQfileLocalFileMediaTabView, FileInfo paramFileInfo) {}
  
  public void run()
  {
    Object localObject = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo.a());
    if (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalfileQfileLocalFileMediaTabView.a.containsKey(localObject)) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalfileQfileLocalFileMediaTabView.a.put(localObject, new ArrayList());
    }
    localObject = (List)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalfileQfileLocalFileMediaTabView.a.get(localObject);
    if (((List)localObject).contains(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo) == true) {
      return;
    }
    ((List)localObject).add(0, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalfileQfileLocalFileMediaTabView.i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acia
 * JD-Core Version:    0.7.0.1
 */