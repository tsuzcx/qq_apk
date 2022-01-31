import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.richmedia.capture.fragment.EffectsCameraCaptureFragment;

class agvp
  extends AnimatorListenerAdapter
{
  agvp(agvn paramagvn) {}
  
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
 * Qualified Name:     agvp
 * JD-Core Version:    0.7.0.1
 */