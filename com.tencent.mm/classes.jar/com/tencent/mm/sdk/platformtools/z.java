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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.compatible.util.d;

public class z
{
  private static int ETS = -1;
  public static int ETT = -1;
  private static boolean ETU = false;
  private static int ETV = -1;
  private static int ETW = -1;
  
  public static int aQ(Activity paramActivity)
  {
    AppMethodBeat.i(125238);
    Rect localRect = new Rect();
    paramActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame(localRect);
    int i = localRect.top;
    AppMethodBeat.o(125238);
    return i;
  }
  
  public static final boolean aw(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(164122);
    if (ETS == paramInt)
    {
      AppMethodBeat.o(164122);
      return true;
    }
    if (!io(paramContext))
    {
      AppMethodBeat.o(164122);
      return false;
    }
    if (paramInt < 0)
    {
      AppMethodBeat.o(164122);
      return false;
    }
    ETS = paramInt;
    ad.d("MicroMsg.KeyBordUtil", "save keybord: %d", new Object[] { Integer.valueOf(paramInt) });
    boolean bool = aj.eFE().edit().putInt("com.tencent.mm.compatible.util.keybord.height", paramInt).commit();
    AppMethodBeat.o(164122);
    return bool;
  }
  
  public static final int ax(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(125230);
    if (paramInt > 0)
    {
      paramInt += 230;
      if (!io(paramContext))
      {
        AppMethodBeat.o(125230);
        return paramInt * 3;
      }
      paramInt = a.fromDPToPix(paramContext, paramInt);
      ETW = paramInt;
      AppMethodBeat.o(125230);
      return paramInt;
    }
    if (ETW > 0)
    {
      paramInt = ETW;
      AppMethodBeat.o(125230);
      return paramInt;
    }
    if (!io(paramContext))
    {
      AppMethodBeat.o(125230);
      return 690;
    }
    paramInt = a.fromDPToPix(paramContext, 230);
    ETW = paramInt;
    AppMethodBeat.o(125230);
    return paramInt;
  }
  
  public static final int ay(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(125231);
    paramInt = h(paramContext, paramInt, 0);
    AppMethodBeat.o(125231);
    return paramInt;
  }
  
  public static void eFi()
  {
    ETU = false;
  }
  
  public static int[] et(Context paramContext)
  {
    AppMethodBeat.i(125237);
    if (paramContext == null) {
      paramContext = aj.getContext();
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
        AppMethodBeat.o(125237);
        return arrayOfInt;
        paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
        arrayOfInt[0] = paramContext.getWidth();
        arrayOfInt[1] = paramContext.getHeight();
      }
    }
  }
  
  public static final int h(Context paramContext, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(125232);
    int i = ax(paramContext, paramInt2);
    ad.e("MicroMsg.KeyBordUtil", "getValidPanelHeight(): minPanelHeight= %d, isOpenIm=%b", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt2) });
    if ((d.lf(24)) && ((paramContext instanceof Activity))) {}
    for (boolean bool = ((Activity)paramContext).isInMultiWindowMode();; bool = false)
    {
      if ((!ip(paramContext)) || (bool))
      {
        paramInt2 = (int)(i / 1.5D);
        i = et(paramContext)[0];
        paramInt1 = paramInt2;
        if (paramInt2 > i / 2) {
          paramInt1 = i / 2;
        }
        AppMethodBeat.o(125232);
        return paramInt1;
      }
      paramInt2 = paramInt1;
      if (paramInt1 <= 0) {
        paramInt2 = il(paramContext);
      }
      paramInt1 = im(paramContext);
      if (paramInt2 > paramInt1)
      {
        AppMethodBeat.o(125232);
        return paramInt1;
      }
      if (paramInt2 < i)
      {
        AppMethodBeat.o(125232);
        return i;
      }
      AppMethodBeat.o(125232);
      return paramInt2;
    }
  }
  
  public static final int ik(Context paramContext)
  {
    AppMethodBeat.i(125227);
    if (!ETU)
    {
      if (!io(paramContext))
      {
        i = aj.eFE().getInt("com.tencent.mm.compatible.util.keybord.height", 690);
        AppMethodBeat.o(125227);
        return i;
      }
      i = aj.eFE().getInt("com.tencent.mm.compatible.util.keybord.height", a.fromDPToPix(paramContext, 230));
      ETS = i;
      AppMethodBeat.o(125227);
      return i;
    }
    int i = ax(paramContext, 0);
    AppMethodBeat.o(125227);
    return i;
  }
  
  public static final int il(Context paramContext)
  {
    AppMethodBeat.i(125228);
    if (!ETU)
    {
      if (ETS > 0)
      {
        i = ETS;
        AppMethodBeat.o(125228);
        return i;
      }
      i = ik(paramContext);
      AppMethodBeat.o(125228);
      return i;
    }
    int i = ax(paramContext, 0);
    AppMethodBeat.o(125228);
    return i;
  }
  
  public static final int im(Context paramContext)
  {
    AppMethodBeat.i(125229);
    if (!ETU)
    {
      if (ETV > 0)
      {
        i = ETV;
        AppMethodBeat.o(125229);
        return i;
      }
      if (!io(paramContext))
      {
        AppMethodBeat.o(125229);
        return 1140;
      }
      i = a.fromDPToPix(paramContext, 380);
      ETV = i;
      AppMethodBeat.o(125229);
      return i;
    }
    int i = ax(paramContext, 0);
    AppMethodBeat.o(125229);
    return i;
  }
  
  public static final int in(Context paramContext)
  {
    AppMethodBeat.i(125233);
    int i = h(paramContext, -1, 0);
    AppMethodBeat.o(125233);
    return i;
  }
  
  private static final boolean io(Context paramContext)
  {
    AppMethodBeat.i(125234);
    Context localContext = paramContext;
    if (paramContext == null) {
      localContext = aj.getContext();
    }
    if (localContext != null)
    {
      AppMethodBeat.o(125234);
      return true;
    }
    AppMethodBeat.o(125234);
    return false;
  }
  
  public static boolean ip(Context paramContext)
  {
    AppMethodBeat.i(125235);
    if (iq(paramContext) == 1)
    {
      AppMethodBeat.o(125235);
      return true;
    }
    AppMethodBeat.o(125235);
    return false;
  }
  
  public static int iq(Context paramContext)
  {
    int i = 1;
    AppMethodBeat.i(125236);
    paramContext = et(paramContext);
    if (paramContext[0] < paramContext[1]) {}
    for (;;)
    {
      AppMethodBeat.o(125236);
      return i;
      i = 2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.z
 * JD-Core Version:    0.7.0.1
 */