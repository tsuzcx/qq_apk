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
import com.tencent.mm.cb.a;
import com.tencent.mm.compatible.util.d;

public class KeyBoardUtil
{
  public static final int BOTTOM_PANEL_TIP_DP = 43;
  public static int CONTENT_HEIGHT = 0;
  public static final String KEYBORD_HEIGHT_PX_PREFS = "com.tencent.mm.compatible.util.keybord.height";
  private static int LAST_SAVE_KEYBORD_HEIGHT_PX = -1;
  private static int MAX_PANEL_HEIGHT_PX = -1;
  private static final int MAX_PANEL_HEIGH_DP = 380;
  private static int MIN_PANEL_HEIGHT_PX = -1;
  private static final int MIN_PANEL_HEIGH_DP = 230;
  private static final String TAG = "MicroMsg.KeyBordUtil";
  private static boolean isFixedHeight;
  
  static
  {
    CONTENT_HEIGHT = -1;
    isFixedHeight = false;
  }
  
  private static final boolean checkContextIsValid(Context paramContext)
  {
    AppMethodBeat.i(125234);
    Context localContext = paramContext;
    if (paramContext == null) {
      localContext = MMApplicationContext.getContext();
    }
    if (localContext != null)
    {
      AppMethodBeat.o(125234);
      return true;
    }
    AppMethodBeat.o(125234);
    return false;
  }
  
  private static final int dp2px(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(200889);
    paramInt = a.fromDPToPix(paramContext, paramInt);
    AppMethodBeat.o(200889);
    return paramInt;
  }
  
  public static final int getKeyBordHeightPx(Context paramContext)
  {
    AppMethodBeat.i(125227);
    if (!isFixedHeight)
    {
      if (!checkContextIsValid(paramContext))
      {
        i = MMApplicationContext.getDefaultPreference().getInt("com.tencent.mm.compatible.util.keybord.height", 690);
        AppMethodBeat.o(125227);
        return i;
      }
      i = MMApplicationContext.getDefaultPreference().getInt("com.tencent.mm.compatible.util.keybord.height", dp2px(paramContext, 230));
      LAST_SAVE_KEYBORD_HEIGHT_PX = i;
      AppMethodBeat.o(125227);
      return i;
    }
    int i = getMinPanelHeightPx(paramContext);
    AppMethodBeat.o(125227);
    return i;
  }
  
  public static final int getKeyBordHeightPx(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(200886);
    if (!isFixedHeight)
    {
      if ((LAST_SAVE_KEYBORD_HEIGHT_PX > 0) && (paramBoolean))
      {
        i = LAST_SAVE_KEYBORD_HEIGHT_PX;
        AppMethodBeat.o(200886);
        return i;
      }
      i = getKeyBordHeightPx(paramContext);
      AppMethodBeat.o(200886);
      return i;
    }
    int i = getMinPanelHeightPx(paramContext);
    AppMethodBeat.o(200886);
    return i;
  }
  
  public static final int getMaxPanelHeightPx(Context paramContext)
  {
    AppMethodBeat.i(125229);
    if (!isFixedHeight)
    {
      if (MAX_PANEL_HEIGHT_PX > 0)
      {
        i = MAX_PANEL_HEIGHT_PX;
        AppMethodBeat.o(125229);
        return i;
      }
      if (!checkContextIsValid(paramContext))
      {
        AppMethodBeat.o(125229);
        return 1140;
      }
      i = dp2px(paramContext, 380);
      MAX_PANEL_HEIGHT_PX = i;
      AppMethodBeat.o(125229);
      return i;
    }
    int i = getMinPanelHeightPx(paramContext);
    AppMethodBeat.o(125229);
    return i;
  }
  
  public static final int getMinPanelHeightPx(Context paramContext)
  {
    AppMethodBeat.i(200888);
    int i = getMinPanelHeightPx(paramContext, 0);
    AppMethodBeat.o(200888);
    return i;
  }
  
  public static final int getMinPanelHeightPx(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(125230);
    if (paramInt > 0)
    {
      paramInt += 230;
      if (!checkContextIsValid(paramContext))
      {
        AppMethodBeat.o(125230);
        return paramInt * 3;
      }
      paramInt = dp2px(paramContext, paramInt);
      MIN_PANEL_HEIGHT_PX = paramInt;
      AppMethodBeat.o(125230);
      return paramInt;
    }
    if (MIN_PANEL_HEIGHT_PX > 0)
    {
      paramInt = MIN_PANEL_HEIGHT_PX;
      AppMethodBeat.o(125230);
      return paramInt;
    }
    if (!checkContextIsValid(paramContext))
    {
      AppMethodBeat.o(125230);
      return 690;
    }
    paramInt = dp2px(paramContext, 230);
    MIN_PANEL_HEIGHT_PX = paramInt;
    AppMethodBeat.o(125230);
    return paramInt;
  }
  
  public static int getScreenOrientation(Context paramContext)
  {
    int i = 1;
    AppMethodBeat.i(125236);
    paramContext = getScreenWH(paramContext);
    if (paramContext[0] < paramContext[1]) {}
    for (;;)
    {
      AppMethodBeat.o(125236);
      return i;
      i = 2;
    }
  }
  
  public static int[] getScreenWH(Context paramContext)
  {
    AppMethodBeat.i(125237);
    if (paramContext == null) {
      paramContext = MMApplicationContext.getContext();
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
  
  public static int getStatusHeight(Activity paramActivity)
  {
    AppMethodBeat.i(125238);
    Rect localRect = new Rect();
    paramActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame(localRect);
    int i = localRect.top;
    AppMethodBeat.o(125238);
    return i;
  }
  
  public static final int getValidPanelHeight(Context paramContext)
  {
    AppMethodBeat.i(125233);
    int i = getValidPanelHeight(paramContext, -1);
    AppMethodBeat.o(125233);
    return i;
  }
  
  public static final int getValidPanelHeight(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(125231);
    paramInt = getValidPanelHeight(paramContext, paramInt, 0);
    AppMethodBeat.o(125231);
    return paramInt;
  }
  
  public static final int getValidPanelHeight(Context paramContext, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(125232);
    int i = getMinPanelHeightPx(paramContext, paramInt2);
    Log.e("MicroMsg.KeyBordUtil", "getValidPanelHeight(): minPanelHeight= %d, isOpenIm=%b", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt2) });
    if ((d.oD(24)) && ((paramContext instanceof Activity))) {}
    for (boolean bool = ((Activity)paramContext).isInMultiWindowMode();; bool = false)
    {
      if ((!isPortOrientation(paramContext)) || (bool))
      {
        paramInt2 = (int)(i / 1.5D);
        i = getScreenWH(paramContext)[0];
        paramInt1 = paramInt2;
        if (paramInt2 > i / 2) {
          paramInt1 = i / 2;
        }
        AppMethodBeat.o(125232);
        return paramInt1;
      }
      paramInt2 = paramInt1;
      if (paramInt1 <= 0) {
        paramInt2 = getKeyBordHeightPx(paramContext, true);
      }
      paramInt1 = getMaxPanelHeightPx(paramContext);
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
  
  public static int getVisibleHeight(Activity paramActivity)
  {
    AppMethodBeat.i(200887);
    Rect localRect = new Rect();
    paramActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame(localRect);
    int i = localRect.bottom;
    int j = localRect.top;
    AppMethodBeat.o(200887);
    return i - j;
  }
  
  public static boolean isPortOrientation(Context paramContext)
  {
    AppMethodBeat.i(125235);
    if (getScreenOrientation(paramContext) == 1)
    {
      AppMethodBeat.o(125235);
      return true;
    }
    AppMethodBeat.o(125235);
    return false;
  }
  
  public static final boolean isValidPanelHeightDP(int paramInt)
  {
    return (paramInt <= 380) && (paramInt >= 230);
  }
  
  public static final boolean saveKeyBordHeightPx(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(164122);
    if (LAST_SAVE_KEYBORD_HEIGHT_PX == paramInt)
    {
      AppMethodBeat.o(164122);
      return true;
    }
    if (!checkContextIsValid(paramContext))
    {
      AppMethodBeat.o(164122);
      return false;
    }
    if (paramInt < 0)
    {
      AppMethodBeat.o(164122);
      return false;
    }
    LAST_SAVE_KEYBORD_HEIGHT_PX = paramInt;
    Log.d("MicroMsg.KeyBordUtil", "save keybord: %d", new Object[] { Integer.valueOf(paramInt) });
    boolean bool = MMApplicationContext.getDefaultPreference().edit().putInt("com.tencent.mm.compatible.util.keybord.height", paramInt).commit();
    AppMethodBeat.o(164122);
    return bool;
  }
  
  public static void setFixedHeight(boolean paramBoolean)
  {
    isFixedHeight = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.KeyBoardUtil
 * JD-Core Version:    0.7.0.1
 */