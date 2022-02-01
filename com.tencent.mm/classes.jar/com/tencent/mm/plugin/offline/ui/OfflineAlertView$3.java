package com.tencent.mm.plugin.offline.ui;

import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet_core.model.q;
import com.tencent.mm.pluginsdk.ui.applet.u;
import com.tencent.mm.pluginsdk.ui.span.h;

final class OfflineAlertView$3
  implements h
{
  OfflineAlertView$3(OfflineAlertView paramOfflineAlertView, View.OnClickListener paramOnClickListener, q paramq) {}
  
  public final Object a(u paramu)
  {
    return null;
  }
  
  public final Object b(u paramu)
  {
    AppMethodBeat.i(189933);
    if ((paramu != null) && (paramu.url.trim().startsWith("weixin://wcpay/fqf/opentinyapp")))
    {
      this.wOT.onClick(null);
      g.yxI.f(18930, new Object[] { Integer.valueOf(this.wOU.Dpc), Integer.valueOf(3) });
    }
    AppMethodBeat.o(189933);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.OfflineAlertView.3
 * JD-Core Version:    0.7.0.1
 */