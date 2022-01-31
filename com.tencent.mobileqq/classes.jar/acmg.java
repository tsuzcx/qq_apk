import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.filemanager.core.FileVideoManager.FileVideoManagerCallback;
import com.tencent.mobileqq.filemanager.core.FileVideoManager.VideoControl;
import java.lang.ref.WeakReference;

public class acmg
  implements DialogInterface.OnClickListener
{
  public acmg(FileVideoManager.VideoControl paramVideoControl) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
    }
    if (this.a.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      paramDialogInterface = (FileVideoManager.FileVideoManagerCallback)this.a.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (paramDialogInterface != null) {
        paramDialogInterface.ac_();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acmg
 * JD-Core Version:    0.7.0.1
 */