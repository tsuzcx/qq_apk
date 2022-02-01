package com.tencent.mm.plugin.remittance.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.c;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au.a;
import com.tencent.mm.model.au.b;
import com.tencent.mm.model.au.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.remittance.model.x;
import com.tencent.mm.pluginsdk.wallet.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.f;

@com.tencent.mm.ui.base.a(7)
public class RemittanceAdapterUI
  extends WalletBaseUI
{
  public String fIQ = null;
  protected String mAppID = null;
  protected int mChannel;
  protected int mScene;
  protected boolean ypQ = false;
  protected com.tencent.mm.plugin.wallet.a ypR = null;
  
  protected void c(String paramString, int paramInt, Intent paramIntent)
  {
    AppMethodBeat.i(67949);
    ae.i("MicroMsg.RemittanceAdapterUI", "startRemittanceUI scene=" + this.mScene + ", name=" + paramString + " payScene: " + paramInt);
    if (paramIntent != null)
    {
      paramIntent = new Intent(paramIntent);
      com.tencent.mm.plugin.wallet.a.a(this.ypR, paramIntent);
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
      paramString = new com.tencent.mm.hellhoundlib.b.a().bc(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramString.ahE(), "com/tencent/mm/plugin/remittance/ui/RemittanceAdapterUI", "startRemittanceUI", "(Ljava/lang/String;ILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramString.mt(0));
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
  
  protected void dMH()
  {
    AppMethodBeat.i(67945);
    x localx = new x(this.fIQ, this.mChannel);
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
    if (!this.ypQ)
    {
      ae.d("MicroMsg.RemittanceAdapterUI", "back press not lock");
      finish();
      AppMethodBeat.o(67947);
      return;
    }
    ae.d("MicroMsg.RemittanceAdapterUI", "back press but lock");
    AppMethodBeat.o(67947);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(67944);
    super.onCreate(paramBundle);
    setContentViewVisibility(8);
    this.mScene = getIntent().getIntExtra("scene", 0);
    this.fIQ = getIntent().getStringExtra("receiver_name");
    this.mChannel = getIntent().getIntExtra("pay_channel", -1);
    this.ypR = com.tencent.mm.plugin.wallet.a.aT(getIntent());
    if (this.mChannel == 56) {
      this.mAppID = this.ypR.CNW;
    }
    if (this.mChannel == -1)
    {
      paramBundle = getProcess();
      if (paramBundle != null) {
        this.mChannel = paramBundle.dyY.getInt("pay_channel", -1);
      }
    }
    if (this.mScene == 1)
    {
      this.ypQ = true;
      dMH();
      AppMethodBeat.o(67944);
      return;
    }
    if (this.mScene == 3)
    {
      addSceneEndListener(580);
      if (getIntent() == null)
      {
        ae.d("MicroMsg.RemittanceAdapterUI", "func[doCheckPayNetscene] intent null");
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
      if (bu.isNullOrNil(this.fIQ))
      {
        ae.w("MicroMsg.RemittanceAdapterUI", "Username empty & finish. scene=" + this.mScene);
        finish();
        AppMethodBeat.o(67944);
        return;
      }
      c(this.fIQ, 31, null);
      AppMethodBeat.o(67944);
      return;
    }
    if ((this.mScene == 5) || (this.mScene == 6))
    {
      if (bu.isNullOrNil(this.fIQ))
      {
        ae.w("MicroMsg.RemittanceAdapterUI", "Username empty & finish. scene=" + this.mScene);
        finish();
        AppMethodBeat.o(67944);
        return;
      }
      paramBundle = this.fIQ;
      ae.i("MicroMsg.RemittanceAdapterUI", "startRemittanceUI scene=" + this.mScene + ", name=" + paramBundle);
      Intent localIntent = new Intent();
      com.tencent.mm.plugin.wallet.a.a(this.ypR, localIntent);
      localIntent.setClass(this, RemittanceOSRedirect.class);
      localIntent.putExtra("receiver_name", paramBundle);
      localIntent.putExtra("scene", this.mScene);
      localIntent.putExtra("pay_scene", 31);
      localIntent.putExtra("pay_channel", this.mChannel);
      paramBundle = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramBundle.ahE(), "com/tencent/mm/plugin/remittance/ui/RemittanceAdapterUI", "startRemittanceOSUI", "(Ljava/lang/String;ILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramBundle.mt(0));
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
      this.ypQ = false;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramn instanceof x))
      {
        paramString = (x)paramn;
        if ((this.mScene == 1) && (paramString.dmy == 0) && (paramString.oGc == 1))
        {
          paramn = new Intent();
          paramn.putExtra("rawUrl", paramString.oGf);
          f.an(this, paramn);
          finish();
          AppMethodBeat.o(67948);
          return true;
        }
        paramn = paramString.yoT;
        this.fIQ = paramString.username;
        if ((bu.isNullOrNil(this.fIQ)) && (bu.isNullOrNil(paramn)))
        {
          ae.d("MicroMsg.RemittanceAdapterUI", "Username empty & fishsh. scene=" + this.mScene);
          finish();
          AppMethodBeat.o(67948);
          return true;
        }
        if (this.mScene == 1)
        {
          if (paramString.scene == 33)
          {
            this.ypR = com.tencent.mm.plugin.wallet.a.fu(this.fIQ, 2);
            this.ypR.cp(20, getIntent().getStringExtra("receiver_name"));
          }
        }
        else
        {
          paramn = new Intent();
          paramn.putExtra("fee", paramString.phz);
          paramn.putExtra("desc", paramString.desc);
          paramn.putExtra("scan_remittance_id", paramString.yoK);
          paramn.putExtra("receiver_true_name", f.bak(paramString.yoJ));
          paramn.putExtra("receiver_true_name_busi", paramString.yoq);
          paramn.putExtra("receiver_tips", paramString.yoL);
          paramn.putExtra("rcvr_new_desc", paramString.yoM);
          paramn.putExtra("payer_desc", paramString.yoN);
          paramn.putExtra("rcvr_open_id", paramString.yoT);
          paramn.putExtra("mch_name", paramString.yoQ);
          paramn.putExtra("mch_info", paramString.yoW);
          paramn.putExtra("mch_photo", paramString.yoR);
          paramn.putExtra("mch_type", paramString.yoU);
          paramn.putExtra("mch_time", paramString.yoS);
          paramn.putExtra("amount_remind_bit", paramString.yoX);
          if (paramString.yoP == 1)
          {
            paramn.putExtra("busi_type", paramString.yoP);
            paramn.putExtra("rcvr_ticket", paramString.yoO);
            paramn.putExtra("rcvr_open_id", paramString.yoT);
            paramn.putExtra("get_pay_wifi", paramString.yoV);
            if (paramString.yoY != null) {
              paramn.putExtra("BusiRemittanceResp", paramString.yoY);
            }
          }
          if (this.mChannel == 56) {
            paramn.putExtra("app_id", this.mAppID);
          }
          g.ajS();
          an localan = ((l)g.ab(l.class)).azF().aUL(this.fIQ);
          c.al(this.fIQ, 3);
          if ((localan == null) && (!this.fIQ.equals(""))) {
            break label639;
          }
          c(this.fIQ, paramString.scene, paramn);
        }
        for (;;)
        {
          AppMethodBeat.o(67948);
          return true;
          this.ypR = com.tencent.mm.plugin.wallet.a.fu(this.fIQ, 3);
          this.ypR.cp(10, getIntent().getStringExtra("receiver_name"));
          break;
          label639:
          ae.d("MicroMsg.RemittanceAdapterUI", "Receiver in contactStg and try to get contact");
          final long l = bu.fpO();
          au.a.hIG.a(this.fIQ, "", new au.b.a()
          {
            public final void p(String paramAnonymousString, boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(67943);
              if (paramAnonymousBoolean)
              {
                ae.v("MicroMsg.RemittanceAdapterUI", "getContact suc; cost=" + (bu.fpO() - l) + " ms");
                c.al(paramAnonymousString, 3);
                p.aEP().Dw(paramAnonymousString);
              }
              for (;;)
              {
                RemittanceAdapterUI.this.c(RemittanceAdapterUI.this.fIQ, paramn.scene, this.ypT);
                AppMethodBeat.o(67943);
                return;
                ae.w("MicroMsg.RemittanceAdapterUI", "getContact failed");
              }
            }
          });
        }
      }
      if ((paramn instanceof com.tencent.mm.plugin.wallet_core.c.d))
      {
        e.aPm(((com.tencent.mm.plugin.wallet_core.c.d)paramn).eIm());
        c(null, 31, null);
        AppMethodBeat.o(67948);
        return true;
      }
    }
    else
    {
      setResult(0);
      h.cm(this, paramString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceAdapterUI
 * JD-Core Version:    0.7.0.1
 */