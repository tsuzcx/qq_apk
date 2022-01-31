package android.support.v4.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

final class x
  extends AnimatorListenerAdapter
{
  View bo;
  
  x(View paramView)
  {
    this.bo = paramView;
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    this.bo.setLayerType(0, null);
    paramAnimator.removeListener(this);
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    this.bo.setLayerType(2, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.app.x
 * JD-Core Version:    0.7.0.1
 */