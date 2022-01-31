package com.tencent.mm.plugin.wear.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import java.util.concurrent.atomic.AtomicInteger;

final class WearYoUI$a
  implements Animator.AnimatorListener
{
  private int ghE = 1;
  
  public WearYoUI$a(WearYoUI paramWearYoUI, int paramInt)
  {
    this.ghE = paramInt;
  }
  
  public final void onAnimationCancel(Animator paramAnimator)
  {
    WearYoUI.g(this.qTa);
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    if (this.ghE == 2)
    {
      y.v("MicroMsg.Wear.WearYoUI", "onAnimationEnd count: %d", new Object[] { Integer.valueOf(WearYoUI.e(this.qTa).get()) });
      if (WearYoUI.e(this.qTa).get() > 0)
      {
        WearYoUI.e(this.qTa).decrementAndGet();
        ai.l(WearYoUI.f(this.qTa), 1000L);
      }
    }
    while (this.ghE != 1)
    {
      return;
      WearYoUI.d(this.qTa).animate().setListener(null);
      WearYoUI.g(this.qTa);
      return;
    }
    WearYoUI.d(this.qTa).animate().scaleX(1.0F);
    WearYoUI.d(this.qTa).animate().scaleY(1.0F);
    WearYoUI.d(this.qTa).animate().setDuration(100L);
    WearYoUI.d(this.qTa).animate().start();
    WearYoUI.d(this.qTa).animate().setListener(new a(this.qTa, 2));
  }
  
  public final void onAnimationRepeat(Animator paramAnimator) {}
  
  public final void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.ui.WearYoUI.a
 * JD-Core Version:    0.7.0.1
 */