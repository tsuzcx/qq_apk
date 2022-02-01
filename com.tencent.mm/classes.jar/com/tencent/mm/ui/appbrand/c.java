package com.tencent.mm.ui.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.service.h;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.ae;

public final class c
  implements h
{
  public final boolean byX()
  {
    AppMethodBeat.i(187067);
    i locali = ((l)g.ab(l.class)).doJ();
    if (locali == null)
    {
      ae.i("MicroMsg.AppBrandNotifyMsgService", "get info storage fail");
      AppMethodBeat.o(187067);
      return false;
    }
    int i = locali.BO("appbrand_notify_message");
    ae.i("MicroMsg.AppBrandNotifyMsgService", "conversation count: %d", new Object[] { Integer.valueOf(i) });
    if (i <= 1)
    {
      AppMethodBeat.o(187067);
      return false;
    }
    boolean bool = ((b)g.ab(b.class)).a(b.a.qEE, false);
    ae.i("MicroMsg.AppBrandNotifyMsgService", "showNotifyMsgPreference, isABtestEnable: %b", new Object[] { Boolean.valueOf(bool) });
    if (!bool)
    {
      AppMethodBeat.o(187067);
      return false;
    }
    AppMethodBeat.o(187067);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.appbrand.c
 * JD-Core Version:    0.7.0.1
 */