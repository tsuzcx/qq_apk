package com.tencent.mm.plugin.wallet_index.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.act;
import com.tencent.mm.autogen.a.adf;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.wallet_index.b.a.e;
import com.tencent.mm.plugin.wallet_index.model.n;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.protobuf.dbf;
import com.tencent.mm.protocal.protobuf.dbg;
import com.tencent.mm.protocal.protobuf.egt;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aw;
import com.tencent.mm.wallet_core.model.ac;
import com.tencent.mm.wallet_core.model.u;
import com.tencent.mm.wallet_core.model.v;
import com.tencent.mm.wallet_core.ui.l;
import java.util.ArrayList;
import java.util.List;

@com.tencent.mm.ui.base.a(7)
public class WalletIapUI
  extends MMActivity
  implements com.tencent.mm.am.h
{
  private final int DEFAULT;
  private int DMu;
  private IListener MSr;
  private final int NDS;
  private final int OK;
  public c WaT;
  private d WaV;
  private IListener WbC;
  private final int WbL;
  private final int WbM;
  private final int WbN;
  private final int WbO;
  private final int WbP;
  private final int WbQ;
  private boolean WbR;
  private boolean WbS;
  private String WbT;
  private b WbU;
  public d WbV;
  private int currentState;
  private int mRequestCode;
  private Dialog ums;
  
  public WalletIapUI()
  {
    AppMethodBeat.i(71919);
    this.WbL = 4;
    this.WbM = 0;
    this.WbN = 1;
    this.WbO = 2;
    this.WbP = 3;
    this.OK = 1000;
    this.WbQ = 1001;
    this.NDS = 1002;
    this.DEFAULT = 1003;
    this.WbR = false;
    this.DMu = 0;
    this.currentState = 1003;
    this.WbT = "0";
    this.mRequestCode = 0;
    this.WbC = new IListener(f.hfK) {};
    this.WbV = new d()
    {
      public final void a(com.tencent.mm.plugin.wallet_index.model.c paramAnonymousc, e paramAnonymouse)
      {
        AppMethodBeat.i(71915);
        Log.i("MicroMsg.WalletIapUI", "Pay Purchase finished: " + paramAnonymousc + ", purchase: " + paramAnonymouse);
        if ((WalletIapUI.b(WalletIapUI.this) instanceof a))
        {
          Log.i("MicroMsg.WalletIapUI", "Pay Purchase finished mWallet is  GoogleWallet");
          if (paramAnonymouse != null) {
            ac.e(paramAnonymouse.Wac, paramAnonymouse.xOk, paramAnonymouse.Wah, paramAnonymousc.mResponse, paramAnonymousc.mMessage);
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
          paramAnonymouse = new Intent();
          paramAnonymouse.putExtra("key_err_code", paramAnonymousc.mResponse);
          paramAnonymouse.putExtra("key_err_msg", paramAnonymousc.mMessage);
          paramAnonymouse.putExtra("key_launch_ts", a.WaU);
          paramAnonymouse.putExtra("key_gw_error_code", paramAnonymousc.Wal);
          WalletIapUI.this.setResult(-1, paramAnonymouse);
          WalletIapUI.this.finish();
          AppMethodBeat.o(71915);
          return;
          a locala = (a)WalletIapUI.b(WalletIapUI.this);
          ac.e(locala.WaY, locala.xOk, locala.Wah, paramAnonymousc.mResponse, paramAnonymousc.mMessage);
          break;
          label254:
          WalletIapUI.a(WalletIapUI.this, 1002);
        }
        label268:
        if (!paramAnonymousc.imk())
        {
          if (paramAnonymouse != null)
          {
            Log.i("MicroMsg.WalletIapUI", "verify purchase! productId:" + paramAnonymouse.xOk + ",billNo:" + paramAnonymouse.Waf);
            com.tencent.mm.kernel.h.baF();
            com.tencent.mm.kernel.h.baD().mCm.a(WalletIapUI.c(WalletIapUI.this).a(paramAnonymouse, false), 0);
            WalletIapUI.b(WalletIapUI.this, 2);
            WalletIapUI.d(WalletIapUI.this);
            AppMethodBeat.o(71915);
            return;
          }
          WalletIapUI.a(WalletIapUI.this, 1002);
          paramAnonymousc = new Intent();
          paramAnonymouse = com.tencent.mm.plugin.wallet_index.model.c.dA(6, "");
          paramAnonymousc.putExtra("key_err_code", paramAnonymouse.mResponse);
          paramAnonymousc.putExtra("key_err_msg", paramAnonymouse.mMessage);
          paramAnonymousc.putExtra("key_launch_ts", a.WaU);
          paramAnonymousc.putExtra("key_gw_error_code", paramAnonymouse.Wal);
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
    this.WaV = new d()
    {
      public final void a(com.tencent.mm.plugin.wallet_index.model.c paramAnonymousc, e paramAnonymouse)
      {
        AppMethodBeat.i(71916);
        Log.i("MicroMsg.WalletIapUI", "Consume finished: " + paramAnonymousc + ", purchase: " + paramAnonymouse);
        if (paramAnonymousc.isFailure())
        {
          WalletIapUI.a(WalletIapUI.this, 1002);
          Log.i("MicroMsg.WalletIapUI", "back to preview UI, reason: consume Fail ! ");
        }
        for (;;)
        {
          paramAnonymouse = new Intent();
          paramAnonymouse.putExtra("key_err_code", paramAnonymousc.mResponse);
          paramAnonymouse.putExtra("key_err_msg", paramAnonymousc.mMessage);
          paramAnonymouse.putStringArrayListExtra("key_response_product_ids", WalletIapUI.c(WalletIapUI.this).Wbb);
          paramAnonymouse.putStringArrayListExtra("key_response_series_ids", WalletIapUI.c(WalletIapUI.this).Wbc);
          paramAnonymouse.putExtra("key_launch_ts", a.WaU);
          WalletIapUI.this.setResult(-1, paramAnonymouse);
          WalletIapUI.this.finish();
          AppMethodBeat.o(71916);
          return;
          WalletIapUI.a(WalletIapUI.this, 1000);
          Log.i("MicroMsg.WalletIapUI", "back to preview UI, reason: consume Success ! ");
        }
      }
    };
    this.MSr = new IListener(f.hfK) {};
    AppMethodBeat.o(71919);
  }
  
  private void bWh()
  {
    AppMethodBeat.i(71928);
    Log.i("MicroMsg.WalletIapUI", "hideLoadingDialog!");
    if ((this.ums != null) && (this.ums.isShowing()))
    {
      this.ums.dismiss();
      this.ums = null;
    }
    AppMethodBeat.o(71928);
  }
  
  private void showLoadingDialog()
  {
    AppMethodBeat.i(71927);
    Log.i("MicroMsg.WalletIapUI", "showLoadingDialog!");
    this.ums = l.c(this, getString(a.i.app_waiting), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(71918);
        Log.i("MicroMsg.WalletIapUI", "showLoadingDialog onCancel currentScene: %d", new Object[] { Integer.valueOf(WalletIapUI.f(WalletIapUI.this)) });
        if (WalletIapUI.f(WalletIapUI.this) == 2) {}
        for (paramAnonymousDialogInterface = com.tencent.mm.plugin.wallet_index.model.c.dA(7, "");; paramAnonymousDialogInterface = com.tencent.mm.plugin.wallet_index.model.c.dA(1, ""))
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
  
  public void finish()
  {
    AppMethodBeat.i(71926);
    Log.i("MicroMsg.WalletIapUI", "finish");
    bWh();
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
      this.WbT = paramIntent.getExtras().get("key_total_fee").toString();
      Log.i("MicroMsg.WalletIapUI", "has payAmount:%s", new Object[] { this.WbT });
    }
    while ((this.WbU != null) && (this.WbU.a(this, paramInt1, paramInt2, paramIntent)))
    {
      Log.d("MicroMsg.WalletIapUI", "onActivityResult handled by mWalletPay.");
      AppMethodBeat.o(71924);
      return;
      Log.i("MicroMsg.WalletIapUI", "no payAmount");
    }
    Log.e("MicroMsg.WalletIapUI", "havn't handle user action");
    paramIntent = new Intent();
    com.tencent.mm.plugin.wallet_index.model.c localc = com.tencent.mm.plugin.wallet_index.model.c.dA(6, "");
    paramIntent.putExtra("key_err_code", localc.mResponse);
    paramIntent.putExtra("key_err_msg", localc.mMessage);
    paramIntent.putExtra("key_launch_ts", a.WaU);
    setResult(-1, paramIntent);
    finish();
    AppMethodBeat.o(71924);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(71920);
    super.onCreate(paramBundle);
    Log.i("MicroMsg.WalletIapUI", "onCreate");
    aw.mM(this);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(422, this);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(414, this);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(1130, this);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(1306, this);
    if (getIntent().getIntExtra("key_action_type", 200001) == 200001) {
      showLoadingDialog();
    }
    this.WbS = getIntent().getBooleanExtra("key_is_mini_program", false);
    if (getIntent().getBooleanExtra("key_request_fullscreen", false)) {
      getWindow().addFlags(1024);
    }
    this.WaT = new c();
    this.WaT.Wbg = this.WbS;
    if ((getIntent().getBooleanExtra("key_force_google", false)) || (z.bBh())) {
      Log.d("MicroMsg.WalletIapUI", "Pay use Google Wallet!");
    }
    for (this.WbU = new a(this, this.WaT, this.WaV);; this.WbU = new g(this.WaT, this.MSr))
    {
      this.WaT.MGo = this.WbU.imm();
      this.WbC.alive();
      AppMethodBeat.o(71920);
      return;
      Log.d("MicroMsg.WalletIapUI", "Pay use WeiXin Wallet!");
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(71923);
    Log.i("MicroMsg.WalletIapUI", "onDestroy");
    bWh();
    if (this.currentState == 1003) {
      this.currentState = 1001;
    }
    String str = "";
    if (getIntent() != null) {
      str = getIntent().getStringExtra("key_appid");
    }
    int i;
    int j;
    if ((this.WbU instanceof g))
    {
      i = 0;
      long l = (Util.getDouble(this.WbT, 0.0D) * 100.0D);
      Log.i("MicroMsg.WalletIapUI", "reportPaymentState report(%s), isMiniProgram : %b, appid %s, walletType %s, currentScene %s, currentState %s, payAmount %s, payamount %s", new Object[] { Integer.valueOf(15751), Boolean.valueOf(this.WbS), str, Integer.valueOf(i), Integer.valueOf(this.DMu), Integer.valueOf(this.currentState), this.WbT, Long.valueOf(l) });
      com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.OAn;
      if (!this.WbS) {
        break label401;
      }
      j = 0;
      label178:
      localh.b(15751, new Object[] { Integer.valueOf(j), str, Integer.valueOf(i), Integer.valueOf(this.DMu), Integer.valueOf(this.currentState), this.WbT, Long.valueOf(l) });
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1044L, this.currentState - 1000, 1L, false);
      if (this.currentState != 1001) {
        break label406;
      }
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1044L, this.DMu + 4, 1L, false);
    }
    for (;;)
    {
      if (this.WbU != null) {
        this.WbU.v(this);
      }
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baD().mCm.b(422, this);
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baD().mCm.b(414, this);
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baD().mCm.b(1130, this);
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baD().mCm.b(1306, this);
      this.WbC.dead();
      super.onDestroy();
      AppMethodBeat.o(71923);
      return;
      i = 1;
      break;
      label401:
      j = 1;
      break label178;
      label406:
      if (this.currentState == 1002) {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1044L, this.DMu + 8, 1L, false);
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
    if (!this.WbR)
    {
      this.WbR = true;
      Object localObject1 = getIntent();
      if (((Intent)localObject1).getIntExtra("key_action_type", 200001) == 200002)
      {
        Log.i("MicroMsg.WalletIapUI", "start to restore the purchase!");
        this.DMu = 3;
        this.WbU.c(this, true);
        AppMethodBeat.o(71921);
        return;
      }
      Log.i("MicroMsg.WalletIapUI", "start to doScene!");
      Object localObject2 = this.WaT;
      String str1 = ((Intent)localObject1).getStringExtra("key_product_id");
      ((c)localObject2).xOk = str1;
      ((c)localObject2).Wbf.add(str1);
      Log.d("MicroMsg.IapData", "prepare pay product: ".concat(String.valueOf(str1)));
      this.WaT.Wah = ((Intent)localObject1).getStringExtra("key_price");
      this.WaT.Wag = ((Intent)localObject1).getStringExtra("key_currency_type");
      localObject2 = ((Intent)localObject1).getStringExtra("key_ext_info");
      this.WaT.mCount = ((Intent)localObject1).getIntExtra("key_count", 1);
      str1 = ((Intent)localObject1).getStringExtra("key_appid");
      String str2 = ((Intent)localObject1).getStringExtra("key_desc");
      String str3 = ((Intent)localObject1).getStringExtra("key_busiid");
      this.WaT.Wbh = ((Intent)localObject1).getStringExtra("key_virtual_pay_sign");
      this.WaT.Wbi = ((Intent)localObject1).getStringExtra("key_attach");
      this.WaT.ryZ = ((Intent)localObject1).getStringExtra("key_extInfo");
      localObject1 = this.WaT.j(this.WbU.imm(), (String)localObject2, str1, str2, str3);
      if (localObject1 != null)
      {
        com.tencent.mm.kernel.h.baF();
        com.tencent.mm.kernel.h.baD().mCm.a((p)localObject1, 0);
        AppMethodBeat.o(71921);
        return;
      }
      Log.e("MicroMsg.WalletIapUI", "getPrepareNetScene error netScene is null");
      this.currentState = 1002;
      localObject1 = com.tencent.mm.plugin.wallet_index.model.c.dA(8, "");
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("key_err_code", ((com.tencent.mm.plugin.wallet_index.model.c)localObject1).mResponse);
      ((Intent)localObject2).putExtra("key_err_msg", ((com.tencent.mm.plugin.wallet_index.model.c)localObject1).mMessage);
      setResult(-1, (Intent)localObject2);
      finish();
    }
    AppMethodBeat.o(71921);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    boolean bool2 = true;
    AppMethodBeat.i(71925);
    Log.i("MicroMsg.WalletIapUI", "onSceneEnd type:" + paramp.getType() + " errCode:" + paramInt2 + ",errMsg:" + paramString);
    paramString = com.tencent.mm.plugin.wallet_index.model.c.dA(paramInt2, paramString);
    paramInt1 = paramString.mResponse;
    paramString = paramString.mMessage;
    paramInt2 = paramp.getType();
    switch (paramInt2)
    {
    default: 
      Log.w("MicroMsg.WalletIapUI", "get a wrong sceneType : ".concat(String.valueOf(paramInt2)));
      AppMethodBeat.o(71925);
      return;
    case 422: 
    case 1130: 
      localc = this.WaT;
      com.tencent.mm.plugin.wallet_index.model.c localc1 = com.tencent.mm.plugin.wallet_index.model.c.dA(paramInt1, paramString);
      paramInt1 = localc1.mResponse;
      if ((paramp instanceof u))
      {
        paramp = (u)paramp;
        if (paramInt1 == 0)
        {
          if (!localc.imn()) {
            break label342;
          }
          paramp = (egt)c.c.b(paramp.rr.otC);
          if (paramp == null) {
            break label328;
          }
          paramString = new dbg();
          paramString.aaGL = paramp.abmc;
          paramString.aaGM = paramp.abmd;
          paramString.hUR = 5;
          paramString.aaGN = paramp.abme;
          Log.d("MicroMsg.NetScenePreparePurchase", "get Sign4TenPay is " + paramp.abme);
          localc.War = paramString;
        }
      }
      for (;;)
      {
        if (localc1.mResponse != 0) {
          break label580;
        }
        Log.i("MicroMsg.WalletIapUI", "Wallet.launchPay");
        this.mRequestCode = this.WbU.a(this, this.WbV);
        this.DMu = 1;
        AppMethodBeat.o(71925);
        return;
        label328:
        Log.e("MicroMsg.NetScenePreparePurchase", "getIapWxPayData fail.");
        paramString = null;
        break;
        label342:
        egt localegt = (egt)c.c.b(paramp.rr.otC);
        if (localegt != null)
        {
          paramString = new dbf();
          paramString.aaoi = paramp.Wag;
          paramString.MQZ = paramp.xOk;
          paramString.price = paramp.Wah;
          paramString.aaGH = localegt.abmb;
          Log.d("MicroMsg.NetScenePreparePurchase", "getIapGoogleData is " + localegt.abmb);
        }
        for (;;)
        {
          localc.Waq = paramString;
          break;
          Log.e("MicroMsg.NetScenePreparePurchase", "getIapGoogleData fail.");
          paramString = null;
        }
        if ((paramp instanceof com.tencent.mm.plugin.wallet_index.model.g))
        {
          paramString = (com.tencent.mm.plugin.wallet_index.model.g)paramp;
          if ((paramInt1 == 0) && (paramString.errCode == 0))
          {
            localc.War = paramString.War;
            localc.Waq = paramString.Waq;
            if (localc.imn())
            {
              if (localc.War != null) {
                localc.WaY = localc.War.aaGH;
              } else {
                Log.e("MicroMsg.IapData", "iapWxPayData is null");
              }
            }
            else if (localc.Waq != null) {
              localc.WaY = localc.Waq.aaGH;
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
    c localc = this.WaT;
    boolean bool1;
    if ((paramp instanceof v))
    {
      paramp = (v)paramp;
      localc.xOk = paramp.xOk;
      localc.Wbd = paramp.xOm;
      localc.Wbe = paramp.Wbe;
      bool1 = paramp.jOM();
    }
    for (;;)
    {
      localc.Wbf.remove(localc.xOk);
      if (bool1)
      {
        Log.i("MicroMsg.IapData", "Verify " + localc.xOk + " OK");
        localc.Wbb.add(localc.xOk);
        localc.Wbc.add(localc.Wbd);
      }
      for (;;)
      {
        for (bool1 = false;; bool1 = bool2)
        {
          if (!this.WaT.Wbf.isEmpty()) {
            break label1239;
          }
          Log.d("MicroMsg.WalletIapUI", "Verify All End... ");
          if (this.WaT.Wbb.isEmpty()) {
            break label1139;
          }
          Log.i("MicroMsg.WalletIapUI", "mResultProductIds size: " + this.WaT.Wbb.size() + ", Consume ...");
          this.WbU.a(this, this.WaT.Wbb, this.WaV, bool1);
          AppMethodBeat.o(71925);
          return;
          if (!(paramp instanceof n)) {
            break label1246;
          }
          paramp = (n)paramp;
          localc.xOk = paramp.productId;
          if (paramp.errCode == 0)
          {
            bool1 = true;
            break;
          }
          bool1 = false;
          break;
          if (!localc.xOk.startsWith("com.tencent.xin.wco")) {
            break label1103;
          }
          if (localc.Wbe <= 0) {
            break label1067;
          }
          localc.Wbb.add(localc.xOk);
          localc.Wbc.add(localc.Wbd);
          Log.i("MicroMsg.IapData", "Verify " + localc.xOk + " fail and cosume");
        }
        label1067:
        Log.i("MicroMsg.IapData", "Verify " + localc.xOk + " fail");
        continue;
        label1103:
        Log.i("MicroMsg.IapData", "Verify " + localc.xOk + " fail");
      }
      label1139:
      Log.i("MicroMsg.WalletIapUI", "back to preview UI, reason: VerifyPurchase fail , errCode: " + paramInt1 + " , errMsg: " + paramString);
      this.currentState = 1002;
      paramp = new Intent();
      paramp.putExtra("key_err_code", paramInt1);
      paramp.putExtra("key_err_msg", paramString);
      paramp.putExtra("key_response_position", 3);
      paramp.putExtra("key_launch_ts", a.WaU);
      setResult(-1, paramp);
      finish();
      label1239:
      AppMethodBeat.o(71925);
      return;
      label1246:
      bool1 = false;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.ui.WalletIapUI
 * JD-Core Version:    0.7.0.1
 */