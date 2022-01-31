package com.tencent.mm.plugin.webview.luggage.b;

import android.content.Context;
import com.tencent.luggage.d.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.luggage.e;
import com.tencent.mm.plugin.webview.luggage.permission.c;
import com.tencent.mm.ui.base.l;

public final class k
  extends a
{
  public k()
  {
    super(2);
  }
  
  public final void a(Context paramContext, e parame)
  {
    AppMethodBeat.i(6445);
    parame.dbb().agX("shareTimeline");
    parame.bzs.a(new k.1(this));
    h.qsU.cT(982, 10);
    AppMethodBeat.o(6445);
  }
  
  public final void a(Context paramContext, e parame, l paraml)
  {
    AppMethodBeat.i(6444);
    if (parame.wZ(23)) {
      paraml.a(2, paramContext.getString(2131302283), 2131231024);
    }
    AppMethodBeat.o(6444);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.b.k
 * JD-Core Version:    0.7.0.1
 */