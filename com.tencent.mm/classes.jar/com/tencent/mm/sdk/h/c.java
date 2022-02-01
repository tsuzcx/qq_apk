package com.tencent.mm.sdk.h;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bt;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class c
{
  public static boolean eHr()
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
  
  public static int iX(Context paramContext)
  {
    int i = 0;
    AppMethodBeat.i(175933);
    try
    {
      Class localClass = Class.forName("com.android.internal.R$dimen");
      Object localObject = localClass.newInstance();
      int j = bt.getInt(localClass.getField("status_bar_height").get(localObject).toString(), 0);
      j = paramContext.getResources().getDimensionPixelSize(j);
      i = j;
    }
    catch (Exception paramContext)
    {
      label49:
      break label49;
    }
    AppMethodBeat.o(175933);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.h.c
 * JD-Core Version:    0.7.0.1
 */