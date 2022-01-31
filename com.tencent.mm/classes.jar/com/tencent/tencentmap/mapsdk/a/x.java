package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class x
{
  public static NetworkInfo a(Context paramContext)
  {
    AppMethodBeat.i(150423);
    paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    if ((paramContext != null) && (paramContext.isConnected()))
    {
      AppMethodBeat.o(150423);
      return paramContext;
    }
    AppMethodBeat.o(150423);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.x
 * JD-Core Version:    0.7.0.1
 */