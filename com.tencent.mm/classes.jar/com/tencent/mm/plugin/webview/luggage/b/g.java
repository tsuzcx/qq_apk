package com.tencent.mm.plugin.webview.luggage.b;

import android.app.Activity;
import android.content.Context;
import com.tencent.luggage.d.j;
import com.tencent.luggage.d.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.c.h;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.ui.base.s;

public final class g
  extends a
{
  public g()
  {
    super(27);
  }
  
  public final void a(Context paramContext, com.tencent.mm.plugin.webview.luggage.g paramg)
  {
    AppMethodBeat.i(78695);
    if ((!paramg.iue()) && (!paramg.eje.aow().aom())) {
      ((Activity)paramg.mContext).finish();
    }
    com.tencent.mm.plugin.report.service.h.OAn.kJ(982, 11);
    AppMethodBeat.o(78695);
  }
  
  public final void a(Context paramContext, com.tencent.mm.plugin.webview.luggage.g paramg, s params)
  {
    AppMethodBeat.i(78694);
    if (paramg.isFullScreen()) {
      params.a(27, paramContext.getString(c.i.readerapp_finish_webview), c.h.bottomsheet_icon_exit);
    }
    AppMethodBeat.o(78694);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.b.g
 * JD-Core Version:    0.7.0.1
 */