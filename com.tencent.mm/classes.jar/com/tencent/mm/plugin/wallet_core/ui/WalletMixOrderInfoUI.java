package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.g.a.xp;
import com.tencent.mm.g.a.xv;
import com.tencent.mm.g.a.yp;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.ql;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;

@com.tencent.mm.ui.base.a(3)
public class WalletMixOrderInfoUI
  extends WalletBaseUI
{
  private boolean BFY;
  private boolean BFZ;
  private ql BGa;
  private int BGb;
  private c BGc;
  private String appId;
  private String dAj;
  private int dAs;
  private String dac;
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
    this.dac = null;
    this.signType = null;
    this.dAj = null;
    this.BGc = new c() {};
    AppMethodBeat.o(70979);
  }
  
  private void azK(String paramString)
  {
    AppMethodBeat.i(70984);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(70984);
      return;
    }
    ac.d("MicroMsg.WalletMixOrderInfoUI", "H5 wallet url: %s", new Object[] { paramString });
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString);
    localIntent.putExtra("showShare", false);
    localIntent.putExtra("show_bottom", false);
    localIntent.putExtra("needRedirect", false);
    localIntent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.DIw);
    localIntent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.DIs);
    e.b(getContext(), localIntent, 1);
    AppMethodBeat.o(70984);
  }
  
  private void br(Context paramContext, String paramString)
  {
    AppMethodBeat.i(70985);
    ac.i("MicroMsg.WalletMixOrderInfoUI", "showErrorAlert");
    if (!this.BFY)
    {
      yp localyp = new yp();
      localyp.dCg.result = 0;
      com.tencent.mm.sdk.b.a.GpY.l(localyp);
    }
    paramContext = h.a(paramContext, paramString, "", false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(70978);
        paramAnonymousDialogInterface.dismiss();
        if (WalletMixOrderInfoUI.k(WalletMixOrderInfoUI.this))
        {
          paramAnonymousDialogInterface = new yp();
          paramAnonymousDialogInterface.dCg.result = this.BGf;
          com.tencent.mm.sdk.b.a.GpY.l(paramAnonymousDialogInterface);
        }
        paramAnonymousDialogInterface = new xv();
        paramAnonymousDialogInterface.dBk.dac = WalletMixOrderInfoUI.a(WalletMixOrderInfoUI.this);
        paramAnonymousDialogInterface.dBk.result = this.BGf;
        com.tencent.mm.sdk.b.a.GpY.l(paramAnonymousDialogInterface);
        WalletMixOrderInfoUI.this.setResult(this.BGf);
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
    ac.i("MicroMsg.WalletMixOrderInfoUI", "finish");
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
      ac.d("MicroMsg.WalletMixOrderInfoUI", "requestCode: %d, resultCode: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (this.BFZ)
      {
        com.tencent.mm.sdk.b.a.GpY.d(this.BGc);
        paramIntent = new xv();
        paramIntent.dBk.dac = this.prepayId;
        paramIntent.dBk.result = 0;
        com.tencent.mm.sdk.b.a.GpY.l(paramIntent);
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
    this.BGa = new ql();
    this.BGa.EhK = paramBundle.getIntExtra("max_count", 3);
    this.BGa.EhJ = paramBundle.getIntExtra("inteval_time", 4);
    this.BGa.EhL = paramBundle.getStringExtra("default_wording");
    if (bs.isNullOrNil(this.BGa.EhL)) {
      this.BGa.EhL = getString(2131765224);
    }
    this.BGb = this.BGa.EhK;
    this.BFY = paramBundle.getBooleanExtra("is_jsapi_offline_pay", false);
    this.BFZ = true;
    if (!this.BFY)
    {
      final String str1 = paramBundle.getStringExtra("pay_gate_url");
      boolean bool = paramBundle.getBooleanExtra("need_dialog", false);
      String str2 = paramBundle.getStringExtra("dialog_text");
      this.prepayId = paramBundle.getStringExtra("prepayId");
      ac.i("MicroMsg.WalletMixOrderInfoUI", " prepayId:%s ，need_dialog:%s", new Object[] { this.prepayId, Boolean.valueOf(bool) });
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
            paramAnonymousDialogInterface = new xv();
            paramAnonymousDialogInterface.dBk.dac = WalletMixOrderInfoUI.a(WalletMixOrderInfoUI.this);
            paramAnonymousDialogInterface.dBk.result = 0;
            com.tencent.mm.sdk.b.a.GpY.l(paramAnonymousDialogInterface);
            WalletMixOrderInfoUI.this.finish();
            AppMethodBeat.o(70976);
          }
        }).setCancelable(false);
      }
      for (;;)
      {
        com.tencent.mm.sdk.b.a.GpY.c(this.BGc);
        AppMethodBeat.o(70980);
        return;
        azK(str1);
      }
    }
    this.appId = getIntent().getStringExtra("appId");
    this.timeStamp = getIntent().getStringExtra("timeStamp");
    this.nonceStr = getIntent().getStringExtra("nonceStr");
    this.packageExt = getIntent().getStringExtra("packageExt");
    this.dac = getIntent().getStringExtra("reqKey");
    this.dAs = getIntent().getIntExtra("payScene", -1);
    this.signType = getIntent().getStringExtra("signtype");
    this.dAj = getIntent().getStringExtra("paySignature");
    if ((this.dAs == 2) && (bs.isNullOrNil(this.prepayId)))
    {
      doSceneForceProgress(new com.tencent.mm.plugin.wallet_core.c.c.a(this.appId, this.timeStamp, this.nonceStr, this.packageExt, this.dac, this.dAs, this.signType, this.dAj));
      AppMethodBeat.o(70980);
      return;
    }
    br(this, getString(2131765589));
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
        this.BFZ = false;
        paramString = new yp();
        paramString.dCg.result = -1;
        com.tencent.mm.sdk.b.a.GpY.l(paramString);
        paramString = ((com.tencent.mm.plugin.wallet_core.c.c.a)paramn).Bpz;
        ac.i("MicroMsg.WalletMixOrderInfoUI", " go to WalletMixOrderInfoProxyUI");
        paramn = new Intent(this, WalletMixOrderInfoProxyUI.class);
        paramn.putExtra("key_orders", paramString);
        paramn.putExtra("prepayId", this.prepayId);
        paramString = new com.tencent.mm.hellhoundlib.b.a().ba(paramn);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramString.aeD(), "com/tencent/mm/plugin/wallet_core/ui/WalletMixOrderInfoUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramString.lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletMixOrderInfoUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        setResult(-1);
        finish();
      }
      for (;;)
      {
        AppMethodBeat.o(70982);
        return true;
        if (this.BGb == 0) {}
        for (paramInt1 = 0;; paramInt1 = 1)
        {
          if (paramInt1 == 0) {
            break label305;
          }
          ac.d("MicroMsg.WalletMixOrderInfoUI", "retryGetPaidOrderDetailAgain again");
          ac.d("MicroMsg.WalletMixOrderInfoUI", "retryGetPaidOrderDetailAgain：m_currentRetryCount: %d", new Object[] { Integer.valueOf(this.BGb) });
          this.BGb -= 1;
          doSceneForceProgress(new com.tencent.mm.plugin.wallet_core.c.c.a(this.appId, this.timeStamp, this.nonceStr, this.packageExt, this.prepayId, this.dAs, this.signType, this.dAj), this.BGa.EhJ);
          break;
        }
        label305:
        this.BFZ = false;
        paramn = paramString;
        if (paramString.isEmpty()) {
          paramn = this.BGa.EhL;
        }
        br(this, paramn);
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