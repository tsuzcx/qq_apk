package com.tencent.soter.core.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build.VERSION;
import com.tencent.soter.core.c.d;
import com.tencent.soter.core.c.g;

@SuppressLint({"NewApi"})
final class b
{
  static int checkSelfPermission(Context paramContext, String paramString)
  {
    if (paramContext == null)
    {
      d.e("Soter.FingerprintManagerCompatApi23", "soter: check self permission: context is null", new Object[0]);
      return -1;
    }
    if (g.bl(paramString))
    {
      d.e("Soter.FingerprintManagerCompatApi23", "soter: requested permission is null or nil", new Object[0]);
      return -1;
    }
    if (Build.VERSION.SDK_INT < 23)
    {
      d.d("Soter.FingerprintManagerCompatApi23", "soter: below 23. directly return.", new Object[0]);
      return 0;
    }
    return paramContext.checkSelfPermission(paramString);
  }
  
  static FingerprintManager getFingerprintManager(Context paramContext)
  {
    return (FingerprintManager)paramContext.getSystemService("fingerprint");
  }
  
  public static boolean hasEnrolledFingerprints(Context paramContext)
  {
    if (checkSelfPermission(paramContext, "android.permission.USE_FINGERPRINT") != 0)
    {
      d.e("Soter.FingerprintManagerCompatApi23", "soter: permission check failed: hasEnrolledFingerprints", new Object[0]);
      return false;
    }
    try
    {
      paramContext = getFingerprintManager(paramContext);
      if (paramContext != null) {
        return paramContext.hasEnrolledFingerprints();
      }
      d.e("Soter.FingerprintManagerCompatApi23", "soter: fingerprint manager is null in hasEnrolledFingerprints! Should never happen", new Object[0]);
      return false;
    }
    catch (SecurityException paramContext)
    {
      d.e("Soter.FingerprintManagerCompatApi23", "soter: triggered SecurityException in hasEnrolledFingerprints! Make sure you declared USE_FINGERPRINT in AndroidManifest.xml", new Object[0]);
    }
    return false;
  }
  
  public static boolean isHardwareDetected(Context paramContext)
  {
    if (checkSelfPermission(paramContext, "android.permission.USE_FINGERPRINT") != 0)
    {
      d.e("Soter.FingerprintManagerCompatApi23", "soter: permission check failed: isHardwareDetected", new Object[0]);
      return false;
    }
    try
    {
      paramContext = getFingerprintManager(paramContext);
      if (paramContext != null) {
        return paramContext.isHardwareDetected();
      }
      d.e("Soter.FingerprintManagerCompatApi23", "soter: fingerprint manager is null in isHardwareDetected! Should never happen", new Object[0]);
      return false;
    }
    catch (SecurityException paramContext)
    {
      d.e("Soter.FingerprintManagerCompatApi23", "soter: triggered SecurityException in isHardwareDetected! Make sure you declared USE_FINGERPRINT in AndroidManifest.xml", new Object[0]);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.soter.core.a.b
 * JD-Core Version:    0.7.0.1
 */