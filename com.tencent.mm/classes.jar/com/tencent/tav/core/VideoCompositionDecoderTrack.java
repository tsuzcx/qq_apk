package com.tencent.tav.core;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.asset.Asset;
import com.tencent.tav.asset.AssetTrack;
import com.tencent.tav.asset.AssetTrackSegment;
import com.tencent.tav.asset.CompositionTrackSegment;
import com.tencent.tav.core.compositing.AsynchronousVideoCompositionRequest;
import com.tencent.tav.core.compositing.VideoCompositing;
import com.tencent.tav.core.compositing.VideoCompositionRenderContext;
import com.tencent.tav.core.composition.VideoComposition;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeMapping;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.DecoderAssetTrack;
import com.tencent.tav.decoder.DecoderTrackSegment;
import com.tencent.tav.decoder.IDecoder;
import com.tencent.tav.decoder.IDecoder.DecodeType;
import com.tencent.tav.decoder.IDecoderTrack;
import com.tencent.tav.decoder.IDecoderTrack.SurfaceCreator;
import com.tencent.tav.decoder.RenderContext;
import com.tencent.tav.decoder.VideoDecoderTrack;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tav.extractor.AssetExtractor;
import com.tencent.tav.extractor.ExtractorUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class VideoCompositionDecoderTrack
  implements IDecoderTrack
{
  public static boolean LOG_VERBOSE = false;
  private static final String TAG = "VideoComDecoderTrack";
  private static final int WAIT_TIME = 200;
  private Asset asset;
  private AssetExtension assetExtension;
  List<AssetTrack> assetTrackList;
  private boolean asynced;
  private IDecoder.DecodeType decodeType;
  List<IDecoderTrack> decoderTrackList;
  private CMTime frameDuration;
  private int frameRate;
  private CMTime lastSampleTime;
  private VideoCompositionRenderContext renderContext;
  private int trackId;
  private VideoCompositing videoCompositing;
  private VideoComposition videoComposition;
  private float volume;
  
  public VideoCompositionDecoderTrack(Asset paramAsset, AssetExtension paramAssetExtension, int paramInt)
  {
    AppMethodBeat.i(201581);
    this.decoderTrackList = new ArrayList();
    this.assetTrackList = new ArrayList();
    this.decodeType = IDecoder.DecodeType.Video;
    this.asynced = true;
    this.frameRate = 30;
    this.volume = 1.0F;
    this.frameDuration = new CMTime(1L, 30);
    this.lastSampleTime = CMTime.CMTimeInvalid;
    this.asset = paramAsset;
    this.assetExtension = paramAssetExtension;
    this.trackId = paramInt;
    AppMethodBeat.o(201581);
  }
  
  private DecoderTrackSegment createDecoderTrackSegment(AssetTrack paramAssetTrack, AssetTrackSegment paramAssetTrackSegment)
  {
    AppMethodBeat.i(201587);
    DecoderAssetTrack localDecoderAssetTrack = null;
    if (!paramAssetTrackSegment.isEmpty())
    {
      localDecoderAssetTrack = new DecoderAssetTrack();
      localDecoderAssetTrack.assetPath = paramAssetTrack.getSourcePath();
      localDecoderAssetTrack.trackId = paramAssetTrack.getTrackID();
      localDecoderAssetTrack.mediaType = paramAssetTrack.getMediaType();
      if ((paramAssetTrackSegment instanceof CompositionTrackSegment)) {
        localDecoderAssetTrack.sourceType = ((CompositionTrackSegment)paramAssetTrackSegment).getSourceType();
      }
      localDecoderAssetTrack.size = paramAssetTrack.getNaturalSize();
      localDecoderAssetTrack.preferredTransform = paramAssetTrack.getPreferredTransform();
      localDecoderAssetTrack.preferredVolume = paramAssetTrack.getPreferredVolume();
      localDecoderAssetTrack.preferRotation = paramAssetTrack.getPreferredRotation();
      localDecoderAssetTrack.frameRate = ((int)paramAssetTrack.getNominalFrameRate());
    }
    paramAssetTrack = paramAssetTrackSegment.getTimeMapping().getSource();
    paramAssetTrack = new DecoderTrackSegment(new CMTimeRange(paramAssetTrack.getStart(), paramAssetTrack.getDuration()), localDecoderAssetTrack);
    paramAssetTrack.setScaledDuration(paramAssetTrackSegment.getScaleDuration());
    AppMethodBeat.o(201587);
    return paramAssetTrack;
  }
  
  private DecoderTrackSegment createDecoderTrackSegment(AssetTrack paramAssetTrack, CompositionTrackSegment paramCompositionTrackSegment)
  {
    AppMethodBeat.i(201588);
    DecoderAssetTrack localDecoderAssetTrack = null;
    if (!paramCompositionTrackSegment.isEmpty())
    {
      localDecoderAssetTrack = new DecoderAssetTrack();
      localDecoderAssetTrack.assetPath = paramCompositionTrackSegment.getSourcePath();
      localDecoderAssetTrack.trackId = paramCompositionTrackSegment.getSourceTrackID();
      localDecoderAssetTrack.mediaType = paramAssetTrack.getMediaType();
      if (!TextUtils.isEmpty(paramCompositionTrackSegment.getSourcePath()))
      {
        AssetExtractor localAssetExtractor = new AssetExtractor();
        localAssetExtractor.setDataSource(paramCompositionTrackSegment.getSourcePath());
        localDecoderAssetTrack.size = ExtractorUtils.getVideoSize(localAssetExtractor);
        localDecoderAssetTrack.preferRotation = localAssetExtractor.getPreferRotation();
        localDecoderAssetTrack.preferredTransform = paramAssetTrack.getPreferredTransform();
        localDecoderAssetTrack.sourceType = paramCompositionTrackSegment.getSourceType();
      }
      localDecoderAssetTrack.preferredVolume = 1.0F;
      localDecoderAssetTrack.frameRate = 30;
    }
    paramAssetTrack = paramCompositionTrackSegment.getTimeMapping().getSource();
    paramAssetTrack = new DecoderTrackSegment(new CMTimeRange(paramAssetTrack.getStart(), paramAssetTrack.getDuration()), localDecoderAssetTrack);
    paramAssetTrack.setScaledDuration(paramCompositionTrackSegment.getScaleDuration());
    AppMethodBeat.o(201588);
    return paramAssetTrack;
  }
  
  private AsynchronousVideoCompositionRequest createVideoCompositionRequest(CMTime paramCMTime)
  {
    AppMethodBeat.i(201595);
    AsynchronousVideoCompositionRequest localAsynchronousVideoCompositionRequest = new AsynchronousVideoCompositionRequest(this, this.assetExtension);
    localAsynchronousVideoCompositionRequest.setRenderContext(this.renderContext);
    localAsynchronousVideoCompositionRequest.setCompositionTime(paramCMTime);
    if (this.videoComposition != null) {
      localAsynchronousVideoCompositionRequest.setVideoCompositionInstruction(VideoComposition.findInstruction(this.videoComposition, paramCMTime));
    }
    AppMethodBeat.o(201595);
    return localAsynchronousVideoCompositionRequest;
  }
  
  private CMSampleBuffer getSampleFromRequest(AsynchronousVideoCompositionRequest paramAsynchronousVideoCompositionRequest)
  {
    AppMethodBeat.i(201597);
    try
    {
      if (paramAsynchronousVideoCompositionRequest.getStatus() == -2147483648) {
        waitForRequestFinish(200);
      }
      switch (paramAsynchronousVideoCompositionRequest.getStatus())
      {
      default: 
        this.lastSampleTime = IDecoder.SAMPLE_TIME_ERROR;
        if (LOG_VERBOSE) {
          Logger.e("VideoComDecoderTrack", "readSample: failed 1 " + this.lastSampleTime);
        }
        paramAsynchronousVideoCompositionRequest = new CMSampleBuffer(IDecoder.SAMPLE_TIME_ERROR);
        AppMethodBeat.o(201597);
        return paramAsynchronousVideoCompositionRequest;
      }
    }
    finally
    {
      AppMethodBeat.o(201597);
    }
    this.lastSampleTime = paramAsynchronousVideoCompositionRequest.getComposedSampleBuffer().getTime();
    paramAsynchronousVideoCompositionRequest = paramAsynchronousVideoCompositionRequest.getComposedSampleBuffer();
    AppMethodBeat.o(201597);
    return paramAsynchronousVideoCompositionRequest;
  }
  
  private CMSampleBuffer readSampleToRequest(CMTime paramCMTime, AsynchronousVideoCompositionRequest paramAsynchronousVideoCompositionRequest)
  {
    AppMethodBeat.i(201596);
    Iterator localIterator = this.decoderTrackList.iterator();
    while (localIterator.hasNext())
    {
      IDecoderTrack localIDecoderTrack = (IDecoderTrack)localIterator.next();
      CMSampleBuffer localCMSampleBuffer = localIDecoderTrack.readSample(paramCMTime);
      if ((localCMSampleBuffer.getTime().equalsTo(IDecoder.SAMPLE_TIME_ERROR)) || (localCMSampleBuffer.getTime().equalsTo(IDecoder.SAMPLE_TIME_FAILED)) || (localCMSampleBuffer.getTime().equalsTo(IDecoder.SAMPLE_TIME_UNSTART)))
      {
        this.lastSampleTime = localCMSampleBuffer.getTime();
        Logger.e("VideoComDecoderTrack", "readSample: failed 0 " + localCMSampleBuffer.getTime());
        paramCMTime = new CMSampleBuffer(localCMSampleBuffer.getTime(), null);
        AppMethodBeat.o(201596);
        return paramCMTime;
      }
      if (localCMSampleBuffer.getTime().equalsTo(IDecoder.SAMPLE_TIME_FINISH))
      {
        if (this.decoderTrackList.size() <= 1)
        {
          Logger.d("VideoComDecoderTrack", "readSample: finish 1");
          AppMethodBeat.o(201596);
          return localCMSampleBuffer;
        }
      }
      else {
        paramAsynchronousVideoCompositionRequest.appendCMSampleBuffer(localCMSampleBuffer, localIDecoderTrack.getTrackId());
      }
    }
    AppMethodBeat.o(201596);
    return null;
  }
  
  /* Error */
  private void waitForRequestFinish(int paramInt)
  {
    // Byte code:
    //   0: ldc_w 366
    //   3: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: monitorenter
    //   8: iload_1
    //   9: i2l
    //   10: lstore_2
    //   11: aload_0
    //   12: lload_2
    //   13: invokevirtual 370	java/lang/Object:wait	(J)V
    //   16: aload_0
    //   17: monitorexit
    //   18: ldc_w 366
    //   21: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: return
    //   25: astore 4
    //   27: aload_0
    //   28: monitorexit
    //   29: ldc_w 366
    //   32: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   35: aload 4
    //   37: athrow
    //   38: astore 4
    //   40: goto -24 -> 16
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	43	0	this	VideoCompositionDecoderTrack
    //   0	43	1	paramInt	int
    //   10	3	2	l	long
    //   25	11	4	localObject	Object
    //   38	1	4	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   11	16	25	finally
    //   16	18	25	finally
    //   27	29	25	finally
    //   11	16	38	java/lang/Exception
  }
  
  public void addTrack(AssetTrack paramAssetTrack)
  {
    try
    {
      AppMethodBeat.i(201582);
      this.assetTrackList.add(paramAssetTrack);
      AppMethodBeat.o(201582);
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
    AppMethodBeat.i(201599);
    if (!this.asynced)
    {
      AppMethodBeat.o(201599);
      return;
    }
    Iterator localIterator = this.decoderTrackList.iterator();
    while (localIterator.hasNext()) {
      ((IDecoderTrack)localIterator.next()).asyncReadNextSample(paramCMTime);
    }
    AppMethodBeat.o(201599);
  }
  
  public void clipRangeAndClearRange(CMTimeRange paramCMTimeRange)
  {
    AppMethodBeat.i(201591);
    Iterator localIterator = this.decoderTrackList.iterator();
    while (localIterator.hasNext()) {
      ((IDecoderTrack)localIterator.next()).clipRangeAndClearRange(paramCMTimeRange);
    }
    AppMethodBeat.o(201591);
  }
  
  public Asset getAsset()
  {
    return this.asset;
  }
  
  public CMTime getCurrentSampleTime()
  {
    return this.lastSampleTime;
  }
  
  public CMTime getDuration()
  {
    AppMethodBeat.i(201600);
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
    AppMethodBeat.o(201600);
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
  
  public CGSize getMaxRenderSize()
  {
    AppMethodBeat.i(201602);
    Object localObject = new CGSize(1.0F, 1.0F);
    Iterator localIterator = this.decoderTrackList.iterator();
    CGSize localCGSize;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localCGSize = ((IDecoderTrack)localIterator.next()).getMaxRenderSize();
      if (localCGSize == null) {
        break label92;
      }
    } while (((CGSize)localObject).width * ((CGSize)localObject).height > localCGSize.width * localCGSize.height);
    label92:
    for (;;)
    {
      localObject = localCGSize;
      continue;
      AppMethodBeat.o(201602);
      return localObject;
    }
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
  
  public boolean hasNewSample(CMTime paramCMTime)
  {
    return false;
  }
  
  public CMSampleBuffer readSample()
  {
    AppMethodBeat.i(201593);
    if ((this.lastSampleTime == IDecoder.SAMPLE_TIME_UNSTART) || (this.lastSampleTime == CMTime.CMTimeInvalid))
    {
      localCMSampleBuffer = readSample(CMTime.CMTimeZero);
      AppMethodBeat.o(201593);
      return localCMSampleBuffer;
    }
    CMSampleBuffer localCMSampleBuffer = readSample(this.lastSampleTime.add(this.frameDuration));
    AppMethodBeat.o(201593);
    return localCMSampleBuffer;
  }
  
  public CMSampleBuffer readSample(CMTime paramCMTime)
  {
    AppMethodBeat.i(201594);
    if (LOG_VERBOSE) {
      Logger.d("VideoComDecoderTrack", "readSample:[targetTime " + paramCMTime + "]" + this.videoCompositing);
    }
    if (this.videoCompositing == null)
    {
      this.lastSampleTime = IDecoder.SAMPLE_TIME_ERROR;
      if (LOG_VERBOSE) {
        Logger.e("VideoComDecoderTrack", "readSample: failed 2 " + this.lastSampleTime);
      }
      paramCMTime = new CMSampleBuffer(IDecoder.SAMPLE_TIME_ERROR);
      AppMethodBeat.o(201594);
      return paramCMTime;
    }
    Object localObject = paramCMTime;
    if (paramCMTime.getValue() < 0L) {
      localObject = this.lastSampleTime.add(this.frameDuration);
    }
    paramCMTime = createVideoCompositionRequest((CMTime)localObject);
    localObject = readSampleToRequest((CMTime)localObject, paramCMTime);
    if (localObject != null)
    {
      AppMethodBeat.o(201594);
      return localObject;
    }
    if (paramCMTime.getSourceTrackIDs().size() == 0)
    {
      if (LOG_VERBOSE) {
        Logger.d("VideoComDecoderTrack", "readSample: finish 2");
      }
      paramCMTime = new CMSampleBuffer(IDecoder.SAMPLE_TIME_FINISH);
      AppMethodBeat.o(201594);
      return paramCMTime;
    }
    if (LOG_VERBOSE) {
      Logger.e("VideoComDecoderTrack", "readSample: startVideoCompositionRequest ");
    }
    this.videoCompositing.startVideoCompositionRequest(paramCMTime);
    if (LOG_VERBOSE) {
      Logger.e("VideoComDecoderTrack", "readSample: startVideoCompositionRequest finish ");
    }
    paramCMTime = getSampleFromRequest(paramCMTime);
    AppMethodBeat.o(201594);
    return paramCMTime;
  }
  
  public void release()
  {
    AppMethodBeat.i(201601);
    Logger.e("VideoComDecoderTrack", "release:start ".concat(String.valueOf(this)));
    Iterator localIterator = this.decoderTrackList.iterator();
    while (localIterator.hasNext()) {
      ((IDecoderTrack)localIterator.next()).release();
    }
    this.decoderTrackList.clear();
    this.assetTrackList.clear();
    this.videoComposition = null;
    this.videoCompositing = null;
    this.renderContext = null;
    Logger.e("VideoComDecoderTrack", "release:finish ".concat(String.valueOf(this)));
    AppMethodBeat.o(201601);
  }
  
  public void removeTrack(AssetTrack paramAssetTrack)
  {
    try
    {
      AppMethodBeat.i(201583);
      this.assetTrackList.remove(paramAssetTrack);
      AppMethodBeat.o(201583);
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
    AppMethodBeat.i(201592);
    Logger.d("VideoComDecoderTrack", "seekTo:[timeUs " + paramCMTime + "] [needRead " + paramBoolean1 + "] [quickSeek " + paramBoolean2 + "]");
    if (!paramCMTime.equalsTo(this.lastSampleTime))
    {
      Iterator localIterator = this.decoderTrackList.iterator();
      while (localIterator.hasNext()) {
        ((IDecoderTrack)localIterator.next()).seekTo(paramCMTime, false, paramBoolean2);
      }
    }
    if (paramCMTime.bigThan(this.frameDuration)) {}
    for (this.lastSampleTime = paramCMTime.sub(this.frameDuration); paramBoolean1; this.lastSampleTime = paramCMTime)
    {
      paramCMTime = readSample();
      AppMethodBeat.o(201592);
      return paramCMTime;
    }
    AppMethodBeat.o(201592);
    return null;
  }
  
  public void setDecodeType(IDecoder.DecodeType paramDecodeType) {}
  
  public void setFrameDuration(CMTime paramCMTime)
  {
    this.frameDuration = paramCMTime;
  }
  
  public void setFrameRate(int paramInt)
  {
    AppMethodBeat.i(201589);
    this.frameRate = paramInt;
    Iterator localIterator = this.decoderTrackList.iterator();
    while (localIterator.hasNext()) {
      ((IDecoderTrack)localIterator.next()).setFrameRate(paramInt);
    }
    AppMethodBeat.o(201589);
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
  
  public void setVolume(float paramFloat)
  {
    AppMethodBeat.i(201590);
    Iterator localIterator = this.decoderTrackList.iterator();
    while (localIterator.hasNext()) {
      ((IDecoderTrack)localIterator.next()).setVolume(paramFloat);
    }
    this.volume = paramFloat;
    AppMethodBeat.o(201590);
  }
  
  public void start()
  {
    AppMethodBeat.i(201584);
    start(null);
    AppMethodBeat.o(201584);
  }
  
  public void start(IDecoderTrack.SurfaceCreator paramSurfaceCreator)
  {
    AppMethodBeat.i(201585);
    start(paramSurfaceCreator, null);
    AppMethodBeat.o(201585);
  }
  
  public void start(IDecoderTrack.SurfaceCreator paramSurfaceCreator, CMTimeRange paramCMTimeRange)
  {
    AppMethodBeat.i(201586);
    Logger.d("VideoComDecoderTrack", "start:[start] " + paramCMTimeRange + " size - " + this.assetTrackList.size());
    this.renderContext = new VideoCompositionRenderContext((RenderContext)paramSurfaceCreator);
    this.renderContext.setVideoComposition(this.videoComposition);
    Iterator localIterator = this.assetTrackList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (AssetTrack)localIterator.next();
      if (((AssetTrack)localObject1).getMediaType() == 1)
      {
        VideoDecoderTrack localVideoDecoderTrack = new VideoDecoderTrack(((AssetTrack)localObject1).getTrackID());
        Object localObject2 = ((AssetTrack)localObject1).getSegments();
        ArrayList localArrayList = new ArrayList();
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          AssetTrackSegment localAssetTrackSegment = (AssetTrackSegment)((Iterator)localObject2).next();
          if ((localAssetTrackSegment instanceof CompositionTrackSegment)) {
            localArrayList.add(createDecoderTrackSegment((AssetTrack)localObject1, (CompositionTrackSegment)localAssetTrackSegment));
          } else {
            localArrayList.add(createDecoderTrackSegment((AssetTrack)localObject1, localAssetTrackSegment));
          }
        }
        localVideoDecoderTrack.setTrackSegments(localArrayList);
        int i;
        if (getFrameRate() > 0)
        {
          i = getFrameRate();
          label245:
          localVideoDecoderTrack.setFrameRate(i);
          localVideoDecoderTrack.setVolume(((AssetTrack)localObject1).getPreferredVolume());
          localVideoDecoderTrack.setDecodeType(IDecoder.DecodeType.Video);
          if (((AssetTrack)localObject1).getTimeRange() != null) {
            localVideoDecoderTrack.clipRangeAndClearRange(new CMTimeRange(((AssetTrack)localObject1).getTimeRange().getStart(), ((AssetTrack)localObject1).getTimeRange().getDuration()));
          }
          if (paramCMTimeRange == null) {
            break label355;
          }
          localObject1 = paramCMTimeRange;
        }
        for (;;)
        {
          localVideoDecoderTrack.start(paramSurfaceCreator, (CMTimeRange)localObject1);
          this.decoderTrackList.add(localVideoDecoderTrack);
          break;
          i = (int)((AssetTrack)localObject1).getNominalFrameRate();
          break label245;
          label355:
          localObject1 = ((AssetTrack)localObject1).getTimeRange();
          if (localObject1 == null) {
            localObject1 = null;
          } else {
            localObject1 = new CMTimeRange(((CMTimeRange)localObject1).getStart(), ((CMTimeRange)localObject1).getDuration());
          }
        }
      }
    }
    AppMethodBeat.o(201586);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tav.core.VideoCompositionDecoderTrack
 * JD-Core Version:    0.7.0.1
 */