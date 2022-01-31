import com.tencent.mobileqq.richmedia.capture.data.CaptureVideoFilterManager;
import com.tencent.mobileqq.richmedia.capture.data.CaptureVideoFilterManager.OnResourceDownloadListener;
import com.tencent.mobileqq.richmedia.capture.fragment.EffectsCameraCaptureFragment;
import com.tencent.qphone.base.util.QLog;

class ahjx
  implements CaptureVideoFilterManager.OnResourceDownloadListener
{
  ahjx(ahjw paramahjw) {}
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.a.a.a(CaptureVideoFilterManager.a().a());
      if (QLog.isColorLevel()) {
        QLog.d("CameraCaptureFragment", 2, "EffectsCameraCaptureFragment onResourceDownload");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahjx
 * JD-Core Version:    0.7.0.1
 */