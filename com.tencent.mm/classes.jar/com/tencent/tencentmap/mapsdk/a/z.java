package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class z
{
  public static boolean a(Context paramContext)
  {
    paramContext = b(paramContext);
    return (paramContext != null) && (paramContext.getType() == 1);
  }
  
  public static NetworkInfo b(Context paramContext)
  {
    paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    if ((paramContext != null) && (paramContext.isConnected())) {
      return paramContext;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.z
 * JD-Core Version:    0.7.0.1
 */