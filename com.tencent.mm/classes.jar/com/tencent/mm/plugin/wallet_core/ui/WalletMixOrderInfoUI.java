package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.g.a.yj;
import com.tencent.mm.g.a.yp;
import com.tencent.mm.g.a.zj;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.sc;
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
  private boolean Dgq;
  private boolean Dgr;
  private sc Dgs;
  private int Dgt;
  private c Dgu;
  private String appId;
  private int dMF;
  private String dMw;
  private String dlu;
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
    this.dlu = null;
    this.signType = null;
    this.dMw = null;
    this.Dgu = new c() {};
    AppMethodBeat.o(70979);
  }
  
  private void aEU(String paramString)
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
    localIntent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.FnD);
    localIntent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.Fnz);
    e.b(getContext(), localIntent, 1);
    AppMethodBeat.o(70984);
  }
  
  private void bu(Context paramContext, String paramString)
  {
    AppMethodBeat.i(70985);
    ad.i("MicroMsg.WalletMixOrderInfoUI", "showErrorAlert");
    if (!this.Dgq)
    {
      zj localzj = new zj();
      localzj.dOt.result = 0;
      com.tencent.mm.sdk.b.a.IbL.l(localzj);
    }
    paramContext = h.a(paramContext, paramString, "", false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(70978);
        paramAnonymousDialogInterface.dismiss();
        if (WalletMixOrderInfoUI.k(WalletMixOrderInfoUI.this))
        {
          paramAnonymousDialogInterface = new zj();
          paramAnonymousDialogInterface.dOt.result = this.Dgx;
          com.tencent.mm.sdk.b.a.IbL.l(paramAnonymousDialogInterface);
        }
        paramAnonymousDialogInterface = new yp();
        paramAnonymousDialogInterface.dNx.dlu = WalletMixOrderInfoUI.a(WalletMixOrderInfoUI.this);
        paramAnonymousDialogInterface.dNx.result = this.Dgx;
        com.tencent.mm.sdk.b.a.IbL.l(paramAnonymousDialogInterface);
        WalletMixOrderInfoUI.this.setResult(this.Dgx);
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
      if (this.Dgr)
      {
        com.tencent.mm.sdk.b.a.IbL.d(this.Dgu);
        paramIntent = new yp();
        paramIntent.dNx.dlu = this.prepayId;
        paramIntent.dNx.result = 0;
        com.tencent.mm.sdk.b.a.IbL.l(paramIntent);
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
    this.Dgs = new sc();
    this.Dgs.FOR = paramBundle.getIntExtra("max_count", 3);
    this.Dgs.FOQ = paramBundle.getIntExtra("inteval_time", 4);
    this.Dgs.FOS = paramBundle.getStringExtra("default_wording");
    if (bt.isNullOrNil(this.Dgs.FOS)) {
      this.Dgs.FOS = getString(2131765224);
    }
    this.Dgt = this.Dgs.FOR;
    this.Dgq = paramBundle.getBooleanExtra("is_jsapi_offline_pay", false);
    this.Dgr = true;
    if (!this.Dgq)
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
            paramAnonymousDialogInterface = new yp();
            paramAnonymousDialogInterface.dNx.dlu = WalletMixOrderInfoUI.a(WalletMixOrderInfoUI.this);
            paramAnonymousDialogInterface.dNx.result = 0;
            com.tencent.mm.sdk.b.a.IbL.l(paramAnonymousDialogInterface);
            WalletMixOrderInfoUI.this.finish();
            AppMethodBeat.o(70976);
          }
        }).setCancelable(false);
      }
      for (;;)
      {
        com.tencent.mm.sdk.b.a.IbL.c(this.Dgu);
        AppMethodBeat.o(70980);
        return;
        aEU(str1);
      }
    }
    this.appId = getIntent().getStringExtra("appId");
    this.timeStamp = getIntent().getStringExtra("timeStamp");
    this.nonceStr = getIntent().getStringExtra("nonceStr");
    this.packageExt = getIntent().getStringExtra("packageExt");
    this.dlu = getIntent().getStringExtra("reqKey");
    this.dMF = getIntent().getIntExtra("payScene", -1);
    this.signType = getIntent().getStringExtra("signtype");
    this.dMw = getIntent().getStringExtra("paySignature");
    if ((this.dMF == 2) && (bt.isNullOrNil(this.prepayId)))
    {
      doSceneForceProgress(new com.tencent.mm.plugin.wallet_core.c.c.a(this.appId, this.timeStamp, this.nonceStr, this.packageExt, this.dlu, this.dMF, this.signType, this.dMw));
      AppMethodBeat.o(70980);
      return;
    }
    bu(this, getString(2131765589));
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
        this.Dgr = false;
        paramString = new zj();
        paramString.dOt.result = -1;
        com.tencent.mm.sdk.b.a.IbL.l(paramString);
        paramString = ((com.tencent.mm.plugin.wallet_core.c.c.a)paramn).CPO;
        ad.i("MicroMsg.WalletMixOrderInfoUI", " go to WalletMixOrderInfoProxyUI");
        paramn = new Intent(this, WalletMixOrderInfoProxyUI.class);
        paramn.putExtra("key_orders", paramString);
        paramn.putExtra("prepayId", this.prepayId);
        paramString = new com.tencent.mm.hellhoundlib.b.a().bc(paramn);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramString.ahp(), "com/tencent/mm/plugin/wallet_core/ui/WalletMixOrderInfoUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramString.mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletMixOrderInfoUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        setResult(-1);
        finish();
      }
      for (;;)
      {
        AppMethodBeat.o(70982);
        return true;
        if (this.Dgt == 0) {}
        for (paramInt1 = 0;; paramInt1 = 1)
        {
          if (paramInt1 == 0) {
            break label305;
          }
          ad.d("MicroMsg.WalletMixOrderInfoUI", "retryGetPaidOrderDetailAgain again");
          ad.d("MicroMsg.WalletMixOrderInfoUI", "retryGetPaidOrderDetailAgain：m_currentRetryCount: %d", new Object[] { Integer.valueOf(this.Dgt) });
          this.Dgt -= 1;
          doSceneForceProgress(new com.tencent.mm.plugin.wallet_core.c.c.a(this.appId, this.timeStamp, this.nonceStr, this.packageExt, this.prepayId, this.dMF, this.signType, this.dMw), this.Dgs.FOQ);
          break;
        }
        label305:
        this.Dgr = false;
        paramn = paramString;
        if (paramString.isEmpty()) {
          paramn = this.Dgs.FOS;
        }
        bu(this, paramn);
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