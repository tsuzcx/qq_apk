package com.tencent.tav.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.asset.Asset;
import com.tencent.tav.asset.AssetTrack;
import com.tencent.tav.core.compositing.AsynchronousVideoCompositionRequest;
import com.tencent.tav.core.compositing.VideoCompositing;
import com.tencent.tav.core.compositing.VideoCompositionRenderContext;
import com.tencent.tav.core.composition.VideoComposition;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMSampleState;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.DecoderTrackSegment;
import com.tencent.tav.decoder.IDecoder.DecodeType;
import com.tencent.tav.decoder.IDecoderTrack;
import com.tencent.tav.decoder.IDecoderTrack.SurfaceCreator;
import com.tencent.tav.decoder.RenderContext;
import com.tencent.tav.decoder.VideoDecoderTrack;
import com.tencent.tav.decoder.logger.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class VideoCompositionDecoderTrack
  implements IDecoderTrack
{
  private static final String TAG = "VideoComDecoderTrack";
  private static final int WAIT_TIME = 200;
  private Asset asset;
  private AssetExtension assetExtension;
  private List<AssetTrack> assetTrackList;
  private boolean asynced;
  private List<IDecoderTrack> decoderTrackList;
  private CMTime frameDuration;
  private int frameRate;
  private CMSampleState lastSampleState;
  private VideoCompositionRenderContext renderContext;
  private int trackId;
  private VideoCompositing videoCompositing;
  private VideoComposition videoComposition;
  
  public VideoCompositionDecoderTrack(Asset paramAsset, AssetExtension paramAssetExtension, int paramInt)
  {
    AppMethodBeat.i(214600);
    this.decoderTrackList = new ArrayList();
    this.assetTrackList = new ArrayList();
    this.asynced = true;
    this.frameRate = 30;
    this.frameDuration = new CMTime(1L, 30);
    this.lastSampleState = new CMSampleState();
    this.asset = paramAsset;
    this.assetExtension = paramAssetExtension;
    this.trackId = paramInt;
    AppMethodBeat.o(214600);
  }
  
  private AsynchronousVideoCompositionRequest createVideoCompositionRequest(CMTime paramCMTime)
  {
    AppMethodBeat.i(214611);
    AsynchronousVideoCompositionRequest localAsynchronousVideoCompositionRequest = new AsynchronousVideoCompositionRequest(this, this.assetExtension);
    localAsynchronousVideoCompositionRequest.setRenderContext(this.renderContext);
    localAsynchronousVideoCompositionRequest.setCompositionTime(paramCMTime);
    if (this.videoComposition != null) {
      localAsynchronousVideoCompositionRequest.setVideoCompositionInstruction(VideoComposition.findInstruction(this.videoComposition, paramCMTime));
    }
    AppMethodBeat.o(214611);
    return localAsynchronousVideoCompositionRequest;
  }
  
  private CMSampleBuffer getSampleFromRequest(AsynchronousVideoCompositionRequest paramAsynchronousVideoCompositionRequest)
  {
    AppMethodBeat.i(214613);
    try
    {
      if (paramAsynchronousVideoCompositionRequest.getStatus() == -2147483648) {
        waitForRequestFinish(200);
      }
      switch (paramAsynchronousVideoCompositionRequest.getStatus())
      {
      default: 
        this.lastSampleState = CMSampleState.fromError(-3L);
        Logger.e("VideoComDecoderTrack", "readSample: failed 1 " + this.lastSampleState);
        paramAsynchronousVideoCompositionRequest = new CMSampleBuffer(CMSampleState.fromError(-3L));
        AppMethodBeat.o(214613);
        return paramAsynchronousVideoCompositionRequest;
      }
    }
    finally
    {
      AppMethodBeat.o(214613);
    }
    this.lastSampleState = paramAsynchronousVideoCompositionRequest.getComposedSampleBuffer().getState();
    paramAsynchronousVideoCompositionRequest = paramAsynchronousVideoCompositionRequest.getComposedSampleBuffer();
    AppMethodBeat.o(214613);
    return paramAsynchronousVideoCompositionRequest;
  }
  
  private CMSampleBuffer readSampleToRequest(CMTime paramCMTime, AsynchronousVideoCompositionRequest paramAsynchronousVideoCompositionRequest)
  {
    AppMethodBeat.i(214612);
    Iterator localIterator = this.decoderTrackList.iterator();
    while (localIterator.hasNext())
    {
      IDecoderTrack localIDecoderTrack = (IDecoderTrack)localIterator.next();
      CMSampleBuffer localCMSampleBuffer = localIDecoderTrack.readSample(paramCMTime);
      if (localCMSampleBuffer.getState().stateMatchingTo(new long[] { -3L, -2L, -100L }))
      {
        this.lastSampleState = new CMSampleState(localCMSampleBuffer.getTime());
        Logger.e("VideoComDecoderTrack", "readSample: failed 0 " + localCMSampleBuffer.getTime());
        paramCMTime = new CMSampleBuffer(localCMSampleBuffer.getState(), null);
        AppMethodBeat.o(214612);
        return paramCMTime;
      }
      if (localCMSampleBuffer.getState().stateMatchingTo(new long[] { -1L }))
      {
        if (this.decoderTrackList.size() <= 1)
        {
          Logger.d("VideoComDecoderTrack", "readSample: finish 1");
          AppMethodBeat.o(214612);
          return localCMSampleBuffer;
        }
      }
      else {
        paramAsynchronousVideoCompositionRequest.appendCMSampleBuffer(localCMSampleBuffer, localIDecoderTrack.getTrackId());
      }
    }
    AppMethodBeat.o(214612);
    return null;
  }
  
  /* Error */
  private void waitForRequestFinish(int paramInt)
  {
    // Byte code:
    //   0: ldc 224
    //   2: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: monitorenter
    //   7: iload_1
    //   8: i2l
    //   9: lstore_2
    //   10: aload_0
    //   11: lload_2
    //   12: invokevirtual 228	java/lang/Object:wait	(J)V
    //   15: aload_0
    //   16: monitorexit
    //   17: ldc 224
    //   19: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   22: return
    //   23: astore 4
    //   25: aload_0
    //   26: monitorexit
    //   27: ldc 224
    //   29: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   32: aload 4
    //   34: athrow
    //   35: astore 4
    //   37: goto -22 -> 15
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	40	0	this	VideoCompositionDecoderTrack
    //   0	40	1	paramInt	int
    //   9	3	2	l	long
    //   23	10	4	localObject	Object
    //   35	1	4	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   10	15	23	finally
    //   15	17	23	finally
    //   25	27	23	finally
    //   10	15	35	java/lang/Exception
  }
  
  public void addTrack(AssetTrack paramAssetTrack)
  {
    try
    {
      AppMethodBeat.i(214601);
      this.assetTrackList.add(paramAssetTrack);
      AppMethodBeat.o(214601);
      return;
    }
    finally
    {
      paramAssetTrack = finally;
      throw paramAssetTrack;
    }
  }
  
  public void asyncReadNextSample(CMTime paramCMTime)
  {
    AppMethodBeat.i(214615);
    if (!this.asynced)
    {
      AppMethodBeat.o(214615);
      return;
    }
    Iterator localIterator = this.decoderTrackList.iterator();
    while (localIterator.hasNext()) {
      ((IDecoderTrack)localIterator.next()).asyncReadNextSample(paramCMTime);
    }
    AppMethodBeat.o(214615);
  }
  
  public void clipRangeAndClearRange(CMTimeRange paramCMTimeRange)
  {
    AppMethodBeat.i(214607);
    Iterator localIterator = this.decoderTrackList.iterator();
    while (localIterator.hasNext()) {
      ((IDecoderTrack)localIterator.next()).clipRangeAndClearRange(paramCMTimeRange);
    }
    AppMethodBeat.o(214607);
  }
  
  public Asset getAsset()
  {
    return this.asset;
  }
  
  public CMTime getCurrentSampleTime()
  {
    AppMethodBeat.i(214617);
    CMTime localCMTime = this.lastSampleState.getTime();
    AppMethodBeat.o(214617);
    return localCMTime;
  }
  
  public CMTime getDuration()
  {
    AppMethodBeat.i(214616);
    Object localObject = CMTime.CMTimeZero;
    Iterator localIterator = this.decoderTrackList.iterator();
    if (localIterator.hasNext())
    {
      CMTime localCMTime = ((IDecoderTrack)localIterator.next()).getDuration();
      if (localCMTime.bigThan((CMTime)localObject)) {
        localObject = localCMTime;
      }
      for (;;)
      {
        break;
      }
    }
    AppMethodBeat.o(214616);
    return localObject;
  }
  
  public CMTime getFrameDuration()
  {
    return this.frameDuration;
  }
  
  public int getFrameRate()
  {
    return this.frameRate;
  }
  
  public VideoCompositionRenderContext getRenderContext()
  {
    return this.renderContext;
  }
  
  public int getTrackId()
  {
    return this.trackId;
  }
  
  public VideoCompositing getVideoCompositing()
  {
    return this.videoCompositing;
  }
  
  public VideoComposition getVideoComposition()
  {
    return this.videoComposition;
  }
  
  public CMSampleBuffer readSample()
  {
    AppMethodBeat.i(214609);
    if ((this.lastSampleState.stateMatchingTo(new long[] { -100L })) || (this.lastSampleState.isInvalid()))
    {
      localCMSampleBuffer = readSample(CMTime.CMTimeZero);
      AppMethodBeat.o(214609);
      return localCMSampleBuffer;
    }
    CMSampleBuffer localCMSampleBuffer = readSample(this.lastSampleState.getTime().add(this.frameDuration));
    AppMethodBeat.o(214609);
    return localCMSampleBuffer;
  }
  
  public CMSampleBuffer readSample(CMTime paramCMTime)
  {
    AppMethodBeat.i(214610);
    Logger.v("VideoComDecoderTrack", "readSample:[targetTime " + paramCMTime + "]" + this.videoCompositing);
    if (this.videoCompositing == null)
    {
      this.lastSampleState = CMSampleState.fromError(-3L);
      Logger.v("VideoComDecoderTrack", "readSample: failed 2 " + this.lastSampleState);
      paramCMTime = new CMSampleBuffer(CMSampleState.fromError(-3L));
      AppMethodBeat.o(214610);
      return paramCMTime;
    }
    Object localObject = paramCMTime;
    if (paramCMTime.getValue() < 0L) {
      localObject = this.lastSampleState.getTime().add(this.frameDuration);
    }
    paramCMTime = createVideoCompositionRequest((CMTime)localObject);
    localObject = readSampleToRequest((CMTime)localObject, paramCMTime);
    if (localObject != null)
    {
      AppMethodBeat.o(214610);
      return localObject;
    }
    if (paramCMTime.getSourceTrackIDs().size() == 0)
    {
      Logger.v("VideoComDecoderTrack", "readSample: finish 2");
      paramCMTime = new CMSampleBuffer(CMSampleState.fromError(-1L));
      AppMethodBeat.o(214610);
      return paramCMTime;
    }
    Logger.v("VideoComDecoderTrack", "readSample: startVideoCompositionRequest ");
    this.videoCompositing.startVideoCompositionRequest(paramCMTime);
    Logger.v("VideoComDecoderTrack", "readSample: startVideoCompositionRequest finish ");
    paramCMTime = getSampleFromRequest(paramCMTime);
    AppMethodBeat.o(214610);
    return paramCMTime;
  }
  
  public void release()
  {
    AppMethodBeat.i(214618);
    Logger.d("VideoComDecoderTrack", "release:start ".concat(String.valueOf(this)));
    Iterator localIterator = this.decoderTrackList.iterator();
    while (localIterator.hasNext()) {
      ((IDecoderTrack)localIterator.next()).release();
    }
    this.decoderTrackList.clear();
    this.assetTrackList.clear();
    this.videoComposition = null;
    this.videoCompositing = null;
    this.renderContext = null;
    Logger.d("VideoComDecoderTrack", "release:finish ".concat(String.valueOf(this)));
    AppMethodBeat.o(214618);
  }
  
  public void removeTrack(AssetTrack paramAssetTrack)
  {
    try
    {
      AppMethodBeat.i(214602);
      this.assetTrackList.remove(paramAssetTrack);
      AppMethodBeat.o(214602);
      return;
    }
    finally
    {
      paramAssetTrack = finally;
      throw paramAssetTrack;
    }
  }
  
  public CMSampleBuffer seekTo(CMTime paramCMTime, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(214608);
    Logger.d("VideoComDecoderTrack", "seekTo:[timeUs " + paramCMTime + "] [needRead " + paramBoolean1 + "] [quickSeek " + paramBoolean2 + "]");
    if (!paramCMTime.equals(this.lastSampleState.getTime()))
    {
      Iterator localIterator = this.decoderTrackList.iterator();
      while (localIterator.hasNext()) {
        ((IDecoderTrack)localIterator.next()).seekTo(paramCMTime, false, paramBoolean2);
      }
    }
    if (paramCMTime.bigThan(this.frameDuration)) {}
    for (this.lastSampleState = new CMSampleState(paramCMTime.sub(this.frameDuration)); paramBoolean1; this.lastSampleState = new CMSampleState(paramCMTime))
    {
      paramCMTime = readSample();
      AppMethodBeat.o(214608);
      return paramCMTime;
    }
    AppMethodBeat.o(214608);
    return null;
  }
  
  public void setDecodeType(IDecoder.DecodeType paramDecodeType) {}
  
  public void setFrameDuration(CMTime paramCMTime)
  {
    this.frameDuration = paramCMTime;
  }
  
  public void setFrameRate(int paramInt)
  {
    AppMethodBeat.i(214606);
    this.frameRate = paramInt;
    Iterator localIterator = this.decoderTrackList.iterator();
    while (localIterator.hasNext()) {
      ((IDecoderTrack)localIterator.next()).setFrameRate(paramInt);
    }
    AppMethodBeat.o(214606);
  }
  
  public void setRenderContext(VideoCompositionRenderContext paramVideoCompositionRenderContext)
  {
    this.renderContext = paramVideoCompositionRenderContext;
  }
  
  public void setTrackSegments(List<DecoderTrackSegment> paramList) {}
  
  public void setVideoCompositing(VideoCompositing paramVideoCompositing)
  {
    this.videoCompositing = paramVideoCompositing;
  }
  
  public void setVideoComposition(VideoComposition paramVideoComposition)
  {
    this.videoComposition = paramVideoComposition;
  }
  
  public void setVolume(float paramFloat) {}
  
  public void start()
  {
    AppMethodBeat.i(214603);
    start(null);
    AppMethodBeat.o(214603);
  }
  
  public void start(IDecoderTrack.SurfaceCreator paramSurfaceCreator)
  {
    AppMethodBeat.i(214604);
    start(paramSurfaceCreator, null);
    AppMethodBeat.o(214604);
  }
  
  public void start(IDecoderTrack.SurfaceCreator paramSurfaceCreator, CMTimeRange paramCMTimeRange)
  {
    AppMethodBeat.i(214605);
    Logger.d("VideoComDecoderTrack", "start:[start] " + paramCMTimeRange + " size - " + this.assetTrackList.size());
    this.renderContext = new VideoCompositionRenderContext((RenderContext)paramSurfaceCreator);
    this.renderContext.setVideoComposition(this.videoComposition);
    Iterator localIterator = this.assetTrackList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (AssetTrack)localIterator.next();
      if (((AssetTrack)localObject).getMediaType() == 1)
      {
        VideoDecoderTrack localVideoDecoderTrack = new VideoDecoderTrack((AssetTrack)localObject);
        this.decoderTrackList.add(localVideoDecoderTrack);
        if (paramCMTimeRange != null) {
          localObject = paramCMTimeRange;
        }
        for (;;)
        {
          localVideoDecoderTrack.start(paramSurfaceCreator, (CMTimeRange)localObject);
          break;
          localObject = ((AssetTrack)localObject).getTimeRange();
          if (localObject == null) {
            localObject = null;
          } else {
            localObject = new CMTimeRange(((CMTimeRange)localObject).getStart(), ((CMTimeRange)localObject).getDuration());
          }
        }
      }
    }
    AppMethodBeat.o(214605);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tav.core.VideoCompositionDecoderTrack
 * JD-Core Version:    0.7.0.1
 */