package com.tencent.mm.plugin.wallet_payu.remittance.ui;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.c;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au.a;
import com.tencent.mm.model.au.b;
import com.tencent.mm.model.au.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.remittance.ui.RemittanceAdapterUI;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bq;
import com.tencent.mm.wallet_core.ui.f;

@com.tencent.mm.ui.base.a(7)
public class PayURemittanceAdapterUI
  extends RemittanceAdapterUI
{
  public final void c(String paramString, int paramInt, Intent paramIntent)
  {
    AppMethodBeat.i(72182);
    ae.i("MicroMsg.PayURemittanceAdapterUI", "startRemittanceUI scene=" + this.mScene + ", name=" + paramString);
    if (paramIntent != null) {}
    for (paramIntent = new Intent(paramIntent);; paramIntent = new Intent())
    {
      paramIntent.putExtra("receiver_name", paramString);
      paramIntent.putExtra("scene", this.mScene);
      paramIntent.putExtra("pay_scene", paramInt);
      paramString = new com.tencent.mm.hellhoundlib.b.a().bc(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramString.ahE(), "com/tencent/mm/plugin/wallet_payu/remittance/ui/PayURemittanceAdapterUI", "startRemittanceUI", "(Ljava/lang/String;ILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramString.mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_payu/remittance/ui/PayURemittanceAdapterUI", "startRemittanceUI", "(Ljava/lang/String;ILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      setResult(-1);
      finish();
      AppMethodBeat.o(72182);
      return;
    }
  }
  
  public final void dMH()
  {
    AppMethodBeat.i(72180);
    doSceneProgress(new com.tencent.mm.plugin.wallet_payu.remittance.a.d(this.fIQ), false);
    AppMethodBeat.o(72180);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, final n paramn)
  {
    AppMethodBeat.i(72181);
    super.onSceneEnd(paramInt1, paramInt2, paramString, paramn);
    if ((paramn instanceof com.tencent.mm.plugin.wallet_payu.remittance.a.d)) {
      this.ypQ = false;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramn instanceof com.tencent.mm.plugin.wallet_payu.remittance.a.d)))
    {
      paramString = (com.tencent.mm.plugin.wallet_payu.remittance.a.d)paramn;
      this.fIQ = paramString.username;
      if (bu.isNullOrNil(this.fIQ))
      {
        ae.d("MicroMsg.PayURemittanceAdapterUI", "Username empty & fishsh. scene=" + this.mScene);
        finish();
        AppMethodBeat.o(72181);
        return true;
      }
      paramn = new Intent();
      paramn.putExtra("fee", paramString.phz);
      paramn.putExtra("desc", paramString.desc);
      paramn.putExtra("scan_remittance_id", paramString.yoK);
      paramn.putExtra("receiver_true_name", f.bak(paramString.yoJ));
      g.ajS();
      if (((l)g.ab(l.class)).azF().aUL(this.fIQ) != null) {
        c(this.fIQ, paramString.scene, paramn);
      }
      for (;;)
      {
        AppMethodBeat.o(72181);
        return true;
        ae.d("MicroMsg.PayURemittanceAdapterUI", "Receiver in contactStg and try to get contact");
        final long l = bu.fpO();
        au.a.hIG.a(this.fIQ, "", new au.b.a()
        {
          public final void p(String paramAnonymousString, boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(72179);
            if (paramAnonymousBoolean)
            {
              ae.v("MicroMsg.PayURemittanceAdapterUI", "getContact suc; cost=" + (bu.fpO() - l) + " ms");
              c.al(paramAnonymousString, 3);
              p.aEP().Dw(paramAnonymousString);
            }
            for (;;)
            {
              PayURemittanceAdapterUI.this.c(PayURemittanceAdapterUI.a(PayURemittanceAdapterUI.this), paramn.scene, this.ypT);
              AppMethodBeat.o(72179);
              return;
              ae.w("MicroMsg.PayURemittanceAdapterUI", "getContact failed");
            }
          }
        });
      }
    }
    AppMethodBeat.o(72181);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.remittance.ui.PayURemittanceAdapterUI
 * JD-Core Version:    0.7.0.1
 */