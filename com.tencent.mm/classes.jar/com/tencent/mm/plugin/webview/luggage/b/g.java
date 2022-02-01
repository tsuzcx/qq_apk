package com.tencent.mm.plugin.webview.luggage.b;

import android.app.Activity;
import android.content.Context;
import com.tencent.luggage.d.j;
import com.tencent.luggage.d.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.m;

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
    if ((!paramg.gbB()) && (!paramg.ctg.Ly().Lo())) {
      ((Activity)paramg.mContext).finish();
    }
    com.tencent.mm.plugin.report.service.h.CyF.dN(982, 11);
    AppMethodBeat.o(78695);
  }
  
  public final void a(Context paramContext, com.tencent.mm.plugin.webview.luggage.g paramg, m paramm)
  {
    AppMethodBeat.i(78694);
    if (paramg.isFullScreen()) {
      paramm.b(27, paramContext.getString(2131764193), 2131689819);
    }
    AppMethodBeat.o(78694);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.b.g
 * JD-Core Version:    0.7.0.1
 */