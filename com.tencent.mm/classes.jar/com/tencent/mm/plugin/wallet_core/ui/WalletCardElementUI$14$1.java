package com.tencent.mm.plugin.wallet_core.ui;

import com.tencent.mm.ui.widget.picker.a;
import com.tencent.mm.ui.widget.picker.a.a;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

final class WalletCardElementUI$14$1
  implements a.a
{
  WalletCardElementUI$14$1(WalletCardElementUI.14 param14, a parama) {}
  
  public final void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramBoolean)
    {
      WalletCardElementUI.j(this.qCp.qCj).setText(String.format("%04d%02d%02d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) }));
      WalletCardElementUI.c(this.qCp.qCj, paramInt1);
      WalletCardElementUI.d(this.qCp.qCj, paramInt2);
      WalletCardElementUI.e(this.qCp.qCj, paramInt3);
      WalletCardElementUI.b(this.qCp.qCj);
    }
    this.qCo.hide();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI.14.1
 * JD-Core Version:    0.7.0.1
 */