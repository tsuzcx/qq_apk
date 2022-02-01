package com.tencent.xweb.skia_canvas.resource_loader;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class SkiaCanvasResourceLoader
{
  private static final String TAG;
  private static ThreadLocal<ResourceLoaderDelegateWrapper> sThreadLocalLoader;
  
  static
  {
    AppMethodBeat.i(217625);
    TAG = SkiaCanvasResourceLoader.class.getSimpleName();
    sThreadLocalLoader = new ThreadLocal();
    AppMethodBeat.o(217625);
  }
  
  static ResourceLoaderDelegateWrapper getDelegateWrapperForCurrentThread()
  {
    AppMethodBeat.i(217623);
    ResourceLoaderDelegateWrapper localResourceLoaderDelegateWrapper = (ResourceLoaderDelegateWrapper)sThreadLocalLoader.get();
    AppMethodBeat.o(217623);
    return localResourceLoaderDelegateWrapper;
  }
  
  public static boolean hasDelegateSet()
  {
    AppMethodBeat.i(217624);
    if (sThreadLocalLoader.get() != null)
    {
      AppMethodBeat.o(217624);
      return true;
    }
    AppMethodBeat.o(217624);
    return false;
  }
  
  public static void setDelegate(IResourceLoader paramIResourceLoader)
  {
    AppMethodBeat.i(217622);
    sThreadLocalLoader.set(new ResourceLoaderDelegateWrapper(paramIResourceLoader));
    AppMethodBeat.o(217622);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.xweb.skia_canvas.resource_loader.SkiaCanvasResourceLoader
 * JD-Core Version:    0.7.0.1
 */