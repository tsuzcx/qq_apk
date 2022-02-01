package com.tencent.mm.plugin.wallet_payu.remittance.ui;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.c;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.b;
import com.tencent.mm.model.ar.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.remittance.ui.RemittanceAdapterUI;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bj;
import com.tencent.mm.wallet_core.ui.e;

@com.tencent.mm.ui.base.a(7)
public class PayURemittanceAdapterUI
  extends RemittanceAdapterUI
{
  public final void c(String paramString, int paramInt, Intent paramIntent)
  {
    AppMethodBeat.i(72182);
    ac.i("MicroMsg.PayURemittanceAdapterUI", "startRemittanceUI scene=" + this.mScene + ", name=" + paramString);
    if (paramIntent != null) {}
    for (paramIntent = new Intent(paramIntent);; paramIntent = new Intent())
    {
      paramIntent.putExtra("receiver_name", paramString);
      paramIntent.putExtra("scene", this.mScene);
      paramIntent.putExtra("pay_scene", paramInt);
      paramString = new com.tencent.mm.hellhoundlib.b.a().ba(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramString.aeD(), "com/tencent/mm/plugin/wallet_payu/remittance/ui/PayURemittanceAdapterUI", "startRemittanceUI", "(Ljava/lang/String;ILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramString.lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_payu/remittance/ui/PayURemittanceAdapterUI", "startRemittanceUI", "(Ljava/lang/String;ILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      setResult(-1);
      finish();
      AppMethodBeat.o(72182);
      return;
    }
  }
  
  public final void dxX()
  {
    AppMethodBeat.i(72180);
    doSceneProgress(new com.tencent.mm.plugin.wallet_payu.remittance.a.d(this.foE), false);
    AppMethodBeat.o(72180);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, final n paramn)
  {
    AppMethodBeat.i(72181);
    super.onSceneEnd(paramInt1, paramInt2, paramString, paramn);
    if ((paramn instanceof com.tencent.mm.plugin.wallet_payu.remittance.a.d)) {
      this.wMr = false;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramn instanceof com.tencent.mm.plugin.wallet_payu.remittance.a.d)))
    {
      paramString = (com.tencent.mm.plugin.wallet_payu.remittance.a.d)paramn;
      this.foE = paramString.username;
      if (bs.isNullOrNil(this.foE))
      {
        ac.d("MicroMsg.PayURemittanceAdapterUI", "Username empty & fishsh. scene=" + this.mScene);
        finish();
        AppMethodBeat.o(72181);
        return true;
      }
      paramn = new Intent();
      paramn.putExtra("fee", paramString.oxA);
      paramn.putExtra("desc", paramString.desc);
      paramn.putExtra("scan_remittance_id", paramString.wLl);
      paramn.putExtra("receiver_true_name", e.aSI(paramString.wLk));
      g.agS();
      if (((k)g.ab(k.class)).awB().aNs(this.foE) != null) {
        c(this.foE, paramString.scene, paramn);
      }
      for (;;)
      {
        AppMethodBeat.o(72181);
        return true;
        ac.d("MicroMsg.PayURemittanceAdapterUI", "Receiver in contactStg and try to get contact");
        final long l = bs.eWj();
        ar.a.hnw.a(this.foE, "", new ar.b.a()
        {
          public final void p(String paramAnonymousString, boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(72179);
            if (paramAnonymousBoolean)
            {
              ac.v("MicroMsg.PayURemittanceAdapterUI", "getContact suc; cost=" + (bs.eWj() - l) + " ms");
              c.ag(paramAnonymousString, 3);
              p.aBy().zV(paramAnonymousString);
            }
            for (;;)
            {
              PayURemittanceAdapterUI.this.c(PayURemittanceAdapterUI.a(PayURemittanceAdapterUI.this), paramn.scene, this.wMu);
              AppMethodBeat.o(72179);
              return;
              ac.w("MicroMsg.PayURemittanceAdapterUI", "getContact failed");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.remittance.ui.PayURemittanceAdapterUI
 * JD-Core Version:    0.7.0.1
 */