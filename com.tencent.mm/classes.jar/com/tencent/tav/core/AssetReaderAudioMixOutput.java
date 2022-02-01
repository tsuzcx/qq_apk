package com.tencent.tav.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.asset.AssetTrack;
import com.tencent.tav.codec.IDecoderFactory;
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
  private AudioCompositionDecoderTrack audioCompositionDecoderTrack;
  private Map<String, Object> audioSettings;
  private ArrayList<AssetTrack> audioTracks;
  private boolean decoderStarted;
  
  public AssetReaderAudioMixOutput(ArrayList<AssetTrack> paramArrayList, Map<String, Object> paramMap, IDecoderFactory paramIDecoderFactory)
  {
    AppMethodBeat.i(215070);
    this.decoderStarted = false;
    this.audioTracks = paramArrayList;
    this.audioSettings = paramMap;
    this.audioCompositionDecoderTrack = new AudioCompositionDecoderTrack(paramArrayList, 2, paramIDecoderFactory);
    AppMethodBeat.o(215070);
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
  
  public CMSampleBuffer nextSampleBuffer(boolean paramBoolean)
  {
    AppMethodBeat.i(215098);
    CMSampleBuffer localCMSampleBuffer = this.audioCompositionDecoderTrack.readSample();
    if (localCMSampleBuffer.getTime().smallThan(this.timeRange.getStart()))
    {
      AppMethodBeat.o(215098);
      return localCMSampleBuffer;
    }
    if (localCMSampleBuffer.getTime().smallThan(this.timeRange.getEnd()))
    {
      localCMSampleBuffer = new CMSampleBuffer(localCMSampleBuffer.getTime().sub(this.timeRange.getStart()), localCMSampleBuffer.getSampleByteBuffer(), localCMSampleBuffer.isNewFrame());
      AppMethodBeat.o(215098);
      return localCMSampleBuffer;
    }
    localCMSampleBuffer = new CMSampleBuffer(CMSampleState.fromError(-1L));
    AppMethodBeat.o(215098);
    return localCMSampleBuffer;
  }
  
  void release()
  {
    AppMethodBeat.i(215141);
    if (this.audioCompositionDecoderTrack != null) {
      this.audioCompositionDecoderTrack.release();
    }
    AppMethodBeat.o(215141);
  }
  
  public void resetForReadingTimeRanges(List<CMTimeRange> paramList) {}
  
  public void setAudioInfo(AudioInfo paramAudioInfo)
  {
    AppMethodBeat.i(215106);
    this.audioCompositionDecoderTrack.setAudioInfo(paramAudioInfo);
    AppMethodBeat.o(215106);
  }
  
  public void setAudioMix(AudioMix paramAudioMix)
  {
    AppMethodBeat.i(215146);
    if (this.audioCompositionDecoderTrack != null) {
      this.audioCompositionDecoderTrack.setAudioMix(paramAudioMix);
    }
    AppMethodBeat.o(215146);
  }
  
  public void start(IContextCreate paramIContextCreate, CMTimeRange paramCMTimeRange)
  {
    AppMethodBeat.i(215131);
    super.start(paramIContextCreate, paramCMTimeRange);
    if ((this.audioCompositionDecoderTrack != null) && (!this.decoderStarted))
    {
      this.audioCompositionDecoderTrack.start(null);
      this.audioCompositionDecoderTrack.seekTo(paramCMTimeRange.getStart(), false, true);
      this.decoderStarted = true;
    }
    AppMethodBeat.o(215131);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tav.core.AssetReaderAudioMixOutput
 * JD-Core Version:    0.7.0.1
 */