package com.tencent.mm.sdk.platformtools;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;

public class x
{
  public static int ynb = -1;
  public static int ync = -1;
  private static boolean ynd = false;
  private static int yne = -1;
  private static int ynf = -1;
  
  public static int at(Activity paramActivity)
  {
    AppMethodBeat.i(115203);
    Rect localRect = new Rect();
    paramActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame(localRect);
    int i = localRect.top;
    AppMethodBeat.o(115203);
    return i;
  }
  
  public static final int av(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(115195);
    if (paramInt > 0)
    {
      paramInt += 230;
      if (!gM(paramContext))
      {
        AppMethodBeat.o(115195);
        return paramInt * 3;
      }
      paramInt = a.fromDPToPix(paramContext, paramInt);
      ynf = paramInt;
      AppMethodBeat.o(115195);
      return paramInt;
    }
    if (ynf > 0)
    {
      paramInt = ynf;
      AppMethodBeat.o(115195);
      return paramInt;
    }
    if (!gM(paramContext))
    {
      AppMethodBeat.o(115195);
      return 690;
    }
    paramInt = a.fromDPToPix(paramContext, 230);
    ynf = paramInt;
    AppMethodBeat.o(115195);
    return paramInt;
  }
  
  public static final int aw(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(115196);
    paramInt = f(paramContext, paramInt, 0);
    AppMethodBeat.o(115196);
    return paramInt;
  }
  
  public static int[] dh(Context paramContext)
  {
    AppMethodBeat.i(115202);
    if (paramContext == null) {
      paramContext = ah.getContext();
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
      }
      for (;;)
      {
        AppMethodBeat.o(115202);
        return arrayOfInt;
        paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
        arrayOfInt[0] = paramContext.getWidth();
        arrayOfInt[1] = paramContext.getHeight();
      }
    }
  }
  
  public static void dss()
  {
    ynd = false;
  }
  
  public static final int f(Context paramContext, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115197);
    int i = av(paramContext, paramInt2);
    ab.e("MicroMsg.KeyBordUtil", "getValidPanelHeight(): minPanelHeight= %d, isOpenIm=%b", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt2) });
    if (!gN(paramContext))
    {
      paramInt2 = (int)(i / 1.5D);
      i = dh(paramContext)[0];
      paramInt1 = paramInt2;
      if (paramInt2 > i / 2) {
        paramInt1 = i / 2;
      }
      AppMethodBeat.o(115197);
      return paramInt1;
    }
    paramInt2 = paramInt1;
    if (paramInt1 <= 0) {
      paramInt2 = gJ(paramContext);
    }
    paramInt1 = gK(paramContext);
    if (paramInt2 > paramInt1)
    {
      AppMethodBeat.o(115197);
      return paramInt1;
    }
    if (paramInt2 < i)
    {
      AppMethodBeat.o(115197);
      return i;
    }
    AppMethodBeat.o(115197);
    return paramInt2;
  }
  
  public static final int gI(Context paramContext)
  {
    AppMethodBeat.i(115192);
    if (!ynd)
    {
      if (!gM(paramContext))
      {
        i = ah.dsQ().getInt("com.tencent.mm.compatible.util.keybord.height", 690);
        AppMethodBeat.o(115192);
        return i;
      }
      i = ah.dsQ().getInt("com.tencent.mm.compatible.util.keybord.height", a.fromDPToPix(paramContext, 230));
      ynb = i;
      AppMethodBeat.o(115192);
      return i;
    }
    int i = av(paramContext, 0);
    AppMethodBeat.o(115192);
    return i;
  }
  
  public static final int gJ(Context paramContext)
  {
    AppMethodBeat.i(115193);
    if (!ynd)
    {
      if (ynb > 0)
      {
        i = ynb;
        AppMethodBeat.o(115193);
        return i;
      }
      i = gI(paramContext);
      AppMethodBeat.o(115193);
      return i;
    }
    int i = av(paramContext, 0);
    AppMethodBeat.o(115193);
    return i;
  }
  
  public static final int gK(Context paramContext)
  {
    AppMethodBeat.i(115194);
    if (!ynd)
    {
      if (yne > 0)
      {
        i = yne;
        AppMethodBeat.o(115194);
        return i;
      }
      if (!gM(paramContext))
      {
        AppMethodBeat.o(115194);
        return 1140;
      }
      i = a.fromDPToPix(paramContext, 380);
      yne = i;
      AppMethodBeat.o(115194);
      return i;
    }
    int i = av(paramContext, 0);
    AppMethodBeat.o(115194);
    return i;
  }
  
  public static final int gL(Context paramContext)
  {
    AppMethodBeat.i(115198);
    int i = f(paramContext, -1, 0);
    AppMethodBeat.o(115198);
    return i;
  }
  
  public static final boolean gM(Context paramContext)
  {
    AppMethodBeat.i(115199);
    Context localContext = paramContext;
    if (paramContext == null) {
      localContext = ah.getContext();
    }
    if (localContext != null)
    {
      AppMethodBeat.o(115199);
      return true;
    }
    AppMethodBeat.o(115199);
    return false;
  }
  
  public static boolean gN(Context paramContext)
  {
    AppMethodBeat.i(115200);
    if (gO(paramContext) == 1)
    {
      AppMethodBeat.o(115200);
      return true;
    }
    AppMethodBeat.o(115200);
    return false;
  }
  
  private static int gO(Context paramContext)
  {
    int i = 1;
    AppMethodBeat.i(115201);
    paramContext = dh(paramContext);
    if (paramContext[0] < paramContext[1]) {}
    for (;;)
    {
      AppMethodBeat.o(115201);
      return i;
      i = 2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.x
 * JD-Core Version:    0.7.0.1
 */