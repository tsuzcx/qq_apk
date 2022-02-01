package com.tencent.xweb.skia_canvas;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class SkiaCanvasLogic
{
  private static boolean sInit = false;
  
  static void init()
  {
    AppMethodBeat.i(4294);
    if (!sInit)
    {
      sInit = true;
      XWebLibraryLoader.beforeLoad();
      XWebLibraryLoader.load("c++_shared");
      XWebLibraryLoader.load("mmskia");
      XWebLibraryLoader.load("canvas");
      XWebLibraryLoader.load("skia-canvas");
      XWebLibraryLoader.afetrLoad();
    }
    AppMethodBeat.o(4294);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.skia_canvas.SkiaCanvasLogic
 * JD-Core Version:    0.7.0.1
 */