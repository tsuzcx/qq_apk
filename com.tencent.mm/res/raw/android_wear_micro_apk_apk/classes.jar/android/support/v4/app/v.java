package android.support.v4.app;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class v
  implements Animation.AnimationListener
{
  private final Animation.AnimationListener da;
  
  private v(Animation.AnimationListener paramAnimationListener)
  {
    this.da = paramAnimationListener;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (this.da != null) {
      this.da.onAnimationEnd(paramAnimation);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation)
  {
    if (this.da != null) {
      this.da.onAnimationRepeat(paramAnimation);
    }
  }
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (this.da != null) {
      this.da.onAnimationStart(paramAnimation);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.app.v
 * JD-Core Version:    0.7.0.1
 */