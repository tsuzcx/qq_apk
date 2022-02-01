package com.tencent.mm.plugin.offline.ui;

import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.q;
import com.tencent.mm.pluginsdk.ui.applet.u;

final class OfflineAlertView$2
  implements com.tencent.mm.pluginsdk.ui.span.h
{
  OfflineAlertView$2(OfflineAlertView paramOfflineAlertView, View.OnClickListener paramOnClickListener, q paramq) {}
  
  public final Object a(u paramu)
  {
    return null;
  }
  
  public final Object b(u paramu)
  {
    AppMethodBeat.i(174389);
    if ((paramu != null) && (paramu.url.trim().startsWith("weixin://wcpay/fqf/opentinyapp")))
    {
      this.ukW.onClick(null);
      com.tencent.mm.plugin.report.service.h.vKh.f(18930, new Object[] { Integer.valueOf(this.ukX.AeN), Integer.valueOf(3) });
    }
    AppMethodBeat.o(174389);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.OfflineAlertView.2
 * JD-Core Version:    0.7.0.1
 */