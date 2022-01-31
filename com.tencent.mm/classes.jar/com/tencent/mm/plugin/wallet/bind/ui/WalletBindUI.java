package com.tencent.mm.plugin.wallet.bind.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.mm.ah.m;
import com.tencent.mm.h.a.tk;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.plugin.wallet_core.b.b;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wallet_core.ui.q;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c.v;
import com.tencent.mm.wallet_core.c.w;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.ArrayList;

@com.tencent.mm.ui.base.a(7)
public class WalletBindUI
  extends WalletBaseUI
{
  private q man = new q();
  private PayInfo nqa = new PayInfo();
  private boolean qkq = false;
  private String qkr;
  private int qks = -1;
  private com.tencent.mm.plugin.wallet_core.c.a qkt = null;
  private boolean qku = false;
  com.tencent.mm.sdk.b.c qkv = new WalletBindUI.3(this);
  private String token = null;
  
  private void AI(int paramInt)
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletBindUI", "doBindCardForOtherScene " + bk.csb().toString());
    Bundle localBundle = this.BX;
    localBundle.putParcelable("key_pay_info", this.nqa);
    localBundle.putBoolean("key_need_bind_response", true);
    localBundle.putString("key_custom_bind_tips", getIntent().getStringExtra("key_custom_bind_tips"));
    p.bTK();
    if (p.bTL().bVM())
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletBindUI", "user status invalid");
      if (paramInt == 4)
      {
        a(new com.tencent.mm.plugin.wallet_core.c.y(null, 20), true, false);
        return;
      }
      a(new com.tencent.mm.plugin.wallet_core.c.y(null, 12), true, false);
      return;
    }
    p.bTK();
    if (p.bTL().bVN())
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletBindUI", "user status reg");
      this.qkq = true;
      this.nqa.bUW = this.qks;
      localBundle.putInt("key_bind_scene", this.nqa.bUW);
      if (!bk.bl(this.token)) {
        localBundle.putString("kreq_token", this.token);
      }
      com.tencent.mm.wallet_core.a.a(this, b.class, localBundle, null);
      return;
    }
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletBindUI", "user status unreg");
    this.qkq = true;
    if (this.qks >= 0) {}
    for (this.nqa.bUW = this.qks;; this.nqa.bUW = 1)
    {
      localBundle.putInt("key_bind_scene", this.nqa.bUW);
      com.tencent.mm.wallet_core.a.a(this, b.class, localBundle, null);
      return;
    }
  }
  
  private void AY(String paramString)
  {
    String str = paramString;
    if (bk.bl(paramString)) {
      str = getString(a.i.wallet_unknown_err);
    }
    h.a(this, str, null, false, new WalletBindUI.7(this));
  }
  
  private void bTG()
  {
    this.nqa.bUW = this.qks;
    this.BX.putParcelable("key_pay_info", this.nqa);
    if (this.qks == 2)
    {
      if (!bk.bl(this.qkr))
      {
        com.tencent.mm.sdk.platformtools.y.d("MicroMsg.WalletBindUI", "importKey " + this.qkr);
        a(new com.tencent.mm.plugin.wallet.bind.a.c(this.qkr, this.nqa), true, false);
        return;
      }
      AY("");
      return;
    }
    if (this.qks == 4)
    {
      v.IX(4);
      if (getIntent() == null)
      {
        AY("");
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
      if (this.qks == 6) {}
      for (this.qkt = new com.tencent.mm.plugin.wallet_core.c.a(str1, str2, str3, str4, str5, str6, str7, 2, "getBrandWCPayCreateCreditCardRequest", i);; this.qkt = new com.tencent.mm.plugin.wallet_core.c.a(str1, str2, str3, str4, str5, str6, str7, 1, "getBrandWCPayBindCardRequest", i))
      {
        a(this.qkt, true, false);
        return;
      }
    }
    if (this.qks == 6)
    {
      bTH();
      return;
    }
    AI(this.qks);
  }
  
  private void bTH()
  {
    int i = 0;
    p.bTK();
    if (p.bTL().bVM())
    {
      a(new com.tencent.mm.plugin.wallet_core.c.y(null, 12), true, false);
      return;
    }
    Object localObject1 = getIntent().getStringExtra("packageExt");
    Object localObject3 = ((String)localObject1).split("&");
    if ((!bk.bl((String)localObject1)) && (localObject3.length >= 2))
    {
      int j = localObject3.length;
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
      if ((!bk.bl(str)) && (!bk.bl((String)localObject1)))
      {
        p.bTK();
        if (p.bTL().Qt((String)localObject1))
        {
          localObject2 = new Bundle();
          localObject3 = new Bankcard();
          ((Bankcard)localObject3).field_bankName = str;
          ((Bankcard)localObject3).field_bankcardType = ((String)localObject1);
          ((Bundle)localObject2).putParcelable("key_bankcard", (Parcelable)localObject3);
          ((Bundle)localObject2).putString("key_bank_type", ((Bankcard)localObject3).field_bankcardType);
          com.tencent.mm.wallet_core.a.a(this, "WXCreditOpenProcess", (Bundle)localObject2, null);
          return;
        }
      }
    }
    finish();
  }
  
  public final boolean bgK()
  {
    return false;
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramm instanceof com.tencent.mm.plugin.wallet.bind.a.c)) {
      this.qkq = true;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramm instanceof com.tencent.mm.plugin.wallet_core.c.y))
      {
        if (this.qks == 6) {
          bTH();
        }
        for (;;)
        {
          return true;
          bTG();
        }
      }
      if ((paramm instanceof com.tencent.mm.plugin.wallet.bind.a.c))
      {
        paramm = (com.tencent.mm.plugin.wallet.bind.a.c)paramm;
        Bundle localBundle = this.BX;
        localBundle.putBoolean("key_is_import_bind", true);
        if ((paramm.qgr != null) && (paramm.qgr.size() > 0))
        {
          paramString = (Bankcard)paramm.qgr.get(0);
          if (!paramString.bre)
          {
            localBundle.putBoolean("key_need_bind_response", true);
            localBundle.putString("kreq_token", paramm.token);
            localBundle.putString("key_bank_username", paramm.qjt);
            localBundle.putString("key_recommand_desc", paramm.qju);
            localBundle.putParcelable("key_import_bankcard", paramString);
            this.qkq = true;
            localBundle.putInt("key_bind_scene", 2);
            com.tencent.mm.wallet_core.a.a(this, b.class, localBundle, new WalletBindUI.4(this));
          }
        }
        for (;;)
        {
          return true;
          h.a(this, a.i.wallet_card_import_exist, 0, false, new WalletBindUI.5(this));
          continue;
          paramm = paramString;
          if (bk.bl(paramString)) {
            paramm = getString(a.i.wallet_bind_import_fail);
          }
          h.a(this, paramm, null, false, new WalletBindUI.6(this));
        }
      }
      if ((paramm instanceof com.tencent.mm.plugin.wallet_core.c.a))
      {
        if ((this.qkt != null) && (this.qkt.equals(paramm)))
        {
          f.Xf(((com.tencent.mm.plugin.wallet_core.c.a)paramm).bUH());
          this.token = ((com.tencent.mm.plugin.wallet_core.c.a)paramm).getToken();
          AI(4);
          return true;
        }
        v.cMD();
      }
      return false;
    }
    AY(paramString);
    return true;
  }
  
  protected final int getForceOrientation()
  {
    return 1;
  }
  
  protected final int getLayoutId()
  {
    return -1;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1)
    {
      if (paramInt2 == -1) {
        this.man.bgR();
      }
    }
    else {
      return;
    }
    this.man.cancel();
    finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    int i = -1;
    super.onCreate(paramBundle);
    kh(580);
    this.man.qHp = new WalletBindUI.1(this);
    this.qkr = getIntent().getStringExtra("key_import_key");
    this.qks = getIntent().getIntExtra("key_bind_scene", -1);
    if (getIntent() != null) {
      i = getIntent().getIntExtra("key_bind_scene", 13);
    }
    paramBundle = new tk();
    if (i == 4) {}
    for (paramBundle.ccZ.scene = 20;; paramBundle.ccZ.scene = 13)
    {
      paramBundle.bFJ = new WalletBindUI.2(this);
      com.tencent.mm.sdk.b.a.udP.m(paramBundle);
      com.tencent.mm.sdk.b.a.udP.c(this.qkv);
      w.fT(6, 0);
      return;
    }
  }
  
  public void onDestroy()
  {
    ki(580);
    com.tencent.mm.sdk.b.a.udP.d(this.qkv);
    super.onDestroy();
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    if (paramIntent == null)
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.WalletBindUI", "onNewIntent intent null");
      setResult(0);
      finish();
      return;
    }
    super.onNewIntent(paramIntent);
    com.tencent.mm.sdk.platformtools.y.v("MicroMsg.WalletBindUI", "onNewIntent");
    setIntent(paramIntent);
    if ((paramIntent != null) && (paramIntent.getBooleanExtra("intent_bind_end", false)))
    {
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.WalletBindUI", "pay done... errCode:" + paramIntent.getBooleanExtra("intent_bind_end", false));
      setResult(-1, getIntent());
    }
    for (;;)
    {
      finish();
      return;
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletBindUI", "pay cancel");
      setResult(0);
    }
  }
  
  public void onPause()
  {
    super.onPause();
    this.man.onPause();
  }
  
  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    super.onRestoreInstanceState(paramBundle);
    this.qkq = paramBundle.getBoolean("key_is_jump", false);
  }
  
  public void onResume()
  {
    if (this.qkq) {
      finish();
    }
    super.onResume();
    this.man.onResume();
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putBoolean("key_is_jump", this.qkq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.bind.ui.WalletBindUI
 * JD-Core Version:    0.7.0.1
 */