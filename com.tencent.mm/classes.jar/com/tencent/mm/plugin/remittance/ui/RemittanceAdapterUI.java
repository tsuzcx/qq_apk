package com.tencent.mm.plugin.remittance.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.c;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.b;
import com.tencent.mm.model.ar.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.remittance.model.x;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@com.tencent.mm.ui.base.a(7)
public class RemittanceAdapterUI
  extends WalletBaseUI
{
  public String foE = null;
  protected String mAppID = null;
  protected int mChannel;
  protected int mScene;
  protected boolean wMr = false;
  protected com.tencent.mm.plugin.wallet.a wMs = null;
  
  protected void c(String paramString, int paramInt, Intent paramIntent)
  {
    AppMethodBeat.i(67949);
    ac.i("MicroMsg.RemittanceAdapterUI", "startRemittanceUI scene=" + this.mScene + ", name=" + paramString + " payScene: " + paramInt);
    if (paramIntent != null)
    {
      paramIntent = new Intent(paramIntent);
      com.tencent.mm.plugin.wallet.a.a(this.wMs, paramIntent);
      if (paramIntent.getIntExtra("busi_type", 0) != 1) {
        break label212;
      }
      paramIntent.setClass(this, RemittanceBusiUI.class);
    }
    for (;;)
    {
      paramIntent.putExtra("receiver_name", paramString);
      paramIntent.putExtra("scene", this.mScene);
      paramIntent.putExtra("pay_scene", paramInt);
      paramIntent.putExtra("pay_channel", this.mChannel);
      paramString = new com.tencent.mm.hellhoundlib.b.a().ba(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramString.aeD(), "com/tencent/mm/plugin/remittance/ui/RemittanceAdapterUI", "startRemittanceUI", "(Ljava/lang/String;ILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramString.lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceAdapterUI", "startRemittanceUI", "(Ljava/lang/String;ILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      setResult(-1);
      finish();
      AppMethodBeat.o(67949);
      return;
      paramIntent = new Intent();
      break;
      label212:
      paramIntent.setClass(this, RemittanceUI.class);
    }
  }
  
  protected void dxX()
  {
    AppMethodBeat.i(67945);
    x localx = new x(this.foE, this.mChannel);
    localx.setProcessName("RemittanceProcess");
    doSceneProgress(localx, true);
    AppMethodBeat.o(67945);
  }
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(67947);
    if (!this.wMr)
    {
      ac.d("MicroMsg.RemittanceAdapterUI", "back press not lock");
      finish();
      AppMethodBeat.o(67947);
      return;
    }
    ac.d("MicroMsg.RemittanceAdapterUI", "back press but lock");
    AppMethodBeat.o(67947);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(67944);
    super.onCreate(paramBundle);
    setContentViewVisibility(8);
    this.mScene = getIntent().getIntExtra("scene", 0);
    this.foE = getIntent().getStringExtra("receiver_name");
    this.mChannel = getIntent().getIntExtra("pay_channel", -1);
    this.wMs = com.tencent.mm.plugin.wallet.a.aN(getIntent());
    if (this.mChannel == 56) {
      this.mAppID = this.wMs.AWj;
    }
    if (this.mChannel == -1)
    {
      paramBundle = getProcess();
      if (paramBundle != null) {
        this.mChannel = paramBundle.dmf.getInt("pay_channel", -1);
      }
    }
    if (this.mScene == 1)
    {
      this.wMr = true;
      dxX();
      AppMethodBeat.o(67944);
      return;
    }
    if (this.mScene == 3)
    {
      addSceneEndListener(580);
      if (getIntent() == null)
      {
        ac.d("MicroMsg.RemittanceAdapterUI", "func[doCheckPayNetscene] intent null");
        setResult(0);
        finish();
        AppMethodBeat.o(67944);
        return;
      }
      paramBundle = new com.tencent.mm.plugin.wallet_core.c.d(getIntent().getStringExtra("appId"), getIntent().getStringExtra("timeStamp"), getIntent().getStringExtra("nonceStr"), getIntent().getStringExtra("packageExt"), getIntent().getStringExtra("signtype"), getIntent().getStringExtra("paySignature"), getIntent().getStringExtra("url"), 3, "getTransferMoneyRequest", getIntent().getIntExtra("pay_channel", 0));
      paramBundle.setProcessName("RemittanceProcess");
      doSceneForceProgress(paramBundle);
      AppMethodBeat.o(67944);
      return;
    }
    if (this.mScene == 2)
    {
      if (bs.isNullOrNil(this.foE))
      {
        ac.w("MicroMsg.RemittanceAdapterUI", "Username empty & finish. scene=" + this.mScene);
        finish();
        AppMethodBeat.o(67944);
        return;
      }
      c(this.foE, 31, null);
      AppMethodBeat.o(67944);
      return;
    }
    if ((this.mScene == 5) || (this.mScene == 6))
    {
      if (bs.isNullOrNil(this.foE))
      {
        ac.w("MicroMsg.RemittanceAdapterUI", "Username empty & finish. scene=" + this.mScene);
        finish();
        AppMethodBeat.o(67944);
        return;
      }
      paramBundle = this.foE;
      ac.i("MicroMsg.RemittanceAdapterUI", "startRemittanceUI scene=" + this.mScene + ", name=" + paramBundle);
      Intent localIntent = new Intent();
      com.tencent.mm.plugin.wallet.a.a(this.wMs, localIntent);
      localIntent.setClass(this, RemittanceOSRedirect.class);
      localIntent.putExtra("receiver_name", paramBundle);
      localIntent.putExtra("scene", this.mScene);
      localIntent.putExtra("pay_scene", 31);
      localIntent.putExtra("pay_channel", this.mChannel);
      paramBundle = new com.tencent.mm.hellhoundlib.b.a().ba(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramBundle.aeD(), "com/tencent/mm/plugin/remittance/ui/RemittanceAdapterUI", "startRemittanceOSUI", "(Ljava/lang/String;ILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramBundle.lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceAdapterUI", "startRemittanceOSUI", "(Ljava/lang/String;ILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      setResult(-1);
      finish();
      AppMethodBeat.o(67944);
      return;
    }
    c(null, 31, null);
    AppMethodBeat.o(67944);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(67946);
    if (this.mScene == 3) {
      removeSceneEndListener(580);
    }
    super.onDestroy();
    AppMethodBeat.o(67946);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, final n paramn)
  {
    AppMethodBeat.i(67948);
    if ((paramn instanceof x)) {
      this.wMr = false;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramn instanceof x))
      {
        paramString = (x)paramn;
        if ((this.mScene == 1) && (paramString.dae == 0) && (paramString.nWg == 1))
        {
          paramn = new Intent();
          paramn.putExtra("rawUrl", paramString.nWj);
          com.tencent.mm.wallet_core.ui.e.al(this, paramn);
          finish();
          AppMethodBeat.o(67948);
          return true;
        }
        paramn = paramString.wLu;
        this.foE = paramString.username;
        if ((bs.isNullOrNil(this.foE)) && (bs.isNullOrNil(paramn)))
        {
          ac.d("MicroMsg.RemittanceAdapterUI", "Username empty & fishsh. scene=" + this.mScene);
          finish();
          AppMethodBeat.o(67948);
          return true;
        }
        if (this.mScene == 1)
        {
          if (paramString.scene == 33)
          {
            this.wMs = com.tencent.mm.plugin.wallet.a.eS(this.foE, 2);
            this.wMs.ch(20, getIntent().getStringExtra("receiver_name"));
          }
        }
        else
        {
          paramn = new Intent();
          paramn.putExtra("fee", paramString.oxA);
          paramn.putExtra("desc", paramString.desc);
          paramn.putExtra("scan_remittance_id", paramString.wLl);
          paramn.putExtra("receiver_true_name", com.tencent.mm.wallet_core.ui.e.aSI(paramString.wLk));
          paramn.putExtra("receiver_true_name_busi", paramString.wKR);
          paramn.putExtra("receiver_tips", paramString.wLm);
          paramn.putExtra("rcvr_new_desc", paramString.wLn);
          paramn.putExtra("payer_desc", paramString.wLo);
          paramn.putExtra("rcvr_open_id", paramString.wLu);
          paramn.putExtra("mch_name", paramString.wLr);
          paramn.putExtra("mch_info", paramString.wLx);
          paramn.putExtra("mch_photo", paramString.wLs);
          paramn.putExtra("mch_type", paramString.wLv);
          paramn.putExtra("mch_time", paramString.wLt);
          paramn.putExtra("amount_remind_bit", paramString.wLy);
          if (paramString.wLq == 1)
          {
            paramn.putExtra("busi_type", paramString.wLq);
            paramn.putExtra("rcvr_ticket", paramString.wLp);
            paramn.putExtra("rcvr_open_id", paramString.wLu);
            paramn.putExtra("get_pay_wifi", paramString.wLw);
            if (paramString.wLz != null) {
              paramn.putExtra("BusiRemittanceResp", paramString.wLz);
            }
          }
          if (this.mChannel == 56) {
            paramn.putExtra("app_id", this.mAppID);
          }
          g.agS();
          ai localai = ((k)g.ab(k.class)).awB().aNs(this.foE);
          c.ag(this.foE, 3);
          if ((localai == null) && (!this.foE.equals(""))) {
            break label639;
          }
          c(this.foE, paramString.scene, paramn);
        }
        for (;;)
        {
          AppMethodBeat.o(67948);
          return true;
          this.wMs = com.tencent.mm.plugin.wallet.a.eS(this.foE, 3);
          this.wMs.ch(10, getIntent().getStringExtra("receiver_name"));
          break;
          label639:
          ac.d("MicroMsg.RemittanceAdapterUI", "Receiver in contactStg and try to get contact");
          final long l = bs.eWj();
          ar.a.hnw.a(this.foE, "", new ar.b.a()
          {
            public final void p(String paramAnonymousString, boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(67943);
              if (paramAnonymousBoolean)
              {
                ac.v("MicroMsg.RemittanceAdapterUI", "getContact suc; cost=" + (bs.eWj() - l) + " ms");
                c.ag(paramAnonymousString, 3);
                p.aBy().zV(paramAnonymousString);
              }
              for (;;)
              {
                RemittanceAdapterUI.this.c(RemittanceAdapterUI.this.foE, paramn.scene, this.wMu);
                AppMethodBeat.o(67943);
                return;
                ac.w("MicroMsg.RemittanceAdapterUI", "getContact failed");
              }
            }
          });
        }
      }
      if ((paramn instanceof com.tencent.mm.plugin.wallet_core.c.d))
      {
        com.tencent.mm.pluginsdk.wallet.e.aIm(((com.tencent.mm.plugin.wallet_core.c.d)paramn).eqF());
        c(null, 31, null);
        AppMethodBeat.o(67948);
        return true;
      }
    }
    else
    {
      setResult(0);
      h.cg(this, paramString);
      finish();
      AppMethodBeat.o(67948);
      return true;
    }
    AppMethodBeat.o(67948);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceAdapterUI
 * JD-Core Version:    0.7.0.1
 */