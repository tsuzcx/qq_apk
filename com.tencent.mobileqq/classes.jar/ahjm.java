import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.richmedia.capture.fragment.EffectsCameraCaptureFragment;

public class ahjm
  extends AnimatorListenerAdapter
{
  public ahjm(EffectsCameraCaptureFragment paramEffectsCameraCaptureFragment) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    EffectsCameraCaptureFragment.a(this.a).setAlpha(1.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahjm
 * JD-Core Version:    0.7.0.1
 */