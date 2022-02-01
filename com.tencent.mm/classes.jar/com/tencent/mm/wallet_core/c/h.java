package com.tencent.mm.wallet_core.c;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.mmdata.rpt.rm;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.wallet_core.b;
import com.tencent.mm.wallet_core.e;
import com.tencent.mm.wallet_core.e.a;
import com.tencent.mm.wallet_core.model.s;
import com.tencent.mm.wallet_core.tenpay.model.n;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.i;
import com.tenpay.android.wechat.TenpaySecureEditText;

public final class h
{
  public static boolean a(final WalletBaseUI paramWalletBaseUI, p paramp, int paramInt1, final int paramInt2, String paramString)
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
      e locale = com.tencent.mm.wallet_core.a.cm(paramWalletBaseUI);
      switch (paramInt2)
      {
      default: 
        bool = false;
        paramInt1 = 0;
        if (paramInt1 != 0)
        {
          paramWalletBaseUI.setmPayResultType(2);
          if ((paramp instanceof s)) {
            ((s)paramp).setHasProcessWalletError(bool);
          }
          AppMethodBeat.o(72852);
          return bool;
        }
        break;
      case 401: 
        if (!(paramp instanceof n)) {}
        break;
      }
      for (paramInt1 = ((n)paramp).VHg;; paramInt1 = 0)
      {
        if (paramInt1 == 1) {
          k.a(paramWalletBaseUI, paramString, "", paramWalletBaseUI.getString(a.i.wallet_forget_notretry_password), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(72841);
              if (h.this.isTransparent()) {
                h.this.finish();
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
          k.a(paramWalletBaseUI, false, paramString, "", paramWalletBaseUI.getString(a.i.wallet_forget_password), paramWalletBaseUI.getString(a.i.app_retry), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(72844);
              paramAnonymousDialogInterface = "";
              if ((h.this instanceof n)) {
                paramAnonymousDialogInterface = ((n)h.this).Vpz;
              }
              if (!Util.isNullOrNil(paramAnonymousDialogInterface))
              {
                rm localrm = new rm();
                localrm.jvV = 1L;
                localrm.jvW = 2L;
                localrm.bMH();
                Log.i("MicroMsg.WalletErrMgr", "jump to forget_url %s", new Object[] { paramAnonymousDialogInterface });
                i.p(paramWalletBaseUI, paramAnonymousDialogInterface, false);
                AppMethodBeat.o(72844);
                return;
              }
              paramAnonymousDialogInterface = new rm();
              paramAnonymousDialogInterface.jvV = 1L;
              paramAnonymousDialogInterface.jvW = 1L;
              paramAnonymousDialogInterface.bMH();
              if (z.bBi()) {
                com.tencent.mm.wallet_core.a.b(paramWalletBaseUI, "PayUForgotPwdProcess", null);
              }
              for (;;)
              {
                if (paramWalletBaseUI.isTransparent()) {
                  paramWalletBaseUI.finish();
                }
                AppMethodBeat.o(72844);
                return;
                paramAnonymousDialogInterface = paramWalletBaseUI;
                b.jNX();
                Log.d("MicroMsg.WalletErrMgr", "startKindaResetPwd:true");
                ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.pluginsdk.wallet.a.class)).startResetPwdUseCase(paramAnonymousDialogInterface, null);
              }
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(72845);
              h.this.cleanUiData(1);
              AppMethodBeat.o(72845);
            }
          });
        }
        if (locale != null)
        {
          bool = locale.a(paramWalletBaseUI, paramInt2, paramString);
          paramInt1 = 1;
          break label145;
          TenpaySecureEditText.setSalt(i.jPu());
          if (z.bBi()) {
            b(paramWalletBaseUI, paramInt2, paramString);
          }
          for (;;)
          {
            bool = true;
            paramInt1 = 1;
            break;
            k.a(paramWalletBaseUI, paramString, null, false, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(72846);
                com.tencent.mm.wallet_core.a.b(h.this, new Bundle(), paramInt2);
                if (h.this.isTransparent()) {
                  h.this.finish();
                }
                AppMethodBeat.o(72846);
              }
            });
          }
          if (locale != null)
          {
            bool = locale.a(paramWalletBaseUI, paramInt2, paramString);
            paramInt1 = 1;
            break label145;
            paramInt1 = i;
            if ((paramp instanceof n)) {
              paramInt1 = ((n)paramp).VHg;
            }
            if (paramInt1 == 1) {
              k.a(paramWalletBaseUI, paramString, "", paramWalletBaseUI.getString(a.i.wallet_forget_notretry_password), new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                {
                  AppMethodBeat.i(72847);
                  if (h.this.isTransparent()) {
                    h.this.finish();
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
              k.b(paramWalletBaseUI, paramString, "", paramWalletBaseUI.getString(a.i.wallet_retry), paramWalletBaseUI.getString(a.i.app_cancel), new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                {
                  AppMethodBeat.i(72848);
                  h.this.resend(true);
                  AppMethodBeat.o(72848);
                }
              }, null);
            }
            k.b(paramWalletBaseUI, paramString, "", paramWalletBaseUI.getString(a.i.wallet_verify_user_info_tips), paramWalletBaseUI.getString(a.i.app_cancel), new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(72849);
                paramAnonymousDialogInterface = new Bundle();
                paramAnonymousDialogInterface.putBoolean("key_is_bind_bankcard", false);
                com.tencent.mm.wallet_core.a.a(h.this, "BindCardProcess", paramAnonymousDialogInterface, new e.a()
                {
                  public final Intent v(int paramAnonymous2Int, Bundle paramAnonymous2Bundle)
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
            TenpaySecureEditText.setSalt(i.jPu());
            b(paramWalletBaseUI, paramInt2, paramString);
            bool = true;
            paramInt1 = 1;
            break label145;
            k.a(paramWalletBaseUI, paramWalletBaseUI.getString(a.i.wallet_err_wording_payment_not_match), null, false, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(72850);
                com.tencent.mm.wallet_core.a.b(h.this, h.this.getInput(), paramInt2);
                if (h.this.isTransparent()) {
                  h.this.finish();
                }
                AppMethodBeat.o(72850);
              }
            });
            bool = true;
            paramInt1 = 1;
            break label145;
            k.a(paramWalletBaseUI, paramWalletBaseUI.getString(a.i.wallet_err_wording_not_open_wallet), null, false, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(72851);
                com.tencent.mm.wallet_core.a.b(h.this, h.this.getInput(), paramInt2);
                if (h.this.isTransparent()) {
                  h.this.finish();
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
    k.a(paramWalletBaseUI, false, paramString, "", paramWalletBaseUI.getString(a.i.wallet_err_wording_contact_me_payu), paramWalletBaseUI.getString(a.i.app_cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(72842);
        i.bC(h.this, "https://www.payu.co.za/wechat/contact-us/");
        if ((h.this.isTransparent()) || (h.this.getContentViewVisibility() != 0)) {
          h.this.finish();
        }
        AppMethodBeat.o(72842);
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(72843);
        com.tencent.mm.wallet_core.a.b(h.this, h.this.getInput(), paramInt);
        if ((h.this.isTransparent()) || (h.this.getContentViewVisibility() != 0)) {
          h.this.finish();
        }
        AppMethodBeat.o(72843);
      }
    });
    AppMethodBeat.o(72854);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.h
 * JD-Core Version:    0.7.0.1
 */