package com.tencent.mm.sdk.h;

import android.content.Context;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class a
{
  private static Boolean ICh = null;
  private static String ICi = null;
  
  public static boolean fqj()
  {
    AppMethodBeat.i(153473);
    String str;
    if (ICh == null)
    {
      str = Build.BRAND;
      ae.i("MicroMsg.Vendor.Huawei", "Build.BRAND = %s", new Object[] { str });
      if (!"HONOR".equalsIgnoreCase(str)) {
        break label59;
      }
      ICh = Boolean.TRUE;
    }
    for (;;)
    {
      boolean bool = ICh.booleanValue();
      AppMethodBeat.o(153473);
      return bool;
      label59:
      if ("HUAWEI".equalsIgnoreCase(str)) {
        ICh = Boolean.TRUE;
      } else {
        ICh = Boolean.FALSE;
      }
    }
  }
  
  public static boolean fqk()
  {
    AppMethodBeat.i(216753);
    if (fqn().startsWith("EmotionUI_8".toLowerCase()))
    {
      AppMethodBeat.o(216753);
      return true;
    }
    AppMethodBeat.o(216753);
    return false;
  }
  
  public static boolean fql()
  {
    AppMethodBeat.i(216754);
    if (fqn().startsWith("EmotionUI_9".toLowerCase()))
    {
      AppMethodBeat.o(216754);
      return true;
    }
    AppMethodBeat.o(216754);
    return false;
  }
  
  public static boolean fqm()
  {
    AppMethodBeat.i(216755);
    if (fqn().startsWith("EmotionUI_1".toLowerCase()))
    {
      AppMethodBeat.o(216755);
      return true;
    }
    AppMethodBeat.o(216755);
    return false;
  }
  
  private static String fqn()
  {
    AppMethodBeat.i(216756);
    Object localObject;
    if (!bu.isNullOrNil(ICi))
    {
      localObject = ICi;
      AppMethodBeat.o(216756);
      return localObject;
    }
    try
    {
      localObject = Class.forName("android.os.SystemProperties");
      localObject = (String)((Class)localObject).getMethod("get", new Class[] { String.class, String.class }).invoke(localObject, new Object[] { "ro.build.version.emui", "unknown" });
      localObject = bu.bI((String)localObject, "").toLowerCase();
      ICi = (String)localObject;
      AppMethodBeat.o(216756);
      return localObject;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.e("MicroMsg.Vendor.Huawei", "getProperty() Exception:%s", new Object[] { localException.getMessage() });
        String str = "unknown";
      }
    }
  }
  
  public static boolean jx(Context paramContext)
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
      ae.d("MicroMsg.Vendor.Huawei", "huawei hasCutOut: %s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(153472);
      return bool;
    }
    catch (ClassNotFoundException paramContext)
    {
      ae.e("MicroMsg.Vendor.Huawei", "hasCutOut, ClassNotFoundException!!");
      return false;
    }
    catch (NoSuchMethodException paramContext)
    {
      ae.e("MicroMsg.Vendor.Huawei", "hasCutOut, NoSuchMethodException!!");
      return false;
    }
    catch (IllegalAccessException paramContext)
    {
      ae.e("MicroMsg.Vendor.Huawei", "hasCutOut, IllegalAccessException!!");
      return false;
    }
    catch (InvocationTargetException paramContext)
    {
      ae.e("MicroMsg.Vendor.Huawei", "hasCutOut, InvocationTargetException!!");
      return false;
    }
    finally
    {
      ae.d("MicroMsg.Vendor.Huawei", "huawei hasCutOut: %s", new Object[] { Boolean.FALSE });
      AppMethodBeat.o(153472);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.h.a
 * JD-Core Version:    0.7.0.1
 */