package com.tencent.mm.plugin.transvoice.ui;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class b$o$a
  implements Runnable
{
  b$o$a(b.o paramo) {}
  
  public final void run()
  {
    AppMethodBeat.i(155842);
    TransVoicePanelLayout localTransVoicePanelLayout = b.m(this.tqL.tqJ);
    if (localTransVoicePanelLayout != null)
    {
      localTransVoicePanelLayout.requestLayout();
      AppMethodBeat.o(155842);
      return;
    }
    AppMethodBeat.o(155842);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.transvoice.ui.b.o.a
 * JD-Core Version:    0.7.0.1
 */