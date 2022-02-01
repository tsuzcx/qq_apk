package com.tencent.mm.wallet_core.c;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bs;

public final class ag
{
  public static String aN(Context paramContext, int paramInt)
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
      paramContext = a.aw(paramContext, 2131765506);
      continue;
      paramContext = a.aw(paramContext, 2131765511);
      continue;
      paramContext = a.aw(paramContext, 2131765512);
      continue;
      paramContext = a.aw(paramContext, 2131765513);
      continue;
      paramContext = a.aw(paramContext, 2131765514);
      continue;
      paramContext = a.aw(paramContext, 2131765515);
      continue;
      paramContext = a.aw(paramContext, 2131765516);
      continue;
      paramContext = a.aw(paramContext, 2131765517);
      continue;
      paramContext = a.aw(paramContext, 2131765518);
      continue;
      paramContext = a.aw(paramContext, 2131765507);
      continue;
      paramContext = a.aw(paramContext, 2131765508);
      continue;
      paramContext = a.aw(paramContext, 2131765509);
      continue;
      paramContext = a.aw(paramContext, 2131765510);
    }
  }
  
  public static int adO(int paramInt)
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
  
  public static boolean br(Intent paramIntent)
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
      ac.i("MicroMsg.WalletPayUtil", "onActivityResult isCanFinish %s %s", new Object[] { Integer.valueOf(i), bs.eWi().toString() });
      AppMethodBeat.o(163884);
      return true;
    }
    AppMethodBeat.o(163884);
    return false;
  }
  
  public static boolean bs(Intent paramIntent)
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
      ac.i("MicroMsg.WalletPayUtil", "onActivityResult isCanIgnore %s %s", new Object[] { Integer.valueOf(i), bs.eWi().toString() });
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