package com.tencent.mm.plugin.sns.ad.j;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Environment;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.plugin.sns.ad.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import com.tencent.xweb.util.k;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class g
{
  private static String PNk;
  private static String PNs;
  private static String PNu;
  private static Map<Integer, String> Qdn;
  private static Map<Integer, String> Qdo;
  private static Map<Integer, String> Qdp;
  private static String Qdq;
  private static int Qdr;
  private static String androidId;
  private static String hEl;
  private static String imei;
  private static volatile String uuid;
  private static String zxR;
  
  static
  {
    AppMethodBeat.i(309823);
    PNk = "";
    hEl = "";
    Qdn = new ConcurrentHashMap();
    imei = "";
    Qdo = new ConcurrentHashMap();
    zxR = "";
    Qdp = new ConcurrentHashMap();
    PNs = "";
    androidId = "";
    uuid = "";
    PNu = "";
    AppMethodBeat.o(309823);
  }
  
  public static String aOY()
  {
    AppMethodBeat.i(309739);
    Object localObject1;
    if (!Util.isNullOrNil(imei))
    {
      localObject1 = imei;
      AppMethodBeat.o(309739);
      return localObject1;
    }
    if ((Build.VERSION.SDK_INT < 29) && (Build.VERSION.SDK_INT >= 26))
    {
      localObject1 = MMApplicationContext.getContext();
      if (localObject1 == null) {}
    }
    for (;;)
    {
      try
      {
        localObject1 = ((Context)localObject1).getSystemService("phone");
        boolean bool = localObject1 instanceof TelephonyManager;
        if (bool) {
          continue;
        }
      }
      finally
      {
        Log.e("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.getIMEI: " + localObject2.toString());
        continue;
      }
      localObject1 = imei;
      AppMethodBeat.o(309739);
      return localObject1;
      localObject1 = (TelephonyManager)TelephonyManager.class.cast(localObject1);
      if (localObject1 != null)
      {
        localObject1 = (String)com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/sns/ad/utils/DeviceInfoUtils", "getIMEI", "()Ljava/lang/String;", "android/telephony/TelephonyManager", "getImei", "()Ljava/lang/String;");
        if (!Util.isNullOrNil((String)localObject1)) {
          imei = (String)localObject1;
        }
      }
    }
  }
  
  public static String aOZ()
  {
    AppMethodBeat.i(309777);
    Object localObject1;
    if (!Util.isNullOrNil(PNs))
    {
      localObject1 = PNs;
      AppMethodBeat.o(309777);
      return localObject1;
    }
    if (Build.VERSION.SDK_INT < 29)
    {
      localObject1 = MMApplicationContext.getContext();
      if (localObject1 == null) {}
    }
    for (;;)
    {
      try
      {
        localObject1 = ((Context)localObject1).getSystemService("phone");
        boolean bool = localObject1 instanceof TelephonyManager;
        if (bool) {
          continue;
        }
      }
      finally
      {
        Log.e("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.getIMSI: " + localObject2.toString());
        continue;
      }
      localObject1 = PNs;
      AppMethodBeat.o(309777);
      return localObject1;
      localObject1 = (TelephonyManager)TelephonyManager.class.cast(localObject1);
      if (localObject1 != null)
      {
        localObject1 = (String)com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/sns/ad/utils/DeviceInfoUtils", "getIMSI", "()Ljava/lang/String;", "android/telephony/TelephonyManager", "getSubscriberId", "()Ljava/lang/String;");
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          PNs = (String)localObject1;
        }
      }
    }
  }
  
  public static String aPk()
  {
    AppMethodBeat.i(309713);
    String str;
    if (!Util.isNullOrNil(PNk))
    {
      str = PNk;
      AppMethodBeat.o(309713);
      return str;
    }
    try
    {
      PNk = q.aPk();
      str = PNk;
      AppMethodBeat.o(309713);
      return str;
    }
    finally
    {
      for (;;)
      {
        Log.e("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.getOAID: " + localObject.toString());
      }
    }
  }
  
  public static String aWS(String paramString)
  {
    AppMethodBeat.i(309810);
    for (;;)
    {
      try
      {
        if (hcp())
        {
          if (!Util.isNullOrNil(PNu))
          {
            localObject1 = PNu;
            AppMethodBeat.o(309810);
            return localObject1;
          }
          if (Util.isNullOrNil(paramString))
          {
            Log.e("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.getHarmonyInfoFromSystemProperties: this aPhone supports HarmonyOS but propertyName is null or nil");
            AppMethodBeat.o(309810);
            return "0.0.0";
          }
          PNu = "0.0.0";
          Object localObject1 = Class.forName("android.os.SystemProperties");
          localObject1 = (String)((Class)localObject1).getDeclaredMethod("get", new Class[] { String.class }).invoke(localObject1, new Object[] { paramString });
          if (Util.isNullOrNil((String)localObject1)) {
            continue;
          }
          PNu = (String)localObject1;
        }
      }
      finally
      {
        Log.e("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.getHarmonyInfoFromSystemProperties: propertyName is " + paramString + ", " + localObject2.toString());
        continue;
      }
      paramString = PNu;
      AppMethodBeat.o(309810);
      return paramString;
      Log.e("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.getHarmonyInfoFromSystemProperties: propertyName is " + paramString + ", this aPhone supports HarmonyOS but harmonyOSVersion is null or nil");
    }
  }
  
  public static String ajQ(int paramInt)
  {
    AppMethodBeat.i(309731);
    Object localObject1 = (String)Qdn.get(Integer.valueOf(paramInt));
    if (!Util.isNullOrNil((String)localObject1))
    {
      AppMethodBeat.o(309731);
      return localObject1;
    }
    if ((Build.VERSION.SDK_INT < 29) && (Build.VERSION.SDK_INT >= 23))
    {
      localObject1 = MMApplicationContext.getContext();
      if (localObject1 == null) {}
    }
    for (;;)
    {
      try
      {
        localObject1 = ((Context)localObject1).getSystemService("phone");
        boolean bool = localObject1 instanceof TelephonyManager;
        if (bool) {
          continue;
        }
      }
      finally
      {
        Log.e("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.getDeviceId" + paramInt + ": " + localObject2.toString());
        continue;
      }
      localObject1 = Util.nullAsNil((String)Qdn.get(Integer.valueOf(paramInt)));
      AppMethodBeat.o(309731);
      return localObject1;
      localObject1 = (TelephonyManager)TelephonyManager.class.cast(localObject1);
      if (localObject1 != null)
      {
        localObject1 = (String)com.tencent.mm.hellhoundlib.a.a.a(localObject1, c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a()).aYi(), "com/tencent/mm/plugin/sns/ad/utils/DeviceInfoUtils", "getDeviceId", "(I)Ljava/lang/String;", "android/telephony/TelephonyManager", "getDeviceId", "(I)Ljava/lang/String;");
        if (!Util.isNullOrNil((String)localObject1)) {
          Qdn.put(Integer.valueOf(paramInt), localObject1);
        }
      }
    }
  }
  
  public static String ajR(int paramInt)
  {
    AppMethodBeat.i(309750);
    Object localObject1 = (String)Qdo.get(Integer.valueOf(paramInt));
    if (!Util.isNullOrNil((String)localObject1))
    {
      AppMethodBeat.o(309750);
      return localObject1;
    }
    if ((Build.VERSION.SDK_INT < 29) && (Build.VERSION.SDK_INT >= 26))
    {
      localObject1 = MMApplicationContext.getContext();
      if (localObject1 == null) {}
    }
    for (;;)
    {
      try
      {
        localObject1 = ((Context)localObject1).getSystemService("phone");
        boolean bool = localObject1 instanceof TelephonyManager;
        if (bool) {
          continue;
        }
      }
      finally
      {
        Log.e("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.getIMEI" + paramInt + ": " + localObject2.toString());
        continue;
      }
      localObject1 = Util.nullAsNil((String)Qdo.get(Integer.valueOf(paramInt)));
      AppMethodBeat.o(309750);
      return localObject1;
      localObject1 = (TelephonyManager)TelephonyManager.class.cast(localObject1);
      if (localObject1 != null)
      {
        localObject1 = (String)com.tencent.mm.hellhoundlib.a.a.a(localObject1, c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a()).aYi(), "com/tencent/mm/plugin/sns/ad/utils/DeviceInfoUtils", "getIMEI", "(I)Ljava/lang/String;", "android/telephony/TelephonyManager", "getImei", "(I)Ljava/lang/String;");
        if (!Util.isNullOrNil((String)localObject1)) {
          Qdo.put(Integer.valueOf(paramInt), localObject1);
        }
      }
    }
  }
  
  public static String ajS(int paramInt)
  {
    AppMethodBeat.i(309769);
    Object localObject1 = (String)Qdp.get(Integer.valueOf(paramInt));
    if (!Util.isNullOrNil((String)localObject1))
    {
      AppMethodBeat.o(309769);
      return localObject1;
    }
    if ((Build.VERSION.SDK_INT < 29) && (Build.VERSION.SDK_INT >= 26))
    {
      localObject1 = MMApplicationContext.getContext();
      if (localObject1 == null) {}
    }
    for (;;)
    {
      try
      {
        localObject1 = ((Context)localObject1).getSystemService("phone");
        boolean bool = localObject1 instanceof TelephonyManager;
        if (bool) {
          continue;
        }
      }
      finally
      {
        Log.e("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.getMEID" + paramInt + ": " + localObject2.toString());
        continue;
      }
      localObject1 = Util.nullAsNil((String)Qdp.get(Integer.valueOf(paramInt)));
      AppMethodBeat.o(309769);
      return localObject1;
      localObject1 = (TelephonyManager)TelephonyManager.class.cast(localObject1);
      if (localObject1 != null)
      {
        localObject1 = (String)com.tencent.mm.hellhoundlib.a.a.a(localObject1, c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a()).aYi(), "com/tencent/mm/plugin/sns/ad/utils/DeviceInfoUtils", "getMEID", "(I)Ljava/lang/String;", "android/telephony/TelephonyManager", "getMeid", "(I)Ljava/lang/String;");
        if (!Util.isNullOrNil((String)localObject1)) {
          Qdp.put(Integer.valueOf(paramInt), localObject1);
        }
      }
    }
  }
  
  public static String bRM()
  {
    AppMethodBeat.i(309724);
    Object localObject1;
    if (!Util.isNullOrNil(hEl))
    {
      localObject1 = hEl;
      AppMethodBeat.o(309724);
      return localObject1;
    }
    if (Build.VERSION.SDK_INT < 29)
    {
      localObject1 = MMApplicationContext.getContext();
      if (localObject1 == null) {}
    }
    for (;;)
    {
      try
      {
        localObject1 = ((Context)localObject1).getSystemService("phone");
        boolean bool = localObject1 instanceof TelephonyManager;
        if (bool) {
          continue;
        }
      }
      finally
      {
        Log.e("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.getDeviceId: " + localObject2.toString());
        continue;
      }
      localObject1 = hEl;
      AppMethodBeat.o(309724);
      return localObject1;
      localObject1 = (TelephonyManager)TelephonyManager.class.cast(localObject1);
      if (localObject1 != null)
      {
        localObject1 = (String)com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/sns/ad/utils/DeviceInfoUtils", "getDeviceId", "()Ljava/lang/String;", "android/telephony/TelephonyManager", "getDeviceId", "()Ljava/lang/String;");
        if (!Util.isNullOrNil((String)localObject1)) {
          hEl = (String)localObject1;
        }
      }
    }
  }
  
  public static String getAndroidId()
  {
    AppMethodBeat.i(309786);
    String str = q.getAndroidId();
    AppMethodBeat.o(309786);
    return str;
  }
  
  public static String hcl()
  {
    AppMethodBeat.i(309758);
    Object localObject1;
    if (!Util.isNullOrNil(zxR))
    {
      localObject1 = zxR;
      AppMethodBeat.o(309758);
      return localObject1;
    }
    if ((Build.VERSION.SDK_INT < 29) && (Build.VERSION.SDK_INT >= 26))
    {
      localObject1 = MMApplicationContext.getContext();
      if (localObject1 == null) {}
    }
    for (;;)
    {
      try
      {
        localObject1 = ((Context)localObject1).getSystemService("phone");
        boolean bool = localObject1 instanceof TelephonyManager;
        if (bool) {
          continue;
        }
      }
      finally
      {
        Log.e("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.getMEID: " + localObject2.toString());
        continue;
      }
      localObject1 = zxR;
      AppMethodBeat.o(309758);
      return localObject1;
      localObject1 = (TelephonyManager)TelephonyManager.class.cast(localObject1);
      if (localObject1 != null)
      {
        localObject1 = (String)com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/sns/ad/utils/DeviceInfoUtils", "getMEID", "()Ljava/lang/String;", "android/telephony/TelephonyManager", "getMeid", "()Ljava/lang/String;");
        if (!Util.isNullOrNil((String)localObject1)) {
          zxR = (String)localObject1;
        }
      }
    }
  }
  
  public static String hcm()
  {
    AppMethodBeat.i(309781);
    try
    {
      String str = q.eD(false);
      AppMethodBeat.o(309781);
      return str;
    }
    finally
    {
      Log.e("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.getIMEIWx: " + localObject.toString());
      AppMethodBeat.o(309781);
    }
    return "";
  }
  
  public static String hcn()
  {
    AppMethodBeat.i(309793);
    try
    {
      if (!Util.isNullOrNil(Qdq))
      {
        str = Qdq;
        AppMethodBeat.o(309793);
        return str;
      }
      String str = Util.nullAsNil(System.getProperty("http.agent"));
      Qdq = str;
      AppMethodBeat.o(309793);
      return str;
    }
    finally
    {
      Log.e("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.getAndroidUserAgent: " + localObject.toString());
      AppMethodBeat.o(309793);
    }
    return "";
  }
  
  public static String hco()
  {
    AppMethodBeat.i(309798);
    h.ahAA.bm(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(309826);
        try
        {
          long l1 = System.currentTimeMillis();
          if (!TextUtils.equals(Environment.getExternalStorageState(), "mounted"))
          {
            Log.e("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.getUUId: Environment.getExternalStorageState is not equals Environment.MEDIA_MOUNTED");
            g.jdMethod_if("");
            AppMethodBeat.o(309826);
            return;
          }
          b localb1 = new b("Tencent/ams/cache", "meta.dat");
          b localb2 = new b("Android/data/com.tencent.ams/cache", "meta.dat");
          if ((!localb1.open()) || (!localb2.open()))
          {
            Log.e("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.getUUId: file or fileBackup can not open");
            g.jdMethod_if("");
            localb1.close();
            localb2.close();
            AppMethodBeat.o(309826);
            return;
          }
          Object localObject1 = localb1.gZD();
          String str = localb2.gZD();
          if (!Util.isNullOrNil((String)localObject1)) {
            Log.i("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.getUUId: result from file is ".concat(String.valueOf(localObject1)));
          }
          for (;;)
          {
            g.jdMethod_if((String)localObject1);
            localb1.close();
            localb2.close();
            long l2 = System.currentTimeMillis();
            Log.i("AdDeviceInfo.DeviceInfoUtils", "getUUId, timeCost = " + (l2 - l1) + ", len = " + ((String)localObject1).length() + ", result = " + (String)localObject1);
            AppMethodBeat.o(309826);
            return;
            if (!Util.isNullOrNil(str))
            {
              Log.i("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.getUUId: result from fileBackup is ".concat(String.valueOf(str)));
              localObject1 = str;
            }
            else
            {
              localObject1 = "";
              Log.i("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.getUUId: result from file and fileBackup is null");
            }
          }
          return;
        }
        finally
        {
          Log.e("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.getUUId: " + localObject2.toString());
          AppMethodBeat.o(309826);
        }
      }
    });
    String str = uuid;
    AppMethodBeat.o(309798);
    return str;
  }
  
  public static boolean hcp()
  {
    AppMethodBeat.i(309803);
    try
    {
      int i = Qdr;
      if (i == 1)
      {
        AppMethodBeat.o(309803);
        return true;
      }
      i = Qdr;
      if (i == 2)
      {
        AppMethodBeat.o(309803);
        return false;
      }
      Qdr = 2;
      Object localObject1 = k.rc("com.huawei.system.BuildEx", "getOsBrand");
      if ((localObject1 instanceof String))
      {
        localObject1 = (String)localObject1;
        if ((!Util.isNullOrNil((String)localObject1)) && ("harmony".equals(localObject1)))
        {
          Qdr = 1;
          AppMethodBeat.o(309803);
          return true;
        }
        Log.i("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.isSupportHarmonyOS: this aPhone not supports HarmonyOS and osNameStr is ".concat(String.valueOf(localObject1)));
      }
    }
    finally
    {
      for (;;)
      {
        Log.e("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.isSupportHarmonyOS: " + localObject2.toString());
      }
    }
    AppMethodBeat.o(309803);
    return false;
  }
  
  public static int hcq()
  {
    AppMethodBeat.i(309818);
    try
    {
      if (hcp())
      {
        int i = Settings.Secure.getInt(MMApplicationContext.getContext().getContentResolver(), "pure_mode_state", -1);
        AppMethodBeat.o(309818);
        return i;
      }
    }
    finally
    {
      Log.e("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.getPureMode: " + localObject.toString());
      AppMethodBeat.o(309818);
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.j.g
 * JD-Core Version:    0.7.0.1
 */