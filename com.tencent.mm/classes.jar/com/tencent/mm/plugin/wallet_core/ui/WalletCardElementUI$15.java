package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.picker.a;

final class WalletCardElementUI$15
  implements View.OnClickListener
{
  WalletCardElementUI$15(WalletCardElementUI paramWalletCardElementUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(47232);
    paramView = new a(this.uoW.getContext());
    paramView.AIQ = new WalletCardElementUI.15.1(this, paramView);
    if ((WalletCardElementUI.l(this.uoW) > 0) && (WalletCardElementUI.m(this.uoW) > 0) && (WalletCardElementUI.n(this.uoW) > 0)) {
      paramView.aA(WalletCardElementUI.l(this.uoW), WalletCardElementUI.m(this.uoW), WalletCardElementUI.n(this.uoW));
    }
    paramView.show();
    AppMethodBeat.o(47232);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI.15
 * JD-Core Version:    0.7.0.1
 */