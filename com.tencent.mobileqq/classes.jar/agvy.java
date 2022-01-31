import android.view.animation.AlphaAnimation;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;
import com.tencent.mobileqq.richmedia.capture.fragment.EffectsCameraCaptureFragment;

public class agvy
  implements Runnable
{
  public agvy(EffectsCameraCaptureFragment paramEffectsCameraCaptureFragment, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void run()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureFragmentEffectsCameraCaptureFragment.a.setAnimationListener(null);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureFragmentEffectsCameraCaptureFragment.b.setAnimationListener(null);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureFragmentEffectsCameraCaptureFragment.b.cancel();
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureFragmentEffectsCameraCaptureFragment.a.cancel();
      EffectsCameraCaptureFragment.d(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureFragmentEffectsCameraCaptureFragment).clearAnimation();
      EffectsCameraCaptureFragment.d(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureFragmentEffectsCameraCaptureFragment).setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureFragmentEffectsCameraCaptureFragment.h = false;
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureFragmentEffectsCameraCaptureFragment.b.reset();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureFragmentEffectsCameraCaptureFragment.a.reset();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureFragmentEffectsCameraCaptureFragment.h = true;
    EffectsCameraCaptureFragment.d(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureFragmentEffectsCameraCaptureFragment).setVisibility(0);
    EffectsCameraCaptureFragment.d(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureFragmentEffectsCameraCaptureFragment).setText(2131439073);
    AlphaAnimation localAlphaAnimation = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureFragmentEffectsCameraCaptureFragment.a;
    Object localObject;
    if (this.b)
    {
      localObject = EffectsCameraCaptureFragment.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureFragmentEffectsCameraCaptureFragment);
      localAlphaAnimation.setAnimationListener((Animation.AnimationListener)localObject);
      localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureFragmentEffectsCameraCaptureFragment.a;
      if (!this.b) {
        break label224;
      }
    }
    label224:
    for (long l = 2000L;; l = 3000L)
    {
      ((AlphaAnimation)localObject).setStartOffset(l);
      EffectsCameraCaptureFragment.d(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureFragmentEffectsCameraCaptureFragment).setAnimation(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureFragmentEffectsCameraCaptureFragment.a);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureFragmentEffectsCameraCaptureFragment.a.startNow();
      return;
      localObject = EffectsCameraCaptureFragment.b(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureFragmentEffectsCameraCaptureFragment);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     agvy
 * JD-Core Version:    0.7.0.1
 */