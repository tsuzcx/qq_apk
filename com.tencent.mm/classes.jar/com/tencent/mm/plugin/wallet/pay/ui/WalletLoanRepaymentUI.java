package com.tencent.mm.plugin.wallet.pay.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.wallet.pay.a.b;
import com.tencent.mm.plugin.wallet_core.c.s;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ad;
import com.tencent.mm.plugin.wallet_core.ui.l;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@com.tencent.mm.ui.base.a(7)
public class WalletLoanRepaymentUI
  extends WalletBaseUI
{
  private String desc;
  private String foR;
  private String mOZ = "CNY";
  private double nyN;
  protected com.tencent.mm.plugin.wallet_core.ui.o qgo;
  private String qmH;
  private String qmI;
  private String qmJ;
  private String qmK;
  private String qmL;
  private String qmM;
  private String qmN;
  private String qmO;
  private int qmP;
  private String token;
  
  private void Qk(String paramString)
  {
    a(new b(paramString), true, false);
  }
  
  private void a(Bankcard paramBankcard, double paramDouble, String paramString)
  {
    WalletLoanRepaymentUI.1 local1 = new WalletLoanRepaymentUI.1(this);
    WalletLoanRepaymentUI.2 local2 = new WalletLoanRepaymentUI.2(this);
    WalletLoanRepaymentUI.3 local3 = new WalletLoanRepaymentUI.3(this);
    this.qmO = paramBankcard.field_bindSerial;
    this.qgo = com.tencent.mm.plugin.wallet_core.ui.o.a(this, this.desc, paramDouble, paramString, paramBankcard, local1, local2, local3);
  }
  
  private void bUa()
  {
    y.i("MicroMsg.WalletLoanRepaymentUI", "to change a bankcard");
    startActivityForResult(new Intent(this, WalletChangeLoanRepayBankcardUI.class), 1);
  }
  
  protected final void bUb()
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("key_bind_scene", 8);
    localBundle.putBoolean("key_need_bind_response", true);
    localBundle.putString("kreq_token", this.token);
    com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet.loan.a.class, localBundle, new WalletLoanRepaymentUI.6(this));
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramm instanceof com.tencent.mm.plugin.wallet_core.c.a))
      {
        f.Xf(((com.tencent.mm.plugin.wallet_core.c.a)paramm).bUH());
        this.token = ((com.tencent.mm.plugin.wallet_core.c.a)paramm).getToken();
        Qk(this.token);
        return true;
      }
      if ((paramm instanceof b))
      {
        paramString = (b)paramm;
        this.mOZ = paramString.mOZ;
        this.nyN = paramString.nyN;
        this.desc = paramString.desc;
        paramString = com.tencent.mm.plugin.wallet_core.model.o.bVt();
        if (paramString.bVD())
        {
          paramString = paramString.bVE();
          if ((paramString != null) && (bk.bl(paramString.field_forbidWord))) {
            a(paramString, this.nyN, this.mOZ);
          }
        }
        for (;;)
        {
          return true;
          bUa();
          continue;
          h.a(this, getResources().getString(a.i.wallet_loan_repayment_new_card_tip), "", getString(a.i.wallet_pay_bankcard_add), getString(a.i.app_cancel), new WalletLoanRepaymentUI.4(this), new WalletLoanRepaymentUI.5(this));
        }
      }
      if ((paramm instanceof s))
      {
        paramString = (s)paramm;
        if (paramString.bUI())
        {
          y.i("MicroMsg.WalletLoanRepaymentUI", "need free sms");
          paramm = new Bundle();
          paramm.putString("key_pwd1", this.foR);
          paramm.putString("key_jsapi_token", this.token);
          paramm.putString("key_relation_key", paramString.qqV);
          paramm.putInt("key_verify_scene", 8);
          paramm.putString("key_mobile", paramString.qqU);
          com.tencent.mm.wallet_core.a.a(this, l.class, paramm);
        }
        for (;;)
        {
          return true;
          paramm = new Intent();
          paramm.putExtra("token", paramString.qqS);
          paramm.putExtra("bind_serial", this.qmO);
          setResult(-1, paramm);
          finish();
        }
      }
    }
    return false;
  }
  
  protected final int getForceOrientation()
  {
    return 1;
  }
  
  protected final int getLayoutId()
  {
    return -1;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1)
    {
      if (paramInt2 == -1)
      {
        paramInt1 = paramIntent.getIntExtra("ret", -1000);
        if (paramInt1 == -1003)
        {
          y.i("MicroMsg.WalletLoanRepaymentUI", "to bind a new card");
          bUb();
          return;
        }
        if (paramInt1 == 0)
        {
          y.i("MicroMsg.WalletLoanRepaymentUI", "change card ok");
          paramIntent = com.tencent.mm.plugin.wallet_core.model.o.bVt().Qs(paramIntent.getStringExtra("bindSerial"));
          if (paramIntent == null)
          {
            y.e("MicroMsg.WalletLoanRepaymentUI", "bankcard is null by getBankcardBySerialNo");
            finish();
            return;
          }
          a(paramIntent, this.nyN, this.mOZ);
          return;
        }
        y.e("MicroMsg.WalletLoanRepaymentUI", "activity return unknow error");
        return;
      }
      paramIntent = com.tencent.mm.plugin.wallet_core.model.o.bVt();
      if (paramIntent.bVD())
      {
        paramIntent = paramIntent.bVE();
        if ((paramIntent != null) && (bk.bl(paramIntent.field_forbidWord)))
        {
          a(paramIntent, this.nyN, this.mOZ);
          return;
        }
        finish();
        return;
      }
      y.e("MicroMsg.WalletLoanRepaymentUI", "onActivityResult hasRepaymentBankcard is false");
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getIntent();
    this.qmM = paramBundle.getStringExtra("appId");
    this.qmH = paramBundle.getStringExtra("timeStamp");
    this.qmI = paramBundle.getStringExtra("nonceStr");
    this.qmJ = paramBundle.getStringExtra("packageExt");
    this.qmK = paramBundle.getStringExtra("signtype");
    this.qmL = paramBundle.getStringExtra("paySignature");
    this.qmN = paramBundle.getStringExtra("url");
    this.qmP = paramBundle.getIntExtra("pay_channel", 0);
    kh(580);
    a(new com.tencent.mm.plugin.wallet_core.c.a(this.qmM, this.qmH, this.qmI, this.qmJ, this.qmK, this.qmL, this.qmN, 7, "getWebPayCheckoutCounterRequst", this.qmP), true, false);
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    Object localObject = paramIntent.getExtras();
    y.i("MicroMsg.WalletLoanRepaymentUI", "onNewIntent");
    if (((Bundle)localObject).containsKey("intent_bind_end"))
    {
      y.i("MicroMsg.WalletLoanRepaymentUI", "back from bind card");
      Qk(this.token);
      return;
    }
    if (((Bundle)localObject).containsKey("jsapi_verifycode_process_end"))
    {
      y.i("MicroMsg.WalletLoanRepaymentUI", "back from verify code");
      localObject = new Intent();
      ((Intent)localObject).putExtra("token", paramIntent.getStringExtra("token"));
      ((Intent)localObject).putExtra("bind_serial", this.qmO);
      setResult(-1, (Intent)localObject);
      finish();
      return;
    }
    y.i("MicroMsg.WalletLoanRepaymentUI", "need to deal with,finish");
    finish();
  }
  
  public void onResume()
  {
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.WalletLoanRepaymentUI
 * JD-Core Version:    0.7.0.1
 */