import android.widget.ImageView;
import com.tencent.mobileqq.richmedia.capture.fragment.EffectsCameraCaptureFragment;
import com.tencent.mobileqq.richmedia.capture.gesture.GLGestureProxy;
import com.tencent.mobileqq.shortvideo.dancemachine.utils.DanceLog;

public class ahno
  implements Runnable
{
  public ahno(EffectsCameraCaptureFragment paramEffectsCameraCaptureFragment) {}
  
  public void run()
  {
    DanceLog.a("EffectsFragment", "readySceneBegin begin exe...");
    this.a.a = false;
    this.a.g();
    EffectsCameraCaptureFragment.g(this.a, true);
    EffectsCameraCaptureFragment.a(this.a).setVisibility(0);
    EffectsCameraCaptureFragment.a(this.a).setEnabled(true);
    DanceLog.a("EffectsFragment", "readySceneBegin end exe...");
    boolean bool = GLGestureProxy.a().a(EffectsCameraCaptureFragment.a(this.a));
    DanceLog.a("EffectsFragment", "readySceneBegin end hasDanceListener=" + bool);
    if (!bool) {
      GLGestureProxy.a().a(EffectsCameraCaptureFragment.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahno
 * JD-Core Version:    0.7.0.1
 */