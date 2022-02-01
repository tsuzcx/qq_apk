package com.tencent.mm.plugin.wallet_payu.remittance.ui;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.c;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ay.a;
import com.tencent.mm.model.ay.b;
import com.tencent.mm.model.ay.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.remittance.ui.RemittanceAdapterUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bv;
import com.tencent.mm.wallet_core.ui.f;

@com.tencent.mm.ui.base.a(7)
public class PayURemittanceAdapterUI
  extends RemittanceAdapterUI
{
  public final void c(String paramString, int paramInt, Intent paramIntent)
  {
    AppMethodBeat.i(72182);
    Log.i("MicroMsg.PayURemittanceAdapterUI", "startRemittanceUI scene=" + this.mScene + ", name=" + paramString);
    if (paramIntent != null) {}
    for (paramIntent = new Intent(paramIntent);; paramIntent = new Intent())
    {
      paramIntent.putExtra("receiver_name", paramString);
      paramIntent.putExtra("scene", this.mScene);
      paramIntent.putExtra("pay_scene", paramInt);
      paramString = new com.tencent.mm.hellhoundlib.b.a().bl(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramString.axQ(), "com/tencent/mm/plugin/wallet_payu/remittance/ui/PayURemittanceAdapterUI", "startRemittanceUI", "(Ljava/lang/String;ILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramString.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_payu/remittance/ui/PayURemittanceAdapterUI", "startRemittanceUI", "(Ljava/lang/String;ILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      setResult(-1);
      finish();
      AppMethodBeat.o(72182);
      return;
    }
  }
  
  public final void eNH()
  {
    AppMethodBeat.i(72180);
    doSceneProgress(new com.tencent.mm.plugin.wallet_payu.remittance.a.d(this.goe), false);
    AppMethodBeat.o(72180);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, final q paramq)
  {
    AppMethodBeat.i(72181);
    super.onSceneEnd(paramInt1, paramInt2, paramString, paramq);
    if ((paramq instanceof com.tencent.mm.plugin.wallet_payu.remittance.a.d)) {
      this.CqH = false;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramq instanceof com.tencent.mm.plugin.wallet_payu.remittance.a.d)))
    {
      paramString = (com.tencent.mm.plugin.wallet_payu.remittance.a.d)paramq;
      this.goe = paramString.username;
      if (Util.isNullOrNil(this.goe))
      {
        Log.d("MicroMsg.PayURemittanceAdapterUI", "Username empty & fishsh. scene=" + this.mScene);
        finish();
        AppMethodBeat.o(72181);
        return true;
      }
      paramq = new Intent();
      paramq.putExtra("fee", paramString.qwJ);
      paramq.putExtra("desc", paramString.desc);
      paramq.putExtra("scan_remittance_id", paramString.CpA);
      paramq.putExtra("receiver_true_name", f.bps(paramString.Cpz));
      g.aAi();
      if (((l)g.af(l.class)).aSN().bjK(this.goe) != null) {
        c(this.goe, paramString.scene, paramq);
      }
      for (;;)
      {
        AppMethodBeat.o(72181);
        return true;
        Log.d("MicroMsg.PayURemittanceAdapterUI", "Receiver in contactStg and try to get contact");
        final long l = Util.nowMilliSecond();
        ay.a.iDq.a(this.goe, "", new ay.b.a()
        {
          public final void p(String paramAnonymousString, boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(72179);
            if (paramAnonymousBoolean)
            {
              Log.v("MicroMsg.PayURemittanceAdapterUI", "getContact suc; cost=" + (Util.nowMilliSecond() - l) + " ms");
              c.ap(paramAnonymousString, 3);
              p.aYD().Mg(paramAnonymousString);
            }
            for (;;)
            {
              PayURemittanceAdapterUI.this.c(PayURemittanceAdapterUI.a(PayURemittanceAdapterUI.this), paramq.scene, this.CqK);
              AppMethodBeat.o(72179);
              return;
              Log.w("MicroMsg.PayURemittanceAdapterUI", "getContact failed");
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