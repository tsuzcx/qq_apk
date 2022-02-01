package com.tencent.mm.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class ar
{
  public static int B(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(159136);
    int i = aL(paramContext, paramInt);
    if (i > 0)
    {
      paramInt = aK(paramContext, i);
      AppMethodBeat.o(159136);
      return paramInt;
    }
    if (i <= 0) {
      ap.i("WeUIToolHelper", "[getStatusBarHeight] return default!!!", new Object[0]);
    }
    for (;;)
    {
      AppMethodBeat.o(159136);
      return paramInt;
      paramInt = i;
    }
  }
  
  private static int aK(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(159138);
    if ((paramContext instanceof Activity))
    {
      DisplayMetrics localDisplayMetrics = ((Activity)paramContext).getResources().getDisplayMetrics();
      Rect localRect = new Rect();
      ((Activity)paramContext).getWindow().getDecorView().getWindowVisibleDisplayFrame(localRect);
      if ((localDisplayMetrics != null) && (localRect.height() > 0))
      {
        int i = localDisplayMetrics.heightPixels - localRect.height();
        ap.i("WeUIToolHelper", "[fixStatusBarHeight] new statusBar:%s ", new Object[] { Integer.valueOf(i) });
        if ((i > paramInt) && (i - paramInt < 100))
        {
          ap.i("WeUIToolHelper", "[fixStatusBarHeight] return new statusBar:%s ", new Object[] { Integer.valueOf(i) });
          AppMethodBeat.o(159138);
          return i;
        }
      }
    }
    AppMethodBeat.o(159138);
    return paramInt;
  }
  
  private static int aL(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(159137);
    try
    {
      Class localClass = Class.forName("com.android.internal.R$dimen");
      Object localObject = localClass.newInstance();
      int i = as.eZ(localClass.getField("status_bar_height").get(localObject).toString());
      i = paramContext.getResources().getDimensionPixelSize(i);
      paramInt = i;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        ap.printErrStackTrace("WeUIToolHelper", paramContext, "getStatusBarHeightFromSysR", new Object[0]);
      }
    }
    ap.i("WeUIToolHelper", "[getStatusBarHeightFromSysR] :%s ", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(159137);
    return paramInt;
  }
  
  public static Point ci(Context paramContext)
  {
    AppMethodBeat.i(159139);
    Point localPoint = new Point();
    paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    if (Build.VERSION.SDK_INT >= 17) {
      paramContext.getRealSize(localPoint);
    }
    for (;;)
    {
      AppMethodBeat.o(159139);
      return localPoint;
      if (Build.VERSION.SDK_INT >= 14) {
        try
        {
          Method localMethod = Display.class.getMethod("getRawHeight", new Class[0]);
          localPoint.x = ((Integer)Display.class.getMethod("getRawWidth", new Class[0]).invoke(paramContext, new Object[0])).intValue();
          localPoint.y = ((Integer)localMethod.invoke(paramContext, new Object[0])).intValue();
        }
        catch (NoSuchMethodException paramContext)
        {
          ap.printErrStackTrace("WeUIToolHelper", paramContext, "getDisplayRealSize NoSuchMethodException", new Object[0]);
        }
        catch (IllegalAccessException paramContext)
        {
          ap.printErrStackTrace("WeUIToolHelper", paramContext, "getDisplayRealSize IllegalAccessException", new Object[0]);
        }
        catch (InvocationTargetException paramContext)
        {
          ap.printErrStackTrace("WeUIToolHelper", paramContext, "getDisplayRealSize InvocationTargetException", new Object[0]);
        }
      } else {
        paramContext.getSize(localPoint);
      }
    }
  }
  
  public static int dT(Context paramContext)
  {
    AppMethodBeat.i(159133);
    if (paramContext == null) {
      ap.w("WeUIToolHelper", "[getActionBarHeight] context is null!", new Object[0]);
    }
    int k = paramContext.getResources().getDimensionPixelSize(2131165251);
    int i;
    if ((paramContext instanceof AppCompatActivity))
    {
      if (((AppCompatActivity)paramContext).getSupportActionBar() == null) {
        break label129;
      }
      i = ((AppCompatActivity)paramContext).getSupportActionBar().getHeight();
    }
    for (;;)
    {
      int j = i;
      if (i <= 0) {
        j = k;
      }
      ap.i("WeUIToolHelper", "[getActionBarHeight] real:%s defaultVal:%s", new Object[] { Integer.valueOf(j), Integer.valueOf(k) });
      AppMethodBeat.o(159133);
      return j;
      if (((paramContext instanceof Activity)) && (((Activity)paramContext).getActionBar() != null)) {
        i = ((Activity)paramContext).getActionBar().getHeight();
      } else {
        label129:
        i = 0;
      }
    }
  }
  
  public static int ej(Context paramContext)
  {
    int i = 0;
    AppMethodBeat.i(159144);
    if (jR(paramContext))
    {
      int j = Resources.getSystem().getIdentifier("navigation_bar_height", "dimen", "android");
      if (j > 0) {
        i = Resources.getSystem().getDimensionPixelSize(j);
      }
      int k = jS(paramContext);
      j = i;
      if (k != 0)
      {
        j = i;
        if (k < i) {
          j = k;
        }
      }
      AppMethodBeat.o(159144);
      return j;
    }
    AppMethodBeat.o(159144);
    return 0;
  }
  
  public static int jG(Context paramContext)
  {
    AppMethodBeat.i(159135);
    int i = B(paramContext, aq.fromDPToPix(paramContext, 25));
    AppMethodBeat.o(159135);
    return i;
  }
  
  @TargetApi(17)
  public static boolean jR(Context paramContext)
  {
    AppMethodBeat.i(159140);
    if (jS(paramContext) > 0)
    {
      AppMethodBeat.o(159140);
      return true;
    }
    AppMethodBeat.o(159140);
    return false;
  }
  
  public static int jS(Context paramContext)
  {
    AppMethodBeat.i(159141);
    Object localObject2 = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    Object localObject1 = new Point();
    ((Display)localObject2).getSize((Point)localObject1);
    localObject2 = ci(paramContext);
    int i = Math.max(((Point)localObject1).y, ((Point)localObject1).x);
    if (jX(paramContext)) {
      i = ((Point)localObject1).y;
    }
    int j = Math.max(((Point)localObject2).y, ((Point)localObject2).x);
    localObject1 = new Rect();
    if ((paramContext instanceof Activity))
    {
      ((Activity)paramContext).getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject1);
      i = Math.max(((Rect)localObject1).bottom, ((Rect)localObject1).right);
      if (jX(paramContext)) {
        i = ((Rect)localObject1).bottom;
      }
    }
    AppMethodBeat.o(159141);
    return j - i;
  }
  
  public static int jW(Context paramContext)
  {
    AppMethodBeat.i(159134);
    int i = aL(paramContext, aq.fromDPToPix(paramContext, 25));
    AppMethodBeat.o(159134);
    return i;
  }
  
  private static boolean jX(Context paramContext)
  {
    AppMethodBeat.i(159142);
    if (paramContext.getResources().getConfiguration().orientation == 1)
    {
      AppMethodBeat.o(159142);
      return true;
    }
    AppMethodBeat.o(159142);
    return false;
  }
  
  public static boolean jY(Context paramContext)
  {
    AppMethodBeat.i(159143);
    if ((paramContext instanceof Activity))
    {
      if ((((Activity)paramContext).getWindow().getAttributes().flags & 0x400) != 1024)
      {
        AppMethodBeat.o(159143);
        return true;
      }
      AppMethodBeat.o(159143);
      return false;
    }
    AppMethodBeat.o(159143);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.ar
 * JD-Core Version:    0.7.0.1
 */