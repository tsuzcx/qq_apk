import android.animation.ObjectAnimator;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.fragment.EffectsCameraCaptureFragment;
import com.tencent.mobileqq.richmedia.capture.util.CaptureReportUtil;
import com.tencent.mobileqq.richmedia.capture.view.ProviderContainerView;
import com.tencent.mobileqq.shortvideo.dancemachine.DisplayUtils;
import com.tencent.mobileqq.shortvideo.util.RecentDanceConfigMgr.DItemInfo;
import mqq.os.MqqHandler;

public class ahjs
  implements Runnable
{
  public ahjs(EffectsCameraCaptureFragment paramEffectsCameraCaptureFragment, RecentDanceConfigMgr.DItemInfo paramDItemInfo) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureFragmentEffectsCameraCaptureFragment.jdField_a_of_type_AndroidWidgetImageView = new ImageView(EffectsCameraCaptureFragment.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureFragmentEffectsCameraCaptureFragment).getContext());
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureFragmentEffectsCameraCaptureFragment.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845548);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(12, -1);
    localLayoutParams.addRule(11, -1);
    localLayoutParams.bottomMargin = DisplayUtils.a(400.0F);
    localLayoutParams.rightMargin = DisplayUtils.a(-154.0F);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureFragmentEffectsCameraCaptureFragment.jdField_a_of_type_AndroidWidgetImageView.setClickable(true);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureFragmentEffectsCameraCaptureFragment.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(new ahjt(this));
    if (EffectsCameraCaptureFragment.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureFragmentEffectsCameraCaptureFragment) == null) {
      EffectsCameraCaptureFragment.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureFragmentEffectsCameraCaptureFragment, new ahju(this));
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureFragmentEffectsCameraCaptureFragment.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderContainerView.a(EffectsCameraCaptureFragment.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureFragmentEffectsCameraCaptureFragment));
    EffectsCameraCaptureFragment.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureFragmentEffectsCameraCaptureFragment).addView(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureFragmentEffectsCameraCaptureFragment.jdField_a_of_type_AndroidWidgetImageView, localLayoutParams);
    int i = DisplayUtils.a(98.0F);
    EffectsCameraCaptureFragment.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureFragmentEffectsCameraCaptureFragment, ObjectAnimator.ofFloat(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureFragmentEffectsCameraCaptureFragment.jdField_a_of_type_AndroidWidgetImageView, "translationX", new float[] { i, 0.0F }));
    EffectsCameraCaptureFragment.c(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureFragmentEffectsCameraCaptureFragment).setDuration(300L);
    EffectsCameraCaptureFragment.b(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureFragmentEffectsCameraCaptureFragment, ObjectAnimator.ofFloat(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureFragmentEffectsCameraCaptureFragment.jdField_a_of_type_AndroidWidgetImageView, "translationX", new float[] { 0.0F, i }));
    EffectsCameraCaptureFragment.d(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureFragmentEffectsCameraCaptureFragment).setDuration(500L);
    EffectsCameraCaptureFragment.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureFragmentEffectsCameraCaptureFragment, true);
    CaptureReportUtil.j();
    ThreadManager.getUIHandler().postDelayed(new ahjv(this), 2000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahjs
 * JD-Core Version:    0.7.0.1
 */