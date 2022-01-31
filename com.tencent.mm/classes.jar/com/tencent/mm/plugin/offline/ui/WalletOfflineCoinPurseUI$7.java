package com.tencent.mm.plugin.offline.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.id_verify.model.f;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.y.a;
import com.tencent.mm.y.c;

final class WalletOfflineCoinPurseUI$7
  implements View.OnClickListener
{
  WalletOfflineCoinPurseUI$7(WalletOfflineCoinPurseUI paramWalletOfflineCoinPurseUI, ImageView paramImageView1, TextView paramTextView, ImageView paramImageView2) {}
  
  public final void onClick(View paramView)
  {
    if (c.BS().b(ac.a.uyr, ac.a.uxr))
    {
      c.BS().c(ac.a.uyr, ac.a.uxr);
      this.mNp.setVisibility(8);
      this.mNq.setVisibility(8);
      this.mNr.setVisibility(8);
      g.DQ();
      g.DP().Dz().c(ac.a.uxH, "");
      h.nFQ.f(14396, new Object[] { Integer.valueOf(3) });
    }
    if (o.bVs().bVN()) {
      WalletOfflineCoinPurseUI.m(this.mNj);
    }
    i locali;
    do
    {
      return;
      o.bVn();
      paramView = this.mNj;
      locali = WalletOfflineCoinPurseUI.n(this.mNj);
      new WalletOfflineCoinPurseUI.7.1(this);
    } while (o.b(paramView, locali));
    paramView = new f("collect");
    this.mNj.a(paramView, true, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.7
 * JD-Core Version:    0.7.0.1
 */