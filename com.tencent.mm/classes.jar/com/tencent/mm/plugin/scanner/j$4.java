package com.tencent.mm.plugin.scanner;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

final class j$4
  implements Runnable
{
  j$4(j paramj) {}
  
  public final void run()
  {
    AppMethodBeat.i(169954);
    if (!g.ajM())
    {
      AppMethodBeat.o(169954);
      return;
    }
    if (bu.isNullOrNil(j.d(this.yzx)))
    {
      ae.e("MicroMsg.scanner.SubCoreScanner", "accPath == null in onAccountPostReset");
      AppMethodBeat.o(169954);
      return;
    }
    bu.n(j.d(this.yzx) + "image/scan/img", "scanbook", 604800000L);
    AppMethodBeat.o(169954);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(169955);
    String str = super.toString() + "|onAccountPostReset";
    AppMethodBeat.o(169955);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.j.4
 * JD-Core Version:    0.7.0.1
 */