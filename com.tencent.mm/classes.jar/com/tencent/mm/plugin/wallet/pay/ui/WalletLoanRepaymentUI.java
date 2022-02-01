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
import com.tencent.mm.al.n;
import com.tencent.mm.g.a.ks;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b.a;
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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c.ab;
import com.tencent.mm.wallet_core.c.z;
import com.tencent.mm.wallet_core.d.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@com.tencent.mm.ui.base.a(7)
public class WalletLoanRepaymentUI
  extends WalletBaseUI
{
  protected s CIH;
  private String CIT;
  private String CIU;
  private String CIV;
  private String CIW;
  private String CIX;
  private String CIY;
  private String CIZ;
  private String CJa;
  private int CJb;
  private String desc;
  private String jmZ;
  private String token;
  private String wCF;
  private com.tencent.mm.sdk.b.c<ks> wxJ;
  private double xYB;
  
  public WalletLoanRepaymentUI()
  {
    AppMethodBeat.i(69347);
    this.wCF = "CNY";
    this.wxJ = new com.tencent.mm.sdk.b.c() {};
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
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/pay/ui/WalletLoanRepaymentUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        WalletLoanRepaymentUI.c(WalletLoanRepaymentUI.this);
        if (WalletLoanRepaymentUI.this.CIH != null) {
          WalletLoanRepaymentUI.this.CIH.dismiss();
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
        if (WalletLoanRepaymentUI.this.CIH != null)
        {
          WalletLoanRepaymentUI.this.CIH.cancel();
          WalletLoanRepaymentUI.this.setResult(0);
          WalletLoanRepaymentUI.this.finish();
        }
        AppMethodBeat.o(69342);
      }
    };
    this.CJa = paramBankcard.field_bindSerial;
    this.CIH = s.a(this, this.desc, paramDouble, paramString, paramBankcard, local1, local2, local3);
    AppMethodBeat.o(69353);
  }
  
  private void aEg(String paramString)
  {
    AppMethodBeat.i(69351);
    doSceneProgress(new com.tencent.mm.plugin.wallet.pay.a.c(paramString), true);
    AppMethodBeat.o(69351);
  }
  
  private void eDC()
  {
    AppMethodBeat.i(69354);
    ad.i("MicroMsg.WalletLoanRepaymentUI", "to change a bankcard");
    startActivityForResult(new Intent(this, WalletChangeLoanRepayBankcardUI.class), 1);
    AppMethodBeat.o(69354);
  }
  
  protected final void eDD()
  {
    int i = 0;
    AppMethodBeat.i(69355);
    Bundle localBundle = new Bundle();
    localBundle.putInt("key_bind_scene", 8);
    localBundle.putBoolean("key_need_bind_response", true);
    localBundle.putString("kreq_token", this.token);
    com.tencent.mm.wallet_core.b.fQJ();
    if (com.tencent.mm.wallet_core.b.b(b.a.qzx, false))
    {
      com.tencent.mm.sdk.b.a.IbL.b(this.wxJ);
      ad.d("MicroMsg.WalletLoanRepaymentUI", "startKindaBindCard:true");
      ab.kB(6, localBundle.getInt("key_bind_scene"));
      z.agm(localBundle.getInt("key_bind_scene"));
      ((com.tencent.mm.pluginsdk.wallet.a)g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).startBindCardUseCase(this, localBundle);
      i = 1;
    }
    while (i != 0)
    {
      AppMethodBeat.o(69355);
      return;
      ad.d("MicroMsg.WalletLoanRepaymentUI", "startKindaBindCard:false");
    }
    com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet.loan.a.class, localBundle, new d.a()
    {
      public final Intent s(int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(69345);
        if (paramAnonymousInt == -1) {
          WalletLoanRepaymentUI.b(WalletLoanRepaymentUI.this, WalletLoanRepaymentUI.b(WalletLoanRepaymentUI.this));
        }
        for (;;)
        {
          AppMethodBeat.o(69345);
          return null;
          paramAnonymousBundle = t.eFz();
          if (paramAnonymousBundle.eFM())
          {
            paramAnonymousBundle = paramAnonymousBundle.eFN();
            if ((paramAnonymousBundle != null) && (bt.isNullOrNil(paramAnonymousBundle.field_forbidWord))) {
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
          ad.i("MicroMsg.WalletLoanRepaymentUI", "to bind a new card");
          eDD();
          AppMethodBeat.o(69357);
          return;
        }
        if (paramInt1 == 0)
        {
          ad.i("MicroMsg.WalletLoanRepaymentUI", "change card ok");
          paramIntent = t.eFz().aEs(paramIntent.getStringExtra("bindSerial"));
          if (paramIntent == null)
          {
            ad.e("MicroMsg.WalletLoanRepaymentUI", "bankcard is null by getBankcardBySerialNo");
            finish();
            AppMethodBeat.o(69357);
            return;
          }
          a(paramIntent, this.xYB, this.wCF);
          AppMethodBeat.o(69357);
          return;
        }
        ad.e("MicroMsg.WalletLoanRepaymentUI", "activity return unknow error");
        AppMethodBeat.o(69357);
        return;
      }
      paramIntent = t.eFz();
      if (paramIntent.eFM())
      {
        paramIntent = paramIntent.eFN();
        if ((paramIntent != null) && (bt.isNullOrNil(paramIntent.field_forbidWord)))
        {
          a(paramIntent, this.xYB, this.wCF);
          AppMethodBeat.o(69357);
          return;
        }
        finish();
        AppMethodBeat.o(69357);
        return;
      }
      ad.e("MicroMsg.WalletLoanRepaymentUI", "onActivityResult hasRepaymentBankcard is false");
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
    this.CIY = paramBundle.getStringExtra("appId");
    this.CIT = paramBundle.getStringExtra("timeStamp");
    this.CIU = paramBundle.getStringExtra("nonceStr");
    this.CIV = paramBundle.getStringExtra("packageExt");
    this.CIW = paramBundle.getStringExtra("signtype");
    this.CIX = paramBundle.getStringExtra("paySignature");
    this.CIZ = paramBundle.getStringExtra("url");
    this.CJb = paramBundle.getIntExtra("pay_channel", 0);
    addSceneEndListener(580);
    doSceneForceProgress(new d(this.CIY, this.CIT, this.CIU, this.CIV, this.CIW, this.CIX, this.CIZ, 7, "getWebPayCheckoutCounterRequst", this.CJb));
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
    ad.i("MicroMsg.WalletLoanRepaymentUI", "onNewIntent");
    if (((Bundle)localObject).containsKey("intent_bind_end"))
    {
      ad.i("MicroMsg.WalletLoanRepaymentUI", "back from bind card");
      aEg(this.token);
      AppMethodBeat.o(69356);
      return;
    }
    if (((Bundle)localObject).containsKey("jsapi_verifycode_process_end"))
    {
      ad.i("MicroMsg.WalletLoanRepaymentUI", "back from verify code");
      localObject = new Intent();
      ((Intent)localObject).putExtra("token", paramIntent.getStringExtra("token"));
      ((Intent)localObject).putExtra("bind_serial", this.CJa);
      setResult(-1, (Intent)localObject);
      finish();
      AppMethodBeat.o(69356);
      return;
    }
    ad.i("MicroMsg.WalletLoanRepaymentUI", "need to deal with,finish");
    finish();
    AppMethodBeat.o(69356);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(69349);
    super.onResume();
    AppMethodBeat.o(69349);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(69352);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramn instanceof d))
      {
        e.aNP(((d)paramn).eEF());
        this.token = ((d)paramn).getToken();
        aEg(this.token);
        AppMethodBeat.o(69352);
        return true;
      }
      if ((paramn instanceof com.tencent.mm.plugin.wallet.pay.a.c))
      {
        paramString = (com.tencent.mm.plugin.wallet.pay.a.c)paramn;
        this.wCF = paramString.wCF;
        this.xYB = paramString.xYB;
        this.desc = paramString.desc;
        paramString = t.eFz();
        if (paramString.eFM())
        {
          paramString = paramString.eFN();
          if ((paramString != null) && (bt.isNullOrNil(paramString.field_forbidWord))) {
            a(paramString, this.xYB, this.wCF);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(69352);
          return true;
          eDC();
          continue;
          h.e(this, getResources().getString(2131765339), "", getString(2131765660), getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(69343);
              ad.i("MicroMsg.WalletLoanRepaymentUI", "to bind a new bankcard");
              WalletLoanRepaymentUI.this.eDD();
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
      if ((paramn instanceof x))
      {
        paramString = (x)paramn;
        if (paramString.eEH())
        {
          ad.i("MicroMsg.WalletLoanRepaymentUI", "need free sms");
          paramn = new Bundle();
          paramn.putString("key_pwd1", this.jmZ);
          paramn.putString("key_jsapi_token", this.token);
          paramn.putString("key_relation_key", paramString.CPg);
          paramn.putInt("key_verify_scene", 8);
          paramn.putString("key_mobile", paramString.CPf);
          com.tencent.mm.wallet_core.a.a(this, p.class, paramn);
        }
        for (;;)
        {
          AppMethodBeat.o(69352);
          return true;
          paramn = new Intent();
          paramn.putExtra("token", paramString.CPd);
          paramn.putExtra("bind_serial", this.CJa);
          setResult(-1, paramn);
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