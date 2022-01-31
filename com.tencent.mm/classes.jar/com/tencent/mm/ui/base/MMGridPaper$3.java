package com.tencent.mm.ui.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class MMGridPaper$3
  implements Runnable
{
  MMGridPaper$3(MMGridPaper paramMMGridPaper) {}
  
  public final void run()
  {
    AppMethodBeat.i(106618);
    ab.w("MicroMsg.MMGridPaper", "post do setDotView");
    MMGridPaper.a(this.zkb);
    AppMethodBeat.o(106618);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMGridPaper.3
 * JD-Core Version:    0.7.0.1
 */