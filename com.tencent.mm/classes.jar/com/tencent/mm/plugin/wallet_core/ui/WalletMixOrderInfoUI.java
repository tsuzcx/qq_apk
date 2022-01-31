package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.ah.m;
import com.tencent.mm.br.d;
import com.tencent.mm.h.a.tp;
import com.tencent.mm.h.a.ul;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.c.li;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@com.tencent.mm.ui.base.a(3)
public class WalletMixOrderInfoUI
  extends WalletBaseUI
{
  private String appId = null;
  private String bMX = null;
  private String ccR = null;
  private int ccY;
  private String nonceStr = null;
  private String packageExt = null;
  private String prepayId = null;
  private boolean qDM;
  private boolean qDN;
  private li qDO;
  private int qDP;
  private com.tencent.mm.sdk.b.c qDQ = new WalletMixOrderInfoUI.3(this);
  private String signType = null;
  private String timeStamp = null;
  
  private void QL(String paramString)
  {
    if (bk.bl(paramString)) {
      return;
    }
    y.d("MicroMsg.WalletMixOrderInfoUI", "H5 wallet url: %s", new Object[] { paramString });
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString);
    localIntent.putExtra("showShare", false);
    localIntent.putExtra("show_bottom", false);
    localIntent.putExtra("needRedirect", false);
    localIntent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.spm);
    localIntent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.spj);
    d.b(this, "webview", ".ui.tools.WebViewUI", localIntent, 1);
  }
  
  private void aT(Context paramContext, String paramString)
  {
    if (!this.qDM)
    {
      ul localul = new ul();
      localul.ceQ.result = 0;
      com.tencent.mm.sdk.b.a.udP.m(localul);
    }
    h.a(paramContext, paramString, "", false, new WalletMixOrderInfoUI.4(this)).setCancelable(false);
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramm instanceof com.tencent.mm.plugin.wallet_core.c.c.a))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.qDN = false;
        paramString = new ul();
        paramString.ceQ.result = -1;
        com.tencent.mm.sdk.b.a.udP.m(paramString);
        paramString = ((com.tencent.mm.plugin.wallet_core.c.c.a)paramm).qrs;
        paramm = new Intent(this, WalletMixOrderInfoProxyUI.class);
        paramm.putExtra("key_orders", paramString);
        paramm.putExtra("prepayId", this.prepayId);
        startActivity(paramm);
        setResult(-1);
        finish();
      }
      for (;;)
      {
        return true;
        if (this.qDP == 0) {}
        for (paramInt1 = 0;; paramInt1 = 1)
        {
          if (paramInt1 == 0) {
            break label215;
          }
          y.d("MicroMsg.WalletMixOrderInfoUI", "retryGetPaidOrderDetailAgain again");
          y.d("MicroMsg.WalletMixOrderInfoUI", "retryGetPaidOrderDetailAgain：m_currentRetryCount: %d", new Object[] { Integer.valueOf(this.qDP) });
          this.qDP -= 1;
          a(new com.tencent.mm.plugin.wallet_core.c.c.a(this.appId, this.timeStamp, this.nonceStr, this.packageExt, this.prepayId, this.ccY, this.signType, this.ccR), true, false, this.qDO.sGZ);
          break;
        }
        label215:
        this.qDN = false;
        aT(this, this.qDO.sHb);
      }
    }
    return false;
  }
  
  protected final int getLayoutId()
  {
    return a.g.transparent_layout;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 1) && (paramInt2 == 0))
    {
      y.d("MicroMsg.WalletMixOrderInfoUI", "requestCode: %d, resultCode: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (this.qDN)
      {
        paramIntent = new tp();
        paramIntent.cdQ.bMX = this.prepayId;
        paramIntent.cdQ.result = 0;
        com.tencent.mm.sdk.b.a.udP.m(paramIntent);
        finish();
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    kh(2570);
    paramBundle = getIntent();
    this.qDO = new li();
    this.qDO.sHa = paramBundle.getIntExtra("max_count", 3);
    this.qDO.sGZ = paramBundle.getIntExtra("inteval_time", 4);
    this.qDO.sHb = paramBundle.getStringExtra("default_wording");
    if (bk.bl(this.qDO.sHb)) {
      this.qDO.sHb = getString(a.i.wallet_data_err);
    }
    this.qDP = this.qDO.sHa;
    this.qDM = paramBundle.getBooleanExtra("is_jsapi_offline_pay", false);
    this.qDN = true;
    if (!this.qDM)
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
        com.tencent.mm.sdk.b.a.udP.c(this.qDQ);
        return;
        QL(str1);
      }
    }
    this.appId = getIntent().getStringExtra("appId");
    this.timeStamp = getIntent().getStringExtra("timeStamp");
    this.nonceStr = getIntent().getStringExtra("nonceStr");
    this.packageExt = getIntent().getStringExtra("packageExt");
    this.bMX = getIntent().getStringExtra("reqKey");
    this.ccY = getIntent().getIntExtra("payScene", -1);
    this.signType = getIntent().getStringExtra("signtype");
    this.ccR = getIntent().getStringExtra("paySignature");
    if ((this.ccY == 2) && (bk.bl(this.prepayId)))
    {
      a(new com.tencent.mm.plugin.wallet_core.c.c.a(this.appId, this.timeStamp, this.nonceStr, this.packageExt, this.bMX, this.ccY, this.signType, this.ccR), true, false);
      return;
    }
    aT(this, getString(a.i.wallet_paid_unknown_error_wallet_mix));
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ki(2570);
  }
  
  public void onResume()
  {
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletMixOrderInfoUI
 * JD-Core Version:    0.7.0.1
 */