package com.tencent.mm.plugin.offline.ui;

import android.content.Context;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.wallet_core.c.c.a;

final class OfflineAlertView$3
  implements c.a
{
  OfflineAlertView$3(OfflineAlertView paramOfflineAlertView, Button paramButton) {}
  
  public final void onFinish()
  {
    AppMethodBeat.i(174391);
    this.ukY.setText(2131755792);
    this.ukY.setEnabled(true);
    OfflineAlertView.c(this.ukV);
    AppMethodBeat.o(174391);
  }
  
  public final void onTick(long paramLong)
  {
    AppMethodBeat.i(174390);
    int i = (int)Math.round(paramLong / 1000.0D);
    if (i == 0)
    {
      this.ukY.setText(2131755792);
      AppMethodBeat.o(174390);
      return;
    }
    this.ukY.setText(String.format("%s(%ss)", new Object[] { aj.getContext().getString(2131755792), Integer.valueOf(i) }));
    AppMethodBeat.o(174390);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.OfflineAlertView.3
 * JD-Core Version:    0.7.0.1
 */