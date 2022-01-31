package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.wallet_core.ui.e;

final class WalletBankcardIdUI$7
  implements View.OnClickListener
{
  WalletBankcardIdUI$7(WalletBankcardIdUI paramWalletBankcardIdUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(47167);
    h.qsU.e(11353, new Object[] { Integer.valueOf(2), Integer.valueOf(0) });
    e.d(this.unn, t.cTN().getTrueName());
    AppMethodBeat.o(47167);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletBankcardIdUI.7
 * JD-Core Version:    0.7.0.1
 */