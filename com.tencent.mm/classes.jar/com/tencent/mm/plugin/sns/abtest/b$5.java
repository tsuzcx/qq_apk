package com.tencent.mm.plugin.sns.abtest;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mm.sdk.platformtools.ai;

final class b$5
  implements Animation.AnimationListener
{
  b$5(b paramb) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    ai.d(new Runnable()
    {
      public final void run()
      {
        b.5.this.ojV.bBZ();
      }
    });
    this.ojV.ojT = false;
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation)
  {
    this.ojV.ojT = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.abtest.b.5
 * JD-Core Version:    0.7.0.1
 */