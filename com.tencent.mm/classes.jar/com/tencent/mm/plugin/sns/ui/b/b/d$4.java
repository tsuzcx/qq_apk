package com.tencent.mm.plugin.sns.ui.b.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.item.a.a;
import com.tencent.mm.sdk.platformtools.ab;

final class d$4
  extends AnimatorListenerAdapter
{
  d$4(d paramd) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(40057);
    ab.i("MicroMsg.CardAdClickAnimation", "onAnimation end");
    ((ViewGroup)this.sfw.sfu.shV.getParent()).removeView(this.sfw.sfu.shV);
    ((ViewGroup)this.sfw.sfu.shW.getParent()).removeView(this.sfw.sfu.shW);
    ((ViewGroup)this.sfw.sfu.shX.getParent()).removeView(this.sfw.sfu.shX);
    this.sfw.sfu.sgS.addView(this.sfw.sfu.shV, this.sfw.seZ);
    this.sfw.sfu.shV.addView(this.sfw.sfu.shW, this.sfw.sfa);
    this.sfw.sfu.shV.addView(this.sfw.sfu.shX, this.sfw.sfb);
    this.sfw.sfu.shW.setScaleX(1.0F);
    this.sfw.sfu.shW.setScaleY(1.0F);
    this.sfw.sfu.shW.setAlpha(1.0F);
    this.sfw.sfu.shX.setAlpha(1.0F);
    if (this.sfw.seT != null) {
      this.sfw.seT.onAnimationEnd();
    }
    this.sfw.sfu.ezJ = false;
    AppMethodBeat.o(40057);
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    AppMethodBeat.i(40056);
    ab.i("MicroMsg.CardAdClickAnimation", "onAnimation start");
    AppMethodBeat.o(40056);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.b.d.4
 * JD-Core Version:    0.7.0.1
 */