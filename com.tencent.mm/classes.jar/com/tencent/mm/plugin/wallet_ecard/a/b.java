package com.tencent.mm.plugin.wallet_ecard.a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.protocal.protobuf.bmu;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.c.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public final class b
{
  public static void a(int paramInt, String paramString1, String paramString2, String paramString3, Context paramContext, c.a parama)
  {
    AppMethodBeat.i(48054);
    ab.i("MicroMsg.ECardUtil", "start open ecard process, scene: %s, token==null%s, eCardType: %s, extraData: %s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bo.isNullOrNil(paramString1)), paramString2, paramString3 });
    Bundle localBundle = new Bundle();
    localBundle.putInt(a.uyJ, paramInt);
    localBundle.putString(a.uyK, paramString1);
    localBundle.putString(a.uyO, paramString2);
    localBundle.putString(a.uyP, paramString3);
    com.tencent.mm.wallet_core.a.a((Activity)paramContext, com.tencent.mm.plugin.wallet_ecard.b.b.class, localBundle, parama);
    AppMethodBeat.o(48054);
  }
  
  public static boolean a(WalletBaseUI paramWalletBaseUI, m paramm, int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(48053);
    if (paramInt2 == 0) {
      paramString2 = paramString1;
    }
    for (;;)
    {
      ab.i("MicroMsg.ECardUtil", "finalRetCode: %s, finalRetMsg: %s", new Object[] { Integer.valueOf(paramInt1), paramString2 });
      if (paramInt1 == 269293577)
      {
        com.tencent.mm.ui.base.h.a(paramWalletBaseUI, paramString1, "", false, new b.4());
        AppMethodBeat.o(48053);
        return true;
      }
      boolean bool = com.tencent.mm.wallet_core.d.h.a(paramWalletBaseUI, paramm, 1000, paramInt1, paramString2);
      AppMethodBeat.o(48053);
      return bool;
      paramInt1 = paramInt2;
    }
  }
  
  public static boolean a(WalletBaseUI paramWalletBaseUI, bmu parambmu)
  {
    AppMethodBeat.i(48051);
    if (parambmu == null) {
      ab.i("MicroMsg.ECardUtil", "no popItem");
    }
    do
    {
      do
      {
        AppMethodBeat.o(48051);
        return false;
      } while (bo.isNullOrNil(parambmu.xBf));
      if ((!bo.isNullOrNil(parambmu.tVo)) && (!bo.isNullOrNil(parambmu.xBg)))
      {
        ab.i("MicroMsg.ECardUtil", "show guide info 1");
        com.tencent.mm.ui.base.h.a(paramWalletBaseUI, parambmu.xBf, "", parambmu.tVo, parambmu.xBg, false, new b.1(parambmu, paramWalletBaseUI), new b.2(parambmu, paramWalletBaseUI));
        AppMethodBeat.o(48051);
        return true;
      }
    } while (bo.isNullOrNil(parambmu.xBg));
    ab.i("MicroMsg.ECardUtil", "show guide info 2");
    com.tencent.mm.ui.base.h.a(paramWalletBaseUI, parambmu.xBf, "", parambmu.xBg, false, new b.3(parambmu, paramWalletBaseUI));
    AppMethodBeat.o(48051);
    return true;
  }
  
  public static String d(Context paramContext, String... paramVarArgs)
  {
    AppMethodBeat.i(48052);
    paramContext = paramContext.getString(2131305682);
    int i;
    if (paramVarArgs.length > 0)
    {
      int j = paramVarArgs.length;
      i = 0;
      if (i < j)
      {
        String str = paramVarArgs[i];
        if (!bo.isNullOrNil(str)) {
          paramContext = str;
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(48052);
      return paramContext;
      i += 1;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.a.b
 * JD-Core Version:    0.7.0.1
 */