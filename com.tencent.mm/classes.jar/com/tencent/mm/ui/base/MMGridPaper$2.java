package com.tencent.mm.ui.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class MMGridPaper$2
  implements Runnable
{
  MMGridPaper$2(MMGridPaper paramMMGridPaper) {}
  
  public final void run()
  {
    AppMethodBeat.i(106617);
    ab.w("MicroMsg.MMGridPaper", "post do setDotView");
    MMGridPaper.a(this.zkb);
    AppMethodBeat.o(106617);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMGridPaper.2
 * JD-Core Version:    0.7.0.1
 */