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
  
  public static void dumpNetStatus(Context paramContext)
  {
    AppMethodBeat.i(92764);
    try
    {
      Log.i("MicroMsg.NetStatusUtil", ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo().toString());
      AppMethodBeat.o(92764);
      return;
    }
    catch (Exception paramContext)
    {
      Log.e("MicroMsg.NetStatusUtil", "", new Object[] { paramContext });
      AppMethodBeat.o(92764);
    }
  }
  
  public static int getBackgroundLimitType(Context paramContext)
  {
    AppMethodBeat.i(92782);
    int i;
    if (Build.VERSION.SDK_INT >= 14) {
      try
      {
        Object localObject = Class.forName("android.app.ActivityManagerNative");
        localObject = ((Class)localObject).getMethod("getDefault", new Class[0]).invoke(localObject, new Object[0]);
        i = ((Integer)localObject.getClass().getMethod("getProcessLimit", new Class[0]).invoke(localObject, new Object[0])).intValue();
        if (i == 0)
        {
          AppMethodBeat.o(92782);
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
        AppMethodBeat.o(92782);
        return 0;
      }
      if ((i == 1) || (i == 0))
      {
        AppMethodBeat.o(92782);
        return 3;
      }
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(92782);
    }
    return 0;
  }
  
  public static int getISPCode(Context paramContext)
  {
    AppMethodBeat.i(92769);
    paramContext = (TelephonyManager)paramContext.getSystemService("phone");
    if (paramContext == null)
    {
      AppMethodBeat.o(92769);
      return 0;
    }
    paramContext = paramContext.getSimOperator();
    if ((paramContext == null) || (paramContext.length() < 5))
    {
      AppMethodBeat.o(92769);
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
        AppMethodBeat.o(92769);
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
      AppMethodBeat.o(92769);
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
    AppMethodBeat.i(92770);
    paramContext = (TelephonyManager)paramContext.getSystemService("phone");
    if (paramContext == null)
    {
      AppMethodBeat.o(92770);
      return "";
    }
    if (paramContext.getSimOperatorName().length() <= 100)
    {
      paramContext = paramContext.getSimOperatorName();
      AppMethodBeat.o(92770);
      return paramContext;
    }
    paramContext = paramContext.getSimOperatorName().substring(0, 100);
    AppMethodBeat.o(92770);
    return paramContext;
  }
  
  public static int getNetType(Context paramContext)
  {
    AppMethodBeat.i(92768);
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext == null)
    {
      AppMethodBeat.o(92768);
      return -1;
    }
    paramContext = paramContext.getActiveNetworkInfo();
    if (paramContext == null)
    {
      AppMethodBeat.o(92768);
      return -1;
    }
    if (paramContext.getType() == 1)
    {
      AppMethodBeat.o(92768);
      return 0;
    }
    if (paramContext.getExtraInfo() != null)
    {
      if (paramContext.getExtraInfo().equalsIgnoreCase("uninet"))
      {
        AppMethodBeat.o(92768);
        return 1;
      }
      if (paramContext.getExtraInfo().equalsIgnoreCase("uniwap"))
      {
        AppMethodBeat.o(92768);
        return 2;
      }
      if (paramContext.getExtraInfo().equalsIgnoreCase("3gwap"))
      {
        AppMethodBeat.o(92768);
        return 3;
      }
      if (paramContext.getExtraInfo().equalsIgnoreCase("3gnet"))
      {
        AppMethodBeat.o(92768);
        return 4;
      }
      if (paramContext.getExtraInfo().equalsIgnoreCase("cmwap"))
      {
        AppMethodBeat.o(92768);
        return 5;
      }
      if (paramContext.getExtraInfo().equalsIgnoreCase("cmnet"))
      {
        AppMethodBeat.o(92768);
        return 6;
      }
      if (paramContext.getExtraInfo().equalsIgnoreCase("ctwap"))
      {
        AppMethodBeat.o(92768);
        return 7;
      }
      if (paramContext.getExtraInfo().equalsIgnoreCase("ctnet"))
      {
        AppMethodBeat.o(92768);
        return 8;
      }
      if (paramContext.getExtraInfo().equalsIgnoreCase("LTE"))
      {
        AppMethodBeat.o(92768);
        return 10;
      }
    }
    AppMethodBeat.o(92768);
    return 9;
  }
  
  public static int getNetTypeForStat(Context paramContext)
  {
    AppMethodBeat.i(92787);
    if (paramContext == null)
    {
      AppMethodBeat.o(92787);
      return 999;
    }
    try
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramContext == null)
      {
        AppMethodBeat.o(92787);
        return 999;
      }
      paramContext = paramContext.getActiveNetworkInfo();
      if (paramContext == null)
      {
        AppMethodBeat.o(92787);
        return 999;
      }
      int i = paramContext.getType();
      if (i == 1)
      {
        AppMethodBeat.o(92787);
        return 1;
      }
      i = paramContext.getSubtype();
      if (i == 0)
      {
        AppMethodBeat.o(92787);
        return 999;
      }
      AppMethodBeat.o(92787);
      return i * 1000;
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(92787);
    }
    return 999;
  }
  
  public static String getNetTypeString(Context paramContext)
  {
    AppMethodBeat.i(92766);
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext == null)
    {
      AppMethodBeat.o(92766);
      return "NON_NETWORK";
    }
    paramContext = paramContext.getActiveNetworkInfo();
    if (paramContext == null)
    {
      AppMethodBeat.o(92766);
      return "NON_NETWORK";
    }
    if (paramContext.getType() == 1)
    {
      AppMethodBeat.o(92766);
      return "WIFI";
    }
    if (paramContext.getExtraInfo() != null)
    {
      paramContext = paramContext.getExtraInfo();
      AppMethodBeat.o(92766);
      return paramContext;
    }
    AppMethodBeat.o(92766);
    return "MOBILE";
  }
  
  public static int getNetWorkType(Context paramContext)
  {
    AppMethodBeat.i(92767);
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramContext != null)
      {
        int i = paramContext.getType();
        AppMethodBeat.o(92767);
        return i;
      }
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(92767);
    }
    return -1;
  }
  
  public static int getProxyInfo(Context paramContext, StringBuffer paramStringBuffer)
  {
    AppMethodBeat.i(92784);
    try
    {
      paramContext = Proxy.getDefaultHost();
      int i = Proxy.getDefaultPort();
      if ((paramContext != null) && (paramContext.length() > 0) && (i > 0))
      {
        paramStringBuffer.append(paramContext);
        AppMethodBeat.o(92784);
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
        AppMethodBeat.o(92784);
        return i;
      }
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(92784);
    }
    return 0;
  }
  
  public static int getStrength(Context paramContext)
  {
    AppMethodBeat.i(92788);
    if (paramContext == null)
    {
      AppMethodBeat.o(92788);
      return 0;
    }
    try
    {
      if (getNetTypeForStat(paramContext) == 1)
      {
        i = Math.abs(((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo().getRssi());
        AppMethodBeat.o(92788);
        return i;
      }
      ((TelephonyManager)paramContext.getSystemService("phone")).listen(new NetStatusUtil.StrengthListener(), 256);
      int i = Math.abs(nowStrength);
      AppMethodBeat.o(92788);
      return i;
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(92788);
    }
    return 0;
  }
  
  public static WifiInfo getWifiInfo(Context paramContext)
  {
    AppMethodBeat.i(92778);
    try
    {
      Object localObject = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (localObject == null)
      {
        AppMethodBeat.o(92778);
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
        AppMethodBeat.o(92778);
        return null;
      }
      paramContext = (WifiManager)paramContext.getSystemService("wifi");
      if (paramContext == null)
      {
        AppMethodBeat.o(92778);
        return null;
      }
      paramContext = paramContext.getConnectionInfo();
      AppMethodBeat.o(92778);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(92778);
    }
    return null;
  }
  
  public static int getWifiSleeepPolicy(Context paramContext)
  {
    AppMethodBeat.i(92781);
    int i = Settings.System.getInt(paramContext.getContentResolver(), "wifi_sleep_policy", 2);
    AppMethodBeat.o(92781);
    return i;
  }
  
  public static int guessNetSpeed(Context paramContext)
  {
    AppMethodBeat.i(92771);
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      int i = paramContext.getType();
      if (i == 1)
      {
        AppMethodBeat.o(92771);
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
    AppMethodBeat.o(92771);
    return 102400;
    AppMethodBeat.o(92771);
    return 4096;
    AppMethodBeat.o(92771);
    return 8192;
    AppMethodBeat.o(92771);
    return 102400;
  }
  
  public static boolean is2G(Context paramContext)
  {
    AppMethodBeat.i(92773);
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      int i = paramContext.getType();
      if (i == 1)
      {
        AppMethodBeat.o(92773);
        return false;
      }
      if ((paramContext.getSubtype() != 2) && (paramContext.getSubtype() != 1))
      {
        i = paramContext.getSubtype();
        if (i != 4) {}
      }
      else
      {
        AppMethodBeat.o(92773);
        return true;
      }
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(92773);
    }
    return false;
  }
  
  public static boolean is3G(Context paramContext)
  {
    AppMethodBeat.i(92776);
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      int i = paramContext.getType();
      if (i == 1)
      {
        AppMethodBeat.o(92776);
        return false;
      }
      if (paramContext.getSubtype() >= 5)
      {
        i = paramContext.getSubtype();
        if (i < 13)
        {
          AppMethodBeat.o(92776);
          return true;
        }
      }
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(92776);
    }
    return false;
  }
  
  public static boolean is4G(Context paramContext)
  {
    AppMethodBeat.i(92774);
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      int i = paramContext.getType();
      if (i == 1)
      {
        AppMethodBeat.o(92774);
        return false;
      }
      i = paramContext.getSubtype();
      if (i >= 13)
      {
        AppMethodBeat.o(92774);
        return true;
      }
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(92774);
    }
    return false;
  }
  
  public static boolean isConnected(Context paramContext)
  {
    AppMethodBeat.i(92765);
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
    AppMethodBeat.o(92765);
    return bool1;
  }
  
  public static boolean isImmediatelyDestroyActivities(Context paramContext)
  {
    AppMethodBeat.i(92783);
    if (Settings.System.getInt(paramContext.getContentResolver(), "always_finish_activities", 0) != 0)
    {
      AppMethodBeat.o(92783);
      return true;
    }
    AppMethodBeat.o(92783);
    return false;
  }
  
  public static boolean isKnownDirectNet(Context paramContext)
  {
    AppMethodBeat.i(92785);
    int i = getNetType(paramContext);
    if ((6 == i) || (1 == i) || (4 == i) || (8 == i) || (10 == i) || (i == 0))
    {
      AppMethodBeat.o(92785);
      return true;
    }
    AppMethodBeat.o(92785);
    return false;
  }
  
  public static boolean isLimited(int paramInt)
  {
    return (paramInt == 2) || (paramInt == 1) || (paramInt == 3);
  }
  
  public static boolean isMobile(Context paramContext)
  {
    AppMethodBeat.i(92772);
    try
    {
      if (((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo().getType() != 1)
      {
        AppMethodBeat.o(92772);
        return true;
      }
      AppMethodBeat.o(92772);
      return false;
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(92772);
    }
    return false;
  }
  
  public static boolean isNetworkConnected(Context paramContext)
  {
    AppMethodBeat.i(92786);
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext == null)
    {
      AppMethodBeat.o(92786);
      return false;
    }
    paramContext = paramContext.getActiveNetworkInfo();
    if (paramContext == null)
    {
      AppMethodBeat.o(92786);
      return false;
    }
    if (paramContext.getState() == NetworkInfo.State.CONNECTED)
    {
      AppMethodBeat.o(92786);
      return true;
    }
    AppMethodBeat.o(92786);
    return false;
  }
  
  public static boolean isWap(int paramInt)
  {
    return (paramInt == 2) || (paramInt == 5) || (paramInt == 7) || (paramInt == 3);
  }
  
  public static boolean isWap(Context paramContext)
  {
    AppMethodBeat.i(92775);
    boolean bool = isWap(getNetType(paramContext));
    AppMethodBeat.o(92775);
    return bool;
  }
  
  public static boolean isWifi(int paramInt)
  {
    return paramInt == 0;
  }
  
  public static boolean isWifi(Context paramContext)
  {
    AppMethodBeat.i(92777);
    boolean bool = isWifi(getNetType(paramContext));
    AppMethodBeat.o(92777);
    return bool;
  }
  
  /* Error */
  private static Intent searchIntentByClass(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: ldc_w 356
    //   3: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokevirtual 360	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   10: astore 5
    //   12: aload 5
    //   14: iconst_0
    //   15: invokevirtual 366	android/content/pm/PackageManager:getInstalledPackages	(I)Ljava/util/List;
    //   18: astore 6
    //   20: aload 6
    //   22: ifnull +205 -> 227
    //   25: aload 6
    //   27: invokeinterface 371 1 0
    //   32: ifle +195 -> 227
    //   35: iconst_0
    //   36: istore_2
    //   37: aload 6
    //   39: invokeinterface 371 1 0
    //   44: istore_3
    //   45: iload_2
    //   46: iload_3
    //   47: if_icmpge +180 -> 227
    //   50: new 373	android/content/Intent
    //   53: dup
    //   54: invokespecial 374	android/content/Intent:<init>	()V
    //   57: astore 7
    //   59: aload 7
    //   61: aload 6
    //   63: iload_2
    //   64: invokeinterface 378 2 0
    //   69: checkcast 380	android/content/pm/PackageInfo
    //   72: getfield 383	android/content/pm/PackageInfo:packageName	Ljava/lang/String;
    //   75: invokevirtual 387	android/content/Intent:setPackage	(Ljava/lang/String;)Landroid/content/Intent;
    //   78: pop
    //   79: aload 5
    //   81: aload 7
    //   83: iconst_0
    //   84: invokevirtual 391	android/content/pm/PackageManager:queryIntentActivities	(Landroid/content/Intent;I)Ljava/util/List;
    //   87: astore 8
    //   89: aload 8
    //   91: ifnull +112 -> 203
    //   94: aload 8
    //   96: invokeinterface 371 1 0
    //   101: istore_3
    //   102: iload_3
    //   103: ifle +116 -> 219
    //   106: iconst_0
    //   107: istore 4
    //   109: iload 4
    //   111: iload_3
    //   112: if_icmpge +107 -> 219
    //   115: aload 8
    //   117: iload 4
    //   119: invokeinterface 378 2 0
    //   124: checkcast 393	android/content/pm/ResolveInfo
    //   127: getfield 397	android/content/pm/ResolveInfo:activityInfo	Landroid/content/pm/ActivityInfo;
    //   130: astore 7
    //   132: aload 7
    //   134: getfield 402	android/content/pm/ActivityInfo:name	Ljava/lang/String;
    //   137: aload_1
    //   138: invokevirtual 406	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   141: ifeq +67 -> 208
    //   144: new 373	android/content/Intent
    //   147: dup
    //   148: ldc_w 408
    //   151: invokespecial 411	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   154: astore 8
    //   156: aload 8
    //   158: new 413	android/content/ComponentName
    //   161: dup
    //   162: aload 7
    //   164: getfield 414	android/content/pm/ActivityInfo:packageName	Ljava/lang/String;
    //   167: aload 7
    //   169: getfield 402	android/content/pm/ActivityInfo:name	Ljava/lang/String;
    //   172: invokespecial 416	android/content/ComponentName:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   175: invokevirtual 420	android/content/Intent:setComponent	(Landroid/content/ComponentName;)Landroid/content/Intent;
    //   178: pop
    //   179: aload 8
    //   181: ldc_w 422
    //   184: invokevirtual 425	android/content/Intent:setAction	(Ljava/lang/String;)Landroid/content/Intent;
    //   187: pop
    //   188: aload_0
    //   189: aload 8
    //   191: invokevirtual 429	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   194: ldc_w 356
    //   197: invokestatic 96	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   200: aload 8
    //   202: areturn
    //   203: iconst_0
    //   204: istore_3
    //   205: goto -103 -> 102
    //   208: iload 4
    //   210: iconst_1
    //   211: iadd
    //   212: istore 4
    //   214: goto -105 -> 109
    //   217: astore 7
    //   219: iload_2
    //   220: iconst_1
    //   221: iadd
    //   222: istore_2
    //   223: goto -186 -> 37
    //   226: astore_0
    //   227: ldc_w 356
    //   230: invokestatic 96	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   233: aconst_null
    //   234: areturn
    //   235: astore 7
    //   237: goto -18 -> 219
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	240	0	paramContext	Context
    //   0	240	1	paramString	String
    //   36	187	2	i	int
    //   44	161	3	j	int
    //   107	106	4	k	int
    //   10	70	5	localPackageManager	android.content.pm.PackageManager
    //   18	44	6	localList	java.util.List
    //   57	111	7	localObject1	Object
    //   217	1	7	localException1	Exception
    //   235	1	7	localException2	Exception
    //   87	114	8	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   50	89	217	java/lang/Exception
    //   94	102	217	java/lang/Exception
    //   6	20	226	java/lang/Exception
    //   25	35	226	java/lang/Exception
    //   37	45	226	java/lang/Exception
    //   115	194	235	java/lang/Exception
  }
  
  public static void startSettingItent(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(92780);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(92780);
      return;
      AppMethodBeat.o(92780);
      return;
      try
      {
        Intent localIntent1 = new Intent("/");
        localIntent1.setComponent(new ComponentName("com.android.providers.subscribedfeeds", "com.android.settings.ManageAccountsSettings"));
        localIntent1.setAction("android.intent.action.VIEW");
        paramContext.startActivity(localIntent1);
        AppMethodBeat.o(92780);
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
          AppMethodBeat.o(92780);
          return;
        }
        catch (Exception localException2)
        {
          searchIntentByClass(paramContext, "ManageAccountsSettings");
          AppMethodBeat.o(92780);
          return;
        }
      }
      try
      {
        Intent localIntent3 = new Intent("/");
        localIntent3.setComponent(new ComponentName("com.android.settings", "com.android.settings.DevelopmentSettings"));
        localIntent3.setAction("android.intent.action.VIEW");
        paramContext.startActivity(localIntent3);
        AppMethodBeat.o(92780);
        return;
      }
      catch (Exception localException3)
      {
        searchIntentByClass(paramContext, "DevelopmentSettings");
        AppMethodBeat.o(92780);
        return;
      }
      try
      {
        Intent localIntent4 = new Intent();
        localIntent4.setAction("android.settings.WIFI_IP_SETTINGS");
        paramContext.startActivity(localIntent4);
        AppMethodBeat.o(92780);
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
 * Qualified Name:     com.tencent.voip.mars.comm.NetStatusUtil
 * JD-Core Version:    0.7.0.1
 */