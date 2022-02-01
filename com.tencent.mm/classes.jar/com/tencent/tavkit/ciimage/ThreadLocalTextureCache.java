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
    AppMethodBeat.i(197357);
    TEXTURE_CACHE = new ThreadLocal()
    {
      protected final ThreadLocalTextureCache initialValue()
      {
        AppMethodBeat.i(197349);
        ThreadLocalTextureCache localThreadLocalTextureCache = new ThreadLocalTextureCache(null);
        AppMethodBeat.o(197349);
        return localThreadLocalTextureCache;
      }
    };
    AppMethodBeat.o(197357);
  }
  
  private ThreadLocalTextureCache()
  {
    AppMethodBeat.i(197352);
    this.TAG = ("ThreadLocalTextureCache@" + Integer.toHexString(hashCode()));
    Logger.d(this.TAG, "ThreadLocalTextureCache() called, thread = " + Thread.currentThread().getName());
    this.textureCache = new HashMap();
    AppMethodBeat.o(197352);
  }
  
  public static ThreadLocalTextureCache getInstance()
  {
    AppMethodBeat.i(197351);
    ThreadLocalTextureCache localThreadLocalTextureCache = (ThreadLocalTextureCache)TEXTURE_CACHE.get();
    AppMethodBeat.o(197351);
    return localThreadLocalTextureCache;
  }
  
  public TextureInfo getTextureInfo(String paramString)
  {
    try
    {
      AppMethodBeat.i(197354);
      paramString = (TextureInfo)this.textureCache.get(paramString);
      AppMethodBeat.o(197354);
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
      AppMethodBeat.i(197353);
      Logger.d(this.TAG, "putTextureInfo() called with: key = [" + paramString + "], textureInfo = [" + paramTextureInfo + "]");
      this.textureCache.put(paramString, paramTextureInfo);
      AppMethodBeat.o(197353);
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
      AppMethodBeat.i(197356);
      Logger.d(this.TAG, "release() called, textureCache = " + this.textureCache);
      Iterator localIterator = this.textureCache.values().iterator();
      while (localIterator.hasNext()) {
        ((TextureInfo)localIterator.next()).release();
      }
      this.textureCache.clear();
    }
    finally {}
    AppMethodBeat.o(197356);
  }
  
  public void remove(String paramString)
  {
    try
    {
      AppMethodBeat.i(197355);
      this.textureCache.remove(paramString);
      AppMethodBeat.o(197355);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tavkit.ciimage.ThreadLocalTextureCache
 * JD-Core Version:    0.7.0.1
 */