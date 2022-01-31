import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.tencent.mobileqq.richmedia.capture.fragment.EffectsCameraCaptureFragment;
import com.tencent.mobileqq.richmedia.capture.util.CaptureReportUtil;
import com.tencent.mobileqq.richmedia.capture.view.ProviderContainerView;
import com.tencent.mobileqq.shortvideo.util.RecentDanceConfigMgr.DItemInfo;

class ahjt
  implements View.OnTouchListener
{
  ahjt(ahjs paramahjs) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureFragmentEffectsCameraCaptureFragment.jdField_a_of_type_AndroidWidgetImageView == null) {}
    do
    {
      return false;
      if (paramMotionEvent.getAction() == 1)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureFragmentEffectsCameraCaptureFragment.jdField_a_of_type_AndroidWidgetImageView.setAlpha(255);
        this.a.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureFragmentEffectsCameraCaptureFragment.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderContainerView.a(102, this.a.jdField_a_of_type_ComTencentMobileqqShortvideoUtilRecentDanceConfigMgr$DItemInfo.categoryID, this.a.jdField_a_of_type_ComTencentMobileqqShortvideoUtilRecentDanceConfigMgr$DItemInfo.itemID);
        CaptureReportUtil.k();
        return false;
      }
    } while (paramMotionEvent.getAction() != 0);
    this.a.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureFragmentEffectsCameraCaptureFragment.jdField_a_of_type_AndroidWidgetImageView.setAlpha(100);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahjt
 * JD-Core Version:    0.7.0.1
 */