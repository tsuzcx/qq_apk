package com.tencent.mm.plugin.webview.luggage.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.e;
import com.tencent.mm.ui.base.l;

public final class f
  extends a
{
  public f()
  {
    super(35);
  }
  
  public final void a(Context paramContext, e parame)
  {
    AppMethodBeat.i(6434);
    paramContext = parame.dbd();
    if (paramContext != null)
    {
      if (!paramContext.dfg())
      {
        paramContext.ow(false);
        com.tencent.mm.plugin.report.service.h.qsU.cT(982, 4);
        AppMethodBeat.o(6434);
        return;
      }
      paramContext.ow(true);
      com.tencent.mm.plugin.report.service.h.qsU.cT(982, 5);
    }
    AppMethodBeat.o(6434);
  }
  
  public final void a(Context paramContext, e parame, l paraml)
  {
    AppMethodBeat.i(6433);
    com.tencent.mm.plugin.webview.ui.tools.bag.h localh = parame.dbd();
    if ((parame.dbc()) && (localh != null))
    {
      if (!localh.dfg())
      {
        paraml.a(35, paramContext.getString(2131302297), 2131231041);
        AppMethodBeat.o(6433);
        return;
      }
      paraml.a(35, paramContext.getString(2131302287), 2131231039);
    }
    AppMethodBeat.o(6433);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.b.f
 * JD-Core Version:    0.7.0.1
 */