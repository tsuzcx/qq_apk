package com.tencent.xweb.skia_canvas.resource_loader;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class SkiaCanvasResourceLoader
{
  private static final String TAG;
  private static ThreadLocal<ResourceLoaderDelegateWrapper> sThreadLocalLoader;
  
  static
  {
    AppMethodBeat.i(196964);
    TAG = SkiaCanvasResourceLoader.class.getSimpleName();
    sThreadLocalLoader = new ThreadLocal();
    AppMethodBeat.o(196964);
  }
  
  static ResourceLoaderDelegateWrapper getDelegateWrapperForCurrentThread()
  {
    AppMethodBeat.i(196960);
    ResourceLoaderDelegateWrapper localResourceLoaderDelegateWrapper = (ResourceLoaderDelegateWrapper)sThreadLocalLoader.get();
    AppMethodBeat.o(196960);
    return localResourceLoaderDelegateWrapper;
  }
  
  public static boolean hasDelegateSet()
  {
    AppMethodBeat.i(196961);
    if (sThreadLocalLoader.get() != null)
    {
      AppMethodBeat.o(196961);
      return true;
    }
    AppMethodBeat.o(196961);
    return false;
  }
  
  public static void setDelegate(IResourceLoader paramIResourceLoader)
  {
    AppMethodBeat.i(196958);
    sThreadLocalLoader.set(new ResourceLoaderDelegateWrapper(paramIResourceLoader));
    AppMethodBeat.o(196958);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.skia_canvas.resource_loader.SkiaCanvasResourceLoader
 * JD-Core Version:    0.7.0.1
 */