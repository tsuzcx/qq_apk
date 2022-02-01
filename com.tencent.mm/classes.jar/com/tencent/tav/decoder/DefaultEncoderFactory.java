package com.tencent.tav.decoder;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class DefaultEncoderFactory
  implements IEncoderFactory
{
  public AssetWriterAudioEncoder getAudioEncoder()
  {
    AppMethodBeat.i(215982);
    MediaCodecAudioEncoder localMediaCodecAudioEncoder = new MediaCodecAudioEncoder();
    AppMethodBeat.o(215982);
    return localMediaCodecAudioEncoder;
  }
  
  public AssetWriterVideoEncoder getVideoEncoder()
  {
    AppMethodBeat.i(215989);
    MediaCodecAssetWriterVideoEncoder localMediaCodecAssetWriterVideoEncoder = new MediaCodecAssetWriterVideoEncoder();
    AppMethodBeat.o(215989);
    return localMediaCodecAssetWriterVideoEncoder;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tav.decoder.DefaultEncoderFactory
 * JD-Core Version:    0.7.0.1
 */