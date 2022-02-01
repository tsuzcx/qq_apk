package com.tencent.mm.plugin.wallet.bind.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.g.a.kj;
import com.tencent.mm.g.a.xl;
import com.tencent.mm.g.a.xm;
import com.tencent.mm.g.a.xq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet_core.c.ad;
import com.tencent.mm.plugin.wallet_core.c.d;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ak;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.ui.u;
import com.tencent.mm.plugin.wallet_core.ui.u.a;
import com.tencent.mm.plugin.wallet_core.ui.u.b;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.e;
import com.tencent.mm.protocal.protobuf.vr;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c.ab;
import com.tencent.mm.wallet_core.c.z;
import com.tencent.mm.wallet_core.d.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.ArrayList;

@com.tencent.mm.ui.base.a(7)
public class WalletBindUI
  extends WalletBaseUI
{
  private boolean BfU;
  private String BfV;
  private int BfW;
  private boolean BfX;
  private String BfY;
  private d BfZ;
  private boolean Bga;
  com.tencent.mm.sdk.b.c Bgb;
  private String token;
  private u uCZ;
  private com.tencent.mm.sdk.b.c<kj> vsr;
  private PayInfo wfX;
  
  public WalletBindUI()
  {
    AppMethodBeat.i(69144);
    this.wfX = new PayInfo();
    this.BfU = false;
    this.BfW = -1;
    this.token = null;
    this.BfX = false;
    this.BfY = null;
    this.BfZ = null;
    this.Bga = false;
    this.uCZ = new u();
    this.Bgb = new com.tencent.mm.sdk.b.c() {};
    this.vsr = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(69144);
  }
  
  private void Tu(int paramInt)
  {
    AppMethodBeat.i(69147);
    ac.i("MicroMsg.WalletBindUI", "doBindCardForOtherScene " + bs.eWi().toString());
    Object localObject = getInput();
    ((Bundle)localObject).putParcelable("key_pay_info", this.wfX);
    ((Bundle)localObject).putBoolean("key_need_bind_response", true);
    ((Bundle)localObject).putString("key_custom_bind_tips", getIntent().getStringExtra("key_custom_bind_tips"));
    boolean bool = getIntent().getBooleanExtra("from_kinda", false);
    if (bool)
    {
      ((Bundle)localObject).putBoolean("is_from_new_cashier", true);
      ((Bundle)localObject).putString("start_activity_class", getClass().getName());
    }
    s.epp();
    if (s.epq().esf())
    {
      ac.i("MicroMsg.WalletBindUI", "user status invalid");
      if (paramInt == 4) {
        doSceneForceProgress(new ad(null, 20));
      }
    }
    for (;;)
    {
      if (bool)
      {
        localObject = com.tencent.mm.wallet_core.a.br(this);
        if ((localObject instanceof com.tencent.mm.plugin.wallet_core.b.b)) {
          ((com.tencent.mm.plugin.wallet_core.b.b)localObject).Boj = new com.tencent.mm.plugin.wallet_core.b.b.a()
          {
            public final void run(int paramAnonymousInt)
            {
              AppMethodBeat.i(69137);
              if (paramAnonymousInt == -1)
              {
                WalletBindUI.this.setResult(-1);
                WalletBindUI.a(WalletBindUI.this, -1);
                AppMethodBeat.o(69137);
                return;
              }
              WalletBindUI.this.setResult(0);
              WalletBindUI.a(WalletBindUI.this, 0);
              AppMethodBeat.o(69137);
            }
          };
        }
      }
      AppMethodBeat.o(69147);
      return;
      doSceneForceProgress(new ad(null, 12));
      continue;
      s.epp();
      if (s.epq().esa())
      {
        ac.i("MicroMsg.WalletBindUI", "user status reg");
        this.BfU = true;
        this.wfX.dqM = this.BfW;
        ((Bundle)localObject).putInt("key_bind_scene", this.wfX.dqM);
        if (!bs.isNullOrNil(this.token)) {
          ((Bundle)localObject).putString("kreq_token", this.token);
        }
        if ((this.BfX) && (!bs.isNullOrNil(this.BfY)))
        {
          ((Bundle)localObject).putBoolean("key_bind_card_can_pass_pwd", true);
          ((Bundle)localObject).putString("key_bind_card_user_token", this.BfY);
        }
        for (;;)
        {
          if (e.eQx() != null) {
            ((Bundle)localObject).putString("jsapi_reqkey", e.eQx());
          }
          com.tencent.mm.wallet_core.b.fzz();
          if (!com.tencent.mm.wallet_core.b.b(com.tencent.mm.plugin.expt.a.b.a.pUR, false)) {
            break;
          }
          com.tencent.mm.sdk.b.a.GpY.b(this.vsr);
          ap((Bundle)localObject);
          AppMethodBeat.o(69147);
          return;
          ((Bundle)localObject).putBoolean("key_bind_card_can_pass_pwd", false);
        }
        getIntent().putExtra("process_id", com.tencent.mm.plugin.wallet_core.b.b.class.hashCode());
        com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet_core.b.b.class, (Bundle)localObject, null);
      }
      else
      {
        ac.i("MicroMsg.WalletBindUI", "user status unreg");
        this.BfU = true;
        if (this.BfW >= 0)
        {
          this.wfX.dqM = this.BfW;
          ((Bundle)localObject).putInt("key_bind_scene", this.wfX.dqM);
          if ((!this.BfX) || (bs.isNullOrNil(this.BfY))) {
            break label512;
          }
          ((Bundle)localObject).putBoolean("key_bind_card_can_pass_pwd", true);
          ((Bundle)localObject).putString("key_bind_card_user_token", this.BfY);
        }
        for (;;)
        {
          com.tencent.mm.wallet_core.b.fzz();
          if (!com.tencent.mm.wallet_core.b.b(com.tencent.mm.plugin.expt.a.b.a.pUR, false)) {
            break label522;
          }
          com.tencent.mm.sdk.b.a.GpY.b(this.vsr);
          ap((Bundle)localObject);
          AppMethodBeat.o(69147);
          return;
          this.wfX.dqM = 1;
          break;
          label512:
          ((Bundle)localObject).putBoolean("key_bind_card_can_pass_pwd", false);
        }
        label522:
        getIntent().putExtra("process_id", com.tencent.mm.plugin.wallet_core.b.b.class.hashCode());
        com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet_core.b.b.class, (Bundle)localObject, null);
      }
    }
  }
  
  private void Tv(int paramInt)
  {
    AppMethodBeat.i(69159);
    if (getIntent().getBooleanExtra("from_kinda", false))
    {
      xl localxl = new xl();
      localxl.dAm.result = paramInt;
      com.tencent.mm.sdk.b.a.GpY.l(localxl);
    }
    AppMethodBeat.o(69159);
  }
  
  private void Ys(String paramString)
  {
    AppMethodBeat.i(69157);
    String str = paramString;
    if (bs.isNullOrNil(paramString)) {
      str = getString(2131765901);
    }
    h.a(this, str, null, false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(69142);
        WalletBindUI.this.setResult(0);
        WalletBindUI.a(WalletBindUI.this, 0);
        WalletBindUI.this.finish();
        AppMethodBeat.o(69142);
      }
    });
    AppMethodBeat.o(69157);
  }
  
  private void ap(Bundle paramBundle)
  {
    AppMethodBeat.i(69158);
    ac.d("MicroMsg.WalletBindUI", "startKindaBindCard");
    if (paramBundle != null)
    {
      ab.km(6, paramBundle.getInt("key_bind_scene"));
      z.adM(paramBundle.getInt("key_bind_scene"));
    }
    for (;;)
    {
      ((com.tencent.mm.pluginsdk.wallet.a)g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).startBindCardUseCase(this, paramBundle);
      AppMethodBeat.o(69158);
      return;
      ab.km(6, 0);
      z.adM(0);
    }
  }
  
  private void epl()
  {
    AppMethodBeat.i(69146);
    this.wfX.dqM = this.BfW;
    getInput().putParcelable("key_pay_info", this.wfX);
    if (this.BfW == 2)
    {
      if (!bs.isNullOrNil(this.BfV))
      {
        ac.d("MicroMsg.WalletBindUI", "importKey " + this.BfV);
        doSceneForceProgress(new com.tencent.mm.plugin.wallet.bind.a.c(this.BfV, this.wfX));
        AppMethodBeat.o(69146);
        return;
      }
      Ys("");
      AppMethodBeat.o(69146);
      return;
    }
    if (this.BfW == 4)
    {
      z.adM(4);
      if (getIntent() == null)
      {
        Ys("");
        AppMethodBeat.o(69146);
        return;
      }
      String str1 = getIntent().getStringExtra("appId");
      String str2 = getIntent().getStringExtra("timeStamp");
      String str3 = getIntent().getStringExtra("nonceStr");
      String str4 = getIntent().getStringExtra("packageExt");
      String str5 = getIntent().getStringExtra("signtype");
      String str6 = getIntent().getStringExtra("paySignature");
      String str7 = getIntent().getStringExtra("url");
      int i = getIntent().getIntExtra("pay_channel", 0);
      if (this.BfW == 6) {}
      for (this.BfZ = new d(str1, str2, str3, str4, str5, str6, str7, 2, "getBrandWCPayCreateCreditCardRequest", i);; this.BfZ = new d(str1, str2, str3, str4, str5, str6, str7, 1, "getBrandWCPayBindCardRequest", i))
      {
        doSceneForceProgress(this.BfZ);
        AppMethodBeat.o(69146);
        return;
      }
    }
    if (this.BfW == 6)
    {
      epm();
      AppMethodBeat.o(69146);
      return;
    }
    Tu(this.BfW);
    AppMethodBeat.o(69146);
  }
  
  private void epm()
  {
    AppMethodBeat.i(69148);
    s.epp();
    if (s.epq().esf())
    {
      doSceneForceProgress(new ad(null, 12));
      AppMethodBeat.o(69148);
      return;
    }
    Object localObject1 = getIntent().getStringExtra("packageExt");
    Object localObject3 = ((String)localObject1).split("&");
    if ((!bs.isNullOrNil((String)localObject1)) && (localObject3.length >= 2))
    {
      int j = localObject3.length;
      int i = 0;
      String str = null;
      localObject1 = null;
      Object localObject2;
      if (i < j)
      {
        Object localObject4 = localObject3[i];
        if (localObject4.startsWith("bankType=")) {
          localObject2 = localObject4.replace("bankType=", "");
        }
        for (;;)
        {
          i += 1;
          localObject1 = localObject2;
          break;
          localObject2 = localObject1;
          if (localObject4.startsWith("bankName="))
          {
            str = localObject4.replace("bankName=", "");
            localObject2 = localObject1;
          }
        }
      }
      if ((!bs.isNullOrNil(str)) && (!bs.isNullOrNil((String)localObject1)))
      {
        s.epp();
        if (s.epq().azm((String)localObject1))
        {
          localObject2 = new Bundle();
          localObject3 = new Bankcard();
          ((Bankcard)localObject3).field_bankName = str;
          ((Bankcard)localObject3).field_bankcardType = ((String)localObject1);
          ((Bundle)localObject2).putParcelable("key_bankcard", (Parcelable)localObject3);
          ((Bundle)localObject2).putString("key_bank_type", ((Bankcard)localObject3).field_bankcardType);
          com.tencent.mm.wallet_core.a.a(this, "WXCreditOpenProcess", (Bundle)localObject2, null);
          AppMethodBeat.o(69148);
          return;
        }
      }
    }
    finish();
    AppMethodBeat.o(69148);
  }
  
  public boolean checkProcLife()
  {
    return false;
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(69152);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1)
    {
      if (paramInt2 == -1)
      {
        this.uCZ.dbh();
        AppMethodBeat.o(69152);
        return;
      }
      this.uCZ.cancel();
      finish();
    }
    AppMethodBeat.o(69152);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    int i = -1;
    AppMethodBeat.i(69145);
    super.onCreate(paramBundle);
    addSceneEndListener(580);
    this.uCZ.BJI = new u.b()
    {
      public final int dbj()
      {
        return 1;
      }
      
      public final Context getContext()
      {
        return WalletBindUI.this;
      }
    };
    this.BfV = getIntent().getStringExtra("key_import_key");
    this.BfW = getIntent().getIntExtra("key_bind_scene", -1);
    if (getIntent() != null) {
      i = getIntent().getIntExtra("key_bind_scene", 13);
    }
    paramBundle = new xq();
    if (i == 4) {}
    for (paramBundle.dAt.scene = 20;; paramBundle.dAt.scene = 13)
    {
      paramBundle.callback = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(69136);
          if (WalletBindUI.a(WalletBindUI.this))
          {
            AppMethodBeat.o(69136);
            return;
          }
          if (WalletBindUI.b(WalletBindUI.this) == 4)
          {
            ak localak = new ak();
            WalletBindUI.d(WalletBindUI.this).a(new u.a()
            {
              public final void cancel()
              {
                AppMethodBeat.i(69134);
                WalletBindUI.this.finish();
                AppMethodBeat.o(69134);
              }
              
              public final void dbh()
              {
                AppMethodBeat.i(69133);
                WalletBindUI.c(WalletBindUI.this);
                AppMethodBeat.o(69133);
              }
              
              public final void dbi()
              {
                AppMethodBeat.i(69135);
                WalletBindUI.c(WalletBindUI.this);
                AppMethodBeat.o(69135);
              }
            }, localak.erY());
          }
          for (;;)
          {
            if (!WalletBindUI.a(WalletBindUI.this)) {
              WalletBindUI.e(WalletBindUI.this);
            }
            AppMethodBeat.o(69136);
            return;
            WalletBindUI.c(WalletBindUI.this);
          }
        }
      };
      com.tencent.mm.sdk.b.a.GpY.l(paramBundle);
      com.tencent.mm.sdk.b.a.GpY.c(this.Bgb);
      ab.km(6, 0);
      AppMethodBeat.o(69145);
      return;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(69151);
    removeSceneEndListener(580);
    com.tencent.mm.sdk.b.a.GpY.d(this.Bgb);
    super.onDestroy();
    AppMethodBeat.o(69151);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(69156);
    if (paramIntent == null)
    {
      ac.e("MicroMsg.WalletBindUI", "onNewIntent intent null");
      setResult(0);
      Tv(0);
      finish();
      AppMethodBeat.o(69156);
      return;
    }
    super.onNewIntent(paramIntent);
    ac.v("MicroMsg.WalletBindUI", "onNewIntent");
    setIntent(paramIntent);
    if ((paramIntent != null) && (paramIntent.getBooleanExtra("intent_bind_end", false)))
    {
      ac.d("MicroMsg.WalletBindUI", "pay done... errCode:" + paramIntent.getBooleanExtra("intent_bind_end", false));
      setResult(-1, getIntent());
      Tv(-1);
    }
    for (;;)
    {
      finish();
      AppMethodBeat.o(69156);
      return;
      ac.i("MicroMsg.WalletBindUI", "pay cancel");
      setResult(0);
      Tv(0);
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(69150);
    super.onPause();
    this.uCZ.onPause();
    AppMethodBeat.o(69150);
  }
  
  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(69155);
    super.onRestoreInstanceState(paramBundle);
    this.BfU = paramBundle.getBoolean("key_is_jump", false);
    AppMethodBeat.o(69155);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(69149);
    if (this.BfU) {
      finish();
    }
    super.onResume();
    this.uCZ.onResume();
    AppMethodBeat.o(69149);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(69154);
    super.onSaveInstanceState(paramBundle);
    paramBundle.putBoolean("key_is_jump", this.BfU);
    AppMethodBeat.o(69154);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(69153);
    if ((paramn instanceof com.tencent.mm.plugin.wallet.bind.a.c)) {
      this.BfU = true;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramn instanceof ad))
      {
        if (this.BfW == 6) {
          epm();
        }
        for (;;)
        {
          AppMethodBeat.o(69153);
          return true;
          epl();
        }
      }
      if ((paramn instanceof com.tencent.mm.plugin.wallet.bind.a.c))
      {
        paramn = (com.tencent.mm.plugin.wallet.bind.a.c)paramn;
        Bundle localBundle = getInput();
        localBundle.putBoolean("key_is_import_bind", true);
        if ((paramn.AYt != null) && (paramn.AYt.size() > 0))
        {
          paramString = (Bankcard)paramn.AYt.get(0);
          if (!paramString.Buy)
          {
            localBundle.putBoolean("key_need_bind_response", true);
            localBundle.putString("kreq_token", paramn.token);
            localBundle.putString("key_bank_username", paramn.BeV);
            localBundle.putString("key_recommand_desc", paramn.BeW);
            localBundle.putParcelable("key_import_bankcard", paramString);
            this.BfU = true;
            localBundle.putInt("key_bind_scene", 2);
            com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet_core.b.b.class, localBundle, new d.a()
            {
              public final Intent r(int paramAnonymousInt, Bundle paramAnonymousBundle)
              {
                AppMethodBeat.i(69139);
                paramAnonymousBundle = new Intent(WalletBindUI.this.getContext(), WalletBankcardManageUI.class);
                AppMethodBeat.o(69139);
                return paramAnonymousBundle;
              }
            });
          }
        }
        for (;;)
        {
          AppMethodBeat.o(69153);
          return true;
          h.a(this, 2131765140, 0, false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(69140);
              WalletBindUI.this.finish();
              AppMethodBeat.o(69140);
            }
          });
          continue;
          paramn = paramString;
          if (bs.isNullOrNil(paramString)) {
            paramn = getString(2131765069);
          }
          h.a(this, paramn, null, false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(69141);
              WalletBindUI.this.finish();
              AppMethodBeat.o(69141);
            }
          });
        }
      }
      if ((paramn instanceof d))
      {
        if ((this.BfZ != null) && (this.BfZ.equals(paramn)))
        {
          e.aIm(((d)paramn).eqF());
          this.token = ((d)paramn).getToken();
          this.BfX = ((vr)((d)paramn).rr.hvs.hvw).Eqc;
          this.BfY = ((vr)((d)paramn).rr.hvs.hvw).Bpa;
          Tu(4);
          AppMethodBeat.o(69153);
          return true;
        }
        z.fAp();
      }
      AppMethodBeat.o(69153);
      return false;
    }
    Ys(paramString);
    AppMethodBeat.o(69153);
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.bind.ui.WalletBindUI
 * JD-Core Version:    0.7.0.1
 */