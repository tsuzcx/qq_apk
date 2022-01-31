package com.tencent.mm.plugin.remittance.ui;

import android.widget.ScrollView;
import com.tencent.mm.wallet_core.ui.a;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

final class RemittanceBusiUI$27
  implements a
{
  RemittanceBusiUI$27(RemittanceBusiUI paramRemittanceBusiUI) {}
  
  public final void gK(boolean paramBoolean)
  {
    RemittanceBusiUI.a(this.nCA, paramBoolean);
    if (paramBoolean) {
      RemittanceBusiUI.a(this.nCA, RemittanceBusiUI.r(this.nCA), RemittanceBusiUI.s(this.nCA));
    }
    do
    {
      return;
      RemittanceBusiUI.r(this.nCA).scrollTo(0, 0);
    } while ((RemittanceBusiUI.d(this.nCA) == null) || (RemittanceBusiUI.d(this.nCA).getVisibility() != 0));
    RemittanceBusiUI.d(this.nCA).setFocusable(false);
    RemittanceBusiUI.d(this.nCA).setFocusable(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI.27
 * JD-Core Version:    0.7.0.1
 */