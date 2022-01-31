package com.tencent.mm.plugin.remittance.ui;

import android.widget.TextView;
import com.tencent.mm.plugin.remittance.model.BusiRemittanceResp;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.wallet_core.ui.e;

final class RemittanceBusiUI$28
  implements Runnable
{
  RemittanceBusiUI$28(RemittanceBusiUI paramRemittanceBusiUI) {}
  
  public final void run()
  {
    RemittanceBusiUI.u(this.nCA).setText(RemittanceBusiUI.t(this.nCA));
    String str2 = e.dP(e.gV(RemittanceBusiUI.v(this.nCA)), 10);
    String str1 = str2;
    if (!bk.bl(RemittanceBusiUI.w(this.nCA))) {
      str1 = this.nCA.getString(a.i.remittance_collect_block, new Object[] { str2, RemittanceBusiUI.w(this.nCA) });
    }
    RemittanceBusiUI.x(this.nCA).setText(j.a(this.nCA, str1, RemittanceBusiUI.x(this.nCA).getTextSize()));
    if (RemittanceBusiUI.i(this.nCA) != null) {
      if (RemittanceBusiUI.i(this.nCA).nxL == 1)
      {
        if (!bk.bl(RemittanceBusiUI.i(this.nCA).nxM))
        {
          if (RemittanceBusiUI.i(this.nCA).nxU == 1) {
            RemittanceBusiUI.y(this.nCA).setRoundCorner(true);
          }
          for (;;)
          {
            int i = BackwardSupportUtil.b.b(this.nCA, 36.0F);
            RemittanceBusiUI.y(this.nCA).j(RemittanceBusiUI.i(this.nCA).nxM, i, i, -1);
            return;
            RemittanceBusiUI.y(this.nCA).setRoundCorner(false);
          }
        }
        if (!bk.bl(RemittanceBusiUI.v(this.nCA)))
        {
          if (RemittanceBusiUI.i(this.nCA).nxU == 1)
          {
            a.b.n(RemittanceBusiUI.y(this.nCA), RemittanceBusiUI.v(this.nCA));
            return;
          }
          a.b.a(RemittanceBusiUI.y(this.nCA), RemittanceBusiUI.v(this.nCA));
        }
      }
      else
      {
        RemittanceBusiUI.y(this.nCA).setVisibility(8);
        return;
      }
    }
    RemittanceBusiUI.y(this.nCA).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI.28
 * JD-Core Version:    0.7.0.1
 */