package com.tencent.mm.plugin.remittance.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.model.az.b.a;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyExclusiveSelectContactUI;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.remittance.model.af;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.g;

@com.tencent.mm.ui.base.a(7)
public class RemittanceAdapterUI
  extends WalletBaseUI
{
  protected boolean Iog = false;
  protected com.tencent.mm.plugin.wallet.a Ioh = null;
  public String iSn = null;
  protected String mAppID = null;
  protected int mChannel;
  protected int mScene;
  
  protected void a(String paramString, int paramInt, Intent paramIntent)
  {
    AppMethodBeat.i(67949);
    Log.i("MicroMsg.RemittanceAdapterUI", "startRemittanceUI scene=" + this.mScene + ", name=" + paramString + " payScene: " + paramInt);
    if (paramIntent != null)
    {
      paramIntent = new Intent(paramIntent);
      com.tencent.mm.plugin.wallet.a.a(this.Ioh, paramIntent);
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
      paramString = new com.tencent.mm.hellhoundlib.b.a().bm(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramString.aFh(), "com/tencent/mm/plugin/remittance/ui/RemittanceAdapterUI", "startRemittanceUI", "(Ljava/lang/String;ILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramString.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/remittance/ui/RemittanceAdapterUI", "startRemittanceUI", "(Ljava/lang/String;ILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
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
  
  protected void fAx()
  {
    AppMethodBeat.i(67945);
    af localaf = new af(this.iSn, this.mChannel);
    localaf.setProcessName("RemittanceProcess");
    doSceneProgress(localaf, true);
    AppMethodBeat.o(67945);
  }
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(269923);
    if (paramInt1 == 16)
    {
      if (paramInt2 == -1)
      {
        paramIntent = paramIntent.getStringExtra("Select_Contact");
        Log.i("MicroMsg.RemittanceAdapterUI", "select user: %s", new Object[] { paramIntent });
        if (!Util.isNullOrNil(paramIntent))
        {
          Intent localIntent = new Intent();
          localIntent.putExtra("key_group_name", this.iSn);
          a(paramIntent, 31, localIntent);
          AppMethodBeat.o(269923);
          return;
        }
        finish();
        AppMethodBeat.o(269923);
        return;
      }
      finish();
      AppMethodBeat.o(269923);
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(269923);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(67947);
    if (!this.Iog)
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
    this.iSn = getIntent().getStringExtra("receiver_name");
    this.mChannel = getIntent().getIntExtra("pay_channel", -1);
    this.Ioh = com.tencent.mm.plugin.wallet.a.be(getIntent());
    if (this.mChannel == 56) {
      this.mAppID = this.Ioh.Oky;
    }
    if (this.mChannel == -1)
    {
      paramBundle = getProcess();
      if (paramBundle != null) {
        this.mChannel = paramBundle.fKb.getInt("pay_channel", -1);
      }
    }
    if (this.mScene == 1)
    {
      this.Iog = true;
      fAx();
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
      if (Util.isNullOrNil(this.iSn))
      {
        Log.w("MicroMsg.RemittanceAdapterUI", "Username empty & finish. scene=" + this.mScene);
        finish();
        AppMethodBeat.o(67944);
        return;
      }
      if (ab.Lj(this.iSn))
      {
        Log.i("MicroMsg.RemittanceAdapterUI", "do select a contact: %s", new Object[] { this.iSn });
        paramBundle = new Intent(this, LuckyMoneyExclusiveSelectContactUI.class);
        paramBundle.putExtra("chatroomName", this.iSn);
        paramBundle.putExtra("key_title", getString(a.i.remittance_select_contact_title));
        paramBundle.putExtra("key_same_name_tips", a.i.remittance_select_contact_same_displayname_tips);
        startActivityForResult(paramBundle, 16);
        AppMethodBeat.o(67944);
        return;
      }
      a(this.iSn, 31, null);
      AppMethodBeat.o(67944);
      return;
    }
    if ((this.mScene == 5) || (this.mScene == 6))
    {
      if (Util.isNullOrNil(this.iSn))
      {
        Log.w("MicroMsg.RemittanceAdapterUI", "Username empty & finish. scene=" + this.mScene);
        finish();
        AppMethodBeat.o(67944);
        return;
      }
      paramBundle = this.iSn;
      Log.i("MicroMsg.RemittanceAdapterUI", "startRemittanceUI scene=" + this.mScene + ", name=" + paramBundle);
      Intent localIntent = new Intent();
      com.tencent.mm.plugin.wallet.a.a(this.Ioh, localIntent);
      localIntent.setClass(this, RemittanceOSRedirect.class);
      localIntent.putExtra("receiver_name", paramBundle);
      localIntent.putExtra("scene", this.mScene);
      localIntent.putExtra("pay_scene", 31);
      localIntent.putExtra("pay_channel", this.mChannel);
      paramBundle = new com.tencent.mm.hellhoundlib.b.a().bm(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramBundle.aFh(), "com/tencent/mm/plugin/remittance/ui/RemittanceAdapterUI", "startRemittanceOSUI", "(Ljava/lang/String;ILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramBundle.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/remittance/ui/RemittanceAdapterUI", "startRemittanceOSUI", "(Ljava/lang/String;ILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      setResult(-1);
      finish();
      AppMethodBeat.o(67944);
      return;
    }
    a(null, 31, null);
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
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, final com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(67948);
    if ((paramq instanceof af)) {
      this.Iog = false;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramq instanceof af))
      {
        paramString = (af)paramq;
        if ((this.mScene == 1) && (paramString.fwx == 0) && (paramString.tpK == 1))
        {
          paramq = new Intent();
          paramq.putExtra("rawUrl", paramString.jump_url);
          g.aJ(this, paramq);
          finish();
          AppMethodBeat.o(67948);
          return true;
        }
        paramq = paramString.ImY;
        this.iSn = paramString.username;
        if ((Util.isNullOrNil(this.iSn)) && (Util.isNullOrNil(paramq)))
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
            this.Ioh = com.tencent.mm.plugin.wallet.a.gE(this.iSn, 2);
            this.Ioh.cH(20, getIntent().getStringExtra("receiver_name"));
          }
        }
        else
        {
          paramq = new Intent();
          paramq.putExtra("fee", paramString.tVK);
          paramq.putExtra("desc", paramString.desc);
          paramq.putExtra("scan_remittance_id", paramString.ImP);
          paramq.putExtra("receiver_true_name", g.bCp(paramString.ImO));
          paramq.putExtra("receiver_true_name_busi", paramString.Imv);
          paramq.putExtra("receiver_tips", paramString.ImQ);
          paramq.putExtra("rcvr_new_desc", paramString.ImR);
          paramq.putExtra("payer_desc", paramString.ImS);
          paramq.putExtra("rcvr_open_id", paramString.ImY);
          paramq.putExtra("mch_name", paramString.ImV);
          paramq.putExtra("mch_info", paramString.Inb);
          paramq.putExtra("mch_photo", paramString.ImW);
          paramq.putExtra("mch_type", paramString.ImZ);
          paramq.putExtra("mch_time", paramString.ImX);
          paramq.putExtra("amount_remind_bit", paramString.Inc);
          if (paramString.ImU == 1)
          {
            paramq.putExtra("busi_type", paramString.ImU);
            paramq.putExtra("rcvr_ticket", paramString.ImT);
            paramq.putExtra("rcvr_open_id", paramString.ImY);
            paramq.putExtra("get_pay_wifi", paramString.Ina);
            if (paramString.Ind != null) {
              paramq.putExtra("BusiRemittanceResp", paramString.Ind);
            }
          }
          if (this.mChannel == 56) {
            paramq.putExtra("app_id", this.mAppID);
          }
          com.tencent.mm.kernel.h.aHH();
          as localas = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().bwh(this.iSn);
          com.tencent.mm.am.d.aH(this.iSn, 3);
          if ((localas == null) && (!this.iSn.equals(""))) {
            break label639;
          }
          a(this.iSn, paramString.scene, paramq);
        }
        for (;;)
        {
          AppMethodBeat.o(67948);
          return true;
          this.Ioh = com.tencent.mm.plugin.wallet.a.gE(this.iSn, 3);
          this.Ioh.cH(10, getIntent().getStringExtra("receiver_name"));
          break;
          label639:
          Log.d("MicroMsg.RemittanceAdapterUI", "Receiver in contactStg and try to get contact");
          final long l = Util.nowMilliSecond();
          az.a.ltq.a(this.iSn, "", new az.b.a()
          {
            public final void s(String paramAnonymousString, boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(67943);
              if (paramAnonymousBoolean)
              {
                Log.v("MicroMsg.RemittanceAdapterUI", "getContact suc; cost=" + (Util.nowMilliSecond() - l) + " ms");
                com.tencent.mm.am.d.aH(paramAnonymousString, 3);
                com.tencent.mm.am.q.bhR().TB(paramAnonymousString);
              }
              for (;;)
              {
                RemittanceAdapterUI.this.a(RemittanceAdapterUI.this.iSn, paramq.scene, this.Ioj);
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
        com.tencent.mm.pluginsdk.wallet.e.bsi(((com.tencent.mm.plugin.wallet_core.c.d)paramq).gIv());
        a(null, 31, null);
        AppMethodBeat.o(67948);
        return true;
      }
    }
    else
    {
      setResult(0);
      com.tencent.mm.ui.base.h.cO(this, paramString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceAdapterUI
 * JD-Core Version:    0.7.0.1
 */