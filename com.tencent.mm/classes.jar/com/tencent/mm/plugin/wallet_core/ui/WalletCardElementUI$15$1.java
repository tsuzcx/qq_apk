package com.tencent.mm.plugin.wallet_core.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.picker.a;
import com.tencent.mm.ui.widget.picker.a.a;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

final class WalletCardElementUI$15$1
  implements a.a
{
  WalletCardElementUI$15$1(WalletCardElementUI.15 param15, a parama) {}
  
  public final void onResult(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(47231);
    if (paramBoolean)
    {
      WalletCardElementUI.k(this.uoZ.uoW).setText(String.format("%04d%02d%02d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) }));
      WalletCardElementUI.c(this.uoZ.uoW, paramInt1);
      WalletCardElementUI.d(this.uoZ.uoW, paramInt2);
      WalletCardElementUI.e(this.uoZ.uoW, paramInt3);
      WalletCardElementUI.b(this.uoZ.uoW);
    }
    this.udA.hide();
    AppMethodBeat.o(47231);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI.15.1
 * JD-Core Version:    0.7.0.1
 */