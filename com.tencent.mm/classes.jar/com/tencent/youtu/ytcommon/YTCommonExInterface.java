package com.tencent.youtu.ytcommon;

import android.app.Activity;
import android.content.Context;
import android.hardware.Camera;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.youtu.ytcommon.auth.YTAuthJNIInterface;
import com.tencent.youtu.ytcommon.tools.CameraSetting;
import com.tencent.youtu.ytcommon.tools.YTLogger;
import com.tencent.youtu.ytcommon.tools.YTLogger.IFaceLiveLogger;

public class YTCommonExInterface
{
  private static final String TAG = "YTUtilityInterface";
  public static final String VERSION = "3.0.1";
  private static int mBusinessCode = 0;
  public static boolean mIsAuthSuccess = false;
  
  public static int getBusinessCode()
  {
    return mBusinessCode;
  }
  
  public static int initAuth(Context paramContext, String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(118048);
    YTLogger.i("YTUtilityInterface", "[YTUtilityInterface.initAuth] ---licence: " + paramString + " initType: " + paramInt + " isDebug: " + paramBoolean);
    if (mIsAuthSuccess)
    {
      AppMethodBeat.o(118048);
      return 0;
    }
    paramInt = YTAuthJNIInterface.init(paramContext, paramString, paramInt, paramBoolean);
    if (paramInt == 0)
    {
      YTLogger.i("YTUtilityInterface", "initAuth success.");
      mIsAuthSuccess = true;
    }
    for (;;)
    {
      AppMethodBeat.o(118048);
      return paramInt;
      YTLogger.w("YTUtilityInterface", "initAuth failed. return value: ".concat(String.valueOf(paramInt)));
    }
  }
  
  public static int initCamera(Context paramContext, Camera paramCamera, int paramInt)
  {
    AppMethodBeat.i(118050);
    YTLogger.i("YTUtilityInterface", "[YTUtilityInterface.initCamera] ---cameraId: ".concat(String.valueOf(paramInt)));
    paramInt = CameraSetting.initCamera(paramContext, paramCamera, paramInt);
    AppMethodBeat.o(118050);
    return paramInt;
  }
  
  public static boolean isAuthSuccess()
  {
    return mIsAuthSuccess;
  }
  
  public static float setAppBrightness(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(118049);
    YTLogger.i("YTUtilityInterface", "[YTUtilityInterface.setAppBrightness] brightness: ".concat(String.valueOf(paramInt)));
    paramActivity = paramActivity.getWindow();
    WindowManager.LayoutParams localLayoutParams = paramActivity.getAttributes();
    float f = localLayoutParams.screenBrightness;
    if (paramInt == -1) {}
    int i;
    for (localLayoutParams.screenBrightness = -1.0F;; localLayoutParams.screenBrightness = (i / 255.0F))
    {
      paramActivity.setAttributes(localLayoutParams);
      AppMethodBeat.o(118049);
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
    AppMethodBeat.i(118052);
    YTLogger.setIsEnabledLog(paramBoolean);
    AppMethodBeat.o(118052);
  }
  
  public static void setIsEnabledNativeLog(boolean paramBoolean)
  {
    AppMethodBeat.i(118053);
    YTLogger.setIsEnabledNativeLog(paramBoolean);
    AppMethodBeat.o(118053);
  }
  
  public static void setLogger(YTLogger.IFaceLiveLogger paramIFaceLiveLogger)
  {
    AppMethodBeat.i(118051);
    YTLogger.setLog(paramIFaceLiveLogger);
    AppMethodBeat.o(118051);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.youtu.ytcommon.YTCommonExInterface
 * JD-Core Version:    0.7.0.1
 */