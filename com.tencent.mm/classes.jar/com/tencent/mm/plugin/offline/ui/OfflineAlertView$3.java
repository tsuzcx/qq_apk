package com.tencent.mm.plugin.offline.ui;

import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.q;
import com.tencent.mm.pluginsdk.ui.applet.u;
import com.tencent.mm.pluginsdk.ui.span.i;

final class OfflineAlertView$3
  implements i
{
  OfflineAlertView$3(OfflineAlertView paramOfflineAlertView, View.OnClickListener paramOnClickListener, q paramq) {}
  
  public final Object a(u paramu)
  {
    return null;
  }
  
  public final Object b(u paramu)
  {
    AppMethodBeat.i(213615);
    if ((paramu != null) && (paramu.url.trim().startsWith("weixin://wcpay/fqf/opentinyapp")))
    {
      this.AKz.onClick(null);
      h.CyF.a(18930, new Object[] { Integer.valueOf(this.AKA.HYq), Integer.valueOf(3) });
    }
    AppMethodBeat.o(213615);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.OfflineAlertView.3
 * JD-Core Version:    0.7.0.1
 */