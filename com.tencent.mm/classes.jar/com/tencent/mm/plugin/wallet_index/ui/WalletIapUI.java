package com.tencent.mm.plugin.wallet_index.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.xk;
import com.tencent.mm.g.a.xw;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_index.c.m;
import com.tencent.mm.protocal.protobuf.bla;
import com.tencent.mm.protocal.protobuf.blb;
import com.tencent.mm.protocal.protobuf.chd;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aj;
import com.tencent.mm.wallet_core.c.ab;
import com.tencent.mm.wallet_core.c.v;
import java.util.ArrayList;
import java.util.List;

@com.tencent.mm.ui.base.a(7)
public class WalletIapUI
  extends MMActivity
  implements com.tencent.mm.ak.g
{
  private c BPS;
  private d BPU;
  private com.tencent.mm.sdk.b.c BQB;
  private final int BQK;
  private final int BQL;
  private final int BQM;
  private final int BQN;
  private final int BQO;
  private final int BQP;
  private boolean BQQ;
  private int BQR;
  private boolean BQS;
  private String BQT;
  private b BQU;
  private d BQV;
  private final int DEFAULT;
  private final int OK;
  private int currentState;
  private int mRequestCode;
  private Dialog mjY;
  private com.tencent.mm.sdk.b.c vGu;
  private final int wms;
  
  public WalletIapUI()
  {
    AppMethodBeat.i(71919);
    this.BQK = 4;
    this.BQL = 0;
    this.BQM = 1;
    this.BQN = 2;
    this.BQO = 3;
    this.OK = 1000;
    this.BQP = 1001;
    this.wms = 1002;
    this.DEFAULT = 1003;
    this.BQQ = false;
    this.BQR = 0;
    this.currentState = 1003;
    this.BQT = "0";
    this.mRequestCode = 0;
    this.BQB = new com.tencent.mm.sdk.b.c() {};
    this.BQV = new d()
    {
      public final void a(com.tencent.mm.plugin.wallet_index.c.b paramAnonymousb, com.tencent.mm.plugin.wallet_index.b.a.c paramAnonymousc)
      {
        AppMethodBeat.i(71915);
        ac.i("MicroMsg.WalletIapUI", "Pay Purchase finished: " + paramAnonymousb + ", purchase: " + paramAnonymousc);
        if ((WalletIapUI.b(WalletIapUI.this) instanceof a))
        {
          ac.i("MicroMsg.WalletIapUI", "Pay Purchase finished mWallet is  GoogleWallet");
          if (paramAnonymousc != null) {
            ab.e(paramAnonymousc.BPr, paramAnonymousc.pbW, paramAnonymousc.BPx, paramAnonymousb.tAT, paramAnonymousb.tAU);
          }
        }
        else
        {
          if (!paramAnonymousb.euT()) {
            break label268;
          }
          ac.i("MicroMsg.WalletIapUI", "back to preview UI, reason: purchase finish , errCode: " + paramAnonymousb.tAT + " , errMsg: " + paramAnonymousb.tAU);
          if (paramAnonymousb.tAT != 1) {
            break label254;
          }
          WalletIapUI.a(WalletIapUI.this, 1001);
        }
        for (;;)
        {
          paramAnonymousc = new Intent();
          paramAnonymousc.putExtra("key_err_code", paramAnonymousb.tAT);
          paramAnonymousc.putExtra("key_err_msg", paramAnonymousb.tAU);
          paramAnonymousc.putExtra("key_launch_ts", a.BPT);
          paramAnonymousc.putExtra("key_gw_error_code", paramAnonymousb.BPy);
          WalletIapUI.this.setResult(-1, paramAnonymousc);
          WalletIapUI.this.finish();
          AppMethodBeat.o(71915);
          return;
          a locala = (a)WalletIapUI.b(WalletIapUI.this);
          ab.e(locala.BPX, locala.pbW, locala.BPx, paramAnonymousb.tAT, paramAnonymousb.tAU);
          break;
          label254:
          WalletIapUI.a(WalletIapUI.this, 1002);
        }
        label268:
        if (!paramAnonymousb.euS())
        {
          if (paramAnonymousc != null)
          {
            ac.i("MicroMsg.WalletIapUI", "verify purchase! productId:" + paramAnonymousc.pbW + ",billNo:" + paramAnonymousc.BPu);
            com.tencent.mm.kernel.g.agS();
            com.tencent.mm.kernel.g.agQ().ghe.a(WalletIapUI.c(WalletIapUI.this).a(paramAnonymousc, false), 0);
            WalletIapUI.b(WalletIapUI.this, 2);
            WalletIapUI.d(WalletIapUI.this);
            AppMethodBeat.o(71915);
            return;
          }
          WalletIapUI.a(WalletIapUI.this, 1002);
          paramAnonymousb = new Intent();
          paramAnonymousc = com.tencent.mm.plugin.wallet_index.c.b.cj(6, "");
          paramAnonymousb.putExtra("key_err_code", paramAnonymousc.tAT);
          paramAnonymousb.putExtra("key_err_msg", paramAnonymousc.tAU);
          paramAnonymousb.putExtra("key_launch_ts", a.BPT);
          paramAnonymousb.putExtra("key_gw_error_code", paramAnonymousc.BPy);
          WalletIapUI.this.setResult(-1, paramAnonymousb);
          WalletIapUI.this.finish();
          AppMethodBeat.o(71915);
          return;
        }
        WalletIapUI.b(WalletIapUI.this, 3);
        ac.i("MicroMsg.WalletIapUI", "start to restore the purchase!");
        WalletIapUI.b(WalletIapUI.this).d(WalletIapUI.this, false);
        AppMethodBeat.o(71915);
      }
    };
    this.BPU = new d()
    {
      public final void a(com.tencent.mm.plugin.wallet_index.c.b paramAnonymousb, com.tencent.mm.plugin.wallet_index.b.a.c paramAnonymousc)
      {
        AppMethodBeat.i(71916);
        ac.i("MicroMsg.WalletIapUI", "Consume finished: " + paramAnonymousb + ", purchase: " + paramAnonymousc);
        if (paramAnonymousb.euT())
        {
          WalletIapUI.a(WalletIapUI.this, 1002);
          ac.i("MicroMsg.WalletIapUI", "back to preview UI, reason: consume Fail ! ");
        }
        for (;;)
        {
          paramAnonymousc = new Intent();
          paramAnonymousc.putExtra("key_err_code", paramAnonymousb.tAT);
          paramAnonymousc.putExtra("key_err_msg", paramAnonymousb.tAU);
          paramAnonymousc.putStringArrayListExtra("key_response_product_ids", WalletIapUI.c(WalletIapUI.this).BQa);
          paramAnonymousc.putStringArrayListExtra("key_response_series_ids", WalletIapUI.c(WalletIapUI.this).BQb);
          paramAnonymousc.putExtra("key_launch_ts", a.BPT);
          WalletIapUI.this.setResult(-1, paramAnonymousc);
          WalletIapUI.this.finish();
          AppMethodBeat.o(71916);
          return;
          WalletIapUI.a(WalletIapUI.this, 1000);
          ac.i("MicroMsg.WalletIapUI", "back to preview UI, reason: consume Success ! ");
        }
      }
    };
    this.vGu = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(71919);
  }
  
  private void aOL()
  {
    AppMethodBeat.i(71927);
    ac.i("MicroMsg.WalletIapUI", "showLoadingDialog!");
    this.mjY = com.tencent.mm.wallet_core.ui.g.b(this, getString(2131755936), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(71918);
        ac.i("MicroMsg.WalletIapUI", "showLoadingDialog onCancel currentScene: %d", new Object[] { Integer.valueOf(WalletIapUI.f(WalletIapUI.this)) });
        if (WalletIapUI.f(WalletIapUI.this) == 2) {}
        for (paramAnonymousDialogInterface = com.tencent.mm.plugin.wallet_index.c.b.cj(7, "");; paramAnonymousDialogInterface = com.tencent.mm.plugin.wallet_index.c.b.cj(1, ""))
        {
          Intent localIntent = new Intent();
          localIntent.putExtra("key_err_code", paramAnonymousDialogInterface.tAT);
          localIntent.putExtra("key_err_msg", paramAnonymousDialogInterface.tAU);
          WalletIapUI.this.setResult(-1, localIntent);
          WalletIapUI.this.finish();
          AppMethodBeat.o(71918);
          return;
        }
      }
    });
    AppMethodBeat.o(71927);
  }
  
  private void aOM()
  {
    AppMethodBeat.i(71928);
    ac.i("MicroMsg.WalletIapUI", "hideLoadingDialog!");
    if ((this.mjY != null) && (this.mjY.isShowing()))
    {
      this.mjY.dismiss();
      this.mjY = null;
    }
    AppMethodBeat.o(71928);
  }
  
  public void finish()
  {
    AppMethodBeat.i(71926);
    ac.i("MicroMsg.WalletIapUI", "finish");
    aOM();
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
    ac.i("MicroMsg.WalletIapUI", "onActivityResult resultCode : ".concat(String.valueOf(paramInt2)));
    if ((paramIntent != null) && (paramIntent.getExtras() != null) && (paramIntent.getExtras().get("key_total_fee") != null))
    {
      this.BQT = paramIntent.getExtras().get("key_total_fee").toString();
      ac.i("MicroMsg.WalletIapUI", "has payAmount:%s", new Object[] { this.BQT });
    }
    while (this.BQU != null)
    {
      this.BQU.a(this, paramInt1, paramInt2, paramIntent);
      ac.d("MicroMsg.WalletIapUI", "onActivityResult handled by mWalletPay.");
      AppMethodBeat.o(71924);
      return;
      ac.i("MicroMsg.WalletIapUI", "no payAmount");
    }
    ac.e("MicroMsg.WalletIapUI", "havn't handle user action");
    paramIntent = new Intent();
    com.tencent.mm.plugin.wallet_index.c.b localb = com.tencent.mm.plugin.wallet_index.c.b.cj(6, "");
    paramIntent.putExtra("key_err_code", localb.tAT);
    paramIntent.putExtra("key_err_msg", localb.tAU);
    paramIntent.putExtra("key_launch_ts", a.BPT);
    setResult(-1, paramIntent);
    finish();
    AppMethodBeat.o(71924);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(71920);
    super.onCreate(paramBundle);
    ac.i("MicroMsg.WalletIapUI", "onCreate");
    aj.jI(this);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.a(422, this);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.a(414, this);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.a(1130, this);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.a(1306, this);
    if (getIntent().getIntExtra("key_action_type", 200001) == 200001) {
      aOL();
    }
    this.BQS = getIntent().getBooleanExtra("key_is_mini_program", false);
    if (getIntent().getBooleanExtra("key_request_fullscreen", false)) {
      getWindow().addFlags(1024);
    }
    this.BPS = new c();
    this.BPS.BQf = this.BQS;
    if ((getIntent().getBooleanExtra("key_force_google", false)) || (com.tencent.mm.model.u.axK())) {
      ac.d("MicroMsg.WalletIapUI", "Pay use Google Wallet!");
    }
    for (this.BQU = new a(this, this.BPS, this.BPU);; this.BQU = new f(this.BPS, this.vGu))
    {
      this.BPS.vzn = this.BQU.euU();
      com.tencent.mm.sdk.b.a.GpY.c(this.BQB);
      AppMethodBeat.o(71920);
      return;
      ac.d("MicroMsg.WalletIapUI", "Pay use WeiXin Wallet!");
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(71923);
    ac.i("MicroMsg.WalletIapUI", "onDestroy");
    aOM();
    if (this.currentState == 1003) {
      this.currentState = 1001;
    }
    String str = "";
    if (getIntent() != null) {
      str = getIntent().getStringExtra("key_appid");
    }
    int i;
    int j;
    if ((this.BQU instanceof f))
    {
      i = 0;
      long l = (bs.getDouble(this.BQT, 0.0D) * 100.0D);
      ac.i("MicroMsg.WalletIapUI", "reportPaymentState report(%s), isMiniProgram : %b, appid %s, walletType %s, currentScene %s, currentState %s, payAmount %s, payamount %s", new Object[] { Integer.valueOf(15751), Boolean.valueOf(this.BQS), str, Integer.valueOf(i), Integer.valueOf(this.BQR), Integer.valueOf(this.currentState), this.BQT, Long.valueOf(l) });
      h localh = h.wUl;
      if (!this.BQS) {
        break label405;
      }
      j = 0;
      label178:
      localh.f(15751, new Object[] { Integer.valueOf(j), str, Integer.valueOf(i), Integer.valueOf(this.BQR), Integer.valueOf(this.currentState), this.BQT, Long.valueOf(l) });
      h.wUl.idkeyStat(1044L, this.currentState - 1000, 1L, false);
      if (this.currentState != 1001) {
        break label410;
      }
      h.wUl.idkeyStat(1044L, this.BQR + 4, 1L, false);
    }
    for (;;)
    {
      if (this.BQU != null) {
        this.BQU.n(this);
      }
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agQ().ghe.b(422, this);
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agQ().ghe.b(414, this);
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agQ().ghe.b(1130, this);
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agQ().ghe.b(1306, this);
      com.tencent.mm.sdk.b.a.GpY.d(this.BQB);
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
        h.wUl.idkeyStat(1044L, this.BQR + 8, 1L, false);
      }
    }
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(71922);
    ac.i("MicroMsg.WalletIapUI", "onNewIntent");
    super.onNewIntent(paramIntent);
    AppMethodBeat.o(71922);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(71921);
    ac.i("MicroMsg.WalletIapUI", "onResume");
    super.onResume();
    ac.i("MicroMsg.WalletIapUI", "Handler jump");
    if (!this.BQQ)
    {
      this.BQQ = true;
      Object localObject1 = getIntent();
      if (((Intent)localObject1).getIntExtra("key_action_type", 200001) == 200002)
      {
        ac.i("MicroMsg.WalletIapUI", "start to restore the purchase!");
        this.BQR = 3;
        this.BQU.d(this, true);
        AppMethodBeat.o(71921);
        return;
      }
      ac.i("MicroMsg.WalletIapUI", "start to doScene!");
      Object localObject2 = this.BPS;
      String str1 = ((Intent)localObject1).getStringExtra("key_product_id");
      ((c)localObject2).pbW = str1;
      ((c)localObject2).BQe.add(str1);
      ac.d("MicroMsg.IapData", "prepare pay product: ".concat(String.valueOf(str1)));
      this.BPS.BPx = ((Intent)localObject1).getStringExtra("key_price");
      this.BPS.BPw = ((Intent)localObject1).getStringExtra("key_currency_type");
      localObject2 = ((Intent)localObject1).getStringExtra("key_ext_info");
      this.BPS.mCount = ((Intent)localObject1).getIntExtra("key_count", 1);
      str1 = ((Intent)localObject1).getStringExtra("key_appid");
      String str2 = ((Intent)localObject1).getStringExtra("key_desc");
      String str3 = ((Intent)localObject1).getStringExtra("key_busiid");
      this.BPS.BQg = ((Intent)localObject1).getStringExtra("key_virtual_pay_sign");
      this.BPS.BQh = ((Intent)localObject1).getStringExtra("key_attach");
      localObject1 = this.BPS.f(this.BQU.euU(), (String)localObject2, str1, str2, str3);
      if (localObject1 != null)
      {
        com.tencent.mm.kernel.g.agS();
        com.tencent.mm.kernel.g.agQ().ghe.a((n)localObject1, 0);
        AppMethodBeat.o(71921);
        return;
      }
      ac.e("MicroMsg.WalletIapUI", "getPrepareNetScene error netScene is null");
      this.currentState = 1002;
      localObject1 = com.tencent.mm.plugin.wallet_index.c.b.cj(8, "");
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("key_err_code", ((com.tencent.mm.plugin.wallet_index.c.b)localObject1).tAT);
      ((Intent)localObject2).putExtra("key_err_msg", ((com.tencent.mm.plugin.wallet_index.c.b)localObject1).tAU);
      setResult(-1, (Intent)localObject2);
      finish();
    }
    AppMethodBeat.o(71921);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    boolean bool = true;
    AppMethodBeat.i(71925);
    ac.i("MicroMsg.WalletIapUI", "onSceneEnd type:" + paramn.getType() + " errCode:" + paramInt2 + ",errMsg:" + paramString);
    paramString = com.tencent.mm.plugin.wallet_index.c.b.cj(paramInt2, paramString);
    paramInt2 = paramString.tAT;
    paramString = paramString.tAU;
    paramInt1 = paramn.getType();
    switch (paramInt1)
    {
    default: 
      ac.w("MicroMsg.WalletIapUI", "get a wrong sceneType : ".concat(String.valueOf(paramInt1)));
      AppMethodBeat.o(71925);
      return;
    case 422: 
    case 1130: 
      localc = this.BPS;
      com.tencent.mm.plugin.wallet_index.c.b localb = com.tencent.mm.plugin.wallet_index.c.b.cj(paramInt2, paramString);
      paramInt1 = localb.tAT;
      if ((paramn instanceof com.tencent.mm.wallet_core.c.u))
      {
        paramn = (com.tencent.mm.wallet_core.c.u)paramn;
        if (paramInt1 == 0)
        {
          if (!localc.euV()) {
            break label342;
          }
          paramn = (chd)paramn.rr.hvs.hvw;
          if (paramn == null) {
            break label328;
          }
          paramString = new blb();
          paramString.FaI = paramn.Fvp;
          paramString.FaJ = paramn.Fvq;
          paramString.dqL = 5;
          paramString.FaK = paramn.Fvr;
          ac.d("MicroMsg.NetScenePreparePurchase", "get Sign4TenPay is " + paramn.Fvr);
          localc.BPE = paramString;
        }
      }
      for (;;)
      {
        if (localb.tAT != 0) {
          break label580;
        }
        ac.i("MicroMsg.WalletIapUI", "Wallet.launchPay");
        this.mRequestCode = this.BQU.a(this, this.BQV);
        this.BQR = 1;
        AppMethodBeat.o(71925);
        return;
        label328:
        ac.e("MicroMsg.NetScenePreparePurchase", "getIapWxPayData fail.");
        paramString = null;
        break;
        label342:
        chd localchd = (chd)paramn.rr.hvs.hvw;
        if (localchd != null)
        {
          paramString = new bla();
          paramString.ELE = paramn.BPw;
          paramString.vFb = paramn.pbW;
          paramString.vyy = paramn.BPx;
          paramString.FaE = localchd.Fvo;
          ac.d("MicroMsg.NetScenePreparePurchase", "getIapGoogleData is " + localchd.Fvo);
        }
        for (;;)
        {
          localc.BPD = paramString;
          break;
          ac.e("MicroMsg.NetScenePreparePurchase", "getIapGoogleData fail.");
          paramString = null;
        }
        if ((paramn instanceof com.tencent.mm.plugin.wallet_index.c.f))
        {
          paramString = (com.tencent.mm.plugin.wallet_index.c.f)paramn;
          if ((paramInt1 == 0) && (paramString.errCode == 0))
          {
            localc.BPE = paramString.BPE;
            localc.BPD = paramString.BPD;
            if (localc.euV())
            {
              if (localc.BPE != null) {
                localc.BPX = localc.BPE.FaE;
              } else {
                ac.e("MicroMsg.IapData", "iapWxPayData is null");
              }
            }
            else if (localc.BPD != null) {
              localc.BPX = localc.BPD.FaE;
            } else {
              ac.e("MicroMsg.IapData", "iapGoogleData is null");
            }
          }
        }
      }
      label580:
      this.currentState = 1002;
      ac.i("MicroMsg.WalletIapUI", "back to preview UI, reason: PreparePurchase fail , errCode: " + localb.tAT + " , errMsg: " + localb.tAU);
      paramString = new Intent();
      paramString.putExtra("key_err_code", localb.tAT);
      paramString.putExtra("key_err_msg", localb.tAU);
      paramString.putExtra("key_response_position", 1);
      setResult(-1, paramString);
      finish();
      AppMethodBeat.o(71925);
      return;
    }
    c localc = this.BPS;
    if ((paramn instanceof v))
    {
      paramn = (v)paramn;
      localc.pbW = paramn.pbW;
      localc.BQc = paramn.pbY;
      localc.BQd = paramn.BQd;
      if (paramn.errCode == 0) {
        paramInt1 = 1;
      }
    }
    for (;;)
    {
      localc.BQe.remove(localc.pbW);
      if (paramInt1 != 0)
      {
        ac.i("MicroMsg.IapData", "Verify " + localc.pbW + " OK");
        localc.BQa.add(localc.pbW);
        localc.BQb.add(localc.BQc);
      }
      for (;;)
      {
        bool = false;
        for (;;)
        {
          if (!this.BPS.BQe.isEmpty()) {
            break label1238;
          }
          ac.d("MicroMsg.WalletIapUI", "Verify All End... ");
          if (this.BPS.BQa.isEmpty()) {
            break label1139;
          }
          ac.i("MicroMsg.WalletIapUI", "mResultProductIds size: " + this.BPS.BQa.size() + ", Consume ...");
          this.BQU.a(this, this.BPS.BQa, this.BPU, bool);
          AppMethodBeat.o(71925);
          return;
          paramInt1 = 0;
          break;
          if (!(paramn instanceof m)) {
            break label1245;
          }
          paramn = (m)paramn;
          localc.pbW = paramn.dcO;
          if (paramn.errCode == 0)
          {
            paramInt1 = 1;
            break;
          }
          paramInt1 = 0;
          break;
          if (!localc.pbW.startsWith("com.tencent.xin.wco")) {
            break label1103;
          }
          if (localc.BQd <= 0) {
            break label1067;
          }
          localc.BQa.add(localc.pbW);
          localc.BQb.add(localc.BQc);
          ac.i("MicroMsg.IapData", "Verify " + localc.pbW + " fail and cosume");
        }
        label1067:
        ac.i("MicroMsg.IapData", "Verify " + localc.pbW + " fail");
        continue;
        label1103:
        ac.i("MicroMsg.IapData", "Verify " + localc.pbW + " fail");
      }
      label1139:
      ac.i("MicroMsg.WalletIapUI", "back to preview UI, reason: VerifyPurchase fail , errCode: " + paramInt2 + " , errMsg: " + paramString);
      this.currentState = 1002;
      paramn = new Intent();
      paramn.putExtra("key_err_code", paramInt2);
      paramn.putExtra("key_err_msg", paramString);
      paramn.putExtra("key_response_position", 3);
      paramn.putExtra("key_launch_ts", a.BPT);
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