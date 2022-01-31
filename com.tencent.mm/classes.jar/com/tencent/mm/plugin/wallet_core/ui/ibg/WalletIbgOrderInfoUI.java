package com.tencent.mm.plugin.wallet_core.ui.ibg;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.iz;
import com.tencent.mm.plugin.wallet_core.c.a.c;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@com.tencent.mm.ui.base.a(3)
public class WalletIbgOrderInfoUI
  extends WalletBaseUI
{
  public static Orders tVr;
  private String mAppId = null;
  private String mTimeStamp = null;
  private String tTG = null;
  private String uvV = null;
  private String uvW = null;
  private String uvX = null;
  private String uvY = null;
  private final int uvZ = 1;
  private final int uwa = 2;
  
  public int getLayoutId()
  {
    return 2130971042;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(47849);
    if (paramInt2 == -1)
    {
      if (paramInt1 == 1)
      {
        paramIntent = new iz();
        paramIntent.cyt.requestCode = 25;
        paramIntent.cyt.bpE = -1;
        paramIntent.cyt.cyu = new Intent();
        com.tencent.mm.sdk.b.a.ymk.l(paramIntent);
      }
      setResult(-1);
      finish();
    }
    AppMethodBeat.o(47849);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(47848);
    super.onCreate(paramBundle);
    addSceneEndListener(1565);
    this.mAppId = getIntent().getStringExtra("appId");
    this.uvV = getIntent().getStringExtra("nonceStr");
    this.mTimeStamp = getIntent().getStringExtra("timeStamp");
    this.tTG = getIntent().getStringExtra("packageExt");
    this.uvW = getIntent().getStringExtra("paySignature");
    this.uvX = getIntent().getStringExtra("signtype");
    this.uvY = getIntent().getStringExtra("url");
    doSceneForceProgress(new c(this.mAppId, this.uvV, this.mTimeStamp, this.tTG, this.uvW, this.uvX, this.uvY));
    AppMethodBeat.o(47848);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(47851);
    super.onDestroy();
    removeSceneEndListener(1565);
    AppMethodBeat.o(47851);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(47850);
    ab.i("MicroMsg.WalletIbgOrderInfoUI", "onSceneEnd, errType: %s, errCode: %s, errMsg: %s, scene: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramm });
    if ((paramm instanceof c))
    {
      removeSceneEndListener(1565);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramm = (c)paramm;
        tVr = paramm.ucc;
        paramString = tVr;
        paramInt1 = paramm.ucn;
        ab.i("MicroMsg.WalletIbgOrderInfoUI", "gotoIbgOrderInfoUI, useNewPage: %s, orders: %s", new Object[] { Integer.valueOf(paramInt1), paramString });
        if (paramInt1 == 1)
        {
          paramm = new Intent(this, WalletIbgOrderInfoNewUI.class);
          paramm.putExtra("key_orders", paramString);
          startActivityForResult(paramm, 1);
        }
        for (;;)
        {
          AppMethodBeat.o(47850);
          return true;
          paramm = new Intent(this, WalletIbgOrderInfoOldUI.class);
          paramm.putExtra("key_orders", paramString);
          startActivityForResult(paramm, 2);
        }
      }
      setResult(0);
      finish();
    }
    setResult(0);
    finish();
    AppMethodBeat.o(47850);
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