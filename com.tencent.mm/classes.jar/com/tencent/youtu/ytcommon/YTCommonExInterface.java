package com.tencent.youtu.ytcommon;

import android.app.Activity;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.youtu.ytcommon.tools.YTLogger;
import com.tencent.youtu.ytcommon.tools.YTLogger.IFaceLiveLogger;
import java.lang.reflect.Method;

public class YTCommonExInterface
{
  private static final String TAG = "YTUtilityInterface";
  public static final String VERSION = "3.2.2";
  protected static Method commonSoInitAuth = null;
  private static int mBusinessCode = 0;
  
  public static int getBusinessCode()
  {
    return mBusinessCode;
  }
  
  public static float setAppBrightness(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(73337);
    YTLogger.i("YTUtilityInterface", "[YTUtilityInterface.setAppBrightness] brightness: ".concat(String.valueOf(paramInt)));
    paramActivity = paramActivity.getWindow();
    WindowManager.LayoutParams localLayoutParams = paramActivity.getAttributes();
    float f = localLayoutParams.screenBrightness;
    if (paramInt == -1) {}
    int i;
    for (localLayoutParams.screenBrightness = -1.0F;; localLayoutParams.screenBrightness = (i / 255.0F))
    {
      paramActivity.setAttributes(localLayoutParams);
      AppMethodBeat.o(73337);
      return f;
      i = paramInt;
      if (paramInt <= 0) {
        i = 1;
      }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.youtu.ytcommon.YTCommonExInterface
 * JD-Core Version:    0.7.0.1
 */