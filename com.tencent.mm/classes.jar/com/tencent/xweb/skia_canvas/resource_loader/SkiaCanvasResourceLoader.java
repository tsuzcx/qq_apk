package com.tencent.xweb.skia_canvas.resource_loader;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class SkiaCanvasResourceLoader
{
  private static final String TAG;
  private static ThreadLocal<ResourceLoaderDelegateWrapper> sThreadLocalLoader;
  
  static
  {
    AppMethodBeat.i(218268);
    TAG = SkiaCanvasResourceLoader.class.getSimpleName();
    sThreadLocalLoader = new ThreadLocal();
    AppMethodBeat.o(218268);
  }
  
  static ResourceLoaderDelegateWrapper getDelegateWrapperForCurrentThread()
  {
    AppMethodBeat.i(218266);
    ResourceLoaderDelegateWrapper localResourceLoaderDelegateWrapper = (ResourceLoaderDelegateWrapper)sThreadLocalLoader.get();
    AppMethodBeat.o(218266);
    return localResourceLoaderDelegateWrapper;
  }
  
  public static boolean hasDelegateSet()
  {
    AppMethodBeat.i(218267);
    if (sThreadLocalLoader.get() != null)
    {
      AppMethodBeat.o(218267);
      return true;
    }
    AppMethodBeat.o(218267);
    return false;
  }
  
  public static void setDelegate(IResourceLoader paramIResourceLoader)
  {
    AppMethodBeat.i(218265);
    sThreadLocalLoader.set(new ResourceLoaderDelegateWrapper(paramIResourceLoader));
    AppMethodBeat.o(218265);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.xweb.skia_canvas.resource_loader.SkiaCanvasResourceLoader
 * JD-Core Version:    0.7.0.1
 */