package com.tencent.tencentmap.mapsdk.maps.a;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ce
{
  public String a;
  public int b;
  public String c;
  public String d;
  public int e;
  
  public ce()
  {
    AppMethodBeat.i(147344);
    this.a = "";
    this.b = 0;
    this.c = "";
    this.d = "";
    try
    {
      this.a = ac.a().getPackageName();
      PackageInfo localPackageInfo = ac.a().getPackageManager().getPackageInfo(this.a, 0);
      this.b = localPackageInfo.versionCode;
      this.c = localPackageInfo.versionName;
      this.e = ac.c();
      this.d = "";
      AppMethodBeat.o(147344);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(147344);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.ce
 * JD-Core Version:    0.7.0.1
 */