package com.tencent.tav.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.asset.AssetTrack;
import com.tencent.tav.codec.IDecoderFactory;
import com.tencent.tav.core.compositing.VideoCompositing;
import com.tencent.tav.core.composition.VideoComposition;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMSampleState;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.IDecoderTrack;
import com.tencent.tav.decoder.IDecoderTrack.SurfaceCreator;
import com.tencent.tav.decoder.decodecache.CachedVideoDecoderTrack;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tav.report.AverageTimeReporter;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AssetReaderVideoCompositionOutput
  extends AssetReaderOutput
{
  public static final String TAG = "AssetReaderVideoCompositionOutput";
  private AssetExtension assetExtension;
  private IContextCreate contextCreate;
  private VideoCompositing customVideoCompositor;
  private IDecoderFactory decoderFactory;
  private boolean decoderStarted;
  private int frameRate;
  private boolean readFirstFrame;
  private boolean revertMode;
  private VideoCompositing videoCompositing;
  private VideoComposition videoComposition;
  private IDecoderTrack videoDecoderTrack;
  private Map<String, Object> videoSettings;
  private List<AssetTrack> videoTracks;
  
  public AssetReaderVideoCompositionOutput(List<AssetTrack> paramList, Map<String, Object> paramMap, AssetExtension paramAssetExtension, IDecoderFactory paramIDecoderFactory)
  {
    AppMethodBeat.i(215103);
    this.customVideoCompositor = new VideoCompositor();
    this.frameRate = -1;
    this.decoderStarted = false;
    this.readFirstFrame = false;
    this.revertMode = false;
    this.videoTracks = paramList;
    this.videoSettings = paramMap;
    this.assetExtension = paramAssetExtension;
    this.mediaType = 1;
    if ((paramMap != null) && (paramMap.containsKey("frame-rate"))) {
      this.frameRate = ((Integer)paramMap.get("frame-rate")).intValue();
    }
    this.decoderFactory = paramIDecoderFactory;
    AppMethodBeat.o(215103);
  }
  
  private void tryStartDecoder()
  {
    AppMethodBeat.i(215117);
    IDecoderTrack localIDecoderTrack;
    if (!this.decoderStarted)
    {
      this.decoderStarted = true;
      this.videoDecoderTrack.setFrameRate(this.frameRate);
      localIDecoderTrack = this.videoDecoderTrack;
      if (this.contextCreate != null) {
        break label76;
      }
    }
    label76:
    for (Object localObject = null;; localObject = this.contextCreate.renderContext())
    {
      localIDecoderTrack.start((IDecoderTrack.SurfaceCreator)localObject);
      this.videoDecoderTrack.seekTo(this.timeRange.getStart(), false, true);
      AppMethodBeat.o(215117);
      return;
    }
  }
  
  public AverageTimeReporter getDecodePerformance()
  {
    AppMethodBeat.i(215288);
    if (this.videoDecoderTrack != null)
    {
      AverageTimeReporter localAverageTimeReporter = this.videoDecoderTrack.getDecodePerformance();
      AppMethodBeat.o(215288);
      return localAverageTimeReporter;
    }
    AppMethodBeat.o(215288);
    return null;
  }
  
  public VideoCompositing getVideoCompositing()
  {
    return this.videoCompositing;
  }
  
  public VideoComposition getVideoComposition()
  {
    return this.videoComposition;
  }
  
  public Map<String, Object> getVideoSettings()
  {
    return this.videoSettings;
  }
  
  public List<AssetTrack> getVideoTracks()
  {
    return this.videoTracks;
  }
  
  public void markConfigurationAsFinal() {}
  
  public CMSampleBuffer nextSampleBuffer(boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(215211);
        if (this.videoDecoderTrack == null) {
          break label225;
        }
        tryStartDecoder();
        CMSampleBuffer localCMSampleBuffer1;
        if (this.videoDecoderTrack == null)
        {
          localCMSampleBuffer1 = new CMSampleBuffer(CMSampleState.fromError(-100L));
          if (localCMSampleBuffer1.getTime().smallThan(this.timeRange.getStart()))
          {
            AppMethodBeat.o(215211);
            return localCMSampleBuffer1;
          }
        }
        else
        {
          if (this.readFirstFrame)
          {
            localCMSampleBuffer1 = this.videoDecoderTrack.readSample();
            continue;
          }
          localCMSampleBuffer1 = this.videoDecoderTrack.readSample(this.timeRange.getStart());
          this.readFirstFrame = true;
          continue;
        }
        if (!localObject1.getTime().smallThan(this.timeRange.getEnd())) {
          break label203;
        }
      }
      finally {}
      if (paramBoolean) {
        this.videoDecoderTrack.asyncReadNextSample(localObject1.getTime());
      }
      CMSampleBuffer localCMSampleBuffer2 = new CMSampleBuffer(localObject1.getTime().sub(this.timeRange.getStart()), localObject1.getTextureInfo(), localObject1.isNewFrame());
      localCMSampleBuffer2.getState().performance = localObject1.getState().performance;
      AppMethodBeat.o(215211);
      Object localObject2 = localCMSampleBuffer2;
      continue;
      label203:
      localObject2 = new CMSampleBuffer(CMSampleState.fromError(-1L));
      AppMethodBeat.o(215211);
      continue;
      label225:
      localObject2 = new CMSampleBuffer(CMSampleState.fromError(-100L));
      AppMethodBeat.o(215211);
    }
  }
  
  void release()
  {
    try
    {
      AppMethodBeat.i(215264);
      if (this.videoDecoderTrack != null) {
        this.videoDecoderTrack.release();
      }
      if (this.videoCompositing != null)
      {
        this.videoCompositing.release();
        this.videoCompositing = null;
      }
      AppMethodBeat.o(215264);
      return;
    }
    finally {}
  }
  
  public void reset(CMTimeRange paramCMTimeRange)
  {
    AppMethodBeat.i(215254);
    Logger.i("AssetReaderVideoCompositionOutput", "reset %s", new Object[] { paramCMTimeRange });
    this.timeRange = paramCMTimeRange;
    this.videoDecoderTrack.seekTo(this.timeRange.getStart(), false, true);
    AppMethodBeat.o(215254);
  }
  
  public void resetForReadingTimeRanges(List<CMTimeRange> paramList) {}
  
  public void setVideoCompositing(VideoCompositing paramVideoCompositing)
  {
    this.videoCompositing = paramVideoCompositing;
  }
  
  public void setVideoComposition(VideoComposition paramVideoComposition)
  {
    this.videoComposition = paramVideoComposition;
  }
  
  public void setVideoRevertMode(boolean paramBoolean)
  {
    this.revertMode = paramBoolean;
  }
  
  public void start(IContextCreate paramIContextCreate, CMTimeRange paramCMTimeRange)
  {
    AppMethodBeat.i(215245);
    super.start(paramIContextCreate, paramCMTimeRange);
    paramCMTimeRange = new VideoCompositionDecoderTrack(this.assetExtension, 1, this.decoderFactory);
    int i = this.frameRate;
    Iterator localIterator = this.videoTracks.iterator();
    if (localIterator.hasNext())
    {
      AssetTrack localAssetTrack = (AssetTrack)localIterator.next();
      if ((localAssetTrack == null) || (!localAssetTrack.isEnabled())) {
        break label203;
      }
      paramCMTimeRange.addTrack(localAssetTrack);
      if ((localAssetTrack.getNominalFrameRate() <= 0.0F) || (this.frameRate >= 0)) {
        break label203;
      }
      i = (int)Math.min(localAssetTrack.getNominalFrameRate(), i);
    }
    label203:
    for (;;)
    {
      break;
      if (i > 0) {}
      for (;;)
      {
        paramCMTimeRange.setVideoComposition(this.videoComposition);
        paramCMTimeRange.setVideoCompositing(this.videoCompositing);
        paramCMTimeRange.setFrameRate(i);
        paramCMTimeRange.setFrameDuration(new CMTime(1L, i));
        this.contextCreate = paramIContextCreate;
        if (!this.revertMode) {
          break;
        }
        this.videoDecoderTrack = new CachedVideoDecoderTrack(paramCMTimeRange, true);
        AppMethodBeat.o(215245);
        return;
        i = 30;
      }
      this.videoDecoderTrack = paramCMTimeRange;
      AppMethodBeat.o(215245);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tav.core.AssetReaderVideoCompositionOutput
 * JD-Core Version:    0.7.0.1
 */