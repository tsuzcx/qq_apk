package com.tencent.mm.plugin.wallet_core.ui.cashier;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.sdk.platformtools.ab;

final class a$6
  implements View.OnClickListener
{
  a$6(a parama, Bankcard paramBankcard) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(47741);
    ab.d("MicroMsg.WcPayCashierBankcardDialog", "click bankcard: %s", new Object[] { this.tNr.field_bindSerial });
    a.a(this.uuG, paramView);
    this.uuG.dismiss();
    if (a.a(this.uuG) != null) {
      a.a(this.uuG).i(this.tNr);
    }
    AppMethodBeat.o(47741);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.cashier.a.6
 * JD-Core Version:    0.7.0.1
 */