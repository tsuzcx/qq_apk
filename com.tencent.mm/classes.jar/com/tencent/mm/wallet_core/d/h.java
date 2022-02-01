package com.tencent.mm.wallet_core.d;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.gc;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.wallet_core.b;
import com.tencent.mm.wallet_core.c.s;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.d.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tenpay.android.wechat.TenpaySecureEditText;

public final class h
{
  public static boolean a(final WalletBaseUI paramWalletBaseUI, com.tencent.mm.ak.n paramn, int paramInt1, final int paramInt2, String paramString)
  {
    int i = 0;
    boolean bool = false;
    AppMethodBeat.i(72852);
    if (paramInt1 == 1000)
    {
      if (!bs.isNullOrNil(paramString)) {
        break label586;
      }
      paramString = paramWalletBaseUI.getString(2131765901);
    }
    label145:
    label154:
    label586:
    for (;;)
    {
      d locald = com.tencent.mm.wallet_core.a.br(paramWalletBaseUI);
      switch (paramInt2)
      {
      default: 
        bool = false;
        paramInt1 = 0;
        if (paramInt1 != 0)
        {
          paramWalletBaseUI.setmPayResultType(2);
          if ((paramn instanceof s)) {
            ((s)paramn).setHasProcessWalletError(bool);
          }
          AppMethodBeat.o(72852);
          return bool;
        }
        break;
      case 401: 
        if (!(paramn instanceof com.tencent.mm.wallet_core.tenpay.model.n)) {}
        break;
      }
      for (paramInt1 = ((com.tencent.mm.wallet_core.tenpay.model.n)paramn).Bya;; paramInt1 = 0)
      {
        if (paramInt1 == 1) {
          com.tencent.mm.ui.base.h.a(paramWalletBaseUI, paramString, "", paramWalletBaseUI.getString(2131765273), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(72841);
              if (this.BhP.isTransparent()) {
                this.BhP.finish();
              }
              AppMethodBeat.o(72841);
            }
          });
        }
        for (;;)
        {
          bool = true;
          paramInt1 = 1;
          break;
          com.tencent.mm.ui.base.h.a(paramWalletBaseUI, false, paramString, "", paramWalletBaseUI.getString(2131765274), paramWalletBaseUI.getString(2131755878), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(72844);
              paramAnonymousDialogInterface = "";
              if ((this.cXh instanceof com.tencent.mm.wallet_core.tenpay.model.n)) {
                paramAnonymousDialogInterface = ((com.tencent.mm.wallet_core.tenpay.model.n)this.cXh).BkM;
              }
              if (!bs.isNullOrNil(paramAnonymousDialogInterface))
              {
                gc localgc = new gc();
                localgc.ebn = 1L;
                localgc.ebo = 2L;
                localgc.aHZ();
                ac.i("MicroMsg.WalletErrMgr", "jump to forget_url %s", new Object[] { paramAnonymousDialogInterface });
                e.o(paramWalletBaseUI, paramAnonymousDialogInterface, false);
                AppMethodBeat.o(72844);
                return;
              }
              paramAnonymousDialogInterface = new gc();
              paramAnonymousDialogInterface.ebn = 1L;
              paramAnonymousDialogInterface.ebo = 1L;
              paramAnonymousDialogInterface.aHZ();
              if (u.axL()) {
                com.tencent.mm.wallet_core.a.b(paramWalletBaseUI, "PayUForgotPwdProcess", null);
              }
              label223:
              for (;;)
              {
                if (paramWalletBaseUI.isTransparent()) {
                  paramWalletBaseUI.finish();
                }
                AppMethodBeat.o(72844);
                return;
                paramAnonymousDialogInterface = paramWalletBaseUI;
                b.fzz();
                if (b.b(b.a.pUS, false))
                {
                  ac.d("MicroMsg.WalletErrMgr", "startKindaResetPwd:true");
                  ((com.tencent.mm.pluginsdk.wallet.a)g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).startResetPwdUseCase(paramAnonymousDialogInterface, null);
                }
                for (paramAnonymousInt = 1;; paramAnonymousInt = 0)
                {
                  if (paramAnonymousInt != 0) {
                    break label223;
                  }
                  com.tencent.mm.wallet_core.a.b(paramWalletBaseUI, "ForgotPwdProcess", null);
                  break;
                  ac.d("MicroMsg.WalletErrMgr", "startKindaResetPwd:false");
                }
              }
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(72845);
              this.BhP.cleanUiData(1);
              AppMethodBeat.o(72845);
            }
          });
        }
        if (locald != null)
        {
          bool = locald.a(paramWalletBaseUI, paramInt2, paramString);
          paramInt1 = 1;
          break label145;
          TenpaySecureEditText.setSalt(e.fAR());
          if (u.axL()) {
            b(paramWalletBaseUI, paramInt2, paramString);
          }
          for (;;)
          {
            bool = true;
            paramInt1 = 1;
            break;
            com.tencent.mm.ui.base.h.a(paramWalletBaseUI, paramString, null, false, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(72846);
                com.tencent.mm.wallet_core.a.b(this.BhP, new Bundle(), paramInt2);
                if (this.BhP.isTransparent()) {
                  this.BhP.finish();
                }
                AppMethodBeat.o(72846);
              }
            });
          }
          if (locald != null)
          {
            bool = locald.a(paramWalletBaseUI, paramInt2, paramString);
            paramInt1 = 1;
            break label145;
            paramInt1 = i;
            if ((paramn instanceof com.tencent.mm.wallet_core.tenpay.model.n)) {
              paramInt1 = ((com.tencent.mm.wallet_core.tenpay.model.n)paramn).Bya;
            }
            if (paramInt1 == 1) {
              com.tencent.mm.ui.base.h.a(paramWalletBaseUI, paramString, "", paramWalletBaseUI.getString(2131765273), new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                {
                  AppMethodBeat.i(72847);
                  if (this.BhP.isTransparent()) {
                    this.BhP.finish();
                  }
                  AppMethodBeat.o(72847);
                }
              });
            }
            for (;;)
            {
              bool = true;
              paramInt1 = 1;
              break;
              com.tencent.mm.ui.base.h.d(paramWalletBaseUI, paramString, "", paramWalletBaseUI.getString(2131765812), paramWalletBaseUI.getString(2131755691), new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                {
                  AppMethodBeat.i(72848);
                  this.BhP.resend(true);
                  AppMethodBeat.o(72848);
                }
              }, null);
            }
            com.tencent.mm.ui.base.h.d(paramWalletBaseUI, paramString, "", paramWalletBaseUI.getString(2131765930), paramWalletBaseUI.getString(2131755691), new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(72849);
                paramAnonymousDialogInterface = new Bundle();
                paramAnonymousDialogInterface.putBoolean("key_is_bind_bankcard", false);
                com.tencent.mm.wallet_core.a.a(this.BhP, "BindCardProcess", paramAnonymousDialogInterface, new d.a()
                {
                  public final Intent r(int paramAnonymous2Int, Bundle paramAnonymous2Bundle)
                  {
                    return null;
                  }
                });
                AppMethodBeat.o(72849);
              }
            }, null);
            bool = true;
            paramInt1 = 1;
            break label145;
            TenpaySecureEditText.setSalt(e.fAR());
            b(paramWalletBaseUI, paramInt2, paramString);
            bool = true;
            paramInt1 = 1;
            break label145;
            com.tencent.mm.ui.base.h.a(paramWalletBaseUI, paramWalletBaseUI.getString(2131765255), null, false, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(72850);
                com.tencent.mm.wallet_core.a.b(this.BhP, this.BhP.getInput(), paramInt2);
                if (this.BhP.isTransparent()) {
                  this.BhP.finish();
                }
                AppMethodBeat.o(72850);
              }
            });
            bool = true;
            paramInt1 = 1;
            break label145;
            com.tencent.mm.ui.base.h.a(paramWalletBaseUI, paramWalletBaseUI.getString(2131765254), null, false, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(72851);
                com.tencent.mm.wallet_core.a.b(this.BhP, this.BhP.getInput(), paramInt2);
                if (this.BhP.isTransparent()) {
                  this.BhP.finish();
                }
                AppMethodBeat.o(72851);
              }
            });
            bool = true;
            break;
            paramWalletBaseUI.setmPayResultType(3);
            break label154;
          }
        }
        bool = false;
        paramInt1 = 1;
        break label145;
      }
    }
  }
  
  private static void b(WalletBaseUI paramWalletBaseUI, final int paramInt, String paramString)
  {
    AppMethodBeat.i(72854);
    com.tencent.mm.ui.base.h.a(paramWalletBaseUI, false, paramString, "", paramWalletBaseUI.getString(2131765253), paramWalletBaseUI.getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(72842);
        e.aT(this.BhP, "https://www.payu.co.za/wechat/contact-us/");
        if ((this.BhP.isTransparent()) || (this.BhP.getContentViewVisibility() != 0)) {
          this.BhP.finish();
        }
        AppMethodBeat.o(72842);
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(72843);
        com.tencent.mm.wallet_core.a.b(this.BhP, this.BhP.getInput(), paramInt);
        if ((this.BhP.isTransparent()) || (this.BhP.getContentViewVisibility() != 0)) {
          this.BhP.finish();
        }
        AppMethodBeat.o(72843);
      }
    });
    AppMethodBeat.o(72854);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.d.h
 * JD-Core Version:    0.7.0.1
 */