package com.tencent.tencentmap.mapsdk.maps.a;

import android.content.Context;
import com.tencent.map.lib.d;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class jh
{
  static final String[] a = { "txmapengine", "txnavengine" };
  
  public static void a(Context paramContext, String paramString)
  {
    AppMethodBeat.i(148693);
    try
    {
      System.loadLibrary(paramString);
      d.a("loadLibary:" + paramString + "  successful");
      AppMethodBeat.o(148693);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      boolean bool = ji.a(paramContext, paramString);
      d.a("loadLibary:" + paramString + " result:" + bool);
      AppMethodBeat.o(148693);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.jh
 * JD-Core Version:    0.7.0.1
 */