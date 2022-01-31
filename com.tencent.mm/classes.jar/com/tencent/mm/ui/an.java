package com.tencent.mm.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;

public final class an
{
  @TargetApi(17)
  public static boolean hO(Context paramContext)
  {
    AppMethodBeat.i(112500);
    Display localDisplay = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    Point localPoint = new Point();
    localDisplay.getSize(localPoint);
    paramContext = hQ(paramContext);
    int i = Math.max(localPoint.y, localPoint.x);
    if (Math.max(paramContext.y, paramContext.x) > i)
    {
      AppMethodBeat.o(112500);
      return true;
    }
    AppMethodBeat.o(112500);
    return false;
  }
  
  public static Point hQ(Context paramContext)
  {
    AppMethodBeat.i(112499);
    Point localPoint = new Point();
    paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    if (Build.VERSION.SDK_INT >= 17) {
      paramContext.getRealSize(localPoint);
    }
    for (;;)
    {
      AppMethodBeat.o(112499);
      return localPoint;
      if (Build.VERSION.SDK_INT >= 14) {
        try
        {
          Method localMethod = Display.class.getMethod("getRawHeight", new Class[0]);
          localPoint.x = ((Integer)Display.class.getMethod("getRawWidth", new Class[0]).invoke(paramContext, new Object[0])).intValue();
          localPoint.y = ((Integer)localMethod.invoke(paramContext, new Object[0])).intValue();
        }
        catch (Exception localException) {}
      } else {
        paramContext.getSize(localPoint);
      }
    }
  }
  
  public static int lT(String paramString)
  {
    AppMethodBeat.i(112501);
    if (paramString != null) {}
    try
    {
      if (paramString.length() <= 0)
      {
        AppMethodBeat.o(112501);
        return 0;
      }
      int i = Integer.decode(paramString).intValue();
      AppMethodBeat.o(112501);
      return i;
    }
    catch (NumberFormatException paramString)
    {
      ak.printErrStackTrace("WeUIUtil", paramString, "", new Object[0]);
      AppMethodBeat.o(112501);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.an
 * JD-Core Version:    0.7.0.1
 */