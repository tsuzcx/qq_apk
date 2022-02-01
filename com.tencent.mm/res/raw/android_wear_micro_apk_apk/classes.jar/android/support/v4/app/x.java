package android.support.v4.app;

import android.animation.Animator;
import android.view.animation.Animation;

final class x
{
  public final Animation eL;
  public final Animator eM;
  
  private x(Animator paramAnimator)
  {
    this.eL = null;
    this.eM = paramAnimator;
    if (paramAnimator == null) {
      throw new IllegalStateException("Animator cannot be null");
    }
  }
  
  private x(Animation paramAnimation)
  {
    this.eL = paramAnimation;
    this.eM = null;
    if (paramAnimation == null) {
      throw new IllegalStateException("Animation cannot be null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.app.x
 * JD-Core Version:    0.7.0.1
 */