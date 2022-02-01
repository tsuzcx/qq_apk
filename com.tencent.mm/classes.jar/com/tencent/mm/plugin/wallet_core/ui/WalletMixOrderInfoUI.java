package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.aaa;
import com.tencent.mm.g.a.aaw;
import com.tencent.mm.g.a.zu;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.th;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.f;

@com.tencent.mm.ui.base.a(3)
public class WalletMixOrderInfoUI
  extends WalletBaseUI
{
  private boolean Ihf;
  public boolean Ihg;
  private th Ihh;
  private int Ihi;
  private IListener Ihj;
  private String appId;
  private String dDL;
  private String dQk;
  public int efQ;
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
    this.dDL = null;
    this.signType = null;
    this.dQk = null;
    this.Ihj = new IListener() {};
    AppMethodBeat.o(70979);
  }
  
  private void aVP(String paramString)
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
    localIntent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.Kzm);
    localIntent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.Kzg);
    f.b(getContext(), localIntent, 1);
    AppMethodBeat.o(70984);
  }
  
  private boolean aeR(int paramInt)
  {
    AppMethodBeat.i(214241);
    Bundle localBundle = new Bundle();
    localBundle.putString("appid", this.appId);
    localBundle.putString("timestamp", this.timeStamp);
    localBundle.putString("nonce_str", this.nonceStr);
    localBundle.putString("package", this.packageExt);
    localBundle.putInt("input_pay_scene", this.efQ);
    localBundle.putString("sign_type", this.signType);
    localBundle.putString("pay_sign", this.dQk);
    localBundle.putString("req_key", this.dDL);
    localBundle.putInt("origin_pay_scene", paramInt);
    localBundle.putString("order_id", this.prepayId);
    localBundle.putInt("retry_max_count", this.Ihh.LbT);
    localBundle.putInt("retry_interval_seconds", this.Ihh.LbS);
    localBundle.putString("retry_default_wording", this.Ihh.LbU);
    if (((com.tencent.mm.pluginsdk.wallet.a)g.af(com.tencent.mm.pluginsdk.wallet.a.class)).startOverseaWalletSuccPageUseCase(this, localBundle))
    {
      AppMethodBeat.o(214241);
      return true;
    }
    AppMethodBeat.o(214241);
    return false;
  }
  
  public static void aeS(int paramInt)
  {
    AppMethodBeat.i(214242);
    aaw localaaw = new aaw();
    localaaw.ehM.result = paramInt;
    EventCenter.instance.publish(localaaw);
    AppMethodBeat.o(214242);
  }
  
  private void bQ(Context paramContext, String paramString)
  {
    AppMethodBeat.i(70985);
    Log.i("MicroMsg.WalletMixOrderInfoUI", "showErrorAlert");
    if (!this.Ihf)
    {
      aaw localaaw = new aaw();
      localaaw.ehM.result = 0;
      EventCenter.instance.publish(localaaw);
    }
    paramContext = h.a(paramContext, paramString, "", false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(70978);
        paramAnonymousDialogInterface.dismiss();
        if (WalletMixOrderInfoUI.l(WalletMixOrderInfoUI.this))
        {
          paramAnonymousDialogInterface = new aaw();
          paramAnonymousDialogInterface.ehM.result = this.Ihm;
          EventCenter.instance.publish(paramAnonymousDialogInterface);
        }
        paramAnonymousDialogInterface = new aaa();
        paramAnonymousDialogInterface.egJ.dDL = WalletMixOrderInfoUI.a(WalletMixOrderInfoUI.this);
        paramAnonymousDialogInterface.egJ.result = this.Ihm;
        EventCenter.instance.publish(paramAnonymousDialogInterface);
        WalletMixOrderInfoUI.this.setResult(this.Ihm);
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
    Log.i("MicroMsg.WalletMixOrderInfoUI", "finish");
    AppMethodBeat.o(182529);
  }
  
  public int getLayoutId()
  {
    return 2131496765;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(70983);
    if ((paramInt1 == 1) && (paramInt2 == 0))
    {
      Log.d("MicroMsg.WalletMixOrderInfoUI", "requestCode: %d, resultCode: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (this.Ihg)
      {
        EventCenter.instance.removeListener(this.Ihj);
        paramIntent = new aaa();
        paramIntent.egJ.dDL = this.prepayId;
        paramIntent.egJ.result = 0;
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
    this.Ihh = new th();
    this.Ihh.LbT = paramBundle.getIntExtra("max_count", 3);
    this.Ihh.LbS = paramBundle.getIntExtra("inteval_time", 4);
    this.Ihh.LbU = paramBundle.getStringExtra("default_wording");
    if (Util.isNullOrNil(this.Ihh.LbU)) {
      this.Ihh.LbU = getString(2131767667);
    }
    this.Ihi = this.Ihh.LbT;
    this.Ihf = paramBundle.getBooleanExtra("is_jsapi_offline_pay", false);
    this.Ihg = true;
    if (!this.Ihf)
    {
      final String str1 = paramBundle.getStringExtra("pay_gate_url");
      boolean bool = paramBundle.getBooleanExtra("need_dialog", false);
      String str2 = paramBundle.getStringExtra("dialog_text");
      this.prepayId = paramBundle.getStringExtra("prepayId");
      Log.i("MicroMsg.WalletMixOrderInfoUI", " prepayId:%s ，need_dialog:%s", new Object[] { this.prepayId, Boolean.valueOf(bool) });
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
            paramAnonymousDialogInterface = new aaa();
            paramAnonymousDialogInterface.egJ.dDL = WalletMixOrderInfoUI.a(WalletMixOrderInfoUI.this);
            paramAnonymousDialogInterface.egJ.result = 0;
            EventCenter.instance.publish(paramAnonymousDialogInterface);
            WalletMixOrderInfoUI.this.finish();
            AppMethodBeat.o(70976);
          }
        }).setCancelable(false);
      }
      for (;;)
      {
        EventCenter.instance.addListener(this.Ihj);
        AppMethodBeat.o(70980);
        return;
        aVP(str1);
      }
    }
    this.appId = getIntent().getStringExtra("appId");
    this.timeStamp = getIntent().getStringExtra("timeStamp");
    this.nonceStr = getIntent().getStringExtra("nonceStr");
    this.packageExt = getIntent().getStringExtra("packageExt");
    this.dDL = getIntent().getStringExtra("reqKey");
    this.efQ = getIntent().getIntExtra("payScene", -1);
    this.signType = getIntent().getStringExtra("signtype");
    this.dQk = getIntent().getStringExtra("paySignature");
    Log.i("MicroMsg.WalletMixOrderInfoUI", "start query offline walletmix succ page, prepayId:%s, payScene：%s, reqKey:%s", new Object[] { this.prepayId, Integer.valueOf(this.efQ), this.dDL });
    if (aeR(2))
    {
      Log.i("MicroMsg.WalletMixOrderInfoUI", "startOverseaWalletSuccPageUseCase is true, go kinda");
      AppMethodBeat.o(70980);
      return;
    }
    if ((this.efQ == 2) && (Util.isNullOrNil(this.prepayId)))
    {
      doSceneForceProgress(new com.tencent.mm.plugin.wallet_core.c.c.a(this.appId, this.timeStamp, this.nonceStr, this.packageExt, this.dDL, this.efQ, this.signType, this.dQk));
      AppMethodBeat.o(70980);
      return;
    }
    bQ(this, getString(2131768038));
    AppMethodBeat.o(70980);
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
        this.Ihg = false;
        paramString = new aaw();
        paramString.ehM.result = -1;
        EventCenter.instance.publish(paramString);
        paramString = ((com.tencent.mm.plugin.wallet_core.c.c.a)paramq).HQL;
        Log.i("MicroMsg.WalletMixOrderInfoUI", " go to WalletMixOrderInfoProxyUI");
        paramq = new Intent(this, WalletMixOrderInfoProxyUI.class);
        paramq.putExtra("key_orders", paramString);
        paramq.putExtra("prepayId", this.prepayId);
        paramString = new com.tencent.mm.hellhoundlib.b.a().bl(paramq);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramString.axQ(), "com/tencent/mm/plugin/wallet_core/ui/WalletMixOrderInfoUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramString.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletMixOrderInfoUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        setResult(-1);
        finish();
      }
      for (;;)
      {
        AppMethodBeat.o(70982);
        return true;
        if (this.Ihi == 0) {}
        for (paramInt1 = 0;; paramInt1 = 1)
        {
          if (paramInt1 == 0) {
            break label305;
          }
          Log.d("MicroMsg.WalletMixOrderInfoUI", "retryGetPaidOrderDetailAgain again");
          Log.d("MicroMsg.WalletMixOrderInfoUI", "retryGetPaidOrderDetailAgain：m_currentRetryCount: %d", new Object[] { Integer.valueOf(this.Ihi) });
          this.Ihi -= 1;
          doSceneForceProgress(new com.tencent.mm.plugin.wallet_core.c.c.a(this.appId, this.timeStamp, this.nonceStr, this.packageExt, this.prepayId, this.efQ, this.signType, this.dQk), this.Ihh.LbS);
          break;
        }
        label305:
        this.Ihg = false;
        paramq = paramString;
        if (paramString.isEmpty()) {
          paramq = this.Ihh.LbU;
        }
        bQ(this, paramq);
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