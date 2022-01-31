package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

public final class gq
{
  public String a = "";
  public int b = 0;
  public String c = "";
  public String d = "";
  public int e;
  
  public gq()
  {
    try
    {
      this.a = em.a().getPackageName();
      PackageInfo localPackageInfo = em.a().getPackageManager().getPackageInfo(this.a, 0);
      this.b = localPackageInfo.versionCode;
      this.c = localPackageInfo.versionName;
      this.e = em.c();
      this.d = "";
      return;
    }
    catch (Throwable localThrowable) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.gq
 * JD-Core Version:    0.7.0.1
 */