package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.a.vk;
import com.tencent.mm.g.a.wf;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.nw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@com.tencent.mm.ui.base.a(3)
public class WalletMixOrderInfoUI
  extends WalletBaseUI
{
  private String appId;
  private String cLA;
  private int cLI;
  private String cnI;
  private String nonceStr;
  private String packageExt;
  private String prepayId;
  private String signType;
  private String timeStamp;
  private boolean uqH;
  private boolean uqI;
  private nw uqJ;
  private int uqK;
  private com.tencent.mm.sdk.b.c uqL;
  
  public WalletMixOrderInfoUI()
  {
    AppMethodBeat.i(47416);
    this.prepayId = null;
    this.appId = null;
    this.timeStamp = null;
    this.nonceStr = null;
    this.packageExt = null;
    this.cnI = null;
    this.signType = null;
    this.cLA = null;
    this.uqL = new WalletMixOrderInfoUI.3(this);
    AppMethodBeat.o(47416);
  }
  
  private void afJ(String paramString)
  {
    AppMethodBeat.i(47421);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(47421);
      return;
    }
    ab.d("MicroMsg.WalletMixOrderInfoUI", "H5 wallet url: %s", new Object[] { paramString });
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString);
    localIntent.putExtra("showShare", false);
    localIntent.putExtra("show_bottom", false);
    localIntent.putExtra("needRedirect", false);
    localIntent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.wib);
    localIntent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.whX);
    d.b(this, "webview", ".ui.tools.WebViewUI", localIntent, 1);
    AppMethodBeat.o(47421);
  }
  
  private void bd(Context paramContext, String paramString)
  {
    AppMethodBeat.i(47422);
    if (!this.uqH)
    {
      wf localwf = new wf();
      localwf.cNw.result = 0;
      com.tencent.mm.sdk.b.a.ymk.l(localwf);
    }
    h.a(paramContext, paramString, "", false, new WalletMixOrderInfoUI.4(this)).setCancelable(false);
    AppMethodBeat.o(47422);
  }
  
  public int getLayoutId()
  {
    return 2130971042;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(47420);
    if ((paramInt1 == 1) && (paramInt2 == 0))
    {
      ab.d("MicroMsg.WalletMixOrderInfoUI", "requestCode: %d, resultCode: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (this.uqI)
      {
        com.tencent.mm.sdk.b.a.ymk.d(this.uqL);
        paramIntent = new vk();
        paramIntent.cMA.cnI = this.prepayId;
        paramIntent.cMA.result = 0;
        com.tencent.mm.sdk.b.a.ymk.l(paramIntent);
        finish();
      }
    }
    AppMethodBeat.o(47420);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(47417);
    super.onCreate(paramBundle);
    paramBundle = getIntent();
    this.uqJ = new nw();
    this.uqJ.wDy = paramBundle.getIntExtra("max_count", 3);
    this.uqJ.wDx = paramBundle.getIntExtra("inteval_time", 4);
    this.uqJ.wDz = paramBundle.getStringExtra("default_wording");
    if (bo.isNullOrNil(this.uqJ.wDz)) {
      this.uqJ.wDz = getString(2131305032);
    }
    this.uqK = this.uqJ.wDy;
    this.uqH = paramBundle.getBooleanExtra("is_jsapi_offline_pay", false);
    this.uqI = true;
    if (!this.uqH)
    {
      String str1 = paramBundle.getStringExtra("pay_gate_url");
      boolean bool = paramBundle.getBooleanExtra("need_dialog", false);
      String str2 = paramBundle.getStringExtra("dialog_text");
      this.prepayId = paramBundle.getStringExtra("prepayId");
      if (bool) {
        h.a(this, str2, "", new WalletMixOrderInfoUI.1(this, str1), new WalletMixOrderInfoUI.2(this)).setCancelable(false);
      }
      for (;;)
      {
        com.tencent.mm.sdk.b.a.ymk.c(this.uqL);
        AppMethodBeat.o(47417);
        return;
        afJ(str1);
      }
    }
    this.appId = getIntent().getStringExtra("appId");
    this.timeStamp = getIntent().getStringExtra("timeStamp");
    this.nonceStr = getIntent().getStringExtra("nonceStr");
    this.packageExt = getIntent().getStringExtra("packageExt");
    this.cnI = getIntent().getStringExtra("reqKey");
    this.cLI = getIntent().getIntExtra("payScene", -1);
    this.signType = getIntent().getStringExtra("signtype");
    this.cLA = getIntent().getStringExtra("paySignature");
    if ((this.cLI == 2) && (bo.isNullOrNil(this.prepayId)))
    {
      doSceneForceProgress(new com.tencent.mm.plugin.wallet_core.c.c.a(this.appId, this.timeStamp, this.nonceStr, this.packageExt, this.cnI, this.cLI, this.signType, this.cLA));
      AppMethodBeat.o(47417);
      return;
    }
    bd(this, getString(2131305375));
    AppMethodBeat.o(47417);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(47418);
    super.onResume();
    AppMethodBeat.o(47418);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(47419);
    if ((paramm instanceof com.tencent.mm.plugin.wallet_core.c.c.a))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.uqI = false;
        paramString = new wf();
        paramString.cNw.result = -1;
        com.tencent.mm.sdk.b.a.ymk.l(paramString);
        paramString = ((com.tencent.mm.plugin.wallet_core.c.c.a)paramm).ucq;
        paramm = new Intent(this, WalletMixOrderInfoProxyUI.class);
        paramm.putExtra("key_orders", paramString);
        paramm.putExtra("prepayId", this.prepayId);
        startActivity(paramm);
        setResult(-1);
        finish();
      }
      for (;;)
      {
        AppMethodBeat.o(47419);
        return true;
        if (this.uqK == 0) {}
        for (paramInt1 = 0;; paramInt1 = 1)
        {
          if (paramInt1 == 0) {
            break label230;
          }
          ab.d("MicroMsg.WalletMixOrderInfoUI", "retryGetPaidOrderDetailAgain again");
          ab.d("MicroMsg.WalletMixOrderInfoUI", "retryGetPaidOrderDetailAgain：m_currentRetryCount: %d", new Object[] { Integer.valueOf(this.uqK) });
          this.uqK -= 1;
          doSceneForceProgress(new com.tencent.mm.plugin.wallet_core.c.c.a(this.appId, this.timeStamp, this.nonceStr, this.packageExt, this.prepayId, this.cLI, this.signType, this.cLA), this.uqJ.wDx);
          break;
        }
        label230:
        this.uqI = false;
        paramm = paramString;
        if (paramString.isEmpty()) {
          paramm = this.uqJ.wDz;
        }
        bd(this, paramm);
      }
    }
    AppMethodBeat.o(47419);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletMixOrderInfoUI
 * JD-Core Version:    0.7.0.1
 */