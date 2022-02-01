package com.tencent.mm.plugin.sns.ad.i;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Environment;
import android.provider.Settings.System;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.plugin.sns.ad.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class f
{
  private static Map<Integer, String> DAc;
  private static Map<Integer, String> DAd;
  private static Map<Integer, String> DAe;
  private static String DAf;
  private static String Dsg;
  private static String Dsm;
  private static String Dsp;
  private static String androidId;
  private static String dGL;
  private static String imei;
  private static volatile String uuid;
  
  static
  {
    AppMethodBeat.i(192765);
    Dsg = "";
    dGL = "";
    DAc = new ConcurrentHashMap();
    imei = "";
    DAd = new ConcurrentHashMap();
    Dsm = "";
    DAe = new ConcurrentHashMap();
    Dsp = "";
    androidId = "";
    uuid = "";
    AppMethodBeat.o(192765);
  }
  
  public static String XT(int paramInt)
  {
    AppMethodBeat.i(192757);
    Object localObject = (String)DAd.get(Integer.valueOf(paramInt));
    if (!Util.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(192757);
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
      localObject = Util.nullAsNil((String)DAd.get(Integer.valueOf(paramInt)));
      AppMethodBeat.o(192757);
      return localObject;
      localObject = (TelephonyManager)TelephonyManager.class.cast(localObject);
      if (localObject != null)
      {
        localObject = ((TelephonyManager)localObject).getImei(paramInt);
        if (!Util.isNullOrNil((String)localObject)) {
          DAd.put(Integer.valueOf(paramInt), localObject);
        }
      }
    }
  }
  
  public static String XU(int paramInt)
  {
    AppMethodBeat.i(192759);
    Object localObject = (String)DAe.get(Integer.valueOf(paramInt));
    if (!Util.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(192759);
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
      localObject = Util.nullAsNil((String)DAe.get(Integer.valueOf(paramInt)));
      AppMethodBeat.o(192759);
      return localObject;
      localObject = (TelephonyManager)TelephonyManager.class.cast(localObject);
      if (localObject != null)
      {
        localObject = ((TelephonyManager)localObject).getMeid(paramInt);
        if (!Util.isNullOrNil((String)localObject)) {
          DAe.put(Integer.valueOf(paramInt), localObject);
        }
      }
    }
  }
  
  public static String aoA()
  {
    AppMethodBeat.i(192760);
    Object localObject;
    if (!Util.isNullOrNil(Dsp))
    {
      localObject = Dsp;
      AppMethodBeat.o(192760);
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
      localObject = Dsp;
      AppMethodBeat.o(192760);
      return localObject;
      localObject = (TelephonyManager)TelephonyManager.class.cast(localObject);
      if (localObject != null)
      {
        localObject = ((TelephonyManager)localObject).getSubscriberId();
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          Dsp = (String)localObject;
        }
      }
    }
  }
  
  public static String aoK()
  {
    AppMethodBeat.i(192753);
    String str;
    if (!Util.isNullOrNil(Dsg))
    {
      str = Dsg;
      AppMethodBeat.o(192753);
      return str;
    }
    try
    {
      Dsg = q.aoK();
      str = Dsg;
      AppMethodBeat.o(192753);
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
  
  public static String aoz()
  {
    AppMethodBeat.i(192756);
    Object localObject;
    if (!Util.isNullOrNil(imei))
    {
      localObject = imei;
      AppMethodBeat.o(192756);
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
      AppMethodBeat.o(192756);
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
  
  public static String eYi()
  {
    AppMethodBeat.i(192758);
    Object localObject;
    if (!Util.isNullOrNil(Dsm))
    {
      localObject = Dsm;
      AppMethodBeat.o(192758);
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
      localObject = Dsm;
      AppMethodBeat.o(192758);
      return localObject;
      localObject = (TelephonyManager)TelephonyManager.class.cast(localObject);
      if (localObject != null)
      {
        localObject = ((TelephonyManager)localObject).getMeid();
        if (!Util.isNullOrNil((String)localObject)) {
          Dsm = (String)localObject;
        }
      }
    }
  }
  
  public static String eYj()
  {
    AppMethodBeat.i(192761);
    try
    {
      String str = q.dr(false);
      AppMethodBeat.o(192761);
      return str;
    }
    catch (Throwable localThrowable)
    {
      Log.e("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.getIMEIWx: " + localThrowable.toString());
      AppMethodBeat.o(192761);
    }
    return "";
  }
  
  public static String eYk()
  {
    AppMethodBeat.i(192763);
    try
    {
      if (!Util.isNullOrNil(DAf))
      {
        str = DAf;
        AppMethodBeat.o(192763);
        return str;
      }
      String str = Util.nullAsNil(System.getProperty("http.agent"));
      DAf = str;
      AppMethodBeat.o(192763);
      return str;
    }
    catch (Throwable localThrowable)
    {
      Log.e("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.getAndroidUserAgent: " + localThrowable.toString());
      AppMethodBeat.o(192763);
    }
    return "";
  }
  
  public static String eYl()
  {
    AppMethodBeat.i(192764);
    h.RTc.aX(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(192752);
        try
        {
          long l1 = System.currentTimeMillis();
          if (!TextUtils.equals(Environment.getExternalStorageState(), "mounted"))
          {
            Log.e("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.getUUId: Environment.getExternalStorageState is not equals Environment.MEDIA_MOUNTED");
            f.fU("");
            AppMethodBeat.o(192752);
            return;
          }
          b localb1 = new b("Tencent/ams/cache", "meta.dat");
          b localb2 = new b("Android/data/com.tencent.ams/cache", "meta.dat");
          if ((!localb1.open()) || (!localb2.open()))
          {
            Log.e("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.getUUId: file or fileBackup can not open");
            f.fU("");
            localb1.close();
            localb2.close();
            AppMethodBeat.o(192752);
            return;
          }
          Object localObject = localb1.eWG();
          String str = localb2.eWG();
          if (!Util.isNullOrNil((String)localObject)) {
            Log.i("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.getUUId: result from file is ".concat(String.valueOf(localObject)));
          }
          for (;;)
          {
            f.fU((String)localObject);
            localb1.close();
            localb2.close();
            long l2 = System.currentTimeMillis();
            Log.i("AdDeviceInfo.DeviceInfoUtils", "getUUId, timeCost = " + (l2 - l1) + ", len = " + ((String)localObject).length() + ", result = " + (String)localObject);
            AppMethodBeat.o(192752);
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
          AppMethodBeat.o(192752);
        }
      }
    });
    String str = uuid;
    AppMethodBeat.o(192764);
    return str;
  }
  
  public static String getAndroidId()
  {
    AppMethodBeat.i(192762);
    String str;
    if (!Util.isNullOrNil(androidId))
    {
      str = androidId;
      AppMethodBeat.o(192762);
      return str;
    }
    try
    {
      str = Settings.System.getString(MMApplicationContext.getContext().getContentResolver(), "android_id");
      if (!Util.isNullOrNil(str)) {
        androidId = str;
      }
      str = androidId;
      AppMethodBeat.o(192762);
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
    AppMethodBeat.i(192754);
    Object localObject;
    if (!Util.isNullOrNil(dGL))
    {
      localObject = dGL;
      AppMethodBeat.o(192754);
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
      localObject = dGL;
      AppMethodBeat.o(192754);
      return localObject;
      localObject = (TelephonyManager)TelephonyManager.class.cast(localObject);
      if (localObject != null)
      {
        localObject = ((TelephonyManager)localObject).getDeviceId();
        if (!Util.isNullOrNil((String)localObject)) {
          dGL = (String)localObject;
        }
      }
    }
  }
  
  public static String getDeviceId(int paramInt)
  {
    AppMethodBeat.i(192755);
    Object localObject = (String)DAc.get(Integer.valueOf(paramInt));
    if (!Util.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(192755);
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
      localObject = Util.nullAsNil((String)DAc.get(Integer.valueOf(paramInt)));
      AppMethodBeat.o(192755);
      return localObject;
      localObject = (TelephonyManager)TelephonyManager.class.cast(localObject);
      if (localObject != null)
      {
        localObject = ((TelephonyManager)localObject).getDeviceId(paramInt);
        if (!Util.isNullOrNil((String)localObject)) {
          DAc.put(Integer.valueOf(paramInt), localObject);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.i.f
 * JD-Core Version:    0.7.0.1
 */