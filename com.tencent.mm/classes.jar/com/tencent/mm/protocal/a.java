package com.tencent.mm.protocal;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public class a
{
  public static int dqk()
  {
    if (b.foreground) {
      return 1;
    }
    return 2;
  }
  
  public static int getNetType(Context paramContext)
  {
    AppMethodBeat.i(58787);
    for (;;)
    {
      try
      {
        paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
        if (paramContext == null)
        {
          AppMethodBeat.o(58787);
          return 0;
        }
        i = paramContext.getSubtype();
        int j = paramContext.getType();
        if (j != 1) {
          continue;
        }
        i = 1;
      }
      catch (Exception paramContext)
      {
        ab.e("MicroMsg.BgFgBase", "getNetType: %s", new Object[] { bo.l(paramContext) });
        int i = 1;
        continue;
      }
      AppMethodBeat.o(58787);
      return i;
      if ((i == 13) || (i == 15) || (i == 14)) {
        i = 4;
      } else if ((i == 3) || (i == 4) || (i == 5) || (i == 6) || (i == 12)) {
        i = 3;
      } else if ((i == 1) || (i == 2)) {
        i = 2;
      } else {
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.a
 * JD-Core Version:    0.7.0.1
 */