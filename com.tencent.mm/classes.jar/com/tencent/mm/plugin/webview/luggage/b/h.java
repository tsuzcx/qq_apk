package com.tencent.mm.plugin.webview.luggage.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.luggage.t;
import com.tencent.mm.ui.base.m;

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
    paramContext = paramg.gbJ();
    if (paramContext != null)
    {
      paramContext.ic(true);
      com.tencent.mm.plugin.report.service.h.CyF.dN(982, 4);
    }
    AppMethodBeat.o(78697);
  }
  
  public final void a(Context paramContext, g paramg, m paramm)
  {
    AppMethodBeat.i(78696);
    t localt = paramg.gbJ();
    if ((paramg.gbH()) && (localt != null)) {
      paramm.b(35, paramContext.getString(2131764199), 2131690846);
    }
    AppMethodBeat.o(78696);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.b.h
 * JD-Core Version:    0.7.0.1
 */