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
    AppMethodBeat.i(204491);
    TEXTURE_CACHE = new ThreadLocal()
    {
      protected final ThreadLocalTextureCache initialValue()
      {
        AppMethodBeat.i(204483);
        ThreadLocalTextureCache localThreadLocalTextureCache = new ThreadLocalTextureCache(null);
        AppMethodBeat.o(204483);
        return localThreadLocalTextureCache;
      }
    };
    AppMethodBeat.o(204491);
  }
  
  private ThreadLocalTextureCache()
  {
    AppMethodBeat.i(204486);
    this.TAG = ("ThreadLocalTextureCache@" + Integer.toHexString(hashCode()));
    Logger.d(this.TAG, "ThreadLocalTextureCache() called, thread = " + Thread.currentThread().getName());
    this.textureCache = new HashMap();
    AppMethodBeat.o(204486);
  }
  
  public static ThreadLocalTextureCache getInstance()
  {
    AppMethodBeat.i(204485);
    ThreadLocalTextureCache localThreadLocalTextureCache = (ThreadLocalTextureCache)TEXTURE_CACHE.get();
    AppMethodBeat.o(204485);
    return localThreadLocalTextureCache;
  }
  
  public TextureInfo getTextureInfo(String paramString)
  {
    try
    {
      AppMethodBeat.i(204488);
      paramString = (TextureInfo)this.textureCache.get(paramString);
      AppMethodBeat.o(204488);
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
      AppMethodBeat.i(204487);
      Logger.d(this.TAG, "putTextureInfo() called with: key = [" + paramString + "], textureInfo = [" + paramTextureInfo + "]");
      this.textureCache.put(paramString, paramTextureInfo);
      AppMethodBeat.o(204487);
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
      AppMethodBeat.i(204490);
      Logger.d(this.TAG, "release() called, textureCache = " + this.textureCache);
      Iterator localIterator = this.textureCache.values().iterator();
      while (localIterator.hasNext()) {
        ((TextureInfo)localIterator.next()).release();
      }
      this.textureCache.clear();
    }
    finally {}
    AppMethodBeat.o(204490);
  }
  
  public void remove(String paramString)
  {
    try
    {
      AppMethodBeat.i(204489);
      this.textureCache.remove(paramString);
      AppMethodBeat.o(204489);
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