import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import com.tencent.mobileqq.filemanager.activity.FilePreviewActivity;
import com.tencent.mobileqq.filemanager.util.FilePreviewAnimQueue;
import com.tencent.mobileqq.filemanager.util.FilePreviewAnimQueue.FilePreviewAnim;

public class acmf
  implements Runnable
{
  public acmf(FilePreviewActivity paramFilePreviewActivity) {}
  
  public void run()
  {
    if (this.a.d) {
      return;
    }
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, 0 - this.a.jdField_a_of_type_AndroidViewViewGroup.getHeight());
    if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilFilePreviewAnimQueue == null) {
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilFilePreviewAnimQueue = new FilePreviewAnimQueue(this.a.jdField_a_of_type_AndroidViewViewGroup);
    }
    FilePreviewAnimQueue.FilePreviewAnim localFilePreviewAnim = new FilePreviewAnimQueue.FilePreviewAnim();
    localFilePreviewAnim.jdField_a_of_type_JavaLangObject = localTranslateAnimation;
    localFilePreviewAnim.jdField_a_of_type_Boolean = false;
    localFilePreviewAnim.jdField_a_of_type_Int = FilePreviewAnimQueue.b;
    localFilePreviewAnim.b = 250;
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilFilePreviewAnimQueue.a(localFilePreviewAnim);
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilFilePreviewAnimQueue.a();
    this.a.d = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acmf
 * JD-Core Version:    0.7.0.1
 */