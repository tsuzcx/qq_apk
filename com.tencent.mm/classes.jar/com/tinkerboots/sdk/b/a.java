package com.tinkerboots.sdk.b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  private static ConnectivityManager MAw = null;
  
  public static boolean isConnected(Context paramContext)
  {
    boolean bool1 = false;
    AppMethodBeat.i(3459);
    if (MAw == null) {
      MAw = (ConnectivityManager)paramContext.getSystemService("connectivity");
    }
    if (MAw == null)
    {
      AppMethodBeat.o(3459);
      return false;
    }
    paramContext = MAw.getActiveNetworkInfo();
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
      AppMethodBeat.o(3459);
      return bool1;
      bool1 = false;
    }
  }
  
  public static boolean isWifi(Context paramContext)
  {
    AppMethodBeat.i(3460);
    if (MAw == null) {
      MAw = (ConnectivityManager)paramContext.getSystemService("connectivity");
    }
    if (MAw == null)
    {
      AppMethodBeat.o(3460);
      return false;
    }
    paramContext = MAw.getActiveNetworkInfo();
    if ((paramContext != null) && (paramContext.getType() == 1))
    {
      AppMethodBeat.o(3460);
      return true;
    }
    AppMethodBeat.o(3460);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tinkerboots.sdk.b.a
 * JD-Core Version:    0.7.0.1
 */