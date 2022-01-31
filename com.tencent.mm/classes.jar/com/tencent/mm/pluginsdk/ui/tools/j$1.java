package com.tencent.mm.pluginsdk.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class j$1
  implements Runnable
{
  j$1(j.a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(68484);
    try
    {
      j.b(this.wfv);
      AppMethodBeat.o(68484);
      return;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.QQMailUnreadHelper", localException, "", new Object[0]);
      ab.e("MicroMsg.QQMailUnreadHelper", "getUnreadCountAsync exception");
      AppMethodBeat.o(68484);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.j.1
 * JD-Core Version:    0.7.0.1
 */