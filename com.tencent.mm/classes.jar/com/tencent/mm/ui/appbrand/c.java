package com.tencent.mm.ui.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.b;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.platformtools.ad;

public final class c
  implements com.tencent.mm.plugin.appbrand.service.h
{
  public final boolean bnd()
  {
    AppMethodBeat.i(191425);
    com.tencent.mm.plugin.messenger.foundation.a.a.h localh = ((k)g.ab(k.class)).cOI();
    if (localh == null)
    {
      ad.i("MicroMsg.AppBrandNotifyMsgService", "get info storage fail");
      AppMethodBeat.o(191425);
      return false;
    }
    int i = localh.uh("appbrand_notify_message");
    ad.i("MicroMsg.AppBrandNotifyMsgService", "conversation count: %d", new Object[] { Integer.valueOf(i) });
    if (i <= 1)
    {
      AppMethodBeat.o(191425);
      return false;
    }
    boolean bool = ((b)g.ab(b.class)).a(b.a.ppj, false);
    ad.i("MicroMsg.AppBrandNotifyMsgService", "showNotifyMsgPreference, isABtestEnable: %b", new Object[] { Boolean.valueOf(bool) });
    if (!bool)
    {
      AppMethodBeat.o(191425);
      return false;
    }
    AppMethodBeat.o(191425);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.appbrand.c
 * JD-Core Version:    0.7.0.1
 */