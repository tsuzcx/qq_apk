package com.tencent.xweb.skia_canvas;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class XWebLibraryLoader$1
  implements IXWebLibraryLoader
{
  public final boolean load(String paramString)
  {
    AppMethodBeat.i(154246);
    try
    {
      System.loadLibrary(paramString);
      AppMethodBeat.o(154246);
      return true;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        XWebLibraryLoader.class.getSimpleName();
        String.format("%s load fail %s", new Object[] { paramString, localException });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.xweb.skia_canvas.XWebLibraryLoader.1
 * JD-Core Version:    0.7.0.1
 */