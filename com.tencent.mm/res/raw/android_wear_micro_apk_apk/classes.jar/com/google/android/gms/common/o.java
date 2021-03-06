package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.util.Log;
import com.google.android.gms.common.internal.d;
import com.google.android.gms.internal.cg;
import com.google.android.gms.internal.ch;

public class o
{
  private static o No;
  private final cg Np;
  private final Context mContext;
  
  private o(Context paramContext)
  {
    this.mContext = paramContext.getApplicationContext();
    this.Np = ch.v(this.mContext);
  }
  
  static j a(PackageInfo paramPackageInfo, j... paramVarArgs)
  {
    int i = 0;
    if (paramPackageInfo.signatures == null) {
      return null;
    }
    if (paramPackageInfo.signatures.length != 1)
    {
      Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
      return null;
    }
    paramPackageInfo = new k(paramPackageInfo.signatures[0].toByteArray());
    while (i < paramVarArgs.length)
    {
      if (paramVarArgs[i].equals(paramPackageInfo)) {
        return paramVarArgs[i];
      }
      i += 1;
    }
    return null;
  }
  
  private static boolean a(PackageInfo paramPackageInfo, boolean paramBoolean)
  {
    if ((paramPackageInfo != null) && (paramPackageInfo.signatures != null))
    {
      if (paramBoolean) {}
      for (paramPackageInfo = a(paramPackageInfo, m.Nh); paramPackageInfo != null; paramPackageInfo = a(paramPackageInfo, new j[] { m.Nh[0] })) {
        return true;
      }
    }
    return false;
  }
  
  public static o q(Context paramContext)
  {
    d.D(paramContext);
    try
    {
      if (No == null)
      {
        i.n(paramContext);
        No = new o(paramContext);
      }
      return No;
    }
    finally {}
  }
  
  public final boolean a(PackageInfo paramPackageInfo)
  {
    if (paramPackageInfo == null) {}
    do
    {
      return false;
      if (a(paramPackageInfo, false)) {
        return true;
      }
    } while (!a(paramPackageInfo, true));
    if (n.o(this.mContext)) {
      return true;
    }
    Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.common.o
 * JD-Core Version:    0.7.0.1
 */