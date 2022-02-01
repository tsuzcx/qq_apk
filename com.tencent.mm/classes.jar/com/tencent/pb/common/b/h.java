package com.tencent.pb.common.b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.pb.common.c.b;
import com.tencent.pb.common.c.c;

public final class h
{
  public static boolean JMb = true;
  private static long JMc = -1L;
  public static h.a JMd = h.a.JMf;
  private static h.a JMe = h.a.JMf;
  
  private static NetworkInfo fBG()
  {
    NetworkInfo localNetworkInfo;
    try
    {
      ConnectivityManager localConnectivityManager = (ConnectivityManager)c.AMx.getSystemService("connectivity");
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
      NetworkInfo localNetworkInfo = fBG();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.pb.common.b.h
 * JD-Core Version:    0.7.0.1
 */