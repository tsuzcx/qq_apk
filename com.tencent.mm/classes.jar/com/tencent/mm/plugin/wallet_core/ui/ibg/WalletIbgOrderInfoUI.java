package com.tencent.mm.plugin.wallet_core.ui.ibg;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.g.a.ko;
import com.tencent.mm.plugin.wallet_core.c.a.c;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@com.tencent.mm.ui.base.a(3)
public class WalletIbgOrderInfoUI
  extends WalletBaseUI
{
  public static Orders CZT;
  private String CYg = null;
  private String DDg = null;
  private String DDh = null;
  private String DDi = null;
  private String DDj = null;
  private final int DDk = 1;
  private final int DDl = 2;
  private String mAppId = null;
  private String mTimeStamp = null;
  
  public int getLayoutId()
  {
    return 2131495807;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(71449);
    if (paramInt2 == -1)
    {
      if (paramInt1 == 1)
      {
        paramIntent = new ko();
        paramIntent.dyC.requestCode = 25;
        paramIntent.dyC.bZU = -1;
        paramIntent.dyC.dyD = new Intent();
        com.tencent.mm.sdk.b.a.IvT.l(paramIntent);
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
    this.DDg = getIntent().getStringExtra("nonceStr");
    this.mTimeStamp = getIntent().getStringExtra("timeStamp");
    this.CYg = getIntent().getStringExtra("packageExt");
    this.DDh = getIntent().getStringExtra("paySignature");
    this.DDi = getIntent().getStringExtra("signtype");
    this.DDj = getIntent().getStringExtra("url");
    doSceneForceProgress(new c(this.mAppId, this.DDg, this.mTimeStamp, this.CYg, this.DDh, this.DDi, this.DDj));
    AppMethodBeat.o(71448);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(71451);
    super.onDestroy();
    removeSceneEndListener(1565);
    AppMethodBeat.o(71451);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(71450);
    ae.i("MicroMsg.WalletIbgOrderInfoUI", "onSceneEnd, errType: %s, errCode: %s, errMsg: %s, scene: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramn });
    if ((paramn instanceof c))
    {
      removeSceneEndListener(1565);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramn = (c)paramn;
        CZT = paramn.DgZ;
        paramString = CZT;
        paramInt1 = paramn.Dhp;
        ae.i("MicroMsg.WalletIbgOrderInfoUI", "gotoIbgOrderInfoUI, useNewPage: %s, orders: %s", new Object[] { Integer.valueOf(paramInt1), paramString });
        if (paramInt1 == 1)
        {
          paramn = new Intent(this, WalletIbgOrderInfoNewUI.class);
          paramn.putExtra("key_orders", paramString);
          startActivityForResult(paramn, 1);
        }
        for (;;)
        {
          AppMethodBeat.o(71450);
          return true;
          paramn = new Intent(this, WalletIbgOrderInfoOldUI.class);
          paramn.putExtra("key_orders", paramString);
          startActivityForResult(paramn, 2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.ibg.WalletIbgOrderInfoUI
 * JD-Core Version:    0.7.0.1
 */