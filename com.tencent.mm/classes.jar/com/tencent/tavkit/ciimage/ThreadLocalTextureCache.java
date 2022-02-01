package com.tencent.tavkit.ciimage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.logger.Logger;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class ThreadLocalTextureCache
{
  private static final ThreadLocal<ThreadLocalTextureCache> TEXTURE_CACHE;
  private final String TAG;
  private final HashMap<String, TextureInfo> textureCache;
  
  static
  {
    AppMethodBeat.i(200687);
    TEXTURE_CACHE = new ThreadLocal()
    {
      protected final ThreadLocalTextureCache initialValue()
      {
        AppMethodBeat.i(200679);
        ThreadLocalTextureCache localThreadLocalTextureCache = new ThreadLocalTextureCache(null);
        AppMethodBeat.o(200679);
        return localThreadLocalTextureCache;
      }
    };
    AppMethodBeat.o(200687);
  }
  
  private ThreadLocalTextureCache()
  {
    AppMethodBeat.i(200682);
    this.TAG = ("ThreadLocalTextureCache@" + Integer.toHexString(hashCode()));
    Logger.d(this.TAG, "ThreadLocalTextureCache() called, thread = " + Thread.currentThread().getName());
    this.textureCache = new HashMap();
    AppMethodBeat.o(200682);
  }
  
  public static ThreadLocalTextureCache getInstance()
  {
    AppMethodBeat.i(200681);
    ThreadLocalTextureCache localThreadLocalTextureCache = (ThreadLocalTextureCache)TEXTURE_CACHE.get();
    AppMethodBeat.o(200681);
    return localThreadLocalTextureCache;
  }
  
  public TextureInfo getTextureInfo(String paramString)
  {
    try
    {
      AppMethodBeat.i(200684);
      paramString = (TextureInfo)this.textureCache.get(paramString);
      AppMethodBeat.o(200684);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void putTextureInfo(String paramString, TextureInfo paramTextureInfo)
  {
    try
    {
      AppMethodBeat.i(200683);
      Logger.d(this.TAG, "putTextureInfo() called with: key = [" + paramString + "], textureInfo = [" + paramTextureInfo + "]");
      this.textureCache.put(paramString, paramTextureInfo);
      AppMethodBeat.o(200683);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void release()
  {
    try
    {
      AppMethodBeat.i(200686);
      Logger.d(this.TAG, "release() called, textureCache = " + this.textureCache);
      Iterator localIterator = this.textureCache.values().iterator();
      while (localIterator.hasNext()) {
        ((TextureInfo)localIterator.next()).release();
      }
      this.textureCache.clear();
    }
    finally {}
    AppMethodBeat.o(200686);
  }
  
  public void remove(String paramString)
  {
    try
    {
      AppMethodBeat.i(200685);
      this.textureCache.remove(paramString);
      AppMethodBeat.o(200685);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tavkit.ciimage.ThreadLocalTextureCache
 * JD-Core Version:    0.7.0.1
 */