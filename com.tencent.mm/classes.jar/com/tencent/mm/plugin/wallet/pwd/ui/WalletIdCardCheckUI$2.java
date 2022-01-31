package com.tencent.mm.plugin.wallet.pwd.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.bt;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.wallet_core.c.n;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

final class WalletIdCardCheckUI$2
  implements View.OnClickListener
{
  WalletIdCardCheckUI$2(WalletIdCardCheckUI paramWalletIdCardCheckUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(46323);
    if (WalletIdCardCheckUI.a(this.tZC))
    {
      paramView = new bt();
      paramView.cRI = 1L;
      paramView.cYT = 1L;
      paramView.ake();
      h.qsU.e(13731, new Object[] { Integer.valueOf(2) });
      paramView = new n(WalletIdCardCheckUI.b(this.tZC).getText(), WalletIdCardCheckUI.c(this.tZC), t.cTN().getTrueName());
      this.tZC.doSceneProgress(paramView);
    }
    AppMethodBeat.o(46323);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletIdCardCheckUI.2
 * JD-Core Version:    0.7.0.1
 */