package com.tencent.mm.plugin.textstatus.ui;

import android.animation.TimeInterpolator;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
final class i$c
  implements Runnable
{
  i$c(LinearLayout paramLinearLayout) {}
  
  public final void run()
  {
    AppMethodBeat.i(233747);
    this.MKM.setPivotX(this.MKM.getWidth() / 2.0F);
    this.MKM.setPivotY(0.0F);
    ViewPropertyAnimator localViewPropertyAnimator = this.MKM.animate().scaleX(1.0F).scaleY(1.0F).alpha(1.0F).setInterpolator((TimeInterpolator)new DecelerateInterpolator(1.5F));
    p.j(localViewPropertyAnimator, "it.animate().scaleX(1f).…lerateInterpolator(1.5f))");
    localViewPropertyAnimator.setDuration(200L);
    AppMethodBeat.o(233747);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.i.c
 * JD-Core Version:    0.7.0.1
 */