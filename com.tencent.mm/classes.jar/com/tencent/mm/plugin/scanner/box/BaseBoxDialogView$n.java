package com.tencent.mm.plugin.scanner.box;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
final class BaseBoxDialogView$n
  implements Runnable
{
  BaseBoxDialogView$n(View paramView) {}
  
  public final void run()
  {
    AppMethodBeat.i(240238);
    View localView = this.wlJ;
    if (localView != null)
    {
      localView.requestLayout();
      AppMethodBeat.o(240238);
      return;
    }
    AppMethodBeat.o(240238);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.box.BaseBoxDialogView.n
 * JD-Core Version:    0.7.0.1
 */