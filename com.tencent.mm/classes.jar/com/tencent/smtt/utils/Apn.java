package com.tencent.smtt.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class Apn
{
  public static final int APN_2G = 1;
  public static final int APN_3G = 2;
  public static final int APN_4G = 4;
  public static final int APN_UNKNOWN = 0;
  public static final int APN_WIFI = 3;
  
  public static String getApnInfo(Context paramContext)
  {
    AppMethodBeat.i(65169);
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if ((paramContext != null) && (paramContext.isConnectedOrConnecting()))
      {
        int i = paramContext.getType();
        switch (i)
        {
        }
      }
    }
    catch (Exception paramContext)
    {
      label56:
      break label56;
    }
    paramContext = "unknown";
    for (;;)
    {
      AppMethodBeat.o(65169);
      return paramContext;
      paramContext = "wifi";
      continue;
      paramContext = paramContext.getExtraInfo();
    }
  }
  
  public static int getApnType(Context paramContext)
  {
    AppMethodBeat.i(65170);
    paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    int i;
    if ((paramContext != null) && (paramContext.isConnectedOrConnecting())) {
      switch (paramContext.getType())
      {
      default: 
        i = 0;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(65170);
      return i;
      i = 3;
      continue;
      switch (paramContext.getSubtype())
      {
      default: 
        i = 0;
        break;
      case 1: 
      case 2: 
      case 4: 
      case 7: 
      case 11: 
        i = 1;
        break;
      case 3: 
      case 5: 
      case 6: 
      case 8: 
      case 9: 
      case 10: 
      case 12: 
      case 14: 
      case 15: 
        i = 2;
        break;
      case 13: 
        i = 4;
        continue;
        i = 0;
      }
    }
  }
  
  public static String getWifiSSID(Context paramContext)
  {
    AppMethodBeat.i(65172);
    for (;;)
    {
      try
      {
        paramContext = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo();
        if (paramContext != null)
        {
          paramContext = paramContext.getBSSID();
          AppMethodBeat.o(65172);
          return paramContext;
        }
      }
      catch (Throwable paramContext)
      {
        AppMethodBeat.o(65172);
        return "";
      }
      paramContext = null;
    }
  }
  
  public static boolean isNetworkAvailable(Context paramContext)
  {
    AppMethodBeat.i(65171);
    paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    if (paramContext == null)
    {
      AppMethodBeat.o(65171);
      return false;
    }
    if ((paramContext.isConnected()) || (paramContext.isAvailable()))
    {
      AppMethodBeat.o(65171);
      return true;
    }
    AppMethodBeat.o(65171);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.smtt.utils.Apn
 * JD-Core Version:    0.7.0.1
 */