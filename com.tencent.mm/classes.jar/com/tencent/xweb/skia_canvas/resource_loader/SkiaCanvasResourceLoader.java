package com.tencent.xweb.skia_canvas.resource_loader;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class SkiaCanvasResourceLoader
{
  private static final String TAG;
  private static ThreadLocal<ResourceLoaderDelegateWrapper> sThreadLocalLoader;
  
  static
  {
    AppMethodBeat.i(189682);
    TAG = SkiaCanvasResourceLoader.class.getSimpleName();
    sThreadLocalLoader = new ThreadLocal();
    AppMethodBeat.o(189682);
  }
  
  public static void setDelegate(IResourceLoader paramIResourceLoader)
  {
    AppMethodBeat.i(189681);
    sThreadLocalLoader.set(new ResourceLoaderDelegateWrapper(paramIResourceLoader));
    AppMethodBeat.o(189681);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.xweb.skia_canvas.resource_loader.SkiaCanvasResourceLoader
 * JD-Core Version:    0.7.0.1
 */