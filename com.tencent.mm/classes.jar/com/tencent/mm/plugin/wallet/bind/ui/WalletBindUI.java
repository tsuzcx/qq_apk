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
import com.tencent.mm.g.a.kt;
import com.tencent.mm.g.a.yl;
import com.tencent.mm.g.a.ym;
import com.tencent.mm.g.a.yq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet_core.c.ad;
import com.tencent.mm.plugin.wallet_core.c.d;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.al;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.ui.u;
import com.tencent.mm.plugin.wallet_core.ui.u.a;
import com.tencent.mm.plugin.wallet_core.ui.u.b;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.e;
import com.tencent.mm.protocal.protobuf.xt;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.bu;
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
  private boolean CXO;
  private String CXP;
  private int CXQ;
  private boolean CXR;
  private String CXS;
  private d CXT;
  private boolean CXU;
  com.tencent.mm.sdk.b.c CXV;
  private String token;
  private u vRV;
  private com.tencent.mm.sdk.b.c<kt> wNu;
  private PayInfo xDC;
  
  public WalletBindUI()
  {
    AppMethodBeat.i(69144);
    this.xDC = new PayInfo();
    this.CXO = false;
    this.CXQ = -1;
    this.token = null;
    this.CXR = false;
    this.CXS = null;
    this.CXT = null;
    this.CXU = false;
    this.vRV = new u();
    this.CXV = new com.tencent.mm.sdk.b.c() {};
    this.wNu = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(69144);
  }
  
  private void VT(int paramInt)
  {
    AppMethodBeat.i(69147);
    ae.i("MicroMsg.WalletBindUI", "doBindCardForOtherScene " + bu.fpN().toString());
    Object localObject = getInput();
    ((Bundle)localObject).putParcelable("key_pay_info", this.xDC);
    ((Bundle)localObject).putBoolean("key_need_bind_response", true);
    ((Bundle)localObject).putString("key_custom_bind_tips", getIntent().getStringExtra("key_custom_bind_tips"));
    boolean bool = getIntent().getBooleanExtra("from_kinda", false);
    if (bool)
    {
      ((Bundle)localObject).putBoolean("is_from_new_cashier", true);
      ((Bundle)localObject).putString("start_activity_class", getClass().getName());
    }
    s.eGW();
    if (s.eGX().eJM())
    {
      ae.i("MicroMsg.WalletBindUI", "user status invalid");
      if (paramInt == 4) {
        doSceneForceProgress(new ad(null, 20));
      }
    }
    for (;;)
    {
      if (bool)
      {
        localObject = com.tencent.mm.wallet_core.a.bs(this);
        if ((localObject instanceof com.tencent.mm.plugin.wallet_core.b.b)) {
          ((com.tencent.mm.plugin.wallet_core.b.b)localObject).Dgd = new com.tencent.mm.plugin.wallet_core.b.b.a()
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
      s.eGW();
      if (s.eGX().eJH())
      {
        ae.i("MicroMsg.WalletBindUI", "user status reg");
        this.CXO = true;
        this.xDC.dDI = this.CXQ;
        ((Bundle)localObject).putInt("key_bind_scene", this.xDC.dDI);
        if (!bu.isNullOrNil(this.token)) {
          ((Bundle)localObject).putString("kreq_token", this.token);
        }
        if ((this.CXR) && (!bu.isNullOrNil(this.CXS)))
        {
          ((Bundle)localObject).putBoolean("key_bind_card_can_pass_pwd", true);
          ((Bundle)localObject).putString("key_bind_card_user_token", this.CXS);
        }
        for (;;)
        {
          if (e.fjr() != null) {
            ((Bundle)localObject).putString("jsapi_reqkey", e.fjr());
          }
          com.tencent.mm.wallet_core.b.fVf();
          if (!com.tencent.mm.wallet_core.b.b(com.tencent.mm.plugin.expt.b.b.a.qGD, false)) {
            break;
          }
          com.tencent.mm.sdk.b.a.IvT.b(this.wNu);
          av((Bundle)localObject);
          AppMethodBeat.o(69147);
          return;
          ((Bundle)localObject).putBoolean("key_bind_card_can_pass_pwd", false);
        }
        getIntent().putExtra("process_id", com.tencent.mm.plugin.wallet_core.b.b.class.hashCode());
        com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet_core.b.b.class, (Bundle)localObject, null);
      }
      else
      {
        ae.i("MicroMsg.WalletBindUI", "user status unreg");
        this.CXO = true;
        if (this.CXQ >= 0)
        {
          this.xDC.dDI = this.CXQ;
          ((Bundle)localObject).putInt("key_bind_scene", this.xDC.dDI);
          if ((!this.CXR) || (bu.isNullOrNil(this.CXS))) {
            break label512;
          }
          ((Bundle)localObject).putBoolean("key_bind_card_can_pass_pwd", true);
          ((Bundle)localObject).putString("key_bind_card_user_token", this.CXS);
        }
        for (;;)
        {
          com.tencent.mm.wallet_core.b.fVf();
          if (!com.tencent.mm.wallet_core.b.b(com.tencent.mm.plugin.expt.b.b.a.qGD, false)) {
            break label522;
          }
          com.tencent.mm.sdk.b.a.IvT.b(this.wNu);
          av((Bundle)localObject);
          AppMethodBeat.o(69147);
          return;
          this.xDC.dDI = 1;
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
  
  private void VU(int paramInt)
  {
    AppMethodBeat.i(69159);
    if (getIntent().getBooleanExtra("from_kinda", false))
    {
      yl localyl = new yl();
      localyl.dNP.result = paramInt;
      com.tencent.mm.sdk.b.a.IvT.l(localyl);
    }
    AppMethodBeat.o(69159);
  }
  
  private void acP(String paramString)
  {
    AppMethodBeat.i(69157);
    String str = paramString;
    if (bu.isNullOrNil(paramString)) {
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
  
  private void av(Bundle paramBundle)
  {
    AppMethodBeat.i(69158);
    ae.d("MicroMsg.WalletBindUI", "startKindaBindCard");
    if (paramBundle != null)
    {
      ab.kI(6, paramBundle.getInt("key_bind_scene"));
      z.agV(paramBundle.getInt("key_bind_scene"));
    }
    for (;;)
    {
      ((com.tencent.mm.pluginsdk.wallet.a)g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).startBindCardUseCase(this, paramBundle);
      AppMethodBeat.o(69158);
      return;
      ab.kI(6, 0);
      z.agV(0);
    }
  }
  
  private void eGS()
  {
    AppMethodBeat.i(69146);
    this.xDC.dDI = this.CXQ;
    getInput().putParcelable("key_pay_info", this.xDC);
    if (this.CXQ == 2)
    {
      if (!bu.isNullOrNil(this.CXP))
      {
        ae.d("MicroMsg.WalletBindUI", "importKey " + this.CXP);
        doSceneForceProgress(new com.tencent.mm.plugin.wallet.bind.a.c(this.CXP, this.xDC));
        AppMethodBeat.o(69146);
        return;
      }
      acP("");
      AppMethodBeat.o(69146);
      return;
    }
    if (this.CXQ == 4)
    {
      z.agV(4);
      if (getIntent() == null)
      {
        acP("");
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
      if (this.CXQ == 6) {}
      for (this.CXT = new d(str1, str2, str3, str4, str5, str6, str7, 2, "getBrandWCPayCreateCreditCardRequest", i);; this.CXT = new d(str1, str2, str3, str4, str5, str6, str7, 1, "getBrandWCPayBindCardRequest", i))
      {
        doSceneForceProgress(this.CXT);
        AppMethodBeat.o(69146);
        return;
      }
    }
    if (this.CXQ == 6)
    {
      eGT();
      AppMethodBeat.o(69146);
      return;
    }
    VT(this.CXQ);
    AppMethodBeat.o(69146);
  }
  
  private void eGT()
  {
    AppMethodBeat.i(69148);
    s.eGW();
    if (s.eGX().eJM())
    {
      doSceneForceProgress(new ad(null, 12));
      AppMethodBeat.o(69148);
      return;
    }
    Object localObject1 = getIntent().getStringExtra("packageExt");
    Object localObject3 = ((String)localObject1).split("&");
    if ((!bu.isNullOrNil((String)localObject1)) && (localObject3.length >= 2))
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
      if ((!bu.isNullOrNil(str)) && (!bu.isNullOrNil((String)localObject1)))
      {
        s.eGW();
        if (s.eGX().aFO((String)localObject1))
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
        this.vRV.dnA();
        AppMethodBeat.o(69152);
        return;
      }
      this.vRV.cancel();
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
    this.vRV.DBE = new u.b()
    {
      public final int dnC()
      {
        return 1;
      }
      
      public final Context getContext()
      {
        return WalletBindUI.this;
      }
    };
    this.CXP = getIntent().getStringExtra("key_import_key");
    this.CXQ = getIntent().getIntExtra("key_bind_scene", -1);
    if (getIntent() != null) {
      i = getIntent().getIntExtra("key_bind_scene", 13);
    }
    paramBundle = new yq();
    if (i == 4) {}
    for (paramBundle.dNW.scene = 20;; paramBundle.dNW.scene = 13)
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
              
              public final void dnA()
              {
                AppMethodBeat.i(69133);
                WalletBindUI.c(WalletBindUI.this);
                AppMethodBeat.o(69133);
              }
              
              public final void dnB()
              {
                AppMethodBeat.i(69135);
                WalletBindUI.c(WalletBindUI.this);
                AppMethodBeat.o(69135);
              }
            }, localal.eJF());
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
      com.tencent.mm.sdk.b.a.IvT.l(paramBundle);
      com.tencent.mm.sdk.b.a.IvT.c(this.CXV);
      ab.kI(6, 0);
      AppMethodBeat.o(69145);
      return;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(69151);
    removeSceneEndListener(580);
    com.tencent.mm.sdk.b.a.IvT.d(this.CXV);
    super.onDestroy();
    AppMethodBeat.o(69151);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(69156);
    if (paramIntent == null)
    {
      ae.e("MicroMsg.WalletBindUI", "onNewIntent intent null");
      setResult(0);
      VU(0);
      finish();
      AppMethodBeat.o(69156);
      return;
    }
    super.onNewIntent(paramIntent);
    ae.v("MicroMsg.WalletBindUI", "onNewIntent");
    setIntent(paramIntent);
    if ((paramIntent != null) && (paramIntent.getBooleanExtra("intent_bind_end", false)))
    {
      ae.d("MicroMsg.WalletBindUI", "pay done... errCode:" + paramIntent.getBooleanExtra("intent_bind_end", false));
      setResult(-1, getIntent());
      VU(-1);
    }
    for (;;)
    {
      finish();
      AppMethodBeat.o(69156);
      return;
      ae.i("MicroMsg.WalletBindUI", "pay cancel");
      setResult(0);
      VU(0);
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(69150);
    super.onPause();
    this.vRV.onPause();
    AppMethodBeat.o(69150);
  }
  
  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(69155);
    super.onRestoreInstanceState(paramBundle);
    this.CXO = paramBundle.getBoolean("key_is_jump", false);
    AppMethodBeat.o(69155);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(69149);
    if (this.CXO) {
      finish();
    }
    super.onResume();
    this.vRV.onResume();
    AppMethodBeat.o(69149);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(69154);
    super.onSaveInstanceState(paramBundle);
    paramBundle.putBoolean("key_is_jump", this.CXO);
    AppMethodBeat.o(69154);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(69153);
    if ((paramn instanceof com.tencent.mm.plugin.wallet.bind.a.c)) {
      this.CXO = true;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramn instanceof ad))
      {
        if (this.CXQ == 6) {
          eGT();
        }
        for (;;)
        {
          AppMethodBeat.o(69153);
          return true;
          eGS();
        }
      }
      if ((paramn instanceof com.tencent.mm.plugin.wallet.bind.a.c))
      {
        paramn = (com.tencent.mm.plugin.wallet.bind.a.c)paramn;
        Bundle localBundle = getInput();
        localBundle.putBoolean("key_is_import_bind", true);
        if ((paramn.CQh != null) && (paramn.CQh.size() > 0))
        {
          paramString = (Bankcard)paramn.CQh.get(0);
          if (!paramString.Dmt)
          {
            localBundle.putBoolean("key_need_bind_response", true);
            localBundle.putString("kreq_token", paramn.token);
            localBundle.putString("key_bank_username", paramn.CWQ);
            localBundle.putString("key_recommand_desc", paramn.CWR);
            localBundle.putParcelable("key_import_bankcard", paramString);
            this.CXO = true;
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
          if (bu.isNullOrNil(paramString)) {
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
        if ((this.CXT != null) && (this.CXT.equals(paramn)))
        {
          e.aPm(((d)paramn).eIm());
          this.token = ((d)paramn).getToken();
          this.CXR = ((xt)((d)paramn).rr.hQE.hQJ).GpM;
          this.CXS = ((xt)((d)paramn).rr.hQE.hQJ).DgT;
          VT(4);
          AppMethodBeat.o(69153);
          return true;
        }
        z.fVV();
      }
      AppMethodBeat.o(69153);
      return false;
    }
    acP(paramString);
    AppMethodBeat.o(69153);
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.bind.ui.WalletBindUI
 * JD-Core Version:    0.7.0.1
 */