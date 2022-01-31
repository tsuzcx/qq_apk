package com.tencent.mm.plugin.remittance.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.mm.ah.m;
import com.tencent.mm.h.a.fu;
import com.tencent.mm.h.a.ti;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.remittance.model.v;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.c.ae;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c.n;
import com.tencent.mm.wallet_core.c.n.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public class RemittanceUI
  extends RemittanceBaseUI
{
  protected String nEy;
  
  public final void a(String paramString1, String paramString2, String paramString3, fu paramfu)
  {
    if (this.nzT != null) {
      this.nzT.i(3, new Object[] { Integer.valueOf(this.nzY), Double.valueOf(this.nzU) });
    }
    int i = getIntent().getIntExtra("pay_channel", -1);
    String str = "";
    Object localObject = str;
    if (!bk.H(new String[0]))
    {
      g.DQ();
      localObject = ((j)g.r(j.class)).Fw().abj(this.djD);
      if (localObject != null) {
        localObject = ((ad)localObject).Bq();
      }
    }
    else
    {
      if (!bk.bl(paramString3)) {
        break label258;
      }
    }
    label258:
    for (this.nAy = true;; this.nAy = false)
    {
      y.i("MicroMsg.RemittanceUI", "doSceneGenRemittance, channel: %s", new Object[] { Integer.valueOf(i) });
      paramString1 = new v(this.nzU, "1", this.djD, this.nAo, this.nzY, this.fzn, paramString1, paramString2, this.nzZ, i, this.nAt, paramString3, this.nzV, (String)localObject, this.nAo, paramfu, this.nAv, this.nAu, this.nEy);
      paramString1.dIA = "RemittanceProcess";
      a(paramString1, true, true);
      this.nAv = "";
      return;
      y.e("MicroMsg.RemittanceUI", "can not found contact for user::" + this.djD);
      localObject = str;
      break;
    }
  }
  
  public final void bwo()
  {
    if (bwx())
    {
      g.DQ();
      this.nAp = ((String)g.DP().Dz().get(ac.a.uuw, ""));
      g.DQ();
      this.nAq = ((String)g.DP().Dz().get(ac.a.uuA, ""));
      g.DQ();
      this.nAr = ((Integer)g.DP().Dz().get(ac.a.uuB, Integer.valueOf(0))).intValue();
      if ((!bk.bl(this.nAp)) && (!bk.bl(this.nAq))) {
        break label138;
      }
      ae.a(true, null);
    }
    for (;;)
    {
      y.d("MicroMsg.RemittanceUI", "do before transfer");
      a(new com.tencent.mm.plugin.remittance.model.e(this.djD), false, false);
      return;
      label138:
      ae.a(false, null);
    }
  }
  
  public final void bwr()
  {
    com.tencent.mm.ui.base.s.makeText(this.mController.uMN, a.i.remittance_amount_lowest_limit, 0).show();
  }
  
  public final void bwu()
  {
    ti localti = new ti();
    localti.ccU.bso = "7";
    localti.bFJ = new RemittanceUI.4(this, localti);
    com.tencent.mm.sdk.b.a.udP.m(localti);
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramm instanceof com.tencent.mm.plugin.remittance.model.e))
    {
      paramString = (com.tencent.mm.plugin.remittance.model.e)paramm;
      paramString.a(new RemittanceUI.3(this, paramString)).b(new n.a()
      {
        public final void f(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, m paramAnonymousm)
        {
          y.d("MicroMsg.RemittanceUI", "before transfer: %s, %s, %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        }
      }).c(new RemittanceUI.1(this, paramString));
      return true;
    }
    return super.c(paramInt1, paramInt2, paramString, paramm);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    h.nFQ.f(15386, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
    kh(2783);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ki(2783);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceUI
 * JD-Core Version:    0.7.0.1
 */