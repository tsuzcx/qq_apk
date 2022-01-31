package com.tencent.mm.plugin.webview.luggage;

import com.tencent.luggage.d.k;
import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class n$1
  implements Runnable
{
  n$1(k paramk) {}
  
  public final void run()
  {
    AppMethodBeat.i(6215);
    try
    {
      this.njp.destroy();
      AppMethodBeat.o(6215);
      return;
    }
    catch (Exception localException)
    {
      d.printErrStackTrace("MicroMsg.LuggageWebCoreStash", localException, "", new Object[0]);
      AppMethodBeat.o(6215);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.n.1
 * JD-Core Version:    0.7.0.1
 */