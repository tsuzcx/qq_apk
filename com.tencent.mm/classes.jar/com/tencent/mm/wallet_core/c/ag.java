package com.tencent.mm.wallet_core.c;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;

public final class ag
{
  public static String aR(Context paramContext, int paramInt)
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
      paramContext = a.aI(paramContext, 2131767955);
      continue;
      paramContext = a.aI(paramContext, 2131767960);
      continue;
      paramContext = a.aI(paramContext, 2131767961);
      continue;
      paramContext = a.aI(paramContext, 2131767962);
      continue;
      paramContext = a.aI(paramContext, 2131767963);
      continue;
      paramContext = a.aI(paramContext, 2131767964);
      continue;
      paramContext = a.aI(paramContext, 2131767965);
      continue;
      paramContext = a.aI(paramContext, 2131767966);
      continue;
      paramContext = a.aI(paramContext, 2131767967);
      continue;
      paramContext = a.aI(paramContext, 2131767956);
      continue;
      paramContext = a.aI(paramContext, 2131767957);
      continue;
      paramContext = a.aI(paramContext, 2131767958);
      continue;
      paramContext = a.aI(paramContext, 2131767959);
    }
  }
  
  public static int aqj(int paramInt)
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
  
  public static boolean bH(Intent paramIntent)
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
  
  public static boolean bI(Intent paramIntent)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.ag
 * JD-Core Version:    0.7.0.1
 */