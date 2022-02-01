package com.tencent.mm.plugin.offline.ui;

import android.content.Context;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.wallet_core.c.c.a;

final class OfflineAlertView$7
  implements c.a
{
  OfflineAlertView$7(OfflineAlertView paramOfflineAlertView, Button paramButton) {}
  
  public final void onFinish()
  {
    AppMethodBeat.i(273723);
    this.GDM.setText(a.i.app_i_know);
    this.GDM.setEnabled(true);
    OfflineAlertView.c(this.GDE);
    AppMethodBeat.o(273723);
  }
  
  public final void onTick(long paramLong)
  {
    AppMethodBeat.i(273722);
    int i = (int)Math.round(paramLong / 1000.0D);
    if (i == 0)
    {
      this.GDM.setText(a.i.app_i_know);
      AppMethodBeat.o(273722);
      return;
    }
    this.GDM.setText(String.format("%s(%ss)", new Object[] { MMApplicationContext.getContext().getString(a.i.app_i_know), Integer.valueOf(i) }));
    AppMethodBeat.o(273722);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.OfflineAlertView.7
 * JD-Core Version:    0.7.0.1
 */