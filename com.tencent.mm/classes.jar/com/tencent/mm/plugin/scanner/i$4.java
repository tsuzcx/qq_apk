package com.tencent.mm.plugin.scanner;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

final class i$4
  implements Runnable
{
  i$4(i parami) {}
  
  public final void run()
  {
    AppMethodBeat.i(169954);
    if (!g.ajx())
    {
      AppMethodBeat.o(169954);
      return;
    }
    if (bt.isNullOrNil(i.d(this.yjB)))
    {
      ad.e("MicroMsg.scanner.SubCoreScanner", "accPath == null in onAccountPostReset");
      AppMethodBeat.o(169954);
      return;
    }
    bt.n(i.d(this.yjB) + "image/scan/img", "scanbook", 604800000L);
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
 * Qualified Name:     com.tencent.mm.plugin.scanner.i.4
 * JD-Core Version:    0.7.0.1
 */