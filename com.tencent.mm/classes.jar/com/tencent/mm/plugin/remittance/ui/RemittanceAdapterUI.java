package com.tencent.mm.plugin.remittance.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.model.az.b.a;
import com.tencent.mm.modelavatar.q;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyExclusiveSelectContactUI;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.remittance.model.ag;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.i;

@com.tencent.mm.ui.base.a(7)
public class RemittanceAdapterUI
  extends WalletBaseUI
{
  protected com.tencent.mm.plugin.wallet.a OlA = null;
  protected String Oly = null;
  protected boolean Olz = false;
  protected String luk = null;
  protected String mAppID = null;
  protected int mChannel;
  protected int mScene;
  
  protected final void a(String paramString, int paramInt, Intent paramIntent)
  {
    AppMethodBeat.i(67949);
    Log.i("MicroMsg.RemittanceAdapterUI", "startRemittanceUI scene=" + this.mScene + ", name=" + paramString + " payScene: " + paramInt);
    if (paramIntent != null)
    {
      paramIntent = new Intent(paramIntent);
      com.tencent.mm.plugin.wallet.a.a(this.OlA, paramIntent);
      if (paramIntent.getIntExtra("busi_type", 0) != 1) {
        break label223;
      }
      paramIntent.setClass(this, RemittanceBusiUI.class);
    }
    for (;;)
    {
      paramIntent.putExtra("receiver_name", paramString);
      paramIntent.putExtra("scene", this.mScene);
      paramIntent.putExtra("pay_scene", paramInt);
      paramIntent.putExtra("pay_channel", this.mChannel);
      paramIntent.putExtra("qq_extend_info", this.Oly);
      paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramString.aYi(), "com/tencent/mm/plugin/remittance/ui/RemittanceAdapterUI", "startRemittanceUI", "(Ljava/lang/String;ILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramString.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/remittance/ui/RemittanceAdapterUI", "startRemittanceUI", "(Ljava/lang/String;ILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      setResult(-1);
      finish();
      AppMethodBeat.o(67949);
      return;
      paramIntent = new Intent();
      break;
      label223:
      paramIntent.setClass(this, RemittanceUI.class);
    }
  }
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(289139);
    if (paramInt1 == 16)
    {
      if (paramInt2 == -1)
      {
        paramIntent = paramIntent.getStringExtra("Select_Contact");
        Log.i("MicroMsg.RemittanceAdapterUI", "select user: %s", new Object[] { paramIntent });
        if (!Util.isNullOrNil(paramIntent))
        {
          Intent localIntent = new Intent();
          localIntent.putExtra("key_group_name", this.luk);
          a(paramIntent, 31, localIntent);
          AppMethodBeat.o(289139);
          return;
        }
        finish();
        AppMethodBeat.o(289139);
        return;
      }
      finish();
      AppMethodBeat.o(289139);
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(289139);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(67947);
    if (!this.Olz)
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
    this.luk = getIntent().getStringExtra("receiver_name");
    this.mChannel = getIntent().getIntExtra("pay_channel", -1);
    this.Oly = getIntent().getStringExtra("qq_extend_info");
    this.OlA = com.tencent.mm.plugin.wallet.a.bE(getIntent());
    if (this.mChannel == 56) {
      this.mAppID = this.OlA.UYV;
    }
    if (this.mChannel == -1)
    {
      paramBundle = getProcess();
      if (paramBundle != null) {
        this.mChannel = paramBundle.hPH.getInt("pay_channel", -1);
      }
    }
    if (this.mScene == 1)
    {
      this.Olz = true;
      paramBundle = new ag(this.luk, this.mChannel, this.Oly);
      paramBundle.setProcessName("RemittanceProcess");
      doSceneProgress(paramBundle, true);
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
      if (Util.isNullOrNil(this.luk))
      {
        Log.w("MicroMsg.RemittanceAdapterUI", "Username empty & finish. scene=" + this.mScene);
        finish();
        AppMethodBeat.o(67944);
        return;
      }
      if (au.bwE(this.luk))
      {
        Log.i("MicroMsg.RemittanceAdapterUI", "do select a contact: %s", new Object[] { this.luk });
        paramBundle = new Intent(this, LuckyMoneyExclusiveSelectContactUI.class);
        paramBundle.putExtra("chatroomName", this.luk);
        paramBundle.putExtra("key_title", getString(a.i.remittance_select_contact_title));
        paramBundle.putExtra("key_same_name_tips", a.i.remittance_select_contact_same_displayname_tips);
        startActivityForResult(paramBundle, 16);
        AppMethodBeat.o(67944);
        return;
      }
      a(this.luk, 31, null);
      AppMethodBeat.o(67944);
      return;
    }
    if ((this.mScene == 5) || (this.mScene == 6))
    {
      if (Util.isNullOrNil(this.luk))
      {
        Log.w("MicroMsg.RemittanceAdapterUI", "Username empty & finish. scene=" + this.mScene);
        finish();
        AppMethodBeat.o(67944);
        return;
      }
      paramBundle = this.luk;
      Log.i("MicroMsg.RemittanceAdapterUI", "startRemittanceUI scene=" + this.mScene + ", name=" + paramBundle);
      Intent localIntent = new Intent();
      com.tencent.mm.plugin.wallet.a.a(this.OlA, localIntent);
      localIntent.setClass(this, RemittanceOSRedirect.class);
      localIntent.putExtra("receiver_name", paramBundle);
      localIntent.putExtra("scene", this.mScene);
      localIntent.putExtra("pay_scene", 31);
      localIntent.putExtra("pay_channel", this.mChannel);
      paramBundle = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramBundle.aYi(), "com/tencent/mm/plugin/remittance/ui/RemittanceAdapterUI", "startRemittanceOSUI", "(Ljava/lang/String;ILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramBundle.sb(0));
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
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, final p paramp)
  {
    AppMethodBeat.i(67948);
    if ((paramp instanceof ag)) {
      this.Olz = false;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramp instanceof ag))
      {
        paramString = (ag)paramp;
        if ((this.mScene == 1) && (paramString.hAV == 0) && (paramString.wuj == 1))
        {
          paramp = new Intent();
          paramp.putExtra("rawUrl", paramString.jump_url);
          i.aS(this, paramp);
          finish();
          AppMethodBeat.o(67948);
          return true;
        }
        paramp = paramString.Oiw;
        this.luk = paramString.username;
        if ((Util.isNullOrNil(this.luk)) && (Util.isNullOrNil(paramp)))
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
            this.OlA = com.tencent.mm.plugin.wallet.a.hB(this.luk, 2);
            this.OlA.dx(20, getIntent().getStringExtra("receiver_name"));
          }
        }
        else
        {
          paramp = new Intent();
          paramp.putExtra("fee", paramString.wZe);
          paramp.putExtra("desc", paramString.desc);
          paramp.putExtra("scan_remittance_id", paramString.Okf);
          paramp.putExtra("receiver_true_name", i.bEN(paramString.Oke));
          paramp.putExtra("receiver_true_name_busi", paramString.OiN);
          paramp.putExtra("receiver_tips", paramString.Okg);
          paramp.putExtra("rcvr_new_desc", paramString.Okh);
          paramp.putExtra("payer_desc", paramString.Oki);
          paramp.putExtra("rcvr_open_id", paramString.Oiw);
          paramp.putExtra("mch_name", paramString.Oiv);
          paramp.putExtra("mch_info", paramString.Okp);
          paramp.putExtra("mch_photo", paramString.Okl);
          paramp.putExtra("mch_type", paramString.Okn);
          paramp.putExtra("mch_time", paramString.Okm);
          paramp.putExtra("amount_remind_bit", paramString.Okq);
          if (paramString.Okk == 1)
          {
            paramp.putExtra("busi_type", paramString.Okk);
            paramp.putExtra("rcvr_ticket", paramString.Okj);
            paramp.putExtra("rcvr_open_id", paramString.Oiw);
            paramp.putExtra("get_pay_wifi", paramString.Oko);
            if (paramString.Okr != null) {
              paramp.putExtra("BusiRemittanceResp", paramString.Okr);
            }
          }
          if (this.mChannel == 56) {
            paramp.putExtra("app_id", this.mAppID);
          }
          h.baF();
          au localau = ((n)h.ax(n.class)).bzA().bxv(this.luk);
          com.tencent.mm.modelavatar.d.aS(this.luk, 3);
          if ((localau == null) && (!this.luk.equals(""))) {
            break label639;
          }
          a(this.luk, paramString.scene, paramp);
        }
        for (;;)
        {
          AppMethodBeat.o(67948);
          return true;
          this.OlA = com.tencent.mm.plugin.wallet.a.hB(this.luk, 3);
          this.OlA.dx(10, getIntent().getStringExtra("receiver_name"));
          break;
          label639:
          Log.d("MicroMsg.RemittanceAdapterUI", "Receiver in contactStg and try to get contact");
          final long l = Util.nowMilliSecond();
          az.a.okP.a(this.luk, "", new az.b.a()
          {
            public final void getContactCallBack(String paramAnonymousString, boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(67943);
              if (paramAnonymousBoolean)
              {
                Log.v("MicroMsg.RemittanceAdapterUI", "getContact suc; cost=" + (Util.nowMilliSecond() - l) + " ms");
                com.tencent.mm.modelavatar.d.aS(paramAnonymousString, 3);
                q.bFG().LB(paramAnonymousString);
              }
              for (;;)
              {
                RemittanceAdapterUI.this.a(RemittanceAdapterUI.this.luk, paramp.scene, this.OlC);
                AppMethodBeat.o(67943);
                return;
                Log.w("MicroMsg.RemittanceAdapterUI", "getContact failed");
              }
            }
          });
        }
      }
      if ((paramp instanceof com.tencent.mm.plugin.wallet_core.c.d))
      {
        com.tencent.mm.pluginsdk.wallet.e.brZ(((com.tencent.mm.plugin.wallet_core.c.d)paramp).ihJ());
        a(null, 31, null);
        AppMethodBeat.o(67948);
        return true;
      }
    }
    else
    {
      setResult(0);
      k.cZ(this, paramString);
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