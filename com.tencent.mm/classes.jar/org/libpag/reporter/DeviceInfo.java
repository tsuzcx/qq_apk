package org.libpag.reporter;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class DeviceInfo
{
  private static final String TAG = "MobileBase-DeviceInfo";
  
  public static int getApiLevelInt()
  {
    try
    {
      int i = Build.VERSION.SDK_INT;
      return i;
    }
    finally {}
    return -1;
  }
  
  public static String getBrand()
  {
    try
    {
      String str = Build.BRAND;
      return str;
    }
    finally {}
    return "fail";
  }
  
  public static String getDeviceName()
  {
    try
    {
      String str = Build.MODEL;
      return str;
    }
    finally {}
    return "fail";
  }
  
  public static String getRomFingerprint(Context paramContext)
  {
    AppMethodBeat.i(187411);
    String str = Build.FINGERPRINT;
    paramContext = str;
    if (TextUtils.isEmpty(str)) {
      paramContext = "Android";
    }
    AppMethodBeat.o(187411);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     org.libpag.reporter.DeviceInfo
 * JD-Core Version:    0.7.0.1
 */