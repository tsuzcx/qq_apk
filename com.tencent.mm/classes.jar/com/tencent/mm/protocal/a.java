package com.tencent.mm.protocal;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public class a
{
  public static int getNetType(NetworkInfo paramNetworkInfo)
  {
    int i = 1;
    AppMethodBeat.i(257307);
    if (paramNetworkInfo == null)
    {
      AppMethodBeat.o(257307);
      return 0;
    }
    for (;;)
    {
      try
      {
        j = paramNetworkInfo.getSubtype();
        int k = paramNetworkInfo.getType();
        if (k != 1) {
          continue;
        }
      }
      catch (Exception paramNetworkInfo)
      {
        int j;
        Log.e("MicroMsg.BgFgBase", "getNetType: %s", new Object[] { Util.stackTraceToString(paramNetworkInfo) });
        continue;
      }
      AppMethodBeat.o(257307);
      return i;
      if ((j == 13) || (j == 15) || (j == 14)) {
        i = 4;
      } else if ((j == 3) || (j == 4) || (j == 5) || (j == 6) || (j == 12)) {
        i = 3;
      } else if ((j == 1) || (j == 2)) {
        i = 2;
      } else {
        i = 0;
      }
    }
  }
  
  public static int iPy()
  {
    if (CrashReportFactory.foreground) {
      return 1;
    }
    return 2;
  }
  
  public static int ibq()
  {
    AppMethodBeat.i(257306);
    for (;;)
    {
      try
      {
        NetworkInfo localNetworkInfo = ((ConnectivityManager)MMApplicationContext.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
        if (localNetworkInfo == null)
        {
          AppMethodBeat.o(257306);
          return 0;
        }
        i = localNetworkInfo.getSubtype();
        int j = localNetworkInfo.getType();
        if (j != 1) {
          continue;
        }
        i = 1;
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.BgFgBase", "getNetType: %s", new Object[] { Util.stackTraceToString(localException) });
        int i = 1;
        continue;
      }
      AppMethodBeat.o(257306);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.a
 * JD-Core Version:    0.7.0.1
 */