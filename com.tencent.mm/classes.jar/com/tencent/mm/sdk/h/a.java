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
  private static Boolean IhW = null;
  private static String IhX = null;
  
  public static boolean fmo()
  {
    AppMethodBeat.i(153473);
    String str;
    if (IhW == null)
    {
      str = Build.BRAND;
      ad.i("MicroMsg.Vendor.Huawei", "Build.BRAND = %s", new Object[] { str });
      if (!"HONOR".equalsIgnoreCase(str)) {
        break label59;
      }
      IhW = Boolean.TRUE;
    }
    for (;;)
    {
      boolean bool = IhW.booleanValue();
      AppMethodBeat.o(153473);
      return bool;
      label59:
      if ("HUAWEI".equalsIgnoreCase(str)) {
        IhW = Boolean.TRUE;
      } else {
        IhW = Boolean.FALSE;
      }
    }
  }
  
  public static boolean fmp()
  {
    AppMethodBeat.i(213162);
    if (fms().startsWith("EmotionUI_8".toLowerCase()))
    {
      AppMethodBeat.o(213162);
      return true;
    }
    AppMethodBeat.o(213162);
    return false;
  }
  
  public static boolean fmq()
  {
    AppMethodBeat.i(213163);
    if (fms().startsWith("EmotionUI_9".toLowerCase()))
    {
      AppMethodBeat.o(213163);
      return true;
    }
    AppMethodBeat.o(213163);
    return false;
  }
  
  public static boolean fmr()
  {
    AppMethodBeat.i(213164);
    if (fms().startsWith("EmotionUI_1".toLowerCase()))
    {
      AppMethodBeat.o(213164);
      return true;
    }
    AppMethodBeat.o(213164);
    return false;
  }
  
  private static String fms()
  {
    AppMethodBeat.i(213165);
    Object localObject;
    if (!bt.isNullOrNil(IhX))
    {
      localObject = IhX;
      AppMethodBeat.o(213165);
      return localObject;
    }
    try
    {
      localObject = Class.forName("android.os.SystemProperties");
      localObject = (String)((Class)localObject).getMethod("get", new Class[] { String.class, String.class }).invoke(localObject, new Object[] { "ro.build.version.emui", "unknown" });
      localObject = bt.bI((String)localObject, "").toLowerCase();
      IhX = (String)localObject;
      AppMethodBeat.o(213165);
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
  
  public static boolean jr(Context paramContext)
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