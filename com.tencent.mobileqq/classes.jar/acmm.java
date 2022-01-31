import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.core.FileVideoManager;
import com.tencent.mobileqq.filemanager.core.FileVideoManager.VideoControl;

public class acmm
  implements Runnable
{
  public acmm(FileVideoManager.VideoControl paramVideoControl, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$VideoControl.a == null)
    {
      FileVideoManager.VideoControl.c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$VideoControl);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$VideoControl.a();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true, 3, null);
    }
    FileVideoManager.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager$VideoControl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acmm
 * JD-Core Version:    0.7.0.1
 */