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
import android.net.NetworkInfo.State;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.provider.Settings.System;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class at
{
  private static int nND = -1;
  private static int nowStrength;
  private static PhoneStateListener yoZ = null;
  private static int ypa = 10000;
  
  static
  {
    nowStrength = 10000;
  }
  
  private static String Ou(String paramString)
  {
    AppMethodBeat.i(52194);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(52194);
      return "";
    }
    String str = paramString;
    if (paramString.startsWith("\""))
    {
      str = paramString;
      if (paramString.endsWith("\"")) {
        str = paramString.substring(1, paramString.length() - 1);
      }
    }
    AppMethodBeat.o(52194);
    return str;
  }
  
  private static String dtt()
  {
    AppMethodBeat.i(52193);
    long l = System.currentTimeMillis();
    try
    {
      if (NetworkInterface.getNetworkInterfaces() != null)
      {
        Object localObject1 = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (NetworkInterface)((Iterator)localObject1).next();
          if (((NetworkInterface)localObject2).getName().equalsIgnoreCase("wlan0"))
          {
            localObject1 = ((NetworkInterface)localObject2).getHardwareAddress();
            if (localObject1 == null)
            {
              ab.d("MicroMsg.NetStatusUtil", "et mobile mac from net time cost :" + (System.currentTimeMillis() - l));
              AppMethodBeat.o(52193);
              return "02:00:00:00:00:00";
            }
            localObject2 = new StringBuilder();
            int j = localObject1.length;
            int i = 0;
            while (i < j)
            {
              ((StringBuilder)localObject2).append(String.format("%02X:", new Object[] { Byte.valueOf(localObject1[i]) }));
              i += 1;
            }
            if (((StringBuilder)localObject2).length() > 0) {
              ((StringBuilder)localObject2).deleteCharAt(((StringBuilder)localObject2).length() - 1);
            }
            ab.d("MicroMsg.NetStatusUtil", "et mobile mac from net time cost :" + (System.currentTimeMillis() - l));
            localObject1 = ((StringBuilder)localObject2).toString();
            AppMethodBeat.o(52193);
            return localObject1;
          }
        }
      }
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.NetStatusUtil", "get mobile mac from net fail!".concat(String.valueOf(localException)));
      ab.d("MicroMsg.NetStatusUtil", "et mobile mac from net time cost :" + (System.currentTimeMillis() - l));
      AppMethodBeat.o(52193);
    }
    return "02:00:00:00:00:00";
  }
  
  public static String gT(Context paramContext)
  {
    AppMethodBeat.i(52171);
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      localStringBuilder.append("isAvailable " + localNetworkInfo.isAvailable() + "\r\n");
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
      ab.i("MicroMsg.NetStatusUtil", "netstatus " + localStringBuilder.toString());
      paramContext = localStringBuilder.toString();
      AppMethodBeat.o(52171);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        ab.i("MicroMsg.NetStatusUtil", paramContext.getMessage());
        ab.printErrStackTrace("MicroMsg.NetStatusUtil", paramContext, "", new Object[0]);
      }
    }
  }
  
  public static String gU(Context paramContext)
  {
    AppMethodBeat.i(52174);
    if (is2G(paramContext))
    {
      AppMethodBeat.o(52174);
      return "2G";
    }
    if (is3G(paramContext))
    {
      AppMethodBeat.o(52174);
      return "3G";
    }
    if (is4G(paramContext))
    {
      AppMethodBeat.o(52174);
      return "4G";
    }
    if (isWifi(paramContext))
    {
      AppMethodBeat.o(52174);
      return "WIFI";
    }
    paramContext = getNetTypeString(paramContext);
    AppMethodBeat.o(52174);
    return paramContext;
  }
  
  public static int gV(Context paramContext)
  {
    AppMethodBeat.i(52175);
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramContext == null)
      {
        AppMethodBeat.o(52175);
        return 0;
      }
      int i = paramContext.getType();
      if (i == 1)
      {
        AppMethodBeat.o(52175);
        return 1;
      }
      if (paramContext.getSubtype() != 1)
      {
        i = paramContext.getSubtype();
        if (i != 2) {}
      }
      else
      {
        AppMethodBeat.o(52175);
        return 2;
      }
      i = paramContext.getSubtype();
      if (i >= 13)
      {
        AppMethodBeat.o(52175);
        return 4;
      }
      i = paramContext.getSubtype();
      if (i >= 3)
      {
        AppMethodBeat.o(52175);
        return 3;
      }
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(52175);
    }
    return 0;
  }
  
  public static int gW(Context paramContext)
  {
    AppMethodBeat.i(52176);
    try
    {
      int i = getNetType(paramContext);
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramContext == null)
      {
        AppMethodBeat.o(52176);
        return 0;
      }
      int j = paramContext.getType();
      if (j == 1)
      {
        AppMethodBeat.o(52176);
        return 1;
      }
      if (paramContext.getSubtype() != 1)
      {
        j = paramContext.getSubtype();
        if (j != 2) {}
      }
      else
      {
        AppMethodBeat.o(52176);
        return 3;
      }
      j = paramContext.getSubtype();
      if (j >= 13)
      {
        AppMethodBeat.o(52176);
        return 5;
      }
      j = paramContext.getSubtype();
      if (j >= 3)
      {
        AppMethodBeat.o(52176);
        return 4;
      }
      boolean bool = isWap(i);
      if (bool)
      {
        AppMethodBeat.o(52176);
        return 2;
      }
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(52176);
    }
    return 0;
  }
  
  public static String gX(Context paramContext)
  {
    AppMethodBeat.i(52190);
    if (getNetType(paramContext) != 0)
    {
      ab.i("MicroMsg.NetStatusUtil", "wifi not connected. getConnectedWifiSsid() is empty");
      AppMethodBeat.o(52190);
      return "";
    }
    Object localObject = (WifiManager)paramContext.getSystemService("wifi");
    if (localObject == null)
    {
      AppMethodBeat.o(52190);
      return "";
    }
    WifiInfo localWifiInfo = ((WifiManager)localObject).getConnectionInfo();
    if (localWifiInfo == null)
    {
      AppMethodBeat.o(52190);
      return "";
    }
    paramContext = localWifiInfo.getSSID();
    if (Build.VERSION.SDK_INT >= 27)
    {
      localObject = ((WifiManager)localObject).getConfiguredNetworks().iterator();
      while (((Iterator)localObject).hasNext())
      {
        WifiConfiguration localWifiConfiguration = (WifiConfiguration)((Iterator)localObject).next();
        if (localWifiConfiguration.networkId == localWifiInfo.getNetworkId())
        {
          ab.i("MicroMsg.NetStatusUtil", "get wifi config ssid %s", new Object[] { localWifiConfiguration.SSID });
          paramContext = localWifiConfiguration.SSID;
        }
      }
    }
    for (;;)
    {
      paramContext = bo.nullAsNil(paramContext);
      ab.i("MicroMsg.NetStatusUtil", "getConnectedWifiSsid()=" + Ou(paramContext));
      paramContext = Ou(paramContext);
      AppMethodBeat.o(52190);
      return paramContext;
    }
  }
  
  public static String gY(Context paramContext)
  {
    AppMethodBeat.i(52191);
    if (getNetType(paramContext) != 0)
    {
      ab.i("MicroMsg.NetStatusUtil", "wifi not connected. getConnectedWifiBssid() is empty");
      AppMethodBeat.o(52191);
      return "";
    }
    paramContext = (WifiManager)paramContext.getSystemService("wifi");
    if (paramContext == null)
    {
      AppMethodBeat.o(52191);
      return "";
    }
    paramContext = paramContext.getConnectionInfo();
    if (paramContext == null)
    {
      AppMethodBeat.o(52191);
      return "";
    }
    paramContext = bo.nullAsNil(paramContext.getBSSID()).toLowerCase();
    ab.i("MicroMsg.NetStatusUtil", "getConnectedWifiBssid()=".concat(String.valueOf(paramContext)));
    AppMethodBeat.o(52191);
    return paramContext;
  }
  
  public static String gZ(Context paramContext)
  {
    AppMethodBeat.i(52192);
    paramContext = (WifiManager)paramContext.getSystemService("wifi");
    if (paramContext == null)
    {
      ab.e("MicroMsg.NetStatusUtil", "error wifiManager is null!!");
      AppMethodBeat.o(52192);
      return "";
    }
    paramContext = paramContext.getConnectionInfo();
    if (paramContext == null)
    {
      ab.e("MicroMsg.NetStatusUtil", "error wifiInfo is null!!");
      AppMethodBeat.o(52192);
      return "";
    }
    String str = paramContext.getMacAddress();
    paramContext = str;
    if (Build.VERSION.SDK_INT > 22) {
      if (str != null)
      {
        paramContext = str;
        if (!str.equals("02:00:00:00:00:00")) {}
      }
      else
      {
        paramContext = dtt();
      }
    }
    paramContext = bo.nullAsNil(paramContext).toLowerCase();
    ab.i("MicroMsg.NetStatusUtil", "getConnectedWifiClientMac()=".concat(String.valueOf(paramContext)));
    AppMethodBeat.o(52192);
    return paramContext;
  }
  
  public static int getBackgroundLimitType(Context paramContext)
  {
    AppMethodBeat.i(52195);
    int i;
    if (Build.VERSION.SDK_INT >= 14) {
      try
      {
        Object localObject = Class.forName("android.app.ActivityManagerNative");
        localObject = ((Class)localObject).getMethod("getDefault", new Class[0]).invoke(localObject, new Object[0]);
        i = ((Integer)localObject.getClass().getMethod("getProcessLimit", new Class[0]).invoke(localObject, new Object[0])).intValue();
        if (i == 0)
        {
          AppMethodBeat.o(52195);
          return 1;
        }
      }
      catch (Exception localException)
      {
        ab.printErrStackTrace("MicroMsg.NetStatusUtil", localException, "", new Object[0]);
      }
    }
    try
    {
      i = Settings.System.getInt(paramContext.getContentResolver(), "wifi_sleep_policy", 2);
      if (i != 2)
      {
        int j = getNetType(paramContext);
        if (j == 0) {}
      }
      else
      {
        AppMethodBeat.o(52195);
        return 0;
      }
      if ((i == 1) || (i == 0))
      {
        AppMethodBeat.o(52195);
        return 3;
      }
    }
    catch (Exception paramContext)
    {
      ab.printErrStackTrace("MicroMsg.NetStatusUtil", paramContext, "", new Object[0]);
      AppMethodBeat.o(52195);
    }
    return 0;
  }
  
  public static int getISPCode(Context paramContext)
  {
    AppMethodBeat.i(52179);
    paramContext = (TelephonyManager)paramContext.getSystemService("phone");
    if (paramContext == null)
    {
      AppMethodBeat.o(52179);
      return 0;
    }
    paramContext = paramContext.getSimOperator();
    if ((paramContext == null) || (paramContext.length() < 5))
    {
      AppMethodBeat.o(52179);
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
        ab.printErrStackTrace("MicroMsg.NetStatusUtil", paramContext, "", new Object[0]);
        AppMethodBeat.o(52179);
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
      AppMethodBeat.o(52179);
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
    AppMethodBeat.i(52180);
    try
    {
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      if (paramContext == null)
      {
        AppMethodBeat.o(52180);
        return "";
      }
      ab.d("MicroMsg.NetStatusUtil", "getISPName ISPName=%s", new Object[] { paramContext.getSimOperatorName() });
      if (paramContext.getSimOperatorName().length() <= 100)
      {
        paramContext = paramContext.getSimOperatorName();
        AppMethodBeat.o(52180);
        return paramContext;
      }
      paramContext = paramContext.getSimOperatorName().substring(0, 100);
      AppMethodBeat.o(52180);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(52180);
    }
    return "";
  }
  
  public static int getNetType(Context paramContext)
  {
    AppMethodBeat.i(52178);
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext == null)
    {
      AppMethodBeat.o(52178);
      return -1;
    }
    paramContext = paramContext.getActiveNetworkInfo();
    if (paramContext == null)
    {
      AppMethodBeat.o(52178);
      return -1;
    }
    if (paramContext.getType() == 1)
    {
      AppMethodBeat.o(52178);
      return 0;
    }
    ab.d("MicroMsg.NetStatusUtil", "activeNetInfo extra=%s, type=%d", new Object[] { paramContext.getExtraInfo(), Integer.valueOf(paramContext.getType()) });
    if (paramContext.getExtraInfo() != null)
    {
      if (paramContext.getExtraInfo().equalsIgnoreCase("uninet"))
      {
        AppMethodBeat.o(52178);
        return 1;
      }
      if (paramContext.getExtraInfo().equalsIgnoreCase("uniwap"))
      {
        AppMethodBeat.o(52178);
        return 2;
      }
      if (paramContext.getExtraInfo().equalsIgnoreCase("3gwap"))
      {
        AppMethodBeat.o(52178);
        return 3;
      }
      if (paramContext.getExtraInfo().equalsIgnoreCase("3gnet"))
      {
        AppMethodBeat.o(52178);
        return 4;
      }
      if (paramContext.getExtraInfo().equalsIgnoreCase("cmwap"))
      {
        AppMethodBeat.o(52178);
        return 5;
      }
      if (paramContext.getExtraInfo().equalsIgnoreCase("cmnet"))
      {
        AppMethodBeat.o(52178);
        return 6;
      }
      if (paramContext.getExtraInfo().equalsIgnoreCase("ctwap"))
      {
        AppMethodBeat.o(52178);
        return 7;
      }
      if (paramContext.getExtraInfo().equalsIgnoreCase("ctnet"))
      {
        AppMethodBeat.o(52178);
        return 8;
      }
      if (paramContext.getExtraInfo().equalsIgnoreCase("LTE"))
      {
        AppMethodBeat.o(52178);
        return 10;
      }
    }
    AppMethodBeat.o(52178);
    return 9;
  }
  
  public static int getNetTypeForStat(Context paramContext)
  {
    AppMethodBeat.i(52197);
    if (paramContext == null)
    {
      AppMethodBeat.o(52197);
      return 999;
    }
    try
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramContext == null)
      {
        AppMethodBeat.o(52197);
        return 999;
      }
      paramContext = paramContext.getActiveNetworkInfo();
      if (paramContext == null)
      {
        AppMethodBeat.o(52197);
        return 999;
      }
      int i = paramContext.getType();
      if (i == 1)
      {
        AppMethodBeat.o(52197);
        return 1;
      }
      i = paramContext.getSubtype();
      if (i == 0)
      {
        AppMethodBeat.o(52197);
        return 999;
      }
      AppMethodBeat.o(52197);
      return i * 1000;
    }
    catch (Exception paramContext)
    {
      ab.printErrStackTrace("MicroMsg.NetStatusUtil", paramContext, "", new Object[0]);
      AppMethodBeat.o(52197);
    }
    return 999;
  }
  
  public static String getNetTypeString(Context paramContext)
  {
    AppMethodBeat.i(52173);
    try
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramContext == null)
      {
        AppMethodBeat.o(52173);
        return "NON_NETWORK";
      }
      paramContext = paramContext.getActiveNetworkInfo();
      if (paramContext == null)
      {
        AppMethodBeat.o(52173);
        return "NON_NETWORK";
      }
      if (paramContext.getType() == 1)
      {
        AppMethodBeat.o(52173);
        return "WIFI";
      }
      ab.d("MicroMsg.NetStatusUtil", "activeNetInfo extra=%s, type=%d", new Object[] { paramContext.getExtraInfo(), Integer.valueOf(paramContext.getType()) });
      if (paramContext.getExtraInfo() != null)
      {
        paramContext = paramContext.getExtraInfo();
        AppMethodBeat.o(52173);
        return paramContext;
      }
      AppMethodBeat.o(52173);
      return "MOBILE";
    }
    catch (Exception paramContext)
    {
      ab.printErrStackTrace("MicroMsg.NetStatusUtil", paramContext, "", new Object[0]);
      AppMethodBeat.o(52173);
    }
    return "NON_NETWORK";
  }
  
  public static int getNetWorkType(Context paramContext)
  {
    AppMethodBeat.i(52177);
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramContext != null)
      {
        int i = paramContext.getType();
        AppMethodBeat.o(52177);
        return i;
      }
    }
    catch (Exception paramContext)
    {
      ab.printErrStackTrace("MicroMsg.NetStatusUtil", paramContext, "", new Object[0]);
      AppMethodBeat.o(52177);
    }
    return -1;
  }
  
  /* Error */
  public static int getStrength(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 494
    //   6: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: ifnonnull +16 -> 26
    //   13: ldc_w 494
    //   16: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: iconst_0
    //   20: istore_1
    //   21: ldc 2
    //   23: monitorexit
    //   24: iload_1
    //   25: ireturn
    //   26: aload_0
    //   27: invokestatic 496	com/tencent/mm/sdk/platformtools/at:getNetTypeForStat	(Landroid/content/Context;)I
    //   30: iconst_1
    //   31: if_icmpne +38 -> 69
    //   34: aload_0
    //   35: ldc_w 307
    //   38: invokevirtual 186	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   41: checkcast 309	android/net/wifi/WifiManager
    //   44: invokevirtual 313	android/net/wifi/WifiManager:getConnectionInfo	()Landroid/net/wifi/WifiInfo;
    //   47: invokevirtual 499	android/net/wifi/WifiInfo:getRssi	()I
    //   50: invokestatic 505	java/lang/Math:abs	(I)I
    //   53: istore_1
    //   54: ldc_w 494
    //   57: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   60: goto -39 -> 21
    //   63: astore_0
    //   64: ldc 2
    //   66: monitorexit
    //   67: aload_0
    //   68: athrow
    //   69: getstatic 19	com/tencent/mm/sdk/platformtools/at:yoZ	Landroid/telephony/PhoneStateListener;
    //   72: ifnonnull +11 -> 83
    //   75: ldc 119
    //   77: ldc_w 507
    //   80: invokestatic 175	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   83: getstatic 23	com/tencent/mm/sdk/platformtools/at:nowStrength	I
    //   86: invokestatic 505	java/lang/Math:abs	(I)I
    //   89: istore_1
    //   90: ldc_w 494
    //   93: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   96: goto -75 -> 21
    //   99: astore_0
    //   100: ldc 119
    //   102: aload_0
    //   103: ldc 46
    //   105: iconst_0
    //   106: anewarray 4	java/lang/Object
    //   109: invokestatic 276	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   112: ldc_w 494
    //   115: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   118: iconst_0
    //   119: istore_1
    //   120: goto -99 -> 21
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	123	0	paramContext	Context
    //   20	100	1	i	int
    // Exception table:
    //   from	to	target	type
    //   3	9	63	finally
    //   13	19	63	finally
    //   26	54	63	finally
    //   54	60	63	finally
    //   69	83	63	finally
    //   83	90	63	finally
    //   90	96	63	finally
    //   100	118	63	finally
    //   26	54	99	java/lang/Exception
    //   69	83	99	java/lang/Exception
    //   83	90	99	java/lang/Exception
  }
  
  public static WifiInfo getWifiInfo(Context paramContext)
  {
    AppMethodBeat.i(52187);
    try
    {
      Object localObject = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (localObject == null)
      {
        AppMethodBeat.o(52187);
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
        AppMethodBeat.o(52187);
        return null;
      }
      paramContext = (WifiManager)paramContext.getSystemService("wifi");
      if (paramContext == null)
      {
        AppMethodBeat.o(52187);
        return null;
      }
      paramContext = paramContext.getConnectionInfo();
      AppMethodBeat.o(52187);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      ab.printErrStackTrace("MicroMsg.NetStatusUtil", paramContext, "", new Object[0]);
      AppMethodBeat.o(52187);
    }
    return null;
  }
  
  public static boolean ha(Context paramContext)
  {
    AppMethodBeat.i(52198);
    int i = getNetType(paramContext);
    if ((i == 0) || (i == 10))
    {
      ab.d("MicroMsg.NetStatusUtil", "[cpan] is wifi or 4g network");
      AppMethodBeat.o(52198);
      return true;
    }
    ab.d("MicroMsg.NetStatusUtil", "[cpan] is mobile network");
    AppMethodBeat.o(52198);
    return false;
  }
  
  public static void hb(Context paramContext)
  {
    try
    {
      AppMethodBeat.i(52199);
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      nND = paramContext.getPhoneType();
      if (yoZ == null)
      {
        yoZ = new PhoneStateListener()
        {
          public final void onSignalStrengthsChanged(SignalStrength paramAnonymousSignalStrength)
          {
            AppMethodBeat.i(52170);
            super.onSignalStrengthsChanged(paramAnonymousSignalStrength);
            if (at.nND == 2) {
              at.ua(paramAnonymousSignalStrength.getCdmaDbm());
            }
            if (at.nND == 1) {
              at.ua(paramAnonymousSignalStrength.getGsmSignalStrength() * 2 - 113);
            }
            ab.i("MicroMsg.NetStatusUtil", "PhoneStateListener  type:%d  strength:%d", new Object[] { Integer.valueOf(at.nND), Integer.valueOf(at.nowStrength) });
            AppMethodBeat.o(52170);
          }
        };
        paramContext.listen(yoZ, 256);
      }
      AppMethodBeat.o(52199);
      return;
    }
    finally {}
  }
  
  /* Error */
  public static List<a> hc(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 530
    //   6: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: getstatic 19	com/tencent/mm/sdk/platformtools/at:yoZ	Landroid/telephony/PhoneStateListener;
    //   12: ifnonnull +24 -> 36
    //   15: ldc 119
    //   17: ldc_w 507
    //   20: invokestatic 175	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   23: aconst_null
    //   24: astore_0
    //   25: ldc_w 530
    //   28: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   31: ldc 2
    //   33: monitorexit
    //   34: aload_0
    //   35: areturn
    //   36: aload_0
    //   37: ldc_w 429
    //   40: invokevirtual 186	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   43: checkcast 431	android/telephony/TelephonyManager
    //   46: astore 7
    //   48: new 532	java/util/LinkedList
    //   51: dup
    //   52: invokespecial 533	java/util/LinkedList:<init>	()V
    //   55: astore 4
    //   57: ldc_w 535
    //   60: astore 5
    //   62: ldc 46
    //   64: astore 6
    //   66: aload 7
    //   68: invokevirtual 538	android/telephony/TelephonyManager:getNetworkOperator	()Ljava/lang/String;
    //   71: astore_3
    //   72: aload_3
    //   73: ifnull +184 -> 257
    //   76: aload_3
    //   77: ldc 46
    //   79: invokevirtual 376	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   82: ifne +175 -> 257
    //   85: aload_3
    //   86: iconst_0
    //   87: iconst_3
    //   88: invokevirtual 64	java/lang/String:substring	(II)Ljava/lang/String;
    //   91: astore_0
    //   92: aload_3
    //   93: iconst_3
    //   94: iconst_5
    //   95: invokevirtual 64	java/lang/String:substring	(II)Ljava/lang/String;
    //   98: astore_3
    //   99: aload 7
    //   101: invokevirtual 522	android/telephony/TelephonyManager:getPhoneType	()I
    //   104: istore_1
    //   105: iload_1
    //   106: iconst_2
    //   107: if_icmpne +529 -> 636
    //   110: aload 7
    //   112: invokevirtual 542	android/telephony/TelephonyManager:getCellLocation	()Landroid/telephony/CellLocation;
    //   115: checkcast 544	android/telephony/cdma/CdmaCellLocation
    //   118: astore 6
    //   120: aload 6
    //   122: ifnull +123 -> 245
    //   125: getstatic 23	com/tencent/mm/sdk/platformtools/at:nowStrength	I
    //   128: getstatic 21	com/tencent/mm/sdk/platformtools/at:ypa	I
    //   131: if_icmpne +204 -> 335
    //   134: ldc 46
    //   136: astore 5
    //   138: aload 6
    //   140: invokevirtual 547	android/telephony/cdma/CdmaCellLocation:getBaseStationId	()I
    //   143: iconst_m1
    //   144: if_icmpeq +101 -> 245
    //   147: aload 6
    //   149: invokevirtual 548	android/telephony/cdma/CdmaCellLocation:getNetworkId	()I
    //   152: iconst_m1
    //   153: if_icmpeq +92 -> 245
    //   156: aload 6
    //   158: invokevirtual 551	android/telephony/cdma/CdmaCellLocation:getSystemId	()I
    //   161: iconst_m1
    //   162: if_icmpeq +83 -> 245
    //   165: aload 4
    //   167: new 8	com/tencent/mm/sdk/platformtools/at$a
    //   170: dup
    //   171: aload_0
    //   172: aload_3
    //   173: ldc 46
    //   175: ldc 46
    //   177: aload 5
    //   179: ldc_w 553
    //   182: new 121	java/lang/StringBuilder
    //   185: dup
    //   186: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   189: aload 6
    //   191: invokevirtual 547	android/telephony/cdma/CdmaCellLocation:getBaseStationId	()I
    //   194: invokevirtual 231	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   197: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   200: new 121	java/lang/StringBuilder
    //   203: dup
    //   204: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   207: aload 6
    //   209: invokevirtual 548	android/telephony/cdma/CdmaCellLocation:getNetworkId	()I
    //   212: invokevirtual 231	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   215: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   218: new 121	java/lang/StringBuilder
    //   221: dup
    //   222: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   225: aload 6
    //   227: invokevirtual 551	android/telephony/cdma/CdmaCellLocation:getSystemId	()I
    //   230: invokevirtual 231	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   233: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   236: invokespecial 556	com/tencent/mm/sdk/platformtools/at$a:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   239: invokeinterface 559 2 0
    //   244: pop
    //   245: ldc_w 530
    //   248: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   251: aload 4
    //   253: astore_0
    //   254: goto -223 -> 31
    //   257: aload 7
    //   259: invokevirtual 434	android/telephony/TelephonyManager:getSimOperator	()Ljava/lang/String;
    //   262: astore 8
    //   264: aload 6
    //   266: astore_3
    //   267: aload 5
    //   269: astore_0
    //   270: aload 8
    //   272: ifnull +35 -> 307
    //   275: aload 6
    //   277: astore_3
    //   278: aload 5
    //   280: astore_0
    //   281: aload 8
    //   283: ldc 46
    //   285: invokevirtual 376	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   288: ifne +19 -> 307
    //   291: aload 8
    //   293: iconst_0
    //   294: iconst_3
    //   295: invokevirtual 64	java/lang/String:substring	(II)Ljava/lang/String;
    //   298: astore_0
    //   299: aload 8
    //   301: iconst_3
    //   302: iconst_5
    //   303: invokevirtual 64	java/lang/String:substring	(II)Ljava/lang/String;
    //   306: astore_3
    //   307: goto -208 -> 99
    //   310: astore_0
    //   311: ldc 119
    //   313: aload_0
    //   314: ldc 46
    //   316: iconst_0
    //   317: anewarray 4	java/lang/Object
    //   320: invokestatic 276	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   323: ldc_w 530
    //   326: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   329: aload 4
    //   331: astore_0
    //   332: goto -301 -> 31
    //   335: new 121	java/lang/StringBuilder
    //   338: dup
    //   339: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   342: getstatic 23	com/tencent/mm/sdk/platformtools/at:nowStrength	I
    //   345: invokevirtual 231	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   348: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   351: astore 5
    //   353: goto -215 -> 138
    //   356: astore 5
    //   358: aload 7
    //   360: invokevirtual 542	android/telephony/TelephonyManager:getCellLocation	()Landroid/telephony/CellLocation;
    //   363: checkcast 561	android/telephony/gsm/GsmCellLocation
    //   366: astore 5
    //   368: aload 5
    //   370: ifnull +68 -> 438
    //   373: aload 5
    //   375: invokevirtual 564	android/telephony/gsm/GsmCellLocation:getCid	()I
    //   378: istore_1
    //   379: aload 5
    //   381: invokevirtual 567	android/telephony/gsm/GsmCellLocation:getLac	()I
    //   384: istore_2
    //   385: iload_2
    //   386: ldc_w 568
    //   389: if_icmpge +49 -> 438
    //   392: iload_2
    //   393: iconst_m1
    //   394: if_icmpeq +44 -> 438
    //   397: iload_1
    //   398: iconst_m1
    //   399: if_icmpeq +39 -> 438
    //   402: aload 4
    //   404: new 8	com/tencent/mm/sdk/platformtools/at$a
    //   407: dup
    //   408: aload_0
    //   409: aload_3
    //   410: iload_2
    //   411: invokestatic 571	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   414: iload_1
    //   415: invokestatic 571	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   418: ldc 46
    //   420: ldc_w 573
    //   423: ldc 46
    //   425: ldc 46
    //   427: ldc 46
    //   429: invokespecial 556	com/tencent/mm/sdk/platformtools/at$a:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   432: invokeinterface 559 2 0
    //   437: pop
    //   438: aload 7
    //   440: invokevirtual 576	android/telephony/TelephonyManager:getNeighboringCellInfo	()Ljava/util/List;
    //   443: astore 5
    //   445: aload 5
    //   447: ifnull -202 -> 245
    //   450: aload 5
    //   452: invokeinterface 579 1 0
    //   457: ifle -212 -> 245
    //   460: aload 5
    //   462: invokeinterface 95 1 0
    //   467: astore 5
    //   469: aload 5
    //   471: invokeinterface 101 1 0
    //   476: ifeq -231 -> 245
    //   479: aload 5
    //   481: invokeinterface 105 1 0
    //   486: checkcast 581	android/telephony/NeighboringCellInfo
    //   489: astore 6
    //   491: aload 6
    //   493: invokevirtual 582	android/telephony/NeighboringCellInfo:getCid	()I
    //   496: iconst_m1
    //   497: if_icmpeq -28 -> 469
    //   500: aload 6
    //   502: invokevirtual 583	android/telephony/NeighboringCellInfo:getLac	()I
    //   505: ldc_w 568
    //   508: if_icmpgt -39 -> 469
    //   511: aload 6
    //   513: invokevirtual 583	android/telephony/NeighboringCellInfo:getLac	()I
    //   516: iconst_m1
    //   517: if_icmpeq -48 -> 469
    //   520: new 121	java/lang/StringBuilder
    //   523: dup
    //   524: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   527: aload 6
    //   529: invokevirtual 584	android/telephony/NeighboringCellInfo:getRssi	()I
    //   532: iconst_2
    //   533: imul
    //   534: bipush 113
    //   536: isub
    //   537: invokevirtual 231	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   540: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   543: astore 7
    //   545: aload 4
    //   547: new 8	com/tencent/mm/sdk/platformtools/at$a
    //   550: dup
    //   551: aload_0
    //   552: aload_3
    //   553: new 121	java/lang/StringBuilder
    //   556: dup
    //   557: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   560: aload 6
    //   562: invokevirtual 583	android/telephony/NeighboringCellInfo:getLac	()I
    //   565: invokevirtual 231	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   568: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   571: new 121	java/lang/StringBuilder
    //   574: dup
    //   575: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   578: aload 6
    //   580: invokevirtual 582	android/telephony/NeighboringCellInfo:getCid	()I
    //   583: invokevirtual 231	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   586: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   589: aload 7
    //   591: ldc_w 573
    //   594: ldc 46
    //   596: ldc 46
    //   598: ldc 46
    //   600: invokespecial 556	com/tencent/mm/sdk/platformtools/at$a:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   603: invokeinterface 559 2 0
    //   608: pop
    //   609: goto -140 -> 469
    //   612: astore_0
    //   613: ldc 2
    //   615: monitorexit
    //   616: aload_0
    //   617: athrow
    //   618: astore 5
    //   620: ldc 119
    //   622: aload 5
    //   624: ldc 46
    //   626: iconst_0
    //   627: anewarray 4	java/lang/Object
    //   630: invokestatic 276	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   633: goto -195 -> 438
    //   636: aload 7
    //   638: invokevirtual 542	android/telephony/TelephonyManager:getCellLocation	()Landroid/telephony/CellLocation;
    //   641: checkcast 561	android/telephony/gsm/GsmCellLocation
    //   644: astore 5
    //   646: aload 5
    //   648: ifnull +81 -> 729
    //   651: aload 5
    //   653: invokevirtual 564	android/telephony/gsm/GsmCellLocation:getCid	()I
    //   656: istore_1
    //   657: aload 5
    //   659: invokevirtual 567	android/telephony/gsm/GsmCellLocation:getLac	()I
    //   662: istore_2
    //   663: iload_2
    //   664: ldc_w 568
    //   667: if_icmpge +62 -> 729
    //   670: iload_2
    //   671: iconst_m1
    //   672: if_icmpeq +57 -> 729
    //   675: iload_1
    //   676: iconst_m1
    //   677: if_icmpeq +52 -> 729
    //   680: getstatic 23	com/tencent/mm/sdk/platformtools/at:nowStrength	I
    //   683: getstatic 21	com/tencent/mm/sdk/platformtools/at:ypa	I
    //   686: if_icmpne +260 -> 946
    //   689: ldc 46
    //   691: astore 5
    //   693: aload 4
    //   695: new 8	com/tencent/mm/sdk/platformtools/at$a
    //   698: dup
    //   699: aload_0
    //   700: aload_3
    //   701: iload_2
    //   702: invokestatic 571	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   705: iload_1
    //   706: invokestatic 571	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   709: aload 5
    //   711: ldc_w 573
    //   714: ldc 46
    //   716: ldc 46
    //   718: ldc 46
    //   720: invokespecial 556	com/tencent/mm/sdk/platformtools/at$a:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   723: invokeinterface 559 2 0
    //   728: pop
    //   729: aload 7
    //   731: invokevirtual 576	android/telephony/TelephonyManager:getNeighboringCellInfo	()Ljava/util/List;
    //   734: astore 5
    //   736: aload 5
    //   738: ifnull -493 -> 245
    //   741: aload 5
    //   743: invokeinterface 579 1 0
    //   748: ifle -503 -> 245
    //   751: aload 5
    //   753: invokeinterface 95 1 0
    //   758: astore 5
    //   760: aload 5
    //   762: invokeinterface 101 1 0
    //   767: ifeq -522 -> 245
    //   770: aload 5
    //   772: invokeinterface 105 1 0
    //   777: checkcast 581	android/telephony/NeighboringCellInfo
    //   780: astore 6
    //   782: aload 6
    //   784: invokevirtual 582	android/telephony/NeighboringCellInfo:getCid	()I
    //   787: iconst_m1
    //   788: if_icmpeq -28 -> 760
    //   791: aload 6
    //   793: invokevirtual 583	android/telephony/NeighboringCellInfo:getLac	()I
    //   796: ldc_w 568
    //   799: if_icmpgt -39 -> 760
    //   802: new 121	java/lang/StringBuilder
    //   805: dup
    //   806: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   809: aload 6
    //   811: invokevirtual 584	android/telephony/NeighboringCellInfo:getRssi	()I
    //   814: iconst_2
    //   815: imul
    //   816: bipush 113
    //   818: isub
    //   819: invokevirtual 231	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   822: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   825: astore 7
    //   827: ldc_w 586
    //   830: new 121	java/lang/StringBuilder
    //   833: dup
    //   834: ldc_w 588
    //   837: invokespecial 127	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   840: aload 6
    //   842: invokevirtual 583	android/telephony/NeighboringCellInfo:getLac	()I
    //   845: invokevirtual 231	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   848: ldc_w 590
    //   851: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   854: aload 6
    //   856: invokevirtual 582	android/telephony/NeighboringCellInfo:getCid	()I
    //   859: invokevirtual 231	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   862: ldc_w 592
    //   865: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   868: aload 7
    //   870: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   873: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   876: invokestatic 595	com/tencent/mm/sdk/platformtools/ab:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   879: aload 4
    //   881: new 8	com/tencent/mm/sdk/platformtools/at$a
    //   884: dup
    //   885: aload_0
    //   886: aload_3
    //   887: new 121	java/lang/StringBuilder
    //   890: dup
    //   891: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   894: aload 6
    //   896: invokevirtual 583	android/telephony/NeighboringCellInfo:getLac	()I
    //   899: invokevirtual 231	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   902: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   905: new 121	java/lang/StringBuilder
    //   908: dup
    //   909: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   912: aload 6
    //   914: invokevirtual 582	android/telephony/NeighboringCellInfo:getCid	()I
    //   917: invokevirtual 231	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   920: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   923: aload 7
    //   925: ldc_w 573
    //   928: ldc 46
    //   930: ldc 46
    //   932: ldc 46
    //   934: invokespecial 556	com/tencent/mm/sdk/platformtools/at$a:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   937: invokeinterface 559 2 0
    //   942: pop
    //   943: goto -183 -> 760
    //   946: new 121	java/lang/StringBuilder
    //   949: dup
    //   950: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   953: getstatic 23	com/tencent/mm/sdk/platformtools/at:nowStrength	I
    //   956: invokevirtual 231	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   959: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   962: astore 5
    //   964: goto -271 -> 693
    //   967: astore 5
    //   969: ldc 119
    //   971: aload 5
    //   973: ldc 46
    //   975: iconst_0
    //   976: anewarray 4	java/lang/Object
    //   979: invokestatic 276	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   982: goto -253 -> 729
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	985	0	paramContext	Context
    //   104	602	1	i	int
    //   384	318	2	j	int
    //   71	816	3	localObject1	Object
    //   55	825	4	localLinkedList	java.util.LinkedList
    //   60	292	5	str1	String
    //   356	1	5	localException1	Exception
    //   366	114	5	localObject2	Object
    //   618	5	5	localException2	Exception
    //   644	319	5	localObject3	Object
    //   967	5	5	localException3	Exception
    //   64	849	6	localObject4	Object
    //   46	878	7	localObject5	Object
    //   262	38	8	str2	String
    // Exception table:
    //   from	to	target	type
    //   66	72	310	java/lang/Exception
    //   76	99	310	java/lang/Exception
    //   257	264	310	java/lang/Exception
    //   281	307	310	java/lang/Exception
    //   110	120	356	java/lang/Exception
    //   125	134	356	java/lang/Exception
    //   138	245	356	java/lang/Exception
    //   335	353	356	java/lang/Exception
    //   3	23	612	finally
    //   25	31	612	finally
    //   36	57	612	finally
    //   66	72	612	finally
    //   76	99	612	finally
    //   99	105	612	finally
    //   110	120	612	finally
    //   125	134	612	finally
    //   138	245	612	finally
    //   245	251	612	finally
    //   257	264	612	finally
    //   281	307	612	finally
    //   311	329	612	finally
    //   335	353	612	finally
    //   358	368	612	finally
    //   373	385	612	finally
    //   402	438	612	finally
    //   438	445	612	finally
    //   450	469	612	finally
    //   469	609	612	finally
    //   620	633	612	finally
    //   636	646	612	finally
    //   651	663	612	finally
    //   680	689	612	finally
    //   693	729	612	finally
    //   729	736	612	finally
    //   741	760	612	finally
    //   760	943	612	finally
    //   946	964	612	finally
    //   969	982	612	finally
    //   358	368	618	java/lang/Exception
    //   373	385	618	java/lang/Exception
    //   402	438	618	java/lang/Exception
    //   636	646	967	java/lang/Exception
    //   651	663	967	java/lang/Exception
    //   680	689	967	java/lang/Exception
    //   693	729	967	java/lang/Exception
    //   946	964	967	java/lang/Exception
  }
  
  public static boolean is2G(Context paramContext)
  {
    AppMethodBeat.i(52182);
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramContext == null)
      {
        AppMethodBeat.o(52182);
        return false;
      }
      int i = paramContext.getType();
      if (i == 1)
      {
        AppMethodBeat.o(52182);
        return false;
      }
      ab.d("MicroMsg.NetStatusUtil", "is2G subtype %d", new Object[] { Integer.valueOf(paramContext.getSubtype()) });
      if ((paramContext.getSubtype() != 2) && (paramContext.getSubtype() != 1))
      {
        i = paramContext.getSubtype();
        if (i != 4) {}
      }
      else
      {
        AppMethodBeat.o(52182);
        return true;
      }
    }
    catch (Exception paramContext)
    {
      ab.printErrStackTrace("MicroMsg.NetStatusUtil", paramContext, "", new Object[0]);
      AppMethodBeat.o(52182);
    }
    return false;
  }
  
  public static boolean is3G(Context paramContext)
  {
    AppMethodBeat.i(52185);
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramContext == null)
      {
        AppMethodBeat.o(52185);
        return false;
      }
      int i = paramContext.getType();
      if (i == 1)
      {
        AppMethodBeat.o(52185);
        return false;
      }
      ab.d("MicroMsg.NetStatusUtil", "is3G subtype %d", new Object[] { Integer.valueOf(paramContext.getSubtype()) });
      if (paramContext.getSubtype() >= 5)
      {
        i = paramContext.getSubtype();
        if (i < 13)
        {
          AppMethodBeat.o(52185);
          return true;
        }
      }
    }
    catch (Exception paramContext)
    {
      ab.printErrStackTrace("MicroMsg.NetStatusUtil", paramContext, "", new Object[0]);
      AppMethodBeat.o(52185);
    }
    return false;
  }
  
  public static boolean is4G(Context paramContext)
  {
    AppMethodBeat.i(52183);
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramContext == null)
      {
        AppMethodBeat.o(52183);
        return false;
      }
      int i = paramContext.getType();
      if (i == 1)
      {
        AppMethodBeat.o(52183);
        return false;
      }
      ab.d("MicroMsg.NetStatusUtil", "is4G subtype %d", new Object[] { Integer.valueOf(paramContext.getSubtype()) });
      i = paramContext.getSubtype();
      if (i >= 13)
      {
        AppMethodBeat.o(52183);
        return true;
      }
    }
    catch (Exception paramContext)
    {
      ab.printErrStackTrace("MicroMsg.NetStatusUtil", paramContext, "", new Object[0]);
      AppMethodBeat.o(52183);
    }
    return false;
  }
  
  public static boolean isConnected(Context paramContext)
  {
    AppMethodBeat.i(52172);
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext == null)
    {
      AppMethodBeat.o(52172);
      return false;
    }
    paramContext = paramContext.getActiveNetworkInfo();
    try
    {
      bool = paramContext.isConnected();
      AppMethodBeat.o(52172);
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
  
  public static boolean isLimited(int paramInt)
  {
    return (paramInt == 2) || (paramInt == 1) || (paramInt == 3);
  }
  
  public static boolean isMobile(Context paramContext)
  {
    AppMethodBeat.i(52181);
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramContext == null)
      {
        AppMethodBeat.o(52181);
        return false;
      }
      int i = paramContext.getType();
      if (i == 1)
      {
        AppMethodBeat.o(52181);
        return false;
      }
      AppMethodBeat.o(52181);
      return true;
    }
    catch (Exception paramContext)
    {
      ab.printErrStackTrace("MicroMsg.NetStatusUtil", paramContext, "", new Object[0]);
      AppMethodBeat.o(52181);
    }
    return false;
  }
  
  public static boolean isNetworkConnected(Context paramContext)
  {
    AppMethodBeat.i(52196);
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext == null)
    {
      AppMethodBeat.o(52196);
      return false;
    }
    paramContext = paramContext.getActiveNetworkInfo();
    if (paramContext == null)
    {
      AppMethodBeat.o(52196);
      return false;
    }
    if (paramContext.getState() != NetworkInfo.State.CONNECTED)
    {
      AppMethodBeat.o(52196);
      return false;
    }
    AppMethodBeat.o(52196);
    return true;
  }
  
  public static boolean isWap(int paramInt)
  {
    return (paramInt == 2) || (paramInt == 5) || (paramInt == 7) || (paramInt == 3);
  }
  
  public static boolean isWap(Context paramContext)
  {
    AppMethodBeat.i(52184);
    boolean bool = isWap(getNetType(paramContext));
    AppMethodBeat.o(52184);
    return bool;
  }
  
  public static boolean isWifi(int paramInt)
  {
    return paramInt == 0;
  }
  
  public static boolean isWifi(Context paramContext)
  {
    AppMethodBeat.i(52186);
    if (getNetType(paramContext) == 0)
    {
      AppMethodBeat.o(52186);
      return true;
    }
    AppMethodBeat.o(52186);
    return false;
  }
  
  private static Intent searchIntentByClass(Context paramContext, String paramString)
  {
    AppMethodBeat.i(52188);
    try
    {
      PackageManager localPackageManager = paramContext.getPackageManager();
      List localList = localPackageManager.getInstalledPackages(0);
      if ((localList != null) && (localList.size() > 0))
      {
        ab.e("MicroMsg.NetStatusUtil", "package  size" + localList.size());
        int i = 0;
        for (;;)
        {
          int j = localList.size();
          if (i >= j) {
            break label348;
          }
          try
          {
            ab.e("MicroMsg.NetStatusUtil", "package " + ((PackageInfo)localList.get(i)).packageName);
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
                  ab.e("MicroMsg.NetStatusUtil", "activityName count ".concat(String.valueOf(j)));
                  int k = 0;
                  for (;;)
                  {
                    if (k >= j) {
                      break label310;
                    }
                    localObject1 = ((ResolveInfo)((List)localObject2).get(k)).activityInfo;
                    if (((ActivityInfo)localObject1).name.contains(paramString))
                    {
                      localObject2 = new Intent("/");
                      ((Intent)localObject2).setComponent(new ComponentName(((ActivityInfo)localObject1).packageName, ((ActivityInfo)localObject1).name));
                      ((Intent)localObject2).setAction("android.intent.action.VIEW");
                      paramContext.startActivity((Intent)localObject2);
                      AppMethodBeat.o(52188);
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
                  ab.printErrStackTrace("MicroMsg.NetStatusUtil", localException1, "", new Object[0]);
                }
              }
            }
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              label310:
              ab.printErrStackTrace("MicroMsg.NetStatusUtil", localException2, "", new Object[0]);
            }
          }
        }
      }
      label348:
      return null;
    }
    catch (Exception paramContext)
    {
      ab.printErrStackTrace("MicroMsg.NetStatusUtil", paramContext, "", new Object[0]);
      AppMethodBeat.o(52188);
    }
  }
  
  public static void startSettingItent(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(52189);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(52189);
      return;
      AppMethodBeat.o(52189);
      return;
      try
      {
        Intent localIntent1 = new Intent("/");
        localIntent1.setComponent(new ComponentName("com.android.providers.subscribedfeeds", "com.android.settings.ManageAccountsSettings"));
        localIntent1.setAction("android.intent.action.VIEW");
        paramContext.startActivity(localIntent1);
        AppMethodBeat.o(52189);
        return;
      }
      catch (Exception localException1)
      {
        try
        {
          Intent localIntent2 = new Intent("/");
          localIntent2.setComponent(new ComponentName("com.htc.settings.accountsync", "com.htc.settings.accountsync.ManageAccountsSettings"));
          localIntent2.setAction("android.intent.action.VIEW");
          paramContext.startActivity(localIntent2);
          AppMethodBeat.o(52189);
          return;
        }
        catch (Exception localException2)
        {
          searchIntentByClass(paramContext, "ManageAccountsSettings");
          AppMethodBeat.o(52189);
          return;
        }
      }
      try
      {
        Intent localIntent3 = new Intent("/");
        localIntent3.setComponent(new ComponentName("com.android.settings", "com.android.settings.DevelopmentSettings"));
        localIntent3.setAction("android.intent.action.VIEW");
        paramContext.startActivity(localIntent3);
        AppMethodBeat.o(52189);
        return;
      }
      catch (Exception localException3)
      {
        searchIntentByClass(paramContext, "DevelopmentSettings");
        AppMethodBeat.o(52189);
        return;
      }
      try
      {
        Intent localIntent4 = new Intent();
        localIntent4.setAction("android.settings.WIFI_IP_SETTINGS");
        paramContext.startActivity(localIntent4);
        AppMethodBeat.o(52189);
        return;
      }
      catch (Exception localException4)
      {
        searchIntentByClass(paramContext, "AdvancedSettings");
      }
    }
  }
  
  public static final class a
  {
    public String oEm;
    public String oEn;
    public String oEo;
    public String systemId;
    public String type;
    public String uij;
    public String uil;
    public String uim;
    public String uio;
    
    public a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
    {
      this.oEm = paramString1;
      this.oEn = paramString2;
      this.uij = paramString3;
      this.type = paramString6;
      this.oEo = paramString4;
      this.uil = paramString7;
      this.uim = paramString8;
      this.systemId = paramString9;
      this.uio = paramString5;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.at
 * JD-Core Version:    0.7.0.1
 */