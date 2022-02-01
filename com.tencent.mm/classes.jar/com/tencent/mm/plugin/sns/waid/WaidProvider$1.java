package com.tencent.mm.plugin.sns.waid;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

final class WaidProvider$1
  implements com.tencent.mm.kernel.api.g
{
  WaidProvider$1(WaidProvider paramWaidProvider) {}
  
  public final void Lk()
  {
    AppMethodBeat.i(162067);
    WaidProvider.a(this.xZG);
    ad.i("ad.waid.WaidProvider", "kernel, onStartupDone");
    try
    {
      com.tencent.mm.kernel.g.afC().b(this);
      AppMethodBeat.o(162067);
      return;
    }
    catch (Exception localException)
    {
      ad.e("ad.waid.WaidProvider", "removeKernelCallback, exp=" + localException.toString());
      AppMethodBeat.o(162067);
    }
  }
  
  public final void ce(boolean paramBoolean)
  {
    AppMethodBeat.i(162068);
    ad.i("ad.waid.WaidProvider", "kernel, onExit");
    AppMethodBeat.o(162068);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.waid.WaidProvider.1
 * JD-Core Version:    0.7.0.1
 */