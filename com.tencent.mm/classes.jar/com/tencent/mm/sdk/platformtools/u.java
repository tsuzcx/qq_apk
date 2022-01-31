package com.tencent.mm.sdk.platformtools;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.tencent.mm.cb.a;

public class u
{
  private static int ueA = -1;
  public static int ueB = -1;
  private static boolean ueC = false;
  private static int ueD = -1;
  private static int ueE = -1;
  
  public static int V(Activity paramActivity)
  {
    Rect localRect = new Rect();
    paramActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame(localRect);
    return localRect.top;
  }
  
  public static final boolean ah(Context paramContext, int paramInt)
  {
    if (ueA == paramInt) {
      return true;
    }
    if (!fz(paramContext)) {
      return false;
    }
    if (paramInt < 0) {
      return false;
    }
    ueA = paramInt;
    y.d("MicroMsg.KeyBordUtil", "save keybord: %d", new Object[] { Integer.valueOf(paramInt) });
    return ae.cqS().edit().putInt("com.tencent.mm.compatible.util.keybord.height", paramInt).commit();
  }
  
  private static int ai(Context paramContext, int paramInt)
  {
    if (paramInt > 0)
    {
      paramInt += 230;
      if (!fz(paramContext)) {
        return paramInt * 3;
      }
      paramInt = a.fromDPToPix(paramContext, paramInt);
      ueE = paramInt;
      return paramInt;
    }
    if (ueE > 0) {
      return ueE;
    }
    if (!fz(paramContext)) {
      return 690;
    }
    paramInt = a.fromDPToPix(paramContext, 230);
    ueE = paramInt;
    return paramInt;
  }
  
  public static final int aj(Context paramContext, int paramInt)
  {
    return f(paramContext, paramInt, 0);
  }
  
  public static int[] cY(Context paramContext)
  {
    if (paramContext == null) {
      paramContext = ae.getContext();
    }
    for (;;)
    {
      int[] arrayOfInt = new int[2];
      if ((paramContext instanceof Activity))
      {
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        ((Activity)paramContext).getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
        arrayOfInt[0] = localDisplayMetrics.widthPixels;
        arrayOfInt[1] = localDisplayMetrics.heightPixels;
        return arrayOfInt;
      }
      paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
      arrayOfInt[0] = paramContext.getWidth();
      arrayOfInt[1] = paramContext.getHeight();
      return arrayOfInt;
    }
  }
  
  public static void cqv()
  {
    ueC = false;
  }
  
  public static final int f(Context paramContext, int paramInt1, int paramInt2)
  {
    int j = ai(paramContext, paramInt2);
    y.e("MicroMsg.KeyBordUtil", "getValidPanelHeight(): minPanelHeight= %d, isOpenIm=%b", new Object[] { Integer.valueOf(j), Integer.valueOf(paramInt2) });
    int i;
    if (!fA(paramContext))
    {
      paramInt2 = (int)(j / 1.5D);
      i = cY(paramContext)[0];
      paramInt1 = paramInt2;
      if (paramInt2 > i / 2) {
        paramInt1 = i / 2;
      }
    }
    do
    {
      return paramInt1;
      paramInt2 = paramInt1;
      if (paramInt1 <= 0) {
        paramInt2 = u(paramContext, true);
      }
      i = fw(paramContext);
      paramInt1 = i;
    } while (paramInt2 > i);
    if (paramInt2 < j) {
      return j;
    }
    return paramInt2;
  }
  
  public static boolean fA(Context paramContext)
  {
    paramContext = cY(paramContext);
    if (paramContext[0] < paramContext[1]) {}
    for (int i = 1; i == 1; i = 2) {
      return true;
    }
    return false;
  }
  
  public static final int fv(Context paramContext)
  {
    if (!ueC)
    {
      if (!fz(paramContext)) {
        return ae.cqS().getInt("com.tencent.mm.compatible.util.keybord.height", 690);
      }
      int i = ae.cqS().getInt("com.tencent.mm.compatible.util.keybord.height", a.fromDPToPix(paramContext, 230));
      ueA = i;
      return i;
    }
    return ai(paramContext, 0);
  }
  
  public static final int fw(Context paramContext)
  {
    if (!ueC)
    {
      if (ueD > 0) {
        return ueD;
      }
      if (!fz(paramContext)) {
        return 1140;
      }
      int i = a.fromDPToPix(paramContext, 380);
      ueD = i;
      return i;
    }
    return ai(paramContext, 0);
  }
  
  public static final int fx(Context paramContext)
  {
    return ai(paramContext, 0);
  }
  
  public static final int fy(Context paramContext)
  {
    return f(paramContext, -1, 0);
  }
  
  private static final boolean fz(Context paramContext)
  {
    Context localContext = paramContext;
    if (paramContext == null) {
      localContext = ae.getContext();
    }
    return localContext != null;
  }
  
  public static final int u(Context paramContext, boolean paramBoolean)
  {
    if (!ueC)
    {
      if ((ueA > 0) && (paramBoolean)) {
        return ueA;
      }
      return fv(paramContext);
    }
    return ai(paramContext, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.u
 * JD-Core Version:    0.7.0.1
 */