package com.tencent.mm.plugin.sns.ad.f;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Environment;
import android.provider.Settings.System;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.plugin.sns.ad.a.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class d
{
  private static String androidId;
  private static String cVh;
  private static String imei;
  private static String uuid;
  private static String zmV;
  private static String znb;
  private static String zne;
  private static Map<Integer, String> zsb;
  private static Map<Integer, String> zsc;
  private static Map<Integer, String> zsd;
  private static String zse;
  
  static
  {
    AppMethodBeat.i(218300);
    zmV = "";
    cVh = "";
    zsb = new ConcurrentHashMap();
    imei = "";
    zsc = new ConcurrentHashMap();
    znb = "";
    zsd = new ConcurrentHashMap();
    zne = "";
    androidId = "";
    uuid = "";
    AppMethodBeat.o(218300);
  }
  
  public static String Qj(int paramInt)
  {
    AppMethodBeat.i(218292);
    Object localObject = (String)zsc.get(Integer.valueOf(paramInt));
    if (!bu.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(218292);
      return localObject;
    }
    if ((Build.VERSION.SDK_INT < 29) && (Build.VERSION.SDK_INT >= 26))
    {
      localObject = ak.getContext();
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
        ae.e("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.getIMEI" + paramInt + ": " + localThrowable.toString());
        continue;
      }
      localObject = bu.nullAsNil((String)zsc.get(Integer.valueOf(paramInt)));
      AppMethodBeat.o(218292);
      return localObject;
      localObject = (TelephonyManager)TelephonyManager.class.cast(localObject);
      if (localObject != null)
      {
        localObject = ((TelephonyManager)localObject).getImei(paramInt);
        if (!bu.isNullOrNil((String)localObject)) {
          zsc.put(Integer.valueOf(paramInt), localObject);
        }
      }
    }
  }
  
  public static String Qk(int paramInt)
  {
    AppMethodBeat.i(218294);
    Object localObject = (String)zsd.get(Integer.valueOf(paramInt));
    if (!bu.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(218294);
      return localObject;
    }
    if ((Build.VERSION.SDK_INT < 29) && (Build.VERSION.SDK_INT >= 26))
    {
      localObject = ak.getContext();
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
        ae.e("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.getMEID" + paramInt + ": " + localThrowable.toString());
        continue;
      }
      localObject = bu.nullAsNil((String)zsd.get(Integer.valueOf(paramInt)));
      AppMethodBeat.o(218294);
      return localObject;
      localObject = (TelephonyManager)TelephonyManager.class.cast(localObject);
      if (localObject != null)
      {
        localObject = ((TelephonyManager)localObject).getMeid(paramInt);
        if (!bu.isNullOrNil((String)localObject)) {
          zsd.put(Integer.valueOf(paramInt), localObject);
        }
      }
    }
  }
  
  public static String aaA()
  {
    AppMethodBeat.i(218291);
    Object localObject;
    if (!bu.isNullOrNil(imei))
    {
      localObject = imei;
      AppMethodBeat.o(218291);
      return localObject;
    }
    if ((Build.VERSION.SDK_INT < 29) && (Build.VERSION.SDK_INT >= 26))
    {
      localObject = ak.getContext();
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
        ae.e("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.getIMEI: " + localThrowable.toString());
        continue;
      }
      localObject = imei;
      AppMethodBeat.o(218291);
      return localObject;
      localObject = (TelephonyManager)TelephonyManager.class.cast(localObject);
      if (localObject != null)
      {
        localObject = ((TelephonyManager)localObject).getImei();
        if (!bu.isNullOrNil((String)localObject)) {
          imei = (String)localObject;
        }
      }
    }
  }
  
  public static String aaB()
  {
    AppMethodBeat.i(218295);
    Object localObject;
    if (!bu.isNullOrNil(zne))
    {
      localObject = zne;
      AppMethodBeat.o(218295);
      return localObject;
    }
    if (Build.VERSION.SDK_INT < 29)
    {
      localObject = ak.getContext();
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
        ae.e("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.getIMSI: " + localThrowable.toString());
        continue;
      }
      localObject = zne;
      AppMethodBeat.o(218295);
      return localObject;
      localObject = (TelephonyManager)TelephonyManager.class.cast(localObject);
      if (localObject != null)
      {
        localObject = ((TelephonyManager)localObject).getSubscriberId();
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          zne = (String)localObject;
        }
      }
    }
  }
  
  public static String aaL()
  {
    AppMethodBeat.i(218288);
    String str;
    if (!bu.isNullOrNil(zmV))
    {
      str = zmV;
      AppMethodBeat.o(218288);
      return str;
    }
    try
    {
      zmV = q.aaL();
      str = zmV;
      AppMethodBeat.o(218288);
      return str;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        ae.e("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.getOAID: " + localThrowable.toString());
      }
    }
  }
  
  public static String dVC()
  {
    AppMethodBeat.i(218293);
    Object localObject;
    if (!bu.isNullOrNil(znb))
    {
      localObject = znb;
      AppMethodBeat.o(218293);
      return localObject;
    }
    if ((Build.VERSION.SDK_INT < 29) && (Build.VERSION.SDK_INT >= 26))
    {
      localObject = ak.getContext();
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
        ae.e("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.getMEID: " + localThrowable.toString());
        continue;
      }
      localObject = znb;
      AppMethodBeat.o(218293);
      return localObject;
      localObject = (TelephonyManager)TelephonyManager.class.cast(localObject);
      if (localObject != null)
      {
        localObject = ((TelephonyManager)localObject).getMeid();
        if (!bu.isNullOrNil((String)localObject)) {
          znb = (String)localObject;
        }
      }
    }
  }
  
  public static String dVD()
  {
    AppMethodBeat.i(218296);
    try
    {
      String str = q.cH(false);
      AppMethodBeat.o(218296);
      return str;
    }
    catch (Throwable localThrowable)
    {
      ae.e("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.getIMEIWx: " + localThrowable.toString());
      AppMethodBeat.o(218296);
    }
    return "";
  }
  
  public static String dVE()
  {
    AppMethodBeat.i(218298);
    try
    {
      if (!bu.isNullOrNil(zse))
      {
        str = zse;
        AppMethodBeat.o(218298);
        return str;
      }
      String str = bu.nullAsNil(System.getProperty("http.agent"));
      zse = str;
      AppMethodBeat.o(218298);
      return str;
    }
    catch (Throwable localThrowable)
    {
      ae.e("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.getAndroidUserAgent: " + localThrowable.toString());
      AppMethodBeat.o(218298);
    }
    return "";
  }
  
  public static String dVF()
  {
    AppMethodBeat.i(218299);
    Object localObject;
    if (!bu.isNullOrNil(uuid))
    {
      localObject = uuid;
      AppMethodBeat.o(218299);
      return localObject;
    }
    try
    {
      long l1 = System.currentTimeMillis();
      if (!TextUtils.equals(Environment.getExternalStorageState(), "mounted"))
      {
        ae.e("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.getUUId: Environment.getExternalStorageState is not equals Environment.MEDIA_MOUNTED");
        AppMethodBeat.o(218299);
        return "";
      }
      b localb1 = new b("Tencent/ams/cache", "meta.dat");
      b localb2 = new b("Android/data/com.tencent.ams/cache", "meta.dat");
      if ((!localb1.open()) || (!localb2.open()))
      {
        ae.e("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.getUUId: file or fileBackup can not open");
        localb1.close();
        localb2.close();
        AppMethodBeat.o(218299);
        return "";
      }
      localObject = localb1.dUF();
      String str = localb2.dUF();
      if (!bu.isNullOrNil((String)localObject)) {
        ae.i("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.getUUId: result from file is ".concat(String.valueOf(localObject)));
      }
      for (;;)
      {
        localb1.close();
        localb2.close();
        if (!bu.isNullOrNil((String)localObject))
        {
          uuid = (String)localObject;
          long l2 = System.currentTimeMillis();
          ae.i("AdDeviceInfo.DeviceInfoUtils", "getUUId, timeCost = " + (l2 - l1) + ", len = " + ((String)localObject).length() + ", result = " + (String)localObject);
        }
        AppMethodBeat.o(218299);
        return localObject;
        if (!bu.isNullOrNil(str))
        {
          ae.i("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.getUUId: result from fileBackup is ".concat(String.valueOf(str)));
          localObject = str;
        }
        else
        {
          localObject = "";
          ae.i("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.getUUId: result from file and fileBackup is null");
        }
      }
      return "";
    }
    catch (Throwable localThrowable)
    {
      ae.e("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.getUUId: " + localThrowable.toString());
      AppMethodBeat.o(218299);
    }
  }
  
  public static String getAndroidId()
  {
    AppMethodBeat.i(218297);
    String str;
    if (!bu.isNullOrNil(androidId))
    {
      str = androidId;
      AppMethodBeat.o(218297);
      return str;
    }
    try
    {
      str = Settings.System.getString(ak.getContext().getContentResolver(), "android_id");
      if (!bu.isNullOrNil(str)) {
        androidId = str;
      }
      str = androidId;
      AppMethodBeat.o(218297);
      return str;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        ae.e("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.getAndroidId: " + localThrowable.toString());
      }
    }
  }
  
  public static String getDeviceId()
  {
    AppMethodBeat.i(218289);
    Object localObject;
    if (!bu.isNullOrNil(cVh))
    {
      localObject = cVh;
      AppMethodBeat.o(218289);
      return localObject;
    }
    if (Build.VERSION.SDK_INT < 29)
    {
      localObject = ak.getContext();
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
        ae.e("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.getDeviceId: " + localThrowable.toString());
        continue;
      }
      localObject = cVh;
      AppMethodBeat.o(218289);
      return localObject;
      localObject = (TelephonyManager)TelephonyManager.class.cast(localObject);
      if (localObject != null)
      {
        localObject = ((TelephonyManager)localObject).getDeviceId();
        if (!bu.isNullOrNil((String)localObject)) {
          cVh = (String)localObject;
        }
      }
    }
  }
  
  public static String getDeviceId(int paramInt)
  {
    AppMethodBeat.i(218290);
    Object localObject = (String)zsb.get(Integer.valueOf(paramInt));
    if (!bu.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(218290);
      return localObject;
    }
    if ((Build.VERSION.SDK_INT < 29) && (Build.VERSION.SDK_INT >= 23))
    {
      localObject = ak.getContext();
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
        ae.e("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.getDeviceId" + paramInt + ": " + localThrowable.toString());
        continue;
      }
      localObject = bu.nullAsNil((String)zsb.get(Integer.valueOf(paramInt)));
      AppMethodBeat.o(218290);
      return localObject;
      localObject = (TelephonyManager)TelephonyManager.class.cast(localObject);
      if (localObject != null)
      {
        localObject = ((TelephonyManager)localObject).getDeviceId(paramInt);
        if (!bu.isNullOrNil((String)localObject)) {
          zsb.put(Integer.valueOf(paramInt), localObject);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.f.d
 * JD-Core Version:    0.7.0.1
 */