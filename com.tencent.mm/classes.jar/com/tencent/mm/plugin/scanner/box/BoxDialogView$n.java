package com.tencent.mm.plugin.scanner.box;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
final class BoxDialogView$n
  implements Runnable
{
  BoxDialogView$n(View paramView) {}
  
  public final void run()
  {
    AppMethodBeat.i(189522);
    View localView = this.teP;
    if (localView != null)
    {
      localView.requestLayout();
      AppMethodBeat.o(189522);
      return;
    }
    AppMethodBeat.o(189522);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.box.BoxDialogView.n
 * JD-Core Version:    0.7.0.1
 */