import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.richmedia.capture.fragment.AIOEffectsCameraCaptureFragment.MediaCodecEditCallback;
import com.tencent.mobileqq.richmedia.capture.fragment.QuickShootEffectsCameraCaptureFragment;

public class agwc
  extends AIOEffectsCameraCaptureFragment.MediaCodecEditCallback
{
  public agwc(QuickShootEffectsCameraCaptureFragment paramQuickShootEffectsCameraCaptureFragment, Activity paramActivity, Intent paramIntent) {}
  
  public void a()
  {
    this.jdField_a_of_type_AndroidAppActivity.setResult(-1, this.jdField_a_of_type_AndroidContentIntent);
    this.jdField_a_of_type_AndroidAppActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     agwc
 * JD-Core Version:    0.7.0.1
 */