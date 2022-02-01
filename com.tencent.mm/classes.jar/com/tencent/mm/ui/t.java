package com.tencent.mm.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import com.tencent.mm.compatible.util.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.vendor.MIUI;
import java.lang.reflect.Method;

public class t
{
  public static int aor(int paramInt)
  {
    return ((int)((paramInt >> 24 & 0xFF) * 0.78F + 56.100006F) & 0xFF) << 24 | ((int)((paramInt >> 16 & 0xFF) * 0.78F + 0.0F) & 0xFF) << 16 | ((int)((paramInt >> 8 & 0xFF) * 0.78F + 0.0F) & 0xFF) << 8 | ((int)((paramInt & 0xFF) * 0.78F + 0.0F) & 0xFF) << 0;
  }
  
  public static Point au(Context paramContext)
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
  
  private static int be(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(175975);
    Rect localRect = new Rect();
    ((Activity)paramContext).getWindow().getDecorView().getWindowVisibleDisplayFrame(localRect);
    if (localRect.top > paramInt)
    {
      Log.w("Luggage.LuggageUIHelper", "[fixStatusBarHeight] top:%s statusHeight:%s", new Object[] { Integer.valueOf(localRect.top), Integer.valueOf(paramInt) });
      AppMethodBeat.o(175975);
      return 0;
    }
    AppMethodBeat.o(175975);
    return paramInt;
  }
  
  private static boolean byq(String paramString)
  {
    AppMethodBeat.i(237533);
    String str1 = Build.MODEL;
    String str2 = Build.DEVICE;
    if ((str1 == null) && (str2 == null))
    {
      AppMethodBeat.o(237533);
      return false;
    }
    if ((nW(str1, paramString)) || (nW(str2, paramString)))
    {
      AppMethodBeat.o(237533);
      return true;
    }
    AppMethodBeat.o(237533);
    return false;
  }
  
  public static boolean d(Window paramWindow, boolean paramBoolean)
  {
    AppMethodBeat.i(175978);
    if ((paramWindow == null) || (paramWindow.getDecorView() == null))
    {
      AppMethodBeat.o(175978);
      return false;
    }
    if (hHz())
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
  
  public static void e(Window paramWindow)
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
  
  public static int getStatusBarHeight(Context paramContext)
  {
    AppMethodBeat.i(175973);
    int i = n.F(paramContext, 25);
    AppMethodBeat.o(175973);
    return i;
  }
  
  public static boolean hHy()
  {
    AppMethodBeat.i(237535);
    if ((byq("y83a")) || (byq("y83")) || (byq("v1732a")) || (byq("v1732t")))
    {
      AppMethodBeat.o(237535);
      return true;
    }
    AppMethodBeat.o(237535);
    return false;
  }
  
  public static boolean hHz()
  {
    AppMethodBeat.i(175979);
    if ((Build.VERSION.SDK_INT >= 23) && (!MIUI.isMIUIV8()))
    {
      AppMethodBeat.o(175979);
      return true;
    }
    AppMethodBeat.o(175979);
    return false;
  }
  
  public static int kI(Context paramContext)
  {
    AppMethodBeat.i(175974);
    int i = n.F(paramContext, -1);
    if (i > 0)
    {
      i = be(paramContext, i);
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
  
  public static int kJ(Context paramContext)
  {
    AppMethodBeat.i(175976);
    int i = n.F(paramContext, 0);
    AppMethodBeat.o(175976);
    return i;
  }
  
  private static boolean nW(String paramString1, String paramString2)
  {
    AppMethodBeat.i(237534);
    if ((paramString1 == null) || (paramString2 == null))
    {
      AppMethodBeat.o(237534);
      return false;
    }
    boolean bool = Util.isEqual(paramString1.toLowerCase(), paramString2.toLowerCase());
    AppMethodBeat.o(237534);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.t
 * JD-Core Version:    0.7.0.1
 */