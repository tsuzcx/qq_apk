package com.tencent.mm.plugin.remittance.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.c;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ay.a;
import com.tencent.mm.model.ay.b;
import com.tencent.mm.model.ay.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.remittance.model.x;
import com.tencent.mm.pluginsdk.wallet.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.f;

@com.tencent.mm.ui.base.a(7)
public class RemittanceAdapterUI
  extends WalletBaseUI
{
  protected boolean CqH = false;
  protected com.tencent.mm.plugin.wallet.a CqI = null;
  public String goe = null;
  protected String mAppID = null;
  protected int mChannel;
  protected int mScene;
  
  protected void c(String paramString, int paramInt, Intent paramIntent)
  {
    AppMethodBeat.i(67949);
    Log.i("MicroMsg.RemittanceAdapterUI", "startRemittanceUI scene=" + this.mScene + ", name=" + paramString + " payScene: " + paramInt);
    if (paramIntent != null)
    {
      paramIntent = new Intent(paramIntent);
      com.tencent.mm.plugin.wallet.a.a(this.CqI, paramIntent);
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
      paramString = new com.tencent.mm.hellhoundlib.b.a().bl(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramString.axQ(), "com/tencent/mm/plugin/remittance/ui/RemittanceAdapterUI", "startRemittanceUI", "(Ljava/lang/String;ILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramString.pG(0));
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
  
  protected void eNH()
  {
    AppMethodBeat.i(67945);
    x localx = new x(this.goe, this.mChannel);
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
    if (!this.CqH)
    {
      Log.d("MicroMsg.RemittanceAdapterUI", "back press not lock");
      finish();
      AppMethodBeat.o(67947);
      return;
    }
    Log.d("MicroMsg.RemittanceAdapterUI", "back press but lock");
    AppMethodBeat.o(67947);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(67944);
    super.onCreate(paramBundle);
    setContentViewVisibility(8);
    this.mScene = getIntent().getIntExtra("scene", 0);
    this.goe = getIntent().getStringExtra("receiver_name");
    this.mChannel = getIntent().getIntExtra("pay_channel", -1);
    this.CqI = com.tencent.mm.plugin.wallet.a.be(getIntent());
    if (this.mChannel == 56) {
      this.mAppID = this.CqI.HsN;
    }
    if (this.mChannel == -1)
    {
      paramBundle = getProcess();
      if (paramBundle != null) {
        this.mChannel = paramBundle.dQL.getInt("pay_channel", -1);
      }
    }
    if (this.mScene == 1)
    {
      this.CqH = true;
      eNH();
      AppMethodBeat.o(67944);
      return;
    }
    if (this.mScene == 3)
    {
      addSceneEndListener(580);
      if (getIntent() == null)
      {
        Log.d("MicroMsg.RemittanceAdapterUI", "func[doCheckPayNetscene] intent null");
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
      if (Util.isNullOrNil(this.goe))
      {
        Log.w("MicroMsg.RemittanceAdapterUI", "Username empty & finish. scene=" + this.mScene);
        finish();
        AppMethodBeat.o(67944);
        return;
      }
      c(this.goe, 31, null);
      AppMethodBeat.o(67944);
      return;
    }
    if ((this.mScene == 5) || (this.mScene == 6))
    {
      if (Util.isNullOrNil(this.goe))
      {
        Log.w("MicroMsg.RemittanceAdapterUI", "Username empty & finish. scene=" + this.mScene);
        finish();
        AppMethodBeat.o(67944);
        return;
      }
      paramBundle = this.goe;
      Log.i("MicroMsg.RemittanceAdapterUI", "startRemittanceUI scene=" + this.mScene + ", name=" + paramBundle);
      Intent localIntent = new Intent();
      com.tencent.mm.plugin.wallet.a.a(this.CqI, localIntent);
      localIntent.setClass(this, RemittanceOSRedirect.class);
      localIntent.putExtra("receiver_name", paramBundle);
      localIntent.putExtra("scene", this.mScene);
      localIntent.putExtra("pay_scene", 31);
      localIntent.putExtra("pay_channel", this.mChannel);
      paramBundle = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramBundle.axQ(), "com/tencent/mm/plugin/remittance/ui/RemittanceAdapterUI", "startRemittanceOSUI", "(Ljava/lang/String;ILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramBundle.pG(0));
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
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, final q paramq)
  {
    AppMethodBeat.i(67948);
    if ((paramq instanceof x)) {
      this.CqH = false;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramq instanceof x))
      {
        paramString = (x)paramq;
        if ((this.mScene == 1) && (paramString.dDN == 0) && (paramString.pTI == 1))
        {
          paramq = new Intent();
          paramq.putExtra("rawUrl", paramString.pTL);
          f.aA(this, paramq);
          finish();
          AppMethodBeat.o(67948);
          return true;
        }
        paramq = paramString.CpJ;
        this.goe = paramString.username;
        if ((Util.isNullOrNil(this.goe)) && (Util.isNullOrNil(paramq)))
        {
          Log.d("MicroMsg.RemittanceAdapterUI", "Username empty & fishsh. scene=" + this.mScene);
          finish();
          AppMethodBeat.o(67948);
          return true;
        }
        if (this.mScene == 1)
        {
          if (paramString.scene == 33)
          {
            this.CqI = com.tencent.mm.plugin.wallet.a.fV(this.goe, 2);
            this.CqI.cG(20, getIntent().getStringExtra("receiver_name"));
          }
        }
        else
        {
          paramq = new Intent();
          paramq.putExtra("fee", paramString.qwJ);
          paramq.putExtra("desc", paramString.desc);
          paramq.putExtra("scan_remittance_id", paramString.CpA);
          paramq.putExtra("receiver_true_name", f.bps(paramString.Cpz));
          paramq.putExtra("receiver_true_name_busi", paramString.Cpg);
          paramq.putExtra("receiver_tips", paramString.CpB);
          paramq.putExtra("rcvr_new_desc", paramString.CpC);
          paramq.putExtra("payer_desc", paramString.CpD);
          paramq.putExtra("rcvr_open_id", paramString.CpJ);
          paramq.putExtra("mch_name", paramString.CpG);
          paramq.putExtra("mch_info", paramString.CpM);
          paramq.putExtra("mch_photo", paramString.CpH);
          paramq.putExtra("mch_type", paramString.CpK);
          paramq.putExtra("mch_time", paramString.CpI);
          paramq.putExtra("amount_remind_bit", paramString.CpN);
          if (paramString.CpF == 1)
          {
            paramq.putExtra("busi_type", paramString.CpF);
            paramq.putExtra("rcvr_ticket", paramString.CpE);
            paramq.putExtra("rcvr_open_id", paramString.CpJ);
            paramq.putExtra("get_pay_wifi", paramString.CpL);
            if (paramString.CpO != null) {
              paramq.putExtra("BusiRemittanceResp", paramString.CpO);
            }
          }
          if (this.mChannel == 56) {
            paramq.putExtra("app_id", this.mAppID);
          }
          g.aAi();
          as localas = ((l)g.af(l.class)).aSN().bjK(this.goe);
          c.ap(this.goe, 3);
          if ((localas == null) && (!this.goe.equals(""))) {
            break label639;
          }
          c(this.goe, paramString.scene, paramq);
        }
        for (;;)
        {
          AppMethodBeat.o(67948);
          return true;
          this.CqI = com.tencent.mm.plugin.wallet.a.fV(this.goe, 3);
          this.CqI.cG(10, getIntent().getStringExtra("receiver_name"));
          break;
          label639:
          Log.d("MicroMsg.RemittanceAdapterUI", "Receiver in contactStg and try to get contact");
          final long l = Util.nowMilliSecond();
          ay.a.iDq.a(this.goe, "", new ay.b.a()
          {
            public final void p(String paramAnonymousString, boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(67943);
              if (paramAnonymousBoolean)
              {
                Log.v("MicroMsg.RemittanceAdapterUI", "getContact suc; cost=" + (Util.nowMilliSecond() - l) + " ms");
                c.ap(paramAnonymousString, 3);
                p.aYD().Mg(paramAnonymousString);
              }
              for (;;)
              {
                RemittanceAdapterUI.this.c(RemittanceAdapterUI.this.goe, paramq.scene, this.CqK);
                AppMethodBeat.o(67943);
                return;
                Log.w("MicroMsg.RemittanceAdapterUI", "getContact failed");
              }
            }
          });
        }
      }
      if ((paramq instanceof com.tencent.mm.plugin.wallet_core.c.d))
      {
        e.bfP(((com.tencent.mm.plugin.wallet_core.c.d)paramq).fPP());
        c(null, 31, null);
        AppMethodBeat.o(67948);
        return true;
      }
    }
    else
    {
      setResult(0);
      h.cD(this, paramString);
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