package com.tencent.mm.ui.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class b$2
  implements Runnable
{
  b$2(b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(107852);
    if (this.ACl.ACk != null)
    {
      ab.w("MicroMsg.InputPanelHelper", "onKeyboardHideOnce not run in measure");
      this.ACl.ACk.run();
      this.ACl.ACk = null;
    }
    AppMethodBeat.o(107852);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.widget.b.2
 * JD-Core Version:    0.7.0.1
 */