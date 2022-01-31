package com.tencent.mm.plugin.wallet_index.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.r;
import com.tencent.mm.pluginsdk.wallet.WalletJsapiData;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c.z;

@com.tencent.mm.ui.base.a(7)
public class WalletBrandUI
  extends MMActivity
  implements f
{
  private int cLI;
  private Dialog gKM;
  private boolean uAU;
  private WalletBrandUI.b uAV;
  private m uAW;
  private WalletJsapiData uAX;
  private final int uAY;
  private String uAZ;
  private c uBa;
  private c uBb;
  
  public WalletBrandUI()
  {
    AppMethodBeat.i(48260);
    this.uAU = false;
    this.gKM = null;
    this.uAW = null;
    this.uAY = (hashCode() & 0xFFFF);
    this.uBa = new WalletBrandUI.2(this);
    this.uBb = new WalletBrandUI.3(this);
    AppMethodBeat.o(48260);
  }
  
  private static String afS(String paramString)
  {
    AppMethodBeat.i(142597);
    int i = paramString.indexOf("prepay_id=");
    if (i == -1)
    {
      AppMethodBeat.o(142597);
      return null;
    }
    paramString = paramString.substring(i + 10);
    if (paramString == null)
    {
      AppMethodBeat.o(142597);
      return null;
    }
    i = paramString.indexOf("&");
    if (i == -1)
    {
      AppMethodBeat.o(142597);
      return paramString;
    }
    paramString = paramString.substring(0, i);
    AppMethodBeat.o(142597);
    return paramString;
  }
  
  private boolean cXi()
  {
    AppMethodBeat.i(142596);
    com.tencent.mm.wallet_core.b.dRI();
    if ((com.tencent.mm.wallet_core.b.dpQ()) && (this.uAX.packageExt != null))
    {
      String str = afS(this.uAX.packageExt);
      if (str == null)
      {
        bool1 = ((com.tencent.mm.pluginsdk.wallet.b)com.tencent.mm.kernel.g.E(com.tencent.mm.pluginsdk.wallet.b.class)).kindaCacheServiceGetBool("NEW_CASHIER_EMPTY_PREPAY_ID_PAY_SWTICH_KEY");
        AppMethodBeat.o(142596);
        return bool1;
      }
      boolean bool1 = str.startsWith("sns_");
      boolean bool2 = str.startsWith("tax_");
      boolean bool3 = str.startsWith("seb_ff_");
      if ((bool1) || (bool2) || (bool3)) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(142596);
        return false;
      }
      if (((this.uAX.cCD == 3) && (((com.tencent.mm.pluginsdk.wallet.b)com.tencent.mm.kernel.g.E(com.tencent.mm.pluginsdk.wallet.b.class)).kindaCacheServiceGetBool("NEW_CASHIER_JSAPI_PAY_SWTICH_KEY"))) || ((this.uAX.cCD == 46) && (((com.tencent.mm.pluginsdk.wallet.b)com.tencent.mm.kernel.g.E(com.tencent.mm.pluginsdk.wallet.b.class)).kindaCacheServiceGetBool("NEW_CASHIER_TINYAPP_PAY_SWTICH_KEY"))))
      {
        AppMethodBeat.o(142596);
        return true;
      }
      AppMethodBeat.o(142596);
      return false;
    }
    AppMethodBeat.o(142596);
    return false;
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(48269);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ab.i("MicroMsg.WalletBrandUI", "onActivityResultresultCode : " + paramInt2 + " requestCode: " + paramInt1);
    if (paramInt2 == -1) {
      switch (paramInt1)
      {
      }
    }
    for (;;)
    {
      finish();
      AppMethodBeat.o(48269);
      return;
      ab.i("MicroMsg.WalletBrandUI", "get result to callback? " + paramIntent.getStringExtra("test"));
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(48261);
    super.onCreate(paramBundle);
    this.uAX = ((WalletJsapiData)getIntent().getParcelableExtra("WalletJsapiData"));
    if ((Build.VERSION.SDK_INT >= 21) && (getWindow() != null))
    {
      getWindow().addFlags(-2147483648);
      getWindow().setStatusBarColor(0);
    }
    this.uAZ = this.uAX.wgN;
    this.cLI = this.uAX.cCD;
    z.dSt();
    ab.i("MicroMsg.WalletBrandUI", "onCreate");
    int i = this.uAX.wgI;
    ab.i("MicroMsg.WalletBrandUI", "onCreate payForWalletType is ".concat(String.valueOf(i)));
    if (r.ZB())
    {
      ab.i("MicroMsg.WalletBrandUI", "hy: do pay with payu");
      this.uAV = new WalletBrandUI.d(this);
    }
    for (;;)
    {
      com.tencent.mm.sdk.b.a.ymk.c(this.uBa);
      com.tencent.mm.sdk.b.a.ymk.c(this.uBb);
      if (!(this.uAV instanceof WalletBrandUI.c)) {
        break;
      }
      ab.i("MicroMsg.WalletBrandUI", "onCreate: do pay with kinda");
      AppMethodBeat.o(48261);
      return;
      if (i == 2)
      {
        ab.i("MicroMsg.WalletBrandUI", "hy: do pay with h5");
        this.uAV = new WalletBrandUI.a(this);
      }
      else if (i == 3)
      {
        ab.i("MicroMsg.WalletBrandUI", "do pay with mall");
        this.uAV = new WalletBrandUI.f(this);
      }
      else if (cXi())
      {
        ab.i("MicroMsg.WalletBrandUI", "do pay with kinda");
        this.uAV = new WalletBrandUI.c(this);
      }
      else
      {
        ab.i("MicroMsg.WalletBrandUI", "hy: do pay with tenpay");
        this.uAV = new WalletBrandUI.e(this);
      }
    }
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().eHt.a(this.uAV.cXj(), this);
    AppMethodBeat.o(48261);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(48262);
    ab.i("MicroMsg.WalletBrandUI", "onDestroy");
    super.onDestroy();
    if ((this.uAV instanceof WalletBrandUI.c)) {
      ab.i("MicroMsg.WalletBrandUI", "onDestroy: do pay with kinda");
    }
    for (;;)
    {
      com.tencent.mm.sdk.b.a.ymk.d(this.uBa);
      com.tencent.mm.sdk.b.a.ymk.d(this.uBb);
      AppMethodBeat.o(48262);
      return;
      com.tencent.mm.kernel.g.RM();
      com.tencent.mm.kernel.g.RK().eHt.b(this.uAV.cXj(), this);
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(48265);
    if (paramInt == 4)
    {
      finish();
      AppMethodBeat.o(48265);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(48265);
    return bool;
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(48263);
    ab.i("MicroMsg.WalletBrandUI", "onNewIntent");
    super.onNewIntent(paramIntent);
    AppMethodBeat.o(48263);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(48264);
    ab.i("MicroMsg.WalletBrandUI", "onResume");
    super.onResume();
    ab.i("MicroMsg.WalletBrandUI", "Handler jump intercept = %b,taskid = %d,parentName = %s", new Object[] { Boolean.valueOf(this.uAU), Integer.valueOf(getTaskId()), getCallingActivity() });
    if (!this.uAU)
    {
      this.uAU = true;
      this.uAW = this.uAV.cXk();
      if (this.gKM != null)
      {
        this.gKM.dismiss();
        this.gKM = null;
      }
      if (!cXi()) {
        this.gKM = com.tencent.mm.wallet_core.ui.g.b(this, true, new WalletBrandUI.1(this));
      }
    }
    AppMethodBeat.o(48264);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(48268);
    ab.i("MicroMsg.WalletBrandUI", "hy: brandui on scene end. errType: %d, errCode: %d, errMsg:%s scene %s _scene %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramm, this.uAW });
    if ((paramm.getType() != this.uAV.cXj()) || (paramm != this.uAW))
    {
      AppMethodBeat.o(48268);
      return;
    }
    this.uAV.onSceneEnd(paramInt1, paramInt2, paramString, paramm);
    AppMethodBeat.o(48268);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(48267);
    super.onStop();
    if (this.gKM != null)
    {
      this.gKM.dismiss();
      this.gKM = null;
    }
    AppMethodBeat.o(48267);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.ui.WalletBrandUI
 * JD-Core Version:    0.7.0.1
 */