package com.tencent.mm.plugin.wallet.bind.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.c;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.acu;
import com.tencent.mm.autogen.a.acz;
import com.tencent.mm.autogen.a.ng;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.wallet_core.b.b.a;
import com.tencent.mm.plugin.wallet_core.c.ae;
import com.tencent.mm.plugin.wallet_core.c.d;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.e;
import com.tencent.mm.protocal.protobuf.abg;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.wallet_core.model.aa;
import com.tencent.mm.wallet_core.model.ac;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.ArrayList;

@com.tencent.mm.ui.base.a(7)
public class WalletBindUI
  extends WalletBaseUI
{
  private IListener<ng> Myr;
  private PayInfo Nxi;
  private boolean VkI;
  private String VkJ;
  private int VkK;
  private boolean VkL;
  private String VkM;
  private d VkN;
  private boolean VkO;
  IListener VkP;
  private String token;
  
  public WalletBindUI()
  {
    AppMethodBeat.i(69144);
    this.Nxi = new PayInfo();
    this.VkI = false;
    this.VkK = -1;
    this.token = null;
    this.VkL = false;
    this.VkM = null;
    this.VkN = null;
    this.VkO = false;
    this.VkP = new WalletBindUI.3(this, f.hfK);
    this.Myr = new IListener(f.hfK) {};
    AppMethodBeat.o(69144);
  }
  
  private void aoP(String paramString)
  {
    AppMethodBeat.i(69157);
    String str = paramString;
    if (Util.isNullOrNil(paramString)) {
      str = getString(a.i.wallet_unknown_err);
    }
    k.a(this, str, null, false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(69141);
        WalletBindUI.this.setResult(0);
        WalletBindUI.a(WalletBindUI.this, 0);
        WalletBindUI.this.finish();
        AppMethodBeat.o(69141);
      }
    });
    AppMethodBeat.o(69157);
  }
  
  private void arS(int paramInt)
  {
    AppMethodBeat.i(69147);
    Log.i("MicroMsg.WalletBindUI", "doBindCardForOtherScene " + Util.getStack().toString());
    Object localObject = getInput();
    ((Bundle)localObject).putParcelable("key_pay_info", this.Nxi);
    ((Bundle)localObject).putBoolean("key_need_bind_response", true);
    ((Bundle)localObject).putString("key_custom_bind_tips", getIntent().getStringExtra("key_custom_bind_tips"));
    boolean bool = getIntent().getBooleanExtra("from_kinda", false);
    if (bool)
    {
      ((Bundle)localObject).putBoolean("is_from_new_cashier", true);
      ((Bundle)localObject).putString("start_activity_class", getClass().getName());
    }
    com.tencent.mm.plugin.wallet.model.p.ifO();
    if (com.tencent.mm.plugin.wallet.model.p.ifP().ijl())
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
        localObject = com.tencent.mm.wallet_core.a.cm(this);
        if ((localObject instanceof com.tencent.mm.plugin.wallet_core.b.b)) {
          ((com.tencent.mm.plugin.wallet_core.b.b)localObject).Vxq = new b.a()
          {
            public final void run(int paramAnonymousInt)
            {
              AppMethodBeat.i(315568);
              if (paramAnonymousInt == -1)
              {
                WalletBindUI.this.setResult(-1);
                WalletBindUI.a(WalletBindUI.this, -1);
                AppMethodBeat.o(315568);
                return;
              }
              WalletBindUI.this.setResult(0);
              WalletBindUI.a(WalletBindUI.this, 0);
              AppMethodBeat.o(315568);
            }
          };
        }
      }
      AppMethodBeat.o(69147);
      return;
      doSceneForceProgress(new ae(null, 12));
      continue;
      com.tencent.mm.plugin.wallet.model.p.ifO();
      if (com.tencent.mm.plugin.wallet.model.p.ifP().ijf())
      {
        Log.i("MicroMsg.WalletBindUI", "user status reg");
        this.VkI = true;
        this.Nxi.hUS = this.VkK;
        ((Bundle)localObject).putInt("key_bind_scene", this.Nxi.hUS);
        if (!Util.isNullOrNil(this.token)) {
          ((Bundle)localObject).putString("kreq_token", this.token);
        }
        if ((this.VkL) && (!Util.isNullOrNil(this.VkM)))
        {
          ((Bundle)localObject).putBoolean("key_bind_card_can_pass_pwd", true);
          ((Bundle)localObject).putString("key_bind_card_user_token", this.VkM);
        }
        for (;;)
        {
          if (e.iOW() != null) {
            ((Bundle)localObject).putString("jsapi_reqkey", e.iOW());
          }
          com.tencent.mm.wallet_core.b.jNX();
          if (!com.tencent.mm.wallet_core.b.b(c.a.yWP, true)) {
            break;
          }
          this.Myr.alive();
          bg((Bundle)localObject);
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
        this.VkI = true;
        if (this.VkK >= 0)
        {
          this.Nxi.hUS = this.VkK;
          ((Bundle)localObject).putInt("key_bind_scene", this.Nxi.hUS);
          if ((!this.VkL) || (Util.isNullOrNil(this.VkM))) {
            break label514;
          }
          ((Bundle)localObject).putBoolean("key_bind_card_can_pass_pwd", true);
          ((Bundle)localObject).putString("key_bind_card_user_token", this.VkM);
        }
        for (;;)
        {
          com.tencent.mm.wallet_core.b.jNX();
          if (!com.tencent.mm.wallet_core.b.b(c.a.yWP, true)) {
            break label525;
          }
          this.Myr.alive();
          bg((Bundle)localObject);
          AppMethodBeat.o(69147);
          return;
          this.Nxi.hUS = 1;
          break;
          label514:
          ((Bundle)localObject).putBoolean("key_bind_card_can_pass_pwd", false);
        }
        label525:
        getIntent().putExtra("process_id", com.tencent.mm.plugin.wallet_core.b.b.class.hashCode());
        com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet_core.b.b.class, (Bundle)localObject, null);
      }
    }
  }
  
  private void arT(int paramInt)
  {
    AppMethodBeat.i(69159);
    if (getIntent().getBooleanExtra("from_kinda", false))
    {
      acu localacu = new acu();
      localacu.igi.result = paramInt;
      localacu.publish();
    }
    AppMethodBeat.o(69159);
  }
  
  private void bg(Bundle paramBundle)
  {
    AppMethodBeat.i(69158);
    Log.d("MicroMsg.WalletBindUI", "startKindaBindCard");
    if (paramBundle != null)
    {
      ac.pu(6, paramBundle.getInt("key_bind_scene"));
      aa.aGq(paramBundle.getInt("key_bind_scene"));
    }
    for (;;)
    {
      ((com.tencent.mm.pluginsdk.wallet.a)h.ax(com.tencent.mm.pluginsdk.wallet.a.class)).startBindCardUseCase(this, paramBundle);
      AppMethodBeat.o(69158);
      return;
      ac.pu(6, 0);
      aa.aGq(0);
    }
  }
  
  private void ifK()
  {
    AppMethodBeat.i(69146);
    this.Nxi.hUS = this.VkK;
    getInput().putParcelable("key_pay_info", this.Nxi);
    if (this.VkK == 2)
    {
      if (!Util.isNullOrNil(this.VkJ))
      {
        Log.d("MicroMsg.WalletBindUI", "importKey " + this.VkJ);
        doSceneForceProgress(new com.tencent.mm.plugin.wallet.bind.a.c(this.VkJ, this.Nxi));
        AppMethodBeat.o(69146);
        return;
      }
      aoP("");
      AppMethodBeat.o(69146);
      return;
    }
    if (this.VkK == 4)
    {
      aa.aGq(4);
      if (getIntent() == null)
      {
        aoP("");
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
      if (this.VkK == 6) {}
      for (this.VkN = new d(str1, str2, str3, str4, str5, str6, str7, 2, "getBrandWCPayCreateCreditCardRequest", i);; this.VkN = new d(str1, str2, str3, str4, str5, str6, str7, 1, "getBrandWCPayBindCardRequest", i))
      {
        doSceneForceProgress(this.VkN);
        AppMethodBeat.o(69146);
        return;
      }
    }
    if (this.VkK == 6)
    {
      ifL();
      AppMethodBeat.o(69146);
      return;
    }
    arS(this.VkK);
    AppMethodBeat.o(69146);
  }
  
  private void ifL()
  {
    AppMethodBeat.i(69148);
    com.tencent.mm.plugin.wallet.model.p.ifO();
    if (com.tencent.mm.plugin.wallet.model.p.ifP().ijl())
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
        com.tencent.mm.plugin.wallet.model.p.ifO();
        if (com.tencent.mm.plugin.wallet.model.p.ifP().bgF((String)localObject1))
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
    AppMethodBeat.o(69152);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    int i = -1;
    AppMethodBeat.i(69145);
    super.onCreate(paramBundle);
    addSceneEndListener(580);
    this.VkJ = getIntent().getStringExtra("key_import_key");
    this.VkK = getIntent().getIntExtra("key_req_bind_scene", -1);
    if (getIntent() != null) {
      i = getIntent().getIntExtra("key_req_bind_scene", 13);
    }
    paramBundle = new acz();
    if (i == 4) {}
    for (paramBundle.igq.scene = 20;; paramBundle.igq.scene = 13)
    {
      paramBundle.callback = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(315575);
          if (WalletBindUI.a(WalletBindUI.this))
          {
            AppMethodBeat.o(315575);
            return;
          }
          WalletBindUI.b(WalletBindUI.this);
          if (!WalletBindUI.a(WalletBindUI.this)) {
            WalletBindUI.c(WalletBindUI.this);
          }
          AppMethodBeat.o(315575);
        }
      };
      paramBundle.publish();
      this.VkP.alive();
      ac.pu(6, 0);
      AppMethodBeat.o(69145);
      return;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(69151);
    removeSceneEndListener(580);
    this.VkP.dead();
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
      arT(0);
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
      arT(-1);
    }
    for (;;)
    {
      finish();
      AppMethodBeat.o(69156);
      return;
      Log.i("MicroMsg.WalletBindUI", "pay cancel");
      setResult(0);
      arT(0);
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(69150);
    super.onPause();
    AppMethodBeat.o(69150);
  }
  
  public void onRestoreInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(69155);
    super.onRestoreInstanceState(paramBundle);
    this.VkI = paramBundle.getBoolean("key_is_jump", false);
    AppMethodBeat.o(69155);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(69149);
    if (this.VkI) {
      finish();
    }
    super.onResume();
    AppMethodBeat.o(69149);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(69154);
    super.onSaveInstanceState(paramBundle);
    paramBundle.putBoolean("key_is_jump", this.VkI);
    AppMethodBeat.o(69154);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(69153);
    if ((paramp instanceof com.tencent.mm.plugin.wallet.bind.a.c)) {
      this.VkI = true;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramp instanceof ae))
      {
        if (this.VkK == 6) {
          ifL();
        }
        for (;;)
        {
          AppMethodBeat.o(69153);
          return true;
          ifK();
        }
      }
      if ((paramp instanceof com.tencent.mm.plugin.wallet.bind.a.c))
      {
        paramp = (com.tencent.mm.plugin.wallet.bind.a.c)paramp;
        Bundle localBundle = getInput();
        localBundle.putBoolean("key_is_import_bind", true);
        if ((paramp.Vbt != null) && (paramp.Vbt.size() > 0))
        {
          paramString = (Bankcard)paramp.Vbt.get(0);
          if (!paramString.hIt)
          {
            localBundle.putBoolean("key_need_bind_response", true);
            localBundle.putString("kreq_token", paramp.token);
            localBundle.putString("key_bank_username", paramp.VjD);
            localBundle.putString("key_recommand_desc", paramp.VjE);
            localBundle.putParcelable("key_import_bankcard", paramString);
            this.VkI = true;
            localBundle.putInt("key_bind_scene", 2);
            com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet_core.b.b.class, localBundle, new WalletBindUI.4(this));
          }
        }
        for (;;)
        {
          AppMethodBeat.o(69153);
          return true;
          k.a(this, a.i.wallet_card_import_exist, 0, false, new WalletBindUI.5(this));
          continue;
          paramp = paramString;
          if (Util.isNullOrNil(paramString)) {
            paramp = getString(a.i.wallet_bind_import_fail);
          }
          k.a(this, paramp, null, false, new WalletBindUI.6(this));
        }
      }
      if ((paramp instanceof d))
      {
        if ((this.VkN != null) && (this.VkN.equals(paramp)))
        {
          e.brZ(((d)paramp).ihJ());
          this.token = ((d)paramp).getToken();
          this.VkL = ((abg)c.c.b(((d)paramp).rr.otC)).ZjR;
          this.VkM = ((abg)c.c.b(((d)paramp).rr.otC)).Vyh;
          arS(4);
          AppMethodBeat.o(69153);
          return true;
        }
        aa.jOQ();
      }
      AppMethodBeat.o(69153);
      return false;
    }
    aoP(paramString);
    AppMethodBeat.o(69153);
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.bind.ui.WalletBindUI
 * JD-Core Version:    0.7.0.1
 */