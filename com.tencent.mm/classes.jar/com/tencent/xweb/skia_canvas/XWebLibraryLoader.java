package com.tencent.xweb.skia_canvas;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class XWebLibraryLoader
{
  private static IXWebLibraryLoader DEFAULT;
  private static IXWebLibraryLoader sXWebLibraryLoader;
  
  static
  {
    AppMethodBeat.i(154248);
    XWebLibraryLoader.1 local1 = new XWebLibraryLoader.1();
    DEFAULT = local1;
    sXWebLibraryLoader = local1;
    AppMethodBeat.o(154248);
  }
  
  public static void initXWebLibraryLoader(IXWebLibraryLoader paramIXWebLibraryLoader) {}
  
  public static boolean load(String paramString)
  {
    AppMethodBeat.i(154247);
    boolean bool = sXWebLibraryLoader.load(paramString);
    AppMethodBeat.o(154247);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.xweb.skia_canvas.XWebLibraryLoader
 * JD-Core Version:    0.7.0.1
 */