package com.tencent.youtu.ytcommon;

import android.app.Activity;
import android.os.Build.VERSION;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.youtu.ytcommon.tools.YTLogger;
import com.tencent.youtu.ytcommon.tools.YTLogger.IFaceLiveLogger;
import java.lang.reflect.Method;

public class YTCommonExInterface
{
  private static final String TAG = "YTUtilityInterface";
  public static final String VERSION = "3.2.3";
  protected static Method commonSoInitAuth = null;
  private static int mBusinessCode = 0;
  
  public static int getBusinessCode()
  {
    return mBusinessCode;
  }
  
  public static float setAppBrightness(Activity paramActivity, int paramInt)
  {
    float f2 = -1.0F;
    AppMethodBeat.i(73337);
    YTLogger.i("YTUtilityInterface", "[YTUtilityInterface.setAppBrightness] brightness: ".concat(String.valueOf(paramInt)));
    float f1 = f2;
    for (;;)
    {
      try
      {
        if (Build.VERSION.SDK_INT >= 17)
        {
          f1 = f2;
          if (paramActivity.isDestroyed()) {}
        }
        else
        {
          f1 = f2;
          boolean bool = paramActivity.isFinishing();
          if (!bool) {
            continue;
          }
        }
        AppMethodBeat.o(73337);
        return -1.0F;
        f1 = f2;
        paramActivity = paramActivity.getWindow();
        f1 = f2;
        localLayoutParams = paramActivity.getAttributes();
        if (paramInt != -1) {
          continue;
        }
        f1 = f2;
        localLayoutParams.screenBrightness = -1.0F;
        f1 = f2;
        f2 = localLayoutParams.screenBrightness;
        f1 = f2;
        paramActivity.setAttributes(localLayoutParams);
        f1 = f2;
      }
      catch (Exception paramActivity)
      {
        WindowManager.LayoutParams localLayoutParams;
        int i;
        float f3;
        YTLogger.e("YTUtilityInterface", "set appbrightness failed :" + paramActivity.getLocalizedMessage());
        continue;
      }
      AppMethodBeat.o(73337);
      return f1;
      i = paramInt;
      if (paramInt <= 0) {
        i = 1;
      }
      f3 = i / 255.0F;
      f1 = f2;
      localLayoutParams.screenBrightness = f3;
    }
  }
  
  public static void setBusinessCode(int paramInt)
  {
    mBusinessCode = paramInt;
  }
  
  public static void setIsEnabledLog(boolean paramBoolean)
  {
    AppMethodBeat.i(73339);
    YTLogger.setIsEnabledLog(paramBoolean);
    AppMethodBeat.o(73339);
  }
  
  public static void setIsEnabledNativeLog(boolean paramBoolean)
  {
    AppMethodBeat.i(73340);
    YTLogger.setIsEnabledNativeLog(paramBoolean);
    AppMethodBeat.o(73340);
  }
  
  public static void setLogger(YTLogger.IFaceLiveLogger paramIFaceLiveLogger)
  {
    AppMethodBeat.i(73338);
    YTLogger.setLog(paramIFaceLiveLogger);
    AppMethodBeat.o(73338);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.youtu.ytcommon.YTCommonExInterface
 * JD-Core Version:    0.7.0.1
 */