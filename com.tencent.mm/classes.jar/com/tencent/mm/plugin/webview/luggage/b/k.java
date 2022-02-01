package com.tencent.mm.plugin.webview.luggage.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.c.h;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.ui.base.o;

public final class k
  extends a
{
  public k()
  {
    super(31);
  }
  
  public final void a(Context paramContext, g paramg)
  {
    AppMethodBeat.i(78704);
    paramg.CX(true);
    h.IzE.el(982, 8);
    AppMethodBeat.o(78704);
  }
  
  public final void a(Context paramContext, g paramg, o paramo)
  {
    AppMethodBeat.i(78703);
    paramo.b(31, paramContext.getString(c.i.wv_search_content), c.h.bottomsheet_icon_search);
    AppMethodBeat.o(78703);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.b.k
 * JD-Core Version:    0.7.0.1
 */