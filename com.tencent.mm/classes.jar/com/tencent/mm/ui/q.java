package com.tencent.mm.ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;
import com.tencent.mm.sdk.h.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class q
{
  public static int VA(int paramInt)
  {
    return ((int)((paramInt >> 24 & 0xFF) * 0.78F + 56.100006F) & 0xFF) << 24 | ((int)((paramInt >> 16 & 0xFF) * 0.78F + 0.0F) & 0xFF) << 16 | ((int)((paramInt >> 8 & 0xFF) * 0.78F + 0.0F) & 0xFF) << 8 | ((int)((paramInt & 0xFF) * 0.78F + 0.0F) & 0xFF) << 0;
  }
  
  private static int aH(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(175975);
    Rect localRect = new Rect();
    ((Activity)paramContext).getWindow().getDecorView().getWindowVisibleDisplayFrame(localRect);
    if (localRect.top > paramInt)
    {
      ac.w("Luggage.LuggageUIHelper", "[fixStatusBarHeight] top:%s statusHeight:%s", new Object[] { Integer.valueOf(localRect.top), Integer.valueOf(paramInt) });
      AppMethodBeat.o(175975);
      return 0;
    }
    AppMethodBeat.o(175975);
    return paramInt;
  }
  
  public static void b(Window paramWindow)
  {
    AppMethodBeat.i(175977);
    if (paramWindow == null)
    {
      AppMethodBeat.o(175977);
      return;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramWindow.addFlags(-2147483648);
      paramWindow.setStatusBarColor(0);
    }
    AppMethodBeat.o(175977);
  }
  
  public static boolean c(Window paramWindow, boolean paramBoolean)
  {
    AppMethodBeat.i(175978);
    if ((paramWindow == null) || (paramWindow.getDecorView() == null))
    {
      AppMethodBeat.o(175978);
      return false;
    }
    if (fgC())
    {
      paramWindow = paramWindow.getDecorView();
      int i = paramWindow.getSystemUiVisibility();
      if (paramBoolean) {
        i |= 0x2000;
      }
      for (;;)
      {
        paramWindow.setSystemUiVisibility(i);
        AppMethodBeat.o(175978);
        return true;
        i &= 0xFFFFDFFF;
      }
    }
    AppMethodBeat.o(175978);
    return false;
  }
  
  public static Point cl(Context paramContext)
  {
    AppMethodBeat.i(175980);
    Point localPoint = new Point();
    if (paramContext == null)
    {
      AppMethodBeat.o(175980);
      return localPoint;
    }
    paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    if (Build.VERSION.SDK_INT >= 17) {
      paramContext.getRealSize(localPoint);
    }
    for (;;)
    {
      AppMethodBeat.o(175980);
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
  
  public static boolean fgC()
  {
    AppMethodBeat.i(175979);
    if ((Build.VERSION.SDK_INT >= 23) && (!b.YJ()))
    {
      AppMethodBeat.o(175979);
      return true;
    }
    AppMethodBeat.o(175979);
    return false;
  }
  
  public static int ji(Context paramContext)
  {
    AppMethodBeat.i(175973);
    int i = jx(paramContext);
    AppMethodBeat.o(175973);
    return i;
  }
  
  public static int jw(Context paramContext)
  {
    AppMethodBeat.i(175974);
    int i = jx(paramContext);
    if (i > 0)
    {
      i = aH(paramContext, i);
      AppMethodBeat.o(175974);
      return i;
    }
    if ((paramContext instanceof Activity))
    {
      Rect localRect = new Rect();
      ((Activity)paramContext).getWindow().getDecorView().getWindowVisibleDisplayFrame(localRect);
      i = ((Activity)paramContext).getWindow().getDecorView().getHeight();
      int[] arrayOfInt = new int[2];
      ((Activity)paramContext).getWindow().getDecorView().getLocationOnScreen(arrayOfInt);
      if ((i - localRect.height() >= 0) && (arrayOfInt[1] > 200))
      {
        int j = localRect.height();
        AppMethodBeat.o(175974);
        return i - j;
      }
      i = localRect.top;
      AppMethodBeat.o(175974);
      return i;
    }
    i = a.fromDPToPix(paramContext, 20);
    AppMethodBeat.o(175974);
    return i;
  }
  
  public static int jx(Context paramContext)
  {
    int i = 0;
    AppMethodBeat.i(175976);
    try
    {
      Class localClass = Class.forName("com.android.internal.R$dimen");
      Object localObject = localClass.newInstance();
      int j = bs.getInt(localClass.getField("status_bar_height").get(localObject).toString(), 0);
      j = paramContext.getResources().getDimensionPixelSize(j);
      i = j;
    }
    catch (Exception paramContext)
    {
      label49:
      break label49;
    }
    AppMethodBeat.o(175976);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.q
 * JD-Core Version:    0.7.0.1
 */