package com.tencent.mm.plugin.remittance.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.remittance.model.aj;
import com.tencent.mm.plugin.remittance.model.v;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.wallet_core.c.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@com.tencent.mm.ui.base.a(7)
public class RemittanceOSRedirect
  extends WalletBaseUI
{
  public String luk = "";
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
    this.luk = getIntent().getStringExtra("receiver_name");
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
      doSceneProgress(new aj(z.bAV()));
      AppMethodBeat.o(68254);
      return;
    }
    if (this.mScene == 6)
    {
      this.mNetSceneMgr.addSceneEndListener(1301);
      doSceneProgress(new v(this.luk), true);
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
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp, boolean paramBoolean)
  {
    AppMethodBeat.i(68255);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramp instanceof aj))
      {
        paramString = (aj)paramp;
        Log.i("MicroMsg.RemittanceOSRedirect", "indexScene  %s", new Object[] { paramString.OkQ });
        paramp = getIntent();
        if (paramString.wYR == 1) {
          f.a(this, 2, this.luk, 11, null);
        }
        for (;;)
        {
          finish();
          AppMethodBeat.o(68255);
          return;
          paramp.setClass(this, RemittanceOSUI.class);
          paramp.putExtra("os_currency", paramString.wYR);
          paramp.putExtra("os_currencyuint", paramString.OkQ);
          paramp.putExtra("os_currencywording", paramString.OkR);
          paramp.putExtra("os_notice", paramString.pHt);
          paramp.putExtra("os_notice_url", paramString.pHu);
          paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramp);
          com.tencent.mm.hellhoundlib.a.a.b(this, paramString.aYi(), "com/tencent/mm/plugin/remittance/ui/RemittanceOSRedirect", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)paramString.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/remittance/ui/RemittanceOSRedirect", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
      }
      if ((paramp instanceof v))
      {
        paramString = (v)paramp;
        paramp = new Intent();
        paramp.setClass(this, RemittanceHKUI.class);
        this.luk = paramString.Oji;
        paramp.putExtra("scene", this.mScene);
        paramp.putExtra("fee", paramString.ihV / 100.0D);
        paramp.putExtra("desc", paramString.desc);
        paramp.putExtra("scan_remittance_id", paramString.Ojk);
        paramp.putExtra("receiver_name", paramString.Oji);
        paramp.putExtra("receiver_true_name", paramString.wYT);
        paramp.putExtra("receiver_nick_name", paramString.Ojj);
        paramp.putExtra("hk_currency", paramString.wYR);
        paramp.putExtra("hk_currencyuint", paramString.wYS);
        paramp.putExtra("hk_notice", paramString.pHt);
        paramp.putExtra("hk_notice_url", paramString.pHu);
        paramp.putExtra("recv_headimgurl", paramString.Ojl);
        paramInt2 = paramString.wYU;
        paramInt1 = 32;
        Log.i("MicroMsg.RemittanceOSRedirect", "setAmount: %d", new Object[] { Integer.valueOf(paramInt2) });
        if (paramInt2 == 1) {
          paramInt1 = 33;
        }
        paramp.putExtra("pay_scene", paramInt1);
        paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramp);
        com.tencent.mm.hellhoundlib.a.a.b(this, paramString.aYi(), "com/tencent/mm/plugin/remittance/ui/RemittanceOSRedirect", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramString.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/remittance/ui/RemittanceOSRedirect", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        finish();
        AppMethodBeat.o(68255);
      }
    }
    else
    {
      if ((paramp instanceof aj))
      {
        Log.i("MicroMsg.RemittanceOSRedirect", "indexScene  errMsg %s", new Object[] { paramString });
        k.d(this, paramString, "", new DialogInterface.OnClickListener()
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
      if ((paramp instanceof v)) {
        k.d(this, paramString, "", new DialogInterface.OnClickListener()
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
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
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