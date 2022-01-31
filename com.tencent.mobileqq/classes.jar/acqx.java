import android.app.Activity;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;

public final class acqx
  implements FMDialogUtil.FMDialogInterface
{
  public acqx(Activity paramActivity, FileManagerEntity paramFileManagerEntity) {}
  
  public void a()
  {
    FileManagerUtil.c(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath());
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acqx
 * JD-Core Version:    0.7.0.1
 */