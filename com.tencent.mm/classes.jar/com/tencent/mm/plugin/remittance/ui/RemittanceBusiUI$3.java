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

final class RemittanceBusiUI$3
  implements WalletFormView.c
{
  RemittanceBusiUI$3(RemittanceBusiUI paramRemittanceBusiUI) {}
  
  public final void m(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(142176);
    if (bo.hl(RemittanceBusiUI.y(this.qoF), 0))
    {
      ab.i("MicroMsg.RemittanceBusiUI", "mAmountRemindBit == 0");
      RemittanceBusiUI.w(this.qoF).setVisibility(8);
      AppMethodBeat.o(142176);
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
    if (i >= RemittanceBusiUI.y(this.qoF))
    {
      j = RemittanceBusiUI.c(this.qoF).l(paramCharSequence, RemittanceBusiUI.x(this.qoF), j);
      if (j != 0)
      {
        RemittanceBusiUI.w(this.qoF).setVisibility(0);
        paramCharSequence = c.ac(ah.getContext(), i);
        RemittanceBusiUI.z(this.qoF).setText(paramCharSequence);
        paramCharSequence = (RelativeLayout.LayoutParams)RemittanceBusiUI.v(this.qoF).getLayoutParams();
        paramCharSequence.leftMargin = j;
        RemittanceBusiUI.v(this.qoF).setLayoutParams(paramCharSequence);
        AppMethodBeat.o(142176);
        return;
      }
      RemittanceBusiUI.w(this.qoF).setVisibility(8);
      AppMethodBeat.o(142176);
      return;
    }
    RemittanceBusiUI.w(this.qoF).setVisibility(8);
    AppMethodBeat.o(142176);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI.3
 * JD-Core Version:    0.7.0.1
 */