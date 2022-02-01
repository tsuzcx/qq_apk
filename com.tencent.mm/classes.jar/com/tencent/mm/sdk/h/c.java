package com.tencent.mm.sdk.h;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;

public final class c
{
  public static boolean fqr()
  {
    AppMethodBeat.i(153481);
    try
    {
      boolean bool = ((Boolean)Class.forName("android.os.Build").getMethod("hasSmartBar", new Class[0]).invoke(null, new Object[0])).booleanValue();
      AppMethodBeat.o(153481);
      return bool;
    }
    catch (Exception localException)
    {
      if (Build.DEVICE.equals("mx2"))
      {
        AppMethodBeat.o(153481);
        return true;
      }
      if ((Build.DEVICE.equals("mx")) || (Build.DEVICE.equals("m9")))
      {
        AppMethodBeat.o(153481);
        return false;
      }
      AppMethodBeat.o(153481);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.h.c
 * JD-Core Version:    0.7.0.1
 */