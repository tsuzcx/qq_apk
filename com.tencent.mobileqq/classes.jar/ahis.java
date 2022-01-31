import com.tencent.mobileqq.activity.richmedia.subtitles.SubtitleLayout;
import com.tencent.mobileqq.richmedia.capture.fragment.EffectsCameraCaptureFragment;

public class ahis
  implements Runnable
{
  public ahis(EffectsCameraCaptureFragment paramEffectsCameraCaptureFragment) {}
  
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
 * Qualified Name:     ahis
 * JD-Core Version:    0.7.0.1
 */