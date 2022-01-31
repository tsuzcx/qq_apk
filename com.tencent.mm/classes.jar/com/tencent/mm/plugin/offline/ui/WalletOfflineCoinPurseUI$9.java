package com.tencent.mm.plugin.offline.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.y.a;
import com.tencent.mm.y.c;

final class WalletOfflineCoinPurseUI$9
  implements View.OnClickListener
{
  WalletOfflineCoinPurseUI$9(WalletOfflineCoinPurseUI paramWalletOfflineCoinPurseUI, ImageView paramImageView) {}
  
  public final void onClick(View paramView)
  {
    y.i("MicroMsg.WalletOfflineCoinPurseUI", "click f2f lucky");
    h.nFQ.f(14021, new Object[] { Integer.valueOf(4), Integer.valueOf(WalletOfflineCoinPurseUI.p(this.mNj)) });
    d.x(this.mNj.mController.uMN, "luckymoney", ".f2f.ui.LuckyMoneyF2FQRCodeUI");
    if (c.BS().b(ac.a.uys, ac.a.uxr))
    {
      c.BS().c(ac.a.uys, ac.a.uxr);
      this.mNu.setVisibility(8);
      h.nFQ.f(14396, new Object[] { Integer.valueOf(5) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.9
 * JD-Core Version:    0.7.0.1
 */