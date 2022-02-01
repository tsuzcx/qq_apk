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
    AppMethodBeat.i(219656);
    TEXTURE_CACHE = new ThreadLocal()
    {
      protected final ThreadLocalTextureCache initialValue()
      {
        AppMethodBeat.i(219648);
        ThreadLocalTextureCache localThreadLocalTextureCache = new ThreadLocalTextureCache(null);
        AppMethodBeat.o(219648);
        return localThreadLocalTextureCache;
      }
    };
    AppMethodBeat.o(219656);
  }
  
  private ThreadLocalTextureCache()
  {
    AppMethodBeat.i(219651);
    this.TAG = ("ThreadLocalTextureCache@" + Integer.toHexString(hashCode()));
    Logger.d(this.TAG, "ThreadLocalTextureCache() called, thread = " + Thread.currentThread().getName());
    this.textureCache = new HashMap();
    AppMethodBeat.o(219651);
  }
  
  public static ThreadLocalTextureCache getInstance()
  {
    AppMethodBeat.i(219650);
    ThreadLocalTextureCache localThreadLocalTextureCache = (ThreadLocalTextureCache)TEXTURE_CACHE.get();
    AppMethodBeat.o(219650);
    return localThreadLocalTextureCache;
  }
  
  public TextureInfo getTextureInfo(String paramString)
  {
    try
    {
      AppMethodBeat.i(219653);
      paramString = (TextureInfo)this.textureCache.get(paramString);
      AppMethodBeat.o(219653);
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
      AppMethodBeat.i(219652);
      Logger.d(this.TAG, "putTextureInfo() called with: key = [" + paramString + "], textureInfo = [" + paramTextureInfo + "]");
      this.textureCache.put(paramString, paramTextureInfo);
      AppMethodBeat.o(219652);
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
      AppMethodBeat.i(219655);
      Logger.d(this.TAG, "release() called, textureCache = " + this.textureCache);
      Iterator localIterator = this.textureCache.values().iterator();
      while (localIterator.hasNext()) {
        ((TextureInfo)localIterator.next()).release();
      }
      this.textureCache.clear();
    }
    finally {}
    AppMethodBeat.o(219655);
  }
  
  public void remove(String paramString)
  {
    try
    {
      AppMethodBeat.i(219654);
      this.textureCache.remove(paramString);
      AppMethodBeat.o(219654);
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