import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.richmedia.capture.fragment.EffectsCameraCaptureFragment;

class ahjr
  extends AnimatorListenerAdapter
{
  ahjr(ahjp paramahjp) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    EffectsCameraCaptureFragment.a(this.a.a).setVisibility(8);
    EffectsCameraCaptureFragment.j(this.a.a, false);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    EffectsCameraCaptureFragment.j(this.a.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahjr
 * JD-Core Version:    0.7.0.1
 */