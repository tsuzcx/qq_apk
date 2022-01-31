import android.view.animation.AlphaAnimation;
import com.tencent.mobileqq.filemanager.activity.FilePreviewActivity;
import com.tencent.mobileqq.filemanager.util.FilePreviewAnimQueue;
import com.tencent.mobileqq.filemanager.util.FilePreviewAnimQueue.FilePreviewAnim;

public class acch
  implements Runnable
{
  public acch(FilePreviewActivity paramFilePreviewActivity) {}
  
  public void run()
  {
    if (this.a.b == null) {
      this.a.b = new FilePreviewAnimQueue(this.a.a);
    }
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setFillAfter(true);
    FilePreviewAnimQueue.FilePreviewAnim localFilePreviewAnim = new FilePreviewAnimQueue.FilePreviewAnim();
    localFilePreviewAnim.jdField_a_of_type_JavaLangObject = localAlphaAnimation;
    localFilePreviewAnim.jdField_a_of_type_Boolean = false;
    localFilePreviewAnim.jdField_a_of_type_Int = FilePreviewAnimQueue.jdField_a_of_type_Int;
    localFilePreviewAnim.b = 1500;
    this.a.b.a(localFilePreviewAnim);
    this.a.b.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acch
 * JD-Core Version:    0.7.0.1
 */