package com.tencent.mm.plugin.sns.ad.e;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Environment;
import android.provider.Settings.System;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.plugin.sns.ad.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class c
{
  private static String androidId;
  private static String cUi;
  private static String imei;
  private static String uuid;
  private static String yWM;
  private static String yWS;
  private static String yWV;
  private static String zbB;
  private static Map<Integer, String> zbx;
  private static Map<Integer, String> zby;
  private static Map<Integer, String> zbz;
  
  static
  {
    AppMethodBeat.i(213147);
    yWM = "";
    cUi = "";
    zbx = new ConcurrentHashMap();
    imei = "";
    zby = new ConcurrentHashMap();
    yWS = "";
    zbz = new ConcurrentHashMap();
    yWV = "";
    androidId = "";
    uuid = "";
    AppMethodBeat.o(213147);
  }
  
  public static String PC(int paramInt)
  {
    AppMethodBeat.i(213136);
    Object localObject = (String)zby.get(Integer.valueOf(paramInt));
    if (!bt.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(213136);
      return localObject;
    }
    if ((Build.VERSION.SDK_INT < 29) && (Build.VERSION.SDK_INT >= 26))
    {
      localObject = aj.getContext();
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
        ad.e("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.getIMEI" + paramInt + ": " + localThrowable.toString());
        continue;
      }
      localObject = bt.nullAsNil((String)zby.get(Integer.valueOf(paramInt)));
      AppMethodBeat.o(213136);
      return localObject;
      localObject = (TelephonyManager)TelephonyManager.class.cast(localObject);
      if (localObject != null)
      {
        localObject = ((TelephonyManager)localObject).getImei(paramInt);
        if (!bt.isNullOrNil((String)localObject)) {
          zby.put(Integer.valueOf(paramInt), localObject);
        }
      }
    }
  }
  
  public static String PD(int paramInt)
  {
    AppMethodBeat.i(213138);
    Object localObject = (String)zbz.get(Integer.valueOf(paramInt));
    if (!bt.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(213138);
      return localObject;
    }
    if ((Build.VERSION.SDK_INT < 29) && (Build.VERSION.SDK_INT >= 26))
    {
      localObject = aj.getContext();
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
        ad.e("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.getMEID" + paramInt + ": " + localThrowable.toString());
        continue;
      }
      localObject = bt.nullAsNil((String)zbz.get(Integer.valueOf(paramInt)));
      AppMethodBeat.o(213138);
      return localObject;
      localObject = (TelephonyManager)TelephonyManager.class.cast(localObject);
      if (localObject != null)
      {
        localObject = ((TelephonyManager)localObject).getMeid(paramInt);
        if (!bt.isNullOrNil((String)localObject)) {
          zbz.put(Integer.valueOf(paramInt), localObject);
        }
      }
    }
  }
  
  public static String aaC()
  {
    AppMethodBeat.i(213132);
    String str;
    if (!bt.isNullOrNil(yWM))
    {
      str = yWM;
      AppMethodBeat.o(213132);
      return str;
    }
    try
    {
      yWM = q.aaC();
      str = yWM;
      AppMethodBeat.o(213132);
      return str;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        ad.e("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.getOAID: " + localThrowable.toString());
      }
    }
  }
  
  public static String aar()
  {
    AppMethodBeat.i(213135);
    Object localObject;
    if (!bt.isNullOrNil(imei))
    {
      localObject = imei;
      AppMethodBeat.o(213135);
      return localObject;
    }
    if ((Build.VERSION.SDK_INT < 29) && (Build.VERSION.SDK_INT >= 26))
    {
      localObject = aj.getContext();
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
        ad.e("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.getIMEI: " + localThrowable.toString());
        continue;
      }
      localObject = imei;
      AppMethodBeat.o(213135);
      return localObject;
      localObject = (TelephonyManager)TelephonyManager.class.cast(localObject);
      if (localObject != null)
      {
        localObject = ((TelephonyManager)localObject).getImei();
        if (!bt.isNullOrNil((String)localObject)) {
          imei = (String)localObject;
        }
      }
    }
  }
  
  public static String aas()
  {
    AppMethodBeat.i(213139);
    Object localObject;
    if (!bt.isNullOrNil(yWV))
    {
      localObject = yWV;
      AppMethodBeat.o(213139);
      return localObject;
    }
    if (Build.VERSION.SDK_INT < 29)
    {
      localObject = aj.getContext();
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
        ad.e("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.getIMSI: " + localThrowable.toString());
        continue;
      }
      localObject = yWV;
      AppMethodBeat.o(213139);
      return localObject;
      localObject = (TelephonyManager)TelephonyManager.class.cast(localObject);
      if (localObject != null)
      {
        localObject = ((TelephonyManager)localObject).getSubscriberId();
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          yWV = (String)localObject;
        }
      }
    }
  }
  
  public static String dSa()
  {
    AppMethodBeat.i(213137);
    Object localObject;
    if (!bt.isNullOrNil(yWS))
    {
      localObject = yWS;
      AppMethodBeat.o(213137);
      return localObject;
    }
    if ((Build.VERSION.SDK_INT < 29) && (Build.VERSION.SDK_INT >= 26))
    {
      localObject = aj.getContext();
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
        ad.e("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.getMEID: " + localThrowable.toString());
        continue;
      }
      localObject = yWS;
      AppMethodBeat.o(213137);
      return localObject;
      localObject = (TelephonyManager)TelephonyManager.class.cast(localObject);
      if (localObject != null)
      {
        localObject = ((TelephonyManager)localObject).getMeid();
        if (!bt.isNullOrNil((String)localObject)) {
          yWS = (String)localObject;
        }
      }
    }
  }
  
  public static String dSb()
  {
    AppMethodBeat.i(213140);
    try
    {
      String str = q.cH(false);
      AppMethodBeat.o(213140);
      return str;
    }
    catch (Throwable localThrowable)
    {
      ad.e("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.getIMEIWx: " + localThrowable.toString());
      AppMethodBeat.o(213140);
    }
    return "";
  }
  
  public static String dSd()
  {
    AppMethodBeat.i(213144);
    try
    {
      if (!bt.isNullOrNil(zbB))
      {
        str = zbB;
        AppMethodBeat.o(213144);
        return str;
      }
      String str = bt.nullAsNil(System.getProperty("http.agent"));
      zbB = str;
      AppMethodBeat.o(213144);
      return str;
    }
    catch (Throwable localThrowable)
    {
      ad.e("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.getAndroidUserAgent: " + localThrowable.toString());
      AppMethodBeat.o(213144);
    }
    return "";
  }
  
  public static String dSe()
  {
    AppMethodBeat.i(213145);
    Object localObject;
    if (!bt.isNullOrNil(uuid))
    {
      localObject = uuid;
      AppMethodBeat.o(213145);
      return localObject;
    }
    try
    {
      long l1 = System.currentTimeMillis();
      if (!TextUtils.equals(Environment.getExternalStorageState(), "mounted"))
      {
        ad.e("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.getUUId: Environment.getExternalStorageState is not equals Environment.MEDIA_MOUNTED");
        AppMethodBeat.o(213145);
        return "";
      }
      b localb1 = new b("Tencent/ams/cache", "meta.dat");
      b localb2 = new b("Android/data/com.tencent.ams/cache", "meta.dat");
      if ((!localb1.open()) || (!localb2.open()))
      {
        ad.e("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.getUUId: file or fileBackup can not open");
        localb1.close();
        localb2.close();
        AppMethodBeat.o(213145);
        return "";
      }
      localObject = localb1.dRi();
      String str = localb2.dRi();
      if (!bt.isNullOrNil((String)localObject)) {
        ad.i("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.getUUId: result from file is ".concat(String.valueOf(localObject)));
      }
      for (;;)
      {
        localb1.close();
        localb2.close();
        if (!bt.isNullOrNil((String)localObject))
        {
          uuid = (String)localObject;
          long l2 = System.currentTimeMillis();
          ad.i("AdDeviceInfo.DeviceInfoUtils", "getUUId, timeCost = " + (l2 - l1) + ", len = " + ((String)localObject).length() + ", result = " + (String)localObject);
        }
        AppMethodBeat.o(213145);
        return localObject;
        if (!bt.isNullOrNil(str))
        {
          ad.i("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.getUUId: result from fileBackup is ".concat(String.valueOf(str)));
          localObject = str;
        }
        else
        {
          localObject = "";
          ad.i("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.getUUId: result from file and fileBackup is null");
        }
      }
      return "";
    }
    catch (Throwable localThrowable)
    {
      ad.e("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.getUUId: " + localThrowable.toString());
      AppMethodBeat.o(213145);
    }
  }
  
  public static String getAndroidId()
  {
    AppMethodBeat.i(213141);
    String str;
    if (!bt.isNullOrNil(androidId))
    {
      str = androidId;
      AppMethodBeat.o(213141);
      return str;
    }
    try
    {
      str = Settings.System.getString(aj.getContext().getContentResolver(), "android_id");
      if (!bt.isNullOrNil(str)) {
        androidId = str;
      }
      str = androidId;
      AppMethodBeat.o(213141);
      return str;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        ad.e("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.getAndroidId: " + localThrowable.toString());
      }
    }
  }
  
  public static String getDeviceId()
  {
    AppMethodBeat.i(213133);
    Object localObject;
    if (!bt.isNullOrNil(cUi))
    {
      localObject = cUi;
      AppMethodBeat.o(213133);
      return localObject;
    }
    if (Build.VERSION.SDK_INT < 29)
    {
      localObject = aj.getContext();
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
        ad.e("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.getDeviceId: " + localThrowable.toString());
        continue;
      }
      localObject = cUi;
      AppMethodBeat.o(213133);
      return localObject;
      localObject = (TelephonyManager)TelephonyManager.class.cast(localObject);
      if (localObject != null)
      {
        localObject = ((TelephonyManager)localObject).getDeviceId();
        if (!bt.isNullOrNil((String)localObject)) {
          cUi = (String)localObject;
        }
      }
    }
  }
  
  public static String getDeviceId(int paramInt)
  {
    AppMethodBeat.i(213134);
    Object localObject = (String)zbx.get(Integer.valueOf(paramInt));
    if (!bt.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(213134);
      return localObject;
    }
    if ((Build.VERSION.SDK_INT < 29) && (Build.VERSION.SDK_INT >= 23))
    {
      localObject = aj.getContext();
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
        ad.e("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.getDeviceId" + paramInt + ": " + localThrowable.toString());
        continue;
      }
      localObject = bt.nullAsNil((String)zbx.get(Integer.valueOf(paramInt)));
      AppMethodBeat.o(213134);
      return localObject;
      localObject = (TelephonyManager)TelephonyManager.class.cast(localObject);
      if (localObject != null)
      {
        localObject = ((TelephonyManager)localObject).getDeviceId(paramInt);
        if (!bt.isNullOrNil((String)localObject)) {
          zbx.put(Integer.valueOf(paramInt), localObject);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.e.c
 * JD-Core Version:    0.7.0.1
 */