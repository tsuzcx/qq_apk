package com.tencent.pb.common.b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.pb.common.c.c;
import com.tencent.pb.common.c.d;

public final class h
{
  public static boolean wFU = true;
  private static long wFV = -1L;
  public static h.a wFW = h.a.wFY;
  private static h.a wFX = h.a.wFY;
  
  private static NetworkInfo cNW()
  {
    NetworkInfo localNetworkInfo;
    try
    {
      ConnectivityManager localConnectivityManager = (ConnectivityManager)d.pZI.getSystemService("connectivity");
      if (localConnectivityManager == null)
      {
        c.x("getSystemService(Context.CONNECTIVITY_SERVICE) null", new Object[0]);
        return null;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localNetworkInfo = null;
      }
    }
    try
    {
      localNetworkInfo = localNetworkInfo.getActiveNetworkInfo();
      return localNetworkInfo;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        c.x("getActiveNetworkInfo exception:", new Object[] { localThrowable });
        Object localObject = null;
      }
    }
  }
  
  public static boolean isNetworkConnected()
  {
    try
    {
      NetworkInfo localNetworkInfo = cNW();
      if (localNetworkInfo == null) {
        return false;
      }
      boolean bool = localNetworkInfo.isConnected();
      return bool;
    }
    catch (Exception localException) {}
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.pb.common.b.h
 * JD-Core Version:    0.7.0.1
 */