package android.support.v4.app;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Transformation;

final class z
  extends AnimationSet
  implements Runnable
{
  private final ViewGroup eN;
  private final View eO;
  private boolean eP;
  private boolean eQ;
  
  z(Animation paramAnimation, ViewGroup paramViewGroup, View paramView)
  {
    super(false);
    this.eN = paramViewGroup;
    this.eO = paramView;
    addAnimation(paramAnimation);
  }
  
  public final boolean getTransformation(long paramLong, Transformation paramTransformation)
  {
    if (this.eP) {
      if (this.eQ) {}
    }
    while (super.getTransformation(paramLong, paramTransformation))
    {
      return true;
      return false;
    }
    this.eP = true;
    az.a(this.eN, this);
    return true;
  }
  
  public final boolean getTransformation(long paramLong, Transformation paramTransformation, float paramFloat)
  {
    if (this.eP) {
      if (this.eQ) {}
    }
    while (super.getTransformation(paramLong, paramTransformation, paramFloat))
    {
      return true;
      return false;
    }
    this.eP = true;
    az.a(this.eN, this);
    return true;
  }
  
  public final void run()
  {
    this.eN.endViewTransition(this.eO);
    this.eQ = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.app.z
 * JD-Core Version:    0.7.0.1
 */