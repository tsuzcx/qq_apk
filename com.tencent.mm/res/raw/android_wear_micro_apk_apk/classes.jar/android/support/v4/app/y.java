package android.support.v4.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

final class y
  extends AnimatorListenerAdapter
{
  View cZ;
  
  y(View paramView)
  {
    this.cZ = paramView;
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    this.cZ.setLayerType(0, null);
    paramAnimator.removeListener(this);
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    this.cZ.setLayerType(2, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.app.y
 * JD-Core Version:    0.7.0.1
 */