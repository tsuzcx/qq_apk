package com.tencent.mm.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.tencent.mm.ci.a.d;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class aq
{
  public static int cD(Context paramContext)
  {
    if (((paramContext instanceof AppCompatActivity)) && (((AppCompatActivity)paramContext).getSupportActionBar() != null)) {
      return ((AppCompatActivity)paramContext).getSupportActionBar().getHeight();
    }
    DisplayMetrics localDisplayMetrics = paramContext.getResources().getDisplayMetrics();
    if (localDisplayMetrics.widthPixels > localDisplayMetrics.heightPixels) {
      return paramContext.getResources().getDimensionPixelSize(a.d.DefaultActionbarHeightLand);
    }
    return paramContext.getResources().getDimensionPixelSize(a.d.DefaultActionbarHeightPort);
  }
  
  public static int gA(Context paramContext)
  {
    try
    {
      Class localClass = Class.forName("com.android.internal.R$dimen");
      Object localObject = localClass.newInstance();
      int i = ar.Jz(localClass.getField("status_bar_height").get(localObject).toString());
      i = paramContext.getResources().getDimensionPixelSize(i);
      return i;
    }
    catch (Exception paramContext)
    {
      ao.a(paramContext, "getStatusBarHeightFromSysR", new Object[0]);
    }
    return 25;
  }
  
  public static int gD(Context paramContext)
  {
    Object localObject2 = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    Object localObject1 = new Point();
    ((Display)localObject2).getSize((Point)localObject1);
    localObject2 = gx(paramContext);
    int i = Math.max(((Point)localObject1).y, ((Point)localObject1).x);
    int j = Math.max(((Point)localObject2).y, ((Point)localObject2).x);
    localObject1 = new Rect();
    if ((paramContext instanceof Activity))
    {
      ((Activity)paramContext).getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject1);
      i = Math.max(((Rect)localObject1).bottom - ((Rect)localObject1).top, ((Rect)localObject1).right - ((Rect)localObject1).left);
    }
    return j - i;
  }
  
  public static int gv(Context paramContext)
  {
    int j = 0;
    int i = j;
    if (gw(paramContext))
    {
      int k = Resources.getSystem().getIdentifier("navigation_bar_height", "dimen", "android");
      i = j;
      if (k > 0) {
        i = Resources.getSystem().getDimensionPixelSize(k);
      }
    }
    return i;
  }
  
  @TargetApi(17)
  public static boolean gw(Context paramContext)
  {
    return gD(paramContext) > 0;
  }
  
  private static Point gx(Context paramContext)
  {
    Point localPoint = new Point();
    paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    if (Build.VERSION.SDK_INT >= 17)
    {
      paramContext.getRealSize(localPoint);
      return localPoint;
    }
    if (Build.VERSION.SDK_INT >= 14) {
      try
      {
        Method localMethod = Display.class.getMethod("getRawHeight", new Class[0]);
        localPoint.x = ((Integer)Display.class.getMethod("getRawWidth", new Class[0]).invoke(paramContext, new Object[0])).intValue();
        localPoint.y = ((Integer)localMethod.invoke(paramContext, new Object[0])).intValue();
        return localPoint;
      }
      catch (NoSuchMethodException paramContext)
      {
        ao.a(paramContext, "getDisplayRealSize NoSuchMethodException", new Object[0]);
        return localPoint;
      }
      catch (IllegalAccessException paramContext)
      {
        ao.a(paramContext, "getDisplayRealSize IllegalAccessException", new Object[0]);
        return localPoint;
      }
      catch (InvocationTargetException paramContext)
      {
        ao.a(paramContext, "getDisplayRealSize InvocationTargetException", new Object[0]);
        return localPoint;
      }
    }
    paramContext.getSize(localPoint);
    return localPoint;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.aq
 * JD-Core Version:    0.7.0.1
 */