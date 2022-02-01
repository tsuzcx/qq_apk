package com.tencent.mm.sdk.platformtools;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.ConnectivityManager.NetworkCallback;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.d;
import kotlin.n.n;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/sdk/platformtools/ConnectivityCompat;", "", "()V", "Companion", "MixedSignalStrength", "NetworkCallbackImpl24", "Receiver", "Supervisor", "WiFiInfo", "WiFiScanResult", "libcompatible_release"})
@SuppressLint({"WxSensitiveWifi"})
public final class ConnectivityCompat
{
  public static final Companion Companion;
  public static final int GET_WIFI_SCAN_RESULT_THRESHOLD = 5;
  public static final String INVALID_WIFI_BSSID = "02:00:00:00:00:00";
  public static final String INVALID_WIFI_SSID = "<unknown ssid>";
  public static final String MMKV_CONFIG_NAME = "connectivity_compat";
  public static final String MMKV_KEY_WIFI_BSSID = "connectivity_compat_key_wifi_bssid";
  public static final String MMKV_KEY_WIFI_IPADDR = "connectivity_compat_key_wifi_idaddr";
  public static final String MMKV_KEY_WIFI_NETWORKID = "connectivity_compat_key_wifi_networkid";
  public static final String MMKV_KEY_WIFI_RSSI = "connectivity_compat_key_wifi_rssi";
  public static final String MMKV_KEY_WIFI_SCAN_RESULTS = "connectivity_compat_key_wifi_scan_results";
  public static final String MMKV_KEY_WIFI_SSID = "connectivity_compat_key_wifi_ssid";
  public static final String MMKV_KEY_WIFI_TOUCH_TIME = "connectivity_compat_key_wifi_touch_time";
  private static final long REALTIME_WIFI_INFO_TOUCH_INTERVAL = 60L;
  public static final String TAG = "MicroMsg.ConnectivityCompat";
  private static Receiver connectivityReceiver;
  private static final MixedSignalStrength mixedSignalStrength;
  private static NetworkCallbackImpl24 networkCallbackImpl24;
  private static PhoneStateListener phoneListener;
  private static Supervisor supervisor;
  private static int wifiScanThreshold;
  
  static
  {
    AppMethodBeat.i(263402);
    Companion = new Companion(null);
    mixedSignalStrength = new MixedSignalStrength();
    AppMethodBeat.o(263402);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/sdk/platformtools/ConnectivityCompat$Companion;", "", "()V", "GET_WIFI_SCAN_RESULT_THRESHOLD", "", "INVALID_WIFI_BSSID", "", "INVALID_WIFI_SSID", "MMKV_CONFIG_NAME", "MMKV_KEY_WIFI_BSSID", "MMKV_KEY_WIFI_IPADDR", "MMKV_KEY_WIFI_NETWORKID", "MMKV_KEY_WIFI_RSSI", "MMKV_KEY_WIFI_SCAN_RESULTS", "MMKV_KEY_WIFI_SSID", "MMKV_KEY_WIFI_TOUCH_TIME", "REALTIME_WIFI_INFO_TOUCH_INTERVAL", "", "TAG", "connectivityReceiver", "Lcom/tencent/mm/sdk/platformtools/ConnectivityCompat$Receiver;", "mixedSignalStrength", "Lcom/tencent/mm/sdk/platformtools/ConnectivityCompat$MixedSignalStrength;", "networkCallbackImpl24", "Lcom/tencent/mm/sdk/platformtools/ConnectivityCompat$NetworkCallbackImpl24;", "phoneListener", "Landroid/telephony/PhoneStateListener;", "supervisor", "Lcom/tencent/mm/sdk/platformtools/ConnectivityCompat$Supervisor;", "getSupervisor", "()Lcom/tencent/mm/sdk/platformtools/ConnectivityCompat$Supervisor;", "setSupervisor", "(Lcom/tencent/mm/sdk/platformtools/ConnectivityCompat$Supervisor;)V", "wifiScanThreshold", "acquireWiFiInfo", "Lcom/tencent/mm/sdk/platformtools/ConnectivityCompat$WiFiInfo;", "acquireWiFiInfo27", "gContext", "Landroid/content/Context;", "wm", "Landroid/net/wifi/WifiManager;", "acquireWiFiInfo29", "getCompatMixStrength", "realtime", "", "getFormattedWiFiBssid", "getFormattedWiFiSsid", "getIPStrByInt", "ipInt", "getNetworkId", "getSignalStrength", "getWiFiBssid", "getWiFiIpAddress", "getWiFiRssi", "getWiFiScanResults", "", "Lcom/tencent/mm/sdk/platformtools/ConnectivityCompat$WiFiScanResult;", "getWiFiSsid", "initSignalStrengthListener", "", "registerReceiver", "removeSsidQuote", "ssid", "startScanWiFi", "touchRealtimeWifiInfo", "unregisterReceiver", "libcompatible_release"})
  public static final class Companion
  {
    private byte _hellAccFlag_;
    
    private final ConnectivityCompat.WiFiInfo acquireWiFiInfo()
    {
      AppMethodBeat.i(262370);
      Object localObject1 = new ConnectivityCompat.WiFiInfo();
      Object localObject2 = MMApplicationContext.getContext();
      p.j(localObject2, "gContext");
      Object localObject3 = ((Context)localObject2).getApplicationContext().getSystemService("connectivity");
      if (localObject3 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type android.net.ConnectivityManager");
        AppMethodBeat.o(262370);
        throw ((Throwable)localObject1);
      }
      localObject3 = ((ConnectivityManager)localObject3).getActiveNetworkInfo();
      if ((localObject3 == null) || (!NetStatusUtil.isWifi((NetworkInfo)localObject3)))
      {
        Log.i("MicroMsg.ConnectivityCompat", "not wifi currently, return empty wifi info");
        localObject1 = new ConnectivityCompat.WiFiInfo();
        AppMethodBeat.o(262370);
        return localObject1;
      }
      localObject3 = ((Context)localObject2).getApplicationContext().getSystemService("wifi");
      if (localObject3 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type android.net.wifi.WifiManager");
        AppMethodBeat.o(262370);
        throw ((Throwable)localObject1);
      }
      localObject3 = (WifiManager)localObject3;
      if (Build.VERSION.SDK_INT >= 29)
      {
        localObject1 = ((Companion)this).acquireWiFiInfo29((Context)localObject2, (WifiManager)localObject3);
        AppMethodBeat.o(262370);
        return localObject1;
      }
      if (Build.VERSION.SDK_INT >= 27)
      {
        localObject1 = ((Companion)this).acquireWiFiInfo27((Context)localObject2, (WifiManager)localObject3);
        AppMethodBeat.o(262370);
        return localObject1;
      }
      localObject2 = (WifiInfo)com.tencent.mm.hellhoundlib.a.a.a(localObject3, "com/tencent/mm/sdk/platformtools/ConnectivityCompat$Companion", "acquireWiFiInfo", "()Lcom/tencent/mm/sdk/platformtools/ConnectivityCompat$WiFiInfo;", "android/net/wifi/WifiManager", "getConnectionInfo", "()Landroid/net/wifi/WifiInfo;");
      if (localObject2 != null)
      {
        int i = ((WifiInfo)localObject2).getRssi();
        localObject3 = ((WifiInfo)localObject2).getBSSID();
        String str = ((WifiInfo)localObject2).getSSID();
        p.j(str, "ssid");
        ((ConnectivityCompat.WiFiInfo)localObject1).fill(i, (String)localObject3, str, ((WifiInfo)localObject2).getNetworkId(), ((WifiInfo)localObject2).getIpAddress());
      }
      AppMethodBeat.o(262370);
      return localObject1;
    }
    
    @SuppressLint({"MissingPermission"})
    private final ConnectivityCompat.WiFiInfo acquireWiFiInfo27(Context paramContext, WifiManager paramWifiManager)
    {
      AppMethodBeat.i(262363);
      ConnectivityCompat.WiFiInfo localWiFiInfo = new ConnectivityCompat.WiFiInfo();
      int i;
      Object localObject;
      try
      {
        if ((paramContext.checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0) || (paramContext.checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0))
        {
          paramContext = (WifiInfo)com.tencent.mm.hellhoundlib.a.a.a(paramWifiManager, "com/tencent/mm/sdk/platformtools/ConnectivityCompat$Companion", "acquireWiFiInfo27", "(Landroid/content/Context;Landroid/net/wifi/WifiManager;)Lcom/tencent/mm/sdk/platformtools/ConnectivityCompat$WiFiInfo;", "android/net/wifi/WifiManager", "getConnectionInfo", "()Landroid/net/wifi/WifiInfo;");
          if (paramContext != null)
          {
            i = paramContext.getRssi();
            localObject = paramContext.getBSSID();
            String str = paramContext.getSSID();
            p.j(str, "ssid");
            localWiFiInfo.fill(i, (String)localObject, str, paramContext.getNetworkId(), paramContext.getIpAddress());
          }
        }
        AppMethodBeat.o(262363);
        return localWiFiInfo;
      }
      catch (Throwable paramContext)
      {
        Log.printErrStackTrace("MicroMsg.ConnectivityCompat", paramContext, "get wifi info failed directly", new Object[0]);
      }
      try
      {
        localObject = paramWifiManager.getConfiguredNetworks();
        p.j(localObject, "wm.getConfiguredNetworks()");
        paramContext = (WifiInfo)com.tencent.mm.hellhoundlib.a.a.a(paramWifiManager, "com/tencent/mm/sdk/platformtools/ConnectivityCompat$Companion", "acquireWiFiInfo27", "(Landroid/content/Context;Landroid/net/wifi/WifiManager;)Lcom/tencent/mm/sdk/platformtools/ConnectivityCompat$WiFiInfo;", "android/net/wifi/WifiManager", "getConnectionInfo", "()Landroid/net/wifi/WifiInfo;");
        paramWifiManager = ((List)localObject).iterator();
        while (paramWifiManager.hasNext())
        {
          i = ((WifiConfiguration)paramWifiManager.next()).networkId;
          p.j(paramContext, "connectionInfo");
          if (i == paramContext.getNetworkId())
          {
            i = paramContext.getRssi();
            paramWifiManager = paramContext.getBSSID();
            localObject = paramContext.getSSID();
            p.j(localObject, "connectionInfo.ssid");
            localWiFiInfo.fill(i, paramWifiManager, (String)localObject, paramContext.getNetworkId(), paramContext.getIpAddress());
          }
        }
      }
      catch (Throwable paramContext)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.ConnectivityCompat", paramContext, "get wifi info failed from configurations", new Object[0]);
        }
      }
      AppMethodBeat.o(262363);
      return localWiFiInfo;
    }
    
    private final ConnectivityCompat.WiFiInfo acquireWiFiInfo29(Context paramContext, WifiManager paramWifiManager)
    {
      AppMethodBeat.i(262366);
      if (paramContext.checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0)
      {
        Log.e("MicroMsg.ConnectivityCompat", "acquireWiFiInfo29(): access_fine_location perm not granted.");
        paramContext = new ConnectivityCompat.WiFiInfo();
        AppMethodBeat.o(262366);
        return paramContext;
      }
      paramContext = ((Companion)this).acquireWiFiInfo27(paramContext, paramWifiManager);
      AppMethodBeat.o(262366);
      return paramContext;
    }
    
    private final String getIPStrByInt(int paramInt)
    {
      AppMethodBeat.i(262358);
      String str = String.valueOf(paramInt & 0xFF) + "." + (paramInt >> 8 & 0xFF) + "." + (paramInt >> 16 & 0xFF) + "." + (paramInt >> 24 & 0xFF);
      AppMethodBeat.o(262358);
      return str;
    }
    
    private final String removeSsidQuote(String paramString)
    {
      AppMethodBeat.i(262356);
      if (Util.isNullOrNil(paramString))
      {
        AppMethodBeat.o(262356);
        return "";
      }
      if (p.h(paramString, "<unknown ssid>"))
      {
        AppMethodBeat.o(262356);
        return "";
      }
      if ((n.M(paramString, "\"", false)) && (n.pu(paramString, "\"")))
      {
        int i = paramString.length();
        if (paramString == null)
        {
          paramString = new t("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(262356);
          throw paramString;
        }
        paramString = paramString.substring(1, i - 1);
        p.j(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        AppMethodBeat.o(262356);
        return paramString;
      }
      AppMethodBeat.o(262356);
      return paramString;
    }
    
    private final boolean touchRealtimeWifiInfo()
    {
      AppMethodBeat.i(262375);
      Object localObject = MultiProcessMMKV.getMMKV("connectivity_compat");
      if (Util.secondsToNow(((MultiProcessMMKV)localObject).getLong("connectivity_compat_key_wifi_touch_time", -1L)) > 60L)
      {
        ((MultiProcessMMKV)localObject).putLong("connectivity_compat_key_wifi_touch_time", Util.nowSecond());
        localObject = ConnectivityCompat.Companion.acquireWiFiInfo();
        Log.i("MicroMsg.ConnectivityCompat", "updated new wifi info (via touch realtime info): ".concat(String.valueOf(localObject)));
        ((ConnectivityCompat.WiFiInfo)localObject).saveMMKV();
        if (ConnectivityCompat.Companion.getSupervisor() != null)
        {
          localObject = ConnectivityCompat.Companion.getSupervisor();
          if (localObject == null) {
            p.iCn();
          }
          ((ConnectivityCompat.Supervisor)localObject).report(ConnectivityCompat.Supervisor.API.GET_CONNECTION_INFO, false, true);
        }
        AppMethodBeat.o(262375);
        return true;
      }
      AppMethodBeat.o(262375);
      return false;
    }
    
    public final int getCompatMixStrength()
    {
      AppMethodBeat.i(262296);
      int i = getCompatMixStrength$default(this, false, 1, null);
      AppMethodBeat.o(262296);
      return i;
    }
    
    /* Error */
    public final int getCompatMixStrength(boolean paramBoolean)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: ldc_w 440
      //   5: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   8: invokestatic 116	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
      //   11: invokestatic 443	com/tencent/mm/sdk/platformtools/NetStatusUtil:isWifi	(Landroid/content/Context;)Z
      //   14: ifeq +24 -> 38
      //   17: getstatic 406	com/tencent/mm/sdk/platformtools/ConnectivityCompat:Companion	Lcom/tencent/mm/sdk/platformtools/ConnectivityCompat$Companion;
      //   20: iload_1
      //   21: invokevirtual 331	com/tencent/mm/sdk/platformtools/ConnectivityCompat$Companion:getWiFiRssi	(Z)I
      //   24: invokestatic 449	java/lang/Math:abs	(I)I
      //   27: istore_2
      //   28: ldc_w 440
      //   31: invokestatic 100	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   34: aload_0
      //   35: monitorexit
      //   36: iload_2
      //   37: ireturn
      //   38: invokestatic 453	com/tencent/mm/sdk/platformtools/ConnectivityCompat:access$getPhoneListener$cp	()Landroid/telephony/PhoneStateListener;
      //   41: ifnonnull +11 -> 52
      //   44: ldc 155
      //   46: ldc_w 455
      //   49: invokestatic 278	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   52: invokestatic 459	com/tencent/mm/sdk/platformtools/ConnectivityCompat:access$getMixedSignalStrength$cp	()Lcom/tencent/mm/sdk/platformtools/ConnectivityCompat$MixedSignalStrength;
      //   55: invokevirtual 464	com/tencent/mm/sdk/platformtools/ConnectivityCompat$MixedSignalStrength:nowStrength	()I
      //   58: invokestatic 449	java/lang/Math:abs	(I)I
      //   61: istore_2
      //   62: ldc_w 440
      //   65: invokestatic 100	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   68: goto -34 -> 34
      //   71: astore_3
      //   72: ldc 155
      //   74: aload_3
      //   75: checkcast 221	java/lang/Throwable
      //   78: ldc_w 344
      //   81: iconst_0
      //   82: anewarray 4	java/lang/Object
      //   85: invokestatic 238	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   88: ldc_w 440
      //   91: invokestatic 100	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   94: iconst_0
      //   95: istore_2
      //   96: goto -62 -> 34
      //   99: astore_3
      //   100: aload_0
      //   101: monitorexit
      //   102: aload_3
      //   103: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	104	0	this	Companion
      //   0	104	1	paramBoolean	boolean
      //   27	69	2	i	int
      //   71	4	3	localException	Exception
      //   99	4	3	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   8	34	71	java/lang/Exception
      //   38	52	71	java/lang/Exception
      //   52	68	71	java/lang/Exception
      //   2	8	99	finally
      //   8	34	99	finally
      //   38	52	99	finally
      //   52	68	99	finally
      //   72	94	99	finally
    }
    
    public final String getFormattedWiFiBssid()
    {
      AppMethodBeat.i(262345);
      String str = getFormattedWiFiBssid$default(this, false, 1, null);
      AppMethodBeat.o(262345);
      return str;
    }
    
    public final String getFormattedWiFiBssid(boolean paramBoolean)
    {
      AppMethodBeat.i(262340);
      Object localObject = ((Companion)this).getWiFiBssid(paramBoolean);
      if (p.h(localObject, "02:00:00:00:00:00"))
      {
        AppMethodBeat.o(262340);
        return "";
      }
      Locale localLocale = Locale.ENGLISH;
      p.j(localLocale, "Locale.ENGLISH");
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(262340);
        throw ((Throwable)localObject);
      }
      localObject = ((String)localObject).toLowerCase(localLocale);
      p.j(localObject, "(this as java.lang.String).toLowerCase(locale)");
      AppMethodBeat.o(262340);
      return localObject;
    }
    
    public final String getFormattedWiFiSsid()
    {
      AppMethodBeat.i(262353);
      String str = getFormattedWiFiSsid$default(this, false, 1, null);
      AppMethodBeat.o(262353);
      return str;
    }
    
    public final String getFormattedWiFiSsid(boolean paramBoolean)
    {
      AppMethodBeat.i(262347);
      String str = ((Companion)this).removeSsidQuote(((Companion)this).getWiFiSsid(paramBoolean));
      AppMethodBeat.o(262347);
      return str;
    }
    
    public final int getNetworkId()
    {
      AppMethodBeat.i(262339);
      int i = getNetworkId$default(this, false, 1, null);
      AppMethodBeat.o(262339);
      return i;
    }
    
    public final int getNetworkId(boolean paramBoolean)
    {
      AppMethodBeat.i(262335);
      int i = MultiProcessMMKV.getMMKV("connectivity_compat").getInt("connectivity_compat_key_wifi_networkid", -1);
      if ((!paramBoolean) && (((Companion)this).getSupervisor() == null))
      {
        AppMethodBeat.o(262335);
        return i;
      }
      int j = ((Companion)this).acquireWiFiInfo().getNetworkId();
      ConnectivityCompat.Supervisor localSupervisor;
      ConnectivityCompat.Supervisor.API localAPI;
      if (((Companion)this).getSupervisor() != null)
      {
        if (i == j) {
          break label152;
        }
        Log.w("MicroMsg.ConnectivityCompat", "check_consistence(networkId), cached: %d, realtime: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
        localSupervisor = ((Companion)this).getSupervisor();
        if (localSupervisor == null) {
          p.iCn();
        }
        localAPI = ConnectivityCompat.Supervisor.API.GET_CONNECTION_INFO;
        if ((i == j) || (paramBoolean)) {
          break label181;
        }
      }
      label152:
      label181:
      for (boolean bool = true;; bool = false)
      {
        localSupervisor.report(localAPI, bool, paramBoolean);
        if (!paramBoolean) {
          break label187;
        }
        AppMethodBeat.o(262335);
        return j;
        Log.d("MicroMsg.ConnectivityCompat", "check_consistence(networkId), cached: %d, realtime: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
        break;
      }
      label187:
      AppMethodBeat.o(262335);
      return i;
    }
    
    public final ConnectivityCompat.MixedSignalStrength getSignalStrength()
    {
      AppMethodBeat.i(262291);
      ConnectivityCompat.MixedSignalStrength localMixedSignalStrength = ConnectivityCompat.access$getMixedSignalStrength$cp();
      AppMethodBeat.o(262291);
      return localMixedSignalStrength;
    }
    
    public final ConnectivityCompat.Supervisor getSupervisor()
    {
      AppMethodBeat.i(262281);
      ConnectivityCompat.Supervisor localSupervisor = ConnectivityCompat.access$getSupervisor$cp();
      AppMethodBeat.o(262281);
      return localSupervisor;
    }
    
    public final String getWiFiBssid()
    {
      AppMethodBeat.i(262321);
      String str = getWiFiBssid$default(this, false, 1, null);
      AppMethodBeat.o(262321);
      return str;
    }
    
    public final String getWiFiBssid(boolean paramBoolean)
    {
      AppMethodBeat.i(262318);
      String str2 = MultiProcessMMKV.getMMKV("connectivity_compat").getString("connectivity_compat_key_wifi_bssid", "02:00:00:00:00:00");
      if (str2 == null) {
        p.iCn();
      }
      p.j(str2, "MultiProcessMMKV.getMMKV…ID, INVALID_WIFI_BSSID)!!");
      String str1 = str2;
      if (p.h(str2, "02:00:00:00:00:00"))
      {
        str1 = str2;
        if (((Companion)this).touchRealtimeWifiInfo())
        {
          str2 = MultiProcessMMKV.getMMKV("connectivity_compat").getString("connectivity_compat_key_wifi_bssid", "02:00:00:00:00:00");
          str1 = str2;
          if (str2 == null)
          {
            p.iCn();
            str1 = str2;
          }
        }
      }
      if ((!paramBoolean) && (((Companion)this).getSupervisor() == null))
      {
        AppMethodBeat.o(262318);
        return str1;
      }
      str2 = ((Companion)this).acquireWiFiInfo().getBssid();
      ConnectivityCompat.Supervisor localSupervisor;
      ConnectivityCompat.Supervisor.API localAPI;
      if (((Companion)this).getSupervisor() != null)
      {
        if (!(p.h(str1, str2) ^ true)) {
          break label243;
        }
        Log.w("MicroMsg.ConnectivityCompat", "check_consistence(bssid), cached: %s, realtime: %s, stack: %s", new Object[] { str1, str2, MMStack.getStack(true) });
        localSupervisor = ((Companion)this).getSupervisor();
        if (localSupervisor == null) {
          p.iCn();
        }
        localAPI = ConnectivityCompat.Supervisor.API.GET_CONNECTION_INFO;
        if ((!(p.h(str1, str2) ^ true)) || (paramBoolean)) {
          break label274;
        }
      }
      label274:
      for (boolean bool = true;; bool = false)
      {
        localSupervisor.report(localAPI, bool, paramBoolean);
        if (!paramBoolean) {
          break label279;
        }
        AppMethodBeat.o(262318);
        return str2;
        label243:
        Log.d("MicroMsg.ConnectivityCompat", "check_consistence(bssid), cached: %s, realtime: %s, stack: %s", new Object[] { str1, str2, MMStack.getStack(true) });
        break;
      }
      label279:
      AppMethodBeat.o(262318);
      return str1;
    }
    
    public final int getWiFiIpAddress()
    {
      AppMethodBeat.i(262329);
      int i = getWiFiIpAddress$default(this, false, 1, null);
      AppMethodBeat.o(262329);
      return i;
    }
    
    public final int getWiFiIpAddress(boolean paramBoolean)
    {
      AppMethodBeat.i(262324);
      int i = MultiProcessMMKV.getMMKV("connectivity_compat").getInt("connectivity_compat_key_wifi_idaddr", 0);
      if ((!paramBoolean) && (((Companion)this).getSupervisor() == null))
      {
        AppMethodBeat.o(262324);
        return i;
      }
      int j = ((Companion)this).acquireWiFiInfo().getIpaddr();
      ConnectivityCompat.Supervisor localSupervisor;
      ConnectivityCompat.Supervisor.API localAPI;
      if (((Companion)this).getSupervisor() != null)
      {
        if (i == j) {
          break label167;
        }
        Log.w("MicroMsg.ConnectivityCompat", "check_consistence(ipaddr), cached: %s, realtime: %s, stack: %s", new Object[] { ((Companion)this).getIPStrByInt(i), ((Companion)this).getIPStrByInt(j), MMStack.getStack(true) });
        localSupervisor = ((Companion)this).getSupervisor();
        if (localSupervisor == null) {
          p.iCn();
        }
        localAPI = ConnectivityCompat.Supervisor.API.GET_CONNECTION_INFO;
        if ((i == j) || (paramBoolean)) {
          break label211;
        }
      }
      label167:
      label211:
      for (boolean bool = true;; bool = false)
      {
        localSupervisor.report(localAPI, bool, paramBoolean);
        if (!paramBoolean) {
          break label217;
        }
        AppMethodBeat.o(262324);
        return j;
        Log.d("MicroMsg.ConnectivityCompat", "check_consistence(ipaddr), cached: %s, realtime: %s, stack: %s", new Object[] { ((Companion)this).getIPStrByInt(i), ((Companion)this).getIPStrByInt(j), MMStack.getStack(true) });
        break;
      }
      label217:
      AppMethodBeat.o(262324);
      return i;
    }
    
    public final int getWiFiRssi()
    {
      AppMethodBeat.i(262304);
      int i = getWiFiRssi$default(this, false, 1, null);
      AppMethodBeat.o(262304);
      return i;
    }
    
    public final int getWiFiRssi(boolean paramBoolean)
    {
      AppMethodBeat.i(262300);
      int k = MultiProcessMMKV.getMMKV("connectivity_compat").getInt("connectivity_compat_key_wifi_rssi", 0);
      if ((!paramBoolean) && (((Companion)this).getSupervisor() == null))
      {
        AppMethodBeat.o(262300);
        return k;
      }
      int m = ((Companion)this).acquireWiFiInfo().getRssi();
      int i;
      int j;
      label90:
      ConnectivityCompat.Supervisor localSupervisor;
      label143:
      ConnectivityCompat.Supervisor.API localAPI;
      if (((Companion)this).getSupervisor() != null)
      {
        if (m <= k + 8) {
          break label227;
        }
        i = 1;
        if (m >= k - 8) {
          break label232;
        }
        j = 1;
        if ((j | i) == 0) {
          break label237;
        }
        Log.w("MicroMsg.ConnectivityCompat", "check_consistence(rssi), cached: " + k + ", realtime: " + m + ", stack: " + MMStack.getStack(true));
        localSupervisor = ((Companion)this).getSupervisor();
        if (localSupervisor == null) {
          p.iCn();
        }
        localAPI = ConnectivityCompat.Supervisor.API.GET_CONNECTION_INFO;
        if (m <= k + 8) {
          break label287;
        }
        i = 1;
        label177:
        if (m >= k - 8) {
          break label292;
        }
        j = 1;
        label189:
        if (((j | i) == 0) || (paramBoolean)) {
          break label297;
        }
      }
      label287:
      label292:
      label297:
      for (boolean bool = true;; bool = false)
      {
        localSupervisor.report(localAPI, bool, paramBoolean);
        if (!paramBoolean) {
          break label303;
        }
        AppMethodBeat.o(262300);
        return m;
        label227:
        i = 0;
        break;
        label232:
        j = 0;
        break label90;
        label237:
        Log.d("MicroMsg.ConnectivityCompat", "check_consistence(rssi), cached: " + k + ", realtime: " + m + ", stack: " + MMStack.getStack(true));
        break label143;
        i = 0;
        break label177;
        j = 0;
        break label189;
      }
      label303:
      AppMethodBeat.o(262300);
      return k;
    }
    
    public final List<ConnectivityCompat.WiFiScanResult> getWiFiScanResults()
    {
      AppMethodBeat.i(262333);
      Log.w("MicroMsg.ConnectivityCompat", "getWiFiScanResults(), stack: %s", new Object[] { MMStack.getStack(true) });
      Object localObject1 = new LinkedList();
      Object localObject2 = MultiProcessMMKV.getMMKV("connectivity_compat").getStringSet("connectivity_compat_key_wifi_scan_results", (Set)new HashSet());
      if (localObject2 == null) {
        p.iCn();
      }
      p.j(localObject2, "MultiProcessMMKV.getMMKV…LTS, HashSet<String>())!!");
      localObject2 = ((Iterable)localObject2).iterator();
      Object localObject3;
      Object localObject5;
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (String)((Iterator)localObject2).next();
        localObject5 = new ConnectivityCompat.WiFiScanResult();
        p.j(localObject3, "it");
        if (((ConnectivityCompat.WiFiScanResult)localObject5).fromStr((String)localObject3)) {
          ((LinkedList)localObject1).add(localObject5);
        }
      }
      Object localObject4;
      if (((Companion)this).getSupervisor() != null)
      {
        localObject2 = new LinkedList();
        try
        {
          localObject3 = MMApplicationContext.getContext();
          p.j(localObject3, "MMApplicationContext.getContext()");
          localObject3 = ((Context)localObject3).getApplicationContext().getSystemService("wifi");
          if (localObject3 != null) {
            break label277;
          }
          localObject3 = new t("null cannot be cast to non-null type android.net.wifi.WifiManager");
          AppMethodBeat.o(262333);
          throw ((Throwable)localObject3);
        }
        catch (Throwable localThrowable) {}
        localObject4 = ((Companion)this).getSupervisor();
        if (localObject4 == null) {
          p.iCn();
        }
        localObject5 = ConnectivityCompat.Supervisor.API.GET_SCAN_RESULTS;
        if ((!((LinkedList)localObject1).containsAll((Collection)localObject2)) || (!((LinkedList)localObject2).containsAll((Collection)localObject1))) {
          break label421;
        }
      }
      label277:
      label421:
      for (boolean bool = true;; bool = false)
      {
        ((ConnectivityCompat.Supervisor)localObject4).report((ConnectivityCompat.Supervisor.API)localObject5, bool, false);
        localObject1 = (List)localObject1;
        AppMethodBeat.o(262333);
        return localObject1;
        localObject4 = (List)com.tencent.mm.hellhoundlib.a.a.a((WifiManager)localObject4, "com/tencent/mm/sdk/platformtools/ConnectivityCompat$Companion", "getWiFiScanResults", "()Ljava/util/List;", "android/net/wifi/WifiManager", "getScanResults", "()Ljava/util/List;");
        p.j(localObject4, "wm.scanResults");
        localObject4 = ((Iterable)localObject4).iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = (ScanResult)((Iterator)localObject4).next();
          ConnectivityCompat.WiFiScanResult localWiFiScanResult = new ConnectivityCompat.WiFiScanResult();
          String str = ((ScanResult)localObject5).SSID;
          p.j(str, "it.SSID");
          localWiFiScanResult.setSsid(str);
          str = ((ScanResult)localObject5).BSSID;
          p.j(str, "it.BSSID");
          localWiFiScanResult.setBssid(str);
          localWiFiScanResult.setLevel(((ScanResult)localObject5).level);
          ((LinkedList)localObject2).add(localWiFiScanResult);
        }
        break;
      }
    }
    
    public final String getWiFiSsid()
    {
      AppMethodBeat.i(262315);
      String str = getWiFiSsid$default(this, false, 1, null);
      AppMethodBeat.o(262315);
      return str;
    }
    
    public final String getWiFiSsid(boolean paramBoolean)
    {
      AppMethodBeat.i(262308);
      String str2 = MultiProcessMMKV.getMMKV("connectivity_compat").getString("connectivity_compat_key_wifi_ssid", "<unknown ssid>");
      if (str2 == null) {
        p.iCn();
      }
      p.j(str2, "MultiProcessMMKV.getMMKV…SID, INVALID_WIFI_SSID)!!");
      String str1 = str2;
      if (p.h(str2, "<unknown ssid>"))
      {
        str1 = str2;
        if (((Companion)this).touchRealtimeWifiInfo())
        {
          str2 = MultiProcessMMKV.getMMKV("connectivity_compat").getString("connectivity_compat_key_wifi_ssid", "<unknown ssid>");
          str1 = str2;
          if (str2 == null)
          {
            p.iCn();
            str1 = str2;
          }
        }
      }
      if ((!paramBoolean) && (((Companion)this).getSupervisor() == null))
      {
        AppMethodBeat.o(262308);
        return str1;
      }
      str2 = ((Companion)this).acquireWiFiInfo().getSsid();
      ConnectivityCompat.Supervisor localSupervisor;
      ConnectivityCompat.Supervisor.API localAPI;
      if (((Companion)this).getSupervisor() != null)
      {
        if (!(p.h(str1, str2) ^ true)) {
          break label261;
        }
        Log.w("MicroMsg.ConnectivityCompat", "check_consistence(ssid), cached: " + str1 + ", realtime: " + str2 + ", stack: " + MMStack.getStack(true));
        localSupervisor = ((Companion)this).getSupervisor();
        if (localSupervisor == null) {
          p.iCn();
        }
        localAPI = ConnectivityCompat.Supervisor.API.GET_CONNECTION_INFO;
        if ((!(p.h(str1, str2) ^ true)) || (paramBoolean)) {
          break label310;
        }
      }
      label261:
      label310:
      for (boolean bool = true;; bool = false)
      {
        localSupervisor.report(localAPI, bool, paramBoolean);
        if (!paramBoolean) {
          break label315;
        }
        AppMethodBeat.o(262308);
        return str2;
        Log.d("MicroMsg.ConnectivityCompat", "check_consistence(ssid), cached: " + str1 + ", realtime: " + str2 + ", stack: " + MMStack.getStack(true));
        break;
      }
      label315:
      AppMethodBeat.o(262308);
      return str1;
    }
    
    public final void initSignalStrengthListener()
    {
      AppMethodBeat.i(262290);
      if (ConnectivityCompat.access$getPhoneListener$cp() == null)
      {
        Object localObject1 = MMApplicationContext.getContext().getSystemService("phone");
        if (localObject1 == null)
        {
          localObject1 = new t("null cannot be cast to non-null type android.telephony.TelephonyManager");
          AppMethodBeat.o(262290);
          throw ((Throwable)localObject1);
        }
        localObject1 = (TelephonyManager)localObject1;
        ConnectivityCompat.access$setPhoneListener$cp((PhoneStateListener)new PhoneStateListener()
        {
          public final void onSignalStrengthsChanged(SignalStrength paramAnonymousSignalStrength)
          {
            AppMethodBeat.i(262718);
            p.k(paramAnonymousSignalStrength, "signalStrength");
            super.onSignalStrengthsChanged(paramAnonymousSignalStrength);
            ConnectivityCompat.access$getMixedSignalStrength$cp().setPhoneType(this.$phoneType);
            switch (ConnectivityCompat.access$getMixedSignalStrength$cp().getPhoneType())
            {
            }
            for (;;)
            {
              AppMethodBeat.o(262718);
              return;
              ConnectivityCompat.access$getMixedSignalStrength$cp().setCdmaDbm(paramAnonymousSignalStrength.getCdmaDbm());
              AppMethodBeat.o(262718);
              return;
              ConnectivityCompat.access$getMixedSignalStrength$cp().setGsmSignalStrength(paramAnonymousSignalStrength.getGsmSignalStrength());
            }
          }
        });
        Object localObject2 = ConnectivityCompat.access$getPhoneListener$cp();
        localObject2 = c.a(256, new com.tencent.mm.hellhoundlib.b.a()).bm(localObject2);
        com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aFh(), "com/tencent/mm/sdk/platformtools/ConnectivityCompat$Companion", "initSignalStrengthListener", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
        ((TelephonyManager)localObject1).listen((PhoneStateListener)((com.tencent.mm.hellhoundlib.b.a)localObject2).sf(0), ((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).sf(1)).intValue());
        com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/sdk/platformtools/ConnectivityCompat$Companion", "initSignalStrengthListener", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
      }
      AppMethodBeat.o(262290);
    }
    
    public final void registerReceiver()
    {
      AppMethodBeat.i(262285);
      Object localObject;
      if (Build.VERSION.SDK_INT >= 24)
      {
        ConnectivityCompat.access$setNetworkCallbackImpl24$cp(new ConnectivityCompat.NetworkCallbackImpl24());
        localObject = MMApplicationContext.getContext().getSystemService("connectivity");
        if (localObject == null)
        {
          localObject = new t("null cannot be cast to non-null type android.net.ConnectivityManager");
          AppMethodBeat.o(262285);
          throw ((Throwable)localObject);
        }
        localObject = (ConnectivityManager)localObject;
        ConnectivityCompat.NetworkCallbackImpl24 localNetworkCallbackImpl24 = ConnectivityCompat.access$getNetworkCallbackImpl24$cp();
        if (localNetworkCallbackImpl24 == null) {
          p.iCn();
        }
        ((ConnectivityManager)localObject).registerDefaultNetworkCallback((ConnectivityManager.NetworkCallback)localNetworkCallbackImpl24);
      }
      if (ConnectivityCompat.access$getConnectivityReceiver$cp() == null)
      {
        ConnectivityCompat.access$setConnectivityReceiver$cp(new ConnectivityCompat.Receiver());
        localObject = new IntentFilter();
        ((IntentFilter)localObject).addAction("android.net.wifi.SCAN_RESULTS");
        ((IntentFilter)localObject).addAction("android.net.wifi.RSSI_CHANGED");
        if (Build.VERSION.SDK_INT < 24) {
          ((IntentFilter)localObject).addAction("android.net.conn.CONNECTIVITY_CHANGE");
        }
        MMApplicationContext.getContext().registerReceiver((BroadcastReceiver)ConnectivityCompat.access$getConnectivityReceiver$cp(), (IntentFilter)localObject);
      }
      for (;;)
      {
        localObject = ((Companion)this).acquireWiFiInfo();
        Log.i("MicroMsg.ConnectivityCompat", "initialized new wifi info %s", new Object[] { ((ConnectivityCompat.WiFiInfo)localObject).toString() });
        ((ConnectivityCompat.WiFiInfo)localObject).saveMMKV();
        AppMethodBeat.o(262285);
        return;
        Log.w("MicroMsg.ConnectivityCompat", "connectivity compat receiver has been registered, check " + MMStack.getCaller());
      }
    }
    
    public final void setSupervisor(ConnectivityCompat.Supervisor paramSupervisor)
    {
      AppMethodBeat.i(262283);
      ConnectivityCompat.access$setSupervisor$cp(paramSupervisor);
      AppMethodBeat.o(262283);
    }
    
    public final void startScanWiFi()
    {
      AppMethodBeat.i(262330);
      Log.w("MicroMsg.ConnectivityCompat", "startScanWiFi(), threshold = " + ConnectivityCompat.access$getWifiScanThreshold$cp() + "/5, stack: %s", new Object[] { MMStack.getStack(true) });
      ConnectivityCompat.access$setWifiScanThreshold$cp(5);
      Object localObject = MMApplicationContext.getContext();
      if (((Context)localObject).checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0)
      {
        Log.e("MicroMsg.ConnectivityCompat", "startScanWiFi(): access_fine_location perm not granted.");
        AppMethodBeat.o(262330);
        return;
      }
      p.j(localObject, "gContext");
      localObject = ((Context)localObject).getApplicationContext().getSystemService("wifi");
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type android.net.wifi.WifiManager");
        AppMethodBeat.o(262330);
        throw ((Throwable)localObject);
      }
      ((Boolean)com.tencent.mm.hellhoundlib.a.a.a((WifiManager)localObject, "com/tencent/mm/sdk/platformtools/ConnectivityCompat$Companion", "startScanWiFi", "()V", "android/net/wifi/WifiManager", "startScan", "()Z")).booleanValue();
      localObject = ((Companion)this).getSupervisor();
      if (localObject != null)
      {
        ((ConnectivityCompat.Supervisor)localObject).report(ConnectivityCompat.Supervisor.API.START_SCAN_WIFI, false, true);
        AppMethodBeat.o(262330);
        return;
      }
      AppMethodBeat.o(262330);
    }
    
    public final void unregisterReceiver()
    {
      AppMethodBeat.i(262288);
      Object localObject = ConnectivityCompat.access$getConnectivityReceiver$cp();
      if (localObject != null)
      {
        MMApplicationContext.getContext().unregisterReceiver((BroadcastReceiver)localObject);
        Log.i("MicroMsg.ConnectivityCompat", "unregister connectivity receiver");
      }
      if (ConnectivityCompat.access$getNetworkCallbackImpl24$cp() != null)
      {
        localObject = MMApplicationContext.getContext().getSystemService("connectivity");
        if (localObject == null)
        {
          localObject = new t("null cannot be cast to non-null type android.net.ConnectivityManager");
          AppMethodBeat.o(262288);
          throw ((Throwable)localObject);
        }
        localObject = (ConnectivityManager)localObject;
        ConnectivityCompat.NetworkCallbackImpl24 localNetworkCallbackImpl24 = ConnectivityCompat.access$getNetworkCallbackImpl24$cp();
        if (localNetworkCallbackImpl24 == null) {
          p.iCn();
        }
        ((ConnectivityManager)localObject).unregisterNetworkCallback((ConnectivityManager.NetworkCallback)localNetworkCallbackImpl24);
        Log.i("MicroMsg.ConnectivityCompat", "unregister network callback(api >= 24)");
      }
      AppMethodBeat.o(262288);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/sdk/platformtools/ConnectivityCompat$MixedSignalStrength;", "", "()V", "cdmaDbm", "", "getCdmaDbm", "()I", "setCdmaDbm", "(I)V", "gsmSignalStrength", "getGsmSignalStrength", "setGsmSignalStrength", "phoneType", "getPhoneType", "setPhoneType", "isGsm", "", "nowStrength", "libcompatible_release"})
  public static final class MixedSignalStrength
  {
    private int cdmaDbm;
    private int gsmSignalStrength = 99;
    private int phoneType;
    
    public final int getCdmaDbm()
    {
      return this.cdmaDbm;
    }
    
    public final int getGsmSignalStrength()
    {
      return this.gsmSignalStrength;
    }
    
    public final int getPhoneType()
    {
      return this.phoneType;
    }
    
    public final boolean isGsm()
    {
      return this.phoneType == 1;
    }
    
    public final int nowStrength()
    {
      AppMethodBeat.i(263386);
      if (isGsm()) {}
      for (int i = this.cdmaDbm;; i = this.gsmSignalStrength * 2 - 113)
      {
        i = Math.abs(i);
        AppMethodBeat.o(263386);
        return i;
      }
    }
    
    public final void setCdmaDbm(int paramInt)
    {
      this.cdmaDbm = paramInt;
    }
    
    public final void setGsmSignalStrength(int paramInt)
    {
      this.gsmSignalStrength = paramInt;
    }
    
    public final void setPhoneType(int paramInt)
    {
      this.phoneType = paramInt;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/sdk/platformtools/ConnectivityCompat$NetworkCallbackImpl24;", "Landroid/net/ConnectivityManager$NetworkCallback;", "()V", "onAvailable", "", "network", "Landroid/net/Network;", "libcompatible_release"})
  public static final class NetworkCallbackImpl24
    extends ConnectivityManager.NetworkCallback
  {
    public final void onAvailable(Network paramNetwork)
    {
      AppMethodBeat.i(262767);
      p.k(paramNetwork, "network");
      Log.i("MicroMsg.ConnectivityCompat", "network available (from network callback)");
      paramNetwork = ConnectivityCompat.Companion.access$acquireWiFiInfo(ConnectivityCompat.Companion);
      Log.i("MicroMsg.ConnectivityCompat", "updated new wifi info (api >= 24): ".concat(String.valueOf(paramNetwork)));
      paramNetwork.saveMMKV();
      if (ConnectivityCompat.Companion.getSupervisor() != null)
      {
        paramNetwork = ConnectivityCompat.Companion.getSupervisor();
        if (paramNetwork == null) {
          p.iCn();
        }
        paramNetwork.report(ConnectivityCompat.Supervisor.API.GET_CONNECTION_INFO, false, true);
      }
      AppMethodBeat.o(262767);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/sdk/platformtools/ConnectivityCompat$Receiver;", "Landroid/content/BroadcastReceiver;", "()V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "libcompatible_release"})
  public static final class Receiver
    extends BroadcastReceiver
  {
    public final void onReceive(Context paramContext, Intent paramIntent)
    {
      AppMethodBeat.i(263428);
      if (paramIntent != null) {}
      for (Object localObject = paramIntent.getAction(); localObject == null; localObject = null)
      {
        AppMethodBeat.o(263428);
        return;
      }
      switch (((String)localObject).hashCode())
      {
      }
      for (;;)
      {
        AppMethodBeat.o(263428);
        return;
        if (((String)localObject).equals("android.net.wifi.RSSI_CHANGED"))
        {
          int i = paramIntent.getIntExtra("newRssi", 0);
          MultiProcessMMKV.getMMKV("connectivity_compat").putInt("connectivity_compat_key_wifi_rssi", i);
          AppMethodBeat.o(263428);
          return;
          if (((String)localObject).equals("android.net.wifi.SCAN_RESULTS"))
          {
            if (ConnectivityCompat.access$getWifiScanThreshold$cp() > 0) {
              break;
            }
            AppMethodBeat.o(263428);
            return;
            if (((String)localObject).equals("android.net.conn.CONNECTIVITY_CHANGE"))
            {
              Log.i("MicroMsg.ConnectivityCompat", "connectivity action updated");
              paramContext = ConnectivityCompat.Companion.access$acquireWiFiInfo(ConnectivityCompat.Companion);
              Log.i("MicroMsg.ConnectivityCompat", "updated new wifi info (api < 24): ".concat(String.valueOf(paramContext)));
              paramContext.saveMMKV();
              if (ConnectivityCompat.Companion.getSupervisor() != null)
              {
                paramContext = ConnectivityCompat.Companion.getSupervisor();
                if (paramContext == null) {
                  p.iCn();
                }
                paramContext.report(ConnectivityCompat.Supervisor.API.GET_CONNECTION_INFO, false, true);
              }
            }
          }
        }
      }
      ConnectivityCompat.access$setWifiScanThreshold$cp(ConnectivityCompat.access$getWifiScanThreshold$cp() - 1);
      Log.i("MicroMsg.ConnectivityCompat", "process wifi scan results action broadcast, threshold = " + ConnectivityCompat.access$getWifiScanThreshold$cp() + "/5");
      paramIntent = new HashSet();
      if (paramContext != null) {}
      try
      {
        if ((paramContext.checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0) || ((paramContext != null) && (paramContext.checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0)))
        {
          paramContext = MMApplicationContext.getContext();
          p.j(paramContext, "MMApplicationContext.getContext()");
          paramContext = paramContext.getApplicationContext().getSystemService("wifi");
          if (paramContext != null) {
            break label382;
          }
          paramContext = new t("null cannot be cast to non-null type android.net.wifi.WifiManager");
          AppMethodBeat.o(263428);
          throw paramContext;
        }
      }
      catch (Exception paramContext) {}
      for (;;)
      {
        MultiProcessMMKV.getMMKV("connectivity_compat").putStringSet("connectivity_compat_key_wifi_scan_results", (Set)paramIntent);
        if (ConnectivityCompat.Companion.getSupervisor() == null) {
          break;
        }
        paramContext = ConnectivityCompat.Companion.getSupervisor();
        if (paramContext == null) {
          p.iCn();
        }
        paramContext.report(ConnectivityCompat.Supervisor.API.GET_SCAN_RESULTS, false, true);
        AppMethodBeat.o(263428);
        return;
        label382:
        paramContext = (List)com.tencent.mm.hellhoundlib.a.a.a((WifiManager)paramContext, "com/tencent/mm/sdk/platformtools/ConnectivityCompat$Receiver", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "android/net/wifi/WifiManager", "getScanResults", "()Ljava/util/List;");
        if (paramContext != null)
        {
          paramContext = ((Iterable)paramContext).iterator();
          while (paramContext.hasNext())
          {
            localObject = (ScanResult)paramContext.next();
            ConnectivityCompat.WiFiScanResult localWiFiScanResult = new ConnectivityCompat.WiFiScanResult();
            String str = ((ScanResult)localObject).SSID;
            p.j(str, "it.SSID");
            localWiFiScanResult.setSsid(str);
            str = ((ScanResult)localObject).BSSID;
            p.j(str, "it.BSSID");
            localWiFiScanResult.setBssid(str);
            localWiFiScanResult.setLevel(((ScanResult)localObject).level);
            paramIntent.add(localWiFiScanResult.toStr());
          }
        }
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/sdk/platformtools/ConnectivityCompat$Supervisor;", "", "report", "", "api", "Lcom/tencent/mm/sdk/platformtools/ConnectivityCompat$Supervisor$API;", "diff", "", "realtime", "API", "libcompatible_release"})
  public static abstract interface Supervisor
  {
    public abstract void report(API paramAPI, boolean paramBoolean1, boolean paramBoolean2);
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/sdk/platformtools/ConnectivityCompat$Supervisor$API;", "", "text", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getText", "()Ljava/lang/String;", "GET_CONNECTION_INFO", "GET_CONFIGURED_NETWORKS", "GET_SCAN_RESULTS", "START_SCAN_WIFI", "libcompatible_release"})
    public static enum API
    {
      private final String text;
      
      static
      {
        AppMethodBeat.i(263304);
        API localAPI1 = new API("GET_CONNECTION_INFO", 0, "WifiManager#getConnectionInfo");
        GET_CONNECTION_INFO = localAPI1;
        API localAPI2 = new API("GET_CONFIGURED_NETWORKS", 1, "WifiManager#getConfiguredNetworks");
        GET_CONFIGURED_NETWORKS = localAPI2;
        API localAPI3 = new API("GET_SCAN_RESULTS", 2, "WifiManager#getScanResults");
        GET_SCAN_RESULTS = localAPI3;
        API localAPI4 = new API("START_SCAN_WIFI", 3, "WifiManager#startScan");
        START_SCAN_WIFI = localAPI4;
        $VALUES = new API[] { localAPI1, localAPI2, localAPI3, localAPI4 };
        AppMethodBeat.o(263304);
      }
      
      private API(String paramString)
      {
        this.text = paramString;
      }
      
      public final String getText()
      {
        return this.text;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/sdk/platformtools/ConnectivityCompat$WiFiInfo;", "", "()V", "bssid", "", "getBssid", "()Ljava/lang/String;", "setBssid", "(Ljava/lang/String;)V", "ipaddr", "", "getIpaddr", "()I", "setIpaddr", "(I)V", "networkId", "getNetworkId", "setNetworkId", "rssi", "getRssi", "setRssi", "ssid", "getSsid", "setSsid", "fill", "", "saveMMKV", "toString", "libcompatible_release"})
  public static final class WiFiInfo
  {
    private String bssid = "02:00:00:00:00:00";
    private int ipaddr;
    private int networkId;
    private int rssi;
    private String ssid = "<unknown ssid>";
    
    public final void fill(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(262862);
      p.k(paramString2, "ssid");
      this.rssi = paramInt1;
      String str = paramString1;
      if (paramString1 == null) {
        str = "02:00:00:00:00:00";
      }
      this.bssid = str;
      this.ssid = paramString2;
      this.networkId = paramInt2;
      this.ipaddr = paramInt3;
      AppMethodBeat.o(262862);
    }
    
    public final String getBssid()
    {
      return this.bssid;
    }
    
    public final int getIpaddr()
    {
      return this.ipaddr;
    }
    
    public final int getNetworkId()
    {
      return this.networkId;
    }
    
    public final int getRssi()
    {
      return this.rssi;
    }
    
    public final String getSsid()
    {
      return this.ssid;
    }
    
    public final void saveMMKV()
    {
      AppMethodBeat.i(262864);
      MultiProcessMMKV.getMMKV("connectivity_compat").putInt("connectivity_compat_key_wifi_rssi", this.rssi);
      MultiProcessMMKV.getMMKV("connectivity_compat").putString("connectivity_compat_key_wifi_ssid", this.ssid);
      MultiProcessMMKV.getMMKV("connectivity_compat").putString("connectivity_compat_key_wifi_bssid", this.bssid);
      MultiProcessMMKV.getMMKV("connectivity_compat").putInt("connectivity_compat_key_wifi_networkid", this.networkId);
      MultiProcessMMKV.getMMKV("connectivity_compat").putInt("connectivity_compat_key_wifi_idaddr", this.ipaddr);
      AppMethodBeat.o(262864);
    }
    
    public final void setBssid(String paramString)
    {
      AppMethodBeat.i(262856);
      p.k(paramString, "<set-?>");
      this.bssid = paramString;
      AppMethodBeat.o(262856);
    }
    
    public final void setIpaddr(int paramInt)
    {
      this.ipaddr = paramInt;
    }
    
    public final void setNetworkId(int paramInt)
    {
      this.networkId = paramInt;
    }
    
    public final void setRssi(int paramInt)
    {
      this.rssi = paramInt;
    }
    
    public final void setSsid(String paramString)
    {
      AppMethodBeat.i(262859);
      p.k(paramString, "<set-?>");
      this.ssid = paramString;
      AppMethodBeat.o(262859);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(262866);
      String str = String.format("rssi(%d), bssid(%s), ssid(%s), networkId(%d), ipaddr(%s)", Arrays.copyOf(new Object[] { Integer.valueOf(this.rssi), this.bssid, this.ssid, Integer.valueOf(this.networkId), ConnectivityCompat.Companion.access$getIPStrByInt(ConnectivityCompat.Companion, this.ipaddr) }, 5));
      p.j(str, "java.lang.String.format(this, *args)");
      AppMethodBeat.o(262866);
      return str;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/sdk/platformtools/ConnectivityCompat$WiFiScanResult;", "", "()V", "bssid", "", "getBssid", "()Ljava/lang/String;", "setBssid", "(Ljava/lang/String;)V", "level", "", "getLevel", "()I", "setLevel", "(I)V", "ssid", "getSsid", "setSsid", "fromStr", "", "str", "toStr", "toString", "libcompatible_release"})
  public static final class WiFiScanResult
  {
    private String bssid = "02:00:00:00:00:00";
    private int level;
    private String ssid = "<unknown ssid>";
    
    public final boolean fromStr(String paramString)
    {
      AppMethodBeat.i(262788);
      p.k(paramString, "str");
      try
      {
        paramString = n.a((CharSequence)paramString, new String[] { "," });
        this.level = Integer.parseInt((String)paramString.get(0));
        this.ssid = ((String)paramString.get(1));
        paramString = Base64.decode((String)paramString.get(2), 2);
        p.j(paramString, "Base64.decode(this[2], Base64.NO_WRAP)");
        this.bssid = new String(paramString, d.UTF_8);
        AppMethodBeat.o(262788);
        return true;
      }
      catch (Exception paramString)
      {
        AppMethodBeat.o(262788);
      }
      return false;
    }
    
    public final String getBssid()
    {
      return this.bssid;
    }
    
    public final int getLevel()
    {
      return this.level;
    }
    
    public final String getSsid()
    {
      return this.ssid;
    }
    
    public final void setBssid(String paramString)
    {
      AppMethodBeat.i(262783);
      p.k(paramString, "<set-?>");
      this.bssid = paramString;
      AppMethodBeat.o(262783);
    }
    
    public final void setLevel(int paramInt)
    {
      this.level = paramInt;
    }
    
    public final void setSsid(String paramString)
    {
      AppMethodBeat.i(262781);
      p.k(paramString, "<set-?>");
      this.ssid = paramString;
      AppMethodBeat.o(262781);
    }
    
    public final String toStr()
    {
      AppMethodBeat.i(262787);
      Object localObject1 = new StringBuilder().append(this.level).append(',').append(this.bssid).append(',');
      Object localObject2 = this.ssid;
      Charset localCharset = d.UTF_8;
      if (localObject2 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(262787);
        throw ((Throwable)localObject1);
      }
      localObject2 = ((String)localObject2).getBytes(localCharset);
      p.j(localObject2, "(this as java.lang.String).getBytes(charset)");
      localObject1 = Base64.encodeToString((byte[])localObject2, 2);
      AppMethodBeat.o(262787);
      return localObject1;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(262786);
      String str = "ssid(" + this.ssid + "), bssid(" + this.bssid + "), level(" + this.level + ')';
      AppMethodBeat.o(262786);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.ConnectivityCompat
 * JD-Core Version:    0.7.0.1
 */