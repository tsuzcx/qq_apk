import com.tencent.mobileqq.richmedia.capture.fragment.EffectsCameraCaptureFragment;
import com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView;
import com.tencent.mobileqq.shortvideo.dancemachine.utils.DanceLog;

public class ahns
  implements Runnable
{
  public ahns(EffectsCameraCaptureFragment paramEffectsCameraCaptureFragment, boolean paramBoolean) {}
  
  public void run()
  {
    DanceLog.a("EffectsFragment", "closeEvent begin exe isReady=" + this.jdField_a_of_type_Boolean);
    if ((this.jdField_a_of_type_Boolean) && (EffectsCameraCaptureFragment.e(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureFragmentEffectsCameraCaptureFragment)))
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureFragmentEffectsCameraCaptureFragment.jdField_a_of_type_Boolean = true;
      EffectsCameraCaptureFragment.b(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureFragmentEffectsCameraCaptureFragment);
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureFragmentEffectsCameraCaptureFragment.k();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureFragmentEffectsCameraCaptureFragment.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.setFaceEffect("");
    DanceLog.a("EffectsFragment", "closeEvent end  exe...");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahns
 * JD-Core Version:    0.7.0.1
 */