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
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.lj;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.wallet.pay.a.c;
import com.tencent.mm.plugin.wallet_core.c.d;
import com.tencent.mm.plugin.wallet_core.c.x;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.ak;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.ui.p;
import com.tencent.mm.plugin.wallet_core.ui.s;
import com.tencent.mm.plugin.wallet_core.ui.s.c;
import com.tencent.mm.pluginsdk.wallet.e;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c.ab;
import com.tencent.mm.wallet_core.c.z;
import com.tencent.mm.wallet_core.d.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@com.tencent.mm.ui.base.a(7)
public class WalletLoanRepaymentUI
  extends WalletBaseUI
{
  private IListener<lj> AJa;
  private String AOl;
  private double Cpj;
  protected s HGb;
  private String HGn;
  private String HGo;
  private String HGp;
  private String HGq;
  private String HGr;
  private String HGs;
  private String HGt;
  private String HGu;
  private int HGv;
  private String desc;
  private String kof;
  private String token;
  
  public WalletLoanRepaymentUI()
  {
    AppMethodBeat.i(69347);
    this.AOl = "CNY";
    this.AJa = new IListener() {};
    AppMethodBeat.o(69347);
  }
  
  private void a(Bankcard paramBankcard, double paramDouble, String paramString)
  {
    AppMethodBeat.i(69353);
    s.c local1 = new s.c()
    {
      public final void a(String paramAnonymousString, FavorPayInfo paramAnonymousFavorPayInfo, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(69340);
        WalletLoanRepaymentUI.a(WalletLoanRepaymentUI.this, paramAnonymousString);
        WalletLoanRepaymentUI.this.doSceneProgress(new x(WalletLoanRepaymentUI.a(WalletLoanRepaymentUI.this), WalletLoanRepaymentUI.b(WalletLoanRepaymentUI.this), (byte)0));
        AppMethodBeat.o(69340);
      }
    };
    View.OnClickListener local2 = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(69341);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/pay/ui/WalletLoanRepaymentUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        WalletLoanRepaymentUI.c(WalletLoanRepaymentUI.this);
        if (WalletLoanRepaymentUI.this.HGb != null) {
          WalletLoanRepaymentUI.this.HGb.dismiss();
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
        if (WalletLoanRepaymentUI.this.HGb != null)
        {
          WalletLoanRepaymentUI.this.HGb.cancel();
          WalletLoanRepaymentUI.this.setResult(0);
          WalletLoanRepaymentUI.this.finish();
        }
        AppMethodBeat.o(69342);
      }
    };
    this.HGu = paramBankcard.field_bindSerial;
    this.HGb = s.a(this, this.desc, paramDouble, paramString, paramBankcard, local1, local2, local3);
    AppMethodBeat.o(69353);
  }
  
  private void aUX(String paramString)
  {
    AppMethodBeat.i(69351);
    doSceneProgress(new c(paramString), true);
    AppMethodBeat.o(69351);
  }
  
  private void fOt()
  {
    AppMethodBeat.i(69354);
    Log.i("MicroMsg.WalletLoanRepaymentUI", "to change a bankcard");
    startActivityForResult(new Intent(this, WalletChangeLoanRepayBankcardUI.class), 1);
    AppMethodBeat.o(69354);
  }
  
  protected final void fOu()
  {
    AppMethodBeat.i(69355);
    Bundle localBundle = new Bundle();
    localBundle.putInt("key_bind_scene", 8);
    localBundle.putBoolean("key_need_bind_response", true);
    localBundle.putString("kreq_token", this.token);
    com.tencent.mm.wallet_core.b.hgC();
    if (com.tencent.mm.wallet_core.b.b(b.a.rZU, true))
    {
      EventCenter.instance.add(this.AJa);
      Log.d("MicroMsg.WalletLoanRepaymentUI", "startKindaBindCard:true");
      ab.mg(6, localBundle.getInt("key_bind_scene"));
      z.aqh(localBundle.getInt("key_bind_scene"));
      ((com.tencent.mm.pluginsdk.wallet.a)g.af(com.tencent.mm.pluginsdk.wallet.a.class)).startBindCardUseCase(this, localBundle);
    }
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(69355);
      return;
      Log.d("MicroMsg.WalletLoanRepaymentUI", "startKindaBindCard:false");
    }
    com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet.loan.a.class, localBundle, new d.a()
    {
      public final Intent q(int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(69345);
        if (paramAnonymousInt == -1) {
          WalletLoanRepaymentUI.b(WalletLoanRepaymentUI.this, WalletLoanRepaymentUI.b(WalletLoanRepaymentUI.this));
        }
        for (;;)
        {
          AppMethodBeat.o(69345);
          return null;
          paramAnonymousBundle = t.fQJ();
          if (paramAnonymousBundle.fQW())
          {
            paramAnonymousBundle = paramAnonymousBundle.fQX();
            if ((paramAnonymousBundle != null) && (Util.isNullOrNil(paramAnonymousBundle.field_forbidWord))) {
              WalletLoanRepaymentUI.a(WalletLoanRepaymentUI.this, paramAnonymousBundle, WalletLoanRepaymentUI.d(WalletLoanRepaymentUI.this), WalletLoanRepaymentUI.e(WalletLoanRepaymentUI.this));
            } else {
              WalletLoanRepaymentUI.c(WalletLoanRepaymentUI.this);
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
          fOu();
          AppMethodBeat.o(69357);
          return;
        }
        if (paramInt1 == 0)
        {
          Log.i("MicroMsg.WalletLoanRepaymentUI", "change card ok");
          paramIntent = t.fQJ().aVl(paramIntent.getStringExtra("bindSerial"));
          if (paramIntent == null)
          {
            Log.e("MicroMsg.WalletLoanRepaymentUI", "bankcard is null by getBankcardBySerialNo");
            finish();
            AppMethodBeat.o(69357);
            return;
          }
          a(paramIntent, this.Cpj, this.AOl);
          AppMethodBeat.o(69357);
          return;
        }
        Log.e("MicroMsg.WalletLoanRepaymentUI", "activity return unknow error");
        AppMethodBeat.o(69357);
        return;
      }
      paramIntent = t.fQJ();
      if (paramIntent.fQW())
      {
        paramIntent = paramIntent.fQX();
        if ((paramIntent != null) && (Util.isNullOrNil(paramIntent.field_forbidWord)))
        {
          a(paramIntent, this.Cpj, this.AOl);
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
    this.HGs = paramBundle.getStringExtra("appId");
    this.HGn = paramBundle.getStringExtra("timeStamp");
    this.HGo = paramBundle.getStringExtra("nonceStr");
    this.HGp = paramBundle.getStringExtra("packageExt");
    this.HGq = paramBundle.getStringExtra("signtype");
    this.HGr = paramBundle.getStringExtra("paySignature");
    this.HGt = paramBundle.getStringExtra("url");
    this.HGv = paramBundle.getIntExtra("pay_channel", 0);
    addSceneEndListener(580);
    doSceneForceProgress(new d(this.HGs, this.HGn, this.HGo, this.HGp, this.HGq, this.HGr, this.HGt, 7, "getWebPayCheckoutCounterRequst", this.HGv));
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
      aUX(this.token);
      AppMethodBeat.o(69356);
      return;
    }
    if (((Bundle)localObject).containsKey("jsapi_verifycode_process_end"))
    {
      Log.i("MicroMsg.WalletLoanRepaymentUI", "back from verify code");
      localObject = new Intent();
      ((Intent)localObject).putExtra("token", paramIntent.getStringExtra("token"));
      ((Intent)localObject).putExtra("bind_serial", this.HGu);
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
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(69352);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramq instanceof d))
      {
        e.bfP(((d)paramq).fPP());
        this.token = ((d)paramq).getToken();
        aUX(this.token);
        AppMethodBeat.o(69352);
        return true;
      }
      if ((paramq instanceof c))
      {
        paramString = (c)paramq;
        this.AOl = paramString.AOl;
        this.Cpj = paramString.Cpj;
        this.desc = paramString.desc;
        paramString = t.fQJ();
        if (paramString.fQW())
        {
          paramString = paramString.fQX();
          if ((paramString != null) && (Util.isNullOrNil(paramString.field_forbidWord))) {
            a(paramString, this.Cpj, this.AOl);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(69352);
          return true;
          fOt();
          continue;
          h.c(this, getResources().getString(2131767782), "", getString(2131768113), getString(2131755761), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(69343);
              Log.i("MicroMsg.WalletLoanRepaymentUI", "to bind a new bankcard");
              WalletLoanRepaymentUI.this.fOu();
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
      if ((paramq instanceof x))
      {
        paramString = (x)paramq;
        if (paramString.fPR())
        {
          Log.i("MicroMsg.WalletLoanRepaymentUI", "need free sms");
          paramq = new Bundle();
          paramq.putString("key_pwd1", this.kof);
          paramq.putString("key_jsapi_token", this.token);
          paramq.putString("key_relation_key", paramString.HQd);
          paramq.putInt("key_verify_scene", 8);
          paramq.putString("key_mobile", paramString.HQc);
          com.tencent.mm.wallet_core.a.a(this, p.class, paramq);
        }
        for (;;)
        {
          AppMethodBeat.o(69352);
          return true;
          paramq = new Intent();
          paramq.putExtra("token", paramString.HQa);
          paramq.putExtra("bind_serial", this.HGu);
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