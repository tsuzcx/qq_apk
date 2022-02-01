package com.tencent.mm.plugin.wallet.bind.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.q;
import com.tencent.mm.f.a.aax;
import com.tencent.mm.f.a.aay;
import com.tencent.mm.f.a.abc;
import com.tencent.mm.f.a.ma;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet.bind.a.c;
import com.tencent.mm.plugin.wallet_core.c.ae;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.ao;
import com.tencent.mm.plugin.wallet_core.ui.v;
import com.tencent.mm.plugin.wallet_core.ui.v.a;
import com.tencent.mm.plugin.wallet_core.ui.v.b;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.e;
import com.tencent.mm.protocal.protobuf.zj;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.c.ab;
import com.tencent.mm.wallet_core.c.z;
import com.tencent.mm.wallet_core.d.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.ArrayList;

@com.tencent.mm.ui.base.a(7)
public class WalletBindUI
  extends WalletBaseUI
{
  private v ERr;
  private IListener<ma> GCj;
  private PayInfo HzF;
  private com.tencent.mm.plugin.wallet_core.c.d OvA;
  private boolean OvB;
  IListener OvC;
  private boolean Ovv;
  private String Ovw;
  private int Ovx;
  private boolean Ovy;
  private String Ovz;
  private String token;
  
  public WalletBindUI()
  {
    AppMethodBeat.i(69144);
    this.HzF = new PayInfo();
    this.Ovv = false;
    this.Ovx = -1;
    this.token = null;
    this.Ovy = false;
    this.Ovz = null;
    this.OvA = null;
    this.OvB = false;
    this.ERr = new v();
    this.OvC = new IListener() {};
    this.GCj = new IListener() {};
    AppMethodBeat.o(69144);
  }
  
  private void aD(Bundle paramBundle)
  {
    AppMethodBeat.i(69158);
    Log.d("MicroMsg.WalletBindUI", "startKindaBindCard");
    if (paramBundle != null)
    {
      ab.ny(6, paramBundle.getInt("key_bind_scene"));
      z.azF(paramBundle.getInt("key_bind_scene"));
    }
    for (;;)
    {
      ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.pluginsdk.wallet.a.class)).startBindCardUseCase(this, paramBundle);
      AppMethodBeat.o(69158);
      return;
      ab.ny(6, 0);
      z.azF(0);
    }
  }
  
  private void ami(int paramInt)
  {
    AppMethodBeat.i(69147);
    Log.i("MicroMsg.WalletBindUI", "doBindCardForOtherScene " + Util.getStack().toString());
    Object localObject = getInput();
    ((Bundle)localObject).putParcelable("key_pay_info", this.HzF);
    ((Bundle)localObject).putBoolean("key_need_bind_response", true);
    ((Bundle)localObject).putString("key_custom_bind_tips", getIntent().getStringExtra("key_custom_bind_tips"));
    boolean bool = getIntent().getBooleanExtra("from_kinda", false);
    if (bool)
    {
      ((Bundle)localObject).putBoolean("is_from_new_cashier", true);
      ((Bundle)localObject).putString("start_activity_class", getClass().getName());
    }
    s.gGL();
    if (s.gGM().gJV())
    {
      Log.i("MicroMsg.WalletBindUI", "user status invalid");
      if (paramInt == 4) {
        doSceneForceProgress(new ae(null, 20));
      }
    }
    for (;;)
    {
      if (bool)
      {
        localObject = com.tencent.mm.wallet_core.a.bF(this);
        if ((localObject instanceof com.tencent.mm.plugin.wallet_core.b.b)) {
          ((com.tencent.mm.plugin.wallet_core.b.b)localObject).OHE = new com.tencent.mm.plugin.wallet_core.b.b.a()
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
      doSceneForceProgress(new ae(null, 12));
      continue;
      s.gGL();
      if (s.gGM().gJQ())
      {
        Log.i("MicroMsg.WalletBindUI", "user status reg");
        this.Ovv = true;
        this.HzF.fOZ = this.Ovx;
        ((Bundle)localObject).putInt("key_bind_scene", this.HzF.fOZ);
        if (!Util.isNullOrNil(this.token)) {
          ((Bundle)localObject).putString("kreq_token", this.token);
        }
        if ((this.Ovy) && (!Util.isNullOrNil(this.Ovz)))
        {
          ((Bundle)localObject).putBoolean("key_bind_card_can_pass_pwd", true);
          ((Bundle)localObject).putString("key_bind_card_user_token", this.Ovz);
        }
        for (;;)
        {
          if (e.hoe() != null) {
            ((Bundle)localObject).putString("jsapi_reqkey", e.hoe());
          }
          com.tencent.mm.wallet_core.b.iie();
          if (!com.tencent.mm.wallet_core.b.b(com.tencent.mm.plugin.expt.b.b.a.vGW, true)) {
            break;
          }
          EventCenter.instance.add(this.GCj);
          aD((Bundle)localObject);
          AppMethodBeat.o(69147);
          return;
          ((Bundle)localObject).putBoolean("key_bind_card_can_pass_pwd", false);
        }
        getIntent().putExtra("process_id", com.tencent.mm.plugin.wallet_core.b.b.class.hashCode());
        com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet_core.b.b.class, (Bundle)localObject, null);
      }
      else
      {
        Log.i("MicroMsg.WalletBindUI", "user status unreg");
        this.Ovv = true;
        if (this.Ovx >= 0)
        {
          this.HzF.fOZ = this.Ovx;
          ((Bundle)localObject).putInt("key_bind_scene", this.HzF.fOZ);
          if ((!this.Ovy) || (Util.isNullOrNil(this.Ovz))) {
            break label523;
          }
          ((Bundle)localObject).putBoolean("key_bind_card_can_pass_pwd", true);
          ((Bundle)localObject).putString("key_bind_card_user_token", this.Ovz);
        }
        for (;;)
        {
          com.tencent.mm.wallet_core.b.iie();
          if (!com.tencent.mm.wallet_core.b.b(com.tencent.mm.plugin.expt.b.b.a.vGW, true)) {
            break label534;
          }
          EventCenter.instance.add(this.GCj);
          aD((Bundle)localObject);
          AppMethodBeat.o(69147);
          return;
          this.HzF.fOZ = 1;
          break;
          label523:
          ((Bundle)localObject).putBoolean("key_bind_card_can_pass_pwd", false);
        }
        label534:
        getIntent().putExtra("process_id", com.tencent.mm.plugin.wallet_core.b.b.class.hashCode());
        com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet_core.b.b.class, (Bundle)localObject, null);
      }
    }
  }
  
  private void amj(int paramInt)
  {
    AppMethodBeat.i(69159);
    if (getIntent().getBooleanExtra("from_kinda", false))
    {
      aax localaax = new aax();
      localaax.gaa.result = paramInt;
      EventCenter.instance.publish(localaax);
    }
    AppMethodBeat.o(69159);
  }
  
  private void auQ(String paramString)
  {
    AppMethodBeat.i(69157);
    String str = paramString;
    if (Util.isNullOrNil(paramString)) {
      str = getString(a.i.wallet_unknown_err);
    }
    com.tencent.mm.ui.base.h.a(this, str, null, false, new DialogInterface.OnClickListener()
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
  
  private void gGH()
  {
    AppMethodBeat.i(69146);
    this.HzF.fOZ = this.Ovx;
    getInput().putParcelable("key_pay_info", this.HzF);
    if (this.Ovx == 2)
    {
      if (!Util.isNullOrNil(this.Ovw))
      {
        Log.d("MicroMsg.WalletBindUI", "importKey " + this.Ovw);
        doSceneForceProgress(new c(this.Ovw, this.HzF));
        AppMethodBeat.o(69146);
        return;
      }
      auQ("");
      AppMethodBeat.o(69146);
      return;
    }
    if (this.Ovx == 4)
    {
      z.azF(4);
      if (getIntent() == null)
      {
        auQ("");
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
      if (this.Ovx == 6) {}
      for (this.OvA = new com.tencent.mm.plugin.wallet_core.c.d(str1, str2, str3, str4, str5, str6, str7, 2, "getBrandWCPayCreateCreditCardRequest", i);; this.OvA = new com.tencent.mm.plugin.wallet_core.c.d(str1, str2, str3, str4, str5, str6, str7, 1, "getBrandWCPayBindCardRequest", i))
      {
        doSceneForceProgress(this.OvA);
        AppMethodBeat.o(69146);
        return;
      }
    }
    if (this.Ovx == 6)
    {
      gGI();
      AppMethodBeat.o(69146);
      return;
    }
    ami(this.Ovx);
    AppMethodBeat.o(69146);
  }
  
  private void gGI()
  {
    AppMethodBeat.i(69148);
    s.gGL();
    if (s.gGM().gJV())
    {
      doSceneForceProgress(new ae(null, 12));
      AppMethodBeat.o(69148);
      return;
    }
    Object localObject1 = getIntent().getStringExtra("packageExt");
    Object localObject3 = ((String)localObject1).split("&");
    if ((!Util.isNullOrNil((String)localObject1)) && (localObject3.length >= 2))
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
      if ((!Util.isNullOrNil(str)) && (!Util.isNullOrNil((String)localObject1)))
      {
        s.gGL();
        if (s.gGM().bgW((String)localObject1))
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
        this.ERr.eQT();
        AppMethodBeat.o(69152);
        return;
      }
      this.ERr.cancel();
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
    this.ERr.Pdi = new v.b()
    {
      public final int eQV()
      {
        return 1;
      }
      
      public final Context getContext()
      {
        return WalletBindUI.this;
      }
    };
    this.Ovw = getIntent().getStringExtra("key_import_key");
    this.Ovx = getIntent().getIntExtra("key_bind_scene", -1);
    if (getIntent() != null) {
      i = getIntent().getIntExtra("key_bind_scene", 13);
    }
    paramBundle = new abc();
    if (i == 4) {}
    for (paramBundle.gah.scene = 20;; paramBundle.gah.scene = 13)
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
            am localam = new am();
            WalletBindUI.d(WalletBindUI.this).a(new v.a()
            {
              public final void cancel()
              {
                AppMethodBeat.i(69134);
                WalletBindUI.this.finish();
                AppMethodBeat.o(69134);
              }
              
              public final void eQT()
              {
                AppMethodBeat.i(69133);
                WalletBindUI.c(WalletBindUI.this);
                AppMethodBeat.o(69133);
              }
              
              public final void eQU()
              {
                AppMethodBeat.i(69135);
                WalletBindUI.c(WalletBindUI.this);
                AppMethodBeat.o(69135);
              }
            }, localam.gJO());
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
      EventCenter.instance.publish(paramBundle);
      EventCenter.instance.addListener(this.OvC);
      ab.ny(6, 0);
      AppMethodBeat.o(69145);
      return;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(69151);
    removeSceneEndListener(580);
    EventCenter.instance.removeListener(this.OvC);
    super.onDestroy();
    AppMethodBeat.o(69151);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(69156);
    if (paramIntent == null)
    {
      Log.e("MicroMsg.WalletBindUI", "onNewIntent intent null");
      setResult(0);
      amj(0);
      finish();
      AppMethodBeat.o(69156);
      return;
    }
    super.onNewIntent(paramIntent);
    Log.v("MicroMsg.WalletBindUI", "onNewIntent");
    setIntent(paramIntent);
    if ((paramIntent != null) && (paramIntent.getBooleanExtra("intent_bind_end", false)))
    {
      Log.d("MicroMsg.WalletBindUI", "pay done... errCode:" + paramIntent.getBooleanExtra("intent_bind_end", false));
      setResult(-1, getIntent());
      amj(-1);
    }
    for (;;)
    {
      finish();
      AppMethodBeat.o(69156);
      return;
      Log.i("MicroMsg.WalletBindUI", "pay cancel");
      setResult(0);
      amj(0);
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(69150);
    super.onPause();
    this.ERr.onPause();
    AppMethodBeat.o(69150);
  }
  
  public void onRestoreInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(69155);
    super.onRestoreInstanceState(paramBundle);
    this.Ovv = paramBundle.getBoolean("key_is_jump", false);
    AppMethodBeat.o(69155);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(69149);
    if (this.Ovv) {
      finish();
    }
    super.onResume();
    this.ERr.onResume();
    AppMethodBeat.o(69149);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(69154);
    super.onSaveInstanceState(paramBundle);
    paramBundle.putBoolean("key_is_jump", this.Ovv);
    AppMethodBeat.o(69154);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(69153);
    if ((paramq instanceof c)) {
      this.Ovv = true;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramq instanceof ae))
      {
        if (this.Ovx == 6) {
          gGI();
        }
        for (;;)
        {
          AppMethodBeat.o(69153);
          return true;
          gGH();
        }
      }
      if ((paramq instanceof c))
      {
        paramq = (c)paramq;
        Bundle localBundle = getInput();
        localBundle.putBoolean("key_is_import_bind", true);
        if ((paramq.OmN != null) && (paramq.OmN.size() > 0))
        {
          paramString = (Bankcard)paramq.OmN.get(0);
          if (!paramString.fDD)
          {
            localBundle.putBoolean("key_need_bind_response", true);
            localBundle.putString("kreq_token", paramq.token);
            localBundle.putString("key_bank_username", paramq.Oup);
            localBundle.putString("key_recommand_desc", paramq.Ouq);
            localBundle.putParcelable("key_import_bankcard", paramString);
            this.Ovv = true;
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
          com.tencent.mm.ui.base.h.a(this, a.i.wallet_card_import_exist, 0, false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(69140);
              WalletBindUI.this.finish();
              AppMethodBeat.o(69140);
            }
          });
          continue;
          paramq = paramString;
          if (Util.isNullOrNil(paramString)) {
            paramq = getString(a.i.wallet_bind_import_fail);
          }
          com.tencent.mm.ui.base.h.a(this, paramq, null, false, new DialogInterface.OnClickListener()
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
      if ((paramq instanceof com.tencent.mm.plugin.wallet_core.c.d))
      {
        if ((this.OvA != null) && (this.OvA.equals(paramq)))
        {
          e.bsi(((com.tencent.mm.plugin.wallet_core.c.d)paramq).gIv());
          this.token = ((com.tencent.mm.plugin.wallet_core.c.d)paramq).getToken();
          this.Ovy = ((zj)d.c.b(((com.tencent.mm.plugin.wallet_core.c.d)paramq).rr.lBS)).SlH;
          this.Ovz = ((zj)d.c.b(((com.tencent.mm.plugin.wallet_core.c.d)paramq).rr.lBS)).OIv;
          ami(4);
          AppMethodBeat.o(69153);
          return true;
        }
        z.iiU();
      }
      AppMethodBeat.o(69153);
      return false;
    }
    auQ(paramString);
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