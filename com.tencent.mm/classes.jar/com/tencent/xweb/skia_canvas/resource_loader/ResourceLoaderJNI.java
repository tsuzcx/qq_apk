package com.tencent.xweb.skia_canvas.resource_loader;

import com.tencent.matrix.trace.core.AppMethodBeat;

class ResourceLoaderJNI
{
  private static final String TAG = "ResourceLoaderJNI";
  
  static byte[] loadResource(String paramString1, String paramString2)
  {
    AppMethodBeat.i(217466);
    if (SkiaCanvasResourceLoader.hasDelegateSet())
    {
      paramString1 = SkiaCanvasResourceLoader.getDelegateWrapperForCurrentThread().loadResource(paramString1, paramString2);
      AppMethodBeat.o(217466);
      return paramString1;
    }
    AppMethodBeat.o(217466);
    return new byte[0];
  }
  
  static void loadResourceAsync(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(217467);
    if (SkiaCanvasResourceLoader.hasDelegateSet()) {
      SkiaCanvasResourceLoader.getDelegateWrapperForCurrentThread().loadResourceAsync(paramInt, paramString1, paramString2);
    }
    AppMethodBeat.o(217467);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.skia_canvas.resource_loader.ResourceLoaderJNI
 * JD-Core Version:    0.7.0.1
 */