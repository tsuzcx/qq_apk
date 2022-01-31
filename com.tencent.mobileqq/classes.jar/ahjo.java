import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.richmedia.capture.fragment.EffectsCameraCaptureFragment;

public class ahjo
  extends AnimatorListenerAdapter
{
  public ahjo(EffectsCameraCaptureFragment paramEffectsCameraCaptureFragment) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    EffectsCameraCaptureFragment.a(this.a).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahjo
 * JD-Core Version:    0.7.0.1
 */