package com.tencent.mm.plugin.offline.ui;

import android.content.Intent;
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

final class WalletOfflineCoinPurseUI$8
  implements View.OnClickListener
{
  WalletOfflineCoinPurseUI$8(WalletOfflineCoinPurseUI paramWalletOfflineCoinPurseUI, ImageView paramImageView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(43512);
    ab.i("MicroMsg.WalletOfflineCoinPurseUI", "click aa");
    h.qsU.e(14021, new Object[] { Integer.valueOf(3), Integer.valueOf(WalletOfflineCoinPurseUI.p(this.pny)) });
    paramView = new Intent();
    if (WalletOfflineCoinPurseUI.c(this.pny) == 1) {
      paramView.putExtra("enter_scene", 2);
    }
    for (;;)
    {
      d.b(this.pny.getContext(), "aa", ".ui.AAEntranceUI", paramView);
      if (c.PJ().b(ac.a.yIA, ac.a.yHA))
      {
        c.PJ().c(ac.a.yIA, ac.a.yHA);
        this.pnI.setVisibility(8);
        h.qsU.e(14396, new Object[] { Integer.valueOf(4) });
      }
      AppMethodBeat.o(43512);
      return;
      if (WalletOfflineCoinPurseUI.c(this.pny) == 2) {
        paramView.putExtra("enter_scene", 4);
      } else {
        ab.w("MicroMsg.WalletOfflineCoinPurseUI", "unknown scene: %s", new Object[] { Integer.valueOf(WalletOfflineCoinPurseUI.c(this.pny)) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.8
 * JD-Core Version:    0.7.0.1
 */