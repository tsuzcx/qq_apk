package com.tencent.mm.wallet_core.c;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.bu;

public final class ag
{
  public static String aQ(Context paramContext, int paramInt)
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
      paramContext = a.az(paramContext, 2131765506);
      continue;
      paramContext = a.az(paramContext, 2131765511);
      continue;
      paramContext = a.az(paramContext, 2131765512);
      continue;
      paramContext = a.az(paramContext, 2131765513);
      continue;
      paramContext = a.az(paramContext, 2131765514);
      continue;
      paramContext = a.az(paramContext, 2131765515);
      continue;
      paramContext = a.az(paramContext, 2131765516);
      continue;
      paramContext = a.az(paramContext, 2131765517);
      continue;
      paramContext = a.az(paramContext, 2131765518);
      continue;
      paramContext = a.az(paramContext, 2131765507);
      continue;
      paramContext = a.az(paramContext, 2131765508);
      continue;
      paramContext = a.az(paramContext, 2131765509);
      continue;
      paramContext = a.az(paramContext, 2131765510);
    }
  }
  
  public static int agX(int paramInt)
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
  
  public static boolean bx(Intent paramIntent)
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
      ae.i("MicroMsg.WalletPayUtil", "onActivityResult isCanFinish %s %s", new Object[] { Integer.valueOf(i), bu.fpN().toString() });
      AppMethodBeat.o(163884);
      return true;
    }
    AppMethodBeat.o(163884);
    return false;
  }
  
  public static boolean by(Intent paramIntent)
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
      ae.i("MicroMsg.WalletPayUtil", "onActivityResult isCanIgnore %s %s", new Object[] { Integer.valueOf(i), bu.fpN().toString() });
      AppMethodBeat.o(163885);
      return true;
    }
    AppMethodBeat.o(163885);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.ag
 * JD-Core Version:    0.7.0.1
 */