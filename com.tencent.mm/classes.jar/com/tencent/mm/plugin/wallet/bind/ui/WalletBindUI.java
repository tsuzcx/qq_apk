package com.tencent.mm.plugin.wallet.bind.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.g.a.ks;
import com.tencent.mm.g.a.yf;
import com.tencent.mm.g.a.yg;
import com.tencent.mm.g.a.yk;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet_core.c.d;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.al;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.ui.u;
import com.tencent.mm.plugin.wallet_core.ui.u.a;
import com.tencent.mm.plugin.wallet_core.ui.u.b;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.e;
import com.tencent.mm.protocal.protobuf.xq;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bt;
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
  private boolean CGi;
  private String CGj;
  private int CGk;
  private boolean CGl;
  private String CGm;
  private d CGn;
  private boolean CGo;
  com.tencent.mm.sdk.b.c CGp;
  private String token;
  private u vFR;
  private com.tencent.mm.sdk.b.c<ks> wxJ;
  private PayInfo xnF;
  
  public WalletBindUI()
  {
    AppMethodBeat.i(69144);
    this.xnF = new PayInfo();
    this.CGi = false;
    this.CGk = -1;
    this.token = null;
    this.CGl = false;
    this.CGm = null;
    this.CGn = null;
    this.CGo = false;
    this.vFR = new u();
    this.CGp = new com.tencent.mm.sdk.b.c() {};
    this.wxJ = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(69144);
  }
  
  private void Vm(int paramInt)
  {
    AppMethodBeat.i(69147);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletBindUI", "doBindCardForOtherScene " + bt.flS().toString());
    Object localObject = getInput();
    ((Bundle)localObject).putParcelable("key_pay_info", this.xnF);
    ((Bundle)localObject).putBoolean("key_need_bind_response", true);
    ((Bundle)localObject).putString("key_custom_bind_tips", getIntent().getStringExtra("key_custom_bind_tips"));
    boolean bool = getIntent().getBooleanExtra("from_kinda", false);
    if (bool)
    {
      ((Bundle)localObject).putBoolean("is_from_new_cashier", true);
      ((Bundle)localObject).putString("start_activity_class", getClass().getName());
    }
    s.eDp();
    if (s.eDq().eGf())
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletBindUI", "user status invalid");
      if (paramInt == 4) {
        doSceneForceProgress(new com.tencent.mm.plugin.wallet_core.c.ad(null, 20));
      }
    }
    for (;;)
    {
      if (bool)
      {
        localObject = com.tencent.mm.wallet_core.a.br(this);
        if ((localObject instanceof com.tencent.mm.plugin.wallet_core.b.b)) {
          ((com.tencent.mm.plugin.wallet_core.b.b)localObject).COy = new com.tencent.mm.plugin.wallet_core.b.b.a()
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
      doSceneForceProgress(new com.tencent.mm.plugin.wallet_core.c.ad(null, 12));
      continue;
      s.eDp();
      if (s.eDq().eGa())
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletBindUI", "user status reg");
        this.CGi = true;
        this.xnF.dCD = this.CGk;
        ((Bundle)localObject).putInt("key_bind_scene", this.xnF.dCD);
        if (!bt.isNullOrNil(this.token)) {
          ((Bundle)localObject).putString("kreq_token", this.token);
        }
        if ((this.CGl) && (!bt.isNullOrNil(this.CGm)))
        {
          ((Bundle)localObject).putBoolean("key_bind_card_can_pass_pwd", true);
          ((Bundle)localObject).putString("key_bind_card_user_token", this.CGm);
        }
        for (;;)
        {
          if (e.ffB() != null) {
            ((Bundle)localObject).putString("jsapi_reqkey", e.ffB());
          }
          com.tencent.mm.wallet_core.b.fQJ();
          if (!com.tencent.mm.wallet_core.b.b(com.tencent.mm.plugin.expt.b.b.a.qzx, false)) {
            break;
          }
          com.tencent.mm.sdk.b.a.IbL.b(this.wxJ);
          au((Bundle)localObject);
          AppMethodBeat.o(69147);
          return;
          ((Bundle)localObject).putBoolean("key_bind_card_can_pass_pwd", false);
        }
        getIntent().putExtra("process_id", com.tencent.mm.plugin.wallet_core.b.b.class.hashCode());
        com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet_core.b.b.class, (Bundle)localObject, null);
      }
      else
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletBindUI", "user status unreg");
        this.CGi = true;
        if (this.CGk >= 0)
        {
          this.xnF.dCD = this.CGk;
          ((Bundle)localObject).putInt("key_bind_scene", this.xnF.dCD);
          if ((!this.CGl) || (bt.isNullOrNil(this.CGm))) {
            break label512;
          }
          ((Bundle)localObject).putBoolean("key_bind_card_can_pass_pwd", true);
          ((Bundle)localObject).putString("key_bind_card_user_token", this.CGm);
        }
        for (;;)
        {
          com.tencent.mm.wallet_core.b.fQJ();
          if (!com.tencent.mm.wallet_core.b.b(com.tencent.mm.plugin.expt.b.b.a.qzx, false)) {
            break label522;
          }
          com.tencent.mm.sdk.b.a.IbL.b(this.wxJ);
          au((Bundle)localObject);
          AppMethodBeat.o(69147);
          return;
          this.xnF.dCD = 1;
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
  
  private void Vn(int paramInt)
  {
    AppMethodBeat.i(69159);
    if (getIntent().getBooleanExtra("from_kinda", false))
    {
      yf localyf = new yf();
      localyf.dMz.result = paramInt;
      com.tencent.mm.sdk.b.a.IbL.l(localyf);
    }
    AppMethodBeat.o(69159);
  }
  
  private void abY(String paramString)
  {
    AppMethodBeat.i(69157);
    String str = paramString;
    if (bt.isNullOrNil(paramString)) {
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
  
  private void au(Bundle paramBundle)
  {
    AppMethodBeat.i(69158);
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.WalletBindUI", "startKindaBindCard");
    if (paramBundle != null)
    {
      ab.kB(6, paramBundle.getInt("key_bind_scene"));
      z.agm(paramBundle.getInt("key_bind_scene"));
    }
    for (;;)
    {
      ((com.tencent.mm.pluginsdk.wallet.a)g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).startBindCardUseCase(this, paramBundle);
      AppMethodBeat.o(69158);
      return;
      ab.kB(6, 0);
      z.agm(0);
    }
  }
  
  private void eDl()
  {
    AppMethodBeat.i(69146);
    this.xnF.dCD = this.CGk;
    getInput().putParcelable("key_pay_info", this.xnF);
    if (this.CGk == 2)
    {
      if (!bt.isNullOrNil(this.CGj))
      {
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.WalletBindUI", "importKey " + this.CGj);
        doSceneForceProgress(new com.tencent.mm.plugin.wallet.bind.a.c(this.CGj, this.xnF));
        AppMethodBeat.o(69146);
        return;
      }
      abY("");
      AppMethodBeat.o(69146);
      return;
    }
    if (this.CGk == 4)
    {
      z.agm(4);
      if (getIntent() == null)
      {
        abY("");
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
      if (this.CGk == 6) {}
      for (this.CGn = new d(str1, str2, str3, str4, str5, str6, str7, 2, "getBrandWCPayCreateCreditCardRequest", i);; this.CGn = new d(str1, str2, str3, str4, str5, str6, str7, 1, "getBrandWCPayBindCardRequest", i))
      {
        doSceneForceProgress(this.CGn);
        AppMethodBeat.o(69146);
        return;
      }
    }
    if (this.CGk == 6)
    {
      eDm();
      AppMethodBeat.o(69146);
      return;
    }
    Vm(this.CGk);
    AppMethodBeat.o(69146);
  }
  
  private void eDm()
  {
    AppMethodBeat.i(69148);
    s.eDp();
    if (s.eDq().eGf())
    {
      doSceneForceProgress(new com.tencent.mm.plugin.wallet_core.c.ad(null, 12));
      AppMethodBeat.o(69148);
      return;
    }
    Object localObject1 = getIntent().getStringExtra("packageExt");
    Object localObject3 = ((String)localObject1).split("&");
    if ((!bt.isNullOrNil((String)localObject1)) && (localObject3.length >= 2))
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
      if ((!bt.isNullOrNil(str)) && (!bt.isNullOrNil((String)localObject1)))
      {
        s.eDp();
        if (s.eDq().aEu((String)localObject1))
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
        this.vFR.dkA();
        AppMethodBeat.o(69152);
        return;
      }
      this.vFR.cancel();
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
    this.vFR.Dka = new u.b()
    {
      public final int dkC()
      {
        return 1;
      }
      
      public final Context getContext()
      {
        return WalletBindUI.this;
      }
    };
    this.CGj = getIntent().getStringExtra("key_import_key");
    this.CGk = getIntent().getIntExtra("key_bind_scene", -1);
    if (getIntent() != null) {
      i = getIntent().getIntExtra("key_bind_scene", 13);
    }
    paramBundle = new yk();
    if (i == 4) {}
    for (paramBundle.dMG.scene = 20;; paramBundle.dMG.scene = 13)
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
            al localal = new al();
            WalletBindUI.d(WalletBindUI.this).a(new u.a()
            {
              public final void cancel()
              {
                AppMethodBeat.i(69134);
                WalletBindUI.this.finish();
                AppMethodBeat.o(69134);
              }
              
              public final void dkA()
              {
                AppMethodBeat.i(69133);
                WalletBindUI.c(WalletBindUI.this);
                AppMethodBeat.o(69133);
              }
              
              public final void dkB()
              {
                AppMethodBeat.i(69135);
                WalletBindUI.c(WalletBindUI.this);
                AppMethodBeat.o(69135);
              }
            }, localal.eFY());
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
      com.tencent.mm.sdk.b.a.IbL.l(paramBundle);
      com.tencent.mm.sdk.b.a.IbL.c(this.CGp);
      ab.kB(6, 0);
      AppMethodBeat.o(69145);
      return;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(69151);
    removeSceneEndListener(580);
    com.tencent.mm.sdk.b.a.IbL.d(this.CGp);
    super.onDestroy();
    AppMethodBeat.o(69151);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(69156);
    if (paramIntent == null)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.WalletBindUI", "onNewIntent intent null");
      setResult(0);
      Vn(0);
      finish();
      AppMethodBeat.o(69156);
      return;
    }
    super.onNewIntent(paramIntent);
    com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.WalletBindUI", "onNewIntent");
    setIntent(paramIntent);
    if ((paramIntent != null) && (paramIntent.getBooleanExtra("intent_bind_end", false)))
    {
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.WalletBindUI", "pay done... errCode:" + paramIntent.getBooleanExtra("intent_bind_end", false));
      setResult(-1, getIntent());
      Vn(-1);
    }
    for (;;)
    {
      finish();
      AppMethodBeat.o(69156);
      return;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletBindUI", "pay cancel");
      setResult(0);
      Vn(0);
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(69150);
    super.onPause();
    this.vFR.onPause();
    AppMethodBeat.o(69150);
  }
  
  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(69155);
    super.onRestoreInstanceState(paramBundle);
    this.CGi = paramBundle.getBoolean("key_is_jump", false);
    AppMethodBeat.o(69155);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(69149);
    if (this.CGi) {
      finish();
    }
    super.onResume();
    this.vFR.onResume();
    AppMethodBeat.o(69149);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(69154);
    super.onSaveInstanceState(paramBundle);
    paramBundle.putBoolean("key_is_jump", this.CGi);
    AppMethodBeat.o(69154);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(69153);
    if ((paramn instanceof com.tencent.mm.plugin.wallet.bind.a.c)) {
      this.CGi = true;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramn instanceof com.tencent.mm.plugin.wallet_core.c.ad))
      {
        if (this.CGk == 6) {
          eDm();
        }
        for (;;)
        {
          AppMethodBeat.o(69153);
          return true;
          eDl();
        }
      }
      if ((paramn instanceof com.tencent.mm.plugin.wallet.bind.a.c))
      {
        paramn = (com.tencent.mm.plugin.wallet.bind.a.c)paramn;
        Bundle localBundle = getInput();
        localBundle.putBoolean("key_is_import_bind", true);
        if ((paramn.CyC != null) && (paramn.CyC.size() > 0))
        {
          paramString = (Bankcard)paramn.CyC.get(0);
          if (!paramString.CUN)
          {
            localBundle.putBoolean("key_need_bind_response", true);
            localBundle.putString("kreq_token", paramn.token);
            localBundle.putString("key_bank_username", paramn.CFk);
            localBundle.putString("key_recommand_desc", paramn.CFl);
            localBundle.putParcelable("key_import_bankcard", paramString);
            this.CGi = true;
            localBundle.putInt("key_bind_scene", 2);
            com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet_core.b.b.class, localBundle, new d.a()
            {
              public final Intent s(int paramAnonymousInt, Bundle paramAnonymousBundle)
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
          if (bt.isNullOrNil(paramString)) {
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
        if ((this.CGn != null) && (this.CGn.equals(paramn)))
        {
          e.aNP(((d)paramn).eEF());
          this.token = ((d)paramn).getToken();
          this.CGl = ((xq)((d)paramn).rr.hNL.hNQ).FXn;
          this.CGm = ((xq)((d)paramn).rr.hNL.hNQ).CPp;
          Vm(4);
          AppMethodBeat.o(69153);
          return true;
        }
        z.fRz();
      }
      AppMethodBeat.o(69153);
      return false;
    }
    abY(paramString);
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