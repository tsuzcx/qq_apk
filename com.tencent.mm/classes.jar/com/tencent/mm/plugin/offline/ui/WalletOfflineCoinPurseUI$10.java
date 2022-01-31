package com.tencent.mm.plugin.offline.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.id_verify.model.f;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.g;
import com.tencent.mm.y.a;
import com.tencent.mm.y.c;

final class WalletOfflineCoinPurseUI$10
  implements View.OnClickListener
{
  WalletOfflineCoinPurseUI$10(WalletOfflineCoinPurseUI paramWalletOfflineCoinPurseUI, ImageView paramImageView) {}
  
  public final void onClick(View paramView)
  {
    y.i("MicroMsg.WalletOfflineCoinPurseUI", "click qr reward");
    h.nFQ.f(14021, new Object[] { Integer.valueOf(5), Integer.valueOf(WalletOfflineCoinPurseUI.p(this.mNj)) });
    if (c.BS().b(ac.a.uyt, ac.a.uxr))
    {
      c.BS().c(ac.a.uyt, ac.a.uxr);
      this.mNv.setVisibility(8);
    }
    if (o.bVs().bVN()) {
      d.x(this.mNj.mController.uMN, "collect", ".reward.ui.QrRewardMainUI");
    }
    i locali;
    do
    {
      return;
      WalletOfflineCoinPurseUI.a(this.mNj, g.a(this.mNj.mController.uMN, false, new WalletOfflineCoinPurseUI.10.1(this)));
      o.bVn();
      paramView = this.mNj;
      locali = WalletOfflineCoinPurseUI.r(this.mNj);
      new WalletOfflineCoinPurseUI.10.2(this);
    } while (o.b(paramView, locali));
    paramView = new f("reward");
    this.mNj.a(paramView, true, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.10
 * JD-Core Version:    0.7.0.1
 */