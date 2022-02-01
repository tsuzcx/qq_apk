package com.tencent.mm.plugin.wallet.pay.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.ng;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.wallet.pay.a.c;
import com.tencent.mm.plugin.wallet_core.c.d;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.aj;
import com.tencent.mm.plugin.wallet_core.ui.r;
import com.tencent.mm.plugin.wallet_core.ui.u.c;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.e;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.b;
import com.tencent.mm.wallet_core.e.a;
import com.tencent.mm.wallet_core.model.aa;
import com.tencent.mm.wallet_core.model.ac;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@com.tencent.mm.ui.base.a(7)
public class WalletLoanRepaymentUI
  extends WalletBaseUI
{
  private String MEq;
  private IListener<ng> Myr;
  private double OjO;
  private int VnA;
  protected com.tencent.mm.plugin.wallet_core.ui.u Vnf;
  private String Vns;
  private String Vnt;
  private String Vnu;
  private String Vnv;
  private String Vnw;
  private String Vnx;
  private String Vny;
  private String Vnz;
  private String desc;
  private String qdg;
  private String token;
  
  public WalletLoanRepaymentUI()
  {
    AppMethodBeat.i(69347);
    this.MEq = "CNY";
    this.Myr = new IListener(f.hfK) {};
    AppMethodBeat.o(69347);
  }
  
  private void a(final Bankcard paramBankcard, double paramDouble, String paramString)
  {
    AppMethodBeat.i(69353);
    u.c local1 = new u.c()
    {
      public final void a(String paramAnonymousString, FavorPayInfo paramAnonymousFavorPayInfo, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(69340);
        WalletLoanRepaymentUI.a(WalletLoanRepaymentUI.this, paramAnonymousString);
        WalletLoanRepaymentUI.this.doSceneProgress(new y(WalletLoanRepaymentUI.a(WalletLoanRepaymentUI.this), WalletLoanRepaymentUI.b(WalletLoanRepaymentUI.this), (byte)0));
        AppMethodBeat.o(69340);
      }
    };
    com.tencent.mm.wallet_core.ui.k local2 = new com.tencent.mm.wallet_core.ui.k()
    {
      public final void dr(View paramAnonymousView)
      {
        AppMethodBeat.i(315517);
        WalletLoanRepaymentUI.b(WalletLoanRepaymentUI.this, paramBankcard.field_bindSerial);
        if (WalletLoanRepaymentUI.this.Vnf != null) {
          WalletLoanRepaymentUI.this.Vnf.dismiss();
        }
        AppMethodBeat.o(315517);
      }
    };
    DialogInterface.OnCancelListener local3 = new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(69342);
        if (WalletLoanRepaymentUI.this.Vnf != null)
        {
          WalletLoanRepaymentUI.this.Vnf.cancel();
          WalletLoanRepaymentUI.this.setResult(0);
          WalletLoanRepaymentUI.this.finish();
        }
        AppMethodBeat.o(69342);
      }
    };
    this.Vnz = paramBankcard.field_bindSerial;
    this.Vnf = com.tencent.mm.plugin.wallet_core.ui.u.a(this, this.desc, paramDouble, paramString, paramBankcard, local1, local2, local3);
    AppMethodBeat.o(69353);
  }
  
  private void bgm(String paramString)
  {
    AppMethodBeat.i(69351);
    doSceneProgress(new c(paramString), true);
    AppMethodBeat.o(69351);
  }
  
  private void igd()
  {
    AppMethodBeat.i(69354);
    Log.i("MicroMsg.WalletLoanRepaymentUI", "to change a bankcard");
    startActivityForResult(new Intent(this, WalletChangeLoanRepayBankcardUI.class), 1);
    AppMethodBeat.o(69354);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return -1;
  }
  
  protected final void ige()
  {
    AppMethodBeat.i(69355);
    Bundle localBundle = new Bundle();
    localBundle.putInt("key_bind_scene", 8);
    localBundle.putBoolean("key_need_bind_response", true);
    localBundle.putString("kreq_token", this.token);
    b.jNX();
    if (b.b(c.a.yWP, true))
    {
      this.Myr.alive();
      Log.d("MicroMsg.WalletLoanRepaymentUI", "startKindaBindCard:true");
      ac.pu(6, localBundle.getInt("key_bind_scene"));
      aa.aGq(localBundle.getInt("key_bind_scene"));
      ((com.tencent.mm.pluginsdk.wallet.a)h.ax(com.tencent.mm.pluginsdk.wallet.a.class)).startBindCardUseCase(this, localBundle);
    }
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(69355);
      return;
      Log.d("MicroMsg.WalletLoanRepaymentUI", "startKindaBindCard:false");
    }
    com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet.loan.a.class, localBundle, new e.a()
    {
      public final Intent v(int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(69345);
        if (paramAnonymousInt == -1) {
          WalletLoanRepaymentUI.c(WalletLoanRepaymentUI.this, WalletLoanRepaymentUI.b(WalletLoanRepaymentUI.this));
        }
        for (;;)
        {
          AppMethodBeat.o(69345);
          return null;
          paramAnonymousBundle = com.tencent.mm.plugin.wallet_core.model.u.iiD();
          if (paramAnonymousBundle.iiQ())
          {
            paramAnonymousBundle = paramAnonymousBundle.iiR();
            if ((paramAnonymousBundle != null) && (Util.isNullOrNil(paramAnonymousBundle.field_forbidWord))) {
              WalletLoanRepaymentUI.a(WalletLoanRepaymentUI.this, paramAnonymousBundle, WalletLoanRepaymentUI.c(WalletLoanRepaymentUI.this), WalletLoanRepaymentUI.d(WalletLoanRepaymentUI.this));
            } else {
              WalletLoanRepaymentUI.e(WalletLoanRepaymentUI.this);
            }
          }
          else
          {
            WalletLoanRepaymentUI.this.setResult(0, null);
          }
        }
      }
    });
    AppMethodBeat.o(69355);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(69357);
    if (paramInt1 == 1)
    {
      if (paramInt2 == -1)
      {
        paramInt1 = paramIntent.getIntExtra("ret", -1000);
        if (paramInt1 == -1003)
        {
          Log.i("MicroMsg.WalletLoanRepaymentUI", "to bind a new card");
          ige();
          AppMethodBeat.o(69357);
          return;
        }
        if (paramInt1 == 0)
        {
          Log.i("MicroMsg.WalletLoanRepaymentUI", "change card ok");
          paramIntent = com.tencent.mm.plugin.wallet_core.model.u.iiD().bgC(paramIntent.getStringExtra("bindSerial"));
          if (paramIntent == null)
          {
            Log.e("MicroMsg.WalletLoanRepaymentUI", "bankcard is null by getBankcardBySerialNo");
            finish();
            AppMethodBeat.o(69357);
            return;
          }
          a(paramIntent, this.OjO, this.MEq);
          AppMethodBeat.o(69357);
          return;
        }
        Log.e("MicroMsg.WalletLoanRepaymentUI", "activity return unknow error");
        AppMethodBeat.o(69357);
        return;
      }
      paramIntent = com.tencent.mm.plugin.wallet_core.model.u.iiD();
      if (paramIntent.iiQ())
      {
        paramIntent = paramIntent.iiR();
        if ((paramIntent != null) && (Util.isNullOrNil(paramIntent.field_forbidWord)))
        {
          a(paramIntent, this.OjO, this.MEq);
          AppMethodBeat.o(69357);
          return;
        }
        finish();
        AppMethodBeat.o(69357);
        return;
      }
      Log.e("MicroMsg.WalletLoanRepaymentUI", "onActivityResult hasRepaymentBankcard is false");
      AppMethodBeat.o(69357);
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(69357);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(69348);
    super.onCreate(paramBundle);
    paramBundle = getIntent();
    this.Vnx = paramBundle.getStringExtra("appId");
    this.Vns = paramBundle.getStringExtra("timeStamp");
    this.Vnt = paramBundle.getStringExtra("nonceStr");
    this.Vnu = paramBundle.getStringExtra("packageExt");
    this.Vnv = paramBundle.getStringExtra("signtype");
    this.Vnw = paramBundle.getStringExtra("paySignature");
    this.Vny = paramBundle.getStringExtra("url");
    this.VnA = paramBundle.getIntExtra("pay_channel", 0);
    addSceneEndListener(580);
    doSceneForceProgress(new d(this.Vnx, this.Vns, this.Vnt, this.Vnu, this.Vnv, this.Vnw, this.Vny, 7, "getWebPayCheckoutCounterRequst", this.VnA));
    AppMethodBeat.o(69348);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(69350);
    super.onDestroy();
    removeSceneEndListener(580);
    AppMethodBeat.o(69350);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(69356);
    Object localObject = paramIntent.getExtras();
    Log.i("MicroMsg.WalletLoanRepaymentUI", "onNewIntent");
    if (((Bundle)localObject).containsKey("intent_bind_end"))
    {
      Log.i("MicroMsg.WalletLoanRepaymentUI", "back from bind card");
      bgm(this.token);
      AppMethodBeat.o(69356);
      return;
    }
    if (((Bundle)localObject).containsKey("jsapi_verifycode_process_end"))
    {
      Log.i("MicroMsg.WalletLoanRepaymentUI", "back from verify code");
      localObject = new Intent();
      ((Intent)localObject).putExtra("token", paramIntent.getStringExtra("token"));
      ((Intent)localObject).putExtra("bind_serial", this.Vnz);
      setResult(-1, (Intent)localObject);
      finish();
      AppMethodBeat.o(69356);
      return;
    }
    Log.i("MicroMsg.WalletLoanRepaymentUI", "need to deal with,finish");
    finish();
    AppMethodBeat.o(69356);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(69349);
    super.onResume();
    AppMethodBeat.o(69349);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(69352);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramp instanceof d))
      {
        e.brZ(((d)paramp).ihJ());
        this.token = ((d)paramp).getToken();
        bgm(this.token);
        AppMethodBeat.o(69352);
        return true;
      }
      if ((paramp instanceof c))
      {
        paramString = (c)paramp;
        this.MEq = paramString.MEq;
        this.OjO = paramString.OjO;
        this.desc = paramString.desc;
        paramString = com.tencent.mm.plugin.wallet_core.model.u.iiD();
        if (paramString.iiQ())
        {
          paramString = paramString.iiR();
          if ((paramString != null) && (Util.isNullOrNil(paramString.field_forbidWord))) {
            a(paramString, this.OjO, this.MEq);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(69352);
          return true;
          igd();
          continue;
          com.tencent.mm.ui.base.k.b(this, getResources().getString(a.i.wallet_loan_repayment_new_card_tip), "", getString(a.i.wallet_pay_bankcard_add), getString(a.i.app_cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(69343);
              Log.i("MicroMsg.WalletLoanRepaymentUI", "to bind a new bankcard");
              WalletLoanRepaymentUI.this.ige();
              AppMethodBeat.o(69343);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(69344);
              if (WalletLoanRepaymentUI.this.isTransparent()) {
                WalletLoanRepaymentUI.this.finish();
              }
              AppMethodBeat.o(69344);
            }
          });
        }
      }
      if ((paramp instanceof y))
      {
        paramString = (y)paramp;
        if (paramString.ihL())
        {
          Log.i("MicroMsg.WalletLoanRepaymentUI", "need free sms");
          paramp = new Bundle();
          paramp.putString("key_pwd1", this.qdg);
          paramp.putString("key_jsapi_token", this.token);
          paramp.putString("key_relation_key", paramString.VxY);
          paramp.putInt("key_verify_scene", 8);
          paramp.putString("key_mobile", paramString.VxX);
          com.tencent.mm.wallet_core.a.a(this, r.class, paramp);
        }
        for (;;)
        {
          AppMethodBeat.o(69352);
          return true;
          paramp = new Intent();
          paramp.putExtra("token", paramString.Vww);
          paramp.putExtra("bind_serial", this.Vnz);
          setResult(-1, paramp);
          finish();
        }
      }
    }
    AppMethodBeat.o(69352);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.WalletLoanRepaymentUI
 * JD-Core Version:    0.7.0.1
 */