package com.tencent.mm.plugin.offline.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.id_verify.model.f;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.x.a;
import com.tencent.mm.x.c;

final class WalletOfflineCoinPurseUI$10
  implements View.OnClickListener
{
  WalletOfflineCoinPurseUI$10(WalletOfflineCoinPurseUI paramWalletOfflineCoinPurseUI, ImageView paramImageView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(43515);
    ab.i("MicroMsg.WalletOfflineCoinPurseUI", "click qr reward");
    h.qsU.e(14021, new Object[] { Integer.valueOf(5), Integer.valueOf(WalletOfflineCoinPurseUI.p(this.pny)) });
    if (c.PJ().b(ac.a.yID, ac.a.yHA))
    {
      c.PJ().c(ac.a.yID, ac.a.yHA);
      this.pnK.setVisibility(8);
    }
    if (t.cTN().cUl())
    {
      d.H(this.pny.getContext(), "collect", ".reward.ui.QrRewardMainUI");
      AppMethodBeat.o(43515);
      return;
    }
    t.cTI();
    paramView = this.pny;
    i locali = WalletOfflineCoinPurseUI.q(this.pny);
    new WalletOfflineCoinPurseUI.10.1(this);
    if (!t.b(paramView, locali, 1006))
    {
      paramView = new f("reward");
      this.pny.doSceneForceProgress(paramView);
    }
    AppMethodBeat.o(43515);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.10
 * JD-Core Version:    0.7.0.1
 */