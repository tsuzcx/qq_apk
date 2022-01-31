package com.tinkerboots.sdk.b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  private static ConnectivityManager BLO = null;
  
  public static boolean isConnected(Context paramContext)
  {
    boolean bool1 = false;
    AppMethodBeat.i(65552);
    if (BLO == null) {
      BLO = (ConnectivityManager)paramContext.getSystemService("connectivity");
    }
    if (BLO == null)
    {
      AppMethodBeat.o(65552);
      return false;
    }
    paramContext = BLO.getActiveNetworkInfo();
    if (paramContext != null) {}
    for (;;)
    {
      try
      {
        boolean bool2 = paramContext.isConnected();
        if (!bool2) {
          continue;
        }
        bool1 = true;
      }
      catch (Exception paramContext)
      {
        continue;
      }
      AppMethodBeat.o(65552);
      return bool1;
      bool1 = false;
    }
  }
  
  public static boolean isWifi(Context paramContext)
  {
    AppMethodBeat.i(65553);
    if (BLO == null) {
      BLO = (ConnectivityManager)paramContext.getSystemService("connectivity");
    }
    if (BLO == null)
    {
      AppMethodBeat.o(65553);
      return false;
    }
    paramContext = BLO.getActiveNetworkInfo();
    if ((paramContext != null) && (paramContext.getType() == 1))
    {
      AppMethodBeat.o(65553);
      return true;
    }
    AppMethodBeat.o(65553);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tinkerboots.sdk.b.a
 * JD-Core Version:    0.7.0.1
 */