package com.tencent.mm.plugin.offline.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.id_verify.model.f;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.x.a;
import com.tencent.mm.x.c;

final class WalletOfflineCoinPurseUI$7
  implements View.OnClickListener
{
  WalletOfflineCoinPurseUI$7(WalletOfflineCoinPurseUI paramWalletOfflineCoinPurseUI, ImageView paramImageView1, TextView paramTextView, ImageView paramImageView2) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(43511);
    if (c.PJ().b(ac.a.yIB, ac.a.yHA))
    {
      c.PJ().c(ac.a.yIB, ac.a.yHA);
      this.pnE.setVisibility(8);
      this.pnF.setVisibility(8);
      this.pnG.setVisibility(8);
      g.RM();
      g.RL().Ru().set(ac.a.yHR, "");
      h.qsU.e(14396, new Object[] { Integer.valueOf(3) });
    }
    if (t.cTN().cUl())
    {
      WalletOfflineCoinPurseUI.m(this.pny);
      AppMethodBeat.o(43511);
      return;
    }
    t.cTI();
    paramView = this.pny;
    i locali = WalletOfflineCoinPurseUI.n(this.pny);
    new WalletOfflineCoinPurseUI.7.1(this);
    if (!t.b(paramView, locali, 1006))
    {
      paramView = new f("collect");
      this.pny.doSceneForceProgress(paramView);
    }
    AppMethodBeat.o(43511);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.7
 * JD-Core Version:    0.7.0.1
 */