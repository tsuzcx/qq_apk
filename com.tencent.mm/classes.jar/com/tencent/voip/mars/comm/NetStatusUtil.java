package com.tencent.voip.mars.comm;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.Proxy;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.provider.Settings.System;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.voip.mars.xlog.Log;
import java.lang.reflect.Method;

public class NetStatusUtil
{
  public static final int CMNET = 6;
  public static final int CMWAP = 5;
  public static final int CTNET = 8;
  public static final int CTWAP = 7;
  public static final int LTE = 10;
  public static final int MOBILE = 9;
  public static final int NETTYPE_NOT_WIFI = 0;
  public static final int NETTYPE_WIFI = 1;
  public static final int NET_3G = 4;
  public static final int NON_NETWORK = -1;
  public static final int NO_SIM_OPERATOR = 0;
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
  private static int nowStrength = 0;
  private byte _hellAccFlag_;
  
  public static void dumpNetStatus(Context paramContext)
  {
    AppMethodBeat.i(55601);
    try
    {
      Log.i("MicroMsg.NetStatusUtil", ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo().toString());
      AppMethodBeat.o(55601);
      return;
    }
    catch (Exception paramContext)
    {
      Log.e("MicroMsg.NetStatusUtil", "", new Object[] { paramContext });
      AppMethodBeat.o(55601);
    }
  }
  
  public static int getBackgroundLimitType(Context paramContext)
  {
    AppMethodBeat.i(55619);
    int i;
    if (Build.VERSION.SDK_INT >= 14) {
      try
      {
        Object localObject = Class.forName("android.app.ActivityManagerNative");
        localObject = ((Class)localObject).getMethod("getDefault", new Class[0]).invoke(localObject, new Object[0]);
        i = ((Integer)localObject.getClass().getMethod("getProcessLimit", new Class[0]).invoke(localObject, new Object[0])).intValue();
        if (i == 0)
        {
          AppMethodBeat.o(55619);
          return 1;
        }
      }
      catch (Exception localException) {}
    }
    try
    {
      i = getWifiSleeepPolicy(paramContext);
      if (i != 2)
      {
        int j = getNetType(paramContext);
        if (j == 0) {}
      }
      else
      {
        AppMethodBeat.o(55619);
        return 0;
      }
      if ((i == 1) || (i == 0))
      {
        AppMethodBeat.o(55619);
        return 3;
      }
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(55619);
    }
    return 0;
  }
  
  public static int getISPCode(Context paramContext)
  {
    AppMethodBeat.i(55606);
    paramContext = (TelephonyManager)paramContext.getSystemService("phone");
    if (paramContext == null)
    {
      AppMethodBeat.o(55606);
      return 0;
    }
    paramContext = paramContext.getSimOperator();
    if ((paramContext == null) || (paramContext.length() < 5))
    {
      AppMethodBeat.o(55606);
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
          break label142;
        }
        i = 6;
      }
      catch (Exception paramContext)
      {
        AppMethodBeat.o(55606);
        return 0;
      }
      if (j < i) {
        if (!Character.isDigit(paramContext.charAt(j)))
        {
          if (localStringBuilder.length() <= 0) {
            break label147;
          }
        }
        else
        {
          localStringBuilder.append(paramContext.charAt(j));
          break label147;
        }
      }
      int i = Integer.valueOf(localStringBuilder.toString()).intValue();
      AppMethodBeat.o(55606);
      return i;
      label142:
      int j = 0;
      continue;
      label147:
      j += 1;
    }
  }
  
  public static String getISPName(Context paramContext)
  {
    AppMethodBeat.i(55607);
    paramContext = (TelephonyManager)paramContext.getSystemService("phone");
    if (paramContext == null)
    {
      AppMethodBeat.o(55607);
      return "";
    }
    if (paramContext.getSimOperatorName().length() <= 100)
    {
      paramContext = paramContext.getSimOperatorName();
      AppMethodBeat.o(55607);
      return paramContext;
    }
    paramContext = paramContext.getSimOperatorName().substring(0, 100);
    AppMethodBeat.o(55607);
    return paramContext;
  }
  
  public static int getNetType(Context paramContext)
  {
    AppMethodBeat.i(55605);
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext == null)
    {
      AppMethodBeat.o(55605);
      return -1;
    }
    paramContext = paramContext.getActiveNetworkInfo();
    if (paramContext == null)
    {
      AppMethodBeat.o(55605);
      return -1;
    }
    if (paramContext.getType() == 1)
    {
      AppMethodBeat.o(55605);
      return 0;
    }
    if (paramContext.getExtraInfo() != null)
    {
      if (paramContext.getExtraInfo().equalsIgnoreCase("uninet"))
      {
        AppMethodBeat.o(55605);
        return 1;
      }
      if (paramContext.getExtraInfo().equalsIgnoreCase("uniwap"))
      {
        AppMethodBeat.o(55605);
        return 2;
      }
      if (paramContext.getExtraInfo().equalsIgnoreCase("3gwap"))
      {
        AppMethodBeat.o(55605);
        return 3;
      }
      if (paramContext.getExtraInfo().equalsIgnoreCase("3gnet"))
      {
        AppMethodBeat.o(55605);
        return 4;
      }
      if (paramContext.getExtraInfo().equalsIgnoreCase("cmwap"))
      {
        AppMethodBeat.o(55605);
        return 5;
      }
      if (paramContext.getExtraInfo().equalsIgnoreCase("cmnet"))
      {
        AppMethodBeat.o(55605);
        return 6;
      }
      if (paramContext.getExtraInfo().equalsIgnoreCase("ctwap"))
      {
        AppMethodBeat.o(55605);
        return 7;
      }
      if (paramContext.getExtraInfo().equalsIgnoreCase("ctnet"))
      {
        AppMethodBeat.o(55605);
        return 8;
      }
      if (paramContext.getExtraInfo().equalsIgnoreCase("LTE"))
      {
        AppMethodBeat.o(55605);
        return 10;
      }
    }
    AppMethodBeat.o(55605);
    return 9;
  }
  
  public static int getNetTypeForStat(Context paramContext)
  {
    AppMethodBeat.i(55624);
    if (paramContext == null)
    {
      AppMethodBeat.o(55624);
      return 999;
    }
    try
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramContext == null)
      {
        AppMethodBeat.o(55624);
        return 999;
      }
      paramContext = paramContext.getActiveNetworkInfo();
      if (paramContext == null)
      {
        AppMethodBeat.o(55624);
        return 999;
      }
      int i = paramContext.getType();
      if (i == 1)
      {
        AppMethodBeat.o(55624);
        return 1;
      }
      i = paramContext.getSubtype();
      if (i == 0)
      {
        AppMethodBeat.o(55624);
        return 999;
      }
      AppMethodBeat.o(55624);
      return i * 1000;
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(55624);
    }
    return 999;
  }
  
  public static String getNetTypeString(Context paramContext)
  {
    AppMethodBeat.i(55603);
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext == null)
    {
      AppMethodBeat.o(55603);
      return "NON_NETWORK";
    }
    paramContext = paramContext.getActiveNetworkInfo();
    if (paramContext == null)
    {
      AppMethodBeat.o(55603);
      return "NON_NETWORK";
    }
    if (paramContext.getType() == 1)
    {
      AppMethodBeat.o(55603);
      return "WIFI";
    }
    if (paramContext.getExtraInfo() != null)
    {
      paramContext = paramContext.getExtraInfo();
      AppMethodBeat.o(55603);
      return paramContext;
    }
    AppMethodBeat.o(55603);
    return "MOBILE";
  }
  
  public static int getNetWorkType(Context paramContext)
  {
    AppMethodBeat.i(55604);
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramContext != null)
      {
        int i = paramContext.getType();
        AppMethodBeat.o(55604);
        return i;
      }
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(55604);
    }
    return -1;
  }
  
  public static int getProxyInfo(Context paramContext, StringBuffer paramStringBuffer)
  {
    AppMethodBeat.i(55621);
    try
    {
      paramContext = Proxy.getDefaultHost();
      int i = Proxy.getDefaultPort();
      if ((paramContext != null) && (paramContext.length() > 0) && (i > 0))
      {
        paramStringBuffer.append(paramContext);
        AppMethodBeat.o(55621);
        return i;
      }
      paramContext = System.getProperty("http.proxyHost");
      String str = System.getProperty("http.proxyPort");
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
        AppMethodBeat.o(55621);
        return i;
      }
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(55621);
    }
    return 0;
  }
  
  public static int getStrength(Context paramContext)
  {
    AppMethodBeat.i(55625);
    if (paramContext == null)
    {
      AppMethodBeat.o(55625);
      return 0;
    }
    try
    {
      if (getNetTypeForStat(paramContext) == 1)
      {
        i = Math.abs(((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo().getRssi());
        AppMethodBeat.o(55625);
        return i;
      }
      ((TelephonyManager)paramContext.getSystemService("phone")).listen(new StrengthListener(), 256);
      int i = Math.abs(nowStrength);
      AppMethodBeat.o(55625);
      return i;
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(55625);
    }
    return 0;
  }
  
  public static WifiInfo getWifiInfo(Context paramContext)
  {
    AppMethodBeat.i(55615);
    try
    {
      Object localObject = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (localObject == null)
      {
        AppMethodBeat.o(55615);
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
        AppMethodBeat.o(55615);
        return null;
      }
      paramContext = (WifiManager)paramContext.getSystemService("wifi");
      if (paramContext == null)
      {
        AppMethodBeat.o(55615);
        return null;
      }
      paramContext = paramContext.getConnectionInfo();
      AppMethodBeat.o(55615);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(55615);
    }
    return null;
  }
  
  public static int getWifiSleeepPolicy(Context paramContext)
  {
    AppMethodBeat.i(55618);
    int i = Settings.System.getInt(paramContext.getContentResolver(), "wifi_sleep_policy", 2);
    AppMethodBeat.o(55618);
    return i;
  }
  
  public static int guessNetSpeed(Context paramContext)
  {
    AppMethodBeat.i(55608);
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      int i = paramContext.getType();
      if (i == 1)
      {
        AppMethodBeat.o(55608);
        return 102400;
      }
      i = paramContext.getSubtype();
      switch (i)
      {
      }
    }
    catch (Exception paramContext)
    {
      label120:
      break label120;
    }
    AppMethodBeat.o(55608);
    return 102400;
    AppMethodBeat.o(55608);
    return 4096;
    AppMethodBeat.o(55608);
    return 8192;
    AppMethodBeat.o(55608);
    return 102400;
  }
  
  public static boolean is2G(Context paramContext)
  {
    AppMethodBeat.i(55610);
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      int i = paramContext.getType();
      if (i == 1)
      {
        AppMethodBeat.o(55610);
        return false;
      }
      if ((paramContext.getSubtype() != 2) && (paramContext.getSubtype() != 1))
      {
        i = paramContext.getSubtype();
        if (i != 4) {}
      }
      else
      {
        AppMethodBeat.o(55610);
        return true;
      }
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(55610);
    }
    return false;
  }
  
  public static boolean is3G(Context paramContext)
  {
    AppMethodBeat.i(55613);
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      int i = paramContext.getType();
      if (i == 1)
      {
        AppMethodBeat.o(55613);
        return false;
      }
      if (paramContext.getSubtype() >= 5)
      {
        i = paramContext.getSubtype();
        if (i < 13)
        {
          AppMethodBeat.o(55613);
          return true;
        }
      }
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(55613);
    }
    return false;
  }
  
  public static boolean is4G(Context paramContext)
  {
    AppMethodBeat.i(55611);
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      int i = paramContext.getType();
      if (i == 1)
      {
        AppMethodBeat.o(55611);
        return false;
      }
      i = paramContext.getSubtype();
      if (i >= 13)
      {
        AppMethodBeat.o(55611);
        return true;
      }
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(55611);
    }
    return false;
  }
  
  public static boolean isConnected(Context paramContext)
  {
    AppMethodBeat.i(55602);
    paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    boolean bool1 = false;
    try
    {
      boolean bool2 = paramContext.isConnected();
      bool1 = bool2;
    }
    catch (Exception paramContext)
    {
      label28:
      break label28;
    }
    AppMethodBeat.o(55602);
    return bool1;
  }
  
  public static boolean isImmediatelyDestroyActivities(Context paramContext)
  {
    AppMethodBeat.i(55620);
    if (Settings.System.getInt(paramContext.getContentResolver(), "always_finish_activities", 0) != 0)
    {
      AppMethodBeat.o(55620);
      return true;
    }
    AppMethodBeat.o(55620);
    return false;
  }
  
  public static boolean isKnownDirectNet(Context paramContext)
  {
    AppMethodBeat.i(55622);
    int i = getNetType(paramContext);
    if ((6 == i) || (1 == i) || (4 == i) || (8 == i) || (10 == i) || (i == 0))
    {
      AppMethodBeat.o(55622);
      return true;
    }
    AppMethodBeat.o(55622);
    return false;
  }
  
  public static boolean isLimited(int paramInt)
  {
    return (paramInt == 2) || (paramInt == 1) || (paramInt == 3);
  }
  
  public static boolean isMobile(Context paramContext)
  {
    AppMethodBeat.i(55609);
    try
    {
      if (((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo().getType() != 1)
      {
        AppMethodBeat.o(55609);
        return true;
      }
      AppMethodBeat.o(55609);
      return false;
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(55609);
    }
    return false;
  }
  
  public static boolean isNetworkConnected(Context paramContext)
  {
    AppMethodBeat.i(55623);
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext == null)
    {
      AppMethodBeat.o(55623);
      return false;
    }
    paramContext = paramContext.getActiveNetworkInfo();
    if (paramContext == null)
    {
      AppMethodBeat.o(55623);
      return false;
    }
    if (paramContext.getState() == NetworkInfo.State.CONNECTED)
    {
      AppMethodBeat.o(55623);
      return true;
    }
    AppMethodBeat.o(55623);
    return false;
  }
  
  public static boolean isWap(int paramInt)
  {
    return (paramInt == 2) || (paramInt == 5) || (paramInt == 7) || (paramInt == 3);
  }
  
  public static boolean isWap(Context paramContext)
  {
    AppMethodBeat.i(55612);
    boolean bool = isWap(getNetType(paramContext));
    AppMethodBeat.o(55612);
    return bool;
  }
  
  public static boolean isWifi(int paramInt)
  {
    return paramInt == 0;
  }
  
  public static boolean isWifi(Context paramContext)
  {
    AppMethodBeat.i(55614);
    boolean bool = isWifi(getNetType(paramContext));
    AppMethodBeat.o(55614);
    return bool;
  }
  
  /* Error */
  private static Intent searchIntentByClass(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: ldc_w 359
    //   3: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokevirtual 363	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   10: astore 5
    //   12: aload 5
    //   14: iconst_0
    //   15: invokevirtual 369	android/content/pm/PackageManager:getInstalledPackages	(I)Ljava/util/List;
    //   18: astore 6
    //   20: aload 6
    //   22: ifnull +275 -> 297
    //   25: aload 6
    //   27: invokeinterface 374 1 0
    //   32: ifle +265 -> 297
    //   35: iconst_0
    //   36: istore_2
    //   37: aload 6
    //   39: invokeinterface 374 1 0
    //   44: istore_3
    //   45: iload_2
    //   46: iload_3
    //   47: if_icmpge +250 -> 297
    //   50: new 376	android/content/Intent
    //   53: dup
    //   54: invokespecial 377	android/content/Intent:<init>	()V
    //   57: astore 7
    //   59: aload 7
    //   61: aload 6
    //   63: iload_2
    //   64: invokeinterface 381 2 0
    //   69: checkcast 383	android/content/pm/PackageInfo
    //   72: getfield 386	android/content/pm/PackageInfo:packageName	Ljava/lang/String;
    //   75: invokevirtual 390	android/content/Intent:setPackage	(Ljava/lang/String;)Landroid/content/Intent;
    //   78: pop
    //   79: aload 5
    //   81: aload 7
    //   83: iconst_0
    //   84: invokevirtual 394	android/content/pm/PackageManager:queryIntentActivities	(Landroid/content/Intent;I)Ljava/util/List;
    //   87: astore 8
    //   89: aload 8
    //   91: ifnull +182 -> 273
    //   94: aload 8
    //   96: invokeinterface 374 1 0
    //   101: istore_3
    //   102: iload_3
    //   103: ifle +186 -> 289
    //   106: iconst_0
    //   107: istore 4
    //   109: iload 4
    //   111: iload_3
    //   112: if_icmpge +177 -> 289
    //   115: aload 8
    //   117: iload 4
    //   119: invokeinterface 381 2 0
    //   124: checkcast 396	android/content/pm/ResolveInfo
    //   127: getfield 400	android/content/pm/ResolveInfo:activityInfo	Landroid/content/pm/ActivityInfo;
    //   130: astore 7
    //   132: aload 7
    //   134: getfield 405	android/content/pm/ActivityInfo:name	Ljava/lang/String;
    //   137: aload_1
    //   138: invokevirtual 409	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   141: ifeq +137 -> 278
    //   144: new 376	android/content/Intent
    //   147: dup
    //   148: ldc_w 411
    //   151: invokespecial 414	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   154: astore 8
    //   156: aload 8
    //   158: new 416	android/content/ComponentName
    //   161: dup
    //   162: aload 7
    //   164: getfield 417	android/content/pm/ActivityInfo:packageName	Ljava/lang/String;
    //   167: aload 7
    //   169: getfield 405	android/content/pm/ActivityInfo:name	Ljava/lang/String;
    //   172: invokespecial 419	android/content/ComponentName:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   175: invokevirtual 423	android/content/Intent:setComponent	(Landroid/content/ComponentName;)Landroid/content/Intent;
    //   178: pop
    //   179: aload 8
    //   181: ldc_w 425
    //   184: invokevirtual 428	android/content/Intent:setAction	(Ljava/lang/String;)Landroid/content/Intent;
    //   187: pop
    //   188: new 430	com/tencent/mm/hellhoundlib/b/a
    //   191: dup
    //   192: invokespecial 431	com/tencent/mm/hellhoundlib/b/a:<init>	()V
    //   195: aload 8
    //   197: invokevirtual 435	com/tencent/mm/hellhoundlib/b/a:bd	(Ljava/lang/Object;)Lcom/tencent/mm/hellhoundlib/b/a;
    //   200: astore 7
    //   202: aload_0
    //   203: aload 7
    //   205: invokevirtual 439	com/tencent/mm/hellhoundlib/b/a:adn	()[Ljava/lang/Object;
    //   208: ldc_w 440
    //   211: ldc_w 441
    //   214: ldc_w 442
    //   217: ldc_w 444
    //   220: ldc_w 446
    //   223: ldc_w 448
    //   226: invokestatic 454	com/tencent/mm/hellhoundlib/a/a:a	(Ljava/lang/Object;[Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   229: aload_0
    //   230: aload 7
    //   232: iconst_0
    //   233: invokevirtual 457	com/tencent/mm/hellhoundlib/b/a:lS	(I)Ljava/lang/Object;
    //   236: checkcast 376	android/content/Intent
    //   239: invokevirtual 459	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   242: aload_0
    //   243: ldc_w 440
    //   246: ldc_w 441
    //   249: ldc_w 442
    //   252: ldc_w 444
    //   255: ldc_w 446
    //   258: ldc_w 448
    //   261: invokestatic 462	com/tencent/mm/hellhoundlib/a/a:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   264: ldc_w 359
    //   267: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   270: aload 8
    //   272: areturn
    //   273: iconst_0
    //   274: istore_3
    //   275: goto -173 -> 102
    //   278: iload 4
    //   280: iconst_1
    //   281: iadd
    //   282: istore 4
    //   284: goto -175 -> 109
    //   287: astore 7
    //   289: iload_2
    //   290: iconst_1
    //   291: iadd
    //   292: istore_2
    //   293: goto -256 -> 37
    //   296: astore_0
    //   297: ldc_w 359
    //   300: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   303: aconst_null
    //   304: areturn
    //   305: astore 7
    //   307: goto -18 -> 289
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	310	0	paramContext	Context
    //   0	310	1	paramString	String
    //   36	257	2	i	int
    //   44	231	3	j	int
    //   107	176	4	k	int
    //   10	70	5	localPackageManager	android.content.pm.PackageManager
    //   18	44	6	localList	java.util.List
    //   57	174	7	localObject1	Object
    //   287	1	7	localException1	Exception
    //   305	1	7	localException2	Exception
    //   87	184	8	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   50	89	287	java/lang/Exception
    //   94	102	287	java/lang/Exception
    //   6	20	296	java/lang/Exception
    //   25	35	296	java/lang/Exception
    //   37	45	296	java/lang/Exception
    //   115	264	305	java/lang/Exception
  }
  
  public static void startSettingItent(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(55617);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(55617);
      return;
      AppMethodBeat.o(55617);
      return;
      try
      {
        Object localObject1 = new Intent("/");
        ((Intent)localObject1).setComponent(new ComponentName("com.android.providers.subscribedfeeds", "com.android.settings.ManageAccountsSettings"));
        ((Intent)localObject1).setAction("android.intent.action.VIEW");
        localObject1 = new com.tencent.mm.hellhoundlib.b.a().bd(localObject1);
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject1).adn(), "com/tencent/voip/mars/comm/NetStatusUtil", "startSettingItent", "(Landroid/content/Context;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/voip/mars/comm/NetStatusUtil", "startSettingItent", "(Landroid/content/Context;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(55617);
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
          com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject2).adn(), "com/tencent/voip/mars/comm/NetStatusUtil", "startSettingItent", "(Landroid/content/Context;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/voip/mars/comm/NetStatusUtil", "startSettingItent", "(Landroid/content/Context;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(55617);
          return;
        }
        catch (Exception localException2)
        {
          searchIntentByClass(paramContext, "ManageAccountsSettings");
          AppMethodBeat.o(55617);
          return;
        }
      }
      try
      {
        Object localObject3 = new Intent("/");
        ((Intent)localObject3).setComponent(new ComponentName("com.android.settings", "com.android.settings.DevelopmentSettings"));
        ((Intent)localObject3).setAction("android.intent.action.VIEW");
        localObject3 = new com.tencent.mm.hellhoundlib.b.a().bd(localObject3);
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject3).adn(), "com/tencent/voip/mars/comm/NetStatusUtil", "startSettingItent", "(Landroid/content/Context;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject3).lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/voip/mars/comm/NetStatusUtil", "startSettingItent", "(Landroid/content/Context;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(55617);
        return;
      }
      catch (Exception localException3)
      {
        searchIntentByClass(paramContext, "DevelopmentSettings");
        AppMethodBeat.o(55617);
        return;
      }
      try
      {
        Object localObject4 = new Intent();
        ((Intent)localObject4).setAction("android.settings.WIFI_IP_SETTINGS");
        localObject4 = new com.tencent.mm.hellhoundlib.b.a().bd(localObject4);
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject4).adn(), "com/tencent/voip/mars/comm/NetStatusUtil", "startSettingItent", "(Landroid/content/Context;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject4).lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/voip/mars/comm/NetStatusUtil", "startSettingItent", "(Landroid/content/Context;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(55617);
        return;
      }
      catch (Exception localException4)
      {
        searchIntentByClass(paramContext, "AdvancedSettings");
      }
    }
  }
  
  public static class StrengthListener
    extends PhoneStateListener
  {
    public void onSignalStrengthsChanged(SignalStrength paramSignalStrength)
    {
      AppMethodBeat.i(55587);
      super.onSignalStrengthsChanged(paramSignalStrength);
      if (!paramSignalStrength.isGsm())
      {
        NetStatusUtil.access$002(paramSignalStrength.getCdmaDbm());
        AppMethodBeat.o(55587);
        return;
      }
      NetStatusUtil.access$002(paramSignalStrength.getGsmSignalStrength());
      AppMethodBeat.o(55587);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.voip.mars.comm.NetStatusUtil
 * JD-Core Version:    0.7.0.1
 */