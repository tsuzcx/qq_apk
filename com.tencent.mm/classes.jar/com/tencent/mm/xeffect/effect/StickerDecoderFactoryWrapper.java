package com.tencent.mm.xeffect.effect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/xeffect/effect/StickerDecoderFactoryWrapper;", "Lcom/tencent/mm/xeffect/effect/IStickerDecoderFactory;", "factory", "(Lcom/tencent/mm/xeffect/effect/IStickerDecoderFactory;)V", "getFactory", "()Lcom/tencent/mm/xeffect/effect/IStickerDecoderFactory;", "getDecoder", "Lcom/tencent/mm/xeffect/effect/IStickerDecoder;", "bytes", "", "path", "", "renderlib_release"}, k=1, mv={1, 1, 15})
public final class StickerDecoderFactoryWrapper
  implements IStickerDecoderFactory
{
  private final IStickerDecoderFactory factory;
  
  public StickerDecoderFactoryWrapper(IStickerDecoderFactory paramIStickerDecoderFactory)
  {
    AppMethodBeat.i(234583);
    this.factory = paramIStickerDecoderFactory;
    AppMethodBeat.o(234583);
  }
  
  public final IStickerDecoder getDecoder(String paramString)
  {
    AppMethodBeat.i(234587);
    s.t(paramString, "path");
    ab.aUw();
    paramString = (IStickerDecoder)new StickerDecoderWrapper(this.factory.getDecoder(paramString));
    AppMethodBeat.o(234587);
    return paramString;
  }
  
  public final IStickerDecoder getDecoder(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(234591);
    s.t(paramArrayOfByte, "bytes");
    ab.aUw();
    new StringBuilder("getDecoder from bytes: ").append(paramArrayOfByte.length);
    paramArrayOfByte = (IStickerDecoder)new StickerDecoderWrapper(this.factory.getDecoder(paramArrayOfByte));
    AppMethodBeat.o(234591);
    return paramArrayOfByte;
  }
  
  public final IStickerDecoderFactory getFactory()
  {
    return this.factory;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.xeffect.effect.StickerDecoderFactoryWrapper
 * JD-Core Version:    0.7.0.1
 */