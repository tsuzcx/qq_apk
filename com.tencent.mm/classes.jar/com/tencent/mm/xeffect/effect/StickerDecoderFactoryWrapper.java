package com.tencent.mm.xeffect.effect;

import androidx.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 15}, iBL={""}, iBM={"Lcom/tencent/mm/xeffect/effect/StickerDecoderFactoryWrapper;", "Lcom/tencent/mm/xeffect/effect/IStickerDecoderFactory;", "factory", "(Lcom/tencent/mm/xeffect/effect/IStickerDecoderFactory;)V", "getFactory", "()Lcom/tencent/mm/xeffect/effect/IStickerDecoderFactory;", "getDecoder", "Lcom/tencent/mm/xeffect/effect/IStickerDecoder;", "bytes", "", "path", "", "renderlib_release"})
@Keep
public final class StickerDecoderFactoryWrapper
  implements IStickerDecoderFactory
{
  private final IStickerDecoderFactory factory;
  
  public StickerDecoderFactoryWrapper(IStickerDecoderFactory paramIStickerDecoderFactory)
  {
    AppMethodBeat.i(195871);
    this.factory = paramIStickerDecoderFactory;
    AppMethodBeat.o(195871);
  }
  
  public final IStickerDecoder getDecoder(String paramString)
  {
    AppMethodBeat.i(195868);
    p.k(paramString, "path");
    ab.aBy();
    paramString = (IStickerDecoder)new StickerDecoderWrapper(this.factory.getDecoder(paramString));
    AppMethodBeat.o(195868);
    return paramString;
  }
  
  public final IStickerDecoder getDecoder(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(195869);
    p.k(paramArrayOfByte, "bytes");
    ab.aBy();
    new StringBuilder("getDecoder from bytes: ").append(paramArrayOfByte.length);
    paramArrayOfByte = (IStickerDecoder)new StickerDecoderWrapper(this.factory.getDecoder(paramArrayOfByte));
    AppMethodBeat.o(195869);
    return paramArrayOfByte;
  }
  
  public final IStickerDecoderFactory getFactory()
  {
    return this.factory;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.xeffect.effect.StickerDecoderFactoryWrapper
 * JD-Core Version:    0.7.0.1
 */