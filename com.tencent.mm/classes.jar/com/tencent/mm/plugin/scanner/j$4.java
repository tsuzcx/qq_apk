package com.tencent.mm.plugin.scanner;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

final class j$4
  implements Runnable
{
  j$4(j paramj) {}
  
  public final void run()
  {
    AppMethodBeat.i(169954);
    if (!g.aAc())
    {
      AppMethodBeat.o(169954);
      return;
    }
    if (Util.isNullOrNil(j.d(this.CAB)))
    {
      Log.e("MicroMsg.scanner.SubCoreScanner", "accPath == null in onAccountPostReset");
      AppMethodBeat.o(169954);
      return;
    }
    Util.deleteOutOfDateFile(j.d(this.CAB) + "image/scan/img", "scanbook", 604800000L);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.j.4
 * JD-Core Version:    0.7.0.1
 */