package com.tencent.mm.plugin.wallet_core.ui.ibg;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.ah.m;
import com.tencent.mm.h.a.is;
import com.tencent.mm.plugin.wallet_core.c.a.c;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@com.tencent.mm.ui.base.a(3)
public class WalletIbgOrderInfoUI
  extends WalletBaseUI
{
  public static Orders qmc;
  private String mAppId = null;
  private String mTimeStamp = null;
  private String qHs = null;
  private String qHt = null;
  private String qHu = null;
  private String qHv = null;
  private final int qHw = 1;
  private final int qHx = 2;
  private String qkG = null;
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.i("MicroMsg.WalletIbgOrderInfoUI", "onSceneEnd, errType: %s, errCode: %s, errMsg: %s, scene: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramm });
    if ((paramm instanceof c))
    {
      ki(1565);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramm = (c)paramm;
        qmc = paramm.qre;
        paramString = qmc;
        paramInt1 = paramm.qrp;
        y.i("MicroMsg.WalletIbgOrderInfoUI", "gotoIbgOrderInfoUI, useNewPage: %s, orders: %s", new Object[] { Integer.valueOf(paramInt1), paramString });
        if (paramInt1 == 1)
        {
          paramm = new Intent(this, WalletIbgOrderInfoNewUI.class);
          paramm.putExtra("key_orders", paramString);
          startActivityForResult(paramm, 1);
          return true;
        }
        paramm = new Intent(this, WalletIbgOrderInfoOldUI.class);
        paramm.putExtra("key_orders", paramString);
        startActivityForResult(paramm, 2);
        return true;
      }
      setResult(0);
      finish();
    }
    setResult(0);
    finish();
    return false;
  }
  
  protected final int getLayoutId()
  {
    return a.g.transparent_layout;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1)
    {
      if (paramInt1 == 1)
      {
        paramIntent = new is();
        paramIntent.bQT.bQU = 25;
        paramIntent.bQT.aYY = -1;
        paramIntent.bQT.bQV = new Intent();
        com.tencent.mm.sdk.b.a.udP.m(paramIntent);
      }
      setResult(-1);
      finish();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    kh(1565);
    this.mAppId = getIntent().getStringExtra("appId");
    this.qHs = getIntent().getStringExtra("nonceStr");
    this.mTimeStamp = getIntent().getStringExtra("timeStamp");
    this.qkG = getIntent().getStringExtra("packageExt");
    this.qHt = getIntent().getStringExtra("paySignature");
    this.qHu = getIntent().getStringExtra("signtype");
    this.qHv = getIntent().getStringExtra("url");
    a(new c(this.mAppId, this.qHs, this.mTimeStamp, this.qkG, this.qHt, this.qHu, this.qHv), true, false);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ki(1565);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.ibg.WalletIbgOrderInfoUI
 * JD-Core Version:    0.7.0.1
 */