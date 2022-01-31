package com.tencent.mm.plugin.wallet_index.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_index.c.k;
import com.tencent.mm.protocal.protobuf.awd;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.bnp;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.af;
import com.tencent.mm.wallet_core.c.s;
import com.tencent.mm.wallet_core.c.t;
import java.util.ArrayList;
import java.util.List;

@com.tencent.mm.ui.base.a(7)
public class WalletIapUI
  extends MMActivity
  implements com.tencent.mm.ai.f
{
  private final int DEFAULT;
  private final int OK;
  private int cun;
  private int currentState;
  private Dialog iTk;
  private com.tencent.mm.sdk.b.c pvT;
  private c uAt;
  private d uAv;
  private com.tencent.mm.sdk.b.c uBa;
  private final int uBh;
  private final int uBi;
  private final int uBj;
  private final int uBk;
  private final int uBl;
  private final int uBm;
  private final int uBn;
  private boolean uBo;
  private int uBp;
  private boolean uBq;
  private String uBr;
  private b uBs;
  private d uBt;
  
  public WalletIapUI()
  {
    AppMethodBeat.i(48278);
    this.uBh = 4;
    this.uBi = 0;
    this.uBj = 1;
    this.uBk = 2;
    this.uBl = 3;
    this.OK = 1000;
    this.uBm = 1001;
    this.uBn = 1002;
    this.DEFAULT = 1003;
    this.uBo = false;
    this.uBp = 0;
    this.currentState = 1003;
    this.uBr = "0";
    this.cun = 0;
    this.uBa = new WalletIapUI.1(this);
    this.uBt = new WalletIapUI.2(this);
    this.uAv = new d()
    {
      public final void a(com.tencent.mm.plugin.wallet_index.c.b paramAnonymousb, com.tencent.mm.plugin.wallet_index.b.a.c paramAnonymousc)
      {
        AppMethodBeat.i(48274);
        ab.d("MicroMsg.WalletIapUI", "Consume finished: " + paramAnonymousb + ", purchase: " + paramAnonymousc);
        if (paramAnonymousb.cXe())
        {
          WalletIapUI.a(WalletIapUI.this, 1002);
          ab.d("MicroMsg.WalletIapUI", "back to preview UI, reason: consume Fail ! ");
        }
        for (;;)
        {
          paramAnonymousc = new Intent();
          paramAnonymousc.putExtra("key_err_code", paramAnonymousb.nGE);
          paramAnonymousc.putExtra("key_err_msg", paramAnonymousb.nGF);
          paramAnonymousc.putStringArrayListExtra("key_response_product_ids", WalletIapUI.d(WalletIapUI.this).uAB);
          paramAnonymousc.putStringArrayListExtra("key_response_series_ids", WalletIapUI.d(WalletIapUI.this).uAC);
          paramAnonymousc.putExtra("key_launch_ts", a.uAu);
          WalletIapUI.this.setResult(-1, paramAnonymousc);
          WalletIapUI.this.finish();
          AppMethodBeat.o(48274);
          return;
          WalletIapUI.a(WalletIapUI.this, 1000);
          ab.d("MicroMsg.WalletIapUI", "back to preview UI, reason: consume Success ! ");
        }
      }
    };
    this.pvT = new WalletIapUI.4(this);
    AppMethodBeat.o(48278);
  }
  
  private void apy()
  {
    AppMethodBeat.i(48286);
    ab.i("MicroMsg.WalletIapUI", "showLoadingDialog!");
    this.iTk = com.tencent.mm.wallet_core.ui.g.a(this, getString(2131297112), new WalletIapUI.5(this));
    AppMethodBeat.o(48286);
  }
  
  private void apz()
  {
    AppMethodBeat.i(48287);
    ab.i("MicroMsg.WalletIapUI", "hideLoadingDialog!");
    if ((this.iTk != null) && (this.iTk.isShowing()))
    {
      this.iTk.dismiss();
      this.iTk = null;
    }
    AppMethodBeat.o(48287);
  }
  
  public void finish()
  {
    AppMethodBeat.i(48285);
    ab.i("MicroMsg.WalletIapUI", "finish");
    apz();
    super.finish();
    AppMethodBeat.o(48285);
  }
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(48283);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ab.i("MicroMsg.WalletIapUI", "onActivityResult resultCode : ".concat(String.valueOf(paramInt2)));
    if ((paramIntent != null) && (paramIntent.getExtras() != null) && (paramIntent.getExtras().get("key_total_fee") != null))
    {
      this.uBr = paramIntent.getExtras().get("key_total_fee").toString();
      ab.i("MicroMsg.WalletIapUI", "has payAmount:%s", new Object[] { this.uBr });
    }
    while (this.uBs != null)
    {
      this.uBs.a(this, paramInt1, paramInt2, paramIntent);
      ab.d("MicroMsg.WalletIapUI", "onActivityResult handled by mWalletPay.");
      AppMethodBeat.o(48283);
      return;
      ab.i("MicroMsg.WalletIapUI", "no payAmount");
    }
    ab.e("MicroMsg.WalletIapUI", "havn't handle user action");
    paramIntent = new Intent();
    com.tencent.mm.plugin.wallet_index.c.b localb = com.tencent.mm.plugin.wallet_index.c.b.bu(6, "");
    paramIntent.putExtra("key_err_code", localb.nGE);
    paramIntent.putExtra("key_err_msg", localb.nGF);
    paramIntent.putExtra("key_launch_ts", a.uAu);
    setResult(-1, paramIntent);
    finish();
    AppMethodBeat.o(48283);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(48279);
    super.onCreate(paramBundle);
    ab.i("MicroMsg.WalletIapUI", "onCreate");
    af.hR(this);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().eHt.a(422, this);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().eHt.a(414, this);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().eHt.a(1130, this);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().eHt.a(1306, this);
    if (getIntent().getIntExtra("key_action_type", 200001) == 200001) {
      apy();
    }
    this.uBq = getIntent().getBooleanExtra("key_is_mini_program", false);
    if (getIntent().getBooleanExtra("key_request_fullscreen", false)) {
      getWindow().addFlags(1024);
    }
    this.uAt = new c();
    this.uAt.uAG = this.uBq;
    if ((getIntent().getBooleanExtra("key_force_google", false)) || (r.ZA())) {
      ab.d("MicroMsg.WalletIapUI", "Pay use Google Wallet!");
    }
    for (this.uBs = new a(this, this.uAt, this.uAv);; this.uBs = new f(this.uAt, this.pvT))
    {
      this.uAt.prr = this.uBs.cXf();
      com.tencent.mm.sdk.b.a.ymk.c(this.uBa);
      AppMethodBeat.o(48279);
      return;
      ab.d("MicroMsg.WalletIapUI", "Pay use WeiXin Wallet!");
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(48282);
    ab.i("MicroMsg.WalletIapUI", "onDestroy");
    apz();
    if (this.currentState == 1003) {
      this.currentState = 1001;
    }
    String str = "";
    if (getIntent() != null) {
      str = getIntent().getStringExtra("key_appid");
    }
    int i;
    int j;
    if ((this.uBs instanceof f))
    {
      i = 0;
      long l = (bo.getDouble(this.uBr, 0.0D) * 100.0D);
      ab.i("MicroMsg.WalletIapUI", "reportPaymentState report(%s), isMiniProgram : %b, appid %s, walletType %s, currentScene %s, currentState %s, payAmount %s, payamount %s", new Object[] { Integer.valueOf(15751), Boolean.valueOf(this.uBq), str, Integer.valueOf(i), Integer.valueOf(this.uBp), Integer.valueOf(this.currentState), this.uBr, Long.valueOf(l) });
      h localh = h.qsU;
      if (!this.uBq) {
        break label405;
      }
      j = 0;
      label178:
      localh.e(15751, new Object[] { Integer.valueOf(j), str, Integer.valueOf(i), Integer.valueOf(this.uBp), Integer.valueOf(this.currentState), this.uBr, Long.valueOf(l) });
      h.qsU.idkeyStat(1044L, this.currentState - 1000, 1L, false);
      if (this.currentState != 1001) {
        break label410;
      }
      h.qsU.idkeyStat(1044L, this.uBp + 4, 1L, false);
    }
    for (;;)
    {
      if (this.uBs != null) {
        this.uBs.l(this);
      }
      com.tencent.mm.kernel.g.RM();
      com.tencent.mm.kernel.g.RK().eHt.b(422, this);
      com.tencent.mm.kernel.g.RM();
      com.tencent.mm.kernel.g.RK().eHt.b(414, this);
      com.tencent.mm.kernel.g.RM();
      com.tencent.mm.kernel.g.RK().eHt.b(1130, this);
      com.tencent.mm.kernel.g.RM();
      com.tencent.mm.kernel.g.RK().eHt.b(1306, this);
      com.tencent.mm.sdk.b.a.ymk.d(this.uBa);
      super.onDestroy();
      AppMethodBeat.o(48282);
      return;
      i = 1;
      break;
      label405:
      j = 1;
      break label178;
      label410:
      if (this.currentState == 1002) {
        h.qsU.idkeyStat(1044L, this.uBp + 8, 1L, false);
      }
    }
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(48281);
    ab.i("MicroMsg.WalletIapUI", "onNewIntent");
    super.onNewIntent(paramIntent);
    AppMethodBeat.o(48281);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(48280);
    ab.i("MicroMsg.WalletIapUI", "onResume");
    super.onResume();
    ab.i("MicroMsg.WalletIapUI", "Handler jump");
    Object localObject2;
    String str1;
    String str2;
    String str3;
    String str4;
    int i;
    if (!this.uBo)
    {
      this.uBo = true;
      localObject1 = getIntent();
      if (((Intent)localObject1).getIntExtra("key_action_type", 200001) == 200002)
      {
        ab.i("MicroMsg.WalletIapUI", "start to restore the purchase!");
        this.uBp = 3;
        this.uBs.b(this, true);
        AppMethodBeat.o(48280);
        return;
      }
      localObject2 = this.uAt;
      str1 = ((Intent)localObject1).getStringExtra("key_product_id");
      ((c)localObject2).liu = str1;
      ((c)localObject2).uAF.add(str1);
      ab.d("MicroMsg.IapData", "prepare pay product: ".concat(String.valueOf(str1)));
      this.uAt.uAb = ((Intent)localObject1).getStringExtra("key_price");
      this.uAt.uAa = ((Intent)localObject1).getStringExtra("key_currency_type");
      str1 = ((Intent)localObject1).getStringExtra("key_ext_info");
      this.uAt.mCount = ((Intent)localObject1).getIntExtra("key_count", 1);
      str2 = ((Intent)localObject1).getStringExtra("key_appid");
      str3 = ((Intent)localObject1).getStringExtra("key_desc");
      str4 = ((Intent)localObject1).getStringExtra("key_busiid");
      this.uAt.uAH = ((Intent)localObject1).getStringExtra("key_virtual_pay_sign");
      this.uAt.uAI = ((Intent)localObject1).getStringExtra("key_attach");
      com.tencent.mm.kernel.g.RM();
      localObject2 = com.tencent.mm.kernel.g.RK().eHt;
      localObject1 = this.uAt;
      i = this.uBs.cXf();
      if (!((c)localObject1).uAG) {
        break label328;
      }
    }
    label328:
    for (Object localObject1 = new com.tencent.mm.plugin.wallet_index.c.f(i, str2, ((c)localObject1).uAb, str3, ((c)localObject1).mCount, ((c)localObject1).uAa, str4, ((c)localObject1).uAH, ((c)localObject1).uAI);; localObject1 = new s(((c)localObject1).liu, ((c)localObject1).uAb, ((c)localObject1).uAa, ((c)localObject1).mCount, i, str1))
    {
      ((p)localObject2).a((m)localObject1, 0);
      AppMethodBeat.o(48280);
      return;
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    boolean bool = true;
    AppMethodBeat.i(48284);
    ab.i("MicroMsg.WalletIapUI", "onSceneEnd type:" + paramm.getType() + " errCode:" + paramInt2 + ",errMsg:" + paramString);
    paramString = com.tencent.mm.plugin.wallet_index.c.b.bu(paramInt2, paramString);
    paramInt2 = paramString.nGE;
    paramString = paramString.nGF;
    paramInt1 = paramm.getType();
    switch (paramInt1)
    {
    default: 
      ab.w("MicroMsg.WalletIapUI", "get a wrong sceneType : ".concat(String.valueOf(paramInt1)));
      AppMethodBeat.o(48284);
      return;
    case 422: 
    case 1130: 
      localc = this.uAt;
      com.tencent.mm.plugin.wallet_index.c.b localb = com.tencent.mm.plugin.wallet_index.c.b.bu(paramInt2, paramString);
      paramInt1 = localb.nGE;
      if ((paramm instanceof s))
      {
        paramm = (s)paramm;
        if (paramInt1 == 0)
        {
          if (!localc.cXg()) {
            break label334;
          }
          paramm = (bnp)paramm.rr.fsW.fta;
          if (paramm == null) {
            break label320;
          }
          paramString = new awe();
          paramString.xlB = paramm.xBO;
          paramString.xlC = paramm.xBP;
          paramString.cCD = 5;
          paramString.xlD = paramm.xBQ;
          ab.d("MicroMsg.NetScenePreparePurchase", "get Sign4TenPay is " + paramm.xBQ);
          localc.uAi = paramString;
        }
      }
      for (;;)
      {
        if (localb.nGE != 0) {
          break label572;
        }
        this.cun = this.uBs.a(this, this.uBt);
        this.uBp = 1;
        AppMethodBeat.o(48284);
        return;
        label320:
        ab.e("MicroMsg.NetScenePreparePurchase", "getIapWxPayData fail.");
        paramString = null;
        break;
        label334:
        bnp localbnp = (bnp)paramm.rr.fsW.fta;
        if (localbnp != null)
        {
          paramString = new awd();
          paramString.wYP = paramm.uAa;
          paramString.puw = paramm.liu;
          paramString.pqC = paramm.uAb;
          paramString.xlx = localbnp.xBN;
          ab.d("MicroMsg.NetScenePreparePurchase", "getIapGoogleData is " + localbnp.xBN);
        }
        for (;;)
        {
          localc.uAh = paramString;
          break;
          ab.e("MicroMsg.NetScenePreparePurchase", "getIapGoogleData fail.");
          paramString = null;
        }
        if ((paramm instanceof com.tencent.mm.plugin.wallet_index.c.f))
        {
          paramString = (com.tencent.mm.plugin.wallet_index.c.f)paramm;
          if ((paramInt1 == 0) && (paramString.errCode == 0))
          {
            localc.uAi = paramString.uAi;
            localc.uAh = paramString.uAh;
            if (localc.cXg())
            {
              if (localc.uAi != null) {
                localc.uAy = localc.uAi.xlx;
              } else {
                ab.e("MicroMsg.IapData", "iapWxPayData is null");
              }
            }
            else if (localc.uAh != null) {
              localc.uAy = localc.uAh.xlx;
            } else {
              ab.e("MicroMsg.IapData", "iapGoogleData is null");
            }
          }
        }
      }
      label572:
      this.currentState = 1002;
      ab.i("MicroMsg.WalletIapUI", "back to preview UI, reason: PreparePurchase fail , errCode: " + localb.nGE + " , errMsg: " + localb.nGF);
      paramString = new Intent();
      paramString.putExtra("key_err_code", localb.nGE);
      paramString.putExtra("key_err_msg", localb.nGF);
      paramString.putExtra("key_response_position", 1);
      setResult(-1, paramString);
      finish();
      AppMethodBeat.o(48284);
      return;
    }
    c localc = this.uAt;
    if ((paramm instanceof t))
    {
      paramm = (t)paramm;
      localc.liu = paramm.liu;
      localc.uAD = paramm.liw;
      localc.uAE = paramm.uAE;
      if (paramm.errCode == 0) {
        paramInt1 = 1;
      }
    }
    for (;;)
    {
      localc.uAF.remove(localc.liu);
      if (paramInt1 != 0)
      {
        ab.i("MicroMsg.IapData", "Verify " + localc.liu + " OK");
        localc.uAB.add(localc.liu);
        localc.uAC.add(localc.uAD);
      }
      for (;;)
      {
        bool = false;
        for (;;)
        {
          if (!this.uAt.uAF.isEmpty()) {
            break label1230;
          }
          ab.d("MicroMsg.WalletIapUI", "Verify All End... ");
          if (this.uAt.uAB.isEmpty()) {
            break label1131;
          }
          ab.i("MicroMsg.WalletIapUI", "mResultProductIds size: " + this.uAt.uAB.size() + ", Consume ...");
          this.uBs.a(this, this.uAt.uAB, this.uAv, bool);
          AppMethodBeat.o(48284);
          return;
          paramInt1 = 0;
          break;
          if (!(paramm instanceof k)) {
            break label1237;
          }
          paramm = (k)paramm;
          localc.liu = paramm.cqx;
          if (paramm.errCode == 0)
          {
            paramInt1 = 1;
            break;
          }
          paramInt1 = 0;
          break;
          if (!localc.liu.startsWith("com.tencent.xin.wco")) {
            break label1095;
          }
          if (localc.uAE <= 0) {
            break label1059;
          }
          localc.uAB.add(localc.liu);
          localc.uAC.add(localc.uAD);
          ab.i("MicroMsg.IapData", "Verify " + localc.liu + " fail and cosume");
        }
        label1059:
        ab.i("MicroMsg.IapData", "Verify " + localc.liu + " fail");
        continue;
        label1095:
        ab.i("MicroMsg.IapData", "Verify " + localc.liu + " fail");
      }
      label1131:
      ab.i("MicroMsg.WalletIapUI", "back to preview UI, reason: VerifyPurchase fail , errCode: " + paramInt2 + " , errMsg: " + paramString);
      this.currentState = 1002;
      paramm = new Intent();
      paramm.putExtra("key_err_code", paramInt2);
      paramm.putExtra("key_err_msg", paramString);
      paramm.putExtra("key_response_position", 3);
      paramm.putExtra("key_launch_ts", a.uAu);
      setResult(-1, paramm);
      finish();
      label1230:
      AppMethodBeat.o(48284);
      return;
      label1237:
      paramInt1 = 0;
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