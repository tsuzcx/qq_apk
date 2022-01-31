import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.richmedia.capture.fragment.QzoneEffectsCameraCaptureFragment;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.VideoCaptureResult;
import com.tencent.mobileqq.shortvideo.mediadevice.GifProcessor;
import cooperation.qzone.util.QZLog;
import java.io.File;

public class ahkh
  implements Runnable
{
  public ahkh(QzoneEffectsCameraCaptureFragment paramQzoneEffectsCameraCaptureFragment, CameraCaptureView.VideoCaptureResult paramVideoCaptureResult, LocalMediaInfo paramLocalMediaInfo) {}
  
  public void run()
  {
    try
    {
      File localFile = new File(QzoneEffectsCameraCaptureFragment.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureFragmentQzoneEffectsCameraCaptureFragment));
      int i = GifProcessor.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult.videoMp4FilePath, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaWidth, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaHeight, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration, localFile.getAbsolutePath());
      QZLog.i("QzoneEffectsCameraCaptureFragment", "Video2GifConverter: convert retCode=" + i);
      QzoneEffectsCameraCaptureFragment localQzoneEffectsCameraCaptureFragment = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureFragmentQzoneEffectsCameraCaptureFragment;
      if (i == 0) {}
      for (boolean bool = true;; bool = false)
      {
        QzoneEffectsCameraCaptureFragment.a(localQzoneEffectsCameraCaptureFragment, bool, localFile.getAbsolutePath());
        return;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QZLog.e("QzoneEffectsCameraCaptureFragment", "processNotExistVideoData: convert exception", localThrowable);
      QzoneEffectsCameraCaptureFragment.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureFragmentQzoneEffectsCameraCaptureFragment, false, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahkh
 * JD-Core Version:    0.7.0.1
 */