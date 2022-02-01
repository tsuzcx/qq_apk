package com.tencent.mm.plugin.offline.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.q;

final class OfflineAlertView$4
  implements View.OnClickListener
{
  OfflineAlertView$4(OfflineAlertView paramOfflineAlertView, q paramq) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(174392);
    this.ukV.dismiss();
    h.vKh.f(18930, new Object[] { Integer.valueOf(this.ukX.AeN), Integer.valueOf(2) });
    AppMethodBeat.o(174392);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.OfflineAlertView.4
 * JD-Core Version:    0.7.0.1
 */