import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerRSWorker;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

class aclj
  implements Runnable
{
  aclj(aclh paramaclh) {}
  
  public void run()
  {
    try
    {
      if (this.a.a.jdField_a_of_type_JavaIoOutputStream == null) {
        this.a.a.jdField_a_of_type_JavaIoOutputStream = new FileOutputStream(this.a.a.d, true);
      }
      if (this.a.a.b == 1) {
        this.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.a.c, 2002);
      }
      this.a.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
      this.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.a.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      this.a.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 2;
      FileManagerRSWorker.a(this.a.a, this.a.a.jdField_a_of_type_Long, this.a.a.h);
      return;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      localFileNotFoundException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aclj
 * JD-Core Version:    0.7.0.1
 */