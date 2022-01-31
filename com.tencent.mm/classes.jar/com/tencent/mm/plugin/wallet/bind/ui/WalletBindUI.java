package com.tencent.mm.plugin.wallet.bind.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.vf;
import com.tencent.mm.plugin.wallet_core.b.b;
import com.tencent.mm.plugin.wallet_core.c.d;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.g;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c.x;
import com.tencent.mm.wallet_core.c.z;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.ArrayList;

@com.tencent.mm.ui.base.a(7)
public class WalletBindUI
  extends WalletBaseUI
{
  private com.tencent.mm.plugin.wallet_core.ui.s oAh;
  private PayInfo pVo;
  private boolean tTq;
  private String tTr;
  private int tTs;
  private d tTt;
  private boolean tTu;
  com.tencent.mm.sdk.b.c tTv;
  private String token;
  
  public WalletBindUI()
  {
    AppMethodBeat.i(45803);
    this.pVo = new PayInfo();
    this.tTq = false;
    this.tTs = -1;
    this.token = null;
    this.tTt = null;
    this.tTu = false;
    this.oAh = new com.tencent.mm.plugin.wallet_core.ui.s();
    this.tTv = new WalletBindUI.3(this);
    AppMethodBeat.o(45803);
  }
  
  private void Im(int paramInt)
  {
    AppMethodBeat.i(45806);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletBindUI", "doBindCardForOtherScene " + bo.dtY().toString());
    Bundle localBundle = getInput();
    localBundle.putParcelable("key_pay_info", this.pVo);
    localBundle.putBoolean("key_need_bind_response", true);
    localBundle.putString("key_custom_bind_tips", getIntent().getStringExtra("key_custom_bind_tips"));
    com.tencent.mm.plugin.wallet.a.s.cRG();
    if (com.tencent.mm.plugin.wallet.a.s.cRH().cUq())
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletBindUI", "user status invalid");
      if (paramInt == 4)
      {
        doSceneForceProgress(new com.tencent.mm.plugin.wallet_core.c.ab(null, 20));
        AppMethodBeat.o(45806);
        return;
      }
      doSceneForceProgress(new com.tencent.mm.plugin.wallet_core.c.ab(null, 12));
      AppMethodBeat.o(45806);
      return;
    }
    com.tencent.mm.plugin.wallet.a.s.cRG();
    if (com.tencent.mm.plugin.wallet.a.s.cRH().cUl())
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletBindUI", "user status reg");
      this.tTq = true;
      this.pVo.cCE = this.tTs;
      localBundle.putInt("key_bind_scene", this.pVo.cCE);
      if (!bo.isNullOrNil(this.token)) {
        localBundle.putString("kreq_token", this.token);
      }
      com.tencent.mm.wallet_core.a.a(this, b.class, localBundle, null);
      AppMethodBeat.o(45806);
      return;
    }
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletBindUI", "user status unreg");
    this.tTq = true;
    if (this.tTs >= 0) {}
    for (this.pVo.cCE = this.tTs;; this.pVo.cCE = 1)
    {
      localBundle.putInt("key_bind_scene", this.pVo.cCE);
      com.tencent.mm.wallet_core.a.a(this, b.class, localBundle, null);
      AppMethodBeat.o(45806);
      return;
    }
  }
  
  private void La(String paramString)
  {
    AppMethodBeat.i(45816);
    String str = paramString;
    if (bo.isNullOrNil(paramString)) {
      str = getString(2131305682);
    }
    h.a(this, str, null, false, new WalletBindUI.7(this));
    AppMethodBeat.o(45816);
  }
  
  private void cRC()
  {
    AppMethodBeat.i(45805);
    this.pVo.cCE = this.tTs;
    getInput().putParcelable("key_pay_info", this.pVo);
    if (this.tTs == 2)
    {
      if (!bo.isNullOrNil(this.tTr))
      {
        com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.WalletBindUI", "importKey " + this.tTr);
        doSceneForceProgress(new com.tencent.mm.plugin.wallet.bind.a.c(this.tTr, this.pVo));
        AppMethodBeat.o(45805);
        return;
      }
      La("");
      AppMethodBeat.o(45805);
      return;
    }
    if (this.tTs == 4)
    {
      x.RT(4);
      if (getIntent() == null)
      {
        La("");
        AppMethodBeat.o(45805);
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
      if (this.tTs == 6) {}
      for (this.tTt = new d(str1, str2, str3, str4, str5, str6, str7, 2, "getBrandWCPayCreateCreditCardRequest", i);; this.tTt = new d(str1, str2, str3, str4, str5, str6, str7, 1, "getBrandWCPayBindCardRequest", i))
      {
        doSceneForceProgress(this.tTt);
        AppMethodBeat.o(45805);
        return;
      }
    }
    if (this.tTs == 6)
    {
      cRD();
      AppMethodBeat.o(45805);
      return;
    }
    Im(this.tTs);
    AppMethodBeat.o(45805);
  }
  
  private void cRD()
  {
    AppMethodBeat.i(45807);
    com.tencent.mm.plugin.wallet.a.s.cRG();
    if (com.tencent.mm.plugin.wallet.a.s.cRH().cUq())
    {
      doSceneForceProgress(new com.tencent.mm.plugin.wallet_core.c.ab(null, 12));
      AppMethodBeat.o(45807);
      return;
    }
    Object localObject1 = getIntent().getStringExtra("packageExt");
    Object localObject3 = ((String)localObject1).split("&");
    if ((!bo.isNullOrNil((String)localObject1)) && (localObject3.length >= 2))
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
      if ((!bo.isNullOrNil(str)) && (!bo.isNullOrNil((String)localObject1)))
      {
        com.tencent.mm.plugin.wallet.a.s.cRG();
        if (com.tencent.mm.plugin.wallet.a.s.cRH().afl((String)localObject1))
        {
          localObject2 = new Bundle();
          localObject3 = new Bankcard();
          ((Bankcard)localObject3).field_bankName = str;
          ((Bankcard)localObject3).field_bankcardType = ((String)localObject1);
          ((Bundle)localObject2).putParcelable("key_bankcard", (Parcelable)localObject3);
          ((Bundle)localObject2).putString("key_bank_type", ((Bankcard)localObject3).field_bankcardType);
          com.tencent.mm.wallet_core.a.a(this, "WXCreditOpenProcess", (Bundle)localObject2, null);
          AppMethodBeat.o(45807);
          return;
        }
      }
    }
    finish();
    AppMethodBeat.o(45807);
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
    AppMethodBeat.i(45811);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1)
    {
      if (paramInt2 == -1)
      {
        this.oAh.bOM();
        AppMethodBeat.o(45811);
        return;
      }
      this.oAh.cancel();
      finish();
    }
    AppMethodBeat.o(45811);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    int i = -1;
    AppMethodBeat.i(45804);
    super.onCreate(paramBundle);
    addSceneEndListener(580);
    this.oAh.uuu = new WalletBindUI.1(this);
    this.tTr = getIntent().getStringExtra("key_import_key");
    this.tTs = getIntent().getIntExtra("key_bind_scene", -1);
    if (getIntent() != null) {
      i = getIntent().getIntExtra("key_bind_scene", 13);
    }
    paramBundle = new vf();
    if (i == 4) {}
    for (paramBundle.cLJ.scene = 20;; paramBundle.cLJ.scene = 13)
    {
      paramBundle.callback = new WalletBindUI.2(this);
      com.tencent.mm.sdk.b.a.ymk.l(paramBundle);
      com.tencent.mm.sdk.b.a.ymk.c(this.tTv);
      z.id(6, 0);
      AppMethodBeat.o(45804);
      return;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(45810);
    removeSceneEndListener(580);
    com.tencent.mm.sdk.b.a.ymk.d(this.tTv);
    super.onDestroy();
    AppMethodBeat.o(45810);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(45815);
    if (paramIntent == null)
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.WalletBindUI", "onNewIntent intent null");
      setResult(0);
      finish();
      AppMethodBeat.o(45815);
      return;
    }
    super.onNewIntent(paramIntent);
    com.tencent.mm.sdk.platformtools.ab.v("MicroMsg.WalletBindUI", "onNewIntent");
    setIntent(paramIntent);
    if ((paramIntent != null) && (paramIntent.getBooleanExtra("intent_bind_end", false)))
    {
      com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.WalletBindUI", "pay done... errCode:" + paramIntent.getBooleanExtra("intent_bind_end", false));
      setResult(-1, getIntent());
    }
    for (;;)
    {
      finish();
      AppMethodBeat.o(45815);
      return;
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletBindUI", "pay cancel");
      setResult(0);
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(45809);
    super.onPause();
    this.oAh.onPause();
    AppMethodBeat.o(45809);
  }
  
  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(45814);
    super.onRestoreInstanceState(paramBundle);
    this.tTq = paramBundle.getBoolean("key_is_jump", false);
    AppMethodBeat.o(45814);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(45808);
    if (this.tTq) {
      finish();
    }
    super.onResume();
    this.oAh.onResume();
    AppMethodBeat.o(45808);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(45813);
    super.onSaveInstanceState(paramBundle);
    paramBundle.putBoolean("key_is_jump", this.tTq);
    AppMethodBeat.o(45813);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(45812);
    if ((paramm instanceof com.tencent.mm.plugin.wallet.bind.a.c)) {
      this.tTq = true;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramm instanceof com.tencent.mm.plugin.wallet_core.c.ab))
      {
        if (this.tTs == 6) {
          cRD();
        }
        for (;;)
        {
          AppMethodBeat.o(45812);
          return true;
          cRC();
        }
      }
      if ((paramm instanceof com.tencent.mm.plugin.wallet.bind.a.c))
      {
        paramm = (com.tencent.mm.plugin.wallet.bind.a.c)paramm;
        Bundle localBundle = getInput();
        localBundle.putBoolean("key_is_import_bind", true);
        if ((paramm.tNG != null) && (paramm.tNG.size() > 0))
        {
          paramString = (Bankcard)paramm.tNG.get(0);
          if (!paramString.ufV)
          {
            localBundle.putBoolean("key_need_bind_response", true);
            localBundle.putString("kreq_token", paramm.token);
            localBundle.putString("key_bank_username", paramm.tSt);
            localBundle.putString("key_recommand_desc", paramm.tSu);
            localBundle.putParcelable("key_import_bankcard", paramString);
            this.tTq = true;
            localBundle.putInt("key_bind_scene", 2);
            com.tencent.mm.wallet_core.a.a(this, b.class, localBundle, new WalletBindUI.4(this));
          }
        }
        for (;;)
        {
          AppMethodBeat.o(45812);
          return true;
          h.a(this, 2131304948, 0, false, new WalletBindUI.5(this));
          continue;
          paramm = paramString;
          if (bo.isNullOrNil(paramString)) {
            paramm = getString(2131304882);
          }
          h.a(this, paramm, null, false, new WalletBindUI.6(this));
        }
      }
      if ((paramm instanceof d))
      {
        if ((this.tTt != null) && (this.tTt.equals(paramm)))
        {
          g.ana(((d)paramm).cSW());
          this.token = ((d)paramm).getToken();
          Im(4);
          AppMethodBeat.o(45812);
          return true;
        }
        x.dSs();
      }
      AppMethodBeat.o(45812);
      return false;
    }
    La(paramString);
    AppMethodBeat.o(45812);
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.bind.ui.WalletBindUI
 * JD-Core Version:    0.7.0.1
 */