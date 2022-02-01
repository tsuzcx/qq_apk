package com.tencent.mm.plugin.webview.luggage.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.ui.base.m;

public final class j
  extends a
{
  public j()
  {
    super(28);
  }
  
  public final void a(Context paramContext, g paramg)
  {
    AppMethodBeat.i(78702);
    paramg.reload();
    h.CyF.dN(982, 7);
    AppMethodBeat.o(78702);
  }
  
  public final void a(Context paramContext, g paramg, m paramm)
  {
    AppMethodBeat.i(78701);
    paramm.b(28, paramContext.getString(2131768534), 2131689838);
    AppMethodBeat.o(78701);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.b.j
 * JD-Core Version:    0.7.0.1
 */