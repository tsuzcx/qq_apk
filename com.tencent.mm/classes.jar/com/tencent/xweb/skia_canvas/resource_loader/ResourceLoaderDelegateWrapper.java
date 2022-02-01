package com.tencent.xweb.skia_canvas.resource_loader;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class ResourceLoaderDelegateWrapper
{
  private static final String TAG = "ResourceLoaderDelegateW";
  private final IResourceLoader mDelegate;
  private final Thread mThread;
  
  ResourceLoaderDelegateWrapper(IResourceLoader paramIResourceLoader)
  {
    AppMethodBeat.i(218257);
    this.mDelegate = paramIResourceLoader;
    this.mThread = Thread.currentThread();
    nativeCreatePeer();
    AppMethodBeat.o(218257);
  }
  
  private void checkRunningThread()
  {
    AppMethodBeat.i(218258);
    if (Thread.currentThread() != this.mThread)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("Any method should be run at thread " + this.mThread);
      AppMethodBeat.o(218258);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(218258);
  }
  
  private native void nativeCreatePeer();
  
  private native void nativeNotifyResourceLoad(int paramInt, byte[] paramArrayOfByte);
  
  public byte[] loadResource(String paramString1, String paramString2)
  {
    AppMethodBeat.i(218259);
    String.format("loadResource path:%s, referrerPolicy:%s, delegate: %s", new Object[] { paramString1, paramString2, this.mDelegate });
    paramString1 = this.mDelegate.loadResource(paramString1, paramString2);
    if (paramString1 == null)
    {
      AppMethodBeat.o(218259);
      return new byte[0];
    }
    String.format("loadResource result:%d", new Object[] { Integer.valueOf(paramString1.length) });
    AppMethodBeat.o(218259);
    return paramString1;
  }
  
  public void loadResourceAsync(final int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(218260);
    String.format("loadResourceAsync path:%s, referrerPolicy:%s, requestId: %d, delegate: %s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt), this.mDelegate });
    this.mDelegate.loadResourceAsync(paramString1, paramString2, new IResourceLoader.ResourceLoadCallback()
    {
      public void onResourceLoaded(byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(218256);
        ResourceLoaderDelegateWrapper.access$000(ResourceLoaderDelegateWrapper.this);
        if (paramAnonymousArrayOfByte == null)
        {
          ResourceLoaderDelegateWrapper.access$100(ResourceLoaderDelegateWrapper.this, paramInt, new byte[0]);
          AppMethodBeat.o(218256);
          return;
        }
        String.format("loadResourceAsync result:%d", new Object[] { Integer.valueOf(paramAnonymousArrayOfByte.length) });
        ResourceLoaderDelegateWrapper.access$100(ResourceLoaderDelegateWrapper.this, paramInt, paramAnonymousArrayOfByte);
        AppMethodBeat.o(218256);
      }
    });
    AppMethodBeat.o(218260);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.xweb.skia_canvas.resource_loader.ResourceLoaderDelegateWrapper
 * JD-Core Version:    0.7.0.1
 */