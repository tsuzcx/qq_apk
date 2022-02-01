package com.tencent.mm.plugin.wallet_index.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.aaw;
import com.tencent.mm.f.a.abi;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.wallet_index.c.g;
import com.tencent.mm.plugin.wallet_index.c.n;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.protobuf.cky;
import com.tencent.mm.protocal.protobuf.ckz;
import com.tencent.mm.protocal.protobuf.doc;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ar;
import com.tencent.mm.wallet_core.c.ab;
import com.tencent.mm.wallet_core.c.u;
import com.tencent.mm.wallet_core.c.v;
import java.util.ArrayList;
import java.util.List;

@com.tencent.mm.ui.base.a(7)
public class WalletIapUI
  extends MMActivity
  implements com.tencent.mm.an.i
{
  private final int DEFAULT;
  private IListener GUP;
  private final int HGt;
  private int Non;
  private final int OK;
  public c PjQ;
  private d PjS;
  private final int PkI;
  private final int PkJ;
  private final int PkK;
  private final int PkL;
  private final int PkM;
  private final int PkN;
  private boolean PkO;
  private boolean PkP;
  private String PkQ;
  private b PkR;
  public d PkS;
  private IListener Pkz;
  private int currentState;
  private int mRequestCode;
  private Dialog reo;
  
  public WalletIapUI()
  {
    AppMethodBeat.i(71919);
    this.PkI = 4;
    this.PkJ = 0;
    this.PkK = 1;
    this.PkL = 2;
    this.PkM = 3;
    this.OK = 1000;
    this.PkN = 1001;
    this.HGt = 1002;
    this.DEFAULT = 1003;
    this.PkO = false;
    this.Non = 0;
    this.currentState = 1003;
    this.PkQ = "0";
    this.mRequestCode = 0;
    this.Pkz = new IListener() {};
    this.PkS = new d()
    {
      public final void a(com.tencent.mm.plugin.wallet_index.c.c paramAnonymousc, com.tencent.mm.plugin.wallet_index.b.a.c paramAnonymousc1)
      {
        AppMethodBeat.i(71915);
        Log.i("MicroMsg.WalletIapUI", "Pay Purchase finished: " + paramAnonymousc + ", purchase: " + paramAnonymousc1);
        if ((WalletIapUI.b(WalletIapUI.this) instanceof a))
        {
          Log.i("MicroMsg.WalletIapUI", "Pay Purchase finished mWallet is  GoogleWallet");
          if (paramAnonymousc1 != null) {
            ab.e(paramAnonymousc1.Pjk, paramAnonymousc1.uFI, paramAnonymousc1.Pjp, paramAnonymousc.mResponse, paramAnonymousc.mMessage);
          }
        }
        else
        {
          if (!paramAnonymousc.isFailure()) {
            break label268;
          }
          Log.i("MicroMsg.WalletIapUI", "back to preview UI, reason: purchase finish , errCode: " + paramAnonymousc.mResponse + " , errMsg: " + paramAnonymousc.mMessage);
          if (paramAnonymousc.mResponse != 1) {
            break label254;
          }
          WalletIapUI.a(WalletIapUI.this, 1001);
        }
        for (;;)
        {
          paramAnonymousc1 = new Intent();
          paramAnonymousc1.putExtra("key_err_code", paramAnonymousc.mResponse);
          paramAnonymousc1.putExtra("key_err_msg", paramAnonymousc.mMessage);
          paramAnonymousc1.putExtra("key_launch_ts", a.PjR);
          paramAnonymousc1.putExtra("key_gw_error_code", paramAnonymousc.Pjt);
          WalletIapUI.this.setResult(-1, paramAnonymousc1);
          WalletIapUI.this.finish();
          AppMethodBeat.o(71915);
          return;
          a locala = (a)WalletIapUI.b(WalletIapUI.this);
          ab.e(locala.PjV, locala.uFI, locala.Pjp, paramAnonymousc.mResponse, paramAnonymousc.mMessage);
          break;
          label254:
          WalletIapUI.a(WalletIapUI.this, 1002);
        }
        label268:
        if (!paramAnonymousc.gMV())
        {
          if (paramAnonymousc1 != null)
          {
            Log.i("MicroMsg.WalletIapUI", "verify purchase! productId:" + paramAnonymousc1.uFI + ",billNo:" + paramAnonymousc1.Pjn);
            com.tencent.mm.kernel.h.aHH();
            com.tencent.mm.kernel.h.aHF().kcd.a(WalletIapUI.c(WalletIapUI.this).a(paramAnonymousc1, false), 0);
            WalletIapUI.b(WalletIapUI.this, 2);
            WalletIapUI.d(WalletIapUI.this);
            AppMethodBeat.o(71915);
            return;
          }
          WalletIapUI.a(WalletIapUI.this, 1002);
          paramAnonymousc = new Intent();
          paramAnonymousc1 = com.tencent.mm.plugin.wallet_index.c.c.cK(6, "");
          paramAnonymousc.putExtra("key_err_code", paramAnonymousc1.mResponse);
          paramAnonymousc.putExtra("key_err_msg", paramAnonymousc1.mMessage);
          paramAnonymousc.putExtra("key_launch_ts", a.PjR);
          paramAnonymousc.putExtra("key_gw_error_code", paramAnonymousc1.Pjt);
          WalletIapUI.this.setResult(-1, paramAnonymousc);
          WalletIapUI.this.finish();
          AppMethodBeat.o(71915);
          return;
        }
        WalletIapUI.b(WalletIapUI.this, 3);
        Log.i("MicroMsg.WalletIapUI", "start to restore the purchase!");
        WalletIapUI.b(WalletIapUI.this).c(WalletIapUI.this, false);
        AppMethodBeat.o(71915);
      }
    };
    this.PjS = new d()
    {
      public final void a(com.tencent.mm.plugin.wallet_index.c.c paramAnonymousc, com.tencent.mm.plugin.wallet_index.b.a.c paramAnonymousc1)
      {
        AppMethodBeat.i(71916);
        Log.i("MicroMsg.WalletIapUI", "Consume finished: " + paramAnonymousc + ", purchase: " + paramAnonymousc1);
        if (paramAnonymousc.isFailure())
        {
          WalletIapUI.a(WalletIapUI.this, 1002);
          Log.i("MicroMsg.WalletIapUI", "back to preview UI, reason: consume Fail ! ");
        }
        for (;;)
        {
          paramAnonymousc1 = new Intent();
          paramAnonymousc1.putExtra("key_err_code", paramAnonymousc.mResponse);
          paramAnonymousc1.putExtra("key_err_msg", paramAnonymousc.mMessage);
          paramAnonymousc1.putStringArrayListExtra("key_response_product_ids", WalletIapUI.c(WalletIapUI.this).PjY);
          paramAnonymousc1.putStringArrayListExtra("key_response_series_ids", WalletIapUI.c(WalletIapUI.this).PjZ);
          paramAnonymousc1.putExtra("key_launch_ts", a.PjR);
          WalletIapUI.this.setResult(-1, paramAnonymousc1);
          WalletIapUI.this.finish();
          AppMethodBeat.o(71916);
          return;
          WalletIapUI.a(WalletIapUI.this, 1000);
          Log.i("MicroMsg.WalletIapUI", "back to preview UI, reason: consume Success ! ");
        }
      }
    };
    this.GUP = new IListener() {};
    AppMethodBeat.o(71919);
  }
  
  private void bxs()
  {
    AppMethodBeat.i(71927);
    Log.i("MicroMsg.WalletIapUI", "showLoadingDialog!");
    this.reo = com.tencent.mm.wallet_core.ui.i.c(this, getString(a.i.app_waiting), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(71918);
        Log.i("MicroMsg.WalletIapUI", "showLoadingDialog onCancel currentScene: %d", new Object[] { Integer.valueOf(WalletIapUI.f(WalletIapUI.this)) });
        if (WalletIapUI.f(WalletIapUI.this) == 2) {}
        for (paramAnonymousDialogInterface = com.tencent.mm.plugin.wallet_index.c.c.cK(7, "");; paramAnonymousDialogInterface = com.tencent.mm.plugin.wallet_index.c.c.cK(1, ""))
        {
          Intent localIntent = new Intent();
          localIntent.putExtra("key_err_code", paramAnonymousDialogInterface.mResponse);
          localIntent.putExtra("key_err_msg", paramAnonymousDialogInterface.mMessage);
          WalletIapUI.this.setResult(-1, localIntent);
          WalletIapUI.this.finish();
          AppMethodBeat.o(71918);
          return;
        }
      }
    });
    AppMethodBeat.o(71927);
  }
  
  private void bxt()
  {
    AppMethodBeat.i(71928);
    Log.i("MicroMsg.WalletIapUI", "hideLoadingDialog!");
    if ((this.reo != null) && (this.reo.isShowing()))
    {
      this.reo.dismiss();
      this.reo = null;
    }
    AppMethodBeat.o(71928);
  }
  
  public void finish()
  {
    AppMethodBeat.i(71926);
    Log.i("MicroMsg.WalletIapUI", "finish");
    bxt();
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
    Log.i("MicroMsg.WalletIapUI", "onActivityResult resultCode : ".concat(String.valueOf(paramInt2)));
    if ((paramIntent != null) && (paramIntent.getExtras() != null) && (paramIntent.getExtras().get("key_total_fee") != null))
    {
      this.PkQ = paramIntent.getExtras().get("key_total_fee").toString();
      Log.i("MicroMsg.WalletIapUI", "has payAmount:%s", new Object[] { this.PkQ });
    }
    while (this.PkR != null)
    {
      this.PkR.a(this, paramInt1, paramInt2, paramIntent);
      Log.d("MicroMsg.WalletIapUI", "onActivityResult handled by mWalletPay.");
      AppMethodBeat.o(71924);
      return;
      Log.i("MicroMsg.WalletIapUI", "no payAmount");
    }
    Log.e("MicroMsg.WalletIapUI", "havn't handle user action");
    paramIntent = new Intent();
    com.tencent.mm.plugin.wallet_index.c.c localc = com.tencent.mm.plugin.wallet_index.c.c.cK(6, "");
    paramIntent.putExtra("key_err_code", localc.mResponse);
    paramIntent.putExtra("key_err_msg", localc.mMessage);
    paramIntent.putExtra("key_launch_ts", a.PjR);
    setResult(-1, paramIntent);
    finish();
    AppMethodBeat.o(71924);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(71920);
    super.onCreate(paramBundle);
    Log.i("MicroMsg.WalletIapUI", "onCreate");
    ar.kX(this);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.a(422, this);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.a(414, this);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.a(1130, this);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.a(1306, this);
    if (getIntent().getIntExtra("key_action_type", 200001) == 200001) {
      bxs();
    }
    this.PkP = getIntent().getBooleanExtra("key_is_mini_program", false);
    if (getIntent().getBooleanExtra("key_request_fullscreen", false)) {
      getWindow().addFlags(1024);
    }
    this.PjQ = new c();
    this.PjQ.Pkd = this.PkP;
    if ((getIntent().getBooleanExtra("key_force_google", false)) || (z.bdp())) {
      Log.d("MicroMsg.WalletIapUI", "Pay use Google Wallet!");
    }
    for (this.PkR = new a(this, this.PjQ, this.PjS);; this.PkR = new f(this.PjQ, this.GUP))
    {
      this.PjQ.GJz = this.PkR.gMX();
      EventCenter.instance.addListener(this.Pkz);
      AppMethodBeat.o(71920);
      return;
      Log.d("MicroMsg.WalletIapUI", "Pay use WeiXin Wallet!");
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(71923);
    Log.i("MicroMsg.WalletIapUI", "onDestroy");
    bxt();
    if (this.currentState == 1003) {
      this.currentState = 1001;
    }
    String str = "";
    if (getIntent() != null) {
      str = getIntent().getStringExtra("key_appid");
    }
    int i;
    int j;
    if ((this.PkR instanceof f))
    {
      i = 0;
      long l = (Util.getDouble(this.PkQ, 0.0D) * 100.0D);
      Log.i("MicroMsg.WalletIapUI", "reportPaymentState report(%s), isMiniProgram : %b, appid %s, walletType %s, currentScene %s, currentState %s, payAmount %s, payamount %s", new Object[] { Integer.valueOf(15751), Boolean.valueOf(this.PkP), str, Integer.valueOf(i), Integer.valueOf(this.Non), Integer.valueOf(this.currentState), this.PkQ, Long.valueOf(l) });
      com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.IzE;
      if (!this.PkP) {
        break label405;
      }
      j = 0;
      label178:
      localh.a(15751, new Object[] { Integer.valueOf(j), str, Integer.valueOf(i), Integer.valueOf(this.Non), Integer.valueOf(this.currentState), this.PkQ, Long.valueOf(l) });
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1044L, this.currentState - 1000, 1L, false);
      if (this.currentState != 1001) {
        break label410;
      }
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1044L, this.Non + 4, 1L, false);
    }
    for (;;)
    {
      if (this.PkR != null) {
        this.PkR.q(this);
      }
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.kernel.h.aHF().kcd.b(422, this);
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.kernel.h.aHF().kcd.b(414, this);
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.kernel.h.aHF().kcd.b(1130, this);
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.kernel.h.aHF().kcd.b(1306, this);
      EventCenter.instance.removeListener(this.Pkz);
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
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1044L, this.Non + 8, 1L, false);
      }
    }
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(71922);
    Log.i("MicroMsg.WalletIapUI", "onNewIntent");
    super.onNewIntent(paramIntent);
    AppMethodBeat.o(71922);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(71921);
    Log.i("MicroMsg.WalletIapUI", "onResume");
    super.onResume();
    Log.i("MicroMsg.WalletIapUI", "Handler jump");
    if (!this.PkO)
    {
      this.PkO = true;
      Object localObject1 = getIntent();
      if (((Intent)localObject1).getIntExtra("key_action_type", 200001) == 200002)
      {
        Log.i("MicroMsg.WalletIapUI", "start to restore the purchase!");
        this.Non = 3;
        this.PkR.c(this, true);
        AppMethodBeat.o(71921);
        return;
      }
      Log.i("MicroMsg.WalletIapUI", "start to doScene!");
      Object localObject2 = this.PjQ;
      String str1 = ((Intent)localObject1).getStringExtra("key_product_id");
      ((c)localObject2).uFI = str1;
      ((c)localObject2).Pkc.add(str1);
      Log.d("MicroMsg.IapData", "prepare pay product: ".concat(String.valueOf(str1)));
      this.PjQ.Pjp = ((Intent)localObject1).getStringExtra("key_price");
      this.PjQ.Pjo = ((Intent)localObject1).getStringExtra("key_currency_type");
      localObject2 = ((Intent)localObject1).getStringExtra("key_ext_info");
      this.PjQ.mCount = ((Intent)localObject1).getIntExtra("key_count", 1);
      str1 = ((Intent)localObject1).getStringExtra("key_appid");
      String str2 = ((Intent)localObject1).getStringExtra("key_desc");
      String str3 = ((Intent)localObject1).getStringExtra("key_busiid");
      this.PjQ.Pke = ((Intent)localObject1).getStringExtra("key_virtual_pay_sign");
      this.PjQ.Pkf = ((Intent)localObject1).getStringExtra("key_attach");
      this.PjQ.ovF = ((Intent)localObject1).getStringExtra("key_extInfo");
      localObject1 = this.PjQ.h(this.PkR.gMX(), (String)localObject2, str1, str2, str3);
      if (localObject1 != null)
      {
        com.tencent.mm.kernel.h.aHH();
        com.tencent.mm.kernel.h.aHF().kcd.a((q)localObject1, 0);
        AppMethodBeat.o(71921);
        return;
      }
      Log.e("MicroMsg.WalletIapUI", "getPrepareNetScene error netScene is null");
      this.currentState = 1002;
      localObject1 = com.tencent.mm.plugin.wallet_index.c.c.cK(8, "");
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("key_err_code", ((com.tencent.mm.plugin.wallet_index.c.c)localObject1).mResponse);
      ((Intent)localObject2).putExtra("key_err_msg", ((com.tencent.mm.plugin.wallet_index.c.c)localObject1).mMessage);
      setResult(-1, (Intent)localObject2);
      finish();
    }
    AppMethodBeat.o(71921);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    boolean bool = true;
    AppMethodBeat.i(71925);
    Log.i("MicroMsg.WalletIapUI", "onSceneEnd type:" + paramq.getType() + " errCode:" + paramInt2 + ",errMsg:" + paramString);
    paramString = com.tencent.mm.plugin.wallet_index.c.c.cK(paramInt2, paramString);
    paramInt2 = paramString.mResponse;
    paramString = paramString.mMessage;
    paramInt1 = paramq.getType();
    switch (paramInt1)
    {
    default: 
      Log.w("MicroMsg.WalletIapUI", "get a wrong sceneType : ".concat(String.valueOf(paramInt1)));
      AppMethodBeat.o(71925);
      return;
    case 422: 
    case 1130: 
      localc = this.PjQ;
      com.tencent.mm.plugin.wallet_index.c.c localc1 = com.tencent.mm.plugin.wallet_index.c.c.cK(paramInt2, paramString);
      paramInt1 = localc1.mResponse;
      if ((paramq instanceof u))
      {
        paramq = (u)paramq;
        if (paramInt1 == 0)
        {
          if (!localc.gMY()) {
            break label342;
          }
          paramq = (doc)d.c.b(paramq.rr.lBS);
          if (paramq == null) {
            break label328;
          }
          paramString = new ckz();
          paramString.TsB = paramq.TVs;
          paramString.TsC = paramq.TVt;
          paramString.fOY = 5;
          paramString.TsD = paramq.TVu;
          Log.d("MicroMsg.NetScenePreparePurchase", "get Sign4TenPay is " + paramq.TVu);
          localc.Pjz = paramString;
        }
      }
      for (;;)
      {
        if (localc1.mResponse != 0) {
          break label580;
        }
        Log.i("MicroMsg.WalletIapUI", "Wallet.launchPay");
        this.mRequestCode = this.PkR.a(this, this.PkS);
        this.Non = 1;
        AppMethodBeat.o(71925);
        return;
        label328:
        Log.e("MicroMsg.NetScenePreparePurchase", "getIapWxPayData fail.");
        paramString = null;
        break;
        label342:
        doc localdoc = (doc)d.c.b(paramq.rr.lBS);
        if (localdoc != null)
        {
          paramString = new cky();
          paramString.TaW = paramq.Pjo;
          paramString.GTv = paramq.uFI;
          paramString.price = paramq.Pjp;
          paramString.Tsx = localdoc.TVr;
          Log.d("MicroMsg.NetScenePreparePurchase", "getIapGoogleData is " + localdoc.TVr);
        }
        for (;;)
        {
          localc.Pjy = paramString;
          break;
          Log.e("MicroMsg.NetScenePreparePurchase", "getIapGoogleData fail.");
          paramString = null;
        }
        if ((paramq instanceof g))
        {
          paramString = (g)paramq;
          if ((paramInt1 == 0) && (paramString.errCode == 0))
          {
            localc.Pjz = paramString.Pjz;
            localc.Pjy = paramString.Pjy;
            if (localc.gMY())
            {
              if (localc.Pjz != null) {
                localc.PjV = localc.Pjz.Tsx;
              } else {
                Log.e("MicroMsg.IapData", "iapWxPayData is null");
              }
            }
            else if (localc.Pjy != null) {
              localc.PjV = localc.Pjy.Tsx;
            } else {
              Log.e("MicroMsg.IapData", "iapGoogleData is null");
            }
          }
        }
      }
      label580:
      this.currentState = 1002;
      Log.i("MicroMsg.WalletIapUI", "back to preview UI, reason: PreparePurchase fail , errCode: " + localc1.mResponse + " , errMsg: " + localc1.mMessage);
      paramString = new Intent();
      paramString.putExtra("key_err_code", localc1.mResponse);
      paramString.putExtra("key_err_msg", localc1.mMessage);
      paramString.putExtra("key_response_position", 1);
      setResult(-1, paramString);
      finish();
      AppMethodBeat.o(71925);
      return;
    }
    c localc = this.PjQ;
    if ((paramq instanceof v))
    {
      paramq = (v)paramq;
      localc.uFI = paramq.uFI;
      localc.Pka = paramq.uFK;
      localc.Pkb = paramq.Pkb;
      if (paramq.errCode == 0) {
        paramInt1 = 1;
      }
    }
    for (;;)
    {
      localc.Pkc.remove(localc.uFI);
      if (paramInt1 != 0)
      {
        Log.i("MicroMsg.IapData", "Verify " + localc.uFI + " OK");
        localc.PjY.add(localc.uFI);
        localc.PjZ.add(localc.Pka);
      }
      for (;;)
      {
        bool = false;
        for (;;)
        {
          if (!this.PjQ.Pkc.isEmpty()) {
            break label1238;
          }
          Log.d("MicroMsg.WalletIapUI", "Verify All End... ");
          if (this.PjQ.PjY.isEmpty()) {
            break label1139;
          }
          Log.i("MicroMsg.WalletIapUI", "mResultProductIds size: " + this.PjQ.PjY.size() + ", Consume ...");
          this.PkR.a(this, this.PjQ.PjY, this.PjS, bool);
          AppMethodBeat.o(71925);
          return;
          paramInt1 = 0;
          break;
          if (!(paramq instanceof n)) {
            break label1245;
          }
          paramq = (n)paramq;
          localc.uFI = paramq.productId;
          if (paramq.errCode == 0)
          {
            paramInt1 = 1;
            break;
          }
          paramInt1 = 0;
          break;
          if (!localc.uFI.startsWith("com.tencent.xin.wco")) {
            break label1103;
          }
          if (localc.Pkb <= 0) {
            break label1067;
          }
          localc.PjY.add(localc.uFI);
          localc.PjZ.add(localc.Pka);
          Log.i("MicroMsg.IapData", "Verify " + localc.uFI + " fail and cosume");
        }
        label1067:
        Log.i("MicroMsg.IapData", "Verify " + localc.uFI + " fail");
        continue;
        label1103:
        Log.i("MicroMsg.IapData", "Verify " + localc.uFI + " fail");
      }
      label1139:
      Log.i("MicroMsg.WalletIapUI", "back to preview UI, reason: VerifyPurchase fail , errCode: " + paramInt2 + " , errMsg: " + paramString);
      this.currentState = 1002;
      paramq = new Intent();
      paramq.putExtra("key_err_code", paramInt2);
      paramq.putExtra("key_err_msg", paramString);
      paramq.putExtra("key_response_position", 3);
      paramq.putExtra("key_launch_ts", a.PjR);
      setResult(-1, paramq);
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