package com.tencent.mm.plugin.remittance.ui;

import android.widget.Toast;
import com.tencent.mm.plugin.remittance.model.c;
import com.tencent.mm.plugin.remittance.model.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.za;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.u;
import java.util.List;

final class RemittanceBusiUI$25
  extends u
{
  RemittanceBusiUI$25(RemittanceBusiUI paramRemittanceBusiUI) {}
  
  public final void aEI()
  {
    h.nFQ.f(15235, new Object[] { Integer.valueOf(5) });
    if (!RemittanceBusiUI.k(this.nCA)) {
      RemittanceBusiUI.a(this.nCA, RemittanceBusiUI.n(this.nCA));
    }
    if (RemittanceBusiUI.o(this.nCA) <= 0.0D)
    {
      com.tencent.mm.ui.base.s.makeText(this.nCA.mController.uMN, a.i.wallet_balance_save_input_invalid, 0).show();
      return;
    }
    g localg = this.nCA.nCs;
    if (this.nCA.nCs == null) {}
    for (String str = "";; str = this.nCA.nCs.nyc)
    {
      y.i("MicroMsg.RemittanceBusiUI", "mPayBtn onClick %s  isFinish:%s getFavorFlag: %s", new Object[] { localg, str, Boolean.valueOf(this.nCA.nCp) });
      if (RemittanceBusiUI.h(this.nCA) != 32) {
        break label292;
      }
      if (!this.nCA.nCp) {
        break label284;
      }
      if ((this.nCA.nCs == null) || (this.nCA.nCs.nyf != (int)(RemittanceBusiUI.o(this.nCA) * 100.0D))) {
        break label267;
      }
      if ((this.nCA.nCs != null) && (this.nCA.nCs.nyc)) {
        break label292;
      }
      if (this.nCA.nCs == null) {
        break;
      }
      this.nCA.nCs.nya = new c()
      {
        public final void cl(List<za> paramAnonymousList)
        {
          RemittanceBusiUI.p(RemittanceBusiUI.25.this.nCA);
        }
      };
      return;
    }
    label267:
    RemittanceBusiUI.a(this.nCA, new RemittanceBusiUI.25.2(this), 0);
    return;
    label284:
    RemittanceBusiUI.p(this.nCA);
    return;
    label292:
    RemittanceBusiUI.p(this.nCA);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI.25
 * JD-Core Version:    0.7.0.1
 */