package com.tencent.mm.plugin.wallet.pay.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.ma;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.wallet.pay.a.c;
import com.tencent.mm.plugin.wallet_core.c.d;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.al;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.plugin.wallet_core.ui.t;
import com.tencent.mm.plugin.wallet_core.ui.t.c;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.e;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.c.ab;
import com.tencent.mm.wallet_core.c.z;
import com.tencent.mm.wallet_core.d.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@com.tencent.mm.ui.base.a(7)
public class WalletLoanRepaymentUI
  extends WalletBaseUI
{
  private IListener<ma> GCj;
  private String GHz;
  private double Imy;
  protected t OxU;
  private String Oyh;
  private String Oyi;
  private String Oyj;
  private String Oyk;
  private String Oyl;
  private String Oym;
  private String Oyn;
  private String Oyo;
  private int Oyp;
  private String desc;
  private String nfX;
  private String token;
  
  public WalletLoanRepaymentUI()
  {
    AppMethodBeat.i(69347);
    this.GHz = "CNY";
    this.GCj = new IListener() {};
    AppMethodBeat.o(69347);
  }
  
  private void a(final Bankcard paramBankcard, double paramDouble, String paramString)
  {
    AppMethodBeat.i(69353);
    t.c local1 = new t.c()
    {
      public final void a(String paramAnonymousString, FavorPayInfo paramAnonymousFavorPayInfo, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(69340);
        WalletLoanRepaymentUI.a(WalletLoanRepaymentUI.this, paramAnonymousString);
        WalletLoanRepaymentUI.this.doSceneProgress(new y(WalletLoanRepaymentUI.a(WalletLoanRepaymentUI.this), WalletLoanRepaymentUI.b(WalletLoanRepaymentUI.this), (byte)0));
        AppMethodBeat.o(69340);
      }
    };
    View.OnClickListener local2 = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(69341);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/pay/ui/WalletLoanRepaymentUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        WalletLoanRepaymentUI.b(WalletLoanRepaymentUI.this, paramBankcard.field_bindSerial);
        if (WalletLoanRepaymentUI.this.OxU != null) {
          WalletLoanRepaymentUI.this.OxU.dismiss();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/pay/ui/WalletLoanRepaymentUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(69341);
      }
    };
    DialogInterface.OnCancelListener local3 = new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(69342);
        if (WalletLoanRepaymentUI.this.OxU != null)
        {
          WalletLoanRepaymentUI.this.OxU.cancel();
          WalletLoanRepaymentUI.this.setResult(0);
          WalletLoanRepaymentUI.this.finish();
        }
        AppMethodBeat.o(69342);
      }
    };
    this.Oyo = paramBankcard.field_bindSerial;
    this.OxU = t.a(this, this.desc, paramDouble, paramString, paramBankcard, local1, local2, local3);
    AppMethodBeat.o(69353);
  }
  
  private void bgG(String paramString)
  {
    AppMethodBeat.i(69351);
    doSceneProgress(new c(paramString), true);
    AppMethodBeat.o(69351);
  }
  
  private void gGZ()
  {
    AppMethodBeat.i(69354);
    Log.i("MicroMsg.WalletLoanRepaymentUI", "to change a bankcard");
    startActivityForResult(new Intent(this, WalletChangeLoanRepayBankcardUI.class), 1);
    AppMethodBeat.o(69354);
  }
  
  protected final void gHa()
  {
    AppMethodBeat.i(69355);
    Bundle localBundle = new Bundle();
    localBundle.putInt("key_bind_scene", 8);
    localBundle.putBoolean("key_need_bind_response", true);
    localBundle.putString("kreq_token", this.token);
    com.tencent.mm.wallet_core.b.iie();
    if (com.tencent.mm.wallet_core.b.b(b.a.vGW, true))
    {
      EventCenter.instance.add(this.GCj);
      Log.d("MicroMsg.WalletLoanRepaymentUI", "startKindaBindCard:true");
      ab.ny(6, localBundle.getInt("key_bind_scene"));
      z.azF(localBundle.getInt("key_bind_scene"));
      ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.pluginsdk.wallet.a.class)).startBindCardUseCase(this, localBundle);
    }
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(69355);
      return;
      Log.d("MicroMsg.WalletLoanRepaymentUI", "startKindaBindCard:false");
    }
    com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet.loan.a.class, localBundle, new d.a()
    {
      public final Intent s(int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(69345);
        if (paramAnonymousInt == -1) {
          WalletLoanRepaymentUI.c(WalletLoanRepaymentUI.this, WalletLoanRepaymentUI.b(WalletLoanRepaymentUI.this));
        }
        for (;;)
        {
          AppMethodBeat.o(69345);
          return null;
          paramAnonymousBundle = u.gJp();
          if (paramAnonymousBundle.gJC())
          {
            paramAnonymousBundle = paramAnonymousBundle.gJD();
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
    AppMethodBeat.i(69357);
    if (paramInt1 == 1)
    {
      if (paramInt2 == -1)
      {
        paramInt1 = paramIntent.getIntExtra("ret", -1000);
        if (paramInt1 == -1003)
        {
          Log.i("MicroMsg.WalletLoanRepaymentUI", "to bind a new card");
          gHa();
          AppMethodBeat.o(69357);
          return;
        }
        if (paramInt1 == 0)
        {
          Log.i("MicroMsg.WalletLoanRepaymentUI", "change card ok");
          paramIntent = u.gJp().bgU(paramIntent.getStringExtra("bindSerial"));
          if (paramIntent == null)
          {
            Log.e("MicroMsg.WalletLoanRepaymentUI", "bankcard is null by getBankcardBySerialNo");
            finish();
            AppMethodBeat.o(69357);
            return;
          }
          a(paramIntent, this.Imy, this.GHz);
          AppMethodBeat.o(69357);
          return;
        }
        Log.e("MicroMsg.WalletLoanRepaymentUI", "activity return unknow error");
        AppMethodBeat.o(69357);
        return;
      }
      paramIntent = u.gJp();
      if (paramIntent.gJC())
      {
        paramIntent = paramIntent.gJD();
        if ((paramIntent != null) && (Util.isNullOrNil(paramIntent.field_forbidWord)))
        {
          a(paramIntent, this.Imy, this.GHz);
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
    this.Oym = paramBundle.getStringExtra("appId");
    this.Oyh = paramBundle.getStringExtra("timeStamp");
    this.Oyi = paramBundle.getStringExtra("nonceStr");
    this.Oyj = paramBundle.getStringExtra("packageExt");
    this.Oyk = paramBundle.getStringExtra("signtype");
    this.Oyl = paramBundle.getStringExtra("paySignature");
    this.Oyn = paramBundle.getStringExtra("url");
    this.Oyp = paramBundle.getIntExtra("pay_channel", 0);
    addSceneEndListener(580);
    doSceneForceProgress(new d(this.Oym, this.Oyh, this.Oyi, this.Oyj, this.Oyk, this.Oyl, this.Oyn, 7, "getWebPayCheckoutCounterRequst", this.Oyp));
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
      bgG(this.token);
      AppMethodBeat.o(69356);
      return;
    }
    if (((Bundle)localObject).containsKey("jsapi_verifycode_process_end"))
    {
      Log.i("MicroMsg.WalletLoanRepaymentUI", "back from verify code");
      localObject = new Intent();
      ((Intent)localObject).putExtra("token", paramIntent.getStringExtra("token"));
      ((Intent)localObject).putExtra("bind_serial", this.Oyo);
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
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(69352);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramq instanceof d))
      {
        e.bsi(((d)paramq).gIv());
        this.token = ((d)paramq).getToken();
        bgG(this.token);
        AppMethodBeat.o(69352);
        return true;
      }
      if ((paramq instanceof c))
      {
        paramString = (c)paramq;
        this.GHz = paramString.GHz;
        this.Imy = paramString.Imy;
        this.desc = paramString.desc;
        paramString = u.gJp();
        if (paramString.gJC())
        {
          paramString = paramString.gJD();
          if ((paramString != null) && (Util.isNullOrNil(paramString.field_forbidWord))) {
            a(paramString, this.Imy, this.GHz);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(69352);
          return true;
          gGZ();
          continue;
          com.tencent.mm.ui.base.h.c(this, getResources().getString(a.i.wallet_loan_repayment_new_card_tip), "", getString(a.i.wallet_pay_bankcard_add), getString(a.i.app_cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(69343);
              Log.i("MicroMsg.WalletLoanRepaymentUI", "to bind a new bankcard");
              WalletLoanRepaymentUI.this.gHa();
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
      if ((paramq instanceof y))
      {
        paramString = (y)paramq;
        if (paramString.gIx())
        {
          Log.i("MicroMsg.WalletLoanRepaymentUI", "need free sms");
          paramq = new Bundle();
          paramq.putString("key_pwd1", this.nfX);
          paramq.putString("key_jsapi_token", this.token);
          paramq.putString("key_relation_key", paramString.OIm);
          paramq.putInt("key_verify_scene", 8);
          paramq.putString("key_mobile", paramString.OIl);
          com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet_core.ui.q.class, paramq);
        }
        for (;;)
        {
          AppMethodBeat.o(69352);
          return true;
          paramq = new Intent();
          paramq.putExtra("token", paramString.OIj);
          paramq.putExtra("bind_serial", this.Oyo);
          setResult(-1, paramq);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.WalletLoanRepaymentUI
 * JD-Core Version:    0.7.0.1
 */