package com.tencent.mm.plugin.offline.ui;

import android.content.Context;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.wallet_core.c.c.a;

final class OfflineAlertView$4
  implements c.a
{
  OfflineAlertView$4(OfflineAlertView paramOfflineAlertView, Button paramButton) {}
  
  public final void onFinish()
  {
    AppMethodBeat.i(189935);
    this.wOV.setText(2131755792);
    this.wOV.setEnabled(true);
    OfflineAlertView.c(this.wOR);
    AppMethodBeat.o(189935);
  }
  
  public final void onTick(long paramLong)
  {
    AppMethodBeat.i(189934);
    int i = (int)Math.round(paramLong / 1000.0D);
    if (i == 0)
    {
      this.wOV.setText(2131755792);
      AppMethodBeat.o(189934);
      return;
    }
    this.wOV.setText(String.format("%s(%ss)", new Object[] { ak.getContext().getString(2131755792), Integer.valueOf(i) }));
    AppMethodBeat.o(189934);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.OfflineAlertView.4
 * JD-Core Version:    0.7.0.1
 */