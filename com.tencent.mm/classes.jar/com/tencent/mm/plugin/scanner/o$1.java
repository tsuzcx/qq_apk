package com.tencent.mm.plugin.scanner;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

final class o$1
  implements Runnable
{
  o$1(o paramo) {}
  
  public final void run()
  {
    AppMethodBeat.i(51560);
    if (!h.aHB())
    {
      AppMethodBeat.o(51560);
      return;
    }
    if (Util.isNullOrNil(o.a(this.IGj)))
    {
      Log.e("MicroMsg.scanner.SubCoreScanner", "accPath == null in onAccountPostReset");
      AppMethodBeat.o(51560);
      return;
    }
    Util.deleteOutOfDateFile(o.a(this.IGj) + "image/scan/img", "scanbook", 604800000L);
    AppMethodBeat.o(51560);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(51561);
    String str = super.toString() + "|onAccountPostReset";
    AppMethodBeat.o(51561);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.o.1
 * JD-Core Version:    0.7.0.1
 */