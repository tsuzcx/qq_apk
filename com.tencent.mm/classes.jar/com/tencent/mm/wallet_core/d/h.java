package com.tencent.mm.wallet_core.d;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.f.b.a.nu;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.b;
import com.tencent.mm.wallet_core.c.s;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.d.a;
import com.tencent.mm.wallet_core.tenpay.model.n;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.g;
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
        break label596;
      }
      paramString = paramWalletBaseUI.getString(a.i.wallet_unknown_err);
    }
    label145:
    label154:
    label596:
    for (;;)
    {
      d locald = com.tencent.mm.wallet_core.a.bF(paramWalletBaseUI);
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
      for (paramInt1 = ((n)paramq).ORm;; paramInt1 = 0)
      {
        if (paramInt1 == 1) {
          com.tencent.mm.ui.base.h.a(paramWalletBaseUI, paramString, "", paramWalletBaseUI.getString(a.i.wallet_forget_notretry_password), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(72841);
              if (this.Oxq.isTransparent()) {
                this.Oxq.finish();
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
          com.tencent.mm.ui.base.h.a(paramWalletBaseUI, false, paramString, "", paramWalletBaseUI.getString(a.i.wallet_forget_password), paramWalletBaseUI.getString(a.i.app_retry), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(72844);
              paramAnonymousDialogInterface = "";
              if ((this.ftz instanceof n)) {
                paramAnonymousDialogInterface = ((n)this.ftz).OAm;
              }
              if (!Util.isNullOrNil(paramAnonymousDialogInterface))
              {
                nu localnu = new nu();
                localnu.hal = 1L;
                localnu.ham = 2L;
                localnu.bpa();
                Log.i("MicroMsg.WalletErrMgr", "jump to forget_url %s", new Object[] { paramAnonymousDialogInterface });
                g.p(paramWalletBaseUI, paramAnonymousDialogInterface, false);
                AppMethodBeat.o(72844);
                return;
              }
              paramAnonymousDialogInterface = new nu();
              paramAnonymousDialogInterface.hal = 1L;
              paramAnonymousDialogInterface.ham = 1L;
              paramAnonymousDialogInterface.bpa();
              if (z.bdq()) {
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
                b.iie();
                if (b.b(b.a.vGX, false))
                {
                  Log.d("MicroMsg.WalletErrMgr", "startKindaResetPwd:true");
                  ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.pluginsdk.wallet.a.class)).startResetPwdUseCase(paramAnonymousDialogInterface, null);
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
              this.Oxq.cleanUiData(1);
              AppMethodBeat.o(72845);
            }
          });
        }
        if (locald != null)
        {
          bool = locald.a(paramWalletBaseUI, paramInt2, paramString);
          paramInt1 = 1;
          break label145;
          TenpaySecureEditText.setSalt(g.ijw());
          if (z.bdq()) {
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
                com.tencent.mm.wallet_core.a.b(this.Oxq, new Bundle(), paramInt2);
                if (this.Oxq.isTransparent()) {
                  this.Oxq.finish();
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
              paramInt1 = ((n)paramq).ORm;
            }
            if (paramInt1 == 1) {
              com.tencent.mm.ui.base.h.a(paramWalletBaseUI, paramString, "", paramWalletBaseUI.getString(a.i.wallet_forget_notretry_password), new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                {
                  AppMethodBeat.i(72847);
                  if (this.Oxq.isTransparent()) {
                    this.Oxq.finish();
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
              com.tencent.mm.ui.base.h.c(paramWalletBaseUI, paramString, "", paramWalletBaseUI.getString(a.i.wallet_retry), paramWalletBaseUI.getString(a.i.app_cancel), new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                {
                  AppMethodBeat.i(72848);
                  this.Oxq.resend(true);
                  AppMethodBeat.o(72848);
                }
              }, null);
            }
            com.tencent.mm.ui.base.h.c(paramWalletBaseUI, paramString, "", paramWalletBaseUI.getString(a.i.wallet_verify_user_info_tips), paramWalletBaseUI.getString(a.i.app_cancel), new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(72849);
                paramAnonymousDialogInterface = new Bundle();
                paramAnonymousDialogInterface.putBoolean("key_is_bind_bankcard", false);
                com.tencent.mm.wallet_core.a.a(this.Oxq, "BindCardProcess", paramAnonymousDialogInterface, new d.a()
                {
                  public final Intent s(int paramAnonymous2Int, Bundle paramAnonymous2Bundle)
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
            TenpaySecureEditText.setSalt(g.ijw());
            b(paramWalletBaseUI, paramInt2, paramString);
            bool = true;
            paramInt1 = 1;
            break label145;
            com.tencent.mm.ui.base.h.a(paramWalletBaseUI, paramWalletBaseUI.getString(a.i.wallet_err_wording_payment_not_match), null, false, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(72850);
                com.tencent.mm.wallet_core.a.b(this.Oxq, this.Oxq.getInput(), paramInt2);
                if (this.Oxq.isTransparent()) {
                  this.Oxq.finish();
                }
                AppMethodBeat.o(72850);
              }
            });
            bool = true;
            paramInt1 = 1;
            break label145;
            com.tencent.mm.ui.base.h.a(paramWalletBaseUI, paramWalletBaseUI.getString(a.i.wallet_err_wording_not_open_wallet), null, false, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(72851);
                com.tencent.mm.wallet_core.a.b(this.Oxq, this.Oxq.getInput(), paramInt2);
                if (this.Oxq.isTransparent()) {
                  this.Oxq.finish();
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
    com.tencent.mm.ui.base.h.a(paramWalletBaseUI, false, paramString, "", paramWalletBaseUI.getString(a.i.wallet_err_wording_contact_me_payu), paramWalletBaseUI.getString(a.i.app_cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(72842);
        g.bA(this.Oxq, "https://www.payu.co.za/wechat/contact-us/");
        if ((this.Oxq.isTransparent()) || (this.Oxq.getContentViewVisibility() != 0)) {
          this.Oxq.finish();
        }
        AppMethodBeat.o(72842);
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(72843);
        com.tencent.mm.wallet_core.a.b(this.Oxq, this.Oxq.getInput(), paramInt);
        if ((this.Oxq.isTransparent()) || (this.Oxq.getContentViewVisibility() != 0)) {
          this.Oxq.finish();
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