package com.tencent.mm.plugin.wallet_payu.remittance.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.order.c.a.a;
import com.tencent.mm.ui.base.h;

final class PayURemittanceDetailUI$3
  implements a.a
{
  PayURemittanceDetailUI$3(PayURemittanceDetailUI paramPayURemittanceDetailUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(48546);
    h.d(this.uDP, this.uDP.getString(2131302555, new Object[] { PayURemittanceDetailUI.afV(PayURemittanceDetailUI.e(this.uDP)) }), this.uDP.getString(2131297056), this.uDP.getString(2131302560), this.uDP.getString(2131296888), new PayURemittanceDetailUI.3.1(this), new PayURemittanceDetailUI.3.2(this));
    AppMethodBeat.o(48546);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.remittance.ui.PayURemittanceDetailUI.3
 * JD-Core Version:    0.7.0.1
 */