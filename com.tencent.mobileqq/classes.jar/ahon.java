import com.tencent.mobileqq.richmedia.capture.data.CapturePtvTemplateManager;
import com.tencent.mobileqq.richmedia.capture.data.CaptureVideoFilterManager;
import com.tencent.mobileqq.richmedia.capture.fragment.EffectsCameraCaptureFragment;
import com.tencent.mobileqq.richmedia.capture.util.CaptureReportUtil;
import com.tencent.mobileqq.richmedia.capture.view.CaptureVideoFilterViewPager;
import com.tencent.mobileqq.richmedia.capture.view.ProviderContainerView;

public class ahon
  implements Runnable
{
  public ahon(EffectsCameraCaptureFragment paramEffectsCameraCaptureFragment) {}
  
  public void run()
  {
    this.a.d();
    CapturePtvTemplateManager.a().b(false);
    CaptureReportUtil.h();
    this.a.a.c();
    if ((this.a.e) && (CaptureVideoFilterManager.a(this.a.getActivity())))
    {
      CaptureVideoFilterManager.a().b();
      CaptureVideoFilterManager.a().a(new ahoo(this));
      EffectsCameraCaptureFragment.a(this.a).c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahon
 * JD-Core Version:    0.7.0.1
 */