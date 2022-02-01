package com.tencent.mm.sdk.vendor;

import android.content.Context;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Huawei
{
  private static final String HUAWEI_SYSTEM_EMUI10_START = "EmotionUI_10";
  private static final String HUAWEI_SYSTEM_EMUI8_START = "EmotionUI_8";
  private static final String HUAWEI_SYSTEM_EMUI9_START = "EmotionUI_9";
  private static final String HUAWEI_SYSTEM_NOT_BELOW_EMUI10_START = "EmotionUI_1";
  private static final String HUAWEI_SYSTEM_STRING = "ro.build.version.emui";
  private static final String TAG = "MicroMsg.Vendor.Huawei";
  private static Boolean ifHUAWEI = null;
  private static Boolean ifOnlyHUAWEI = null;
  private static String systemName = null;
  
  private static String getProperty()
  {
    AppMethodBeat.i(243219);
    Object localObject;
    if (!Util.isNullOrNil(systemName))
    {
      localObject = systemName;
      AppMethodBeat.o(243219);
      return localObject;
    }
    try
    {
      localObject = Class.forName("android.os.SystemProperties");
      localObject = (String)((Class)localObject).getMethod("get", new Class[] { String.class, String.class }).invoke(localObject, new Object[] { "ro.build.version.emui", "unknown" });
      localObject = Util.nullAs((String)localObject, "").toLowerCase();
      systemName = (String)localObject;
      AppMethodBeat.o(243219);
      return localObject;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.Vendor.Huawei", "getProperty() Exception:%s", new Object[] { localException.getMessage() });
        String str = "unknown";
      }
    }
  }
  
  public static boolean huaweihasCutOut(Context paramContext)
  {
    AppMethodBeat.i(153472);
    if (paramContext == null)
    {
      AppMethodBeat.o(153472);
      return false;
    }
    try
    {
      paramContext = paramContext.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
      boolean bool = ((Boolean)paramContext.getMethod("hasNotchInScreen", new Class[0]).invoke(paramContext, new Object[0])).booleanValue();
      Log.d("MicroMsg.Vendor.Huawei", "huawei hasCutOut: %s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(153472);
      return bool;
    }
    catch (ClassNotFoundException paramContext)
    {
      Log.e("MicroMsg.Vendor.Huawei", "hasCutOut, ClassNotFoundException!!");
      return false;
    }
    catch (NoSuchMethodException paramContext)
    {
      Log.e("MicroMsg.Vendor.Huawei", "hasCutOut, NoSuchMethodException!!");
      return false;
    }
    catch (IllegalAccessException paramContext)
    {
      Log.e("MicroMsg.Vendor.Huawei", "hasCutOut, IllegalAccessException!!");
      return false;
    }
    catch (InvocationTargetException paramContext)
    {
      Log.e("MicroMsg.Vendor.Huawei", "hasCutOut, InvocationTargetException!!");
      return false;
    }
    finally
    {
      Log.d("MicroMsg.Vendor.Huawei", "huawei hasCutOut: %s", new Object[] { Boolean.FALSE });
      AppMethodBeat.o(153472);
    }
    return false;
  }
  
  @Deprecated
  public static boolean ifHUAWEI()
  {
    AppMethodBeat.i(153473);
    String str;
    if (ifHUAWEI == null)
    {
      str = Build.BRAND;
      Log.i("MicroMsg.Vendor.Huawei", "Build.BRAND = %s", new Object[] { str });
      if (!"HONOR".equalsIgnoreCase(str)) {
        break label59;
      }
      ifHUAWEI = Boolean.TRUE;
    }
    for (;;)
    {
      boolean bool = ifHUAWEI.booleanValue();
      AppMethodBeat.o(153473);
      return bool;
      label59:
      if ("HUAWEI".equalsIgnoreCase(str)) {
        ifHUAWEI = Boolean.TRUE;
      } else {
        ifHUAWEI = Boolean.FALSE;
      }
    }
  }
  
  public static boolean ifOnlyHUAWEI()
  {
    boolean bool = true;
    AppMethodBeat.i(243200);
    String str;
    if (ifOnlyHUAWEI == null)
    {
      str = Build.BRAND;
      Log.i("MicroMsg.Vendor.Huawei", "Build.BRAND = %s", new Object[] { str });
      if (!"HUAWEI".equalsIgnoreCase(str)) {
        break label61;
      }
      ifOnlyHUAWEI = Boolean.TRUE;
    }
    for (;;)
    {
      bool = ifOnlyHUAWEI.booleanValue();
      AppMethodBeat.o(243200);
      return bool;
      label61:
      if ("HONOR".equalsIgnoreCase(str))
      {
        str = Build.MANUFACTURER;
        Log.i("MicroMsg.Vendor.Huawei", "Build.MANUFACTURER = %s", new Object[] { str });
        if (!"HONOR".equalsIgnoreCase(str)) {}
        for (;;)
        {
          ifOnlyHUAWEI = Boolean.valueOf(bool);
          break;
          bool = false;
        }
      }
      ifOnlyHUAWEI = Boolean.FALSE;
    }
  }
  
  public static boolean isEMUI10()
  {
    AppMethodBeat.i(243210);
    if (getProperty().startsWith("EmotionUI_10".toLowerCase()))
    {
      AppMethodBeat.o(243210);
      return true;
    }
    AppMethodBeat.o(243210);
    return false;
  }
  
  public static boolean isEMUI8()
  {
    AppMethodBeat.i(243205);
    if (getProperty().startsWith("EmotionUI_8".toLowerCase()))
    {
      AppMethodBeat.o(243205);
      return true;
    }
    AppMethodBeat.o(243205);
    return false;
  }
  
  public static boolean isEMUI9()
  {
    AppMethodBeat.i(243207);
    if (getProperty().startsWith("EmotionUI_9".toLowerCase()))
    {
      AppMethodBeat.o(243207);
      return true;
    }
    AppMethodBeat.o(243207);
    return false;
  }
  
  public static boolean isNotBelowEMUI10()
  {
    AppMethodBeat.i(243214);
    if (getProperty().startsWith("EmotionUI_1".toLowerCase()))
    {
      AppMethodBeat.o(243214);
      return true;
    }
    AppMethodBeat.o(243214);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.vendor.Huawei
 * JD-Core Version:    0.7.0.1
 */