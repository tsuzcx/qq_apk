package com.tencent.mm.plugin.wallet_core.ui.cashier;

import android.text.Layout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WcPayCashierDetailItemLayout$2
  implements Runnable
{
  WcPayCashierDetailItemLayout$2(WcPayCashierDetailItemLayout paramWcPayCashierDetailItemLayout) {}
  
  public final void run()
  {
    AppMethodBeat.i(142530);
    Layout localLayout = this.uuO.ldI.getLayout();
    if ((localLayout != null) && (localLayout.getLineCount() > 1)) {
      this.uuO.ldI.setMaxWidth((int)localLayout.getLineWidth(0));
    }
    AppMethodBeat.o(142530);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierDetailItemLayout.2
 * JD-Core Version:    0.7.0.1
 */