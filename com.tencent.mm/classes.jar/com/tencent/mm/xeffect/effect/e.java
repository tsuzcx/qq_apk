package com.tencent.mm.xeffect.effect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 15}, hxE={""}, hxF={"Lcom/tencent/mm/xeffect/effect/DefaultDecoderFactory;", "Lcom/tencent/mm/xeffect/effect/IStickerDecoderFactory;", "()V", "getDecoder", "Lcom/tencent/mm/xeffect/effect/IStickerDecoder;", "bytes", "", "path", "", "renderlib_release"})
public final class e
  implements IStickerDecoderFactory
{
  public final IStickerDecoder getDecoder(String paramString)
  {
    AppMethodBeat.i(237051);
    p.h(paramString, "path");
    paramString = (IStickerDecoder)new y(paramString);
    AppMethodBeat.o(237051);
    return paramString;
  }
  
  public final IStickerDecoder getDecoder(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(237052);
    p.h(paramArrayOfByte, "bytes");
    paramArrayOfByte = (IStickerDecoder)new y(paramArrayOfByte);
    AppMethodBeat.o(237052);
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.xeffect.effect.e
 * JD-Core Version:    0.7.0.1
 */