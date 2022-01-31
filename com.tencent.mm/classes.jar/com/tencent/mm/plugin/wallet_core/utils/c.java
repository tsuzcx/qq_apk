package com.tencent.mm.plugin.wallet_core.utils;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bo;

public final class c
{
  public static int IK(int paramInt)
  {
    switch (paramInt)
    {
    case 3: 
    default: 
      return 3;
    case 0: 
      return 0;
    case 1: 
      return 1;
    }
    return 2;
  }
  
  public static String ac(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(142576);
    switch (paramInt)
    {
    default: 
      paramContext = "";
    }
    for (;;)
    {
      AppMethodBeat.o(142576);
      return paramContext;
      paramContext = a.aq(paramContext, 2131305292);
      continue;
      paramContext = a.aq(paramContext, 2131305297);
      continue;
      paramContext = a.aq(paramContext, 2131305298);
      continue;
      paramContext = a.aq(paramContext, 2131305299);
      continue;
      paramContext = a.aq(paramContext, 2131305300);
      continue;
      paramContext = a.aq(paramContext, 2131305301);
      continue;
      paramContext = a.aq(paramContext, 2131305302);
      continue;
      paramContext = a.aq(paramContext, 2131305303);
      continue;
      paramContext = a.aq(paramContext, 2131305304);
      continue;
      paramContext = a.aq(paramContext, 2131305293);
      continue;
      paramContext = a.aq(paramContext, 2131305294);
      continue;
      paramContext = a.aq(paramContext, 2131305295);
      continue;
      paramContext = a.aq(paramContext, 2131305296);
    }
  }
  
  public static boolean av(Intent paramIntent)
  {
    AppMethodBeat.i(48008);
    if (paramIntent == null)
    {
      AppMethodBeat.o(48008);
      return false;
    }
    int i = paramIntent.getIntExtra("key_pay_reslut_type", 0);
    if (i == 1000)
    {
      ab.i("MicroMsg.WalletPayUtil", "onActivityResult isCanFinish %s %s", new Object[] { Integer.valueOf(i), bo.dtY().toString() });
      AppMethodBeat.o(48008);
      return true;
    }
    AppMethodBeat.o(48008);
    return false;
  }
  
  public static boolean aw(Intent paramIntent)
  {
    AppMethodBeat.i(48009);
    if (paramIntent == null)
    {
      AppMethodBeat.o(48009);
      return false;
    }
    int i = paramIntent.getIntExtra("key_pay_reslut_type", 0);
    if (i == 1001)
    {
      ab.i("MicroMsg.WalletPayUtil", "onActivityResult isCanIgnore %s %s", new Object[] { Integer.valueOf(i), bo.dtY().toString() });
      AppMethodBeat.o(48009);
      return true;
    }
    AppMethodBeat.o(48009);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.utils.c
 * JD-Core Version:    0.7.0.1
 */