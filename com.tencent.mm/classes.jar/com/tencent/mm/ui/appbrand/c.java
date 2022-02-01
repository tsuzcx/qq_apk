package com.tencent.mm.ui.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
  implements com.tencent.mm.plugin.appbrand.service.i
{
  public final boolean bRX()
  {
    AppMethodBeat.i(249660);
    com.tencent.mm.plugin.messenger.foundation.a.a.i locali = ((n)h.ax(n.class)).gaZ();
    if (locali == null)
    {
      Log.i("MicroMsg.AppBrandNotifyMsgService", "get info storage fail");
      AppMethodBeat.o(249660);
      return false;
    }
    int i = locali.JL("appbrand_notify_message");
    Log.i("MicroMsg.AppBrandNotifyMsgService", "conversation count: %d", new Object[] { Integer.valueOf(i) });
    if (i <= 1)
    {
      AppMethodBeat.o(249660);
      return false;
    }
    boolean bool = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yTV, false);
    Log.i("MicroMsg.AppBrandNotifyMsgService", "showNotifyMsgPreference, isABtestEnable: %b", new Object[] { Boolean.valueOf(bool) });
    if (!bool)
    {
      AppMethodBeat.o(249660);
      return false;
    }
    AppMethodBeat.o(249660);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.appbrand.c
 * JD-Core Version:    0.7.0.1
 */