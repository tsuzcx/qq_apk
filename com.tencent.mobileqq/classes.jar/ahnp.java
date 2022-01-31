import com.tencent.mobileqq.richmedia.capture.fragment.EffectsCameraCaptureFragment;
import com.tencent.mobileqq.richmedia.capture.util.DanceGameReporter;
import com.tencent.mobileqq.shortvideo.dancegame.DanceGameVideoManager;

public class ahnp
  implements Runnable
{
  public ahnp(EffectsCameraCaptureFragment paramEffectsCameraCaptureFragment, long paramLong) {}
  
  public void run()
  {
    DanceGameVideoManager.a().a();
    DanceGameReporter.a().a(this.jdField_a_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahnp
 * JD-Core Version:    0.7.0.1
 */