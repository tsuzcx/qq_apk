package com.tencent.mm.plugin.scanner;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

final class h$4
  implements Runnable
{
  h$4(h paramh) {}
  
  public final void run()
  {
    AppMethodBeat.i(169954);
    if (!g.afw())
    {
      AppMethodBeat.o(169954);
      return;
    }
    if (bt.isNullOrNil(h.d(this.vLT)))
    {
      ad.e("MicroMsg.scanner.SubCoreScanner", "accPath == null in onAccountPostReset");
      AppMethodBeat.o(169954);
      return;
    }
    bt.z(h.d(this.vLT) + "image/scan/img", "scanbook", 604800000L);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.h.4
 * JD-Core Version:    0.7.0.1
 */