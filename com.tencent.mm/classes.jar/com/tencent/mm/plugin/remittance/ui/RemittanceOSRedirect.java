package com.tencent.mm.plugin.remittance.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.remittance.model.aa;
import com.tencent.mm.plugin.remittance.model.s;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@com.tencent.mm.ui.base.a(7)
public class RemittanceOSRedirect
  extends WalletBaseUI
{
  public String foE = "";
  private int mScene;
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(68254);
    super.onCreate(paramBundle);
    setTitleVisibility(8);
    this.mScene = getIntent().getIntExtra("scene", 0);
    this.foE = getIntent().getStringExtra("receiver_name");
    if (this.mScene == 0)
    {
      ac.e("MicroMsg.RemittanceOSRedirect", "error scene: %s", new Object[] { Integer.valueOf(this.mScene) });
      finish();
      AppMethodBeat.o(68254);
      return;
    }
    if (this.mScene == 5)
    {
      this.mNetSceneMgr.addSceneEndListener(1574);
      doSceneProgress(new aa(u.axD()));
      AppMethodBeat.o(68254);
      return;
    }
    if (this.mScene == 6)
    {
      this.mNetSceneMgr.addSceneEndListener(1301);
      doSceneProgress(new s(this.foE), true);
    }
    AppMethodBeat.o(68254);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(68256);
    super.onDestroy();
    if (this.mScene == 5)
    {
      removeSceneEndListener(1574);
      AppMethodBeat.o(68256);
      return;
    }
    if (this.mScene == 6) {
      removeSceneEndListener(1301);
    }
    AppMethodBeat.o(68256);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn, boolean paramBoolean)
  {
    AppMethodBeat.i(68255);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramn instanceof aa))
      {
        paramString = (aa)paramn;
        ac.i("MicroMsg.RemittanceOSRedirect", "indexScene  %s", new Object[] { paramString.wLV });
        paramn = getIntent();
        if (paramString.oxo == 1) {
          f.a(this, 2, this.foE, 11, null);
        }
        for (;;)
        {
          finish();
          AppMethodBeat.o(68255);
          return;
          paramn.setClass(this, RemittanceOSUI.class);
          paramn.putExtra("os_currency", paramString.oxo);
          paramn.putExtra("os_currencyuint", paramString.wLV);
          paramn.putExtra("os_currencywording", paramString.wLW);
          paramn.putExtra("os_notice", paramString.iAx);
          paramn.putExtra("os_notice_url", paramString.iAy);
          paramString = new com.tencent.mm.hellhoundlib.b.a().ba(paramn);
          com.tencent.mm.hellhoundlib.a.a.a(this, paramString.aeD(), "com/tencent/mm/plugin/remittance/ui/RemittanceOSRedirect", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)paramString.lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceOSRedirect", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
      }
      if ((paramn instanceof s))
      {
        paramString = (s)paramn;
        paramn = new Intent();
        paramn.setClass(this, RemittanceHKUI.class);
        this.foE = paramString.wKA;
        paramn.putExtra("scene", this.mScene);
        paramn.putExtra("fee", paramString.dBN / 100.0D);
        paramn.putExtra("desc", paramString.desc);
        paramn.putExtra("scan_remittance_id", paramString.wKC);
        paramn.putExtra("receiver_name", paramString.wKA);
        paramn.putExtra("receiver_true_name", paramString.oxq);
        paramn.putExtra("receiver_nick_name", paramString.wKB);
        paramn.putExtra("hk_currency", paramString.oxo);
        paramn.putExtra("hk_currencyuint", paramString.oxp);
        paramn.putExtra("hk_notice", paramString.iAx);
        paramn.putExtra("hk_notice_url", paramString.iAy);
        paramn.putExtra("recv_headimgurl", paramString.wKD);
        paramInt2 = paramString.oxr;
        paramInt1 = 32;
        ac.i("MicroMsg.RemittanceOSRedirect", "setAmount: %d", new Object[] { Integer.valueOf(paramInt2) });
        if (paramInt2 == 1) {
          paramInt1 = 33;
        }
        paramn.putExtra("pay_scene", paramInt1);
        paramString = new com.tencent.mm.hellhoundlib.b.a().ba(paramn);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramString.aeD(), "com/tencent/mm/plugin/remittance/ui/RemittanceOSRedirect", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramString.lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceOSRedirect", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        finish();
        AppMethodBeat.o(68255);
      }
    }
    else
    {
      if ((paramn instanceof aa))
      {
        ac.i("MicroMsg.RemittanceOSRedirect", "indexScene  errMsg %s", new Object[] { paramString });
        h.d(this, paramString, "", new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(68252);
            RemittanceOSRedirect.this.finish();
            AppMethodBeat.o(68252);
          }
        });
        AppMethodBeat.o(68255);
        return;
      }
      if ((paramn instanceof s)) {
        h.d(this, paramString, "", new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(68253);
            RemittanceOSRedirect.this.finish();
            AppMethodBeat.o(68253);
          }
        });
      }
    }
    AppMethodBeat.o(68255);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceOSRedirect
 * JD-Core Version:    0.7.0.1
 */