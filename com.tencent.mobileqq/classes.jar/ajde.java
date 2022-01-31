import com.tencent.mobileqq.surfaceviewaction.gl.FrameSprite.OnFrameEndListener;
import com.tencent.mobileqq.troop.utils.VideoAnimationUtils;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;

public final class ajde
  extends DownloadListener
{
  public ajde(WeakReference paramWeakReference, File paramFile, FrameSprite.OnFrameEndListener paramOnFrameEndListener) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoAnimationUtils", 2, "onDone:" + paramDownloadTask.a);
    }
    VideoAnimationUtils.a(this.jdField_a_of_type_JavaLangRefWeakReference, this.jdField_a_of_type_JavaIoFile.getAbsolutePath(), this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite$OnFrameEndListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ajde
 * JD-Core Version:    0.7.0.1
 */