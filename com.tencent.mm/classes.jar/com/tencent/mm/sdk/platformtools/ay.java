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

public final class ay
{
  private static PhoneStateListener EVM = null;
  private static int EVN = 10000;
  private static int nowStrength = 10000;
  private static int sBB = -1;
  
  private static String aas(String paramString)
  {
    AppMethodBeat.i(157753);
    if (bt.isNullOrNil(paramString))
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
  
  private static String eGj()
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
              ad.d("MicroMsg.NetStatusUtil", "et mobile mac from net time cost :" + (System.currentTimeMillis() - l));
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
            ad.d("MicroMsg.NetStatusUtil", "et mobile mac from net time cost :" + (System.currentTimeMillis() - l));
            localObject1 = ((StringBuilder)localObject2).toString();
            AppMethodBeat.o(157752);
            return localObject1;
          }
        }
      }
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.NetStatusUtil", "get mobile mac from net fail!".concat(String.valueOf(localException)));
      ad.d("MicroMsg.NetStatusUtil", "et mobile mac from net time cost :" + (System.currentTimeMillis() - l));
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
        ad.printErrStackTrace("MicroMsg.NetStatusUtil", localException, "", new Object[0]);
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
      ad.printErrStackTrace("MicroMsg.NetStatusUtil", paramContext, "", new Object[0]);
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
        ad.printErrStackTrace("MicroMsg.NetStatusUtil", paramContext, "", new Object[0]);
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
      ad.d("MicroMsg.NetStatusUtil", "getISPName ISPName=%s", new Object[] { paramContext.getSimOperatorName() });
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
    ad.d("MicroMsg.NetStatusUtil", "activeNetInfo extra=%s, type=%d", new Object[] { paramContext.getExtraInfo(), Integer.valueOf(paramContext.getType()) });
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
      ad.printErrStackTrace("MicroMsg.NetStatusUtil", paramContext, "", new Object[0]);
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
      ad.d("MicroMsg.NetStatusUtil", "activeNetInfo extra=%s, type=%d", new Object[] { paramContext.getExtraInfo(), Integer.valueOf(paramContext.getType()) });
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
      ad.printErrStackTrace("MicroMsg.NetStatusUtil", paramContext, "", new Object[0]);
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
      ad.printErrStackTrace("MicroMsg.NetStatusUtil", paramContext, "", new Object[0]);
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
    //   3: ldc_w 338
    //   6: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: ifnonnull +16 -> 26
    //   13: ldc_w 338
    //   16: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: iconst_0
    //   20: istore_1
    //   21: ldc 2
    //   23: monitorexit
    //   24: iload_1
    //   25: ireturn
    //   26: aload_0
    //   27: invokestatic 340	com/tencent/mm/sdk/platformtools/ay:getNetTypeForStat	(Landroid/content/Context;)I
    //   30: iconst_1
    //   31: if_icmpne +38 -> 69
    //   34: aload_0
    //   35: ldc_w 342
    //   38: invokevirtual 249	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   41: checkcast 344	android/net/wifi/WifiManager
    //   44: invokevirtual 348	android/net/wifi/WifiManager:getConnectionInfo	()Landroid/net/wifi/WifiInfo;
    //   47: invokevirtual 353	android/net/wifi/WifiInfo:getRssi	()I
    //   50: invokestatic 359	java/lang/Math:abs	(I)I
    //   53: istore_1
    //   54: ldc_w 338
    //   57: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   60: goto -39 -> 21
    //   63: astore_0
    //   64: ldc 2
    //   66: monitorexit
    //   67: aload_0
    //   68: athrow
    //   69: getstatic 19	com/tencent/mm/sdk/platformtools/ay:EVM	Landroid/telephony/PhoneStateListener;
    //   72: ifnonnull +11 -> 83
    //   75: ldc 125
    //   77: ldc_w 361
    //   80: invokestatic 181	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   83: getstatic 23	com/tencent/mm/sdk/platformtools/ay:nowStrength	I
    //   86: invokestatic 359	java/lang/Math:abs	(I)I
    //   89: istore_1
    //   90: ldc_w 338
    //   93: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   96: goto -75 -> 21
    //   99: astore_0
    //   100: ldc 125
    //   102: aload_0
    //   103: ldc 46
    //   105: iconst_0
    //   106: anewarray 4	java/lang/Object
    //   109: invokestatic 224	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   112: ldc_w 338
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
      ad.printErrStackTrace("MicroMsg.NetStatusUtil", paramContext, "", new Object[0]);
      AppMethodBeat.o(157746);
    }
    return null;
  }
  
  public static String iA(Context paramContext)
  {
    AppMethodBeat.i(157749);
    if (getNetType(paramContext) != 0)
    {
      ad.i("MicroMsg.NetStatusUtil", "wifi not connected. getConnectedWifiSsid() is empty");
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
            ad.i("MicroMsg.NetStatusUtil", "get wifi config ssid %s", new Object[] { localWifiConfiguration.SSID });
            paramContext = localWifiConfiguration.SSID;
          }
        }
      }
    }
    for (;;)
    {
      paramContext = bt.nullAsNil(paramContext);
      ad.i("MicroMsg.NetStatusUtil", "getConnectedWifiSsid()=" + aas(paramContext));
      paramContext = aas(paramContext);
      AppMethodBeat.o(157749);
      return paramContext;
    }
  }
  
  public static String iB(Context paramContext)
  {
    AppMethodBeat.i(157750);
    if (getNetType(paramContext) != 0)
    {
      ad.i("MicroMsg.NetStatusUtil", "wifi not connected. getConnectedWifiBssid() is empty");
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
    paramContext = bt.nullAsNil(paramContext.getBSSID()).toLowerCase();
    ad.i("MicroMsg.NetStatusUtil", "getConnectedWifiBssid()=".concat(String.valueOf(paramContext)));
    AppMethodBeat.o(157750);
    return paramContext;
  }
  
  public static String iC(Context paramContext)
  {
    AppMethodBeat.i(157751);
    paramContext = (WifiManager)paramContext.getSystemService("wifi");
    if (paramContext == null)
    {
      ad.e("MicroMsg.NetStatusUtil", "error wifiManager is null!!");
      AppMethodBeat.o(157751);
      return "";
    }
    paramContext = paramContext.getConnectionInfo();
    if (paramContext == null)
    {
      ad.e("MicroMsg.NetStatusUtil", "error wifiInfo is null!!");
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
        paramContext = eGj();
      }
    }
    paramContext = bt.nullAsNil(paramContext).toLowerCase();
    ad.i("MicroMsg.NetStatusUtil", "getConnectedWifiClientMac()=".concat(String.valueOf(paramContext)));
    AppMethodBeat.o(157751);
    return paramContext;
  }
  
  public static boolean iD(Context paramContext)
  {
    AppMethodBeat.i(157757);
    int i = getNetType(paramContext);
    if ((i == 0) || (i == 10))
    {
      ad.d("MicroMsg.NetStatusUtil", "[cpan] is wifi or 4g network");
      AppMethodBeat.o(157757);
      return true;
    }
    ad.d("MicroMsg.NetStatusUtil", "[cpan] is mobile network");
    AppMethodBeat.o(157757);
    return false;
  }
  
  public static void iE(Context paramContext)
  {
    try
    {
      AppMethodBeat.i(157758);
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      sBB = paramContext.getPhoneType();
      if (EVM == null)
      {
        EVM = new PhoneStateListener()
        {
          public final void onSignalStrengthsChanged(SignalStrength paramAnonymousSignalStrength)
          {
            AppMethodBeat.i(157729);
            super.onSignalStrengthsChanged(paramAnonymousSignalStrength);
            if (ay.sBB == 2) {
              ay.zT(paramAnonymousSignalStrength.getCdmaDbm());
            }
            if (ay.sBB == 1) {
              ay.zT(paramAnonymousSignalStrength.getGsmSignalStrength() * 2 - 113);
            }
            ad.i("MicroMsg.NetStatusUtil", "PhoneStateListener  type:%d  strength:%d", new Object[] { Integer.valueOf(ay.sBB), Integer.valueOf(ay.nowStrength) });
            AppMethodBeat.o(157729);
          }
        };
        paramContext.listen(EVM, 256);
      }
      AppMethodBeat.o(157758);
      return;
    }
    finally {}
  }
  
  /* Error */
  public static List<a> iF(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 446
    //   6: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: getstatic 19	com/tencent/mm/sdk/platformtools/ay:EVM	Landroid/telephony/PhoneStateListener;
    //   12: ifnonnull +24 -> 36
    //   15: ldc 125
    //   17: ldc_w 361
    //   20: invokestatic 181	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   23: aconst_null
    //   24: astore_0
    //   25: ldc_w 446
    //   28: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   31: ldc 2
    //   33: monitorexit
    //   34: aload_0
    //   35: areturn
    //   36: aload_0
    //   37: ldc 245
    //   39: invokevirtual 249	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   42: checkcast 251	android/telephony/TelephonyManager
    //   45: astore 7
    //   47: new 448	java/util/LinkedList
    //   50: dup
    //   51: invokespecial 449	java/util/LinkedList:<init>	()V
    //   54: astore 4
    //   56: ldc_w 451
    //   59: astore 5
    //   61: ldc 46
    //   63: astore 6
    //   65: aload 7
    //   67: invokevirtual 454	android/telephony/TelephonyManager:getNetworkOperator	()Ljava/lang/String;
    //   70: astore_3
    //   71: aload_3
    //   72: ifnull +184 -> 256
    //   75: aload_3
    //   76: ldc 46
    //   78: invokevirtual 54	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   81: ifne +175 -> 256
    //   84: aload_3
    //   85: iconst_0
    //   86: iconst_3
    //   87: invokevirtual 70	java/lang/String:substring	(II)Ljava/lang/String;
    //   90: astore_0
    //   91: aload_3
    //   92: iconst_3
    //   93: iconst_5
    //   94: invokevirtual 70	java/lang/String:substring	(II)Ljava/lang/String;
    //   97: astore_3
    //   98: aload 7
    //   100: invokevirtual 438	android/telephony/TelephonyManager:getPhoneType	()I
    //   103: istore_1
    //   104: iload_1
    //   105: iconst_2
    //   106: if_icmpne +529 -> 635
    //   109: aload 7
    //   111: invokevirtual 458	android/telephony/TelephonyManager:getCellLocation	()Landroid/telephony/CellLocation;
    //   114: checkcast 460	android/telephony/cdma/CdmaCellLocation
    //   117: astore 6
    //   119: aload 6
    //   121: ifnull +123 -> 244
    //   124: getstatic 23	com/tencent/mm/sdk/platformtools/ay:nowStrength	I
    //   127: getstatic 21	com/tencent/mm/sdk/platformtools/ay:EVN	I
    //   130: if_icmpne +204 -> 334
    //   133: ldc 46
    //   135: astore 5
    //   137: aload 6
    //   139: invokevirtual 463	android/telephony/cdma/CdmaCellLocation:getBaseStationId	()I
    //   142: iconst_m1
    //   143: if_icmpeq +101 -> 244
    //   146: aload 6
    //   148: invokevirtual 464	android/telephony/cdma/CdmaCellLocation:getNetworkId	()I
    //   151: iconst_m1
    //   152: if_icmpeq +92 -> 244
    //   155: aload 6
    //   157: invokevirtual 467	android/telephony/cdma/CdmaCellLocation:getSystemId	()I
    //   160: iconst_m1
    //   161: if_icmpeq +83 -> 244
    //   164: aload 4
    //   166: new 8	com/tencent/mm/sdk/platformtools/ay$a
    //   169: dup
    //   170: aload_0
    //   171: aload_3
    //   172: ldc 46
    //   174: ldc 46
    //   176: aload 5
    //   178: ldc_w 469
    //   181: new 127	java/lang/StringBuilder
    //   184: dup
    //   185: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   188: aload 6
    //   190: invokevirtual 463	android/telephony/cdma/CdmaCellLocation:getBaseStationId	()I
    //   193: invokevirtual 471	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   196: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   199: new 127	java/lang/StringBuilder
    //   202: dup
    //   203: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   206: aload 6
    //   208: invokevirtual 464	android/telephony/cdma/CdmaCellLocation:getNetworkId	()I
    //   211: invokevirtual 471	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   214: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   217: new 127	java/lang/StringBuilder
    //   220: dup
    //   221: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   224: aload 6
    //   226: invokevirtual 467	android/telephony/cdma/CdmaCellLocation:getSystemId	()I
    //   229: invokevirtual 471	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   232: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   235: invokespecial 474	com/tencent/mm/sdk/platformtools/ay$a:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   238: invokeinterface 477 2 0
    //   243: pop
    //   244: ldc_w 446
    //   247: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   250: aload 4
    //   252: astore_0
    //   253: goto -222 -> 31
    //   256: aload 7
    //   258: invokevirtual 254	android/telephony/TelephonyManager:getSimOperator	()Ljava/lang/String;
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
    //   282: ldc 46
    //   284: invokevirtual 54	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   287: ifne +19 -> 306
    //   290: aload 8
    //   292: iconst_0
    //   293: iconst_3
    //   294: invokevirtual 70	java/lang/String:substring	(II)Ljava/lang/String;
    //   297: astore_0
    //   298: aload 8
    //   300: iconst_3
    //   301: iconst_5
    //   302: invokevirtual 70	java/lang/String:substring	(II)Ljava/lang/String;
    //   305: astore_3
    //   306: goto -208 -> 98
    //   309: astore_0
    //   310: ldc 125
    //   312: aload_0
    //   313: ldc 46
    //   315: iconst_0
    //   316: anewarray 4	java/lang/Object
    //   319: invokestatic 224	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   322: ldc_w 446
    //   325: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   328: aload 4
    //   330: astore_0
    //   331: goto -300 -> 31
    //   334: new 127	java/lang/StringBuilder
    //   337: dup
    //   338: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   341: getstatic 23	com/tencent/mm/sdk/platformtools/ay:nowStrength	I
    //   344: invokevirtual 471	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   347: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   350: astore 5
    //   352: goto -215 -> 137
    //   355: astore 5
    //   357: aload 7
    //   359: invokevirtual 458	android/telephony/TelephonyManager:getCellLocation	()Landroid/telephony/CellLocation;
    //   362: checkcast 479	android/telephony/gsm/GsmCellLocation
    //   365: astore 5
    //   367: aload 5
    //   369: ifnull +68 -> 437
    //   372: aload 5
    //   374: invokevirtual 482	android/telephony/gsm/GsmCellLocation:getCid	()I
    //   377: istore_1
    //   378: aload 5
    //   380: invokevirtual 485	android/telephony/gsm/GsmCellLocation:getLac	()I
    //   383: istore_2
    //   384: iload_2
    //   385: ldc_w 486
    //   388: if_icmpge +49 -> 437
    //   391: iload_2
    //   392: iconst_m1
    //   393: if_icmpeq +44 -> 437
    //   396: iload_1
    //   397: iconst_m1
    //   398: if_icmpeq +39 -> 437
    //   401: aload 4
    //   403: new 8	com/tencent/mm/sdk/platformtools/ay$a
    //   406: dup
    //   407: aload_0
    //   408: aload_3
    //   409: iload_2
    //   410: invokestatic 489	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   413: iload_1
    //   414: invokestatic 489	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   417: ldc 46
    //   419: ldc_w 491
    //   422: ldc 46
    //   424: ldc 46
    //   426: ldc 46
    //   428: invokespecial 474	com/tencent/mm/sdk/platformtools/ay$a:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   431: invokeinterface 477 2 0
    //   436: pop
    //   437: aload 7
    //   439: invokevirtual 494	android/telephony/TelephonyManager:getNeighboringCellInfo	()Ljava/util/List;
    //   442: astore 5
    //   444: aload 5
    //   446: ifnull -202 -> 244
    //   449: aload 5
    //   451: invokeinterface 497 1 0
    //   456: ifle -212 -> 244
    //   459: aload 5
    //   461: invokeinterface 101 1 0
    //   466: astore 5
    //   468: aload 5
    //   470: invokeinterface 107 1 0
    //   475: ifeq -231 -> 244
    //   478: aload 5
    //   480: invokeinterface 111 1 0
    //   485: checkcast 499	android/telephony/NeighboringCellInfo
    //   488: astore 6
    //   490: aload 6
    //   492: invokevirtual 500	android/telephony/NeighboringCellInfo:getCid	()I
    //   495: iconst_m1
    //   496: if_icmpeq -28 -> 468
    //   499: aload 6
    //   501: invokevirtual 501	android/telephony/NeighboringCellInfo:getLac	()I
    //   504: ldc_w 486
    //   507: if_icmpgt -39 -> 468
    //   510: aload 6
    //   512: invokevirtual 501	android/telephony/NeighboringCellInfo:getLac	()I
    //   515: iconst_m1
    //   516: if_icmpeq -48 -> 468
    //   519: new 127	java/lang/StringBuilder
    //   522: dup
    //   523: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   526: aload 6
    //   528: invokevirtual 502	android/telephony/NeighboringCellInfo:getRssi	()I
    //   531: iconst_2
    //   532: imul
    //   533: bipush 113
    //   535: isub
    //   536: invokevirtual 471	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   539: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   542: astore 7
    //   544: aload 4
    //   546: new 8	com/tencent/mm/sdk/platformtools/ay$a
    //   549: dup
    //   550: aload_0
    //   551: aload_3
    //   552: new 127	java/lang/StringBuilder
    //   555: dup
    //   556: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   559: aload 6
    //   561: invokevirtual 501	android/telephony/NeighboringCellInfo:getLac	()I
    //   564: invokevirtual 471	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   567: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   570: new 127	java/lang/StringBuilder
    //   573: dup
    //   574: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   577: aload 6
    //   579: invokevirtual 500	android/telephony/NeighboringCellInfo:getCid	()I
    //   582: invokevirtual 471	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   585: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   588: aload 7
    //   590: ldc_w 491
    //   593: ldc 46
    //   595: ldc 46
    //   597: ldc 46
    //   599: invokespecial 474	com/tencent/mm/sdk/platformtools/ay$a:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   602: invokeinterface 477 2 0
    //   607: pop
    //   608: goto -140 -> 468
    //   611: astore_0
    //   612: ldc 2
    //   614: monitorexit
    //   615: aload_0
    //   616: athrow
    //   617: astore 5
    //   619: ldc 125
    //   621: aload 5
    //   623: ldc 46
    //   625: iconst_0
    //   626: anewarray 4	java/lang/Object
    //   629: invokestatic 224	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   632: goto -195 -> 437
    //   635: aload 7
    //   637: invokevirtual 458	android/telephony/TelephonyManager:getCellLocation	()Landroid/telephony/CellLocation;
    //   640: checkcast 479	android/telephony/gsm/GsmCellLocation
    //   643: astore 5
    //   645: aload 5
    //   647: ifnull +81 -> 728
    //   650: aload 5
    //   652: invokevirtual 482	android/telephony/gsm/GsmCellLocation:getCid	()I
    //   655: istore_1
    //   656: aload 5
    //   658: invokevirtual 485	android/telephony/gsm/GsmCellLocation:getLac	()I
    //   661: istore_2
    //   662: iload_2
    //   663: ldc_w 486
    //   666: if_icmpge +62 -> 728
    //   669: iload_2
    //   670: iconst_m1
    //   671: if_icmpeq +57 -> 728
    //   674: iload_1
    //   675: iconst_m1
    //   676: if_icmpeq +52 -> 728
    //   679: getstatic 23	com/tencent/mm/sdk/platformtools/ay:nowStrength	I
    //   682: getstatic 21	com/tencent/mm/sdk/platformtools/ay:EVN	I
    //   685: if_icmpne +260 -> 945
    //   688: ldc 46
    //   690: astore 5
    //   692: aload 4
    //   694: new 8	com/tencent/mm/sdk/platformtools/ay$a
    //   697: dup
    //   698: aload_0
    //   699: aload_3
    //   700: iload_2
    //   701: invokestatic 489	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   704: iload_1
    //   705: invokestatic 489	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   708: aload 5
    //   710: ldc_w 491
    //   713: ldc 46
    //   715: ldc 46
    //   717: ldc 46
    //   719: invokespecial 474	com/tencent/mm/sdk/platformtools/ay$a:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   722: invokeinterface 477 2 0
    //   727: pop
    //   728: aload 7
    //   730: invokevirtual 494	android/telephony/TelephonyManager:getNeighboringCellInfo	()Ljava/util/List;
    //   733: astore 5
    //   735: aload 5
    //   737: ifnull -493 -> 244
    //   740: aload 5
    //   742: invokeinterface 497 1 0
    //   747: ifle -503 -> 244
    //   750: aload 5
    //   752: invokeinterface 101 1 0
    //   757: astore 5
    //   759: aload 5
    //   761: invokeinterface 107 1 0
    //   766: ifeq -522 -> 244
    //   769: aload 5
    //   771: invokeinterface 111 1 0
    //   776: checkcast 499	android/telephony/NeighboringCellInfo
    //   779: astore 6
    //   781: aload 6
    //   783: invokevirtual 500	android/telephony/NeighboringCellInfo:getCid	()I
    //   786: iconst_m1
    //   787: if_icmpeq -28 -> 759
    //   790: aload 6
    //   792: invokevirtual 501	android/telephony/NeighboringCellInfo:getLac	()I
    //   795: ldc_w 486
    //   798: if_icmpgt -39 -> 759
    //   801: new 127	java/lang/StringBuilder
    //   804: dup
    //   805: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   808: aload 6
    //   810: invokevirtual 502	android/telephony/NeighboringCellInfo:getRssi	()I
    //   813: iconst_2
    //   814: imul
    //   815: bipush 113
    //   817: isub
    //   818: invokevirtual 471	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   821: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   824: astore 7
    //   826: ldc_w 504
    //   829: new 127	java/lang/StringBuilder
    //   832: dup
    //   833: ldc_w 506
    //   836: invokespecial 133	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   839: aload 6
    //   841: invokevirtual 501	android/telephony/NeighboringCellInfo:getLac	()I
    //   844: invokevirtual 471	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   847: ldc_w 508
    //   850: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   853: aload 6
    //   855: invokevirtual 500	android/telephony/NeighboringCellInfo:getCid	()I
    //   858: invokevirtual 471	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   861: ldc_w 510
    //   864: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   867: aload 7
    //   869: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   872: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   875: invokestatic 513	com/tencent/mm/sdk/platformtools/ad:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   878: aload 4
    //   880: new 8	com/tencent/mm/sdk/platformtools/ay$a
    //   883: dup
    //   884: aload_0
    //   885: aload_3
    //   886: new 127	java/lang/StringBuilder
    //   889: dup
    //   890: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   893: aload 6
    //   895: invokevirtual 501	android/telephony/NeighboringCellInfo:getLac	()I
    //   898: invokevirtual 471	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   901: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   904: new 127	java/lang/StringBuilder
    //   907: dup
    //   908: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   911: aload 6
    //   913: invokevirtual 500	android/telephony/NeighboringCellInfo:getCid	()I
    //   916: invokevirtual 471	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   919: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   922: aload 7
    //   924: ldc_w 491
    //   927: ldc 46
    //   929: ldc 46
    //   931: ldc 46
    //   933: invokespecial 474	com/tencent/mm/sdk/platformtools/ay$a:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   936: invokeinterface 477 2 0
    //   941: pop
    //   942: goto -183 -> 759
    //   945: new 127	java/lang/StringBuilder
    //   948: dup
    //   949: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   952: getstatic 23	com/tencent/mm/sdk/platformtools/ay:nowStrength	I
    //   955: invokevirtual 471	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   958: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   961: astore 5
    //   963: goto -271 -> 692
    //   966: astore 5
    //   968: ldc 125
    //   970: aload 5
    //   972: ldc 46
    //   974: iconst_0
    //   975: anewarray 4	java/lang/Object
    //   978: invokestatic 224	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   981: goto -253 -> 728
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	984	0	paramContext	Context
    //   103	602	1	i	int
    //   383	318	2	j	int
    //   70	816	3	localObject1	Object
    //   54	825	4	localLinkedList	java.util.LinkedList
    //   59	292	5	str1	String
    //   355	1	5	localException1	Exception
    //   365	114	5	localObject2	Object
    //   617	5	5	localException2	Exception
    //   643	319	5	localObject3	Object
    //   966	5	5	localException3	Exception
    //   63	849	6	localObject4	Object
    //   45	878	7	localObject5	Object
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
    //   3	23	611	finally
    //   25	31	611	finally
    //   36	56	611	finally
    //   65	71	611	finally
    //   75	98	611	finally
    //   98	104	611	finally
    //   109	119	611	finally
    //   124	133	611	finally
    //   137	244	611	finally
    //   244	250	611	finally
    //   256	263	611	finally
    //   280	306	611	finally
    //   310	328	611	finally
    //   334	352	611	finally
    //   357	367	611	finally
    //   372	384	611	finally
    //   401	437	611	finally
    //   437	444	611	finally
    //   449	468	611	finally
    //   468	608	611	finally
    //   619	632	611	finally
    //   635	645	611	finally
    //   650	662	611	finally
    //   679	688	611	finally
    //   692	728	611	finally
    //   728	735	611	finally
    //   740	759	611	finally
    //   759	942	611	finally
    //   945	963	611	finally
    //   968	981	611	finally
    //   357	367	617	java/lang/Exception
    //   372	384	617	java/lang/Exception
    //   401	437	617	java/lang/Exception
    //   635	645	966	java/lang/Exception
    //   650	662	966	java/lang/Exception
    //   679	688	966	java/lang/Exception
    //   692	728	966	java/lang/Exception
    //   945	963	966	java/lang/Exception
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
      ad.d("MicroMsg.NetStatusUtil", "is2G subtype %d", new Object[] { Integer.valueOf(paramContext.getSubtype()) });
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
      ad.printErrStackTrace("MicroMsg.NetStatusUtil", paramContext, "", new Object[0]);
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
      ad.d("MicroMsg.NetStatusUtil", "is3G subtype %d", new Object[] { Integer.valueOf(paramContext.getSubtype()) });
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
      ad.printErrStackTrace("MicroMsg.NetStatusUtil", paramContext, "", new Object[0]);
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
      ad.d("MicroMsg.NetStatusUtil", "is4G subtype %d", new Object[] { Integer.valueOf(paramContext.getSubtype()) });
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
      ad.printErrStackTrace("MicroMsg.NetStatusUtil", paramContext, "", new Object[0]);
      AppMethodBeat.o(157742);
    }
    return false;
  }
  
  public static boolean is5G(Context paramContext)
  {
    AppMethodBeat.i(194740);
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramContext == null)
      {
        AppMethodBeat.o(194740);
        return false;
      }
      int i = paramContext.getType();
      if (i == 1)
      {
        AppMethodBeat.o(194740);
        return false;
      }
      ad.d("MicroMsg.NetStatusUtil", "is5G subtype %d", new Object[] { Integer.valueOf(paramContext.getSubtype()) });
      i = paramContext.getSubtype();
      if (i >= 20)
      {
        AppMethodBeat.o(194740);
        return true;
      }
    }
    catch (Exception paramContext)
    {
      ad.printErrStackTrace("MicroMsg.NetStatusUtil", paramContext, "", new Object[0]);
      AppMethodBeat.o(194740);
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
      ad.printErrStackTrace("MicroMsg.NetStatusUtil", paramContext, "", new Object[0]);
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
  
  public static String iv(Context paramContext)
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
      ad.i("MicroMsg.NetStatusUtil", "netstatus " + localStringBuilder.toString());
      paramContext = localStringBuilder.toString();
      AppMethodBeat.o(157730);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        ad.i("MicroMsg.NetStatusUtil", paramContext.getMessage());
        ad.printErrStackTrace("MicroMsg.NetStatusUtil", paramContext, "", new Object[0]);
      }
    }
  }
  
  public static String iw(Context paramContext)
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
  
  public static int ix(Context paramContext)
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
  
  public static int iy(Context paramContext)
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
  
  public static boolean iz(Context paramContext)
  {
    AppMethodBeat.i(194739);
    try
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramContext != null)
      {
        Method localMethod = paramContext.getClass().getMethod("getMobileDataEnabled", new Class[0]);
        localMethod.setAccessible(true);
        boolean bool = ((Boolean)localMethod.invoke(paramContext, new Object[0])).booleanValue();
        AppMethodBeat.o(194739);
        return bool;
      }
    }
    catch (Exception paramContext)
    {
      ad.printErrStackTrace("MicroMsg.NetStatusUtil", paramContext, "", new Object[0]);
      AppMethodBeat.o(194739);
    }
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
        ad.e("MicroMsg.NetStatusUtil", "package  size" + localList.size());
        int i = 0;
        for (;;)
        {
          int j = localList.size();
          if (i >= j) {
            break label418;
          }
          try
          {
            ad.e("MicroMsg.NetStatusUtil", "package " + ((PackageInfo)localList.get(i)).packageName);
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
                  ad.e("MicroMsg.NetStatusUtil", "activityName count ".concat(String.valueOf(j)));
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
                      localObject1 = new com.tencent.mm.hellhoundlib.b.a().bd(localObject2);
                      com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject1).adn(), "com/tencent/mm/sdk/platformtools/NetStatusUtil", "searchIntentByClass", "(Landroid/content/Context;Ljava/lang/String;)Landroid/content/Intent;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                      paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).lS(0));
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
                  ad.printErrStackTrace("MicroMsg.NetStatusUtil", localException1, "", new Object[0]);
                }
              }
            }
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              label380:
              ad.printErrStackTrace("MicroMsg.NetStatusUtil", localException2, "", new Object[0]);
            }
          }
        }
      }
      label418:
      return null;
    }
    catch (Exception paramContext)
    {
      ad.printErrStackTrace("MicroMsg.NetStatusUtil", paramContext, "", new Object[0]);
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
        localObject1 = new com.tencent.mm.hellhoundlib.b.a().bd(localObject1);
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject1).adn(), "com/tencent/mm/sdk/platformtools/NetStatusUtil", "startSettingItent", "(Landroid/content/Context;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).lS(0));
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
          localObject2 = new com.tencent.mm.hellhoundlib.b.a().bd(localObject2);
          com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject2).adn(), "com/tencent/mm/sdk/platformtools/NetStatusUtil", "startSettingItent", "(Landroid/content/Context;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).lS(0));
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
        localObject3 = new com.tencent.mm.hellhoundlib.b.a().bd(localObject3);
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject3).adn(), "com/tencent/mm/sdk/platformtools/NetStatusUtil", "startSettingItent", "(Landroid/content/Context;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject3).lS(0));
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
        localObject4 = new com.tencent.mm.hellhoundlib.b.a().bd(localObject4);
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject4).adn(), "com/tencent/mm/sdk/platformtools/NetStatusUtil", "startSettingItent", "(Landroid/content/Context;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject4).lS(0));
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
    public String Aep;
    public String Aer;
    public String Aes;
    public String Aet;
    public String systemId;
    public String type;
    public String tzr;
    public String tzs;
    public String tzt;
    
    public a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
    {
      this.tzr = paramString1;
      this.tzs = paramString2;
      this.Aep = paramString3;
      this.type = paramString6;
      this.tzt = paramString4;
      this.Aer = paramString7;
      this.Aes = paramString8;
      this.systemId = paramString9;
      this.Aet = paramString5;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.ay
 * JD-Core Version:    0.7.0.1
 */