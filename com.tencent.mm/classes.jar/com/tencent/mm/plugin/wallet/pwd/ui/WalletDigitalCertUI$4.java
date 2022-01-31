package com.tencent.mm.plugin.wallet.pwd.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c.aa;
import com.tencent.mm.wallet_core.ui.d;

final class WalletDigitalCertUI$4
  extends d
{
  WalletDigitalCertUI$4(WalletDigitalCertUI paramWalletDigitalCertUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(46255);
    if ((paramView.getTag() instanceof aa))
    {
      paramView = (aa)paramView.getTag();
      h.a(this.tYR, this.tYR.getString(2131305392, new Object[] { paramView.ycL }), "", this.tYR.getString(2131296901), this.tYR.getString(2131296888), true, new WalletDigitalCertUI.4.1(this, paramView), null);
    }
    AppMethodBeat.o(46255);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletDigitalCertUI.4
 * JD-Core Version:    0.7.0.1
 */