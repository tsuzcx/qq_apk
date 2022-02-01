package com.tencent.mm.xeffect.effect;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/xeffect/effect/IStickerDecoderFactory;", "", "getDecoder", "Lcom/tencent/mm/xeffect/effect/IStickerDecoder;", "bytes", "", "path", "", "renderlib_release"}, k=1, mv={1, 1, 15})
public abstract interface IStickerDecoderFactory
{
  public abstract IStickerDecoder getDecoder(String paramString);
  
  public abstract IStickerDecoder getDecoder(byte[] paramArrayOfByte);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.xeffect.effect.IStickerDecoderFactory
 * JD-Core Version:    0.7.0.1
 */