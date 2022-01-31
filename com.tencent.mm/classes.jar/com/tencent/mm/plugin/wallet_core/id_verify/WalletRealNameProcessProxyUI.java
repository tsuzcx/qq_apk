package com.tencent.mm.plugin.wallet_core.id_verify;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@com.tencent.mm.ui.base.a(7)
public class WalletRealNameProcessProxyUI
  extends WalletBaseUI
{
  private void J(Bundle paramBundle)
  {
    y.i("MicroMsg.WalletRealNameProcessProxyUI", "goRealNameUI");
    Bundle localBundle = paramBundle;
    if (paramBundle == null)
    {
      y.i("MicroMsg.WalletRealNameProcessProxyUI", "goRealNameUI, param is null");
      localBundle = new Bundle();
    }
    localBundle.putString("realname_verify_process_jump_plugin", "wallet_core");
    localBundle.putString("realname_verify_process_jump_activity", ".id_verify.WalletRealNameProcessProxyUI");
    localBundle.putBoolean("process_finish_stay_orgpage", false);
    com.tencent.mm.wallet_core.a.a(this, a.class, localBundle);
  }
  
  public final boolean aSk()
  {
    return true;
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramm instanceof com.tencent.mm.plugin.wallet_core.c.a))
    {
      y.e("MicroMsg.WalletRealNameProcessProxyUI", "NetSceneCheckPayJsapi resp,errType = " + paramInt1 + ",errCode=" + paramInt2);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        f.Xf(((com.tencent.mm.plugin.wallet_core.c.a)paramm).bUH());
        J(this.BX);
        return true;
      }
    }
    return false;
  }
  
  protected final int getLayoutId()
  {
    return -1;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    kh(580);
    paramBundle = this.BX;
    if (paramBundle != null) {}
    for (int i = paramBundle.getInt("realname_scene", 0);; i = 0)
    {
      int j = i;
      if (i == 0) {
        j = getIntent().getIntExtra("realname_scene", 0);
      }
      if (j == 1)
      {
        y.i("MicroMsg.WalletRealNameProcessProxyUI", "from jsapi, do NetSceneCheckPayJsapi");
        if (getIntent() == null)
        {
          paramBundle = "";
          if (bk.bl("")) {
            paramBundle = getString(a.i.wallet_unknown_err);
          }
          h.a(this, paramBundle, null, false, new WalletRealNameProcessProxyUI.1(this));
          return;
        }
        paramBundle = getIntent().getStringExtra("appId");
        String str1 = getIntent().getStringExtra("timeStamp");
        String str2 = getIntent().getStringExtra("nonceStr");
        String str3 = getIntent().getStringExtra("packageExt");
        String str4 = getIntent().getStringExtra("signtype");
        String str5 = getIntent().getStringExtra("paySignature");
        String str6 = getIntent().getStringExtra("url");
        i = 8;
        if (this.BX.getInt("realname_scene") == 2) {
          i = 12;
        }
        a(new com.tencent.mm.plugin.wallet_core.c.a(paramBundle, str1, str2, str3, str4, str5, str6, i, "idCardRealnameVerify", getIntent().getIntExtra("pay_channel", 0)), true, false);
        return;
      }
      J(paramBundle);
      return;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ki(580);
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    y.i("MicroMsg.WalletRealNameProcessProxyUI", "onNewIntent");
    paramIntent = getIntent().getExtras();
    if ((paramIntent != null) && (paramIntent.getBoolean("key_is_realname_verify_process"))) {
      switch (paramIntent.getInt("realname_verify_process_ret", 0))
      {
      default: 
        setResult(0);
      }
    }
    for (;;)
    {
      finish();
      return;
      setResult(-1);
      break;
      setResult(0);
    }
  }
  
  public void onResume()
  {
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.WalletRealNameProcessProxyUI
 * JD-Core Version:    0.7.0.1
 */