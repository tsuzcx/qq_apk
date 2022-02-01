package com.tencent.mm.plugin.wallet_core.ui.ibg;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.a.na;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.wallet_core.c.a.c;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@com.tencent.mm.ui.base.a(3)
public class WalletIbgOrderInfoUI
  extends WalletBaseUI
{
  public static Orders VmL;
  private String VVs = null;
  private String VVt = null;
  private String VVu = null;
  private String VVv = null;
  private final int VVw = 1;
  private final int VVx = 2;
  private String VkZ = null;
  private String mAppId = null;
  private String mTimeStamp = null;
  
  public int getLayoutId()
  {
    return a.g.transparent_layout;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(71449);
    if (paramInt2 == -1)
    {
      if (paramInt1 == 1)
      {
        paramIntent = new na();
        paramIntent.hPl.hPm = 25;
        paramIntent.hPl.resultCode = -1;
        paramIntent.hPl.hPn = new Intent();
        paramIntent.publish();
      }
      setResult(-1);
      finish();
    }
    AppMethodBeat.o(71449);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(71448);
    super.onCreate(paramBundle);
    addSceneEndListener(1565);
    this.mAppId = getIntent().getStringExtra("appId");
    this.VVs = getIntent().getStringExtra("nonceStr");
    this.mTimeStamp = getIntent().getStringExtra("timeStamp");
    this.VkZ = getIntent().getStringExtra("packageExt");
    this.VVt = getIntent().getStringExtra("paySignature");
    this.VVu = getIntent().getStringExtra("signtype");
    this.VVv = getIntent().getStringExtra("url");
    paramBundle = new Bundle();
    paramBundle.putString("appid", this.mAppId);
    paramBundle.putString("timestamp", this.mTimeStamp);
    paramBundle.putString("nonce_str", this.VVs);
    paramBundle.putString("package", this.VkZ);
    paramBundle.putString("sign_type", this.VVu);
    paramBundle.putString("pay_sign", this.VVt);
    paramBundle.putString("webview_url", this.VVv);
    if (((com.tencent.mm.pluginsdk.wallet.a)h.ax(com.tencent.mm.pluginsdk.wallet.a.class)).startPayIBGJsGetSuccPageUseCase(this, paramBundle))
    {
      AppMethodBeat.o(71448);
      return;
    }
    doSceneForceProgress(new c(this.mAppId, this.VVs, this.mTimeStamp, this.VkZ, this.VVt, this.VVu, this.VVv));
    AppMethodBeat.o(71448);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(71451);
    super.onDestroy();
    removeSceneEndListener(1565);
    AppMethodBeat.o(71451);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(71450);
    Log.i("MicroMsg.WalletIbgOrderInfoUI", "onSceneEnd, errType: %s, errCode: %s, errMsg: %s, scene: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramp });
    if ((paramp instanceof c))
    {
      removeSceneEndListener(1565);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramp = (c)paramp;
        VmL = paramp.Vyn;
        paramString = VmL;
        paramInt1 = paramp.VyC;
        Log.i("MicroMsg.WalletIbgOrderInfoUI", "gotoIbgOrderInfoUI, useNewPage: %s, orders: %s", new Object[] { Integer.valueOf(paramInt1), paramString });
        if (paramInt1 == 1)
        {
          paramp = new Intent(this, WalletIbgOrderInfoNewUI.class);
          paramp.putExtra("key_orders", paramString);
          startActivityForResult(paramp, 1);
        }
        for (;;)
        {
          AppMethodBeat.o(71450);
          return true;
          paramp = new Intent(this, WalletIbgOrderInfoOldUI.class);
          paramp.putExtra("key_orders", paramString);
          startActivityForResult(paramp, 2);
        }
      }
      setResult(0);
      finish();
    }
    setResult(0);
    finish();
    AppMethodBeat.o(71450);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.ibg.WalletIbgOrderInfoUI
 * JD-Core Version:    0.7.0.1
 */