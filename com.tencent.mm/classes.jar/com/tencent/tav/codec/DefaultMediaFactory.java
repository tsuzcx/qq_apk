package com.tencent.tav.codec;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.decoder.AssetWriterAudioEncoder;
import com.tencent.tav.decoder.AssetWriterVideoEncoder;
import com.tencent.tav.decoder.DefaultEncoderFactory;
import com.tencent.tav.decoder.IEncoderFactory;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tav/codec/DefaultMediaFactory;", "Lcom/tencent/tav/codec/IMediaFactory;", "encoderFactory", "Lcom/tencent/tav/decoder/IEncoderFactory;", "decoderFactory", "Lcom/tencent/tav/codec/IDecoderFactory;", "(Lcom/tencent/tav/decoder/IEncoderFactory;Lcom/tencent/tav/codec/IDecoderFactory;)V", "getDecoderFactory", "()Lcom/tencent/tav/codec/IDecoderFactory;", "getEncoderFactory", "()Lcom/tencent/tav/decoder/IEncoderFactory;", "createAudioDecoder", "Lcom/tencent/tav/codec/IMediaCodec;", "mimeType", "", "scene", "createVideoDecoder", "getAudioEncoder", "Lcom/tencent/tav/decoder/AssetWriterAudioEncoder;", "getVideoEncoder", "Lcom/tencent/tav/decoder/AssetWriterVideoEncoder;", "avfoundation_release"}, k=1, mv={1, 1, 15})
public final class DefaultMediaFactory
  implements IMediaFactory
{
  private final IDecoderFactory decoderFactory;
  private final IEncoderFactory encoderFactory;
  
  public DefaultMediaFactory(IEncoderFactory paramIEncoderFactory, IDecoderFactory paramIDecoderFactory)
  {
    AppMethodBeat.i(214779);
    if (paramIEncoderFactory == null) {
      paramIEncoderFactory = (IEncoderFactory)new DefaultEncoderFactory();
    }
    for (;;)
    {
      this.encoderFactory = paramIEncoderFactory;
      if (paramIDecoderFactory == null) {}
      for (paramIEncoderFactory = (IDecoderFactory)new DefaultDecoderFactory();; paramIEncoderFactory = paramIDecoderFactory)
      {
        this.decoderFactory = paramIEncoderFactory;
        AppMethodBeat.o(214779);
        return;
      }
    }
  }
  
  public final IMediaCodec createAudioDecoder(String paramString1, String paramString2)
  {
    AppMethodBeat.i(214833);
    s.t(paramString1, "mimeType");
    s.t(paramString2, "scene");
    paramString1 = this.decoderFactory.createAudioDecoder(paramString1, paramString2);
    AppMethodBeat.o(214833);
    return paramString1;
  }
  
  public final IMediaCodec createVideoDecoder(String paramString)
  {
    AppMethodBeat.i(214868);
    s.t(paramString, "mimeType");
    paramString = this.decoderFactory.createVideoDecoder(paramString);
    s.r(paramString, "decoderFactory.createVideoDecoder(mimeType)");
    AppMethodBeat.o(214868);
    return paramString;
  }
  
  public final AssetWriterAudioEncoder getAudioEncoder()
  {
    AppMethodBeat.i(214848);
    AssetWriterAudioEncoder localAssetWriterAudioEncoder = this.encoderFactory.getAudioEncoder();
    s.r(localAssetWriterAudioEncoder, "encoderFactory.getAudioEncoder()");
    AppMethodBeat.o(214848);
    return localAssetWriterAudioEncoder;
  }
  
  public final IDecoderFactory getDecoderFactory()
  {
    return this.decoderFactory;
  }
  
  public final IEncoderFactory getEncoderFactory()
  {
    return this.encoderFactory;
  }
  
  public final AssetWriterVideoEncoder getVideoEncoder()
  {
    AppMethodBeat.i(214885);
    AssetWriterVideoEncoder localAssetWriterVideoEncoder = this.encoderFactory.getVideoEncoder();
    s.r(localAssetWriterVideoEncoder, "encoderFactory.getVideoEncoder()");
    AppMethodBeat.o(214885);
    return localAssetWriterVideoEncoder;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tav.codec.DefaultMediaFactory
 * JD-Core Version:    0.7.0.1
 */