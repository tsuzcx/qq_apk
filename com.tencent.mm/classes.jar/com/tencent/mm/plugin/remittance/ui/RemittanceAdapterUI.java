package com.tencent.mm.plugin.remittance.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.p;
import com.tencent.mm.al.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.as.a;
import com.tencent.mm.model.as.b;
import com.tencent.mm.model.as.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.remittance.model.x;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@com.tencent.mm.ui.base.a(7)
public class RemittanceAdapterUI
  extends WalletBaseUI
{
  public String fGM = null;
  protected String mAppID = null;
  protected int mChannel;
  protected int mScene;
  protected boolean xZY = false;
  protected com.tencent.mm.plugin.wallet.a xZZ = null;
  
  protected void c(String paramString, int paramInt, Intent paramIntent)
  {
    AppMethodBeat.i(67949);
    ad.i("MicroMsg.RemittanceAdapterUI", "startRemittanceUI scene=" + this.mScene + ", name=" + paramString + " payScene: " + paramInt);
    if (paramIntent != null)
    {
      paramIntent = new Intent(paramIntent);
      com.tencent.mm.plugin.wallet.a.a(this.xZZ, paramIntent);
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
      com.tencent.mm.hellhoundlib.a.a.a(this, paramString.ahp(), "com/tencent/mm/plugin/remittance/ui/RemittanceAdapterUI", "startRemittanceUI", "(Ljava/lang/String;ILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramString.mq(0));
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
  
  protected void dJp()
  {
    AppMethodBeat.i(67945);
    x localx = new x(this.fGM, this.mChannel);
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
    if (!this.xZY)
    {
      ad.d("MicroMsg.RemittanceAdapterUI", "back press not lock");
      finish();
      AppMethodBeat.o(67947);
      return;
    }
    ad.d("MicroMsg.RemittanceAdapterUI", "back press but lock");
    AppMethodBeat.o(67947);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(67944);
    super.onCreate(paramBundle);
    setContentViewVisibility(8);
    this.mScene = getIntent().getIntExtra("scene", 0);
    this.fGM = getIntent().getStringExtra("receiver_name");
    this.mChannel = getIntent().getIntExtra("pay_channel", -1);
    this.xZZ = com.tencent.mm.plugin.wallet.a.aS(getIntent());
    if (this.mChannel == 56) {
      this.mAppID = this.xZZ.Cwr;
    }
    if (this.mChannel == -1)
    {
      paramBundle = getProcess();
      if (paramBundle != null) {
        this.mChannel = paramBundle.dxT.getInt("pay_channel", -1);
      }
    }
    if (this.mScene == 1)
    {
      this.xZY = true;
      dJp();
      AppMethodBeat.o(67944);
      return;
    }
    if (this.mScene == 3)
    {
      addSceneEndListener(580);
      if (getIntent() == null)
      {
        ad.d("MicroMsg.RemittanceAdapterUI", "func[doCheckPayNetscene] intent null");
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
      if (bt.isNullOrNil(this.fGM))
      {
        ad.w("MicroMsg.RemittanceAdapterUI", "Username empty & finish. scene=" + this.mScene);
        finish();
        AppMethodBeat.o(67944);
        return;
      }
      c(this.fGM, 31, null);
      AppMethodBeat.o(67944);
      return;
    }
    if ((this.mScene == 5) || (this.mScene == 6))
    {
      if (bt.isNullOrNil(this.fGM))
      {
        ad.w("MicroMsg.RemittanceAdapterUI", "Username empty & finish. scene=" + this.mScene);
        finish();
        AppMethodBeat.o(67944);
        return;
      }
      paramBundle = this.fGM;
      ad.i("MicroMsg.RemittanceAdapterUI", "startRemittanceUI scene=" + this.mScene + ", name=" + paramBundle);
      Intent localIntent = new Intent();
      com.tencent.mm.plugin.wallet.a.a(this.xZZ, localIntent);
      localIntent.setClass(this, RemittanceOSRedirect.class);
      localIntent.putExtra("receiver_name", paramBundle);
      localIntent.putExtra("scene", this.mScene);
      localIntent.putExtra("pay_scene", 31);
      localIntent.putExtra("pay_channel", this.mChannel);
      paramBundle = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramBundle.ahp(), "com/tencent/mm/plugin/remittance/ui/RemittanceAdapterUI", "startRemittanceOSUI", "(Ljava/lang/String;ILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramBundle.mq(0));
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
      this.xZY = false;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramn instanceof x))
      {
        paramString = (x)paramn;
        if ((this.mScene == 1) && (paramString.dlw == 0) && (paramString.ozA == 1))
        {
          paramn = new Intent();
          paramn.putExtra("rawUrl", paramString.ozD);
          com.tencent.mm.wallet_core.ui.e.an(this, paramn);
          finish();
          AppMethodBeat.o(67948);
          return true;
        }
        paramn = paramString.xZb;
        this.fGM = paramString.username;
        if ((bt.isNullOrNil(this.fGM)) && (bt.isNullOrNil(paramn)))
        {
          ad.d("MicroMsg.RemittanceAdapterUI", "Username empty & fishsh. scene=" + this.mScene);
          finish();
          AppMethodBeat.o(67948);
          return true;
        }
        if (this.mScene == 1)
        {
          if (paramString.scene == 33)
          {
            this.xZZ = com.tencent.mm.plugin.wallet.a.fl(this.fGM, 2);
            this.xZZ.cp(20, getIntent().getStringExtra("receiver_name"));
          }
        }
        else
        {
          paramn = new Intent();
          paramn.putExtra("fee", paramString.paV);
          paramn.putExtra("desc", paramString.desc);
          paramn.putExtra("scan_remittance_id", paramString.xYS);
          paramn.putExtra("receiver_true_name", com.tencent.mm.wallet_core.ui.e.aYH(paramString.xYR));
          paramn.putExtra("receiver_true_name_busi", paramString.xYy);
          paramn.putExtra("receiver_tips", paramString.xYT);
          paramn.putExtra("rcvr_new_desc", paramString.xYU);
          paramn.putExtra("payer_desc", paramString.xYV);
          paramn.putExtra("rcvr_open_id", paramString.xZb);
          paramn.putExtra("mch_name", paramString.xYY);
          paramn.putExtra("mch_info", paramString.xZe);
          paramn.putExtra("mch_photo", paramString.xYZ);
          paramn.putExtra("mch_type", paramString.xZc);
          paramn.putExtra("mch_time", paramString.xZa);
          paramn.putExtra("amount_remind_bit", paramString.xZf);
          if (paramString.xYX == 1)
          {
            paramn.putExtra("busi_type", paramString.xYX);
            paramn.putExtra("rcvr_ticket", paramString.xYW);
            paramn.putExtra("rcvr_open_id", paramString.xZb);
            paramn.putExtra("get_pay_wifi", paramString.xZd);
            if (paramString.xZg != null) {
              paramn.putExtra("BusiRemittanceResp", paramString.xZg);
            }
          }
          if (this.mChannel == 56) {
            paramn.putExtra("app_id", this.mAppID);
          }
          g.ajD();
          am localam = ((l)g.ab(l.class)).azp().aTk(this.fGM);
          c.ak(this.fGM, 3);
          if ((localam == null) && (!this.fGM.equals(""))) {
            break label639;
          }
          c(this.fGM, paramString.scene, paramn);
        }
        for (;;)
        {
          AppMethodBeat.o(67948);
          return true;
          this.xZZ = com.tencent.mm.plugin.wallet.a.fl(this.fGM, 3);
          this.xZZ.cp(10, getIntent().getStringExtra("receiver_name"));
          break;
          label639:
          ad.d("MicroMsg.RemittanceAdapterUI", "Receiver in contactStg and try to get contact");
          final long l = bt.flT();
          as.a.hFO.a(this.fGM, "", new as.b.a()
          {
            public final void p(String paramAnonymousString, boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(67943);
              if (paramAnonymousBoolean)
              {
                ad.v("MicroMsg.RemittanceAdapterUI", "getContact suc; cost=" + (bt.flT() - l) + " ms");
                c.ak(paramAnonymousString, 3);
                p.aEz().CU(paramAnonymousString);
              }
              for (;;)
              {
                RemittanceAdapterUI.this.c(RemittanceAdapterUI.this.fGM, paramn.scene, this.yab);
                AppMethodBeat.o(67943);
                return;
                ad.w("MicroMsg.RemittanceAdapterUI", "getContact failed");
              }
            }
          });
        }
      }
      if ((paramn instanceof com.tencent.mm.plugin.wallet_core.c.d))
      {
        com.tencent.mm.pluginsdk.wallet.e.aNP(((com.tencent.mm.plugin.wallet_core.c.d)paramn).eEF());
        c(null, 31, null);
        AppMethodBeat.o(67948);
        return true;
      }
    }
    else
    {
      setResult(0);
      h.cl(this, paramString);
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