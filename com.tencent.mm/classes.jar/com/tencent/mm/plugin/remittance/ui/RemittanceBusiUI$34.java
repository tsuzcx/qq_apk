package com.tencent.mm.plugin.remittance.ui;

import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.ui.a;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

final class RemittanceBusiUI$34
  implements a
{
  RemittanceBusiUI$34(RemittanceBusiUI paramRemittanceBusiUI) {}
  
  public final void onVisibleStateChange(boolean paramBoolean)
  {
    AppMethodBeat.i(142206);
    RemittanceBusiUI.a(this.qoF, paramBoolean);
    if (!paramBoolean)
    {
      RemittanceBusiUI.u(this.qoF).scrollTo(0, 0);
      if ((RemittanceBusiUI.c(this.qoF) != null) && (RemittanceBusiUI.c(this.qoF).getVisibility() == 0))
      {
        RemittanceBusiUI.c(this.qoF).setFocusable(false);
        RemittanceBusiUI.c(this.qoF).setFocusable(true);
      }
    }
    AppMethodBeat.o(142206);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI.34
 * JD-Core Version:    0.7.0.1
 */