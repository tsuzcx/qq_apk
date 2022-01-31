package com.tencent.mm.plugin.wallet_payu.remittance.ui;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.c;
import com.tencent.mm.ah.o;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ao.a;
import com.tencent.mm.model.ao.b;
import com.tencent.mm.model.ao.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.remittance.ui.RemittanceAdapterUI;
import com.tencent.mm.plugin.wallet_payu.remittance.a.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.e;

@a(7)
public class PayURemittanceAdapterUI
  extends RemittanceAdapterUI
{
  public final void c(String paramString, int paramInt, Intent paramIntent)
  {
    AppMethodBeat.i(48541);
    ab.i("MicroMsg.PayURemittanceAdapterUI", "startRemittanceUI scene=" + this.mScene + ", name=" + paramString);
    if (paramIntent != null) {}
    for (paramIntent = new Intent(paramIntent);; paramIntent = new Intent())
    {
      paramIntent.putExtra("receiver_name", paramString);
      paramIntent.putExtra("scene", this.mScene);
      paramIntent.putExtra("pay_scene", paramInt);
      startActivity(paramIntent);
      setResult(-1);
      finish();
      AppMethodBeat.o(48541);
      return;
    }
  }
  
  public final void che()
  {
    AppMethodBeat.i(48539);
    doSceneProgress(new d(this.eaX), false);
    AppMethodBeat.o(48539);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, final m paramm)
  {
    AppMethodBeat.i(48540);
    super.onSceneEnd(paramInt1, paramInt2, paramString, paramm);
    if ((paramm instanceof d)) {
      this.qle = false;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramm instanceof d)))
    {
      paramString = (d)paramm;
      this.eaX = paramString.username;
      if (bo.isNullOrNil(this.eaX))
      {
        ab.d("MicroMsg.PayURemittanceAdapterUI", "Username empty & fishsh. scene=" + this.mScene);
        finish();
        AppMethodBeat.o(48540);
        return true;
      }
      paramm = new Intent();
      paramm.putExtra("fee", paramString.kNS);
      paramm.putExtra("desc", paramString.desc);
      paramm.putExtra("scan_remittance_id", paramString.qke);
      paramm.putExtra("receiver_true_name", e.awc(paramString.qkd));
      g.RM();
      if (((j)g.E(j.class)).YA().arv(this.eaX) != null) {
        c(this.eaX, paramString.scene, paramm);
      }
      for (;;)
      {
        AppMethodBeat.o(48540);
        return true;
        ab.d("MicroMsg.PayURemittanceAdapterUI", "Receiver in contactStg and try to get contact");
        final long l = bo.aoy();
        ao.a.flI.a(this.eaX, "", new ao.b.a()
        {
          public final void p(String paramAnonymousString, boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(48538);
            if (paramAnonymousBoolean)
            {
              ab.v("MicroMsg.PayURemittanceAdapterUI", "getContact suc; cost=" + (bo.aoy() - l) + " ms");
              b.U(paramAnonymousString, 3);
              o.adi().qU(paramAnonymousString);
            }
            for (;;)
            {
              PayURemittanceAdapterUI.this.c(PayURemittanceAdapterUI.a(PayURemittanceAdapterUI.this), paramm.scene, this.qlh);
              AppMethodBeat.o(48538);
              return;
              ab.w("MicroMsg.PayURemittanceAdapterUI", "getContact failed");
            }
          }
        });
      }
    }
    AppMethodBeat.o(48540);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.remittance.ui.PayURemittanceAdapterUI
 * JD-Core Version:    0.7.0.1
 */