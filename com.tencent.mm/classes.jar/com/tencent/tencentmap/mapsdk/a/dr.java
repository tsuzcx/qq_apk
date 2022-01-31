package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.map.lib.util.StringUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class dr
{
  private static int a(NetworkInfo paramNetworkInfo)
  {
    AppMethodBeat.i(150143);
    if ((paramNetworkInfo == null) || (!paramNetworkInfo.isAvailable()))
    {
      AppMethodBeat.o(150143);
      return 0;
    }
    int i = paramNetworkInfo.getType();
    if (i == 1)
    {
      AppMethodBeat.o(150143);
      return 5;
    }
    if (i != 0)
    {
      AppMethodBeat.o(150143);
      return 6;
    }
    paramNetworkInfo = paramNetworkInfo.getExtraInfo();
    if (StringUtil.isEmpty(paramNetworkInfo))
    {
      AppMethodBeat.o(150143);
      return 6;
    }
    if (paramNetworkInfo.equalsIgnoreCase("cmwap"))
    {
      AppMethodBeat.o(150143);
      return 1;
    }
    if (paramNetworkInfo.equalsIgnoreCase("3gwap"))
    {
      AppMethodBeat.o(150143);
      return 3;
    }
    if (paramNetworkInfo.equalsIgnoreCase("uniwap"))
    {
      AppMethodBeat.o(150143);
      return 2;
    }
    if (paramNetworkInfo.equalsIgnoreCase("ctwap"))
    {
      AppMethodBeat.o(150143);
      return 4;
    }
    AppMethodBeat.o(150143);
    return 3;
  }
  
  public static NetworkInfo a(Context paramContext)
  {
    AppMethodBeat.i(150140);
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      AppMethodBeat.o(150140);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(150140);
    }
    return null;
  }
  
  public static int b(Context paramContext)
  {
    AppMethodBeat.i(150141);
    int i = a(a(paramContext));
    AppMethodBeat.o(150141);
    return i;
  }
  
  public static String c(Context paramContext)
  {
    AppMethodBeat.i(150142);
    int i = b(paramContext);
    paramContext = "";
    switch (i)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(150142);
      return paramContext;
      paramContext = "wifi";
      continue;
      paramContext = "3gwap";
      continue;
      paramContext = "uniwap";
      continue;
      paramContext = "cmwap";
      continue;
      paramContext = "ctwap";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.dr
 * JD-Core Version:    0.7.0.1
 */