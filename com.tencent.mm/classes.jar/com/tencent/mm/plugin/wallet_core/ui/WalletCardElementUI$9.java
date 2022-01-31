package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.wallet_core.ui.e;

final class WalletCardElementUI$9
  implements View.OnClickListener
{
  WalletCardElementUI$9(WalletCardElementUI paramWalletCardElementUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(47222);
    h.qsU.e(11353, new Object[] { Integer.valueOf(2), Integer.valueOf(0) });
    e.d(this.uoW, t.cTN().getTrueName());
    AppMethodBeat.o(47222);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI.9
 * JD-Core Version:    0.7.0.1
 */