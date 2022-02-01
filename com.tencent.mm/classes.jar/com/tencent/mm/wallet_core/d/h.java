package com.tencent.mm.wallet_core.d;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.b.a.ky;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.b;
import com.tencent.mm.wallet_core.c.s;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.d.a;
import com.tencent.mm.wallet_core.tenpay.model.n;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.f;
import com.tenpay.android.wechat.TenpaySecureEditText;

public final class h
{
  public static boolean a(final WalletBaseUI paramWalletBaseUI, q paramq, int paramInt1, final int paramInt2, String paramString)
  {
    int i = 0;
    boolean bool = false;
    AppMethodBeat.i(72852);
    if (paramInt1 == 1000)
    {
      if (!Util.isNullOrNil(paramString)) {
        break label586;
      }
      paramString = paramWalletBaseUI.getString(2131768354);
    }
    label145:
    label154:
    label586:
    for (;;)
    {
      d locald = com.tencent.mm.wallet_core.a.by(paramWalletBaseUI);
      switch (paramInt2)
      {
      default: 
        bool = false;
        paramInt1 = 0;
        if (paramInt1 != 0)
        {
          paramWalletBaseUI.setmPayResultType(2);
          if ((paramq instanceof s)) {
            ((s)paramq).setHasProcessWalletError(bool);
          }
          AppMethodBeat.o(72852);
          return bool;
        }
        break;
      case 401: 
        if (!(paramq instanceof n)) {}
        break;
      }
      for (paramInt1 = ((n)paramq).HZm;; paramInt1 = 0)
      {
        if (paramInt1 == 1) {
          com.tencent.mm.ui.base.h.a(paramWalletBaseUI, paramString, "", paramWalletBaseUI.getString(2131767716), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(72841);
              if (this.HFx.isTransparent()) {
                this.HFx.finish();
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
          com.tencent.mm.ui.base.h.a(paramWalletBaseUI, false, paramString, "", paramWalletBaseUI.getString(2131767717), paramWalletBaseUI.getString(2131755967), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(72844);
              paramAnonymousDialogInterface = "";
              if ((this.dAK instanceof n)) {
                paramAnonymousDialogInterface = ((n)this.dAK).HIu;
              }
              if (!Util.isNullOrNil(paramAnonymousDialogInterface))
              {
                ky localky = new ky();
                localky.eXG = 1L;
                localky.eXH = 2L;
                localky.bfK();
                Log.i("MicroMsg.WalletErrMgr", "jump to forget_url %s", new Object[] { paramAnonymousDialogInterface });
                f.p(paramWalletBaseUI, paramAnonymousDialogInterface, false);
                AppMethodBeat.o(72844);
                return;
              }
              paramAnonymousDialogInterface = new ky();
              paramAnonymousDialogInterface.eXG = 1L;
              paramAnonymousDialogInterface.eXH = 1L;
              paramAnonymousDialogInterface.bfK();
              if (z.aUo()) {
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
                b.hgC();
                if (b.b(b.a.rZV, false))
                {
                  Log.d("MicroMsg.WalletErrMgr", "startKindaResetPwd:true");
                  ((com.tencent.mm.pluginsdk.wallet.a)g.af(com.tencent.mm.pluginsdk.wallet.a.class)).startResetPwdUseCase(paramAnonymousDialogInterface, null);
                }
                for (paramAnonymousInt = 1;; paramAnonymousInt = 0)
                {
                  if (paramAnonymousInt != 0) {
                    break label223;
                  }
                  com.tencent.mm.wallet_core.a.b(paramWalletBaseUI, "ForgotPwdProcess", null);
                  break;
                  Log.d("MicroMsg.WalletErrMgr", "startKindaResetPwd:false");
                }
              }
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(72845);
              this.HFx.cleanUiData(1);
              AppMethodBeat.o(72845);
            }
          });
        }
        if (locald != null)
        {
          bool = locald.a(paramWalletBaseUI, paramInt2, paramString);
          paramInt1 = 1;
          break label145;
          TenpaySecureEditText.setSalt(f.hhV());
          if (z.aUo()) {
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
                com.tencent.mm.wallet_core.a.c(this.HFx, new Bundle(), paramInt2);
                if (this.HFx.isTransparent()) {
                  this.HFx.finish();
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
            if ((paramq instanceof n)) {
              paramInt1 = ((n)paramq).HZm;
            }
            if (paramInt1 == 1) {
              com.tencent.mm.ui.base.h.a(paramWalletBaseUI, paramString, "", paramWalletBaseUI.getString(2131767716), new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                {
                  AppMethodBeat.i(72847);
                  if (this.HFx.isTransparent()) {
                    this.HFx.finish();
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
              com.tencent.mm.ui.base.h.c(paramWalletBaseUI, paramString, "", paramWalletBaseUI.getString(2131768265), paramWalletBaseUI.getString(2131755761), new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                {
                  AppMethodBeat.i(72848);
                  this.HFx.resend(true);
                  AppMethodBeat.o(72848);
                }
              }, null);
            }
            com.tencent.mm.ui.base.h.c(paramWalletBaseUI, paramString, "", paramWalletBaseUI.getString(2131768383), paramWalletBaseUI.getString(2131755761), new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(72849);
                paramAnonymousDialogInterface = new Bundle();
                paramAnonymousDialogInterface.putBoolean("key_is_bind_bankcard", false);
                com.tencent.mm.wallet_core.a.a(this.HFx, "BindCardProcess", paramAnonymousDialogInterface, new d.a()
                {
                  public final Intent q(int paramAnonymous2Int, Bundle paramAnonymous2Bundle)
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
            TenpaySecureEditText.setSalt(f.hhV());
            b(paramWalletBaseUI, paramInt2, paramString);
            bool = true;
            paramInt1 = 1;
            break label145;
            com.tencent.mm.ui.base.h.a(paramWalletBaseUI, paramWalletBaseUI.getString(2131767698), null, false, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(72850);
                com.tencent.mm.wallet_core.a.c(this.HFx, this.HFx.getInput(), paramInt2);
                if (this.HFx.isTransparent()) {
                  this.HFx.finish();
                }
                AppMethodBeat.o(72850);
              }
            });
            bool = true;
            paramInt1 = 1;
            break label145;
            com.tencent.mm.ui.base.h.a(paramWalletBaseUI, paramWalletBaseUI.getString(2131767697), null, false, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(72851);
                com.tencent.mm.wallet_core.a.c(this.HFx, this.HFx.getInput(), paramInt2);
                if (this.HFx.isTransparent()) {
                  this.HFx.finish();
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
    com.tencent.mm.ui.base.h.a(paramWalletBaseUI, false, paramString, "", paramWalletBaseUI.getString(2131767696), paramWalletBaseUI.getString(2131755761), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(72842);
        f.bn(this.HFx, "https://www.payu.co.za/wechat/contact-us/");
        if ((this.HFx.isTransparent()) || (this.HFx.getContentViewVisibility() != 0)) {
          this.HFx.finish();
        }
        AppMethodBeat.o(72842);
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(72843);
        com.tencent.mm.wallet_core.a.c(this.HFx, this.HFx.getInput(), paramInt);
        if ((this.HFx.isTransparent()) || (this.HFx.getContentViewVisibility() != 0)) {
          this.HFx.finish();
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