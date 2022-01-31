package com.tinkerboots.sdk.b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public final class a
{
  private static ConnectivityManager xnS = null;
  
  public static boolean isConnected(Context paramContext)
  {
    if (xnS == null) {
      xnS = (ConnectivityManager)paramContext.getSystemService("connectivity");
    }
    if (xnS == null) {
      return false;
    }
    paramContext = xnS.getActiveNetworkInfo();
    if (paramContext != null) {}
    try
    {
      boolean bool = paramContext.isConnected();
      if (bool) {}
      for (bool = true;; bool = false) {
        return bool;
      }
      return false;
    }
    catch (Exception paramContext) {}
  }
  
  public static boolean isWifi(Context paramContext)
  {
    if (xnS == null) {
      xnS = (ConnectivityManager)paramContext.getSystemService("connectivity");
    }
    if (xnS == null) {
      return false;
    }
    paramContext = xnS.getActiveNetworkInfo();
    return (paramContext != null) && (paramContext.getType() == 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tinkerboots.sdk.b.a
 * JD-Core Version:    0.7.0.1
 */