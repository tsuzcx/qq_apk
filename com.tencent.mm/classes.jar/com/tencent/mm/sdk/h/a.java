package com.tencent.mm.sdk.h;

import android.content.Context;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class a
{
  private static Boolean EYQ = null;
  private static String EYR = null;
  
  public static boolean eHj()
  {
    AppMethodBeat.i(153473);
    String str;
    if (EYQ == null)
    {
      str = Build.BRAND;
      ad.i("MicroMsg.Vendor.Huawei", "Build.BRAND = %s", new Object[] { str });
      if (!"HONOR".equalsIgnoreCase(str)) {
        break label59;
      }
      EYQ = Boolean.TRUE;
    }
    for (;;)
    {
      boolean bool = EYQ.booleanValue();
      AppMethodBeat.o(153473);
      return bool;
      label59:
      if ("HUAWEI".equalsIgnoreCase(str)) {
        EYQ = Boolean.TRUE;
      } else {
        EYQ = Boolean.FALSE;
      }
    }
  }
  
  public static boolean eHk()
  {
    AppMethodBeat.i(189950);
    if (eHn().startsWith("EmotionUI_8".toLowerCase()))
    {
      AppMethodBeat.o(189950);
      return true;
    }
    AppMethodBeat.o(189950);
    return false;
  }
  
  public static boolean eHl()
  {
    AppMethodBeat.i(189951);
    if (eHn().startsWith("EmotionUI_9".toLowerCase()))
    {
      AppMethodBeat.o(189951);
      return true;
    }
    AppMethodBeat.o(189951);
    return false;
  }
  
  public static boolean eHm()
  {
    AppMethodBeat.i(189952);
    if (eHn().startsWith("EmotionUI_10".toLowerCase()))
    {
      AppMethodBeat.o(189952);
      return true;
    }
    AppMethodBeat.o(189952);
    return false;
  }
  
  private static String eHn()
  {
    AppMethodBeat.i(189953);
    Object localObject;
    if (!bt.isNullOrNil(EYR))
    {
      localObject = EYR;
      AppMethodBeat.o(189953);
      return localObject;
    }
    try
    {
      localObject = Class.forName("android.os.SystemProperties");
      localObject = (String)((Class)localObject).getMethod("get", new Class[] { String.class, String.class }).invoke(localObject, new Object[] { "ro.build.version.emui", "unknown" });
      localObject = bt.by((String)localObject, "");
      AppMethodBeat.o(189953);
      return localObject;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.e("MicroMsg.Vendor.Huawei", "getProperty() Exception:%s", new Object[] { localException.getMessage() });
        String str = "unknown";
      }
    }
  }
  
  public static boolean iW(Context paramContext)
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
      ad.d("MicroMsg.Vendor.Huawei", "huawei hasCutOut: %s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(153472);
      return bool;
    }
    catch (ClassNotFoundException paramContext)
    {
      ad.e("MicroMsg.Vendor.Huawei", "hasCutOut, ClassNotFoundException!!");
      return false;
    }
    catch (NoSuchMethodException paramContext)
    {
      ad.e("MicroMsg.Vendor.Huawei", "hasCutOut, NoSuchMethodException!!");
      return false;
    }
    catch (IllegalAccessException paramContext)
    {
      ad.e("MicroMsg.Vendor.Huawei", "hasCutOut, IllegalAccessException!!");
      return false;
    }
    catch (InvocationTargetException paramContext)
    {
      ad.e("MicroMsg.Vendor.Huawei", "hasCutOut, InvocationTargetException!!");
      return false;
    }
    finally
    {
      ad.d("MicroMsg.Vendor.Huawei", "huawei hasCutOut: %s", new Object[] { Boolean.FALSE });
      AppMethodBeat.o(153472);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.h.a
 * JD-Core Version:    0.7.0.1
 */