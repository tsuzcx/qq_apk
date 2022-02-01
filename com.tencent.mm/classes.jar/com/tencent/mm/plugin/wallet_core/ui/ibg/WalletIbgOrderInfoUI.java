package com.tencent.mm.plugin.wallet_core.ui.ibg;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.f.a.lv;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.wallet_core.c.a.c;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@com.tencent.mm.ui.base.a(3)
public class WalletIbgOrderInfoUI
  extends WalletBaseUI
{
  public static Orders OxA;
  private String OvN = null;
  private String PeK = null;
  private String PeL = null;
  private String PeM = null;
  private String PeN = null;
  private final int PeO = 1;
  private final int PeP = 2;
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
        paramIntent = new lv();
        paramIntent.fJI.requestCode = 25;
        paramIntent.fJI.resultCode = -1;
        paramIntent.fJI.fJJ = new Intent();
        EventCenter.instance.publish(paramIntent);
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
    this.PeK = getIntent().getStringExtra("nonceStr");
    this.mTimeStamp = getIntent().getStringExtra("timeStamp");
    this.OvN = getIntent().getStringExtra("packageExt");
    this.PeL = getIntent().getStringExtra("paySignature");
    this.PeM = getIntent().getStringExtra("signtype");
    this.PeN = getIntent().getStringExtra("url");
    paramBundle = new Bundle();
    paramBundle.putString("appid", this.mAppId);
    paramBundle.putString("timestamp", this.mTimeStamp);
    paramBundle.putString("nonce_str", this.PeK);
    paramBundle.putString("package", this.OvN);
    paramBundle.putString("sign_type", this.PeM);
    paramBundle.putString("pay_sign", this.PeL);
    paramBundle.putString("webview_url", this.PeN);
    if (((com.tencent.mm.pluginsdk.wallet.a)h.ae(com.tencent.mm.pluginsdk.wallet.a.class)).startPayIBGJsGetSuccPageUseCase(this, paramBundle))
    {
      AppMethodBeat.o(71448);
      return;
    }
    doSceneForceProgress(new c(this.mAppId, this.PeK, this.mTimeStamp, this.OvN, this.PeL, this.PeM, this.PeN));
    AppMethodBeat.o(71448);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(71451);
    super.onDestroy();
    removeSceneEndListener(1565);
    AppMethodBeat.o(71451);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(71450);
    Log.i("MicroMsg.WalletIbgOrderInfoUI", "onSceneEnd, errType: %s, errCode: %s, errMsg: %s, scene: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramq });
    if ((paramq instanceof c))
    {
      removeSceneEndListener(1565);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramq = (c)paramq;
        OxA = paramq.OIB;
        paramString = OxA;
        paramInt1 = paramq.OIQ;
        Log.i("MicroMsg.WalletIbgOrderInfoUI", "gotoIbgOrderInfoUI, useNewPage: %s, orders: %s", new Object[] { Integer.valueOf(paramInt1), paramString });
        if (paramInt1 == 1)
        {
          paramq = new Intent(this, WalletIbgOrderInfoNewUI.class);
          paramq.putExtra("key_orders", paramString);
          startActivityForResult(paramq, 1);
        }
        for (;;)
        {
          AppMethodBeat.o(71450);
          return true;
          paramq = new Intent(this, WalletIbgOrderInfoOldUI.class);
          paramq.putExtra("key_orders", paramString);
          startActivityForResult(paramq, 2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.ibg.WalletIbgOrderInfoUI
 * JD-Core Version:    0.7.0.1
 */