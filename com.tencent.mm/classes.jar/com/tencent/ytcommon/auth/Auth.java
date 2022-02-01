package com.tencent.ytcommon.auth;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;

public class Auth
{
  private static String aalB = "";
  
  public static int aj(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(251301);
    boolean bool2 = true;
    boolean bool1;
    if (Build.VERSION.SDK_INT >= 29) {
      bool1 = false;
    }
    try
    {
      InputStream localInputStream;
      for (;;)
      {
        localInputStream = paramContext.getAssets().open(paramString1, 0);
        if (localInputStream != null) {
          break;
        }
        AppMethodBeat.o(251301);
        return -10;
        bool1 = bool2;
        if (Build.VERSION.SDK_INT >= 23)
        {
          bool1 = bool2;
          if (paramContext.checkSelfPermission("android.permission.READ_PHONE_STATE") != 0) {
            bool1 = false;
          }
        }
      }
      localInputStream.close();
      int i = nativeInitN(paramContext, 0, paramString1, paramContext.getAssets(), paramString1, bool1, paramString2);
      AppMethodBeat.o(251301);
      return i;
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(251301);
    }
    return -10;
  }
  
  public static native String getFailedReason(int paramInt);
  
  public static int getVersion()
  {
    AppMethodBeat.i(2628);
    int i = nativeGetVersion();
    AppMethodBeat.o(2628);
    return i;
  }
  
  private static native boolean nativeCheck();
  
  private static native long nativeGetEndTime();
  
  private static native int nativeGetLicense(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt, boolean paramBoolean, String paramString4);
  
  private static native int nativeGetVersion();
  
  private static native int nativeInitN(Context paramContext, int paramInt, String paramString1, AssetManager paramAssetManager, String paramString2, boolean paramBoolean, String paramString3);
  
  private static native int nativeSetSerial(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.ytcommon.auth.Auth
 * JD-Core Version:    0.7.0.1
 */