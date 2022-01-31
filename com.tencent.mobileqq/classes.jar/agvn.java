import android.animation.ObjectAnimator;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.richmedia.capture.data.CapturePtvTemplateManager;
import com.tencent.mobileqq.richmedia.capture.fragment.EffectsCameraCaptureFragment;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;

public class agvn
  implements Runnable
{
  public agvn(EffectsCameraCaptureFragment paramEffectsCameraCaptureFragment) {}
  
  public void run()
  {
    PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = CapturePtvTemplateManager.a().a();
    if (((this.a.a == null) && (localPtvTemplateInfo == null)) || ((this.a.a != null) && (localPtvTemplateInfo != null) && (this.a.a.md5.equals(localPtvTemplateInfo.md5)))) {}
    do
    {
      do
      {
        return;
        this.a.a = localPtvTemplateInfo;
      } while (!this.a.b);
      if ((localPtvTemplateInfo != null) && (localPtvTemplateInfo.isAdvertise) && (!TextUtils.isEmpty(localPtvTemplateInfo.advertiseStr)) && (!TextUtils.isEmpty(localPtvTemplateInfo.advertiseIconUrl)) && (!TextUtils.isEmpty(localPtvTemplateInfo.advertiseWebUrl)))
      {
        EffectsCameraCaptureFragment.d(this.a);
        EffectsCameraCaptureFragment.a(this.a).addListener(new agvo(this, localPtvTemplateInfo));
        EffectsCameraCaptureFragment.a(this.a).setDuration(200L).start();
        EffectsCameraCaptureFragment.i(this.a, true);
        return;
      }
      EffectsCameraCaptureFragment.i(this.a, false);
    } while (EffectsCameraCaptureFragment.a(this.a).getVisibility() != 0);
    EffectsCameraCaptureFragment.d(this.a);
    EffectsCameraCaptureFragment.b(this.a).addListener(new agvp(this));
    EffectsCameraCaptureFragment.b(this.a).setDuration(200L).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     agvn
 * JD-Core Version:    0.7.0.1
 */