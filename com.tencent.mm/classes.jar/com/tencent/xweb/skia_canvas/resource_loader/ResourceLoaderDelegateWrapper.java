package com.tencent.xweb.skia_canvas.resource_loader;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class ResourceLoaderDelegateWrapper
{
  private static final String TAG = "ResourceLoaderDelegateW";
  private final IResourceLoader mDelegate;
  private final Thread mThread;
  
  ResourceLoaderDelegateWrapper(IResourceLoader paramIResourceLoader)
  {
    AppMethodBeat.i(196945);
    this.mDelegate = paramIResourceLoader;
    this.mThread = Thread.currentThread();
    nativeCreatePeer();
    AppMethodBeat.o(196945);
  }
  
  private void checkRunningThread()
  {
    AppMethodBeat.i(196946);
    if (Thread.currentThread() != this.mThread)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("Any method should be run at thread " + this.mThread);
      AppMethodBeat.o(196946);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(196946);
  }
  
  private native void nativeCreatePeer();
  
  private native void nativeNotifyResourceLoad(int paramInt, byte[] paramArrayOfByte);
  
  public byte[] loadResource(String paramString1, String paramString2)
  {
    AppMethodBeat.i(196947);
    String.format("loadResource path:%s, referrerPolicy:%s, delegate: %s", new Object[] { paramString1, paramString2, this.mDelegate });
    paramString1 = this.mDelegate.loadResource(paramString1, paramString2);
    if (paramString1 == null)
    {
      AppMethodBeat.o(196947);
      return new byte[0];
    }
    AppMethodBeat.o(196947);
    return paramString1;
  }
  
  public void loadResourceAsync(final int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(196949);
    String.format("loadResourceAsync path:%s, referrerPolicy:%s, requestId: %d, delegate: %s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt), this.mDelegate });
    this.mDelegate.loadResourceAsync(paramString1, paramString2, new IResourceLoader.ResourceLoadCallback()
    {
      public void onResourceLoaded(byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(196944);
        ResourceLoaderDelegateWrapper.access$000(ResourceLoaderDelegateWrapper.this);
        if (paramAnonymousArrayOfByte == null)
        {
          ResourceLoaderDelegateWrapper.access$100(ResourceLoaderDelegateWrapper.this, paramInt, new byte[0]);
          AppMethodBeat.o(196944);
          return;
        }
        ResourceLoaderDelegateWrapper.access$100(ResourceLoaderDelegateWrapper.this, paramInt, paramAnonymousArrayOfByte);
        AppMethodBeat.o(196944);
      }
    });
    AppMethodBeat.o(196949);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.skia_canvas.resource_loader.ResourceLoaderDelegateWrapper
 * JD-Core Version:    0.7.0.1
 */