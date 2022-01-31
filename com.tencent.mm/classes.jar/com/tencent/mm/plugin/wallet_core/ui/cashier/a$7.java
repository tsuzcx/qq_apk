package com.tencent.mm.plugin.wallet_core.ui.cashier;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class a$7
  implements View.OnClickListener
{
  a$7(a parama) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(47742);
    ab.d("MicroMsg.WcPayCashierBankcardDialog", "click bind new card");
    this.uuG.dismiss();
    if (a.a(this.uuG) != null) {
      a.a(this.uuG).cQU();
    }
    AppMethodBeat.o(47742);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.cashier.a.7
 * JD-Core Version:    0.7.0.1
 */