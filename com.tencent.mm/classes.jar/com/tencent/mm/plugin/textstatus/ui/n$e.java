package com.tencent.mm.plugin.textstatus.ui;

import android.view.ViewPropertyAnimator;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
final class n$e
  implements Runnable
{
  n$e(n paramn) {}
  
  public final void run()
  {
    AppMethodBeat.i(232381);
    this.MNm.gnt().setTranslationY(-this.MNm.gnt().getMeasuredHeight());
    this.MNm.gnt().setVisibility(0);
    ViewPropertyAnimator localViewPropertyAnimator = this.MNm.gnt().animate();
    if (localViewPropertyAnimator != null)
    {
      localViewPropertyAnimator = localViewPropertyAnimator.translationY(0.0F);
      if (localViewPropertyAnimator != null)
      {
        localViewPropertyAnimator.setDuration(200L);
        AppMethodBeat.o(232381);
        return;
      }
    }
    AppMethodBeat.o(232381);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.n.e
 * JD-Core Version:    0.7.0.1
 */