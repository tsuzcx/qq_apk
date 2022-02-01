package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.acy;
import com.tencent.mm.autogen.a.ade;
import com.tencent.mm.autogen.a.adx;
import com.tencent.mm.autogen.a.aeb;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.uz;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.i;

@com.tencent.mm.ui.base.a(3)
public class WalletMixOrderInfoUI
  extends WalletBaseUI
{
  private IListener KLC;
  public boolean VPA;
  private uz VPB;
  private int VPC;
  private IListener VPD;
  private boolean VPz;
  private String appId;
  private String hAT;
  private String hPe;
  public int igp;
  private String nonceStr;
  private String packageExt;
  public String prepayId;
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
    this.hAT = null;
    this.signType = null;
    this.hPe = null;
    this.KLC = new IListener(f.hfK) {};
    this.VPD = new IListener(f.hfK) {};
    AppMethodBeat.o(70979);
  }
  
  private boolean asu(int paramInt)
  {
    AppMethodBeat.i(301205);
    Bundle localBundle = new Bundle();
    localBundle.putString("appid", this.appId);
    localBundle.putString("timestamp", this.timeStamp);
    localBundle.putString("nonce_str", this.nonceStr);
    localBundle.putString("package", this.packageExt);
    localBundle.putInt("input_pay_scene", this.igp);
    localBundle.putString("sign_type", this.signType);
    localBundle.putString("pay_sign", this.hPe);
    localBundle.putString("req_key", this.hAT);
    localBundle.putInt("origin_pay_scene", paramInt);
    localBundle.putString("order_id", this.prepayId);
    localBundle.putInt("retry_max_count", this.VPB.ZaY);
    localBundle.putInt("retry_interval_seconds", this.VPB.ZaX);
    localBundle.putString("retry_default_wording", this.VPB.ZaZ);
    if (((com.tencent.mm.pluginsdk.wallet.a)h.ax(com.tencent.mm.pluginsdk.wallet.a.class)).startOverseaWalletSuccPageUseCase(this, localBundle))
    {
      AppMethodBeat.o(301205);
      return true;
    }
    AppMethodBeat.o(301205);
    return false;
  }
  
  public static void asv(int paramInt)
  {
    AppMethodBeat.i(301207);
    aeb localaeb = new aeb();
    localaeb.iip.result = paramInt;
    localaeb.publish();
    AppMethodBeat.o(301207);
  }
  
  private void bhh(String paramString)
  {
    AppMethodBeat.i(70984);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(70984);
      return;
    }
    Log.d("MicroMsg.WalletMixOrderInfoUI", "H5 wallet url: %s", new Object[] { paramString });
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString);
    localIntent.putExtra("showShare", false);
    localIntent.putExtra("show_bottom", false);
    localIntent.putExtra("needRedirect", false);
    localIntent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.YxF);
    localIntent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.YxA);
    i.d(getContext(), localIntent, 1);
    this.KLC.alive();
    AppMethodBeat.o(70984);
  }
  
  private void cm(Context paramContext, String paramString)
  {
    AppMethodBeat.i(70985);
    Log.i("MicroMsg.WalletMixOrderInfoUI", "showErrorAlert");
    if (!this.VPz)
    {
      aeb localaeb = new aeb();
      localaeb.iip.result = 0;
      localaeb.publish();
    }
    paramContext = k.a(paramContext, paramString, "", false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(301201);
        paramAnonymousDialogInterface.dismiss();
        if (WalletMixOrderInfoUI.m(WalletMixOrderInfoUI.this))
        {
          paramAnonymousDialogInterface = new aeb();
          paramAnonymousDialogInterface.iip.result = this.VPG;
          paramAnonymousDialogInterface.publish();
        }
        paramAnonymousDialogInterface = new ade();
        paramAnonymousDialogInterface.ihj.hAT = WalletMixOrderInfoUI.a(WalletMixOrderInfoUI.this);
        paramAnonymousDialogInterface.ihj.result = this.VPG;
        paramAnonymousDialogInterface.publish();
        WalletMixOrderInfoUI.this.setResult(this.VPG);
        WalletMixOrderInfoUI.this.finish();
        AppMethodBeat.o(301201);
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
    Log.i("MicroMsg.WalletMixOrderInfoUI", "finish");
    AppMethodBeat.o(182529);
  }
  
  public int getLayoutId()
  {
    return a.g.transparent_layout;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(70983);
    if ((paramInt1 == 1) && (paramInt2 == 0))
    {
      Log.d("MicroMsg.WalletMixOrderInfoUI", "requestCode: %d, resultCode: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (this.VPA)
      {
        Log.i("MicroMsg.WalletMixOrderInfoUI", "onActivityResult, mIsPending is true");
        this.VPD.dead();
        paramIntent = new ade();
        paramIntent.ihj.hAT = this.prepayId;
        paramIntent.ihj.result = 0;
        paramIntent.publish();
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
    this.VPB = new uz();
    this.VPB.ZaY = paramBundle.getIntExtra("max_count", 3);
    this.VPB.ZaX = paramBundle.getIntExtra("inteval_time", 4);
    this.VPB.ZaZ = paramBundle.getStringExtra("default_wording");
    if (Util.isNullOrNil(this.VPB.ZaZ)) {
      this.VPB.ZaZ = getString(a.i.wallet_data_err);
    }
    this.VPC = this.VPB.ZaY;
    this.VPz = paramBundle.getBooleanExtra("is_jsapi_offline_pay", false);
    this.VPA = true;
    if (!this.VPz)
    {
      final String str1 = paramBundle.getStringExtra("pay_gate_url");
      boolean bool = paramBundle.getBooleanExtra("need_dialog", false);
      String str2 = paramBundle.getStringExtra("dialog_text");
      this.prepayId = paramBundle.getStringExtra("prepayId");
      Log.i("MicroMsg.WalletMixOrderInfoUI", " prepayId:%s ，need_dialog:%s", new Object[] { this.prepayId, Boolean.valueOf(bool) });
      if (bool) {
        k.a(this, str2, "", new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
            paramAnonymousDialogInterface = new ade();
            paramAnonymousDialogInterface.ihj.hAT = WalletMixOrderInfoUI.a(WalletMixOrderInfoUI.this);
            paramAnonymousDialogInterface.ihj.result = 0;
            paramAnonymousDialogInterface.publish();
            WalletMixOrderInfoUI.this.finish();
            AppMethodBeat.o(70976);
          }
        }).setCancelable(false);
      }
      for (;;)
      {
        this.VPD.alive();
        AppMethodBeat.o(70980);
        return;
        bhh(str1);
      }
    }
    this.appId = getIntent().getStringExtra("appId");
    this.timeStamp = getIntent().getStringExtra("timeStamp");
    this.nonceStr = getIntent().getStringExtra("nonceStr");
    this.packageExt = getIntent().getStringExtra("packageExt");
    this.hAT = getIntent().getStringExtra("reqKey");
    this.igp = getIntent().getIntExtra("payScene", -1);
    this.signType = getIntent().getStringExtra("signtype");
    this.hPe = getIntent().getStringExtra("paySignature");
    Log.i("MicroMsg.WalletMixOrderInfoUI", "start query offline walletmix succ page, prepayId:%s, payScene：%s, reqKey:%s", new Object[] { this.prepayId, Integer.valueOf(this.igp), this.hAT });
    if (asu(2))
    {
      Log.i("MicroMsg.WalletMixOrderInfoUI", "startOverseaWalletSuccPageUseCase is true, go kinda");
      AppMethodBeat.o(70980);
      return;
    }
    if ((this.igp == 2) && (Util.isNullOrNil(this.prepayId)))
    {
      doSceneForceProgress(new com.tencent.mm.plugin.wallet_core.c.c.a(this.appId, this.timeStamp, this.nonceStr, this.packageExt, this.hAT, this.igp, this.signType, this.hPe));
      AppMethodBeat.o(70980);
      return;
    }
    cm(this, getString(a.i.wallet_paid_unknown_error_wallet_mix));
    AppMethodBeat.o(70980);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(301246);
    super.onDestroy();
    this.VPD.dead();
    this.KLC.dead();
    AppMethodBeat.o(301246);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(70981);
    super.onResume();
    AppMethodBeat.o(70981);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(70982);
    if ((paramp instanceof com.tencent.mm.plugin.wallet_core.c.c.a))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.VPA = false;
        paramString = new aeb();
        paramString.iip.result = -1;
        paramString.publish();
        paramString = ((com.tencent.mm.plugin.wallet_core.c.c.a)paramp).VyF;
        Log.i("MicroMsg.WalletMixOrderInfoUI", " go to WalletMixOrderInfoProxyUI");
        paramp = new Intent(this, WalletMixOrderInfoProxyUI.class);
        paramp.putExtra("key_orders", paramString);
        paramp.putExtra("prepayId", this.prepayId);
        paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramp);
        com.tencent.mm.hellhoundlib.a.a.b(this, paramString.aYi(), "com/tencent/mm/plugin/wallet_core/ui/WalletMixOrderInfoUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramString.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/wallet_core/ui/WalletMixOrderInfoUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        setResult(-1);
        finish();
      }
      for (;;)
      {
        AppMethodBeat.o(70982);
        return true;
        if (this.VPC == 0) {}
        for (paramInt1 = 0;; paramInt1 = 1)
        {
          if (paramInt1 == 0) {
            break label302;
          }
          Log.d("MicroMsg.WalletMixOrderInfoUI", "retryGetPaidOrderDetailAgain again");
          Log.d("MicroMsg.WalletMixOrderInfoUI", "retryGetPaidOrderDetailAgain：m_currentRetryCount: %d", new Object[] { Integer.valueOf(this.VPC) });
          this.VPC -= 1;
          doSceneForceProgress(new com.tencent.mm.plugin.wallet_core.c.c.a(this.appId, this.timeStamp, this.nonceStr, this.packageExt, this.prepayId, this.igp, this.signType, this.hPe), this.VPB.ZaX);
          break;
        }
        label302:
        this.VPA = false;
        paramp = paramString;
        if (paramString.isEmpty()) {
          paramp = this.VPB.ZaZ;
        }
        cm(this, paramp);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletMixOrderInfoUI
 * JD-Core Version:    0.7.0.1
 */