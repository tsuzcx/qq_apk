package com.tencent.mm.sdk.h;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class e
{
  public static boolean hu(Context paramContext)
  {
    AppMethodBeat.i(65377);
    if (paramContext == null)
    {
      AppMethodBeat.o(65377);
      return false;
    }
    try
    {
      paramContext = paramContext.getClassLoader().loadClass("android.util.FtFeature");
      boolean bool = ((Boolean)paramContext.getMethod("isFeatureSupport", new Class[] { Integer.TYPE }).invoke(paramContext, new Object[] { Integer.valueOf(32) })).booleanValue();
      ab.d("MicroMsg.Vendor.Vivo", "vivo hasCutOut: %s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(65377);
      return bool;
    }
    catch (ClassNotFoundException paramContext)
    {
      ab.e("MicroMsg.Vendor.Vivo", "hasCutOut, ClassNotFoundException!!");
      return false;
    }
    catch (NoSuchMethodException paramContext)
    {
      ab.e("MicroMsg.Vendor.Vivo", "hasCutOut, NoSuchMethodException!!");
      return false;
    }
    catch (IllegalAccessException paramContext)
    {
      ab.e("MicroMsg.Vendor.Vivo", "hasCutOut, IllegalAccessException!!");
      return false;
    }
    catch (InvocationTargetException paramContext)
    {
      ab.e("MicroMsg.Vendor.Vivo", "hasCutOut, InvocationTargetException!!");
      return false;
    }
    finally
    {
      ab.d("MicroMsg.Vendor.Vivo", "vivo hasCutOut: %s", new Object[] { Boolean.FALSE });
      AppMethodBeat.o(65377);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.h.e
 * JD-Core Version:    0.7.0.1
 */