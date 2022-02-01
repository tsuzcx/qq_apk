package com.tencent.tav.core.audio;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.asset.Asset;
import com.tencent.tav.core.AudioCompositionDecoderTrack;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.AudioInfo;
import com.tencent.tav.decoder.IDecoder.DecodeType;

public class AudioSourceComposition
  implements IAudioSource<AudioCompositionDecoderTrack>
{
  private Asset mAsset;
  private AudioInfo mAudioInfo;
  
  public AudioSourceComposition(Asset paramAsset)
  {
    AppMethodBeat.i(217996);
    this.mAudioInfo = new AudioInfo(44100, 1, 2);
    this.mAsset = paramAsset;
    AppMethodBeat.o(217996);
  }
  
  public CMTime getDuration()
  {
    AppMethodBeat.i(217998);
    CMTime localCMTime = this.mAsset.getDuration();
    AppMethodBeat.o(217998);
    return localCMTime;
  }
  
  public AudioCompositionDecoderTrack getSourceAudioDecoder(CMTimeRange paramCMTimeRange)
  {
    AppMethodBeat.i(217997);
    paramCMTimeRange = new AudioCompositionDecoderTrack(this.mAsset.getTracks(), -1);
    paramCMTimeRange.setAudioInfo(this.mAudioInfo);
    paramCMTimeRange.setDecodeType(IDecoder.DecodeType.Audio);
    paramCMTimeRange.setFrameRate(44);
    AppMethodBeat.o(217997);
    return paramCMTimeRange;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tav.core.audio.AudioSourceComposition
 * JD-Core Version:    0.7.0.1
 */