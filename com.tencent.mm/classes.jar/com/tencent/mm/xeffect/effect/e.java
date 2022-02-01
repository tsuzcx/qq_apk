package com.tencent.mm.xeffect.effect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/xeffect/effect/DefaultDecoderFactory;", "Lcom/tencent/mm/xeffect/effect/IStickerDecoderFactory;", "()V", "getDecoder", "Lcom/tencent/mm/xeffect/effect/IStickerDecoder;", "bytes", "", "path", "", "renderlib_release"}, k=1, mv={1, 1, 15})
public final class e
  implements IStickerDecoderFactory
{
  public final IStickerDecoder getDecoder(String paramString)
  {
    AppMethodBeat.i(234573);
    s.t(paramString, "path");
    paramString = (IStickerDecoder)new aa(paramString);
    AppMethodBeat.o(234573);
    return paramString;
  }
  
  public final IStickerDecoder getDecoder(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(234577);
    s.t(paramArrayOfByte, "bytes");
    paramArrayOfByte = (IStickerDecoder)new aa(paramArrayOfByte);
    AppMethodBeat.o(234577);
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.xeffect.effect.e
 * JD-Core Version:    0.7.0.1
 */