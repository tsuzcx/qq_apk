import com.tencent.mobileqq.filemanager.activity.recentfile.QfileRecentDocFileTabView;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class acjm
  implements Runnable
{
  public acjm(QfileRecentDocFileTabView paramQfileRecentDocFileTabView, String paramString, FileManagerEntity paramFileManagerEntity) {}
  
  public void run()
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityRecentfileQfileRecentDocFileTabView.a.containsKey(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityRecentfileQfileRecentDocFileTabView.a.put(this.jdField_a_of_type_JavaLangString, new ArrayList());
    }
    List localList = (List)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityRecentfileQfileRecentDocFileTabView.a.get(this.jdField_a_of_type_JavaLangString);
    if (localList.contains(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity) == true) {
      return;
    }
    localList.add(0, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityRecentfileQfileRecentDocFileTabView.i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acjm
 * JD-Core Version:    0.7.0.1
 */