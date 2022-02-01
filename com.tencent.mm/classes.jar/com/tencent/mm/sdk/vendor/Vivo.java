package com.tencent.mm.sdk.vendor;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Vivo
{
  private static final String TAG = "MicroMsg.Vendor.Vivo";
  
  public static boolean vivoSupportDarkMode()
  {
    AppMethodBeat.i(243188);
    try
    {
      Class localClass = Class.forName("android.util.FtFeature");
      bool = ((Boolean)localClass.getDeclaredMethod("isFeatureSupport", new Class[] { String.class }).invoke(localClass, new Object[] { "vivo.software.nightmode" })).booleanValue();
      Log.d("MicroMsg.Vendor.Vivo", "vivo supportDarkMode: %s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(243188);
      return bool;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.d("MicroMsg.Vendor.Vivo", "vivo supportDarkMode Exception!:%s", new Object[] { localException });
        Log.printErrStackTrace("MicroMsg.Vendor.Vivo", localException, "", new Object[0]);
        boolean bool = false;
      }
    }
  }
  
  public static boolean vivohasCutOut(Context paramContext)
  {
    AppMethodBeat.i(153484);
    if (paramContext == null)
    {
      AppMethodBeat.o(153484);
      return false;
    }
    try
    {
      paramContext = paramContext.getClassLoader().loadClass("android.util.FtFeature");
      boolean bool = ((Boolean)paramContext.getMethod("isFeatureSupport", new Class[] { Integer.TYPE }).invoke(paramContext, new Object[] { Integer.valueOf(32) })).booleanValue();
      Log.d("MicroMsg.Vendor.Vivo", "vivo hasCutOut: %s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(153484);
      return bool;
    }
    catch (ClassNotFoundException paramContext)
    {
      Log.e("MicroMsg.Vendor.Vivo", "hasCutOut, ClassNotFoundException!!");
      return false;
    }
    catch (NoSuchMethodException paramContext)
    {
      Log.e("MicroMsg.Vendor.Vivo", "hasCutOut, NoSuchMethodException!!");
      return false;
    }
    catch (IllegalAccessException paramContext)
    {
      Log.e("MicroMsg.Vendor.Vivo", "hasCutOut, IllegalAccessException!!");
      return false;
    }
    catch (InvocationTargetException paramContext)
    {
      Log.e("MicroMsg.Vendor.Vivo", "hasCutOut, InvocationTargetException!!");
      return false;
    }
    finally
    {
      Log.d("MicroMsg.Vendor.Vivo", "vivo hasCutOut: %s", new Object[] { Boolean.FALSE });
      AppMethodBeat.o(153484);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.vendor.Vivo
 * JD-Core Version:    0.7.0.1
 */