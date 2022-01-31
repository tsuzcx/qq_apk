package com.tencent.voip.mars.comm;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.PrintWriter;
import java.io.StringWriter;

public class PlatformComm$C2Java
{
  private static String exception2String(Exception paramException)
  {
    AppMethodBeat.i(92727);
    StringWriter localStringWriter = new StringWriter();
    paramException.printStackTrace(new PrintWriter(localStringWriter));
    paramException = localStringWriter.toString();
    AppMethodBeat.o(92727);
    return paramException;
  }
  
  public static PlatformComm.APNInfo getAPNInfo()
  {
    AppMethodBeat.i(92734);
    try
    {
      Object localObject = ((ConnectivityManager)PlatformComm.context.getSystemService("connectivity")).getActiveNetworkInfo();
      PlatformComm.APNInfo localAPNInfo = new PlatformComm.APNInfo();
      if (localObject != null)
      {
        localAPNInfo.netType = ((NetworkInfo)localObject).getType();
        localAPNInfo.subNetType = ((NetworkInfo)localObject).getSubtype();
        if (1 != ((NetworkInfo)localObject).getType()) {
          if (((NetworkInfo)localObject).getExtraInfo() == null) {
            localObject = "";
          }
        }
        for (localAPNInfo.extraInfo = ((String)localObject);; localAPNInfo.extraInfo = getCurWifiInfo().ssid)
        {
          AppMethodBeat.o(92734);
          return localAPNInfo;
          localObject = ((NetworkInfo)localObject).getExtraInfo();
          break;
        }
      }
      return null;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(92734);
    }
  }
  
  public static int getCurRadioAccessNetworkInfo()
  {
    AppMethodBeat.i(92735);
    if (PlatformComm.context == null)
    {
      PlatformComm.Assert.assertTrue(false);
      AppMethodBeat.o(92735);
      return 0;
    }
    try
    {
      int i = ((TelephonyManager)PlatformComm.context.getSystemService("phone")).getNetworkType();
      AppMethodBeat.o(92735);
      return i;
    }
    catch (Exception localException)
    {
      PlatformComm.Assert.assertTrue(localException.getClass().getSimpleName() + ":" + localException.getStackTrace()[0] + ", " + localException.getStackTrace()[1], false);
      AppMethodBeat.o(92735);
    }
    return 0;
  }
  
  public static PlatformComm.SIMInfo getCurSIMInfo()
  {
    AppMethodBeat.i(92733);
    try
    {
      Object localObject = PlatformComm.context;
      if (localObject == null)
      {
        AppMethodBeat.o(92733);
        return null;
      }
      int i = NetStatusUtil.getISPCode(PlatformComm.context);
      if (i == 0)
      {
        AppMethodBeat.o(92733);
        return null;
      }
      localObject = new PlatformComm.SIMInfo();
      ((PlatformComm.SIMInfo)localObject).ispCode = String.valueOf(i);
      ((PlatformComm.SIMInfo)localObject).ispName = NetStatusUtil.getISPName(PlatformComm.context);
      AppMethodBeat.o(92733);
      return localObject;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(92733);
    }
    return null;
  }
  
  public static PlatformComm.WifiInfo getCurWifiInfo()
  {
    AppMethodBeat.i(92732);
    try
    {
      Object localObject = PlatformComm.context;
      if (localObject == null)
      {
        AppMethodBeat.o(92732);
        return null;
      }
      localObject = (ConnectivityManager)PlatformComm.context.getSystemService("connectivity");
      if (localObject == null)
      {
        AppMethodBeat.o(92732);
        return null;
      }
      localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
      if (localObject != null)
      {
        int i = ((NetworkInfo)localObject).getType();
        if (1 == i) {}
      }
      else
      {
        AppMethodBeat.o(92732);
        return null;
      }
      localObject = (WifiManager)PlatformComm.context.getSystemService("wifi");
      if (localObject == null)
      {
        AppMethodBeat.o(92732);
        return null;
      }
      localObject = ((WifiManager)localObject).getConnectionInfo();
      if (localObject == null)
      {
        AppMethodBeat.o(92732);
        return null;
      }
      PlatformComm.WifiInfo localWifiInfo = new PlatformComm.WifiInfo();
      localWifiInfo.ssid = ((WifiInfo)localObject).getSSID();
      localWifiInfo.bssid = ((WifiInfo)localObject).getBSSID();
      AppMethodBeat.o(92732);
      return localWifiInfo;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(92732);
    }
    return null;
  }
  
  public static int getNetInfo()
  {
    AppMethodBeat.i(92728);
    Object localObject = (ConnectivityManager)PlatformComm.context.getSystemService("connectivity");
    if (localObject == null)
    {
      AppMethodBeat.o(92728);
      return -1;
    }
    localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
    if (localObject == null)
    {
      AppMethodBeat.o(92728);
      return -1;
    }
    try
    {
      int i = ((NetworkInfo)localObject).getType();
      switch (i)
      {
      default: 
        AppMethodBeat.o(92728);
        return 3;
      case 1: 
        AppMethodBeat.o(92728);
        return 1;
      }
      AppMethodBeat.o(92728);
      return 2;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(92728);
    }
    return 3;
  }
  
  public static int getProxyInfo(StringBuffer paramStringBuffer)
  {
    return -1;
  }
  
  public static long getSignal(boolean paramBoolean)
  {
    AppMethodBeat.i(92736);
    try
    {
      if (PlatformComm.context == null)
      {
        PlatformComm.Assert.assertTrue(false);
        AppMethodBeat.o(92736);
        return 0L;
      }
      if (paramBoolean)
      {
        l = NetworkSignalUtil.getWifiSignalStrength();
        AppMethodBeat.o(92736);
        return l;
      }
      long l = NetworkSignalUtil.getGSMSignalStrength();
      AppMethodBeat.o(92736);
      return l;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(92736);
    }
    return 0L;
  }
  
  public static int getStatisticsNetType()
  {
    AppMethodBeat.i(92729);
    if (PlatformComm.context == null)
    {
      PlatformComm.Assert.assertTrue(false);
      AppMethodBeat.o(92729);
      return 0;
    }
    try
    {
      int i = NetStatusUtil.getNetType(PlatformComm.context);
      if (i == -1)
      {
        AppMethodBeat.o(92729);
        return -1;
      }
      boolean bool = NetStatusUtil.is2G(PlatformComm.context);
      if (bool)
      {
        AppMethodBeat.o(92729);
        return 3;
      }
      bool = NetStatusUtil.is3G(PlatformComm.context);
      if (bool)
      {
        AppMethodBeat.o(92729);
        return 4;
      }
      bool = NetStatusUtil.is4G(PlatformComm.context);
      if (bool)
      {
        AppMethodBeat.o(92729);
        return 5;
      }
      bool = NetStatusUtil.isWifi(i);
      if (bool)
      {
        AppMethodBeat.o(92729);
        return 1;
      }
      bool = NetStatusUtil.isWap(i);
      if (bool)
      {
        AppMethodBeat.o(92729);
        return 2;
      }
      AppMethodBeat.o(92729);
      return 6;
    }
    catch (Exception localException)
    {
      exception2String(localException);
      PlatformComm.Assert.assertTrue(localException.getClass().getSimpleName() + ":" + localException.getStackTrace()[0] + ", " + localException.getStackTrace()[1], false);
      AppMethodBeat.o(92729);
    }
    return -1;
  }
  
  public static boolean isNetworkConnected()
  {
    AppMethodBeat.i(92737);
    if (PlatformComm.context == null)
    {
      PlatformComm.Assert.assertTrue(false);
      AppMethodBeat.o(92737);
      return false;
    }
    try
    {
      boolean bool = NetStatusUtil.isNetworkConnected(PlatformComm.context);
      AppMethodBeat.o(92737);
      return bool;
    }
    catch (Exception localException)
    {
      exception2String(localException);
      PlatformComm.Assert.assertTrue(localException.getClass().getSimpleName() + ":" + localException.getStackTrace()[0] + ", " + localException.getStackTrace()[1], false);
      AppMethodBeat.o(92737);
    }
    return false;
  }
  
  public static boolean startAlarm(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(92730);
    if (PlatformComm.context == null)
    {
      PlatformComm.Assert.assertTrue(false);
      AppMethodBeat.o(92730);
      return false;
    }
    long l = paramInt1;
    try
    {
      boolean bool = Alarm.start(l, paramInt2, PlatformComm.context);
      AppMethodBeat.o(92730);
      return bool;
    }
    catch (Exception localException)
    {
      exception2String(localException);
      PlatformComm.Assert.assertTrue(localException.getClass().getSimpleName() + ":" + localException.getStackTrace()[0] + ", " + localException.getStackTrace()[1], false);
      AppMethodBeat.o(92730);
    }
    return false;
  }
  
  public static boolean stopAlarm(int paramInt)
  {
    AppMethodBeat.i(92731);
    if (PlatformComm.context == null)
    {
      PlatformComm.Assert.assertTrue(false);
      AppMethodBeat.o(92731);
      return false;
    }
    long l = paramInt;
    try
    {
      boolean bool = Alarm.stop(l, PlatformComm.context);
      AppMethodBeat.o(92731);
      return bool;
    }
    catch (Exception localException)
    {
      exception2String(localException);
      PlatformComm.Assert.assertTrue(localException.getClass().getSimpleName() + ":" + localException.getStackTrace()[0] + ", " + localException.getStackTrace()[1], false);
      AppMethodBeat.o(92731);
    }
    return false;
  }
  
  public static WakerLock wakeupLock_new()
  {
    AppMethodBeat.i(92738);
    if (PlatformComm.context == null)
    {
      PlatformComm.Assert.assertTrue(false);
      AppMethodBeat.o(92738);
      return null;
    }
    try
    {
      WakerLock localWakerLock = new WakerLock(PlatformComm.context);
      AppMethodBeat.o(92738);
      return localWakerLock;
    }
    catch (Exception localException)
    {
      exception2String(localException);
      PlatformComm.Assert.assertTrue(localException.getClass().getSimpleName() + ":" + localException.getStackTrace()[0] + ", " + localException.getStackTrace()[1], false);
      AppMethodBeat.o(92738);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.voip.mars.comm.PlatformComm.C2Java
 * JD-Core Version:    0.7.0.1
 */