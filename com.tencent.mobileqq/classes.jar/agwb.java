import android.os.Handler;
import com.tencent.mobileqq.richmedia.capture.fragment.EffectsCameraCaptureFragment;

public class agwb
  implements Runnable
{
  private agwb(EffectsCameraCaptureFragment paramEffectsCameraCaptureFragment) {}
  
  public void run()
  {
    EffectsCameraCaptureFragment.b(this.a);
    if (EffectsCameraCaptureFragment.a(this.a) >= 3) {
      EffectsCameraCaptureFragment.a(this.a, 0);
    }
    EffectsCameraCaptureFragment.a(this.a, EffectsCameraCaptureFragment.a(this.a));
    this.a.a.postDelayed(EffectsCameraCaptureFragment.a(this.a), 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     agwb
 * JD-Core Version:    0.7.0.1
 */