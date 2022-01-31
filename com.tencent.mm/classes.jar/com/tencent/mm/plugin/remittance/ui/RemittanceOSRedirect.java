package com.tencent.mm.plugin.remittance.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
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
import com.tencent.mm.plugin.remittance.model.z;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@a(7)
public class RemittanceOSRedirect
  extends WalletBaseUI
{
  public String eaX = "";
  private int mScene;
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(45088);
    super.onCreate(paramBundle);
    setTitleVisibility(8);
    this.mScene = getIntent().getIntExtra("scene", 0);
    this.eaX = getIntent().getStringExtra("receiver_name");
    if (this.mScene == 0)
    {
      ab.e("MicroMsg.RemittanceOSRedirect", "error scene: %s", new Object[] { Integer.valueOf(this.mScene) });
      finish();
      AppMethodBeat.o(45088);
      return;
    }
    if (this.mScene == 5)
    {
      this.mNetSceneMgr.addSceneEndListener(1574);
      doSceneProgress(new z(com.tencent.mm.model.r.Zu()));
      AppMethodBeat.o(45088);
      return;
    }
    if (this.mScene == 6)
    {
      this.mNetSceneMgr.addSceneEndListener(1301);
      doSceneProgress(new com.tencent.mm.plugin.remittance.model.r(this.eaX), true);
    }
    AppMethodBeat.o(45088);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(45090);
    super.onDestroy();
    if (this.mScene == 5)
    {
      removeSceneEndListener(1574);
      AppMethodBeat.o(45090);
      return;
    }
    if (this.mScene == 6) {
      removeSceneEndListener(1301);
    }
    AppMethodBeat.o(45090);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm, boolean paramBoolean)
  {
    AppMethodBeat.i(45089);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramm instanceof z))
      {
        paramString = (z)paramm;
        ab.i("MicroMsg.RemittanceOSRedirect", "indexScene  %s", new Object[] { paramString.qkM });
        paramm = getIntent();
        if (paramString.kNE == 1) {
          com.tencent.mm.pluginsdk.wallet.h.a(this, 2, this.eaX, 11, null);
        }
        for (;;)
        {
          finish();
          AppMethodBeat.o(45089);
          return;
          paramm.setClass(this, RemittanceOSUI.class);
          paramm.putExtra("os_currency", paramString.kNE);
          paramm.putExtra("os_currencyuint", paramString.qkM);
          paramm.putExtra("os_currencywording", paramString.qkN);
          paramm.putExtra("os_notice", paramString.kNG);
          paramm.putExtra("os_notice_url", paramString.kNH);
          startActivity(paramm);
        }
      }
      if ((paramm instanceof com.tencent.mm.plugin.remittance.model.r))
      {
        paramString = (com.tencent.mm.plugin.remittance.model.r)paramm;
        paramm = new Intent();
        paramm.setClass(this, RemittanceHKUI.class);
        this.eaX = paramString.qju;
        if (bo.isNullOrNil(this.eaX))
        {
          ab.e("MicroMsg.RemittanceOSRedirect", "empty username");
          finish();
        }
        paramm.putExtra("scene", this.mScene);
        paramm.putExtra("fee", paramString.cNd / 100.0D);
        paramm.putExtra("desc", paramString.desc);
        paramm.putExtra("scan_remittance_id", paramString.qjw);
        paramm.putExtra("receiver_name", paramString.qju);
        paramm.putExtra("receiver_true_name", paramString.kNI);
        paramm.putExtra("receiver_nick_name", paramString.qjv);
        paramm.putExtra("hk_currency", paramString.kNE);
        paramm.putExtra("hk_currencyuint", paramString.kNF);
        paramm.putExtra("hk_notice", paramString.kNG);
        paramm.putExtra("hk_notice_url", paramString.kNH);
        paramInt2 = paramString.kNJ;
        paramInt1 = 32;
        ab.i("MicroMsg.RemittanceOSRedirect", "setAmount: %d", new Object[] { Integer.valueOf(paramInt2) });
        if (paramInt2 == 1) {
          paramInt1 = 33;
        }
        paramm.putExtra("pay_scene", paramInt1);
        g.RM();
        if (((j)g.E(j.class)).YA().arv(this.eaX) != null)
        {
          startActivity(paramm);
          finish();
          AppMethodBeat.o(45089);
          return;
        }
        ab.d("MicroMsg.RemittanceOSRedirect", "Receiver in contactStg and try to get contact");
        final long l = bo.aoy();
        ao.a.flI.a(this.eaX, "", new ao.b.a()
        {
          public final void p(String paramAnonymousString, boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(45085);
            if (paramAnonymousBoolean)
            {
              ab.v("MicroMsg.RemittanceOSRedirect", "getContact suc; cost=" + (bo.aoy() - l) + " ms");
              b.U(paramAnonymousString, 3);
              o.adi().qU(paramAnonymousString);
            }
            for (;;)
            {
              RemittanceOSRedirect.this.startActivity(this.val$intent);
              RemittanceOSRedirect.this.finish();
              AppMethodBeat.o(45085);
              return;
              ab.w("MicroMsg.RemittanceOSRedirect", "getContact failed");
            }
          }
        });
        AppMethodBeat.o(45089);
      }
    }
    else
    {
      if ((paramm instanceof z))
      {
        ab.i("MicroMsg.RemittanceOSRedirect", "indexScene  errMsg %s", new Object[] { paramString });
        com.tencent.mm.ui.base.h.a(this, paramString, "", new RemittanceOSRedirect.2(this));
        AppMethodBeat.o(45089);
        return;
      }
      if ((paramm instanceof com.tencent.mm.plugin.remittance.model.r)) {
        com.tencent.mm.ui.base.h.a(this, paramString, "", new RemittanceOSRedirect.3(this));
      }
    }
    AppMethodBeat.o(45089);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceOSRedirect
 * JD-Core Version:    0.7.0.1
 */