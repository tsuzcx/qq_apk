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
    AppMethodBeat.i(198007);
    this.segmentTimeRange = null;
    this.cacheFrameList = new ArrayList();
    this.segmentTimeRange = paramCMTimeRange;
    AppMethodBeat.o(198007);
  }
  
  private boolean isCacheFrameUsable(CacheFrame paramCacheFrame)
  {
    AppMethodBeat.i(198009);
    if ((paramCacheFrame.sampleBuffer != null) && (paramCacheFrame.sampleBuffer.getTextureInfo() != null))
    {
      AppMethodBeat.o(198009);
      return true;
    }
    AppMethodBeat.o(198009);
    return false;
  }
  
  public void clear()
  {
    AppMethodBeat.i(198011);
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
    AppMethodBeat.o(198011);
  }
  
  CMTime getLastFrameTime()
  {
    AppMethodBeat.i(198012);
    if (this.cacheFrameList.size() > 0)
    {
      localCMTime = ((CacheFrame)this.cacheFrameList.get(this.cacheFrameList.size() - 1)).frameTime;
      AppMethodBeat.o(198012);
      return localCMTime;
    }
    CMTime localCMTime = this.segmentTimeRange.getEnd();
    AppMethodBeat.o(198012);
    return localCMTime;
  }
  
  CacheFrame popFrame(CMTime paramCMTime)
  {
    AppMethodBeat.i(198008);
    if (this.cacheFrameList.size() > 0)
    {
      CacheFrame localCacheFrame = (CacheFrame)this.cacheFrameList.get(0);
      if (!localCacheFrame.frameTime.smallThan(paramCMTime))
      {
        paramCMTime = (CacheFrame)this.cacheFrameList.get(0);
        AppMethodBeat.o(198008);
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
    AppMethodBeat.o(198008);
    return null;
  }
  
  void pushFrame(CacheFrame paramCacheFrame)
  {
    AppMethodBeat.i(198010);
    int i = 0;
    while (i < this.cacheFrameList.size())
    {
      if (((CacheFrame)this.cacheFrameList.get(i)).frameTime.bigThan(paramCacheFrame.frameTime))
      {
        this.cacheFrameList.add(i, paramCacheFrame);
        AppMethodBeat.o(198010);
        return;
      }
      i += 1;
    }
    this.cacheFrameList.add(paramCacheFrame);
    AppMethodBeat.o(198010);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tav.decoder.decodecache.CacheSegment
 * JD-Core Version:    0.7.0.1
 */