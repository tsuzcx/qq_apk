package com.tencent.mm.plugin.wallet_core.ui;

import com.tencent.mm.ui.widget.picker.a;
import com.tencent.mm.ui.widget.picker.a.a;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

final class WalletCardElementUI$17$1
  implements a.a
{
  WalletCardElementUI$17$1(WalletCardElementUI.17 param17, a parama) {}
  
  public final void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramBoolean)
    {
      WalletCardElementUI.p(this.qCq.qCj).setText(String.format("%04d%02d%02d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) }));
      WalletCardElementUI.f(this.qCq.qCj, paramInt1);
      WalletCardElementUI.g(this.qCq.qCj, paramInt2);
      WalletCardElementUI.h(this.qCq.qCj, paramInt3);
      WalletCardElementUI.b(this.qCq.qCj);
    }
    this.qCo.hide();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI.17.1
 * JD-Core Version:    0.7.0.1
 */