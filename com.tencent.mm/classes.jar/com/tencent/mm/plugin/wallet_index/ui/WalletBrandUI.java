package com.tencent.mm.plugin.wallet_index.ui;

import android.app.Dialog;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.a.tp;
import com.tencent.mm.kernel.b;
import com.tencent.mm.model.q;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c.w;

@com.tencent.mm.ui.base.a(7)
public class WalletBrandUI
  extends MMActivity
  implements f
{
  private String appId;
  private String bUU;
  private int ccY;
  private Dialog ftk = null;
  private boolean qLU = false;
  private WalletBrandUI.b qLV;
  private c qLW = new c() {};
  private c qLX = new WalletBrandUI.3(this);
  
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
    y.i("MicroMsg.WalletBrandUI", "onActivityResultresultCode : " + paramInt2 + " requestCode: " + paramInt1);
    if (paramInt2 == -1) {
      switch (paramInt1)
      {
      }
    }
    for (;;)
    {
      finish();
      return;
      y.i("MicroMsg.WalletBrandUI", "get result to callback? " + paramIntent.getStringExtra("test"));
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if ((Build.VERSION.SDK_INT >= 21) && (getWindow() != null))
    {
      getWindow().addFlags(-2147483648);
      getWindow().setStatusBarColor(0);
    }
    this.ccY = getIntent().getIntExtra("pay_scene", 3);
    w.cME();
    y.i("MicroMsg.WalletBrandUI", "onCreate");
    int i = getIntent().getIntExtra("pay_for_wallet_type", 1);
    y.i("MicroMsg.WalletBrandUI", "onCreate payForWalletType is " + i);
    if (q.Gw())
    {
      y.i("MicroMsg.WalletBrandUI", "hy: do pay with payu");
      this.qLV = new WalletBrandUI.c(this);
    }
    for (;;)
    {
      com.tencent.mm.sdk.b.a.udP.c(this.qLW);
      com.tencent.mm.sdk.b.a.udP.c(this.qLX);
      com.tencent.mm.kernel.g.DQ();
      com.tencent.mm.kernel.g.DO().dJT.a(this.qLV.bXB(), this);
      return;
      if (i == 2)
      {
        y.i("MicroMsg.WalletBrandUI", "hy: do pay with h5");
        this.qLV = new WalletBrandUI.a(this);
      }
      else if (i == 3)
      {
        y.i("MicroMsg.WalletBrandUI", "do pay with mall");
        this.qLV = new WalletBrandUI.e(this);
      }
      else
      {
        y.i("MicroMsg.WalletBrandUI", "hy: do pay with tenpay");
        this.qLV = new WalletBrandUI.d(this);
      }
    }
  }
  
  public void onDestroy()
  {
    y.i("MicroMsg.WalletBrandUI", "onDestroy");
    super.onDestroy();
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DO().dJT.b(this.qLV.bXB(), this);
    com.tencent.mm.sdk.b.a.udP.d(this.qLW);
    com.tencent.mm.sdk.b.a.udP.d(this.qLX);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      finish();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    y.i("MicroMsg.WalletBrandUI", "onNewIntent");
    super.onNewIntent(paramIntent);
  }
  
  public void onResume()
  {
    y.i("MicroMsg.WalletBrandUI", "onResume");
    super.onResume();
    y.i("MicroMsg.WalletBrandUI", "Handler jump intercept = %b,taskid = %d,parentName = %s", new Object[] { Boolean.valueOf(this.qLU), Integer.valueOf(getTaskId()), getCallingActivity() });
    if (!this.qLU)
    {
      this.qLU = true;
      m localm = this.qLV.bXC();
      if (this.ftk != null)
      {
        this.ftk.dismiss();
        this.ftk = null;
      }
      this.ftk = com.tencent.mm.wallet_core.ui.g.e(this, new WalletBrandUI.1(this, localm));
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.i("MicroMsg.WalletBrandUI", "hy: brandui on scene end. errType: %d, errCode: %d, errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (paramm.getType() != this.qLV.bXB()) {
      return;
    }
    this.qLV.onSceneEnd(paramInt1, paramInt2, paramString, paramm);
  }
  
  public void onStart()
  {
    super.onStart();
  }
  
  protected void onStop()
  {
    super.onStop();
    if (this.ftk != null)
    {
      this.ftk.dismiss();
      this.ftk = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.ui.WalletBrandUI
 * JD-Core Version:    0.7.0.1
 */