package android.support.wearable.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.annotation.TargetApi;

@TargetApi(20)
public class u
  implements Animator.AnimatorListener
{
  private boolean Fs;
  
  public final boolean fB()
  {
    return this.Fs;
  }
  
  public void fp() {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.Fs = true;
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (!this.Fs) {
      fp();
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.Fs = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.wearable.view.u
 * JD-Core Version:    0.7.0.1
 */