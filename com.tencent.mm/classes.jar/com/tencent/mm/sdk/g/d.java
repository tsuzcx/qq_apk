package com.tencent.mm.sdk.g;

import android.content.Context;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class d
{
  public static boolean gb(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    try
    {
      paramContext = paramContext.getClassLoader().loadClass("android.util.FtFeature");
      boolean bool = ((Boolean)paramContext.getMethod("isFeatureSupport", new Class[] { Integer.TYPE }).invoke(paramContext, new Object[] { Integer.valueOf(32) })).booleanValue();
      y.d("MicroMsg.Vendor.Vivo", "vivo hasCutOut: %s", new Object[] { Boolean.valueOf(bool) });
      return bool;
    }
    catch (ClassNotFoundException paramContext)
    {
      y.printErrStackTrace("MicroMsg.Vendor.Vivo", paramContext, "hasCutOut, ClassNotFoundException!!", new Object[0]);
      return false;
    }
    catch (NoSuchMethodException paramContext)
    {
      y.printErrStackTrace("MicroMsg.Vendor.Vivo", paramContext, "hasCutOut, NoSuchMethodException!!", new Object[0]);
      return false;
    }
    catch (IllegalAccessException paramContext)
    {
      y.printErrStackTrace("MicroMsg.Vendor.Vivo", paramContext, "hasCutOut, IllegalAccessException!!", new Object[0]);
      return false;
    }
    catch (InvocationTargetException paramContext)
    {
      y.printErrStackTrace("MicroMsg.Vendor.Vivo", paramContext, "hasCutOut, InvocationTargetException!!", new Object[0]);
      return false;
    }
    finally
    {
      y.d("MicroMsg.Vendor.Vivo", "vivo hasCutOut: %s", new Object[] { Boolean.valueOf(false) });
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.g.d
 * JD-Core Version:    0.7.0.1
 */