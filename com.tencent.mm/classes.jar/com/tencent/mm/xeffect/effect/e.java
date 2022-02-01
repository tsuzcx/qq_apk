package com.tencent.mm.xeffect.effect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 15}, iBL={""}, iBM={"Lcom/tencent/mm/xeffect/effect/DefaultDecoderFactory;", "Lcom/tencent/mm/xeffect/effect/IStickerDecoderFactory;", "()V", "getDecoder", "Lcom/tencent/mm/xeffect/effect/IStickerDecoder;", "bytes", "", "path", "", "renderlib_release"})
public final class e
  implements IStickerDecoderFactory
{
  public final IStickerDecoder getDecoder(String paramString)
  {
    AppMethodBeat.i(195693);
    p.k(paramString, "path");
    paramString = (IStickerDecoder)new aa(paramString);
    AppMethodBeat.o(195693);
    return paramString;
  }
  
  public final IStickerDecoder getDecoder(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(195696);
    p.k(paramArrayOfByte, "bytes");
    paramArrayOfByte = (IStickerDecoder)new aa(paramArrayOfByte);
    AppMethodBeat.o(195696);
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.xeffect.effect.e
 * JD-Core Version:    0.7.0.1
 */