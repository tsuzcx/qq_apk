package com.tencent.mm.plugin.webview.luggage.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.f;
import com.tencent.mm.plugin.webview.luggage.p;
import com.tencent.mm.ui.base.l;

public final class h
  extends a
{
  public h()
  {
    super(35);
  }
  
  public final void a(Context paramContext, f paramf)
  {
    AppMethodBeat.i(78697);
    paramContext = paramf.ekZ();
    if (paramContext != null)
    {
      if (!paramContext.bzs())
      {
        paramContext.fE(true);
        com.tencent.mm.plugin.report.service.h.vKh.dB(982, 4);
        AppMethodBeat.o(78697);
        return;
      }
      paramContext.fE(false);
      com.tencent.mm.plugin.report.service.h.vKh.dB(982, 5);
    }
    AppMethodBeat.o(78697);
  }
  
  public final void a(Context paramContext, f paramf, l paraml)
  {
    AppMethodBeat.i(78696);
    p localp = paramf.ekZ();
    if ((paramf.ekY()) && (localp != null))
    {
      if (!localp.bzs())
      {
        paraml.a(35, paramContext.getString(2131762178), 2131690574);
        AppMethodBeat.o(78696);
        return;
      }
      paraml.a(35, paramContext.getString(2131762168), 2131690573);
    }
    AppMethodBeat.o(78696);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.b.h
 * JD-Core Version:    0.7.0.1
 */