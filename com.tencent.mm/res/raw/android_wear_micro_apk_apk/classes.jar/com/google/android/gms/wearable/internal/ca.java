package com.google.android.gms.wearable.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.util.Log;
import com.google.android.gms.common.internal.d;
import com.google.android.gms.common.n;
import com.google.android.gms.internal.cg;
import com.google.android.gms.internal.ch;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class ca
{
  static final byte[] UA = o("");
  private static ca Uy;
  static final byte[] Uz = o("");
  private final Context mContext;
  
  private ca(Context paramContext)
  {
    this.mContext = paramContext.getApplicationContext();
  }
  
  private static boolean a(PackageInfo paramPackageInfo, byte[]... paramVarArgs)
  {
    if (paramPackageInfo.signatures == null) {}
    for (;;)
    {
      return false;
      if (paramPackageInfo.signatures.length != 1)
      {
        Log.w("WearSignatureVerifier", "Package has more than one signature.");
        return false;
      }
      paramPackageInfo = paramPackageInfo.signatures[0].toByteArray();
      int i = 0;
      while (i < paramVarArgs.length)
      {
        if (Arrays.equals(paramVarArgs[i], paramPackageInfo)) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  private static boolean b(PackageInfo paramPackageInfo, boolean paramBoolean)
  {
    if (paramPackageInfo.signatures.length != 1)
    {
      Log.w("WearSignatureVerifier", "Package has more than one signature.");
      return false;
    }
    paramPackageInfo.signatures[0].toByteArray();
    if (paramBoolean) {
      return a(paramPackageInfo, new byte[][] { Uz, UA });
    }
    return a(paramPackageInfo, new byte[][] { Uz });
  }
  
  private static byte[] o(String paramString)
  {
    try
    {
      paramString = paramString.getBytes("ISO-8859-1");
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new AssertionError(paramString);
    }
  }
  
  public static ca v(Context paramContext)
  {
    d.u(paramContext);
    try
    {
      if (Uy == null) {
        Uy = new ca(paramContext);
      }
      return Uy;
    }
    finally {}
  }
  
  private PackageInfo z(String paramString)
  {
    try
    {
      PackageInfo localPackageInfo = ch.u(this.mContext).getPackageInfo(paramString, 64);
      return localPackageInfo;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      paramString = String.valueOf(paramString);
      if (paramString.length() == 0) {}
    }
    for (paramString = "No package ".concat(paramString);; paramString = new String("No package "))
    {
      Log.w("WearSignatureVerifier", paramString);
      return null;
    }
  }
  
  public final boolean y(String paramString)
  {
    boolean bool1 = false;
    paramString = z(paramString);
    if (paramString == null) {}
    boolean bool2;
    do
    {
      do
      {
        return bool1;
        if (n.n(this.mContext)) {
          return b(paramString, true);
        }
        bool2 = b(paramString, false);
        bool1 = bool2;
      } while (bool2);
      bool1 = bool2;
    } while (!b(paramString, true));
    Log.w("WearSignatureVerifier", "Test-keys aren't accepted on this build.");
    return bool2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.ca
 * JD-Core Version:    0.7.0.1
 */