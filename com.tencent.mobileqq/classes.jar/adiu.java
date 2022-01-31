import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.FileManagerProxy;

public class adiu
  implements Runnable
{
  public adiu(FileManagerProxy paramFileManagerProxy, FileManagerEntity paramFileManagerEntity) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerProxy.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, null);
    if (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bDelInFM) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerProxy.c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adiu
 * JD-Core Version:    0.7.0.1
 */