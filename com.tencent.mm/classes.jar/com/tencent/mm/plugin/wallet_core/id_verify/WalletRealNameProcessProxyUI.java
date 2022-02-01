package com.tencent.mm.plugin.wallet_core.id_verify;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.pluginsdk.wallet.e;
import com.tencent.mm.protocal.protobuf.zf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.d.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@com.tencent.mm.ui.base.a(7)
public class WalletRealNameProcessProxyUI
  extends WalletBaseUI
{
  private d.a HKI;
  private String scene;
  private String sessionId;
  
  private void aJ(Bundle paramBundle)
  {
    AppMethodBeat.i(70044);
    Log.i("MicroMsg.WalletRealNameProcessProxyUI", "goRealNameUI");
    Bundle localBundle = paramBundle;
    if (paramBundle == null)
    {
      Log.i("MicroMsg.WalletRealNameProcessProxyUI", "goRealNameUI, param is null");
      localBundle = new Bundle();
    }
    localBundle.putString("key_realname_scene", this.scene);
    localBundle.putString("key_realname_sessionid", this.sessionId);
    localBundle.putString("realname_verify_process_jump_plugin", "wallet_core");
    localBundle.putString("realname_verify_process_jump_activity", ".id_verify.WalletRealNameProcessProxyUI");
    localBundle.putBoolean("process_finish_stay_orgpage", false);
    this.HKI = new WalletRealNameProcessProxyUI.1(this);
    com.tencent.mm.wallet_core.a.a(this, a.class, localBundle, this.HKI);
    AppMethodBeat.o(70044);
  }
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public boolean isTransparent()
  {
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(70042);
    super.onCreate(paramBundle);
    addSceneEndListener(580);
    paramBundle = getInput();
    if (paramBundle != null) {}
    for (int i = paramBundle.getInt("realname_scene", 0);; i = 0)
    {
      int j = i;
      if (i == 0) {
        j = getIntent().getIntExtra("realname_scene", 0);
      }
      if (j == 1)
      {
        Log.i("MicroMsg.WalletRealNameProcessProxyUI", "from jsapi, do NetSceneCheckPayJsapi");
        if (getIntent() == null)
        {
          paramBundle = "";
          if (Util.isNullOrNil("")) {
            paramBundle = getString(2131768354);
          }
          h.a(this, paramBundle, null, false, new WalletRealNameProcessProxyUI.2(this));
          AppMethodBeat.o(70042);
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
        if (getInput().getInt("realname_scene") == 2) {
          i = 12;
        }
        doSceneForceProgress(new com.tencent.mm.plugin.wallet_core.c.d(paramBundle, str1, str2, str3, str4, str5, str6, i, "idCardRealnameVerify", getIntent().getIntExtra("pay_channel", 0)));
        AppMethodBeat.o(70042);
        return;
      }
      aJ(paramBundle);
      AppMethodBeat.o(70042);
      return;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(70047);
    super.onDestroy();
    removeSceneEndListener(580);
    AppMethodBeat.o(70047);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(70046);
    Log.i("MicroMsg.WalletRealNameProcessProxyUI", "onNewIntent");
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
      AppMethodBeat.o(70046);
      return;
      setResult(-1);
      break;
      setResult(0);
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(70043);
    super.onResume();
    AppMethodBeat.o(70043);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(70045);
    if ((paramq instanceof com.tencent.mm.plugin.wallet_core.c.d))
    {
      Log.e("MicroMsg.WalletRealNameProcessProxyUI", "NetSceneCheckPayJsapi resp,errType = " + paramInt1 + ",errCode=" + paramInt2);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        e.bfP(((com.tencent.mm.plugin.wallet_core.c.d)paramq).fPP());
        this.sessionId = ((zf)((com.tencent.mm.plugin.wallet_core.c.d)paramq).rr.iLL.iLR).session_id;
        this.scene = ((zf)((com.tencent.mm.plugin.wallet_core.c.d)paramq).rr.iLL.iLR).scene;
        aJ(getInput());
        AppMethodBeat.o(70045);
        return true;
      }
    }
    AppMethodBeat.o(70045);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.WalletRealNameProcessProxyUI
 * JD-Core Version:    0.7.0.1
 */