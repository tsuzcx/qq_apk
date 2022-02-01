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
import com.tencent.mm.g.a.yk;
import com.tencent.mm.g.a.yw;
import com.tencent.mm.plugin.wallet_index.c.m;
import com.tencent.mm.protocal.protobuf.bqc;
import com.tencent.mm.protocal.protobuf.bqd;
import com.tencent.mm.protocal.protobuf.cmw;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.al;
import com.tencent.mm.wallet_core.c.ab;
import com.tencent.mm.wallet_core.c.u;
import com.tencent.mm.wallet_core.ui.h;
import java.util.ArrayList;
import java.util.List;

@com.tencent.mm.ui.base.a(7)
public class WalletIapUI
  extends MMActivity
  implements com.tencent.mm.ak.f
{
  private final int DEFAULT;
  private c DHQ;
  private d DHS;
  private final int DII;
  private final int DIJ;
  private final int DIK;
  private final int DIL;
  private final int DIM;
  private final int DIN;
  private boolean DIO;
  private int DIP;
  private boolean DIQ;
  private String DIR;
  private b DIS;
  private d DIT;
  private com.tencent.mm.sdk.b.c DIz;
  private final int OK;
  private int currentState;
  private Dialog mPB;
  private int mRequestCode;
  private final int xKf;
  private com.tencent.mm.sdk.b.c xdp;
  
  public WalletIapUI()
  {
    AppMethodBeat.i(71919);
    this.DII = 4;
    this.DIJ = 0;
    this.DIK = 1;
    this.DIL = 2;
    this.DIM = 3;
    this.OK = 1000;
    this.DIN = 1001;
    this.xKf = 1002;
    this.DEFAULT = 1003;
    this.DIO = false;
    this.DIP = 0;
    this.currentState = 1003;
    this.DIR = "0";
    this.mRequestCode = 0;
    this.DIz = new com.tencent.mm.sdk.b.c() {};
    this.DIT = new d()
    {
      public final void a(com.tencent.mm.plugin.wallet_index.c.b paramAnonymousb, com.tencent.mm.plugin.wallet_index.b.a.c paramAnonymousc)
      {
        AppMethodBeat.i(71915);
        ae.i("MicroMsg.WalletIapUI", "Pay Purchase finished: " + paramAnonymousb + ", purchase: " + paramAnonymousc);
        if ((WalletIapUI.b(WalletIapUI.this) instanceof a))
        {
          ae.i("MicroMsg.WalletIapUI", "Pay Purchase finished mWallet is  GoogleWallet");
          if (paramAnonymousc != null) {
            ab.e(paramAnonymousc.DHp, paramAnonymousc.pMk, paramAnonymousc.DHv, paramAnonymousb.uPh, paramAnonymousb.uPi);
          }
        }
        else
        {
          if (!paramAnonymousb.eMH()) {
            break label268;
          }
          ae.i("MicroMsg.WalletIapUI", "back to preview UI, reason: purchase finish , errCode: " + paramAnonymousb.uPh + " , errMsg: " + paramAnonymousb.uPi);
          if (paramAnonymousb.uPh != 1) {
            break label254;
          }
          WalletIapUI.a(WalletIapUI.this, 1001);
        }
        for (;;)
        {
          paramAnonymousc = new Intent();
          paramAnonymousc.putExtra("key_err_code", paramAnonymousb.uPh);
          paramAnonymousc.putExtra("key_err_msg", paramAnonymousb.uPi);
          paramAnonymousc.putExtra("key_launch_ts", a.DHR);
          paramAnonymousc.putExtra("key_gw_error_code", paramAnonymousb.DHw);
          WalletIapUI.this.setResult(-1, paramAnonymousc);
          WalletIapUI.this.finish();
          AppMethodBeat.o(71915);
          return;
          a locala = (a)WalletIapUI.b(WalletIapUI.this);
          ab.e(locala.DHV, locala.pMk, locala.DHv, paramAnonymousb.uPh, paramAnonymousb.uPi);
          break;
          label254:
          WalletIapUI.a(WalletIapUI.this, 1002);
        }
        label268:
        if (!paramAnonymousb.eMG())
        {
          if (paramAnonymousc != null)
          {
            ae.i("MicroMsg.WalletIapUI", "verify purchase! productId:" + paramAnonymousc.pMk + ",billNo:" + paramAnonymousc.DHs);
            com.tencent.mm.kernel.g.ajS();
            com.tencent.mm.kernel.g.ajQ().gDv.a(WalletIapUI.c(WalletIapUI.this).a(paramAnonymousc, false), 0);
            WalletIapUI.b(WalletIapUI.this, 2);
            WalletIapUI.d(WalletIapUI.this);
            AppMethodBeat.o(71915);
            return;
          }
          WalletIapUI.a(WalletIapUI.this, 1002);
          paramAnonymousb = new Intent();
          paramAnonymousc = com.tencent.mm.plugin.wallet_index.c.b.cr(6, "");
          paramAnonymousb.putExtra("key_err_code", paramAnonymousc.uPh);
          paramAnonymousb.putExtra("key_err_msg", paramAnonymousc.uPi);
          paramAnonymousb.putExtra("key_launch_ts", a.DHR);
          paramAnonymousb.putExtra("key_gw_error_code", paramAnonymousc.DHw);
          WalletIapUI.this.setResult(-1, paramAnonymousb);
          WalletIapUI.this.finish();
          AppMethodBeat.o(71915);
          return;
        }
        WalletIapUI.b(WalletIapUI.this, 3);
        ae.i("MicroMsg.WalletIapUI", "start to restore the purchase!");
        WalletIapUI.b(WalletIapUI.this).d(WalletIapUI.this, false);
        AppMethodBeat.o(71915);
      }
    };
    this.DHS = new d()
    {
      public final void a(com.tencent.mm.plugin.wallet_index.c.b paramAnonymousb, com.tencent.mm.plugin.wallet_index.b.a.c paramAnonymousc)
      {
        AppMethodBeat.i(71916);
        ae.i("MicroMsg.WalletIapUI", "Consume finished: " + paramAnonymousb + ", purchase: " + paramAnonymousc);
        if (paramAnonymousb.eMH())
        {
          WalletIapUI.a(WalletIapUI.this, 1002);
          ae.i("MicroMsg.WalletIapUI", "back to preview UI, reason: consume Fail ! ");
        }
        for (;;)
        {
          paramAnonymousc = new Intent();
          paramAnonymousc.putExtra("key_err_code", paramAnonymousb.uPh);
          paramAnonymousc.putExtra("key_err_msg", paramAnonymousb.uPi);
          paramAnonymousc.putStringArrayListExtra("key_response_product_ids", WalletIapUI.c(WalletIapUI.this).DHY);
          paramAnonymousc.putStringArrayListExtra("key_response_series_ids", WalletIapUI.c(WalletIapUI.this).DHZ);
          paramAnonymousc.putExtra("key_launch_ts", a.DHR);
          WalletIapUI.this.setResult(-1, paramAnonymousc);
          WalletIapUI.this.finish();
          AppMethodBeat.o(71916);
          return;
          WalletIapUI.a(WalletIapUI.this, 1000);
          ae.i("MicroMsg.WalletIapUI", "back to preview UI, reason: consume Success ! ");
        }
      }
    };
    this.xdp = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(71919);
  }
  
  private void aSw()
  {
    AppMethodBeat.i(71927);
    ae.i("MicroMsg.WalletIapUI", "showLoadingDialog!");
    this.mPB = h.b(this, getString(2131755936), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(71918);
        ae.i("MicroMsg.WalletIapUI", "showLoadingDialog onCancel currentScene: %d", new Object[] { Integer.valueOf(WalletIapUI.f(WalletIapUI.this)) });
        if (WalletIapUI.f(WalletIapUI.this) == 2) {}
        for (paramAnonymousDialogInterface = com.tencent.mm.plugin.wallet_index.c.b.cr(7, "");; paramAnonymousDialogInterface = com.tencent.mm.plugin.wallet_index.c.b.cr(1, ""))
        {
          Intent localIntent = new Intent();
          localIntent.putExtra("key_err_code", paramAnonymousDialogInterface.uPh);
          localIntent.putExtra("key_err_msg", paramAnonymousDialogInterface.uPi);
          WalletIapUI.this.setResult(-1, localIntent);
          WalletIapUI.this.finish();
          AppMethodBeat.o(71918);
          return;
        }
      }
    });
    AppMethodBeat.o(71927);
  }
  
  private void aSx()
  {
    AppMethodBeat.i(71928);
    ae.i("MicroMsg.WalletIapUI", "hideLoadingDialog!");
    if ((this.mPB != null) && (this.mPB.isShowing()))
    {
      this.mPB.dismiss();
      this.mPB = null;
    }
    AppMethodBeat.o(71928);
  }
  
  public void finish()
  {
    AppMethodBeat.i(71926);
    ae.i("MicroMsg.WalletIapUI", "finish");
    aSx();
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
    ae.i("MicroMsg.WalletIapUI", "onActivityResult resultCode : ".concat(String.valueOf(paramInt2)));
    if ((paramIntent != null) && (paramIntent.getExtras() != null) && (paramIntent.getExtras().get("key_total_fee") != null))
    {
      this.DIR = paramIntent.getExtras().get("key_total_fee").toString();
      ae.i("MicroMsg.WalletIapUI", "has payAmount:%s", new Object[] { this.DIR });
    }
    while (this.DIS != null)
    {
      this.DIS.a(this, paramInt1, paramInt2, paramIntent);
      ae.d("MicroMsg.WalletIapUI", "onActivityResult handled by mWalletPay.");
      AppMethodBeat.o(71924);
      return;
      ae.i("MicroMsg.WalletIapUI", "no payAmount");
    }
    ae.e("MicroMsg.WalletIapUI", "havn't handle user action");
    paramIntent = new Intent();
    com.tencent.mm.plugin.wallet_index.c.b localb = com.tencent.mm.plugin.wallet_index.c.b.cr(6, "");
    paramIntent.putExtra("key_err_code", localb.uPh);
    paramIntent.putExtra("key_err_msg", localb.uPi);
    paramIntent.putExtra("key_launch_ts", a.DHR);
    setResult(-1, paramIntent);
    finish();
    AppMethodBeat.o(71924);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(71920);
    super.onCreate(paramBundle);
    ae.i("MicroMsg.WalletIapUI", "onCreate");
    al.kb(this);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajQ().gDv.a(422, this);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajQ().gDv.a(414, this);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajQ().gDv.a(1130, this);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajQ().gDv.a(1306, this);
    if (getIntent().getIntExtra("key_action_type", 200001) == 200001) {
      aSw();
    }
    this.DIQ = getIntent().getBooleanExtra("key_is_mini_program", false);
    if (getIntent().getBooleanExtra("key_request_fullscreen", false)) {
      getWindow().addFlags(1024);
    }
    this.DHQ = new c();
    this.DHQ.DId = this.DIQ;
    if ((getIntent().getBooleanExtra("key_force_google", false)) || (com.tencent.mm.model.v.aAQ())) {
      ae.d("MicroMsg.WalletIapUI", "Pay use Google Wallet!");
    }
    for (this.DIS = new a(this, this.DHQ, this.DHS);; this.DIS = new f(this.DHQ, this.xdp))
    {
      this.DHQ.wUs = this.DIS.eMI();
      com.tencent.mm.sdk.b.a.IvT.c(this.DIz);
      AppMethodBeat.o(71920);
      return;
      ae.d("MicroMsg.WalletIapUI", "Pay use WeiXin Wallet!");
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(71923);
    ae.i("MicroMsg.WalletIapUI", "onDestroy");
    aSx();
    if (this.currentState == 1003) {
      this.currentState = 1001;
    }
    String str = "";
    if (getIntent() != null) {
      str = getIntent().getStringExtra("key_appid");
    }
    int i;
    int j;
    if ((this.DIS instanceof f))
    {
      i = 0;
      long l = (bu.getDouble(this.DIR, 0.0D) * 100.0D);
      ae.i("MicroMsg.WalletIapUI", "reportPaymentState report(%s), isMiniProgram : %b, appid %s, walletType %s, currentScene %s, currentState %s, payAmount %s, payamount %s", new Object[] { Integer.valueOf(15751), Boolean.valueOf(this.DIQ), str, Integer.valueOf(i), Integer.valueOf(this.DIP), Integer.valueOf(this.currentState), this.DIR, Long.valueOf(l) });
      com.tencent.mm.plugin.report.service.g localg = com.tencent.mm.plugin.report.service.g.yxI;
      if (!this.DIQ) {
        break label405;
      }
      j = 0;
      label178:
      localg.f(15751, new Object[] { Integer.valueOf(j), str, Integer.valueOf(i), Integer.valueOf(this.DIP), Integer.valueOf(this.currentState), this.DIR, Long.valueOf(l) });
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1044L, this.currentState - 1000, 1L, false);
      if (this.currentState != 1001) {
        break label410;
      }
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1044L, this.DIP + 4, 1L, false);
    }
    for (;;)
    {
      if (this.DIS != null) {
        this.DIS.p(this);
      }
      com.tencent.mm.kernel.g.ajS();
      com.tencent.mm.kernel.g.ajQ().gDv.b(422, this);
      com.tencent.mm.kernel.g.ajS();
      com.tencent.mm.kernel.g.ajQ().gDv.b(414, this);
      com.tencent.mm.kernel.g.ajS();
      com.tencent.mm.kernel.g.ajQ().gDv.b(1130, this);
      com.tencent.mm.kernel.g.ajS();
      com.tencent.mm.kernel.g.ajQ().gDv.b(1306, this);
      com.tencent.mm.sdk.b.a.IvT.d(this.DIz);
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
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1044L, this.DIP + 8, 1L, false);
      }
    }
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(71922);
    ae.i("MicroMsg.WalletIapUI", "onNewIntent");
    super.onNewIntent(paramIntent);
    AppMethodBeat.o(71922);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(71921);
    ae.i("MicroMsg.WalletIapUI", "onResume");
    super.onResume();
    ae.i("MicroMsg.WalletIapUI", "Handler jump");
    if (!this.DIO)
    {
      this.DIO = true;
      Object localObject1 = getIntent();
      if (((Intent)localObject1).getIntExtra("key_action_type", 200001) == 200002)
      {
        ae.i("MicroMsg.WalletIapUI", "start to restore the purchase!");
        this.DIP = 3;
        this.DIS.d(this, true);
        AppMethodBeat.o(71921);
        return;
      }
      ae.i("MicroMsg.WalletIapUI", "start to doScene!");
      Object localObject2 = this.DHQ;
      String str1 = ((Intent)localObject1).getStringExtra("key_product_id");
      ((c)localObject2).pMk = str1;
      ((c)localObject2).DIc.add(str1);
      ae.d("MicroMsg.IapData", "prepare pay product: ".concat(String.valueOf(str1)));
      this.DHQ.DHv = ((Intent)localObject1).getStringExtra("key_price");
      this.DHQ.DHu = ((Intent)localObject1).getStringExtra("key_currency_type");
      localObject2 = ((Intent)localObject1).getStringExtra("key_ext_info");
      this.DHQ.mCount = ((Intent)localObject1).getIntExtra("key_count", 1);
      str1 = ((Intent)localObject1).getStringExtra("key_appid");
      String str2 = ((Intent)localObject1).getStringExtra("key_desc");
      String str3 = ((Intent)localObject1).getStringExtra("key_busiid");
      this.DHQ.DIe = ((Intent)localObject1).getStringExtra("key_virtual_pay_sign");
      this.DHQ.DIf = ((Intent)localObject1).getStringExtra("key_attach");
      localObject1 = this.DHQ.f(this.DIS.eMI(), (String)localObject2, str1, str2, str3);
      if (localObject1 != null)
      {
        com.tencent.mm.kernel.g.ajS();
        com.tencent.mm.kernel.g.ajQ().gDv.a((n)localObject1, 0);
        AppMethodBeat.o(71921);
        return;
      }
      ae.e("MicroMsg.WalletIapUI", "getPrepareNetScene error netScene is null");
      this.currentState = 1002;
      localObject1 = com.tencent.mm.plugin.wallet_index.c.b.cr(8, "");
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("key_err_code", ((com.tencent.mm.plugin.wallet_index.c.b)localObject1).uPh);
      ((Intent)localObject2).putExtra("key_err_msg", ((com.tencent.mm.plugin.wallet_index.c.b)localObject1).uPi);
      setResult(-1, (Intent)localObject2);
      finish();
    }
    AppMethodBeat.o(71921);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    boolean bool = true;
    AppMethodBeat.i(71925);
    ae.i("MicroMsg.WalletIapUI", "onSceneEnd type:" + paramn.getType() + " errCode:" + paramInt2 + ",errMsg:" + paramString);
    paramString = com.tencent.mm.plugin.wallet_index.c.b.cr(paramInt2, paramString);
    paramInt2 = paramString.uPh;
    paramString = paramString.uPi;
    paramInt1 = paramn.getType();
    switch (paramInt1)
    {
    default: 
      ae.w("MicroMsg.WalletIapUI", "get a wrong sceneType : ".concat(String.valueOf(paramInt1)));
      AppMethodBeat.o(71925);
      return;
    case 422: 
    case 1130: 
      localc = this.DHQ;
      com.tencent.mm.plugin.wallet_index.c.b localb = com.tencent.mm.plugin.wallet_index.c.b.cr(paramInt2, paramString);
      paramInt1 = localb.uPh;
      if ((paramn instanceof u))
      {
        paramn = (u)paramn;
        if (paramInt1 == 0)
        {
          if (!localc.eMJ()) {
            break label342;
          }
          paramn = (cmw)paramn.rr.hQE.hQJ;
          if (paramn == null) {
            break label328;
          }
          paramString = new bqd();
          paramString.HdI = paramn.HyU;
          paramString.HdJ = paramn.HyV;
          paramString.dDH = 5;
          paramString.HdK = paramn.HyW;
          ae.d("MicroMsg.NetScenePreparePurchase", "get Sign4TenPay is " + paramn.HyW);
          localc.DHC = paramString;
        }
      }
      for (;;)
      {
        if (localb.uPh != 0) {
          break label580;
        }
        ae.i("MicroMsg.WalletIapUI", "Wallet.launchPay");
        this.mRequestCode = this.DIS.a(this, this.DIT);
        this.DIP = 1;
        AppMethodBeat.o(71925);
        return;
        label328:
        ae.e("MicroMsg.NetScenePreparePurchase", "getIapWxPayData fail.");
        paramString = null;
        break;
        label342:
        cmw localcmw = (cmw)paramn.rr.hQE.hQJ;
        if (localcmw != null)
        {
          paramString = new bqc();
          paramString.GOh = paramn.DHu;
          paramString.xbV = paramn.pMk;
          paramString.wTD = paramn.DHv;
          paramString.HdE = localcmw.HyT;
          ae.d("MicroMsg.NetScenePreparePurchase", "getIapGoogleData is " + localcmw.HyT);
        }
        for (;;)
        {
          localc.DHB = paramString;
          break;
          ae.e("MicroMsg.NetScenePreparePurchase", "getIapGoogleData fail.");
          paramString = null;
        }
        if ((paramn instanceof com.tencent.mm.plugin.wallet_index.c.f))
        {
          paramString = (com.tencent.mm.plugin.wallet_index.c.f)paramn;
          if ((paramInt1 == 0) && (paramString.errCode == 0))
          {
            localc.DHC = paramString.DHC;
            localc.DHB = paramString.DHB;
            if (localc.eMJ())
            {
              if (localc.DHC != null) {
                localc.DHV = localc.DHC.HdE;
              } else {
                ae.e("MicroMsg.IapData", "iapWxPayData is null");
              }
            }
            else if (localc.DHB != null) {
              localc.DHV = localc.DHB.HdE;
            } else {
              ae.e("MicroMsg.IapData", "iapGoogleData is null");
            }
          }
        }
      }
      label580:
      this.currentState = 1002;
      ae.i("MicroMsg.WalletIapUI", "back to preview UI, reason: PreparePurchase fail , errCode: " + localb.uPh + " , errMsg: " + localb.uPi);
      paramString = new Intent();
      paramString.putExtra("key_err_code", localb.uPh);
      paramString.putExtra("key_err_msg", localb.uPi);
      paramString.putExtra("key_response_position", 1);
      setResult(-1, paramString);
      finish();
      AppMethodBeat.o(71925);
      return;
    }
    c localc = this.DHQ;
    if ((paramn instanceof com.tencent.mm.wallet_core.c.v))
    {
      paramn = (com.tencent.mm.wallet_core.c.v)paramn;
      localc.pMk = paramn.pMk;
      localc.DIa = paramn.pMm;
      localc.DIb = paramn.DIb;
      if (paramn.errCode == 0) {
        paramInt1 = 1;
      }
    }
    for (;;)
    {
      localc.DIc.remove(localc.pMk);
      if (paramInt1 != 0)
      {
        ae.i("MicroMsg.IapData", "Verify " + localc.pMk + " OK");
        localc.DHY.add(localc.pMk);
        localc.DHZ.add(localc.DIa);
      }
      for (;;)
      {
        bool = false;
        for (;;)
        {
          if (!this.DHQ.DIc.isEmpty()) {
            break label1238;
          }
          ae.d("MicroMsg.WalletIapUI", "Verify All End... ");
          if (this.DHQ.DHY.isEmpty()) {
            break label1139;
          }
          ae.i("MicroMsg.WalletIapUI", "mResultProductIds size: " + this.DHQ.DHY.size() + ", Consume ...");
          this.DIS.a(this, this.DHQ.DHY, this.DHS, bool);
          AppMethodBeat.o(71925);
          return;
          paramInt1 = 0;
          break;
          if (!(paramn instanceof m)) {
            break label1245;
          }
          paramn = (m)paramn;
          localc.pMk = paramn.dpp;
          if (paramn.errCode == 0)
          {
            paramInt1 = 1;
            break;
          }
          paramInt1 = 0;
          break;
          if (!localc.pMk.startsWith("com.tencent.xin.wco")) {
            break label1103;
          }
          if (localc.DIb <= 0) {
            break label1067;
          }
          localc.DHY.add(localc.pMk);
          localc.DHZ.add(localc.DIa);
          ae.i("MicroMsg.IapData", "Verify " + localc.pMk + " fail and cosume");
        }
        label1067:
        ae.i("MicroMsg.IapData", "Verify " + localc.pMk + " fail");
        continue;
        label1103:
        ae.i("MicroMsg.IapData", "Verify " + localc.pMk + " fail");
      }
      label1139:
      ae.i("MicroMsg.WalletIapUI", "back to preview UI, reason: VerifyPurchase fail , errCode: " + paramInt2 + " , errMsg: " + paramString);
      this.currentState = 1002;
      paramn = new Intent();
      paramn.putExtra("key_err_code", paramInt2);
      paramn.putExtra("key_err_msg", paramString);
      paramn.putExtra("key_response_position", 3);
      paramn.putExtra("key_launch_ts", a.DHR);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.ui.WalletIapUI
 * JD-Core Version:    0.7.0.1
 */