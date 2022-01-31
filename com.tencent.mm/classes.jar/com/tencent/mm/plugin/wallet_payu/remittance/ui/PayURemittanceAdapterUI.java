package com.tencent.mm.plugin.wallet_payu.remittance.ui;

import android.content.Intent;
import com.tencent.mm.ag.b;
import com.tencent.mm.ag.c;
import com.tencent.mm.ag.o;
import com.tencent.mm.ah.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.am.a;
import com.tencent.mm.model.am.b;
import com.tencent.mm.model.am.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.remittance.ui.RemittanceAdapterUI;
import com.tencent.mm.plugin.wallet_payu.remittance.a.d;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;

@a(7)
public class PayURemittanceAdapterUI
  extends RemittanceAdapterUI
{
  protected final void bwn()
  {
    a(new d(this.djD), false, false);
  }
  
  protected final void c(String paramString, int paramInt, Intent paramIntent)
  {
    y.i("MicroMsg.PayURemittanceAdapterUI", "startRemittanceUI scene=" + this.fzn + ", name=" + paramString);
    if (paramIntent != null) {}
    for (paramIntent = new Intent(paramIntent);; paramIntent = new Intent())
    {
      paramIntent.putExtra("receiver_name", paramString);
      paramIntent.putExtra("scene", this.fzn);
      paramIntent.putExtra("pay_scene", paramInt);
      startActivity(paramIntent);
      setResult(-1);
      finish();
      return;
    }
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, final m paramm)
  {
    boolean bool2 = false;
    super.c(paramInt1, paramInt2, paramString, paramm);
    if ((paramm instanceof d)) {
      this.nzO = false;
    }
    boolean bool1 = bool2;
    if (paramInt1 == 0)
    {
      bool1 = bool2;
      if (paramInt2 == 0)
      {
        bool1 = bool2;
        if ((paramm instanceof d))
        {
          paramString = (d)paramm;
          this.djD = paramString.username;
          if (!bk.bl(this.djD)) {
            break label112;
          }
          y.d("MicroMsg.PayURemittanceAdapterUI", "Username empty & fishsh. scene=" + this.fzn);
          finish();
          bool1 = true;
        }
      }
    }
    return bool1;
    label112:
    paramm = new Intent();
    paramm.putExtra("fee", paramString.iHP);
    paramm.putExtra("desc", paramString.desc);
    paramm.putExtra("scan_remittance_id", paramString.nzc);
    paramm.putExtra("receiver_true_name", e.afj(paramString.nzb));
    g.DQ();
    if (((j)g.r(j.class)).Fw().abk(this.djD) != null) {
      c(this.djD, paramString.scene, paramm);
    }
    for (;;)
    {
      return true;
      y.d("MicroMsg.PayURemittanceAdapterUI", "Receiver in contactStg and try to get contact");
      final long l = bk.UY();
      am.a.dVy.a(this.djD, "", new am.b.a()
      {
        public final void m(String paramAnonymousString, boolean paramAnonymousBoolean)
        {
          if (paramAnonymousBoolean)
          {
            y.v("MicroMsg.PayURemittanceAdapterUI", "getContact suc; cost=" + (bk.UY() - l) + " ms");
            b.M(paramAnonymousString, 3);
            o.Kj().kb(paramAnonymousString);
          }
          for (;;)
          {
            PayURemittanceAdapterUI.this.c(PayURemittanceAdapterUI.a(PayURemittanceAdapterUI.this), paramm.scene, this.nzR);
            return;
            y.w("MicroMsg.PayURemittanceAdapterUI", "getContact failed");
          }
        }
      });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.remittance.ui.PayURemittanceAdapterUI
 * JD-Core Version:    0.7.0.1
 */