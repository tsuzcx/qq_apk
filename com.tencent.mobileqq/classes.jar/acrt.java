import com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileDocTabView;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class acrt
  implements Runnable
{
  public acrt(QfileLocalFileDocTabView paramQfileLocalFileDocTabView, FileInfo paramFileInfo) {}
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalfileQfileLocalFileDocTabView.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo.d());
    if (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalfileQfileLocalFileDocTabView.jdField_a_of_type_JavaUtilLinkedHashMap.containsKey(localObject)) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalfileQfileLocalFileDocTabView.jdField_a_of_type_JavaUtilLinkedHashMap.put(localObject, new ArrayList());
    }
    localObject = (List)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalfileQfileLocalFileDocTabView.jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject);
    if (((List)localObject).contains(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo) == true) {}
    do
    {
      return;
      ((List)localObject).add(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalfileQfileLocalFileDocTabView.i();
    } while (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalfileQfileLocalFileDocTabView.jdField_a_of_type_JavaUtilArrayList.size() != 1);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalfileQfileLocalFileDocTabView.setSelect(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acrt
 * JD-Core Version:    0.7.0.1
 */