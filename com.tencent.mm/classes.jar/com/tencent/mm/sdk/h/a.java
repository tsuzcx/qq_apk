package com.tencent.mm.sdk.h;

import android.content.Context;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class a
{
  private static Boolean Gwc = null;
  private static String Gwd = null;
  
  public static boolean eWE()
  {
    AppMethodBeat.i(153473);
    String str;
    if (Gwc == null)
    {
      str = Build.BRAND;
      ac.i("MicroMsg.Vendor.Huawei", "Build.BRAND = %s", new Object[] { str });
      if (!"HONOR".equalsIgnoreCase(str)) {
        break label59;
      }
      Gwc = Boolean.TRUE;
    }
    for (;;)
    {
      boolean bool = Gwc.booleanValue();
      AppMethodBeat.o(153473);
      return bool;
      label59:
      if ("HUAWEI".equalsIgnoreCase(str)) {
        Gwc = Boolean.TRUE;
      } else {
        Gwc = Boolean.FALSE;
      }
    }
  }
  
  public static boolean eWF()
  {
    AppMethodBeat.i(206790);
    if (eWI().startsWith("EmotionUI_8".toLowerCase()))
    {
      AppMethodBeat.o(206790);
      return true;
    }
    AppMethodBeat.o(206790);
    return false;
  }
  
  public static boolean eWG()
  {
    AppMethodBeat.i(206791);
    if (eWI().startsWith("EmotionUI_9".toLowerCase()))
    {
      AppMethodBeat.o(206791);
      return true;
    }
    AppMethodBeat.o(206791);
    return false;
  }
  
  private static String eWI()
  {
    AppMethodBeat.i(206793);
    Object localObject;
    if (!bs.isNullOrNil(Gwd))
    {
      localObject = Gwd;
      AppMethodBeat.o(206793);
      return localObject;
    }
    try
    {
      localObject = Class.forName("android.os.SystemProperties");
      localObject = (String)((Class)localObject).getMethod("get", new Class[] { String.class, String.class }).invoke(localObject, new Object[] { "ro.build.version.emui", "unknown" });
      localObject = bs.bG((String)localObject, "").toLowerCase();
      Gwd = (String)localObject;
      AppMethodBeat.o(206793);
      return localObject;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.e("MicroMsg.Vendor.Huawei", "getProperty() Exception:%s", new Object[] { localException.getMessage() });
        String str = "unknown";
      }
    }
  }
  
  public static boolean fdl()
  {
    AppMethodBeat.i(210472);
    if (eWI().startsWith("EmotionUI_1".toLowerCase()))
    {
      AppMethodBeat.o(210472);
      return true;
    }
    AppMethodBeat.o(210472);
    return false;
  }
  
  public static boolean jh(Context paramContext)
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
      ac.d("MicroMsg.Vendor.Huawei", "huawei hasCutOut: %s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(153472);
      return bool;
    }
    catch (ClassNotFoundException paramContext)
    {
      ac.e("MicroMsg.Vendor.Huawei", "hasCutOut, ClassNotFoundException!!");
      return false;
    }
    catch (NoSuchMethodException paramContext)
    {
      ac.e("MicroMsg.Vendor.Huawei", "hasCutOut, NoSuchMethodException!!");
      return false;
    }
    catch (IllegalAccessException paramContext)
    {
      ac.e("MicroMsg.Vendor.Huawei", "hasCutOut, IllegalAccessException!!");
      return false;
    }
    catch (InvocationTargetException paramContext)
    {
      ac.e("MicroMsg.Vendor.Huawei", "hasCutOut, InvocationTargetException!!");
      return false;
    }
    finally
    {
      ac.d("MicroMsg.Vendor.Huawei", "huawei hasCutOut: %s", new Object[] { Boolean.FALSE });
      AppMethodBeat.o(153472);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.h.a
 * JD-Core Version:    0.7.0.1
 */