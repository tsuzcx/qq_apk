package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.picker.a;
import com.tencent.mm.ui.widget.picker.a.a;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

final class WalletCardElementUI$18
  implements View.OnClickListener
{
  WalletCardElementUI$18(WalletCardElementUI paramWalletCardElementUI) {}
  
  public final void onClick(final View paramView)
  {
    AppMethodBeat.i(47236);
    paramView = new a(this.uoW.getContext());
    paramView.AIQ = new a.a()
    {
      public final void onResult(boolean paramAnonymousBoolean, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(47235);
        if (paramAnonymousBoolean)
        {
          WalletCardElementUI.q(WalletCardElementUI.18.this.uoW).setText(String.format("%04d%02d%02d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3) }));
          WalletCardElementUI.f(WalletCardElementUI.18.this.uoW, paramAnonymousInt1);
          WalletCardElementUI.g(WalletCardElementUI.18.this.uoW, paramAnonymousInt2);
          WalletCardElementUI.h(WalletCardElementUI.18.this.uoW, paramAnonymousInt3);
          WalletCardElementUI.b(WalletCardElementUI.18.this.uoW);
        }
        paramView.hide();
        AppMethodBeat.o(47235);
      }
    };
    if ((WalletCardElementUI.r(this.uoW) > 0) && (WalletCardElementUI.s(this.uoW) > 0) && (WalletCardElementUI.t(this.uoW) > 0)) {
      paramView.aA(WalletCardElementUI.r(this.uoW), WalletCardElementUI.s(this.uoW), WalletCardElementUI.t(this.uoW));
    }
    paramView.show();
    AppMethodBeat.o(47236);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI.18
 * JD-Core Version:    0.7.0.1
 */