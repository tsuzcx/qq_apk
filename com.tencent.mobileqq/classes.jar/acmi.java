import android.view.animation.AlphaAnimation;
import com.tencent.mobileqq.filemanager.activity.FilePreviewActivity;
import com.tencent.mobileqq.filemanager.util.FilePreviewAnimQueue;
import com.tencent.mobileqq.filemanager.util.FilePreviewAnimQueue.FilePreviewAnim;
import com.tencent.qphone.base.util.QLog;

public class acmi
  implements Runnable
{
  public acmi(FilePreviewActivity paramFilePreviewActivity, int paramInt) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.c == null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.c = new FilePreviewAnimQueue(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.a);
    }
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setFillAfter(true);
    FilePreviewAnimQueue.FilePreviewAnim localFilePreviewAnim = new FilePreviewAnimQueue.FilePreviewAnim();
    localFilePreviewAnim.jdField_a_of_type_JavaLangObject = localAlphaAnimation;
    localFilePreviewAnim.jdField_a_of_type_Boolean = false;
    localFilePreviewAnim.jdField_a_of_type_Int = FilePreviewAnimQueue.jdField_a_of_type_Int;
    localFilePreviewAnim.b = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.c.a(localFilePreviewAnim);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.c.a();
    if (QLog.isColorLevel()) {
      QLog.i("<FileAssistant>FilePreviewActivity", 2, "hideGetMore(" + this.jdField_a_of_type_Int + ")");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acmi
 * JD-Core Version:    0.7.0.1
 */