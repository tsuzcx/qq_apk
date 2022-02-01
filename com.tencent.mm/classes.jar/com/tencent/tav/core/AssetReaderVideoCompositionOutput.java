package com.tencent.tav.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.asset.AssetTrack;
import com.tencent.tav.core.compositing.VideoCompositing;
import com.tencent.tav.core.composition.VideoComposition;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.IDecoderTrack;
import com.tencent.tav.decoder.IDecoderTrack.SurfaceCreator;
import com.tencent.tav.decoder.VideoDecoder;
import com.tencent.tav.decoder.decodecache.CachedVideoDecoderTrack;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AssetReaderVideoCompositionOutput
  extends AssetReaderOutput
{
  private AssetExtension assetExtension;
  private AssetReader assetReader;
  private IContextCreate contextCreate;
  private VideoCompositing customVideoCompositor;
  private boolean decoderStarted;
  private int frameRate;
  private boolean revertMode;
  private VideoCompositing videoCompositing;
  private VideoComposition videoComposition;
  private IDecoderTrack videoDecoderTrack;
  private Map<String, Object> videoSettings;
  private List<AssetTrack> videoTracks;
  
  public AssetReaderVideoCompositionOutput(List<AssetTrack> paramList, Map<String, Object> paramMap, AssetExtension paramAssetExtension)
  {
    AppMethodBeat.i(197534);
    this.customVideoCompositor = new VideoCompositor();
    this.frameRate = -1;
    this.decoderStarted = false;
    this.revertMode = false;
    this.videoTracks = paramList;
    this.videoSettings = paramMap;
    this.assetExtension = paramAssetExtension;
    this.mediaType = 1;
    if ((paramMap != null) && (paramMap.containsKey("frame-rate"))) {
      this.frameRate = ((Integer)paramMap.get("frame-rate")).intValue();
    }
    AppMethodBeat.o(197534);
  }
  
  private void tryStartDecoder()
  {
    AppMethodBeat.i(197535);
    IDecoderTrack localIDecoderTrack;
    if (!this.decoderStarted)
    {
      this.decoderStarted = true;
      this.videoDecoderTrack.setFrameRate(this.frameRate);
      localIDecoderTrack = this.videoDecoderTrack;
      if (this.contextCreate != null) {
        break label79;
      }
    }
    label79:
    for (Object localObject = null;; localObject = this.contextCreate.renderContext())
    {
      localIDecoderTrack.start((IDecoderTrack.SurfaceCreator)localObject);
      this.videoDecoderTrack.seekTo(this.assetReader.getTimeRange().getStart(), false, true);
      AppMethodBeat.o(197535);
      return;
    }
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
  
  public CMSampleBuffer nextSampleBuffer()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(197536);
        if (this.videoDecoderTrack != null)
        {
          tryStartDecoder();
          if (this.videoDecoderTrack == null)
          {
            localCMSampleBuffer1 = new CMSampleBuffer(VideoDecoder.SAMPLE_TIME_UNSTART);
            if (localCMSampleBuffer1.getTime().smallThan(this.assetReader.getTimeRange().getStart()))
            {
              AppMethodBeat.o(197536);
              return localCMSampleBuffer1;
            }
          }
          else
          {
            localCMSampleBuffer1 = this.videoDecoderTrack.readSample();
            continue;
          }
          if (localCMSampleBuffer1.getTime().smallThan(this.assetReader.getTimeRange().getEnd()))
          {
            this.videoDecoderTrack.asyncReadNextSample(localCMSampleBuffer1.getTime());
            localCMSampleBuffer1 = new CMSampleBuffer(localCMSampleBuffer1.getTime().sub(this.assetReader.getTimeRange().getStart()), localCMSampleBuffer1.getTextureInfo(), localCMSampleBuffer1.isNewFrame());
            AppMethodBeat.o(197536);
            continue;
          }
          CMSampleBuffer localCMSampleBuffer1 = new CMSampleBuffer(VideoDecoder.SAMPLE_TIME_FINISH);
          AppMethodBeat.o(197536);
          continue;
        }
        CMSampleBuffer localCMSampleBuffer2 = new CMSampleBuffer(VideoDecoder.SAMPLE_TIME_UNSTART);
      }
      finally {}
      AppMethodBeat.o(197536);
    }
  }
  
  void release()
  {
    try
    {
      AppMethodBeat.i(197538);
      if (this.videoDecoderTrack != null) {
        this.videoDecoderTrack.release();
      }
      AppMethodBeat.o(197538);
      return;
    }
    finally {}
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
  
  void start(IContextCreate paramIContextCreate, AssetReader paramAssetReader)
  {
    AppMethodBeat.i(197537);
    this.assetReader = paramAssetReader;
    paramAssetReader = new VideoCompositionDecoderTrack(paramAssetReader.getAsset(), this.assetExtension, 1);
    int i = this.frameRate;
    Iterator localIterator = this.videoTracks.iterator();
    if (localIterator.hasNext())
    {
      AssetTrack localAssetTrack = (AssetTrack)localIterator.next();
      if ((localAssetTrack == null) || (!localAssetTrack.isEnabled())) {
        break label202;
      }
      paramAssetReader.addTrack(localAssetTrack);
      if ((localAssetTrack.getNominalFrameRate() <= 0.0F) || (this.frameRate >= 0)) {
        break label202;
      }
      i = (int)Math.min(localAssetTrack.getNominalFrameRate(), i);
    }
    label202:
    for (;;)
    {
      break;
      if (i > 0) {}
      for (;;)
      {
        paramAssetReader.setVideoComposition(this.videoComposition);
        paramAssetReader.setVideoCompositing(this.videoCompositing);
        paramAssetReader.setFrameRate(i);
        paramAssetReader.setFrameDuration(new CMTime(1L, i));
        this.contextCreate = paramIContextCreate;
        if (!this.revertMode) {
          break;
        }
        this.videoDecoderTrack = new CachedVideoDecoderTrack(paramAssetReader, true);
        AppMethodBeat.o(197537);
        return;
        i = 30;
      }
      this.videoDecoderTrack = paramAssetReader;
      AppMethodBeat.o(197537);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tav.core.AssetReaderVideoCompositionOutput
 * JD-Core Version:    0.7.0.1
 */