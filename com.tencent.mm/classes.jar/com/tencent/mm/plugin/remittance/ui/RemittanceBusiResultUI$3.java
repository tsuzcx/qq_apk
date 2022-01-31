package com.tencent.mm.plugin.remittance.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.h.a.rc;
import com.tencent.mm.protocal.c.la;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.wallet_core.ui.e;

final class RemittanceBusiResultUI$3
  implements View.OnClickListener
{
  RemittanceBusiResultUI$3(RemittanceBusiResultUI paramRemittanceBusiResultUI, la paramla) {}
  
  public final void onClick(View paramView)
  {
    y.i("MicroMsg.RemittanceBusiResultUI", "app type: %s", new Object[] { Integer.valueOf(this.nBz.type) });
    if (this.nBz.type == 1)
    {
      RemittanceBusiResultUI.a(this.nBx);
      paramView = new rc();
      paramView.caq.userName = this.nBz.sGf;
      paramView.caq.cas = bk.aM(this.nBz.sGg, "");
      paramView.caq.scene = 1034;
      paramView.caq.cat = 0;
      a.udP.m(paramView);
      return;
    }
    if (this.nBz.type == 2)
    {
      RemittanceBusiResultUI.a(this.nBx);
      e.l(this.nBx.mController.uMN, this.nBz.url, true);
      return;
    }
    int i = this.nBz.type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceBusiResultUI.3
 * JD-Core Version:    0.7.0.1
 */