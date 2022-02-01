package com.tencent.mm.plugin.secinforeport;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.secinforeport.a.d;
import com.tencent.mm.sdk.platformtools.ac;

final class PluginSecInfoReport$12
  implements Runnable
{
  PluginSecInfoReport$12(PluginSecInfoReport paramPluginSecInfoReport, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(89154);
    ac.i("MicroMsg.PSIR", "[+] report finder task start running.");
    try
    {
      d.xnP.Nv(this.xnH);
      AppMethodBeat.o(89154);
      return;
    }
    catch (Throwable localThrowable)
    {
      ac.printErrStackTrace("MicroMsg.PSIR", localThrowable, "[finder] unexpected exception was thrown.", new Object[0]);
      AppMethodBeat.o(89154);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.secinforeport.PluginSecInfoReport.12
 * JD-Core Version:    0.7.0.1
 */