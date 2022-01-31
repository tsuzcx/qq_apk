package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

public class k
{
  private static volatile k a;
  private String b;
  private String c;
  private String d;
  private String e;
  private String f;
  
  private k(Context paramContext)
  {
    AppMethodBeat.i(150426);
    this.b = paramContext.getDir("tencentMapTemp", 0).getAbsolutePath();
    this.e = paramContext.getDir("tencentMapLib", 0).getAbsolutePath();
    this.c = (this.e + File.separator + "vector.jar");
    this.d = (this.e + File.separator + "libtxmapengine.so");
    this.f = (paramContext.getFilesDir().getAbsolutePath() + "/tencentMapSdk/dynamicAssets/");
    AppMethodBeat.o(150426);
  }
  
  public static k a(Context paramContext)
  {
    AppMethodBeat.i(150427);
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new k(paramContext);
      }
      paramContext = a;
      AppMethodBeat.o(150427);
      return paramContext;
    }
    finally
    {
      AppMethodBeat.o(150427);
    }
  }
  
  public String a()
  {
    return this.b;
  }
  
  public String b()
  {
    return this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.k
 * JD-Core Version:    0.7.0.1
 */