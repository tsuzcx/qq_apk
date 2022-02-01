package com.tencent.mm.plugin.wallet_ecard.a;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.protocal.protobuf.caz;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.d.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public final class b
{
  public static void a(int paramInt, String paramString1, String paramString2, String paramString3, Context paramContext, d.a parama)
  {
    AppMethodBeat.i(71687);
    ad.i("MicroMsg.ECardUtil", "start open ecard process, scene: %s, token==null%s, eCardType: %s, extraData: %s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bt.isNullOrNil(paramString1)), paramString2, paramString3 });
    Bundle localBundle = new Bundle();
    localBundle.putInt(a.AvM, paramInt);
    localBundle.putString(a.AvN, paramString1);
    localBundle.putString(a.AvR, paramString2);
    localBundle.putString(a.AvS, paramString3);
    com.tencent.mm.wallet_core.a.a((Activity)paramContext, com.tencent.mm.plugin.wallet_ecard.b.b.class, localBundle, parama);
    AppMethodBeat.o(71687);
  }
  
  public static boolean a(WalletBaseUI paramWalletBaseUI, n paramn, int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(71686);
    if (paramInt2 == 0) {
      paramString2 = paramString1;
    }
    for (;;)
    {
      ad.i("MicroMsg.ECardUtil", "finalRetCode: %s, finalRetMsg: %s", new Object[] { Integer.valueOf(paramInt1), paramString2 });
      if (paramInt1 == 269293577)
      {
        com.tencent.mm.ui.base.h.a(paramWalletBaseUI, paramString1, "", false, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        AppMethodBeat.o(71686);
        return true;
      }
      boolean bool = com.tencent.mm.wallet_core.d.h.a(paramWalletBaseUI, paramn, 1000, paramInt1, paramString2);
      AppMethodBeat.o(71686);
      return bool;
      paramInt1 = paramInt2;
    }
  }
  
  public static boolean a(final WalletBaseUI paramWalletBaseUI, caz paramcaz)
  {
    AppMethodBeat.i(71684);
    if (paramcaz == null) {
      ad.i("MicroMsg.ECardUtil", "no popItem");
    }
    do
    {
      do
      {
        AppMethodBeat.o(71684);
        return false;
      } while (bt.isNullOrNil(paramcaz.DwR));
      if ((!bt.isNullOrNil(paramcaz.zPB)) && (!bt.isNullOrNil(paramcaz.DXn)))
      {
        ad.i("MicroMsg.ECardUtil", "show guide info 1");
        com.tencent.mm.ui.base.h.a(paramWalletBaseUI, paramcaz.DwR, "", paramcaz.zPB, paramcaz.DXn, false, new b.1(paramcaz, paramWalletBaseUI), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(71682);
            d locald;
            if (this.Awk.DBz == a.AvI)
            {
              ad.i("MicroMsg.ECardUtil", "do end process");
              locald = paramWalletBaseUI.getProcess();
              if (locald != null) {
                locald.b(paramWalletBaseUI, new Bundle());
              }
            }
            for (;;)
            {
              paramAnonymousDialogInterface.dismiss();
              AppMethodBeat.o(71682);
              return;
              paramWalletBaseUI.finish();
              continue;
              if (this.Awk.DBz == a.AvL)
              {
                ad.i("MicroMsg.ECardUtil", "back bank list");
                locald = paramWalletBaseUI.getProcess();
                if (locald != null) {
                  locald.g(paramWalletBaseUI, 100);
                } else {
                  paramWalletBaseUI.finish();
                }
              }
            }
          }
        });
        AppMethodBeat.o(71684);
        return true;
      }
    } while (bt.isNullOrNil(paramcaz.DXn));
    ad.i("MicroMsg.ECardUtil", "show guide info 2");
    com.tencent.mm.ui.base.h.a(paramWalletBaseUI, paramcaz.DwR, "", paramcaz.DXn, false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(71683);
        d locald;
        if (this.Awk.DBz == a.AvI)
        {
          ad.i("MicroMsg.ECardUtil", "do end process");
          locald = paramWalletBaseUI.getProcess();
          if (locald != null) {
            locald.b(paramWalletBaseUI, new Bundle());
          }
        }
        for (;;)
        {
          paramAnonymousDialogInterface.dismiss();
          AppMethodBeat.o(71683);
          return;
          paramWalletBaseUI.finish();
          continue;
          if (this.Awk.DBz == a.AvL)
          {
            ad.i("MicroMsg.ECardUtil", "back bank list");
            locald = paramWalletBaseUI.getProcess();
            if (locald != null) {
              locald.g(paramWalletBaseUI, 100);
            } else {
              paramWalletBaseUI.finish();
            }
          }
        }
      }
    });
    AppMethodBeat.o(71684);
    return true;
  }
  
  public static String d(Context paramContext, String... paramVarArgs)
  {
    AppMethodBeat.i(71685);
    paramContext = paramContext.getString(2131765901);
    int i;
    if (paramVarArgs.length > 0)
    {
      int j = paramVarArgs.length;
      i = 0;
      if (i < j)
      {
        String str = paramVarArgs[i];
        if (!bt.isNullOrNil(str)) {
          paramContext = str;
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(71685);
      return paramContext;
      i += 1;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.a.b
 * JD-Core Version:    0.7.0.1
 */