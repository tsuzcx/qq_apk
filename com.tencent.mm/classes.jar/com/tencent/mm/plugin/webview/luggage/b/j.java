package com.tencent.mm.plugin.webview.luggage.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.l;

public final class j
  extends a
{
  public j()
  {
    super(28);
  }
  
  public final void a(Context paramContext, com.tencent.mm.plugin.webview.luggage.g paramg)
  {
    AppMethodBeat.i(78702);
    paramg.reload();
    com.tencent.mm.plugin.report.service.g.yhR.dD(982, 7);
    AppMethodBeat.o(78702);
  }
  
  public final void a(Context paramContext, com.tencent.mm.plugin.webview.luggage.g paramg, l paraml)
  {
    AppMethodBeat.i(78701);
    paraml.a(28, paramContext.getString(2131766077), 2131689825);
    AppMethodBeat.o(78701);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.b.j
 * JD-Core Version:    0.7.0.1
 */