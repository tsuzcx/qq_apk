package com.tencent.pb.common.b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.pb.common.c.b;
import com.tencent.pb.common.c.c;

public final class h
{
  public static boolean Ikq = true;
  private static long Ikr = -1L;
  public static h.a Iks = h.a.Iku;
  private static h.a Ikt = h.a.Iku;
  
  private static NetworkInfo flp()
  {
    NetworkInfo localNetworkInfo;
    try
    {
      ConnectivityManager localConnectivityManager = (ConnectivityManager)c.ztG.getSystemService("connectivity");
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
      NetworkInfo localNetworkInfo = flp();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.pb.common.b.h
 * JD-Core Version:    0.7.0.1
 */