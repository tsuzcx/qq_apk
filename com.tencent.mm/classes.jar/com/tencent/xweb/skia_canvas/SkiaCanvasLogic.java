package com.tencent.xweb.skia_canvas;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class SkiaCanvasLogic
{
  static boolean sInit = false;
  
  public static void init()
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
  
  public static void init(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(217424);
    nativeInitJSBinding(paramLong1, paramLong2);
    AppMethodBeat.o(217424);
  }
  
  private static native void nativeInitJSBinding(long paramLong1, long paramLong2);
  
  private static native void nativeOnJSContextDestroying();
  
  private static native void nativeSetAppTag(String paramString);
  
  public static void onJSContextDestroying()
  {
    AppMethodBeat.i(217425);
    nativeOnJSContextDestroying();
    AppMethodBeat.o(217425);
  }
  
  public static void setAppTag(String paramString)
  {
    AppMethodBeat.i(217426);
    nativeSetAppTag(paramString);
    AppMethodBeat.o(217426);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.skia_canvas.SkiaCanvasLogic
 * JD-Core Version:    0.7.0.1
 */