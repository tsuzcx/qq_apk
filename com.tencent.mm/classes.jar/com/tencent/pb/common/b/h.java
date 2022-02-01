package com.tencent.pb.common.b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.pb.common.c.b;
import com.tencent.pb.common.c.c;

public final class h
{
  public static boolean RDd = true;
  private static long RDe = -1L;
  public static h.a RDf = h.a.RDh;
  private static h.a RDg = h.a.RDh;
  
  private static NetworkInfo hja()
  {
    NetworkInfo localNetworkInfo;
    try
    {
      ConnectivityManager localConnectivityManager = (ConnectivityManager)c.Hhs.getSystemService("connectivity");
      if (localConnectivityManager == null)
      {
        b.w("getSystemService(Context.CONNECTIVITY_SERVICE) null", new Object[0]);
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
        b.w("getActiveNetworkInfo exception:", new Object[] { localThrowable });
        Object localObject = null;
      }
    }
  }
  
  public static boolean isNetworkConnected()
  {
    try
    {
      NetworkInfo localNetworkInfo = hja();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.pb.common.b.h
 * JD-Core Version:    0.7.0.1
 */