package android.support.v4.app;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class w
  implements Animation.AnimationListener
{
  private final Animation.AnimationListener eK;
  
  private w(Animation.AnimationListener paramAnimationListener)
  {
    this.eK = paramAnimationListener;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (this.eK != null) {
      this.eK.onAnimationEnd(paramAnimation);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation)
  {
    if (this.eK != null) {
      this.eK.onAnimationRepeat(paramAnimation);
    }
  }
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (this.eK != null) {
      this.eK.onAnimationStart(paramAnimation);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.app.w
 * JD-Core Version:    0.7.0.1
 */