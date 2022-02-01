package com.tencent.mm.plugin.textstatus.ui;

import android.view.ViewPropertyAnimator;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
final class j$e
  implements Runnable
{
  j$e(j paramj) {}
  
  public final void run()
  {
    AppMethodBeat.i(216605);
    this.Gft.fwC().setTranslationY(-this.Gft.fwC().getMeasuredHeight());
    this.Gft.fwC().setVisibility(0);
    ViewPropertyAnimator localViewPropertyAnimator = this.Gft.fwC().animate();
    if (localViewPropertyAnimator != null)
    {
      localViewPropertyAnimator = localViewPropertyAnimator.translationY(0.0F);
      if (localViewPropertyAnimator != null)
      {
        localViewPropertyAnimator.setDuration(200L);
        AppMethodBeat.o(216605);
        return;
      }
    }
    AppMethodBeat.o(216605);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.j.e
 * JD-Core Version:    0.7.0.1
 */