package com.tencent.soter.core.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.core.c.d;
import com.tencent.soter.core.c.g;

@Deprecated
@SuppressLint({"NewApi"})
final class b
{
  static int checkSelfPermission(Context paramContext, String paramString)
  {
    AppMethodBeat.i(72994);
    if (paramContext == null)
    {
      d.e("Soter.FingerprintManagerCompatApi23", "soter: check self permission: context is null", new Object[0]);
      AppMethodBeat.o(72994);
      return -1;
    }
    if (g.isNullOrNil(paramString))
    {
      d.e("Soter.FingerprintManagerCompatApi23", "soter: requested permission is null or nil", new Object[0]);
      AppMethodBeat.o(72994);
      return -1;
    }
    if (Build.VERSION.SDK_INT < 23)
    {
      d.d("Soter.FingerprintManagerCompatApi23", "soter: below 23. directly return.", new Object[0]);
      AppMethodBeat.o(72994);
      return 0;
    }
    int i = paramContext.checkSelfPermission(paramString);
    AppMethodBeat.o(72994);
    return i;
  }
  
  static FingerprintManager getFingerprintManager(Context paramContext)
  {
    AppMethodBeat.i(72992);
    paramContext = (FingerprintManager)paramContext.getSystemService("fingerprint");
    AppMethodBeat.o(72992);
    return paramContext;
  }
  
  public static boolean hasEnrolledFingerprints(Context paramContext)
  {
    AppMethodBeat.i(72993);
    if (checkSelfPermission(paramContext, "android.permission.USE_FINGERPRINT") != 0)
    {
      d.e("Soter.FingerprintManagerCompatApi23", "soter: permission check failed: hasEnrolledFingerprints", new Object[0]);
      AppMethodBeat.o(72993);
      return false;
    }
    try
    {
      paramContext = getFingerprintManager(paramContext);
      if (paramContext != null)
      {
        boolean bool = paramContext.hasEnrolledFingerprints();
        AppMethodBeat.o(72993);
        return bool;
      }
      d.e("Soter.FingerprintManagerCompatApi23", "soter: fingerprint manager is null in hasEnrolledFingerprints! Should never happen", new Object[0]);
      AppMethodBeat.o(72993);
      return false;
    }
    catch (SecurityException paramContext)
    {
      d.e("Soter.FingerprintManagerCompatApi23", "soter: triggered SecurityException in hasEnrolledFingerprints! Make sure you declared USE_FINGERPRINT in AndroidManifest.xml", new Object[0]);
      AppMethodBeat.o(72993);
    }
    return false;
  }
  
  public static boolean isHardwareDetected(Context paramContext)
  {
    AppMethodBeat.i(72995);
    if (checkSelfPermission(paramContext, "android.permission.USE_FINGERPRINT") != 0)
    {
      d.e("Soter.FingerprintManagerCompatApi23", "soter: permission check failed: isHardwareDetected", new Object[0]);
      AppMethodBeat.o(72995);
      return false;
    }
    try
    {
      paramContext = getFingerprintManager(paramContext);
      if (paramContext != null)
      {
        boolean bool = paramContext.isHardwareDetected();
        AppMethodBeat.o(72995);
        return bool;
      }
      d.e("Soter.FingerprintManagerCompatApi23", "soter: fingerprint manager is null in isHardwareDetected! Should never happen", new Object[0]);
      AppMethodBeat.o(72995);
      return false;
    }
    catch (SecurityException paramContext)
    {
      d.e("Soter.FingerprintManagerCompatApi23", "soter: triggered SecurityException in isHardwareDetected! Make sure you declared USE_FINGERPRINT in AndroidManifest.xml", new Object[0]);
      AppMethodBeat.o(72995);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.soter.core.a.b
 * JD-Core Version:    0.7.0.1
 */