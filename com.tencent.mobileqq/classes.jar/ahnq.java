import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.richmedia.capture.fragment.EffectsCameraCaptureFragment;
import com.tencent.mobileqq.shortvideo.dancemachine.utils.DanceLog;

public class ahnq
  implements Runnable
{
  public ahnq(EffectsCameraCaptureFragment paramEffectsCameraCaptureFragment) {}
  
  public void run()
  {
    DanceLog.a("EffectsFragment", "playSceneEndEvent  begin exe...");
    EffectsCameraCaptureFragment.a(this.a).setVisibility(8);
    EffectsCameraCaptureFragment.a(this.a).setEnabled(false);
    EffectsCameraCaptureFragment.a(this.a, 0);
    EffectsCameraCaptureFragment.a(this.a, EffectsCameraCaptureFragment.a(this.a));
    EffectsCameraCaptureFragment.e(this.a).setVisibility(0);
    this.a.a.postDelayed(EffectsCameraCaptureFragment.a(this.a), 500L);
    DanceLog.a("EffectsFragment", "playSceneEndEvent  end exe...");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahnq
 * JD-Core Version:    0.7.0.1
 */