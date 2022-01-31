import com.tencent.mobileqq.richmedia.capture.fragment.QzoneEffectsCameraCaptureFragment;
import com.tencent.open.base.ToastUtil;

public class ahki
  implements Runnable
{
  public ahki(QzoneEffectsCameraCaptureFragment paramQzoneEffectsCameraCaptureFragment, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    QzoneEffectsCameraCaptureFragment.b(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureFragmentQzoneEffectsCameraCaptureFragment);
    if (this.jdField_a_of_type_Boolean)
    {
      QzoneEffectsCameraCaptureFragment.b(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureFragmentQzoneEffectsCameraCaptureFragment, this.jdField_a_of_type_JavaLangString);
      return;
    }
    ToastUtil.a().a("对不起，GIF处理异常...");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahki
 * JD-Core Version:    0.7.0.1
 */