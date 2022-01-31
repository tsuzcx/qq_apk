package com.tencent.ttpic.device;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.LogUtils;
import java.lang.reflect.Method;

public class NotchInScreenUtils
{
  public static final int NOTCH_IN_SCREEN_VIVO = 32;
  public static final int ROUNDED_IN_SCREEN_VIVO = 8;
  
  public static int getNotchHeightHw(Context paramContext)
  {
    AppMethodBeat.i(49931);
    int[] arrayOfInt = new int[2];
    int[] tmp10_9 = arrayOfInt;
    tmp10_9[0] = 0;
    int[] tmp14_10 = tmp10_9;
    tmp14_10[1] = 0;
    tmp14_10;
    paramContext = paramContext.getClassLoader();
    try
    {
      paramContext = paramContext.loadClass("com.huawei.android.util.HwNotchSizeUtil");
      paramContext = (int[])paramContext.getMethod("getNotchSize", new Class[0]).invoke(paramContext, new Object[0]);
      int i = paramContext[1];
      AppMethodBeat.o(49931);
      return i;
    }
    catch (ClassNotFoundException paramContext)
    {
      for (;;)
      {
        LogUtils.e(paramContext);
        paramContext = arrayOfInt;
      }
    }
    catch (NoSuchMethodException paramContext)
    {
      for (;;)
      {
        LogUtils.e(paramContext);
        paramContext = arrayOfInt;
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        LogUtils.e(paramContext);
        paramContext = arrayOfInt;
      }
    }
  }
  
  public static int getStatusBarHeight(Context paramContext)
  {
    AppMethodBeat.i(49932);
    int i = 0;
    int j = paramContext.getResources().getIdentifier("status_bar_height", "dimen", "android");
    if (j > 0) {
      i = paramContext.getResources().getDimensionPixelSize(j);
    }
    AppMethodBeat.o(49932);
    return i;
  }
  
  public static boolean hasNotchInScreen(Context paramContext)
  {
    AppMethodBeat.i(49929);
    if ((hasNotchInScreenHw(paramContext)) || (hasNotchInScreenAtOppo(paramContext)) || (hasNotchInScreenAtVivo(paramContext)) || (hasNotchInScreenAtXM()))
    {
      AppMethodBeat.o(49929);
      return true;
    }
    AppMethodBeat.o(49929);
    return false;
  }
  
  public static boolean hasNotchInScreenAtOppo(Context paramContext)
  {
    AppMethodBeat.i(49933);
    boolean bool = paramContext.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
    AppMethodBeat.o(49933);
    return bool;
  }
  
  public static boolean hasNotchInScreenAtVivo(Context paramContext)
  {
    AppMethodBeat.i(49934);
    try
    {
      paramContext = paramContext.getClassLoader().loadClass("com.util.FtFeature");
      boolean bool = ((Boolean)paramContext.getMethod("isFeatureSupport", new Class[] { Integer.TYPE }).invoke(paramContext, new Object[] { Integer.valueOf(32) })).booleanValue();
      return bool;
    }
    catch (ClassNotFoundException paramContext)
    {
      LogUtils.e(paramContext);
      return false;
    }
    catch (NoSuchMethodException paramContext)
    {
      LogUtils.e(paramContext);
      return false;
    }
    catch (Exception paramContext)
    {
      LogUtils.e(paramContext);
      return false;
    }
    finally
    {
      AppMethodBeat.o(49934);
    }
    return false;
  }
  
  public static boolean hasNotchInScreenAtXM()
  {
    AppMethodBeat.i(49935);
    String str = System.getProperty("ro.miui.notch");
    if (TextUtils.isEmpty(str))
    {
      AppMethodBeat.o(49935);
      return false;
    }
    try
    {
      i = Integer.parseInt(str);
      if (i == 1)
      {
        AppMethodBeat.o(49935);
        return true;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        LogUtils.e(localNumberFormatException);
        int i = 0;
      }
      AppMethodBeat.o(49935);
    }
    return false;
  }
  
  public static boolean hasNotchInScreenHw(Context paramContext)
  {
    AppMethodBeat.i(49930);
    paramContext = paramContext.getClassLoader();
    try
    {
      paramContext = paramContext.loadClass("com.huawei.android.util.HwNotchSizeUtil");
      bool = ((Boolean)paramContext.getMethod("hasNotchInScreen", new Class[0]).invoke(paramContext, new Object[0])).booleanValue();
      AppMethodBeat.o(49930);
      return bool;
    }
    catch (ClassNotFoundException paramContext)
    {
      for (;;)
      {
        LogUtils.e(paramContext);
        bool = false;
      }
    }
    catch (NoSuchMethodException paramContext)
    {
      for (;;)
      {
        LogUtils.e(paramContext);
        bool = false;
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        LogUtils.e(paramContext);
        boolean bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.ttpic.device.NotchInScreenUtils
 * JD-Core Version:    0.7.0.1
 */