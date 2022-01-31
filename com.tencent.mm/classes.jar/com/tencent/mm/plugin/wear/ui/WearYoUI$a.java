package com.tencent.mm.plugin.wear.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import java.util.concurrent.atomic.AtomicInteger;

final class WearYoUI$a
  implements Animator.AnimatorListener
{
  private int hAu = 1;
  
  public WearYoUI$a(WearYoUI paramWearYoUI, int paramInt)
  {
    this.hAu = paramInt;
  }
  
  public final void onAnimationCancel(Animator paramAnimator)
  {
    AppMethodBeat.i(26470);
    WearYoUI.g(this.uIh);
    AppMethodBeat.o(26470);
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(26469);
    if (this.hAu == 2)
    {
      ab.v("MicroMsg.Wear.WearYoUI", "onAnimationEnd count: %d", new Object[] { Integer.valueOf(WearYoUI.e(this.uIh).get()) });
      if (WearYoUI.e(this.uIh).get() > 0)
      {
        WearYoUI.e(this.uIh).decrementAndGet();
        al.p(WearYoUI.f(this.uIh), 1000L);
        AppMethodBeat.o(26469);
        return;
      }
      WearYoUI.d(this.uIh).animate().setListener(null);
      WearYoUI.g(this.uIh);
      AppMethodBeat.o(26469);
      return;
    }
    if (this.hAu == 1)
    {
      WearYoUI.d(this.uIh).animate().scaleX(1.0F);
      WearYoUI.d(this.uIh).animate().scaleY(1.0F);
      WearYoUI.d(this.uIh).animate().setDuration(100L);
      WearYoUI.d(this.uIh).animate().start();
      WearYoUI.d(this.uIh).animate().setListener(new a(this.uIh, 2));
    }
    AppMethodBeat.o(26469);
  }
  
  public final void onAnimationRepeat(Animator paramAnimator) {}
  
  public final void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.ui.WearYoUI.a
 * JD-Core Version:    0.7.0.1
 */