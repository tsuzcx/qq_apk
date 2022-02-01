package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.f.a.abb;
import com.tencent.mm.f.a.abh;
import com.tencent.mm.f.a.aca;
import com.tencent.mm.f.a.ace;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.tj;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.g;

@com.tencent.mm.ui.base.a(3)
public class WalletMixOrderInfoUI
  extends WalletBaseUI
{
  private IListener ERe;
  private boolean OZl;
  public boolean OZm;
  private tj OZn;
  private int OZo;
  private IListener OZp;
  private String appId;
  private String fJB;
  private String fwv;
  public int gag;
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
    this.fwv = null;
    this.signType = null;
    this.fJB = null;
    this.ERe = new IListener() {};
    this.OZp = new IListener() {};
    AppMethodBeat.o(70979);
  }
  
  private boolean amF(int paramInt)
  {
    AppMethodBeat.i(273170);
    Bundle localBundle = new Bundle();
    localBundle.putString("appid", this.appId);
    localBundle.putString("timestamp", this.timeStamp);
    localBundle.putString("nonce_str", this.nonceStr);
    localBundle.putString("package", this.packageExt);
    localBundle.putInt("input_pay_scene", this.gag);
    localBundle.putString("sign_type", this.signType);
    localBundle.putString("pay_sign", this.fJB);
    localBundle.putString("req_key", this.fwv);
    localBundle.putInt("origin_pay_scene", paramInt);
    localBundle.putString("order_id", this.prepayId);
    localBundle.putInt("retry_max_count", this.OZn.Sdg);
    localBundle.putInt("retry_interval_seconds", this.OZn.Sdf);
    localBundle.putString("retry_default_wording", this.OZn.Sdh);
    if (((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.pluginsdk.wallet.a.class)).startOverseaWalletSuccPageUseCase(this, localBundle))
    {
      AppMethodBeat.o(273170);
      return true;
    }
    AppMethodBeat.o(273170);
    return false;
  }
  
  public static void amG(int paramInt)
  {
    AppMethodBeat.i(273171);
    ace localace = new ace();
    localace.gcd.result = paramInt;
    EventCenter.instance.publish(localace);
    AppMethodBeat.o(273171);
  }
  
  private void bhy(String paramString)
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
    localIntent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.RBc);
    localIntent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.RAX);
    g.c(getContext(), localIntent, 1);
    EventCenter.instance.addListener(this.ERe);
    AppMethodBeat.o(70984);
  }
  
  private void cb(Context paramContext, String paramString)
  {
    AppMethodBeat.i(70985);
    Log.i("MicroMsg.WalletMixOrderInfoUI", "showErrorAlert");
    if (!this.OZl)
    {
      ace localace = new ace();
      localace.gcd.result = 0;
      EventCenter.instance.publish(localace);
    }
    paramContext = com.tencent.mm.ui.base.h.a(paramContext, paramString, "", false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(213689);
        paramAnonymousDialogInterface.dismiss();
        if (WalletMixOrderInfoUI.m(WalletMixOrderInfoUI.this))
        {
          paramAnonymousDialogInterface = new ace();
          paramAnonymousDialogInterface.gcd.result = this.OZs;
          EventCenter.instance.publish(paramAnonymousDialogInterface);
        }
        paramAnonymousDialogInterface = new abh();
        paramAnonymousDialogInterface.gaZ.fwv = WalletMixOrderInfoUI.a(WalletMixOrderInfoUI.this);
        paramAnonymousDialogInterface.gaZ.result = this.OZs;
        EventCenter.instance.publish(paramAnonymousDialogInterface);
        WalletMixOrderInfoUI.this.setResult(this.OZs);
        WalletMixOrderInfoUI.this.finish();
        AppMethodBeat.o(213689);
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
      if (this.OZm)
      {
        Log.i("MicroMsg.WalletMixOrderInfoUI", "onActivityResult, mIsPending is true");
        EventCenter.instance.removeListener(this.OZp);
        paramIntent = new abh();
        paramIntent.gaZ.fwv = this.prepayId;
        paramIntent.gaZ.result = 0;
        EventCenter.instance.publish(paramIntent);
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
    this.OZn = new tj();
    this.OZn.Sdg = paramBundle.getIntExtra("max_count", 3);
    this.OZn.Sdf = paramBundle.getIntExtra("inteval_time", 4);
    this.OZn.Sdh = paramBundle.getStringExtra("default_wording");
    if (Util.isNullOrNil(this.OZn.Sdh)) {
      this.OZn.Sdh = getString(a.i.wallet_data_err);
    }
    this.OZo = this.OZn.Sdg;
    this.OZl = paramBundle.getBooleanExtra("is_jsapi_offline_pay", false);
    this.OZm = true;
    if (!this.OZl)
    {
      final String str1 = paramBundle.getStringExtra("pay_gate_url");
      boolean bool = paramBundle.getBooleanExtra("need_dialog", false);
      String str2 = paramBundle.getStringExtra("dialog_text");
      this.prepayId = paramBundle.getStringExtra("prepayId");
      Log.i("MicroMsg.WalletMixOrderInfoUI", " prepayId:%s ，need_dialog:%s", new Object[] { this.prepayId, Boolean.valueOf(bool) });
      if (bool) {
        com.tencent.mm.ui.base.h.a(this, str2, "", new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
            paramAnonymousDialogInterface = new abh();
            paramAnonymousDialogInterface.gaZ.fwv = WalletMixOrderInfoUI.a(WalletMixOrderInfoUI.this);
            paramAnonymousDialogInterface.gaZ.result = 0;
            EventCenter.instance.publish(paramAnonymousDialogInterface);
            WalletMixOrderInfoUI.this.finish();
            AppMethodBeat.o(70976);
          }
        }).setCancelable(false);
      }
      for (;;)
      {
        EventCenter.instance.addListener(this.OZp);
        AppMethodBeat.o(70980);
        return;
        bhy(str1);
      }
    }
    this.appId = getIntent().getStringExtra("appId");
    this.timeStamp = getIntent().getStringExtra("timeStamp");
    this.nonceStr = getIntent().getStringExtra("nonceStr");
    this.packageExt = getIntent().getStringExtra("packageExt");
    this.fwv = getIntent().getStringExtra("reqKey");
    this.gag = getIntent().getIntExtra("payScene", -1);
    this.signType = getIntent().getStringExtra("signtype");
    this.fJB = getIntent().getStringExtra("paySignature");
    Log.i("MicroMsg.WalletMixOrderInfoUI", "start query offline walletmix succ page, prepayId:%s, payScene：%s, reqKey:%s", new Object[] { this.prepayId, Integer.valueOf(this.gag), this.fwv });
    if (amF(2))
    {
      Log.i("MicroMsg.WalletMixOrderInfoUI", "startOverseaWalletSuccPageUseCase is true, go kinda");
      AppMethodBeat.o(70980);
      return;
    }
    if ((this.gag == 2) && (Util.isNullOrNil(this.prepayId)))
    {
      doSceneForceProgress(new com.tencent.mm.plugin.wallet_core.c.c.a(this.appId, this.timeStamp, this.nonceStr, this.packageExt, this.fwv, this.gag, this.signType, this.fJB));
      AppMethodBeat.o(70980);
      return;
    }
    cb(this, getString(a.i.wallet_paid_unknown_error_wallet_mix));
    AppMethodBeat.o(70980);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(273169);
    super.onDestroy();
    EventCenter.instance.removeListener(this.OZp);
    EventCenter.instance.removeListener(this.ERe);
    AppMethodBeat.o(273169);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(70981);
    super.onResume();
    AppMethodBeat.o(70981);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(70982);
    if ((paramq instanceof com.tencent.mm.plugin.wallet_core.c.c.a))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.OZm = false;
        paramString = new ace();
        paramString.gcd.result = -1;
        EventCenter.instance.publish(paramString);
        paramString = ((com.tencent.mm.plugin.wallet_core.c.c.a)paramq).OIT;
        Log.i("MicroMsg.WalletMixOrderInfoUI", " go to WalletMixOrderInfoProxyUI");
        paramq = new Intent(this, WalletMixOrderInfoProxyUI.class);
        paramq.putExtra("key_orders", paramString);
        paramq.putExtra("prepayId", this.prepayId);
        paramString = new com.tencent.mm.hellhoundlib.b.a().bm(paramq);
        com.tencent.mm.hellhoundlib.a.a.b(this, paramString.aFh(), "com/tencent/mm/plugin/wallet_core/ui/WalletMixOrderInfoUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramString.sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/wallet_core/ui/WalletMixOrderInfoUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        setResult(-1);
        finish();
      }
      for (;;)
      {
        AppMethodBeat.o(70982);
        return true;
        if (this.OZo == 0) {}
        for (paramInt1 = 0;; paramInt1 = 1)
        {
          if (paramInt1 == 0) {
            break label305;
          }
          Log.d("MicroMsg.WalletMixOrderInfoUI", "retryGetPaidOrderDetailAgain again");
          Log.d("MicroMsg.WalletMixOrderInfoUI", "retryGetPaidOrderDetailAgain：m_currentRetryCount: %d", new Object[] { Integer.valueOf(this.OZo) });
          this.OZo -= 1;
          doSceneForceProgress(new com.tencent.mm.plugin.wallet_core.c.c.a(this.appId, this.timeStamp, this.nonceStr, this.packageExt, this.prepayId, this.gag, this.signType, this.fJB), this.OZn.Sdf);
          break;
        }
        label305:
        this.OZm = false;
        paramq = paramString;
        if (paramString.isEmpty()) {
          paramq = this.OZn.Sdh;
        }
        cb(this, paramq);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletMixOrderInfoUI
 * JD-Core Version:    0.7.0.1
 */