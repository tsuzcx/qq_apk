package com.tencent.mm.ui.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.service.h;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.ad;

public final class c
  implements h
{
  public final boolean bye()
  {
    AppMethodBeat.i(193776);
    i locali = ((l)g.ab(l.class)).dlK();
    if (locali == null)
    {
      ad.i("MicroMsg.AppBrandNotifyMsgService", "get info storage fail");
      AppMethodBeat.o(193776);
      return false;
    }
    int i = locali.Bm("appbrand_notify_message");
    ad.i("MicroMsg.AppBrandNotifyMsgService", "conversation count: %d", new Object[] { Integer.valueOf(i) });
    if (i <= 1)
    {
      AppMethodBeat.o(193776);
      return false;
    }
    boolean bool = ((b)g.ab(b.class)).a(b.a.qxy, false);
    ad.i("MicroMsg.AppBrandNotifyMsgService", "showNotifyMsgPreference, isABtestEnable: %b", new Object[] { Boolean.valueOf(bool) });
    if (!bool)
    {
      AppMethodBeat.o(193776);
      return false;
    }
    AppMethodBeat.o(193776);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.appbrand.c
 * JD-Core Version:    0.7.0.1
 */