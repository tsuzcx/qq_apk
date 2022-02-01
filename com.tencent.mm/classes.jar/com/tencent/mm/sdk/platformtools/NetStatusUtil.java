package com.tencent.mm.sdk.platformtools;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.provider.Settings.System;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.systemservicecache.NetworkCache;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

public class NetStatusUtil
{
  public static final String CELL_CDMA = "cdma";
  public static final String CELL_GSM = "gsm";
  public static final int CMNET = 6;
  public static final int CMWAP = 5;
  public static final int CTNET = 8;
  public static final int CTWAP = 7;
  public static final int IOS_NETTYPE_2G = 2;
  public static final int IOS_NETTYPE_3G = 3;
  public static final int IOS_NETTYPE_4G = 4;
  public static final int IOS_NETTYPE_UNKNOW = 0;
  public static final int IOS_NETTYPE_WIFI = 1;
  public static final int LTE = 10;
  public static final int MOBILE = 9;
  public static final int NETTYPE_NOT_WIFI = 0;
  public static final int NETTYPE_WIFI = 1;
  public static final int NETWORK_TYPE_NR = 20;
  public static final int NET_3G = 4;
  public static final int NON_NETWORK = -1;
  public static final int NO_SIM_OPERATOR = 0;
  public static final int NR_5G = 11;
  public static final int OLD_IOS_NETTYPE_2G = 3;
  public static final int OLD_IOS_NETTYPE_3G = 4;
  public static final int OLD_IOS_NETTYPE_4G = 5;
  public static final int OLD_IOS_NETTYPE_NOT_WIFI = 0;
  public static final int OLD_IOS_NETTYPE_WAP = 2;
  public static final int OLD_IOS_NETTYPE_WIFI = 1;
  public static final int POLICY_NONE = 0;
  public static final int POLICY_REJECT_METERED_BACKGROUND = 1;
  private static final String TAG = "MicroMsg.NetStatusUtil";
  public static final int TBACKGROUND_DATA_LIMITED = 2;
  public static final int TBACKGROUND_NOT_LIMITED = 0;
  public static final int TBACKGROUND_PROCESS_LIMITED = 1;
  public static final int TBACKGROUND_WIFI_LIMITED = 3;
  public static final int UNINET = 1;
  public static final int UNIWAP = 2;
  public static final int UNKNOW_TYPE = 999;
  public static final int WAP_3G = 3;
  public static final int WIFI = 0;
  private byte _hellAccFlag_;
  
  public static String dumpNetStatus(Context paramContext)
  {
    AppMethodBeat.i(157730);
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
      localStringBuilder.append("isAvailable " + localNetworkInfo.isAvailable() + "\r\n");
      localStringBuilder.append("isConnected " + localNetworkInfo.isConnected() + "\r\n");
      localStringBuilder.append("isRoaming " + localNetworkInfo.isRoaming() + "\r\n");
      localStringBuilder.append("isFailover " + localNetworkInfo.isFailover() + "\r\n");
      localStringBuilder.append("getSubtypeName " + localNetworkInfo.getSubtypeName() + "\r\n");
      localStringBuilder.append("getSubtype " + localNetworkInfo.getSubtype() + "\r\n");
      localStringBuilder.append("getType " + localNetworkInfo.getType() + "\r\n");
      localStringBuilder.append("getExtraInfo " + localNetworkInfo.getExtraInfo() + "\r\n");
      localStringBuilder.append("activeNetInfo " + localNetworkInfo.toString() + "\r\n");
      localStringBuilder.append("is2G " + is2G(paramContext) + "\r\n");
      localStringBuilder.append("is3G " + is3G(paramContext) + "\r\n");
      localStringBuilder.append("is4G " + is4G(paramContext) + "\r\n");
      localStringBuilder.append("isWifi " + isWifi(paramContext) + "\r\n");
      Log.i("MicroMsg.NetStatusUtil", "netstatus " + localStringBuilder.toString());
      paramContext = localStringBuilder.toString();
      AppMethodBeat.o(157730);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        Log.i("MicroMsg.NetStatusUtil", paramContext.getMessage());
        Log.printErrStackTrace("MicroMsg.NetStatusUtil", paramContext, "", new Object[0]);
      }
    }
  }
  
  public static NetworkInfo getActiveNetworkInfo(Context paramContext)
  {
    AppMethodBeat.i(243564);
    if (paramContext == null)
    {
      AppMethodBeat.o(243564);
      return null;
    }
    if ((paramContext != null) && (paramContext.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0))
    {
      AppMethodBeat.o(243564);
      return null;
    }
    paramContext = (ConnectivityManager)paramContext.getApplicationContext().getSystemService("connectivity");
    if (paramContext == null)
    {
      AppMethodBeat.o(243564);
      return null;
    }
    paramContext = paramContext.getActiveNetworkInfo();
    AppMethodBeat.o(243564);
    return paramContext;
  }
  
  public static int getBackgroundLimitType(Context paramContext)
  {
    AppMethodBeat.i(157754);
    try
    {
      Object localObject = Class.forName("android.app.ActivityManagerNative");
      localObject = ((Class)localObject).getMethod("getDefault", new Class[0]).invoke(localObject, new Object[0]);
      i = ((Integer)localObject.getClass().getMethod("getProcessLimit", new Class[0]).invoke(localObject, new Object[0])).intValue();
      if (i == 0)
      {
        AppMethodBeat.o(157754);
        return 1;
      }
    }
    catch (Exception localException)
    {
      int i;
      Log.printErrStackTrace("MicroMsg.NetStatusUtil", localException, "", new Object[0]);
      try
      {
        i = getWifiSleepPolicy(paramContext);
        if (i != 2)
        {
          int j = getNetType(paramContext);
          if (j == 0) {}
        }
        else
        {
          AppMethodBeat.o(157754);
          return 0;
        }
        if ((i == 1) || (i == 0))
        {
          AppMethodBeat.o(157754);
          return 3;
        }
      }
      catch (Exception paramContext)
      {
        Log.printErrStackTrace("MicroMsg.NetStatusUtil", paramContext, "", new Object[0]);
        AppMethodBeat.o(157754);
      }
    }
    return 0;
  }
  
  @Deprecated
  public static List<NetStatusUtil.CellInfo> getCellInfoList(Context paramContext)
  {
    try
    {
      AppMethodBeat.i(157760);
      Log.e("MicroMsg.NetStatusUtil", "getCellInfoList() here will always return empty list, and mostly you should not read cell info list any more");
      paramContext = new LinkedList();
      AppMethodBeat.o(157760);
      return paramContext;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static String getFormatedNetType(Context paramContext)
  {
    AppMethodBeat.i(157733);
    if (is2G(paramContext))
    {
      AppMethodBeat.o(157733);
      return "2G";
    }
    if (is3G(paramContext))
    {
      AppMethodBeat.o(157733);
      return "3G";
    }
    if (is4G(paramContext))
    {
      AppMethodBeat.o(157733);
      return "4G";
    }
    if (is5G(paramContext))
    {
      AppMethodBeat.o(157733);
      return "5G";
    }
    if (isWifi(paramContext))
    {
      AppMethodBeat.o(157733);
      return "WIFI";
    }
    paramContext = getNetTypeString(paramContext);
    AppMethodBeat.o(157733);
    return paramContext;
  }
  
  public static int getIOSNetType(Context paramContext)
  {
    AppMethodBeat.i(157734);
    if ((paramContext != null) && (paramContext.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0))
    {
      AppMethodBeat.o(157734);
      return 0;
    }
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramContext == null)
      {
        AppMethodBeat.o(157734);
        return 0;
      }
      int i = paramContext.getType();
      if (i == 1)
      {
        AppMethodBeat.o(157734);
        return 1;
      }
      if (paramContext.getSubtype() != 1)
      {
        i = paramContext.getSubtype();
        if (i != 2) {}
      }
      else
      {
        AppMethodBeat.o(157734);
        return 2;
      }
      i = paramContext.getSubtype();
      if (i >= 13)
      {
        AppMethodBeat.o(157734);
        return 4;
      }
      i = paramContext.getSubtype();
      if (i >= 3)
      {
        AppMethodBeat.o(157734);
        return 3;
      }
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(157734);
    }
    return 0;
  }
  
  public static int getIOSNetType(NetworkInfo paramNetworkInfo)
  {
    AppMethodBeat.i(243547);
    if (paramNetworkInfo == null)
    {
      AppMethodBeat.o(243547);
      return 0;
    }
    try
    {
      int i = paramNetworkInfo.getType();
      if (i == 1)
      {
        AppMethodBeat.o(243547);
        return 1;
      }
      if (paramNetworkInfo.getSubtype() != 1)
      {
        i = paramNetworkInfo.getSubtype();
        if (i != 2) {}
      }
      else
      {
        AppMethodBeat.o(243547);
        return 2;
      }
      i = paramNetworkInfo.getSubtype();
      if (i >= 13)
      {
        AppMethodBeat.o(243547);
        return 4;
      }
      i = paramNetworkInfo.getSubtype();
      if (i >= 3)
      {
        AppMethodBeat.o(243547);
        return 3;
      }
    }
    catch (Exception paramNetworkInfo)
    {
      AppMethodBeat.o(243547);
    }
    return 0;
  }
  
  public static int getIOSOldNetType(Context paramContext)
  {
    AppMethodBeat.i(157735);
    if ((paramContext != null) && (paramContext.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0))
    {
      AppMethodBeat.o(157735);
      return 0;
    }
    try
    {
      int i = getNetType(paramContext);
      paramContext = ((ConnectivityManager)paramContext.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramContext == null)
      {
        AppMethodBeat.o(157735);
        return 0;
      }
      int j = paramContext.getType();
      if (j == 1)
      {
        AppMethodBeat.o(157735);
        return 1;
      }
      if (paramContext.getSubtype() != 1)
      {
        j = paramContext.getSubtype();
        if (j != 2) {}
      }
      else
      {
        AppMethodBeat.o(157735);
        return 3;
      }
      j = paramContext.getSubtype();
      if (j >= 13)
      {
        AppMethodBeat.o(157735);
        return 5;
      }
      j = paramContext.getSubtype();
      if (j >= 3)
      {
        AppMethodBeat.o(157735);
        return 4;
      }
      boolean bool = isWap(i);
      if (bool)
      {
        AppMethodBeat.o(157735);
        return 2;
      }
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(157735);
    }
    return 0;
  }
  
  public static int getISPCode(Context paramContext)
  {
    AppMethodBeat.i(157738);
    paramContext = (TelephonyManager)paramContext.getSystemService("phone");
    if (paramContext == null)
    {
      AppMethodBeat.o(157738);
      return 0;
    }
    paramContext = paramContext.getSimOperator();
    if ((paramContext == null) || (paramContext.length() < 5))
    {
      AppMethodBeat.o(157738);
      return 0;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    for (;;)
    {
      try
      {
        j = paramContext.length();
        i = j;
        if (j <= 6) {
          break label160;
        }
        i = 6;
      }
      catch (Exception paramContext)
      {
        Log.printErrStackTrace("MicroMsg.NetStatusUtil", paramContext, "", new Object[0]);
        AppMethodBeat.o(157738);
        return 0;
      }
      if (j < i) {
        if (!Character.isDigit(paramContext.charAt(j)))
        {
          if (localStringBuilder.length() <= 0) {
            break label165;
          }
        }
        else
        {
          localStringBuilder.append(paramContext.charAt(j));
          break label165;
        }
      }
      int i = Integer.valueOf(localStringBuilder.toString()).intValue();
      AppMethodBeat.o(157738);
      return i;
      label160:
      int j = 0;
      continue;
      label165:
      j += 1;
    }
  }
  
  public static String getISPName(Context paramContext)
  {
    AppMethodBeat.i(157739);
    try
    {
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      if (paramContext == null)
      {
        AppMethodBeat.o(157739);
        return "";
      }
      Log.d("MicroMsg.NetStatusUtil", "getISPName ISPName=%s", new Object[] { paramContext.getSimOperatorName() });
      if (paramContext.getSimOperatorName().length() <= 100)
      {
        paramContext = paramContext.getSimOperatorName();
        AppMethodBeat.o(157739);
        return paramContext;
      }
      paramContext = paramContext.getSimOperatorName().substring(0, 100);
      AppMethodBeat.o(157739);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(157739);
    }
    return "";
  }
  
  public static int getNetType(Context paramContext)
  {
    AppMethodBeat.i(157737);
    if ((paramContext != null) && (paramContext.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0))
    {
      AppMethodBeat.o(157737);
      return -1;
    }
    paramContext = (ConnectivityManager)paramContext.getApplicationContext().getSystemService("connectivity");
    if (paramContext == null)
    {
      AppMethodBeat.o(157737);
      return -1;
    }
    paramContext = paramContext.getActiveNetworkInfo();
    if (paramContext == null)
    {
      AppMethodBeat.o(157737);
      return -1;
    }
    int i = getNetType(paramContext);
    AppMethodBeat.o(157737);
    return i;
  }
  
  public static int getNetType(NetworkInfo paramNetworkInfo)
  {
    AppMethodBeat.i(243579);
    if (paramNetworkInfo.getType() == 1)
    {
      AppMethodBeat.o(243579);
      return 0;
    }
    Log.d("MicroMsg.NetStatusUtil", "activeNetInfo extra=%s, type=%d", new Object[] { paramNetworkInfo.getExtraInfo(), Integer.valueOf(paramNetworkInfo.getType()) });
    if (paramNetworkInfo.getExtraInfo() != null)
    {
      if (paramNetworkInfo.getExtraInfo().equalsIgnoreCase("uninet"))
      {
        AppMethodBeat.o(243579);
        return 1;
      }
      if (paramNetworkInfo.getExtraInfo().equalsIgnoreCase("uniwap"))
      {
        AppMethodBeat.o(243579);
        return 2;
      }
      if (paramNetworkInfo.getExtraInfo().equalsIgnoreCase("3gwap"))
      {
        AppMethodBeat.o(243579);
        return 3;
      }
      if (paramNetworkInfo.getExtraInfo().equalsIgnoreCase("3gnet"))
      {
        AppMethodBeat.o(243579);
        return 4;
      }
      if (paramNetworkInfo.getExtraInfo().equalsIgnoreCase("cmwap"))
      {
        AppMethodBeat.o(243579);
        return 5;
      }
      if (paramNetworkInfo.getExtraInfo().equalsIgnoreCase("cmnet"))
      {
        AppMethodBeat.o(243579);
        return 6;
      }
      if (paramNetworkInfo.getExtraInfo().equalsIgnoreCase("ctwap"))
      {
        AppMethodBeat.o(243579);
        return 7;
      }
      if (paramNetworkInfo.getExtraInfo().equalsIgnoreCase("ctnet"))
      {
        AppMethodBeat.o(243579);
        return 8;
      }
      if (paramNetworkInfo.getExtraInfo().equalsIgnoreCase("LTE"))
      {
        AppMethodBeat.o(243579);
        return 10;
      }
    }
    AppMethodBeat.o(243579);
    return 9;
  }
  
  public static int getNetTypeForStat(Context paramContext)
  {
    AppMethodBeat.i(157756);
    if ((paramContext != null) && (paramContext.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0))
    {
      AppMethodBeat.o(157756);
      return 999;
    }
    try
    {
      paramContext = (ConnectivityManager)paramContext.getApplicationContext().getSystemService("connectivity");
      if (paramContext == null)
      {
        AppMethodBeat.o(157756);
        return 999;
      }
      paramContext = paramContext.getActiveNetworkInfo();
      if (paramContext == null)
      {
        AppMethodBeat.o(157756);
        return 999;
      }
      int i = paramContext.getType();
      if (i == 1)
      {
        AppMethodBeat.o(157756);
        return 1;
      }
      i = paramContext.getSubtype();
      if (i == 0)
      {
        AppMethodBeat.o(157756);
        return 999;
      }
      AppMethodBeat.o(157756);
      return i * 1000;
    }
    catch (Exception paramContext)
    {
      Log.printErrStackTrace("MicroMsg.NetStatusUtil", paramContext, "", new Object[0]);
      AppMethodBeat.o(157756);
    }
    return 999;
  }
  
  public static String getNetTypeString(Context paramContext)
  {
    AppMethodBeat.i(157732);
    if ((paramContext != null) && (paramContext.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0))
    {
      AppMethodBeat.o(157732);
      return "NON_NETWORK";
    }
    try
    {
      paramContext = (ConnectivityManager)paramContext.getApplicationContext().getSystemService("connectivity");
      if (paramContext == null)
      {
        AppMethodBeat.o(157732);
        return "NON_NETWORK";
      }
      paramContext = paramContext.getActiveNetworkInfo();
      if (paramContext == null)
      {
        AppMethodBeat.o(157732);
        return "NON_NETWORK";
      }
      if (paramContext.getType() == 1)
      {
        AppMethodBeat.o(157732);
        return "WIFI";
      }
      Log.d("MicroMsg.NetStatusUtil", "activeNetInfo extra=%s, type=%d", new Object[] { paramContext.getExtraInfo(), Integer.valueOf(paramContext.getType()) });
      if (paramContext.getExtraInfo() != null)
      {
        paramContext = paramContext.getExtraInfo();
        AppMethodBeat.o(157732);
        return paramContext;
      }
      AppMethodBeat.o(157732);
      return "MOBILE";
    }
    catch (Exception paramContext)
    {
      Log.printErrStackTrace("MicroMsg.NetStatusUtil", paramContext, "", new Object[0]);
      AppMethodBeat.o(157732);
    }
    return "NON_NETWORK";
  }
  
  public static int getNetWorkType(Context paramContext)
  {
    AppMethodBeat.i(157736);
    if ((paramContext != null) && (paramContext.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0))
    {
      AppMethodBeat.o(157736);
      return -1;
    }
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramContext != null)
      {
        int i = paramContext.getType();
        AppMethodBeat.o(157736);
        return i;
      }
    }
    catch (Exception paramContext)
    {
      Log.printErrStackTrace("MicroMsg.NetStatusUtil", paramContext, "", new Object[0]);
      AppMethodBeat.o(157736);
    }
    return -1;
  }
  
  public static int getProxyInfo(Context paramContext, StringBuffer paramStringBuffer)
  {
    AppMethodBeat.i(243760);
    try
    {
      paramContext = Proxy.getDefaultHost();
      int i = Proxy.getDefaultPort();
      Log.d("MicroMsg.NetStatusUtil", "dkwap api host:%s port:%d thr:%d", new Object[] { paramContext, Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()) });
      if ((paramContext != null) && (paramContext.length() > 0) && (i > 0))
      {
        paramStringBuffer.append(paramContext);
        AppMethodBeat.o(243760);
        return i;
      }
      paramContext = System.getProperty("http.proxyHost");
      String str = System.getProperty("http.proxyPort");
      Log.d("MicroMsg.NetStatusUtil", "dkwap vm host:%s port:%s thr:%d", new Object[] { paramContext, str, Long.valueOf(Thread.currentThread().getId()) });
      int j = 80;
      i = j;
      if (str != null)
      {
        i = j;
        if (str.length() > 0) {
          i = Integer.parseInt(str);
        }
      }
      if ((paramContext != null) && (paramContext.length() > 0))
      {
        paramStringBuffer.append(paramContext);
        AppMethodBeat.o(243760);
        return i;
      }
    }
    catch (Exception paramContext)
    {
      Log.printErrStackTrace("MicroMsg.NetStatusUtil", paramContext, "", new Object[0]);
      AppMethodBeat.o(243760);
    }
    return 0;
  }
  
  public static int getWifiSleepPolicy(Context paramContext)
  {
    AppMethodBeat.i(243738);
    int i = Settings.System.getInt(paramContext.getContentResolver(), "wifi_sleep_policy", 2);
    AppMethodBeat.o(243738);
    return i;
  }
  
  public static int guessNetSpeed(Context paramContext)
  {
    AppMethodBeat.i(243620);
    if ((paramContext != null) && (paramContext.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0))
    {
      AppMethodBeat.o(243620);
      return 102400;
    }
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
      int i = paramContext.getType();
      if (i == 1)
      {
        AppMethodBeat.o(243620);
        return 102400;
      }
      i = paramContext.getSubtype();
      switch (i)
      {
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.NetStatusUtil", paramContext, "", new Object[0]);
      }
    }
    AppMethodBeat.o(243620);
    return 102400;
    AppMethodBeat.o(243620);
    return 4096;
    AppMethodBeat.o(243620);
    return 8192;
    AppMethodBeat.o(243620);
    return 102400;
  }
  
  public static boolean is2G(Context paramContext)
  {
    AppMethodBeat.i(157741);
    if ((paramContext == null) || (paramContext.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0))
    {
      AppMethodBeat.o(157741);
      return false;
    }
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramContext == null)
      {
        AppMethodBeat.o(157741);
        return false;
      }
      int i = paramContext.getType();
      if (i == 1)
      {
        AppMethodBeat.o(157741);
        return false;
      }
      Log.d("MicroMsg.NetStatusUtil", "is2G subtype %d", new Object[] { Integer.valueOf(paramContext.getSubtype()) });
      if ((paramContext.getSubtype() != 2) && (paramContext.getSubtype() != 1) && (paramContext.getSubtype() != 4) && (paramContext.getSubtype() != 16) && (paramContext.getSubtype() != 7))
      {
        i = paramContext.getSubtype();
        if (i != 11) {}
      }
      else
      {
        AppMethodBeat.o(157741);
        return true;
      }
    }
    catch (Exception paramContext)
    {
      Log.printErrStackTrace("MicroMsg.NetStatusUtil", paramContext, "", new Object[0]);
      AppMethodBeat.o(157741);
    }
    return false;
  }
  
  public static boolean is3G(Context paramContext)
  {
    AppMethodBeat.i(157744);
    if ((paramContext != null) && (paramContext.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0))
    {
      AppMethodBeat.o(157744);
      return false;
    }
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramContext == null)
      {
        AppMethodBeat.o(157744);
        return false;
      }
      int i = paramContext.getType();
      if (i == 1)
      {
        AppMethodBeat.o(157744);
        return false;
      }
      Log.d("MicroMsg.NetStatusUtil", "is3G subtype %d", new Object[] { Integer.valueOf(paramContext.getSubtype()) });
      if (paramContext.getSubtype() >= 5)
      {
        i = paramContext.getSubtype();
        if (i < 13)
        {
          AppMethodBeat.o(157744);
          return true;
        }
      }
    }
    catch (Exception paramContext)
    {
      Log.printErrStackTrace("MicroMsg.NetStatusUtil", paramContext, "", new Object[0]);
      AppMethodBeat.o(157744);
    }
    return false;
  }
  
  public static boolean is4G(Context paramContext)
  {
    AppMethodBeat.i(157742);
    if ((paramContext != null) && (paramContext.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0))
    {
      AppMethodBeat.o(157742);
      return false;
    }
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramContext == null)
      {
        AppMethodBeat.o(157742);
        return false;
      }
      int i = paramContext.getType();
      if (i == 1)
      {
        AppMethodBeat.o(157742);
        return false;
      }
      Log.d("MicroMsg.NetStatusUtil", "is4G subtype %d", new Object[] { Integer.valueOf(paramContext.getSubtype()) });
      if (paramContext.getSubtype() >= 13)
      {
        i = paramContext.getSubtype();
        if (i < 20)
        {
          AppMethodBeat.o(157742);
          return true;
        }
      }
    }
    catch (Exception paramContext)
    {
      Log.printErrStackTrace("MicroMsg.NetStatusUtil", paramContext, "", new Object[0]);
      AppMethodBeat.o(157742);
    }
    return false;
  }
  
  public static boolean is5G(Context paramContext)
  {
    AppMethodBeat.i(243664);
    if (paramContext != null) {}
    try
    {
      int i = paramContext.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE");
      if (i != 0)
      {
        AppMethodBeat.o(243664);
        return false;
      }
      paramContext = ((ConnectivityManager)paramContext.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramContext == null)
      {
        AppMethodBeat.o(243664);
        return false;
      }
      i = paramContext.getType();
      if (i == 1)
      {
        AppMethodBeat.o(243664);
        return false;
      }
      Log.d("MicroMsg.NetStatusUtil", "is5G subtype %d", new Object[] { Integer.valueOf(paramContext.getSubtype()) });
      i = paramContext.getSubtype();
      if (i >= 20)
      {
        AppMethodBeat.o(243664);
        return true;
      }
    }
    catch (Exception paramContext)
    {
      Log.printErrStackTrace("MicroMsg.NetStatusUtil", paramContext, "", new Object[0]);
      AppMethodBeat.o(243664);
    }
    return false;
  }
  
  public static boolean isConnected(Context paramContext)
  {
    AppMethodBeat.i(157731);
    if ((paramContext != null) && (paramContext.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0))
    {
      AppMethodBeat.o(157731);
      return false;
    }
    paramContext = (ConnectivityManager)paramContext.getApplicationContext().getSystemService("connectivity");
    if (paramContext == null)
    {
      AppMethodBeat.o(157731);
      return false;
    }
    paramContext = paramContext.getActiveNetworkInfo();
    try
    {
      bool = paramContext.isConnected();
      AppMethodBeat.o(157731);
      return bool;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        boolean bool = false;
      }
    }
  }
  
  public static boolean isConnected(NetworkInfo paramNetworkInfo)
  {
    AppMethodBeat.i(243489);
    boolean bool1 = false;
    try
    {
      boolean bool2 = paramNetworkInfo.isConnected();
      bool1 = bool2;
    }
    catch (Exception paramNetworkInfo)
    {
      label15:
      break label15;
    }
    AppMethodBeat.o(243489);
    return bool1;
  }
  
  public static boolean isImmediatelyDestroyActivities(Context paramContext)
  {
    AppMethodBeat.i(243752);
    if (Settings.System.getInt(paramContext.getContentResolver(), "always_finish_activities", 0) != 0)
    {
      AppMethodBeat.o(243752);
      return true;
    }
    AppMethodBeat.o(243752);
    return false;
  }
  
  public static boolean isKnownDirectNet(Context paramContext)
  {
    AppMethodBeat.i(243763);
    int i = getNetType(paramContext);
    if ((6 == i) || (1 == i) || (4 == i) || (8 == i) || (10 == i) || (i == 0))
    {
      AppMethodBeat.o(243763);
      return true;
    }
    AppMethodBeat.o(243763);
    return false;
  }
  
  public static boolean isLimited(int paramInt)
  {
    return (paramInt == 2) || (paramInt == 1) || (paramInt == 3);
  }
  
  public static boolean isMobile(Context paramContext)
  {
    AppMethodBeat.i(157740);
    if ((paramContext != null) && (paramContext.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0))
    {
      AppMethodBeat.o(157740);
      return false;
    }
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramContext == null)
      {
        AppMethodBeat.o(157740);
        return false;
      }
      if (paramContext.getType() != 1)
      {
        AppMethodBeat.o(157740);
        return true;
      }
      AppMethodBeat.o(157740);
      return false;
    }
    catch (Exception paramContext)
    {
      Log.printErrStackTrace("MicroMsg.NetStatusUtil", paramContext, "", new Object[0]);
      AppMethodBeat.o(157740);
    }
    return false;
  }
  
  public static boolean isMobileNetworkOpen(Context paramContext)
  {
    AppMethodBeat.i(243643);
    try
    {
      paramContext = (ConnectivityManager)paramContext.getApplicationContext().getSystemService("connectivity");
      if (paramContext != null)
      {
        Method localMethod = paramContext.getClass().getMethod("getMobileDataEnabled", new Class[0]);
        localMethod.setAccessible(true);
        boolean bool = ((Boolean)localMethod.invoke(paramContext, new Object[0])).booleanValue();
        AppMethodBeat.o(243643);
        return bool;
      }
    }
    catch (Exception paramContext)
    {
      Log.printErrStackTrace("MicroMsg.NetStatusUtil", paramContext, "", new Object[0]);
      AppMethodBeat.o(243643);
    }
    return false;
  }
  
  @Deprecated
  public static boolean isNetworkConnected(Context paramContext)
  {
    AppMethodBeat.i(157755);
    boolean bool = isConnected(paramContext);
    AppMethodBeat.o(157755);
    return bool;
  }
  
  public static boolean isWap(int paramInt)
  {
    return (paramInt == 2) || (paramInt == 5) || (paramInt == 7) || (paramInt == 3);
  }
  
  public static boolean isWap(Context paramContext)
  {
    AppMethodBeat.i(157743);
    boolean bool = isWap(getNetType(paramContext));
    AppMethodBeat.o(157743);
    return bool;
  }
  
  public static boolean isWapFromCache(Context paramContext)
  {
    AppMethodBeat.i(243670);
    boolean bool = NetworkCache.INSTANCE.isWapFromCache(paramContext);
    AppMethodBeat.o(243670);
    return bool;
  }
  
  public static boolean isWifi(int paramInt)
  {
    return paramInt == 0;
  }
  
  public static boolean isWifi(Context paramContext)
  {
    AppMethodBeat.i(157745);
    boolean bool = isWifi(getNetType(paramContext));
    AppMethodBeat.o(157745);
    return bool;
  }
  
  public static boolean isWifi(NetworkInfo paramNetworkInfo)
  {
    AppMethodBeat.i(243684);
    boolean bool = isWifi(getNetType(paramNetworkInfo));
    AppMethodBeat.o(243684);
    return bool;
  }
  
  public static boolean isWifiFromCache(Context paramContext)
  {
    AppMethodBeat.i(243699);
    boolean bool = NetworkCache.INSTANCE.isWifiFromCache(paramContext);
    AppMethodBeat.o(243699);
    return bool;
  }
  
  public static boolean isWifiOr4G(Context paramContext)
  {
    AppMethodBeat.i(157757);
    int i = getNetType(paramContext);
    if ((i == 0) || (i == 10))
    {
      Log.d("MicroMsg.NetStatusUtil", "[cpan] is wifi or 4g network");
      AppMethodBeat.o(157757);
      return true;
    }
    Log.d("MicroMsg.NetStatusUtil", "[cpan] is mobile network");
    AppMethodBeat.o(157757);
    return false;
  }
  
  private static Intent searchIntentByClass(Context paramContext, String paramString)
  {
    AppMethodBeat.i(157747);
    try
    {
      PackageManager localPackageManager = paramContext.getPackageManager();
      List localList = localPackageManager.getInstalledPackages(0);
      if ((localList != null) && (localList.size() > 0))
      {
        Log.e("MicroMsg.NetStatusUtil", "package  size" + localList.size());
        int i = 0;
        for (;;)
        {
          int j = localList.size();
          if (i >= j) {
            break label418;
          }
          try
          {
            Log.e("MicroMsg.NetStatusUtil", "package " + ((PackageInfo)localList.get(i)).packageName);
            Object localObject1 = new Intent();
            ((Intent)localObject1).setPackage(((PackageInfo)localList.get(i)).packageName);
            Object localObject2 = localPackageManager.queryIntentActivities((Intent)localObject1, 0);
            if (localObject2 != null) {
              j = ((List)localObject2).size();
            }
            for (;;)
            {
              if (j > 0) {
                try
                {
                  Log.e("MicroMsg.NetStatusUtil", "activityName count ".concat(String.valueOf(j)));
                  int k = 0;
                  for (;;)
                  {
                    if (k >= j) {
                      break label380;
                    }
                    localObject1 = ((ResolveInfo)((List)localObject2).get(k)).activityInfo;
                    if (((ActivityInfo)localObject1).name.contains(paramString))
                    {
                      localObject2 = new Intent("/");
                      ((Intent)localObject2).setComponent(new ComponentName(((ActivityInfo)localObject1).packageName, ((ActivityInfo)localObject1).name));
                      ((Intent)localObject2).setAction("android.intent.action.VIEW");
                      localObject1 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject2);
                      com.tencent.mm.hellhoundlib.a.a.b(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aYi(), "com/tencent/mm/sdk/platformtools/NetStatusUtil", "searchIntentByClass", "(Landroid/content/Context;Ljava/lang/String;)Landroid/content/Intent;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                      paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sb(0));
                      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/sdk/platformtools/NetStatusUtil", "searchIntentByClass", "(Landroid/content/Context;Ljava/lang/String;)Landroid/content/Intent;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                      AppMethodBeat.o(157747);
                      return localObject2;
                      j = 0;
                      break;
                    }
                    k += 1;
                  }
                  i += 1;
                }
                catch (Exception localException1)
                {
                  Log.printErrStackTrace("MicroMsg.NetStatusUtil", localException1, "", new Object[0]);
                }
              }
            }
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              label380:
              Log.printErrStackTrace("MicroMsg.NetStatusUtil", localException2, "", new Object[0]);
            }
          }
        }
      }
      label418:
      return null;
    }
    catch (Exception paramContext)
    {
      Log.printErrStackTrace("MicroMsg.NetStatusUtil", paramContext, "", new Object[0]);
      AppMethodBeat.o(157747);
    }
  }
  
  public static void startSettingItent(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(157748);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(157748);
      return;
      AppMethodBeat.o(157748);
      return;
      try
      {
        Object localObject1 = new Intent("/");
        ((Intent)localObject1).setComponent(new ComponentName("com.android.providers.subscribedfeeds", "com.android.settings.ManageAccountsSettings"));
        ((Intent)localObject1).setAction("android.intent.action.VIEW");
        localObject1 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject1);
        com.tencent.mm.hellhoundlib.a.a.b(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aYi(), "com/tencent/mm/sdk/platformtools/NetStatusUtil", "startSettingItent", "(Landroid/content/Context;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/sdk/platformtools/NetStatusUtil", "startSettingItent", "(Landroid/content/Context;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(157748);
        return;
      }
      catch (Exception localException1)
      {
        try
        {
          Object localObject2 = new Intent("/");
          ((Intent)localObject2).setComponent(new ComponentName("com.htc.settings.accountsync", "com.htc.settings.accountsync.ManageAccountsSettings"));
          ((Intent)localObject2).setAction("android.intent.action.VIEW");
          localObject2 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject2);
          com.tencent.mm.hellhoundlib.a.a.b(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aYi(), "com/tencent/mm/sdk/platformtools/NetStatusUtil", "startSettingItent", "(Landroid/content/Context;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/sdk/platformtools/NetStatusUtil", "startSettingItent", "(Landroid/content/Context;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(157748);
          return;
        }
        catch (Exception localException2)
        {
          searchIntentByClass(paramContext, "ManageAccountsSettings");
          AppMethodBeat.o(157748);
          return;
        }
      }
      try
      {
        Object localObject3 = new Intent("/");
        ((Intent)localObject3).setComponent(new ComponentName("com.android.settings", "com.android.settings.DevelopmentSettings"));
        ((Intent)localObject3).setAction("android.intent.action.VIEW");
        localObject3 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject3);
        com.tencent.mm.hellhoundlib.a.a.b(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject3).aYi(), "com/tencent/mm/sdk/platformtools/NetStatusUtil", "startSettingItent", "(Landroid/content/Context;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject3).sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/sdk/platformtools/NetStatusUtil", "startSettingItent", "(Landroid/content/Context;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(157748);
        return;
      }
      catch (Exception localException3)
      {
        searchIntentByClass(paramContext, "DevelopmentSettings");
        AppMethodBeat.o(157748);
        return;
      }
      try
      {
        Object localObject4 = new Intent();
        ((Intent)localObject4).setAction("android.settings.WIFI_IP_SETTINGS");
        localObject4 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject4);
        com.tencent.mm.hellhoundlib.a.a.b(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject4).aYi(), "com/tencent/mm/sdk/platformtools/NetStatusUtil", "startSettingItent", "(Landroid/content/Context;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject4).sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/sdk/platformtools/NetStatusUtil", "startSettingItent", "(Landroid/content/Context;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(157748);
        return;
      }
      catch (Exception localException4)
      {
        searchIntentByClass(paramContext, "AdvancedSettings");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.NetStatusUtil
 * JD-Core Version:    0.7.0.1
 */