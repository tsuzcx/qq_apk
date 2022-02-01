package com.tencent.mm.ui.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.service.h;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
  implements h
{
  public final boolean bVr()
  {
    AppMethodBeat.i(232751);
    i locali = ((l)g.af(l.class)).eiy();
    if (locali == null)
    {
      Log.i("MicroMsg.AppBrandNotifyMsgService", "get info storage fail");
      AppMethodBeat.o(232751);
      return false;
    }
    int i = locali.Ku("appbrand_notify_message");
    Log.i("MicroMsg.AppBrandNotifyMsgService", "conversation count: %d", new Object[] { Integer.valueOf(i) });
    if (i <= 1)
    {
      AppMethodBeat.o(232751);
      return false;
    }
    boolean bool = ((b)g.af(b.class)).a(b.a.rXN, false);
    Log.i("MicroMsg.AppBrandNotifyMsgService", "showNotifyMsgPreference, isABtestEnable: %b", new Object[] { Boolean.valueOf(bool) });
    if (!bool)
    {
      AppMethodBeat.o(232751);
      return false;
    }
    AppMethodBeat.o(232751);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.appbrand.c
 * JD-Core Version:    0.7.0.1
 */