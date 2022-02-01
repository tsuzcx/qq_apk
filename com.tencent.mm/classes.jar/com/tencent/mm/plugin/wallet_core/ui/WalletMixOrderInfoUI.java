package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.g.a.yp;
import com.tencent.mm.g.a.yv;
import com.tencent.mm.g.a.zp;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.se;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.f;

@com.tencent.mm.ui.base.a(3)
public class WalletMixOrderInfoUI
  extends WalletBaseUI
{
  private boolean DxU;
  private boolean DxV;
  private se DxW;
  private int DxX;
  private c DxY;
  private String appId;
  private String dNM;
  private int dNV;
  private String dmw;
  private String nonceStr;
  private String packageExt;
  private String prepayId;
  private String signType;
  private String timeStamp;
  
  public WalletMixOrderInfoUI()
  {
    AppMethodBeat.i(70979);
    this.prepayId = null;
    this.appId = null;
    this.timeStamp = null;
    this.nonceStr = null;
    this.packageExt = null;
    this.dmw = null;
    this.signType = null;
    this.dNM = null;
    this.DxY = new c() {};
    AppMethodBeat.o(70979);
  }
  
  private void aGo(String paramString)
  {
    AppMethodBeat.i(70984);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(70984);
      return;
    }
    ae.d("MicroMsg.WalletMixOrderInfoUI", "H5 wallet url: %s", new Object[] { paramString });
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString);
    localIntent.putExtra("showShare", false);
    localIntent.putExtra("show_bottom", false);
    localIntent.putExtra("needRedirect", false);
    localIntent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.FGb);
    localIntent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.FFX);
    f.b(getContext(), localIntent, 1);
    AppMethodBeat.o(70984);
  }
  
  private void bw(Context paramContext, String paramString)
  {
    AppMethodBeat.i(70985);
    ae.i("MicroMsg.WalletMixOrderInfoUI", "showErrorAlert");
    if (!this.DxU)
    {
      zp localzp = new zp();
      localzp.dPJ.result = 0;
      com.tencent.mm.sdk.b.a.IvT.l(localzp);
    }
    paramContext = h.a(paramContext, paramString, "", false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(70978);
        paramAnonymousDialogInterface.dismiss();
        if (WalletMixOrderInfoUI.k(WalletMixOrderInfoUI.this))
        {
          paramAnonymousDialogInterface = new zp();
          paramAnonymousDialogInterface.dPJ.result = this.Dyb;
          com.tencent.mm.sdk.b.a.IvT.l(paramAnonymousDialogInterface);
        }
        paramAnonymousDialogInterface = new yv();
        paramAnonymousDialogInterface.dON.dmw = WalletMixOrderInfoUI.a(WalletMixOrderInfoUI.this);
        paramAnonymousDialogInterface.dON.result = this.Dyb;
        com.tencent.mm.sdk.b.a.IvT.l(paramAnonymousDialogInterface);
        WalletMixOrderInfoUI.this.setResult(this.Dyb);
        WalletMixOrderInfoUI.this.finish();
        AppMethodBeat.o(70978);
      }
    });
    if (paramContext != null) {
      paramContext.setCancelable(false);
    }
    AppMethodBeat.o(70985);
  }
  
  public void finish()
  {
    AppMethodBeat.i(182529);
    super.finish();
    ae.i("MicroMsg.WalletMixOrderInfoUI", "finish");
    AppMethodBeat.o(182529);
  }
  
  public int getLayoutId()
  {
    return 2131495807;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(70983);
    if ((paramInt1 == 1) && (paramInt2 == 0))
    {
      ae.d("MicroMsg.WalletMixOrderInfoUI", "requestCode: %d, resultCode: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (this.DxV)
      {
        com.tencent.mm.sdk.b.a.IvT.d(this.DxY);
        paramIntent = new yv();
        paramIntent.dON.dmw = this.prepayId;
        paramIntent.dON.result = 0;
        com.tencent.mm.sdk.b.a.IvT.l(paramIntent);
        finish();
      }
    }
    AppMethodBeat.o(70983);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(70980);
    super.onCreate(paramBundle);
    paramBundle = getIntent();
    this.DxW = new se();
    this.DxW.Ghq = paramBundle.getIntExtra("max_count", 3);
    this.DxW.Ghp = paramBundle.getIntExtra("inteval_time", 4);
    this.DxW.Ghr = paramBundle.getStringExtra("default_wording");
    if (bu.isNullOrNil(this.DxW.Ghr)) {
      this.DxW.Ghr = getString(2131765224);
    }
    this.DxX = this.DxW.Ghq;
    this.DxU = paramBundle.getBooleanExtra("is_jsapi_offline_pay", false);
    this.DxV = true;
    if (!this.DxU)
    {
      final String str1 = paramBundle.getStringExtra("pay_gate_url");
      boolean bool = paramBundle.getBooleanExtra("need_dialog", false);
      String str2 = paramBundle.getStringExtra("dialog_text");
      this.prepayId = paramBundle.getStringExtra("prepayId");
      ae.i("MicroMsg.WalletMixOrderInfoUI", " prepayId:%s ，need_dialog:%s", new Object[] { this.prepayId, Boolean.valueOf(bool) });
      if (bool) {
        h.a(this, str2, "", new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(70975);
            paramAnonymousDialogInterface.dismiss();
            WalletMixOrderInfoUI.a(WalletMixOrderInfoUI.this, str1);
            AppMethodBeat.o(70975);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(70976);
            paramAnonymousDialogInterface.dismiss();
            paramAnonymousDialogInterface = new yv();
            paramAnonymousDialogInterface.dON.dmw = WalletMixOrderInfoUI.a(WalletMixOrderInfoUI.this);
            paramAnonymousDialogInterface.dON.result = 0;
            com.tencent.mm.sdk.b.a.IvT.l(paramAnonymousDialogInterface);
            WalletMixOrderInfoUI.this.finish();
            AppMethodBeat.o(70976);
          }
        }).setCancelable(false);
      }
      for (;;)
      {
        com.tencent.mm.sdk.b.a.IvT.c(this.DxY);
        AppMethodBeat.o(70980);
        return;
        aGo(str1);
      }
    }
    this.appId = getIntent().getStringExtra("appId");
    this.timeStamp = getIntent().getStringExtra("timeStamp");
    this.nonceStr = getIntent().getStringExtra("nonceStr");
    this.packageExt = getIntent().getStringExtra("packageExt");
    this.dmw = getIntent().getStringExtra("reqKey");
    this.dNV = getIntent().getIntExtra("payScene", -1);
    this.signType = getIntent().getStringExtra("signtype");
    this.dNM = getIntent().getStringExtra("paySignature");
    if ((this.dNV == 2) && (bu.isNullOrNil(this.prepayId)))
    {
      doSceneForceProgress(new com.tencent.mm.plugin.wallet_core.c.c.a(this.appId, this.timeStamp, this.nonceStr, this.packageExt, this.dmw, this.dNV, this.signType, this.dNM));
      AppMethodBeat.o(70980);
      return;
    }
    bw(this, getString(2131765589));
    AppMethodBeat.o(70980);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(70981);
    super.onResume();
    AppMethodBeat.o(70981);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(70982);
    if ((paramn instanceof com.tencent.mm.plugin.wallet_core.c.c.a))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.DxV = false;
        paramString = new zp();
        paramString.dPJ.result = -1;
        com.tencent.mm.sdk.b.a.IvT.l(paramString);
        paramString = ((com.tencent.mm.plugin.wallet_core.c.c.a)paramn).Dhs;
        ae.i("MicroMsg.WalletMixOrderInfoUI", " go to WalletMixOrderInfoProxyUI");
        paramn = new Intent(this, WalletMixOrderInfoProxyUI.class);
        paramn.putExtra("key_orders", paramString);
        paramn.putExtra("prepayId", this.prepayId);
        paramString = new com.tencent.mm.hellhoundlib.b.a().bc(paramn);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramString.ahE(), "com/tencent/mm/plugin/wallet_core/ui/WalletMixOrderInfoUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramString.mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletMixOrderInfoUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        setResult(-1);
        finish();
      }
      for (;;)
      {
        AppMethodBeat.o(70982);
        return true;
        if (this.DxX == 0) {}
        for (paramInt1 = 0;; paramInt1 = 1)
        {
          if (paramInt1 == 0) {
            break label305;
          }
          ae.d("MicroMsg.WalletMixOrderInfoUI", "retryGetPaidOrderDetailAgain again");
          ae.d("MicroMsg.WalletMixOrderInfoUI", "retryGetPaidOrderDetailAgain：m_currentRetryCount: %d", new Object[] { Integer.valueOf(this.DxX) });
          this.DxX -= 1;
          doSceneForceProgress(new com.tencent.mm.plugin.wallet_core.c.c.a(this.appId, this.timeStamp, this.nonceStr, this.packageExt, this.prepayId, this.dNV, this.signType, this.dNM), this.DxW.Ghp);
          break;
        }
        label305:
        this.DxV = false;
        paramn = paramString;
        if (paramString.isEmpty()) {
          paramn = this.DxW.Ghr;
        }
        bw(this, paramn);
      }
    }
    AppMethodBeat.o(70982);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletMixOrderInfoUI
 * JD-Core Version:    0.7.0.1
 */