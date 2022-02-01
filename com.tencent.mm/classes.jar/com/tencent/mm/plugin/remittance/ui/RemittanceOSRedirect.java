package com.tencent.mm.plugin.remittance.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.remittance.model.aa;
import com.tencent.mm.plugin.remittance.model.s;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@com.tencent.mm.ui.base.a(7)
public class RemittanceOSRedirect
  extends WalletBaseUI
{
  public String goe = "";
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
    this.goe = getIntent().getStringExtra("receiver_name");
    if (this.mScene == 0)
    {
      Log.e("MicroMsg.RemittanceOSRedirect", "error scene: %s", new Object[] { Integer.valueOf(this.mScene) });
      finish();
      AppMethodBeat.o(68254);
      return;
    }
    if (this.mScene == 5)
    {
      this.mNetSceneMgr.addSceneEndListener(1574);
      doSceneProgress(new aa(z.aUf()));
      AppMethodBeat.o(68254);
      return;
    }
    if (this.mScene == 6)
    {
      this.mNetSceneMgr.addSceneEndListener(1301);
      doSceneProgress(new s(this.goe), true);
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
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq, boolean paramBoolean)
  {
    AppMethodBeat.i(68255);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramq instanceof aa))
      {
        paramString = (aa)paramq;
        Log.i("MicroMsg.RemittanceOSRedirect", "indexScene  %s", new Object[] { paramString.Cql });
        paramq = getIntent();
        if (paramString.qww == 1) {
          f.a(this, 2, this.goe, 11, null);
        }
        for (;;)
        {
          finish();
          AppMethodBeat.o(68255);
          return;
          paramq.setClass(this, RemittanceOSUI.class);
          paramq.putExtra("os_currency", paramString.qww);
          paramq.putExtra("os_currencyuint", paramString.Cql);
          paramq.putExtra("os_currencywording", paramString.Cqm);
          paramq.putExtra("os_notice", paramString.jTx);
          paramq.putExtra("os_notice_url", paramString.jTy);
          paramString = new com.tencent.mm.hellhoundlib.b.a().bl(paramq);
          com.tencent.mm.hellhoundlib.a.a.a(this, paramString.axQ(), "com/tencent/mm/plugin/remittance/ui/RemittanceOSRedirect", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)paramString.pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceOSRedirect", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
      }
      if ((paramq instanceof s))
      {
        paramString = (s)paramq;
        paramq = new Intent();
        paramq.setClass(this, RemittanceHKUI.class);
        this.goe = paramString.CoP;
        paramq.putExtra("scene", this.mScene);
        paramq.putExtra("fee", paramString.eht / 100.0D);
        paramq.putExtra("desc", paramString.desc);
        paramq.putExtra("scan_remittance_id", paramString.CoR);
        paramq.putExtra("receiver_name", paramString.CoP);
        paramq.putExtra("receiver_true_name", paramString.qwy);
        paramq.putExtra("receiver_nick_name", paramString.CoQ);
        paramq.putExtra("hk_currency", paramString.qww);
        paramq.putExtra("hk_currencyuint", paramString.qwx);
        paramq.putExtra("hk_notice", paramString.jTx);
        paramq.putExtra("hk_notice_url", paramString.jTy);
        paramq.putExtra("recv_headimgurl", paramString.CoS);
        paramInt2 = paramString.qwz;
        paramInt1 = 32;
        Log.i("MicroMsg.RemittanceOSRedirect", "setAmount: %d", new Object[] { Integer.valueOf(paramInt2) });
        if (paramInt2 == 1) {
          paramInt1 = 33;
        }
        paramq.putExtra("pay_scene", paramInt1);
        paramString = new com.tencent.mm.hellhoundlib.b.a().bl(paramq);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramString.axQ(), "com/tencent/mm/plugin/remittance/ui/RemittanceOSRedirect", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramString.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceOSRedirect", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        finish();
        AppMethodBeat.o(68255);
      }
    }
    else
    {
      if ((paramq instanceof aa))
      {
        Log.i("MicroMsg.RemittanceOSRedirect", "indexScene  errMsg %s", new Object[] { paramString });
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
      if ((paramq instanceof s)) {
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
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
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