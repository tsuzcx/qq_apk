package com.tencent.mm.plugin.wallet.bind.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.lj;
import com.tencent.mm.g.a.zq;
import com.tencent.mm.g.a.zr;
import com.tencent.mm.g.a.zv;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet.bind.a.c;
import com.tencent.mm.plugin.wallet_core.c.ad;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.al;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.ui.u;
import com.tencent.mm.plugin.wallet_core.ui.u.a;
import com.tencent.mm.plugin.wallet_core.ui.u.b;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.e;
import com.tencent.mm.protocal.protobuf.zf;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
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
  private IListener<lj> AJa;
  private PayInfo BDB;
  private boolean HDC;
  private String HDD;
  private int HDE;
  private boolean HDF;
  private String HDG;
  private com.tencent.mm.plugin.wallet_core.c.d HDH;
  private boolean HDI;
  IListener HDJ;
  private String token;
  private u zmb;
  
  public WalletBindUI()
  {
    AppMethodBeat.i(69144);
    this.BDB = new PayInfo();
    this.HDC = false;
    this.HDE = -1;
    this.token = null;
    this.HDF = false;
    this.HDG = null;
    this.HDH = null;
    this.HDI = false;
    this.zmb = new u();
    this.HDJ = new IListener() {};
    this.AJa = new IListener() {};
    AppMethodBeat.o(69144);
  }
  
  private void aH(Bundle paramBundle)
  {
    AppMethodBeat.i(69158);
    Log.d("MicroMsg.WalletBindUI", "startKindaBindCard");
    if (paramBundle != null)
    {
      ab.mg(6, paramBundle.getInt("key_bind_scene"));
      z.aqh(paramBundle.getInt("key_bind_scene"));
    }
    for (;;)
    {
      ((com.tencent.mm.pluginsdk.wallet.a)g.af(com.tencent.mm.pluginsdk.wallet.a.class)).startBindCardUseCase(this, paramBundle);
      AppMethodBeat.o(69158);
      return;
      ab.mg(6, 0);
      z.aqh(0);
    }
  }
  
  private void aev(int paramInt)
  {
    AppMethodBeat.i(69147);
    Log.i("MicroMsg.WalletBindUI", "doBindCardForOtherScene " + Util.getStack().toString());
    Object localObject = getInput();
    ((Bundle)localObject).putParcelable("key_pay_info", this.BDB);
    ((Bundle)localObject).putBoolean("key_need_bind_response", true);
    ((Bundle)localObject).putString("key_custom_bind_tips", getIntent().getStringExtra("key_custom_bind_tips"));
    boolean bool = getIntent().getBooleanExtra("from_kinda", false);
    if (bool)
    {
      ((Bundle)localObject).putBoolean("is_from_new_cashier", true);
      ((Bundle)localObject).putString("start_activity_class", getClass().getName());
    }
    s.fOg();
    if (s.fOh().fRp())
    {
      Log.i("MicroMsg.WalletBindUI", "user status invalid");
      if (paramInt == 4) {
        doSceneForceProgress(new ad(null, 20));
      }
    }
    for (;;)
    {
      if (bool)
      {
        localObject = com.tencent.mm.wallet_core.a.by(this);
        if ((localObject instanceof com.tencent.mm.plugin.wallet_core.b.b)) {
          ((com.tencent.mm.plugin.wallet_core.b.b)localObject).HPw = new com.tencent.mm.plugin.wallet_core.b.b.a()
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
      s.fOg();
      if (s.fOh().fRk())
      {
        Log.i("MicroMsg.WalletBindUI", "user status reg");
        this.HDC = true;
        this.BDB.dVw = this.HDE;
        ((Bundle)localObject).putInt("key_bind_scene", this.BDB.dVw);
        if (!Util.isNullOrNil(this.token)) {
          ((Bundle)localObject).putString("kreq_token", this.token);
        }
        if ((this.HDF) && (!Util.isNullOrNil(this.HDG)))
        {
          ((Bundle)localObject).putBoolean("key_bind_card_can_pass_pwd", true);
          ((Bundle)localObject).putString("key_bind_card_user_token", this.HDG);
        }
        for (;;)
        {
          if (e.gsR() != null) {
            ((Bundle)localObject).putString("jsapi_reqkey", e.gsR());
          }
          com.tencent.mm.wallet_core.b.hgC();
          if (!com.tencent.mm.wallet_core.b.b(com.tencent.mm.plugin.expt.b.b.a.rZU, true)) {
            break;
          }
          EventCenter.instance.add(this.AJa);
          aH((Bundle)localObject);
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
        this.HDC = true;
        if (this.HDE >= 0)
        {
          this.BDB.dVw = this.HDE;
          ((Bundle)localObject).putInt("key_bind_scene", this.BDB.dVw);
          if ((!this.HDF) || (Util.isNullOrNil(this.HDG))) {
            break label523;
          }
          ((Bundle)localObject).putBoolean("key_bind_card_can_pass_pwd", true);
          ((Bundle)localObject).putString("key_bind_card_user_token", this.HDG);
        }
        for (;;)
        {
          com.tencent.mm.wallet_core.b.hgC();
          if (!com.tencent.mm.wallet_core.b.b(com.tencent.mm.plugin.expt.b.b.a.rZU, true)) {
            break label534;
          }
          EventCenter.instance.add(this.AJa);
          aH((Bundle)localObject);
          AppMethodBeat.o(69147);
          return;
          this.BDB.dVw = 1;
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
  
  private void aew(int paramInt)
  {
    AppMethodBeat.i(69159);
    if (getIntent().getBooleanExtra("from_kinda", false))
    {
      zq localzq = new zq();
      localzq.efK.result = paramInt;
      EventCenter.instance.publish(localzq);
    }
    AppMethodBeat.o(69159);
  }
  
  private void amW(String paramString)
  {
    AppMethodBeat.i(69157);
    String str = paramString;
    if (Util.isNullOrNil(paramString)) {
      str = getString(2131768354);
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
  
  private void fOc()
  {
    AppMethodBeat.i(69146);
    this.BDB.dVw = this.HDE;
    getInput().putParcelable("key_pay_info", this.BDB);
    if (this.HDE == 2)
    {
      if (!Util.isNullOrNil(this.HDD))
      {
        Log.d("MicroMsg.WalletBindUI", "importKey " + this.HDD);
        doSceneForceProgress(new c(this.HDD, this.BDB));
        AppMethodBeat.o(69146);
        return;
      }
      amW("");
      AppMethodBeat.o(69146);
      return;
    }
    if (this.HDE == 4)
    {
      z.aqh(4);
      if (getIntent() == null)
      {
        amW("");
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
      if (this.HDE == 6) {}
      for (this.HDH = new com.tencent.mm.plugin.wallet_core.c.d(str1, str2, str3, str4, str5, str6, str7, 2, "getBrandWCPayCreateCreditCardRequest", i);; this.HDH = new com.tencent.mm.plugin.wallet_core.c.d(str1, str2, str3, str4, str5, str6, str7, 1, "getBrandWCPayBindCardRequest", i))
      {
        doSceneForceProgress(this.HDH);
        AppMethodBeat.o(69146);
        return;
      }
    }
    if (this.HDE == 6)
    {
      fOd();
      AppMethodBeat.o(69146);
      return;
    }
    aev(this.HDE);
    AppMethodBeat.o(69146);
  }
  
  private void fOd()
  {
    AppMethodBeat.i(69148);
    s.fOg();
    if (s.fOh().fRp())
    {
      doSceneForceProgress(new ad(null, 12));
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
        s.fOg();
        if (s.fOh().aVn((String)localObject1))
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
        this.zmb.ehm();
        AppMethodBeat.o(69152);
        return;
      }
      this.zmb.cancel();
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
    this.zmb.IkQ = new u.b()
    {
      public final int eho()
      {
        return 1;
      }
      
      public final Context getContext()
      {
        return WalletBindUI.this;
      }
    };
    this.HDD = getIntent().getStringExtra("key_import_key");
    this.HDE = getIntent().getIntExtra("key_bind_scene", -1);
    if (getIntent() != null) {
      i = getIntent().getIntExtra("key_bind_scene", 13);
    }
    paramBundle = new zv();
    if (i == 4) {}
    for (paramBundle.efR.scene = 20;; paramBundle.efR.scene = 13)
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
              
              public final void ehm()
              {
                AppMethodBeat.i(69133);
                WalletBindUI.c(WalletBindUI.this);
                AppMethodBeat.o(69133);
              }
              
              public final void ehn()
              {
                AppMethodBeat.i(69135);
                WalletBindUI.c(WalletBindUI.this);
                AppMethodBeat.o(69135);
              }
            }, localal.fRi());
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
      EventCenter.instance.addListener(this.HDJ);
      ab.mg(6, 0);
      AppMethodBeat.o(69145);
      return;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(69151);
    removeSceneEndListener(580);
    EventCenter.instance.removeListener(this.HDJ);
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
      aew(0);
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
      aew(-1);
    }
    for (;;)
    {
      finish();
      AppMethodBeat.o(69156);
      return;
      Log.i("MicroMsg.WalletBindUI", "pay cancel");
      setResult(0);
      aew(0);
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(69150);
    super.onPause();
    this.zmb.onPause();
    AppMethodBeat.o(69150);
  }
  
  public void onRestoreInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(69155);
    super.onRestoreInstanceState(paramBundle);
    this.HDC = paramBundle.getBoolean("key_is_jump", false);
    AppMethodBeat.o(69155);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(69149);
    if (this.HDC) {
      finish();
    }
    super.onResume();
    this.zmb.onResume();
    AppMethodBeat.o(69149);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(69154);
    super.onSaveInstanceState(paramBundle);
    paramBundle.putBoolean("key_is_jump", this.HDC);
    AppMethodBeat.o(69154);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(69153);
    if ((paramq instanceof c)) {
      this.HDC = true;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramq instanceof ad))
      {
        if (this.HDE == 6) {
          fOd();
        }
        for (;;)
        {
          AppMethodBeat.o(69153);
          return true;
          fOc();
        }
      }
      if ((paramq instanceof c))
      {
        paramq = (c)paramq;
        Bundle localBundle = getInput();
        localBundle.putBoolean("key_is_import_bind", true);
        if ((paramq.Hva != null) && (paramq.Hva.size() > 0))
        {
          paramString = (Bankcard)paramq.Hva.get(0);
          if (!paramString.dKO)
          {
            localBundle.putBoolean("key_need_bind_response", true);
            localBundle.putString("kreq_token", paramq.token);
            localBundle.putString("key_bank_username", paramq.HCw);
            localBundle.putString("key_recommand_desc", paramq.HCx);
            localBundle.putParcelable("key_import_bankcard", paramString);
            this.HDC = true;
            localBundle.putInt("key_bind_scene", 2);
            com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet_core.b.b.class, localBundle, new d.a()
            {
              public final Intent q(int paramAnonymousInt, Bundle paramAnonymousBundle)
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
          h.a(this, 2131767583, 0, false, new DialogInterface.OnClickListener()
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
            paramq = getString(2131767512);
          }
          h.a(this, paramq, null, false, new DialogInterface.OnClickListener()
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
        if ((this.HDH != null) && (this.HDH.equals(paramq)))
        {
          e.bfP(((com.tencent.mm.plugin.wallet_core.c.d)paramq).fPP());
          this.token = ((com.tencent.mm.plugin.wallet_core.c.d)paramq).getToken();
          this.HDF = ((zf)((com.tencent.mm.plugin.wallet_core.c.d)paramq).rr.iLL.iLR).Lky;
          this.HDG = ((zf)((com.tencent.mm.plugin.wallet_core.c.d)paramq).rr.iLL.iLR).HQm;
          aev(4);
          AppMethodBeat.o(69153);
          return true;
        }
        z.hhs();
      }
      AppMethodBeat.o(69153);
      return false;
    }
    amW(paramString);
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