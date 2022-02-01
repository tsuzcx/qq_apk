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
import com.tencent.mm.ak.n;
import com.tencent.mm.g.a.kj;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.wallet_core.c.d;
import com.tencent.mm.plugin.wallet_core.c.x;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.aj;
import com.tencent.mm.plugin.wallet_core.ui.p;
import com.tencent.mm.plugin.wallet_core.ui.s.c;
import com.tencent.mm.pluginsdk.wallet.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.b;
import com.tencent.mm.wallet_core.c.ab;
import com.tencent.mm.wallet_core.c.z;
import com.tencent.mm.wallet_core.d.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@com.tencent.mm.ui.base.a(7)
public class WalletLoanRepaymentUI
  extends WalletBaseUI
{
  private String BiF;
  private String BiG;
  private String BiH;
  private String BiI;
  private String BiJ;
  private String BiK;
  private String BiL;
  private String BiM;
  private int BiN;
  protected com.tencent.mm.plugin.wallet_core.ui.s Bit;
  private String desc;
  private String iTR;
  private String token;
  private com.tencent.mm.sdk.b.c<kj> vsr;
  private String vxl;
  private double wKU;
  
  public WalletLoanRepaymentUI()
  {
    AppMethodBeat.i(69347);
    this.vxl = "CNY";
    this.vsr = new com.tencent.mm.sdk.b.c() {};
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
        WalletLoanRepaymentUI.c(WalletLoanRepaymentUI.this);
        if (WalletLoanRepaymentUI.this.Bit != null) {
          WalletLoanRepaymentUI.this.Bit.dismiss();
        }
        AppMethodBeat.o(69341);
      }
    };
    DialogInterface.OnCancelListener local3 = new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(69342);
        if (WalletLoanRepaymentUI.this.Bit != null)
        {
          WalletLoanRepaymentUI.this.Bit.cancel();
          WalletLoanRepaymentUI.this.setResult(0);
          WalletLoanRepaymentUI.this.finish();
        }
        AppMethodBeat.o(69342);
      }
    };
    this.BiM = paramBankcard.field_bindSerial;
    this.Bit = com.tencent.mm.plugin.wallet_core.ui.s.a(this, this.desc, paramDouble, paramString, paramBankcard, local1, local2, local3);
    AppMethodBeat.o(69353);
  }
  
  private void ayY(String paramString)
  {
    AppMethodBeat.i(69351);
    doSceneProgress(new com.tencent.mm.plugin.wallet.pay.a.c(paramString), true);
    AppMethodBeat.o(69351);
  }
  
  private void epC()
  {
    AppMethodBeat.i(69354);
    ac.i("MicroMsg.WalletLoanRepaymentUI", "to change a bankcard");
    startActivityForResult(new Intent(this, WalletChangeLoanRepayBankcardUI.class), 1);
    AppMethodBeat.o(69354);
  }
  
  protected final void epD()
  {
    int i = 0;
    AppMethodBeat.i(69355);
    Bundle localBundle = new Bundle();
    localBundle.putInt("key_bind_scene", 8);
    localBundle.putBoolean("key_need_bind_response", true);
    localBundle.putString("kreq_token", this.token);
    b.fzz();
    if (b.b(b.a.pUR, false))
    {
      com.tencent.mm.sdk.b.a.GpY.b(this.vsr);
      ac.d("MicroMsg.WalletLoanRepaymentUI", "startKindaBindCard:true");
      ab.km(6, localBundle.getInt("key_bind_scene"));
      z.adM(localBundle.getInt("key_bind_scene"));
      ((com.tencent.mm.pluginsdk.wallet.a)g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).startBindCardUseCase(this, localBundle);
      i = 1;
    }
    while (i != 0)
    {
      AppMethodBeat.o(69355);
      return;
      ac.d("MicroMsg.WalletLoanRepaymentUI", "startKindaBindCard:false");
    }
    com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet.loan.a.class, localBundle, new d.a()
    {
      public final Intent r(int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(69345);
        if (paramAnonymousInt == -1) {
          WalletLoanRepaymentUI.b(WalletLoanRepaymentUI.this, WalletLoanRepaymentUI.b(WalletLoanRepaymentUI.this));
        }
        for (;;)
        {
          AppMethodBeat.o(69345);
          return null;
          paramAnonymousBundle = com.tencent.mm.plugin.wallet_core.model.s.erz();
          if (paramAnonymousBundle.erM())
          {
            paramAnonymousBundle = paramAnonymousBundle.erN();
            if ((paramAnonymousBundle != null) && (bs.isNullOrNil(paramAnonymousBundle.field_forbidWord))) {
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
          ac.i("MicroMsg.WalletLoanRepaymentUI", "to bind a new card");
          epD();
          AppMethodBeat.o(69357);
          return;
        }
        if (paramInt1 == 0)
        {
          ac.i("MicroMsg.WalletLoanRepaymentUI", "change card ok");
          paramIntent = com.tencent.mm.plugin.wallet_core.model.s.erz().azk(paramIntent.getStringExtra("bindSerial"));
          if (paramIntent == null)
          {
            ac.e("MicroMsg.WalletLoanRepaymentUI", "bankcard is null by getBankcardBySerialNo");
            finish();
            AppMethodBeat.o(69357);
            return;
          }
          a(paramIntent, this.wKU, this.vxl);
          AppMethodBeat.o(69357);
          return;
        }
        ac.e("MicroMsg.WalletLoanRepaymentUI", "activity return unknow error");
        AppMethodBeat.o(69357);
        return;
      }
      paramIntent = com.tencent.mm.plugin.wallet_core.model.s.erz();
      if (paramIntent.erM())
      {
        paramIntent = paramIntent.erN();
        if ((paramIntent != null) && (bs.isNullOrNil(paramIntent.field_forbidWord)))
        {
          a(paramIntent, this.wKU, this.vxl);
          AppMethodBeat.o(69357);
          return;
        }
        finish();
        AppMethodBeat.o(69357);
        return;
      }
      ac.e("MicroMsg.WalletLoanRepaymentUI", "onActivityResult hasRepaymentBankcard is false");
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
    this.BiK = paramBundle.getStringExtra("appId");
    this.BiF = paramBundle.getStringExtra("timeStamp");
    this.BiG = paramBundle.getStringExtra("nonceStr");
    this.BiH = paramBundle.getStringExtra("packageExt");
    this.BiI = paramBundle.getStringExtra("signtype");
    this.BiJ = paramBundle.getStringExtra("paySignature");
    this.BiL = paramBundle.getStringExtra("url");
    this.BiN = paramBundle.getIntExtra("pay_channel", 0);
    addSceneEndListener(580);
    doSceneForceProgress(new d(this.BiK, this.BiF, this.BiG, this.BiH, this.BiI, this.BiJ, this.BiL, 7, "getWebPayCheckoutCounterRequst", this.BiN));
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
    ac.i("MicroMsg.WalletLoanRepaymentUI", "onNewIntent");
    if (((Bundle)localObject).containsKey("intent_bind_end"))
    {
      ac.i("MicroMsg.WalletLoanRepaymentUI", "back from bind card");
      ayY(this.token);
      AppMethodBeat.o(69356);
      return;
    }
    if (((Bundle)localObject).containsKey("jsapi_verifycode_process_end"))
    {
      ac.i("MicroMsg.WalletLoanRepaymentUI", "back from verify code");
      localObject = new Intent();
      ((Intent)localObject).putExtra("token", paramIntent.getStringExtra("token"));
      ((Intent)localObject).putExtra("bind_serial", this.BiM);
      setResult(-1, (Intent)localObject);
      finish();
      AppMethodBeat.o(69356);
      return;
    }
    ac.i("MicroMsg.WalletLoanRepaymentUI", "need to deal with,finish");
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
        e.aIm(((d)paramn).eqF());
        this.token = ((d)paramn).getToken();
        ayY(this.token);
        AppMethodBeat.o(69352);
        return true;
      }
      if ((paramn instanceof com.tencent.mm.plugin.wallet.pay.a.c))
      {
        paramString = (com.tencent.mm.plugin.wallet.pay.a.c)paramn;
        this.vxl = paramString.vxl;
        this.wKU = paramString.wKU;
        this.desc = paramString.desc;
        paramString = com.tencent.mm.plugin.wallet_core.model.s.erz();
        if (paramString.erM())
        {
          paramString = paramString.erN();
          if ((paramString != null) && (bs.isNullOrNil(paramString.field_forbidWord))) {
            a(paramString, this.wKU, this.vxl);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(69352);
          return true;
          epC();
          continue;
          h.d(this, getResources().getString(2131765339), "", getString(2131765660), getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(69343);
              ac.i("MicroMsg.WalletLoanRepaymentUI", "to bind a new bankcard");
              WalletLoanRepaymentUI.this.epD();
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
        if (paramString.eqH())
        {
          ac.i("MicroMsg.WalletLoanRepaymentUI", "need free sms");
          paramn = new Bundle();
          paramn.putString("key_pwd1", this.iTR);
          paramn.putString("key_jsapi_token", this.token);
          paramn.putString("key_relation_key", paramString.BoR);
          paramn.putInt("key_verify_scene", 8);
          paramn.putString("key_mobile", paramString.BoQ);
          com.tencent.mm.wallet_core.a.a(this, p.class, paramn);
        }
        for (;;)
        {
          AppMethodBeat.o(69352);
          return true;
          paramn = new Intent();
          paramn.putExtra("token", paramString.BoO);
          paramn.putExtra("bind_serial", this.BiM);
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