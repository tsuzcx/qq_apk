package com.tencent.mm.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;

public final class bg
{
  private static Boolean adLj = null;
  
  public static Point bf(Context paramContext)
  {
    AppMethodBeat.i(159145);
    Point localPoint = new Point();
    paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    if (Build.VERSION.SDK_INT >= 17) {
      paramContext.getRealSize(localPoint);
    }
    for (;;)
    {
      AppMethodBeat.o(159145);
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
  
  public static boolean bg(Context paramContext)
  {
    AppMethodBeat.i(159146);
    Display localDisplay = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    Point localPoint = new Point();
    localDisplay.getSize(localPoint);
    paramContext = bf(paramContext);
    int i = Math.max(localPoint.y, localPoint.x);
    if (Math.max(paramContext.y, paramContext.x) > i)
    {
      AppMethodBeat.o(159146);
      return true;
    }
    AppMethodBeat.o(159146);
    return false;
  }
  
  public static int bk(Context paramContext)
  {
    AppMethodBeat.i(168811);
    if (bg(paramContext))
    {
      int i = Resources.getSystem().getIdentifier("navigation_bar_height", "dimen", "android");
      if (i > 0)
      {
        i = Resources.getSystem().getDimensionPixelSize(i);
        AppMethodBeat.o(168811);
        return i;
      }
    }
    AppMethodBeat.o(168811);
    return 0;
  }
  
  public static int ew(String paramString)
  {
    AppMethodBeat.i(159147);
    if (paramString != null) {}
    try
    {
      if (paramString.length() <= 0)
      {
        AppMethodBeat.o(159147);
        return 0;
      }
      int i = Integer.decode(paramString).intValue();
      AppMethodBeat.o(159147);
      return i;
    }
    catch (NumberFormatException paramString)
    {
      bc.printErrStackTrace("WeUIUtil", paramString, "", new Object[0]);
      AppMethodBeat.o(159147);
    }
    return 0;
  }
  
  public static boolean isMIUI()
  {
    AppMethodBeat.i(249402);
    if (adLj == null)
    {
      String str = Build.MANUFACTURER;
      if ((TextUtils.isEmpty(str)) || (!str.equalsIgnoreCase("xiaomi"))) {
        break label54;
      }
    }
    label54:
    for (boolean bool = true;; bool = false)
    {
      adLj = Boolean.valueOf(bool);
      bool = adLj.booleanValue();
      AppMethodBeat.o(249402);
      return bool;
    }
  }
  
  public static boolean jlr()
  {
    AppMethodBeat.i(249406);
    String str = Build.MANUFACTURER;
    if ((!TextUtils.isEmpty(str)) && (str.equalsIgnoreCase("blackshark")))
    {
      AppMethodBeat.o(249406);
      return true;
    }
    AppMethodBeat.o(249406);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.bg
 * JD-Core Version:    0.7.0.1
 */