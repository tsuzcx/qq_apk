package com.tencent.mm.plugin.webview.luggage.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.c.h;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.luggage.t;
import com.tencent.mm.ui.base.o;

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
    paramContext = paramg.gUE();
    if (paramContext != null)
    {
      paramContext.iW(true);
      com.tencent.mm.plugin.report.service.h.IzE.el(982, 4);
    }
    AppMethodBeat.o(78697);
  }
  
  public final void a(Context paramContext, g paramg, o paramo)
  {
    AppMethodBeat.i(78696);
    t localt = paramg.gUE();
    if ((paramg.gUC()) && (localt != null)) {
      paramo.b(35, paramContext.getString(c.i.readerapp_minimize), c.h.icons_outlined_multitask);
    }
    AppMethodBeat.o(78696);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.b.h
 * JD-Core Version:    0.7.0.1
 */