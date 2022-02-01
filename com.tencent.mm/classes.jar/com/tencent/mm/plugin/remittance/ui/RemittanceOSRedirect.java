package com.tencent.mm.plugin.remittance.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.remittance.model.aa;
import com.tencent.mm.plugin.remittance.model.s;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@com.tencent.mm.ui.base.a(7)
public class RemittanceOSRedirect
  extends WalletBaseUI
{
  public String fGM = "";
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
    this.fGM = getIntent().getStringExtra("receiver_name");
    if (this.mScene == 0)
    {
      ad.e("MicroMsg.RemittanceOSRedirect", "error scene: %s", new Object[] { Integer.valueOf(this.mScene) });
      finish();
      AppMethodBeat.o(68254);
      return;
    }
    if (this.mScene == 5)
    {
      this.mNetSceneMgr.addSceneEndListener(1574);
      doSceneProgress(new aa(u.aAt()));
      AppMethodBeat.o(68254);
      return;
    }
    if (this.mScene == 6)
    {
      this.mNetSceneMgr.addSceneEndListener(1301);
      doSceneProgress(new s(this.fGM), true);
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
        ad.i("MicroMsg.RemittanceOSRedirect", "indexScene  %s", new Object[] { paramString.xZC });
        paramn = getIntent();
        if (paramString.paJ == 1) {
          f.a(this, 2, this.fGM, 11, null);
        }
        for (;;)
        {
          finish();
          AppMethodBeat.o(68255);
          return;
          paramn.setClass(this, RemittanceOSUI.class);
          paramn.putExtra("os_currency", paramString.paJ);
          paramn.putExtra("os_currencyuint", paramString.xZC);
          paramn.putExtra("os_currencywording", paramString.xZD);
          paramn.putExtra("os_notice", paramString.iTH);
          paramn.putExtra("os_notice_url", paramString.iTI);
          paramString = new com.tencent.mm.hellhoundlib.b.a().bc(paramn);
          com.tencent.mm.hellhoundlib.a.a.a(this, paramString.ahp(), "com/tencent/mm/plugin/remittance/ui/RemittanceOSRedirect", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)paramString.mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceOSRedirect", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
      }
      if ((paramn instanceof s))
      {
        paramString = (s)paramn;
        paramn = new Intent();
        paramn.setClass(this, RemittanceHKUI.class);
        this.fGM = paramString.xYh;
        paramn.putExtra("scene", this.mScene);
        paramn.putExtra("fee", paramString.dOa / 100.0D);
        paramn.putExtra("desc", paramString.desc);
        paramn.putExtra("scan_remittance_id", paramString.xYj);
        paramn.putExtra("receiver_name", paramString.xYh);
        paramn.putExtra("receiver_true_name", paramString.paL);
        paramn.putExtra("receiver_nick_name", paramString.xYi);
        paramn.putExtra("hk_currency", paramString.paJ);
        paramn.putExtra("hk_currencyuint", paramString.paK);
        paramn.putExtra("hk_notice", paramString.iTH);
        paramn.putExtra("hk_notice_url", paramString.iTI);
        paramn.putExtra("recv_headimgurl", paramString.xYk);
        paramInt2 = paramString.paM;
        paramInt1 = 32;
        ad.i("MicroMsg.RemittanceOSRedirect", "setAmount: %d", new Object[] { Integer.valueOf(paramInt2) });
        if (paramInt2 == 1) {
          paramInt1 = 33;
        }
        paramn.putExtra("pay_scene", paramInt1);
        paramString = new com.tencent.mm.hellhoundlib.b.a().bc(paramn);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramString.ahp(), "com/tencent/mm/plugin/remittance/ui/RemittanceOSRedirect", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramString.mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceOSRedirect", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        finish();
        AppMethodBeat.o(68255);
      }
    }
    else
    {
      if ((paramn instanceof aa))
      {
        ad.i("MicroMsg.RemittanceOSRedirect", "indexScene  errMsg %s", new Object[] { paramString });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceOSRedirect
 * JD-Core Version:    0.7.0.1
 */