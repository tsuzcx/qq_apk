package com.tencent.tencentmap.mapsdk.maps.a;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cg
{
  public String a;
  public String b;
  public String c;
  public String d;
  public String e;
  
  public cg()
  {
    AppMethodBeat.i(147346);
    try
    {
      this.a = Build.MODEL;
      this.b = Build.VERSION.RELEASE;
      this.c = dd.a();
      this.d = dd.b();
      dd.e();
      this.e = dd.f();
      AppMethodBeat.o(147346);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(147346);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.cg
 * JD-Core Version:    0.7.0.1
 */