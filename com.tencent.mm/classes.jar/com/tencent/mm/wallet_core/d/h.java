package com.tencent.mm.wallet_core.d;

import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.c.o;
import com.tencent.mm.wallet_core.tenpay.model.k;
import com.tencent.mm.wallet_core.tenpay.model.n;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public final class h
{
  public static boolean a(WalletBaseUI paramWalletBaseUI, m paramm, int paramInt1, int paramInt2, String paramString)
  {
    int i = 0;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramInt1 == 1000)
    {
      if (!bk.bl(paramString)) {
        break label551;
      }
      paramString = paramWalletBaseUI.getString(a.i.wallet_unknown_err);
    }
    label551:
    for (;;)
    {
      c localc = a.aj(paramWalletBaseUI);
      switch (paramInt2)
      {
      default: 
        bool1 = bool2;
        if ((paramm instanceof o)) {
          ((o)paramm).wAH = bool1;
        }
        return bool1;
      case 401: 
        if (!(paramm instanceof k)) {
          break;
        }
      }
      for (paramInt1 = ((k)paramm).qwW;; paramInt1 = 0)
      {
        if (paramInt1 == 1) {
          com.tencent.mm.ui.base.h.a(paramWalletBaseUI, paramString, "", paramWalletBaseUI.getString(a.i.wallet_forget_notretry_password), new h.1(paramWalletBaseUI));
        }
        for (;;)
        {
          bool1 = true;
          break;
          com.tencent.mm.ui.base.h.a(paramWalletBaseUI, false, paramString, "", paramWalletBaseUI.getString(a.i.wallet_forget_password), paramWalletBaseUI.getString(a.i.app_retry), new h.4(paramm, paramWalletBaseUI), new h.5(paramWalletBaseUI));
        }
        bool1 = bool2;
        if (localc == null) {
          break;
        }
        bool1 = localc.a(paramWalletBaseUI, paramInt2, paramString);
        break;
        cMR();
        if (q.Gw()) {
          b(paramWalletBaseUI, paramInt2, paramString);
        }
        for (;;)
        {
          bool1 = true;
          break;
          com.tencent.mm.ui.base.h.a(paramWalletBaseUI, paramString, null, false, new h.6(paramWalletBaseUI, paramInt2));
        }
        bool1 = bool2;
        if (localc == null) {
          break;
        }
        bool1 = localc.a(paramWalletBaseUI, paramInt2, paramString);
        break;
        paramInt1 = i;
        if ((paramm instanceof k)) {
          paramInt1 = ((k)paramm).qwW;
        }
        if (paramInt1 == 1) {
          com.tencent.mm.ui.base.h.a(paramWalletBaseUI, paramString, "", paramWalletBaseUI.getString(a.i.wallet_forget_notretry_password), new h.7(paramWalletBaseUI));
        }
        for (;;)
        {
          bool1 = true;
          break;
          com.tencent.mm.ui.base.h.a(paramWalletBaseUI, paramString, "", paramWalletBaseUI.getString(a.i.wallet_retry), paramWalletBaseUI.getString(a.i.app_cancel), new h.8(paramWalletBaseUI), null);
        }
        com.tencent.mm.ui.base.h.a(paramWalletBaseUI, paramString, "", paramWalletBaseUI.getString(a.i.wallet_verify_user_info_tips), paramWalletBaseUI.getString(a.i.app_cancel), new h.9(paramWalletBaseUI), null);
        bool1 = true;
        break;
        cMR();
        b(paramWalletBaseUI, paramInt2, paramString);
        bool1 = true;
        break;
        com.tencent.mm.ui.base.h.a(paramWalletBaseUI, paramWalletBaseUI.getString(a.i.wallet_err_wording_payment_not_match), null, false, new h.10(paramWalletBaseUI, paramInt2));
        bool1 = true;
        break;
        com.tencent.mm.ui.base.h.a(paramWalletBaseUI, paramWalletBaseUI.getString(a.i.wallet_err_wording_not_open_wallet), null, false, new h.11(paramWalletBaseUI, paramInt2));
        bool1 = true;
        break;
      }
    }
  }
  
  private static void b(WalletBaseUI paramWalletBaseUI, int paramInt, String paramString)
  {
    com.tencent.mm.ui.base.h.a(paramWalletBaseUI, false, paramString, "", paramWalletBaseUI.getString(a.i.wallet_err_wording_contact_me_payu), paramWalletBaseUI.getString(a.i.app_cancel), new h.2(paramWalletBaseUI), new h.3(paramWalletBaseUI, paramInt));
  }
  
  private static void cMR()
  {
    if (!q.Gw()) {}
    for (Object localObject = new n();; localObject = new com.tencent.mm.wallet_core.e.a.b())
    {
      g.DQ();
      g.DO().dJT.a((m)localObject, 0);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.wallet_core.d.h
 * JD-Core Version:    0.7.0.1
 */