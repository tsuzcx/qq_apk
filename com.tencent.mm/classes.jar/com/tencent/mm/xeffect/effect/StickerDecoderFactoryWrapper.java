package com.tencent.mm.xeffect.effect;

import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 15}, hxE={""}, hxF={"Lcom/tencent/mm/xeffect/effect/StickerDecoderFactoryWrapper;", "Lcom/tencent/mm/xeffect/effect/IStickerDecoderFactory;", "factory", "(Lcom/tencent/mm/xeffect/effect/IStickerDecoderFactory;)V", "getFactory", "()Lcom/tencent/mm/xeffect/effect/IStickerDecoderFactory;", "getDecoder", "Lcom/tencent/mm/xeffect/effect/IStickerDecoder;", "bytes", "", "path", "", "renderlib_release"})
@Keep
public final class StickerDecoderFactoryWrapper
  implements IStickerDecoderFactory
{
  private final IStickerDecoderFactory factory;
  
  public StickerDecoderFactoryWrapper(IStickerDecoderFactory paramIStickerDecoderFactory)
  {
    AppMethodBeat.i(237106);
    this.factory = paramIStickerDecoderFactory;
    AppMethodBeat.o(237106);
  }
  
  public final IStickerDecoder getDecoder(String paramString)
  {
    AppMethodBeat.i(237104);
    p.h(paramString, "path");
    z.auD();
    paramString = (IStickerDecoder)new StickerDecoderWrapper(this.factory.getDecoder(paramString));
    AppMethodBeat.o(237104);
    return paramString;
  }
  
  public final IStickerDecoder getDecoder(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(237105);
    p.h(paramArrayOfByte, "bytes");
    z.auD();
    new StringBuilder("getDecoder from bytes: ").append(paramArrayOfByte.length);
    paramArrayOfByte = (IStickerDecoder)new StickerDecoderWrapper(this.factory.getDecoder(paramArrayOfByte));
    AppMethodBeat.o(237105);
    return paramArrayOfByte;
  }
  
  public final IStickerDecoderFactory getFactory()
  {
    return this.factory;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.xeffect.effect.StickerDecoderFactoryWrapper
 * JD-Core Version:    0.7.0.1
 */