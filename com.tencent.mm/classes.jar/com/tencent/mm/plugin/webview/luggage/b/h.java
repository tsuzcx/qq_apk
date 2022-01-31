package com.tencent.mm.plugin.webview.luggage.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.e;
import com.tencent.mm.ui.base.l;

public final class h
  extends a
{
  public h()
  {
    super(28);
  }
  
  public final void a(Context paramContext, e parame)
  {
    AppMethodBeat.i(6439);
    parame.reload();
    com.tencent.mm.plugin.report.service.h.qsU.cT(982, 7);
    AppMethodBeat.o(6439);
  }
  
  public final void a(Context paramContext, e parame, l paraml)
  {
    AppMethodBeat.i(6438);
    paraml.a(28, paramContext.getString(2131305843), 2131231032);
    AppMethodBeat.o(6438);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.b.h
 * JD-Core Version:    0.7.0.1
 */