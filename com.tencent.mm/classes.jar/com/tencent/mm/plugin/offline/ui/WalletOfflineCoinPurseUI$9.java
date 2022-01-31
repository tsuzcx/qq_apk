package com.tencent.mm.plugin.offline.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.x.a;
import com.tencent.mm.x.c;

final class WalletOfflineCoinPurseUI$9
  implements View.OnClickListener
{
  WalletOfflineCoinPurseUI$9(WalletOfflineCoinPurseUI paramWalletOfflineCoinPurseUI, ImageView paramImageView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(43513);
    ab.i("MicroMsg.WalletOfflineCoinPurseUI", "click f2f lucky");
    h.qsU.e(14021, new Object[] { Integer.valueOf(4), Integer.valueOf(WalletOfflineCoinPurseUI.p(this.pny)) });
    d.H(this.pny.getContext(), "luckymoney", ".f2f.ui.LuckyMoneyF2FQRCodeUI");
    if (c.PJ().b(ac.a.yIC, ac.a.yHA))
    {
      c.PJ().c(ac.a.yIC, ac.a.yHA);
      this.pnJ.setVisibility(8);
      h.qsU.e(14396, new Object[] { Integer.valueOf(5) });
    }
    AppMethodBeat.o(43513);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.9
 * JD-Core Version:    0.7.0.1
 */