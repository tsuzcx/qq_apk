package com.tencent.mm.plugin.wallet.pay.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet.pay.a.c;
import com.tencent.mm.plugin.wallet_core.c.d;
import com.tencent.mm.plugin.wallet_core.c.v;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.aj;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.ui.n;
import com.tencent.mm.plugin.wallet_core.ui.q;
import com.tencent.mm.pluginsdk.wallet.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@com.tencent.mm.ui.base.a(7)
public class WalletLoanRepaymentUI
  extends WalletBaseUI
{
  private String desc;
  private String gGl;
  private String ppp = "CNY";
  private double qjN;
  protected q tVM;
  private String tVY;
  private String tVZ;
  private String tWa;
  private String tWb;
  private String tWc;
  private String tWd;
  private String tWe;
  private String tWf;
  private int tWg;
  private String token;
  
  private void a(Bankcard paramBankcard, double paramDouble, String paramString)
  {
    AppMethodBeat.i(46001);
    WalletLoanRepaymentUI.1 local1 = new WalletLoanRepaymentUI.1(this);
    WalletLoanRepaymentUI.2 local2 = new WalletLoanRepaymentUI.2(this);
    WalletLoanRepaymentUI.3 local3 = new WalletLoanRepaymentUI.3(this);
    this.tWf = paramBankcard.field_bindSerial;
    this.tVM = q.a(this, this.desc, paramDouble, paramString, paramBankcard, local1, local2, local3);
    AppMethodBeat.o(46001);
  }
  
  private void afc(String paramString)
  {
    AppMethodBeat.i(45999);
    doSceneProgress(new c(paramString), true);
    AppMethodBeat.o(45999);
  }
  
  private void cRU()
  {
    AppMethodBeat.i(46002);
    ab.i("MicroMsg.WalletLoanRepaymentUI", "to change a bankcard");
    startActivityForResult(new Intent(this, WalletChangeLoanRepayBankcardUI.class), 1);
    AppMethodBeat.o(46002);
  }
  
  protected final void cRV()
  {
    AppMethodBeat.i(46003);
    Bundle localBundle = new Bundle();
    localBundle.putInt("key_bind_scene", 8);
    localBundle.putBoolean("key_need_bind_response", true);
    localBundle.putString("kreq_token", this.token);
    com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet.loan.a.class, localBundle, new WalletLoanRepaymentUI.6(this));
    AppMethodBeat.o(46003);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(46005);
    if (paramInt1 == 1)
    {
      if (paramInt2 == -1)
      {
        paramInt1 = paramIntent.getIntExtra("ret", -1000);
        if (paramInt1 == -1003)
        {
          ab.i("MicroMsg.WalletLoanRepaymentUI", "to bind a new card");
          cRV();
          AppMethodBeat.o(46005);
          return;
        }
        if (paramInt1 == 0)
        {
          ab.i("MicroMsg.WalletLoanRepaymentUI", "change card ok");
          paramIntent = t.cTO().afk(paramIntent.getStringExtra("bindSerial"));
          if (paramIntent == null)
          {
            ab.e("MicroMsg.WalletLoanRepaymentUI", "bankcard is null by getBankcardBySerialNo");
            finish();
            AppMethodBeat.o(46005);
            return;
          }
          a(paramIntent, this.qjN, this.ppp);
          AppMethodBeat.o(46005);
          return;
        }
        ab.e("MicroMsg.WalletLoanRepaymentUI", "activity return unknow error");
        AppMethodBeat.o(46005);
        return;
      }
      paramIntent = t.cTO();
      if (paramIntent.cTZ())
      {
        paramIntent = paramIntent.cUa();
        if ((paramIntent != null) && (bo.isNullOrNil(paramIntent.field_forbidWord)))
        {
          a(paramIntent, this.qjN, this.ppp);
          AppMethodBeat.o(46005);
          return;
        }
        finish();
        AppMethodBeat.o(46005);
        return;
      }
      ab.e("MicroMsg.WalletLoanRepaymentUI", "onActivityResult hasRepaymentBankcard is false");
      AppMethodBeat.o(46005);
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(46005);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(45997);
    super.onCreate(paramBundle);
    paramBundle = getIntent();
    this.tWd = paramBundle.getStringExtra("appId");
    this.tVY = paramBundle.getStringExtra("timeStamp");
    this.tVZ = paramBundle.getStringExtra("nonceStr");
    this.tWa = paramBundle.getStringExtra("packageExt");
    this.tWb = paramBundle.getStringExtra("signtype");
    this.tWc = paramBundle.getStringExtra("paySignature");
    this.tWe = paramBundle.getStringExtra("url");
    this.tWg = paramBundle.getIntExtra("pay_channel", 0);
    addSceneEndListener(580);
    doSceneForceProgress(new d(this.tWd, this.tVY, this.tVZ, this.tWa, this.tWb, this.tWc, this.tWe, 7, "getWebPayCheckoutCounterRequst", this.tWg));
    AppMethodBeat.o(45997);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(46004);
    Object localObject = paramIntent.getExtras();
    ab.i("MicroMsg.WalletLoanRepaymentUI", "onNewIntent");
    if (((Bundle)localObject).containsKey("intent_bind_end"))
    {
      ab.i("MicroMsg.WalletLoanRepaymentUI", "back from bind card");
      afc(this.token);
      AppMethodBeat.o(46004);
      return;
    }
    if (((Bundle)localObject).containsKey("jsapi_verifycode_process_end"))
    {
      ab.i("MicroMsg.WalletLoanRepaymentUI", "back from verify code");
      localObject = new Intent();
      ((Intent)localObject).putExtra("token", paramIntent.getStringExtra("token"));
      ((Intent)localObject).putExtra("bind_serial", this.tWf);
      setResult(-1, (Intent)localObject);
      finish();
      AppMethodBeat.o(46004);
      return;
    }
    ab.i("MicroMsg.WalletLoanRepaymentUI", "need to deal with,finish");
    finish();
    AppMethodBeat.o(46004);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(45998);
    super.onResume();
    AppMethodBeat.o(45998);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(46000);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramm instanceof d))
      {
        g.ana(((d)paramm).cSW());
        this.token = ((d)paramm).getToken();
        afc(this.token);
        AppMethodBeat.o(46000);
        return true;
      }
      if ((paramm instanceof c))
      {
        paramString = (c)paramm;
        this.ppp = paramString.ppp;
        this.qjN = paramString.qjN;
        this.desc = paramString.desc;
        paramString = t.cTO();
        if (paramString.cTZ())
        {
          paramString = paramString.cUa();
          if ((paramString != null) && (bo.isNullOrNil(paramString.field_forbidWord))) {
            a(paramString, this.qjN, this.ppp);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(46000);
          return true;
          cRU();
          continue;
          h.d(this, getResources().getString(2131305147), "", getString(2131305446), getString(2131296888), new WalletLoanRepaymentUI.4(this), new WalletLoanRepaymentUI.5(this));
        }
      }
      if ((paramm instanceof v))
      {
        paramString = (v)paramm;
        if (paramString.cSX())
        {
          ab.i("MicroMsg.WalletLoanRepaymentUI", "need free sms");
          paramm = new Bundle();
          paramm.putString("key_pwd1", this.gGl);
          paramm.putString("key_jsapi_token", this.token);
          paramm.putString("key_relation_key", paramString.ubR);
          paramm.putInt("key_verify_scene", 8);
          paramm.putString("key_mobile", paramString.ubQ);
          com.tencent.mm.wallet_core.a.a(this, n.class, paramm);
        }
        for (;;)
        {
          AppMethodBeat.o(46000);
          return true;
          paramm = new Intent();
          paramm.putExtra("token", paramString.ubO);
          paramm.putExtra("bind_serial", this.tWf);
          setResult(-1, paramm);
          finish();
        }
      }
    }
    AppMethodBeat.o(46000);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.WalletLoanRepaymentUI
 * JD-Core Version:    0.7.0.1
 */