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
import com.tencent.mm.cc.a;
import com.tencent.mm.compatible.util.d;

public class y
{
  private static int Gre = -1;
  public static int Grf = -1;
  private static boolean Grg = false;
  private static int Grh = -1;
  private static int Gri = -1;
  
  public static final boolean aC(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(164122);
    if (Gre == paramInt)
    {
      AppMethodBeat.o(164122);
      return true;
    }
    if (!iz(paramContext))
    {
      AppMethodBeat.o(164122);
      return false;
    }
    if (paramInt < 0)
    {
      AppMethodBeat.o(164122);
      return false;
    }
    Gre = paramInt;
    ac.d("MicroMsg.KeyBordUtil", "save keybord: %d", new Object[] { Integer.valueOf(paramInt) });
    boolean bool = ai.eUY().edit().putInt("com.tencent.mm.compatible.util.keybord.height", paramInt).commit();
    AppMethodBeat.o(164122);
    return bool;
  }
  
  public static final int aD(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(125230);
    if (paramInt > 0)
    {
      paramInt += 230;
      if (!iz(paramContext))
      {
        AppMethodBeat.o(125230);
        return paramInt * 3;
      }
      paramInt = a.fromDPToPix(paramContext, paramInt);
      Gri = paramInt;
      AppMethodBeat.o(125230);
      return paramInt;
    }
    if (Gri > 0)
    {
      paramInt = Gri;
      AppMethodBeat.o(125230);
      return paramInt;
    }
    if (!iz(paramContext))
    {
      AppMethodBeat.o(125230);
      return 690;
    }
    paramInt = a.fromDPToPix(paramContext, 230);
    Gri = paramInt;
    AppMethodBeat.o(125230);
    return paramInt;
  }
  
  public static final int aE(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(125231);
    paramInt = j(paramContext, paramInt, 0);
    AppMethodBeat.o(125231);
    return paramInt;
  }
  
  public static int aU(Activity paramActivity)
  {
    AppMethodBeat.i(125238);
    Rect localRect = new Rect();
    paramActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame(localRect);
    int i = localRect.top;
    AppMethodBeat.o(125238);
    return i;
  }
  
  public static int[] eB(Context paramContext)
  {
    AppMethodBeat.i(125237);
    if (paramContext == null) {
      paramContext = ai.getContext();
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
  
  public static void eUC()
  {
    Grg = false;
  }
  
  public static boolean iA(Context paramContext)
  {
    AppMethodBeat.i(125235);
    if (iB(paramContext) == 1)
    {
      AppMethodBeat.o(125235);
      return true;
    }
    AppMethodBeat.o(125235);
    return false;
  }
  
  public static int iB(Context paramContext)
  {
    int i = 1;
    AppMethodBeat.i(125236);
    paramContext = eB(paramContext);
    if (paramContext[0] < paramContext[1]) {}
    for (;;)
    {
      AppMethodBeat.o(125236);
      return i;
      i = 2;
    }
  }
  
  public static final int iv(Context paramContext)
  {
    AppMethodBeat.i(125227);
    if (!Grg)
    {
      if (!iz(paramContext))
      {
        i = ai.eUY().getInt("com.tencent.mm.compatible.util.keybord.height", 690);
        AppMethodBeat.o(125227);
        return i;
      }
      i = ai.eUY().getInt("com.tencent.mm.compatible.util.keybord.height", a.fromDPToPix(paramContext, 230));
      Gre = i;
      AppMethodBeat.o(125227);
      return i;
    }
    int i = aD(paramContext, 0);
    AppMethodBeat.o(125227);
    return i;
  }
  
  public static final int iw(Context paramContext)
  {
    AppMethodBeat.i(125228);
    if (!Grg)
    {
      if (Gre > 0)
      {
        i = Gre;
        AppMethodBeat.o(125228);
        return i;
      }
      i = iv(paramContext);
      AppMethodBeat.o(125228);
      return i;
    }
    int i = aD(paramContext, 0);
    AppMethodBeat.o(125228);
    return i;
  }
  
  public static final int ix(Context paramContext)
  {
    AppMethodBeat.i(125229);
    if (!Grg)
    {
      if (Grh > 0)
      {
        i = Grh;
        AppMethodBeat.o(125229);
        return i;
      }
      if (!iz(paramContext))
      {
        AppMethodBeat.o(125229);
        return 1140;
      }
      i = a.fromDPToPix(paramContext, 380);
      Grh = i;
      AppMethodBeat.o(125229);
      return i;
    }
    int i = aD(paramContext, 0);
    AppMethodBeat.o(125229);
    return i;
  }
  
  public static final int iy(Context paramContext)
  {
    AppMethodBeat.i(125233);
    int i = j(paramContext, -1, 0);
    AppMethodBeat.o(125233);
    return i;
  }
  
  private static final boolean iz(Context paramContext)
  {
    AppMethodBeat.i(125234);
    Context localContext = paramContext;
    if (paramContext == null) {
      localContext = ai.getContext();
    }
    if (localContext != null)
    {
      AppMethodBeat.o(125234);
      return true;
    }
    AppMethodBeat.o(125234);
    return false;
  }
  
  public static final int j(Context paramContext, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(125232);
    int i = aD(paramContext, paramInt2);
    ac.e("MicroMsg.KeyBordUtil", "getValidPanelHeight(): minPanelHeight= %d, isOpenIm=%b", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt2) });
    if ((d.kZ(24)) && ((paramContext instanceof Activity))) {}
    for (boolean bool = ((Activity)paramContext).isInMultiWindowMode();; bool = false)
    {
      if ((!iA(paramContext)) || (bool))
      {
        paramInt2 = (int)(i / 1.5D);
        i = eB(paramContext)[0];
        paramInt1 = paramInt2;
        if (paramInt2 > i / 2) {
          paramInt1 = i / 2;
        }
        AppMethodBeat.o(125232);
        return paramInt1;
      }
      paramInt2 = paramInt1;
      if (paramInt1 <= 0) {
        paramInt2 = iw(paramContext);
      }
      paramInt1 = ix(paramContext);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.y
 * JD-Core Version:    0.7.0.1
 */