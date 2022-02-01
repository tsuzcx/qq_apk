package com.tencent.mm.plugin.webview.luggage.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.c.h;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.luggage.u;
import com.tencent.mm.ui.base.s;

public final class h
  extends a
{
  public h()
  {
    super(35);
  }
  
  public final void a(Context paramContext, g paramg)
  {
    AppMethodBeat.i(78697);
    paramContext = paramg.iun();
    if (paramContext != null)
    {
      paramContext.ke(true);
      com.tencent.mm.plugin.report.service.h.OAn.kJ(982, 4);
    }
    AppMethodBeat.o(78697);
  }
  
  public final void a(Context paramContext, g paramg, s params)
  {
    AppMethodBeat.i(78696);
    u localu = paramg.iun();
    if ((paramg.iul()) && (localu != null)) {
      params.a(35, paramContext.getString(c.i.readerapp_minimize), c.h.icons_outlined_multitask);
    }
    AppMethodBeat.o(78696);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.b.h
 * JD-Core Version:    0.7.0.1
 */