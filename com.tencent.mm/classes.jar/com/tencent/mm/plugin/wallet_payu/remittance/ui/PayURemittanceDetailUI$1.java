package com.tencent.mm.plugin.wallet_payu.remittance.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.order.c.a.a;
import com.tencent.mm.ui.base.h;

final class PayURemittanceDetailUI$1
  implements a.a
{
  PayURemittanceDetailUI$1(PayURemittanceDetailUI paramPayURemittanceDetailUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(48543);
    h.d(this.uDP, this.uDP.getString(2131302539), this.uDP.getString(2131297056), this.uDP.getString(2131302613), this.uDP.getString(2131296888), new PayURemittanceDetailUI.1.1(this), new PayURemittanceDetailUI.1.2(this));
    AppMethodBeat.o(48543);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.remittance.ui.PayURemittanceDetailUI.1
 * JD-Core Version:    0.7.0.1
 */