package com.tencent.mm.wallet_core.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.tenpay.model.n;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public final class h
{
  public static boolean a(WalletBaseUI paramWalletBaseUI, m paramm, int paramInt1, int paramInt2, String paramString)
  {
    int i = 0;
    boolean bool = false;
    AppMethodBeat.i(49136);
    if (paramInt1 == 1000)
    {
      if (!bo.isNullOrNil(paramString)) {
        break label580;
      }
      paramString = paramWalletBaseUI.getString(2131305682);
    }
    label145:
    label154:
    label580:
    for (;;)
    {
      c localc = a.aM(paramWalletBaseUI);
      switch (paramInt2)
      {
      default: 
        bool = false;
        paramInt1 = 0;
        if (paramInt1 != 0)
        {
          paramWalletBaseUI.setmPayResultType(2);
          if ((paramm instanceof com.tencent.mm.wallet_core.c.q)) {
            ((com.tencent.mm.wallet_core.c.q)paramm).setHasProcessWalletError(bool);
          }
          AppMethodBeat.o(49136);
          return bool;
        }
        break;
      case 401: 
        if (!(paramm instanceof n)) {}
        break;
      }
      for (paramInt1 = ((n)paramm).uju;; paramInt1 = 0)
      {
        if (paramInt1 == 1) {
          com.tencent.mm.ui.base.h.a(paramWalletBaseUI, paramString, "", paramWalletBaseUI.getString(2131305081), new h.1(paramWalletBaseUI));
        }
        for (;;)
        {
          bool = true;
          paramInt1 = 1;
          break;
          com.tencent.mm.ui.base.h.a(paramWalletBaseUI, false, paramString, "", paramWalletBaseUI.getString(2131305082), paramWalletBaseUI.getString(2131297061), new h.4(paramm, paramWalletBaseUI), new h.5(paramWalletBaseUI));
        }
        if (localc != null)
        {
          bool = localc.a(paramWalletBaseUI, paramInt2, paramString);
          paramInt1 = 1;
          break label145;
          dSF();
          if (r.ZB()) {
            b(paramWalletBaseUI, paramInt2, paramString);
          }
          for (;;)
          {
            bool = true;
            paramInt1 = 1;
            break;
            com.tencent.mm.ui.base.h.a(paramWalletBaseUI, paramString, null, false, new h.6(paramWalletBaseUI, paramInt2));
          }
          if (localc != null)
          {
            bool = localc.a(paramWalletBaseUI, paramInt2, paramString);
            paramInt1 = 1;
            break label145;
            paramInt1 = i;
            if ((paramm instanceof n)) {
              paramInt1 = ((n)paramm).uju;
            }
            if (paramInt1 == 1) {
              com.tencent.mm.ui.base.h.a(paramWalletBaseUI, paramString, "", paramWalletBaseUI.getString(2131305081), new h.7(paramWalletBaseUI));
            }
            for (;;)
            {
              bool = true;
              paramInt1 = 1;
              break;
              com.tencent.mm.ui.base.h.d(paramWalletBaseUI, paramString, "", paramWalletBaseUI.getString(2131305596), paramWalletBaseUI.getString(2131296888), new h.8(paramWalletBaseUI), null);
            }
            com.tencent.mm.ui.base.h.d(paramWalletBaseUI, paramString, "", paramWalletBaseUI.getString(2131305710), paramWalletBaseUI.getString(2131296888), new h.9(paramWalletBaseUI), null);
            bool = true;
            paramInt1 = 1;
            break label145;
            dSF();
            b(paramWalletBaseUI, paramInt2, paramString);
            bool = true;
            paramInt1 = 1;
            break label145;
            com.tencent.mm.ui.base.h.a(paramWalletBaseUI, paramWalletBaseUI.getString(2131305063), null, false, new h.10(paramWalletBaseUI, paramInt2));
            bool = true;
            paramInt1 = 1;
            break label145;
            com.tencent.mm.ui.base.h.a(paramWalletBaseUI, paramWalletBaseUI.getString(2131305062), null, false, new h.11(paramWalletBaseUI, paramInt2));
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
  
  private static void b(WalletBaseUI paramWalletBaseUI, int paramInt, String paramString)
  {
    AppMethodBeat.i(49138);
    com.tencent.mm.ui.base.h.a(paramWalletBaseUI, false, paramString, "", paramWalletBaseUI.getString(2131305061), paramWalletBaseUI.getString(2131296888), new h.2(paramWalletBaseUI), new h.3(paramWalletBaseUI, paramInt));
    AppMethodBeat.o(49138);
  }
  
  private static void dSF()
  {
    AppMethodBeat.i(49137);
    if (!r.ZB()) {}
    for (Object localObject = new com.tencent.mm.wallet_core.tenpay.model.q();; localObject = new com.tencent.mm.wallet_core.e.a.b())
    {
      g.RM();
      g.RK().eHt.a((m)localObject, 0);
      AppMethodBeat.o(49137);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.d.h
 * JD-Core Version:    0.7.0.1
 */