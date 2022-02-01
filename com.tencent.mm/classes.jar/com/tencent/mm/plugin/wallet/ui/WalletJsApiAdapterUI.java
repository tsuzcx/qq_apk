package com.tencent.mm.plugin.wallet.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.pluginsdk.wallet.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@a(7)
public class WalletJsApiAdapterUI
  extends WalletBaseUI
{
  protected String COw = "";
  protected String packageName = "";
  protected boolean xZY = false;
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(69856);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1)
    {
      setResult(-1);
      finish();
    }
    AppMethodBeat.o(69856);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(69855);
    if (!this.xZY)
    {
      ad.d("MicroMsg.WalletJsApiAdapterUI", "back press not lock");
      finish();
      AppMethodBeat.o(69855);
      return;
    }
    ad.d("MicroMsg.WalletJsApiAdapterUI", "back press but lock");
    AppMethodBeat.o(69855);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(69852);
    super.onCreate(paramBundle);
    setContentViewVisibility(8);
    this.packageName = getIntent().getStringExtra("intent_jump_package");
    this.COw = getIntent().getStringExtra("intent_jump_ui");
    addSceneEndListener(580);
    if (getIntent() == null)
    {
      ad.d("MicroMsg.WalletJsApiAdapterUI", "func[doCheckPayNetscene] intent null");
      setResult(0);
      finish();
      AppMethodBeat.o(69852);
      return;
    }
    int i = getIntent().getIntExtra("source_type", 1);
    ad.i("MicroMsg.WalletJsApiAdapterUI", "do check jsapi: %s", new Object[] { Integer.valueOf(i) });
    paramBundle = null;
    if (i == 1) {
      paramBundle = new com.tencent.mm.plugin.wallet_core.c.d(getIntent().getStringExtra("appId"), getIntent().getStringExtra("timeStamp"), getIntent().getStringExtra("nonceStr"), getIntent().getStringExtra("packageExt"), getIntent().getStringExtra("signtype"), getIntent().getStringExtra("paySignature"), getIntent().getStringExtra("url"), getIntent().getIntExtra("jsapi_scene", 0), "openWCPayCardList", getIntent().getIntExtra("pay_channel", 0));
    }
    for (;;)
    {
      if (paramBundle != null) {
        doSceneForceProgress(paramBundle);
      }
      AppMethodBeat.o(69852);
      return;
      if (i == 2)
      {
        paramBundle = getIntent().getStringExtra("appId");
        String str1 = getIntent().getStringExtra("timeStamp");
        String str2 = getIntent().getStringExtra("nonceStr");
        String str3 = getIntent().getStringExtra("packageExt");
        String str4 = getIntent().getStringExtra("signtype");
        String str5 = getIntent().getStringExtra("paySignature");
        String str6 = getIntent().getStringExtra("wxapp_username");
        String str7 = getIntent().getStringExtra("wxapp_path");
        String str8 = getIntent().getStringExtra("command_word");
        paramBundle = new com.tencent.mm.plugin.wallet_core.c.d(paramBundle, str1, str2, str3, str4, str5, getIntent().getIntExtra("jsapi_scene", 0), str6, str7, str8, getIntent().getIntExtra("pay_channel", 0));
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(69854);
    removeSceneEndListener(580);
    super.onDestroy();
    AppMethodBeat.o(69854);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(69853);
    ad.v("MicroMsg.WalletJsApiAdapterUI", "onNewIntent");
    int i = paramIntent.getIntExtra("RESET_PWD_USER_ACTION", 0);
    if (i == 1)
    {
      setResult(-1);
      finish();
      AppMethodBeat.o(69853);
      return;
    }
    if (i == 2)
    {
      setResult(-1000);
      finish();
      AppMethodBeat.o(69853);
      return;
    }
    setResult(0);
    finish();
    AppMethodBeat.o(69853);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(69857);
    ad.i("MicroMsg.WalletJsApiAdapterUI", "onSceneEnd errType %s errCode %s errMsg %s scene %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramn });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramn instanceof com.tencent.mm.plugin.wallet_core.c.d))
      {
        e.aNP(((com.tencent.mm.plugin.wallet_core.c.d)paramn).eEF());
        if ((!bt.isNullOrNil(this.packageName)) && (!bt.isNullOrNil(this.COw)))
        {
          paramString = new Intent();
          paramString.putExtra("intent_finish_self", true);
          com.tencent.mm.bs.d.b(this, this.packageName, this.COw, paramString, 1);
        }
        for (;;)
        {
          AppMethodBeat.o(69857);
          return true;
          setResult(-1);
          finish();
        }
      }
    }
    else
    {
      setResult(-1000);
      h.cl(this, paramString);
      finish();
      AppMethodBeat.o(69857);
      return true;
    }
    AppMethodBeat.o(69857);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.ui.WalletJsApiAdapterUI
 * JD-Core Version:    0.7.0.1
 */