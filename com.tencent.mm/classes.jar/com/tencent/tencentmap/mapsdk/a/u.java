package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.a.ka;

public class u
  extends q
{
  private static volatile u b;
  
  private u(Context paramContext)
  {
    AppMethodBeat.i(147082);
    if (paramContext == null)
    {
      AppMethodBeat.o(147082);
      return;
    }
    this.a = paramContext.getSharedPreferences("com.tencent.tencentmap.mapsdk.maps.offlinemap", 0);
    c();
    AppMethodBeat.o(147082);
  }
  
  public static u a(Context paramContext)
  {
    AppMethodBeat.i(147081);
    if (b == null) {}
    try
    {
      if (b == null) {
        b = new u(paramContext);
      }
      paramContext = b;
      AppMethodBeat.o(147081);
      return paramContext;
    }
    finally
    {
      AppMethodBeat.o(147081);
    }
  }
  
  private void c()
  {
    AppMethodBeat.i(98281);
    if (b == null)
    {
      AppMethodBeat.o(98281);
      return;
    }
    a(new String[] { "taiwanClearCacheVersion", "taiwanStyle", "taiwanVersion", "mapPoiIcon", "worldTileCount" });
    String str = a("sdkVersion");
    if (str == null)
    {
      AppMethodBeat.o(98281);
      return;
    }
    if (ka.b("4.1.0", str) > 0) {
      a();
    }
    AppMethodBeat.o(98281);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.u
 * JD-Core Version:    0.7.0.1
 */