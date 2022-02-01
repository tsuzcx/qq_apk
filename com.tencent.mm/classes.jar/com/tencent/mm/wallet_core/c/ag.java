package com.tencent.mm.wallet_core.c;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;

public final class ag
{
  public static int azH(int paramInt)
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
  
  public static boolean bL(Intent paramIntent)
  {
    AppMethodBeat.i(163884);
    if (paramIntent == null)
    {
      AppMethodBeat.o(163884);
      return false;
    }
    int i = paramIntent.getIntExtra("key_pay_reslut_type", 0);
    if (i == 1000)
    {
      Log.i("MicroMsg.WalletPayUtil", "onActivityResult isCanFinish %s %s", new Object[] { Integer.valueOf(i), Util.getStack().toString() });
      AppMethodBeat.o(163884);
      return true;
    }
    AppMethodBeat.o(163884);
    return false;
  }
  
  public static boolean bM(Intent paramIntent)
  {
    AppMethodBeat.i(163885);
    if (paramIntent == null)
    {
      AppMethodBeat.o(163885);
      return false;
    }
    int i = paramIntent.getIntExtra("key_pay_reslut_type", 0);
    if (i == 1001)
    {
      Log.i("MicroMsg.WalletPayUtil", "onActivityResult isCanIgnore %s %s", new Object[] { Integer.valueOf(i), Util.getStack().toString() });
      AppMethodBeat.o(163885);
      return true;
    }
    AppMethodBeat.o(163885);
    return false;
  }
  
  public static String bk(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(163886);
    switch (paramInt)
    {
    default: 
      paramContext = "";
    }
    for (;;)
    {
      AppMethodBeat.o(163886);
      return paramContext;
      paramContext = a.ba(paramContext, a.i.wallet_max_unit_1);
      continue;
      paramContext = a.ba(paramContext, a.i.wallet_max_unit_2);
      continue;
      paramContext = a.ba(paramContext, a.i.wallet_max_unit_3);
      continue;
      paramContext = a.ba(paramContext, a.i.wallet_max_unit_4);
      continue;
      paramContext = a.ba(paramContext, a.i.wallet_max_unit_5);
      continue;
      paramContext = a.ba(paramContext, a.i.wallet_max_unit_6);
      continue;
      paramContext = a.ba(paramContext, a.i.wallet_max_unit_7);
      continue;
      paramContext = a.ba(paramContext, a.i.wallet_max_unit_8);
      continue;
      paramContext = a.ba(paramContext, a.i.wallet_max_unit_9);
      continue;
      paramContext = a.ba(paramContext, a.i.wallet_max_unit_10);
      continue;
      paramContext = a.ba(paramContext, a.i.wallet_max_unit_11);
      continue;
      paramContext = a.ba(paramContext, a.i.wallet_max_unit_12);
      continue;
      paramContext = a.ba(paramContext, a.i.wallet_max_unit_13);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.ag
 * JD-Core Version:    0.7.0.1
 */