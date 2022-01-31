package com.tencent.mm.plugin.remittance.ui;

import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.utils.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView.c;

final class RemittanceNewBaseUI$31
  implements WalletFormView.c
{
  RemittanceNewBaseUI$31(RemittanceNewBaseUI paramRemittanceNewBaseUI) {}
  
  public final void m(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(142263);
    if (bo.hl(this.qqR.qnV, 0))
    {
      ab.i("MicroMsg.RemittanceNewBaseUI", "mAmountRemindBit == 0");
      RemittanceNewBaseUI.f(this.qqR).setVisibility(8);
      AppMethodBeat.o(142263);
      return;
    }
    long l = Double.valueOf(bo.getDouble(paramCharSequence.toString(), 0.0D)).longValue();
    int j = 0;
    int i = 0;
    while (l != 0L)
    {
      j = (int)(l % 10L);
      l /= 10L;
      i += 1;
    }
    if (i >= this.qqR.qnV)
    {
      j = this.qqR.kRl.l(paramCharSequence, RemittanceNewBaseUI.g(this.qqR), j);
      if (j != 0)
      {
        RemittanceNewBaseUI.f(this.qqR).setVisibility(0);
        paramCharSequence = c.ac(ah.getContext(), i);
        RemittanceNewBaseUI.h(this.qqR).setText(paramCharSequence);
        paramCharSequence = (RelativeLayout.LayoutParams)RemittanceNewBaseUI.e(this.qqR).getLayoutParams();
        paramCharSequence.leftMargin = j;
        RemittanceNewBaseUI.e(this.qqR).setLayoutParams(paramCharSequence);
        AppMethodBeat.o(142263);
        return;
      }
      RemittanceNewBaseUI.f(this.qqR).setVisibility(8);
      AppMethodBeat.o(142263);
      return;
    }
    RemittanceNewBaseUI.f(this.qqR).setVisibility(8);
    AppMethodBeat.o(142263);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceNewBaseUI.31
 * JD-Core Version:    0.7.0.1
 */