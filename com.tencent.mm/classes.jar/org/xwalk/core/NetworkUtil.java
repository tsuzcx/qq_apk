package org.xwalk.core;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetworkUtil
{
  private static final int NON_NETWORK = 0;
  private static final int OTHER = 4;
  private static final int WIFI = 1;
  private static final int _3G = 2;
  private static final int _4G = 3;
  
  public static int getCurrentNetWorkStatus(Context paramContext)
  {
    if (paramContext.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0) {
      return 0;
    }
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext == null) {
      return 0;
    }
    paramContext = paramContext.getActiveNetworkInfo();
    if (paramContext == null) {
      return 0;
    }
    if (!paramContext.isConnected()) {
      return 0;
    }
    if (paramContext.getType() == 1) {
      return 1;
    }
    if (paramContext.getSubtype() >= 13) {
      return 3;
    }
    if ((paramContext.getSubtype() >= 5) && (paramContext.getSubtype() < 13)) {
      return 2;
    }
    return 4;
  }
  
  public static boolean isNetworkAvailable()
  {
    if (Integer.valueOf(getCurrentNetWorkStatus(XWalkEnvironment.getApplicationContext())).intValue() == 0)
    {
      XWalkInitializer.addXWalkInitializeLog("no network");
      return false;
    }
    return true;
  }
  
  public static boolean isWifiAvailable()
  {
    switch (Integer.valueOf(getCurrentNetWorkStatus(XWalkEnvironment.getApplicationContext())).intValue())
    {
    default: 
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     org.xwalk.core.NetworkUtil
 * JD-Core Version:    0.7.0.1
 */