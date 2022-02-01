package com.tencent.mm.plugin.sns.ad.i;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Environment;
import android.provider.Settings.Secure;
import android.provider.Settings.System;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.plugin.sns.ad.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class g
{
  private static Map<Integer, String> JLA;
  private static Map<Integer, String> JLB;
  private static Map<Integer, String> JLC;
  private static String JLD;
  private static int JLE;
  private static String JyL;
  private static String JyR;
  private static String JyU;
  private static String JyW;
  private static String androidId;
  private static String fzB;
  private static String imei;
  private static volatile String uuid;
  
  static
  {
    AppMethodBeat.i(260909);
    JyL = "";
    fzB = "";
    JLA = new ConcurrentHashMap();
    imei = "";
    JLB = new ConcurrentHashMap();
    JyR = "";
    JLC = new ConcurrentHashMap();
    JyU = "";
    androidId = "";
    uuid = "";
    JyW = "";
    AppMethodBeat.o(260909);
  }
  
  public static String afh(int paramInt)
  {
    AppMethodBeat.i(260886);
    Object localObject = (String)JLA.get(Integer.valueOf(paramInt));
    if (!Util.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(260886);
      return localObject;
    }
    if ((Build.VERSION.SDK_INT < 29) && (Build.VERSION.SDK_INT >= 23))
    {
      localObject = MMApplicationContext.getContext();
      if (localObject == null) {}
    }
    for (;;)
    {
      try
      {
        localObject = ((Context)localObject).getSystemService("phone");
        boolean bool = localObject instanceof TelephonyManager;
        if (bool) {
          continue;
        }
      }
      catch (Throwable localThrowable)
      {
        Log.e("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.getDeviceId" + paramInt + ": " + localThrowable.toString());
        continue;
      }
      localObject = Util.nullAsNil((String)JLA.get(Integer.valueOf(paramInt)));
      AppMethodBeat.o(260886);
      return localObject;
      localObject = (TelephonyManager)TelephonyManager.class.cast(localObject);
      if (localObject != null)
      {
        localObject = ((TelephonyManager)localObject).getDeviceId(paramInt);
        if (!Util.isNullOrNil((String)localObject)) {
          JLA.put(Integer.valueOf(paramInt), localObject);
        }
      }
    }
  }
  
  public static String afi(int paramInt)
  {
    AppMethodBeat.i(260890);
    Object localObject = (String)JLB.get(Integer.valueOf(paramInt));
    if (!Util.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(260890);
      return localObject;
    }
    if ((Build.VERSION.SDK_INT < 29) && (Build.VERSION.SDK_INT >= 26))
    {
      localObject = MMApplicationContext.getContext();
      if (localObject == null) {}
    }
    for (;;)
    {
      try
      {
        localObject = ((Context)localObject).getSystemService("phone");
        boolean bool = localObject instanceof TelephonyManager;
        if (bool) {
          continue;
        }
      }
      catch (Throwable localThrowable)
      {
        Log.e("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.getIMEI" + paramInt + ": " + localThrowable.toString());
        continue;
      }
      localObject = Util.nullAsNil((String)JLB.get(Integer.valueOf(paramInt)));
      AppMethodBeat.o(260890);
      return localObject;
      localObject = (TelephonyManager)TelephonyManager.class.cast(localObject);
      if (localObject != null)
      {
        localObject = ((TelephonyManager)localObject).getImei(paramInt);
        if (!Util.isNullOrNil((String)localObject)) {
          JLB.put(Integer.valueOf(paramInt), localObject);
        }
      }
    }
  }
  
  public static String afj(int paramInt)
  {
    AppMethodBeat.i(260893);
    Object localObject = (String)JLC.get(Integer.valueOf(paramInt));
    if (!Util.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(260893);
      return localObject;
    }
    if ((Build.VERSION.SDK_INT < 29) && (Build.VERSION.SDK_INT >= 26))
    {
      localObject = MMApplicationContext.getContext();
      if (localObject == null) {}
    }
    for (;;)
    {
      try
      {
        localObject = ((Context)localObject).getSystemService("phone");
        boolean bool = localObject instanceof TelephonyManager;
        if (bool) {
          continue;
        }
      }
      catch (Throwable localThrowable)
      {
        Log.e("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.getMEID" + paramInt + ": " + localThrowable.toString());
        continue;
      }
      localObject = Util.nullAsNil((String)JLC.get(Integer.valueOf(paramInt)));
      AppMethodBeat.o(260893);
      return localObject;
      localObject = (TelephonyManager)TelephonyManager.class.cast(localObject);
      if (localObject != null)
      {
        localObject = ((TelephonyManager)localObject).getMeid(paramInt);
        if (!Util.isNullOrNil((String)localObject)) {
          JLC.put(Integer.valueOf(paramInt), localObject);
        }
      }
    }
  }
  
  public static String auE()
  {
    AppMethodBeat.i(260888);
    Object localObject;
    if (!Util.isNullOrNil(imei))
    {
      localObject = imei;
      AppMethodBeat.o(260888);
      return localObject;
    }
    if ((Build.VERSION.SDK_INT < 29) && (Build.VERSION.SDK_INT >= 26))
    {
      localObject = MMApplicationContext.getContext();
      if (localObject == null) {}
    }
    for (;;)
    {
      try
      {
        localObject = ((Context)localObject).getSystemService("phone");
        boolean bool = localObject instanceof TelephonyManager;
        if (bool) {
          continue;
        }
      }
      catch (Throwable localThrowable)
      {
        Log.e("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.getIMEI: " + localThrowable.toString());
        continue;
      }
      localObject = imei;
      AppMethodBeat.o(260888);
      return localObject;
      localObject = (TelephonyManager)TelephonyManager.class.cast(localObject);
      if (localObject != null)
      {
        localObject = ((TelephonyManager)localObject).getImei();
        if (!Util.isNullOrNil((String)localObject)) {
          imei = (String)localObject;
        }
      }
    }
  }
  
  public static String auF()
  {
    AppMethodBeat.i(260895);
    Object localObject;
    if (!Util.isNullOrNil(JyU))
    {
      localObject = JyU;
      AppMethodBeat.o(260895);
      return localObject;
    }
    if (Build.VERSION.SDK_INT < 29)
    {
      localObject = MMApplicationContext.getContext();
      if (localObject == null) {}
    }
    for (;;)
    {
      try
      {
        localObject = ((Context)localObject).getSystemService("phone");
        boolean bool = localObject instanceof TelephonyManager;
        if (bool) {
          continue;
        }
      }
      catch (Throwable localThrowable)
      {
        Log.e("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.getIMSI: " + localThrowable.toString());
        continue;
      }
      localObject = JyU;
      AppMethodBeat.o(260895);
      return localObject;
      localObject = (TelephonyManager)TelephonyManager.class.cast(localObject);
      if (localObject != null)
      {
        localObject = ((TelephonyManager)localObject).getSubscriberId();
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          JyU = (String)localObject;
        }
      }
    }
  }
  
  public static String auQ()
  {
    AppMethodBeat.i(260881);
    String str;
    if (!Util.isNullOrNil(JyL))
    {
      str = JyL;
      AppMethodBeat.o(260881);
      return str;
    }
    try
    {
      JyL = q.auQ();
      str = JyL;
      AppMethodBeat.o(260881);
      return str;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Log.e("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.getOAID: " + localThrowable.toString());
      }
    }
  }
  
  public static String fLR()
  {
    AppMethodBeat.i(260891);
    Object localObject;
    if (!Util.isNullOrNil(JyR))
    {
      localObject = JyR;
      AppMethodBeat.o(260891);
      return localObject;
    }
    if ((Build.VERSION.SDK_INT < 29) && (Build.VERSION.SDK_INT >= 26))
    {
      localObject = MMApplicationContext.getContext();
      if (localObject == null) {}
    }
    for (;;)
    {
      try
      {
        localObject = ((Context)localObject).getSystemService("phone");
        boolean bool = localObject instanceof TelephonyManager;
        if (bool) {
          continue;
        }
      }
      catch (Throwable localThrowable)
      {
        Log.e("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.getMEID: " + localThrowable.toString());
        continue;
      }
      localObject = JyR;
      AppMethodBeat.o(260891);
      return localObject;
      localObject = (TelephonyManager)TelephonyManager.class.cast(localObject);
      if (localObject != null)
      {
        localObject = ((TelephonyManager)localObject).getMeid();
        if (!Util.isNullOrNil((String)localObject)) {
          JyR = (String)localObject;
        }
      }
    }
  }
  
  public static String fLS()
  {
    AppMethodBeat.i(260896);
    try
    {
      String str = q.dR(false);
      AppMethodBeat.o(260896);
      return str;
    }
    catch (Throwable localThrowable)
    {
      Log.e("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.getIMEIWx: " + localThrowable.toString());
      AppMethodBeat.o(260896);
    }
    return "";
  }
  
  public static String fLT()
  {
    AppMethodBeat.i(260900);
    try
    {
      if (!Util.isNullOrNil(JLD))
      {
        str = JLD;
        AppMethodBeat.o(260900);
        return str;
      }
      String str = Util.nullAsNil(System.getProperty("http.agent"));
      JLD = str;
      AppMethodBeat.o(260900);
      return str;
    }
    catch (Throwable localThrowable)
    {
      Log.e("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.getAndroidUserAgent: " + localThrowable.toString());
      AppMethodBeat.o(260900);
    }
    return "";
  }
  
  public static String fLU()
  {
    AppMethodBeat.i(260902);
    h.ZvG.be(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(261719);
        try
        {
          long l1 = System.currentTimeMillis();
          if (!TextUtils.equals(Environment.getExternalStorageState(), "mounted"))
          {
            Log.e("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.getUUId: Environment.getExternalStorageState is not equals Environment.MEDIA_MOUNTED");
            g.gE("");
            AppMethodBeat.o(261719);
            return;
          }
          b localb1 = new b("Tencent/ams/cache", "meta.dat");
          b localb2 = new b("Android/data/com.tencent.ams/cache", "meta.dat");
          if ((!localb1.open()) || (!localb2.open()))
          {
            Log.e("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.getUUId: file or fileBackup can not open");
            g.gE("");
            localb1.close();
            localb2.close();
            AppMethodBeat.o(261719);
            return;
          }
          Object localObject = localb1.fJJ();
          String str = localb2.fJJ();
          if (!Util.isNullOrNil((String)localObject)) {
            Log.i("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.getUUId: result from file is ".concat(String.valueOf(localObject)));
          }
          for (;;)
          {
            g.gE((String)localObject);
            localb1.close();
            localb2.close();
            long l2 = System.currentTimeMillis();
            Log.i("AdDeviceInfo.DeviceInfoUtils", "getUUId, timeCost = " + (l2 - l1) + ", len = " + ((String)localObject).length() + ", result = " + (String)localObject);
            AppMethodBeat.o(261719);
            return;
            if (!Util.isNullOrNil(str))
            {
              Log.i("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.getUUId: result from fileBackup is ".concat(String.valueOf(str)));
              localObject = str;
            }
            else
            {
              localObject = "";
              Log.i("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.getUUId: result from file and fileBackup is null");
            }
          }
          return;
        }
        catch (Throwable localThrowable)
        {
          Log.e("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.getUUId: " + localThrowable.toString());
          AppMethodBeat.o(261719);
        }
      }
    });
    String str = uuid;
    AppMethodBeat.o(260902);
    return str;
  }
  
  public static boolean fLV()
  {
    AppMethodBeat.i(260905);
    try
    {
      int i = JLE;
      if (i == 1)
      {
        AppMethodBeat.o(260905);
        return true;
      }
      i = JLE;
      if (i == 2)
      {
        AppMethodBeat.o(260905);
        return false;
      }
      JLE = 2;
      Object localObject = com.tencent.xweb.util.g.pf("com.huawei.system.BuildEx", "getOsBrand");
      if ((localObject instanceof String))
      {
        localObject = (String)localObject;
        if ((!Util.isNullOrNil((String)localObject)) && ("harmony".equals(localObject)))
        {
          JLE = 1;
          AppMethodBeat.o(260905);
          return true;
        }
        Log.i("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.isSupportHarmonyOS: this aPhone not supports HarmonyOS and osNameStr is ".concat(String.valueOf(localObject)));
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Log.e("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.isSupportHarmonyOS: " + localThrowable.toString());
      }
    }
    AppMethodBeat.o(260905);
    return false;
  }
  
  public static String fLW()
  {
    AppMethodBeat.i(260907);
    for (;;)
    {
      try
      {
        if (!fLV()) {
          continue;
        }
        if (!Util.isNullOrNil(JyW))
        {
          localObject = JyW;
          AppMethodBeat.o(260907);
          return localObject;
        }
        JyW = "0.0.0";
        localObject = com.tencent.xweb.util.g.pf("ohos.system.version.SystemVersion", "getVersion");
        if (!(localObject instanceof String)) {
          continue;
        }
        localObject = (String)localObject;
        if (Util.isNullOrNil((String)localObject)) {
          continue;
        }
        JyW = (String)localObject;
      }
      catch (Throwable localThrowable)
      {
        Object localObject;
        Log.e("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.getHarmonyOSVersion: " + localThrowable.toString());
        continue;
        Log.e("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.getHarmonyOSVersion: this aPhone supports HarmonyOS but version is null or not instance of String");
        continue;
        Log.i("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.getHarmonyOSVersion: Protected, this aPhone not supports HarmonyOS");
        continue;
      }
      localObject = JyW;
      AppMethodBeat.o(260907);
      return localObject;
      Log.e("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.getHarmonyOSVersion: this aPhone supports HarmonyOS but versionStr is null or nil");
    }
  }
  
  public static int fLX()
  {
    AppMethodBeat.i(260908);
    try
    {
      if (fLV())
      {
        int i = Settings.Secure.getInt(MMApplicationContext.getContext().getContentResolver(), "pure_mode_state", -1);
        AppMethodBeat.o(260908);
        return i;
      }
    }
    catch (Throwable localThrowable)
    {
      Log.e("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.getPureMode: " + localThrowable.toString());
      AppMethodBeat.o(260908);
    }
    return -1;
  }
  
  public static String getAndroidId()
  {
    AppMethodBeat.i(260898);
    String str;
    if (!Util.isNullOrNil(androidId))
    {
      str = androidId;
      AppMethodBeat.o(260898);
      return str;
    }
    try
    {
      str = Settings.System.getString(MMApplicationContext.getContext().getContentResolver(), "android_id");
      if (!Util.isNullOrNil(str)) {
        androidId = str;
      }
      str = androidId;
      AppMethodBeat.o(260898);
      return str;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Log.e("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.getAndroidId: " + localThrowable.toString());
      }
    }
  }
  
  public static String getDeviceId()
  {
    AppMethodBeat.i(260884);
    Object localObject;
    if (!Util.isNullOrNil(fzB))
    {
      localObject = fzB;
      AppMethodBeat.o(260884);
      return localObject;
    }
    if (Build.VERSION.SDK_INT < 29)
    {
      localObject = MMApplicationContext.getContext();
      if (localObject == null) {}
    }
    for (;;)
    {
      try
      {
        localObject = ((Context)localObject).getSystemService("phone");
        boolean bool = localObject instanceof TelephonyManager;
        if (bool) {
          continue;
        }
      }
      catch (Throwable localThrowable)
      {
        Log.e("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.getDeviceId: " + localThrowable.toString());
        continue;
      }
      localObject = fzB;
      AppMethodBeat.o(260884);
      return localObject;
      localObject = (TelephonyManager)TelephonyManager.class.cast(localObject);
      if (localObject != null)
      {
        localObject = ((TelephonyManager)localObject).getDeviceId();
        if (!Util.isNullOrNil((String)localObject)) {
          fzB = (String)localObject;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.i.g
 * JD-Core Version:    0.7.0.1
 */