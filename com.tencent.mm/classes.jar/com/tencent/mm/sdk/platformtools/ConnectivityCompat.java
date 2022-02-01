package com.tencent.mm.sdk.platformtools;

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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sdk/platformtools/ConnectivityCompat;", "", "()V", "Companion", "MixedSignalStrength", "NetworkCallbackImpl24", "Receiver", "Supervisor", "WiFiInfo", "WiFiScanResult", "libcompatible_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ConnectivityCompat
{
  public static final Companion Companion;
  public static final int GET_WIFI_SCAN_RESULT_THRESHOLD = 2;
  public static final String INVALID_WIFI_BSSID = "02:00:00:00:00:00";
  public static final String INVALID_WIFI_SSID = "<unknown ssid>";
  public static final String MMKV_CONFIG_NAME = "connectivity_compat";
  public static final String MMKV_KEY_WIFI_BSSID = "connectivity_compat_key_wifi_bssid";
  public static final String MMKV_KEY_WIFI_IPADDR = "connectivity_compat_key_wifi_idaddr";
  public static final String MMKV_KEY_WIFI_LAST_GET_TIME = "connectivity_compat_key_wifi_last_get_time";
  public static final String MMKV_KEY_WIFI_NETWORKID = "connectivity_compat_key_wifi_networkid";
  public static final String MMKV_KEY_WIFI_RSSI = "connectivity_compat_key_wifi_rssi";
  public static final String MMKV_KEY_WIFI_SCAN_RESULTS = "connectivity_compat_key_wifi_scan_results";
  public static final String MMKV_KEY_WIFI_SCAN_THRESHOLD = "connectivity_compat_key_wifi_scan_threshold";
  public static final String MMKV_KEY_WIFI_SSID = "connectivity_compat_key_wifi_ssid";
  public static final String MMKV_KEY_WIFI_TOUCH_TIME = "connectivity_compat_key_wifi_touch_time";
  public static final String MMKV_KEY_WIFI_UPDATE_TIME_STAMP = "wifi_info_update_timestamp";
  private static final long REALTIME_WIFI_INFO_TOUCH_INTERVAL = 60L;
  public static final String TAG = "MicroMsg.ConnectivityCompat";
  private static Receiver connectivityReceiver;
  private static final MixedSignalStrength mixedSignalStrength;
  private static NetworkCallbackImpl24 networkCallbackImpl24;
  private static PhoneStateListener phoneListener;
  private static Supervisor supervisor;
  
  static
  {
    AppMethodBeat.i(243415);
    Companion = new Companion(null);
    mixedSignalStrength = new MixedSignalStrength();
    AppMethodBeat.o(243415);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/sdk/platformtools/ConnectivityCompat$Companion;", "", "()V", "GET_WIFI_SCAN_RESULT_THRESHOLD", "", "INVALID_WIFI_BSSID", "", "INVALID_WIFI_SSID", "MMKV_CONFIG_NAME", "MMKV_KEY_WIFI_BSSID", "MMKV_KEY_WIFI_IPADDR", "MMKV_KEY_WIFI_LAST_GET_TIME", "MMKV_KEY_WIFI_NETWORKID", "MMKV_KEY_WIFI_RSSI", "MMKV_KEY_WIFI_SCAN_RESULTS", "MMKV_KEY_WIFI_SCAN_THRESHOLD", "MMKV_KEY_WIFI_SSID", "MMKV_KEY_WIFI_TOUCH_TIME", "MMKV_KEY_WIFI_UPDATE_TIME_STAMP", "REALTIME_WIFI_INFO_TOUCH_INTERVAL", "", "TAG", "connectivityReceiver", "Lcom/tencent/mm/sdk/platformtools/ConnectivityCompat$Receiver;", "mixedSignalStrength", "Lcom/tencent/mm/sdk/platformtools/ConnectivityCompat$MixedSignalStrength;", "networkCallbackImpl24", "Lcom/tencent/mm/sdk/platformtools/ConnectivityCompat$NetworkCallbackImpl24;", "phoneListener", "Landroid/telephony/PhoneStateListener;", "supervisor", "Lcom/tencent/mm/sdk/platformtools/ConnectivityCompat$Supervisor;", "getSupervisor", "()Lcom/tencent/mm/sdk/platformtools/ConnectivityCompat$Supervisor;", "setSupervisor", "(Lcom/tencent/mm/sdk/platformtools/ConnectivityCompat$Supervisor;)V", "acquireWiFiInfo", "Lcom/tencent/mm/sdk/platformtools/ConnectivityCompat$WiFiInfo;", "acquireWiFiInfo27", "gContext", "Landroid/content/Context;", "wm", "Landroid/net/wifi/WifiManager;", "acquireWiFiInfo29", "getCompatMixStrength", "realtime", "", "getFormattedWiFiBssid", "getFormattedWiFiSsid", "getIPStrByInt", "ipInt", "getNetworkId", "getSignalStrength", "getWiFiBssid", "getWiFiIpAddress", "getWiFiRssi", "getWiFiScanResults", "", "Lcom/tencent/mm/sdk/platformtools/ConnectivityCompat$WiFiScanResult;", "getWiFiSsid", "initSignalStrengthListener", "", "registerReceiver", "removeSsidQuote", "ssid", "startScanWiFi", "touchRealtimeWifiInfo", "unregisterReceiver", "libcompatible_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class Companion
  {
    private byte _hellAccFlag_;
    
    private final ConnectivityCompat.WiFiInfo acquireWiFiInfo()
    {
      AppMethodBeat.i(243507);
      Object localObject1 = new ConnectivityCompat.WiFiInfo();
      Object localObject2 = MMApplicationContext.getContext();
      Object localObject3 = ((Context)localObject2).getApplicationContext().getSystemService("connectivity");
      if (localObject3 == null)
      {
        localObject1 = new NullPointerException("null cannot be cast to non-null type android.net.ConnectivityManager");
        AppMethodBeat.o(243507);
        throw ((Throwable)localObject1);
      }
      localObject3 = ((ConnectivityManager)localObject3).getActiveNetworkInfo();
      if ((localObject3 == null) || (!NetStatusUtil.isWifi((NetworkInfo)localObject3)))
      {
        Log.i("MicroMsg.ConnectivityCompat", "not wifi currently, return empty wifi info");
        localObject1 = new ConnectivityCompat.WiFiInfo();
        AppMethodBeat.o(243507);
        return localObject1;
      }
      localObject3 = ((Context)localObject2).getApplicationContext().getSystemService("wifi");
      if (localObject3 == null)
      {
        localObject1 = new NullPointerException("null cannot be cast to non-null type android.net.wifi.WifiManager");
        AppMethodBeat.o(243507);
        throw ((Throwable)localObject1);
      }
      localObject3 = (WifiManager)localObject3;
      if (Build.VERSION.SDK_INT >= 29)
      {
        s.s(localObject2, "gContext");
        localObject1 = acquireWiFiInfo29((Context)localObject2, (WifiManager)localObject3);
        AppMethodBeat.o(243507);
        return localObject1;
      }
      if (Build.VERSION.SDK_INT >= 27)
      {
        s.s(localObject2, "gContext");
        localObject1 = acquireWiFiInfo27((Context)localObject2, (WifiManager)localObject3);
        AppMethodBeat.o(243507);
        return localObject1;
      }
      localObject2 = (WifiInfo)com.tencent.mm.hellhoundlib.a.a.a(localObject3, "com/tencent/mm/sdk/platformtools/ConnectivityCompat$Companion", "acquireWiFiInfo", "()Lcom/tencent/mm/sdk/platformtools/ConnectivityCompat$WiFiInfo;", "android/net/wifi/WifiManager", "getConnectionInfo", "()Landroid/net/wifi/WifiInfo;");
      if (localObject2 != null)
      {
        int i = ((WifiInfo)localObject2).getRssi();
        localObject3 = ((WifiInfo)localObject2).getBSSID();
        String str = ((WifiInfo)localObject2).getSSID();
        s.s(str, "ssid");
        ((ConnectivityCompat.WiFiInfo)localObject1).fill(i, (String)localObject3, str, ((WifiInfo)localObject2).getNetworkId(), ((WifiInfo)localObject2).getIpAddress());
      }
      AppMethodBeat.o(243507);
      return localObject1;
    }
    
    private final ConnectivityCompat.WiFiInfo acquireWiFiInfo27(Context paramContext, WifiManager paramWifiManager)
    {
      AppMethodBeat.i(243497);
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
            s.s(str, "ssid");
            localWiFiInfo.fill(i, (String)localObject, str, paramContext.getNetworkId(), paramContext.getIpAddress());
          }
        }
        AppMethodBeat.o(243497);
        return localWiFiInfo;
      }
      finally
      {
        Log.printErrStackTrace("MicroMsg.ConnectivityCompat", paramContext, "get wifi info failed directly", new Object[0]);
      }
      try
      {
        localObject = (List)com.tencent.mm.hellhoundlib.a.a.a(paramWifiManager, "com/tencent/mm/sdk/platformtools/ConnectivityCompat$Companion", "acquireWiFiInfo27", "(Landroid/content/Context;Landroid/net/wifi/WifiManager;)Lcom/tencent/mm/sdk/platformtools/ConnectivityCompat$WiFiInfo;", "android/net/wifi/WifiManager", "getConfiguredNetworks", "()Ljava/util/List;");
        s.s(localObject, "wm.getConfiguredNetworks()");
        paramContext = (WifiInfo)com.tencent.mm.hellhoundlib.a.a.a(paramWifiManager, "com/tencent/mm/sdk/platformtools/ConnectivityCompat$Companion", "acquireWiFiInfo27", "(Landroid/content/Context;Landroid/net/wifi/WifiManager;)Lcom/tencent/mm/sdk/platformtools/ConnectivityCompat$WiFiInfo;", "android/net/wifi/WifiManager", "getConnectionInfo", "()Landroid/net/wifi/WifiInfo;");
        paramWifiManager = ((List)localObject).iterator();
        while (paramWifiManager.hasNext()) {
          if (((WifiConfiguration)paramWifiManager.next()).networkId == paramContext.getNetworkId())
          {
            i = paramContext.getRssi();
            paramWifiManager = paramContext.getBSSID();
            localObject = paramContext.getSSID();
            s.s(localObject, "connectionInfo.ssid");
            localWiFiInfo.fill(i, paramWifiManager, (String)localObject, paramContext.getNetworkId(), paramContext.getIpAddress());
          }
        }
      }
      finally
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.ConnectivityCompat", paramContext, "get wifi info failed from configurations", new Object[0]);
        }
      }
      AppMethodBeat.o(243497);
      return localWiFiInfo;
    }
    
    private final ConnectivityCompat.WiFiInfo acquireWiFiInfo29(Context paramContext, WifiManager paramWifiManager)
    {
      AppMethodBeat.i(243501);
      if (paramContext.checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0)
      {
        Log.e("MicroMsg.ConnectivityCompat", "acquireWiFiInfo29(): access_fine_location perm not granted.");
        paramContext = new ConnectivityCompat.WiFiInfo();
        AppMethodBeat.o(243501);
        return paramContext;
      }
      paramContext = acquireWiFiInfo27(paramContext, paramWifiManager);
      AppMethodBeat.o(243501);
      return paramContext;
    }
    
    private final String getIPStrByInt(int paramInt)
    {
      AppMethodBeat.i(243486);
      String str = (paramInt & 0xFF) + '.' + (paramInt >> 8 & 0xFF) + '.' + (paramInt >> 16 & 0xFF) + '.' + (paramInt >> 24 & 0xFF);
      AppMethodBeat.o(243486);
      return str;
    }
    
    private final String removeSsidQuote(String paramString)
    {
      AppMethodBeat.i(243481);
      if (Util.isNullOrNil(paramString))
      {
        AppMethodBeat.o(243481);
        return "";
      }
      if (s.p(paramString, "<unknown ssid>"))
      {
        AppMethodBeat.o(243481);
        return "";
      }
      if ((n.U(paramString, "\"", false)) && (n.rs(paramString, "\"")))
      {
        int i = paramString.length();
        if (paramString == null)
        {
          paramString = new NullPointerException("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(243481);
          throw paramString;
        }
        paramString = paramString.substring(1, i - 1);
        s.s(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        AppMethodBeat.o(243481);
        return paramString;
      }
      AppMethodBeat.o(243481);
      return paramString;
    }
    
    private final boolean touchRealtimeWifiInfo()
    {
      AppMethodBeat.i(243512);
      Object localObject = MultiProcessMMKV.getMMKV("connectivity_compat");
      if (Util.secondsToNow(((MultiProcessMMKV)localObject).getLong("connectivity_compat_key_wifi_touch_time", -1L)) > 60L)
      {
        ((MultiProcessMMKV)localObject).putLong("connectivity_compat_key_wifi_touch_time", Util.nowSecond());
        localObject = ConnectivityCompat.Companion.acquireWiFiInfo();
        Log.i("MicroMsg.ConnectivityCompat", s.X("updated new wifi info (via touch realtime info): ", localObject));
        ((ConnectivityCompat.WiFiInfo)localObject).saveMMKV();
        if (ConnectivityCompat.Companion.getSupervisor() != null)
        {
          localObject = ConnectivityCompat.Companion.getSupervisor();
          s.checkNotNull(localObject);
          ((ConnectivityCompat.Supervisor)localObject).report(ConnectivityCompat.Supervisor.API.GET_CONNECTION_INFO, false, true);
        }
        AppMethodBeat.o(243512);
        return true;
      }
      AppMethodBeat.o(243512);
      return false;
    }
    
    public final int getCompatMixStrength()
    {
      AppMethodBeat.i(243623);
      int i = getCompatMixStrength$default(this, false, 1, null);
      AppMethodBeat.o(243623);
      return i;
    }
    
    /* Error */
    public final int getCompatMixStrength(boolean paramBoolean)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: ldc_w 431
      //   5: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   8: invokestatic 121	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
      //   11: invokestatic 434	com/tencent/mm/sdk/platformtools/NetStatusUtil:isWifi	(Landroid/content/Context;)Z
      //   14: ifeq +24 -> 38
      //   17: getstatic 398	com/tencent/mm/sdk/platformtools/ConnectivityCompat:Companion	Lcom/tencent/mm/sdk/platformtools/ConnectivityCompat$Companion;
      //   20: iload_1
      //   21: invokevirtual 321	com/tencent/mm/sdk/platformtools/ConnectivityCompat$Companion:getWiFiRssi	(Z)I
      //   24: invokestatic 440	java/lang/Math:abs	(I)I
      //   27: istore_2
      //   28: ldc_w 431
      //   31: invokestatic 105	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   34: aload_0
      //   35: monitorexit
      //   36: iload_2
      //   37: ireturn
      //   38: invokestatic 444	com/tencent/mm/sdk/platformtools/ConnectivityCompat:access$getPhoneListener$cp	()Landroid/telephony/PhoneStateListener;
      //   41: ifnonnull +11 -> 52
      //   44: ldc 153
      //   46: ldc_w 446
      //   49: invokestatic 275	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   52: invokestatic 450	com/tencent/mm/sdk/platformtools/ConnectivityCompat:access$getMixedSignalStrength$cp	()Lcom/tencent/mm/sdk/platformtools/ConnectivityCompat$MixedSignalStrength;
      //   55: invokevirtual 455	com/tencent/mm/sdk/platformtools/ConnectivityCompat$MixedSignalStrength:nowStrength	()I
      //   58: invokestatic 440	java/lang/Math:abs	(I)I
      //   61: istore_2
      //   62: ldc_w 431
      //   65: invokestatic 105	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   68: goto -34 -> 34
      //   71: astore_3
      //   72: ldc 153
      //   74: aload_3
      //   75: checkcast 457	java/lang/Throwable
      //   78: ldc_w 334
      //   81: iconst_0
      //   82: anewarray 4	java/lang/Object
      //   85: invokestatic 238	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   88: ldc_w 431
      //   91: invokestatic 105	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
      AppMethodBeat.i(243650);
      String str = getFormattedWiFiBssid$default(this, false, 1, null);
      AppMethodBeat.o(243650);
      return str;
    }
    
    public final String getFormattedWiFiBssid(boolean paramBoolean)
    {
      AppMethodBeat.i(243613);
      Object localObject = getWiFiBssid(paramBoolean);
      if (s.p(localObject, "02:00:00:00:00:00"))
      {
        AppMethodBeat.o(243613);
        return "";
      }
      Locale localLocale = Locale.ENGLISH;
      s.s(localLocale, "ENGLISH");
      if (localObject == null)
      {
        localObject = new NullPointerException("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(243613);
        throw ((Throwable)localObject);
      }
      localObject = ((String)localObject).toLowerCase(localLocale);
      s.s(localObject, "(this as java.lang.String).toLowerCase(locale)");
      AppMethodBeat.o(243613);
      return localObject;
    }
    
    public final String getFormattedWiFiSsid()
    {
      AppMethodBeat.i(243654);
      String str = getFormattedWiFiSsid$default(this, false, 1, null);
      AppMethodBeat.o(243654);
      return str;
    }
    
    public final String getFormattedWiFiSsid(boolean paramBoolean)
    {
      AppMethodBeat.i(243616);
      String str = removeSsidQuote(getWiFiSsid(paramBoolean));
      AppMethodBeat.o(243616);
      return str;
    }
    
    public final int getNetworkId()
    {
      AppMethodBeat.i(243647);
      int i = getNetworkId$default(this, false, 1, null);
      AppMethodBeat.o(243647);
      return i;
    }
    
    public final int getNetworkId(boolean paramBoolean)
    {
      boolean bool = true;
      AppMethodBeat.i(243609);
      int i = MultiProcessMMKV.getMMKV("connectivity_compat").getInt("connectivity_compat_key_wifi_networkid", -1);
      if ((!paramBoolean) && (getSupervisor() == null))
      {
        AppMethodBeat.o(243609);
        return i;
      }
      int j = acquireWiFiInfo().getNetworkId();
      ConnectivityCompat.Supervisor localSupervisor;
      ConnectivityCompat.Supervisor.API localAPI;
      if (getSupervisor() != null)
      {
        if (i == j) {
          break label137;
        }
        Log.w("MicroMsg.ConnectivityCompat", "check_consistence(networkId), cached: %d, realtime: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
        localSupervisor = getSupervisor();
        s.checkNotNull(localSupervisor);
        localAPI = ConnectivityCompat.Supervisor.API.GET_CONNECTION_INFO;
        if ((i == j) || (paramBoolean)) {
          break label166;
        }
      }
      for (;;)
      {
        localSupervisor.report(localAPI, bool, paramBoolean);
        if (!paramBoolean) {
          break label172;
        }
        AppMethodBeat.o(243609);
        return j;
        label137:
        Log.d("MicroMsg.ConnectivityCompat", "check_consistence(networkId), cached: %d, realtime: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
        break;
        label166:
        bool = false;
      }
      label172:
      AppMethodBeat.o(243609);
      return i;
    }
    
    public final ConnectivityCompat.MixedSignalStrength getSignalStrength()
    {
      AppMethodBeat.i(243557);
      ConnectivityCompat.MixedSignalStrength localMixedSignalStrength = ConnectivityCompat.access$getMixedSignalStrength$cp();
      AppMethodBeat.o(243557);
      return localMixedSignalStrength;
    }
    
    public final ConnectivityCompat.Supervisor getSupervisor()
    {
      AppMethodBeat.i(243524);
      ConnectivityCompat.Supervisor localSupervisor = ConnectivityCompat.access$getSupervisor$cp();
      AppMethodBeat.o(243524);
      return localSupervisor;
    }
    
    public final String getWiFiBssid()
    {
      AppMethodBeat.i(243636);
      String str = getWiFiBssid$default(this, false, 1, null);
      AppMethodBeat.o(243636);
      return str;
    }
    
    public final String getWiFiBssid(boolean paramBoolean)
    {
      boolean bool = true;
      AppMethodBeat.i(243580);
      String str2 = MultiProcessMMKV.getMMKV("connectivity_compat").getString("connectivity_compat_key_wifi_bssid", "02:00:00:00:00:00");
      s.checkNotNull(str2);
      s.s(str2, "getMMKV(MMKV_CONFIG_NAME…ID, INVALID_WIFI_BSSID)!!");
      String str1 = str2;
      if (s.p(str2, "02:00:00:00:00:00"))
      {
        str1 = str2;
        if (touchRealtimeWifiInfo())
        {
          str1 = MultiProcessMMKV.getMMKV("connectivity_compat").getString("connectivity_compat_key_wifi_bssid", "02:00:00:00:00:00");
          s.checkNotNull(str1);
          s.s(str1, "getMMKV(MMKV_CONFIG_NAME…ID, INVALID_WIFI_BSSID)!!");
        }
      }
      if ((!paramBoolean) && (getSupervisor() == null))
      {
        AppMethodBeat.o(243580);
        return str1;
      }
      str2 = acquireWiFiInfo().getBssid();
      ConnectivityCompat.Supervisor localSupervisor;
      ConnectivityCompat.Supervisor.API localAPI;
      if (getSupervisor() != null)
      {
        if (s.p(str1, str2)) {
          break label214;
        }
        Log.w("MicroMsg.ConnectivityCompat", "check_consistence(bssid), cached: %s, realtime: %s, stack: %s", new Object[] { str1, str2, MMStack.getStack(true) });
        localSupervisor = getSupervisor();
        s.checkNotNull(localSupervisor);
        localAPI = ConnectivityCompat.Supervisor.API.GET_CONNECTION_INFO;
        if ((s.p(str1, str2)) || (paramBoolean)) {
          break label245;
        }
      }
      for (;;)
      {
        localSupervisor.report(localAPI, bool, paramBoolean);
        if (!paramBoolean) {
          break label250;
        }
        AppMethodBeat.o(243580);
        return str2;
        label214:
        Log.d("MicroMsg.ConnectivityCompat", "check_consistence(bssid), cached: %s, realtime: %s, stack: %s", new Object[] { str1, str2, MMStack.getStack(true) });
        break;
        label245:
        bool = false;
      }
      label250:
      AppMethodBeat.o(243580);
      return str1;
    }
    
    public final int getWiFiIpAddress()
    {
      AppMethodBeat.i(243642);
      int i = getWiFiIpAddress$default(this, false, 1, null);
      AppMethodBeat.o(243642);
      return i;
    }
    
    public final int getWiFiIpAddress(boolean paramBoolean)
    {
      boolean bool = true;
      AppMethodBeat.i(243586);
      int i = MultiProcessMMKV.getMMKV("connectivity_compat").getInt("connectivity_compat_key_wifi_idaddr", 0);
      if ((!paramBoolean) && (getSupervisor() == null))
      {
        AppMethodBeat.o(243586);
        return i;
      }
      int j = acquireWiFiInfo().getIpaddr();
      ConnectivityCompat.Supervisor localSupervisor;
      ConnectivityCompat.Supervisor.API localAPI;
      if (getSupervisor() != null)
      {
        if (i == j) {
          break label146;
        }
        Log.w("MicroMsg.ConnectivityCompat", "check_consistence(ipaddr), cached: %s, realtime: %s, stack: %s", new Object[] { getIPStrByInt(i), getIPStrByInt(j), MMStack.getStack(true) });
        localSupervisor = getSupervisor();
        s.checkNotNull(localSupervisor);
        localAPI = ConnectivityCompat.Supervisor.API.GET_CONNECTION_INFO;
        if ((i == j) || (paramBoolean)) {
          break label184;
        }
      }
      for (;;)
      {
        localSupervisor.report(localAPI, bool, paramBoolean);
        if (!paramBoolean) {
          break label190;
        }
        AppMethodBeat.o(243586);
        return j;
        label146:
        Log.d("MicroMsg.ConnectivityCompat", "check_consistence(ipaddr), cached: %s, realtime: %s, stack: %s", new Object[] { getIPStrByInt(i), getIPStrByInt(j), MMStack.getStack(true) });
        break;
        label184:
        bool = false;
      }
      label190:
      AppMethodBeat.o(243586);
      return i;
    }
    
    public final int getWiFiRssi()
    {
      AppMethodBeat.i(243627);
      int i = getWiFiRssi$default(this, false, 1, null);
      AppMethodBeat.o(243627);
      return i;
    }
    
    public final int getWiFiRssi(boolean paramBoolean)
    {
      boolean bool = true;
      AppMethodBeat.i(243570);
      int k = MultiProcessMMKV.getMMKV("connectivity_compat").getInt("connectivity_compat_key_wifi_rssi", 0);
      if ((!paramBoolean) && (getSupervisor() == null))
      {
        AppMethodBeat.o(243570);
        return k;
      }
      int m = acquireWiFiInfo().getRssi();
      int i;
      int j;
      label84:
      ConnectivityCompat.Supervisor localSupervisor;
      label137:
      ConnectivityCompat.Supervisor.API localAPI;
      if (getSupervisor() != null)
      {
        if (m <= k + 8) {
          break label212;
        }
        i = 1;
        if (m >= k - 8) {
          break label217;
        }
        j = 1;
        if ((j | i) == 0) {
          break label222;
        }
        Log.w("MicroMsg.ConnectivityCompat", "check_consistence(rssi), cached: " + k + ", realtime: " + m + ", stack: " + MMStack.getStack(true));
        localSupervisor = getSupervisor();
        s.checkNotNull(localSupervisor);
        localAPI = ConnectivityCompat.Supervisor.API.GET_CONNECTION_INFO;
        if (m <= k + 8) {
          break label272;
        }
        i = 1;
        label165:
        if (m >= k - 8) {
          break label277;
        }
        j = 1;
        label177:
        if (((j | i) == 0) || (paramBoolean)) {
          break label282;
        }
      }
      for (;;)
      {
        localSupervisor.report(localAPI, bool, paramBoolean);
        if (!paramBoolean) {
          break label288;
        }
        AppMethodBeat.o(243570);
        return m;
        label212:
        i = 0;
        break;
        label217:
        j = 0;
        break label84;
        label222:
        Log.d("MicroMsg.ConnectivityCompat", "check_consistence(rssi), cached: " + k + ", realtime: " + m + ", stack: " + MMStack.getStack(true));
        break label137;
        label272:
        i = 0;
        break label165;
        label277:
        j = 0;
        break label177;
        label282:
        bool = false;
      }
      label288:
      AppMethodBeat.o(243570);
      return k;
    }
    
    public final List<ConnectivityCompat.WiFiScanResult> getWiFiScanResults()
    {
      int j = 1;
      AppMethodBeat.i(243602);
      Log.w("MicroMsg.ConnectivityCompat", "getWiFiScanResults(), stack: %s", new Object[] { MMStack.getStack(true) });
      if (Util.secondsToNow(MultiProcessMMKV.getMMKV("connectivity_compat").getLong("connectivity_compat_key_wifi_last_get_time", 0L)) > 600L) {}
      for (;;)
      {
        int i;
        Object localObject3;
        Object localObject4;
        try
        {
          Object localObject1 = MMApplicationContext.getContext();
          if ((localObject1 != null) && (((Context)localObject1).checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0))
          {
            i = 1;
            if (i == 0)
            {
              if ((localObject1 == null) || (((Context)localObject1).checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") != 0)) {
                break label274;
              }
              i = j;
              break label486;
            }
            Log.i("MicroMsg.ConnectivityCompat", "real getWiFiScanResults.");
            localObject3 = new LinkedList();
            localObject1 = new HashSet();
            localObject4 = MMApplicationContext.getContext().getApplicationContext().getSystemService("wifi");
            if (localObject4 != null) {
              break label279;
            }
            localObject1 = new NullPointerException("null cannot be cast to non-null type android.net.wifi.WifiManager");
            AppMethodBeat.o(243602);
            throw ((Throwable)localObject1);
          }
        }
        catch (Exception localException) {}
        label274:
        label279:
        label486:
        do
        {
          for (;;)
          {
            localObject2 = new LinkedList();
            localObject3 = MultiProcessMMKV.getMMKV("connectivity_compat").getStringSet("connectivity_compat_key_wifi_scan_results", (Set)new HashSet());
            s.checkNotNull(localObject3);
            s.s(localObject3, "getMMKV(MMKV_CONFIG_NAME…LTS, HashSet<String>())!!");
            localObject3 = ((Iterable)localObject3).iterator();
            Object localObject5;
            while (((Iterator)localObject3).hasNext())
            {
              localObject4 = (String)((Iterator)localObject3).next();
              localObject5 = new ConnectivityCompat.WiFiScanResult();
              s.s(localObject4, "it");
              if (((ConnectivityCompat.WiFiScanResult)localObject5).fromStr((String)localObject4)) {
                ((LinkedList)localObject2).add(localObject5);
              }
            }
            i = 0;
            break;
            i = 0;
            break label486;
            localObject4 = (List)com.tencent.mm.hellhoundlib.a.a.a((WifiManager)localObject4, "com/tencent/mm/sdk/platformtools/ConnectivityCompat$Companion", "getWiFiScanResults", "()Ljava/util/List;", "android/net/wifi/WifiManager", "getScanResults", "()Ljava/util/List;");
            if (localObject4 != null)
            {
              localObject4 = ((Iterable)localObject4).iterator();
              while (((Iterator)localObject4).hasNext())
              {
                localObject5 = (ScanResult)((Iterator)localObject4).next();
                ConnectivityCompat.WiFiScanResult localWiFiScanResult = new ConnectivityCompat.WiFiScanResult();
                String str = ((ScanResult)localObject5).SSID;
                s.s(str, "it.SSID");
                localWiFiScanResult.setSsid(str);
                str = ((ScanResult)localObject5).BSSID;
                s.s(str, "it.BSSID");
                localWiFiScanResult.setBssid(str);
                localWiFiScanResult.setLevel(((ScanResult)localObject5).level);
                ((LinkedList)localObject3).add(localWiFiScanResult);
                ((HashSet)localObject2).add(localWiFiScanResult.toStr());
              }
            }
            localObject3 = MultiProcessMMKV.getMMKV("connectivity_compat");
            ((MultiProcessMMKV)localObject3).putStringSet("connectivity_compat_key_wifi_scan_results", (Set)localObject2);
            ((MultiProcessMMKV)localObject3).putLong("connectivity_compat_key_wifi_last_get_time", Util.nowSecond());
            Log.i("MicroMsg.ConnectivityCompat", "get scan results from system api now");
          }
          Object localObject2 = (List)localObject2;
          AppMethodBeat.o(243602);
          return localObject2;
        } while (i == 0);
      }
    }
    
    public final String getWiFiSsid()
    {
      AppMethodBeat.i(243632);
      String str = getWiFiSsid$default(this, false, 1, null);
      AppMethodBeat.o(243632);
      return str;
    }
    
    public final String getWiFiSsid(boolean paramBoolean)
    {
      boolean bool = true;
      AppMethodBeat.i(243573);
      String str2 = MultiProcessMMKV.getMMKV("connectivity_compat").getString("connectivity_compat_key_wifi_ssid", "<unknown ssid>");
      s.checkNotNull(str2);
      s.s(str2, "getMMKV(MMKV_CONFIG_NAME…SID, INVALID_WIFI_SSID)!!");
      String str1 = str2;
      if (s.p(str2, "<unknown ssid>"))
      {
        str1 = str2;
        if (touchRealtimeWifiInfo())
        {
          str1 = MultiProcessMMKV.getMMKV("connectivity_compat").getString("connectivity_compat_key_wifi_ssid", "<unknown ssid>");
          s.checkNotNull(str1);
          s.s(str1, "getMMKV(MMKV_CONFIG_NAME…SID, INVALID_WIFI_SSID)!!");
        }
      }
      if ((!paramBoolean) && (getSupervisor() == null))
      {
        AppMethodBeat.o(243573);
        return str1;
      }
      str2 = acquireWiFiInfo().getSsid();
      ConnectivityCompat.Supervisor localSupervisor;
      ConnectivityCompat.Supervisor.API localAPI;
      if (getSupervisor() != null)
      {
        if (s.p(str1, str2)) {
          break label232;
        }
        Log.w("MicroMsg.ConnectivityCompat", "check_consistence(ssid), cached: " + str1 + ", realtime: " + str2 + ", stack: " + MMStack.getStack(true));
        localSupervisor = getSupervisor();
        s.checkNotNull(localSupervisor);
        localAPI = ConnectivityCompat.Supervisor.API.GET_CONNECTION_INFO;
        if ((s.p(str1, str2)) || (paramBoolean)) {
          break label281;
        }
      }
      for (;;)
      {
        localSupervisor.report(localAPI, bool, paramBoolean);
        if (!paramBoolean) {
          break label286;
        }
        AppMethodBeat.o(243573);
        return str2;
        label232:
        Log.d("MicroMsg.ConnectivityCompat", "check_consistence(ssid), cached: " + str1 + ", realtime: " + str2 + ", stack: " + MMStack.getStack(true));
        break;
        label281:
        bool = false;
      }
      label286:
      AppMethodBeat.o(243573);
      return str1;
    }
    
    public final void initSignalStrengthListener()
    {
      AppMethodBeat.i(243553);
      if (ConnectivityCompat.access$getPhoneListener$cp() == null)
      {
        Object localObject1 = MMApplicationContext.getContext().getSystemService("phone");
        if (localObject1 == null)
        {
          localObject1 = new NullPointerException("null cannot be cast to non-null type android.telephony.TelephonyManager");
          AppMethodBeat.o(243553);
          throw ((Throwable)localObject1);
        }
        localObject1 = (TelephonyManager)localObject1;
        ConnectivityCompat.access$setPhoneListener$cp((PhoneStateListener)new PhoneStateListener()
        {
          public final void onSignalStrengthsChanged(SignalStrength paramAnonymousSignalStrength)
          {
            AppMethodBeat.i(243687);
            s.u(paramAnonymousSignalStrength, "signalStrength");
            super.onSignalStrengthsChanged(paramAnonymousSignalStrength);
            ConnectivityCompat.access$getMixedSignalStrength$cp().setPhoneType(this.$phoneType);
            switch (ConnectivityCompat.access$getMixedSignalStrength$cp().getPhoneType())
            {
            }
            for (;;)
            {
              AppMethodBeat.o(243687);
              return;
              ConnectivityCompat.access$getMixedSignalStrength$cp().setCdmaDbm(paramAnonymousSignalStrength.getCdmaDbm());
              AppMethodBeat.o(243687);
              return;
              ConnectivityCompat.access$getMixedSignalStrength$cp().setGsmSignalStrength(paramAnonymousSignalStrength.getGsmSignalStrength());
            }
          }
        });
        Object localObject2 = ConnectivityCompat.access$getPhoneListener$cp();
        localObject2 = c.a(256, new com.tencent.mm.hellhoundlib.b.a()).cG(localObject2);
        com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aYi(), "com/tencent/mm/sdk/platformtools/ConnectivityCompat$Companion", "initSignalStrengthListener", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
        ((TelephonyManager)localObject1).listen((PhoneStateListener)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(0), ((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(1)).intValue());
        com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/sdk/platformtools/ConnectivityCompat$Companion", "initSignalStrengthListener", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
      }
      AppMethodBeat.o(243553);
    }
    
    public final void registerReceiver()
    {
      AppMethodBeat.i(243536);
      Object localObject;
      if (Build.VERSION.SDK_INT >= 24)
      {
        ConnectivityCompat.access$setNetworkCallbackImpl24$cp(new ConnectivityCompat.NetworkCallbackImpl24());
        localObject = MMApplicationContext.getContext().getSystemService("connectivity");
        if (localObject == null)
        {
          localObject = new NullPointerException("null cannot be cast to non-null type android.net.ConnectivityManager");
          AppMethodBeat.o(243536);
          throw ((Throwable)localObject);
        }
        localObject = (ConnectivityManager)localObject;
        ConnectivityCompat.NetworkCallbackImpl24 localNetworkCallbackImpl24 = ConnectivityCompat.access$getNetworkCallbackImpl24$cp();
        s.checkNotNull(localNetworkCallbackImpl24);
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
        localObject = acquireWiFiInfo();
        Log.i("MicroMsg.ConnectivityCompat", "initialized new wifi info %s", new Object[] { ((ConnectivityCompat.WiFiInfo)localObject).toString() });
        ((ConnectivityCompat.WiFiInfo)localObject).saveMMKV();
        AppMethodBeat.o(243536);
        return;
        Log.w("MicroMsg.ConnectivityCompat", s.X("connectivity compat receiver has been registered, check ", MMStack.getCaller()));
      }
    }
    
    public final void setSupervisor(ConnectivityCompat.Supervisor paramSupervisor)
    {
      AppMethodBeat.i(243528);
      ConnectivityCompat.access$setSupervisor$cp(paramSupervisor);
      AppMethodBeat.o(243528);
    }
    
    public final void startScanWiFi()
    {
      AppMethodBeat.i(243593);
      int i = MultiProcessMMKV.getMMKV("connectivity_compat").getInt("connectivity_compat_key_wifi_scan_threshold", 0);
      Log.w("MicroMsg.ConnectivityCompat", "startScanWiFi(), threshold = " + i + "/2, stack: %s", new Object[] { MMStack.getStack(true) });
      MultiProcessMMKV.getMMKV("connectivity_compat").putInt("connectivity_compat_key_wifi_scan_threshold", 2);
      Object localObject = MMApplicationContext.getContext();
      if (((Context)localObject).checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0)
      {
        Log.e("MicroMsg.ConnectivityCompat", "startScanWiFi(): access_fine_location perm not granted.");
        AppMethodBeat.o(243593);
        return;
      }
      localObject = ((Context)localObject).getApplicationContext().getSystemService("wifi");
      if (localObject == null)
      {
        localObject = new NullPointerException("null cannot be cast to non-null type android.net.wifi.WifiManager");
        AppMethodBeat.o(243593);
        throw ((Throwable)localObject);
      }
      ((Boolean)com.tencent.mm.hellhoundlib.a.a.a((WifiManager)localObject, "com/tencent/mm/sdk/platformtools/ConnectivityCompat$Companion", "startScanWiFi", "()V", "android/net/wifi/WifiManager", "startScan", "()Z")).booleanValue();
      localObject = getSupervisor();
      if (localObject != null) {
        ((ConnectivityCompat.Supervisor)localObject).report(ConnectivityCompat.Supervisor.API.START_SCAN_WIFI, false, true);
      }
      AppMethodBeat.o(243593);
    }
    
    public final void unregisterReceiver()
    {
      AppMethodBeat.i(243542);
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
          localObject = new NullPointerException("null cannot be cast to non-null type android.net.ConnectivityManager");
          AppMethodBeat.o(243542);
          throw ((Throwable)localObject);
        }
        localObject = (ConnectivityManager)localObject;
        ConnectivityCompat.NetworkCallbackImpl24 localNetworkCallbackImpl24 = ConnectivityCompat.access$getNetworkCallbackImpl24$cp();
        s.checkNotNull(localNetworkCallbackImpl24);
        ((ConnectivityManager)localObject).unregisterNetworkCallback((ConnectivityManager.NetworkCallback)localNetworkCallbackImpl24);
        Log.i("MicroMsg.ConnectivityCompat", "unregister network callback(api >= 24)");
      }
      AppMethodBeat.o(243542);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/sdk/platformtools/ConnectivityCompat$MixedSignalStrength;", "", "()V", "cdmaDbm", "", "getCdmaDbm", "()I", "setCdmaDbm", "(I)V", "gsmSignalStrength", "getGsmSignalStrength", "setGsmSignalStrength", "phoneType", "getPhoneType", "setPhoneType", "isGsm", "", "nowStrength", "libcompatible_release"}, k=1, mv={1, 5, 1}, xi=48)
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
      AppMethodBeat.i(243477);
      if (isGsm()) {}
      for (int i = this.cdmaDbm;; i = this.gsmSignalStrength * 2 - 113)
      {
        i = Math.abs(i);
        AppMethodBeat.o(243477);
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
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/sdk/platformtools/ConnectivityCompat$NetworkCallbackImpl24;", "Landroid/net/ConnectivityManager$NetworkCallback;", "()V", "onAvailable", "", "network", "Landroid/net/Network;", "libcompatible_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class NetworkCallbackImpl24
    extends ConnectivityManager.NetworkCallback
  {
    public final void onAvailable(Network paramNetwork)
    {
      AppMethodBeat.i(243900);
      s.u(paramNetwork, "network");
      Log.i("MicroMsg.ConnectivityCompat", "network available (from network callback)");
      MultiProcessMMKV.getMMKV("connectivity_compat").putLong("wifi_info_update_timestamp", System.currentTimeMillis());
      paramNetwork = ConnectivityCompat.Companion.access$acquireWiFiInfo(ConnectivityCompat.Companion);
      Log.i("MicroMsg.ConnectivityCompat", s.X("updated new wifi info (api >= 24): ", paramNetwork));
      paramNetwork.saveMMKV();
      if (ConnectivityCompat.Companion.getSupervisor() != null)
      {
        paramNetwork = ConnectivityCompat.Companion.getSupervisor();
        s.checkNotNull(paramNetwork);
        paramNetwork.report(ConnectivityCompat.Supervisor.API.GET_CONNECTION_INFO, false, true);
      }
      AppMethodBeat.o(243900);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/sdk/platformtools/ConnectivityCompat$Receiver;", "Landroid/content/BroadcastReceiver;", "()V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "libcompatible_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class Receiver
    extends BroadcastReceiver
  {
    public final void onReceive(Context paramContext, Intent paramIntent)
    {
      AppMethodBeat.i(243748);
      if (paramIntent == null)
      {
        paramContext = null;
        if (paramContext != null) {
          switch (paramContext.hashCode())
          {
          }
        }
      }
      for (;;)
      {
        AppMethodBeat.o(243748);
        return;
        paramContext = paramIntent.getAction();
        break;
        if (!paramContext.equals("android.net.wifi.RSSI_CHANGED"))
        {
          AppMethodBeat.o(243748);
          return;
          if (!paramContext.equals("android.net.wifi.SCAN_RESULTS"))
          {
            AppMethodBeat.o(243748);
            return;
            if (!paramContext.equals("android.net.conn.CONNECTIVITY_CHANGE")) {
              AppMethodBeat.o(243748);
            }
          }
          else
          {
            Log.i("MicroMsg.ConnectivityCompat", "scan results available, invalid last get time");
            MultiProcessMMKV.getMMKV("connectivity_compat").putInt("connectivity_compat_key_wifi_last_get_time", 0);
            AppMethodBeat.o(243748);
          }
        }
        else
        {
          int i = paramIntent.getIntExtra("newRssi", 0);
          MultiProcessMMKV.getMMKV("connectivity_compat").putInt("connectivity_compat_key_wifi_rssi", i);
          AppMethodBeat.o(243748);
          return;
        }
        Log.i("MicroMsg.ConnectivityCompat", "connectivity action updated");
        MultiProcessMMKV.getMMKV("connectivity_compat").putLong("wifi_info_update_timestamp", System.currentTimeMillis());
        paramContext = ConnectivityCompat.Companion.access$acquireWiFiInfo(ConnectivityCompat.Companion);
        Log.i("MicroMsg.ConnectivityCompat", s.X("updated new wifi info (api < 24): ", paramContext));
        paramContext.saveMMKV();
        if (ConnectivityCompat.Companion.getSupervisor() != null)
        {
          paramContext = ConnectivityCompat.Companion.getSupervisor();
          s.checkNotNull(paramContext);
          paramContext.report(ConnectivityCompat.Supervisor.API.GET_CONNECTION_INFO, false, true);
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/sdk/platformtools/ConnectivityCompat$Supervisor;", "", "report", "", "api", "Lcom/tencent/mm/sdk/platformtools/ConnectivityCompat$Supervisor$API;", "diff", "", "realtime", "API", "libcompatible_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface Supervisor
  {
    public abstract void report(ConnectivityCompat.Supervisor.API paramAPI, boolean paramBoolean1, boolean paramBoolean2);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/sdk/platformtools/ConnectivityCompat$WiFiInfo;", "", "()V", "bssid", "", "getBssid", "()Ljava/lang/String;", "setBssid", "(Ljava/lang/String;)V", "ipaddr", "", "getIpaddr", "()I", "setIpaddr", "(I)V", "networkId", "getNetworkId", "setNetworkId", "rssi", "getRssi", "setRssi", "ssid", "getSsid", "setSsid", "fill", "", "saveMMKV", "toString", "libcompatible_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class WiFiInfo
  {
    private String bssid = "02:00:00:00:00:00";
    private int ipaddr;
    private int networkId;
    private int rssi;
    private String ssid = "<unknown ssid>";
    
    public final void fill(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(243663);
      s.u(paramString2, "ssid");
      this.rssi = paramInt1;
      String str = paramString1;
      if (paramString1 == null) {
        str = "02:00:00:00:00:00";
      }
      this.bssid = str;
      this.ssid = paramString2;
      this.networkId = paramInt2;
      this.ipaddr = paramInt3;
      AppMethodBeat.o(243663);
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
      AppMethodBeat.i(243666);
      MultiProcessMMKV.getMMKV("connectivity_compat").putInt("connectivity_compat_key_wifi_rssi", this.rssi);
      MultiProcessMMKV.getMMKV("connectivity_compat").putString("connectivity_compat_key_wifi_ssid", this.ssid);
      MultiProcessMMKV.getMMKV("connectivity_compat").putString("connectivity_compat_key_wifi_bssid", this.bssid);
      MultiProcessMMKV.getMMKV("connectivity_compat").putInt("connectivity_compat_key_wifi_networkid", this.networkId);
      MultiProcessMMKV.getMMKV("connectivity_compat").putInt("connectivity_compat_key_wifi_idaddr", this.ipaddr);
      AppMethodBeat.o(243666);
    }
    
    public final void setBssid(String paramString)
    {
      AppMethodBeat.i(243640);
      s.u(paramString, "<set-?>");
      this.bssid = paramString;
      AppMethodBeat.o(243640);
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
      AppMethodBeat.i(243649);
      s.u(paramString, "<set-?>");
      this.ssid = paramString;
      AppMethodBeat.o(243649);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(243668);
      String str = String.format("rssi(%d), bssid(%s), ssid(%s), networkId(%d), ipaddr(%s)", Arrays.copyOf(new Object[] { Integer.valueOf(this.rssi), this.bssid, this.ssid, Integer.valueOf(this.networkId), ConnectivityCompat.Companion.access$getIPStrByInt(ConnectivityCompat.Companion, this.ipaddr) }, 5));
      s.s(str, "java.lang.String.format(this, *args)");
      AppMethodBeat.o(243668);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.ConnectivityCompat
 * JD-Core Version:    0.7.0.1
 */