package com.tencent.mm.plugin.wallet_index.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.ye;
import com.tencent.mm.g.a.yq;
import com.tencent.mm.plugin.wallet_index.c.m;
import com.tencent.mm.protocal.protobuf.bpk;
import com.tencent.mm.protocal.protobuf.bpl;
import com.tencent.mm.protocal.protobuf.cmc;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.al;
import com.tencent.mm.wallet_core.c.ab;
import com.tencent.mm.wallet_core.c.v;
import java.util.ArrayList;
import java.util.List;

@com.tencent.mm.ui.base.a(7)
public class WalletIapUI
  extends MMActivity
  implements com.tencent.mm.al.f
{
  private final int DEFAULT;
  private com.tencent.mm.sdk.b.c DqU;
  private c Dqk;
  private d Dqm;
  private final int Drd;
  private final int Dre;
  private final int Drf;
  private final int Drg;
  private final int Drh;
  private final int Dri;
  private boolean Drj;
  private int Drk;
  private boolean Drl;
  private String Drm;
  private b Drn;
  private d Dro;
  private final int OK;
  private int currentState;
  private Dialog mKz;
  private int mRequestCode;
  private com.tencent.mm.sdk.b.c wNB;
  private final int xui;
  
  public WalletIapUI()
  {
    AppMethodBeat.i(71919);
    this.Drd = 4;
    this.Dre = 0;
    this.Drf = 1;
    this.Drg = 2;
    this.Drh = 3;
    this.OK = 1000;
    this.Dri = 1001;
    this.xui = 1002;
    this.DEFAULT = 1003;
    this.Drj = false;
    this.Drk = 0;
    this.currentState = 1003;
    this.Drm = "0";
    this.mRequestCode = 0;
    this.DqU = new com.tencent.mm.sdk.b.c() {};
    this.Dro = new d()
    {
      public final void a(com.tencent.mm.plugin.wallet_index.c.b paramAnonymousb, com.tencent.mm.plugin.wallet_index.b.a.c paramAnonymousc)
      {
        AppMethodBeat.i(71915);
        ad.i("MicroMsg.WalletIapUI", "Pay Purchase finished: " + paramAnonymousb + ", purchase: " + paramAnonymousc);
        if ((WalletIapUI.b(WalletIapUI.this) instanceof a))
        {
          ad.i("MicroMsg.WalletIapUI", "Pay Purchase finished mWallet is  GoogleWallet");
          if (paramAnonymousc != null) {
            ab.e(paramAnonymousc.DpJ, paramAnonymousc.pFG, paramAnonymousc.DpP, paramAnonymousb.uDC, paramAnonymousb.uDD);
          }
        }
        else
        {
          if (!paramAnonymousb.eIZ()) {
            break label268;
          }
          ad.i("MicroMsg.WalletIapUI", "back to preview UI, reason: purchase finish , errCode: " + paramAnonymousb.uDC + " , errMsg: " + paramAnonymousb.uDD);
          if (paramAnonymousb.uDC != 1) {
            break label254;
          }
          WalletIapUI.a(WalletIapUI.this, 1001);
        }
        for (;;)
        {
          paramAnonymousc = new Intent();
          paramAnonymousc.putExtra("key_err_code", paramAnonymousb.uDC);
          paramAnonymousc.putExtra("key_err_msg", paramAnonymousb.uDD);
          paramAnonymousc.putExtra("key_launch_ts", a.Dql);
          paramAnonymousc.putExtra("key_gw_error_code", paramAnonymousb.DpQ);
          WalletIapUI.this.setResult(-1, paramAnonymousc);
          WalletIapUI.this.finish();
          AppMethodBeat.o(71915);
          return;
          a locala = (a)WalletIapUI.b(WalletIapUI.this);
          ab.e(locala.Dqp, locala.pFG, locala.DpP, paramAnonymousb.uDC, paramAnonymousb.uDD);
          break;
          label254:
          WalletIapUI.a(WalletIapUI.this, 1002);
        }
        label268:
        if (!paramAnonymousb.eIY())
        {
          if (paramAnonymousc != null)
          {
            ad.i("MicroMsg.WalletIapUI", "verify purchase! productId:" + paramAnonymousc.pFG + ",billNo:" + paramAnonymousc.DpM);
            com.tencent.mm.kernel.g.ajD();
            com.tencent.mm.kernel.g.ajB().gAO.a(WalletIapUI.c(WalletIapUI.this).a(paramAnonymousc, false), 0);
            WalletIapUI.b(WalletIapUI.this, 2);
            WalletIapUI.d(WalletIapUI.this);
            AppMethodBeat.o(71915);
            return;
          }
          WalletIapUI.a(WalletIapUI.this, 1002);
          paramAnonymousb = new Intent();
          paramAnonymousc = com.tencent.mm.plugin.wallet_index.c.b.cr(6, "");
          paramAnonymousb.putExtra("key_err_code", paramAnonymousc.uDC);
          paramAnonymousb.putExtra("key_err_msg", paramAnonymousc.uDD);
          paramAnonymousb.putExtra("key_launch_ts", a.Dql);
          paramAnonymousb.putExtra("key_gw_error_code", paramAnonymousc.DpQ);
          WalletIapUI.this.setResult(-1, paramAnonymousb);
          WalletIapUI.this.finish();
          AppMethodBeat.o(71915);
          return;
        }
        WalletIapUI.b(WalletIapUI.this, 3);
        ad.i("MicroMsg.WalletIapUI", "start to restore the purchase!");
        WalletIapUI.b(WalletIapUI.this).d(WalletIapUI.this, false);
        AppMethodBeat.o(71915);
      }
    };
    this.Dqm = new d()
    {
      public final void a(com.tencent.mm.plugin.wallet_index.c.b paramAnonymousb, com.tencent.mm.plugin.wallet_index.b.a.c paramAnonymousc)
      {
        AppMethodBeat.i(71916);
        ad.i("MicroMsg.WalletIapUI", "Consume finished: " + paramAnonymousb + ", purchase: " + paramAnonymousc);
        if (paramAnonymousb.eIZ())
        {
          WalletIapUI.a(WalletIapUI.this, 1002);
          ad.i("MicroMsg.WalletIapUI", "back to preview UI, reason: consume Fail ! ");
        }
        for (;;)
        {
          paramAnonymousc = new Intent();
          paramAnonymousc.putExtra("key_err_code", paramAnonymousb.uDC);
          paramAnonymousc.putExtra("key_err_msg", paramAnonymousb.uDD);
          paramAnonymousc.putStringArrayListExtra("key_response_product_ids", WalletIapUI.c(WalletIapUI.this).Dqs);
          paramAnonymousc.putStringArrayListExtra("key_response_series_ids", WalletIapUI.c(WalletIapUI.this).Dqt);
          paramAnonymousc.putExtra("key_launch_ts", a.Dql);
          WalletIapUI.this.setResult(-1, paramAnonymousc);
          WalletIapUI.this.finish();
          AppMethodBeat.o(71916);
          return;
          WalletIapUI.a(WalletIapUI.this, 1000);
          ad.i("MicroMsg.WalletIapUI", "back to preview UI, reason: consume Success ! ");
        }
      }
    };
    this.wNB = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(71919);
  }
  
  private void aRX()
  {
    AppMethodBeat.i(71927);
    ad.i("MicroMsg.WalletIapUI", "showLoadingDialog!");
    this.mKz = com.tencent.mm.wallet_core.ui.g.b(this, getString(2131755936), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(71918);
        ad.i("MicroMsg.WalletIapUI", "showLoadingDialog onCancel currentScene: %d", new Object[] { Integer.valueOf(WalletIapUI.f(WalletIapUI.this)) });
        if (WalletIapUI.f(WalletIapUI.this) == 2) {}
        for (paramAnonymousDialogInterface = com.tencent.mm.plugin.wallet_index.c.b.cr(7, "");; paramAnonymousDialogInterface = com.tencent.mm.plugin.wallet_index.c.b.cr(1, ""))
        {
          Intent localIntent = new Intent();
          localIntent.putExtra("key_err_code", paramAnonymousDialogInterface.uDC);
          localIntent.putExtra("key_err_msg", paramAnonymousDialogInterface.uDD);
          WalletIapUI.this.setResult(-1, localIntent);
          WalletIapUI.this.finish();
          AppMethodBeat.o(71918);
          return;
        }
      }
    });
    AppMethodBeat.o(71927);
  }
  
  private void aRY()
  {
    AppMethodBeat.i(71928);
    ad.i("MicroMsg.WalletIapUI", "hideLoadingDialog!");
    if ((this.mKz != null) && (this.mKz.isShowing()))
    {
      this.mKz.dismiss();
      this.mKz = null;
    }
    AppMethodBeat.o(71928);
  }
  
  public void finish()
  {
    AppMethodBeat.i(71926);
    ad.i("MicroMsg.WalletIapUI", "finish");
    aRY();
    super.finish();
    AppMethodBeat.o(71926);
  }
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(71924);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ad.i("MicroMsg.WalletIapUI", "onActivityResult resultCode : ".concat(String.valueOf(paramInt2)));
    if ((paramIntent != null) && (paramIntent.getExtras() != null) && (paramIntent.getExtras().get("key_total_fee") != null))
    {
      this.Drm = paramIntent.getExtras().get("key_total_fee").toString();
      ad.i("MicroMsg.WalletIapUI", "has payAmount:%s", new Object[] { this.Drm });
    }
    while (this.Drn != null)
    {
      this.Drn.a(this, paramInt1, paramInt2, paramIntent);
      ad.d("MicroMsg.WalletIapUI", "onActivityResult handled by mWalletPay.");
      AppMethodBeat.o(71924);
      return;
      ad.i("MicroMsg.WalletIapUI", "no payAmount");
    }
    ad.e("MicroMsg.WalletIapUI", "havn't handle user action");
    paramIntent = new Intent();
    com.tencent.mm.plugin.wallet_index.c.b localb = com.tencent.mm.plugin.wallet_index.c.b.cr(6, "");
    paramIntent.putExtra("key_err_code", localb.uDC);
    paramIntent.putExtra("key_err_msg", localb.uDD);
    paramIntent.putExtra("key_launch_ts", a.Dql);
    setResult(-1, paramIntent);
    finish();
    AppMethodBeat.o(71924);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(71920);
    super.onCreate(paramBundle);
    ad.i("MicroMsg.WalletIapUI", "onCreate");
    al.jU(this);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.a(422, this);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.a(414, this);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.a(1130, this);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.a(1306, this);
    if (getIntent().getIntExtra("key_action_type", 200001) == 200001) {
      aRX();
    }
    this.Drl = getIntent().getBooleanExtra("key_is_mini_program", false);
    if (getIntent().getBooleanExtra("key_request_fullscreen", false)) {
      getWindow().addFlags(1024);
    }
    this.Dqk = new c();
    this.Dqk.Dqx = this.Drl;
    if ((getIntent().getBooleanExtra("key_force_google", false)) || (com.tencent.mm.model.u.aAA())) {
      ad.d("MicroMsg.WalletIapUI", "Pay use Google Wallet!");
    }
    for (this.Drn = new a(this, this.Dqk, this.Dqm);; this.Drn = new f(this.Dqk, this.wNB))
    {
      this.Dqk.wEH = this.Drn.eJa();
      com.tencent.mm.sdk.b.a.IbL.c(this.DqU);
      AppMethodBeat.o(71920);
      return;
      ad.d("MicroMsg.WalletIapUI", "Pay use WeiXin Wallet!");
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(71923);
    ad.i("MicroMsg.WalletIapUI", "onDestroy");
    aRY();
    if (this.currentState == 1003) {
      this.currentState = 1001;
    }
    String str = "";
    if (getIntent() != null) {
      str = getIntent().getStringExtra("key_appid");
    }
    int i;
    int j;
    if ((this.Drn instanceof f))
    {
      i = 0;
      long l = (bt.getDouble(this.Drm, 0.0D) * 100.0D);
      ad.i("MicroMsg.WalletIapUI", "reportPaymentState report(%s), isMiniProgram : %b, appid %s, walletType %s, currentScene %s, currentState %s, payAmount %s, payamount %s", new Object[] { Integer.valueOf(15751), Boolean.valueOf(this.Drl), str, Integer.valueOf(i), Integer.valueOf(this.Drk), Integer.valueOf(this.currentState), this.Drm, Long.valueOf(l) });
      com.tencent.mm.plugin.report.service.g localg = com.tencent.mm.plugin.report.service.g.yhR;
      if (!this.Drl) {
        break label405;
      }
      j = 0;
      label178:
      localg.f(15751, new Object[] { Integer.valueOf(j), str, Integer.valueOf(i), Integer.valueOf(this.Drk), Integer.valueOf(this.currentState), this.Drm, Long.valueOf(l) });
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(1044L, this.currentState - 1000, 1L, false);
      if (this.currentState != 1001) {
        break label410;
      }
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(1044L, this.Drk + 4, 1L, false);
    }
    for (;;)
    {
      if (this.Drn != null) {
        this.Drn.p(this);
      }
      com.tencent.mm.kernel.g.ajD();
      com.tencent.mm.kernel.g.ajB().gAO.b(422, this);
      com.tencent.mm.kernel.g.ajD();
      com.tencent.mm.kernel.g.ajB().gAO.b(414, this);
      com.tencent.mm.kernel.g.ajD();
      com.tencent.mm.kernel.g.ajB().gAO.b(1130, this);
      com.tencent.mm.kernel.g.ajD();
      com.tencent.mm.kernel.g.ajB().gAO.b(1306, this);
      com.tencent.mm.sdk.b.a.IbL.d(this.DqU);
      super.onDestroy();
      AppMethodBeat.o(71923);
      return;
      i = 1;
      break;
      label405:
      j = 1;
      break label178;
      label410:
      if (this.currentState == 1002) {
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(1044L, this.Drk + 8, 1L, false);
      }
    }
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(71922);
    ad.i("MicroMsg.WalletIapUI", "onNewIntent");
    super.onNewIntent(paramIntent);
    AppMethodBeat.o(71922);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(71921);
    ad.i("MicroMsg.WalletIapUI", "onResume");
    super.onResume();
    ad.i("MicroMsg.WalletIapUI", "Handler jump");
    if (!this.Drj)
    {
      this.Drj = true;
      Object localObject1 = getIntent();
      if (((Intent)localObject1).getIntExtra("key_action_type", 200001) == 200002)
      {
        ad.i("MicroMsg.WalletIapUI", "start to restore the purchase!");
        this.Drk = 3;
        this.Drn.d(this, true);
        AppMethodBeat.o(71921);
        return;
      }
      ad.i("MicroMsg.WalletIapUI", "start to doScene!");
      Object localObject2 = this.Dqk;
      String str1 = ((Intent)localObject1).getStringExtra("key_product_id");
      ((c)localObject2).pFG = str1;
      ((c)localObject2).Dqw.add(str1);
      ad.d("MicroMsg.IapData", "prepare pay product: ".concat(String.valueOf(str1)));
      this.Dqk.DpP = ((Intent)localObject1).getStringExtra("key_price");
      this.Dqk.DpO = ((Intent)localObject1).getStringExtra("key_currency_type");
      localObject2 = ((Intent)localObject1).getStringExtra("key_ext_info");
      this.Dqk.mCount = ((Intent)localObject1).getIntExtra("key_count", 1);
      str1 = ((Intent)localObject1).getStringExtra("key_appid");
      String str2 = ((Intent)localObject1).getStringExtra("key_desc");
      String str3 = ((Intent)localObject1).getStringExtra("key_busiid");
      this.Dqk.Dqy = ((Intent)localObject1).getStringExtra("key_virtual_pay_sign");
      this.Dqk.Dqz = ((Intent)localObject1).getStringExtra("key_attach");
      localObject1 = this.Dqk.f(this.Drn.eJa(), (String)localObject2, str1, str2, str3);
      if (localObject1 != null)
      {
        com.tencent.mm.kernel.g.ajD();
        com.tencent.mm.kernel.g.ajB().gAO.a((n)localObject1, 0);
        AppMethodBeat.o(71921);
        return;
      }
      ad.e("MicroMsg.WalletIapUI", "getPrepareNetScene error netScene is null");
      this.currentState = 1002;
      localObject1 = com.tencent.mm.plugin.wallet_index.c.b.cr(8, "");
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("key_err_code", ((com.tencent.mm.plugin.wallet_index.c.b)localObject1).uDC);
      ((Intent)localObject2).putExtra("key_err_msg", ((com.tencent.mm.plugin.wallet_index.c.b)localObject1).uDD);
      setResult(-1, (Intent)localObject2);
      finish();
    }
    AppMethodBeat.o(71921);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    boolean bool = true;
    AppMethodBeat.i(71925);
    ad.i("MicroMsg.WalletIapUI", "onSceneEnd type:" + paramn.getType() + " errCode:" + paramInt2 + ",errMsg:" + paramString);
    paramString = com.tencent.mm.plugin.wallet_index.c.b.cr(paramInt2, paramString);
    paramInt2 = paramString.uDC;
    paramString = paramString.uDD;
    paramInt1 = paramn.getType();
    switch (paramInt1)
    {
    default: 
      ad.w("MicroMsg.WalletIapUI", "get a wrong sceneType : ".concat(String.valueOf(paramInt1)));
      AppMethodBeat.o(71925);
      return;
    case 422: 
    case 1130: 
      localc = this.Dqk;
      com.tencent.mm.plugin.wallet_index.c.b localb = com.tencent.mm.plugin.wallet_index.c.b.cr(paramInt2, paramString);
      paramInt1 = localb.uDC;
      if ((paramn instanceof com.tencent.mm.wallet_core.c.u))
      {
        paramn = (com.tencent.mm.wallet_core.c.u)paramn;
        if (paramInt1 == 0)
        {
          if (!localc.eJb()) {
            break label342;
          }
          paramn = (cmc)paramn.rr.hNL.hNQ;
          if (paramn == null) {
            break label328;
          }
          paramString = new bpl();
          paramString.GKh = paramn.Hfu;
          paramString.GKi = paramn.Hfv;
          paramString.dCC = 5;
          paramString.GKj = paramn.Hfw;
          ad.d("MicroMsg.NetScenePreparePurchase", "get Sign4TenPay is " + paramn.Hfw);
          localc.DpW = paramString;
        }
      }
      for (;;)
      {
        if (localb.uDC != 0) {
          break label580;
        }
        ad.i("MicroMsg.WalletIapUI", "Wallet.launchPay");
        this.mRequestCode = this.Drn.a(this, this.Dro);
        this.Drk = 1;
        AppMethodBeat.o(71925);
        return;
        label328:
        ad.e("MicroMsg.NetScenePreparePurchase", "getIapWxPayData fail.");
        paramString = null;
        break;
        label342:
        cmc localcmc = (cmc)paramn.rr.hNL.hNQ;
        if (localcmc != null)
        {
          paramString = new bpk();
          paramString.GuI = paramn.DpO;
          paramString.wMh = paramn.pFG;
          paramString.wDS = paramn.DpP;
          paramString.GKd = localcmc.Hft;
          ad.d("MicroMsg.NetScenePreparePurchase", "getIapGoogleData is " + localcmc.Hft);
        }
        for (;;)
        {
          localc.DpV = paramString;
          break;
          ad.e("MicroMsg.NetScenePreparePurchase", "getIapGoogleData fail.");
          paramString = null;
        }
        if ((paramn instanceof com.tencent.mm.plugin.wallet_index.c.f))
        {
          paramString = (com.tencent.mm.plugin.wallet_index.c.f)paramn;
          if ((paramInt1 == 0) && (paramString.errCode == 0))
          {
            localc.DpW = paramString.DpW;
            localc.DpV = paramString.DpV;
            if (localc.eJb())
            {
              if (localc.DpW != null) {
                localc.Dqp = localc.DpW.GKd;
              } else {
                ad.e("MicroMsg.IapData", "iapWxPayData is null");
              }
            }
            else if (localc.DpV != null) {
              localc.Dqp = localc.DpV.GKd;
            } else {
              ad.e("MicroMsg.IapData", "iapGoogleData is null");
            }
          }
        }
      }
      label580:
      this.currentState = 1002;
      ad.i("MicroMsg.WalletIapUI", "back to preview UI, reason: PreparePurchase fail , errCode: " + localb.uDC + " , errMsg: " + localb.uDD);
      paramString = new Intent();
      paramString.putExtra("key_err_code", localb.uDC);
      paramString.putExtra("key_err_msg", localb.uDD);
      paramString.putExtra("key_response_position", 1);
      setResult(-1, paramString);
      finish();
      AppMethodBeat.o(71925);
      return;
    }
    c localc = this.Dqk;
    if ((paramn instanceof v))
    {
      paramn = (v)paramn;
      localc.pFG = paramn.pFG;
      localc.Dqu = paramn.pFI;
      localc.Dqv = paramn.Dqv;
      if (paramn.errCode == 0) {
        paramInt1 = 1;
      }
    }
    for (;;)
    {
      localc.Dqw.remove(localc.pFG);
      if (paramInt1 != 0)
      {
        ad.i("MicroMsg.IapData", "Verify " + localc.pFG + " OK");
        localc.Dqs.add(localc.pFG);
        localc.Dqt.add(localc.Dqu);
      }
      for (;;)
      {
        bool = false;
        for (;;)
        {
          if (!this.Dqk.Dqw.isEmpty()) {
            break label1238;
          }
          ad.d("MicroMsg.WalletIapUI", "Verify All End... ");
          if (this.Dqk.Dqs.isEmpty()) {
            break label1139;
          }
          ad.i("MicroMsg.WalletIapUI", "mResultProductIds size: " + this.Dqk.Dqs.size() + ", Consume ...");
          this.Drn.a(this, this.Dqk.Dqs, this.Dqm, bool);
          AppMethodBeat.o(71925);
          return;
          paramInt1 = 0;
          break;
          if (!(paramn instanceof m)) {
            break label1245;
          }
          paramn = (m)paramn;
          localc.pFG = paramn.dok;
          if (paramn.errCode == 0)
          {
            paramInt1 = 1;
            break;
          }
          paramInt1 = 0;
          break;
          if (!localc.pFG.startsWith("com.tencent.xin.wco")) {
            break label1103;
          }
          if (localc.Dqv <= 0) {
            break label1067;
          }
          localc.Dqs.add(localc.pFG);
          localc.Dqt.add(localc.Dqu);
          ad.i("MicroMsg.IapData", "Verify " + localc.pFG + " fail and cosume");
        }
        label1067:
        ad.i("MicroMsg.IapData", "Verify " + localc.pFG + " fail");
        continue;
        label1103:
        ad.i("MicroMsg.IapData", "Verify " + localc.pFG + " fail");
      }
      label1139:
      ad.i("MicroMsg.WalletIapUI", "back to preview UI, reason: VerifyPurchase fail , errCode: " + paramInt2 + " , errMsg: " + paramString);
      this.currentState = 1002;
      paramn = new Intent();
      paramn.putExtra("key_err_code", paramInt2);
      paramn.putExtra("key_err_msg", paramString);
      paramn.putExtra("key_response_position", 3);
      paramn.putExtra("key_launch_ts", a.Dql);
      setResult(-1, paramn);
      finish();
      label1238:
      AppMethodBeat.o(71925);
      return;
      label1245:
      paramInt1 = 0;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.ui.WalletIapUI
 * JD-Core Version:    0.7.0.1
 */