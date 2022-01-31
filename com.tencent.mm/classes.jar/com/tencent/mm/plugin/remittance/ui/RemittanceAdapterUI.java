package com.tencent.mm.plugin.remittance.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.o;
import com.tencent.mm.ai.m;
import com.tencent.mm.model.ao.a;
import com.tencent.mm.model.ao.b;
import com.tencent.mm.model.ao.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.remittance.model.w;
import com.tencent.mm.plugin.wallet_core.c.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;

@com.tencent.mm.ui.base.a(7)
public class RemittanceAdapterUI
  extends WalletBaseUI
{
  public String eaX = null;
  protected int mChannel;
  protected int mScene;
  protected boolean qle = false;
  protected com.tencent.mm.plugin.wallet.a qlf = null;
  
  protected void c(String paramString, int paramInt, Intent paramIntent)
  {
    AppMethodBeat.i(44824);
    ab.i("MicroMsg.RemittanceAdapterUI", "startRemittanceUI scene=" + this.mScene + ", name=" + paramString + " payScene: " + paramInt);
    if (paramIntent != null)
    {
      paramIntent = new Intent(paramIntent);
      com.tencent.mm.plugin.wallet.a.a(this.qlf, paramIntent);
      if (paramIntent.getIntExtra("busi_type", 0) != 1) {
        break label157;
      }
      paramIntent.setClass(this, RemittanceBusiUI.class);
    }
    for (;;)
    {
      paramIntent.putExtra("receiver_name", paramString);
      paramIntent.putExtra("scene", this.mScene);
      paramIntent.putExtra("pay_scene", paramInt);
      paramIntent.putExtra("pay_channel", this.mChannel);
      startActivity(paramIntent);
      setResult(-1);
      finish();
      AppMethodBeat.o(44824);
      return;
      paramIntent = new Intent();
      break;
      label157:
      paramIntent.setClass(this, RemittanceUI.class);
    }
  }
  
  protected void che()
  {
    AppMethodBeat.i(44820);
    w localw = new w(this.eaX, this.mChannel);
    localw.setProcessName("RemittanceProcess");
    doSceneProgress(localw, true);
    AppMethodBeat.o(44820);
  }
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(44822);
    if (!this.qle)
    {
      ab.d("MicroMsg.RemittanceAdapterUI", "back press not lock");
      finish();
      AppMethodBeat.o(44822);
      return;
    }
    ab.d("MicroMsg.RemittanceAdapterUI", "back press but lock");
    AppMethodBeat.o(44822);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(44819);
    super.onCreate(paramBundle);
    setContentViewVisibility(8);
    this.mScene = getIntent().getIntExtra("scene", 0);
    this.eaX = getIntent().getStringExtra("receiver_name");
    this.mChannel = getIntent().getIntExtra("pay_channel", -1);
    this.qlf = com.tencent.mm.plugin.wallet.a.as(getIntent());
    if (this.mChannel == -1)
    {
      paramBundle = getProcess();
      if (paramBundle != null) {
        this.mChannel = paramBundle.mEJ.getInt("pay_channel", -1);
      }
    }
    if (this.mScene == 1)
    {
      this.qle = true;
      che();
      AppMethodBeat.o(44819);
      return;
    }
    if (this.mScene == 3)
    {
      addSceneEndListener(580);
      if (getIntent() == null)
      {
        ab.d("MicroMsg.RemittanceAdapterUI", "func[doCheckPayNetscene] intent null");
        setResult(0);
        finish();
        AppMethodBeat.o(44819);
        return;
      }
      paramBundle = new d(getIntent().getStringExtra("appId"), getIntent().getStringExtra("timeStamp"), getIntent().getStringExtra("nonceStr"), getIntent().getStringExtra("packageExt"), getIntent().getStringExtra("signtype"), getIntent().getStringExtra("paySignature"), getIntent().getStringExtra("url"), 3, "getTransferMoneyRequest", getIntent().getIntExtra("pay_channel", 0));
      paramBundle.setProcessName("RemittanceProcess");
      doSceneForceProgress(paramBundle);
      AppMethodBeat.o(44819);
      return;
    }
    if (this.mScene == 2)
    {
      if (bo.isNullOrNil(this.eaX))
      {
        ab.w("MicroMsg.RemittanceAdapterUI", "Username empty & finish. scene=" + this.mScene);
        finish();
        AppMethodBeat.o(44819);
        return;
      }
      c(this.eaX, 31, null);
      AppMethodBeat.o(44819);
      return;
    }
    if ((this.mScene == 5) || (this.mScene == 6))
    {
      if (bo.isNullOrNil(this.eaX))
      {
        ab.w("MicroMsg.RemittanceAdapterUI", "Username empty & finish. scene=" + this.mScene);
        finish();
        AppMethodBeat.o(44819);
        return;
      }
      paramBundle = this.eaX;
      ab.i("MicroMsg.RemittanceAdapterUI", "startRemittanceUI scene=" + this.mScene + ", name=" + paramBundle);
      Intent localIntent = new Intent();
      com.tencent.mm.plugin.wallet.a.a(this.qlf, localIntent);
      localIntent.setClass(this, RemittanceOSRedirect.class);
      localIntent.putExtra("receiver_name", paramBundle);
      localIntent.putExtra("scene", this.mScene);
      localIntent.putExtra("pay_scene", 31);
      localIntent.putExtra("pay_channel", this.mChannel);
      startActivity(localIntent);
      setResult(-1);
      finish();
      AppMethodBeat.o(44819);
      return;
    }
    c(null, 31, null);
    AppMethodBeat.o(44819);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(44821);
    if (this.mScene == 3) {
      removeSceneEndListener(580);
    }
    super.onDestroy();
    AppMethodBeat.o(44821);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, final m paramm)
  {
    AppMethodBeat.i(44823);
    if ((paramm instanceof w)) {
      this.qle = false;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramm instanceof w))
      {
        paramString = (w)paramm;
        paramm = paramString.qkn;
        this.eaX = paramString.username;
        if ((bo.isNullOrNil(this.eaX)) && (bo.isNullOrNil(paramm)))
        {
          ab.d("MicroMsg.RemittanceAdapterUI", "Username empty & fishsh. scene=" + this.mScene);
          finish();
          AppMethodBeat.o(44823);
          return true;
        }
        if (this.mScene == 1)
        {
          if (paramString.scene == 33)
          {
            this.qlf = com.tencent.mm.plugin.wallet.a.dC(this.eaX, 2);
            this.qlf.bs(20, getIntent().getStringExtra("receiver_name"));
          }
        }
        else
        {
          paramm = new Intent();
          paramm.putExtra("fee", paramString.kNS);
          paramm.putExtra("desc", paramString.desc);
          paramm.putExtra("scan_remittance_id", paramString.qke);
          paramm.putExtra("receiver_true_name", e.awc(paramString.qkd));
          paramm.putExtra("receiver_true_name_busi", paramString.qjK);
          paramm.putExtra("receiver_tips", paramString.qkf);
          paramm.putExtra("rcvr_new_desc", paramString.qkg);
          paramm.putExtra("payer_desc", paramString.qkh);
          paramm.putExtra("rcvr_open_id", paramString.qkn);
          paramm.putExtra("mch_name", paramString.qkk);
          paramm.putExtra("mch_info", paramString.qkq);
          paramm.putExtra("mch_photo", paramString.qkl);
          paramm.putExtra("mch_type", paramString.qko);
          paramm.putExtra("mch_time", paramString.qkm);
          paramm.putExtra("amount_remind_bit", paramString.qkr);
          if (paramString.qkj == 1)
          {
            paramm.putExtra("busi_type", paramString.qkj);
            paramm.putExtra("rcvr_ticket", paramString.qki);
            paramm.putExtra("rcvr_open_id", paramString.qkn);
            paramm.putExtra("get_pay_wifi", paramString.qkp);
            if (paramString.qks != null) {
              paramm.putExtra("BusiRemittanceResp", paramString.qks);
            }
          }
          com.tencent.mm.kernel.g.RM();
          ad localad = ((j)com.tencent.mm.kernel.g.E(j.class)).YA().arv(this.eaX);
          b.U(this.eaX, 3);
          if ((localad == null) && (!this.eaX.equals(""))) {
            break label550;
          }
          c(this.eaX, paramString.scene, paramm);
        }
        for (;;)
        {
          AppMethodBeat.o(44823);
          return true;
          this.qlf = com.tencent.mm.plugin.wallet.a.dC(this.eaX, 3);
          this.qlf.bs(10, getIntent().getStringExtra("receiver_name"));
          break;
          label550:
          ab.d("MicroMsg.RemittanceAdapterUI", "Receiver in contactStg and try to get contact");
          final long l = bo.aoy();
          ao.a.flI.a(this.eaX, "", new ao.b.a()
          {
            public final void p(String paramAnonymousString, boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(44818);
              if (paramAnonymousBoolean)
              {
                ab.v("MicroMsg.RemittanceAdapterUI", "getContact suc; cost=" + (bo.aoy() - l) + " ms");
                b.U(paramAnonymousString, 3);
                o.adi().qU(paramAnonymousString);
              }
              for (;;)
              {
                RemittanceAdapterUI.this.c(RemittanceAdapterUI.this.eaX, paramm.scene, this.qlh);
                AppMethodBeat.o(44818);
                return;
                ab.w("MicroMsg.RemittanceAdapterUI", "getContact failed");
              }
            }
          });
        }
      }
      if ((paramm instanceof d))
      {
        com.tencent.mm.pluginsdk.wallet.g.ana(((d)paramm).cSW());
        c(null, 31, null);
        AppMethodBeat.o(44823);
        return true;
      }
    }
    else
    {
      setResult(0);
      h.bO(this, paramString);
      finish();
      AppMethodBeat.o(44823);
      return true;
    }
    AppMethodBeat.o(44823);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceAdapterUI
 * JD-Core Version:    0.7.0.1
 */