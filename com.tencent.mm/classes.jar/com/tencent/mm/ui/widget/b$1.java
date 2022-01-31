package com.tencent.mm.ui.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class b$1
  implements Runnable
{
  b$1(b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(107851);
    if (this.ACl.ACj != null)
    {
      ab.w("MicroMsg.InputPanelHelper", "onKeyboardShowOnce not run in measure");
      this.ACl.ACj.run();
      this.ACl.ACj = null;
    }
    AppMethodBeat.o(107851);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.widget.b.1
 * JD-Core Version:    0.7.0.1
 */