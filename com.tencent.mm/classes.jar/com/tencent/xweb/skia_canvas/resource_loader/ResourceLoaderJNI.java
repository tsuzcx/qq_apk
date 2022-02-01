package com.tencent.xweb.skia_canvas.resource_loader;

import com.tencent.matrix.trace.core.AppMethodBeat;

class ResourceLoaderJNI
{
  private static final String TAG = "ResourceLoaderJNI";
  
  static byte[] loadResource(String paramString1, String paramString2)
  {
    AppMethodBeat.i(217620);
    if (SkiaCanvasResourceLoader.hasDelegateSet())
    {
      paramString1 = SkiaCanvasResourceLoader.getDelegateWrapperForCurrentThread().loadResource(paramString1, paramString2);
      AppMethodBeat.o(217620);
      return paramString1;
    }
    AppMethodBeat.o(217620);
    return new byte[0];
  }
  
  static void loadResourceAsync(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(217621);
    if (SkiaCanvasResourceLoader.hasDelegateSet()) {
      SkiaCanvasResourceLoader.getDelegateWrapperForCurrentThread().loadResourceAsync(paramInt, paramString1, paramString2);
    }
    AppMethodBeat.o(217621);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.xweb.skia_canvas.resource_loader.ResourceLoaderJNI
 * JD-Core Version:    0.7.0.1
 */