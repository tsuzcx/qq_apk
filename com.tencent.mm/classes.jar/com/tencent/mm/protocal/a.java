package com.tencent.mm.protocal;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public class a
{
  public static int coN()
  {
    if (b.foreground) {
      return 1;
    }
    return 2;
  }
  
  public static int getNetType(Context paramContext)
  {
    for (;;)
    {
      try
      {
        paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
        if (paramContext == null) {
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
        y.e("MicroMsg.BgFgBase", "getNetType: %s", new Object[] { bk.j(paramContext) });
        int i = 1;
        continue;
      }
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