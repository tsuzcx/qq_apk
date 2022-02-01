package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.g.a.xe;
import com.tencent.mm.g.a.xk;
import com.tencent.mm.g.a.ye;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.qb;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;

@com.tencent.mm.ui.base.a(3)
public class WalletMixOrderInfoUI
  extends WalletBaseUI
{
  private boolean AnE;
  private boolean AnF;
  private qb AnG;
  private int AnH;
  private c AnI;
  private String appId;
  private int dCG;
  private String dCx;
  private String dcE;
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
    this.dcE = null;
    this.signType = null;
    this.dCx = null;
    this.AnI = new c() {};
    AppMethodBeat.o(70979);
  }
  
  private void aut(String paramString)
  {
    AppMethodBeat.i(70984);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(70984);
      return;
    }
    ad.d("MicroMsg.WalletMixOrderInfoUI", "H5 wallet url: %s", new Object[] { paramString });
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString);
    localIntent.putExtra("showShare", false);
    localIntent.putExtra("show_bottom", false);
    localIntent.putExtra("needRedirect", false);
    localIntent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.Cqe);
    localIntent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.Cqa);
    e.b(getContext(), localIntent, 1);
    AppMethodBeat.o(70984);
  }
  
  private void bq(Context paramContext, String paramString)
  {
    AppMethodBeat.i(70985);
    ad.i("MicroMsg.WalletMixOrderInfoUI", "showErrorAlert");
    if (!this.AnE)
    {
      ye localye = new ye();
      localye.dEu.result = 0;
      com.tencent.mm.sdk.b.a.ESL.l(localye);
    }
    paramContext = h.a(paramContext, paramString, "", false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(70978);
        paramAnonymousDialogInterface.dismiss();
        if (WalletMixOrderInfoUI.k(WalletMixOrderInfoUI.this))
        {
          paramAnonymousDialogInterface = new ye();
          paramAnonymousDialogInterface.dEu.result = this.AnL;
          com.tencent.mm.sdk.b.a.ESL.l(paramAnonymousDialogInterface);
        }
        paramAnonymousDialogInterface = new xk();
        paramAnonymousDialogInterface.dDy.dcE = WalletMixOrderInfoUI.a(WalletMixOrderInfoUI.this);
        paramAnonymousDialogInterface.dDy.result = this.AnL;
        com.tencent.mm.sdk.b.a.ESL.l(paramAnonymousDialogInterface);
        WalletMixOrderInfoUI.this.setResult(this.AnL);
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
    ad.i("MicroMsg.WalletMixOrderInfoUI", "finish");
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
      ad.d("MicroMsg.WalletMixOrderInfoUI", "requestCode: %d, resultCode: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (this.AnF)
      {
        com.tencent.mm.sdk.b.a.ESL.d(this.AnI);
        paramIntent = new xk();
        paramIntent.dDy.dcE = this.prepayId;
        paramIntent.dDy.result = 0;
        com.tencent.mm.sdk.b.a.ESL.l(paramIntent);
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
    this.AnG = new qb();
    this.AnG.COZ = paramBundle.getIntExtra("max_count", 3);
    this.AnG.COY = paramBundle.getIntExtra("inteval_time", 4);
    this.AnG.CPa = paramBundle.getStringExtra("default_wording");
    if (bt.isNullOrNil(this.AnG.CPa)) {
      this.AnG.CPa = getString(2131765224);
    }
    this.AnH = this.AnG.COZ;
    this.AnE = paramBundle.getBooleanExtra("is_jsapi_offline_pay", false);
    this.AnF = true;
    if (!this.AnE)
    {
      final String str1 = paramBundle.getStringExtra("pay_gate_url");
      boolean bool = paramBundle.getBooleanExtra("need_dialog", false);
      String str2 = paramBundle.getStringExtra("dialog_text");
      this.prepayId = paramBundle.getStringExtra("prepayId");
      ad.i("MicroMsg.WalletMixOrderInfoUI", " prepayId:%s ，need_dialog:%s", new Object[] { this.prepayId, Boolean.valueOf(bool) });
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
            paramAnonymousDialogInterface = new xk();
            paramAnonymousDialogInterface.dDy.dcE = WalletMixOrderInfoUI.a(WalletMixOrderInfoUI.this);
            paramAnonymousDialogInterface.dDy.result = 0;
            com.tencent.mm.sdk.b.a.ESL.l(paramAnonymousDialogInterface);
            WalletMixOrderInfoUI.this.finish();
            AppMethodBeat.o(70976);
          }
        }).setCancelable(false);
      }
      for (;;)
      {
        com.tencent.mm.sdk.b.a.ESL.c(this.AnI);
        AppMethodBeat.o(70980);
        return;
        aut(str1);
      }
    }
    this.appId = getIntent().getStringExtra("appId");
    this.timeStamp = getIntent().getStringExtra("timeStamp");
    this.nonceStr = getIntent().getStringExtra("nonceStr");
    this.packageExt = getIntent().getStringExtra("packageExt");
    this.dcE = getIntent().getStringExtra("reqKey");
    this.dCG = getIntent().getIntExtra("payScene", -1);
    this.signType = getIntent().getStringExtra("signtype");
    this.dCx = getIntent().getStringExtra("paySignature");
    if ((this.dCG == 2) && (bt.isNullOrNil(this.prepayId)))
    {
      doSceneForceProgress(new com.tencent.mm.plugin.wallet_core.c.c.a(this.appId, this.timeStamp, this.nonceStr, this.packageExt, this.dcE, this.dCG, this.signType, this.dCx));
      AppMethodBeat.o(70980);
      return;
    }
    bq(this, getString(2131765589));
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
        this.AnF = false;
        paramString = new ye();
        paramString.dEu.result = -1;
        com.tencent.mm.sdk.b.a.ESL.l(paramString);
        paramString = ((com.tencent.mm.plugin.wallet_core.c.c.a)paramn).zXf;
        ad.i("MicroMsg.WalletMixOrderInfoUI", " go to WalletMixOrderInfoProxyUI");
        paramn = new Intent(this, WalletMixOrderInfoProxyUI.class);
        paramn.putExtra("key_orders", paramString);
        paramn.putExtra("prepayId", this.prepayId);
        paramString = new com.tencent.mm.hellhoundlib.b.a().bd(paramn);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramString.adn(), "com/tencent/mm/plugin/wallet_core/ui/WalletMixOrderInfoUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramString.lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletMixOrderInfoUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        setResult(-1);
        finish();
      }
      for (;;)
      {
        AppMethodBeat.o(70982);
        return true;
        if (this.AnH == 0) {}
        for (paramInt1 = 0;; paramInt1 = 1)
        {
          if (paramInt1 == 0) {
            break label305;
          }
          ad.d("MicroMsg.WalletMixOrderInfoUI", "retryGetPaidOrderDetailAgain again");
          ad.d("MicroMsg.WalletMixOrderInfoUI", "retryGetPaidOrderDetailAgain：m_currentRetryCount: %d", new Object[] { Integer.valueOf(this.AnH) });
          this.AnH -= 1;
          doSceneForceProgress(new com.tencent.mm.plugin.wallet_core.c.c.a(this.appId, this.timeStamp, this.nonceStr, this.packageExt, this.prepayId, this.dCG, this.signType, this.dCx), this.AnG.COY);
          break;
        }
        label305:
        this.AnF = false;
        paramn = paramString;
        if (paramString.isEmpty()) {
          paramn = this.AnG.CPa;
        }
        bq(this, paramn);
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