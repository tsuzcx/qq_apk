package com.tencent.tav.codec;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class DefaultDecoderFactory
  implements IDecoderFactory
{
  public IMediaCodec createAudioDecoder(String paramString1, String paramString2)
  {
    AppMethodBeat.i(214727);
    paramString1 = MediaCodecAnalyse.createDecoderByType(paramString1, paramString2);
    AppMethodBeat.o(214727);
    return paramString1;
  }
  
  public IMediaCodec createVideoDecoder(String paramString)
  {
    AppMethodBeat.i(214737);
    paramString = MediaCodecAnalyse.createDecoderByType(paramString, "video");
    AppMethodBeat.o(214737);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tav.codec.DefaultDecoderFactory
 * JD-Core Version:    0.7.0.1
 */