import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.richmedia.capture.fragment.EffectsCameraCaptureFragment;

public class ahjl
  extends AnimatorListenerAdapter
{
  public ahjl(EffectsCameraCaptureFragment paramEffectsCameraCaptureFragment) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    EffectsCameraCaptureFragment.a(this.a).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahjl
 * JD-Core Version:    0.7.0.1
 */