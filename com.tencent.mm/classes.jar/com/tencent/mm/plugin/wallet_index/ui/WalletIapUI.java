package com.tencent.mm.plugin.wallet_index.ui;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_index.c.e;
import com.tencent.mm.plugin.wallet_index.c.j;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.aqe;
import com.tencent.mm.protocal.c.aqf;
import com.tencent.mm.protocal.c.bfo;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c.r;
import java.util.ArrayList;
import java.util.List;

@com.tencent.mm.ui.base.a(7)
public class WalletIapUI
  extends MMActivity
  implements com.tencent.mm.ah.f
{
  private final int DEFAULT = 1003;
  private final int OK = 1000;
  private Dialog hhG;
  private int kFU = 1003;
  private com.tencent.mm.sdk.b.c mTN = new WalletIapUI.3(this);
  private c qLx;
  private d qLz = new WalletIapUI.2(this);
  private final int qMb = 0;
  private final int qMc = 1;
  private final int qMd = 2;
  private final int qMe = 3;
  private final int qMf = 1001;
  private final int qMg = 1002;
  private boolean qMh = false;
  private int qMi = 0;
  private boolean qMj;
  private String qMk = "0";
  private b qMl;
  private d qMm = new WalletIapUI.1(this);
  
  private void VZ()
  {
    y.i("MicroMsg.WalletIapUI", "showLoadingDialog!");
    this.hhG = com.tencent.mm.wallet_core.ui.g.b(this, getString(a.i.app_waiting), new WalletIapUI.4(this));
  }
  
  private void Wa()
  {
    y.i("MicroMsg.WalletIapUI", "hideLoadingDialog!");
    if ((this.hhG != null) && (this.hhG.isShowing()))
    {
      this.hhG.dismiss();
      this.hhG = null;
    }
  }
  
  public void finish()
  {
    y.i("MicroMsg.WalletIapUI", "finish");
    Wa();
    super.finish();
  }
  
  protected final int getLayoutId()
  {
    return -1;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    y.i("MicroMsg.WalletIapUI", "onActivityResult resultCode : " + paramInt2);
    if ((paramIntent != null) && (paramIntent.getExtras() != null) && (paramIntent.getExtras().get("key_total_fee") != null))
    {
      this.qMk = paramIntent.getExtras().get("key_total_fee").toString();
      y.i("MicroMsg.WalletIapUI", "has payAmount:%s", new Object[] { this.qMk });
    }
    while (this.qMl != null)
    {
      this.qMl.a(this, paramInt1, paramInt2, paramIntent);
      y.d("MicroMsg.WalletIapUI", "onActivityResult handled by mWalletPay.");
      return;
      y.i("MicroMsg.WalletIapUI", "no payAmount");
    }
    y.e("MicroMsg.WalletIapUI", "havn't handle user action");
    paramIntent = new Intent();
    com.tencent.mm.plugin.wallet_index.c.b localb = com.tencent.mm.plugin.wallet_index.c.b.aP(6, "");
    paramIntent.putExtra("key_err_code", localb.ljp);
    paramIntent.putExtra("key_err_msg", localb.ljq);
    paramIntent.putExtra("key_launch_ts", a.qLy);
    setResult(-1, paramIntent);
    finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    y.i("MicroMsg.WalletIapUI", "onCreate");
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DO().dJT.a(422, this);
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DO().dJT.a(414, this);
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DO().dJT.a(1130, this);
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DO().dJT.a(1306, this);
    if (getIntent().getIntExtra("key_action_type", 200001) == 200001) {
      VZ();
    }
    this.qMj = getIntent().getBooleanExtra("key_is_mini_program", false);
    this.qLx = new c();
    this.qLx.qLK = this.qMj;
    if ((getIntent().getBooleanExtra("key_force_google", false)) || (com.tencent.mm.model.q.Gv())) {
      y.d("MicroMsg.WalletIapUI", "Pay use Google Wallet!");
    }
    for (this.qMl = new a(this, this.qLx, this.qLz);; this.qMl = new f(this.qLx, this.mTN))
    {
      this.qLx.mRe = this.qMl.bXz();
      return;
      y.d("MicroMsg.WalletIapUI", "Pay use WeiXin Wallet!");
    }
  }
  
  public void onDestroy()
  {
    y.i("MicroMsg.WalletIapUI", "onDestroy");
    Wa();
    if (this.kFU == 1003) {
      this.kFU = 1001;
    }
    String str = "";
    if (getIntent() != null) {
      str = getIntent().getStringExtra("key_appid");
    }
    int i;
    long l;
    h localh;
    if ((this.qMl instanceof f))
    {
      i = 0;
      l = (bk.getDouble(this.qMk, 0.0D) * 100.0D);
      y.i("MicroMsg.WalletIapUI", "reportPaymentState report(%s), isMiniProgram : %b, appid %s, walletType %s, currentScene %s, currentState %s, payAmount %s, payamount %s", new Object[] { Integer.valueOf(15751), Boolean.valueOf(this.qMj), str, Integer.valueOf(i), Integer.valueOf(this.qMi), Integer.valueOf(this.kFU), this.qMk, Long.valueOf(l) });
      localh = h.nFQ;
      if (!this.qMj) {
        break label334;
      }
    }
    label334:
    for (int j = 0;; j = 1)
    {
      localh.f(15751, new Object[] { Integer.valueOf(j), str, Integer.valueOf(i), Integer.valueOf(this.qMi), Integer.valueOf(this.kFU), this.qMk, Long.valueOf(l) });
      if (this.qMl != null) {
        this.qMl.j(this);
      }
      com.tencent.mm.kernel.g.DQ();
      com.tencent.mm.kernel.g.DO().dJT.b(422, this);
      com.tencent.mm.kernel.g.DQ();
      com.tencent.mm.kernel.g.DO().dJT.b(414, this);
      com.tencent.mm.kernel.g.DQ();
      com.tencent.mm.kernel.g.DO().dJT.b(1130, this);
      com.tencent.mm.kernel.g.DQ();
      com.tencent.mm.kernel.g.DO().dJT.b(1306, this);
      super.onDestroy();
      return;
      i = 1;
      break;
    }
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    y.i("MicroMsg.WalletIapUI", "onNewIntent");
    super.onNewIntent(paramIntent);
  }
  
  public void onResume()
  {
    y.i("MicroMsg.WalletIapUI", "onResume");
    super.onResume();
    y.i("MicroMsg.WalletIapUI", "Handler jump");
    if (!this.qMh)
    {
      this.qMh = true;
      localObject1 = getIntent();
      if (((Intent)localObject1).getIntExtra("key_action_type", 200001) == 200002)
      {
        y.i("MicroMsg.WalletIapUI", "start to restore the purchase!");
        this.qMi = 3;
        this.qMl.c(this, true);
      }
    }
    else
    {
      return;
    }
    Object localObject2 = this.qLx;
    String str1 = ((Intent)localObject1).getStringExtra("key_product_id");
    ((c)localObject2).iZD = str1;
    ((c)localObject2).qLJ.add(str1);
    y.d("MicroMsg.IapData", "prepare pay product: " + str1);
    this.qLx.qLf = ((Intent)localObject1).getStringExtra("key_price");
    this.qLx.qLe = ((Intent)localObject1).getStringExtra("key_currency_type");
    str1 = ((Intent)localObject1).getStringExtra("key_ext_info");
    this.qLx.mCount = ((Intent)localObject1).getIntExtra("key_count", 1);
    String str2 = ((Intent)localObject1).getStringExtra("key_appid");
    String str3 = ((Intent)localObject1).getStringExtra("key_desc");
    String str4 = ((Intent)localObject1).getStringExtra("key_busiid");
    this.qLx.qLL = ((Intent)localObject1).getStringExtra("key_virtual_pay_sign");
    this.qLx.qLM = ((Intent)localObject1).getStringExtra("key_attach");
    com.tencent.mm.kernel.g.DQ();
    localObject2 = com.tencent.mm.kernel.g.DO().dJT;
    Object localObject1 = this.qLx;
    int i = this.qMl.bXz();
    if (((c)localObject1).qLK) {}
    for (localObject1 = new e(i, str2, ((c)localObject1).qLf, str3, ((c)localObject1).mCount, ((c)localObject1).qLe, str4, ((c)localObject1).qLL, ((c)localObject1).qLM);; localObject1 = new com.tencent.mm.wallet_core.c.q(((c)localObject1).iZD, ((c)localObject1).qLf, ((c)localObject1).qLe, ((c)localObject1).mCount, i, str1))
    {
      ((p)localObject2).a((m)localObject1, 0);
      return;
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    c localc1 = null;
    boolean bool = true;
    y.i("MicroMsg.WalletIapUI", "onSceneEnd type:" + paramm.getType() + " errCode:" + paramInt2 + ",errMsg:" + paramString);
    paramString = com.tencent.mm.plugin.wallet_index.c.b.aP(paramInt2, paramString);
    paramInt2 = paramString.ljp;
    paramString = paramString.ljq;
    paramInt1 = paramm.getType();
    switch (paramInt1)
    {
    default: 
      y.w("MicroMsg.WalletIapUI", "get a wrong sceneType : " + paramInt1);
      return;
    case 422: 
    case 1130: 
      c localc2 = this.qLx;
      com.tencent.mm.plugin.wallet_index.c.b localb = com.tencent.mm.plugin.wallet_index.c.b.aP(paramInt2, paramString);
      paramInt1 = localb.ljp;
      if ((paramm instanceof com.tencent.mm.wallet_core.c.q))
      {
        paramm = (com.tencent.mm.wallet_core.c.q)paramm;
        if (paramInt1 == 0)
        {
          if (!localc2.bXA()) {
            break label321;
          }
          paramm = (bfo)paramm.dmK.ecF.ecN;
          if (paramm == null) {
            break label307;
          }
          paramString = new aqf();
          paramString.tmi = paramm.tAl;
          paramString.tmj = paramm.tAm;
          paramString.bUV = 5;
          paramString.tmk = paramm.tAn;
          y.d("MicroMsg.NetScenePreparePurchase", "get Sign4TenPay is " + paramm.tAn);
          localc2.qLl = paramString;
        }
      }
      for (;;)
      {
        if (localb.ljp != 0) {
          break label560;
        }
        this.qMl.a(this, this.qMm);
        this.qMi = 1;
        return;
        label307:
        y.e("MicroMsg.NetScenePreparePurchase", "getIapWxPayData fail.");
        paramString = null;
        break;
        label321:
        bfo localbfo = (bfo)paramm.dmK.ecF.ecN;
        if (localbfo != null)
        {
          paramString = new aqe();
          paramString.taz = paramm.qLe;
          paramString.mSq = paramm.iZD;
          paramString.mQn = paramm.qLf;
          paramString.tme = localbfo.tAk;
          y.d("MicroMsg.NetScenePreparePurchase", "getIapGoogleData is " + localbfo.tAk);
        }
        for (;;)
        {
          localc2.qLk = paramString;
          break;
          y.e("MicroMsg.NetScenePreparePurchase", "getIapGoogleData fail.");
          paramString = localc1;
        }
        if ((paramm instanceof e))
        {
          paramString = (e)paramm;
          if ((paramInt1 == 0) && (paramString.errCode == 0))
          {
            localc2.qLl = paramString.qLl;
            localc2.qLk = paramString.qLk;
            if (localc2.bXA())
            {
              if (localc2.qLl != null) {
                localc2.qLC = localc2.qLl.tme;
              } else {
                y.e("MicroMsg.IapData", "iapWxPayData is null");
              }
            }
            else if (localc2.qLk != null) {
              localc2.qLC = localc2.qLk.tme;
            } else {
              y.e("MicroMsg.IapData", "iapGoogleData is null");
            }
          }
        }
      }
      label560:
      this.kFU = 1002;
      y.i("MicroMsg.WalletIapUI", "back to preview UI, reason: PreparePurchase fail , errCode: " + localb.ljp + " , errMsg: " + localb.ljq);
      paramString = new Intent();
      paramString.putExtra("key_err_code", localb.ljp);
      paramString.putExtra("key_err_msg", localb.ljq);
      paramString.putExtra("key_response_position", 1);
      setResult(-1, paramString);
      finish();
      return;
    }
    localc1 = this.qLx;
    if ((paramm instanceof r))
    {
      paramm = (r)paramm;
      localc1.iZD = paramm.iZD;
      localc1.qLH = paramm.iZF;
      localc1.qLI = paramm.qLI;
      if (paramm.errCode == 0) {
        paramInt1 = 1;
      }
    }
    for (;;)
    {
      localc1.qLJ.remove(localc1.iZD);
      if (paramInt1 != 0)
      {
        y.i("MicroMsg.IapData", "Verify " + localc1.iZD + " OK");
        localc1.qLF.add(localc1.iZD);
        localc1.qLG.add(localc1.qLH);
      }
      for (;;)
      {
        bool = false;
        for (;;)
        {
          if (!this.qLx.qLJ.isEmpty()) {
            break label1033;
          }
          y.d("MicroMsg.WalletIapUI", "Verify All End... ");
          if (this.qLx.qLF.isEmpty()) {
            break label1107;
          }
          y.i("MicroMsg.WalletIapUI", "mResultProductIds size: " + this.qLx.qLF.size() + ", Consume ...");
          this.qMl.a(this, this.qLx.qLF, this.qLz, bool);
          return;
          paramInt1 = 0;
          break;
          if (!(paramm instanceof j)) {
            break label1206;
          }
          paramm = (j)paramm;
          localc1.iZD = paramm.bJd;
          if (paramm.errCode == 0)
          {
            paramInt1 = 1;
            break;
          }
          paramInt1 = 0;
          break;
          if (!localc1.iZD.startsWith("com.tencent.xin.wco")) {
            break label1071;
          }
          if (localc1.qLI <= 0) {
            break label1035;
          }
          localc1.qLF.add(localc1.iZD);
          localc1.qLG.add(localc1.qLH);
          y.i("MicroMsg.IapData", "Verify " + localc1.iZD + " fail and cosume");
        }
        label1033:
        break;
        label1035:
        y.i("MicroMsg.IapData", "Verify " + localc1.iZD + " fail");
        continue;
        label1071:
        y.i("MicroMsg.IapData", "Verify " + localc1.iZD + " fail");
      }
      label1107:
      y.i("MicroMsg.WalletIapUI", "back to preview UI, reason: VerifyPurchase fail , errCode: " + paramInt2 + " , errMsg: " + paramString);
      this.kFU = 1002;
      paramm = new Intent();
      paramm.putExtra("key_err_code", paramInt2);
      paramm.putExtra("key_err_msg", paramString);
      paramm.putExtra("key_response_position", 3);
      paramm.putExtra("key_launch_ts", a.qLy);
      setResult(-1, paramm);
      finish();
      return;
      label1206:
      paramInt1 = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.ui.WalletIapUI
 * JD-Core Version:    0.7.0.1
 */