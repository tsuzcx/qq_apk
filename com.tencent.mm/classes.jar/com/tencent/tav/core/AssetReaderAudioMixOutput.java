package com.tencent.tav.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.asset.AssetTrack;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMSampleState;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.AudioInfo;
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
    AppMethodBeat.i(217807);
    this.decoderStarted = false;
    this.audioTracks = paramArrayList;
    this.audioSettings = paramMap;
    this.audioCompositionDecoderTrack = new AudioCompositionDecoderTrack(paramArrayList, 2);
    AppMethodBeat.o(217807);
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
    AppMethodBeat.i(217808);
    CMSampleBuffer localCMSampleBuffer = this.audioCompositionDecoderTrack.readSample();
    if (localCMSampleBuffer.getTime().smallThan(this.assetReader.getTimeRange().getStart()))
    {
      AppMethodBeat.o(217808);
      return localCMSampleBuffer;
    }
    if (localCMSampleBuffer.getTime().smallThan(this.assetReader.getTimeRange().getEnd()))
    {
      localCMSampleBuffer = new CMSampleBuffer(localCMSampleBuffer.getTime().sub(this.assetReader.getTimeRange().getStart()), localCMSampleBuffer.getSampleByteBuffer(), localCMSampleBuffer.isNewFrame());
      AppMethodBeat.o(217808);
      return localCMSampleBuffer;
    }
    localCMSampleBuffer = new CMSampleBuffer(CMSampleState.fromError(-1L));
    AppMethodBeat.o(217808);
    return localCMSampleBuffer;
  }
  
  void release()
  {
    AppMethodBeat.i(217811);
    if (this.audioCompositionDecoderTrack != null) {
      this.audioCompositionDecoderTrack.release();
    }
    AppMethodBeat.o(217811);
  }
  
  public void resetForReadingTimeRanges(List<CMTimeRange> paramList) {}
  
  public void setAudioInfo(AudioInfo paramAudioInfo)
  {
    AppMethodBeat.i(217809);
    this.audioCompositionDecoderTrack.setAudioInfo(paramAudioInfo);
    AppMethodBeat.o(217809);
  }
  
  public void setAudioMix(AudioMix paramAudioMix)
  {
    AppMethodBeat.i(217812);
    if (this.audioCompositionDecoderTrack != null) {
      this.audioCompositionDecoderTrack.setAudioMix(paramAudioMix);
    }
    AppMethodBeat.o(217812);
  }
  
  void start(IContextCreate paramIContextCreate, AssetReader paramAssetReader)
  {
    AppMethodBeat.i(217810);
    this.assetReader = paramAssetReader;
    if ((this.audioCompositionDecoderTrack != null) && (!this.decoderStarted))
    {
      this.audioCompositionDecoderTrack.start(null);
      this.audioCompositionDecoderTrack.seekTo(paramAssetReader.getTimeRange().getStart(), false, true);
      this.decoderStarted = true;
    }
    AppMethodBeat.o(217810);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tav.core.AssetReaderAudioMixOutput
 * JD-Core Version:    0.7.0.1
 */