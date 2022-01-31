package com.tencent.mm.plugin.wallet_core.ui.cashier;

import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;

final class WcPayCashierDetailItemLayout$1
  implements Runnable
{
  WcPayCashierDetailItemLayout$1(WcPayCashierDetailItemLayout paramWcPayCashierDetailItemLayout) {}
  
  public final void run()
  {
    AppMethodBeat.i(142529);
    int j = this.uuO.qkT.getWidth();
    int i = j;
    if (this.uuO.uuM.getVisibility() != 8) {
      i = j + WcPayCashierDetailItemLayout.access$000();
    }
    j = i;
    if (this.uuO.uuN.getVisibility() != 8) {
      j = i + WcPayCashierDetailItemLayout.access$100();
    }
    i = WcPayCashierDetailItemLayout.access$200();
    this.uuO.ldI.setMaxWidth(i - j);
    AppMethodBeat.o(142529);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierDetailItemLayout.1
 * JD-Core Version:    0.7.0.1
 */