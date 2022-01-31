package com.tencent.mm.sdk.h;

import android.content.Context;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class a
{
  private static Boolean ytx = null;
  
  public static boolean duM()
  {
    AppMethodBeat.i(65367);
    String str;
    if (ytx == null)
    {
      str = Build.BRAND;
      ab.i("MicroMsg.Vendor.Huawei", "Build.BRAND = %s", new Object[] { str });
      if (!"HONOR".equalsIgnoreCase(str)) {
        break label59;
      }
      ytx = Boolean.TRUE;
    }
    for (;;)
    {
      boolean bool = ytx.booleanValue();
      AppMethodBeat.o(65367);
      return bool;
      label59:
      if ("HUAWEI".equalsIgnoreCase(str)) {
        ytx = Boolean.TRUE;
      } else {
        ytx = Boolean.FALSE;
      }
    }
  }
  
  public static boolean hs(Context paramContext)
  {
    AppMethodBeat.i(65366);
    if (paramContext == null)
    {
      AppMethodBeat.o(65366);
      return false;
    }
    try
    {
      paramContext = paramContext.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
      boolean bool = ((Boolean)paramContext.getMethod("hasNotchInScreen", new Class[0]).invoke(paramContext, new Object[0])).booleanValue();
      ab.d("MicroMsg.Vendor.Huawei", "huawei hasCutOut: %s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(65366);
      return bool;
    }
    catch (ClassNotFoundException paramContext)
    {
      ab.e("MicroMsg.Vendor.Huawei", "hasCutOut, ClassNotFoundException!!");
      return false;
    }
    catch (NoSuchMethodException paramContext)
    {
      ab.e("MicroMsg.Vendor.Huawei", "hasCutOut, NoSuchMethodException!!");
      return false;
    }
    catch (IllegalAccessException paramContext)
    {
      ab.e("MicroMsg.Vendor.Huawei", "hasCutOut, IllegalAccessException!!");
      return false;
    }
    catch (InvocationTargetException paramContext)
    {
      ab.e("MicroMsg.Vendor.Huawei", "hasCutOut, InvocationTargetException!!");
      return false;
    }
    finally
    {
      ab.d("MicroMsg.Vendor.Huawei", "huawei hasCutOut: %s", new Object[] { Boolean.FALSE });
      AppMethodBeat.o(65366);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.h.a
 * JD-Core Version:    0.7.0.1
 */