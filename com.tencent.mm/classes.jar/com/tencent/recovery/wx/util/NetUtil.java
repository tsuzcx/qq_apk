package com.tencent.recovery.wx.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetUtil
{
  private static final String NON_NETWORK = "NOT_NETWORK";
  private static final String OTHER = "other";
  private static final String TAG = "Recovery.NetUtil";
  private static final String WIFI = "WIFI";
  private static final String _3G = "3G";
  private static final String _4G = "4G";
  
  public static String getCurrentNetWorkStatus(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext == null) {
      return "NOT_NETWORK";
    }
    paramContext = paramContext.getActiveNetworkInfo();
    if (paramContext == null) {
      return "NOT_NETWORK";
    }
    if (!paramContext.isConnected()) {
      return "NOT_NETWORK";
    }
    if (paramContext.getType() == 1) {
      return "WIFI";
    }
    if (paramContext.getSubtype() >= 13) {
      return "4G";
    }
    if ((paramContext.getSubtype() >= 5) && (paramContext.getSubtype() < 13)) {
      return "3G";
    }
    return "other";
  }
  
  public static boolean isConnected(Context paramContext)
  {
    return !getCurrentNetWorkStatus(paramContext).equals("NOT_NETWORK");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.recovery.wx.util.NetUtil
 * JD-Core Version:    0.7.0.1
 */