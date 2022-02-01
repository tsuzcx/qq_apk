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

public final class az
{
  private static PhoneStateListener IyY = null;
  private static int IyZ = 10000;
  private static int nowStrength = 10000;
  private static int uXJ = -1;
  
  private static String akG(String paramString)
  {
    AppMethodBeat.i(157753);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(157753);
      return "";
    }
    if (paramString.equals("<unknown ssid>"))
    {
      AppMethodBeat.o(157753);
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
    AppMethodBeat.o(157753);
    return str;
  }
  
  private static String fpg()
  {
    AppMethodBeat.i(157752);
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
              ae.d("MicroMsg.NetStatusUtil", "et mobile mac from net time cost :" + (System.currentTimeMillis() - l));
              AppMethodBeat.o(157752);
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
            ae.d("MicroMsg.NetStatusUtil", "et mobile mac from net time cost :" + (System.currentTimeMillis() - l));
            localObject1 = ((StringBuilder)localObject2).toString();
            AppMethodBeat.o(157752);
            return localObject1;
          }
        }
      }
    }
    catch (Exception localException)
    {
      ae.e("MicroMsg.NetStatusUtil", "get mobile mac from net fail!".concat(String.valueOf(localException)));
      ae.d("MicroMsg.NetStatusUtil", "et mobile mac from net time cost :" + (System.currentTimeMillis() - l));
      AppMethodBeat.o(157752);
    }
    return "02:00:00:00:00:00";
  }
  
  public static int getBackgroundLimitType(Context paramContext)
  {
    AppMethodBeat.i(157754);
    int i;
    if (Build.VERSION.SDK_INT >= 14) {
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
        ae.printErrStackTrace("MicroMsg.NetStatusUtil", localException, "", new Object[0]);
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
      ae.printErrStackTrace("MicroMsg.NetStatusUtil", paramContext, "", new Object[0]);
      AppMethodBeat.o(157754);
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
          break label154;
        }
        i = 6;
      }
      catch (Exception paramContext)
      {
        ae.printErrStackTrace("MicroMsg.NetStatusUtil", paramContext, "", new Object[0]);
        AppMethodBeat.o(157738);
        return 0;
      }
      if (j < i) {
        if (!Character.isDigit(paramContext.charAt(j)))
        {
          if (localStringBuilder.length() <= 0) {
            break label159;
          }
        }
        else
        {
          localStringBuilder.append(paramContext.charAt(j));
          break label159;
        }
      }
      int i = Integer.valueOf(localStringBuilder.toString()).intValue();
      AppMethodBeat.o(157738);
      return i;
      label154:
      int j = 0;
      continue;
      label159:
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
      ae.d("MicroMsg.NetStatusUtil", "getISPName ISPName=%s", new Object[] { paramContext.getSimOperatorName() });
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
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
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
    if (paramContext.getType() == 1)
    {
      AppMethodBeat.o(157737);
      return 0;
    }
    ae.d("MicroMsg.NetStatusUtil", "activeNetInfo extra=%s, type=%d", new Object[] { paramContext.getExtraInfo(), Integer.valueOf(paramContext.getType()) });
    if (paramContext.getExtraInfo() != null)
    {
      if (paramContext.getExtraInfo().equalsIgnoreCase("uninet"))
      {
        AppMethodBeat.o(157737);
        return 1;
      }
      if (paramContext.getExtraInfo().equalsIgnoreCase("uniwap"))
      {
        AppMethodBeat.o(157737);
        return 2;
      }
      if (paramContext.getExtraInfo().equalsIgnoreCase("3gwap"))
      {
        AppMethodBeat.o(157737);
        return 3;
      }
      if (paramContext.getExtraInfo().equalsIgnoreCase("3gnet"))
      {
        AppMethodBeat.o(157737);
        return 4;
      }
      if (paramContext.getExtraInfo().equalsIgnoreCase("cmwap"))
      {
        AppMethodBeat.o(157737);
        return 5;
      }
      if (paramContext.getExtraInfo().equalsIgnoreCase("cmnet"))
      {
        AppMethodBeat.o(157737);
        return 6;
      }
      if (paramContext.getExtraInfo().equalsIgnoreCase("ctwap"))
      {
        AppMethodBeat.o(157737);
        return 7;
      }
      if (paramContext.getExtraInfo().equalsIgnoreCase("ctnet"))
      {
        AppMethodBeat.o(157737);
        return 8;
      }
      if (paramContext.getExtraInfo().equalsIgnoreCase("LTE"))
      {
        AppMethodBeat.o(157737);
        return 10;
      }
    }
    AppMethodBeat.o(157737);
    return 9;
  }
  
  public static int getNetTypeForStat(Context paramContext)
  {
    AppMethodBeat.i(157756);
    if (paramContext == null)
    {
      AppMethodBeat.o(157756);
      return 999;
    }
    try
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
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
      ae.printErrStackTrace("MicroMsg.NetStatusUtil", paramContext, "", new Object[0]);
      AppMethodBeat.o(157756);
    }
    return 999;
  }
  
  public static String getNetTypeString(Context paramContext)
  {
    AppMethodBeat.i(157732);
    try
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
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
      ae.d("MicroMsg.NetStatusUtil", "activeNetInfo extra=%s, type=%d", new Object[] { paramContext.getExtraInfo(), Integer.valueOf(paramContext.getType()) });
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
      ae.printErrStackTrace("MicroMsg.NetStatusUtil", paramContext, "", new Object[0]);
      AppMethodBeat.o(157732);
    }
    return "NON_NETWORK";
  }
  
  public static int getNetWorkType(Context paramContext)
  {
    AppMethodBeat.i(157736);
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramContext != null)
      {
        int i = paramContext.getType();
        AppMethodBeat.o(157736);
        return i;
      }
    }
    catch (Exception paramContext)
    {
      ae.printErrStackTrace("MicroMsg.NetStatusUtil", paramContext, "", new Object[0]);
      AppMethodBeat.o(157736);
    }
    return -1;
  }
  
  /* Error */
  public static int getStrength(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 340
    //   6: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: ifnonnull +16 -> 26
    //   13: ldc_w 340
    //   16: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: iconst_0
    //   20: istore_1
    //   21: ldc 2
    //   23: monitorexit
    //   24: iload_1
    //   25: ireturn
    //   26: aload_0
    //   27: invokestatic 342	com/tencent/mm/sdk/platformtools/az:getNetTypeForStat	(Landroid/content/Context;)I
    //   30: iconst_1
    //   31: if_icmpne +38 -> 69
    //   34: aload_0
    //   35: ldc_w 344
    //   38: invokevirtual 251	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   41: checkcast 346	android/net/wifi/WifiManager
    //   44: invokevirtual 350	android/net/wifi/WifiManager:getConnectionInfo	()Landroid/net/wifi/WifiInfo;
    //   47: invokevirtual 355	android/net/wifi/WifiInfo:getRssi	()I
    //   50: invokestatic 360	java/lang/Math:abs	(I)I
    //   53: istore_1
    //   54: ldc_w 340
    //   57: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   60: goto -39 -> 21
    //   63: astore_0
    //   64: ldc 2
    //   66: monitorexit
    //   67: aload_0
    //   68: athrow
    //   69: getstatic 19	com/tencent/mm/sdk/platformtools/az:IyY	Landroid/telephony/PhoneStateListener;
    //   72: ifnonnull +11 -> 83
    //   75: ldc 127
    //   77: ldc_w 362
    //   80: invokestatic 183	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   83: getstatic 23	com/tencent/mm/sdk/platformtools/az:nowStrength	I
    //   86: invokestatic 360	java/lang/Math:abs	(I)I
    //   89: istore_1
    //   90: ldc_w 340
    //   93: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   96: goto -75 -> 21
    //   99: astore_0
    //   100: ldc 127
    //   102: aload_0
    //   103: ldc 51
    //   105: iconst_0
    //   106: anewarray 4	java/lang/Object
    //   109: invokestatic 226	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   112: ldc_w 340
    //   115: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    AppMethodBeat.i(157746);
    try
    {
      Object localObject = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (localObject == null)
      {
        AppMethodBeat.o(157746);
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
        AppMethodBeat.o(157746);
        return null;
      }
      paramContext = (WifiManager)paramContext.getSystemService("wifi");
      if (paramContext == null)
      {
        AppMethodBeat.o(157746);
        return null;
      }
      paramContext = paramContext.getConnectionInfo();
      AppMethodBeat.o(157746);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      ae.printErrStackTrace("MicroMsg.NetStatusUtil", paramContext, "", new Object[0]);
      AppMethodBeat.o(157746);
    }
    return null;
  }
  
  public static String iV(Context paramContext)
  {
    AppMethodBeat.i(157730);
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
      ae.i("MicroMsg.NetStatusUtil", "netstatus " + localStringBuilder.toString());
      paramContext = localStringBuilder.toString();
      AppMethodBeat.o(157730);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        ae.i("MicroMsg.NetStatusUtil", paramContext.getMessage());
        ae.printErrStackTrace("MicroMsg.NetStatusUtil", paramContext, "", new Object[0]);
      }
    }
  }
  
  public static String iW(Context paramContext)
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
  
  public static int iX(Context paramContext)
  {
    AppMethodBeat.i(157734);
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
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
  
  public static int iY(Context paramContext)
  {
    AppMethodBeat.i(157735);
    try
    {
      int i = getNetType(paramContext);
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
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
  
  public static boolean iZ(Context paramContext)
  {
    AppMethodBeat.i(200296);
    try
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramContext != null)
      {
        Method localMethod = paramContext.getClass().getMethod("getMobileDataEnabled", new Class[0]);
        localMethod.setAccessible(true);
        boolean bool = ((Boolean)localMethod.invoke(paramContext, new Object[0])).booleanValue();
        AppMethodBeat.o(200296);
        return bool;
      }
    }
    catch (Exception paramContext)
    {
      ae.printErrStackTrace("MicroMsg.NetStatusUtil", paramContext, "", new Object[0]);
      AppMethodBeat.o(200296);
    }
    return false;
  }
  
  public static boolean is2G(Context paramContext)
  {
    AppMethodBeat.i(157741);
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
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
      ae.d("MicroMsg.NetStatusUtil", "is2G subtype %d", new Object[] { Integer.valueOf(paramContext.getSubtype()) });
      if ((paramContext.getSubtype() != 2) && (paramContext.getSubtype() != 1))
      {
        i = paramContext.getSubtype();
        if (i != 4) {}
      }
      else
      {
        AppMethodBeat.o(157741);
        return true;
      }
    }
    catch (Exception paramContext)
    {
      ae.printErrStackTrace("MicroMsg.NetStatusUtil", paramContext, "", new Object[0]);
      AppMethodBeat.o(157741);
    }
    return false;
  }
  
  public static boolean is3G(Context paramContext)
  {
    AppMethodBeat.i(157744);
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
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
      ae.d("MicroMsg.NetStatusUtil", "is3G subtype %d", new Object[] { Integer.valueOf(paramContext.getSubtype()) });
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
      ae.printErrStackTrace("MicroMsg.NetStatusUtil", paramContext, "", new Object[0]);
      AppMethodBeat.o(157744);
    }
    return false;
  }
  
  public static boolean is4G(Context paramContext)
  {
    AppMethodBeat.i(157742);
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
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
      ae.d("MicroMsg.NetStatusUtil", "is4G subtype %d", new Object[] { Integer.valueOf(paramContext.getSubtype()) });
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
      ae.printErrStackTrace("MicroMsg.NetStatusUtil", paramContext, "", new Object[0]);
      AppMethodBeat.o(157742);
    }
    return false;
  }
  
  public static boolean is5G(Context paramContext)
  {
    AppMethodBeat.i(200297);
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramContext == null)
      {
        AppMethodBeat.o(200297);
        return false;
      }
      int i = paramContext.getType();
      if (i == 1)
      {
        AppMethodBeat.o(200297);
        return false;
      }
      ae.d("MicroMsg.NetStatusUtil", "is5G subtype %d", new Object[] { Integer.valueOf(paramContext.getSubtype()) });
      i = paramContext.getSubtype();
      if (i >= 20)
      {
        AppMethodBeat.o(200297);
        return true;
      }
    }
    catch (Exception paramContext)
    {
      ae.printErrStackTrace("MicroMsg.NetStatusUtil", paramContext, "", new Object[0]);
      AppMethodBeat.o(200297);
    }
    return false;
  }
  
  public static boolean isConnected(Context paramContext)
  {
    AppMethodBeat.i(157731);
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
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
  
  public static boolean isLimited(int paramInt)
  {
    return (paramInt == 2) || (paramInt == 1) || (paramInt == 3);
  }
  
  public static boolean isMobile(Context paramContext)
  {
    AppMethodBeat.i(157740);
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramContext == null)
      {
        AppMethodBeat.o(157740);
        return false;
      }
      int i = paramContext.getType();
      if (i == 1)
      {
        AppMethodBeat.o(157740);
        return false;
      }
      AppMethodBeat.o(157740);
      return true;
    }
    catch (Exception paramContext)
    {
      ae.printErrStackTrace("MicroMsg.NetStatusUtil", paramContext, "", new Object[0]);
      AppMethodBeat.o(157740);
    }
    return false;
  }
  
  public static boolean isNetworkConnected(Context paramContext)
  {
    AppMethodBeat.i(157755);
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext == null)
    {
      AppMethodBeat.o(157755);
      return false;
    }
    paramContext = paramContext.getActiveNetworkInfo();
    if (paramContext == null)
    {
      AppMethodBeat.o(157755);
      return false;
    }
    if (paramContext.getState() != NetworkInfo.State.CONNECTED)
    {
      AppMethodBeat.o(157755);
      return false;
    }
    AppMethodBeat.o(157755);
    return true;
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
  
  public static boolean isWifi(int paramInt)
  {
    return paramInt == 0;
  }
  
  public static boolean isWifi(Context paramContext)
  {
    AppMethodBeat.i(157745);
    if (getNetType(paramContext) == 0)
    {
      AppMethodBeat.o(157745);
      return true;
    }
    AppMethodBeat.o(157745);
    return false;
  }
  
  public static String ja(Context paramContext)
  {
    AppMethodBeat.i(157749);
    if (getNetType(paramContext) != 0)
    {
      ae.i("MicroMsg.NetStatusUtil", "wifi not connected. getConnectedWifiSsid() is empty");
      AppMethodBeat.o(157749);
      return "";
    }
    Object localObject = (WifiManager)paramContext.getSystemService("wifi");
    if (localObject == null)
    {
      AppMethodBeat.o(157749);
      return "";
    }
    WifiInfo localWifiInfo = ((WifiManager)localObject).getConnectionInfo();
    if (localWifiInfo == null)
    {
      AppMethodBeat.o(157749);
      return "";
    }
    paramContext = localWifiInfo.getSSID();
    if (Build.VERSION.SDK_INT >= 27)
    {
      localObject = ((WifiManager)localObject).getConfiguredNetworks();
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          WifiConfiguration localWifiConfiguration = (WifiConfiguration)((Iterator)localObject).next();
          if (localWifiConfiguration.networkId == localWifiInfo.getNetworkId())
          {
            ae.i("MicroMsg.NetStatusUtil", "get wifi config ssid %s", new Object[] { localWifiConfiguration.SSID });
            paramContext = localWifiConfiguration.SSID;
          }
        }
      }
    }
    for (;;)
    {
      paramContext = bu.nullAsNil(paramContext);
      ae.i("MicroMsg.NetStatusUtil", "getConnectedWifiSsid()=" + akG(paramContext));
      paramContext = akG(paramContext);
      AppMethodBeat.o(157749);
      return paramContext;
    }
  }
  
  public static String jb(Context paramContext)
  {
    AppMethodBeat.i(157750);
    if (getNetType(paramContext) != 0)
    {
      ae.i("MicroMsg.NetStatusUtil", "wifi not connected. getConnectedWifiBssid() is empty");
      AppMethodBeat.o(157750);
      return "";
    }
    paramContext = (WifiManager)paramContext.getSystemService("wifi");
    if (paramContext == null)
    {
      AppMethodBeat.o(157750);
      return "";
    }
    paramContext = paramContext.getConnectionInfo();
    if (paramContext == null)
    {
      AppMethodBeat.o(157750);
      return "";
    }
    paramContext = bu.nullAsNil(paramContext.getBSSID()).toLowerCase();
    ae.i("MicroMsg.NetStatusUtil", "getConnectedWifiBssid()=".concat(String.valueOf(paramContext)));
    AppMethodBeat.o(157750);
    return paramContext;
  }
  
  public static String jc(Context paramContext)
  {
    AppMethodBeat.i(157751);
    paramContext = (WifiManager)paramContext.getSystemService("wifi");
    if (paramContext == null)
    {
      ae.e("MicroMsg.NetStatusUtil", "error wifiManager is null!!");
      AppMethodBeat.o(157751);
      return "";
    }
    paramContext = paramContext.getConnectionInfo();
    if (paramContext == null)
    {
      ae.e("MicroMsg.NetStatusUtil", "error wifiInfo is null!!");
      AppMethodBeat.o(157751);
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
        paramContext = fpg();
      }
    }
    paramContext = bu.nullAsNil(paramContext).toLowerCase();
    ae.i("MicroMsg.NetStatusUtil", "getConnectedWifiClientMac()=".concat(String.valueOf(paramContext)));
    AppMethodBeat.o(157751);
    return paramContext;
  }
  
  public static boolean jd(Context paramContext)
  {
    AppMethodBeat.i(157757);
    int i = getNetType(paramContext);
    if ((i == 0) || (i == 10))
    {
      ae.d("MicroMsg.NetStatusUtil", "[cpan] is wifi or 4g network");
      AppMethodBeat.o(157757);
      return true;
    }
    ae.d("MicroMsg.NetStatusUtil", "[cpan] is mobile network");
    AppMethodBeat.o(157757);
    return false;
  }
  
  public static void je(Context paramContext)
  {
    try
    {
      AppMethodBeat.i(157758);
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      uXJ = paramContext.getPhoneType();
      if (IyY == null)
      {
        IyY = new PhoneStateListener()
        {
          public final void onSignalStrengthsChanged(SignalStrength paramAnonymousSignalStrength)
          {
            AppMethodBeat.i(157729);
            super.onSignalStrengthsChanged(paramAnonymousSignalStrength);
            if (az.uXJ == 2) {
              az.access$102(paramAnonymousSignalStrength.getCdmaDbm());
            }
            if (az.uXJ == 1) {
              az.access$102(paramAnonymousSignalStrength.getGsmSignalStrength() * 2 - 113);
            }
            ae.i("MicroMsg.NetStatusUtil", "PhoneStateListener  type:%d  strength:%d", new Object[] { Integer.valueOf(az.uXJ), Integer.valueOf(az.nowStrength) });
            AppMethodBeat.o(157729);
          }
        };
        paramContext.listen(IyY, 256);
      }
      AppMethodBeat.o(157758);
      return;
    }
    finally {}
  }
  
  /* Error */
  public static List<a> jf(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 581
    //   6: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: getstatic 19	com/tencent/mm/sdk/platformtools/az:IyY	Landroid/telephony/PhoneStateListener;
    //   12: ifnonnull +24 -> 36
    //   15: ldc 127
    //   17: ldc_w 362
    //   20: invokestatic 183	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   23: aconst_null
    //   24: astore_0
    //   25: ldc_w 581
    //   28: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   31: ldc 2
    //   33: monitorexit
    //   34: aload_0
    //   35: areturn
    //   36: aload_0
    //   37: ldc 247
    //   39: invokevirtual 251	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   42: checkcast 253	android/telephony/TelephonyManager
    //   45: astore 7
    //   47: new 583	java/util/LinkedList
    //   50: dup
    //   51: invokespecial 584	java/util/LinkedList:<init>	()V
    //   54: astore 4
    //   56: ldc_w 586
    //   59: astore 5
    //   61: ldc 51
    //   63: astore 6
    //   65: aload 7
    //   67: invokevirtual 589	android/telephony/TelephonyManager:getNetworkOperator	()Ljava/lang/String;
    //   70: astore_3
    //   71: aload_3
    //   72: ifnull +184 -> 256
    //   75: aload_3
    //   76: ldc 51
    //   78: invokevirtual 59	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   81: ifne +175 -> 256
    //   84: aload_3
    //   85: iconst_0
    //   86: iconst_3
    //   87: invokevirtual 74	java/lang/String:substring	(II)Ljava/lang/String;
    //   90: astore_0
    //   91: aload_3
    //   92: iconst_3
    //   93: iconst_5
    //   94: invokevirtual 74	java/lang/String:substring	(II)Ljava/lang/String;
    //   97: astore_3
    //   98: aload 7
    //   100: invokevirtual 573	android/telephony/TelephonyManager:getPhoneType	()I
    //   103: istore_1
    //   104: iload_1
    //   105: iconst_2
    //   106: if_icmpne +553 -> 659
    //   109: aload 7
    //   111: invokevirtual 593	android/telephony/TelephonyManager:getCellLocation	()Landroid/telephony/CellLocation;
    //   114: checkcast 595	android/telephony/cdma/CdmaCellLocation
    //   117: astore 6
    //   119: aload 6
    //   121: ifnull +123 -> 244
    //   124: getstatic 23	com/tencent/mm/sdk/platformtools/az:nowStrength	I
    //   127: getstatic 21	com/tencent/mm/sdk/platformtools/az:IyZ	I
    //   130: if_icmpne +204 -> 334
    //   133: ldc 51
    //   135: astore 5
    //   137: aload 6
    //   139: invokevirtual 598	android/telephony/cdma/CdmaCellLocation:getBaseStationId	()I
    //   142: iconst_m1
    //   143: if_icmpeq +101 -> 244
    //   146: aload 6
    //   148: invokevirtual 599	android/telephony/cdma/CdmaCellLocation:getNetworkId	()I
    //   151: iconst_m1
    //   152: if_icmpeq +92 -> 244
    //   155: aload 6
    //   157: invokevirtual 602	android/telephony/cdma/CdmaCellLocation:getSystemId	()I
    //   160: iconst_m1
    //   161: if_icmpeq +83 -> 244
    //   164: aload 4
    //   166: new 8	com/tencent/mm/sdk/platformtools/az$a
    //   169: dup
    //   170: aload_0
    //   171: aload_3
    //   172: ldc 51
    //   174: ldc 51
    //   176: aload 5
    //   178: ldc_w 604
    //   181: new 129	java/lang/StringBuilder
    //   184: dup
    //   185: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   188: aload 6
    //   190: invokevirtual 598	android/telephony/cdma/CdmaCellLocation:getBaseStationId	()I
    //   193: invokevirtual 401	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   196: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   199: new 129	java/lang/StringBuilder
    //   202: dup
    //   203: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   206: aload 6
    //   208: invokevirtual 599	android/telephony/cdma/CdmaCellLocation:getNetworkId	()I
    //   211: invokevirtual 401	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   214: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   217: new 129	java/lang/StringBuilder
    //   220: dup
    //   221: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   224: aload 6
    //   226: invokevirtual 602	android/telephony/cdma/CdmaCellLocation:getSystemId	()I
    //   229: invokevirtual 401	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   232: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   235: invokespecial 607	com/tencent/mm/sdk/platformtools/az$a:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   238: invokeinterface 610 2 0
    //   243: pop
    //   244: ldc_w 581
    //   247: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   250: aload 4
    //   252: astore_0
    //   253: goto -222 -> 31
    //   256: aload 7
    //   258: invokevirtual 256	android/telephony/TelephonyManager:getSimOperator	()Ljava/lang/String;
    //   261: astore 8
    //   263: aload 6
    //   265: astore_3
    //   266: aload 5
    //   268: astore_0
    //   269: aload 8
    //   271: ifnull +35 -> 306
    //   274: aload 6
    //   276: astore_3
    //   277: aload 5
    //   279: astore_0
    //   280: aload 8
    //   282: ldc 51
    //   284: invokevirtual 59	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   287: ifne +19 -> 306
    //   290: aload 8
    //   292: iconst_0
    //   293: iconst_3
    //   294: invokevirtual 74	java/lang/String:substring	(II)Ljava/lang/String;
    //   297: astore_0
    //   298: aload 8
    //   300: iconst_3
    //   301: iconst_5
    //   302: invokevirtual 74	java/lang/String:substring	(II)Ljava/lang/String;
    //   305: astore_3
    //   306: goto -208 -> 98
    //   309: astore_0
    //   310: ldc 127
    //   312: aload_0
    //   313: ldc 51
    //   315: iconst_0
    //   316: anewarray 4	java/lang/Object
    //   319: invokestatic 226	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   322: ldc_w 581
    //   325: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   328: aload 4
    //   330: astore_0
    //   331: goto -300 -> 31
    //   334: new 129	java/lang/StringBuilder
    //   337: dup
    //   338: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   341: getstatic 23	com/tencent/mm/sdk/platformtools/az:nowStrength	I
    //   344: invokevirtual 401	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   347: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   350: astore 5
    //   352: goto -215 -> 137
    //   355: astore 5
    //   357: aload 7
    //   359: invokevirtual 593	android/telephony/TelephonyManager:getCellLocation	()Landroid/telephony/CellLocation;
    //   362: checkcast 612	android/telephony/gsm/GsmCellLocation
    //   365: astore 5
    //   367: aload 5
    //   369: ifnull +68 -> 437
    //   372: aload 5
    //   374: invokevirtual 615	android/telephony/gsm/GsmCellLocation:getCid	()I
    //   377: istore_1
    //   378: aload 5
    //   380: invokevirtual 618	android/telephony/gsm/GsmCellLocation:getLac	()I
    //   383: istore_2
    //   384: iload_2
    //   385: ldc_w 619
    //   388: if_icmpge +49 -> 437
    //   391: iload_2
    //   392: iconst_m1
    //   393: if_icmpeq +44 -> 437
    //   396: iload_1
    //   397: iconst_m1
    //   398: if_icmpeq +39 -> 437
    //   401: aload 4
    //   403: new 8	com/tencent/mm/sdk/platformtools/az$a
    //   406: dup
    //   407: aload_0
    //   408: aload_3
    //   409: iload_2
    //   410: invokestatic 622	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   413: iload_1
    //   414: invokestatic 622	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   417: ldc 51
    //   419: ldc_w 624
    //   422: ldc 51
    //   424: ldc 51
    //   426: ldc 51
    //   428: invokespecial 607	com/tencent/mm/sdk/platformtools/az$a:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   431: invokeinterface 610 2 0
    //   436: pop
    //   437: aload 7
    //   439: invokevirtual 627	android/telephony/TelephonyManager:getAllCellInfo	()Ljava/util/List;
    //   442: astore 5
    //   444: aload 5
    //   446: ifnull -202 -> 244
    //   449: aload 5
    //   451: invokeinterface 630 1 0
    //   456: ifle -212 -> 244
    //   459: aload 5
    //   461: invokeinterface 103 1 0
    //   466: astore 5
    //   468: aload 5
    //   470: invokeinterface 109 1 0
    //   475: ifeq -231 -> 244
    //   478: aload 5
    //   480: invokeinterface 113 1 0
    //   485: checkcast 632	android/telephony/CellInfo
    //   488: astore 7
    //   490: aload 7
    //   492: instanceof 634
    //   495: ifeq -27 -> 468
    //   498: aload 7
    //   500: checkcast 634	android/telephony/CellInfoGsm
    //   503: invokevirtual 638	android/telephony/CellInfoGsm:getCellIdentity	()Landroid/telephony/CellIdentityGsm;
    //   506: astore 6
    //   508: aload 6
    //   510: invokevirtual 641	android/telephony/CellIdentityGsm:getCid	()I
    //   513: iconst_m1
    //   514: if_icmpeq -46 -> 468
    //   517: aload 6
    //   519: invokevirtual 642	android/telephony/CellIdentityGsm:getLac	()I
    //   522: ldc_w 619
    //   525: if_icmpgt -57 -> 468
    //   528: aload 6
    //   530: invokevirtual 642	android/telephony/CellIdentityGsm:getLac	()I
    //   533: iconst_m1
    //   534: if_icmpeq -66 -> 468
    //   537: new 129	java/lang/StringBuilder
    //   540: dup
    //   541: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   544: aload 7
    //   546: checkcast 634	android/telephony/CellInfoGsm
    //   549: invokevirtual 646	android/telephony/CellInfoGsm:getCellSignalStrength	()Landroid/telephony/CellSignalStrengthGsm;
    //   552: invokevirtual 651	android/telephony/CellSignalStrengthGsm:getAsuLevel	()I
    //   555: iconst_2
    //   556: imul
    //   557: bipush 113
    //   559: isub
    //   560: invokevirtual 401	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   563: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   566: astore 7
    //   568: aload 4
    //   570: new 8	com/tencent/mm/sdk/platformtools/az$a
    //   573: dup
    //   574: aload_0
    //   575: aload_3
    //   576: new 129	java/lang/StringBuilder
    //   579: dup
    //   580: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   583: aload 6
    //   585: invokevirtual 642	android/telephony/CellIdentityGsm:getLac	()I
    //   588: invokevirtual 401	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   591: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   594: new 129	java/lang/StringBuilder
    //   597: dup
    //   598: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   601: aload 6
    //   603: invokevirtual 641	android/telephony/CellIdentityGsm:getCid	()I
    //   606: invokevirtual 401	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   609: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   612: aload 7
    //   614: ldc_w 624
    //   617: ldc 51
    //   619: ldc 51
    //   621: ldc 51
    //   623: invokespecial 607	com/tencent/mm/sdk/platformtools/az$a:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   626: invokeinterface 610 2 0
    //   631: pop
    //   632: goto -164 -> 468
    //   635: astore_0
    //   636: ldc 2
    //   638: monitorexit
    //   639: aload_0
    //   640: athrow
    //   641: astore 5
    //   643: ldc 127
    //   645: aload 5
    //   647: ldc 51
    //   649: iconst_0
    //   650: anewarray 4	java/lang/Object
    //   653: invokestatic 226	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   656: goto -219 -> 437
    //   659: aload 7
    //   661: invokevirtual 593	android/telephony/TelephonyManager:getCellLocation	()Landroid/telephony/CellLocation;
    //   664: checkcast 612	android/telephony/gsm/GsmCellLocation
    //   667: astore 5
    //   669: aload 5
    //   671: ifnull +81 -> 752
    //   674: aload 5
    //   676: invokevirtual 615	android/telephony/gsm/GsmCellLocation:getCid	()I
    //   679: istore_1
    //   680: aload 5
    //   682: invokevirtual 618	android/telephony/gsm/GsmCellLocation:getLac	()I
    //   685: istore_2
    //   686: iload_2
    //   687: ldc_w 619
    //   690: if_icmpge +62 -> 752
    //   693: iload_2
    //   694: iconst_m1
    //   695: if_icmpeq +57 -> 752
    //   698: iload_1
    //   699: iconst_m1
    //   700: if_icmpeq +52 -> 752
    //   703: getstatic 23	com/tencent/mm/sdk/platformtools/az:nowStrength	I
    //   706: getstatic 21	com/tencent/mm/sdk/platformtools/az:IyZ	I
    //   709: if_icmpne +284 -> 993
    //   712: ldc 51
    //   714: astore 5
    //   716: aload 4
    //   718: new 8	com/tencent/mm/sdk/platformtools/az$a
    //   721: dup
    //   722: aload_0
    //   723: aload_3
    //   724: iload_2
    //   725: invokestatic 622	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   728: iload_1
    //   729: invokestatic 622	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   732: aload 5
    //   734: ldc_w 624
    //   737: ldc 51
    //   739: ldc 51
    //   741: ldc 51
    //   743: invokespecial 607	com/tencent/mm/sdk/platformtools/az$a:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   746: invokeinterface 610 2 0
    //   751: pop
    //   752: aload 7
    //   754: invokevirtual 627	android/telephony/TelephonyManager:getAllCellInfo	()Ljava/util/List;
    //   757: astore 5
    //   759: aload 5
    //   761: ifnull -517 -> 244
    //   764: aload 5
    //   766: invokeinterface 630 1 0
    //   771: ifle -527 -> 244
    //   774: aload 5
    //   776: invokeinterface 103 1 0
    //   781: astore 5
    //   783: aload 5
    //   785: invokeinterface 109 1 0
    //   790: ifeq -546 -> 244
    //   793: aload 5
    //   795: invokeinterface 113 1 0
    //   800: checkcast 632	android/telephony/CellInfo
    //   803: astore 7
    //   805: aload 7
    //   807: instanceof 634
    //   810: ifeq -27 -> 783
    //   813: aload 7
    //   815: checkcast 634	android/telephony/CellInfoGsm
    //   818: invokevirtual 638	android/telephony/CellInfoGsm:getCellIdentity	()Landroid/telephony/CellIdentityGsm;
    //   821: astore 6
    //   823: aload 6
    //   825: invokevirtual 641	android/telephony/CellIdentityGsm:getCid	()I
    //   828: iconst_m1
    //   829: if_icmpeq -46 -> 783
    //   832: aload 6
    //   834: invokevirtual 642	android/telephony/CellIdentityGsm:getLac	()I
    //   837: ldc_w 619
    //   840: if_icmpgt -57 -> 783
    //   843: new 129	java/lang/StringBuilder
    //   846: dup
    //   847: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   850: aload 7
    //   852: checkcast 634	android/telephony/CellInfoGsm
    //   855: invokevirtual 646	android/telephony/CellInfoGsm:getCellSignalStrength	()Landroid/telephony/CellSignalStrengthGsm;
    //   858: invokevirtual 651	android/telephony/CellSignalStrengthGsm:getAsuLevel	()I
    //   861: iconst_2
    //   862: imul
    //   863: bipush 113
    //   865: isub
    //   866: invokevirtual 401	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   869: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   872: astore 7
    //   874: ldc_w 653
    //   877: new 129	java/lang/StringBuilder
    //   880: dup
    //   881: ldc_w 655
    //   884: invokespecial 135	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   887: aload 6
    //   889: invokevirtual 642	android/telephony/CellIdentityGsm:getLac	()I
    //   892: invokevirtual 401	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   895: ldc_w 657
    //   898: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   901: aload 6
    //   903: invokevirtual 641	android/telephony/CellIdentityGsm:getCid	()I
    //   906: invokevirtual 401	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   909: ldc_w 659
    //   912: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   915: aload 7
    //   917: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   920: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   923: invokestatic 662	com/tencent/mm/sdk/platformtools/ae:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   926: aload 4
    //   928: new 8	com/tencent/mm/sdk/platformtools/az$a
    //   931: dup
    //   932: aload_0
    //   933: aload_3
    //   934: new 129	java/lang/StringBuilder
    //   937: dup
    //   938: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   941: aload 6
    //   943: invokevirtual 642	android/telephony/CellIdentityGsm:getLac	()I
    //   946: invokevirtual 401	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   949: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   952: new 129	java/lang/StringBuilder
    //   955: dup
    //   956: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   959: aload 6
    //   961: invokevirtual 641	android/telephony/CellIdentityGsm:getCid	()I
    //   964: invokevirtual 401	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   967: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   970: aload 7
    //   972: ldc_w 624
    //   975: ldc 51
    //   977: ldc 51
    //   979: ldc 51
    //   981: invokespecial 607	com/tencent/mm/sdk/platformtools/az$a:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   984: invokeinterface 610 2 0
    //   989: pop
    //   990: goto -207 -> 783
    //   993: new 129	java/lang/StringBuilder
    //   996: dup
    //   997: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   1000: getstatic 23	com/tencent/mm/sdk/platformtools/az:nowStrength	I
    //   1003: invokevirtual 401	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1006: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1009: astore 5
    //   1011: goto -295 -> 716
    //   1014: astore 5
    //   1016: ldc 127
    //   1018: aload 5
    //   1020: ldc 51
    //   1022: iconst_0
    //   1023: anewarray 4	java/lang/Object
    //   1026: invokestatic 226	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1029: goto -277 -> 752
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1032	0	paramContext	Context
    //   103	626	1	i	int
    //   383	342	2	j	int
    //   70	864	3	localObject1	Object
    //   54	873	4	localLinkedList	java.util.LinkedList
    //   59	292	5	str1	String
    //   355	1	5	localException1	Exception
    //   365	114	5	localObject2	Object
    //   641	5	5	localException2	Exception
    //   667	343	5	localObject3	Object
    //   1014	5	5	localException3	Exception
    //   63	897	6	localObject4	Object
    //   45	926	7	localObject5	Object
    //   261	38	8	str2	String
    // Exception table:
    //   from	to	target	type
    //   65	71	309	java/lang/Exception
    //   75	98	309	java/lang/Exception
    //   256	263	309	java/lang/Exception
    //   280	306	309	java/lang/Exception
    //   109	119	355	java/lang/Exception
    //   124	133	355	java/lang/Exception
    //   137	244	355	java/lang/Exception
    //   334	352	355	java/lang/Exception
    //   3	23	635	finally
    //   25	31	635	finally
    //   36	56	635	finally
    //   65	71	635	finally
    //   75	98	635	finally
    //   98	104	635	finally
    //   109	119	635	finally
    //   124	133	635	finally
    //   137	244	635	finally
    //   244	250	635	finally
    //   256	263	635	finally
    //   280	306	635	finally
    //   310	328	635	finally
    //   334	352	635	finally
    //   357	367	635	finally
    //   372	384	635	finally
    //   401	437	635	finally
    //   437	444	635	finally
    //   449	468	635	finally
    //   468	632	635	finally
    //   643	656	635	finally
    //   659	669	635	finally
    //   674	686	635	finally
    //   703	712	635	finally
    //   716	752	635	finally
    //   752	759	635	finally
    //   764	783	635	finally
    //   783	990	635	finally
    //   993	1011	635	finally
    //   1016	1029	635	finally
    //   357	367	641	java/lang/Exception
    //   372	384	641	java/lang/Exception
    //   401	437	641	java/lang/Exception
    //   659	669	1014	java/lang/Exception
    //   674	686	1014	java/lang/Exception
    //   703	712	1014	java/lang/Exception
    //   716	752	1014	java/lang/Exception
    //   993	1011	1014	java/lang/Exception
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
        ae.e("MicroMsg.NetStatusUtil", "package  size" + localList.size());
        int i = 0;
        for (;;)
        {
          int j = localList.size();
          if (i >= j) {
            break label418;
          }
          try
          {
            ae.e("MicroMsg.NetStatusUtil", "package " + ((PackageInfo)localList.get(i)).packageName);
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
                  ae.e("MicroMsg.NetStatusUtil", "activityName count ".concat(String.valueOf(j)));
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
                      localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
                      com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahE(), "com/tencent/mm/sdk/platformtools/NetStatusUtil", "searchIntentByClass", "(Landroid/content/Context;Ljava/lang/String;)Landroid/content/Intent;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                      paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mt(0));
                      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/sdk/platformtools/NetStatusUtil", "searchIntentByClass", "(Landroid/content/Context;Ljava/lang/String;)Landroid/content/Intent;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
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
                  ae.printErrStackTrace("MicroMsg.NetStatusUtil", localException1, "", new Object[0]);
                }
              }
            }
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              label380:
              ae.printErrStackTrace("MicroMsg.NetStatusUtil", localException2, "", new Object[0]);
            }
          }
        }
      }
      label418:
      return null;
    }
    catch (Exception paramContext)
    {
      ae.printErrStackTrace("MicroMsg.NetStatusUtil", paramContext, "", new Object[0]);
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
        localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject1);
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahE(), "com/tencent/mm/sdk/platformtools/NetStatusUtil", "startSettingItent", "(Landroid/content/Context;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/sdk/platformtools/NetStatusUtil", "startSettingItent", "(Landroid/content/Context;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
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
          localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
          com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahE(), "com/tencent/mm/sdk/platformtools/NetStatusUtil", "startSettingItent", "(Landroid/content/Context;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/sdk/platformtools/NetStatusUtil", "startSettingItent", "(Landroid/content/Context;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
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
        localObject3 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject3);
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject3).ahE(), "com/tencent/mm/sdk/platformtools/NetStatusUtil", "startSettingItent", "(Landroid/content/Context;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject3).mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/sdk/platformtools/NetStatusUtil", "startSettingItent", "(Landroid/content/Context;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
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
        localObject4 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject4);
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject4).ahE(), "com/tencent/mm/sdk/platformtools/NetStatusUtil", "startSettingItent", "(Landroid/content/Context;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject4).mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/sdk/platformtools/NetStatusUtil", "startSettingItent", "(Landroid/content/Context;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(157748);
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
    public String DoE;
    public String DoG;
    public String DoH;
    public String DoI;
    public String systemId;
    public String type;
    public String vWX;
    public String vWY;
    public String vWZ;
    
    public a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
    {
      this.vWX = paramString1;
      this.vWY = paramString2;
      this.DoE = paramString3;
      this.type = paramString6;
      this.vWZ = paramString4;
      this.DoG = paramString7;
      this.DoH = paramString8;
      this.systemId = paramString9;
      this.DoI = paramString5;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.az
 * JD-Core Version:    0.7.0.1
 */