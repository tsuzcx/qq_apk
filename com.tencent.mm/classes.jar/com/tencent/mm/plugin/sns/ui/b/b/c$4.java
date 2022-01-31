package com.tencent.mm.plugin.sns.ui.b.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.item.a.a;
import com.tencent.mm.sdk.platformtools.ab;

final class c$4
  extends AnimatorListenerAdapter
{
  c$4(c paramc) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(40050);
    ab.i("MicroMsg.CardAdBackAnimation", "onAnimation end");
    ((ViewGroup)this.sfv.sfu.shV.getParent()).removeView(this.sfv.sfu.shV);
    ((ViewGroup)this.sfv.sfu.shW.getParent()).removeView(this.sfv.sfu.shW);
    ((ViewGroup)this.sfv.sfu.shX.getParent()).removeView(this.sfv.sfu.shX);
    this.sfv.sfu.sgS.addView(this.sfv.sfu.shV, this.sfv.seZ);
    this.sfv.sfu.shV.addView(this.sfv.sfu.shW, this.sfv.sfa);
    this.sfv.sfu.shV.addView(this.sfv.sfu.shX, this.sfv.sfb);
    this.sfv.sfu.shW.setScaleX(1.0F);
    this.sfv.sfu.shW.setScaleY(1.0F);
    this.sfv.sfu.shW.setAlpha(1.0F);
    this.sfv.sfu.shX.setAlpha(1.0F);
    if (this.sfv.seT != null) {
      this.sfv.seT.onAnimationEnd();
    }
    this.sfv.sfu.ezJ = false;
    AppMethodBeat.o(40050);
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    AppMethodBeat.i(40049);
    ab.i("MicroMsg.CardAdBackAnimation", "onAnimation start");
    AppMethodBeat.o(40049);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.b.c.4
 * JD-Core Version:    0.7.0.1
 */