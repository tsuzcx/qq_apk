package com.tencent.mm.plugin.scanner;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class e$4
  implements Runnable
{
  e$4(e parame) {}
  
  public final void run()
  {
    AppMethodBeat.i(138456);
    if (!g.RG())
    {
      AppMethodBeat.o(138456);
      return;
    }
    if (bo.isNullOrNil(e.d(this.qtF)))
    {
      ab.e("MicroMsg.scanner.SubCoreScanner", "accPath == null in onAccountPostReset");
      AppMethodBeat.o(138456);
      return;
    }
    bo.q(e.d(this.qtF) + "image/scan/img", "scanbook", 604800000L);
    AppMethodBeat.o(138456);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(138457);
    String str = super.toString() + "|onAccountPostReset";
    AppMethodBeat.o(138457);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.e.4
 * JD-Core Version:    0.7.0.1
 */