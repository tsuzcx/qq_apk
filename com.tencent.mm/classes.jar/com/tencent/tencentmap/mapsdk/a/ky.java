package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import com.tencent.map.lib.d;

public class ky
{
  static final String[] a = { "txmapengine", "txnavengine" };
  
  public static void a(Context paramContext, String paramString)
  {
    try
    {
      System.loadLibrary(paramString);
      d.a("loadLibary:" + paramString + "  successful");
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      boolean bool = kz.a(paramContext, paramString);
      d.a("loadLibary:" + paramString + " result:" + bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ky
 * JD-Core Version:    0.7.0.1
 */