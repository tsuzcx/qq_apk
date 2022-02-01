package com.tencent.tav.decoder.decodecache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.ITexturePool;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class CacheSegment
{
  public volatile List<CacheFrame> cacheFrameList;
  public volatile CMTimeRange segmentTimeRange;
  
  CacheSegment(CMTimeRange paramCMTimeRange)
  {
    AppMethodBeat.i(218403);
    this.segmentTimeRange = null;
    this.cacheFrameList = new ArrayList();
    this.segmentTimeRange = paramCMTimeRange;
    AppMethodBeat.o(218403);
  }
  
  private boolean isCacheFrameUsable(CacheFrame paramCacheFrame)
  {
    AppMethodBeat.i(218405);
    if ((paramCacheFrame.sampleBuffer != null) && (paramCacheFrame.sampleBuffer.getTextureInfo() != null))
    {
      AppMethodBeat.o(218405);
      return true;
    }
    AppMethodBeat.o(218405);
    return false;
  }
  
  public void clear()
  {
    AppMethodBeat.i(218407);
    Iterator localIterator = this.cacheFrameList.iterator();
    while (localIterator.hasNext())
    {
      CacheFrame localCacheFrame = (CacheFrame)localIterator.next();
      if (isCacheFrameUsable(localCacheFrame))
      {
        localCacheFrame.texturePool.pushTexture(localCacheFrame.sampleBuffer.getTextureInfo());
        localCacheFrame.sampleBuffer = null;
      }
    }
    this.cacheFrameList.clear();
    AppMethodBeat.o(218407);
  }
  
  CMTime getLastFrameTime()
  {
    AppMethodBeat.i(218408);
    if (this.cacheFrameList.size() > 0)
    {
      localCMTime = ((CacheFrame)this.cacheFrameList.get(this.cacheFrameList.size() - 1)).frameTime;
      AppMethodBeat.o(218408);
      return localCMTime;
    }
    CMTime localCMTime = this.segmentTimeRange.getEnd();
    AppMethodBeat.o(218408);
    return localCMTime;
  }
  
  CacheFrame popFrame(CMTime paramCMTime)
  {
    AppMethodBeat.i(218404);
    if (this.cacheFrameList.size() > 0)
    {
      CacheFrame localCacheFrame = (CacheFrame)this.cacheFrameList.get(0);
      if (!localCacheFrame.frameTime.smallThan(paramCMTime))
      {
        paramCMTime = (CacheFrame)this.cacheFrameList.get(0);
        AppMethodBeat.o(218404);
        return paramCMTime;
      }
      if (isCacheFrameUsable(localCacheFrame))
      {
        if (localCacheFrame.texturePool != null) {
          break label107;
        }
        localCacheFrame.sampleBuffer.getTextureInfo().release();
      }
      for (;;)
      {
        localCacheFrame.sampleBuffer = null;
        this.cacheFrameList.remove(0);
        break;
        label107:
        localCacheFrame.texturePool.pushTexture(localCacheFrame.sampleBuffer.getTextureInfo());
      }
    }
    AppMethodBeat.o(218404);
    return null;
  }
  
  void pushFrame(CacheFrame paramCacheFrame)
  {
    AppMethodBeat.i(218406);
    int i = 0;
    while (i < this.cacheFrameList.size())
    {
      if (((CacheFrame)this.cacheFrameList.get(i)).frameTime.bigThan(paramCacheFrame.frameTime))
      {
        this.cacheFrameList.add(i, paramCacheFrame);
        AppMethodBeat.o(218406);
        return;
      }
      i += 1;
    }
    this.cacheFrameList.add(paramCacheFrame);
    AppMethodBeat.o(218406);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tav.decoder.decodecache.CacheSegment
 * JD-Core Version:    0.7.0.1
 */