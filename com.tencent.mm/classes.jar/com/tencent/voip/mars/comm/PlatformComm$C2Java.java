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
    AppMethodBeat.i(55564);
    StringWriter localStringWriter = new StringWriter();
    paramException.printStackTrace(new PrintWriter(localStringWriter));
    paramException = localStringWriter.toString();
    AppMethodBeat.o(55564);
    return paramException;
  }
  
  public static PlatformComm.APNInfo getAPNInfo()
  {
    AppMethodBeat.i(55571);
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
          AppMethodBeat.o(55571);
          return localAPNInfo;
          localObject = ((NetworkInfo)localObject).getExtraInfo();
          break;
        }
      }
      return null;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(55571);
    }
  }
  
  public static int getCurRadioAccessNetworkInfo()
  {
    AppMethodBeat.i(55572);
    if (PlatformComm.context == null)
    {
      PlatformComm.Assert.assertTrue(false);
      AppMethodBeat.o(55572);
      return 0;
    }
    try
    {
      int i = ((TelephonyManager)PlatformComm.context.getSystemService("phone")).getNetworkType();
      AppMethodBeat.o(55572);
      return i;
    }
    catch (Exception localException)
    {
      PlatformComm.Assert.assertTrue(localException.getClass().getSimpleName() + ":" + localException.getStackTrace()[0] + ", " + localException.getStackTrace()[1], false);
      AppMethodBeat.o(55572);
    }
    return 0;
  }
  
  public static PlatformComm.SIMInfo getCurSIMInfo()
  {
    AppMethodBeat.i(55570);
    try
    {
      Object localObject = PlatformComm.context;
      if (localObject == null)
      {
        AppMethodBeat.o(55570);
        return null;
      }
      int i = NetStatusUtil.getISPCode(PlatformComm.context);
      if (i == 0)
      {
        AppMethodBeat.o(55570);
        return null;
      }
      localObject = new PlatformComm.SIMInfo();
      ((PlatformComm.SIMInfo)localObject).ispCode = String.valueOf(i);
      ((PlatformComm.SIMInfo)localObject).ispName = NetStatusUtil.getISPName(PlatformComm.context);
      AppMethodBeat.o(55570);
      return localObject;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(55570);
    }
    return null;
  }
  
  public static PlatformComm.WifiInfo getCurWifiInfo()
  {
    AppMethodBeat.i(55569);
    try
    {
      Object localObject = PlatformComm.context;
      if (localObject == null)
      {
        AppMethodBeat.o(55569);
        return null;
      }
      localObject = (ConnectivityManager)PlatformComm.context.getSystemService("connectivity");
      if (localObject == null)
      {
        AppMethodBeat.o(55569);
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
        AppMethodBeat.o(55569);
        return null;
      }
      localObject = (WifiManager)PlatformComm.context.getSystemService("wifi");
      if (localObject == null)
      {
        AppMethodBeat.o(55569);
        return null;
      }
      localObject = ((WifiManager)localObject).getConnectionInfo();
      if (localObject == null)
      {
        AppMethodBeat.o(55569);
        return null;
      }
      PlatformComm.WifiInfo localWifiInfo = new PlatformComm.WifiInfo();
      localWifiInfo.ssid = ((WifiInfo)localObject).getSSID();
      localWifiInfo.bssid = ((WifiInfo)localObject).getBSSID();
      AppMethodBeat.o(55569);
      return localWifiInfo;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(55569);
    }
    return null;
  }
  
  public static int getNetInfo()
  {
    AppMethodBeat.i(55565);
    Object localObject = (ConnectivityManager)PlatformComm.context.getSystemService("connectivity");
    if (localObject == null)
    {
      AppMethodBeat.o(55565);
      return -1;
    }
    localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
    if (localObject == null)
    {
      AppMethodBeat.o(55565);
      return -1;
    }
    try
    {
      int i = ((NetworkInfo)localObject).getType();
      switch (i)
      {
      default: 
        AppMethodBeat.o(55565);
        return 3;
      case 1: 
        AppMethodBeat.o(55565);
        return 1;
      }
      AppMethodBeat.o(55565);
      return 2;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(55565);
    }
    return 3;
  }
  
  public static int getProxyInfo(StringBuffer paramStringBuffer)
  {
    return -1;
  }
  
  public static long getSignal(boolean paramBoolean)
  {
    AppMethodBeat.i(55573);
    try
    {
      if (PlatformComm.context == null)
      {
        PlatformComm.Assert.assertTrue(false);
        AppMethodBeat.o(55573);
        return 0L;
      }
      if (paramBoolean)
      {
        l = NetworkSignalUtil.getWifiSignalStrength();
        AppMethodBeat.o(55573);
        return l;
      }
      long l = NetworkSignalUtil.getGSMSignalStrength();
      AppMethodBeat.o(55573);
      return l;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(55573);
    }
    return 0L;
  }
  
  public static int getStatisticsNetType()
  {
    AppMethodBeat.i(55566);
    if (PlatformComm.context == null)
    {
      PlatformComm.Assert.assertTrue(false);
      AppMethodBeat.o(55566);
      return 0;
    }
    try
    {
      int i = NetStatusUtil.getNetType(PlatformComm.context);
      if (i == -1)
      {
        AppMethodBeat.o(55566);
        return -1;
      }
      boolean bool = NetStatusUtil.is2G(PlatformComm.context);
      if (bool)
      {
        AppMethodBeat.o(55566);
        return 3;
      }
      bool = NetStatusUtil.is3G(PlatformComm.context);
      if (bool)
      {
        AppMethodBeat.o(55566);
        return 4;
      }
      bool = NetStatusUtil.is4G(PlatformComm.context);
      if (bool)
      {
        AppMethodBeat.o(55566);
        return 5;
      }
      bool = NetStatusUtil.isWifi(i);
      if (bool)
      {
        AppMethodBeat.o(55566);
        return 1;
      }
      bool = NetStatusUtil.isWap(i);
      if (bool)
      {
        AppMethodBeat.o(55566);
        return 2;
      }
      AppMethodBeat.o(55566);
      return 6;
    }
    catch (Exception localException)
    {
      exception2String(localException);
      PlatformComm.Assert.assertTrue(localException.getClass().getSimpleName() + ":" + localException.getStackTrace()[0] + ", " + localException.getStackTrace()[1], false);
      AppMethodBeat.o(55566);
    }
    return -1;
  }
  
  public static boolean isNetworkConnected()
  {
    AppMethodBeat.i(55574);
    if (PlatformComm.context == null)
    {
      PlatformComm.Assert.assertTrue(false);
      AppMethodBeat.o(55574);
      return false;
    }
    try
    {
      boolean bool = NetStatusUtil.isNetworkConnected(PlatformComm.context);
      AppMethodBeat.o(55574);
      return bool;
    }
    catch (Exception localException)
    {
      exception2String(localException);
      PlatformComm.Assert.assertTrue(localException.getClass().getSimpleName() + ":" + localException.getStackTrace()[0] + ", " + localException.getStackTrace()[1], false);
      AppMethodBeat.o(55574);
    }
    return false;
  }
  
  public static boolean startAlarm(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(183724);
    if (PlatformComm.context == null)
    {
      PlatformComm.Assert.assertTrue(false);
      AppMethodBeat.o(183724);
      return false;
    }
    long l = paramInt2;
    try
    {
      boolean bool = Alarm.start(paramInt1, l, paramInt3, PlatformComm.context);
      AppMethodBeat.o(183724);
      return bool;
    }
    catch (Exception localException)
    {
      exception2String(localException);
      PlatformComm.Assert.assertTrue(localException.getClass().getSimpleName() + ":" + localException.getStackTrace()[0] + ", " + localException.getStackTrace()[1], false);
      AppMethodBeat.o(183724);
    }
    return false;
  }
  
  public static boolean stopAlarm(int paramInt)
  {
    AppMethodBeat.i(55568);
    if (PlatformComm.context == null)
    {
      PlatformComm.Assert.assertTrue(false);
      AppMethodBeat.o(55568);
      return false;
    }
    long l = paramInt;
    try
    {
      boolean bool = Alarm.stop(l, PlatformComm.context);
      AppMethodBeat.o(55568);
      return bool;
    }
    catch (Exception localException)
    {
      exception2String(localException);
      PlatformComm.Assert.assertTrue(localException.getClass().getSimpleName() + ":" + localException.getStackTrace()[0] + ", " + localException.getStackTrace()[1], false);
      AppMethodBeat.o(55568);
    }
    return false;
  }
  
  public static WakerLock wakeupLock_new()
  {
    AppMethodBeat.i(55575);
    if (PlatformComm.context == null)
    {
      PlatformComm.Assert.assertTrue(false);
      AppMethodBeat.o(55575);
      return null;
    }
    try
    {
      WakerLock localWakerLock = new WakerLock(PlatformComm.context);
      AppMethodBeat.o(55575);
      return localWakerLock;
    }
    catch (Exception localException)
    {
      exception2String(localException);
      PlatformComm.Assert.assertTrue(localException.getClass().getSimpleName() + ":" + localException.getStackTrace()[0] + ", " + localException.getStackTrace()[1], false);
      AppMethodBeat.o(55575);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.voip.mars.comm.PlatformComm.C2Java
 * JD-Core Version:    0.7.0.1
 */