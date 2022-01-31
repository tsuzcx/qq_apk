package com.tencent.mm.plugin.webview.luggage.b;

import android.content.Context;
import com.tencent.luggage.d.k;
import com.tencent.luggage.d.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.luggage.e;
import com.tencent.mm.plugin.webview.luggage.jsapi.au;
import com.tencent.mm.plugin.webview.luggage.permission.c;
import com.tencent.mm.ui.base.l;

public final class j
  extends a
{
  public j()
  {
    super(1);
  }
  
  public final void a(Context paramContext, e parame)
  {
    AppMethodBeat.i(6443);
    au.JS(0);
    parame.dbb().agX("sendAppMessage");
    parame.bzs.a(new j.1(this));
    h.qsU.cT(982, 9);
    AppMethodBeat.o(6443);
  }
  
  public final void a(Context paramContext, e parame, l paraml)
  {
    AppMethodBeat.i(6442);
    if (parame.wZ(21)) {
      paraml.a(this.id, paramContext.getString(2131302282), 2131231038);
    }
    AppMethodBeat.o(6442);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.b.j
 * JD-Core Version:    0.7.0.1
 */