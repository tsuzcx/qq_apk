package com.tencent.mm.ui.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
  implements com.tencent.mm.plugin.appbrand.service.h
{
  public final boolean ciC()
  {
    AppMethodBeat.i(281183);
    i locali = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe();
    if (locali == null)
    {
      Log.i("MicroMsg.AppBrandNotifyMsgService", "get info storage fail");
      AppMethodBeat.o(281183);
      return false;
    }
    int i = locali.RN("appbrand_notify_message");
    Log.i("MicroMsg.AppBrandNotifyMsgService", "conversation count: %d", new Object[] { Integer.valueOf(i) });
    if (i <= 1)
    {
      AppMethodBeat.o(281183);
      return false;
    }
    boolean bool = ((b)com.tencent.mm.kernel.h.ae(b.class)).a(b.a.vEF, false);
    Log.i("MicroMsg.AppBrandNotifyMsgService", "showNotifyMsgPreference, isABtestEnable: %b", new Object[] { Boolean.valueOf(bool) });
    if (!bool)
    {
      AppMethodBeat.o(281183);
      return false;
    }
    AppMethodBeat.o(281183);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.appbrand.c
 * JD-Core Version:    0.7.0.1
 */