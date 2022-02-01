package com.tencent.xweb.skia_canvas.resource_loader;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class SkiaCanvasResourceLoader
{
  private static final String TAG;
  private static ThreadLocal<ResourceLoaderDelegateWrapper> sThreadLocalLoader;
  
  static
  {
    AppMethodBeat.i(213821);
    TAG = SkiaCanvasResourceLoader.class.getSimpleName();
    sThreadLocalLoader = new ThreadLocal();
    AppMethodBeat.o(213821);
  }
  
  static ResourceLoaderDelegateWrapper getDelegateWrapperForCurrentThread()
  {
    AppMethodBeat.i(213806);
    ResourceLoaderDelegateWrapper localResourceLoaderDelegateWrapper = (ResourceLoaderDelegateWrapper)sThreadLocalLoader.get();
    AppMethodBeat.o(213806);
    return localResourceLoaderDelegateWrapper;
  }
  
  public static boolean hasDelegateSet()
  {
    AppMethodBeat.i(213814);
    if (sThreadLocalLoader.get() != null)
    {
      AppMethodBeat.o(213814);
      return true;
    }
    AppMethodBeat.o(213814);
    return false;
  }
  
  public static void setDelegate(IResourceLoader paramIResourceLoader)
  {
    AppMethodBeat.i(213798);
    sThreadLocalLoader.set(new ResourceLoaderDelegateWrapper(paramIResourceLoader));
    AppMethodBeat.o(213798);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.xweb.skia_canvas.resource_loader.SkiaCanvasResourceLoader
 * JD-Core Version:    0.7.0.1
 */