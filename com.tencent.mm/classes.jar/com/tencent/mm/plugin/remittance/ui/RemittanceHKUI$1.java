package com.tencent.mm.plugin.remittance.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.wallet_core.ui.e;

final class RemittanceHKUI$1
  implements View.OnClickListener
{
  RemittanceHKUI$1(RemittanceHKUI paramRemittanceHKUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(68202);
    ad.i("MicroMsg.RemittanceHKUI", "hy: on click banner");
    if (!bt.isNullOrNil(RemittanceHKUI.a(this.vIa))) {
      e.aS(this.vIa.getContext(), RemittanceHKUI.a(this.vIa));
    }
    AppMethodBeat.o(68202);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceHKUI.1
 * JD-Core Version:    0.7.0.1
 */