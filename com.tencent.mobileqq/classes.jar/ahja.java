import android.os.Handler;
import android.widget.TextView;
import com.tencent.mobileqq.richmedia.capture.fragment.EffectsCameraCaptureFragment;
import com.tencent.mobileqq.richmedia.capture.gesture.GLGestureProxy;

public class ahja
  implements Runnable
{
  public ahja(EffectsCameraCaptureFragment paramEffectsCameraCaptureFragment, String paramString1, int paramInt, String paramString2) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureFragmentEffectsCameraCaptureFragment.c = this.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureFragmentEffectsCameraCaptureFragment.b = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureFragmentEffectsCameraCaptureFragment.d = this.b;
    EffectsCameraCaptureFragment.b(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureFragmentEffectsCameraCaptureFragment);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureFragmentEffectsCameraCaptureFragment.a.removeCallbacks(EffectsCameraCaptureFragment.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureFragmentEffectsCameraCaptureFragment));
    EffectsCameraCaptureFragment.e(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureFragmentEffectsCameraCaptureFragment).setVisibility(8);
    GLGestureProxy.a().b(EffectsCameraCaptureFragment.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureFragmentEffectsCameraCaptureFragment));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahja
 * JD-Core Version:    0.7.0.1
 */