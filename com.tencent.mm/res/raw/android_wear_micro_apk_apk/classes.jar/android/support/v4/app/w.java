package android.support.v4.app;

import android.animation.Animator;
import android.view.animation.Animation;

final class w
{
  public final Animation db;
  public final Animator dc;
  
  private w(Animator paramAnimator)
  {
    this.db = null;
    this.dc = paramAnimator;
    if (paramAnimator == null) {
      throw new IllegalStateException("Animator cannot be null");
    }
  }
  
  private w(Animation paramAnimation)
  {
    this.db = paramAnimation;
    this.dc = null;
    if (paramAnimation == null) {
      throw new IllegalStateException("Animation cannot be null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.app.w
 * JD-Core Version:    0.7.0.1
 */