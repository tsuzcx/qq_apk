import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mobileqq.richmedia.capture.fragment.EffectsCameraCaptureFragment;
import com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView;

public class agve
  implements Runnable
{
  public agve(EffectsCameraCaptureFragment paramEffectsCameraCaptureFragment) {}
  
  public void run()
  {
    EffectsCameraCaptureFragment.h(this.a, false);
    if (EffectsCameraCaptureFragment.a(this.a) == null) {
      return;
    }
    EffectsCameraCaptureFragment.a(this.a).removeView(EffectsCameraCaptureFragment.a(this.a));
    EffectsCameraCaptureFragment.a(this.a).setVisibility(0);
    EffectsCameraCaptureFragment.a(this.a).setEnabled(true);
    this.a.a.a(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     agve
 * JD-Core Version:    0.7.0.1
 */