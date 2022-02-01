package com.tencent.tav.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.asset.AssetTrack;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.AudioInfo;
import com.tencent.tav.decoder.VideoDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AssetReaderAudioMixOutput
  extends AssetReaderOutput
{
  public static final String TAG = "AssetReaderAudioMixOutput";
  private AssetReader assetReader;
  private AudioCompositionDecoderTrack audioCompositionDecoderTrack;
  private Map<String, Object> audioSettings;
  private ArrayList<AssetTrack> audioTracks;
  private boolean decoderStarted;
  
  public AssetReaderAudioMixOutput(ArrayList<AssetTrack> paramArrayList, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(197528);
    this.decoderStarted = false;
    this.audioTracks = paramArrayList;
    this.audioSettings = paramMap;
    this.audioCompositionDecoderTrack = new AudioCompositionDecoderTrack(paramArrayList, 2);
    AppMethodBeat.o(197528);
  }
  
  public Map<String, Object> getAudioSettings()
  {
    return this.audioSettings;
  }
  
  public ArrayList<AssetTrack> getAudioTracks()
  {
    return this.audioTracks;
  }
  
  public void markConfigurationAsFinal() {}
  
  public CMSampleBuffer nextSampleBuffer()
  {
    AppMethodBeat.i(197529);
    CMSampleBuffer localCMSampleBuffer = this.audioCompositionDecoderTrack.readSample();
    if (localCMSampleBuffer.getTime().smallThan(this.assetReader.getTimeRange().getStart()))
    {
      AppMethodBeat.o(197529);
      return localCMSampleBuffer;
    }
    if (localCMSampleBuffer.getTime().smallThan(this.assetReader.getTimeRange().getEnd()))
    {
      localCMSampleBuffer = new CMSampleBuffer(localCMSampleBuffer.getTime().sub(this.assetReader.getTimeRange().getStart()), localCMSampleBuffer.getSampleByteBuffer(), localCMSampleBuffer.isNewFrame());
      AppMethodBeat.o(197529);
      return localCMSampleBuffer;
    }
    localCMSampleBuffer = new CMSampleBuffer(VideoDecoder.SAMPLE_TIME_FINISH);
    AppMethodBeat.o(197529);
    return localCMSampleBuffer;
  }
  
  void release()
  {
    AppMethodBeat.i(197532);
    if (this.audioCompositionDecoderTrack != null) {
      this.audioCompositionDecoderTrack.release();
    }
    AppMethodBeat.o(197532);
  }
  
  public void resetForReadingTimeRanges(List<CMTimeRange> paramList) {}
  
  public void setAudioInfo(AudioInfo paramAudioInfo)
  {
    AppMethodBeat.i(197530);
    this.audioCompositionDecoderTrack.setAudioInfo(paramAudioInfo);
    AppMethodBeat.o(197530);
  }
  
  public void setAudioMix(AudioMix paramAudioMix)
  {
    AppMethodBeat.i(197533);
    if (this.audioCompositionDecoderTrack != null) {
      this.audioCompositionDecoderTrack.setAudioMix(paramAudioMix);
    }
    AppMethodBeat.o(197533);
  }
  
  void start(IContextCreate paramIContextCreate, AssetReader paramAssetReader)
  {
    AppMethodBeat.i(197531);
    this.assetReader = paramAssetReader;
    if ((this.audioCompositionDecoderTrack != null) && (!this.decoderStarted))
    {
      this.audioCompositionDecoderTrack.start(null);
      this.audioCompositionDecoderTrack.seekTo(paramAssetReader.getTimeRange().getStart(), false, true);
      this.decoderStarted = true;
    }
    AppMethodBeat.o(197531);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tav.core.AssetReaderAudioMixOutput
 * JD-Core Version:    0.7.0.1
 */