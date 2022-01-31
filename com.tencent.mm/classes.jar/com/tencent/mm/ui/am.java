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

public final class am
{
  public static int K(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(112491);
    int i = aA(paramContext, paramInt);
    if (i > 0)
    {
      paramInt = aB(paramContext, i);
      AppMethodBeat.o(112491);
      return paramInt;
    }
    if (i <= 0) {
      ak.i("WeUIToolHelper", "[getStatusBarHeight] return default!!!", new Object[0]);
    }
    for (;;)
    {
      AppMethodBeat.o(112491);
      return paramInt;
      paramInt = i;
    }
  }
  
  private static int aA(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(112492);
    try
    {
      Class localClass = Class.forName("com.android.internal.R$dimen");
      Object localObject = localClass.newInstance();
      int i = an.lT(localClass.getField("status_bar_height").get(localObject).toString());
      i = paramContext.getResources().getDimensionPixelSize(i);
      paramInt = i;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        ak.printErrStackTrace("WeUIToolHelper", paramContext, "getStatusBarHeightFromSysR", new Object[0]);
      }
    }
    ak.i("WeUIToolHelper", "[getStatusBarHeightFromSysR] :%s ", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(112492);
    return paramInt;
  }
  
  private static int aB(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(112493);
    if ((paramContext instanceof Activity))
    {
      DisplayMetrics localDisplayMetrics = ((Activity)paramContext).getResources().getDisplayMetrics();
      Rect localRect = new Rect();
      ((Activity)paramContext).getWindow().getDecorView().getWindowVisibleDisplayFrame(localRect);
      if ((localDisplayMetrics != null) && (localRect.height() > 0))
      {
        int i = localDisplayMetrics.heightPixels - localRect.height();
        ak.i("WeUIToolHelper", "[fixStatusBarHeight] new statusBar:%s ", new Object[] { Integer.valueOf(i) });
        if ((i > paramInt) && (i - paramInt < 100))
        {
          ak.i("WeUIToolHelper", "[fixStatusBarHeight] return new statusBar:%s ", new Object[] { Integer.valueOf(i) });
          AppMethodBeat.o(112493);
          return i;
        }
      }
    }
    AppMethodBeat.o(112493);
    return paramInt;
  }
  
  public static int di(Context paramContext)
  {
    AppMethodBeat.i(112488);
    if (paramContext == null) {
      ak.w("WeUIToolHelper", "[getActionBarHeight] context is null!", new Object[0]);
    }
    int k = paramContext.getResources().getDimensionPixelSize(2131427558);
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
      ak.i("WeUIToolHelper", "[getActionBarHeight] real:%s defaultVal:%s", new Object[] { Integer.valueOf(j), Integer.valueOf(k) });
      AppMethodBeat.o(112488);
      return j;
      if (((paramContext instanceof Activity)) && (((Activity)paramContext).getActionBar() != null)) {
        i = ((Activity)paramContext).getActionBar().getHeight();
      } else {
        label129:
        i = 0;
      }
    }
  }
  
  public static int fx(Context paramContext)
  {
    int i = 0;
    AppMethodBeat.i(112498);
    if (hO(paramContext))
    {
      int j = Resources.getSystem().getIdentifier("navigation_bar_height", "dimen", "android");
      if (j > 0) {
        i = Resources.getSystem().getDimensionPixelSize(j);
      }
      int k = hP(paramContext);
      j = i;
      if (k != 0)
      {
        j = i;
        if (k < i) {
          j = k;
        }
      }
      AppMethodBeat.o(112498);
      return j;
    }
    AppMethodBeat.o(112498);
    return 0;
  }
  
  public static int getStatusBarHeight(Context paramContext)
  {
    AppMethodBeat.i(112490);
    int i = K(paramContext, al.fromDPToPix(paramContext, 25));
    AppMethodBeat.o(112490);
    return i;
  }
  
  @TargetApi(17)
  public static boolean hO(Context paramContext)
  {
    AppMethodBeat.i(112495);
    if (hP(paramContext) > 0)
    {
      AppMethodBeat.o(112495);
      return true;
    }
    AppMethodBeat.o(112495);
    return false;
  }
  
  public static int hP(Context paramContext)
  {
    AppMethodBeat.i(112496);
    Object localObject2 = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    Object localObject1 = new Point();
    ((Display)localObject2).getSize((Point)localObject1);
    localObject2 = hQ(paramContext);
    int i = Math.max(((Point)localObject1).y, ((Point)localObject1).x);
    if (hZ(paramContext)) {
      i = ((Point)localObject1).y;
    }
    int j = Math.max(((Point)localObject2).y, ((Point)localObject2).x);
    localObject1 = new Rect();
    if ((paramContext instanceof Activity))
    {
      ((Activity)paramContext).getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject1);
      i = Math.max(((Rect)localObject1).bottom, ((Rect)localObject1).right);
      if (hZ(paramContext)) {
        i = ((Rect)localObject1).bottom;
      }
    }
    AppMethodBeat.o(112496);
    return j - i;
  }
  
  public static Point hQ(Context paramContext)
  {
    AppMethodBeat.i(112494);
    Point localPoint = new Point();
    paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    if (Build.VERSION.SDK_INT >= 17) {
      paramContext.getRealSize(localPoint);
    }
    for (;;)
    {
      AppMethodBeat.o(112494);
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
          ak.printErrStackTrace("WeUIToolHelper", paramContext, "getDisplayRealSize NoSuchMethodException", new Object[0]);
        }
        catch (IllegalAccessException paramContext)
        {
          ak.printErrStackTrace("WeUIToolHelper", paramContext, "getDisplayRealSize IllegalAccessException", new Object[0]);
        }
        catch (InvocationTargetException paramContext)
        {
          ak.printErrStackTrace("WeUIToolHelper", paramContext, "getDisplayRealSize InvocationTargetException", new Object[0]);
        }
      } else {
        paramContext.getSize(localPoint);
      }
    }
  }
  
  public static int hY(Context paramContext)
  {
    AppMethodBeat.i(112489);
    int i = aA(paramContext, al.fromDPToPix(paramContext, 25));
    AppMethodBeat.o(112489);
    return i;
  }
  
  private static boolean hZ(Context paramContext)
  {
    AppMethodBeat.i(156482);
    if (paramContext.getResources().getConfiguration().orientation == 1)
    {
      AppMethodBeat.o(156482);
      return true;
    }
    AppMethodBeat.o(156482);
    return false;
  }
  
  public static boolean ia(Context paramContext)
  {
    AppMethodBeat.i(112497);
    if ((paramContext instanceof Activity))
    {
      if ((((Activity)paramContext).getWindow().getAttributes().flags & 0x400) != 1024)
      {
        AppMethodBeat.o(112497);
        return true;
      }
      AppMethodBeat.o(112497);
      return false;
    }
    AppMethodBeat.o(112497);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.am
 * JD-Core Version:    0.7.0.1
 */