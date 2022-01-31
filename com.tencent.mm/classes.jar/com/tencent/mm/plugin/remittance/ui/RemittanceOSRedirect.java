package com.tencent.mm.plugin.remittance.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.ah.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.am.a;
import com.tencent.mm.model.am.b;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.remittance.model.r;
import com.tencent.mm.plugin.remittance.model.z;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@a(7)
public class RemittanceOSRedirect
  extends WalletBaseUI
{
  public String djD = "";
  private int fzn;
  
  public final void b(int paramInt1, int paramInt2, String paramString, m paramm, boolean paramBoolean)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if ((paramm instanceof z))
      {
        paramString = (z)paramm;
        y.i("MicroMsg.RemittanceOSRedirect", "indexScene  %s", new Object[] { paramString.nzA });
        paramm = getIntent();
        if (paramString.iHA == 1)
        {
          com.tencent.mm.pluginsdk.wallet.h.a(this, 2, this.djD, 11, null);
          finish();
        }
      }
    }
    do
    {
      do
      {
        return;
        paramm.setClass(this, RemittanceOSUI.class);
        paramm.putExtra("os_currency", paramString.iHA);
        paramm.putExtra("os_currencyuint", paramString.nzA);
        paramm.putExtra("os_currencywording", paramString.nzB);
        paramm.putExtra("os_notice", paramString.iHC);
        paramm.putExtra("os_notice_url", paramString.iHD);
        startActivity(paramm);
        break;
      } while (!(paramm instanceof r));
      paramString = (r)paramm;
      paramm = new Intent();
      paramm.setClass(this, RemittanceHKUI.class);
      this.djD = paramString.nyu;
      if (bk.bl(this.djD))
      {
        y.e("MicroMsg.RemittanceOSRedirect", "empty username");
        finish();
      }
      paramm.putExtra("scene", this.fzn);
      paramm.putExtra("fee", paramString.ceq / 100.0D);
      paramm.putExtra("desc", paramString.desc);
      paramm.putExtra("scan_remittance_id", paramString.nyw);
      paramm.putExtra("receiver_name", paramString.nyu);
      paramm.putExtra("receiver_true_name", paramString.iHE);
      paramm.putExtra("receiver_nick_name", paramString.nyv);
      paramm.putExtra("hk_currency", paramString.iHA);
      paramm.putExtra("hk_currencyuint", paramString.iHB);
      paramm.putExtra("hk_notice", paramString.iHC);
      paramm.putExtra("hk_notice_url", paramString.iHD);
      paramInt2 = paramString.iHF;
      paramInt1 = 32;
      y.i("MicroMsg.RemittanceOSRedirect", "setAmount: %d", new Object[] { Integer.valueOf(paramInt2) });
      if (paramInt2 == 1) {
        paramInt1 = 33;
      }
      paramm.putExtra("pay_scene", paramInt1);
      g.DQ();
      if (((j)g.r(j.class)).Fw().abk(this.djD) != null)
      {
        startActivity(paramm);
        finish();
        return;
      }
      y.d("MicroMsg.RemittanceOSRedirect", "Receiver in contactStg and try to get contact");
      long l = bk.UY();
      am.a.dVy.a(this.djD, "", new RemittanceOSRedirect.1(this, l, paramm));
      return;
      if ((paramm instanceof z))
      {
        y.i("MicroMsg.RemittanceOSRedirect", "indexScene  errMsg %s", new Object[] { paramString });
        com.tencent.mm.ui.base.h.a(this, paramString, "", new RemittanceOSRedirect.2(this));
        return;
      }
    } while (!(paramm instanceof r));
    com.tencent.mm.ui.base.h.a(this, paramString, "", new RemittanceOSRedirect.3(this));
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    return true;
  }
  
  protected final int getLayoutId()
  {
    return -1;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setTitleVisibility(8);
    this.fzn = getIntent().getIntExtra("scene", 0);
    this.djD = getIntent().getStringExtra("receiver_name");
    if (this.fzn == 0)
    {
      y.e("MicroMsg.RemittanceOSRedirect", "error scene: %s", new Object[] { Integer.valueOf(this.fzn) });
      finish();
    }
    do
    {
      return;
      if (this.fzn == 5)
      {
        this.wCh.kh(1574);
        a(new z(q.Gq()), true, true);
        return;
      }
    } while (this.fzn != 6);
    this.wCh.kh(1301);
    a(new r(this.djD), true, false);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.fzn == 5) {
      ki(1574);
    }
    while (this.fzn != 6) {
      return;
    }
    ki(1301);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceOSRedirect
 * JD-Core Version:    0.7.0.1
 */