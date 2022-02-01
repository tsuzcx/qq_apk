package com.tencent.xweb.skia_canvas.resource_loader;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class SkiaCanvasResourceLoader
{
  private static final String TAG;
  private static ThreadLocal<ResourceLoaderDelegateWrapper> sThreadLocalLoader;
  
  static
  {
    AppMethodBeat.i(217471);
    TAG = SkiaCanvasResourceLoader.class.getSimpleName();
    sThreadLocalLoader = new ThreadLocal();
    AppMethodBeat.o(217471);
  }
  
  static ResourceLoaderDelegateWrapper getDelegateWrapperForCurrentThread()
  {
    AppMethodBeat.i(217469);
    ResourceLoaderDelegateWrapper localResourceLoaderDelegateWrapper = (ResourceLoaderDelegateWrapper)sThreadLocalLoader.get();
    AppMethodBeat.o(217469);
    return localResourceLoaderDelegateWrapper;
  }
  
  public static boolean hasDelegateSet()
  {
    AppMethodBeat.i(217470);
    if (sThreadLocalLoader.get() != null)
    {
      AppMethodBeat.o(217470);
      return true;
    }
    AppMethodBeat.o(217470);
    return false;
  }
  
  public static void setDelegate(IResourceLoader paramIResourceLoader)
  {
    AppMethodBeat.i(217468);
    sThreadLocalLoader.set(new ResourceLoaderDelegateWrapper(paramIResourceLoader));
    AppMethodBeat.o(217468);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.skia_canvas.resource_loader.SkiaCanvasResourceLoader
 * JD-Core Version:    0.7.0.1
 */