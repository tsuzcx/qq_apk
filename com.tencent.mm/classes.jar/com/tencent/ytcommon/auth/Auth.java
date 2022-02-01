package com.tencent.ytcommon.auth;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.InputStream;

public class Auth
{
  private static final boolean FORQQ = false;
  private static final String LIC_FILE_NAME = ".youtu_common.lic";
  private static final boolean MACADDR = false;
  private static final String TAG = "youtu-common";
  private static String licensePath = "";
  
  public static long getEndTime()
  {
    AppMethodBeat.i(2630);
    long l = nativeGetEndTime();
    AppMethodBeat.o(2630);
    return l;
  }
  
  public static native String getFailedReason(int paramInt);
  
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
  
  public static int init(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    boolean bool1 = false;
    AppMethodBeat.i(2627);
    if ((Build.VERSION.SDK_INT < 29) || (paramInt == 0)) {}
    do
    {
      do
      {
        try
        {
          InputStream localInputStream = paramContext.getAssets().open(paramString1, 0);
          if (localInputStream == null)
          {
            AppMethodBeat.o(2627);
            return -10;
            if ((Build.VERSION.SDK_INT >= 23) && (paramContext.checkSelfPermission("android.permission.READ_PHONE_STATE") != 0)) {
              break;
            }
            bool1 = true;
            break;
          }
          localInputStream.close();
          paramInt = nativeInitN(paramContext, paramInt, paramString1, paramContext.getAssets(), paramString1, bool1, paramString2);
          AppMethodBeat.o(2627);
          return paramInt;
        }
        catch (Exception paramContext)
        {
          boolean bool2;
          AppMethodBeat.o(2627);
        }
      } while (paramInt != 2);
      bool2 = new File(paramString1).exists();
    } while (bool2);
    AppMethodBeat.o(2627);
    return -10;
    return -10;
  }
  
  public static int init(Context paramContext, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    boolean bool = false;
    AppMethodBeat.i(186316);
    if (licensePath.isEmpty())
    {
      licensePath = paramContext.getFilesDir().getPath() + File.separator + ".youtu_common.lic";
      if (Build.VERSION.SDK_INT < 29) {
        break label192;
      }
    }
    for (;;)
    {
      paramInt = nativeGetLicense(paramContext, paramString1, paramString2, getLicensePath(), paramInt, bool, paramString3);
      if (paramInt != 0) {
        break label222;
      }
      int i = nativeInitN(paramContext, 2, getLicensePath(), paramContext.getAssets(), getLicensePath(), bool, paramString3);
      paramInt = i;
      if (i == 0) {
        break label215;
      }
      i = nativeGetLicense(paramContext, paramString1, paramString2, getLicensePath(), 1, bool, paramString3);
      paramInt = i;
      if (i != 0) {
        break label215;
      }
      paramInt = nativeInitN(paramContext, 2, getLicensePath(), paramContext.getAssets(), getLicensePath(), bool, paramString3);
      AppMethodBeat.o(186316);
      return paramInt;
      if ((Build.VERSION.SDK_INT < 23) || (Build.VERSION.SDK_INT >= 29) || (paramContext.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0)) {
        break;
      }
      AppMethodBeat.o(186316);
      return 2004;
      label192:
      if ((Build.VERSION.SDK_INT < 23) || (paramContext.checkSelfPermission("android.permission.READ_PHONE_STATE") == 0)) {
        bool = true;
      }
    }
    label215:
    AppMethodBeat.o(186316);
    return paramInt;
    label222:
    AppMethodBeat.o(186316);
    return paramInt;
  }
  
  public static int initAuthForQQ(Context paramContext)
  {
    return 5002;
  }
  
  private static native boolean nativeCheck();
  
  private static native long nativeGetEndTime();
  
  private static native int nativeGetLicense(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt, boolean paramBoolean, String paramString4);
  
  private static native int nativeGetVersion();
  
  private static native int nativeInitN(Context paramContext, int paramInt, String paramString1, AssetManager paramAssetManager, String paramString2, boolean paramBoolean, String paramString3);
  
  private static native int nativeSetSerial(String paramString);
  
  public static void setLicensePath(String paramString)
  {
    licensePath = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.ytcommon.auth.Auth
 * JD-Core Version:    0.7.0.1
 */