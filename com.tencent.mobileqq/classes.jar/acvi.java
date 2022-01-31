import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerRSWorker;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

class acvi
  implements Runnable
{
  acvi(acve paramacve, String paramString) {}
  
  public void run()
  {
    try
    {
      if (this.jdField_a_of_type_Acve.a.jdField_a_of_type_JavaIoOutputStream == null) {
        this.jdField_a_of_type_Acve.a.jdField_a_of_type_JavaIoOutputStream = new FileOutputStream(this.jdField_a_of_type_Acve.a.d, true);
      }
      this.jdField_a_of_type_Acve.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Acve.a.c, 2002);
      this.jdField_a_of_type_Acve.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
      this.jdField_a_of_type_Acve.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_Acve.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      this.jdField_a_of_type_Acve.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 2;
      this.jdField_a_of_type_Acve.a.h = this.jdField_a_of_type_JavaLangString;
      FileManagerRSWorker.a(this.jdField_a_of_type_Acve.a, this.jdField_a_of_type_Acve.a.jdField_a_of_type_Long, this.jdField_a_of_type_Acve.a.h);
      return;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      localFileNotFoundException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acvi
 * JD-Core Version:    0.7.0.1
 */