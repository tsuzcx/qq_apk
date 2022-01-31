import com.tencent.mobileqq.activity.richmedia.subtitles.SubtitleLayout;
import com.tencent.mobileqq.richmedia.capture.fragment.EffectsCameraCaptureFragment;

public class aguq
  implements Runnable
{
  public aguq(EffectsCameraCaptureFragment paramEffectsCameraCaptureFragment) {}
  
  public void run()
  {
    if ((EffectsCameraCaptureFragment.a(this.a) != null) && (EffectsCameraCaptureFragment.a(this.a).a()))
    {
      EffectsCameraCaptureFragment.a(this.a).e();
      EffectsCameraCaptureFragment.a(this.a).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aguq
 * JD-Core Version:    0.7.0.1
 */