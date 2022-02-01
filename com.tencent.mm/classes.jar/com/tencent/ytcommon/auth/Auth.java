package com.tencent.ytcommon.auth;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.InputStream;

public class Auth
{
  private static final String LIC_FILE_NAME = ".youtu_common.lic";
  private static final String TAG = "youtu-common";
  private static long handle = 0L;
  private static String licensePath = "";
  
  public static boolean check()
  {
    AppMethodBeat.i(2629);
    boolean bool = nativeCheck(handle);
    AppMethodBeat.o(2629);
    return bool;
  }
  
  private static native int getCurrentAuthStatus(long paramLong);
  
  public static long getEndTime()
  {
    AppMethodBeat.i(2630);
    long l = nativeGetEndTime(handle);
    AppMethodBeat.o(2630);
    return l;
  }
  
  public static native String getFailedReason(int paramInt);
  
  public static long getHandle()
  {
    return handle;
  }
  
  public static String getLicensePath()
  {
    return licensePath;
  }
  
  public static int getVersion()
  {
    AppMethodBeat.i(2628);
    int i = nativeGetVersion();
    AppMethodBeat.o(2628);
    return i;
  }
  
  public static int init(Context paramContext, String paramString, int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(2626);
    YTLog.d("youtu-common", "start init");
    if ((Build.VERSION.SDK_INT >= 23) && (paramContext.checkSelfPermission("android.permission.READ_PHONE_STATE") != 0)) {}
    for (;;)
    {
      try
      {
        InputStream localInputStream = paramContext.getAssets().open(paramString, 0);
        if (localInputStream == null)
        {
          AppMethodBeat.o(2626);
          return -10;
        }
        localInputStream.close();
        handle = nativeInitN(paramContext, paramInt, paramString, paramContext.getAssets(), paramString, bool);
        YTLog.d("youtu-common", "handleinit: " + handle);
        paramInt = getCurrentAuthStatus(handle);
        AppMethodBeat.o(2626);
        return paramInt;
      }
      catch (Exception paramContext)
      {
        AppMethodBeat.o(2626);
        return -10;
      }
      bool = true;
    }
  }
  
  public static int init(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(2627);
    if (licensePath.isEmpty())
    {
      licensePath = paramContext.getFilesDir().getPath() + File.separator + ".youtu_common.lic";
      if ((Build.VERSION.SDK_INT < 23) || (paramContext.checkSelfPermission("android.permission.READ_PHONE_STATE") == 0)) {
        break label233;
      }
    }
    label233:
    for (boolean bool = false;; bool = true)
    {
      paramInt = (int)nativeGetLicense(paramContext, paramString1, paramString2, getLicensePath(), paramInt, bool);
      if (paramInt == 0)
      {
        long l = nativeInitN(paramContext, 2, getLicensePath(), paramContext.getAssets(), getLicensePath(), bool);
        handle = l;
        if (getCurrentAuthStatus(l) != 0)
        {
          paramInt = (int)nativeGetLicense(paramContext, paramString1, paramString2, getLicensePath(), 1, bool);
          if (paramInt == 0)
          {
            l = nativeInitN(paramContext, 2, getLicensePath(), paramContext.getAssets(), getLicensePath(), bool);
            handle = l;
            paramInt = getCurrentAuthStatus(l);
            AppMethodBeat.o(2627);
            return paramInt;
            if ((Build.VERSION.SDK_INT < 23) || (paramContext.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0)) {
              break;
            }
            AppMethodBeat.o(2627);
            return 2004;
          }
          AppMethodBeat.o(2627);
          return paramInt;
        }
        paramInt = getCurrentAuthStatus(handle);
        AppMethodBeat.o(2627);
        return paramInt;
      }
      AppMethodBeat.o(2627);
      return paramInt;
    }
  }
  
  private static native boolean nativeCheck(long paramLong);
  
  private static native long nativeGetEndTime(long paramLong);
  
  private static native long nativeGetLicense(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt, boolean paramBoolean);
  
  private static native int nativeGetVersion();
  
  private static native long nativeInitN(Context paramContext, int paramInt, String paramString1, AssetManager paramAssetManager, String paramString2, boolean paramBoolean);
  
  public static void setLicensePath(String paramString)
  {
    licensePath = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.ytcommon.auth.Auth
 * JD-Core Version:    0.7.0.1
 */