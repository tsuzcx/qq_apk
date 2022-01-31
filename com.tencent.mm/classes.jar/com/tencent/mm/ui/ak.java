package com.tencent.mm.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.util.SparseArray;
import android.view.Display;
import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import com.tencent.mm.compatible.loader.c;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public final class ak
{
  private static Rect uRp = new Rect(0, 0, 0, 0);
  
  public static int Cx(int paramInt)
  {
    return ((int)((paramInt >> 24 & 0xFF) * 0.78F + 56.100006F) & 0xFF) << 24 | ((int)((paramInt >> 16 & 0xFF) * 0.78F + 0.0F) & 0xFF) << 16 | ((int)((paramInt >> 8 & 0xFF) * 0.78F + 0.0F) & 0xFF) << 8 | ((int)((paramInt & 0xFF) * 0.78F + 0.0F) & 0xFF) << 0;
  }
  
  public static void D(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    uRp.set(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public static int[] Y(Bitmap paramBitmap)
  {
    return d(paramBitmap, 4, 4);
  }
  
  @TargetApi(21)
  public static ViewGroup a(Window paramWindow, View paramView)
  {
    View localView = null;
    if (paramWindow == null) {
      return null;
    }
    Object localObject = f(paramWindow);
    if (localObject != null) {
      return localObject;
    }
    if (paramView != null) {
      for (paramView = paramView.getParent(); (paramView != paramWindow.getDecorView()) && (paramView != null); paramView = (View)localObject)
      {
        localObject = paramView.getParent();
        localView = paramView;
      }
    }
    for (paramView = localView;; paramView = null)
    {
      if (paramView == null)
      {
        localView = ((ViewGroup)paramWindow.getDecorView()).getChildAt(0);
        if ((localView instanceof ViewGroup)) {
          return (ViewGroup)localView;
        }
        if (Build.VERSION.SDK_INT >= 21) {
          paramWindow.clearFlags(-2147483648);
        }
      }
      return (ViewGroup)paramView;
    }
  }
  
  public static void a(Window paramWindow)
  {
    if (paramWindow == null) {}
    while (Build.VERSION.SDK_INT < 21) {
      return;
    }
    paramWindow.addFlags(-2147483648);
    paramWindow.setStatusBarColor(0);
  }
  
  private static float[] b(List<float[]> paramList, int paramInt1, int paramInt2)
  {
    float[] arrayOfFloat;
    if (paramList.size() > Math.max(paramInt1, paramInt2))
    {
      arrayOfFloat = null;
      paramInt1 = 0;
      if (paramInt1 < paramList.size())
      {
        if (((float[])paramList.get(paramInt1))[2] >= 3.4028235E+38F) {
          break label126;
        }
        arrayOfFloat = (float[])paramList.get(paramInt1);
      }
    }
    label126:
    for (;;)
    {
      paramInt1 += 1;
      break;
      if (arrayOfFloat[2] <= 0.15D) {
        return arrayOfFloat;
      }
      if (arrayOfFloat[1] > 0.5D) {
        arrayOfFloat[1] -= 0.1F;
      }
      arrayOfFloat[2] -= 0.1F;
      return arrayOfFloat;
      paramList = (float[])paramList.get(0);
      paramList[2] = 0.15F;
      return paramList;
    }
  }
  
  public static Rect cAg()
  {
    return uRp;
  }
  
  public static int[] d(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    Object localObject = Bitmap.createScaledBitmap(paramBitmap, paramInt1, paramInt2, false);
    paramBitmap = new int[paramInt1 * paramInt2];
    ((Bitmap)localObject).getPixels(paramBitmap, 0, paramInt1, 0, 0, paramInt1, paramInt2);
    float[][] arrayOfFloat = new float[paramInt1 * paramInt2][];
    int i = 0;
    while (i < paramInt1 * paramInt2)
    {
      localObject = new float[3];
      Color.colorToHSV(paramBitmap[i], (float[])localObject);
      arrayOfFloat[i] = localObject;
      i += 1;
    }
    int[] arrayOfInt = new int[8];
    SparseArray localSparseArray = new SparseArray();
    i = 0;
    if (i < arrayOfFloat.length)
    {
      j = 1;
      for (;;)
      {
        if (j <= 7)
        {
          if (arrayOfFloat[i][0] < 360.0F * (j / 7.0F))
          {
            arrayOfInt[j] += 1;
            localObject = (List)localSparseArray.get(j);
            paramBitmap = (Bitmap)localObject;
            if (localObject == null) {
              paramBitmap = new ArrayList();
            }
            paramBitmap.add(arrayOfFloat[i]);
            localSparseArray.put(j, paramBitmap);
          }
        }
        else
        {
          i += 1;
          break;
        }
        j += 1;
      }
    }
    int k = -1;
    int j = 0;
    i = 1;
    while (i <= 7)
    {
      int m = j;
      if (arrayOfInt[i] > j)
      {
        m = arrayOfInt[i];
        k = i;
      }
      i += 1;
      j = m;
    }
    paramBitmap = b((List)localSparseArray.get(k, new ArrayList()), paramInt1, paramInt2);
    localObject = new float[3];
    if (paramBitmap[2] <= 0.15D)
    {
      localObject[0] = paramBitmap[0];
      localObject[1] = paramBitmap[1];
      paramBitmap[2] += 0.7F;
    }
    for (;;)
    {
      if (localObject[1] > 0.5F) {
        localObject[1] -= 0.1F;
      }
      return new int[] { Color.HSVToColor(paramBitmap), Color.HSVToColor((float[])localObject) };
      localObject[0] = paramBitmap[0];
      localObject[1] = paramBitmap[1];
      if (paramBitmap[2] + 0.5D >= 1.0D) {
        paramBitmap[2] -= 0.5F;
      } else {
        paramBitmap[2] += 0.5F;
      }
    }
  }
  
  private static ViewGroup f(Window paramWindow)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramWindow = new c(paramWindow, "mContentRoot", null);
      if (!paramWindow.zy()) {}
    }
    try
    {
      paramWindow = (ViewGroup)paramWindow.get();
      return paramWindow;
    }
    catch (NoSuchFieldException paramWindow)
    {
      y.printErrStackTrace("MicroMsg.UIUtils", paramWindow, "", new Object[0]);
      return null;
    }
    catch (IllegalAccessException paramWindow)
    {
      break label38;
    }
    catch (IllegalArgumentException paramWindow)
    {
      label38:
      break label38;
    }
  }
  
  public static void g(Window paramWindow)
  {
    if ((paramWindow == null) || (paramWindow.getDecorView() == null)) {}
    while (Build.VERSION.SDK_INT < 23) {
      return;
    }
    paramWindow = paramWindow.getDecorView();
    paramWindow.setSystemUiVisibility(paramWindow.getSystemUiVisibility() | 0x2000);
  }
  
  @TargetApi(20)
  public static boolean g(View paramView1, final View paramView2)
  {
    if (!com.tencent.mm.compatible.util.d.gF(21)) {
      return true;
    }
    if ((paramView1 != null) && ((paramView1 instanceof ViewGroup)) && (paramView2 != null) && ((paramView1.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)))
    {
      paramView1.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener()
      {
        public final WindowInsets onApplyWindowInsets(View paramAnonymousView, WindowInsets paramAnonymousWindowInsets)
        {
          paramAnonymousView = (ViewGroup.MarginLayoutParams)this.uRq.getLayoutParams();
          ak.D(paramAnonymousView.leftMargin, paramAnonymousView.topMargin, paramAnonymousView.rightMargin, paramAnonymousView.bottomMargin);
          paramView2.setPadding(paramView2.getPaddingLeft(), paramView2.getPaddingTop(), paramAnonymousView.rightMargin, paramAnonymousView.bottomMargin);
          return this.uRq.onApplyWindowInsets(paramAnonymousWindowInsets);
        }
      });
      return true;
    }
    return false;
  }
  
  public static int gA(Context paramContext)
  {
    try
    {
      Class localClass = Class.forName("com.android.internal.R$dimen");
      Object localObject = localClass.newInstance();
      int i = bk.getInt(localClass.getField("status_bar_height").get(localObject).toString(), 0);
      i = paramContext.getResources().getDimensionPixelSize(i);
      return i;
    }
    catch (Exception paramContext) {}
    return 0;
  }
  
  public static int gB(Context paramContext)
  {
    return gA(paramContext);
  }
  
  public static boolean gC(Context paramContext)
  {
    boolean bool2 = false;
    if (!com.tencent.mm.sdk.g.d.gb(paramContext))
    {
      if (paramContext != null) {
        break label40;
      }
      bool1 = false;
      if ((!bool1) && (!com.tencent.mm.sdk.g.a.ga(paramContext))) {
        if (paramContext != null) {
          break label54;
        }
      }
    }
    label40:
    label54:
    for (boolean bool1 = false;; bool1 = paramContext.getPackageManager().hasSystemFeature("android.hardware.notch_support"))
    {
      if (bool1) {
        bool2 = true;
      }
      return bool2;
      bool1 = paramContext.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
      break;
    }
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
    int i;
    if (paramContext == null) {
      i = 0;
    }
    while (i > 0)
    {
      return true;
      Object localObject1 = (WindowManager)paramContext.getSystemService("window");
      if (localObject1 == null)
      {
        y.e("MicroMsg.UIUtils", "getRealBottomHeight, get NULL windowManager");
        i = 0;
      }
      else
      {
        Object localObject2 = ((WindowManager)localObject1).getDefaultDisplay();
        localObject1 = new Point();
        ((Display)localObject2).getSize((Point)localObject1);
        localObject2 = gx(paramContext);
        i = Math.max(((Point)localObject1).y, ((Point)localObject1).x);
        int j = Math.max(((Point)localObject2).y, ((Point)localObject2).x);
        localObject1 = new Rect();
        if ((paramContext instanceof Activity))
        {
          ((Activity)paramContext).getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject1);
          i = Math.max(((Rect)localObject1).bottom - ((Rect)localObject1).top, ((Rect)localObject1).right - ((Rect)localObject1).left);
        }
        i = j - i;
      }
    }
    return false;
  }
  
  public static Point gx(Context paramContext)
  {
    Point localPoint = new Point();
    if (paramContext == null) {
      return localPoint;
    }
    paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    if (Build.VERSION.SDK_INT >= 17) {
      paramContext.getRealSize(localPoint);
    }
    for (;;)
    {
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
  
  public static int gy(Context paramContext)
  {
    return gA(paramContext);
  }
  
  public static int gz(Context paramContext)
  {
    int j = gA(paramContext);
    Rect localRect;
    int i;
    if (j > 0)
    {
      localRect = new Rect();
      ((Activity)paramContext).getWindow().getDecorView().getWindowVisibleDisplayFrame(localRect);
      i = j;
      if (localRect.top > j) {
        i = 0;
      }
      return i;
    }
    if ((paramContext instanceof Activity))
    {
      localRect = new Rect();
      ((Activity)paramContext).getWindow().getDecorView().getWindowVisibleDisplayFrame(localRect);
      i = ((Activity)paramContext).getWindow().getDecorView().getHeight();
      int[] arrayOfInt = new int[2];
      ((Activity)paramContext).getWindow().getDecorView().getLocationOnScreen(arrayOfInt);
      if ((i - localRect.height() >= 0) && (arrayOfInt[1] > 200)) {
        return i - localRect.height();
      }
      return localRect.top;
    }
    return com.tencent.mm.cb.a.fromDPToPix(paramContext, 20);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.ak
 * JD-Core Version:    0.7.0.1
 */